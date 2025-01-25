package ceagms;

public class Course {

    private String name;
    private String code;
    private int maximumCapacity = 20;
    private int count = 0;
    private static int enrolledStudent = 0;

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
        count++;
    }

    public Course(String code) {
        this.code = code;
        this.name = "undefined";
        count++;
    }

    public String getName() {
        if (this.name.equals("undefined")) {
            return "Please update the course name!";
        }
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMaximumCapacity() {
        return this.maximumCapacity;
    }

    public void setMaximumCapacity(int maxCapacity) {
        this.maximumCapacity = maxCapacity;
    }

    public int getCount() {
        return this.count;
    }
    
    public static int getEnrolledStudent() {
        return enrolledStudent;
    }

    public void newEnrolledStudent() {
        enrolledStudent++;
        this.count++;
    }
}
