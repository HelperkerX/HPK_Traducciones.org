const toggles = document.querySelectorAll(".toggle");

toggles.forEach(toggle => {
    toggle.addEventListener("click", (e) => {
        e.preventDefault();
        const submenu = toggle.nextElementSibling;

        // Cierra todos los submenús abiertos excepto el actual
        document.querySelectorAll(".submenu").forEach(menu => {
            if (menu !== submenu) {
                menu.classList.remove("show");
            }
        });

        // Alterna el estado del submenú actual
        submenu.classList.toggle("show");
    });
});

// Cierra todos los submenús al hacer clic fuera del nav
document.addEventListener("click", (e) => {
    if (!e.target.closest("nav")) {
        document.querySelectorAll(".submenu").forEach(menu => {
            menu.classList.remove("show");
        });
    }
});