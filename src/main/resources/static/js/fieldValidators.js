$(document).ready(function() {
    $("#playform").validate({
        rules: {
            a1: {
                required:true,
                digits: true
            },
            a2: {
                required:true,
                digits: true
            }
        },
        messages: {
            a1: "Please enter a whole number",
            a2: "Please enter a whole number"
        }
    });
});