let box = document.getElementById("result-box");

    let data = window.location.search;
    let search_data = new URLSearchParams(data);

    let name = search_data.get("full-name");
    let check_boxes = search_data.getAll("newsletter");
    let email = search_data.get("e-mail");

let full_name = document.getElementById("r-name");
let checks = document.getElementById("r-newsletter");
let e_mail = document.getElementById("r-email");


    full_name.innerHTML = name;
    checks.innerHTML = check_boxes;
    e_mail.innerHTML = email;
