package com.demo.login.task;


public class AttendCheckTask {
    private static int i=0;
    public void checkAttend(){
        System.out.println("hello quartz , i="+(i++));
    }
}
