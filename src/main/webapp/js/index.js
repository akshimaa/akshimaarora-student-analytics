// js file for index.jsp
//author: Akshima Arora

function submitCSV(){
    
    alert("The CSV file has been uploaded.");
}
 var xmlhttp = new XMLHttpRequest();
function show_more_menu(){
    alert("show_more_menu");
    
     var xmlhttp = new XMLHttpRequest();
      xmlhttp.onreadystatechange=useResponse;
        xmlhttp.open("Get", "/upload", true);
        xmlhttp.send(null);
    
}
function useResponse() {
    alert(xmlhttp.readyState);
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            
            document.getElementById("dataDiv").innerHTML=xmlhttp.responseText;
        } else {
            alert("Error in AJAX");
        }
    }