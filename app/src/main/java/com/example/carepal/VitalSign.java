package com.example.carepal;

public class VitalSign
{
    int ublPressure,lblPressure, blSugar, choHDL, choLDL, trigly;

    public VitalSign() {
    }
    public int getUblPressure()
    {
        return ublPressure;
    }

    public void setUblPressure(int u_blPressure)
    {
        ublPressure = u_blPressure;
    }

    public int getLblPressure() {
        return lblPressure;
    }

    public void setLblPressure(int blPressure) {
        this.lblPressure = blPressure;
    }

    public int getBlSugar() {
        return blSugar;
    }

    public void setBlSugar(int blSugar) {
        this.blSugar = blSugar;
    }

    public int getChoHDL() {
        return choHDL;
    }

    public void setChoHDL(int chOHDL) {
        choHDL = chOHDL;
    }

    public int getChoLDL() {
        return choLDL;
    }

    public void setChoLDL(int chOLDL) {
        choLDL = chOLDL;
    }

    public int getTrigly() {
        return trigly;
    }

    public void setTrigly(int Trigly) {
        trigly = Trigly;
    }
}
