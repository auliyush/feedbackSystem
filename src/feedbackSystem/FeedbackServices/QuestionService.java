package feedbackSystem.FeedbackServices;

public interface QuestionService {
    void createQuestion(String adminName, String batchName, BatchServicesImpl userBatchServiceObj,UserServiceImpl userServiceObj);

    void editFeedbackQuestion(String adminName, String batchName,BatchServicesImpl userBatchServiceObj,UserServiceImpl userServiceObj);

    void printAllQuestionOfBatch(String userName, String batchName, BatchServicesImpl userBatchServiceObj, UserServiceImpl userServiceObj);

    void deleteQuestion(String adminName, String batchName, BatchServicesImpl userBatchServiceObj,UserServiceImpl userServiceObj);

    void setDefaultQuestion(String batchName);

    void askQuestionsFromUser(String userName, String batchName, String userMobNo, UserServiceImpl userServiceObj, BatchServicesImpl userBatchServiceObj);

    void showOneStudentAnswerList(String adminName, String studentName, String batchName, String studentMobNo, UserServiceImpl userServiceObj, BatchServicesImpl userBatchServiceObj);

    void answerListBatchWise(String adminName, String batchName, UserServiceImpl userServiceObj, BatchServicesImpl userBatchServiceObj);
}
