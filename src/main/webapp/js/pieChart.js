// js file for pieChart.jsp
//akshima

 var xmlhttp = new XMLHttpRequest();
   
  
 function checkOptions(){
     var select2= document.getElementById("Select2");
   var selected2=select2.options[select2.selectedIndex].text;
   
   var select1= document.getElementById("Select1");
   var selected1=select1.options[select1.selectedIndex].text;
 alert("selected1==="+selected1);
 if(selected1=="Uploaded Data"){
    
   document.getElementById("uploadID").style.display="block";
     
 }  
     else{
         var selectedOptions=selected1+","+selected2;
         generatePieCharts(selectedOptions);
     }
 }
function generatePieCharts(selectedOptions){
 alert(selectedOptions);
  
        xmlhttp.onreadystatechange=useResponse;
     
    
        xmlhttp.open("POST", "/PieChart?val="+selectedOptions, true);
        xmlhttp.setRequestHeader("Content-length", selectedOptions.length);

        xmlhttp.send(selectedOptions);

}

function useResponse() {
    if (xmlhttp.readyState==4) {
            document.getElementById("data").innerHTML="<img src='Temp/pie_Chart3D.png'>";
           
        }
    }