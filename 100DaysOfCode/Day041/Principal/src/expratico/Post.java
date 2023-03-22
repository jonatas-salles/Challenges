package expratico;

import java.time.LocalDate;
import java.util.Objects;

public class Post {
    private final String quote;
    private final LocalDate date;
    private int claps;
    private int boos;
    private final UserAccount user;

    public Post(UserAccount user, String quote) {
        this.user = Objects.requireNonNull(user);
        this.quote = Objects.requireNonNull(quote);
        this.date = LocalDate.now();
    }

    public String getPostInfo() {
        return String.format("[%s] %s says \"%s\" | Claps: %d | Boos: %d", date, user.getUsername(), quote, claps, boos);
    }

    public void clap() {
        this.claps++;
    }
    public void boo() {
        this.boos++;
    }
}
