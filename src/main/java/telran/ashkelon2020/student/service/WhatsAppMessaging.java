package telran.ashkelon2020.student.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import telran.ashkelon2020.student.dto.MessageDto;
@Service
public class WhatsAppMessaging implements MessagingService {

    @Override

    public MessageDto sendMessage(String message) {
        return MessageDto.builder().messager("WhatsApp").payload(message).build();
    }
}
