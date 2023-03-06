@funcionais
Feature: Cadastro de contas
  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

#Contexto
Background:
  Given que desejo adicionar uma conta

# Esquema do cenário
  Scenario Outline: Deve analisar regras cadastro contas
    When adiciono a conta "<conta>"
    Then recebo a mensagem "<mensagem>"

    Examples:
      |conta            | mensagem                           |
      |Conta de Teste   | Conta adicionada com sucesso!      |
      |                 | Informe o nome da conta            |
      |Conta mesmo nome | Já existe uma conta com esse nome! |

