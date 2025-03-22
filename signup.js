const form = document.getElementById('form');
const name_input = document.getElementById('name-input')
const gender_input = document.getElementById('gender-input')
const email_input = document.getElementById('email-input')
const phone_input = document.getElementById('phone-input')
const password_input = document.getElementById('password-input')
const repeat_password_input = document.getElementById('repeat-password-input')
const error_message = document.getElementById('error-message')

form.addEventListener('submit', (e) => {
    let errors = []

    if(name_input) {
        errors = getSignupFormErrors(name_input.value, email_input.value, phone_input.value, password_input.value, repeat_password_input.value)
    }
    else {
        errors = getLoginFormErrors(email_input.value, password_input.value)
    }

    if (errors.length > 0) {
        e.preventDefault()
        error_message.innerText = errors.join(". ")
    }
})
function getSignupFormErrors(name, email, phone, password, repeatpassword){
    let errors = []
    if(name === '' || name == null) {
        if(errors.length === 0) errors.push('Thiếu thông tin')
        name_input.parentElement.classList.add('incorrect')
    }
    if(email === '' || email == null) {
        if(errors.length === 0) errors.push('Thiếu thông tin')
        email_input.parentElement.classList.add('incorrect')
    }
    if(phone === '' || phone == null) {
        if(errors.length === 0) errors.push('Thiếu thông tin')
        phone_input.parentElement.classList.add('incorrect')
    }
    if(password === '' || password == null) {
        if(errors.length === 0) errors.push('Thiếu thông tin')
        password_input.parentElement.classList.add('incorrect')
    }

    if(password !== repeatpassword){
        errors.push('Mật khẩu không khớp')
        password_input.parentElement.classList.add('incorrect')
        repeat_password_input.parentElement.classList.add('incorrect')
    }

    return errors;
}

function getLoginFormErrors(email, password){
    let errors = []
    if(email === '' || email == null) {
        if(errors.length === 0) errors.push('Thiếu thông tin')
        email_input.parentElement.classList.add('incorrect')
    }
    if(password === '' || password == null) {
        if(errors.length === 0) errors.push('Thiếu thông tin')
        password_input.parentElement.classList.add('incorrect')
    }
    return errors;
}

const allInputs = [name_input, email_input, phone_input, password_input, repeat_password_input].filter(input => input != null)
allInputs.forEach(input => {
    input.addEventListener('input', () => {
        if (input.parentElement.classList.contains('incorrect')) {
            input.parentElement.classList.remove('incorrect')
            error_message.innerText = ''
        }
    })
})