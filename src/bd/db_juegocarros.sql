create database juegocarros;

	create table driver
		(id_driver int unsigned not null auto_increment,
		name_driver varchar (30) not null,
		cont_driver int not null,
		primary key (id_driver));

	create table podium
		(id_podium int unsigned not null auto_increment,
		id_primero int unsigned not null,
		id_segundo int unsigned not null,
		id_tercero int unsigned not null,
		primary key (id_podium),
		foreign key (id_primero) references driver (id_driver),
		foreign key (id_segundo) references driver (id_driver),
		foreign key (id_tercero) references driver (id_driver));

	create table game
		(id_game int unsigned not null auto_increment,
		 id_podium int unsigned not null,
		 primary key (id_game),
		 foreign key (id_podium) references podium (id_podium));
		
