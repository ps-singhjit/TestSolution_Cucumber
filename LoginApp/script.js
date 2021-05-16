const uname = document.getElementById("name")
const password = document.getElementById("password")
const form = document.getElementById("form")
const errorEle = document.getElementById("error")
const loginBtn = document.getElementById("login")

form.addEventListener('submit', (e) => {
    let messages = []
    
    if(uname.value === "user123" && password.value === "happycoder123" ){        
        password.nextElementSibling.textContent = 'Login Successfull'        
        messages.push('Nice try !!! but credentials are wrong')
    }else{

        if(uname.value == ''|| uname.value == null){
            uname.nextElementSibling.textContent = 'Name cannot be blank'
            messages.push('Name cannot be blank')       
        }  
        if(password.value == ''|| password.value == null){
            password.nextElementSibling.textContent = 'Password cannot be blank'
            messages.push('Password cannot be blank')
        }      
        if(password.value.length <= 7 && password.value != ''){            
            password.nextElementSibling.textContent = 'Password must be longer than 8 characters'
            messages.push('Password must be longer than 8 characters')
        }
        if(password.value.length >= 14){
            password.nextElementSibling.textContent = 'Password must be shorter than 15 characters'
            messages.push('Password must be shorter than 20 characters')
        }
        if(password.value === 'password'){
            password.nextElementSibling.textContent = 'Password cannot be - password'
            messages.push('Password cannot be - password')
        }
        if(password.value.length > 7 && password.value.length < 20){            
            password.nextElementSibling.textContent = 'Nice try !!! but credentials are wrong'
            messages.push('Nice try !!! but credentials are wrong')
        }

    }

    if(messages.length > 0){
        e.preventDefault()
        // errorEle.innerText = messages.join(', ')
    }


})