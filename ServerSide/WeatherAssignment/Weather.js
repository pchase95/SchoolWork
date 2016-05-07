$(document).ready(function() {
  document.onkeypress = stopEnterKey;
  $('#get_forecast').click(function() {
    $('#results').addClass('jumbotron');
    var input = $('#info_input').val().trim();
    var url = 'http://api.apixu.com/v1/current.json?key=180e390bca4d44d9a4a11730161104&q='+input;
    var request = $.getJSON(url);
    request.done(function(json) {
      console.log(json);
      try {
        var region = json.location.region;
        var city = json.location.name;
        var condition = json.current.condition.text;
        var temp = json.current.temp_f;
        var icon = 'http:' + json.current.condition.icon;
        $('#results').html('<h2 style="font-weight: bold">Weather for ' + city + ', ' + region+'</h2>'
          + '<h3>' + condition + ', ' + temp + '&#8457;</h3>'
          + '<img src="' + icon +'" alt="' + condition + '">');
      } catch(err) {
        console.log(err);
        $('#results').html('<h3 style="color: red; font-weight: bold">No matching location found.</h3>');
      }
    });
  });
  $('body').keyup(function(e) {
    if(e.which == 13) {
      $('#get_forecast').trigger('click');
    }
  });
});

function stopEnterKey(e) {
  var evt = (e) ? e : ((event) ? event : null);
  var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null);
  if ((evt.keyCode == 13 || evt.which == 13) && (node.type=="text")) {
    return false;
  }
}
