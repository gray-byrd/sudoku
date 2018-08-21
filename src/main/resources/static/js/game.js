$('.board-btn').on('click touchstart', function() {
    $('.board-btn').removeClass('active highlight');
    $(this).addClass('active');
    var cellValue = $(this).html().trim();
    if (cellValue.length > 0) {
        $(".board-btn:contains('" + cellValue + "')")
            .addClass('highlight');
    }
});

$('.ctrl-btn').on('click touchstart', function() {
    var activeButton = $('.board-btn.active');
    if (activeButton.length
        && activeButton.html().trim().length <= 0
        && $(this).html().trim().length > 0) {
        window.location.replace("/play?"
            + activeButton.val() + $(this).val());
    }
});