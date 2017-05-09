	function validacion(){
		var nombre=document.getElementById("nombre");
		var miformulario=document.getElementById(miformulario);
		if (nombre.value=="" || nombre== null)
			alert("Dato no valido");
		else {
			miformulario.submit();
			alert("Dato ok");
		}
	}




