# DN5.0_ALLWeek_s
i have completed my java,pl sql,design pattern
# Local Community Event Portal

## 📌 Project Overview
This project was developed as part of Cognizant’s HTML5 exercises.  
It is a lightweight, browser-based portal that allows residents to:
- Register for local events
- View past event galleries
- Watch promo videos
- Save preferences
- Find nearby events using geolocation

---

## 🏗️ What the Code Does

### 1. Base Template
- Uses `<!DOCTYPE html>` and semantic tags (`<nav>`, `<section>`, `<footer>`).
- Ensures compatibility across browsers.

### 2. Navigation
- Provides links to **Home**, **Events**, **Contact**, and **Help**.
- `help.html` opens in a new tab for external guidance.

### 3. Welcome Banner
- Displays a welcome message with a **blue background**.
- Highlights special offers using inline styles and CSS classes.

### 4. Image Gallery
- Shows past events in a **2x3 table layout**.
- Each image has `alt`, `title`, and styled borders.

### 5. Event Registration Form
- Collects **Name, Email, Date, Event Type, Message, Phone**.
- Uses validation (`required`, `autofocus`, `placeholder`).
- Displays confirmation via `<output>`.

### 6. Feedback & Event Handling
- Validates phone number with `onblur`.
- Counts characters typed in feedback textarea.
- Enlarges images on double-click.
- Shows confirmation on form submission.

### 7. Video Invite
- Embeds a promo video with controls.
- Displays “Video ready to play!” when loaded.
- Warns users before leaving the page (`onbeforeunload`).

### 8. User Preferences
- Saves preferred event type in **localStorage**.
- Restores preference on reload.
- Provides a button to clear preferences.

### 9. Geolocation
- Finds nearby events using `navigator.geolocation`.
- Displays latitude and longitude.
- Handles errors (permission denial, timeout).

### 10. Debugging
- Chrome DevTools used for live style edits, console logs, and breakpoints.

---

## 🎯 What I Learned
- How to structure HTML5 documents with semantic tags.
- Linking internal and external pages with `<nav>` and `<a>`.
- Styling with **CSS classes, IDs, and inline styles**.
- Building forms with validation and dynamic feedback.
- Handling **JavaScript events** (blur, change, click, dblclick, keyup).
- Using **localStorage/sessionStorage** for preferences.
- Embedding and controlling media with `<video>`.
- Implementing **geolocation** with error handling.
- Debugging effectively with Chrome DevTools.

---

## ✅ Next Steps
- Replace placeholder images with real event photos.
- Improve layout with **Flexbox/Grid** for responsiveness.
- Expand `help.html` with FAQs and contact info.
- Deploy the project on **GitHub Pages** for public access.
