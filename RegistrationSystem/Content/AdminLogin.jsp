<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body onload="document.f.j_username.focus();">
	<form name="f" action="j_spring_security_check" method="post">
	<div class="center">
	<table width="100%" height="100%" >
      <tr>
        <td valign="middle" align="center">
		<table>
			<tr>
				<td>帳號：</td>
				<td><input type="text" name="j_username" value=""></td>
			</tr>
			<tr><td>&nbsp;</td><td></td></tr>
			<tr>
				<td>密碼：</td>
				<td><input type="password" name="j_password" /></td>
			</tr>
			<tr><td>&nbsp;</td><td></td></tr>
			<tr>
				<td colspan="2" >
					<input type="submit" value="登入"/>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	</table>
	</div>
	</form>
</body>
</html>