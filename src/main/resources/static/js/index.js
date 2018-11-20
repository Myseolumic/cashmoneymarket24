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

$('.post-location').each(function(){
    var coords = $(this).attr("value").replace('(','').replace(')','').split(',');
    var parsedCoords = [coords[0], coords[1]];
    console.log(parsedCoords);
})

var map;
var markers = [];
var icon = {
    url: "images/sellIcon.png"
}

function initMap() {
    if(document.getElementById('map') == null) return;
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 58.378241, lng: 26.714755},
        zoom: 16
    });

    map.addListener('click', function(event){
        addMarker(event.latLng);
    });
}

function addMarker(location){
    var marker = new google.maps.Marker({
        position: location,
        icon: icon,
        map: map
    });
    clearMap();
    document.getElementById('latLng').value = location;
    markers.push(marker);
}
function clearMap(){
    for(var i = 0; i < markers.length; i++) {
        markers[i].setMap(null);
    }
}
$.get("/user", function(data) {
    $("#dropdownMenuButton").html(data.principal.fullName);
});