Feature: Cadastro de contas
  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

#Contexto
Background:
  Given que estou acessando a aplicação
  When informo o usuário "ariane@narin"
  And a senha "13"
  And seleciono entrar
  Then visualizo a página inicial
  When seleciono Contas
  And seleciono Adicionar

# Esquema do cenário
  Scenario Outline: Deve analisar regras cadastro contas
    When informo a conta "<conta>"
    And seleciono Salvar
    Then recebo a mensagem "<mensagem>"

    Examples:
      |conta            | mensagem                           |
      |Conta de Teste   | Conta adicionada com sucesso!      |
      |                 | Informe o nome da conta            |
      |Conta mesmo nome | Já existe uma conta com esse nome! |

