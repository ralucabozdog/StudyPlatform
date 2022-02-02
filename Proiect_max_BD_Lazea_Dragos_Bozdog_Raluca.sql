drop schema universitate;

create schema universitate;

use universitate;

create table universitate.utilizator (
id int not null auto_increment,
    cnp char(13) not null,
    nume varchar(45) not null,
    prenume varchar(45) not null,
    adresa varchar(100) not null,
    nrTelefon char(12) not null,
    email varchar(45) not null,
    iban varchar(34) not null,
    nrContract varchar(45) not null,
    tipUtilizator int not null,							-- 0 pentru student, 1 pentru profesor, 2 pentru administrator, 3 pentru super-administrator
    parola varchar(45) not null default "defaultpassword",
   
    primary key(id)
);

create table universitate.activitatepredare (
id int not null auto_increment,
    idProf int not null,
    idProfCurs int not null default 0,
    idMaterie int not null,
    tipActivitate int, -- 0 pentru curs, 1 pentru seminar, 2 pentru laborator
    pondere int not null default 0,
    dataStart date,
    dataFinal date,
    recurenta varchar(45) not null default "săptămânal",
    ora time,
    nrMaxStudenti int not null default 150,
    nrCurentStudenti int not null default 0,
   
    primary key(id)
);

create table universitate.departament (
id int not null auto_increment,
    nume varchar(45),
    
    primary key(id)
);

create table universitate.materie (
id int not null auto_increment,
    nume varchar(45) not null,
    descriere text,
   
    primary key(id)
);

create table universitate.inscriereactivitatipredare (
id int not null auto_increment,
    idStudent int not null,
    idActivitate int not null,
	nota int not null default 0,
    primary key(id)
);

create table universitate.listaactivitati (
id int not null auto_increment,
    idStudent int not null,
    idActivitateGrup int not null,
   
    primary key(id)
);

create table universitate.activitategrup (
id int not null auto_increment,
	idGrupStudiu int not null,
    idProfesor int,
    dataDesfasurare date not null,
    ora time not null,
    durata float,
    timpExpirare float,
    nrMinStudenti int,
    nrCurentStudenti int default 0,
    momentCreare datetime default now(),
        
    primary key(id)
);

create table universitate.grupstudiu (
id int not null auto_increment,
    idMaterie int not null,
    nume varchar(45),
   
    primary key(id)
);

create table universitate.catalog (
id int not null auto_increment,
    idStudent int not null,
    idMaterie int not null,
    nota int not null default 0,
    
    primary key(id)
);

create table universitate.student(
id int not null auto_increment,
	idUtilizator int not null,
	anStudiu int not null default 1,
    nrOre int not null default 30,
   
primary key(id)
);

create table universitate.profesor(
id int not null auto_increment,
	idUtilizator int not null,
    nrMinOre int not null default 18,
    nrMaxOre int not null default 26,
    idDepartament int not null default 1,
   
primary key(id)
);

create table universitate.administrator(
id int not null auto_increment,
	idUtilizator int not null,
   
    primary key(id)
);

create Table universitate.superadministrator(
id int not null auto_increment,
	idUtilizator int not null,
   
    primary key(id)
);

create table universitate.mesajeroare(
id int not null auto_increment,
    mesaj varchar(200),
   
    primary key(id)
);

create table universitate.mesaje( 
id int not null auto_increment,
	idUtilizator int not null,
	idGrup int not null,
    mesaj text,
   
    primary key(id)
);

create table universitate.listagrupuri(
id int not null auto_increment,
	idStudent int not null,
    idGrup int not null,
    
    primary key(id)
);

create table universitate.calendarGrupuri(
id int not null auto_increment,
    idActivitateGrup int not null,
    dataDesfasurare int not null,
    
    primary key(id)
);

create table universitate.calendarPredare(
id int not null auto_increment,
    idActivitatePredare int not null,
    dataDesfasurare int not null,
    
    primary key(id)
);

create table universitate.atribuireCalendarPredare(
id int not null auto_increment,
    idUtilizator int not null,
    idCalendar int not null,
    primary key(id)
);

create table universitate.atribuireCalendarGrup(
id int not null auto_increment,
    idUtilizator int not null,
    idCalendar int not null,
    
    primary key(id)
);

alter table profesor
add constraint ut
foreign key (idUtilizator)
references utilizator (id);

alter table administrator
add constraint ad
foreign key (idUtilizator)
references utilizator (id);

alter table superadministrator
add constraint superad
foreign key (idUtilizator)
references utilizator (id);

alter table student
add constraint std
foreign key (idUtilizator)
references utilizator (id);

alter table profesor
add constraint departament
foreign key (idDepartament)
references departament (id);

alter table inscriereactivitatipredare
add constraint student
foreign key (idStudent)
references student (id);

alter table inscriereactivitatipredare
add constraint activitate_predare
foreign key (idActivitate)
references activitatepredare (id);

alter table listaactivitati
add constraint student_activitate
foreign key (idStudent)
references student (id);

alter table listaactivitati
add constraint activitateGrup
foreign key (idActivitateGrup)
references activitategrup (id);

alter table activitategrup
add constraint grup
foreign key (idGrupStudiu)
references grupstudiu (id);

alter table grupstudiu
add constraint grup_materie
foreign key (idMaterie)
references materie (id);

alter table activitatepredare
add constraint profesor
foreign key (idProf)
references profesor (id);

alter table activitatepredare
add constraint profesor_curs
foreign key (idProfCurs)
references profesor (id);

alter table activitatepredare
add constraint materie_activitate
foreign key (idMaterie)
references materie (id);

alter table catalog
add constraint materie_catalog
foreign key (idMaterie)
references materie (id);

alter table catalog
add constraint student_catalog
foreign key (idStudent)
references student (id);

alter table listagrupuri
add constraint grup_student
foreign key (idStudent)
references student (id);

alter table listagrupuri
add constraint student_grup
foreign key (idGrup)
references grupstudiu (id);

alter table mesaje
add constraint emitator
foreign key (idUtilizator)
references Utilizator(id);

alter table mesaje
add constraint mesaj_grup
foreign key (idGrup)
references grupstudiu(id);

alter table activitategrup
add constraint prof_grup
foreign key (idProfesor)
references profesor(id);

alter table calendarGrupuri
add constraint grup_calendar
foreign key (idActivitateGrup)
references activitategrup(id);


alter table atribuirecalendargrup
add constraint calendargrup_user
foreign key (idUtilizator)
references utilizator(id);

alter table atribuirecalendargrup
add constraint calendargrup_calendar
foreign key (idCalendar)
references calendargrupuri(id);

alter table atribuirecalendarpredare
add constraint calendarpredare_user
foreign key (idUtilizator)
references utilizator(id);

alter table atribuirecalendarpredare
add constraint calendarpredare_calendar
foreign key (idCalendar)
references calendarpredare(id);

-- triggere
-- drop trigger inserare_student;

delimiter //
create trigger inserare_student after insert on utilizator
for each row
begin
declare i int;
if (new.id in (select id from utilizator where tipUtilizator = 0)) then
select id from utilizator where id = new.id into i;
insert into student (idUtilizator) values (i);
end if;
end
//
delimiter ;

-- drop trigger inserare_student;

delimiter //
create trigger inserare_profesor after insert on utilizator
for each row
begin
declare i int;
if (new.id in (select id from utilizator where tipUtilizator = 1)) then
select id from utilizator where id = new.id into i;
insert into profesor (idUtilizator) values (i);
end if;
end
//
delimiter ;
   
-- select * from profesor;

delimiter //
create trigger inserare_administrator after insert on utilizator
for each row
begin
declare i int;
if (new.id in (select id from utilizator where tipUtilizator = 2)) then
select id from utilizator where id = new.id into i;
insert into administrator (idUtilizator) values (i);
end if;
end
//
delimiter ;

delimiter //
create trigger inserare_superadministrator after insert on utilizator
for each row
begin
declare i int;
if (new.id in (select id from utilizator where tipUtilizator = 3)) then
select id from utilizator where id = new.id into i;
insert into superadministrator (idUtilizator) values (i);
end if;
end
//
delimiter ;

delimiter //
create trigger generare_calendar_grup after insert on activitategrup
for each row
begin
    declare idA int;
    declare dataA date;
    select max(id) from activitategrup into idA;
    select dataDesfasurare from activitategrup where activitategrup.id = idA into dataA;
    insert into calendargrupuri (idActivitateGrup, dataActivitate) values (idA, dataA);
end //
delimiter ;

#drop trigger generare_calendar_grup;
#insert into activitategrup(idGrupStudiu, dataDesfasurare, ora) values (1, "2021-02-03", "10:00:00");

delimiter //
create trigger generare_calendar_predare after insert on activitatepredare
for each row
begin
    declare idA, idP, idU int;
    declare dataS, dataF, dataC date;
    declare nrZile, idCal int;
    declare rec varchar(45);
    
    select max(id) from activitatepredare into idA;
    select idProf from activitatepredare where activitatepredare.id = idA into idP;
    select idUtilizator from profesor where profesor.id = idP into idU;
    select dataStart from activitatepredare where activitatepredare.id = idA into dataS;
    select dataFinal from activitatepredare where activitatepredare.id = idA into dataF;
    select recurenta from activitatepredare where activitatepredare.id = idA into rec;
    
    set dataC = dataS;
    
    if(rec = "saptamanal") then
        set nrZile = 7;
    else
        set nrZile = 14;
    end if;
    
    loop_label:
        loop
            insert into calendarpredare (idActivitatePredare, dataActivitate) values (idA, dataC);
            
            select max(id) from calendar into idCal;
            insert into atribuirecalendarpredare (idUtilizator, idCalendar) values (idU, idCal);
            
            set dataC = date_add(dataC, interval nrZile day);            
            
            if(dataC >= dataF) then
                leave loop_label;
            end if;
        end loop;
