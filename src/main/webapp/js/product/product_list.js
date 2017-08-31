$(document).ready(function(){
	$("#queryFormId")
	.on("click",".btn-attachement",loadAttachement);
});

/*加载产品附件页面*/
function loadAttachement(){
	var url="attach/uploadUI.do";
	//归属类型对象(产品附件,分销商附件)
	$("#container").data("athType",1);
	//假设归属产品1对象(是选择的checkbox的value值)
	$("#container").data("belongId",1);
	//加载附件页面
	$("#container").load(url);
}