document.addEventListener('DOMContentLoaded', () => {
    const toggleNavButton = document.getElementById('toggle-nav');
    const navPane = document.getElementById('nav-pane');
    const mainContent = document.getElementById('main-content');

    toggleNavButton.addEventListener('click', () => {
        navPane.classList.toggle('hidden');
        mainContent.classList.toggle('expanded');
    });
});
