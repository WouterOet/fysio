package oet.wouter.fysio;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class Data {

    private Map<Integer, Question> questions;
    private Map<Integer, Solution> solutions;

    @PostConstruct
    private void init() {
        questions = map(List.of(
                new Question(1, "Does your head hurt", List.of(
                        new Answer(1, "Yes", -1),
                        new Answer(2, "No", 2)
                )),
                new Question(2, "Did you bang your left small toe?", List.of(
                        new Answer(3, "Yes", -2),
                        new Answer(4, "No", 3)
                        )),
                new Question(3, "Does your upper or lower body hurt?", List.of(
                        new Answer(5, "Upper", -3),
                        new Answer(6, "Lower", -3)
                ))
        ), Question::getId);

        solutions = map(List.of(
                new Solution(-1, "See a psych"),
                new Solution(-2, "That wasn't the smartest thing do to was it. You'll be fine."),
                new Solution(-3, "Boy, that sounds complicated. See a professional")
        ), Solution::getId);
    }

    private <T> Map<Integer, T> map(List<T> items, Function<T, Integer> id) {
        return items
                .stream()
                .collect(Collectors.toMap(id, Function.identity()));
    }

    public Question getQuestion(int id) {
        return questions.get(id);
    }

    public Solution getSolution(int id) {
        return solutions.get(id);
    }
}
