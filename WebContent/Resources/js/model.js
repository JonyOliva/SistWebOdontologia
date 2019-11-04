const Estados = [
    "images/dNormal.png",
    "0",
    "images/dCarie.png",
    "1",
    "images/dEmpaste.png",
    "2",
    "images/dAusente.png",
    "3",
    "images/dCorona.png",
    "4"
];

const D_NORMAL = 0;
const OFFSET = 15;
const ESTPARCIAL = 4;
const VACIO = "0";
var estadoAnt;
var estadoSelect = {
    tipo : 0,
    Str: VACIO,
    url: Estados[D_NORMAL]
}

class Diente{

    constructor(posX, posY, id){
        this.id = id;
        this.hasModified = false;
        this.posX = posX;
        this.posY = posY;

        this.estadoStr = new Array("0", "0", "0", "0", "0");
        this.total = null;
        this.isTotal = false;

        this.left = new Image;
        this.left.src = Estados[D_NORMAL];

        this.up = new Image;
        this.up.src = Estados[D_NORMAL];

        this.right = new Image();
        this.right.src = Estados[D_NORMAL];

        this.bottom = new Image();
        this.bottom.src = Estados[D_NORMAL];

        this.center = new Image();
        this.center.src = Estados[D_NORMAL];
    }

    draw(context){
        this.left.onload = () => {
            context.drawImage(this.left, this.posX, this.posY+OFFSET);
        }
        this.up.onload = () => {
            context.drawImage(this.up, this.posX+OFFSET, this.posY);
        }
        this.right.onload = () => {
            context.drawImage(this.right, this.posX+OFFSET*2, this.posY+OFFSET);
        }
        this.bottom.onload = () => {
            context.drawImage(this.bottom, this.posX+OFFSET, this.posY+OFFSET*2);
        }
        this.center.onload = () => {
            context.drawImage(this.center, this.posX+OFFSET, this.posY+OFFSET);
        }
    }

    reDraw(context){
        context.drawImage(this.left, this.posX, this.posY+OFFSET);
        context.drawImage(this.up, this.posX+OFFSET, this.posY);
        context.drawImage(this.right, this.posX+OFFSET*2, this.posY+OFFSET);
        context.drawImage(this.bottom, this.posX+OFFSET, this.posY+OFFSET*2);
        context.drawImage(this.center, this.posX+OFFSET, this.posY+OFFSET);
    }

    Contains(x, y){
        let width = this.posX+OFFSET*3;
        let height = this.posY+OFFSET*3;
        return x>=this.posX && x<=width && y>=this.posY && y<=height;
    }

    isNotEmpty(){
        return (this.estadoStr[0] != VACIO ||
                this.estadoStr[1] != VACIO ||
                this.estadoStr[2] != VACIO ||
                this.estadoStr[3] != VACIO ||
                this.estadoStr[4] != VACIO)
    }

    getData(){
        return{
            id: this.id,
            left: (this.isTotal) ? 0 : this.estadoStr[0],
            up: (this.isTotal) ? 0 : this.estadoStr[1],
            right: (this.isTotal) ? 0 : this.estadoStr[2],
            bottom: (this.isTotal) ? 0 : this.estadoStr[3],
            center: this.estadoStr[4]
        }
    }

    setEstado(estado) {
        this.left.src = estado;
        this.up.src = estado;
        this.right.src = estado;
        this.bottom.src = estado;
        this.center.src = estado;
    }

    inicializar(context, dLeft, dUp, dRight, dBottom, dCenter){
        if(dCenter > 2){
            this.total = new Image();
            this.total.src = Estados[dCenter*2];
            this.total.onload = () => {
                context.drawImage(this.total, this.posX, this.posY);
            }
        }else{
            if(dLeft){
                this.left.src = Estados[dLeft*2];
                this.estadoStr[0] = dLeft;
            }
            if(dUp){
                this.up.src = Estados[dUp*2];
                this.estadoStr[1] = dUp;
            }
            if(dRight){
                this.right.src = Estados[dRight*2];
                this.estadoStr[2] = dRight;
            }
            if(dBottom){
                this.bottom.src = Estados[dBottom*2];
                this.estadoStr[3] = dBottom;
            }
            if(dCenter){
                this.center.src = Estados[dCenter*2];
                this.estadoStr[4] = dCenter;
            }
        }
    }

