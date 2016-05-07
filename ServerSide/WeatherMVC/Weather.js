$(document).ready(function() {
  document.onkeypress = stopEnterKey;
  //model
  var model = {};  
  //view
  function updateView(json) {
     try {
      model.region = json.location.region;
      model.city = json.location.name;
      model.condition = json.current.condition.text;
      model.temp = json.current.temp_f;
      model.icon = 'http:' + json.current.condition.icon;
      $('#results').html('<h2 style="font-weight: bold">Weather for ' + model.city + ', ' + model.region+'</h2>'
        + '<h3>' + model.condition + ', ' + model.temp + '&#8457;</h3>'
        + '<img src="' + model.icon +'" alt="' + model.condition + '">');
    } catch(err) {
      console.log(err);
      $('#results').html('<h3 style="color: red; font-weight: bold">No matching location found.</h3>');
    } 
  }

  //controller 
    $('#get_forecast').click(function() {
      $('#results').addClass('jumbotron');
      var input = $('#info_input').val().trim();
      var url = 'http://api.apixu.com/v1/current.json?key=180e390bca4d44d9a4a11730161104&q='+input;
      var request = $.getJSON(url);
      request.done(function(json) {
        console.log(json);
        updateView(json);
      });
    });
    $('body').keyup(function(e) {
      if(e.which == 13) {
        $('#get_forecast').trigger('click');
      }
    });

  function stopEnterKey(e) {
    var evt = (e) ? e : ((event) ? event : null);
    var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null);
    if ((evt.keyCode == 13 || evt.which == 13) && (node.type=="text")) {
      return false;
    }
  }
});