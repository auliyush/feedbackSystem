package feedbackSystem.FeedbackServices;

import feedbackSystem.FeedbackModels.Batch;
import feedbackSystem.FeedbackModels.StudentClass;
import feedbackSystem.FeedbackRepositories.BatchRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class BatchServicesImpl implements BatchServices{

    BatchRepositoryImpl batchRepositoryObj = new BatchRepositoryImpl();

    @Override
    public boolean assignBatch(String adminUserName, String studentName, String studentMobNo, String batch, UserServiceImpl userServiceObj) {
        StudentClass returnAdminUserValue = userServiceObj.fetchUserName(adminUserName);
        if(returnAdminUserValue!=null){
            if(returnAdminUserValue.getUserRole().equals("Admin") || returnAdminUserValue.getUserRole().equals("admin")){
                StudentClass returnUser = userServiceObj.fetchUserName(studentName);
                if(returnUser != null){
                    if(returnUser.getUsertMobNo().equals(studentMobNo)) {
                        if (returnUser.getUserRole().equals("student") || returnUser.getUserRole().equals("Student")) {
                            Batch returnBatchValue = findBatch(batch);
                            if (returnBatchValue != null) {
                                Batch newStudentAssign = new Batch(batch, studentName);
                                batchRepositoryObj.addBatch(newStudentAssign);
                                System.out.println(studentName + " Assigned in "+batch);
                                return true;
                            } else {
                                System.out.println(batch+" Batch does not exist");
                            }
                        } else {
                            System.out.println("This is an admin therefore it can not be assign in any batch");
                        }
                    }else{
                        System.out.println(studentName+" mobile number does'nt match");
                    }
                }else{
                    System.out.println("The student is not present");
                }

            }else{
                System.out.println("This user is not an admin");
            }
        }else {
            System.out.println("The admin is not present");
        }

        return false;
    }

    @Override
    public boolean createBatch(UserServiceImpl userServiceObj, String adminName, String batchName ,
                               QuestionServiceImpl userQuestionServiceObj) {
        StudentClass userNameValue = userServiceObj.fetchUserName(adminName);
        if(userNameValue != null){
            if(userNameValue.getUserRole().equals("Admin") || userNameValue.getUserRole().equals("admin")){
                Batch returnBatchValue = batchRepositoryObj.findBatch(batchName);
                if(returnBatchValue == null){
                    Batch newBatch = new Batch(adminName,batchName,true);
                    System.out.println(batchRepositoryObj.addBatch(newBatch));
                    userQuestionServiceObj.setDefaultQuestion(batchName);
                }
                else{
                    System.out.println("Batch already exists");
                }
            }
            else{
                System.out.println("User are not Admin");
            }
        }
        else{
            System.out.println("User are not Exists");
        }
        return false;
    }

    @Override
    public Batch checkAdminofBatch(String adminName) {
        List<Batch> returnBatch = batchRepositoryObj.checkAdminofBatch();
        for(Batch i : returnBatch){
            if(i.getAdminName().equals(adminName))
            {
                return i;
            }
        }
        return null;
    }

    @Override
    public Batch findBatch(String batchName){
        return batchRepositoryObj.findBatch(batchName);
    }

    @Override
    public Batch findBatchbyUserName(String userName) {
        return  batchRepositoryObj.findBatchbyUserName(userName);
    }

    @Override
    public Batch findBatchbyAdminName(String adminName) {
        return  batchRepositoryObj.findBatchbyAdminName(adminName);    }

    @Override
    public List<Batch> getBatchList(String batchName) {
        List<Batch> returnList =  batchRepositoryObj.fetchBatchStudentList(batchName);
        for(Batch i : returnList){
            if(i.getBatchName().equals(batchName)){
                return returnList;
            }
        }
        return null;
    }

    @Override
    public boolean showBatchStudents(String adminName , String batchName,UserServiceImpl userServiceObj) {
        StudentClass returnUserValue = userServiceObj.fetchUserName(adminName);
        if(returnUserValue != null){
            if(returnUserValue.getUserRole().equals("Admin") || returnUserValue.getUserRole().equals("admin")){
                Batch returnBatchValue = batchRepositoryObj.findBatch(batchName);
                if(returnBatchValue != null){
                    List<Batch> fetchedStudentList = batchRepositoryObj.fetchBatchStudentList(batchName);
                    for(Batch i : fetchedStudentList){
                        if(i.getBatchName().equals(batchName) && i.getStudentName() != null){
                            System.out.println(i.getStudentName());
                        }
                    }
                    return true;
                }
                else {
                    System.out.println("Batch not exists");
                }
            }else{
                System.out.println("User is not an admin");
            }
        }else{
            System.out.println("Admin is not exists");
        }

        return false;
    }

}
