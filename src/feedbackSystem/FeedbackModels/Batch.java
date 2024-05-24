package feedbackSystem.FeedbackModels;

public class Batch {
    private String batchName;

    private String studentName;
    private String adminName;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Batch(String adminName ,String batchName,boolean value) {
        this.adminName = adminName;
        this.batchName = batchName;
    }

    public Batch(String batchName, String studentName) {
        this.batchName = batchName;
        this.studentName = studentName;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }



    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
