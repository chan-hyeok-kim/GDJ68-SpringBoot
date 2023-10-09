  var zTreeObj;
   // zTree configuration information, refer to API documentation (setting details)
   var setting = {
    check: {
      autoCheckTrigger:false,
      chkStyle: "checkbox",
      enable:true,
      chkboxType:{"Y":"ps","N":"ps"},
      nocheckInherit:false,
      chkDisabledInherit:false,
      radioType:"level"
    },
   callback: {
	   onClick: myOnClick
   }
	
   };
   var resultArr=new Array();
   function myOnClick(event,tree_6,treeNode) {
      $('#tree_6').click(function(){
         console.log('영업부 클릭됨')
          console.log(treeNode.name)
          if(treeNode.name=="영업팀"){
			  deptCode='1'
		  }
          $.ajax({
			  url:"/approval/getSalesTeamList?deptCode="+deptCode,
			  type:"GET"
			  ,success:function(result){
              console.log(result);
              
             for(r of result){
				console.log(r);
				resultArr.push(r);
               $('#tree-list').append('<div>영업팀 '+r.employeeName+'</div>');
            } 
        }
        })
       })
   
};

   // zTree data attributes, refer to the API documentation (treeNode data details)
   var zNodes = [
   {name:"페인트 오피스", open:true, children:[
      {name:"인사팀"}, {name:"재무회계팀"},
      {name:"개발팀"}, {name:"생산팀"},{name:"영업팀"}]},
   {name:"test", open:true, children:[
      {name:"test_1"}, {name:"test_2"}]}
   ];
   $(document).ready(function(){
      zTreeObj = $.fn.zTree.init($("#tree"), setting, zNodes);
   });
   
   
   
   
   
   
   var settingList = {
    check: {
      autoCheckTrigger:false,
      chkStyle: "checkbox",
      enable:true,
      chkboxType:{"Y":"ps","N":"ps"},
      nocheckInherit:false,
      chkDisabledInherit:false,
      radioType:"level"
    }};
    var zNodesList = resultArr;
   $(document).ready(function(){
      zTreeObj = $.fn.zTree.init($("#tree-list"), settingList, zNodesList);
   });
  