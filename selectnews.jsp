<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="graduate.TitleDAO" %>
    <%@page import="graduate.Title" %>
    <%@page import="java.util.List" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<font face="楷体" size="6" color="#000">选题界面</font>
	<form action = "#.jsp" method = "post" onsubmit = "return validate()">
  	<table   border="1" bordercolor="#A0A0A0">
  	  <tr   height="10">
		<th>课题编号</th>
		<th>课题名称</th>
		<th>作者编号</th>
		<th>课题状态</th>
		<th>课题内容</th>	
		<th>选题学生编号</th>		 
  	  </tr>
  	  <%
  	TitleDAO dao=new TitleDAO();
     List<Title> list =dao.readFirstTitle();    
      for(Title tl:list)
   {%>
  <tr>
     <td><%=tl.getTitle_id() %></td>
     <td><%=tl.getTitle_name() %></td>
          <td><%=tl.getTech_id() %> </td>
        <td><%=tl.getTitle_state() %></td>
       <td><%=tl.getTitle_show() %> </td> 
      <td><%=tl.getStu_id() %> </td>
     </tr>
     <%}
          %>
  	    <tr  height="30"><th></th><th></th><th></th><th></th><th></th><th></th></tr>
  	    <tr   height="30"><th></th><th></th><th></th><th></th><th></th><th></th></tr>
  	    <tr  height="30"><th></th><th></th><th></th><th></th><th></th><th></th></tr>
  	    <tr   height="30"><th></th><th></th><th></th><th></th><th></th><th></th></tr>
  	    <tr   height="30"><th></th><th></th><th></th><th></th><th></th><th></th></tr>
  	    <tr   height="30"><th></th><th></th><th></th><th></th><th></th><th></th></tr>
  	    <tr   height="30"><th></th><th></th><th></th><th></th><th></th><th></th></tr>
	    	    <tr   height="30"><th></th><th></th><th></th><th></th><th></th><th></th></tr>
	  
	   <tr   height="30">
 		<td colspan = "6" align = "center">
 		  <input type="submit" value="提 交">    
 		  <input type="reset" value="重  置">
 		</td>
	  </tr>
	</table>
    </form>
    </center> 

</body>
</html>