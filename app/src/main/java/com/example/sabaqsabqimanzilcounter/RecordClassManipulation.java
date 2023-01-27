package com.example.sabaqsabqimanzilcounter;


import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.util.Log;

public class RecordClassManipulation {

    // Date datetime;
    String Name;
    String Sabaq;
    String Sabqi;
    String Manzil;

    String Date;


    public RecordClassManipulation( String pName,    String pSabaq,    String pSabqi,    String pManzil) {

        //  this.datetime = datetime;
        Name= pName;
        Sabaq=pSabaq;
        Sabqi=pSabqi;
        Manzil=pManzil;
       // Date = pDate;

    }


    public RecordClassManipulation() {

        //  this.datetime = datetime;
        Name= "";
        Sabaq="";
        Sabqi="";
        Manzil="";
        Date="";

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


    @Override
    public String toString() {
        return Name ;
    }


/*    public String getDate() {

        //getting current date time
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String Date= dateFormat.format(cal.getTime()).toString();
        Log.d(Date, "insertRecord: ");
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }*/
}
