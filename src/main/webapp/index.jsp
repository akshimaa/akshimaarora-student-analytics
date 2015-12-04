<%-- 
    Document   : index
    Created on : Nov 3, 2015, 5:23:33 PM
    Author     : madan, akshima
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>CMU Student Analytics</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="css/metisMenu.min.css" rel="stylesheet">

        <!-- Timeline CSS -->
        <link href="css/timeline.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/sb-admin-2.css" rel="stylesheet">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-select.css">
        <!-- Custom Fonts -->
        <link href="css/font-awesome.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>
        <script>
            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id))
                    return;
                js = d.createElement(s);
                js.id = id;
                js.src = "//connect.facebook.net/en_US/sdk.js";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));


        </script>
        <div id="userId" style="display: none;">${userID}</div>
        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0;min-height: 101px">
                <div class="navbar-header" style="max-height: 15px" >
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index"><img src="images/WebAppHeader.png"  width="30%"/></a>
                </div>
                <!-- /.navbar-header -->

                <ul class="nav navbar-top-links navbar-right">

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <span id = "profilePicture"><img src="https://graph.facebook.com/${userID}/picture?size=normal"/></span>  <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                            </li>
                            <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="login.jsp" onclick="logout();"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                            </li>
                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" style="margin-top: 101px; width: 300px" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">

                            <li class="sidebar-search">
                                <div class="input-group custom-search-form">
                                    <jsp:include page="upload.jsp"></jsp:include>
                                    </div>
                                    <!-- /input-group -->
                                </li>



                                <li>
                                    <a href="index"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>
                                    <ul class="nav nav-second-level">
                                        <li>
                                            <a href="javascript:;" onClick="bar(this);">Bar Charts</a>
                                        </li>
                                        <li>
                                            <a href="javascript:;" onClick="pie(this);">Pie Charts</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-second-level -->
                                </li>
                                <li>
                                    <a href="javascript:;" onclick="analysis(this);"><i class="fa fa-table fa-fw"></i> Analysis</a>

                                </li>



                                <li>
                                    <a href="javascript:;" onClick="generateReport(this);"><i class="fa fa-edit fa-fw"></i> Generate Report</a>

                                    <!-- /.nav-second-level -->
                                </li>
                            </ul>

                        </div>
                        <!-- /.navbar-static-side -->
                </nav>
            <c:set var="status" scope="request" value="${requestScope.status}" />     

            <div class="alert alert-danger" id="noFileSelectedError" style="display:none;margin-left: 300px">
                <button type="button" class="close">×</button>
                <strong>ERROR!</strong> No file was selected in the file upload box.
            </div>

            <div class="alert alert-success" id="successMessageBanner" style="display:none;margin-left: 300px">
                <button type="button" class="close">×</button>
                <strong>Success!</strong> Indicates a successful or positive action.
            </div>

            <div id="page-wrapper" style="margin:0 0 0 300px">

                <choose:when test="${status == null}">
                    <choose:otherwise>
                        <div> <c:out value="${status}"/>
                        </div>
                    </choose:otherwise>
                </choose:when>
                <c:set var="content" scope="request" value="${requestScope.content}" />  
                <c:choose>
                    <c:when test="${content eq 'analytics'}">
                        <jsp:include page="analysis.jsp"></jsp:include>
                    </c:when>
                    <c:when test="${content eq 'barChart'}">
                        <jsp:include page="barChart.jsp"></jsp:include>
                    </c:when>
                    <c:when test="${content eq 'pieChart'}">
                        <jsp:include page="pieChart.jsp"></jsp:include>
                    </c:when>
                    <c:otherwise>
                        <jsp:include page="overview.jsp"></jsp:include>
                    </c:otherwise>
                </c:choose>

                <!-- /#page-wrapper -->
            </div>
        </div>

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery-2.1.4.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="js/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="js/raphael-min.js"></script>

    <script src="js/bootstrap-select.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="js/sb-admin-2.js"></script>

    <script>
                                        function pie(placeholder) {
                                            $('#page-wrapper').load('pieChart.jsp');
                                        }
                                        function bar(placeholder) {
                                            $('#page-wrapper').load('barChart.jsp');
                                        }
                                        function analysis(placeholder) {
                                            $('#page-wrapper').load('analysis.jsp');
                                        }
                                        function generateReport(placeholder) {
                                            $('#page-wrapper').load('generateReport.jsp');
                                        }

                                        $('.alert .close').on('click', function (e) {
                                            $(this).parent().hide();
                                        });

                                        $(document).ready(function () {

                                            $('#uploadToS3Button').click(function () {

                                                var uploadFileName = $("#uploadToS3Input").val();

                                                console.log(uploadFileName);
                                                if (uploadFileName == "") { // returns true if the string is not empty
                                                    $('#noFileSelectedError').show();

                                                } else {

                                                    console.log($('#uploadMergeCheckbox').is(":checked"));
                                                    if ($('#uploadMergeCheckbox').is(":checked")) {
                                                        $('#hiddenMergeFlag').val("1");
                                                    } else {
                                                        $('#hiddenMergeFlag').val("0");
                                                    }
                                                    $('#uploadForm').submit();

                                                }
                                            });
                                        });

                                        function logout() {
                                            comsole.log("in logout func");
                                            FB.logout(function (response) {
                                                // user is now logged out
                                                var url = $(this).attr('href');
                                                window.location = url;



                                            });

                                        }
    </script>

</body>


</html>