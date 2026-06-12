# Student Course Form Application

## 📝 Project Overview

**Student Course Form Application** is a Java-based desktop application designed to streamline the student course registration and enrollment process. The application provides an intuitive interface for students to submit course registration forms, manage their academic plans, and track enrollment status. It's particularly useful for educational institutions seeking to digitize and automate their course registration workflows.

### Purpose
To simplify student course registration, reduce administrative burden, and provide students with an efficient platform to manage their academic coursework selection and planning.

---

## ✨ Key Features

### 1. **Student Registration Form**
- Comprehensive student information capture
- Personal details entry (Name, ID, Email, Contact)
- Academic information (Program, Semester, GPA)
- Form validation and error handling
- Persistent data storage

### 2. **Course Selection Interface**
- Browse available courses by department
- View course details (code, title, credits, instructor)
- Prerequisites display and validation
- Class schedule conflict detection
- Add/remove courses from selection

### 3. **Form Submission Management**
- Multi-step form validation
- Pre-submission verification
- Confirmation before final submission
- Success/error notifications
- Submission confirmation with reference number

### 4. **Academic Planning Tools**
- Course cart/wish list functionality
- Credit hour tracking
- Semester planning interface
- Course recommendation system
- Academic advisor notes integration

### 5. **Status Tracking**
- View submission history
- Track enrollment status
- Check approval status
- View submitted forms
- Download receipt/confirmation

### 6. **Data Management**
- Form storage and retrieval
- Edit capability for incomplete forms
- Search and filter functionality
- Export to PDF/Excel
- Database backup features

---

## 🛠️ Technology Stack

| Component | Technology |
|-----------|-----------|
| **Programming Language** | Java (JDK 11+) |
| **GUI Framework** | Swing / JavaFX |
| **Database** | SQLite / MySQL |
| **Build Tool** | Maven / Gradle |
| **IDE** | IntelliJ IDEA / Eclipse |
| **Version Control** | Git |

---

## 🏗️ Architecture

```
StudentCourseForm/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/student/
│   │   │   │   ├── Main.java
│   │   │   │   ├── ui/
│   │   │   │   │   ├── MainFrame.java
│   │   │   │   │   ├── StudentInfoPanel.java
│   │   │   │   │   ├── CourseSelectionPanel.java
│   │   │   │   │   ├── ConfirmationPanel.java
│   │   │   │   │   ├── StatusPanel.java
│   │   │   │   │   └── MenuBar.java
│   │   │   │   ├── models/
│   │   │   │   │   ├── Student.java
│   │   │   │   │   ├── Course.java
│   │   │   │   │   ├── CourseForm.java
│   │   │   │   │   ├── Enrollment.java
│   │   │   │   │   └── CourseSelection.java
│   │   │   │   ├── services/
│   │   │   │   │   ├── FormService.java
│   │   │   │   │   ├── StudentService.java
│   │   │   │   │   ├── CourseService.java
│   │   │   │   │   ├── ValidationService.java
│   │   │   │   │   └── EnrollmentService.java
│   │   │   │   ├── data/
│   │   │   │   │   ├── DatabaseConnection.java
│   │   │   │   │   ├── StudentDAO.java
│   │   │   │   │   ├── CourseDAO.java
│   │   │   │   │   └── FormDAO.java
│   │   │   │   ├── utils/
│   │   │   │   │   ├── Constants.java
│   │   │   │   │   ├── Validators.java
│   │   │   │   │   ├── FileExporter.java
│   │   │   │   │   └── Logger.java
│   │   │   │   └── exceptions/
│   │   │   │       ├── FormValidationException.java
│   │   │   │       ├── DatabaseException.java
│   │   │   │       └── EnrollmentException.java
│   │   │   └── resources/
│   │   │       ├── database.properties
│   │   │       ├── config.properties
│   │   │       └── styles.css
│   │   └── test/
│   │       └── java/
│   │           ├── FormServiceTest.java
│   │           ├── ValidationServiceTest.java
│   │           └── StudentServiceTest.java
│   └── pom.xml / build.gradle
├── data/
│   ├── courses.sql
│   ├── students.sql
│   └── forms.db
├── resources/
│   ├── templates/
│   └── config/
├── README.md
└── .gitignore
```

---

## 🚀 Installation & Setup

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Maven 3.6+ or Gradle 6.0+
- MySQL 5.7+ or SQLite 3.0+
- Git

### Step-by-Step Installation

```bash
# 1. Clone the repository
git clone https://github.com/aleem02a/Studentcourseform.git
cd Studentcourseform

# 2. Install dependencies using Maven
mvn clean install

# Or using Gradle
gradle build

# 3. Configure database
# Edit src/main/resources/database.properties
# Set database URL, username, password

# 4. Initialize database
mvn flyway:migrate
# Or for Gradle
gradle flywayMigrate

# 5. Run the application
mvn spring-boot:run
# Or
java -jar target/StudentCourseForm-1.0.jar
```

