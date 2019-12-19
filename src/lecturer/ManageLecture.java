package lecturer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import save.*;
import javax.swing.JFileChooser;

/**
 *
 * @author Soi Lan Tron
 */
public class ManageLecture implements saveFile{

    public static Scanner mylecScanner = new Scanner(System.in);
    private ArrayList<Lecturers> lecList = new ArrayList<Lecturers>();

    public void lectMenu() {
        char choose;
        while (true) {
            System.out.println("=======================");
            System.out.println("1. Add new lecturer");
            System.out.println("2. View all lecturer");
            System.out.println("3. Search lecturer");
            System.out.println("4. Delete lecturer");
            System.out.println("5. Update lecturer");
            System.out.println("6. Back to mainmenu");
            System.out.println("=======================");
            System.out.print("Please choose option: ");

            Scanner mylecScanner = new Scanner(System.in);
            choose = mylecScanner.nextLine().charAt(0);

            switch (choose) {
                case '1':
                    add();
                    break;
                case '2':
                    view();
                    break;
                case '3':
                    search();
                    break;
                case '4':
                    delete();
                    break;
                case '5':
                    update();
                    break;
                case '6':
                    System.out.println("Save file with name 'lecturer' follow link D:/lecturer.txt");
                    saveF();
                    break;
                default:
                    System.out.print("Enter the key form 1 to 6");
            }
            if (choose == '6') {
                break;
            }
        }
    }
//=================================================================================

    public void add() {
//        int add_no = start_no;
        String lecId = inputId();
        String lecName = inputName();
        String lecDob = inputDoB();
        String lecAddress = inputAddress();
        String lecDept = inputDepartment();
        String lecEmail = inputEmail();
        String lecPhone = inputPhone();
        Lecturers myLecturer = new Lecturers(lecId, lecName, lecEmail, lecAddress, lecDept, lecDob, lecPhone);

        lecList.add(myLecturer);

    }

    public void view() {
        if (lecList.size() == 0) {
            System.out.println("No Data !");
            return;
        }
        for (int i = 0; i < lecList.size(); i++) {
            System.out.format("The Lecturer %d: \n", i + 1);
            System.out.println("ID: "+lecList.get(i).getLecId() + " | " +"Name: "+ lecList.get(i).getName() + " | "
                    +"Email: "+ lecList.get(i).getEmail() + " | " +"Address: "+ lecList.get(i).getLecAddress() + " | "
                    +"Dept: "+ lecList.get(i).getLecDept() + " | " +"Dob"+ lecList.get(i).getLecDob() + " | "
                    +"Phone: "+ lecList.get(i).getLecPhone());
        }
    }

    public void search() {

        System.out.println("Enter the Lecturer name (or a part of the name) you want to search:");
        String searchName = mylecScanner.nextLine();
        for (int i = 0; i < lecList.size(); i++) {
            if (lecList.get(i).getName().toLowerCase().contains(searchName.toLowerCase()) == true) {
//"if(stdList.get(i).getStdName().indexOf(searchName) >= 0)	{" to find exactly or distinguish the lowerCase or upperCase 
                System.out.println("ID: "+lecList.get(i).getLecId() + " | " +"Name: "+ lecList.get(i).getName() + " | "
                    +"Email: "+ lecList.get(i).getEmail() + " | " +"Address: "+ lecList.get(i).getLecAddress() + " | "
                    +"Dept: "+ lecList.get(i).getLecDept() + " | " +"Dob"+ lecList.get(i).getLecDob() + " | "
                    +"Phone: "+ lecList.get(i).getLecPhone());
            }
        }

    }

    public void delete() {
        //   String stdId = inputId();
        System.out.print("Enter the Lecturer ID you want to delete: ");
        String searchId = mylecScanner.nextLine();
        int i;
        for (i = 0; i < lecList.size(); i++) {

            if (lecList.get(i).getLecId().compareTo(searchId) == 0) {
                break;
            }
        }

        if (i < lecList.size()) {
            System.out.println("ID: "+lecList.get(i).getLecId() + " | " +"Name: "+ lecList.get(i).getName() + " | "
                    +"Email: "+ lecList.get(i).getEmail() + " | " +"Address: "+ lecList.get(i).getLecAddress() + " | "
                    +"Dept: "+ lecList.get(i).getLecDept() + " | " +"Dob"+ lecList.get(i).getLecDob() + " | "
                    +"Phone: "+ lecList.get(i).getLecPhone());
            lecList.remove(i);
//            studentDao.write(stdList);
            System.out.print("Delete complete !\n");
        } else {
            System.out.printf("id = "+searchId+" not existed.\n");
        }
//        }
    }
    
