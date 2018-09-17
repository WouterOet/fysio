package oet.wouter.fysio;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class FysioEndpoint {

    private final Data data;

    public FysioEndpoint(Data data) {
        this.data = data;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<Question> start() {
        return ResponseEntity.ok(data.getQuestion(1));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{question}/{answer}")
    public ResponseEntity answer(@PathVariable("question") int questionId, @PathVariable("answer") int answerId) {
        Optional<Answer> answer = data.getQuestion(questionId)
                .getAnswers()
                .stream()
                .filter(a -> a.getId() == answerId)
                .findAny();

        if(answer.isPresent()) {
            int next = answer.get().getNext();
            if (next < 0) {
                return ResponseEntity.ok(data.getSolution(next));
            } else {
                return ResponseEntity.ok(data.getQuestion(next));
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
