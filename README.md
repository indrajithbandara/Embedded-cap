# Aulas Android
Aplicativos para fixação de conteúdo das aulas de capacitação Nokia - UFCG 2017/2018.

## Aula 09
Aplicativo para somar dois valores e apresentar o resultado
* A tela principal (Activity) deve ter um botão “somar” que abre uma tela secundária (Sub-Activity)
* A tela secundária deve ter:
  * Dois campos para inserir os valores
  * Um botão de “Ok” e um botão de “Cancelar”
* A tela principal deve apresentar o resultado da soma retornado pela tela secundária em um Fragment

## Aula 10
Aplicativo que possui duas variações de layout, dependendo da orientação do aparelho (portrait or landscape)
* Caso a tela esteja em modo landscape, uma mensagem deve ser exibida informado a orientação do celular

## Aula 11
Aplicações que enviam e recebem broadcast:
* Criar aplicação contendo uma Activity e um BroadcastReceiver
  * Crie uma string que represente uma action
  * Crie um IntentFilter com a action
  * Crie uma instância do BroadcastReceiver
  * Registre o BroadcastReceiver ao IntentFilter utilizando o método registerReceiver
* Crie outra aplicação para enviar a action em broadcast usando sendBroadcast
  * Teste o recebimento com Log
