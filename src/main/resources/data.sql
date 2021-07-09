INSERT INTO grupo(
                             ds_nome,
                             ds_descricao) 
                      VALUES(
                              'ADMINISTRADORES', 
                              'Adminitrador');
 
INSERT INTO grupo(
                             ds_nome,
                             ds_descricao) 
                      VALUES(
                              'USUARIOS', 
                              'Usuário Comum');
 
INSERT INTO grupo(
                             ds_nome,
                             ds_descricao) 
                      VALUES(
                              'BACKOFFICE', 
                              'Backoffice - Cadastros');
                              
INSERT INTO usuario (
                                ds_nome,
                                ds_login,
                                ds_senha,
                                fl_ativo)
                        VALUES(
                                'Marcos Segundo',
                                'mrsegundo',
'$2a$10$YYe9VtFGZoWvrNSZNV/AeuVSTOMQLxcGia4IQEl/yVaxrfAnPDcuO',
                                 1);
                                 
INSERT INTO permissao(
                                  ds_permissao,
                                  ds_descricao)
                           VALUES(
                                   'ROLE_CADASTROUSUARIO',
                                   'CADASTRO DE NOVOS USUÁRIOS');
 
INSERT INTO permissao(
                                  ds_permissao,
                                  ds_descricao)
                           VALUES(
                                   'ROLE_CONSULTAUSUARIO',
                                   'CONSULTA DE USUÁRIOS');                                   
 
INSERT INTO permissao(
                                  ds_permissao,
                                  ds_descricao)
                           VALUES(
                                   'ROLE_ADMIN',
                                   'ADMINISTRAÇÂO COMPLETA');
                                   
INSERT INTO usuario_x_grupo(id_usuario,id_grupo)VALUES(1,1);

/*ROLE_CADASTROUSUARIO x BACKOFFICE*/
INSERT INTO permissao_x_grupo(id_permissao,id_grupo)VALUES(1,3); 
 
/*ROLE_CONSULTAUSUARIO x USUARIOS*/
INSERT INTO permissao_x_grupo(id_permissao,id_grupo)VALUES(2,2);
 
/*ROLE_ADMIN x ADMINISTRADORES*/
INSERT INTO permissao_x_grupo(id_permissao,id_grupo)VALUES(3,1);