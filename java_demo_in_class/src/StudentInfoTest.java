public class StudentInfoTest {
    public static void main(String[] args) {
        StudentInfo studentInfo = getStudentInfo();
        StudentInfo studentInfo2 = getStudentInfo();

        /*print*/
        System.out.println("Name: " + studentInfo.getName());
        System.out.println("Age: " + studentInfo.getAge());
        System.out.println("Student ID: " + studentInfo.getStudent_ID());
        System.out.println("Gender: " + studentInfo.getGender());
    }

    private static StudentInfo getStudentInfo() {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setAge(25);
        studentInfo.setGender("Male");
        studentInfo.setName("Autumn Fall");
        studentInfo.setStudent_ID("CS180430");
        return studentInfo;
    }
}
