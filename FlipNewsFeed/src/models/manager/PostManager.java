package models.manager;

import models.Post;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;

public class PostManager {
    private Map<Integer, Post> idToPostMap;
    private Map<Integer, LinkedHashSet<Integer>> postIdToCommentMap;
    private static PostManager postManagerInstance;
    private PostManager() {
        this.idToPostMap = new HashMap<>();
        this.postIdToCommentMap = new HashMap<>();
    }

    public static PostManager getInstance() {
        if (postManagerInstance == null) {
            postManagerInstance = new PostManager();
        }
        return postManagerInstance;
    }

    public void createPost(Post post) {
        int id  = post.getPostId();
        idToPostMap.put(id, post);
        postIdToCommentMap.put(post.getPostId(), new LinkedHashSet<>());
    }

    public Map<Integer, Post> getIdToPostMap() {
        return idToPostMap;
    }

    public Map<Integer, LinkedHashSet<Integer>> getPostIdToCommentMap() {
        return postIdToCommentMap;
    }

    public Optional<Post> getPost(int id) {
        return idToPostMap.values().stream().filter(it-> it.getPostId() == id).findFirst();
    }

    public LinkedHashSet<Integer> getCommentsIds(int postId) {
        return postIdToCommentMap.get(postId);
    }
}
