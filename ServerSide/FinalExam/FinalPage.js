
//model
var model = {};
model.results = '#list';
model.genre = '#genre';

var server = 'https://php-csci343.rhcloud.com/SP16/Examples/FilmCategories.php?cmd=films&category=';
var items = 5;
var id;

//view
function updateView(json) {
	console.log(json);
	$(model.genre).html(json[0].name);
	for(var i = 0; i < items; i++) {
		$(model.results).append('<li>'+json[i].title+'</li>');
	}
}

//controller
$(document).ready(function() {
	$('.btn-primary').on('click', function() {
		$(model.results).html('');
		id = this.id;
		var category = id;
		console.log(category);
		var url = server + category;
		var request = $.getJSON(url);
		request.done(function(json) {
			updateView(json);
		});
	});

	$('.btn-default').on('click', function() {
		items = parseInt(this.id.substring(4));
		$('#'+id).trigger('click');
	})
	$('#action').trigger('click');
});

