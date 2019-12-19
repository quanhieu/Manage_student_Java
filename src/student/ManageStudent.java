package student;

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
public class ManageStudent implements saveFile{

    public static Scanner myScanner = new Scanner(System.in);
    private ArrayList<Student> stdList = new ArrayList<Student>();
//    private List<Student> stdList;
//    private StudentDao studentDao;

//    public ManageStudent() {
//        studentDao = new StudentDao();
//        stdList = studentDao.read();
//    }

    public void studentMenu() {
        char choose;
        while (true) {
            System.out.println("=======================");
            System.out.println("1. Add new student");
            System.out.println("2. View all students");
            System.out.println("3. Search students");
            System.out.println("4. Delete students");
            System.out.println("5. Update student");
            System.out.println("6. Back to mainmenu");
            System.out.println("=======================");
            System.out.print("Please choose option: ");

            Scanner myScanner = new Scanner(System.in);
            choose = myScanner.nextLine().charAt(0);
//http://stackoverflow.com/questions/13942701/take-a-char-input-from-the-scanner	

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
                     System.out.println("Save file with name 'student' follow link D:/student.txt");
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

    //==========================================================================
//     int start_no;
    public void add() {
//        int add_no = start_no;
        String stdId = inputId();
        String stdName = inputName();
        String stdDob = inputDoB();
        String stdAddress = inputAddress();
        String stdBatch = inputBatch();
        String stdEmail = inputEmail();
        String stdPhone = inputPhone();
        Student myStudent = new Student(stdName, stdEmail, stdId, stdAddress, stdBatch, stdDob, stdPhone);
//        start_no++;
        stdList.add(myStudent);
//        studentDao.write(stdList);
    }

    public void view() {
        if (stdList.size() == 0) {
            System.out.println("No Data !");
            return;
        }
        for (int i = 0; i < stdList.size(); i++) {
            System.out.format("The student %d: \n", i + 1);
            System.out.println("ID: "+stdList.get(i).getStdId() + " | " +"Name: "+ stdList.get(i).getName() + " | "
                        +"Email: "+ stdList.get(i).getEmail() + " | " +"Address: "+ stdList.get(i).getStdAddress() + " | "
                        +"Batch: "+ stdList.get(i).getStdBatch() + " | " +"Dob: "+ stdList.get(i).getStdDob() + " | "
                        +"Phone: "+ stdList.get(i).getStdPhone());
        }
    }

    public void search() {

        System.out.println("Enter the Student name (or a part of the name) you want to search:");
        String searchName = myScanner.nextLine();
        for (int i = 0; i < stdList.size(); i++) {
            if (stdList.get(i).getName().toLowerCase().contains(searchName.toLowerCase()) == true) {
//"if(stdList.get(i).getStdName().indexOf(searchName) >= 0)	{" to find exactly or distinguish the lowerCase or upperCase 
                System.out.println("ID: "+stdList.get(i).getStdId() + " | " +"Name: "+ stdList.get(i).getName() + " | "
                        +"Email: "+ stdList.get(i).getEmail() + " | " +"Address: "+ stdList.get(i).getStdAddress() + " | "
                        +"Batch: "+ stdList.get(i).getStdBatch() + " | " +"Dob: "+ stdList.get(i).getStdDob() + " | "
                        +"Phone: "+ stdList.get(i).getStdPhone());
            } 
        }

    }


    public void delete() {
        //   String stdId = inputId();
        System.out.print("Enter the Student ID you want to delete: ");
        String searchId = myScanner.nextLine();
        int i;
        for (i = 0; i < stdList.size(); i++) {

            if (stdList.get(i).getStdId().compareTo(searchId) == 0) {
                break;
            }
        }

        if (i < stdList.size()) {
            System.out.println("ID: "+stdList.get(i).getStdId() + " | " +"Name: "+ stdList.get(i).getName() + " | "
                        +"Email: "+ stdList.get(i).getEmail() + " | " +"Address: "+ stdList.get(i).getStdAddress() + " | "
                        +"Batch: "+ stdList.get(i).getStdBatch() + " | " +"Dob: "+ stdList.get(i).getStdDob() + " | "
                        +"Phone: "+ stdList.get(i).getStdPhone());
            stdList.remove(i);
//            studentDao.write(stdList);
            System.out.print("Delete complete !\n");
        } else {
            System.out.printf("id = "+searchId+" not existed.\n");
        }

    }

    public void update() {
        //   String stdId = inputId();
        System.out.print("Enter the Student ID you want to update: ");
        String searchId = myScanner.nextLine();
        int i;
        for (i = 0; i < stdList.size(); i++) {

            if (stdList.get(i).getStdId().compareTo(searchId) == 0) {
                break;
            }
        }

        if (i < stdList.size()) {
            stdList.get(i).setStdId(inputId());
            stdList.get(i).setName(inputName());
            stdList.get(i).setEmail(inputEmail());
            stdList.get(i).setStdBatch(inputBatch());
            stdList.get(i).setStdDob(inputDoB());
            stdList.get(i).setStdAddress(inputAddress());
            stdList.get(i).setStdPhone(inputPhone());

//            studentDao.write(stdList);
            System.out.print("Update complete !\n");
        } else {
            System.out.printf("id = "+searchId+" not existed.\n");
        }

    }

    //==========================================================================
    private String inputId() {
        System.out.print("Input student ID: ");
//        String mystdId = myScanner.nextLine();
    String mystdId = null;
        boolean m = true;
        while (m) {
            mystdId = myScanner.nextLine();
            if (mystdId.length() == 7) {
                String first = mystdId.substring(0, 2);
                String last = mystdId.substring(2, 7);


                    if ((first.equals("GT") || first.equals("GC")) && checkDigit(last)) {
//                    return mystdId;
                        m = false;

                } else {
                        System.out.println("Please check id follow GCxxxxx or GTxxxxx");
                    }

            } else {
                System.out.println("Please check id follow GCxxxxx or GTxxxxx (with 'GC' ,'GT' are UPPERCASE and remaining xxxxx are digit): ");
              
            }
          
        }
        return mystdId;
    }

    public boolean checkDigit(String last) {
        char arrayremaining[] = last.toCharArray();
        
       for(int n=0;n <arrayremaining.length;n++)	{
           if(Character.isDigit(arrayremaining[n])==false) {
               return false;
               
           }
       }
        return true;
         
    }
    

    private String inputName() {
        System.out.print("Input student name: ");
        return myScanner.nextLine();
    }
    
    

    private String inputAddress() {
        System.out.print("Input student address: ");
        return myScanner.nextLine();
    }

    private String inputDoB() {
        System.out.print("Input student DoB: ");
        return myScanner.nextLine();
    }

    private String inputEmail() {
        System.out.print("Input student Email: ");
        return myScanner.nextLine();
    }

    private String inputBatch() {
        System.out.print("Input student Batch: ");
        return myScanner.nextLine();
    }


    
        private String inputPhone() {
         
        System.out.print("Input student Phone: ");

    String mystdPhone = null;
        
         while (true) {

            mystdPhone = myScanner.nextLine();
            if (mystdPhone.length() == 10) {
                System.out.print("Enter random 10 DIGIT !\n");
                String remaining = mystdPhone.substring(0, 9);
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
        return mystdPhone;
    }
        
        

        

    // getter && setter
//    public List<Student> getStudentList() {
//        return stdList;
//    }
//
//    public void setStudentList(List<Student> stdList) {
//        this.stdList = stdList;
//    }
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
                
                for (i =0; i < stdList.size(); i++) {
                    bw.write( " \n " +"ID: "+stdList.get(i).getStdId() + " | " +"Name: "+ stdList.get(i).getName() + " | "
                        +"Email: "+ stdList.get(i).getEmail() + " | " +"Address: "+ stdList.get(i).getStdAddress() + " | "
                        +"Batch: "+ stdList.get(i).getStdBatch() + " | " +"Dob: "+ stdList.get(i).getStdDob() + " | "
                        +"Phone: "+ stdList.get(i).getStdPhone());
                }
                bw.close();
                System.out.println("Write file completed");
            } catch (IOException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
            
        
               
    

}
