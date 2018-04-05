(function () {
    $(init);
    var $usernameFld, $passwordFld, $createBtn;
    var $userRowTemplate, $tbody, $clones;
    var userService = new AdminUserServiceClient();

    function init() {
        $usernameFld = $('#usernameFld');
        $passwordFld = $('#passwordFld');
        $createBtn = $('.wbdv-create');
        $userRowTemplate = $('.wbdv-template.wbdv-user').clone();
        $userRowTemplate.removeClass('wbdv-hidden');
        $tbody = $('.wbdv-tbody');
        $createBtn.click(createUser);
        userService
            .findAllUsers(renderUsers);
        clones=makeClones()
    }
    function makeClones(){
      $clones={}
      $clones["createRow"]=$('tr.wbdv-form').clone();
      return $clones
    }
    function createUser() {
    $createRow=$('tr.wbdv-form');
    var user={}
    $createRow.find('td input,td select').each (function(id,inp) {
        $elem=$(inp)
        id=$elem.attr('id').replace('Fld','');
        val=$elem.val()
        if(!val) {
          alert("Please enter Value of "+id)
        $createRow.replaceWith($clones["createRow"].clone());
        return false;
        }
        else{
            user[id]=val
        }
    });
    userService
        .createUser(user,renderUsers);
    }
    function deleteUser() {
        // TBD
    }
    function selectUser() {
        // TBD
    }
    function updateUser() {
        // TBD
    }
    function renderUsers(users) {
        $tbody.empty();
        for(var u in users) {
            var user = users[u];
            var $row = $userRowTemplate.clone();
            $row.find('.wbdv-username').html(user.username);
            $row.find('.wbdv-first-name').html(user.firstName);
            $row.find('.wbdv-last-name').html(user.lastName);
            if ('tenure' in user)
            $row.find('.wbdv-role').html("FACULTY");
            else
                $row.find('.wbdv-role').html("STUDENT");
            $tbody.append($row);
        }
    }
})();
