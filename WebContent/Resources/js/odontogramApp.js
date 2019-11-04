var canvas = document.getElementById("odontogram");
var lienzo = canvas.getContext("2d");
var IDPaciente = $("#idpaciente").val();

lienzo.font = "25px Helvetica";
lienzo.fillText("Der", 10, 25);
lienzo.fillText("Izq", canvas.width - 40, 25);

const cantDientes = 16;
const distEntreDientes = 52; //min 45 (OFFSET*3)
const OFFSETX = 4;
const yMaxilar = 160;
const yMandibular = 290;
/*
var test = [{id:17,left:"", up:"", right:"", bottom:"", center:"3"},
            {id:18,left:"1", up:"", right:"", bottom:"1", center:"2"}]; //DEBUG

iniciarOdontograma(test);
*/
recibirOdontogramaPaciente(IDPaciente);
