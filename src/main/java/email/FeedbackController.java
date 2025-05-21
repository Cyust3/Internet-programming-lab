package email.service;
import email.FeedbackService;
import email.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedback")
    public String showFeedbackForm() {
        return "feedback";
    }

    @PostMapping("/feedback")
    public String sendFeedback(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String message,
                               Model model) {
        Feedback feedback = new Feedback();
        feedback.setName(name);
        feedback.setEmail(email);
        feedback.setMessage(message);

        feedbackService.saveFeedback(feedback);

        model.addAttribute("message", "Ваш отзыв был отправлен успешно!");
        return "thankYou";
    }
}
