<%-- 
    Document   : barChart
    Created on : Nov 25, 2015, 4:27:04 AM
    Author     : madan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Bar Chart</h1>

    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group"><div class="dropdown">
                <!--<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    Choose Datasource
                    <span class="caret"></span>
                </button>-->
                <select name="category"  id="single1">
                    <option value="Original" >Original Data</option>
                    <option value="Uploaded">Uploaded Data</option>
                    <option value="Merged">Merged Data</option>
                </select>
                <!--<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li class="dropdown-header">Datasource</li>
                    <li><a href="#">Original Data</a></li>
                    <li><a href="#">Uploaded Data</a></li>
                    <li><a href="#">Merged Data</a></li>                   
                </ul>-->
            </div>
        </div><div class="btn-group">
            <div class="dropdown">
                <!--<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    Choose Y value
                    <span class="caret"></span>
                </button>-->
                <select name="category"  id="single1">
                    <option value="Age" > Age</option>
                    <option value="GPA">GPA</option>
                    <option value="Gender">Gender</option>
                </select>
                <!--<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                    <li class="dropdown-header">Parameter</li>
                    <li><a href="#">Age</a></li>
                    <li><a href="#">GPA</a></li>
                    <li><a href="#">Gender</a></li>
                </ul>-->
            </div></div>
    </div>
</div>
<div class="row">
    <img src="BarChart" width="300" height="300">
</div>
