package entity.user;

import entity.collective.StudentClass;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Headmaster extends Teacher {

    @OneToOne(mappedBy = "headmaster", cascade = CascadeType.ALL)
    private StudentClass studentClass;

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public Headmaster setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
        return this;
    }
}
