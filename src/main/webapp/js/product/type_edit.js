var zTree;
//定义zTree树的基本配置
var setting = {
		data : {   
			simpleData : {
				enable : true,
				idKey : "id",  //节点数据中保存唯一标识的属性名称
				pIdKey : "parentId",  //节点数据中保存其父节点唯一标识的属性名称
				rootPId : null  //根节点id
		}
	}
}

$(document).ready(function(){
	$("#editTypeForm").on("click",".load-product-type",loadTypeTree);
	$("#typeLayer").on("click",".btn-cancle",hideTypeTree);
	$("#typeLayer").on("click",".btn-confirm",setSelectedTypeNode);
    $("#btn-save").click(doSaveOrUpdate);
    //首先判定当前页面中有没有id值,假如有则根据id查询产品分类,并将产品分类的信息填充到表单中
    var typeId=$("#container").data("typeId");
    console.log("edit.typeId="+typeId)
    if(typeId)doGetObjectById(typeId);
});

//根据id查找ProductType对象
function doGetObjectById(typeId){
	var url="productType/doFindObjectById.do";
	var params={"id":typeId};
	console.log("params="+JSON.stringify(params));
	$.post(url,params,function(result){
		console.log("result="+JSON.stringify(result.data));
		if(result.state==1){
		   setEditFormData(result.data)
		}else{
		   alert(result.message);
		}
	});
}

//填充表单数据
function setEditFormData(obj){
	$("#editTypeForm").data("parentId",obj.parentId);
	$("#typeNameId").val(obj.name);
	$("#parentNameId").val(obj.parentName);//显示
	$("#typeSortId").val(obj.sort);
	$("#typeNoteId").html(obj.note);
}

//执行保存或更新的动作
function doSaveOrUpdate(){
	//1.获得表单数据(注意修改时需要获得一个id值)
	var params=getEditFormData();
	//2.提交表单数据
	//2.1检测当前页面是否有绑定的typeId值
	var typeId=$("#container").data("typeId");
	//2.2有的话说明是修改,要在提交的表单中添加一个id值
	if(typeId)params.id=typeId;//修改是id应该有值
    //2.3根据typeId是否有值确定是更新还是添加操作
	var saveUrl="productType/doSaveObject.do";
	var updateUrl="productType/doUpdateObject.do";
	var url=typeId?updateUrl:saveUrl;
	//2.4提交数据到数据库
	console.log("params==="+JSON.stringify(params));
	$.post(url,params,function(result){
		if(result.state==1){
			alert("save ok");
			//清空表单数据
			doClearFormData();
			//回到列表页面
			$("#container")
			.load("productType/listUI.do?t="+Math.random(1000));
		}else{
			alert(result.message);
		}
	});
}

//清空表单数据
function doClearFormData(){
	//技巧型应用(给每天表单中需要清空数据的地方添加一个dynamicClear选择)
	$(".dynamicClear").val('');
	//移除绑定数据
	$("#container").removeData("typeId");
	$("#editTypeForm").removeData("parentId");
}

/*获得表单数据*/
function getEditFormData(){
	var params={
	   "name":$("#typeNameId").val(),
	   "parentId":$("#editTypeForm").data("parentId"),
	   "sort":$("#typeSortId").val(),
	   "note":$("#typeNoteId").val()
	};
	return params;
}

//隐藏typetree
function hideTypeTree(){
	$("#typeLayer").css("display","none");
}

//设置选中的type节点
function setSelectedTypeNode(){
	//获得zTree中选中的节点(jquery.ztree.all.min.js)
	var nodes=zTree.getSelectedNodes();
	//获得选中的第一个节点
	var node=nodes[0];
	//给parentNameId的赋值
	$("#parentNameId").val(node.name);//显示的是名字
	//将id的值绑定到editTypeForm对象上
	$("#editTypeForm").data("parentId",node.id)//保存到数据库的应该是parentId值
	//隐藏zTree树对象
	$("#typeLayer").css("display","none");
}

//加载产品分类信息,然后以zTree形式显示
function loadTypeTree(){	
	//显示zTree树
	$("#typeLayer").css("display","block");//none
	//初始化zTree的
	var url="productType/doFindTreeNodes.do";//??? (dao-->mappper)-->service-->controller
	$.getJSON(url,function(result){
		console.log(JSON.stringify(result.data))
		if(result.state==1){
			//初始化zTree;
			  zTree=$.fn.zTree.init(
			  $("#typeTree"),//显示树的位置
			  setting,//树的基本配置
			  result.data);//树上要显示的数据
		}else{
			alert(result.message);
		}
	});
}