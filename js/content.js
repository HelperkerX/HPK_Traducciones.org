// Acordeón para desplegables
document.querySelectorAll('.objeto').forEach(obj => {
    obj.addEventListener('click', () => {
        const subitems = obj.querySelector('.subitems');
        const desplegable = obj.querySelector('.desplegable');

        if (subitems.style.display === 'block') {
            subitems.style.display = 'none';
            desplegable.style.transform = 'rotate(0deg)';
        } else {
            subitems.style.display = 'block';
            desplegable.style.transform = 'rotate(90deg)';
        }
    });
});
