//Angkan BAIDYA
//112309655
//RECITATION 01

public class HiringTable { /*** The HiringTable Class is the main class that contains most methods and also contains the
                                counter variables that keep track of how many applicants
                                are in the Hiringtable. Variables such as Max companies and skills are final and static
                                because they do not change*///
    public final static int MAX_SKILLS = 3;
    public final static int MAX_COMPANIES = 3;
    final static int MAX_APPLICANT = 50;
    private Applicant[] data;
    int counter = 0;
    int counter1 = 49;
    int count2 = 49;
    int counter3 = 0;

    public Applicant[] getData() { /*** This method returns the main array***/
        return data;
    }

    public HiringTable() { /*** This method constructs a HiringTable but does not have any applicants.***/
        data = new Applicant[MAX_APPLICANT];
    }

    public int size() {                        /*** This method returns the amount of applicants in the Hiring Table***/
        System.out.println("There are" + " " + counter + " " + "Applicants in the Hiring System.");

        return counter;
    }

    public class FullTableException extends Exception{ /*** This class allows methods below to throw errors such as
                                                            FullTableException***/
        public FullTableException(String message){
            super();
        }}
    public class ApplicantNotFoundException extends Exception{ /*** This class allows methods below to throw errors such
                                                                    as ApplicantNotFoundException***/
        public ApplicantNotFoundException(String message){
            super();
        }}


    public void addApplicant(Applicant a) throws FullTableException{ /*** This method adds a new applicant object to the
                                                                            array. The number of applicants must always
                                                                    be less than Max Applicants otherwise it throws a
                                                                    FullTableException. Everytime a new applicant is
                                                                    added counter adds one***/
        data[counter1] = a;
        counter1--;
        counter++;
        if(counter == 50){
            throw new FullTableException("No more applicants can be added.");
        }
    }


    public void removeApplicant(String name) throws ApplicantNotFoundException{ /*** This method deletes applicants from
                                                                the hiring table. It removes the applicants specified to
                                                     the back of the list using a temporary variable. If the wrong name is
                                                                        inserted then the method will give an error. All
                                                                        applicants are also moved up one spot. ***/
        try {
            for (int i = MAX_APPLICANT -1; i >= 0; i--) {
                if (data[i].getApplicantName().equals(name)) {
                    Applicant temp = data[i];
                    data[i] = data[count2];
                    data[count2] = temp;
                    count2--;
                    counter--;
                    counter3++;
                System.out.println("Applicant has successfully been removed from the Hiring System.");}


            } }
            catch(NullPointerException a){}





        }

    public void printApplicantTable() {      /*** This method prints out the current Hiring Table array in a neat table.
                                                It uses C style formatting **/

        System.out.printf( "%-25s%-25s%25s%25s%25s", "Company Name", "Applicant", "GPA", "College", "Skills");
        System.out.print("\n");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");


        try {
            for (int i = count2; i >= 0; i--) {


                {
                    System.out.printf("%n%-25s%-25s%25s%25s%25s",data[i].getCompanies()[0] + "," +
                                    data[i].getCompanies()[1] + ","
                                    + data[i].getCompanies()[2] , data[i].getApplicantName() , data[i].getGPA() ,
                                             data[i].getCollege() , data[i].getSkills()[0] + ","
                                        + data[i].getSkills()[1] + "," + data[i].getSkills()[2]);
                }



            }


        } catch (NullPointerException a) {
        }
    }

