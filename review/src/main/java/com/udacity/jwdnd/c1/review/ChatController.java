package com.udacity.jwdnd.c1.review;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageService messageService;

    public ChatController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model){

        return "chat";
    }

    @PostMapping
    public String addMessage (ChatForm chatForm, Model model){
        messageService.addMessage(chatForm);
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        return "chat";
    }
}
