package ma.marjane.digitalisation_processus_recrutement.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.marjane.digitalisation_processus_recrutement.dto.InterviewDto;
import ma.marjane.digitalisation_processus_recrutement.service.impl.InterviewServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/interviews")
public class InterviewController {

    private final InterviewServiceImp interviewService;

    @GetMapping
    public ResponseEntity<List<InterviewDto>> getAllInterviews() {
        List<InterviewDto> interviews = interviewService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(interviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterviewDto> getInterviewById(@PathVariable UUID id) {
        return interviewService.findById(id)
                .map(interviewDto -> ResponseEntity.status(HttpStatus.OK).body(interviewDto))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<InterviewDto> createInterview(@Valid @RequestBody InterviewDto interviewDto) {
        InterviewDto createdInterviewDto = interviewService.save(interviewDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInterviewDto);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<InterviewDto> updateInterview(@Valid @RequestBody InterviewDto interviewDto) {
//        InterviewDto updatedInterviewDto = interviewService.update(interviewDto);
//        return ResponseEntity.status(HttpStatus.OK).body(updatedInterviewDto);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterview(@PathVariable UUID id) {
        interviewService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
