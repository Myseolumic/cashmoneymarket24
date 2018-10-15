package com.bestteam.CashMoneyMarket.Controllers;

import com.bestteam.CashMoneyMarket.Models.Post;
import com.bestteam.CashMoneyMarket.Repositories.PostRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/submitpost")
    public String submitPost(@RequestParam String title,
                             @RequestParam String message,
                             @RequestParam MultipartFile image,
                             @RequestParam String location) {
        Post post = new Post();
        post.setTitle(title);
        post.setMessage(message);
        post.setLocation(location);
        try {
            post.setImage(getImageBase64Format(image));
        } catch (Exception e) {

        }
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
        List<Post> posts = new ArrayList<>();
        for (Post post : postRepository.findAll()) {
            posts.add(post);
        }
        model.addAttribute("posts", posts);
        return "posts";
    }

    @GetMapping("/peek-post")
    @ResponseBody
    public Post post() {
        return postRepository.findAll().get(0);
    }

    private String getImageBase64Format(MultipartFile file) throws Exception {
        if (file.getContentType().equals("application/octet-stream")) return null;
        return "data:" + file.getContentType() + ";base64," + Base64.encodeBase64String(file.getBytes());
    }
}
