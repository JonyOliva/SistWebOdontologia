function validarCampoText(){
	const regex = /[^a-zA-Z ]|^\s*$/
	var elements = document.querySelectorAll('input[type="text"]');
	for(var e of elements){
		if(regex.test(e.value)){
			$("input[name='"+e.name+"']").val("");
			$("input[name='"+e.name+"']").focus();
			return false;
		}
	}
	return true;
}

function validarTecla(evt){
	if(!/[a-zA-ZÀ-ÿ\u00f1\u00d1 ]/.test(evt.key)){
		evt.preventDefault();
	}
}