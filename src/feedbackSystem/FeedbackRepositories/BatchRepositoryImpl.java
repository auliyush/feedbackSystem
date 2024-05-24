package feedbackSystem.FeedbackRepositories;

import feedbackSystem.FeedbackModels.Batch;

import java.util.ArrayList;
import java.util.List;

public class BatchRepositoryImpl implements BatchRepository{

    private List<Batch> mainBatchList = new ArrayList<>();

    @Override
    public Batch findBatch(String batchName) {
        for(Batch i : mainBatchList){
            if (i.getBatchName().equals(batchName) ) {
                return i;
            }
        }
        return null;
    }

    @Override
    public Batch findBatchbyUserName(String userName) {
        for(Batch i : mainBatchList){
            if(i.getStudentName() == null || i.getStudentName().equals(null))
            {
            }
            else{
                if(i.getStudentName().equals(userName)){
                    return i;
                }
            }
        }
        return null;
    }

    @Override
    public Batch findBatchbyAdminName(String adminName) {
        for(Batch i : mainBatchList){
            if(i.getAdminName() == null || i.getAdminName().equals(null))
            {
            }
            else{
                if(i.getAdminName().equals(adminName)){
                    return i;
                }
            }
        }
        return null;
    }

    @Override
    public List<Batch> checkAdminofBatch() {
        return mainBatchList;
    }

    @Override
    public List<Batch> fetchBatchStudentList(String batchName) {
       return mainBatchList;
    }

    @Override
    public String addBatch(Batch newBatch) {
        mainBatchList.add(newBatch);
        return "Batch created ";
    }
}
