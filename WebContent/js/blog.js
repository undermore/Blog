$(document).ready(function() {
    $(window).scroll(function() {
        var scrollY = $(document).scrollTop();
        if(scrollY > 300) {
            $('.info').hide();
        } else {
            $('.info').show();
        }
    });

	$("#switch").click(function(event) {
		if ($("#wrap").hasClass('open')) {
			$('#wrap,#left-nav').removeClass('open');
			$(this).removeClass('botton-open');
		} else {
			$('#wrap,#left-nav').addClass('open');
			$(this).addClass('botton-open');
		}
	});
	
	$(".showSub").click(function(event){
		$(this).next(".submenu").slideToggle();
	});

	
});