end //
delimiter ;

 

#drop trigger generare_calendar_predare;
#insert into activitatepredare(idProf, idProfCurs, idMaterie, tipActivitate, dataStart, dataFinal, recurenta, ora) values (13, 13, 3, 0, "2021-01-15", "2021-05-23", "saptamanal", "02:27:59");


#drop procedure toateMateriileProfesorului;
#call toateMateriileProfesorului(1);

 

create event verificareActivitateGrup
on schedule every 30 minute
starts '2021-01-10 20:56:00'
do
    delete from activitategrup
    where date_add(activitategrup.momentCreare, interval activitategrup.timpExpirare hour) <= now() and activitategrup.nrCurentStudenti < activitategrup.nrMinStudenti;
    
create event verificareListaActivitati
on schedule every 30 minute
starts '2021-01-10 20:55:00'
do
    delete from listaactivitati 
    where listaactivitati.idActivitateGrup in
    (select activitategrup.id from activitategrup
    where date_add(activitategrup.momentCreare, interval activitategrup.timpExpirare hour) <= now() and activitategrup.nrCurentStudenti < activitategrup.nrMinStudenti);
    
#drop event verificareListaActivitati;
#set global event_scheduler = on;



-- proceduri
delimiter //
create procedure adaugareUser(cnp char(13), nume varchar(45), prenume varchar(45), adresa varchar(100), telefon char(12), email varchar(45), iban varchar(34), contract varchar(45), tip int, out mesajerr varchar(200))
begin
declare exista_cnp, exista_mail int;
set exista_cnp = 0;
    set exista_mail = 0;
    select count(utilizator.cnp) from utilizator where utilizator.cnp = cnp into exista_cnp;
    select count(utilizator.email) from utilizator where utilizator.email = email into exista_mail;
    set mesajerr = null;
    if (exista_cnp = 0 and exista_mail = 0) then
if (length(cnp) <> 13) then
select mesaj from mesajeroare where mesajeroare.id = 16 into mesajerr;
else
if (length(iban) <> 34) then
select mesaj from mesajeroare where mesajeroare.id = 18 into mesajerr;
else
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator) values (cnp, nume, prenume, adresa, telefon, email, iban, contract, tip);
end if;
end if;
    else
select mesaj from mesajeroare where mesajeroare.id = 21 into mesajerr;
    end if;
end //

delimiter ; 

-- drop procedure adaugareUser;

-- delimiter //
-- call adaugareUser("2601223127456", "Popescu", "Maria", "Blaj", "0759582093", "popescumaria@gmail.com", "4856880134510814568popm765mn684m21", "a07", 1, @mesajerr);
-- select @mesajerr;
-- //
-- delimiter ;

delimiter //
create procedure autentificare(
emailUser varchar(45),
    parolaUser varchar(45),
    out numeUser varchar(45),
    out prenumeUser varchar(45),
    out cnpUser char(13),
    out telefonUser char(12),
    out adrEmailUser varchar(45),
    out adresaUser varchar(100),
    out ibanUser varchar(34),
    out contractUser varchar(45),
    out tipUser int,
    out mesajerr varchar(200)
    )
begin
declare exista_email int;
    select count(utilizator.email) from utilizator where utilizator.email = email into exista_email;
    if (exista_email <> 0) then
if (parolaUser in (select parola from utilizator where utilizator.email = emailUser)) then
select nume from utilizator where utilizator.email = emailUser into numeUser;
            select prenume from utilizator where utilizator.email = emailUser into prenumeUser;
            select cnp from utilizator where utilizator.email = emailUser into cnpUser;
            select nrTelefon from utilizator where utilizator.email = emailUser into telefonUser;
            select adresa from utilizator where utilizator.email = emailUser into adresaUser;
            select email from utilizator where utilizator.email = emailUser into adrEmailUser;
            select iban from utilizator where utilizator.email = emailUser into ibanUser;
            select nrContract from utilizator where utilizator.email = emailUser into contractUser;
            select tipUtilizator from utilizator where utilizator.email = emailUser into tipUser;
            set mesajerr = null;
else
select mesaj from mesajeroare where mesajeroare.id = 1 into mesajerr;
        end if;
    else
select mesaj from mesajeroare where mesajeroare.id = 1 into mesajerr;
end if;
end //
delimiter ; 

-- drop procedure autentificare;

-- call autentificare("vacariulucia@gmail.com", "profesor6", @nume, @prenume, @cnp, @telefon, @adrEmail, @adresa, @iban, @contract, @tip, @mesajerr);
-- select @nume, @prenume, @cnp, @telefon, @adrEmail, @adresa, @iban, @contract, @tip, @mesajerr;

delimiter //
create procedure asignareProfCurs(
numeProf varchar(45),
    prenumeProf varchar(45),
    contractProf varchar(45), -- ca sa ne asiguram ca e unic
    numeCurs varchar(45),
    tipAct varchar(45),
    out mesajerr varchar(200)
)
begin
declare idPr, idUser, idCurs, existaProf, existaCurs, tipA int;
    set existaProf = 0;
    set mesajerr = null;
    select count(id) from utilizator where utilizator.nume = numeProf and utilizator.prenume = prenumeProf and utilizator.tipUtilizator = 1 and utilizator.nrContract = contractProf into existaProf;
    if (existaProf = 0) then
select mesaj from mesajeroare where mesajeroare.id = 6 into mesajerr;
else
select count(id) from materie where materie.nume = numeCurs into existaCurs;
        if (existaCurs = 0) then
select mesaj from mesajeroare where mesajeroare.id = 7;
else
select id from utilizator where utilizator.nrContract = contractProf into idUser;
            select id from profesor where idUtilizator = idUser into idPr;
            select id from materie where materie.nume = numeCurs into idCurs;
            if (tipAct = "laborator") then
set tipA = 2;
else
if (tipAct = "seminar") then
set tipA = 1;
else
set tipA = 0;
end if;
            end if;
insert into activitatepredare(idMaterie, idProf, tipActivitate) values (idCurs, idPr, tipA);
        end if;
    end if;
end //
delimiter ;

-- drop procedure asignareProfCurs;

delimiter //
create procedure creareCont(
	email varchar(45),
    parola varchar(45),
    confirmaParola varchar(45),
    parolaVeche varchar(45),
    out mesajEroare varchar(200)
)
begin
	declare i int;
    declare parolaV varchar(45);
    set i = 0;
    
    if(parola <> confirmaParola) then
		select mesaj from mesajeroare where id = 23 into mesajEroare;
	end if;
    select id from utilizator where email = utilizator.email into i;
    if (i <> 0) then
		select utilizator.parola from utilizator where utilizator.id = i into parolaV;
        if(parolaV = parolaVeche) then
			update utilizator set utilizator.parola = parola where id = i;
		else
			select mesaj from mesajeroare where id = 1 into mesajEroare;
		end if;
	else
		select mesaj from mesajeroare where id = 24 into mesajEroare;
    end if;
end//
delimiter ;

#drop procedure creareCont;
#call creareCont("blagacristian@gmail.com", "alabalaportocala", "alabalaportocala", "student2", @mesajEroare);
#select @mesajEroare;

delimiter //
create procedure incarcareProcentuala(
	idMaterie int,
    idProfCurs int,
    procentCurs int,
    procentLab int,
    procentSeminar int,
    out mesajEroare varchar(200)
)
begin
	declare suma int;
    declare este int;
    set suma = procentCurs + procentLab + procentSeminar;
    if(suma <> 100) then
		select mesaj from mesajeroare where id = 15 into mesajEroare;
	else
		if(procentCurs < 0 or procentCurs > 100 or procentLab < 0 or procentLab > 100 or procentSeminar < 0 or procentSeminar > 100) then
			select mesaj from mesajeroare where id = 14 into mesajEroare;
        else
			call esteProfCurs(idProfCurs, idMaterie, este);
            if(este) then
				update activitatepredare set pondere = procentCurs 	  where activitatepredare.idProfCurs = idProfCurs and activitatepredare.idMaterie = idMaterie and activitatepredare.tipActivitate = 0;
				update activitatepredare set pondere = procentLab	  where activitatepredare.idProfCurs = idProfCurs and activitatepredare.idMaterie = idMaterie and activitatepredare.tipActivitate = 1;
				update activitatepredare set pondere = procentSeminar where activitatepredare.idProfCurs = idProfCurs and activitatepredare.idMaterie = idMaterie and activitatepredare.tipActivitate = 2;
			else
				select mesaj from mesajeroare where id = 35 into mesajEroare;
			end if;
		end if;
    end if;
end//
delimiter ;

#drop procedure incarcareProcentuala;

#call incarcareProcentuala(2, 1, 70, 20, 10, @mesajEroare);
#call incarcareProcentuala(13, 3, 60, 0, 40, @mesajEroare);
#select @mesajEroare;

delimiter //
create procedure esteProfCurs(idProf int, idMaterie int, out este boolean)
begin
	if((select activitatepredare.id from activitatepredare where activitatepredare.idProfCurs = idProf and activitatepredare.idMaterie = idMaterie limit 1) is null) then
		select false into este;
	else
		select true into este;
	end if;    
end //
delimiter ;

#drop procedure esteProfCurs;
#call esteProfCurs(13, 4, @este);
#select @este;

delimiter //

