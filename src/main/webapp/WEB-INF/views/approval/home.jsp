<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/layout/headCSS.jsp"></c:import>
 <link href="
https://cdn.jsdelivr.net/npm/ztree@3.5.24/css/metroStyle/metroStyle.min.css
" rel="stylesheet">
 <link rel="stylesheet" href="/css/demo.css" type="text/css">
  <link rel="stylesheet" href="/css/zTreeStyle/zTreeStyle.css" type="text/css">
  <script type="text/javascript" src="/js/ztree/jquery-1.4.4.min.js"></script>
  <script type="text/javascript" src="/js/ztree/jquery.ztree.core.js"></script>
<style type="text/css">
  #tree_list_add{
      margin-left: 20px;

  }
  #tree-table{
      border: 1px solid black;
      height: 360px;
      width: 220px;
      padding: 10px;
  }
  #tree-table-div{
      margin: 10px;
  }

</style>
</head>
<body id="page-top">
	<div id="wrapper">
		<!-- sidebar -->
		<c:import url="/WEB-INF/views/layout/sidebar.jsp"></c:import>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/layout/topbar.jsp"></c:import>

				<div class="container-fluid">
				  
				  <h1>전자 결재 홈</h1>
				  <div>
				  <button id="approval-add"> 새 결재 진행</button>
				  
				  
			
				  <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#approvalModal">
  결재선 설정
</button>




<!-- Sign -->
<div>
     <button type="button" class="btn" data-toggle="modal"  data-target="#signModal">My 도장/서명</button>
  </div> 
  
  
  </div>
  
  


<!-- Modal -->
<div class="modal fade" id="approvalModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content" style="border-bottom: white; border-radius: 0rem;">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">결재양식 선택</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
       <div>
         <input type="search">
         <input type="radio"> 이름
         <input type="radio"> 부서 
       </div>
       
  <div style="display: flex; float:left; width:40%;">
       <div style="">
       
       <ul id="tree" class="ztree"></ul>
       </div>
       
       <div style="margin-left: 20px; " id="tree_list_empty">
         <ul id="tree_list" class="ztree"></ul>
       
       </div>
       </div>
       <div style="float:right; width: 40%">
       <div style="float:left;">
           <button type="button" class="btn btn-primary" id="tree_list_add">결재  > </button>
       </div>
       
       <div style="overflow:auto; float:left;" id="tree-table-div">
          <table id="tree-table">
             <tbody id="tree-table-body">
                 <tr style="height: 10%">
                    <td>결재</td>
                    <td>이대리<br>디자인팀 이대리</td>
                 </tr>
                 
             </tbody>
          </table>
       </div>
       </div>
       
  
  
       
  </div>     
  
  
       
      </div>
      <div class="modal-footer" style="background: white;">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
        <button type="button" class="btn btn-primary">확인</button>
      </div>
    </div>
  </div>
</div>
				  

<!-- Sign-Modal -->
<div class="modal fade" id="signModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" style="border-bottom: white; border-radius: 0rem;">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">도장/서명올리기</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
      <div>1. 등록할 이미지를 선택한 후, 사용할 영역을 선택합니다.</div>
      
      
     <div style="display: flex;">
     
     <div style="border: 1px solid gray">
     <div style="border: 1px solid gray; ">
     <div style="width: 55%;">
      Before: 원본 사진
      </div>
      <input type="file" accept="image/*" id="file" name="file" style="display: none;" onchange="loadFile(this)">
      <div style="text-decoration:underline; float:left; width: 40%" onclick="document.getElementById('file').click()">이미지 선택</div>
       </div>
       </div>
         <div id="fileName"></div>
      <div id="image-show" style="width: 400px"></div>
      
      
     </div>
     
     
     
     <div style="border: 1px solid gray;">
     <div style="border: 1px solid gray;">
      After
     </div>
        <div id="small-image-show" style="align-content: center; padding: 40px;"></div>  
        </div>    
     </div>
      
      
  </div>     
  
  
      </div>
      <div class="modal-footer" style="background: white">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
        <button id="sign-image-save" type="button" class="btn btn-primary">확인</button>
      </div>
    </div>
  </div>

					
	


				</div>
</div>
			</div>

		

	
			<c:import url="/WEB-INF/views/layout/footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/layout/footjs.jsp"></c:import>
	<script src="/js/ztree/paint-tree.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/ztree@3.5.24/js/jquery.ztree.all.min.js"></script>

<script type="text/javascript">
function loadFile(input) {
    var file = input.files[0];	//선택된 파일 가져오기

    //미리 만들어 놓은 div에 text(파일 이름) 추가
    var name = document.getElementById('fileName');
    name.textContent = file.name;

  	//새로운 이미지 div 추가
    var newImage = document.createElement("img");
    newImage.setAttribute("class", 'img');
    newImage.setAttribute("id", 'file-img');
    
    //이미지 source 가져오기
    newImage.src = URL.createObjectURL(file);   

    newImage.style.width = "80%";
    newImage.style.height = "80%";
      //버튼을 누르기 전까지는 이미지를 숨긴다
    newImage.style.objectFit = "contain";

    //이미지를 image-show div에 추가
    var container = document.getElementById('image-show');
    container.appendChild(newImage);
    
    document.getElementById('fileName').textContent = null; 
    
    var fileUrl = $('#file-img').attr('src');
    console.log();
    $('#small-image-show').append('<img src='+fileUrl+' width="60px" height="40px" id="sign-image">')
    
    $('#approval-add').click(function(){
    	
    })
    
    
    
    //작은 이미지
   
    
    
    /* var submit = document.getElementById('submitButton');
    submit.onclick = showImage;     //Submit 버튼 클릭시 이미지 보여주기

    function showImage() {
        var newImage = document.getElementById('image-show').lastElementChild;
      
        //이미지는 화면에 나타나고
        newImage.style.visibility = "visible";
      

           //기존 파일 이름 지우기
    } */
};
</script>
</body>
</html>