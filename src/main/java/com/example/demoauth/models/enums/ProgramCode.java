package com.example.demoauth.models.enums;

public enum ProgramCode {
    INFORMATION_SYSTEMS  (FacultyCode.FACULTY_OF_DIGITAL_TRANSFORMATIONS),
    JOURNALISM (FacultyCode.FACULTY_OF_DIGITAL_TRANSFORMATIONS),
    FINANCE (FacultyCode.FACULTY_OF_DIGITAL_TRANSFORMATIONS),

    COMPUTER_SCIENCE (FacultyCode.FACULTY_OF_COMPUTER_TECHNOLOGY_AND_CYBER_SECURITY),
    SOFTWARE_ENGINEERING (FacultyCode.FACULTY_OF_COMPUTER_TECHNOLOGY_AND_CYBER_SECURITY),
    CYBER_SECURITY (FacultyCode.FACULTY_OF_COMPUTER_TECHNOLOGY_AND_CYBER_SECURITY);

    private FacultyCode faculty;

    ProgramCode(FacultyCode faculty) {
        this.faculty = faculty;
    }

    public boolean isInGroup(FacultyCode faculty) {
        return this.faculty == faculty;
    }
}
