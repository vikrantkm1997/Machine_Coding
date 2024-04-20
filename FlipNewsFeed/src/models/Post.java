package models;

import enums.FeedType;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Post {
    private int postId;
    private String feed;
    private FeedType feedType;
    private int ownerId;
    private Set<Integer> upvotes;
    private Set<Integer> downvotes;

    private LocalDateTime localDateTime;

    public Post(int postId, String feed, FeedType feedType, int ownerId) {
        this.postId = postId;
        this.feed = feed;
        this.feedType = feedType;
        this.ownerId = ownerId;
        this.upvotes = new HashSet<>();
        this.downvotes = new HashSet<>();
        this.localDateTime = LocalDateTime.now();
    }

    public int getPostId() {
        return postId;
    }

    public String getFeed() {
        return feed;
    }

    public FeedType getFeedType() {
        return feedType;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public Set<Integer> getUpvotes() {
        return upvotes;
    }

    public Set<Integer> getDownvotes() {
        return downvotes;
    }

    public void upVote(int userId){
        this.downvotes.remove(userId);
        this.upvotes.add(userId);
    }

    public void downVote(int userId){
        this.upvotes.remove(userId);
        this.downvotes.add(userId);
    }

    public int score() {
        return this.upvotes.size() - this.downvotes.size();
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
