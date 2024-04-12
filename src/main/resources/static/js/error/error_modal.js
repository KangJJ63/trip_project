$(document).ready(function(){
    function showErrorModal(errorMessage) {
        $('#errorMessage').text(errorMessage); // 에러 메시지 설정
        $('#errorModal').modal('show'); // 모달 창 열기
    }
});