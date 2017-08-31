<%@ page  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${basePath}/js/product/product_list.js"></script>
<script type="text/javascript" src="${basePath}/js/common/page.js"></script>
<div class="container">
	   <!-- 页面导航 -->
	   <div class="page-header">
			<div class="page-title" style="padding-bottom: 5px">
				<h3>旅游管理系统</h3>
				<ol class="breadcrumb">
				  <li>产品管理</li>
				  <li>项目管理</li>
				  <li class="active">产品信息管理</li>
				</ol>
			</div>
			<div class="page-stats"></div>
		</div>
		<form method="post" id="queryFormId">
		    <!-- 查询表单 -->
			<div class="row page-search">
			 <div class="col-md-12">
				<ul class="list-unstyled list-inline">
					<li><input type="text" id="searchNameId" class="form-control"placeholder="项目名称"></li>
					<li><select id="searchValidId" class="form-control">
							<option value="">选择状态</option>
							<option value="1">启用</option>
							<option value="0">禁用</option>
					</select></li>
					<li class='O1'><button type="button" class="btn btn-primary btn-search" >查询</button></li>
					<li class='O2'><button type="button" class="btn btn-primary btn-add">添加</button></li>
					<li class='O3'><button type="button" class="btn btn-primary btn-attachement">附件</button></li>
				</ul>
			  </div>
			</div>
			<!-- 列表显示内容 -->
			<div class="row col-md-12">
				<table class="table table-bordered">
					<thead>
						<tr>
						   <th>选择</th>
							<th>产品编码</th>
							<th>产品名称</th>
							<th>所属团</th>
							<th>所属分类</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="tbodyId">
					   <tr>
					      <td><input type="checkbox" name="selectItem" value="1"></td>
					      <td>TTCN-20170712-CHN-BJ-00101</td>
					      <td>北京马拉松3日团精品游</td>
					      <td>北京马拉松3日团</td>
					      <td>赛事</td>
					      <td>上架</td>
					      <td>修改</td>
					   </tr>
					</tbody>
				</table>
          <%@include file="../common/page.jsp" %>
			</div>
		</form>
</div> 



