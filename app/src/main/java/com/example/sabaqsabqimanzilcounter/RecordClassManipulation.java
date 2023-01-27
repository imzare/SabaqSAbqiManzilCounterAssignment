package com.example.sabaqsabqimanzilcounter;


import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.util.Log;

import java.util.Date;

public class RecordClassManipulation {

    // Date datetime;
    String Name;
    String Sabaq;
    String Sabqi;
    String Manzil;

    String RollNumber;


    public RecordClassManipulation( String pName,    String pSabaq,    String pSabqi,    String pManzil, String pRollNumber) {

        //  this.datetime = datetime;
        Name= pName;
        Sabaq=pSabaq;
        Sabqi=pSabqi;
        Manzil=pManzil;
        RollNumber=pRollNumber;
       // Date = pDate;

    }


    public RecordClassManipulation() {

        //  this.datetime = datetime;
        Name= "";
        Sabaq="";
        Sabqi="";
        Manzil="";
        RollNumber="";

    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSabaq() {
        return Sabaq;
    }

    public void setSabaq(String sabaq) {
        Sabaq = sabaq;
    }

    public String getSabqi() {
        return Sabqi;
    }

    public void setSabqi(String sabqi) {
        Sabqi = sabqi;
    }

    public String getManzil() {
        return Manzil;
    }

    public void setManzil(String manzil) {
        Manzil = manzil;
    }


    public String getRollNumber() {
        return RollNumber;
    }

    public void setRollNumber(String rollNumber) {
        RollNumber = rollNumber;
    }

/*   @Override
    public String toString() {
        return Name;
    }*/

    @Override
    public String toString() {
        return "Student Data:-\n Name:" + Name + "\n Date=" + RollNumber + "\n Sabaq=" + Sabaq+ "\n Sabqi=" + Sabqi+ "\n Manzil=" + Manzil
                + "\n" +  "...................................." +"\n";
    }
}


