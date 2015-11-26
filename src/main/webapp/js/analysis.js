// js file for pieChart.jsp
//akshima

var xmlhttp = new XMLHttpRequest();
function generateCharts() {

//    var select2 = document.getElementById("Select2");
//    var selected2 = select2.options[select2.selectedIndex].text;
//
//    var select1 = document.getElementById("Select2");
//    var seelcted2 = select1.options[select1.selectedIndex].text;

    
    xmlhttp.onreadystatechange = useResponse;
    
    xmlhttp.open("GET", "/histogram");

    xmlhttp.send(null);


}

function useResponse() {
    // output 

    if (xmlhttp.readyState == 4) {
        document.getElementById("histogramChart").innerHTML = "<img src='Temp/pie_Chart3D.png'>";
    }
}

                    function clickButton(){
            console.log("upload clicked!");
                    //event.preventDefault();
                    // var file = $('#histogram').attr('file');
                    alert("line 1---");
                    $.ajax({
                    type: "GET",
                           
                            url: "histogram",
                            //data: "file=" + file,
                           
                            success: function(msg) {
                            //                            console.log(file);
                            $('#histgramChart').html("<img src='Temp/grumpy_cat.jpg'>");
                                    //document.getElementById("histogramChart").innerHTML="<img src='Temp/pie_Chart3D.png'>";
                            }
                    });
            }
//
//On Thu, Nov 26, 2015 at 4:49 PM, Akshima Arora < akshima.arora@gmail.com > wrote:
//// js file for pieChart.jsp
////akshima
//
//        var xmlhttp = new XMLHttpRequest();
//
//
//function checkOptions() {
//    var select2 = document.getElementById("Select2");
//    var selected2 = select2.options[select2.selectedIndex].text;
//
//    var select1 = document.getElementById("Select1");
//    var selected1 = select1.options[select1.selectedIndex].text;
//    alert("selected1===" + selected1);
//    if (selected1 == "Uploaded Data") {
//
//        document.getElementById("uploadID").style.display = "block";
//
//    }
//    else {
//        var selectedOptions = selected1 + "," + selected2;
//        generatePieCharts(selectedOptions);
//    }
//}
//function generatePieCharts(selectedOptions) {
//    alert(selectedOptions);
//
//    xmlhttp.onreadystatechange = useResponse;
//
//
//    xmlhttp.open("GET", "/PieChart", true);
//
//    xmlhttp.send("val=" + selectedOptions);
//
//}
//
//function useResponse() {
//
//    if (xmlhttp.readyState == 4) {
//        document.getElementById("data").innerHTML = "<img src='Temp/pie_Chart3D.png'>";
//
//    }
//}