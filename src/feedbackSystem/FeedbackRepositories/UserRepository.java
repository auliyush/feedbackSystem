package feedbackSystem.FeedbackRepositories;

import feedbackSystem.FeedbackModels.StudentClass;

public interface UserRepository {
    boolean saveUser(StudentClass user);

    StudentClass fetchUserName(String userName);


    StudentClass fetchUserMobNo(String studentMobno);
}
