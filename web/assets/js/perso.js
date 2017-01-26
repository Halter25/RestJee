$(document).ready(function () {
    $('select').material_select();
    $('#content').trigger('autoresize');
    $('input#input_text, textarea#content').characterCounter();
});