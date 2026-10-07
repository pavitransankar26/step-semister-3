abstract class Question {
    String question;
    int marks;

    Question(String question, int marks) {
        this.question = question;
        this.marks = marks;
    }

    abstract boolean evaluate(String answer);
}

class MultipleChoiceQuestion extends Question {
    String correctAnswer;

    MultipleChoiceQuestion(String question, int marks, String correctAnswer) {
        super(question, marks);
        this.correctAnswer = correctAnswer;
    }

    boolean evaluate(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}

class TrueFalseQuestion extends Question {
    boolean correctAnswer;

    TrueFalseQuestion(String question, int marks, boolean correctAnswer) {
        super(question, marks);
        this.correctAnswer = correctAnswer;
    }

    boolean evaluate(String answer) {
        return Boolean.parseBoolean(answer) == correctAnswer;
    }
}

class Attempt {
    String student;
    boolean submitted = false;

    Attempt(String student) {
        this.student = student;
    }

    void answerQuestion(Question q, String answer) {
        if (submitted) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }

        boolean correct = q.evaluate(answer);

        if (correct)
            System.out.println("Answer recorded. Correct (" + q.marks + " points)");
        else
            System.out.println("Answer recorded. Incorrect (0 points)");
    }

    void submit() {
        submitted = true;
        System.out.println("Exam submitted by " + student + ".");
    }
}

public class PracticeQuestion3 {
    public static void main(String[] args) {

        Question q1 = new MultipleChoiceQuestion(
                "Question 1", 5, "C");

        Question q2 = new TrueFalseQuestion(
                "Question 2", 5, false);

        Attempt attempt = new Attempt("Student 1");

        System.out.println("Exam started by Student 1.");

        attempt.answerQuestion(q1, "C");
        attempt.answerQuestion(q2, "True");

        attempt.submit();

        attempt.answerQuestion(q1, "B");
    }
}
