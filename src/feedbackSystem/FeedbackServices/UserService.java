package feedbackSystem.FeedbackServices;

import feedbackSystem.FeedbackModels.StudentClass;

public interface UserService {
     boolean signup(String userName, String userMobNo, String userRole);
     StudentClass fetchUserName(String userName);

    StudentClass fetchbyUserMobNo(String studentMobno);
}
