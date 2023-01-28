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
