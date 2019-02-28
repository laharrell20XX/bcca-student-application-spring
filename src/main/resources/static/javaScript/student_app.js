main = function () {
    var nextButton = document.getElementById("nextBtn");
    var charPart = document.getElementById("chrPage");
    var infoPart = document.getElementById("studentInfo");
    var phoneInput = infoPart.querySelector("#studentPhoneNumberInput")

    function isInfoPartValid() {
        // checks the validity of all of the inputs in the info
        // section
        let inputs = infoPart.querySelectorAll("input")
        for (let input of inputs) {
            if (!input.checkValidity()) {
                // if one of the inputs aren't valid, false is returned
                // so "form" is not valid 
                return false
            }
        }
        return true
    }

    function isValidPhoneNumber(n) {
        var phoneLayout = /^[0-9]{3}-[0-9]{3}-[0-9]{4}$/;
        // regular expression for phone number (123-456-7890)
        return phoneLayout.test(n);
    }

    phoneInput.addEventListener("input", function (event) {
        if (!isValidPhoneNumber(phoneInput.value)) {
            phoneInput.setCustomValidity("Please enter a valid phone");
        } else {
            phoneInput.setCustomValidity("");
        }
    });


    nextButton.addEventListener("click", (event) => {
        // checks the validity of the InfoPart
        if (isInfoPartValid()) {
            // if valid, the user can progress
            event.target.setAttribute("hidden", "")
            event.preventDefault()
            charPart.removeAttribute("hidden")
        } else {
            // otherwise the user cannot progress
        }
    })




}()