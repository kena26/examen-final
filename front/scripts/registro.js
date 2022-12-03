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


async function main () {
    const campoReg = [
        document.getElementById('cedula'),// 0
        document.getElementById('correo'),// 1
        document.getElementById('nombre'),// 2
        document.getElementById('apellido'),// 3 
        document.getElementById('contra'),// 4
        document.getElementById('direccion')// 5
    ]
    const submit = document.getElementById('submit');
    const form = document.getElementById('formulario');

    validarCamposFormularios(campoReg, submit);
    
    form.addEventListener('submit', async e => {
        e.preventDefault();

        // Cliente a registrar
        const cliente = {
            nombre: campoReg[2].value,
            apellido: campoReg[3].value,
            cedula:  campoReg[0].value,
            correo: campoReg[1].value,
            contra: campoReg[4].value,
            direccion: campoReg[5].value
        }

        const {cedula, correo} = cliente;

        // Arreglo de clientes que coincidan
        const clientes = await fetch(`http://localhost:8080/clientes/cedulaoemail/${cedula}/${correo}`)
                                .then(data => data.json()).then(data => data);

        console.log(clientes);        

        
        if(clientes.length === 0) {

            await fetch(`http://localhost:8080/cliente/registro`, {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: 'post',
                body: JSON.stringify(cliente)
            }).then(data => data.text()).then(data => {
                console.log(data);
                window.location.href = 'index.html';
            });

        }else {
            addTemporalError(form, 'No se puede registrar ese cliente');
        }
    });
}
main();

// API URL PARA REGISTRAR  -->  http://localhost:8080/cliente/registro
// API URL PARA RETORNAR LISTA DE CLIENTES --> http://localhost:8080/clientes/cedulaoemail/${cedula}/${correo}