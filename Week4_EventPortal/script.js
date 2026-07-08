// Show confirmation when form is submitted
function showConfirmation(event) {
  event.preventDefault();
  document.getElementById("confirmation").value = "Registration successful!";
}

// Validate phone number on blur
function validatePhone() {
  let phone = document.getElementById("phone").value;
  if (!/^\d{10}$/.test(phone)) {
    alert("Phone number must be 10 digits");
  }
}

// Count characters in feedback textarea
function countChars() {
  let text = document.getElementById("feedback").value;
  document.getElementById("charCount").innerText = text.length;
}

// Enlarge image on double click
function enlargeImage(img) {
  img.style.width = "300px";
  img.style.height = "200px";
}

// Video ready event
function videoReady() {
  document.getElementById("videoMsg").innerText = "Video ready to play!";
}

// Warn user before leaving unfinished form
window.onbeforeunload = function() {
  return "Are you sure you want to leave? Unsaved form data will be lost.";
};

// LocalStorage
function savePreference(eventType) {
  localStorage.setItem("preferredEvent", eventType);
}

function clearPreferences() {
  localStorage.clear();
  sessionStorage.clear();
  alert("Preferences cleared!");
}

window.onload = function() {
  let pref = localStorage.getItem("preferredEvent");
  if (pref) {
    document.getElementById("eventType").value = pref;
  }
};

// Geolocation
function findEvents() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(
      (pos) => {
        document.getElementById("coords").innerText =
          "Latitude: " + pos.coords.latitude + ", Longitude: " + pos.coords.longitude;
      },
      (err) => {
        document.getElementById("coords").innerText = "Error: " + err.message;
      },
      { enableHighAccuracy: true, timeout: 5000 }
    );
  } else {
    alert("Geolocation not supported");
  }
}
