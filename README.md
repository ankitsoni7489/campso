🏫 CAMPso – Student Utility Web Portal 🎓📚
📘 1. Context
In many universities, students face the burden of managing multiple fragmented tools for organizing academic resources, events, faculty communication, library access, food services, and more. There is a need for a unified digital platform that streamlines all essential campus-related services.

CAMPso was developed as a full-stack student utility web portal to centralize these services, improve communication, and enhance the overall student experience.

🎯 2. Objective
The primary objective of CAMPso is to:

Digitally unify essential student services such as event tracking, study planning, faculty directories, library search, cafeteria menus, etc.

Promote collaboration and self-service among students.

Provide administrators a seamless interface to manage events, students, and resources.

Enable secure communication via features like OTP-based password reset and complaint email tracking.

⚙️ 3. Functional Overview (Features)
🌟 Student-Centric Features
Feature	Description
📅 Event Scheduler	View and track all university events
📘 Study Planner	Organize study schedules and manage tasks
👨‍🏫 Faculty Directory	Find faculty contact details and office locations
📢 Complaint Box	Submit and track complaints with email updates
🧳 Lost & Found	Report or find lost items
🍽 Cafeteria Menu	Browse daily menus of food outlets
📚 Library System	Search book availability in the library
📝 Note Sharing	Upload/download class notes
🔗 External Resources	Curated links to scholarships, portals, and more
🔐 OTP Reset	2-minute valid OTP for password recovery

🛠 Admin Panel
Add/edit/delete students, events, faculty, notes, and resources

Review and validate complaints

Manage Lost & Found submissions

Track notes and user activity

📖 4. Information (Technology Stack)
Component	Technology Used
Backend	Java, Spring Boot, Spring Security, Spring Data JPA
Frontend	HTML, CSS, Thymeleaf, JavaScript
Database	MySQL
Authentication	OTP verification system (Java Mail Sender)
Deployment	Local server or cloud deployment options
Security	Spring Security, OTP, Email-based verification

🔍 5. Problem Decomposition
The project is decomposed into several independent but integrated modules:

Authentication Module: Login, registration, password reset (OTP)

Event Module: Event creation, update, view

Study Module: Task planner and scheduler

Faculty Module: Faculty directory with location and contact info

Complaint Module: Trackable complaints with unique ID and email notification

Lost & Found Module: Submit and claim lost items

Cafeteria Module: Daily food menu display

Library Module: Search book availability and status

Notes Module: Upload/download class notes with ratings

External Links Module: Curated resource links for students

Each module interacts with a common user/authentication system and shares access control logic for students and admins.

🧩 6. Requirement Engineering Tasks
6.1 Inception (Identify Stakeholders & Goals)
Stakeholders: Students, University Admin, Faculty

Goals:

Provide centralized access to academic and campus services

Simplify campus communication

Encourage student collaboration

6.2 Elicitation (Gather Requirements)
Conducted via:

Student surveys on missing utilities

Interviews with admin for workflow pain points

Observation of current university website inefficiencies

6.3 Elaboration (Define Functional Requirements)
User Authentication: Role-based login, secure OTP reset

Admin Control: CRUD for every module

Student Portal: Event view, planner, note upload, complaint tracking

Real-Time Alerts: Email updates for complaints and OTP

6.4 Negotiation (Prioritize Requirements)
MVP Core Modules: Auth, Events, Notes, Complaints

Phase 2 Features: Cafeteria Menu, External Links, Faculty Directory

Tradeoffs: Offline mode not implemented; focus on real-time web interface

6.5 Specification (Document Requirements)
Each feature is formally documented as:

vbnet
Copy
Edit
Requirement ID: STU-03
Title: Submit Complaint
Description: Student should be able to submit a complaint with title, description, and category. Complaint ID is emailed.
Priority: High
6.6 Validation (Ensure Correctness)
Unit tested each module

Verified OTP expiry functionality (2-minute limit)

Admin dashboard tested with CRUD operations

Complaint email functionality verified with mock SMTP

6.7 Requirements Management (Maintain and Update)
Maintained using GitHub Issues & Kanban Board

Each module assigned a milestone

Changes tracked via version control & peer review

🎨 7. UI/UX Design
Designed by Manashi

Responsive and accessible UI for desktop & mobile

Clean module separation using tab-based navigation

Icons and color codes for each service (lost & found, events, etc.)

OTP input with countdown timer for security

🚀 8. Future Scope
Add Push Notifications for event reminders

Implement Dark Mode

Enable Analytics Dashboard for Admins (usage, logins, uploads)

Add Offline Support using service workers

🤝 Contribution
We welcome contributions! Please read the CONTRIBUTING.md and open issues or feature requests.

📜 License
This project is licensed under the MIT License.

📧 Contact
For any issues, contact: [as0766177@gmail.com]
