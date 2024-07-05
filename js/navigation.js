document.addEventListener('DOMContentLoaded', function() {
    const navPane = document.getElementById('nav-pane');

    // Function to fetch list of HTML files in 'html' folder
    function fetchHTMLFiles() {
        return fetch('./html')
            .then(response => response.text())
            .then(html => {
                const parser = new DOMParser();
                const doc = parser.parseFromString(html, 'text/html');
                const links = Array.from(doc.querySelectorAll('a')).map(a => a.getAttribute('href'));
                return links.filter(link => link.endsWith('.html') && !link.includes('index.html'));
            });
    }

    // Function to create nested navigation links
    function createNestedNavigation(files) {
        const ul = document.createElement('ul');

        files.forEach(file => {
            const li = document.createElement('li');
            const a = document.createElement('a');
            const fileName = file.split('/').pop(); // Get filename from path
            a.textContent = fileName.replace('.html', '').toUpperCase(); // Example: content1.html -> CONTENT1
            a.setAttribute('href', `html/${file}`);
            li.appendChild(a);

            // Check if the file has subcontent and create nested list
            if (fileName === 'content1.html') {
                const subUl = document.createElement('ul');
                ['Keywords', 'Identifiers', 'Variables', 'Datatypes'].forEach(sub => {
                    const subLi = document.createElement('li');
                    const subA = document.createElement('a');
                    subA.textContent = sub;
                    subA.setAttribute('href', `html/${file}#${sub.toLowerCase()}`);
                    subLi.appendChild(subA);
                    subUl.appendChild(subLi);
                });
                li.appendChild(subUl);
            }

            ul.appendChild(li);
        });

        return ul;
    }

    // Initialize the navigation
    fetchHTMLFiles()
        .then(files => {
            const navLinks = createNestedNavigation(files);
            navPane.appendChild(navLinks);
        })
        .catch(error => console.error('Error fetching HTML files:', error));
});
