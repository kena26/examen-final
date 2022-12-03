

async function main () {
    const bandera = await estaLaSesionActiva();
    if(bandera) {
        const cliente = obtenerClienteSesion();
        document.getElementById('el-otro-nombre').innerText = cliente.nombre + ' ' + cliente.apellido;

        const botonCerrar = document.getElementById('boton-cerrar-sesion');
        botonCerrar.addEventListener('click', e => {
            localStorage.removeItem('cliente');
            window.location.href = 'index.html';
        }); 
        const nombre = document.getElementById("nom");
        const apellido = document.getElementById("ape");
        const direccion = document.getElementById("dir");

        nombre.value = cliente.nombre;
        apellido.value = cliente.apellido;
        direccion.value = cliente.direccion;
    } 
    else {
        // Si la sesión NO esta activa, realiza una redirección al index.html
        window.location.href = 'index.html';
    }
}
main();

