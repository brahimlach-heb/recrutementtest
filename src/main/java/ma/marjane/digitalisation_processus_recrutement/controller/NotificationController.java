package ma.marjane.digitalisation_processus_recrutement.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.marjane.digitalisation_processus_recrutement.dto.NotificationDto;
import ma.marjane.digitalisation_processus_recrutement.service.impl.NotificationServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationServiceImp notificationService;

    @GetMapping
    public ResponseEntity<List<NotificationDto>> getAllNotifications() {
        List<NotificationDto> notifications = notificationService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDto> getNotificationById(@PathVariable UUID id) {
        return notificationService.findById(id)
                .map(notificationDto -> ResponseEntity.status(HttpStatus.OK).body(notificationDto))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<NotificationDto> createNotification(@Valid @RequestBody NotificationDto notificationDto) {
        NotificationDto createdNotificationDto = notificationService.save(notificationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNotificationDto);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<NotificationDto> updateNotification(@Valid @RequestBody NotificationDto notificationDto) {
//        NotificationDto updatedNotificationDto = notificationService.update(notificationDto);
//        return ResponseEntity.status(HttpStatus.OK).body(updatedNotificationDto);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable UUID id) {
        notificationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
