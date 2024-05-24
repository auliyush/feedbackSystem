package feedbackSystem.FeedbackModels;

import feedbackSystem.Controller.Controller;

public class ClientClass {
    public static void main(String[] args) {
        Controller obj = new Controller();

//        signup
        System.out.println(obj.signup("ayush","9939180672","Admin"));

//        Batch assign
        obj.createBatch("ayush","Cage1");
    }
}
