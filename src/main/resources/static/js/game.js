$('.board-btn').on('click touchstart', function() {
    $('.board-btn').removeClass('active highlight');
    $(this).addClass('active');
    if ($(this).html().trim().length > 0) {
        $(".board-btn:contains('" + $(this).html().trim() + "')").addClass('highlight');
    }
});

$('.ctrl-btn').on('click touchstart', function() {
    if ($('.board-btn.active').length
        && $('.board-btn.active').html().trim().length <= 0
        && $(this).html().trim().length > 0) {
        window.location.replace("/play?"+ $('.board-btn.active').val() + $(this).val());
    }
});