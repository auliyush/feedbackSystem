package feedbackSystem.FeedbackModels;

public class Question {
    private String question;
    private String questionId;

    public Question( String batchName, String question, String questionId) {
        this.question = question;
        this.questionId = questionId;
        this.batchName = batchName;
    }

    private String batchName;
    private String QuestionsAnswer;
    private String studentMobno;

    public Question(String questionsAnswer, String studentMobno, String batchName,String questionId) {
        QuestionsAnswer = questionsAnswer;
        this.studentMobno = studentMobno;
        this.batchName = batchName;

    }

    public String getStudentMobno() {
        return studentMobno;
    }

    public void setStudentMobno(String studentMobno) {
        this.studentMobno = studentMobno;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionsAnswer() {
        return QuestionsAnswer;
    }

    public void setQuestionsAnswer(String questionsAnswer) {
        QuestionsAnswer = questionsAnswer;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }
}
