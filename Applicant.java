//Angkan BAIDYA
//112309655
//RECITATION 01

public class Applicant { /***This class contains all the variables used for the Applicant object such as
                            GPA,college, and the skills and companies arrays***/
    private String ApplicantName;
    private double GPA;
    private String College;
    private String[] Skills;
    private String[] Companies;



    public Applicant(String[] Company, String ApplicantName,double GPA, String College, String[] sKILLS){
        /*** this method instantiates all the variables for the applicant object***/
        this.ApplicantName = ApplicantName;
        this.GPA = GPA;
        this.College = College;
        Companies = Company;
        Skills = sKILLS;
             }

    public String getApplicantName() { /*** This method gets the applicant name***/
        return ApplicantName;
    }

    public double getGPA() {        /*** This method gets the applicant GPA***/
        return GPA;
    }

    public String getCollege() { /*** This method gets the applicant college.***/
        return College;
    }



    public void setApplicantName(String applicantName) { /*** This method sets the applicant name***/
        ApplicantName = applicantName;
    }

    public void setCollege(String college) {        /*** This method sets the applicant college***/
        College = college;
    }

    public void setGPA(double GPA) {            /*** This method sets the applicant GPA***/
        this.GPA = GPA;
    }

    public String[] getCompanies() {            /*** This method gets the applicant companies***/
        return Companies;
    }

    public String[] getSkills() {           /*** This method gets the applicant skills***/
        return Skills;
    }








    public String toString(){ /*** The two strings displays all the different components of an applicant into a string***/
        return (Companies[0] + "," + Companies[1] + "," + Companies[2] + "," + ApplicantName + "," + GPA + ","
                + College + ","+ Skills[0] + "," + Skills[1] +  "," + Skills[2]);

    }



    public Object clone( ){ /*** For the clone method, it creates a brand new test applicant for cloning***/
        Applicant new1 = new Applicant(getCompanies(),getApplicantName(),getGPA(),getCollege(),getSkills());
        return new1;
    }



    public boolean equals(Object obj){/*** The equals method compares the backup copy to the true applicants and
     returns a boolean if they are the same.***/
        try {
            boolean flag = false;

            if (!(obj instanceof Applicant)) {

                return false;

            }

            Applicant newcopy = (Applicant) obj;

            if (!newcopy.getApplicantName().equals(ApplicantName)) {
                return false;
            }

            if (!newcopy.getCollege().equals(getCollege())) {

                return false;
            }

            if (newcopy.getGPA() != (getGPA())) {

                return false;
            }

            for (int i = 0; i < HiringTable.MAX_COMPANIES; i++) {
                if (!newcopy.getCompanies()[i].equals(this.Companies[i])) {


                    return false;
                }
            }

            for (int i = 0; i < HiringTable.MAX_SKILLS; i++) {
                if (!newcopy.getSkills()[i].equals(this.Skills[i])) {
                    return false;
                }
            }

        } catch (NullPointerException a){}
        return true;
    }

}
