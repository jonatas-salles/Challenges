package expratico;

import java.util.Objects;

public class UserAccount {
    public static final int MAX_POSTS_TIMELINE = 10;
    public static final int INFINITY = 99999;
    private final String email;
    private final String username;
    private final UserAccount[] followers;
    private final Post[] posts;
    private final Post[] timeline;
    private int numFollowers;
    private int numPosts;
    private int numPostsTimeline;

    public UserAccount(String email, String username) {
        this.email = Objects.requireNonNull(email);
        this.username = Objects.requireNonNull(username);
        this.timeline = new Post[MAX_POSTS_TIMELINE];
        this.followers = new UserAccount[INFINITY];
        this.posts = new Post[INFINITY];
    }

    public void publish(String quote) {
        final Post post = new Post(this, quote);
        posts[numPosts++] = post;
        for (int i = 0; i < numFollowers; i++) {
            UserAccount follower = followers[i];
            follower.updateTimeline(post);
        }
    }

    private void updateTimeline(Post post) {
        timeline[numPostsTimeline%10] = post;
        numPostsTimeline++;
    }

    public void deletePost(int postIdx) {
        if (isTimelineIndexInvalid(postIdx)) return;
        for (int i = postIdx; i < numPosts-1; i++) {
            posts[i] = posts[i+1];
        }
        posts[--numPosts] = null;
    }

    private boolean isTimelineIndexInvalid(int postIdx) {
        return postIdx < 0 || postIdx >= numPosts;
    }

    private boolean isPostIndexInvalid(int postIdx) {
        return postIdx < 0 || postIdx >= Math.min(timeline.length, numPostsTimeline);
    }

    public void clapPost(int postIdx) {
        if (isPostIndexInvalid(postIdx)) return;
        timeline[postIdx].clap();
    }


    public void booPost(int postIdx) {
        if (isPostIndexInvalid(postIdx)) return;
        timeline[postIdx].boo();
    }

    public void acceptFollower(UserAccount newFollower) {
        followers[numFollowers++] = newFollower;
    }

    public void blockFollower(UserAccount follower) {
        for (int i = 0; i < numFollowers; i++) {
            if (followers[i] == follower) {
                for (int j = i; j < numFollowers-1; j++) {
                    followers[j] = followers[j+1];
                }
            }
        }
        followers[--numFollowers] = null;
    }

    public String getTimelineAsString() {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Math.min(numPostsTimeline, timeline.length); i++) {
            builder.append(timeline[i].getPostInfo()).append("\n");
        }
        return builder.toString();
    }

    public String getmyPostsAsString() {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Math.min(numPosts, posts.length); i++) {
            builder.append(posts[i].getPostInfo()).append("\n");
        }
        return builder.toString();
    }

    public String getFollowersAsString() {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Math.min(numFollowers, followers.length); i++) {
            builder.append(followers[i].getUsername()).append("\n");
        }
        return builder.toString();
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
