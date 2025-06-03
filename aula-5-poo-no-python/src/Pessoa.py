# Classe Pessoa
class Pessoa:
    # Atributos
    nome: str  # Público
    email: str  # Protegido
    idade: int  # Privado

    # método construtor
    def __init__(self, nome: str, email: str, idade: int) -> None:
        self.nome = nome
        self.email = email
        self.idade = idade

    # método público, retorna nada
    def mostrar_infos(self) -> None:
        print(f"Nome: {self.nome}\nEmail: {self.email}\nIdade: {self.idade}")

    # método público, retorna um valor inteiro
    def retornar_idade(self) -> int:
        return self.idade
