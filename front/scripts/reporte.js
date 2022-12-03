

async function main () {
    const reportecontainer = document.getElementById('container');
    const reportes = await fetch('http://localhost:8080/reporte/all')
                    .then(data => data.json()).then(data => data);
    
    reportes.forEach(reporte => {
        const resultado = document.createElement('tr');
        resultado.classList.add('mascota');
        resultado.innerHTML = `
            <td>${reporte.servicios}</td>
            <td>${reporte.nombremascota}</td>
            <td>${reporte.nombreclie}</td>
            <td>${reporte.fecha}</td>
        `
        reportecontainer.appendChild(resultado);

    })

}

main();
