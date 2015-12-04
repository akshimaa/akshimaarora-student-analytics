// js file for pieChart.jsp
//akshima

   
 $('#generatePie').click(function(){
        
        datasource = $('#datasourceDropdown').val();
        preset = $('#presetDropdown').val();
        $('#datasource').attr('value',datasource);
        $('#preset').attr('value', preset);
        $('#pieChartForm').submit();
         
    }); 
