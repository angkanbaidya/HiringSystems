
//Angkan BAIDYA
//112309655
//RECITATION 01

import java.util.Scanner;



    public class HiringSystems { /*** This main class first creates an hiring table object called instance.
                                    It has different variables such as keep going which help the main menu run. ***/
        static String userInput;
        static boolean keepGoing;

        static Scanner keyboard;
        static HiringTable Instance = new HiringTable();
        static private HiringTable backupcopy = new HiringTable();

    public static void main(String[] args)
    {


        userInput = ""; 	// EMPTY INPUT
        keepGoing = true;	// KEEP LOOPING

        keyboard = new Scanner(System.in);
        HiringSystems current = new HiringSystems();
        while (keepGoing)
        {
            runMainMenu();
            current.processMainMenuInput();
        }
    }

    private static void   runMainMenu() { /*** This method displays all the main menu options.***/

        System.out.println("\n*** SELECT A MENU OPTION ***");
        System.out.println("A) Add Applicant");
        System.out.println("R) Remove Applicant");
        System.out.println("G) Get Applicant");
        System.out.println("P) Print List ");
        System.out.println("RS) Refine Search");
        System.out.println("S) Size");
        System.out.println("D) Backup");
        System.out.println("CB) Compare Backup");
        System.out.println("RB) Revert Backup");
        System.out.println("Q) Quit");
        userInput = keyboard.nextLine();
    }





    private  void processMainMenuInput() /*** If the user presses the letter for a specific option then the code will
                                                run the specific method for that option.***/
    {
        // 1)
        if (userInput.toUpperCase().equals("A"))
        {
            runAddApplicant();
        }
        // 2)
        else if (userInput.toUpperCase().equals("R"))
        {
            runRemoveApplicant();
        }
        // Q or q
        else if (userInput.toUpperCase().equals("P"))
        {
            runPrintApplicantTable();
        }

        else if (userInput.toUpperCase().equals("G")){
            runGetApplicant();
        }

        else if (userInput.toUpperCase().equals("S")){
            runGetSize();
        }

        else if (userInput.toUpperCase().equals("D")){

            runGetClone();

        }

        else if (userInput.toUpperCase().equals("CB")){
           runCompareBackup();

        }

        else if (userInput.toUpperCase().equals("RS")){
            runRefineSearch();
        }
        else if (userInput.toUpperCase().equals("Q"))
        {
            System.out.println("\nGoodbye\n");
            keepGoing = false;
        }

        else if( userInput.toUpperCase().equals("RB"))
        {
            runRevertBackup();
        }

        // ENTRY NOT A VALID OPTION
        else
        {
            System.out.println("\nINVALID INPUT - Please enter a menu choice\n");
        }
    }


    private static void runAddApplicant() { /*** This method creates an applicant. It creates an applicant to the end of
                                                    the list and takes the different parameters for the Applicant object.
                                                    Parameters such as companies and skills are put into their own seperate
                                                    arrays which are fed into the applicant object at the end. If the GPA
                                                    is not valid the method will catch the error and inform the user.***/
        try {
            String[] Companies = new String[3];
            String[] SkillsArray = new String[3];
            System.out.print("\nEnter Applicant Name: ");
            userInput = keyboard.nextLine();
            String name = userInput;
            System.out.print("\nEnter GPA: ");
            double GPA = Double.parseDouble(keyboard.nextLine());
            System.out.print("\nEnter College: ");
            String College = keyboard.nextLine();
            System.out.print("\nEnter Company Name: ");
            String CompanyName = keyboard.nextLine();
            Companies[0] = CompanyName;
            System.out.println("\nEnter second company name: ");
            String CompanyName2 = keyboard.nextLine();
            if (CompanyName2.equals("")) {
                Companies[1] = "";
                Companies[2] = "";
                System.out.print("\nEnter First Skill: ");
                String Skills1 = keyboard.nextLine();
                SkillsArray[0] = Skills1;
                System.out.print("\nEnter Second Skill: ");
                String Skills2 = keyboard.nextLine();
                if (Skills2.equals("")) {
                    SkillsArray[1] = "";
                    SkillsArray[2] = "";
                    Instance.addApplicant(new Applicant(Companies, name, GPA, College, SkillsArray));

                } else {
                    SkillsArray[1] = Skills2;
                    System.out.println("\nEnter third skill: ");

                    String Skills3 = keyboard.nextLine();
                    if (Skills3.equals("")) {
                        SkillsArray[2] = "";
                        Instance.addApplicant(new Applicant(Companies, name, GPA, College, SkillsArray));
                    } else {
                        SkillsArray[2] = Skills3;
                        Instance.addApplicant(new Applicant(Companies, name, GPA, College, SkillsArray));
                    }
                }


            } else {
                Companies[1] = CompanyName2;
                System.out.println("\nEnter third company name");
                String CompanyName3 = keyboard.nextLine();
                if (CompanyName3.equals("")) {
                    Companies[2] = "";
                    System.out.print("\nEnter First Skill: ");
                    String Skills = keyboard.nextLine();
                    SkillsArray[0] = Skills;
                    System.out.print("\nEnter Second Skill: ");
                    String Skills2 = keyboard.nextLine();
                    if (Skills2.equals("")) {
                        SkillsArray[1] = "";
                        SkillsArray[2] = "";
                        Instance.addApplicant(new Applicant(Companies, name, GPA, College, SkillsArray));
                    } else {
                        SkillsArray[1] = Skills2;
                        System.out.println("\nEnter a third skill: ");
                        String Skills3 = keyboard.nextLine();
                        if (Skills3.equals("")) {
                            SkillsArray[2] = "";
                            Instance.addApplicant(new Applicant(Companies, name, GPA, College, SkillsArray));
                        } else {
                            SkillsArray[2] = Skills3;
                            Instance.addApplicant(new Applicant(Companies, name, GPA, College, SkillsArray));
                        }
                    }
                } else {
                    Companies[2] = CompanyName3;
                    System.out.print("\nEnter First Skill: ");
                    String Skills = keyboard.nextLine();
                    SkillsArray[0] = Skills;
                    System.out.print("\nEnter Second Skill: ");
                    String Skills2 = keyboard.nextLine();

                    if (Skills2.equals("")) {
                        SkillsArray[1] = "";
                        SkillsArray[2] = "";
                        Instance.addApplicant(new Applicant(Companies, name, GPA, College, SkillsArray));
                    } else {
                        SkillsArray[1] = Skills2;
                        System.out.println("\nEnter a third skill: ");
                        String Skills3 = keyboard.nextLine();
                        if (Skills3.equals("")) {
                            SkillsArray[2] = "";
                            Instance.addApplicant(new Applicant(Companies, name, GPA, College, SkillsArray));
                        } else {
                            SkillsArray[2] = Skills3;
                            Instance.addApplicant(new Applicant(Companies, name, GPA, College, SkillsArray));
                        }
                    }
                }

            }
            System.out.println(" The Applicant has succesfully been added to the hiring system ");
        } catch (HiringTable.FullTableException a) {
        }
        catch (NumberFormatException a){System.out.println("Please enter a valid GPA.");}

    }


    private static void runRemoveApplicant()  /*** This method calls upon the remove method in the hiring system class.
                                                    It asks the user for the name of the applicant and removes it based on name from
                                                    the hiring table array.***/

    {
        try {
            System.out.println("\nEnter Applicant Name");
            String removename = keyboard.nextLine();
            Instance.removeApplicant(removename);

        }catch (HiringTable.ApplicantNotFoundException a) {}}

    private static void runPrintApplicantTable(){ /*** This method calls upon the print applicant table in the Hiring Table
                                                        and prints out the information of applicants***/
        Instance.printApplicantTable();

    }

    private static void runGetApplicant(){        /*** This method asks the user for a name of a specific applicant
                                                        and displays the information of the specific applicant.***/
        try {
            System.out.print("\nEnter Applicant Name:");
            String applicantname = keyboard.nextLine();
            Instance.getApplicant(applicantname);
        }
        catch (HiringTable.ApplicantNotFoundException a){}
    }

    private static void runGetSize(){      /*** This method gets the counter from the hiring table class and shows
                                                    the number of applicants in the list. ***/
        Instance.size();
    }

    private  void runGetClone(){                        /*** This method creates a backup of the current hiring table
                                                        and saves the result to a variable called backup copy which can be used
                                                        to revert if needed**/
        backupcopy = (HiringTable)Instance.clone();
        System.out.println("Succesfully created a backup copy");

    }

    public void runCompareBackup() {                    /*** This method calls upon the equals method and checks the backup
                                                            copy and the current copy.**/
        if (Instance.equals(backupcopy)) {
            System.out.println("The backup and original are the same");
        }
        else{
            System.out.println("The backup and original are not the same");
        }
    }


    private static void runRefineSearch (){      /*** This method is a static method that asks the user for specific
                                                    criteria they want to find the applicant by and returns the applicants that
                                                    match.**/
            try{
                double GPA1 = 0;
        System.out.print("\nPlease enter company");
        String company = keyboard.nextLine();
        System.out.print("\nPlease enter gpa");
        String GPA = keyboard.nextLine();
        if( GPA.equals("")){ }
        else{
             GPA1 = Double.parseDouble(GPA);
        }
        System.out.print("\nPlease enter skill");
        String skill = keyboard.nextLine();
        System.out.print("\nPlease enter college");
        String college = keyboard.nextLine();
        Instance.refineSearch(Instance,company, skill, college, GPA1); }

        catch(NullPointerException a){

        } }

    public void runRevertBackup() {                             /*** This method reverts backup and saves the backup information
                                                                    onto the main Hiring Table array. ***/
        Instance = (HiringTable)backupcopy.clone();
       System.out.println("Succesfully reverted to original copy.");
    }




}

