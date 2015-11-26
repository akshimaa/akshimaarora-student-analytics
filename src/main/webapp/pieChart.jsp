<%-- 
    Document   : pieChart
    Created on : Nov 24, 2015, 8:44:41 PM
    Author     : Melissa, Akshima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
   

    
    </script>
    <div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Pie Chart</h1>

    </div>
    <!-- /.col-lg-12 -->
</div>
 <script src="js/pieChart.js"></script>
  <table>

      <tr>
          <td>
<div class="row">
    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group"><div class="dropdown">
                
                <select style="width: 123px;" name="" value="Select1" id="Select1">
                   
                    <option value="200"><a href="#">OriginalData</a></option>
                    <option ><a href="#">UploadedData</a></option>
                    <option><a href="#">MergedData</a></option>
                </select>
            </div>
        </td>
            </tr>
            <tr></tr>
             <tr></tr>
            <tr>
                <td>
        </div><div class="btn-group">
            <div class="dropdown">
              
                <select style="width: 123px;" name="" value="Select2" id="Select2">
                   
                    <option value="100"><a href="#">Age</a></option>
                    <option ><a href="#">GPA</a></option>
                    <option ><a href="#">Gender</a></option>
             
            </div></div>
    </div>
</div>

          </td>
      </tr>
       <tr></tr>
</table>
<table>
<input type="button" value="Generate Charts" onclick="checkOptions();">
</table>
 <tr></tr>
  <tr></tr>
   <tr></tr> <tr></tr>
   
 <table>
       <div class="input-group-btn" style="display:none" id="uploadID" >
     <form  action="upload" method="post" enctype="multipart/form-data">
   
                <input id="upload-input" class="form-control" type="file" name="file" accept=".csv" style="width: 181px"/>
                
                <button class="btn btn-default" type="submit" value="upload">
                                    <i class="fa fa-upload"></i>
                                </button>
              
                </form> 
   </div>
     </table>
<div id="data"></div>
<div class="row" id="actualcharts" style="display:none">
    <img src="PieChart" width="300" height="300">
</div>
<!-- /.row -->



