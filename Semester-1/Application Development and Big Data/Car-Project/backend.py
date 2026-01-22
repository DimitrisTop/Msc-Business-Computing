import os
import sys
from sqlite3 import converters

# from pyspark.sql.connect.functions.partitioning import years

# --- Ρυθμίσεις Υποδομής (Για Mac) ---
java_home_path = "/Library/Java/JavaVirtualMachines/amazon-corretto-17.jdk/Contents/Home"
if os.path.exists(java_home_path):
    os.environ["JAVA_HOME"] = java_home_path
    os.environ["PATH"] = f"{java_home_path}/bin:" + os.environ.get("PATH", "")

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, upper, regexp_replace, avg, count, round, min, asc

print("--- Εκκίνηση Spark ---")

# Αρχείο
current_dir = os.getcwd()
csv_path = os.path.join(current_dir, "used_cars.csv")

# Μηχανή Spark
spark = SparkSession.builder \
    .appName("CarDataAnalysis") \
    .master("local[*]") \
    .config("spark.driver.bindAddress", "127.0.0.1") \
    .getOrCreate()

spark.sparkContext.setLogLevel("ERROR")

try:
    print(f"--- Φόρτωση αρχείου: {csv_path} ---")

    # Φόρτωση CSV
    df = spark.read.csv(csv_path, header=True, inferSchema=True)
    print("✅ Το αρχείο φορτώθηκε.")

    print("===============================================================")

    # Ζητούμενο 1

    # Ερώτηση 1
    df_cleaning_model = df.withColumn('model', regexp_replace(col('model')," " , "_"))
    df_cleaned = df_cleaning_model.withColumn('engine', regexp_replace(col('engine'), " ", "_"))
    # Επαλήθευση
    # df_cleaned.select('model', 'engine').show(5, False)

    # Ερώτηση 2
    df_upper =  df_cleaned.withColumn('brand', upper(col('brand')))
    # Επαλήθευση
    # df_upper.select('brand').show(truncate=False)

    # Ερώτηση 3
    df_Audi = df_upper.filter((col('brand') == 'AUDI') & (col('model_year') >= 2016) & (col('model_year') <= 2020)).count()
    # print(df_Audi)

    # Ερώτηση 4
    # Καθαρισμός των String
    df_clean_price = df_upper.withColumn('price', regexp_replace(col('price'),"[$,]" , ""))
    df_clean_mil = df_clean_price.withColumn('milage', regexp_replace(col('milage'),"[,]| mi\\." , ""))
    df_converted = df_clean_mil
    # Μετατροπή τιμών
    df_measurables_price = df_converted.withColumn("price", round(col("price") * 0.90,0).cast("int"))
    df_measurables = df_measurables_price.withColumn("milage", round(col("milage") * 1.60,0).cast("int"))
    df_measurables.show()

    # Overwrite
    df_measurables.write.csv("Output_q4", header=True, mode="overwrite")

    # Ερώτηση 5
    df_sales_per_brand = df_measurables.groupby("brand").count()
    df_sales_per_brand.show()
    # Overwrite
    # df_sales_per_brand.write.csv("Output_q5", header=True, mode="overwrite")

    # Ζητούμενο 2
    df_measurables.printSchema()
    # Calculations
    df_minimum = df_measurables.groupby("brand","model").avg("price")
    df_counter = df_measurables.groupby("brand","model").count()
    df_index = df_measurables.withColumn("value", col("price").cast("long") * col("milage").cast("long"))
    df_best_match = df_index.groupBy("brand", "model").agg(min("value"))
    # Joins
    df_join_1 = df_minimum.join(df_counter, ["brand", "model"])
    df_teliko = df_join_1.join(df_best_match, ["brand", "model"])
    df_final = df_teliko.sort("min(value)")

    # Overwrite
    df_final.write.csv("Ζητούμενο_2", header=True, mode="overwrite")



except Exception as e:
    print("\n❌ Σφάλμα:")
    print(e)