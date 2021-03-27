package com.example.carepal;

public class MedList
{
    String mediname, doctorname, meditime;

    public MedList()
    {
        mediname = null;
        doctorname = null;
        mediname = null;
    }

    public String getMediname() {
        return mediname;
    }

    public void setMediname(String mediname) {
        this.mediname = mediname;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getMeditime() {
        return meditime;
    }

    public void setMeditime(String meditime) {
        this.meditime = meditime;
    }

    @Override
    public String toString()
    {
        return ("Medication: " + mediname + "\nDoctor: " + doctorname + "\nTime to take medication: " + meditime);
    }
}
