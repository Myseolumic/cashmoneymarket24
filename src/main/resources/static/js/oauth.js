$.get("/user", function(data) {
    $("#dropdownMenuButton").html(data.principal.fullName);
});