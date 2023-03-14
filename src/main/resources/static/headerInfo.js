headerInfo();

function headerInfo() {
    fetch('http://localhost:8080/users/authorized')
        .then(response => response.json())
        .then(user => {

            document.getElementById("headerUsername").innerHTML = user.username;

            let rolesString = "";
            user.roles.forEach(role => {
                rolesString += role.redactedNames + " ";
            })
            document.getElementById("headerRoles").innerHTML = 'with roles: ' + rolesString;
        });
}