create procedure calculMedie (idMaterie int, idStudent int)
begin
	declare idCurs, idLab, idSeminar, procCurs, procLab, procSeminar, notaCurs, notaLab, notaSeminar int;
    declare nota float;
    set idCurs = 0;
    set idLab = 0;
    set idSeminar = 0;
    set nota = 0;
    set notaCurs = 0;
    set notaLab = 0;
    set notaSeminar = 0;
    set procCurs = 0;
    set procLab = 0;
    set procSeminar = 0;
    
     select id from activitatepredare
			where activitatepredare.id in 
				(select idActivitate from inscriereactivitatipredare where inscriereactivitatipredare.idStudent = idStudent)
			and activitatepredare.idMaterie = idMaterie and activitatepredare.tipActivitate = 0
		into idCurs;
    
    select id from activitatepredare
			where activitatepredare.id in 
				(select idActivitate from inscriereactivitatipredare where inscriereactivitatipredare.idStudent = idStudent)
			and activitatepredare.idMaterie = idMaterie and activitatepredare.tipActivitate = 1
    into idLab;
    
	select id from activitatepredare
			where activitatepredare.id in 
				(select idActivitate from inscriereactivitatipredare where inscriereactivitatipredare.idStudent = idStudent)
			and activitatepredare.idMaterie = idMaterie and activitatepredare.tipActivitate = 2
    into idSeminar;
    
    if(idCurs > 0) then
		select pondere from activitatepredare where id = idCurs into procCurs;
        select inscriereactivitatipredare.nota from inscriereactivitatipredare where inscriereactivitatipredare.idActivitate = idCurs and inscriereactivitatipredare.idStudent = idStudent into notaCurs;
    end if;
    
    if(idLab > 0) then
		select pondere from activitatepredare where id = idLab into procLab;
        select inscriereactivitatipredare.nota from inscriereactivitatipredare where inscriereactivitatipredare.idActivitate = idLab and inscriereactivitatipredare.idStudent = idStudent into notaLab;
    end if;
    
    if(idSeminar > 0) then
		select pondere from activitatepredare where id = idSeminar into procSeminar;
        select inscriereactivitatipredare.nota from inscriereactivitatipredare where inscriereactivitatipredare.idActivitate = idSeminar and inscriereactivitatipredare.idStudent = idStudent into notaSeminar;
    end if;
    set nota = (notaCurs * procCurs + notaLab * procLab + notaSeminar * procSeminar) / 100;
    update catalog set catalog.nota = nota where catalog.idMaterie = idMaterie and catalog.idStudent = idStudent;
    
end//
delimiter ;
#drop procedure calculMedie;
#call calculMedie(4, 1);

delimiter //
create procedure creareGrup(idMaterie int, numeGrup varchar(45))
begin
	insert into grupstudiu (idMaterie, nume) values (idMaterie, numeGrup);
end //
delimiter ;

#call creareGrup(3, "ALGA partial");

delimiter //
create procedure inscriereGrup(idStudent int, idGrup int, out mesajEroare varchar(200))
begin
	declare areMateria, materieGrup, inscrisDeja int;
    set areMateria = 0;
    set inscrisDeja = 0;
    select listagrupuri.id from listagrupuri where listagrupuri.idStudent = idStudent and listagrupuri.idGrup = idGrup into inscrisDeja;
    if(inscrisDeja <> 0) then
		select mesajeroare.mesaj from mesajeroare where id = 32 into mesajEroare;
	else
		select grupstudiu.idMaterie from grupstudiu where grupstudiu.id = idGrup into materieGrup;
		select catalog.id from catalog where catalog.idMaterie = materieGrup and catalog.idStudent = idStudent into areMateria;
		if(areMateria <> 0) then
			insert into listagrupuri (idStudent, idGrup) values (idStudent, idGrup);
		else
			select mesajeroare.mesaj from mesajeroare where id = 31 into mesajEroare;
		end if;
	end if;
end//
delimiter ;

#drop procedure inscriereGrup;
#call inscriereGrup(1,2, @mesajEroare);
#select @mesajEroare;

delimiter //
create procedure toateGrupurile()
begin
	select grupstudiu.id, " ", grupstudiu.nume, "   -   ", materie.nume from grupstudiu, materie 
    where materie.id = grupstudiu.idMaterie
    into outfile "toate_grupurile.txt";
end //
delimiter ;

#drop procedure toateGrupurile;
#call toateGrupurile();

delimiter //
create procedure adaugareNota(idStudent int, idMaterie int, tipActivitate int, nota float, out mesajEroare varchar(200))
begin
	declare idA, idVerificare int;
	set idA = 0, idVerificare = 0;
	if(nota < 0) then 
		select mesaj from mesajeroare where id = 3 into mesajEroare;
	else
		if(idStudent not in (select id from student)) then
			select mesaj from mesajeroare where id = 2 into mesajEroare;
		else
			select id from activitatepredare where activitatepredare.idMaterie = idMaterie and activitatepredare.tipActivitate = tipActivitate into idVerificare;
            if(idVerificare = 0) then
				select mesaj from mesajeroare where id = 4 into mesajEroare;
			else
				select id from activitatepredare
					where activitatepredare.id in 
						(select idActivitate from inscriereactivitatipredare where inscriereactivitatipredare.idStudent = idStudent)
					and activitatepredare.idMaterie = idMaterie and activitatepredare.tipActivitate = tipActivitate
				into idA;
				if(idA = 0) then 
					select mesaj from mesajeroare where id = 25 into mesajEroare;
				else
					update inscriereactivitatipredare set inscriereactivitatipredare.nota = nota where inscriereactivitatipredare.idStudent = idStudent and inscriereactivitatipredare.idActivitate = idA;
				end if;
			end if;
		end if;
	end if;
end//
delimiter ;

#drop procedure adaugareNota;

#call adaugareNota(1,4,0,10,@mesajEroare);
#call adaugareNota(9,4,0,10,@mesajEroare);

delimiter //
create procedure inscriereCurs (idStudent int, idMaterie int, out mesajEroare varchar(200))
begin
	declare cursMin, labMin, seminarMin, idCurs, idLab, idSeminar, maxCurs, maxLab, maxSeminar int;
    set cursMin = 151, labMin = 151, seminarMin = 151, idCurs = 0, idLab = 0, idSeminar = 0, maxCurs = 0, maxLab = 0, maxSeminar = 0;
	if(idStudent not in (select id from student)) then
		select mesaj from mesajeroare where id = 2 into mesajEroare;
	else
		insert into catalog (idStudent, idMaterie) values (idStudent, idMaterie);
        
        select min(nrCurentStudenti) from activitatepredare where activitatepredare.idMaterie = idMaterie and tipActivitate = 0 limit 1 into cursMin;
		select min(nrCurentStudenti) from activitatepredare where activitatepredare.idMaterie = idMaterie and tipActivitate = 1 limit 1 into labMin;      
		select min(nrCurentStudenti) from activitatepredare where activitatepredare.idMaterie = idMaterie and tipActivitate = 2 limit 1 into seminarMin;
        
        select id from activitatepredare where activitatepredare.idMaterie = idMaterie and tipActivitate = 0 and nrCurentStudenti = cursMin limit 1 into idCurs;
        select id from activitatepredare where activitatepredare.idMaterie = idMaterie and tipActivitate = 1 and nrCurentStudenti = labMin limit 1 into idLab;
        select id from activitatepredare where activitatepredare.idMaterie = idMaterie and tipActivitate = 2 and nrCurentStudenti = seminarMin limit 1 into idSeminar;
        
        select nrMaxStudenti from activitatepredare where activitatepredare.id = idCurs limit 1 into maxCurs;
        select nrMaxStudenti from activitatepredare where activitatepredare.id = idLab limit 1 into maxLab;
        select nrMaxStudenti from activitatepredare where activitatepredare.id = idSeminar limit 1 into maxSeminar;
        
        if(idCurs > 0 and cursMin + 1 <= maxCurs) then
			insert into inscriereactivitatipredare(idStudent, idActivitate) values (idStudent, idCurs);
            update activitatepredare set nrCurentStudenti = nrCurentStudenti + 1 where id = idCurs;
		end if;
        
        if(idLab > 0 and labMin + 1 <= maxLab) then
			insert into inscriereactivitatipredare(idStudent, idActivitate) values (idStudent, idLab);
			update activitatepredare set nrCurentStudenti = nrCurentStudenti + 1 where id = idLab;
		end if;
        
        if(idSeminar > 0 and seminarMin + 1 <= maxSeminar) then
			insert into inscriereactivitatipredare(idStudent, idActivitate) values (idStudent, idSeminar);
            update activitatepredare set nrCurentStudenti = nrCurentStudenti + 1 where id = idSeminar;
		end if;
	end if;
end//
delimiter ;

#call inscriereCurs(13, 3, @mesajEroare);
#call inscriereCurs(13, 4, @mesajEroare);
#call inscriereCurs(1, 1, @mesajEroare);
#call inscriereCurs(1, 4, @mesajEroare);
#call inscriereCurs(9, 4, @mesajEroare);
#call inscriereCurs(1, 2, @mesajEroare);
#call inscriereCurs(7, 2, @mesajEroare);

#drop procedure inscriereCurs;

