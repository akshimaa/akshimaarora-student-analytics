// js file for index.jsp
//author: Akshima Arora

function submitCSV(){
    
    console.log("The CSV file has been uploaded.");
}
 var xmlhttp = new XMLHttpRequest();
function show_more_menu(){
    console.log("show_more_menu");
    
     var xmlhttp = new XMLHttpRequest();
      xmlhttp.onreadystatechange=useResponse;
        xmlhttp.open("Get", "/upload", true);
        xmlhttp.send(null);
    
}
function useResponse() {
    console.log(xmlhttp.readyState);
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            
            document.getElementById("dataDiv").innerHTML=xmlhttp.responseText;
        } else {
            console.log("Error in AJAX");
        }
    }
    
