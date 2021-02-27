package com.junjia.enums;

public enum RoleEnum {

    STUDENT(1, "学生"),
    TEACHER(2, "老师");

    private int roleNumber;
    private String value;

    RoleEnum(int roleNumber, String value) {
        this.roleNumber = roleNumber;
        this.value = value;
    }


    public static RoleEnum getRoleByRoleNumber(int roleNumber) {
        if (roleNumber == STUDENT.roleNumber) {
            return STUDENT;
        } else if (roleNumber == TEACHER.roleNumber) {
            return TEACHER;
        }
        return null;
    }





}
