$('.board-btn').on('click touchstart', function() {
    $('.board-btn').removeClass('active');
    $(this).addClass('active');
});

$('.ctrl-btn').on('click touchstart', function() {
    if ($('.board-btn.active').length) {
        window.location.replace("/play?"+ $('.board-btn.active').val() + $(this).val());
    }
});