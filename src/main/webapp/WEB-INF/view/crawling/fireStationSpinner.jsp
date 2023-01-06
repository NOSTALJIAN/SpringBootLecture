<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Fire Station</title>
	<script>
		window.onload = function() {
			const form = document.getElementById('form');
			form.submit();
		}
	</script>
</head>
<body style="margin: 30px;">
	<h3>서울 소재 소방서 현황</h3>
	<hr>
	<img src="/img/loading.gif">
	<form style="display: none;" action="/crawling/fireStation" method="post" id="form">
		<input type="hidden" name="dummy" value="0">
	</form>
</body>
</html>