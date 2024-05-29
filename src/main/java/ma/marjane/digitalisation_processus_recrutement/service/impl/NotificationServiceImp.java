package ma.marjane.digitalisation_processus_recrutement.service.impl;

import lombok.RequiredArgsConstructor;
import ma.marjane.digitalisation_processus_recrutement.dto.NotificationDto;
import ma.marjane.digitalisation_processus_recrutement.entity.Notification;
import ma.marjane.digitalisation_processus_recrutement.mapper.impl.NotificationMapperImpl;
import ma.marjane.digitalisation_processus_recrutement.repository.NotificationRepository;
import ma.marjane.digitalisation_processus_recrutement.service.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImp implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapperImpl notificationMapper;

    public List<NotificationDto> findAll() {
        return notificationRepository.findAll().stream().map(notificationMapper::convertToDto).toList();
    }

    public Optional<NotificationDto> findById(UUID id) {
        Optional<Notification> notificationOptional = notificationRepository.findById(id);
        return notificationOptional.map(notificationMapper::convertToDto);
    }

    public NotificationDto save(NotificationDto notificationDto) {
        notificationRepository.save(notificationMapper.convertToEntity(notificationDto));
        return notificationDto;
    }
//    public NotificationDto update(NotificationDto notificationDto) {
//        Optional<NotificationDto> optionalNotificationDto = this.findById(notificationDto.getId());
//        if (optionalNotificationDto.isPresent()) {
//            notificationRepository.save(notificationMapper.convertToEntity(notificationDto));
//            return notificationDto;
//        } else {
//            // Handle case when candidate with given id is not found
//            throw new RuntimeException("Notification with id " + notificationDto.getId() + " not found");
//        }
//    }

    public void deleteById(UUID id) {
        notificationRepository.deleteById(id);
    }
}