delimiter //
create procedure renuntareCurs(idStudent int, idMaterie int, out mesajEroare varchar(200))
begin
	declare idCurs, idLab, idSeminar int;
    set idCurs = 0, idLab = 0, idSeminar = 0;
	if(idStudent not in (select id from student)) then
		select mesaj from mesajeroare where id = 2 into mesajEroare;
	else
		delete from catalog where catalog.idStudent = idStudent and catalog.idMaterie = idMaterie;
        
        select id from activitatepredare
			where activitatepredare.id in 
				(select idActivitate from inscriereactivitatipredare where inscriereactivitatipredare.idStudent = idStudent)
			and activitatepredare.idMaterie = idMaterie and activitatepredare.tipActivitate = 0
		into idCurs;
                
		select id from activitatepredare
			where activitatepredare.id in 
				(select idActivitate from inscriereactivitatipredare where inscriereactivitatipredare.idStudent = idStudent)
			and activitatepredare.idMaterie = idMaterie and activitatepredare.tipActivitate = 1
		into idLab;
                
		select id from activitatepredare
			where activitatepredare.id in 
				(select idActivitate from inscriereactivitatipredare where inscriereactivitatipredare.idStudent = idStudent)
			and activitatepredare.idMaterie = idMaterie and activitatepredare.tipActivitate = 2
		into idSeminar;
                
		if(idCurs > 0) then
			delete from inscriereactivitatipredare where inscriereactivitatipredare.idStudent = idStudent and inscriereactivitatipredare.idActivitate = idCurs;
            update activitatepredare set nrCurentStudenti = nrCurentStudenti - 1 where id = idCurs;
		end if;
        
        if(idLab > 0) then
			delete from inscriereactivitatipredare where inscriereactivitatipredare.idStudent = idStudent and inscriereactivitatipredare.idActivitate = idLab;
			update activitatepredare set nrCurentStudenti = nrCurentStudenti - 1 where id = idLab;
		end if;
        
        if(idSeminar > 0) then
			delete from inscriereactivitatipredare where inscriereactivitatipredare.idStudent = idStudent and inscriereactivitatipredare.idActivitate = idSeminar;
            update activitatepredare set nrCurentStudenti = nrCurentStudenti - 1 where id = idSeminar;
		end if;       
		
    end if;
end//
delimiter ;

#call renuntareCurs(13, 4, @mesajEroare);
#call renuntareCurs(7, 2, @mesajEroare);
#drop procedure renuntareCurs;

delimiter //
create procedure modificareDate(
emailUser varchar(45),
    newNume varchar(45),
    newPrenume varchar(45),
    newCnp char(13),
    newTelefon char(12),
-- newEmail varchar(45)
    newAdresa varchar(100),
    newIban char(34),
    newNrContract varchar(45),
    out mesajerr varchar(200)
)
begin
declare exista int;
    select count(id) from utilizator where utilizator.email = emailUser into exista;
    set mesajerr = null;
    if (exista = 0) then
select mesaj from mesajeroare where mesajeroare.id = 24 into mesajerr;
else
if (length(newCnp) <> 13) then
select mesaj from mesajeroare where mesajeroare.id = 16 into mesajerr;
else
if (length(newIban) <> 34) then
select mesaj from mesajeroare where mesajeroare.id = 18 into mesajerr;
else
update utilizator set nume = newNume, prenume = newPrenume, cnp = newCnp, iban = newIban, nrTelefon = newTelefon, adresa = newAdresa, nrContract = newNrContract
                where utilizator.email = emailUser;
end if;
end if;
    end if;
end //

delimiter ;

-- drop procedure modificareDate;

delimiter //
create procedure stergereInformatii(
emailUser varchar(45),
    out mesajerr varchar(200)
)
begin
declare exista, idUser, tip int;
    set exista = 0;
    set mesajerr = null;
    select count(id) from utilizator where utilizator.email = emailUser into exista;
    if (exista <> 0) then
select id from utilizator where utilizator.email = emailUser into idUser;
        select tipUtilizator from utilizator where utilizator.email = emailUser into tip;
        if (tip = 0) then
delete from student where idUtilizator = idUser;
else
if (tip = 1) then
delete from profesor where idUtilizator = idUser;
else
if (tip = 2) then
delete from administrator where idUtilizator = idUser;
end if;
end if;
end if;
delete from utilizator where utilizator.email = emailUser;
else
select mesaj from mesajeroare where mesajeroare.id = 24;
end if;
end //

delimiter ;
-- drop procedure stergereInformatii;
-- select * from utilizator;

-- call stergereInformatii("vargarobert@gmail.com", @mesajerr);
-- select @mesajerr;

delimiter //
create procedure adaugareDetaliiProfesor(
emailUser varchar(45),
    minOre int,
    maxOre int,
    dep varchar(45),
    out mesajerr varchar(200)
)
begin
declare existaProf, existaDep, idUser, idDep int;
    set existaProf = 0;
    set existaDep = 0;
    set mesajerr = null;
    select count(id) from utilizator where utilizator.email = emailUser and tipUtilizator = 1 into existaProf;
    select count(id) from departament where departament.nume = dep into existaDep;
    if (existaProf = 1) then
select id from utilizator where utilizator.email = emailUser and tipUtilizator = 1 into idUser;
        if (existaDep <> 0) then
select id from departament where departament.nume = dep into idDep;
            if (minOre > maxOre) then
select mesaj from mesajeroare where mesajeroare.id = 27;
else
update profesor set nrMinOre = minOre, nrMaxOre = maxOre, idDepartament = idDep where profesor.idUtilizator = idUser;
end if;
else
select mesaj from mesajeroare where mesajeroare.id = 26;
end if;
else
select mesaj from mesajeroare where mesajeroare.id = 6;
end if;
end //

delimiter ;

-- call adaugareDetaliiProfesor("popadorian@gmail.com", 16, 28, "Matematica", @mesajerr);
-- select @mesajerr;
-- select * from profesor;
-- select * from utilizator;

delimiter //
create procedure adaugareDetaliiStudent(
emailUser varchar(45),
an int,
    ore int,
    out mesajerr varchar(200)
)
begin
declare exista, idUser int;
    set exista = 0;
    set mesajerr = null;
    select count(id) from utilizator where utilizator.email = emailUser and tipUtilizator = 0 into exista;
    if (exista = 0) then
select mesaj from mesajeroare where mesajeroare.id = 2 into mesajerr;
else
select id from utilizator where utilizator.email = emailUser and tipUtilizator = 0 into idUser;
update student set anStudiu = an, nrOre = ore where student.idUtilizator = idUser;
end if;
end //

delimiter ;

-- call adaugareDetaliiStudent("amarieigeorg@gmail.com", 2, 26, @mesajerr);
-- select @mesajerr;

-- select * from mesajeroare;

delimiter //
create procedure adaugareMaterie(numeMat varchar(45), descr text, out mesajerr varchar(200))
begin
declare exista int;
    set exista = 0;
    set mesajerr = null;
select count(id) from materie where materie.nume = numeMat into exista;
    if (exista = 0) then
insert into materie(nume, descriere) values(numeMat, descr);
else
select mesaj from mesajeroare where mesajeroare.id = 28 into mesajerr;
end if;
end //

delimiter ;

-- call adaugareMaterie("Pedagogie", "Disciplina optionala", @mesajerr);
-- select @mesajerr;
-- select * from materie;
-- drop procedure adaugareMaterie;

delimiter //
create procedure trimitereMesaj(
msj varchar(200),
    idUser int,
    idGr varchar (45)
)
begin
declare existaUser, existaGrup int;
    set existaUser = 0;
    set existaGrup = 0;
    select count(id) from grupstudiu where grupstudiu.id = idGr into existaGrup;
    select count(id) from utilizator where utilizator.id = idUser into existaUser;
    
	insert into mesaje(idUtilizator, idGrup, mesaj) values (idUser, idGr, msj);

end //
delimiter ;

#drop procedure trimitereMesaj;
#call trimitereMesaj("bla bla", 14, 1);

delimiter //
create procedure descarcareCatalog()
begin
	select utilizator.nume, " ", utilizator.prenume, " ", materie.nume," ", catalog.nota from utilizator, materie, catalog
    where materie.id = idMaterie
    and utilizator.id in (select idUtilizator from student, catalog where student.id = catalog.idStudent)
    into outfile "catalog.txt";
end//
delimiter ;

#insert into catalog (idStudent, idMaterie, nota) values (1, 2, 7);
#select * from catalog;
#drop procedure descarcareCatalog;
#call descarcareCatalog();

delimiter //
create procedure vizualizareNoteStudent(idStudent int, out mesajEroare varchar(45))
begin
	declare idS int;
    set idS = 0;
    select id from student where id in (select idStudent from catalog) into idS;
    if (idS = 0) then
		select mesaj from mesajeroare where id = 2 into mesajEroare;
	else
		select distinct materie.nume, "      ", catalog.nota from catalog, materie 
        where catalog.idStudent = idStudent
        and materie.id = catalog.idMaterie
        into outfile "note_student.txt";
    end if;
end//
delimiter ;

#drop procedure vizualizareNoteStudent;
#call vizualizareNoteStudent(9, @mesajEroare);
#call vizualizareNoteStudent(1, @mesajEroare);
#select @mesajEroare;

delimiter //
create procedure vizualizareNoteProfesor(idProf int, out mesajEroare varchar(200))
begin
	declare idP int;
    set idP = 0;
    select id from profesor where profesor.id = idProf into idP;
    if (idP = 0) then
		select mesaj from mesajeroare where id = 6 into mesajEroare;
	else
		select distinct utilizator.nume, utilizator.prenume, materie.nume, catalog.nota from utilizator, materie, catalog
        where
			utilizator.id in (select student.idUtilizator from student, catalog 
								where student.id = catalog.idStudent 
                                and catalog.idMaterie in (select activitatepredare.idMaterie from activitatepredare where activitatepredare.idProf = idProf))
			 and materie.id in (select materie.id from materie where materie.id in (select activitatepredare.idMaterie from activitatepredare where activitatepredare.idProf = idProf))
             and catalog.idMaterie in (select materie.id from materie where materie.id in (select activitatepredare.idMaterie from activitatepredare where activitatepredare.idProf = idProf))
             and catalog.idStudent in (select student.id from student, catalog 
								where student.id = catalog.idStudent 
                                and catalog.idMaterie in (select activitatepredare.idMaterie from activitatepredare where activitatepredare.idProf = idProf));
    end if;
