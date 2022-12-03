const validarCamposFormularios = (campos, submit) => {
    submit.disabled = true;
    campos.forEach(campo => {
        campo.addEventListener('input', e => {
            if(campos.every(campo => campo.value !== '')) {
                submit.disabled = false;
                submit.classList.remove('disabled');
                return;
            } 
            submit.disabled = true;
            submit.classList.add('disabled');
        });
    })
}

const addTemporalError = (element, text) => {
    const error = document.createElement('div');
    error.classList.add('error')
    error.textContent = text;
    element.appendChild(error);
    setTimeout(()=>{
        error.remove();
    }, 2000)
}

const addTemporalSucces = (element, text) => {
    const succes = document.createElement('div');
    succes.classList.add('succes')
    succes.textContent = text;
    element.appendChild(succes);
    setTimeout(()=>{
        succes.remove();
    }, 2000)
}


/*
* seleccionar el submit y el formulario a través de su id 
  si no tienen id, agreguelo :D
* Una vez seleccionado el submit y el formulario, deben validar los campos
    envien el arreglo de campos y el submit a la función validarCamposFormulario
* deben prevenir el comportamiento por defecto del formulario    
*/

async function main () {
    const campos = [
        document.getElementById('correo'),
        document.getElementById('contra')
    ];
    const form = document.getElementById('formulario');
    const submit = document.getElementById('submit');

    validarCamposFormularios(campos, submit);
    
    form.addEventListener('submit', async e => {
        e.preventDefault();
        
        const valueCorreo = campos[0].value;
        const valueContra = campos[1].value;

        const clienteLogin = await fetch(`http://localhost:8080/cliente/passyemail/${valueContra}/${valueCorreo}`).
                                then(data => data.json()).then(data => data);
        
        if(clienteLogin.cedula) { 
            localStorage.setItem('cliente', JSON.stringify(clienteLogin));
            window.location.href = 'index.html';
        } else {
            addTemporalError(form, 'Credenciales incorrectas');
        }
    })
}
main();

/*http://localhost:8080/cliente/passyemail/contra/email */