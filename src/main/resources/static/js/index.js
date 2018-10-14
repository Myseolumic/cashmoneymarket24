$('#peekMarket').on('show.bs.modal', function (e) {
    $.ajax({
        type: 'GET',
        url: "/peek-post",
        dataType: 'json',
        success: function (data, status) {
            $('#title').html(data.title);
            $('#message').html(data.message);

        }

    });
});