end //
delimiter ;

#drop procedure vizualizareNoteProfesor;
#call vizualizareNoteProfesor(7, @mesajEoare);

delimiter //
create procedure cautareUtilizator(nume varchar(45), prenume varchar(45), tipUtilizator varchar(45))
begin
    if(tipUtilizator = "student") then
		select utilizator.nume, " ", utilizator.prenume,":     ", utilizator.email from utilizator
        where utilizator.id in (select idUtilizator from student)
        and utilizator.nume = nume
        and utilizator.prenume = prenume
        into outfile "cautare_utilizator.txt";
	else if (tipUtilizator = "profesor") then
			select utilizator.nume, " ", utilizator.prenume,":     ", utilizator.email from utilizator
			where utilizator.id in (select idUtilizator from profesor)
            and utilizator.nume = nume
			and utilizator.prenume = prenume
			into outfile "cautare_utilizator.txt";
        else
			select utilizator.nume," ", utilizator.prenume,":     ", utilizator.email from utilizator
			where (utilizator.tipUtilizator = 0
            or utilizator.tipUtilizator = 1)
			and utilizator.nume = nume
			and utilizator.prenume = prenume
			into outfile "cautare_utilizator.txt";
        end if;
	end if;
end//
delimiter ;

#drop procedure cautareUtilizator;
#call cautareUtilizator("Eremia", "Daniel", "*toate");


delimiter //
create procedure cautareCurs(nume varchar(45), out mesajEroare varchar(200))
begin
	declare idMaterie int;
    set idMaterie = 0;
    
    select id from materie where materie.nume = nume into idMaterie;
    if(idMaterie = 0) then
		select mesaj from mesajeroare where id = 7 into mesajEroare;
	else
		select materie.nume, ":   ", materie.descriere,"          Profesor: ", utilizator.nume," ", utilizator.prenume from materie, utilizator 
        where materie.id = idMaterie
        and utilizator.id in
        (select idUtilizator from profesor where profesor.id in (select idProfCurs from activitatepredare where activitatepredare.idMaterie = idMaterie))
        into outfile "cautare_curs.txt"
        ;
    end if;
end //
delimiter ;

#drop procedure cautareCurs;
-- insert into activitatepredare (idProfCurs, idProf, idMaterie) values (1, 1, 1);
-- insert into activitatepredare (idProfCurs, idProf, idMaterie) values (2, 1, 1);
#call cautareCurs("Programarea Calculatoarelor", @mesajEroare);

delimiter //
create procedure afisareMembri(idGrup int)
begin
	select utilizator.nume, " ", utilizator.prenume from utilizator
    where utilizator.id in
    (select idUtilizator from student, listagrupuri 
    where student.id = listagrupuri.idStudent
    and listagrupuri.idGrup = idGrup)
    into outfile "afisare_membri.txt";
end //
delimiter ;

#drop procedure afisareMembri;

#insert into listagrupuri (idStudent, idGrup) values (14, 1); 
#insert into listagrupuri (idStudent, idGrup) values (2, 1); 
#insert into listagrupuri (idStudent, idGrup) values (4, 1); 

#insert into listagrupuri (idStudent, idGrup) values (4, 2); 
#insert into listagrupuri (idStudent, idGrup) values (1, 2); 

delimiter ;
#call afisareMembri(1);
#call afisareMembri(2);

delimiter //
create procedure afisareMesaje(idGrup int)
begin
	select utilizator.nume, " ", utilizator.prenume, ": ", mesaje.mesaj from utilizator, mesaje
    where utilizator.id = mesaje.idUtilizator
    and mesaje.idGrup = idGrup
    into outfile "afisare_mesaje.txt";    
end //
delimiter ;

#drop procedure afisareMesaje;

#insert into mesaje (idUtilizator, idGrup, mesaj) values (14, 1, "mesajul meu");
#insert into mesaje (idUtilizator, idGrup, mesaj) values (4, 1, "mesajul urmator");
#insert into mesaje (idUtilizator, idGrup, mesaj) values (14, 1, "mesaj 3");

#insert into mesaje (idUtilizator, idGrup, mesaj) values (4, 2, "mesaj nou");
delimiter ;

#call afisareMesaje(1);

delimiter //
create procedure inserareMesajNou(idUtilizator int, idGrup int, mesaj text)
begin
	insert into mesaje (idUtilizator, idGrup, mesaj) values (idUtilizator, idGrup, mesaj);    
end //
delimiter ;

#call inserareMesajNou(2, 1, "bla bla bla");

delimiter //
create procedure afisareStudenti(idActivitate int)
begin
	 select utilizator.nume, " ", utilizator.prenume, " " from utilizator
     where utilizator.id in
     (select idUtilizator from student, inscriereactivitatipredare where student.id = idStudent and inscriereactivitatipredare.idActivitate = idActivitate)
     into outfile "afisare_studenti.txt";
end //
delimiter ;


#drop procedure afisareStudenti;
#call afisareStudenti(6);

delimiter //
create procedure sugestiiParticipanti(idGrup int)
begin
	declare idMaterie int;
	select grupstudiu.idMaterie from grupstudiu where grupstudiu.id = idGrup into idMaterie;
    
	select utilizator.nume, " ", utilizator.prenume from utilizator
    where utilizator.id in
    (select idUtilizator from student, catalog 
    where student.id = catalog.idStudent
    and catalog.idMaterie = idMaterie)
    
    and utilizator.id not in
    (select idUtilizator from student, listagrupuri
    where student.id = listagrupuri.idStudent
    and listagrupuri.idGrup = idGrup)
    into outfile "sugestii_participanti.txt"
    ;
end //
delimiter ;

#drop procedure sugestiiParticipanti;
#call sugestiiParticipanti(2);

delimiter //
create procedure getNumeGrup(idGrup int, out numeGrup varchar(45))
begin
	select grupstudiu.nume from grupstudiu where grupstudiu.id = idGrup into numeGrup;	
end//
delimiter ;

#drop procedure getNumeGrup;
#call getNumeGrup(2, @nume);
#select @nume;

delimiter //
create procedure getNumeStudent(idStudent int, out numeStudent varchar(45), out prenumeStudent varchar(45))
begin
	select utilizator.nume from utilizator where utilizator.id in (select idUtilizator from student where student.id = idStudent) into numeStudent;
    select utilizator.prenume from utilizator where utilizator.id in (select idUtilizator from student where student.id = idStudent) into prenumeStudent;
end//
delimiter ;

#drop procedure getNumeStudent;
#call getNumeStudent(1, @nume, @prenume);
#select @nume, @prenume;

delimiter //
create procedure getNumeMaterie(idMaterie int, out numeMaterie varchar(45))
begin
	select materie.nume from materie where materie.id = idMaterie into numeMaterie;
end//
delimiter ;

#call getNumeMaterie(8, @numeMaterie);
#select @numeMaterie;

delimiter //
create procedure toateCursurileStudentului(idStudent int)
begin
	select materie.id from materie, catalog
    where catalog.idStudent = idStudent
    and catalog.idMaterie = materie.id
    into outfile "toate_cursurile_studentului.txt";
end//
delimiter ;

#drop procedure toateCursurileStudentului;
#call toateCursurileStudentului(4);

delimiter //
create procedure creareActivitate(
idGrup int,
dataDesfasurare date, 
ora time, 
durata float, 
timpExpirare float,
minStudenti int,
out mesajEroare varchar(200), 
out idActivitate int)
begin
	declare azi date;
    declare acum time;
    select current_date() into azi;
    select current_time() into acum;
    
    if (dataDesfasurare < azi) or (dataDesfasurare = azi and ora < acum) then
		select mesaj from mesajeroare where id = 20 into mesajEroare;
	else
		if (minStudenti < 0) then
			select mesaj from mesajeroare where id = 11 into mesajEroare;
		else
				insert into activitategrup(idGrupStudiu, dataDesfasurare, ora, durata, timpExpirare, nrMinStudenti)
                values (idGrup, dataDesfasurare, ora, durata, timpExpirare, minStudenti);
                
                select max(activitategrup.id) from activitategrup into idActivitate;
        end if;
    end if;
end //
delimiter ;

#drop procedure creareActivitate;

delimiter //
create procedure totiProfesorii()
begin
	select profesor.id, " ", utilizator.nume, " ", utilizator.prenume, "           ", utilizator.email from utilizator, profesor
    where utilizator.id = profesor.idUtilizator
    into outfile "toti_profesorii.txt";
end //
delimiter ;

#drop procedure totiProfesorii;
#call totiProfesorii;

delimiter //
create procedure invitaProfesor(idActivitate int, idProfesor int)
begin
	update activitategrup set activitategrup.idProfesor = idProfesor where activitategrup.id = idActivitate;
end//
delimiter ;

#call invitaProfesor(6,13);

delimiter //
create procedure toateActivitatileCuProfesor()
begin
	select activitategrup.id, "Grupul de studiu:   ", grupstudiu.nume, "            Profesor coordonator:   ", utilizator.nume, " ", utilizator.prenume, "            data:          ", activitategrup.dataDesfasurare, "           ora:           ", activitategrup.ora, "          durata:       ", activitategrup.durata, "         numar participanti:       ", activitategrup.nrCurentStudenti
    from grupstudiu, utilizator, activitategrup
    where grupstudiu.id = activitategrup.idGrupStudiu
    and utilizator.id in (select idUtilizator from profesor where profesor.id = idProfesor)
    into outfile "toate_activitatile_cu_profesor.txt";
