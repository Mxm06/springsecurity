showAllUsers();

function showAllUsers() {
    let table = document.getElementById("tableBody");
    table.innerHTML = "";
    fetch('http://localhost:8080/users')
        .then(response => response.json())
        .then(usersList => {
            usersList.forEach(user => {
                var row = table.insertRow();
                row.setAttribute("id", user.id);
                var idCell = row.insertCell();
                idCell.innerHTML = user.id;
                var firstNameCell = row.insertCell();
                firstNameCell.innerHTML = user.firstName;
                var lastNameCell = row.insertCell();
                lastNameCell.innerHTML = user.lastName;
                var ageCell = row.insertCell();
                ageCell.innerHTML = user.age;
                var emailCell = row.insertCell();
                emailCell.innerHTML = user.username;
                var roleCell = row.insertCell();
                let rolesString = "";
                user.roles.forEach(role => {
                    rolesString += role.redactedNames + " ";
                })
                roleCell.innerHTML = rolesString;

                var editButton = row.insertCell();
                editButton.innerHTML =
                    '<button type="button" onclick="modalTabPatch(' + user.id + ')" class="btn btn-primary btn-sm">Edit</button>';

                var deleteButton = row.insertCell();
                deleteButton.innerHTML =
                    '<button type="button" onclick="modalTabDelete(' + user.id + ')" class="btn btn-danger btn-sm">Delete</button>';
            })
        });
}
