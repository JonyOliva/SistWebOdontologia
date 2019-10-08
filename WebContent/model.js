const Estados = [
    "images/dNormal.png",
    "0",
    "images/dCarie.png",
    "1",
    "images/dEmpaste.png",
    "2",
    "images/dEmpty.png",
    "-",
    "images/dAusente.png",
    "X",
    "images/dCorona.png",
    "O"
];

const D_NORMAL = 0;
const OFFSET = 15;
const ESTPARCIAL = 4;

var estadoSelect = {
    tipo : 0,
    Str: "0",
    url: Estados[D_NORMAL]
}

class Diente{

    constructor(posX, posY){
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

    getEstadoStr(){
        return {
            left: this.estadoStr[0],
            up: this.estadoStr[1],
            right: this.estadoStr[2],
            bottom: this.estadoStr[3],
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

    cambiarEstado(x, y, estado, context){
        let url = estado.url;
        
        if(estado.tipo){
            context.clearRect(this.posX, this.posY, (OFFSET+1)*3, (OFFSET+1)*3);
            this.setEstado(Estados[D_NORMAL]);
            this.reDraw(context);
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
            if(isEdit && this.total){
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

};

function getMousePos(canvas, evt) {
    var rect = canvas.getBoundingClientRect();
    return {
        x: parseInt(evt.clientX - rect.left),
        y: parseInt(evt.clientY - rect.top)
    };
}

function obtenerDienteSeleccionado(mousePos, array){
    console.log("Mouse: " + mousePos.x + " , " + mousePos.y);
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
        odontograma.push({
            id: id,
            estado: maxilar[i].getEstadoStr()
        })
        id--;
    }
    id = 21;
    for (let i = maxilar.length/2; i < maxilar.length; i++) {
        odontograma.push({
            id: id,
            estado: maxilar[i].getEstadoStr()
        })
        id++;
    }
    id = 48;
    for (let i = 0; i < mandibular.length/2; i++) {
        odontograma.push({
            id: id,
            estado: mandibular[i].getEstadoStr()
        })
        id--;
    }
    id = 31;
    for (let i = mandibular.length/2; i < mandibular.length; i++) {
        odontograma.push({
            id: id,
            estado: mandibular[i].getEstadoStr()
        })
        id++;
    }
    console.log(odontograma);
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
    index = parseInt(input.id);
    estadoSelect.url = Estados[index];
    estadoSelect.Str = Estados[index+1];
    estadoSelect.tipo = (index > ESTPARCIAL) ? 1 : 0;
}
