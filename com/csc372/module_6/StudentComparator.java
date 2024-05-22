package com.csc372.module_6;

import java.util.Comparator;

class StudentComparator implements Comparator<Student>
{
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getRollno(), s2.getRollno());
    }
}
