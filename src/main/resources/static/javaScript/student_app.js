main = function () {
    // wraps file in self calling function
    // prevents global usage of variables and functions
    var nextButton = document.getElementById("nextBtn");
    var charPart = document.getElementById("chrPage");
    var infoPart = document.getElementById("studentInfo");
    var phoneInput = infoPart.querySelector("#studentPhoneNumberInput")
    var schoolOptions = document.getElementById("studentHighSchoolSelector")
    var otherSpecifierBox = document.querySelector(".otherSpecifierWrapper")
    var otherSpecifier = document.getElementById("otherSpecifier")
    var schoolInput = document.getElementById("studentHighSchoolInput")
    var applicationForm = document.querySelector("#applicationForm")

    schoolInput.value = schoolOptions.value
    // sets the hidden value of the schoolInput by default
    if (schoolOptions.value === "otherOption") {
        // for when the page loads on the "Other option"
        otherSpecifierBox.removeAttribute("hidden")
    } else {
        // otherwise the specifier should be 'hidden'
        otherSpecifierBox.setAttribute("hidden", "")
    }

    function isInfoPartValid() {
        // checks the validity of all of the inputs in the info
        // section
        let inputs = infoPart.querySelectorAll("input, select")
        var isFormValid = true;
        for (let input of inputs) {
            input.value = input.value.trim()
            if (!input.checkValidity()) {
                // if one of the inputs aren't valid, false is returned
                // so "form" is not valid 
                input.classList.add("error")
                isFormValid = false
            }
        }
        return isFormValid
    }

    function isValidPhoneNumber(n) {
        var phoneLayout = /^[0-9]{3}-[0-9]{3}-[0-9]{4}$/;
        // regular expression for phone number (123-456-7890)
        return phoneLayout.test(n);
    }

    function isValidSpecifier() {
        if (otherSpecifier.value === "") {
            if (schoolOptions.value != "otherOption") {
                otherSpecifier.setCustomValidity("")
                return true
            }
            otherSpecifier.classList.add("error")
            otherSpecifier.setCustomValidity("Please enter a high school")
            return false
        }
        otherSpecifier.setCustomValidity("")
        return true
    }


    function isEligible() {
        var radioYes = document.querySelector("#yesButton")
        if (radioYes.checked) {
            // if the applicant is eligible true is returned
            return true
        } else {
            return false
        }

    }

    function fillDefaultFieldsCharPage() {
        var inputs = charPart.querySelectorAll("input")
        inputs.forEach((element, key) => {
            element.value = "Incomplete - Not Eligible"
        })
    }


    phoneInput.addEventListener("input", function (event) {
        if (!isValidPhoneNumber(phoneInput.value.trim())) {
            phoneInput.setCustomValidity("Please enter a valid phone");
        } else {
            phoneInput.setCustomValidity("");
        }
    });


    schoolOptions.addEventListener("change", (event) => {
        if (event.target.value === "otherOption") {
            otherSpecifierBox.removeAttribute("hidden")
        } else {
            schoolInput.value = event.target.value
            otherSpecifier.value = ""
            otherSpecifierBox.setAttribute("hidden", "")
        }
    })

    charPart.querySelectorAll("input").forEach(input => {
        input.addEventListener("change", event => {
            if (!input.checkValidity()) {
                input.classList.add("error")
            }
        })
    })

    otherSpecifier.addEventListener("change", event => {
        isValidSpecifier()
        schoolInput.value = event.target.value
    })

    nextButton.addEventListener("click", (event) => {
        // checks the validity of the InfoPart
        if ((isValidSpecifier() + isInfoPartValid()) == 2) {
            if (isEligible()) {
                // if eligible the user can progress
                event.target.setAttribute("hidden", "")
                event.preventDefault()
                charPart.removeAttribute("hidden")
            } else {
                // if not eligible the form is filled with def fields and submitted
                fillDefaultFieldsCharPage()
                applicationForm.submit()
            }
        } else {
            // otherwise the user cannot progress
        }
    })

    applicationForm.addEventListener("submit", (event) => {
        event.target.querySelectorAll("input").forEach((input) => input.value = input.value.trim())
        if (!event.target.checkValidity()) {
            event.preventDefault();
        }
    })

}()