document.getElementById("registrationForm").addEventListener("submit", function(event) {
  const name = document.getElementById("name").value.trim();
  const email = document.getElementById("email").value.trim();
  const age = parseInt(document.getElementById("age").value);

  if (name === "" || email === "" || isNaN(age) || age <= 0) {
    alert("Please fill out all fields correctly.");
    event.preventDefault(); // Prevent form submission
  }
});