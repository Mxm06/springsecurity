function postUser() {
    let form = window.formNewUser.newRoles;
    const userRole = {
        id: "2",
    }
    const adminRole = {
        id: "1",
    }
    let rolesArr = []
    for (var i = 0; i < form.length; i++) {
        var option = form.options[i];
        if (option.selected) {
            if (option.value == 1) {
                rolesArr.push(adminRole);
            }
            if (option.value == 2) {
                rolesArr.push(userRole)
            }
        }
    }


    fetch('/users', {
        method: 'POST',
        body: JSON.stringify({
            firstName: window.formNewUser.newName.value,
            lastName: window.formNewUser.newLastName.value,
            age: window.formNewUser.newAge.value,
            username: window.formNewUser.newEmail.value,
            password: window.formNewUser.newPassword.value,
            roles: rolesArr
        }),
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })
        .then(response => response.status == 200 ? (alert("New user added"), showAllUsers()) : alert("Error while creating user"))

    window.formNewUser.newName.value = "";
    window.formNewUser.newLastName.value = "";
    window.formNewUser.newAge.value = "";
    window.formNewUser.newEmail.value = "";
    window.formNewUser.newPassword.value = "";
    window.formNewUser.newRoles.value = "";

}