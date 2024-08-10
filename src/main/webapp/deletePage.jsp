<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        
</style>
</head>
<body>
<form action="deleteServlet" method="post">

<div class="search-container">
Nome : <input type="text" name="pokename">

<br>

<input type="submit" name="Enviar"> 
</div>
</form>
</body>
</html>