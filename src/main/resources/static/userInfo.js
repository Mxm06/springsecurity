userInfo();

function userInfo(user) {
    fetch('http://localhost:8080/users/authorized')
        .then(response => response.json())
        .then(user => {
            let tBody = document.getElementById("user_info");
            tBody.innerHTML = "";

            var row = tBody.insertRow(0);
            var idCell = row.insertCell(0);
            idCell.innerHTML = user.id;
            var firstNameCell = row.insertCell(1);
            firstNameCell.innerHTML = user.firstName;
            var lastNameCell = row.insertCell(2);
            lastNameCell.innerHTML = user.lastName;
            var ageCell = row.insertCell(3);
            ageCell.innerHTML = user.age;
            var usernameCell = row.insertCell(4);
            usernameCell.innerHTML = user.username;
            var rolesCell = row.insertCell(5);
            let rolesString = "";
            user.roles.forEach(role => {
                rolesString += role.redactedNames + " ";
            })
            rolesCell.innerHTML = rolesString;
        });

}