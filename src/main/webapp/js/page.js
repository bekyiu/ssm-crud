// 提交form表单
function goto(pageNumber) {
    document.querySelector("#currentPage").value = pageNumber
    document.querySelector("#pageSize").value = document.querySelector("#pageSizeItems").value
    document.forms[0].submit();
}