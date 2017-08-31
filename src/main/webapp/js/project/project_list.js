$(document).ready(function(){
	$("#queryFormId").on("click",".btn-search",doGetObjects);	
	$("#queryFormId").on("click",".btn-valid,.btn-invalid",doValidById);
	$("#queryFormId").on("click",".btn-add,.btn-update",showEditDialog);
	//页面加载完成执行此方法
	//1.发起ajax请求(findObjects.do)
	//2.将返回的结果填充到content位置
	doGetObjects();
});
//显示编辑模态框
function showEditDialog(){
	var url="project/editUI.do";
	var title;
	if($(this).hasClass("btn-add")){
		title="添加项目"
	}
	if($(this).hasClass("btn-update")){
		title="修改项目"
		//将要修改的记录的id值绑定到模态框上
		//目的时通过一个模块实现添加或更新操作
		$("#modal-dialog").data("id",$(this).parent().parent().data("id"));
	}
	//在模态框的.moday-body位置异步加载url
	$("#modal-dialog .modal-body").load(url,function(){//加载完成执行此
		 $(".modal-title").html(title);
		 $("#modal-dialog").modal("show");
	})	
}

//获取项目信息
function doGetObjects(){
	var url="project/findPageObjects.do";
	//获得查询参数
	var params=getQueryFormData();
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(pageCurrent){params.pageCurrent=pageCurrent};
	console.log(params.name+"/"+params.valid+"/"+pageCurrent);
	$.post(url,params,function(result){
		console.log(JSON.stringify(result.data.list));
		if(result.state==1){
			//设置表格tabody中的内容
			setTableRows(result.data.list);//map中的list(根据key取值list)
			//设置分页
			setPagination(result.data.pageObject);
		}else{
			alert(result.message);	
		}
	});
}

//获得查询表单中的数据
function getQueryFormData(){
	var params={
	"name":$("#searchNameId").val(),
	"valid":$("#searchValidId").val()
	}
	return params;
}
//将从服务端获得的列表数据填充的表格中
function setTableRows(list){
	 var tBody=$('#tbodyId');
	 tBody.empty();
	 var temp='<td><input type="checkbox" name="checkedItem" value="[id]"></td>'
	       +'<td>[code]</td>'
	       +'<td>[name]</td>'
	       +'<td>[beginDate]</td>'
	       +'<td>[endDate]</td>'
	       +'<td>[valid]</td>'
	       +'<td><input type="button"  class="btn btn-success btn-update" value="修改"></td>'
		   //追加新的数据
		 for(var i in list){//循环一次取一行数据(对应一对tr对象)
		  var tr=$('<tr></tr>');//创建一对tr对象
		  tr.data("id",list[i].id);//绑定数据,便于后续获得此数据进行修改等操作
          tr.append(temp
         .replace('[id]',list[i].id)
         .replace('[code]',list[i].code)		        
         .replace('[name]',list[i].name)
         .replace('[beginDate]',list[i].beginDate)
         .replace('[endDate]',list[i].endDate)
         .replace('[valid]',list[i].valid?'启用':'禁用')
          );
         tBody.append(tr);//将tr对象追加tbody
	}
}

/**启动/禁用*/
function doValidById(){
	//1.判定触发的是启用还是禁用按钮(根据类选择器)
	var state;//定义一个状态值,表示状态
	if($(this).hasClass("btn-valid")){
		state=1;//启用(将选中的记录的valid修改为1)
	}else{
		state=0;//禁用
	}
	//2.获得选中的checkbox对应的id值(id是记录的唯一标识)
	var checkedIds=getCheckedIds();
	if(checkedIds==''){
		alert("至少选择一个");
		return;
	}
	console.log("checkedIds="+checkedIds);
	var params={"checkedIds":checkedIds,"valid":state};
	//3.获得的数据通过ajax发送异步请求到服务器然后
	//执行更新操作
	var url="doValidById.do";
	$.post(url,params,function(result){
		if(result.state==1){//1表示成功了
			doGetObjects();//重新查询
		}else{
			alert(result.message);//显示错误信息
		}
	})
}

function getCheckedIds(){
	var checkedIds='';
	//获得tbody对象中名字为checkedItem的input对象
	$('tbody input[name="checkedItem"]').each(function(){//迭代input对象
		//判定这个input对象是否是选中的input
		if($(this).is(":checked")){//$(this).prop("checked")
			//将选中的checkbox的值拼接为字符串
			if(checkedIds==''){
				checkedIds+=$(this).val();
			}else{
				checkedIds+=","+$(this).val();
			}
		};
	})
	return checkedIds;
}









