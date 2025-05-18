package edu.icet.ecom.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatMessage {

    private String sender;
    private String recipient;
    private String content;
    private LocalDateTime timestamp;
    private Status status;

}
