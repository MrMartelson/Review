package com.udacity.jwdnd.c1.review;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MessageService {

    private String message;
    private List<ChatMessage> chat;

    public MessageService(String message){
        this.message = message;
    }

    public String toUpperCase (){
        return this.message.toUpperCase();
    }

    public String toLowerCase (){
        return this.message.toLowerCase();
    }

    @PostConstruct
    public void postConstructor(){
        System.out.println("Creating messageService");
    }

    public void addMessage(ChatForm form){
        ChatMessage message = new ChatMessage();
        message.setMessage(form.getMessageText());
        message.setUserName(form.getUsername());
        chat.add(message);
    }

    public List<ChatMessage> getChatMessages() {
        return chat;
    }

}
