var swiper = new Swiper( '.swiper-container', {
    //pagination: '.swiper-pagination',
    //paginationClickable: true,
    autoplay:3000,
    speed : 1000,
    effect: 'coverflow',
    loop: true,
    centeredSlides: true,
    slidesPerView: 'auto',
    coverflow: {
        rotate: 0,
        stretch: 100,
        depth: 150,
        modifier: 1.5,
        slideShadows : true,

    }
} );


$(document).on('mouseenter', '.swiper-container', function(e){
    console.log('stop autoplay');
    swiper.stopAutoplay();
});
$(document).on('mouseleave', '.swiper-container', function(e){
    console.log('start autoplay');
    swiper.startAutoplay();
});