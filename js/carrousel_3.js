$('.youplay-carousel').owlCarousel({
    // Configuración existente de Owl Carousel
    loop: true,
    stagePadding: 0,
    nav: true,
    dots: false,
    // -------- Para la reproducción de carrusel --------
    autoplay: true,
    autoplayHoverPause: true, //Si el cursor entra en el carrusel este se detiene
    autoplayTimeout: 3000,
    // ------ Fin ------
    //navSpeed: 0, // Deshabilita la detección de finalización
    loop: true,
    items: 1,

    navText: ['', ''],
    responsive: {
        0: {
            items: 1,
            stagePadding: 25
        },
        640: {
            items: 1,
            stagePadding: 50
        },
        960: {
            items: 1,
            stagePadding: 100
        },
        1280: {
            items: 1,
            stagePadding: 250
        },
        1920: {
            items: 1,
            stagePadding: 500
        }
    },

    // Cuando el cursor sale del carrusel llama a X evento
    mouseleave: function () {
        autoplayHoverResume();
    }


});

//
function autoplayHoverResume() {
    // Cuando se llama a este evento reinicia el contador
    $('.youplay-carousel').trigger('play.owl.autoplay', [3000]); // Debe tener la misma cantidad que "autoplayTimeout"
}