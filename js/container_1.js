const Recientes = [
    { src: "https://i.redd.it/w6drorzwqv281.png", alt: "Imagen 1", title: "En proceso", link: "" },
    { src: "https://i.redd.it/w6drorzwqv281.png", alt: "Imagen 3", title: "En proceso", link: "" },
    { src: "https://i.redd.it/w6drorzwqv281.png", alt: "Imagen 2", title: "En proceso", link: "" },

];

const Proximamente = [
    { src: "https://i.pinimg.com/originals/02/a0/c1/02a0c19eb362eb7b84e596d21146ccfe.gif", alt: "Imagen 1", title: "En proceso", link: "" },
    { src: "https://i.pinimg.com/originals/02/a0/c1/02a0c19eb362eb7b84e596d21146ccfe.gif", alt: "Imagen 2", title: "En proceso", link: "" },
    { src: "https://i.pinimg.com/originals/02/a0/c1/02a0c19eb362eb7b84e596d21146ccfe.gif", alt: "Imagen 2", title: "En proceso", link: "" },

];

const Recomendados = [
    { src: "https://i.redd.it/w6drorzwqv281.png", alt: "Imagen 1", title: "En proceso", link: "" },
    { src: "https://i.redd.it/w6drorzwqv281.png", alt: "Imagen 3", title: "En proceso", link: "" },
    { src: "https://i.redd.it/w6drorzwqv281.png", alt: "Imagen 2", title: "En proceso", link: "" },
];

document.addEventListener("DOMContentLoaded", function () {
    // Función para mostrar imágenes en un contenedor específico
    function showImages(images, containerId) {
        const imageGrid = document.getElementById(containerId);
        imageGrid.innerHTML = '';

        // Iterarador de las imágenes para mostrarlas en el contenedor
        images.forEach(image => {
            const imageContainer = document.createElement("div");
            imageContainer.className = "image-container";

            const imgElement = document.createElement("img");
            imgElement.src = image.src;
            imgElement.alt = image.alt;

            const overlay = document.createElement("div");
            overlay.className = "image-overlay";
            overlay.innerHTML = `<h2 class="centered-text">${image.title}</h2>`;

            const link = document.createElement("a");
            link.href = image.link;
            link.appendChild(overlay);

            imageContainer.appendChild(imgElement);
            imageContainer.appendChild(link);
            imageGrid.appendChild(imageContainer);
        });
    }

    // Función para mostrar imágenes de Próximamente cuando se presiona el botón correspondiente
    document.getElementById("proximamenteButton").addEventListener("click", function () {
        showImages(Proximamente, "Images_1");
    });

    // Función para mostrar imágenes de Recientes cuando se presiona el botón correspondiente
    document.getElementById("recientesButton").addEventListener("click", function () {
        showImages(Recientes, "Images_1");
    });

    // Función para mostrar imágenes de Destacados cuando se presiona el botón correspondiente
    document.getElementById("recomendadosButton").addEventListener("click", function () {
        showImages(Recomendados, "Images_1");
    });

    // Mostrar imágenes populares por defecto al cargar la página
    showImages(Recientes, "Images_1");

});
