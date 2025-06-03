from src.Pessoa import Pessoa


def main() -> None:
    # objeto da classe Pessoa
    pessoa_teste = Pessoa("Marcos", "teste@mail.com", 20)
    pessoa_teste.mostrar_infos()


if __name__ == '__main__':
    main()
