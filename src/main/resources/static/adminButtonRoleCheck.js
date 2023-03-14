adminButtonRoleCheck();
function adminButtonRoleCheck() {
    fetch('http://localhost:8080/users/authorized')
        .then(response => response.json())
        .then(user => {

            let rolesString = "";
            user.roles.forEach(role => {
                rolesString += role.redactedNames + " ";
            })
            if (!rolesString.includes("ADMIN")) {
                document.getElementById("adminButton").style.display = "none";
            }
        });
}