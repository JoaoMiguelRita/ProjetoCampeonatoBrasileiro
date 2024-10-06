# API de Futebol

## Descrição do Projeto

Este projeto é uma API de futebol que permite acessar dados sobre o Brasileirão, times, atletas, grupos e suas respectivas posições. Atualmente, estamos utilizando a versão Free para testes, que possui limitações em comparação com a versão paga. A versão paga oferece uma capacidade maior e mais recursos, ideal para projetos em larga escala ou aplicações que necessitam de informações em tempo real.

## Funcionalidades

A API de futebol oferece as seguintes possibilidades de requisições GET e POST:

1. **Obter todos os campeonatos**
    - **Endpoint:** `/campeonatos`
    - **URL:** `http://localhost:8080/futebola/campeonatos`
    - **Descrição:** Retorna uma lista de todos os campeonatos disponíveis.

2. **Obter detalhes de um campeonato específico**
    - **Endpoint:** `/campeonatos/{campeonato_id}`
    - **URL:** `Em processo...`
    - **Descrição:** Retorna detalhes do campeonato correspondente ao ID fornecido.

3. **Obter todos os times de um campeonato**
    - **Endpoint:** `/campeonatos/{campeonato_id}/tabela`
    - **URL:** `http://localhost:8080/futebola/campeonato?id=10`
    - **Descrição:** Retorna uma lista de todos os times que participam do campeonato especificado.

4. **Obter detalhes de um time específico**
    - **Endpoint:** `/times/{time_id}`
    - **URL:** `http://localhost:8080/futebola/time?id=6`
    - **Descrição:** Retorna detalhes do time correspondente ao ID fornecido.

5. **Obter um Atleta específico**
    - **Endpoint:** `/atleta/{id}`
    - **URL:** `http://localhost:8080/atletas/buscar?id=564`
    - **Post:** `http://localhost:8080/atletas?id=1&nome_popular=teste&nome=teste1&sigla=tst&nomePosicao=teste`
    - **Descrição:** Retorna informações do atleta correspondente ao ID informado.

6. **Informação sobre o projeto**
    - **Endpoint:** `/sobre`
    - **URL:** `http://localhost:8080/sobre`
    - **Descrição:** Retorna informações sobre o desenvolvedor e projeto.

## Agradecimentos

Agradecemos sua atenção e interesse na API de futebol. Para mais informações ou suporte, sinta-se à vontade para questionar.

Link da home da API: https://api-futebol.com.br
 
