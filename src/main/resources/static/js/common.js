//////////////////////////////////////////////////
// toastr[type](msg)
// * type => success|info|warn|error
/////////////////////////////////////////////////
toastr.options = {
    "positionClass": 'toast-top-right',
    "timeOut": 3000,
    "extendedTimeOut": 1500,
    "closeButton": true,
    "progressBar": true,
    "preventDuplicates": true
}

function showErrorToast(msg) {
    toastr["error"](msg);
}

/////////////////////////////////////////////////
// functions
/////////////////////////////////////////////////
function lengthRange(el, minlength, maxlength) {
    var inputValue = el.value;
    if (inputValue.length >= minlength && inputValue.length <= maxlength) {
        return true;
    } else {
        showErrorToast("최소 " + minlength + ", 최대 " + maxlength + "까지 입력하세요.");
        return false;
    }
}

function isNullOrEmpty(value) {
    var returnValue = false;
    try {
        if (
            ((value != 0) & !value)
            || (typeof (value) == "undefined")
            || value == null
            || (typeof (value) == "object" && Object.prototype.toString.call(value) != "[object Date]" && !Object.keys(value).length)
            || (typeof (value) == "string" && value.trim() == "")
            || (typeof (value) == "number" && isNaN(value))
        ) {
            returnValue = true;
        }
    } catch (e) {
        returnValue = false;
    }
    return returnValue;
}