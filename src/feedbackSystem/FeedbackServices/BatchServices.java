package feedbackSystem.FeedbackServices;

import feedbackSystem.FeedbackModels.Batch;

import java.util.List;

public interface BatchServices {
    boolean createBatch(UserServiceImpl userServiceObj, String adminName, String batchName,QuestionServiceImpl userQuestionServiceObj);

    boolean assignBatch(String adminUserName, String studentName, String studentMobNo, String batch, UserServiceImpl userServiceObj);

    Batch findBatch(String batchName);
    Batch findBatchbyUserName(String userName);

    boolean showBatchStudents(String adminName ,String batchName,UserServiceImpl userServiceObj);

    List<Batch> getBatchList(String batchName);

    Batch checkAdminofBatch(String adminName);

    Batch findBatchbyAdminName(String adminName);
}
