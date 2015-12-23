<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!-- Message Modal -->
<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="title"></h4>
            </div>
            <div class="modal-body">
                <p id="message"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!-- End Basic Modal -->

<script type="text/javascript">
function showMessage(title, message) {
    $("#title").text(title);
    $("#message").text(message);
    $("#messageModal").modal();   
}
</script>>