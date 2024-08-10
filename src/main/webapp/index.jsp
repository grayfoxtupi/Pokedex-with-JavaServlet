<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pokedex</title>
     <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            background-color: #f0f0f0;
        }

        h1 {
            text-align: center;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            background-color: #333;
            padding: 10px;
        }

        li {
            margin: 0 10px;
        }

        a {
            text-decoration: none;
            color: white;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1>Bem-vindo à Pokedex</h1>
    <ul>
        <li><a href="pokedexViewPage.jsp">Ver Todos os Pokémon</a></li>
        <li><a href="insertPage.jsp">Pesquisar Pokémon</a></li>
        <li><a href="deletePage.jsp">Detalhes do Pokémon</a></li>
    </ul>
</body>
</html>