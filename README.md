# Out-Patient-Appointment-System
This project implements an API for managing appointments in an out-patient appointment system. Doctors practice on a weekly schedule, with appointments available in the evenings. The system allows for listing doctors, viewing doctor details, checking doctor availability, and booking appointments.


## API Endpoints

### Doctors Listing
- **GET /doctors**: Retrieves a list of all doctors.

### Doctor Detail Page
- **GET /doctors/{doctorId}**: Retrieves details of a specific doctor.

### Availability
- **GET /doctors/{doctorId}/availability**: Retrieves available time slots for a specific doctor.

### Appointment Booking
- **POST /appointments/book**: Books an appointment with a specific doctor.

## Deployment
- http://localhost:8080/swagger-ui/index.html#: Provides an interactive documentation of the API endpoints.

## Screencast Explanation
- https://www.dropbox.com/scl/fi/quei9rvdmipljg5t685rz/Out-Patient-Appointment-Project.mp4?rlkey=vptsr3pd5duxjv8nf2cuiforv&st=smeb2ijd&dl=0: Provides a video demonstration and explanation of the code and API functionality.

