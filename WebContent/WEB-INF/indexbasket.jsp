<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<!-- 下面的ajax包，是通过邮编获取得知的ajax库 -->
<script src="https://ajaxzip3.github.io/ajaxzip3.js"></script>
<script type="text/javascript">
	function addCheckForm() {
		var form = document.getElementById('addForm');

		var input_teachername = document.getElementById('addteachername').value;
		var input_course = document.getElementById('addcourse').value;

		if (input_teachername == "" || input_teachername == null) {
			alert("请输入先生姓名！！！");
			return false;
		}

		if (input_course == "" || input_course == null) {
			alert("请输入先生科目！！！");
			return false;
		}

		form.submit();
		return true;
	}

	function delCheckForm() {
		var form = document.getElementById('delForm');
		var flag = 0;
		var input_id = document.getElementById("delid").value;
		if (input_id == "" || input_id == null) {
			alert("请输入削除先生id！！！");
			return false;
		}

		if (input_id.match(/[^0-9]+/)) {
			flag = 1;
		}

		if (flag) {
			window.alert('数字以外が入力できません');
			return false; // 送信を中止
		}

		form.submit();
		return true;
	}

	function editCheckForm() {
		var form = document.getElementById('editForm');

		var input_id = document.getElementById('editid');
		var input_teachername = document.getElementById('editteachername');
		var input_score = document.getElementById('editscore');

		if (input_id == "" || input_id == null) {
			alert("请输入先生id！！！");
			return false;
		}

		if (input_teachername == "" || input_teachername == null) {
			alert("请输入先生姓名！！！");
			return false;
		}

		form.submit();
		return true;
	}
	$(document).ready(function() {
		$("#idquerysumit").click(function() {
			var input_Id = $("#queryid").val();
			if (input_Id == "" || input_Id == null) {
				alert("輸入要查詢的id！！！");
				return false;
			} else {
				var username = /^[0-9]+$/;
				console.log("IDForm Function!");
				console.log($("#queryid").val())
				if (!username.test($("#queryid").val())) {
					alert("ID只能輸入數字");
					return false;
				} else {

					$("#IDForm").submit();
					alert("ok！");

				}
			}
		});
	});

	$(document)
			.ready(
					function() {
						$("#namequerysumit")
								.click(
										function() {
											var input_name = $("#queryname")
													.val();
											if (input_name == ""
													|| input_name == null) {
												alert("輸入要查詢的老师姓名！！！");
												return false;
											} else {
												var usernameone = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
												console
														.log("nameForm Function!");
												console.log($("#queryname")
														.val())
												if (!usernameone.test($(
														"#queryname").val())) {
													alert("老师姓名只能輸入英文和日文");
													return false;
												} else {

													$("#nameForm").submit();
													alert("ok！");

												}
											}
										});
					});

	$(function() {
		$("#Address").click(function() {

			$("#addAddress").submit();
		})

	})
</script>

</head>
<body>
	<img src="./images/header.jpg" />
	<h1 align="center">球員信息管理</h1>
	<table id="table_id" border="8" align="center">
		<tr>
			<td>id</td>
			<td>name</td>
			<td>birthday</td>
			<td>age</td>
			<td>money</td>
			<td>address</td>

		</tr>

		<c:forEach items="${baskets}" var="basket">
			<tr>
				<td id="${basket.id}">${basket.id}</td>
				<td id="${basket.id}">${basket.name}</td>
				<td id="${basket.id}">${basket.birthday}</td>
				<td id="${basket.id}">${basket.age}</td>
				<td id="${basket.id}">${basket.money}</td>
				<td id="${basket.id}">${basket.address}</td>
			</tr>
		</c:forEach>
	</table>

	<div id="edit_comm" class="all" align="center">
		<h2 id="edit_title">球員編集</h2>
		<form id="editForm" action="update" method="post">
			<input id="editid" type="text" placeholder="要修改的id" id="edit_id"
				name="id" /><br> <input id="editname" type="text"
				placeholder="氏名" name="name" /> <input id="editbirthday"
				type="text" placeholder="生年月日" name="birthday" /> <input
				id="editage" type="text" placeholder="年齢" name="age" /> <input
				id="editscore" type="text" placeholder="工資" name="money" /> <input
				type="submit" value="修正の確認" />
		</form>
	</div>

	<div id="edit_comm" class="all" align="center">
		<h2>刪除球員</h2>
		<form id="delForm" action="deleteById" method="post">
			<input id="delid" type="text" placeholder="刪除球員的id" name="id" /> <input
				type="submit" value="刪除球員" onclick="delCheckForm()" />
		</form>
	</div>

	<div id="add_comm" class="all" align="center">
		<h2 id="edit_title">球員追加</h2>
		<form id="addForm" action="add" method="post" class="checkform">
			<input id="addname" type="text" placeholder="氏名" name="name" /> <input
				id="addbirthday" type="text" placeholder="生年月日" name="birthday" />
			<input id="addage" type="text" placeholder="年齢" name="age"
				class="number" /> <span class="alertarea"></span> <input
				id="addscore" type="text" placeholder="工資" name="money" /> <input
				type="submit" value="添加" />
		</form>
	</div>


	<div id="edit_comm" class="all" align="center">
		<h2>球員Id查詢</h2>
		<form id="IDForm" action="queryById" method="post">
			<input id="queryid" type="text" placeholder="要查詢的id" name="id" />
			<button id="idquerysumit" type="button">
				<p>查詢</p>
			</button>
		</form>
	</div>

	<div id="edit_comm" class="contro" align="center">
		<h2 id="edit_title">郵便と住所</h2>
		<form id="addAddress" action="address" method="post">
			<label>郵便番号(ハイフンもOK)</label>
			<br>
			<input type="text" name="zip11" size="10" maxlength="8" onKeyUp="AjaxZip3.zip2addr(this,'','addr11','addr11');">
			<br>
			 <label>都道府県と以降の住所</label>
			 <br>
			<input type="text" name="addr11" size="60">
			<br>
			<label>学生の番号</label>
			<br>
			<input id="d" type="text" name="id" placeholder="学生のID"> <br>
			<button id="Address" type="button">確認</button>
			<p>確認追加</p>
		</form>
	</div>



	<div id="edit_comm" class="all" align="center">
		<h2>球員name查詢</h2>
		<form id="nameForm" action="queryByName" method="post">
			<input id="queryname" type="text" placeholder="要查詢的name" name="name" />
			<button id="namequerysumit" type="button">
				<p>查詢</p>
			</button>
		</form>
	</div>


</body>
</html>