end//
delimiter ;

#drop procedure toateActivitatileCuProfesor;
#call toateActivitatileCuProfesor();

delimiter //
create procedure toateActivitatileFaraProfesor()
begin
	select activitategrup.id, "Grupul de studiu:   ", grupstudiu.nume, "            data:          ", activitategrup.dataDesfasurare, "           ora:           ", activitategrup.ora, "          durata:       ", activitategrup.durata, "         numar participanti:        ", activitategrup.nrCurentStudenti
    from grupstudiu, activitategrup
    where grupstudiu.id = activitategrup.idGrupStudiu
    and activitategrup.idProfesor is null
    into outfile "toate_activitatile_fara_profesor.txt";
end//
delimiter ;

#drop procedure toateActivitatileFaraProfesor;
#call toateActivitatileFaraProfesor();


delimiter //
create procedure inscriereActivitateGrup(idStudent int, idActivitate int, out mesajEroare varchar(200))
begin
	 declare idGrup int;
     declare inscrisGrup int;
     set inscrisGrup = 0;
     select activitategrup.idGrupStudiu from activitategrup where activitategrup.id = idActivitate into idGrup;
     select listagrupuri.id from listagrupuri where listagrupuri.idStudent = idStudent and listagrupuri.idGrup = idGrup into inscrisGrup;
     
     if(inscrisGrup = 0) then
		select mesaj from mesajeroare where mesajeroare.id = 33 into mesajEroare;
     else
		insert into listaactivitati (idStudent, idActivitateGrup) values (idStudent, idActivitate);
        update activitategrup set nrCurentStudenti = nrCurentStudenti + 1 where activitategrup.id = idActivitate;
     end if;
     
end//
delimiter ;
#drop procedure inscriereActivitateGrup;
#call inscriereActivitateGrup(4, 22, @mesajEroare);


delimiter //
create procedure toateGrupurileStudentului(idStudent int)
begin
	select grupstudiu.id, " ", grupstudiu.nume from grupstudiu, listagrupuri
    where listagrupuri.idStudent = idStudent
    and grupstudiu.id = listagrupuri.idGrup
    into outfile "toate_grupurile_studentului.txt";
end//
delimiter ;

#drop procedure toateGrupurileStudentului;
#call toateGrupurileStudentului(1);

delimiter //
create procedure toateMateriileProfesorului(idProf int)
begin
	select distinct materie.id from materie, activitatepredare
    where activitatepredare.idProf = idProf
    and activitatepredare.idMaterie = materie.id
    into outfile "toate_materiile_profesorului.txt";
end//
delimiter ;


delimiter //
create procedure vizualizareNoteMaterie(idProfCurs int, out mesajEroare varchar(200))									-- de revazut
begin
	select distinct utilizator.nume, utilizator.prenume, catalog.nota from utilizator, catalog, activitatepredare
    where utilizator.id in (select idUtilizator from student where student.id = catalog.idStudent)
    and catalog.idMaterie = activitatepredare.idMaterie
    and activitatepredare.idProfCurs = idProfCurs
    into outfile "note_materie.txt";
end//
delimiter ;

 #drop procedure vizualizareNoteMaterie;
 #call vizualizareNoteMaterie(2, @mesajEroare);
 
 
 delimiter //
 create procedure vizualizareNoteLaborator(idProf int, idMaterie int, out mesajEroare varchar(200))
 begin
	if((select activitatepredare.id from activitatepredare where activitatepredare.idProf = idProf and activitatepredare.tipActivitate = 1) is null) then
		select mesaj from mesajeroare where id = 34 into mesajEroare;
	else 
		select utilizator.nume, utilizator.prenume, inscriereactivitatipredare.nota from utilizator, inscriereactivitatipredare, activitatepredare
		where utilizator.id in (select student.idUtilizator from student where student.id = inscriereactivitatipredare.idStudent)
		and inscriereactivitatipredare.idActivitate = activitatepredare.id
		and activitatepredare.idProf = idProf
		and activitatepredare.idMaterie = idMaterie
		and activitatepredare.tipActivitate = 1
        into outfile "note_laborator.txt";    
	end if;
 end //
 delimiter ;
 
#drop procedure vizualizareNoteLaborator;
#call vizualizareNoteLaborator(2, 2, @mesajEroare);
#select @mesajEroare;


 delimiter //
 create procedure vizualizareNoteSeminar(idProf int, idMaterie int, out mesajEroare varchar(200))
 begin
	if((select activitatepredare.id from activitatepredare where activitatepredare.idProf = idProf and activitatepredare.tipActivitate = 2) is null) then
		select mesaj from mesajeroare where id = 34 into mesajEroare;
	else 
		select utilizator.nume, utilizator.prenume, inscriereactivitatipredare.nota from utilizator, inscriereactivitatipredare, activitatepredare
		where utilizator.id in (select student.idUtilizator from student where student.id = inscriereactivitatipredare.idStudent)
		and inscriereactivitatipredare.idActivitate = activitatepredare.id
		and activitatepredare.idProf = idProf
		and activitatepredare.idMaterie = idMaterie
		and activitatepredare.tipActivitate = 2
        into outfile "note_seminar.txt";    
	end if;
 end //
 delimiter ;
 
#drop procedure vizualizareNoteSeminar;
#call vizualizareNoteSeminar(13, 4, @mesajEroare);
#select @mesajEroare;

 delimiter //
 create procedure vizualizareNoteCurs(idProfCurs int, idMaterie int, out mesajEroare varchar(200))
 begin
	if((select activitatepredare.id from activitatepredare where activitatepredare.idProf = idProfCurs and activitatepredare.tipActivitate = 0) is null) then
		select mesaj from mesajeroare where id = 34 into mesajEroare;
	else 
		select utilizator.nume, utilizator.prenume, inscriereactivitatipredare.nota from utilizator, inscriereactivitatipredare, activitatepredare
		where utilizator.id in (select student.idUtilizator from student where student.id = inscriereactivitatipredare.idStudent)
		and inscriereactivitatipredare.idActivitate = activitatepredare.id
		and activitatepredare.idProf = idProfCurs
		and activitatepredare.idMaterie = idMaterie
		and activitatepredare.tipActivitate = 0
        into outfile "note_curs.txt";
	end if;
 end //
 delimiter ;
 
 #drop procedure vizualizareNoteCurs;
 #call vizualizareNoteCurs(1, 2, @mesajEroare);
 #select @mesajEroare;
 
 delimiter //
 create procedure gasireActivitate(numeMaterie varchar(45), numeProfesor varchar(45), prenumeProfesor varchar(45), out idActivitate int)
 begin
		declare idM, idU, idP int;
        select materie.id from materie where materie.nume = numeMaterie into idM;
        select utilizator.id from utilizator where utilizator.nume = numeProfesor and utilizator.prenume = prenumeProfesor into idU;
        select profesor.id from profesor where profesor.idUtilizator = idU into idP; 
 
	select activitatepredare.id from activitatepredare
    where activitatepredare.idProf = idP
    and activitatepredare.idMaterie = idM
    and activitatepredare.tipActivitate = 0
    into idActivitate;
 end// 
 delimiter ;
 
#call gasireActivitate("Programarea Calculatoarelor", "Giosan", "Ion", @idActivitate);
#select @idActivitate;

delimiter //
create procedure getInfoStudent(emailUser varchar(45), out an int, out ore int)
begin
declare idUt int;
    select id from utilizator where email = emailUser into idUt;
select nrOre from student where idUtilizator = idUt into ore;
    select anStudiu from student where idUtilizator = idUt into an;
end //
delimiter ;

-- call getInfoStudent("amarieigeorge@gmail.com", @an, @ore);
-- select @an, @ore;

delimiter //
create procedure getInfoProfesor(emailUser varchar(45), out nrMin int, out nrMax int, out idDep varchar(45))
begin
declare idUt int;
    select id from utilizator where email = emailUser into idUt;
    select nrMinOre from profesor where idUtilizator = idUt into nrMin;
    select nrMaxOre from profesor where idUtilizator = idUt into nrMax;
    select idDepartament from profesor where idUtilizator = idUt into idDep;
    -- select nume from departament where id = idDep into numeDep;
end //
delimiter ;

-- drop procedure getInfoProfesor;

-- call getInfoProfesor("popadorian@gmail.com", @min, @max, @idDep);
-- select @min, @max, @idDep;

delimiter //
create procedure getNumeDep(idDep int, out numeDep varchar(45))
begin
select nume from departament where id = idDep into numeDep;
end //
delimiter ;

-- drop procedure getNumeDep;

-- call getNumeDep(3, @numeD);
-- select @numeD;


delimiter //
create procedure getDate(
emailUser varchar(45),
    out numeUser varchar(45),
    out prenumeUser varchar(45),
    out adrEmailUser varchar(45),
    out cnpUser char(13),
    out telefonUser char(12),
    out adresaUser varchar(100),
    out ibanUser char(34),
    out nrContractUser varchar(45)
)
begin
select nume from utilizator where email = emailUser into numeUser;
    select prenume from utilizator where email = emailUser into prenumeUser;
    set adrEmailUser = emailUser;
    select cnp from utilizator where email = emailUser into cnpUser;
    select nrTelefon from utilizator where email = emailUser into telefonUser;
    select adresa from utilizator where email = emailUser into adresaUser;
    select iban from utilizator where email = emailUser into ibanUser;
    select nrContract from utilizator where email = emailUser into nrContractUser;
end //
delimiter ;

