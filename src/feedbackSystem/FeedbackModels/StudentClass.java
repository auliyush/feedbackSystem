package feedbackSystem.FeedbackModels;

public class StudentClass {
    private String UserName;
    private String UserMobNo;
    private String UserRole;

    public StudentClass(String userName, String userMobNo, String userRole) {
        UserName = userName;
        UserMobNo = userMobNo;
        UserRole = userRole;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUsertMobNo() {
        return UserMobNo;
    }

    public void setUsertMobNo(String usertMobNo) {
        UserMobNo = usertMobNo;
    }

    public String getUserRole() {
        return UserRole;
    }

    public void setUserRole(String userRole) {
        UserRole = userRole;
    }
}
