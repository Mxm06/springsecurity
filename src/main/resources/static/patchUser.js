function patchUser() {

    let form = window.formEditUser.editRoles;
    const userRole = {
        id: "2",
        name: "USER_ROLE"
    }
    const adminRole = {
        id: "1",
        name: "ADMIN_ROLE"
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

    let id = window.formEditUser.editID.value;

    fetch('http://localhost:8080/users', {
        method: 'PATCH',
        body: JSON.stringify({
            id: window.formEditUser.editID.value,
            firstName: window.formEditUser.editFirstName.value,
            lastName: window.formEditUser.editLastName.value,
            age: window.formEditUser.editAge.value,
            username: window.formEditUser.editEmail.value,
            password: window.formEditUser.editPassword.value,
            roles: rolesArr
        }),
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })
        .then(response => response.status == 200 ? (alert("User updated successfully"), showAllUsers()) : alert("Error while updating user"));
}

