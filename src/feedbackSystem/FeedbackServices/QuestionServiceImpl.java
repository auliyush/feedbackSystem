package feedbackSystem.FeedbackServices;

import feedbackSystem.FeedbackModels.Batch;
import feedbackSystem.FeedbackModels.Question;
import feedbackSystem.FeedbackModels.StudentClass;
import feedbackSystem.FeedbackRepositories.QuestionRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class QuestionServiceImpl implements QuestionService {
    QuestionRepositoryImpl userQuestionRepositoryObj = new QuestionRepositoryImpl();
    Scanner sc = new Scanner(System.in);

    @Override
    public void setDefaultQuestion(String batchName) {
        Question defaultQuestion = new Question(batchName, "Do you have any doubt of today's class", "1");
        userQuestionRepositoryObj.addNewQuestion(defaultQuestion);
        defaultQuestion = new Question(batchName, "How much you rate for today Class", "2");
        userQuestionRepositoryObj.addNewQuestion(defaultQuestion);
        defaultQuestion = new Question(batchName, "can you understand everything which our faculty trying" +
                " to understand you", "3");
        userQuestionRepositoryObj.addNewQuestion(defaultQuestion);
    }

    @Override
    public void createQuestion(String adminName, String batchName, BatchServicesImpl userBatchServiceObj
            , UserServiceImpl userServiceObj) {
        StudentClass returnUserValue = userServiceObj.fetchUserName(adminName);
        if (returnUserValue != null) {
            if (returnUserValue.getUserRole().equals("admin") || returnUserValue.getUserRole().equals("Admin")) {
                Batch returnBatchName = userBatchServiceObj.findBatch(batchName);
                if (returnBatchName != null) {
                    returnBatchName = userBatchServiceObj.findBatchbyAdminName(adminName);
                    if(returnBatchName != null && returnBatchName.getBatchName().equals(batchName)){
                        System.out.println("Enter Question Number , first 3 already add you should start question no 4");
                        String questionId = sc.nextLine();
                        System.out.println("Type your QUESTION");
                        String question = sc.nextLine();
                        Question newQuestionadd = new Question(batchName, question, questionId);
                        userQuestionRepositoryObj.addNewQuestion(newQuestionadd);
                    }else {
                        System.out.println(adminName + " is not admin of "+batchName+" they cannot create question");
                    }
                } else {
                    System.out.println("Batch is not exists");
                }
            } else {
                System.out.println("User is not an Admin");
            }
        } else {
            System.out.println("Admin are not exists");
        }

    }

    @Override
    public void editFeedbackQuestion(String adminName, String batchName, BatchServicesImpl userBatchServiceObj
            , UserServiceImpl userServiceObj) {

        StudentClass returnUserValue = userServiceObj.fetchUserName(adminName);
        if (returnUserValue != null) {
            if (returnUserValue.getUserRole().equals("admin") || returnUserValue.getUserRole().equals("Admin")) {
                Batch returnBatchName = userBatchServiceObj.findBatch(batchName);
                if (returnBatchName != null) {
                  Batch returnValue = userBatchServiceObj.checkAdminofBatch(adminName);
                  if(returnValue.getBatchName().equals(batchName)){
                      System.out.println("Enter Question Id for "+batchName);
                      String questionId = sc.nextLine();
                      Question returnQuestionUserValue = userQuestionRepositoryObj.findQuestionId(questionId , batchName);
                      if (returnQuestionUserValue != null) {
                          System.out.println("Edit QUESTION");
                          String editQuestion = sc.nextLine();
                          returnQuestionUserValue.setQuestion(editQuestion);
                      } else {
                          System.out.println("Question Id is not Match of "+batchName+" Batch");
                      }
                  }else{
                      System.out.println(adminName + " is not admin of "+batchName+" Batch they can't edit");
                  }
                } else {
                    System.out.println("Batch is not Exists");
                    return;
                }
            } else {
                System.out.println("User is not admin");
                return;
            }
        } else {
            System.out.println("Admin is not Exists");
            return;
        }
    }

    @Override
    public void printAllQuestionOfBatch(String userName, String batchName, BatchServicesImpl userBatchServiceObj, UserServiceImpl userServiceObj) {
        StudentClass returnUserValue = userServiceObj.fetchUserName(userName);
        if (returnUserValue != null) {
             Batch returnBatchValue = userBatchServiceObj.findBatch(batchName);
             if(returnBatchValue != null){
                 if(returnBatchValue.getBatchName().equals(batchName)){
                     Batch returnvalue = userBatchServiceObj.findBatchbyUserName(userName);
                     if(returnvalue != null && returnvalue.getBatchName().equals(batchName)){
                         List<Question> listQuestionList =  userQuestionRepositoryObj.getAllBatchesList(batchName);
                         for(Question i : listQuestionList){
                             if(i.getBatchName().equals(batchName)){
                                 System.out.println(i.getQuestionId()+"  "+i.getQuestion());
                             }
                         }
                     }else{
                         System.out.println(userName + " is not in "+batchName+" so they can't see Questions");
                     }
                 }else{
                     System.out.println(userName+" is not in "+batchName);
                 }
             }else{
                 System.out.println(userName+" is not exits in any batches");
             }
        } else {
            System.out.println("User are not Exists");
        }
    }

    @Override
    public void deleteQuestion(String adminName, String batchName, BatchServicesImpl userBatchServiceObj,
                               UserServiceImpl userServiceObj) {
        StudentClass returnUserValue = userServiceObj.fetchUserName(adminName);
        if (returnUserValue != null) {
            if (returnUserValue.getUserRole().equals("admin") || returnUserValue.getUserRole().equals("Admin")) {
                Batch returnBatchUserValue = userBatchServiceObj.findBatch(batchName);
                if (returnBatchUserValue != null) {
                    returnBatchUserValue = userBatchServiceObj.findBatchbyAdminName(adminName);
                    if(returnBatchUserValue != null && returnBatchUserValue.getBatchName().equals(batchName)){
                        System.out.println("Enter Question Id which you want to delete it");
                        String takeQuestionId = sc.nextLine();
                        String returnValue = userQuestionRepositoryObj.deleteFeedbackQuestion(batchName, takeQuestionId);
                        System.out.println(returnValue);
                        userQuestionRepositoryObj.deleteAnswersOfDeletedQuestion(batchName,takeQuestionId);
                    }else{
                        System.out.println(adminName + " is not admin of "+batchName+" so they can't delete Questions");

                    }
                } else {
                    System.out.println("Batch is not available");
                }
            } else {
                System.out.println("You are Student, You can't delete Questions");
            }
        } else {
            System.out.println("User not Found");
        }
    }

    @Override
    public void askQuestionsFromUser(String userName, String batchName, String userMobNo, UserServiceImpl userServiceObj,
                                     BatchServicesImpl userBatchServiceObj) {
        StudentClass returnUserValue = userServiceObj.fetchUserName(userName);
        if (returnUserValue != null) {
            if (returnUserValue.getUsertMobNo().equals(userMobNo)) {
                Batch returnBatchValue = userBatchServiceObj.findBatch(batchName);
                if (returnBatchValue != null) {
                        returnBatchValue = userBatchServiceObj.findBatchbyUserName(userName);
                        if(returnBatchValue != null && returnBatchValue.getBatchName().equals(batchName)){
                            List<Question> returnList = userQuestionRepositoryObj.getAllBatchesList(batchName);
                            for (Question i : returnList) {
                                if (i.getBatchName().equals(batchName) && i.getQuestion() != null) {
                                    System.out.println(i.getQuestionId() + " " + i.getQuestion());
                                    String usersAnswer = sc.nextLine();
                                    Question addAnswers = new Question(usersAnswer, userMobNo, batchName, null);
                                    userQuestionRepositoryObj.saveAnswersFromUser(addAnswers);
                                }
                            }
                        }else{
                            System.out.println("Student not exists in batch "+batchName);
                        }
                } else {
                    System.out.println("Batch not exists");
                }
            } else {
                System.out.println("Mobile number not matched");
            }
        } else {
            System.out.println("User not exists");
        }
    }

    @Override
    public void showOneStudentAnswerList(String adminName, String studentName, String batchName, String studentMobNo
            , UserServiceImpl userServiceObj, BatchServicesImpl userBatchServiceObj) {
        StudentClass returnAdminUserValue = userServiceObj.fetchUserName(adminName);
        if (returnAdminUserValue != null) {
            if (returnAdminUserValue.getUserRole().equals("admin") || returnAdminUserValue.getUserRole().equals("Admin")) {
                StudentClass returnStudentUserValue = userServiceObj.fetchUserName(studentName);
                if (returnStudentUserValue != null) {
                    if (returnStudentUserValue.getUserRole().equals("student") || returnStudentUserValue.getUserRole().equals("Student")) {
                        Batch returnBatchValue = userBatchServiceObj.findBatchbyUserName(studentName);
                        if (returnBatchValue != null) {
                            if (returnBatchValue.getBatchName().equals(batchName)) {
                                if (returnStudentUserValue.getUsertMobNo().equals(studentMobNo)) {
                                    List<Question> retrunAnswerList = userQuestionRepositoryObj.getAllAnswerOfBatch(batchName);
                                    try {
                                        for (Question i : retrunAnswerList) {
                                            if (i.getStudentMobno().equals(studentMobNo) && i.getBatchName().equals(batchName)) {
                                                System.out.println(returnStudentUserValue.getUserName() + " : " + i.getQuestionsAnswer());
                                            }
                                        }
                                    }
                                    catch (NullPointerException nullpointreexception){
                                        System.out.println(studentName +" Does not feed any feedback questions");
                                    }
                                }else{
                                    System.out.println("Mobile Number not match");
                                }
                            }else{
                                System.out.println("Batch Name does Not match");
                            }
                        }else{
                            System.out.println(studentName+" is not Assigned in any Batch");
                        }
                    }else{
                        System.out.println(studentName+" is not a student");
                    }
                }else{
                    System.out.println(studentName+" does not Exists");
                }
            }else{
                System.out.println(adminName+" is Not an ADMIN");
            }
        }else {
            System.out.println(adminName+" is Not Exists");
        }
    }

    @Override
    public void answerListBatchWise(String adminName, String batchName, UserServiceImpl userServiceObj,
                                    BatchServicesImpl userBatchServiceObj) {
        StudentClass returnAdminUserValue = userServiceObj.fetchUserName(adminName);
        if (returnAdminUserValue != null) {
            if (returnAdminUserValue.getUserRole().equals("admin") || returnAdminUserValue.getUserRole().equals("Admin")) {
                List<Question> retrunAnswerList = userQuestionRepositoryObj.getAllAnswerOfBatch(batchName);
                if (retrunAnswerList != null) {
                    for (Question i : retrunAnswerList) {
                        StudentClass returnStudentUserValue = userServiceObj.fetchbyUserMobNo(i.getStudentMobno());
                        System.out.println(returnStudentUserValue.getUserName()+ " : "+i.getQuestionsAnswer());
                    }
                }else{
                    System.out.println("No one feed feedback questions");
                }
            }else{
                System.out.println("User is not admin");
            }
        }else{
            System.out.println("Admin user are not exists");
        }
    }
}


