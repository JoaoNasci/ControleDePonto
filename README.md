------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#Sistema de controle de ponto 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


#1-Tela de Login

#Nessa tela o colaborador e o administrador do sistema poderão realizar o login no sistema para serem direcionados para suas respectivas telas através do nivel de privilégio do usúario.

#Botões:

#Logar - Botão para realizar o login do usúario através do evento de "validarUsuario" para comparar os dados registrados na tabela de usuario para que seja possivel autenticar o usúari

#Campos

#Login - Campo para o usúario digitar seu e-mail cadastrado para realizar o login.

#Senha - Campo para o usúario digitar sua senha.

#Eventos:

#autenticarUsuario - evento para que possa ser comparado o email e senha que o usúario digitar com os cadastrados no banco para que possa ser feita a autenticação do usúario, e através do nivel 
de privelégio redirecionar o usúario para sua respectiva tela sendo elas PrincipalADM ou PrincipalColaborador.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#2-Tela PrincipalADM

#Nessa tela o administrador do sistema podera ver as solicitações de ajuste ponto em aberto , realizar ajustes de registros de ponto dos colaboradores através do botão "Editar registro" e excluir registros de ponto dos colaboradores através do botão "Excluir registro".

#Botões:

#Atualizar - Atualiza registros da tabela de solicitações de ajuste de ponto .

#Campo e botão de filtro - Filtra solicitações de ajuste de registros de pontos dos colaborados na tabela .

#Eventos:

#exibirDados - evento para mostrar todas as solicitações de ajuste de registro de ponto em aberto dos colaboradores.

#atualizarDados - evento para atualizar os dados da tabela para  mostrar os dados mais recentes.

#pesquisarDados - evento para filtrar solicitações de acordo com o filtro que o usúario escolher exemplo filtrar por nome ou número da solicitação.

#carregarDadosSolicitacao - evento que quando o Administrador clicar na solicitação na tela seja redirecionado para a tela de ExcluirRegistro ou EditarRegistro de acordo com o tipo de solicitação feita pelo colaborador.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#3-Tela PrincipalColaborador

#Nessa tela o colaborador podera ver as suas solicitações de ajuste ponto em aberto ou encerradas, além disso o  colaborador pode solicitar um novo reajuste de registro de ponto através do botão "Solicitar Reajuste".

#Botões:

#SolicitarReajuste - Botão para que o colaborador seja redirecionado para a tela de SolicitarReajuste.

#Campo e botão de filtro - Filtra as solicitações do colaborador que estão em aberto ou encerradas na tabela .

#Eventos:

#exibirDados - evento para mostrar todas as solicitações de resgistro de ponto do colaborador que estão em aberto ou encerrados.

#atualizarDados - evento para atualizar os dados da tabela para  mostrar os dados mais recentes.

#pesquisarDados - evento para que o colaborador possa filtrar suas solicitações de acordo com o filtro que o ele selecionar como número da solicitação ou status.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#4-Tela SolicitarReajuste

#Nessa tela o colaborador podera preencher os campos para poder abrir uma nova solicitação de reajuste de ponto.

#Botões:

#Enviar - Botão para o colaborador possa registrar a solicitação de reajuste na tabela de solicitações.

#Cancelar - Cancela a operação e retorna para a tela de PrincipalColaborador.

#Campos

#Nome - Campo que mostra o nome do usúario que ira solicitar o ajuste de ponto.

#Data - Campo para o usúario digitar a data do registro a ser alterado.

#Registro de ponto - Campo para o usúario selecionar o registro que será alterado.

#Motivo - Campo para o usúario descrever o motivo da solicitação de reajuste.

#Eventos:

#registrarSolicitacao - evento para pegar os dados preenchidos nos campos pelo usúario para registrar uma nova solicitação de ajuste de ponto no sistema .

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#5-Tela ExcluirRegistro

#Nessa tela o administrador podera excluir o registro de ponto caso o usúario tenha solicitado

#Botões:

#Confirmar - Botão para o administrador confirmar a exclusão do registro de ponto.

#Cancelar - Cancela a operação e retorna para a tela de PrincipalAdministrador.

#Campos

#Nome - Campo que mostra o nome do usúario que solicitou a exclusão do registro.

#Data - Campo para o usúario digitar a data do registro a ser excluido.

#Horário - Campo para o usúario selecionar o registro a ser excluido.

#Eventos:

#excluirRegistro - evento para excluir um Registro de ponto de acordo com a solicitação feita pelo usúario  .

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#6-Tela EditarRegistro

#Nessa tela o administrador podera excluir o registro de ponto caso o usúario tenha solicitado

#Botões:

#Confirmar - Botão para o administrador confirmar a exclusão do registro de ponto.

#Cancelar - Cancela a operação e retorna para a tela de PrincipalAdministrador.

#Campos

#Nome - Campo que mostra o nome do usúario que solicitou a edição do registro.

#Data - Campo para o usúario digitar a data do registro a ser alterado.

#Horário antigo - Campo para o usúario selecionar o registro a ser alterado.

#Horário novo - campo para o administrador digitar o novo horario que sera atualizado.

#Eventos:

#editarRegistro - evento para editar um Registro de ponto de acordo com a solicitação feita pelo usúario  .

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