    public Applicant getApplicant(String name) throws ApplicantNotFoundException {  /*** This method finds a specific applicant
                                                                                    based on name. Once the method goes through
                                                                                    the hiring table array and finds a name matching
                                                                                    an index it will print out the applicants information.
                                                                                    An applicant not found exception will also be thrown if
                                                                                    name does not match. ***/
            int place = 0;
            for (int i = MAX_APPLICANT - 1; i > MAX_APPLICANT - counter - 1; i--) {
                if (data[i].getApplicantName().equals(name)) {
                    System.out.println("The Applicant is applying from: " + data[i].getCompanies()[0] + "," +
                            data[i].getCompanies()[1] + "," +
                            data[i].getCompanies()[2]);
                    System.out.println("The Applicant's GPA is: " + data[i].getGPA());
                    System.out.println("The Applicant's College: " + data[i].getCollege());
                    System.out.println("Applicant Skills :" + data[i].getSkills()[0] + "," +
                            data[i].getSkills()[1] + "," + data[i].getSkills()[2]);

                }


            }


            return data[place];


    }


    public static void refineSearch(HiringTable a, String company, String skill, String college, double GPA) { /***

                                                    This method takes many different parameters such as a Hiring
                                                    table and custom GPA and compares it against the Hiring Table array and checks
                                                    to see which applicants meet the criteria. It first has 4 different flags that are set to false.
                                                    Once specified information matches, then the flags become true, or if the information supplied is blank.
                                                    If all flags are true, then the information matches and the system prints out the applicant.
                                                                                                                ***/


        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        int savenumber = 9;

        try {
            for (int i = MAX_APPLICANT - a.counter; i < MAX_APPLICANT; i++) {
                if (a.data[i].getCompanies()[0].equals(company) || company.equals("") ||
                        a.data[i].getCompanies()[1].equals(company) ||
                        a.data[i].getCompanies()[2].equals(company)) {
                    flag = true;
                }
                if (a.data[i].getGPA() > GPA || GPA == 0.0) {
                    flag1 = true;
                }
                if (a.data[i].getCollege().equals(college) || college.equals("")) {
                    flag2 = true;
                }
                if (a.data[i].getSkills()[0].equals(skill) || skill.equals("") ||
                        a.data[i].getSkills()[1].equals(skill)  ||
                        a.data[i].getSkills()[2].equals(skill) ) {
                    flag3 = true;
                }

                if (flag & flag1 & flag2 & flag3) {
                    savenumber = i;
                    flag = false;
                    flag1 = false;
                    flag2 = false;
                    flag3 = false;
                    System.out.printf("%n%-25s%-25s%25s%25s%25s",a.data[i].getCompanies()[0] + "," + a.data[i].getCompanies()[1
                                    ] + ","+ a.data[i].getCompanies()[2] , a.data[i].getApplicantName() ,
                                a.data[savenumber].getGPA() ,//
                                a.data[i].getCollege() , a.data[savenumber].getSkills()[0] + "," +
                                    a.data[savenumber].getSkills()[1] + "," + a.data[savenumber].getSkills()[2]);//


                }


            }


        } catch (NullPointerException b) {

        }

    }

    public Object clone() {     /*** This method creates a new Hiring Table object and clones each specific
                                        index from the main array into a test subject. It also clones the counter.
                                        By doing this no changes from the main hiring table will affect the copy.***/
        HiringTable test1 = new HiringTable();
        try {
            for (int i = MAX_APPLICANT -1; i > MAX_APPLICANT - counter -1 ; i--) {
                test1.getData()[i] = (Applicant) getData()[i].clone();
            }

        } catch (NullPointerException a) {
        }
        test1.counter = counter;
        return test1;
    }



    public boolean equals(Object obj) {  /*** The equals method first checks if the object given is an instance of the
                                            hiring table, if it is not then its automatically false. Then
                                            the program checks to see the backup object is equal to the main hiring table.
                                            If everything passes the method returns true. ***/
        try{
        if (!(obj instanceof HiringTable)) {
            return false;
        }

        HiringTable newcopy = (HiringTable) obj;

        for (int i = MAX_APPLICANT - counter3; i > MAX_APPLICANT - counter; i--) {
            if (!data[i].equals(newcopy.data[i])) {
                return false;
            }
        }}catch (ArrayIndexOutOfBoundsException a){}
        return true;



    }}





