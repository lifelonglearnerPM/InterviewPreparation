document.addEventListener("DOMContentLoaded", function() {
    function loadContent(file) {
        fetch(file)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text();
            })
            .then(html => {
                document.getElementById('content').innerHTML = html;
            })
            .catch(error => {
                console.error('Error loading content:', error);
            });
    }

    const links = document.querySelectorAll('#menu a');
    links.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            const file = this.getAttribute('onclick').match(/'(.*)'/)[1];
            loadContent(file);
        });
    });

    // Load the initial content
    loadContent('index.html');
});
