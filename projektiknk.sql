create database projektiknk;
use projektiKNK;

CREATE TABLE orari (
  id int(11) NOT NULL auto_increment primary key,
  titlenda varchar(35) DEFAULT NULL,
  ects int(11) DEFAULT NULL,
  profcol varchar(35) DEFAULT NULL,
  asscol varchar(35) DEFAULT NULL,
  ldita varchar(35) DEFAULT NULL,
  lora varchar(35) DEFAULT NULL,
  lsalla int(11) DEFAULT NULL,
  udita varchar(35) DEFAULT NULL,
  uora varchar(35) DEFAULT NULL,
  usalla int(11) DEFAULT NULL,
  nstud varchar(35) DEFAULT NULL,
  departamenti varchar(35) DEFAULT NULL,
  sem varchar(35) DEFAULT NULL,
  grupi varchar(35) DEFAULT NULL
  );

  create table users(
   id integer auto_increment,
   emri varchar(35) NOT NULL,
   mbiemri varchar(35) NOT NULL,
   numriID bigint(20) NOT NULL,
  password varchar(65) NOT NULL,
  primary key (id)
   );

INSERT INTO orari (id, titlenda, ects, profcol, asscol, ldita, lora, lsalla, udita, uora, usalla, nstud, departamenti, sem, grupi) 
VALUES (10, 'Sinjale dhe Sisteme', '5', 'Vjosa Shatri', 'Drilon Bunjaku', 'E hene', '08:00-10:30', '626', 'E marte', '13:00-14:30', '310', 'Bachelor', 'Kompjuterike', 'III', '1'),
 (11, 'Elektronika', '5', 'Myzafere Limani', 'Qamil Kabashi', 'E enjte', '11:00-12:30', '626', 'E premte', '08:00-09:30', '626', 'Bachelor', 'Kompjuterike', 'III', '1'), 
 (12, 'Matematika 3K', '5', 'Qefsere Doko Gjonbalaj', 'Blerta Selimaj', 'E premte', '10:30-12:00', '411', 'E marte', '16:00-17:30', '415', 'Bachelor', 'Kompjuterike', 'III', '1'),
 (13, 'Baza e Te Dhenave', '5', 'Lule Ahmedi', 'Besmir Sejdiu', 'E hene', '10:30-12:00', '621', 'E merkure', '17:30-19:00', '621', 'Bachelor', 'Kompjuterike', 'III', '1'),
 (14, 'Interneti', '5', 'Lule Ahmedi', 'Korab Rrmoku', 'E marte', '08:00-09:30', '626', 'E enjte', '15:00-16:30', '611',  'Bachelor', 'Kompjuterike', 'III', '1'), 
 (15, 'Programimi i Orientuar ne Objekte', '5', 'Isak Shabani', 'Vigan Abdurrahmani', 'E merkure', '11:30-13:00', '626', 'E enjte', '08:00-09:30', '611', 'Bachelor', 'Kompjuterike', 'III', '1'),
 (16, 'Komunikimi Njeri Kompjuter', '5', 'Isak Shabani', 'Vigan Abdurrahmani', 'E hene', '17:00-18:30', '621', 'E marte', '18:30-20:00', '611',  'Bachelor', 'Kompjuterike', 'IV', '2'),
 (17, 'Rrjeta Kompjuterike', '5', 'Blerim Rexha', 'Haxhi Lajqi', 'E marte', '08:15-09:45', '621', 'E enjte', '16:00-17:30', '626', 'Bachelor', 'Kompjuterike', 'IV', '2'), 
 (18, 'Siguria e Te Dhenave', '5', 'Blerim Rexha', 'Arbnor Halili', 'E merkure', '08:15-09:45', '621', 'E merkure','11:30-13:00', '615',  'Bachelor', 'Kompjuterike', 'IV', '2'),
 (19, 'Arkitektura e Kompjutereve', '5', 'Valon Raca', 'Vlera Alimehaj', 'E enjte', '13:30-15:00', '621', 'E premte', '13:30-15:00', '621', 'Bachelor', 'Kompjuterike', 'IV','2' ),
 (20, 'Programimi ne Internet,' , '5','Valon Raca','Dardan Shabani','E merkure','13:30-15:00','621','E enjte','09:30-11:00', '621', 'Bachelor','Kompjuterike','IV','2')
 ;
 
 select * from orari;





 INSERT INTO users(id,emri,mbiemri,numriID,password)
 VALUES
 (1,'Festim','Braha',190714100099,'admin'),
 (9,'admin','admin',1,'test');

 
 select * from users;
