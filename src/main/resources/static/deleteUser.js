function deleteUser(id) {
    fetch('http://localhost:8080/users/' + id, {
        method: 'DELETE',
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })
        .then(response => response.status == 200 ? (alert("User deleted successfully"), showAllUsers()) : alert("Error while deleting user"));
}