# chessapi

ChessAPI é uma aplicação REST que disponibiliza os ratings dos jogadores cadastrados no BD da World Chess Federation.

Ratings: https://ratings.fide.com/download.phtml

CRUD.

Apesar de utilizar o dados da FIDE a aplicação não suporta todos os campos contidos no XML. Somente fideId, Name, Country, rating e yearOfBirth. Esses são os parametros que devem ser enviados para a criação de novos jogadores, deve-se utilizar o formato json.

Um GET para /players vai retornar um JSON com todos os players cadastrados.

É possível fazer busca pelo nome passando o parametro name pela URL. 


O único atributo que pode ser atualizado é o rating. Deve-se utilizar o formato json.

Exclusão são feitas passando o ID pela URL.





Busca utilizando /players

<a href="http://i.imgur.com/c63ftoq.png">
  <img src="http://imgur.com/c63ftoql.png" />
</a>

Busca por nome

<a href="http://i.imgur.com/eefm0Ry.png">
  <img src="http://imgur.com/eefm0Ryl.png" />
</a>

Atualização do Rating

<a href="http://i.imgur.com/xhg1U26.png">
  <img src="http://imgur.com/xhg1U26l.png" />
</a>



*Proximos passos: Implementar seguranca, cache e documentacao.





