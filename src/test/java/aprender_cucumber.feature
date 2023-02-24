Feature: Aprender Cucumber
  Como um aluno
  Eu quero aprender a utilizar Cucumber
  Para que eu possa automatizar critérios de aceitação

Scenario: Deve executar especificação
  Given que criei o arquivo corretamente
  When executá-lo
  Then a especificação deve finalizar com sucesso

Scenario: Deve incrementar contador
  Given que o valor do contador é 15
  When eu incrementar em 5
  Then o valor do contador será 18