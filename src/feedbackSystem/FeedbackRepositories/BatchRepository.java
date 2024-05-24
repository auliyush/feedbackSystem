package feedbackSystem.FeedbackRepositories;

import feedbackSystem.FeedbackModels.Batch;

import java.util.List;

public interface BatchRepository {


    String addBatch(Batch newBatch);

    Batch findBatch(String batchName);
    Batch findBatchbyUserName(String userName);

    List<Batch> fetchBatchStudentList(String batchName);

    List<Batch> checkAdminofBatch();

    Batch findBatchbyAdminName(String adminName);
}
