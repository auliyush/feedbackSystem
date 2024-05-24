package feedbackSystem.FeedbackRepositories;

import feedbackSystem.FeedbackModels.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository{
    private List<Question> questionsList = new ArrayList<>();
    private List<Question> questiosAnswersList = new ArrayList<>();
    @Override
    public Question addNewQuestion(Question newQuestionadd) {
        questionsList.add(newQuestionadd);
        return newQuestionadd;
    }

    @Override
    public Question findQuestionId(String questionId ,String batchName) {
        for(Question i : questionsList){
            if(i.getQuestionId().equals(questionId) && i.getBatchName().equals(batchName)){
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Question> getAllBatchesList(String btchName) {
        for(Question i: questionsList){
            if(i.getBatchName().equals(btchName)){
                return questionsList;
            }
        }
        return null;
    }

    @Override
    public String deleteFeedbackQuestion(String batchName, String takeQuestionId) {
        for(Question i : questionsList){
            if(i.getBatchName().equals(batchName) && i.getQuestionId().equals(takeQuestionId)){
                questionsList.remove(i);
                return "Question Deleted";
            }
        }
        return null;
    }

    @Override
    public void deleteAnswersOfDeletedQuestion(String batchName, String takeQuestionId) {
        for(Question i : questiosAnswersList){
            if(i.getBatchName().equals(batchName) && i.getQuestionId().equals(takeQuestionId)){
                questiosAnswersList.remove(i);
            }
        }
    }

    @Override
    public Question saveAnswersFromUser(Question questionAnswersFromUSer) {
       questiosAnswersList.add(questionAnswersFromUSer);
       return questionAnswersFromUSer;
    }

    @Override
    public List<Question> fetchOneStudentAnswerList(String batchName, String studentMobNo) {
        return questiosAnswersList;
    }

    @Override
    public List<Question> getAllAnswerOfBatch(String batchName) {
        for(Question i : questiosAnswersList){
            if(i.getBatchName().equals(batchName) && i.getQuestionsAnswer() != null){
                return questiosAnswersList;
            }
        }
        return null;
    }
}
