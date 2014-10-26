

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coffee Advisor</title>
        <link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="style.css" type='text/css'>
    </head>
    <body class="main">
	    <div>
                <h1 align="center">Coffee Advisor</h1>
	    </div>	
        <ul class="coffeeList">
                <%
                List styles = (List) request.getAttribute("styles");
                Iterator it = styles.iterator();
                while(it.hasNext()) {
                        out.print("<li>" + it.next() + "</li>");
                }
                %>
        </ul>
        </body>
</html>
