package email;

import email.model.Feedback;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    public void saveFeedback(Feedback feedback) {

        System.out.println("Feedback received: " + feedback);
    }
}
