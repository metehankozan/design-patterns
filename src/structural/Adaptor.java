package structural;

public class Adaptor {

    class LegacyUser {
        int id;
        String username;
        String name;
        String lastName;
    }

    interface LegacyUserService {
        LegacyUser getUser(int id);
    }

    class User {
        int id;
        String email;
        String username;
        String name;
        String lastname;
        String location;
        String isActive;
    }

    interface UserRepository {
        User getUser(String email);
    }

    interface UserService {
        User getUser(String email);
    }

    class UserServiceAdaptor implements UserService {

        UserRepository userRepository;
        LegacyUserService legacyUserService;

        @Override
        public User getUser(String email) {
            User user = userRepository.getUser(email);
            LegacyUser legacyUser = legacyUserService.getUser(user.id);
            user.username = legacyUser.username;
            user.lastname = legacyUser.lastName;
            return user;
        }
    }

    public void adapterDemo() {
        UserService userService = new UserServiceAdaptor();
        User user = userService.getUser("mail@mail.com");
        System.out.println(user);
    }

    public static void main(String[] args) {
        new Adaptor().adapterDemo();
    }
}
