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

    /***
     *
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
