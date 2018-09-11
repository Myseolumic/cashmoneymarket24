package com.bestteam.CashMoneyMarket.Controllers;

import com.bestteam.CashMoneyMarket.Models.Post;
import com.bestteam.CashMoneyMarket.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/submitpost")
    public String submitPost(@ModelAttribute Post post) {
        postRepository.save(post);

        return "redirect:/";
    }

    @GetMapping("/submitpost")
    public String postForm(Model model) {
        model.addAttribute("post", new Post());
        return "submitpost";
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "posts";
    }
}
