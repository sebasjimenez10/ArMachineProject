/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//Fecha de caducidad de las cookies
var caduca = "31 Dec 2020 23:59:59 GMT";
//lista de elementos afectados
/*misCookies=["user","pass"];
	
window.onload =  function() {
    for (n=0;n<misCookies.length;n++) {
        leer(misCookies[n]);
        miNombre=misCookies[n];
        escribir();
    }
}
//guardar cookies	
function guardarCookie(Nombre,Valor,Fecha){
    document.cookie=Nombre+"="+Valor+";expires="+Fecha;
}

function guardarUser() {
    var tuCookie = "user";
    var tuValor = document.getElementById("user");
    alert(tuValor.value);
    guardarCookie(tuCookie,tuValor,caduca);	 
}

function guardarPass() {
    var tuCookie = "pass";
    var tuValor = document.getElementById("pass");
    alert(tuValor.value);
    guardarCookie(tuCookie,tuValor,caduca);	 
}*/

//leer cookies
function leerUser() {
    var lista = document.cookie.split(";")
    for (i in lista) {
        var busca = lista[i].search("user")
        if (busca > -1) {
            var micookie=lista[i]
        }
    }
    var igual = micookie.indexOf("=")
    var valor = micookie.substring(igual+1)
    alert("cookie.js " + valor.value);
    return valor
}

function leerUser1(){
    var cname = "user=";               
    var dc = document.cookie;             
    if (dc.length > 0) {              
        begin = dc.indexOf(cname);       
        if (begin != -1) {           
            begin += cname.length;       
            end = dc.indexOf(";", begin);
            if (end == -1) end = dc.length;
            alert("otro "+ unescape(dc.substring(begin, end)).value);
            return unescape(dc.substring(begin, end));
        } 
    }
    return null;
}

function leerCookie(){ 

    var valCookie= ""; 
    var buscar= "user="; 
    alert(buscar.value);
    if(document.cookie.length > 0) { 
        pos=document.cookie.indexOf(buscar); 
        if (pos != -1) { 
            pos += buscar.length; 
            fin= document.cookie.indexOf(";", pos); 
            if (fin == -1) 
                fin= document.cookie.length; 
            valCookie= unescape(document.cookie.substring(pos,fin)) 
            alert(valCookie.value);
        } 
    } 
    return valCookie; 
} 




/*function escribir() {			 
    switch (miNombre) {
        case "user": //cambiar color de fondo
            var valor= document.getElementById("user")
            guardarCookie("user", valor, caduca)
            break;
        case "pass": //cambiar color cabecera
            var valor1= document.getElementById("pass")
            guardarCookie("pass", valor1, caduca)
            break;
    }
}*/

function createCookie(name,value,days) {
        alert("function createCookie");
	if (days) {
		var date = new Date();
		date.setTime(date.getTime()+(days*24*60*60*1000));
		var expires = "; expires="+date.toGMTString();
	}
	else{ 
            var expires = "";
        }
	document.cookie = name+"="+value+expires+"; path=/";
        alert(document.cookie);
}

function readCookie(name) {
	var nameEQ = name + "=";
        alert(nameEQ.value);
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];
		while (c.charAt(0)==' '){ 
                    c = c.substring(1,c.length);
                }
		if (c.indexOf(nameEQ) == 0){ 
                    alert("yo soy la nueva " + c.substring(nameEQ.length,c.length).value);
                    return c.substring(nameEQ.length,c.length);
                }
                
	}
	return null;
}




