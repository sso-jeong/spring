function load() {
    $.ajax({
        url: "/grp/getBuseoList",
        type: "POST",
        data: "",
        contentType: 'application/x-www-urlencoded; charset=utf-8', // 수신 방식
        dataType: "json", // 수신 데이터 타입
        success: function (resData) {
        
            $.each(resData, function(key, value){
            	$("#buseo").append("<option>"+value.buseo_name+"</option>");
            });
            
        },
        error: function () {
            alert("시스템 에러");
        }
    });
    
     $.ajax({
        url: "/grp/getGradeList",
        type: "POST",
        data: "",
        contentType: 'application/x-www-urlencoded; charset=utf-8', // 수신 방식
        dataType: "json", // 수신 데이터 타입
        success: function (resData) {
        
            $.each(resData, function(key, value){
            	$("#grade").append("<option>"+value.grade_name+"</option>");
            });
            
        },
        error: function () {
            alert("시스템 에러");
        }
    });
}