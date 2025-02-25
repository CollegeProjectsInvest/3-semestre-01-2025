import infra.Database;
import user.UserRepository;
import user.UserView;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        UserRepository userRepository = new UserRepository(database);
        UserView userView = new UserView(userRepository);

        userView.registerUser();
    }
}
