create table barang(
	id_Barang serial primary key,
	nama_Barang varchar(15) not null,
	harga int not null,
	keterangan text
);

insert into barang(id_Barang, nama_Barang, harga, keterangan)
values 
('122', 'ACCU',500000,'Baru'),
('123','Kampas Rem', 300000, 'Baru' ),
('124','Kampas Kopling', 200000, 'Baru'),
('125', 'Katup Ekspansi',300000, 'Baru'),
('126', 'Cooling Unit', 100000, 'Baru'),
('127','Kondensor', 100000, 'Baru');


create table pegawai(
	id_pegawai serial primary key,
	nama_pegawai varchar(50) not null
);

insert into pegawai(id_pegawai, nama_pegawai)
values('1001', 'Rindi Ayu'),
('1002', 'Kirana Mahar'),
('1003', 'Dimas Gakih');

create table customer(
	id_customer serial primary key,
	nama_customer varchar(20) not null
);

insert into customer(id_customer, nama_customer)
values 
('101', 'Raja Husaka'),
('102', 'Budi Suryo'),
('103', 'Nana Salim'),
('104', 'Briyan Akbar'),
('105', 'Muhammad Nasir'),
('106', 'Salsa Putri');

create table dataService(
	id_service serial primary key,
	nama_service varchar(50) not null,
	jumlah_service int not null,
	tanggal date not null,
	id_customer int not null,
	keterangan text
);

alter table dataService add foreign key (id_customer) references customer(id_customer);

insert into dataService(id_service, nama_service, jumlah_service, tanggal, id_customer, keterangan)
values ('1','Service Ac', 1,'2021-12-8', '101', 'Klorin'),
('2','Ganti oli', 1, '2021-12-8', '102', 'Oli mobil'),
('3','Ganti kampas rem', 1, '2021-12-9', '103', 'Kampas premium'),
('4','Ganti oli', 1, '2021-12-10', '104', 'ACCU Toyota'),
('5','Service ACCU', 1, '2021-12-10', '105', 'Air ACCU'),
('6','Ganti Kampas kopling', 1, '2021-12-10', '106', 'Kampas medium');

create table transaksi(
	id_transaksi serial primary key,
	jumlah_transaksi int not null,
	tanggal date not null,
	id_pegawai int not null,
	id_customer int not null,
	keterangan text
);

alter table transaksi add foreign key (id_pegawai) references pegawai(id_pegawai);

alter table transaksi add foreign key(id_customer) references customer(id_customer);

insert into transaksi(id_transaksi, jumlah_transaksi, tanggal, id_pegawai, id_customer, keterangan)
values
('1', 1, '2021-12-8', '1001','101', 'Lunas'),
('2', 1, '2021-12-8', '1001','102', 'Lunas'),
('3', 1, '2021-12-9', '1002','103', 'Lunas'),
('4', 1, '2021-12-10', '1002','104', 'Lunas'),
('5', 1, '2021-12-10', '1001','105', 'Lunas'),
('6', 1, '2021-12-10', '1003','106', 'Lunas')
