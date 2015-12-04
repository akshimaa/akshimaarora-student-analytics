
<%-- 
    Document   : overview
    Created on : Nov 25, 2015, 1:47:47 AM
    Author     : Madan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Dashboard</h1>
                </div>
            </div>

<div  id="chartPanel" class="row">
    <div class="col-lg-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                Bar Chart Visualization
                <div class="pull-right">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                            Actions
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu pull-right" role="menu">
                            <li id="barChoiceOne" value="basisAdmission"><a href="javascript:;" onclick = "generateOveriewBar('basisAdmission');">Basis for Admission</a></li>
                            <li id="barChoiceTwo" value="degreeLevel_gender"><a href="javascript:;" onclick = "generateOveriewBar('degreeLevel_gender');">Degree by Gender</a></li>
               
                            <li class="divider"></li>
                            <li><a href="javascript:;" onclick="addToReport();">Add to Report</a>
                            </li>

                        </ul>
                    </div>
                </div>
            </div>
            <div class="panel-body">
                <div id ="chartDiv" class="row" style="margin-left: 8%;">
                </div>
            </div>
        </div>

    </div>
</div>
<script>

    $(document).ready(function () {
        $('#chartPanel').hide();
        $('.selectpicker').selectpicker();
        console.log();
        
            $('#chartDiv').html('');
           
            preset = $('#barChoiceOne').attr('value');

            $.ajax({
                type: "POST",
                url: "/StudentAnalytics/BarChart",
                data: {datasource: 'OriginalData', preset: preset},
                cache: false,
                datatype: "application/json",
                success: function (data, textStatus, request) {
                    $('#chartPanel').fadeIn("fast", function () {
                        $(this).show();
                    });
                    $('#chartDiv').html('<img src="' + data.chart + '" height="300" width="400" />');
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    console.log(xhr.status);
                    console.log(thrownError);
                }
         
        });

    });

    function generateOveriewBar(value)
    {
        $('#chartDiv').fadeTo("fast",0.0);
        console.log(value);
                    $.ajax({
                type: "POST",
                url: "BarChart",
                data: {datasource: 'OriginalData', preset: value},
                cache: false,
                datatype: "application/json",
                success: function (data, textStatus, request) {
                    $('#chartDiv').fadeTo("slow",1.0);
                    $('#chartDiv').html('<img src="' + data.chart + '" height="95%" width="95%" />');
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    console.log(xhr.status);
                    console.log(thrownError);
                }
         
        });
    }

</script>