document.addEventListener('DOMContentLoaded', function() {
    const navPane = document.getElementById('nav-pane');
    const contentSection = document.getElementById('content');

    // Function to fetch list of HTML files in 'html' folder
    function fetchHTMLFiles() {
        return fetch('./html')
            .then(response => response.text())
            .then(html => {
                const parser = new DOMParser();
                const doc = parser.parseFromString(html, 'text/html');
                const links = Array.from(doc.querySelectorAll('a'))
                                  .map(a => a.getAttribute('href'))
                                  .filter(link => link.endsWith('.html') && !link.includes('index.html'));
                return links;
            });
    }

    // Function to create navigation links
    function createNavigationLinks(files) {
        const ul = document.createElement('ul');

        files.forEach(file => {
            const li = document.createElement('li');
            const a = document.createElement('a');
            const fileName = file.split('/').pop(); // Get filename from path
            a.textContent = fileName.replace('.html', '').toUpperCase();
            a.setAttribute('href', `html/${file}`);
            li.appendChild(a);
            ul.appendChild(li);
        });

        return ul;
    }

    // Function to load content into the content section
    function loadContent(file) {
        fetch(`html/${file}`)
            .then(response => response.text())
            .then(html => {
                contentSection.innerHTML = html;
            })
            .catch(error => console.error('Error loading content:', error));
    }

    // Initialize the navigation and load initial content
    fetchHTMLFiles()
        .then(files => {
            const navLinks = createNavigationLinks(files);
            navPane.appendChild(navLinks);

            // Load initial content (content1.html by default)
            const initialFile = files[0];
            loadContent(initialFile);
        })
        .catch(error => console.error('Error fetching HTML files:', error));

    // Event delegation for navigation links
    navPane.addEventListener('click', function(event) {
        event.preventDefault();
        if (event.target.tagName === 'A') {
            const file = event.target.getAttribute('href');
            loadContent(file);
        }
    });
});
