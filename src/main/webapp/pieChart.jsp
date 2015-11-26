<%-- 
    Document   : pieChart
    Created on : Nov 24, 2015, 8:44:41 PM
    Author     : Melissa, Akshima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Pie Chart</h1>

    </div>
  
</div>
 <script src="js/pieChart.js"></script>
 
<div class="row">
    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <div class="dropdown">
                
                <select style="width: 123px;" name=""  id="datasourceDropdown">
                   
                    <option value="OriginalData"><a href="#">OriginalData</a></option>
                    <option value="UploadedData"><a href="#">UploadedData</a></option>
                    <option value="MergedData"><a href="#">MergedData</a></option>
                </select>
            </div>
           
            
              
                <select style="width: 123px;" name="" value="Select2" id="presetDropdown">
                   
                    <option value="gender" ><a href="#">Gender</a></option>
                    <option value="language"><a href="#">Language</a></option>
                    <option value="course"><a href="#">Course</a></option>
                </select>
            </div>
         </div>
    </div>
</div>
 <div class="row">
     <button id="generatePie"  class="btn btn-default">Generate Pie!</button>
 </div>

<div class="row" id="actualcharts" style="display:none">

</div>

<form id="pieChartForm" action="PieChart" name="PieChart" method="POST" style="display:none;">
  <input type="hidden" name="datasource" id="datasource" />
<input type="hidden" name="preset" id="preset" />
</form>





