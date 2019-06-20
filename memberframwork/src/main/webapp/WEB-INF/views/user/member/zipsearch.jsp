<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">

$(function() {
	$("#searchBtn").click(function(){
		$.ajax({
			type : "GET",
			url : "${root}/user/zipsearch.kitri",
			dataType : "json",
			data : {"doro" : $("#doro").val()},	// checkid를 찾아서 알아서 들어간다 (String checkid)그렇지만 명시해주자!(MemberController)
			success : function(data){
				//아까 service에서 배열 만든거 넣을거야..?
				var list = data.ziplist;	// json의 배열을 얻어올거야
				var len = list.length;
				var view = "";
				for (var i = 0; i < len; i++) {
					var address = list[i].sido + " " + list[i].gugun  + " " + list[i].upmyon + " " + 
					list[i].doro + " " + list[i].buildingNumber + " " + list[i].sigugunBuildingName;
					
					view += "<tr>\n";
					view += "	<td>"+ list[i].zipcode +"</td>\n";
					view += "	<td align = 'left'>";
					view += '<a href="javascript:selectZip(\'' + list[i].zipcode + '\', \''+address+'\');">';
					view += address;
					view += '</a>';
					view += "</td>\n";
					view += "</tr>";
				}
				$("#zip_codeList").empty().append(view);
			}
		});
		
	});
});

function selectZip(z, a){
//	document.getElementById("zipcode").value = z;
//	document.getElementById("address").value = a;
	$("#zipcode").val(z);
	$("#address").val(a);
	
	$("#zipModal").modal("hide");
	$("#doro").val('');
	$("#zip_codeList").empty();
}

/* var ziplistView;

function zipSearch(){
	ziplistView = document.getElementById("zip_codeList");
	var doro = document.getElementById("doro").value;
	if(doro.length == 0){
		alert("검색할 도로명을 입력!!");
		return;
	}else{
		var params = "act=zipsearch&doro=" + doro;
		sendRequest("${root}/user",params, zipsearchResult, "GET");
	}
}


function zipsearchResult(){
	if(httpRequest.readyState == 4){	// 모든 데이터가 정상적으로 넘어왔다!   httpRequest이걸 가지고 모든 것을 처리한다!
		if(httpRequest.status == 200){	// 정상적인 데이터가 넘어왔다
			var view = "";
			var result = httpRequest.responseXML;
			var ziplist = result.getElementsByTagName("zip");
			var len = ziplist.length;
			for(var i = 0; i < len; i++){
				var zipcode = ziplist[i].getElementsByTagName("zipcode")[0].firstChild.data;
				var address = ziplist[i].getElementsByTagName("address")[0].firstChild.data;
				view += "<tr>\n";
				view += "	<td>"+ zipcode +"</td>\n";
				view += "	<td align = 'left'>";
				view += '<a href="javascript:selectZip(\'' + zipcode + '\', \''+address+'\');">';
				view += address;
				view += '</a>';
				view += "</td>\n";
				view += "</tr>";
			}
			ziplistView.innerHTML = view;
		}
	} else{
		ziplistView.innerHTML = '<img src="${root}/img/loading.gif" width="80">';
	}
}

function selectZip(z, a){
	document.getElementById("zipcode").value = z;
	document.getElementById("address").value = a;
	
	$("#zipModal").modal("hide");
	$("#doro").val('');
	$("#zip_codeList").empty();
} */
</script>

<!-- 단독으로 시작할 필요 없다! -->
<div id="zipModal" class="modal fade" role="dialog">
	<h5 class="modal-title" id="myModalLabel">우편번호검색</h5>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header text-center">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>    
            <div class="modal-body text-center">
            <!-- 	<form id = "zip_codeForm"> -->
            		<div align="center">
            			<label>도로명 주소검색</label>
            		</div>
					<div class="input-group" align="left">
						<input type="text" class="form-control" id="doro" name="doro" placeholder="검색 할 도로명 입력(예: 구로디지털로, 여수울로)">
						<span class="input-group-btn">
						<input type="button" class="btn btn-warning" value="검색" id="searchBtn">  <!-- onclick="javascript:zipSearch();" -->
						</span>
					</div>
             <!--    </form> -->
                <div style="width:100%; height:200px; overflow:auto">
                	<table class = "table text-center">
                		<thead>
                		<tr>
                			<th style="width:150px;">우편번호</th>
                			<th style="width:600px;">주소</th>
                		</tr>
                		</thead>
                		<tbody id="zip_codeList"></tbody>
                	</table>
                </div>
            </div>
        </div>
    </div>
</div>
