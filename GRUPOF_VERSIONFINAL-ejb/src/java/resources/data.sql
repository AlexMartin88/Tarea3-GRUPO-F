/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  aleex
 * Created: 08-may-2020
 */
 
--MENSAJE--
insert into app.mensaje values (11111,'error inscripcion actividad','he tendio un error y necesito que me ayuden','org@uma.es','pdi@uma.es',1);
insert into app.mensaje values (4444,'error inscripcion actividad','error solucionado','pdi@uma.es','alumno@uma.es',11);
insert into app.mensaje values (3333,'error inscripcion actividad','error solucionado','org@uma.es','pas@uma.es',22);
insert into app.mensaje values (222,'error inscripcion actividad','he tendio un error y necesito que me ayuden','pas@uma.es','org@uma.es',22);
insert into app.mensaje values (4321,'Save Children Respuesta','Ha sido usted rechazado en la Actividad Save children','org@uma.es','pdi@uma.es',1);
insert into app.mensaje values (5431,'Save Children Respuesta','Ha sido usted rechazado en la Actividad Save children','pdi@uma.es','alumno@uma.es',11);
insert into app.mensaje values (66677,'Save Children Respuesta','Ha sido usted rechazado en la Actividad Save children','org@uma.es','pas@uma.es',22);
insert into app.mensaje values (32211,'Respuesta a propuesta de actividad','Propuesta aceptada','pas@uma.es','org@uma.es',22);



--ORGANIZACION--
insert into app.organizacion values (5,null,null,null,null,'Caritas','org',3,'Malibu,Florida',null,'org@uma.es',null,null,null,'Salvar vidas en el mundo',null,null,null);

--USUARIO--
--PDI--
insert into app.usuario values (2,'romero','22222r','1998-01-05','robert',null,'pdi',0,null,'margarita','pdi@uma.es','mecanico','n','ruso',null,11122222,null,null);
--PAS--
insert into app.usuario values (3,'bernabeu','422112u','1991-03-06','roberto carlos',null,'pas',1,null,'zarzamora,3','pas@uma.es','team manegement','dir/foto','espaniol',null,5343,null,null);
--ALUMNO--
insert into app.usuario values (4,'racero','1234482x','1991-06-03','t-bag',null,'alumno',2,null,'maria,5','alumno@uma.es','estudio en bellas artes','dir/foto','español',null,766556,null,null);

insert into app.usuario values (6,null,null,null,null,'Caritas','org',3,'Malibu,Florida',null,'org@uma.es',null,null,null,'Salvar vidas en el mundo',null,null,null);



--NOTICIA--
insert into app.noticia values (550,'Ayudanos a salvar vidas sobre el hambre en el mundo','Salvar vidas','10/05/2020',null,null);
insert into app.noticia values (610,'Ayudanos a salvar el mundo sobre posibles pandemias','Salvar el mundo','11/05/2020',null,null);
insert into app.noticia values (126,'Ayudar a la gente con lo problemas que puedan tener','Todos a una','09/05/2020',null,null);
insert into app.noticia values (890,'Salvar a los niños de posibles enfermadades del continente africano','Save Children','08/04/2020',null,null);



--ORGANIZACION_NOTICIA
--insert into app.organizacion_noticia values (1111,123);
--insert into app.organizacion_noticia values (2222,345);
--insert into app.organizacion_noticia values (3333,678);
--insert into app.organizacion_noticia values (4444,912);


--ACTIVIDAD--
insert into app.ACTIVIDAD values(600,'Conocimientos previos del lavado de mano (Curso Lavado de manos de la Complutense)','Actividad correspondiente al lavado de manos','ABIERTA','ACEPTADA','25/11/2020','21/11/2020','Kuala Lumpur','Hands on Kuala Lumpur',8,'VOLUNTARIADO',5,'ONG que cumple con los estatutos del estado',5,null);

insert into app.ACTIVIDAD values(500,'Tener un grado en medicina','Asistencia sanitaria para ocupar en el hospital Carlo Haya','ABIERTA','ACEPTADA','02/02/2020','21/04/2020','Malaga,Spain','Save life',8,'VOLUNTARIADO',5,'ONG que cumple con los estatutos del estado',5,null);


insert into app.ACTIVIDAD values(860,'Tener una licenciatura en bellas artes','Museo Louvre','ABIERTA','DENEGADA','02/02/2020','21/05/2020','Paris,Francia','Painting',null,'FORMACION',5,'mal planteamiento',5,null);






