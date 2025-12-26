// 1. Εντοπίζεις τη φόρμα
const form = document.getElementById('myForm');

// 2. Προσθέτεις τον Listener
form.addEventListener('submit', function(event) {

    // Καλείς τη λογική ελέγχου σου
    // (Μπορείς να γράψεις τον κώδικα εδώ μέσα ή να καλέσεις άλλη συνάρτηση)

    var checkboxes = document.getElementsByName("newsletter");
    var isChecked = false;



    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            isChecked = true;
            break;
        }
    }

    if (isChecked === false) {
        alert("Παρακαλώ επιλέξτε τουλάχιστον ένα πεδίο!");

        // ΤΟ ΚΛΕΙΔΙ: Αυτή η εντολή ακυρώνει την αποστολή
        event.preventDefault();
    }

    // Αν όλα είναι καλά, δεν κάνουμε τίποτα και η φόρμα φεύγει μόνη της.
});

