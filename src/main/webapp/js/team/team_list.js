$(document).ready(function(){
	$("#queryFormId").on("click",".btn-search",doGetObjects);
	$("#queryFormId").on("click",".btn-add",showEditDialog);
	doGetObjects();//加载数据
});

function showEditDialog(){
	var title;
    var url="team/editUI.do"
	if($(this).hasClass("btn-add")){
		title="添加团信息"
	}
	$("#modal-dialog .modal-body").load(url,function(){
		 $(".modal-title").html(title);
		 $("#modal-dialog").modal("show");
	});
}

function doGetObjects(){
	//1.url
	var url="team/doFindPageObjects.do"
	//2.params
	var params=getQueryFormData();
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(pageCurrent){//true
		params.pageCurrent=pageCurrent;
	}else{
		params.pageCurrent=1;
	}
	console.log("pageCurrent="+pageCurrent);
	//3.ajax (post)                    
    $.post(url,params,function(result){
    	console.log(JSON.stringify(result));
    	if(result.state==1){
    	//3.1 填充表格
    	setTableRows(result.data.list)
    	//3.2 设置分页
    	setPagination(result.data.pageObject);
    	}else{
    	  alert(result.message);
    	}
    });
}

/**获得查询表单中的数据*/
function getQueryFormData(){
	var params={//对象中的名字要与controller方法中的参数名相同
		"projectName":$("#searchNameId").val(),
		"valid":$("#searchValidId").val()
	}
	return params;
}
function setTableRows(list){
	//迭代list(此集合中现在存储的是多个map)
	var tds='<td><input type="checkbox" name="checkedItem" value="[id]"></td>'
	        +"<td>[name]</td>"
	        +"<td>[projectName]</td>"
	        +"<td>[valid]</td>"
	        +"<td>修改</td>";
	var tBody=$("#tbodyId");
	tBody.empty();
	for(var i in list){
		var tr=$("<tr></tr>");
		tr.append(
			tds.replace("[id]",list[i].id)
			.replace("[name]",list[i].name)
			.replace("[projectName]",list[i].projectName)
			.replace("[valid]",list[i].valid?"启用":"禁用"));
	    tBody.append(tr);
	}
}




  











