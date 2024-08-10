<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Catálogo de Imagens</title>
    <!-- Adicione a ligação ao Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
      <style>
        .search-container {
            width: 300px; /* Largura desejada da div */
            margin: auto; /* Margem automática para centralizar */
            text-align: center; /* Centralizar conteúdo dentro da div */
            padding: 20px; /* Adicionar espaço interno para melhor visualização */
            border: 0px; /* Adicionar borda para visualização */
            border-radius: 8px; /* Adicionar borda arredondada */
        }
        
        .search-container input{
        width: 100%; /* Ocupar 100% da largura disponível */
        padding: 0px; /* Adicionar espaçamento interno ao input */
        margin-bottom: 10px; /* Adicionar espaçamento inferior para separar do botão */
        box-sizing: border-box; /* Incluir padding e borda no tamanho total do elemento */
        
        }
        
        .search-container button{
        
         width: 100%; /* Ocupar 100% da largura disponível */
         padding: 10px; /* Adicionar espaçamento interno ao botão */
         background-color: #4CAF50; /* Cor de fundo verde */
         color: white; /* Cor do texto branco */
         border: none; /* Remover a borda */
         border-radius: 4px; /* Adicionar borda arredondada */
         cursor: pointer; /* Adicionar cursor de ponteiro ao passar o mouse */
        
        }
    </style> 
    <script src="javascript/fetchPV2.js"></script>
</head>

<body onload="getCards()">

    <div class="search-container">
        <h1>Pokedex</h1>
        <input type="text" id="userInput" name="userInput">
        <button onclick="customSearch()">Enviar</button>
    </div>

    <div id="imagesContainer">
        <!-- Cards Bootstrap serão adicionados aqui dinamicamente por JavaScript -->
    </div>

    <!-- Adicione a ligação ao Bootstrap JS e ao Popper.js -->

</body>

</html>