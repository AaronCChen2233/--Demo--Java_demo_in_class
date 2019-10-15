public class StudentInfoTest {
    public static void main(String[] args) {
        StudentInfo studentInfo = new StudentInfo("Autumn Fall", 25, "CS180430", "Male");
        System.out.println("Name: " + studentInfo.getName());
        System.out.println("Age: " + studentInfo.getAge());
        System.out.println("Student ID: " + studentInfo.getStudent_ID());
        System.out.println("Gender: " + studentInfo.getGender());
    }
}
