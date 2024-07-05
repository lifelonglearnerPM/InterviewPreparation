document.addEventListener('DOMContentLoaded', function() {
    const menu = document.getElementById('menu');
    const contentSection = document.getElementById('content');

    // Function to create menu items
    function createMenuItems() {
        const menuItems = [
            { label: 'Home', file: 'index.html' },
            { label: 'Content 1', file: 'html/content1.html' },
            { label: 'Content 2', file: 'html/content2.html' }
            // Add more menu items as needed
        ];

        const ul = document.createElement('ul');

        menuItems.forEach(item => {
            const li = document.createElement('li');
            const a = document.createElement('a');
            a.textContent = item.label;
            a.setAttribute('href', item.file);
            li.appendChild(a);
            ul.appendChild(li);
        });

        return ul;
    }

    // Function to load content into the content section
    function loadContent(file) {
        fetch(file)
            .then(response => response.text())
            .then(html => {
                contentSection.innerHTML = html;
            })
            .catch(error => console.error('Error loading content:', error));
    }

    // Initialize the menu and load initial content (content1.html by default)
    menu.appendChild(createMenuItems());

    // Event delegation for menu links
    menu.addEventListener('click', function(event) {
        event.preventDefault();
        if (event.target.tagName === 'A') {
            const file = event.target.getAttribute('href');
            loadContent(file);
        }
    });

    // Load initial content (content1.html by default)
    loadContent('html/content1.html');
});
