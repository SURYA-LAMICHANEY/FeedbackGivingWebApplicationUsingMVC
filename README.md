# FeedbackGivingWebApplicationUsingMVC
This project is design to help teachers to give feedback to students in different areas.
Each teacher and student will have an account through which they can go to their respective pages.
Since there is a chance of users creating fake accounts or same person creating more than one accounts, we have admin who creates accounts for all the users using ID card number as their username.
Teachers can logon to the portal and give feedback in three different areas, namely- academics, self-reliant department amd miscellaneous.
So, a teacher will select the area of feedback and then will write feedback to the student.
A teacher can write feedback to only those students who, are being taught by him(academic) and  who work in his self-reliance department .
Miscellaneous area is for all the teachers to write feedback to any student.
A teacher can see which student has read the feedback and which has not.

It is strictly a one way communication platform, i.e,only from teacher to student. Student can only view the feedback.
An acknowedgement will automatically be sent to the teacher as soon as the student reads the feedback. So the teacher will know that the student has read the feedback.

Both the admin and the teachers can view students' profile.Students can also view teachers' profile.
At the end of every semester the admin can generate a report for each student which contains all the feedbacks and grades that the student has received in the semester, and same can be sent to the parents of the student.

The main technology used here is model_view_controller (MVC). Basically, model contains java files which is used which is used for retrieving and storing data into database.
View is nothing but a jsp page which displays the results of particular search or query. Controller is a servlet which acts as intermediate between a model and a view.

Apart from MVC some web development tools used are- CSS and java script (for page design) and jasper reports for generating reports.
