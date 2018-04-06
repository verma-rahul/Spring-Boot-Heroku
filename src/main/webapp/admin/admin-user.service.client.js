function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.url = location.protocol + '//' + location.host+"/api/user";
    this.url_student = location.protocol + '//' + location.host+"/api/student";
    this.url_faculty = location.protocol + '//' + location.host+"/api/faculty";
    var self = this;

    function findAllUsers(callback) {
        $.ajax({
            url: self.url,
            success: callback,
            error: function(xhr, status, error) {
              console.log(status + '; ' + error);
            }
        })
  }

    function createUser(user, callback) {
        var url= user.dtype=="Student" ? self.url_student:self.url_faculty;
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
              type: "POST",
              url: url,
              data: JSON.stringify(user),
              dataType: 'json',
              success: function (data){
                    console.log("success")
                    findAllUsers(callback)

              }
            });

    }

    function findUserById(userId, callback) {
        // TBD
    }

    function updateUser(userId, user, callback) {
        // TBD
    }

    function deleteUser(userId, callback) {
        // TBD
    }
}
