public class StudentInfo {
    private String name;
    private int age;
    private String student_ID;
    private String gender;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudent_ID() {
        return student_ID;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudent_ID(String student_ID) {
        this.student_ID = student_ID;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /***
     * @param _name
     * @param _age
     * @param _student_ID
     * @param _male
     */

    public StudentInfo(String _name, int _age, String _student_ID, String _gender) {
        name = _name;
        age = _age;
        student_ID = _student_ID;
        gender = _gender;
    }
}
