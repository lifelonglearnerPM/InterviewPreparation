//
// Created by: Your Name
// Date: YYYY-MM-DD
// Project: Interview Preparation Resources
// Description: JavaScript for Identifiers, Variables, and Data Types Page
//

document.addEventListener('DOMContentLoaded', function () {
    const languageSelect = document.getElementById('language-select');
    const codeContainer = document.getElementById('code-container');

    // Function to load code example based on selected language
    function loadCodeExample(language) {
        let filePath = '';
        switch (language) {
            case 'c':
                filePath = 'programmingLanguages/concepts/variablesAndDataTypes/c_examples.c';
                break;
            case 'cpp':
                filePath = 'programmingLanguages/concepts/variablesAndDataTypes/cpp_examples.cpp';
                break;
            case 'python':
                filePath = 'programmingLanguages/concepts/variablesAndDataTypes/python_examples.py';
                break;
            case 'java':
                filePath = 'programmingLanguages/concepts/variablesAndDataTypes/java_examples.java';
                break;
            case 'javascript':
                filePath = 'programmingLanguages/concepts/variablesAndDataTypes/javascript_examples.js';
                break;
            case 'rust':
                filePath = 'programmingLanguages/concepts/variablesAndDataTypes/rust_examples.rs';
                break;
            default:
                console.error('Invalid language:', language);
                return;
        }

        fetch(filePath)
            .then(response => response.text())
            .then(code => {
                codeContainer.innerHTML = `
                    <article>
                        <h3>Example in ${language.toUpperCase()}</h3>
                        <pre><code class="language-${language}">${escapeHtml(code)}</code></pre>
                    </article>
                `;
                Prism.highlightAll(); // Highlight syntax using Prism.js
            })
            .catch(error => console.error('Error fetching code:', error));
    }

    // Function to escape HTML for displaying code
    function escapeHtml(html) {
        return html.replace(/</g, '&lt;').replace(/>/g, '&gt;');
    }

    // Load the default Java code example on page load
    loadCodeExample('java');

    // Event listener for language selection
    languageSelect.addEventListener('change', function () {
        const selectedLanguage = languageSelect.value;
        loadCodeExample(selectedLanguage);
    });
});
