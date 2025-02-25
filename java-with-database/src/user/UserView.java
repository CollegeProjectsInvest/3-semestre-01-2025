package user;

import java.util.Scanner;

public class UserView {
    private final Scanner scanner;
    private final UserRepository userRepository;

    public UserView(UserRepository userRepository) {
        this.scanner = new Scanner(System.in);
        this.userRepository = userRepository;
    }

    public void registerUser() {
        System.out.println("==================");
        System.out.println("Digite um nome do usuário: ");
        String name = scanner.nextLine();

        UserModel userModel = new UserModel(name);
        int userId = this.userRepository.insert(userModel);

        System.out.println("Usuário " + userId + " criado com sucesso!");
    }
}
