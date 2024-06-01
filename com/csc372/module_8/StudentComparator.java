package com.csc372.module_8;

import java.util.Comparator;

class StudentComparator implements Comparator<Student>
{
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
