package feedbackSystem.FeedbackRepositories;

import feedbackSystem.FeedbackModels.StudentClass;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{

    private List<StudentClass> studentsData = new ArrayList<>();


    @Override
    public StudentClass fetchUserName(String userName) {
        for(StudentClass i : studentsData){
            if(i.getUserName().equals(userName)){
                return i;
            }
        }
        return null;
    }

    public boolean saveUser(StudentClass user) {
        return studentsData.add(user);
    }

    @Override
    public StudentClass fetchUserMobNo(String studentMobno) {
        for(StudentClass i : studentsData){
            if(i.getUsertMobNo().equals(studentMobno)){
                return i;
            }
        }
       return null;
    }
}
