document.addEventListener('DOMContentLoaded', function () {
    const topicNavigation = document.getElementById('topic-navigation');
    const contentSection = document.getElementById('content');

    // Event listener for topic navigation links
    topicNavigation.addEventListener('click', function (event) {
        event.preventDefault();
        if (event.target.tagName === 'A') {
            const topic = event.target.dataset.topic;
            loadTopicContent(topic);
        }
    });

    // Function to load content based on selected topic
    function loadTopicContent(topic) {
        let htmlContent = '';
        switch (topic) {
            case 'variables':
                loadCodeExample('Variables in C', 'concepts/variables/c_variables.c');
                loadCodeExample('Variables in C++', 'concepts/variables/cpp_variables.cpp');
                loadCodeExample('Variables in Python', 'concepts/variables/python_variables.py');
                loadCodeExample('Variables in Java', 'concepts/variables/java_variables.java');
                loadCodeExample('Variables in JavaScript', 'concepts/variables/javascript_variables.js');
                loadCodeExample('Variables in Rust', 'concepts/variables/rust_variables.rs');
                break;
            case 'control_structures':
                loadCodeExample('If-Else in C', 'concepts/control_structures/if_else/c_if_else.c');
                loadCodeExample('If-Else in C++', 'concepts/control_structures/if_else/cpp_if_else.cpp');
                loadCodeExample('If-Else in Python', 'concepts/control_structures/if_else/python_if_else.py');
                loadCodeExample('If-Else in Java', 'concepts/control_structures/if_else/java_if_else.java');
                loadCodeExample('If-Else in JavaScript', 'concepts/control_structures/if_else/javascript_if_else.js');
                loadCodeExample('If-Else in Rust', 'concepts/control_structures/if_else/rust_if_else.rs');
                // Add cases for other control structures similarly
                break;
            case 'functions_methods':
                loadCodeExample('Functions in C', 'concepts/functions_methods/c_functions.c');
                loadCodeExample('Functions in C++', 'concepts/functions_methods/cpp_functions.cpp');
                loadCodeExample('Functions in Python', 'concepts/functions_methods/python_functions.py');
                loadCodeExample('Methods in Java', 'concepts/functions_methods/java_methods.java');
                loadCodeExample('Functions in JavaScript', 'concepts/functions_methods/javascript_functions.js');
                loadCodeExample('Functions in Rust', 'concepts/functions_methods/rust_functions.rs');
                break;
            // Add cases for other topics similarly
            default:
                htmlContent = '<p>Select a topic from the navigation</p>';
                break;
        }

        // Function to fetch and display code example
        function loadCodeExample(title, filePath) {
            fetch(filePath)
                .then(response => response.text())
                .then(code => {
                    htmlContent += `
                        <article>
                            <h2>${title}</h2>
                            <pre><code class="language-${getFileExtension(filePath)}">${escapeHtml(code)}</code></pre>
                        </article>
                    `;
                    contentSection.innerHTML = htmlContent;
                    Prism.highlightAll(); // Highlight syntax using Prism.js
                })
                .catch(error => console.error('Error fetching code:', error));
        }

        // Function to get file extension
        function getFileExtension(filePath) {
            return filePath.split('.').pop();
        }

        // Function to escape HTML for displaying code
        function escapeHtml(html) {
            return html.replace(/</g, '&lt;').replace(/>/g, '&gt;');
        }
    }
});