    cambiarEstado(x, y, estado, context){
        let url = estado.url;
        if(estado.tipo){
            context.clearRect(this.posX, this.posY, (OFFSET+1)*3, (OFFSET+1)*3);
            this.setEstado(Estados[D_NORMAL]);
            this.reDraw(context);
            this.hasModified = true;
            if(!this.total){
                this.total = new Image();
                this.total.src = url;
                this.total.onload = () => {
                    context.drawImage(this.total, this.posX, this.posY);
                }
            }else{
                this.total.src = url;
                context.drawImage(this.total, this.posX, this.posY);
            }
            for (let i = 0; i < this.estadoStr.length; i++) {
                this.estadoStr[i] = estado.Str;
            }
            this.isTotal = true;
        }else{
            let isEdit = false;
            if(x>=this.posX && x<=this.posX+OFFSET && y>=this.posY+OFFSET && y<=this.posY+OFFSET*2){
                this.left.src = url;
                this.estadoStr[0] = estado.Str;
                isEdit = true;
            }else if(x>=this.posX+OFFSET && x<=this.posX+OFFSET*2 && y>=this.posY && y<=this.posY+OFFSET){
                this.up.src = url;
                this.estadoStr[1] = estado.Str;
                isEdit = true;
            }else if(x>=this.posX+OFFSET*2 && x<=this.posX+OFFSET*3 && y>=this.posY+OFFSET && y<=this.posY+OFFSET*2){
                this.right.src = url;
                this.estadoStr[2] = estado.Str;
                isEdit = true;
            }else if(x>=this.posX+OFFSET && x<=this.posX+OFFSET*2 && y>=this.posY+OFFSET*2 && y<=this.posY+OFFSET*3){
                this.bottom.src = url;
                this.estadoStr[3] = estado.Str;
                isEdit = true;
            }else if(x>=this.posX+OFFSET && x<=this.posX+OFFSET*2 && y>=this.posY+OFFSET && y<=this.posY+OFFSET*2){
                this.center.src = url;
                this.estadoStr[4] = estado.Str;
                isEdit = true;
            }
            if(isEdit){
                this.hasModified = true;
                if(this.total){
                    context.clearRect(this.posX, this.posY, (OFFSET+1)*3, (OFFSET+1)*3);
                    this.reDraw(context);
                    if(this.isTotal){
                        for (let i = 0; i < this.estadoStr.length; i++) {
                            if(this.estadoStr[i] != estado.Str)
                                this.estadoStr[i] = Estados[D_NORMAL+1];
                        }
                        this.isTotal = false;
                    }
                }
            }
        }
    }

};

function getMousePos(canvas, evt) {
    var rect = canvas.getBoundingClientRect();
    return {
        x: parseInt(evt.clientX - rect.left),
        y: parseInt(evt.clientY - rect.top)
    };
}

function obtenerDienteSeleccionado(mousePos, array){
    //console.log("Mouse: " + mousePos.x + " , " + mousePos.y);
    for (let i = 0; i < array.length; i++) {
        if(array[i].Contains(mousePos.x, mousePos.y)){
            return array[i];
        }
    }
}

function guardarOdontograma(maxilar, mandibular){
    var odontograma = new Array();
    let id = 18;
    for (let i = 0; i < maxilar.length/2; i++) {
        if(maxilar[i].hasModified){
            if(maxilar[i].isNotEmpty()){
                odontograma.push(maxilar[i].getData());
            }
        }
    }
    for (let i = maxilar.length/2; i < maxilar.length; i++) {
        if(maxilar[i].hasModified){
            if(maxilar[i].isNotEmpty()){
                odontograma.push(maxilar[i].getData());
            }
        }
    }
    for (let i = 0; i < mandibular.length/2; i++) {
        if(mandibular[i].hasModified){
            if(mandibular[i].isNotEmpty()){
                odontograma.push(mandibular[i].getData());
            }
        }
    }
    for (let i = mandibular.length/2; i < mandibular.length; i++) {
        if(mandibular[i].hasModified){
            if(mandibular[i].isNotEmpty()){
                odontograma.push(mandibular[i].getData());
            }
        }
    }
    enviarServidor(odontograma);
}

function dibujarLinea(color,xinicial,yinicial,xfinal,yfinal)
{
  lienzo.beginPath();
  lienzo.strokeStyle = color;
  lienzo.moveTo(xinicial, yinicial);
  lienzo.lineTo(xfinal, yfinal);
  lienzo.stroke();
  lienzo.closePath();
}

