package com.example.sabaqsabqimanzilcounter;



public class RecordClassManipulation {

    // Date datetime;
    String Name;
    String Sabaq;
    String Sabqi;
    String Manzil;
    //boolean isCorrect;


    public RecordClassManipulation(String pName,    String pSabaq,    String pSabqi,    String pManzil) {

        //  this.datetime = datetime;
        Name= pName;
        Sabaq=pSabaq;
        Sabqi=pSabqi;
        Manzil=pManzil;

    }


    public RecordClassManipulation() {

        //  this.datetime = datetime;
        Name= "";
        Sabaq="";
        Sabqi="";
        Manzil="";

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
}
