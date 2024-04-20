import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlipKartNewsFeed flipKartNewsFeed = new FlipKartNewsFeed();
        do{
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String []input = s.split("~");
            try
            {
                switch (input[0]) {
                    case "signup":
                        flipKartNewsFeed.signUp(input[1]);
                        break;
                    case "login":
                        flipKartNewsFeed.login(input[1]);
                        break;
                    case "post":
                        flipKartNewsFeed.post(input[1]);
                        break;
                    case "logout":
                        flipKartNewsFeed.logOut();
                        break;
                    case "shownewsfeed":
                        flipKartNewsFeed.showNewsfeed();
                        break;
                    case "follow":
                        flipKartNewsFeed.follow(input[1]);
                        break;
                    case "upvote":
                        flipKartNewsFeed.upVote(Integer.parseInt(input[1]));
                        break;
                    case "downvote":
                        flipKartNewsFeed.downVote(Integer.parseInt(input[1]));
                        break;
                    case "reply":
                        flipKartNewsFeed.reply(Integer.parseInt(input[1]), input[2]);
                        break;
                    default:
                        System.out.println("Wrong input");
                        break;

                }
            }catch (Exception e) {
                System.out.println("Exception happened");
            }
        }while(true);
    }
}
//        signup~lucious
//        signup~albus
//        signup~tom
//        login~tom
//        post~I am going to be the darkest dark wizard of all time
//        post~I am lord Voldemort btw 3:)
//        logout
//        login~lucious
//
//
//    id: 002
//    (0 upvotes, 0 downvotes)
//    tom
//    I am lord Voldemort btw 3:)
//    1994-04-19 10:11 PM
//
//
//    id: 001
//    (0 upvotes, 0 downvotes)
//    tom
//    I am going to be the darkest dark wizard of all time
//    1994-04-19 10:10 PM
//    upvote~001
//    follow~tom
//    reply~001~I am with you dark lord!
//    logout
//    login~albus
//
//
//    id: 001
//    (1 upvote, 0 downvotes)
//    tom
//    I am going to be the darkest dark wizard of all time
//    1994-04-19 10:10 PM
//    id: 003
//    Lucious
//    I am with you dark lord!
//    1994-04-19 10:15 PM
//
//
//    id: 002
//    (0 upvotes, 0 downvotes)
//    tom
//    I am lord Voldemort btw 3:)
//    1994-04-19 10:11 PM
//
//
//    post~Happiness can be found, even in the darkest of times, if one only remembers to turn on the light
//    follow~tom
//    downvote~001
//    downvote~002
//    reply~002~LOL!
//    shownewsfeed
//    id: 001
//    (1 upvote, 1 downvotes)
//    tom
//    I am going to be the darkest dark wizard of all time
//    1994-04-19 10:10 PM
//    id: 003
//    lucius
//    I am with you dark lord!
//    1994-04-19 10:15 PM
//
//
//    id: 002
//    (0 upvotes, 1 downvotes)
//    tom
//    I am lord Voldemort btw 3:)
//    1994-04-19 10:11 PM
//    id: 005
//    albus
//    LOL!
//    1994-04-19 10:30 PM
//
//
//    id: 004
//    (0 upvotes, 0 downvotes)
//    albus
//    Happiness can be found, even in the darkest of times, if one only remembers to turn on the light
//    1994-04-19 10:28 PM
