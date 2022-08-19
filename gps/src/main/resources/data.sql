INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Mario', 'Miranda', 'mario@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Cristina', 'Chan', 'cristina@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO TB_TYPE ( ACTIVE , ASK , CREATED_AT , CREATED_BY , DESCRIPTION , PARENT_TYPE_ID , UPDATED_AT , UPDATED_BY ) VALUES (1, 'Motivo do contato?' , TIMESTAMP WITH TIME ZONE '2022-07-13T20:50:07.12345Z', 1 , 'Solicitacao' , null , null , null);
INSERT INTO TB_TYPE ( ACTIVE , ASK , CREATED_AT , CREATED_BY , DESCRIPTION , PARENT_TYPE_ID , UPDATED_AT , UPDATED_BY ) VALUES (1, 'Motivo do contato?' , TIMESTAMP WITH TIME ZONE '2022-07-13T20:50:07.12345Z', 1 , 'Cancelamento' , 1 , null , null);
INSERT INTO TB_TYPE ( ACTIVE , ASK , CREATED_AT , CREATED_BY , DESCRIPTION , PARENT_TYPE_ID , UPDATED_AT , UPDATED_BY ) VALUES (1, 'Definicao do atendimento?' , TIMESTAMP WITH TIME ZONE '2022-07-13T20:50:07.12345Z', 1 , 'Servico' , 2 , null , null);
INSERT INTO TB_TYPE ( ACTIVE , ASK , CREATED_AT , CREATED_BY , DESCRIPTION , PARENT_TYPE_ID , UPDATED_AT , UPDATED_BY ) VALUES (1, 'Motivo do contato?' , TIMESTAMP WITH TIME ZONE '2022-07-13T20:50:07.12345Z', 1 , 'Informacao' , null , null , null);