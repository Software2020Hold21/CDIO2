/* Implement ajax call to rest Service */
$(document).ready(function () {
    loadUsers();
});


function createUser() {
    event.preventDefault();
    var data = $('#userform').serializeJSON();
    $.ajax({
        url: 'rest/user',
        method: 'POST',
        
        contentType: "application/json", // det vi sender er json
        data: data,
        success: function (data) {
            alert(JSON.stringify(data));
            loadUsers();
        },
		error: function (jqXHR, textStatus, errorThrown) {
		    alert(jqXHR.responseText);
		    alert(textStatus);
		    alert(errorThrown);

		}
    });
}

function deleteUser(id) {
    if (!id && id != 0) {
        id = $('#deleteid').val();
    }
    event.preventDefault();
    $.ajax({
        url: 'rest/user/' + id,
        method: 'DELETE',
        success: function (data) {
        	alert(JSON.stringify(data));
        	loadUsers();
        },
        error: function (jqXHR, textStatus, errorThrown) {
    		    alert(jqXHR.responseText);
    		    loadUsers();
    		
        }
    });
}

function loadUsers() {
    $.get('rest/user', function (data, textStatus, req) {
        $("#usertablebody").empty();
        $.each(data, function (i, elt) {
            $('#usertablebody').append(generateUserHTML(elt));
        });
    });
}

function generateUserHTML(user) {
    return '<tr><td>' + user.id + '</td>' +
        '<td>' + user.name + '</td>' +
        '<td>' + user.ini + '</td>' +
        '<td>' + user.roles + '</td>' +
        '<td>' + user.password + '</td>' +
        '<td>' + user.cpr + '</td>' +
        '<td onclick="deleteUser(' + user.id + ')"><button>slet bruger</button></td></tr> '
}

function generateHTML(json) {
    var html = '<tr>';
    $.each(json, function (i, elt) {
        html += '<td>' + JSON.stringify(elt) + '</td>';
    });
    return html += '</tr>';
}