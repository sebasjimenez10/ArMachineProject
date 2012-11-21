
function getCookie(c_name){
    var i=0,x,y;
    var ARRcookies=document.cookie.split(";");
    //while(i<ARRcookies.length){
//    for(i=0;i<ARRcookies.length;i++){
//        x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
//        alert("x "+ x);
//        y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
//        alert("y "+ x);
//        x=x.replace(/^\s+|\s+$/g,"");
//        if (x==c_name){
//            return unescape(y);
//        }else{
//            return "No encontrado";
//        }
//        i+= 1;
//}
      if(c_name== "username"){
          y=ARRcookies[0].substr(ARRcookies[0].indexOf("=")+1);
          return unescape(y);
      }else{
          if(c_name== "id"){
              y=ARRcookies[2].substr(ARRcookies[2].indexOf("=")+1);
              return unescape(y);
          }else{
              return "error";
          }
      } 
}
    

function setCookie(c_name,value,exdays){
    var exdate=new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
    document.cookie=c_name + "=" + c_value;
}

function del_cookie(name){
    document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}
