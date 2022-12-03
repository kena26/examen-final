/*
if (sesion esta activa) {
    ELIMINAR botones login/register
    NO eliminar boton perfil de usuario
} else {
    NO eliminar botones login/regiser
    ELIMINAR boton perfil de usuario
}
*/

/*
id de los botones login/register -> botones-login
id de la tarjeta de usuario -> cliente-tarjeta
*/

const obtenerClienteSesion = () => JSON.parse( localStorage.getItem('cliente') );


const estaLaSesionActiva = async () => {
    if(JSON.parse(localStorage.getItem('cliente'))?.cedula) {
        const userActive = JSON.parse(localStorage.getItem('cliente'));
        const usersCoincidences = await fetch(`http://localhost:8080/cliente/passyemail/${userActive.cedula}/${userActive.correo}`)
                                            .then(data => data.json()).then(data => data);
        return usersCoincidences.length !== 0;
    }
    return false;
}

// cambiar el nombre del user

async function main () {
    const bandera = await estaLaSesionActiva();
    if(bandera){
        const botonesLoginRegister = document.getElementById('botones-login');
        botonesLoginRegister.remove();
        const cliente = obtenerClienteSesion();
        const userH2 = document.getElementById('cliente-tarjeta-nombre');
        userH2.innerText = cliente.nombre + ' ' + cliente.apellido;
    }else {
        const botonesTarjetaUser = document.getElementById('cliente-tarjeta');
        botonesTarjetaUser.remove();
    }
    
}
main();