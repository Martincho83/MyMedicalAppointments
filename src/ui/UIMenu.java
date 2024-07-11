package ui;

import model.Doctor;
import model.Patient;

import javax.print.Doc;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String [] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octube","Nobiembre","Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static  void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do{
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response !=0);
    }

    private  static  void  authUser(int userType){
        //userType = 1 Doctor
        //userType = 2 Patient
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandro Gomez", "ale@gomez.com"));
        doctors.add(new Doctor("Celeste Ramos", "cele@r.com"));
        doctors.add(new Doctor("Morena Lopez", "more@m.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Aida Gomez", "aida@gomez.com"));
        patients.add(new Patient("Lorena Rosas", "lore@r.com"));
        patients.add(new Patient("Monica Lopez", "momi@m.com"));

        boolean emailCorrect = false;
        do{
            System.out.println("Insert your email: a@a.com");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if(userType == 1){
                for(Doctor d: doctors){
                    if(d.getEmail().equals(email)){
                        emailCorrect = true;
                        //Obtener el usuario logueado
                        doctorLogged = d;
                        //showDoctorMunu
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }
            if(userType == 2){
                for(Patient p: patients){
                    if(p.getEmail().equals(email)){
                        emailCorrect = true;
                        patientLogged = p;
                        //showPatientMenu
                        UIPatientMenu.showPatientMenu();

                    }
                }
            }
        }while(!emailCorrect);
    }

    public static  void showPatientMenu(){
        int response = 0;
        do{
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book and appointment");
                    for (int i = 0; i < 4; i++) {
                        System.out.println(i+". "+ MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while(response !=0);
    }
}
