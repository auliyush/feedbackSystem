package feedbackSystem.FeedbackRepositories;

import feedbackSystem.FeedbackModels.Question;

import java.util.List;

public interface QuestionRepository {
    Question addNewQuestion(Question newQuestionadd);

    Question findQuestionId(String questionId , String batchName);

    List<Question> getAllBatchesList(String btchName);

    String deleteFeedbackQuestion(String batchName, String takeQuestionId);
    Question saveAnswersFromUser(Question questionAnswersFromUSer);

    List<Question> fetchOneStudentAnswerList(String batchName, String studentMobNo);

    List<Question> getAllAnswerOfBatch(String batchName);

    void deleteAnswersOfDeletedQuestion(String batchName, String takeQuestionId);
}
