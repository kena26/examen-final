/*
<article class="resultados">
    <div>
        <img class="img-resultado" src="./imagenes/canario.jpg" alt="">
    </div>
    <div>
        <p>Nombre: </p>
        <p>Peso: </p>
        <p>Genero: </p>
        <p>Raza: </p>
        <p>Fecha: </p>
        <p>Pertenece a: </p>
        <a href="#Pagina correspondiente">Ver mas</a>
    </div>
</article>
*/

async function main () { // click -> BIEN
    const botonEnvio = document.getElementById('boton-enviar'); //evento -> click
    const palabraBusqueda = document.getElementById('palabra-busqueda'); //value -> palabra de busqueda
    const resultadosContenedor = document.getElementById("resultados"); //almacenar -> value -> palabra de busqueda


    botonEnvio.addEventListener('click', async e => {
        const value = palabraBusqueda.value;
        const mascotas = await fetch(`http://localhost:8080/mascota/busqueda/${value}`)
                                .then(data => data.json()).then(data => data);


        resultadosContenedor.innerHTML = '';
        mascotas.forEach(mascota => {
            const resultado = document.createElement('article');
            resultado.classList.add('resultados');
            resultado.innerHTML = `
            <div>
                <img class="img-resultado" src="./imagenes/canario.jpg" alt="">
            </div>
            <div>
                <p>Nombre: ${mascota.nombre}</p>
                <p>Peso: ${mascota.peso}</p>
                <p>Genero: ${mascota.genero}</p>
                <p>Raza: ${mascota.raza}</p>
                <p>Fecha: ${mascota.fecha}</p>
                <p>Pertenece a: ${mascota.cedulacli}</p>
                <a href="resultado.html">Ver mas</a>
            </div>
            `;

            resultadosContenedor.appendChild(resultado);
        });
            
    });
}

main();