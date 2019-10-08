var canvas = document.getElementById("odontogram");
var lienzo = canvas.getContext("2d");

lienzo.font = "25px Helvetica";
lienzo.fillText("Der", 10, 25);
lienzo.fillText("Izq", canvas.width - 40, 25);

const cantDientes = 16;
const distEntreDientes = 52; //min 45 (OFFSET*3)

var maxilarImg = new Image();
maxilarImg.src = "images/maxilar.png";
maxilarImg.onload = () => {
    lienzo.drawImage(maxilarImg, 150, 25);
}
const OFFSETX = 4;
const yMaxilar = 150;
var dientesMaxilar = new Array();
for (let i = 0; i < cantDientes/2; i++) {
    dientesMaxilar.push(new Diente(distEntreDientes * i + OFFSETX, yMaxilar));
    dientesMaxilar[i].draw(lienzo);
}
for (let i = cantDientes/2; i < cantDientes; i++) {
    dientesMaxilar.push(new Diente(distEntreDientes*i + OFFSETX + distEntreDientes/2, yMaxilar));
    dientesMaxilar[i].draw(lienzo);
}
var mandibularImg = new Image();
mandibularImg.src = "images/mandibular.png";
mandibularImg.onload = () => {
    lienzo.drawImage(mandibularImg, 150, 360);
}
const yMandibular = 285;
var dientesMandibular = new Array();
for (let i = 0; i < cantDientes/2; i++) {
    dientesMandibular.push(new Diente(distEntreDientes * i + OFFSETX, yMandibular));
    dientesMandibular[i].draw(lienzo);
}
for (let i = cantDientes/2; i < cantDientes; i++) {
    dientesMandibular.push(new Diente(distEntreDientes*i + OFFSETX + distEntreDientes/2, yMandibular));
    dientesMandibular[i].draw(lienzo);
}

document.getElementById("save").addEventListener("click", () => {
    guardarOdontograma(dientesMaxilar, dientesMandibular);
})

canvas.addEventListener("mouseup", (e) => {
    let mousePos = getMousePos(canvas, e);
    var filaDientes = (mousePos.y > canvas.height/2) ? dientesMandibular : dientesMaxilar;
    var dienteSelec = obtenerDienteSeleccionado(mousePos, filaDientes);
    if(dienteSelec){
        dienteSelec.cambiarEstado(mousePos.x, mousePos.y, estadoSelect, lienzo);
    }
});
