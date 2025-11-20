// Acordeón para desplegables
document.querySelectorAll('.objeto').forEach(obj => {
    obj.addEventListener('click', () => {
        const subitems = obj.querySelector('.subitems');
        const flecha = obj.querySelector('.flecha');

        if (subitems.style.display === 'block') {
            subitems.style.display = 'none';
            flecha.style.transform = 'rotate(0deg)';
        } else {
            subitems.style.display = 'block';
            flecha.style.transform = 'rotate(90deg)';
        }
    });
});
