/**
 * ���ύʱ��֤
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
 * �û��������ʧȥ����
 */
function InputUsernameBlur() {
    var uname = document.getElementById("InputUsername");
    var ename = document.getElementById("errorName");
    if (uname.value === "") {
        ename.innerHTML = "�û�������Ϊ�ա�";
        return false;
    } else {
        ename.innerHTML = "";
    }
    if (uname.value.length < 4 || uname.value.length > 16) {
        ename.innerHTML = "����Ϊ4-16��";
        return false;
    } else {
        ename.innerHTML = "";
    }
    return true;
}

/**
 * ���������ʧȥ����
 */
function InputPasswordBlur() {
    var pwd = document.getElementById("InputPassword");
    var epwd = document.getElementById("errorPassword");
    if (pwd.value === "") {
        epwd.innerHTML = "���벻Ϊ�ա�";
        return false;
    } else {
        epwd.innerHTML = "";
    }
    if (pwd.value.length < 6 || pwd.value.length > 16) {
        epwd.innerHTML = "����Ϊ6-16��";
        return false;
    } else {
        epwd.innerHTML = "";
    }
    return true;
}

/**
 * ȷ�����������ʧȥ����
 */
function InputRepasswordBlur() {
    var rpwd = document.getElementById("InputRepassword");
    var erpwd = document.getElementById("errorRepassword");
    if (rpwd.value === "") {
        erpwd.innerHTML = "ȷ�����벻Ϊ�ա�";
        return false;
    } else {
        erpwd.innerHTML = "";
    }
    var pwd = document.getElementById("InputPassword");
    if (pwd.value !== rpwd.value) {
        erpwd.innerHTML = "���벻һ�¡�";
        return false;
    } else {
        erpwd.innerHTML = "";
    }
    return true;
}
