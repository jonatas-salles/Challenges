package expratico;

public class Main {
    public static void main(String[] args) {
        final UserAccount jorge = new UserAccount("jorge@teste.com.br", "Jorge");
        final UserAccount marcos = new UserAccount("marcos@teste.com.br", "Marcos");
        final UserAccount maria = new UserAccount("maria@teste.com.br", "Maria");

        jorge.acceptFollower(marcos);
        jorge.publish("teste");
        System.out.println("Posts do Jorge:");
        System.out.println(jorge.getmyPostsAsString());
        System.out.println("Timeline do Marcos:");
        System.out.println(marcos.getTimelineAsString());
        System.out.println("Timeline da Maria:");
        System.out.println(maria.getTimelineAsString());

        jorge.acceptFollower(maria);
        jorge.publish("teste2");
        System.out.println("Posts do Jorge:");
        System.out.println(jorge.getmyPostsAsString());
        System.out.println("Timeline do Marcos:");
        System.out.println(marcos.getTimelineAsString());
        System.out.println("Timeline da Maria:");
        System.out.println(maria.getTimelineAsString());

        maria.clapPost(0);
        maria.clapPost(0);
        maria.clapPost(0);
        marcos.booPost(1);

        jorge.blockFollower(marcos);
        jorge.publish("teste3");
        System.out.println("Posts do Jorge:");
        System.out.println(jorge.getmyPostsAsString());
        System.out.println("Timeline do Marcos:");
        System.out.println(marcos.getTimelineAsString());
        System.out.println("Timeline da Maria:");
        System.out.println(maria.getTimelineAsString());

        for (int i = 0; i < 10; i++) {
            jorge.publish("["+ i + "]");
        }

        System.out.println("Posts do Jorge:");
        System.out.println(jorge.getmyPostsAsString());
        System.out.println("Timeline do Marcos:");
        System.out.println(marcos.getTimelineAsString());
        System.out.println("Timeline da Maria:");
        System.out.println(maria.getTimelineAsString());

        System.out.println("Followers do Jorge:");
        System.out.println(jorge.getFollowersAsString());

        jorge.deletePost(0);
        System.out.println("Posts do Jorge:");
        System.out.println(jorge.getmyPostsAsString());
    }
}