$(function() {
    // $('.input-date').mask('00/00/0000');
    $('.input-password').maskPassword(500);

    $("form[name='register']").validate({
        rules: {
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                rangelength: [5, 30]
            }
        },

        messages: {
            email: {
                required: "Please enter your email address",
                email: "Please enter a valid email address"
            },
            password: {
                required: "Please enter a password",
                rangelength: "Password rules"
            }
        },

        submitHandler: function(form) {
            form.submit();
        }
    });
});