function cambiarEstadoSelect(input){
    if(estadoAnt)
        estadoAnt.disabled = false;
    input.disabled = true;
    estadoAnt = input;

    index = parseInt(input.id);
    estadoSelect.url = Estados[index];
    estadoSelect.Str = Estados[index+1];
    estadoSelect.tipo = (index > ESTPARCIAL) ? 1 : 0;
}

function enviarServidor(odontograma){
	$.ajax({
		type: "POST",
		url: "ServletHistoriales",
		data: { odontograma: JSON.stringify(odontograma), idpaciente: IDPaciente},
		success: (resp)=>{
			console.log("enviado OK: " + resp);
		},
		error: (resp)=>{
			console.log("enviado error: " + resp);
		}
	});
}

function recibirOdontogramaPaciente(id){
	$.ajax({
		type:"GET",
		url: "ServletHistoriales?id="+id,
		success: (resp)=>{
			console.log("recibido OK: " + resp);
			iniciarOdontograma(JSON.parse(resp));
		},
		error: (resp)=>{
			console.log("recibido error: " + resp);
		}
	});
}

function inicializarDientes(pData, vecMan, vecMax){
    for (let i = 0; i < pData.length; i++) {
        let left = (pData[i].left != "") ? pData[i].left : null;
        let up = (pData[i].up != "") ? pData[i].up : null;
        let right = (pData[i].right != "") ? pData[i].right : null;
        let bottom = (pData[i].bottom != "") ? pData[i].bottom : null;
        let center = (pData[i].center != "") ? pData[i].center : null;

        if(pData[i].id < 29){ //maxilar
            for (let d = 0; d < vecMax.length; d++) {
                if(vecMax[d].id == pData[i].id)
                    vecMax[d].inicializar(lienzo, left, up, right, bottom, center);      
            }
        }else{                //mandibular
            for (let d = 0; d < vecMan.length; d++) {
                if(vecMan[d].id == pData[i].id)
                    vecMan[d].inicializar(lienzo, left, up, right, bottom, center);
            }
        }     
    }
}

function iniciarOdontograma(pData){
	/*
	console.log("empiezo con: ");
	for(var i = 0;i<pData.length;i++){
		if(pData[i].left)
		console.log("id: "+pData[i].id+", center:"+pData[i].center+"\n");
	}*/
	var maxilarImg = new Image();
	maxilarImg.src = "images/maxilar.png";
	maxilarImg.onload = () => {
	    lienzo.drawImage(maxilarImg, 0, 40);
    }
    let id = 18;
	var dientesMaxilar = new Array();
	for (let i = 0; i < cantDientes/2; i++) {          //18 -> 11
	    dientesMaxilar.push(new Diente(distEntreDientes * i + OFFSETX, yMaxilar, id));
        dientesMaxilar[i].draw(lienzo);
        id--;
    }
    id = 21;
	for (let i = cantDientes/2; i < cantDientes; i++) {//21 -> 28
	    dientesMaxilar.push(new Diente(distEntreDientes*i + OFFSETX + distEntreDientes/2, yMaxilar, id));
        dientesMaxilar[i].draw(lienzo);
        id++;
    }
	var mandibularImg = new Image();
	mandibularImg.src = "images/mandibular.png";
	mandibularImg.onload = () => {
	    lienzo.drawImage(mandibularImg, 0, 360);
    }
    id = 48;
	var dientesMandibular = new Array();
	for (let i = 0; i < cantDientes/2; i++) {          //48 -> 41
	    dientesMandibular.push(new Diente(distEntreDientes * i + OFFSETX, yMandibular, id));
        dientesMandibular[i].draw(lienzo);
        id--;
    }
    id = 31;
	for (let i = cantDientes/2; i < cantDientes; i++) {//31 -> 38
	    dientesMandibular.push(new Diente(distEntreDientes*i + OFFSETX + distEntreDientes/2, yMandibular, id));
        dientesMandibular[i].draw(lienzo);
        id++;
	}

	document.getElementById("saveOdont").addEventListener("click", () => {
		$("#saveOdont").attr("disabled", true);
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

    if(pData.length)
        inicializarDientes(pData, dientesMandibular, dientesMaxilar);
}