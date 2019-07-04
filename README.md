# UCDb-backend

> Repositório para o backend do projeto final da disciplina Projeto de Software.


A API desenvolvida trabalha de uma forma onde os controllers mandam informações aos
services que mandaram dados para DAO, que se comunicara com o banco de dados.
Foram criadas 4 entidades, PerfilDisciplina(para perfil de uma disciplina), Disciplina
(que é a própria disciplina), Comentario e Usuario. Estas serão manejadas pelos Controllers,
cada um com seu controller correspondente com exceção de Comentario, que é controlado pelo
PerfilDisciplinaController. EmailController é o que utiliza o java MailSender, que
é uma API feita para o envio de email, utilizada para mandar email após o cadastro de
um usuario.A autenticação de um usuário é feita por meio de um token, este token será
checado por meio de TokenFilter, este token é gerado quando um usuário cadastrado
no sistema faz seu login, e ele é checado em todas as operações que devem ser
acessíveis apenas ao usuarios autenticados.