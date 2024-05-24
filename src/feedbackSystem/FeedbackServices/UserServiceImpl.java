package feedbackSystem.FeedbackServices;

import feedbackSystem.FeedbackModels.StudentClass;
import feedbackSystem.FeedbackRepositories.UserRepositoryImpl;

public class UserServiceImpl implements UserService{
    UserRepositoryImpl userRepositoryObj = new UserRepositoryImpl();
    public boolean signup(String userName, String userMobNo, String userRole) {
        StudentClass newUser = new StudentClass(userName,userMobNo,userRole);
       boolean returnValue = userRepositoryObj.saveUser(newUser);
        System.out.println(returnValue);
        return returnValue;
    }
    public StudentClass fetchUserName(String userName){
        return userRepositoryObj.fetchUserName(userName);
    }

    @Override
    public StudentClass fetchbyUserMobNo(String studentMobno) {
        return userRepositoryObj.fetchUserMobNo(studentMobno);
    }
}
