
async function main () {
    const nosotros = await fetch("http://localhost:8080/nosotros/all")
                            .then(data => data.json()).then(data => data);
    const imag = document.getElementById("contenido-imagen");
    const par = document.getElementById("contenido-parrafo");
 
    imag.innerHTML = `<img src="${nosotros[0].foto}">`;
    par.innerText = nosotros[0].descrip;

}
main();