// js file for pieChart.jsp
//akshima

 var xmlhttp = new XMLHttpRequest();
function generateCharts(){
 
   var select2= document.getElementById("Select2");
   var val=select2.options[select2.selectedIndex].text;
 
        xmlhttp.onreadystatechange=useResponse;
    
        xmlhttp.open("GET", "/PieChart", true);

        xmlhttp.send(null);

}

function useResponse() {

        if (xmlhttp.readyState==4) {
            document.getElementById("data").innerHTML="<img src='Temp/pie_Chart3D.png'>";
           
        }
    }