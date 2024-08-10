// script.js

// Add event listener to the button in the home section
document.querySelector('#home button').addEventListener('click', () => {
  // Download a Word document when the button is clicked
  const url = 'https://docs.google.com/document/d/1pjNXkAfcVRRakeGfFC5MV40pLEvmY6Fm/edit?usp=drive_web&ouid=109480640041846851760&rtpof=true'; // Replace with the URL of your Word document
  const link = document.createElement('a');
  link.href = url;
  link.download = 'Serena_Fakha_Resume.docx'; // Set the file name for the download
  link.click();
});

// Add event listener to the navigation links
document.querySelectorAll('header nav a').forEach((link) => {
  link.addEventListener('click', (e) => {
    // Prevent default link behavior
    e.preventDefault();
    // Get the section ID from the link's href attribute
    const sectionId = link.getAttribute('href').replace('#', '');
    // Scroll to the corresponding section
    document.querySelector(`#${sectionId}`).scrollIntoView({ behavior: 'smooth' });
  });
});

// Add event listener to the contact form submit button
document.querySelector('#contact form').addEventListener('submit', (e) => {
  // Prevent default form submission behavior
  e.preventDefault();
  // Get the form data
  const formData = new FormData(e.target);
  // Send the form data to a server-side script (replace with your own script)
  fetch('/contact.php', {
    method: 'POST',
    body: formData,
  })
    .then((response) => response.json())
    .then((data) => console.log(data))
    .catch((error) => console.error(error));
});