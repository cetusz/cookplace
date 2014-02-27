/**
 * 
 * options 为hash对象，基于datagrid的标准配置
 * 
 */
(function($){
	$.fn.mygrid = function(options){
		var defaultOptions = {
		        title:'',  
		        iconCls:'icon-edit',//图标  
		        width: 1000,  
		        height: '90%',  
		        nowrap: false,  
		        striped: true,  
		        border: true,  
		        collapsible:false,//是否可折叠的  
		        fit: true,//自动大小  
		        method:'get',  
		        remoteSort:false,
		        url:'#',
		        //idField:'channelId',
		        pageSize:20,
		        pageNumber:1,
		        pageList: [20,40,100],
		        singleSelect:false,//是否单选  
		        pagination:true,//分页控件  
		        rownumbers:true,//行号  
		        frozenColumns:[[  
		            {field:'ck',checkbox:true}  
		        ]] 
		};
		var options = $.extend(defaultOptions,options);
		var _self = this;
		$(_self).datagrid(options); 
		var p = $(_self).datagrid('getPager');  
	    $(p).pagination({
	        pageSize: options.pageSize,//每页显示的记录条数，默认为20  
	        pageList: options.pageList,//可以设置每页记录条数的列表  
	        beforePageText: '第',//页数文本框前显示的汉字  
	        afterPageText: '页    共 {pages} 页',  
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
	        pageNumber:1
	    });
	}
	
})(jQuery);
