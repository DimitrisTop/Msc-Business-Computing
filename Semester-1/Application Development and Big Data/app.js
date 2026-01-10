// Εισαγωγή csv
// function readFile(input) {
//
//     let reader = new FileReader(); // 1. Δημιουργούμε έναν "Αναγνώστη" (FileReader)
//     reader.readAsText(input.files[0]);  // 2. Του λέμε ποιο αρχείο να διαβάσει (αυτό που διάλεξε ο χρήστης)
//
//     reader.onload = function () { // 3. Του λέμε: "Όταν τελειώσεις το διάβασμα, κάνε τα εξής:"
//
//         let text = reader.result; // Πάρε όλο το κείμενο του αρχείου
//
//         let rows = text.split("\n"); // Σπάσε το κείμενο σε γραμμές (εκεί που αλλάζει η σειρά)
//
//         let htmlContent = ""; // Εδώ θα αποθηκεύουμε το HTML που φτιάχνουμε σιγά-σιγά
//
//         // 4. Ξεκίνα να διαβάζεις τις γραμμές μία-μία
//         for (let i = 1; i < rows.length; i++) { // Ξεκινάμε από το 1 (i=1) για να προσπεράσουμε την πρώτη γραμμή με τους τίτλους
//
//             let row = rows[i].trim(); // trim() = αφαίρεσε τυχόν κενά στην αρχή/τέλος
//
//             if (row !== "") { // Αν η γραμμή δεν είναι άδεια
//
//                 let columns = row.split(","); // Σπάσε τη γραμμή σε στήλες (εκεί που έχει κόμμα)
//
//                 htmlContent += "<tr>"; // Ξεκίνα να χτίζεις τη σειρά του πίνακα
//
//                 // Για κάθε στήλη, φτιάξε ένα κελί (td)
//                  for (let j = 0; j < columns.length; j++) {
//                     let cellData = columns[j];
//                     htmlContent += "<td>" + cellData + "</td>";
//                  }
//                 htmlContent += "</tr>";
//             }
//         }
//
//         document.getElementById("t_body").innerHTML = htmlContent; // 5. Τέλος, "πέτα" όλο το HTML που φτιάξαμε μέσα
//         // στο <tbody> της σελίδας
//     };
// }

function readFile(input) {
    let reader = new FileReader();
    reader.readAsText(input.files[0]);

    reader.onload = function () {
        let text = reader.result;
        let rows = text.split("\n");
        let htmlContent = "";

        for (let i = 1; i < rows.length; i++) {
            let row = rows[i].trim();

            if (row !== "") {
                // Properly parse CSV by handling quoted values
                let columns = parseCSVRow(row);
                //

                htmlContent += "<tr>";
                for (let j = 0; j < columns.length; j++) {
                    htmlContent += "<td>" + columns[j] + "</td>";
                }
                htmlContent += "</tr>";
            }
        }

        document.getElementById("t_body").innerHTML = htmlContent;
    };
}

// Helper function to parse CSV rows correctly
function parseCSVRow(row) {
    let columns = [];
    let current = "";
    let insideQuotes = false;

    for (let i = 0; i < row.length; i++) {
        let char = row[i];

        if (char === '"') {
            insideQuotes = !insideQuotes; // Toggle quote mode
        } else if (char === "," && !insideQuotes) {
            columns.push(current.trim()); // Save column and reset
            current = "";
        } else {
            current += char;
        }
    }

    columns.push(current.trim()); // Don't forget the last column
    return columns;
}


// Διαγραφή
let selectedRow = null;
document.getElementById('t_body').addEventListener('click', function (e) {
    let tempRow = e.target.closest('tr');

    if (tempRow) {
        if(selectedRow !== null) {
            selectedRow.style.backgroundColor = "";
        }

        selectedRow = tempRow;
        selectedRow.style.backgroundColor = 'lightBlue'

    }
});

document.getElementById('del').addEventListener('click', function () {
    if(selectedRow) {
        selectedRow.remove();
    }
});

// Επεξεργασία
document.getElementById('edit_row').addEventListener('click', function (e) {
    if(selectedRow) {
        selectedRow.contentEditable = true;
        selectedRow.focus();
    }
    selectedRow.onkeydown = function (e) {
        if (e.key === "Enter" || e.key === 'mousedown') {
            e.preventDefault(); // Εμποδίζει την αλλαγή γραμμής μέσα στο κελί
            selectedRow.contentEditable = false; // Απενεργοποιεί το edit
            selectedRow.blur(); // Χάνει το focus
        }
    };
    selectedRow.onblur = function () {
        selectedRow.contentEditable = false;
    };

});


