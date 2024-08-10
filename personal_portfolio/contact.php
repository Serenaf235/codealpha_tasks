<?php
  // contact.php

  // Check if the form has been submitted
  if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Get the form data
    $name = $_POST['name'];
    $email = $_POST['email'];
    $message = $_POST['message'];

    // Validate the form data
    if (empty($name) || empty($email) || empty($message)) {
      echo 'Please fill in all fields.';
      exit;
    }

    // Send the email
    $to = 'serenafakha@gmail.com'; // Replace with your email address
    $subject = 'Contact Form Submission';
    $body = "Name: $name\nEmail: $email\nMessage: $message";

    // Use a more reliable method to send emails (e.g., PHPMailer)
    // For this example, we'll use the mail() function, but be aware of its limitations
    if (mail($to, $subject, $body)) {
      // Redirect to a thank-you page or display a success message
      header('Location: thank-you.html');
      exit;
    } else {
      echo 'Error sending email.';
    }
  } else {
    echo 'Form not submitted.';
  }
?>