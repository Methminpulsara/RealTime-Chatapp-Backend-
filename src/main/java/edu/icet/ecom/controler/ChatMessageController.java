package edu.icet.ecom.controler;

import edu.icet.ecom.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor
public class ChatMessageController {

    private final SimpMessagingTemplate simpMessagingTemplate;


    @MessageMapping("/message") //app/message
    @SendTo("/chatroom/public")
    private ChatMessage receivePublicMessage(ChatMessage message){
        return message;
    }

    @MessageMapping("/private-message")
    public ChatMessage receivePrivateMessage(ChatMessage message){
        simpMessagingTemplate.convertAndSendToUser(message.getRecipient(),"/private", message);
        return message;
    }




}
