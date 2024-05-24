package feedbackSystem.FeedbackModels;

import feedbackSystem.Controller.Controller;

public class Uiclient {
    public static void main(String[] args) {
        Controller user = new Controller();

//        Signup
        user.signup("Ayush","9939180672","Admin");
        user.signup("Aaka","99180672","Admin");
        user.signup("priya","991802","Admin");
        user.signup("kriti", "98967567", "student");
        user.signup("anshal", "98978067", "student");
        user.signup("kritika", "98346809", "student");
        user.signup("kruka", "98346", "student");

//        createBatch
        System.out.println();
        user.createBatch("Ayush","Cage1");
//        user.createBatch("Ayush","Cage1");
//        user.createBatch("Aaka","Cage5");
        user.createBatch("Aaka","Cage2");



//        AsssignBatch
        System.out.println("Assign Batch");
        user.assignBatch("Ayush","anshal", "98978067", "Cage1");
        user.assignBatch("Ayush", "kriti","98967567", "Cage1");
        user.assignBatch("Aaka", "kritika","98346809", "Cage2");
        user.assignBatch("Aaka", "kruka","98346", "Cage2");



//        ShowBatchStudents
        System.out.println();
//        user.showBatchStudents("Ayush","Cage1");
//        user.showBatchStudents("Ayush","Cage5");

//        CreateFeedbackQuestion
        System.out.println("Create Question");
        user.createFeedbackQuestion("Ayush","Cage1");
        user.createFeedbackQuestion("Ayush","Cage1");
        user.createFeedbackQuestion("Aaka","Cage2");  // same admin can not create question for another batch
        user.createFeedbackQuestion("Aaka","Cage2");

//        PrintFeedbackQuestion
        System.out.println();
//       user.printFeedbackQuestion("anshal","Cage14");

//        EditFeedbackQuestion
        System.out.println();
//        user.editFeedbackQuestion("Ayush","Cage5");
//        user.editFeedbackQuestion("priya","Cage5");
        user.createFeedbackQuestion("Ayush","Cage1");


//        PrintFeedbackQuestion
        System.out.println();
       user.printFeedbackQuestion("kritika","Cage1");


//        DeleteFeedbackQuestion
        System.out.println("delete Question");
        user.deleteFeedbackQuestion("Ayush","Cage1");// delete all answer after giving feedback
//        user.deleteFeedbackQuestion("Ayush","Cage1");// delete all answer after giving feedback
//        user.deleteFeedbackQuestion("Ayush","Cage5");// delete all answer after giving feedback

        user.editFeedbackQuestion("Ayush","Cage1");

        user.createFeedbackQuestion("Ayush","Cage1");

//        AskQuestionsFromStudents
        System.out.println();
        user.askQuestions("kriti","Cage1","98967567");
        user.askQuestions("kritika","Cage1","98346809");
        user.askQuestions("anshal","Cage1","98978067");
        user.askQuestions("kruka","Cage2","98346");


//        individualStudentAnsweeList
        System.out.println();
        user.oneStudentAnswersList("Ayush","kruka","Cage1","98346");

//        StudentAnswerListBatchWise
        System.out.println();
        user.answerListBatchWise("Ayush","Cage1");
    }
}
