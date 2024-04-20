import Utils.Idgenerator;
import enums.FeedType;
import models.Post;
import models.User;
import models.manager.PostManager;
import models.manager.UserManager;

import java.util.*;

import static Utils.Utils.formatDateTime;

public class FlipKartNewsFeed {
    private UserManager userManager;
    private User loggedInUser;
    private Map<Integer, Set<Integer>> userFollowerMap;

    private PostManager postManager;

    public FlipKartNewsFeed() {
        this.userFollowerMap = new HashMap<>();
        this.userManager = UserManager.getInstance();
        this.postManager = PostManager.getInstance();
    }

    public void signUp(String userName) {
        int userId = Idgenerator.getUserId();
        User user = new User(userId, userName, "");
        userManager.addUser(user);
        userFollowerMap.put(userId, new HashSet<>());
    }

    public void login(String username) {
        User user = userManager.getUser(username).get();
        this.loggedInUser = user;
        showNewsfeed();
    }

    public void logOut() {
        this.loggedInUser = null;
    }

    public void post(String feed) {
        int postid = Idgenerator.getFeedId();
        Post post = new Post(postid, feed, FeedType.POST, loggedInUser.getId());
        postManager.createPost(post);
    }

    public void reply(int postId, String comment) {
        int replyId = Idgenerator.getFeedId();
        Post post = new Post(replyId, comment, FeedType.COMMENT, loggedInUser.getId());
        postManager.createPost(post);
        Map<Integer, LinkedHashSet<Integer>> postIdToCommentMap = postManager.getPostIdToCommentMap();
        LinkedHashSet<Integer> commentIds = postIdToCommentMap.getOrDefault(postId, new LinkedHashSet<>());
        commentIds.add(replyId);
        postIdToCommentMap.put(postId, commentIds);
    }

    public void upVote(int postId) {
        Optional<Post> post = postManager.getPost(postId);
        post.get().upVote(loggedInUser.getId());
    }

    public void downVote(int postId) {
        Optional<Post> post = postManager.getPost(postId);
        post.get().downVote(loggedInUser.getId());
    }

    public void follow(String userName) {
        Optional<User> user = userManager.getUser(userName);
        Set<Integer> followers = userFollowerMap.getOrDefault(user.get().getId(), new HashSet<>());
        followers.add(loggedInUser.getId());
    }

    public void showNewsfeed() {
        int loggedInUserId = loggedInUser.getId();
        List<Post> userFollowedPost =
            postManager
                .getIdToPostMap()
                .values()
                .stream().filter(it -> it.getFeedType() == FeedType.POST
                    && userFollowerMap.get(loggedInUserId).contains(it.getOwnerId()))
                .sorted(Comparator.comparing(Post::score)
                    .thenComparing(it -> getCommentsSize(it.getPostId())).reversed()
                    .thenComparing(Comparator.comparing(Post::getLocalDateTime).reversed())
                )
                .toList();
        userFollowedPost.forEach(this::printPostAndItsComment);
        List<Post> usersNotFollowed =
            postManager
                .getIdToPostMap()
                .values()
                .stream().filter(it -> it.getFeedType() == FeedType.POST
                    && !userFollowedPost.contains(it))
                .sorted(Comparator.comparing(Post::score)
                    .thenComparing(it -> getCommentsSize(it.getPostId())).reversed()
                    .thenComparing(Comparator.comparing(Post::getLocalDateTime).reversed())
                )
                .toList();
        usersNotFollowed.forEach(this::printPostAndItsComment);
    }

    public void printPostAndItsComment(Post post) {
        System.out.println("id: " + post.getPostId());
        System.out.println("(upvotes " + post.getUpvotes().size() + ", downvotes" + post.getDownvotes().size() + ")");
        System.out.println(userManager.getUserByUserId(post.getOwnerId()).get().getUserName());
        System.out.println(post.getFeed());
        System.out.println(formatDateTime(post.getLocalDateTime()));
        LinkedHashSet<Integer> commentIds = postManager.getCommentsIds(post.getPostId());
        commentIds.forEach(it -> {
            Optional<Post> optionalPost = postManager.getPost(it);
            Post post1 = optionalPost.get();
            System.out.println("   " + "id: " + post1.getPostId());
            System.out.println("   " + "(upvotes " + post1.getUpvotes().size() + ", downvotes" + post1.getDownvotes().size() + ")");
            System.out.println("   " + userManager.getUserByUserId(post1.getOwnerId()).get().getUserName());
            System.out.println("   " + post1.getFeed());
            System.out.println("   " + formatDateTime(post.getLocalDateTime()));
        });
        System.out.println();
        System.out.println();
    }

    public int getCommentsSize(int postId) {
        return postManager.getCommentsIds(postId).size();
    }

}