delimiter //
create procedure getTipUser(emailUser varchar(45), out tipUser int)
begin
select tipUtilizator from utilizator where email = emailUser into tipUser;
end //
delimiter ;

-- call getTipUser("toaderioana@gmail.com", @tipUser);
-- select @tipUser;

delimiter //
create procedure getIdStudent(email varchar(45), out id int)
begin
	declare idU int;
	select utilizator.id from utilizator where utilizator.email = email into idU;
    
    select student.id from student where student.idUtilizator = idU into id;
end //
delimiter ;

#drop procedure getIdStudent;
#call getIdStudent("amarieigeorge@gmail.com", @id);
#select @id;
 
 
delimiter //
create procedure getNrContract(nume varchar(45), prenume varchar(45), out nr varchar(45))
begin
	select utilizator.nrContract from utilizator where utilizator.nume = nume and utilizator.prenume = prenume into nr;
end //
delimiter ; 

#drop procedure getNrContract;
#call getNrContract("Amariei", "Georgiana", @id);
#select @id;
 
 delimiter //
create procedure getIdMaterie(nume varchar(45), out nr int)
begin
	select materie.id from materie where materie.nume = nume into nr;
end //
delimiter ; 
 
 #call getIdMaterie("Proiectare Logica", @id);
 #select @id;
 
delimiter ; 
 
-- departamente 
insert into universitate.departament (nume) values ("Calculatoare");
insert into universitate.departament (nume) values ("Automatica");
insert into universitate.departament (nume) values ("Matematica");

-- materii
insert into universitate.materie (nume, descriere) values ("Proiectare Logica", "Disciplina fundamentala ce are drept obiectiv studiul circuitelor integrate realizare folosind porti logice");
insert into universitate.materie (nume, descriere) values ("Programarea Calculatoarelor", "Disciplina fundamentala de specialitate ce se ocupa cu studiul limbajului de programare C");
insert into universitate.materie (nume, descriere) values ("Algebra Liniara si Geometrie Analitica", "Disciplina fundamentala ce are drept obiectiv studiul si aprofundarea conceptelor din algebra liniara si geometria analitica");
insert into universitate.materie (nume, descriere) values ("Analiza Matematica I", "Disciplina fundamentala de specialitate ce se ocupa cu studiul conceptelor din teoria calcului diferential pentru functii de mai multe variabile reale");
insert into universitate.materie (nume, descriere) values ("Matematici Speciale", "Disciplina fundamentala ce se ocupa cu studiul conceptelor din domeniul matematicilor discrete");
insert into universitate.materie (nume, descriere) values ("Fizica", "Disciplina fundamentala de specialitate ce se ocupa cu studiul conceptelor de electricitate si mecanica");
insert into universitate.materie (nume, descriere) values ("Proiectarea Sistemelor Numerice", "Disciplina de specialitatstudente ce se ocupa cu studiul modalitatilor de proiectare a sistemelor numerice");
insert into universitate.materie (nume, descriere) values ("Programare in Limbaj de Asamblare", "Disciplina de specialitate ce se ocupa cu studiul conceptelor specifice limbajului de asamblare");
insert into universitate.materie (nume, descriere) values ("Structuri de Date si Algoritmi", "Disciplina de specialitate ce se ocupa cu studiul structurilor de date si a algoritmilor utilizati frecvent in diverse limbaje de programare");
insert into universitate.materie (nume, descriere) values ("Electrotehnica", "Disciplina fundamentala ce se ocupa cu studiul conceptelor din domeniul electrotehnicii");
insert into universitate.materie (nume, descriere) values ("Analiza Matematica II", "Disciplina fundamentala ce are drept obiectiv studiul conceptelor din teoria calculului integral al functiilor reale");
insert into universitate.materie (nume, descriere) values ("Algoritmi Fundamentali", "Disciplina de specialitate ce are drept obiectiv studiul complexitatii algoritmilor frecvent utilizati in practica");
insert into universitate.materie (nume, descriere) values ("Programare Orientata pe Obiecte", "Disciplina de specialitate ce are drept obiectiv studiul conceptelor din teoria limbajelor de programare orientate pe obiecte");
insert into universitate.materie (nume, descriere) values ("Matematici Speciale in Inginerie", "Disciplina de specialitate ce are drept obiectiv studiul conceptelor din teoria functiilor complexe si teoria semnalelor");
insert into universitate.materie (nume, descriere) values ("Masuratori Electrice si Senzori", "Disciplina fundamentala ce are drept obiectiv studiul teoriei senzorilor si a conceptelor referitoare la masuratorile din domeniul electronic");
insert into universitate.materie (nume, descriere) values ("Baze de Date", "Disciplina de specialitate ce are drept obiectiv studiul conceptelor din teoria bazelor de date");
insert into universitate.materie (nume, descriere) values ("Circuite Analogice si Numerice", "Disciplina de specialitate ce are drept obiectiv studiul conceptelor din teoria circuitelor analogice si numerice");

-- studenti
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("6000314567892", "Amariei", "Georgiana", "Cluj-Napoca", "0745123456", "amarieigeorge@gmail.com", "5467891253647894568ssaq745db684s21", "a56", 0, "student1");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("5000714567892", "Blaga", "Cristian", "Baia-Mare", "0753125478", "blagacristian@gmail.com", "5467891253647894568ssaq745db684s21", "a44", 0, "student2");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("5000425567892", "Cibu", "Alin", "Blaj", "0758451369", "cibualin@gmail.com", "5467891253647894568sdfg745db684s21", "a32", 0, "student3");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("6000522467892", "Damian", "Crina", "Cluj-Napoca", "0745124231", "damiancrina@gmail.com", "5467891253647894568cvbn745db684s21", "a80", 0, "student4");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("5000714567823", "Eremia", "Daniel", "Alba-Iulia", "0746785478", "eremiadaniel@gmail.com", "5467891253647894568rtfs745db684s21", "a90", 0, "student5");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("6000425127892", "Farcas", "Dorina", "Turda", "0758451359", "farcasdorina@gmail.com", "5467891253647894568cvbn745db684s21", "a53", 0, "student6");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("6000622467892", "Grigore", "Ioana", "Campeni", "0725124231", "grigoreioana@gmail.com", "5467891253647894568rewq745db684s21", "a21", 0, "student7");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("5001114567823", "Hermann", "Marin", "Brasov", "0732785478", "hermannmarin@gmail.com", "5467891253647894568zxcv245db684s21", "a33", 0, "student8");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("5001225127892", "Istrate", "Andrei", "Floresti", "0788451359", "istrateandrei@gmail.com", "5467891253647894568ghjk745db684s21", "a12", 0, "student9");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("5000623467892", "Jurca", "Felix", "Cugir", "0732124231", "jurcafelix@gmail.com", "5467891253647894568erty745db684s21", "a98", 0, "student10");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("6001204367823", "Klam", "Ilinca", "Sighisoara", "0764785478", "klamilinca@gmail.com", "5467891253647894568lkjp245db684s21", "a97", 0, "student11");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("6001231127892", "Lisan", "Denisa", "Pitesti", "0747451359", "lisandenisa@gmail.com", "5467891253647894568poil745db684s21", "a96", 0, "student12");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("6001023467892", "Mihalca", "Luana", "Cluj-Napoca", "0732125698", "mihalcaluana@gmail.com", "5467891253647894568xfcv745db684s21", "a51", 0, "student13");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("5001114367823", "Nemes", "Matei", "Baia-Mare", "0764785951", "nemesmatei@gmail.com", "5467891253647894564fvhn245db684s21", "a42", 0, "student14");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("5000916127892", "Oprean", "Dorin", "Cluj-Napoca", "0747349359", "opreandorin@gmail.com", "5467891253647894568sdnm745db684s21", "a77", 0, "student15");

-- profesori
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("1850312674572", "Varga", "Robert", "Cluj-Napoca", "0746124458", "vargarobert@gmail.com", "3467891255947894568ssaq745db684s31", "b78", 1, "profesor1");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("1830612674582", "Giosan", "Ion", "Cluj-Napoca", "0756122459", "giosanion@gmail.com", "8467891255947894568bbaq745db684s91", "b23", 1, "profesor2");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("1600306674572", "Popa", "Dorian", "Cluj-Napoca", "0746457845", "popadorian@gmail.com", "3454891255947894568ssad745db684u47", "b19", 1, "profesor3");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("1560310674572", "Pop", "Vasile", "Cluj-Napoca", "0729124758", "popvasile@gmail.com", "7467391215947894568ffaq745db684q32", "b20", 1, "profesor4");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("1800412674572", "Gabor", "Mihai", "Cluj-Napoca", "0747125458", "gabormihai@gmail.com", "9467891255947894568suag745db684i41", "b90", 1, "profesor5");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("2580511674572", "Vacariu", "Lucia", "Cluj-Napoca", "0776124459", "vacariulucia@gmail.com", "8467591255947894578ssaq745db584r31", "b50", 1, "profesor6");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("2700409674572", "Rosca", "Daniela", "Cluj-Napoca", "0748124952", "roscadaniela@gmail.com", "3767291255947894568mraq735db684s31", "b29", 1, "profesor7");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("1820712674573", "Rus", "Mircea", "Cluj-Napoca", "0772134498", "rusmircea@gmail.com", "3467991255947894568ttaq745db684d51", "b51", 1, "profesor8");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("2850406674571", "Hangan", "Anca", "Cluj-Napoca", "0756124248", "hangananca@gmail.com", "1467891255947894568hsaq745db684h29", "b60", 1, "profesor9");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("2820110674972", "Brehar", "Raluca", "Cluj-Napoca", "0736122478", "breharraluca@gmail.com", "8846791255947894568qqas745db684s41", "b72", 1, "profesor10");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("1550210674562", "Gavrea", "Ioan", "Cluj-Napoca", "0747121469", "gavreaioan@gmail.com", "6467891255947894568aaaq745db684w48", "b12", 1, "profesor11");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("2780911674572", "Cretu", "Mihaela", "Cluj-Napoca", "0747023451", "cretumihaela@gmail.com", "4467891825947894568qraf735db684s10", "b21", 1, "profesor12");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("2870310674579", "Baias", "Alina", "Cluj-Napoca", "0745123355", "baiasalina@gmail.com", "3267891247947894568bbaq745db684a29", "b10", 1, "profesor13");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("2600710674578", "Potolea", "Rodica", "Cluj-Napoca", "0726124473", "potolearodica@gmail.com", "3967831225957896568rrap745db684p27", "b09", 1, "profesor14");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("1700111667572", "Peculea", "Adrian", "Cluj-Napoca", "0736012468", "peculeaadrian@gmail.com", "9587891255947894568paad745db684a70", "b06", 1, "profesor15");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("1620412674552", "Munteanu", "Radu", "Cluj-Napoca", "0722134437", "radumunteanu@gmail.com", "3967891022947894568rmar765cb684m30", "b05", 1, "profesor16");