### Database Configuration
Edit `src/main/resources/database.properties`:
```properties
# Database Connection
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/student_db
db.username=root
db.password=password

# Connection Pool
db.pool.size=10
db.timeout=30

# Debug
db.debug=false
```

---

## 📋 User Workflows

### Student Registration & Course Selection Flow

```
1. Launch Application
   ↓
2. Enter Student Information
   - Student ID
   - Full Name
   - Email
   - Contact Number
   - Program/Major
   - Semester
   ↓
3. Validate Student Information
   - Check if student exists in system
   - Verify enrollment status
   ↓
4. Browse & Select Courses
   - View available courses
   - Check prerequisites
   - Verify schedule conflicts
   - Add courses to selection
   ↓
5. Review Course Selection
   - Confirm selected courses
   - Review credit hours
   - Check schedule
   ↓
6. Submit Form
   - Final validation
   - Confirmation dialog
   - Generate reference number
   ↓
7. Receive Confirmation
   - Display confirmation message
   - Show reference number
   - Offer download/print options
```

---

## 🎯 Core Features Explained

### 1. **Form Validation**
- Student ID format validation
- Email address verification
- Phone number validation
- Credit hour limit check
- Prerequisite validation
- Schedule conflict detection

### 2. **Course Management**
- Department-wise course listing
- Course detail display (credits, schedule, instructor)
- Prerequisite tracking
- Course availability checking
- Capacity management

### 3. **Data Persistence**
- Store forms in database
- Retrieve historical submissions
- Update pending forms
- Archive completed registrations
- Generate audit trails

### 4. **User Interface**
- Multi-tab interface for different sections
- Intuitive form layout
- Real-time validation feedback
- Progress indicators
- Status messages

---

## 📊 Database Schema

### Students Table
```sql
CREATE TABLE students (
    student_id VARCHAR(20) PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(15),
    program VARCHAR(50),
    semester INT,
    gpa DECIMAL(3,2),
    enrollment_status VARCHAR(20),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
```

### Courses Table
```sql
CREATE TABLE courses (
    course_code VARCHAR(20) PRIMARY KEY,
    course_title VARCHAR(100),
    credits INT,
    department VARCHAR(50),
    instructor VARCHAR(100),
    schedule VARCHAR(100),
    capacity INT,
    enrolled INT,
    prerequisites VARCHAR(200)
);
```

### Course Forms Table
```sql
CREATE TABLE course_forms (
    form_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id VARCHAR(20),
    submission_date TIMESTAMP,
    status VARCHAR(20),
    reference_number VARCHAR(50),
    notes TEXT,
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);
```

---

## 🧪 Testing

```bash
# Run all unit tests
mvn test

# Run specific test class
mvn test -Dtest=FormServiceTest

# Run integration tests
mvn verify

# Generate test coverage report
mvn test jacoco:report
mvn jacoco:report

# View coverage report
# Open target/site/jacoco/index.html
```

---

## 🔐 Security Features

- User authentication and authorization
- Input validation and sanitization
- SQL injection prevention (prepared statements)
- Secure session management
- Password encryption
- Role-based access control
- Audit logging of all operations

---

## 🐛 Known Issues & Limitations

- Single-user application (network mode in development)
- Maximum 500 courses per semester
- Form submission timeout after 30 minutes
- Browser compatibility issues with older Java versions
- Limited print formatting options

---

## 🗺️ Roadmap

### Version 2.0 (Planned)
- [ ] Multi-user network support
- [ ] Integration with student information system
- [ ] Mobile application
- [ ] Advanced analytics dashboard
- [ ] Email notifications
- [ ] Payment integration

### Version 3.0 (Planned)
- [ ] Cloud-based deployment
- [ ] AI-powered course recommendations
- [ ] Virtual advisor chatbot
- [ ] Real-time enrollment tracking
- [ ] Mobile app for iOS/Android

---

## 📈 Performance Considerations

- Database indexing on frequently searched fields
- Lazy loading of course lists
- Caching of static data
- Optimized SQL queries
- Connection pooling for database

---

## 🤝 Contributing

Contributions are welcome! Please follow these guidelines:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/NewFeature`)
3. Commit changes (`git commit -m 'Add NewFeature'`)
4. Push to branch (`git push origin feature/NewFeature`)
5. Open a Pull Request

### Code Standards
- Follow Java naming conventions
- Write javadoc for public methods
- Maintain code with 80%+ test coverage
- Use meaningful variable names
- Document complex logic

---

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

**Mohammad Aleem Qurammi**
- GitHub: [@aleem02a](https://github.com/aleem02a)

---

## 📞 Support & Contact

For questions or support:
- **GitHub Issues**: [Report an issue](https://github.com/aleem02a/Studentcourseform/issues)
- **Discussions**: [Join community](https://github.com/aleem02a/Studentcourseform/discussions)

---

## 🙏 Acknowledgments

- Java community for documentation and support
- Educational institutions using this application
- All contributors and users providing feedback

---

**Version**: 1.0.0  
**Last Updated**: 2026-06-12  
**Status**: Active Development  
**Compatibility**: Java 11+, Windows/Mac/Linux
