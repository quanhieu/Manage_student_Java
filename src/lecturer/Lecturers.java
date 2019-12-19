package lecturer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Scanner;
import person.*;

/**
 *
 * @author Soi Lan Tron
 */
public class Lecturers extends persons{

    private String lecId;
//    private String lecName;
//    private String lecEmail;
    private String lecAddress;
    private String lecDept;
    private String lecDob;
    private String lecPhone;

    public Lecturers() {
        lecId = "unknow";
//        lecName = "unknow";
//        lecEmail = "unknow";
        lecAddress = "unknow";
        lecDept = "unknow";
        lecDob = "unknow";
        lecPhone = "unknow";
    }
    

    public static String clearName(String s) {
        String sClear = s;
        sClear = sClear.trim();
        String[] arrWord = sClear.split(" ");
        sClear = "";
        for (String word : arrWord) {
            String newWord = word.toLowerCase();
            if (newWord.length() > 0) {
                newWord = newWord.replaceFirst(
                        newWord.charAt(0) + "",
                        (newWord.charAt(0) + "").toUpperCase());
                sClear += newWord + " ";
            }
        }
        return sClear.trim();
    }

    public Lecturers(String lecId, String Name, String Email, String lecAddress, String lecDept, String lecDob, String lecPhone) {
        super(Name, Email);
        this.lecId = lecId;
//        this.lecName = lecName;
//        this.lecEmail = lecEmail;
        this.lecAddress = lecAddress;
        this.lecDept = lecDept;
        this.lecDob = lecDob;
        this.lecPhone = lecPhone;
    }

    public void setLecId(String lecId) {
        this.lecId = lecId;
    }

    public String getLecId() {
        return lecId;
    }

//    public void setLecName(String lecName) {
//
//        this.lecName = lecName;
//    }
//
//    public String getStdName() {
//        return lecName;
//    }
//
//    public String getlecName() {
//        return lecName;
//    }
//
//    public void setLecEmail(String lecEmail) {
//        this.lecEmail = lecEmail;
//    }
//
//    public String getLecEmail() {
//        return lecEmail;
//    }

    public String getLecAddress() {
        return lecAddress;
    }

    public void setLecAddress(String lecAddress) {
        this.lecAddress = lecAddress;
    }

    public String getLecDept() {
        return lecDept;
    }

    public void setLecDept(String lecDept) {
        this.lecDept = lecDept;
    }

    public String getLecDob() {
        return lecDob;
    }

    public void setLecDob(String lecDob) {
        this.lecDob = lecDob;
    }

    public String getLecPhone() {
        return lecPhone;
    }

    public void setLecPhone(String lecPhone) {
        this.lecPhone = lecPhone;
    }

}
