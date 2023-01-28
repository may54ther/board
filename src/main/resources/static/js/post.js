//////////////////////////////////////////////////
// Toast UI Editor & Viewer Initialize
/////////////////////////////////////////////////
const EL_VIEWER = document.querySelector('#viewer');
const Viewer = EL_VIEWER ?
    new toastui.Editor.factory({
        el: document.querySelector('#viewer'),
        viewer: true,
        height: '500px',
        initialEditType: "markdown",
    }) : null;

const EL_EDITOR = document.querySelector('#editor');
const Editor = EL_EDITOR ?
    new toastui.Editor({
        el: EL_EDITOR,
        previewStyle: 'vertical',
        height: '500px',
        initialEditType: "markdown",
        initialValue: '',
        events: {
            change() {
                //<![CDATA[
                document.querySelector("#content").value = Editor.getHTML() || "";
                //]]>
            }
        }
    }) : null;

/////////////////////////////////////////////////
// functions
/////////////////////////////////////////////////
var postFormAction = {
    getList: function () {
        location.href = `/posts`;
    },
    getDetail: function (postId) {
        location.href = `/posts/${postId}`;
    },
    addForm: function () {
        location.href = `/posts/add`;
    },
    replyForm: function (postId) {
        location.href = `/posts/${postId}/reply`;
    },
    editForm: function (postId) {
        location.href = `/posts/${postId}/edit`;
    },
    removePost: function (postId) {
        if (confirm("게시글을 삭제하시겠습니까?")) {
            location.href = `/posts/${postId}/remove`;
        }
    },
    savePost: function (e) {
        e.preventDefault();

        if (isNullOrEmpty(writer.value)) {
            showErrorToast("작성자를 입력하세요.");
        } else if (isNullOrEmpty(title.value)) {
            showErrorToast("제목을 입력하세요.")
        } else if (isNullOrEmpty(content.value)) {
            showErrorToast("내용을 입력하세요.");
        } else {
            postForm.submit();
        }
    },
}