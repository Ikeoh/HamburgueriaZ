# HamburgueriaZ

**Projeto desenvolvido como aula prática da disciplina de "Desenvolvimento Mobile"** no curso de graduação de Engenharia de Software Ampli - Ahanguera.

**HamburgueriaZ** é um aplicativo de pedidos de lanches, desenvolvido em Kotlin utilizando **Jetpack Compose** para a interface de usuário. O app permite aos usuários selecionar lanches do cardápio, calcular automaticamente o preço total com desconto especial para pedidos maiores e enviar o pedido via WhatsApp.

## Funcionalidades

- **Seleção de Lanches**: O usuário pode escolher entre três lanches especiais: Goku, Vegeta e Piccolo, cada um com ingredientes únicos e preços personalizados.
- **Cálculo de Preço**: O app calcula automaticamente o valor do pedido e aplica um desconto de 25% quando dois ou mais lanches são selecionados.
- **Resumo do Pedido**: Exibe o resumo do pedido com o total de itens, valor sem desconto, desconto aplicado e o valor final a pagar.
- **Envio de Pedido via WhatsApp**: O pedido pode ser enviado diretamente via WhatsApp com um clique no botão "Enviar Pedido".

## Tecnologias Utilizadas

- **Kotlin**: Linguagem de programação principal.
- **Jetpack Compose**: Framework declarativo para construção de interfaces no Android.
- **Android Studio**: IDE utilizada no desenvolvimento.
- **WhatsApp API**: Para enviar mensagens diretamente ao WhatsApp.

## Estrutura do Projeto

- **MainActivity.kt**: Arquivo principal contendo a lógica do app e a interface do usuário.
  - `Cardapio()`: Componente responsável por exibir os lanches disponíveis.
  - `LancheItem()`: Componente que representa cada lanche com checkbox para seleção e controle de quantidade.
  - `ResumoPedido()`: Componente que calcula e exibe o resumo do pedido com valores e desconto.
- **Função Auxiliar**:
  - `enviarMensagemWhatsApp()`: Função que envia o resumo do pedido via WhatsApp.

