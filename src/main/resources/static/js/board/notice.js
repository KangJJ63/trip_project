function confirmDelete() {
    if (confirm("정말로 삭제하시겠습니까?")) {
        document.getElementById("noticeTask").action = "/board/notice/{{noticeId}}/delete";
        document.getElementById("noticeTask").submit();
    }
}