        public void update() {
        //   String stdId = inputId();
        System.out.print("Enter the lecturer ID you want to update: ");
        String searchId = mylecScanner.nextLine();
        int i;
        for (i = 0; i < lecList.size(); i++) {

            if (lecList.get(i).getLecId().compareTo(searchId) == 0) {
                break;
            }
        }

        if (i < lecList.size()) {
            lecList.get(i).setLecId(inputId());
            lecList.get(i).setName(inputName());
            lecList.get(i).setEmail(inputEmail());
            lecList.get(i).setLecDept(inputDepartment());
            lecList.get(i).setLecDob(inputDoB());
            lecList.get(i).setLecAddress(inputAddress());
            lecList.get(i).setLecPhone(inputPhone());

//            studentDao.write(stdList);
            System.out.print("Update complete !\n");
//             break;
        } else {
            System.out.printf("id = "+searchId+" not existed.\n");
            
        }
//        } 

    }
        
//=================================================================================

    private String inputId() {
        System.out.print("Input Lecturer ID: ");
//        String mystdId = myScanner.nextLine();
        String myLecId = null;
        boolean m = true;
        while (m) {
            myLecId = mylecScanner.nextLine();
            if (myLecId.length() == 8) {
//                String first = myLecId.substring(0, 2);
                String last = myLecId.substring(0, 8);

                if (checkDigit(last)) {
//                    return mystdId;
                    m = false;

                } else {
                    System.out.println("Please check id follow xxxxxxxx (with x are 8 digit): ");
                }

            } else {
                System.out.println("Please check id follow xxxxxxxx (with x are 8 digit): ");

            }

        }
        return myLecId;
    }

    public boolean checkDigit(String last) {
        char arrayremaining[] = last.toCharArray();

        for (int n = 0; n < arrayremaining.length; n++) {
            if (Character.isDigit(arrayremaining[n]) == false) {
                return false;

            }
        }
        return true;

    }

    private String inputName() {
        System.out.print("Input lecturer name: ");
        return mylecScanner.nextLine();
    }

    private String inputAddress() {
        System.out.print("Input lecturer address: ");
        return mylecScanner.nextLine();
    }

    private String inputDoB() {
        System.out.print("Input lecturer DoB: ");
        return mylecScanner.nextLine();
    }

    private String inputEmail() {
        System.out.print("Input lecturer Email: ");
        return mylecScanner.nextLine();
    }

    private String inputDepartment () {
        System.out.print("Input lecturer Batch: ");
        return mylecScanner.nextLine();
    }

    private String inputPhone() {

        System.out.print("Input lecturer Phone: ");

        String mylecPhone = null;

        while (true) {

            mylecPhone = mylecScanner.nextLine();
            if (mylecPhone.length() == 10) {
                System.out.print("Enter random 10 DIGIT !\n");
                String remaining = mylecPhone.substring(0, 9);
                char arrayremaining[] = remaining.toCharArray();
                char check_non_Digit = 'N';

                for (int i = 0; i < arrayremaining.length; i++) {
                    if (Character.isDigit(arrayremaining[i]) == false) {
                        check_non_Digit = 'Y';
                        break;
                    }
                }
                if (check_non_Digit == 'N') {
                    System.out.print("Add Completely !\n");
                    break;
                } else {
                    System.out.print("Wrong remaining characters, enter whole Phone again: ");
                }

            } else {
                System.out.print("Wrong length, enter whole Phone with 10 digit: ");
            }
        }
        return mylecPhone;
    }

@Override
    public void saveF() { 
       JFileChooser fileChooser = new JFileChooser();

        int choice = fileChooser.showSaveDialog(null);
        int i;
                if (choice == JFileChooser.APPROVE_OPTION) {

            try {
                BufferedWriter bw = null;

                File file = fileChooser.getSelectedFile();
                bw = new BufferedWriter(new FileWriter(file));
                
                for (i =0; i < lecList.size(); i++) {
                    bw.write( " \n " +"ID: "+lecList.get(i).getLecId() + " | " +"Name: "+ lecList.get(i).getName() + " | "
                    +"Email: "+ lecList.get(i).getEmail() + " | " +"Address: "+ lecList.get(i).getLecAddress() + " | "
                    +"Dept: "+ lecList.get(i).getLecDept() + " | " +"Dob"+ lecList.get(i).getLecDob() + " | "
                    +"Phone: "+ lecList.get(i).getLecPhone());
                }
                bw.close();
                System.out.println("Write file completed");
            } catch (IOException ex) {
                Logger.getLogger(Lecturers.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
