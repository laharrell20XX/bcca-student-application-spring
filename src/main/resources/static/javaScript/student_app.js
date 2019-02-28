main = function () {
    var nextButton = document.getElementById("nextBtn");
    var charPart = document.getElementById("chrPage");
    var infoPart = document.getElementById("studentInfo");
    var phoneInput = infoPart.querySelector("#studentPhoneNumberInput")
    var applicationPage = document.getElementById("StudentApplication")
    var thankYouPage = document.getElementById("thankYouPage")

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
            if (isEligible()) {
                // if eligible the user can progress
                event.target.setAttribute("hidden", "")
                event.preventDefault()
                charPart.removeAttribute("hidden")
            } else {
                // if not eligible the user is the thank is shown
                showThankYou()
            }
        } else {
            // otherwise the user cannot progress
        }
    })

    function isEligible() {
        var radioYes = document.querySelector("#yesButton")
        if (radioYes.checked) {
            // if the applicant is eligible true is returned
            return true
        } else {
            return false
        }

    }

    function showThankYou() {
        // hides the application and shows the thank you
        applicationPage.setAttribute("hidden", "")
        thankYouPage.removeAttribute("hidden")

    }




}()