// let getTitles = document.getElementById('column_titles').children;
// console.log(getTitles)
// let showBoxes = document.querySelector('.checkboxes')
// document.onload = function () {
//     for(i=0; i < getTitles.length; i++) {
//         let checkbox = document.createElement('input');
//         checkbox.type = 'checkbox';
//         checkbox.name = i.toString();
//         checkbox.value = i.toString();
//         checkbox.appendChild(document.createTextNode());
//     }
// }

// window.addEventListener('load', function() {
//
//     // 1. Βρίσκουμε τις κεφαλίδες του πίνακα (τα <th>)
//     let getTitles = document.getElementById('column_titles').children;
//
//     // 2. Βρίσκουμε το σημείο που θα μπουν τα checkboxes (το section στο HTML)
//     // let showBoxes = document.getElementById('small_wrapper');
//     let showBoxes = document.getElementById('checkbox_area');
//
//     // 3. Ξεκινάμε το Loop για να φτιάξουμε ένα κουτάκι για κάθε τίτλο
//     for (let i = 0; i < getTitles.length; i++) {
//
//         // --- ΒΗΜΑ Α: Δημιουργία του Checkbox ---
//         let checkbox = document.createElement('input');
//         checkbox.type = 'checkbox';
//         checkbox.checked = true; // Θέλουμε να είναι τσεκαρισμένα στην αρχή
//
//         // --- ΒΗΜΑ Β: Δημιουργία της ετικέτας (Label) για να ξέρουμε τι είναι ---
//         let label = document.createElement('label');
//         label.innerText = getTitles[i].innerText; // Παίρνουμε το κείμενο (π.χ. "Μάρκα")
//
//         // --- ΒΗΜΑ Γ: Η "Μαγεία" (Τι θα γίνει όταν το πατήσουμε) ---
//         checkbox.onchange = function() {
//             // Βρίσκουμε τον πίνακα και όλες τις σειρές του
//             let table = document.getElementById('my_table');
//             let allRows = table.rows;
//
//             // Τρέχουμε σε όλες τις σειρές (από την κορυφή μέχρι κάτω)
//             for (let n = 0; n < allRows.length; n++) {
//
//                 // Αν το κουτάκι ΔΕΝ είναι τσεκαρισμένο
//                 if (checkbox.checked === false) {
//                     // Κρύψε το κελί στη θέση (i) αυτής της σειράς
//                     allRows[n].cells[i].style.display = "none";
//                 } else {
//                     // Αλλιώς εμφάνισέ το πάλι
//                     allRows[n].cells[i].style.display = "";
//                 }
//             }
//         };
//
//         // --- ΒΗΜΑ Δ: Τοποθέτηση στη σελίδα ---
//         showBoxes.appendChild(checkbox); // Βάζουμε το κουτάκι στο section
//         showBoxes.appendChild(label);    // Βάζουμε το κείμενο δίπλα του
//
//     }
// });

// Απόκρυψη στήλης
function toggleColumn(colIndex) {

    let table = document.getElementById('my_table');
    let rows = table.rows; // Όλες οι γραμμές του πίνακα

    // Ελέγχουμε αν το κουτάκι είναι τσεκαρισμένο
    // Χρησιμοποιούμε το "event.target" για να βρούμε το checkbox που πατήθηκε μόλις
    let isChecked = event.target.checked;

    // Πάμε σε κάθε γραμμή του πίνακα μία-μία
    for (let i = 0; i < rows.length; i++) {

        // Βρες το κελί στη συγκεκριμένη στήλη (colIndex)
        let cell = rows[i].cells[colIndex];

        // Αν υπάρχει το κελί...
        if (cell) {
            if (isChecked === true) {
                cell.style.display = ""; // Εμφάνισέ το (κενό = default)
            } else {
                cell.style.display = "none"; // Κρύψ' το
            }
        }
    }
}


// CSV
function downloadCSV() {
    // Get all table rows
    let rows = document.getElementsByTagName('tr');
    let csv_data = [];

    // Loop through each row
    for (let i = 0; i < rows.length; i++) {
        let cols = rows[i].querySelectorAll('td,th');
        let csvrow = [];

        // Loop through each cell in the row
        for (let j = 0; j < cols.length; j++) {
            csvrow.push(cols[j].innerHTML);
        }

        // Join cells with comma
        csv_data.push(csvrow.join(","));
    }

    // Join all rows with new line
    let csv_content = csv_data.join('\n');

    // Create a blob (file) from the CSV data
    let blob = new Blob([csv_content], { type: 'text/csv' });

    // Create a download link
    let url = window.URL.createObjectURL(blob);
    let a = document.createElement('a');
    a.href = url;
    a.download = 'table.csv'; // File name
    document.body.appendChild(a);
    a.click(); // Click to download
    document.body.removeChild(a); // Clean up
}

// Προσθήκη Νέας Εγγραφής