-- administratori
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("1610309672562", "Ionescu", "Marin", "Cluj-Napoca", "0779131442", "ionescumarin@gmail.com", "2856980134547894568ioar765cb684m53", "c01", 2, "admin1");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("1720502682461", "Popa", "Ioan", "Cluj-Napoca", "0739201452", "popaioan@gmail.com", "1856970132547844568puar765cb684m32", "c02", 2, "admin2");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("2650103672764", "Lazar", "Iuliana", "Cluj-Napoca", "0769131361", "lazariuliana@gmail.com", "2836980134597894568lazr765cb684m91", "c03", 2, "admin3");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("1680909582502", "Adam", "Marius", "Cluj-Napoca", "0748131230", "adammarius@gmail.com", "8967091234547894568adar765cm684m59", "c04", 2, "admin4");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("1800707472812", "Muresan", "Claudiu", "Cluj-Napoca", "0758131340", "muresanclaudiu@gmail.com", "6866980164546894568mras765cb684m82", "c05", 2, "admin5");

-- super administratori
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("1750308672438", "Mateescu", "Raul", "Cluj-Napoca", "0767831407", "mateescuradu@gmail.com", "4896980134547894568mrar765rl684m53", "d01", 3, "super1");
insert into utilizator (cnp, nume, prenume, adresa, nrTelefon, email, iban, nrContract, tipUtilizator, parola) values ("2760810662529", "Toader", "Ioana", "Cluj-Napoca", "0763574309", "toaderioana@gmail.com", "5926980134547894568tdrr765rl684m46", "d02", 3, "super2");

-- mesaje de eroare
insert into mesajeroare(mesaj) values ("e-mail sau parolă incorecte");
insert into mesajeroare(mesaj) values ("Student inexistent");
insert into mesajeroare(mesaj) values ("Notă invalidă");
insert into mesajeroare(mesaj) values ("Această materie nu are activitatea de predare selectată");
insert into mesajeroare(mesaj) values ("An de studiu invalid");
insert into mesajeroare(mesaj) values ("Profesor inexistent");
insert into mesajeroare(mesaj) values ("Materie inexistentă");
insert into mesajeroare(mesaj) values ("Profesorul nu predă această materie");
insert into mesajeroare(mesaj) values ("Dată invalidă");
insert into mesajeroare(mesaj) values ("Oră invalidă");
insert into mesajeroare(mesaj) values ("Numărul minim de participanți trebuie să fie un număr mai mare decăt 0");
insert into mesajeroare(mesaj) values ("Numărul minim de studenți trebuie să fie un număr mai mare decăt 0");
insert into mesajeroare(mesaj) values ("Grup deja existent. Alegeți alt nume!");
insert into mesajeroare(mesaj) values ("Procentul trebuie să fie un număr între 0 și 100");
insert into mesajeroare(mesaj) values ("Suma tuturor procentelor trebuie să fie 100");
insert into mesajeroare(mesaj) values ("CNP-ul trebuie să aibă 13 cifre");
insert into mesajeroare(mesaj) values ("Numărul de telefon nu poate avea mai mult de 12 cifre");
insert into mesajeroare(mesaj) values ("IBAN-ul trebuie să aibă exact 34 de caractere");
insert into mesajeroare(mesaj) values ("Data final nu poate să fie înainte de data început");
insert into mesajeroare(mesaj) values ("Activitățile pot fi programate doar în viitor!");
insert into mesajeroare(mesaj) values ("Utilizator existent!");
insert into mesajeroare(mesaj) values ("Cont deja existent");
insert into mesajeroare(mesaj) values ("Confirmarea parolei nu corespunde cu parola");
insert into mesajeroare(mesaj) values ("e-mail inexistent");
insert into mesajeroare(mesaj) values ("Studentul nu este inscris la aceasta activitate de predare");
insert into mesajeroare(mesaj) values ("Departament inexistent");
insert into mesajeroare(mesaj) values ("Numarul maxim de ore trebuie sa fie mai mare sau egal cu numarul minim");
insert into mesajeroare(mesaj) values ("Materie existenta!");
insert into mesajeroare(mesaj) values ("Utilizator inexistent!");
insert into mesajeroare(mesaj) values ("Grup inexistent!");
insert into mesajeroare(mesaj) values ("Nu sunteți înscris la materia acestui grup");
insert into mesajeroare(mesaj) values ("Sunteți deja înscris în acest grup");
insert into mesajeroare(mesaj) values ("Nu sunteți înscris în acest grup");
insert into mesajeroare(mesaj) values ("Activitatea de predare nu este asignată acestui profesor");
insert into mesajeroare(mesaj) values ("Doar profesorul de curs poate modifica împărțirea procentuală");

-- grupuri de studiu
insert into grupstudiu(idMaterie, nume) values (17, "Circuite liniare RC");
insert into grupstudiu(idMaterie, nume) values (2, "Pointeri");
insert into grupstudiu(idMaterie, nume) values (1, "Bistabile D");


-- useri

DROP USER 'student'@localhost;
CREATE USER 'student'@localhost;
GRANT SELECT ON universitate.*TO 'student'@'localhost';
GRANT INSERT ON universitate.*TO 'student'@'localhost';
GRANT UPDATE ON universitate.*TO 'student'@'localhost';
GRANT DELETE ON universitate.*TO 'student'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.creareGrup TO 'student'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.inscriereGrup TO 'student'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.inscriereCurs TO 'student'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.renuntareCurs TO 'student'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.vizualizareNoteStudent TO 'student'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.afisareMembri TO 'student'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.afisareMesaje TO 'student'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.inserareMesajNou TO 'student'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.sugestiiParticipanti TO 'student'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.toateCursurileStudentului TO 'student'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.inscriereActivitateGrup TO 'student'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.trimitereMesaj TO 'student'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.creareActivitate TO 'student'@'localhost';


DROP USER 'profesor'@localhost;
CREATE USER 'profesor'@localhost;
GRANT SELECT ON universitate.*TO 'profesor'@'localhost';
GRANT INSERT ON universitate.*TO 'profesor'@'localhost';
GRANT UPDATE ON universitate.*TO 'profesor'@'localhost';
GRANT DELETE ON universitate.*TO 'profesor'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.incarcareProcentuala TO 'profesor'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.descarcareCatalog TO 'profesor'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.vizualizareNoteProfesor TO 'profesor'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.toateMateriileProfesorului TO 'profesor'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.vizualizareNoteMaterie TO 'profesor'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.vizualizareNoteLaborator TO 'profesor'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.vizualizareNoteSeminar TO 'profesor'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.vizualizareNoteCurs TO 'profesor'@'localhost';

DROP USER 'administrator'@localhost;
CREATE USER 'administrator'@localhost;
GRANT SELECT ON universitate.*TO 'administrator'@'localhost';
GRANT INSERT ON universitate.*TO 'administrator'@'localhost';
GRANT UPDATE ON universitate.*TO 'administrator'@'localhost';
GRANT DELETE ON universitate.*TO 'administrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.adaugareUser TO 'administrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.asignareProfCurs TO 'administrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.creareCont TO 'administrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.calculMedie TO 'administrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.modificareDate TO 'administrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.stergereInformatii TO 'administrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.adaugareDetaliiProfesor TO 'administrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.adaugareDetaliiStudent TO 'administrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.adaugareMaterie TO 'administrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.cautareUtilizator TO 'administrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.cautareCurs TO 'administrator'@'localhost';

DROP USER 'superadministrator'@localhost;
CREATE USER 'superadministrator'@localhost;
GRANT SELECT ON universitate.*TO 'superadministrator'@'localhost';
GRANT INSERT ON universitate.*TO 'superadministrator'@'localhost';
GRANT UPDATE ON universitate.*TO 'superadministrator'@'localhost';
GRANT DELETE ON universitate.*TO 'superadministrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.adaugareUser TO 'superadministrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.asignareProfCurs TO 'superadministrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.creareCont TO 'superadministrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.calculMedie TO 'superadministrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.modificareDate TO 'superadministrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.stergereInformatii TO 'superadministrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.adaugareDetaliiProfesor TO 'superadministrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.adaugareDetaliiStudent TO 'superadministrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.adaugareMaterie TO 'superadministrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.cautareUtilizator TO 'superadministrator'@'localhost';
GRANT EXECUTE ON PROCEDURE universitate.cautareCurs TO 'superadministrator'@'localhost';







