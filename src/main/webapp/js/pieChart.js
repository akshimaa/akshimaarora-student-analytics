// js file for pieChart.jsp
//akshima

   
 $('#generatePie').click(function(){
        console.log("generate button clicked!");
        console.log($('#datasourceDropdown').val());
        console.log($('#presetDropdown').val());
        datasource = $('#datasourceDropdown').val();
        preset = $('#presetDropdown').val();
        $('#datasource').attr('value',datasource);
        $('#preset').attr('value', preset);
        $('#pieChartForm').submit();
         
    }); 
