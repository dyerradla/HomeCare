<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="styles/Demo.css" type="text/css" />	
<link rel="stylesheet" href="styles/jquery-ui-1.8.18.custom.css" type="text/css">
<link href="Styles/zebra_datepicker.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<script src="Script/zebra_datepicker.js" type="text/javascript"></script>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
    <center>
        <div class="main_div" style="width:73%">
            <div class="middle_bg" align="left">
                <tiles:insertAttribute name="header" />
                <tiles:insertAttribute name="body" />
           		<tiles:insertAttribute name="footer" />
            </div>
        </div>
    </center>
</body></html>