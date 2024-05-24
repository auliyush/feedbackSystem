package feedbackSystem.Controller;

import feedbackSystem.FeedbackModels.StudentClass;
import feedbackSystem.FeedbackServices.BatchServicesImpl;
import feedbackSystem.FeedbackServices.QuestionService;
import feedbackSystem.FeedbackServices.QuestionServiceImpl;
import feedbackSystem.FeedbackServices.UserServiceImpl;
public class Controller {
    UserServiceImpl userServiceObj = new UserServiceImpl();
    BatchServicesImpl userBatchServiceObj = new BatchServicesImpl();
    QuestionServiceImpl userQuestionServiceObj = new QuestionServiceImpl();
    public boolean signup(String userName, String userMobNo, String userRole) {
        return userServiceObj.signup(userName,userMobNo,userRole);
    }

    public boolean createBatch(String adminName, String batchName ) {
        return userBatchServiceObj.createBatch(userServiceObj ,adminName,batchName,userQuestionServiceObj);
    }

    public boolean assignBatch(String adminUserName , String studentName, String studentMobNo, String batch) {
        return userBatchServiceObj.assignBatch(adminUserName,studentName,studentMobNo,batch,userServiceObj);
    }

    public boolean showBatchStudents(String adminName ,String batchName) {
        return userBatchServiceObj.showBatchStudents(adminName,batchName,userServiceObj);
    }

    public void createFeedbackQuestion(String adminName, String batchName) {
        userQuestionServiceObj.createQuestion(adminName,batchName,userBatchServiceObj,userServiceObj);
    }

    public void editFeedbackQuestion(String adminName, String batchName) {
        userQuestionServiceObj.editFeedbackQuestion(adminName,batchName,userBatchServiceObj,userServiceObj);
    }

    public void printFeedbackQuestion(String userName, String batchName) {
        userQuestionServiceObj.printAllQuestionOfBatch(userName,batchName,userBatchServiceObj,userServiceObj);
    }

    public void deleteFeedbackQuestion(String adminName, String batchName) {
        userQuestionServiceObj.deleteQuestion(adminName,batchName,userBatchServiceObj,userServiceObj);
    }

    public void askQuestions(String userName, String batchName,String userMobNo) {
        userQuestionServiceObj.askQuestionsFromUser(userName,batchName,userMobNo,userServiceObj,userBatchServiceObj);
    }

    public void oneStudentAnswersList(String adminName, String studentName, String batchName, String studentMobNo) {
        userQuestionServiceObj.showOneStudentAnswerList(adminName,studentName,batchName,studentMobNo,userServiceObj,userBatchServiceObj);
    }

    public void answerListBatchWise(String adminName, String batchName) {
        userQuestionServiceObj.answerListBatchWise(adminName,batchName,userServiceObj,userBatchServiceObj);
    }
}
