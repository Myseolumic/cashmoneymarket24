package com.bestteam.CashMoneyMarket;

import com.bestteam.CashMoneyMarket.Controllers.PostController;
import com.bestteam.CashMoneyMarket.Models.Post;
import com.bestteam.CashMoneyMarket.Repositories.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostControllerTest {
    @InjectMocks
    private PostController postController;
    @Mock
    private PostRepository postRepository;
    @Mock
    private Model model;

    @Test
    public void testModelIsPopulatedWithDataFromDB() {
        // mocked data
        List<Post> postList = new ArrayList<>();
        Post post = new Post();
        post.setTitle("Vahva");
        post.setMessage("Vahvel");
        postList.add(post);
        when(postRepository.findAll()).thenReturn(postList);
        String template = postController.posts(model);
        assertEquals("posts", template);
        verify(model).addAttribute(eq("posts"), eq(postList));
    }
}