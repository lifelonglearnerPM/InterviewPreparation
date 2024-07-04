// Wait for the DOM content to be fully loaded before executing JavaScript
document.addEventListener('DOMContentLoaded', function () {
    // Select all language links within the #topic-navigation section
    const languageLinks = document.querySelectorAll('#topic-navigation a[data-language]');
    // Select the section where code examples will be displayed
    const codeExamplesSection = document.getElementById('code-examples');

    // Event listener for language links
    languageLinks.forEach(function (link) {
        link.addEventListener('click', function (event) {
            event.preventDefault(); // Prevent default link behavior (e.g., navigating to a new page)
            const language = event.target.dataset.language; // Get the selected language from the data-language attribute of the clicked link
            loadCodeExample(language); // Call the function to load code example based on the selected language
        });
    });

    // Function to load code example based on selected language
    function loadCodeExample(language) {
        let filePath = '';
        switch (language) {
            case 'c':
                filePath = 'concepts/programmingBasics/variablesAndDataTypes/c_variables.c'; // File path for C language example (adjust as needed)
                break;
            case 'cpp':
                filePath = 'concepts/programmingBasics/variablesAndDataTypes/cpp_variables.cpp'; // File path for C++ language example (adjust as needed)
                break;
            case 'python':
                filePath = 'concepts/programmingBasics/variablesAndDataTypes/python_variables.py'; // File path for Python language example (adjust as needed)
                break;
            case 'java':
                filePath = 'concepts/programmingBasics/variablesAndDataTypes/java_variables.java'; // File path for Java language example (adjust as needed)
                break;
            case 'javascript':
                filePath = 'concepts/programmingBasics/variablesAndDataTypes/javascript_variables.js'; // File path for JavaScript language example (adjust as needed)
                break;
            case 'rust':
                filePath = 'concepts/programmingBasics/variablesAndDataTypes/rust_variables.rs'; // File path for Rust language example (adjust as needed)
                break;
            default:
                console.error('Invalid language:', language); // Log an error message for invalid language selections
                return;
        }

        // Fetch the code file using the determined file path
        fetch(filePath)
            .then(response => response.text()) // Convert the response to text format
            .then(code => {
                // Display the code example in the codeExamplesSection
                codeExamplesSection.innerHTML = `
                    <article>
                        <h2>Example in ${language.toUpperCase()}</h2>
                        <pre><code class="language-${language}">${escapeHtml(code)}</code></pre>
                    </article>
                `;
                Prism.highlightAll(); // Highlight syntax using Prism.js
            })
            .catch(error => console.error('Error fetching code:', error)); // Log an error if fetching the code fails
    }

    // Function to escape HTML characters for displaying code safely
    function escapeHtml(html) {
        return html.replace(/</g, '&lt;').replace(/>/g, '&gt;'); // Replace < and > with HTML entities
    }
});
