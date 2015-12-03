<%-- 
    Document   : analysis
    Created on : Nov 25, 2015, 5:24:25 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<script src="js/jquery-2.1.4.js" type="text/js"></script>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Predictive Analysis</h1>
        <p>This is the predictive analytics tool to predict prospective student GPA values.
        <p>Please select a .csv file and a type of predictive algorithm then press the submit button to continue.</p>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="input-group custom-search-form">
    <form id="analysisInput" action="Histogram" method="post" enctype="multipart/form-data">
    <input id="upload-input" class="form-control" value="file" type="file" name="file" accept=".csv" style="width: 250px"/>
    <input type="hidden" name="classifier" id="classifier" />
    <select style="width: 180px;" name=""  value="1" id="dropmenu">
        <option value="1"><a href="#">MultilayerPerceptron</a></option>
        <option value="2"><a href="#">LinearRegression</a></option>
    </select>
    <span class="input-group-btn">
        <button class="btn btn-default" id="buttonPress" value="upload">
            <i class="fa fa-upload"></i>
        </button>
    </span>
</form>
</div>

<!--<div class="dropdown">
    <select style="width: 180px;" name=""  id="">
        <option value="1"><a href="#">MultilayerPerceptron</a></option>
        <option value="2"><a href="#">LinearRegression</a></option>
    </select>
</div>-->

<p></p>

<div class="row">
    <c:set var="chart" scope="request" value="${requestScope.chart}" /> 
    <c:set var="contextPath" scope="request" value="${requestScope.contextPath}"/>
    <c:choose>
        <c:when test="${chart != null}">
            <img src="${contextPath}/images/${chart}">
        </c:when>
    </c:choose>
</div>



<script>
    $('#buttonPress').click(function () {
        alert("BUTTON PRESSED");
        $('#classifier').attr('value', $('#dropmenu').val());
        $('#analysisInput').submit();
//        var myForm = document.querySelector('analysisInput');
//        var formData = new FormData(myForm);
//          var formData = new FormData();
//          formData.append('file', 'test');
//          formData.append('classifier', '2');
////      var formData = $('#analysisInput');
//
//        $.ajax({
//            url: 'http://localhost:8080/StudentAnalytics/Histogram',
//            type: 'POST',
//            data: {"classifier":"2"},
//            async: false,
//            cache: false,
//            contentType: 'multipart/form-data',
//            processData: false,
//            error: function () {
//                alert("error");
//                return true;
//            },
//            success: function (msg) {
//                alert("success");
//            }
//
//        });
    });

//    function () {
////    
////        $('#classifier').attr('value', $('#dropmenu').val());
//////        $('#upload-input').attr('value', $('#upload-input').val());
//////    console.log($('#analysisInput').attr('file'));
////        console.log("It works! WOOT!");
////        console.log($('#dropmenu').val());
////        console.log($('#upload-input').val());
////        alert($('#dropmenu').val());
//        $('#analysisInput').submit();
//        
//
//    });
</script>
<!--<SCRIPT LANGUAGE="JavaScript">
function getParm(string,parm) {
    // returns value of parm from string
    var startPos = string.indexOf(parm + "=");
    if (startPos > -1) {
        startPos = startPos + parm.length + 1;
        var endPos = string.indexOf("&",startPos);
        if (endPos == -1)
            endPos = string.length;
        return unescape(string.substring(startPos,endPos));
    }
    return '';
}

var passed = location.search.substring(1);

document.analysisInput.file.value = getParm(passed,'file');
document.analysisInput.classifier.value = getParm(passed,'classifier');
//</SCRIPT>-->
