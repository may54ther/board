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
