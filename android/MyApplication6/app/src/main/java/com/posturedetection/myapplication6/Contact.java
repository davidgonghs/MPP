package com.posturedetection.myapplication6;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Contact {
    private String name;
    private String contact;
    private String email;
    private boolean isMale;

    //dateOfBirth
    private Long dob;



    public Contact(String name, String contact, String email, boolean isMale) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.isMale = isMale;
    }

    public Contact(String name, String contact, String email, boolean isMale, Long dob) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.isMale = isMale;
        this.dob = dob;
    }

    @Override
    public String toString() {
        String dobString = "";
        if(dob != null){
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(dob);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dobString = simpleDateFormat.format(calendar.getTime());
        }

        return "Contact{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", isMale=" + isMale +
                ", dob=" + dobString +
                '}';
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getDob() {
        return dob;
    }

    public void setDob(Long dob) {
        this.dob = dob;
    }
}
