// js file for pieChart.jsp
//akshima

   
 $('#generatePie').click(function(){
        alert("generate button clicked!");
        alert($('#datasourceDropdown').val());
        alert($('#presetDropdown').val());
        datasource = $('#datasourceDropdown').val();
        preset = $('#presetDropdown').val();
        $('#datasource').attr('value',datasource);
        $('#preset').attr('value', preset);
        $('#pieChartForm').submit();
         
    }); 
