/**
 * 表单提交时验证
 * @returns {boolean}
 */
function checkForm() {
    var form = document.getElementById("formId");
    var isValid = true;
    if (!InputUsernameBlur()) isValid = false;
    if (!InputPasswordBlur()) isValid = false;
    if (!InputRepasswordBlur()) isValid = false;
    return isValid;
}

/**
 * 用户名输入框失去焦点
 */
function InputUsernameBlur() {
    var uname = document.getElementById("InputUsername");
    var ename = document.getElementById("errorName");
    if (uname.value === "") {
        ename.innerHTML = "用户名不能为空。";
        return false;
    } else {
        ename.innerHTML = "";
    }
    if (uname.value.length < 4 || uname.value.length > 16) {
        ename.innerHTML = "长度为4-16。";
        return false;
    } else {
        ename.innerHTML = "";
    }
    return true;
}

/**
 * 密码输入框失去焦点
 */
function InputPasswordBlur() {
    var pwd = document.getElementById("InputPassword");
    var epwd = document.getElementById("errorPassword");
    if (pwd.value === "") {
        epwd.innerHTML = "密码不为空。";
        return false;
    } else {
        epwd.innerHTML = "";
    }
    if (pwd.value.length < 6 || pwd.value.length > 16) {
        epwd.innerHTML = "长度为6-16。";
        return false;
    } else {
        epwd.innerHTML = "";
    }
    return true;
}

/**
 * 确认密码输入框失去焦点
 */
function InputRepasswordBlur() {
    var rpwd = document.getElementById("InputRepassword");
    var erpwd = document.getElementById("errorRepassword");
    if (rpwd.value === "") {
        erpwd.innerHTML = "确认密码不为空。";
        return false;
    } else {
        erpwd.innerHTML = "";
    }
    var pwd = document.getElementById("InputPassword");
    if (pwd.value !== rpwd.value) {
        erpwd.innerHTML = "密码不一致。";
        return false;
    } else {
        erpwd.innerHTML = "";
    }
    return true;
}
