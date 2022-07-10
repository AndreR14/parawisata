-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 05 Jul 2021 pada 17.19
-- Versi server: 10.1.38-MariaDB
-- Versi PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pariwisata`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `hotel`
--

CREATE TABLE `hotel` (
  `kode_hotel` varchar(15) NOT NULL,
  `nama_hotel` varchar(200) NOT NULL,
  `harga` int(11) NOT NULL,
  `alamat_hotel` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `hotel`
--

INSERT INTO `hotel` (`kode_hotel`, `nama_hotel`, `harga`, `alamat_hotel`) VALUES
('KH0001', 'Hotel Grand Vilia', 250000, 'Jl. Telaver No.1, Langgur, Kei Kecil, Kabupaten Maluku Tenggara, Maluku '),
('KH0002', 'Pandawa', 570000, 'Kei');

-- --------------------------------------------------------

--
-- Struktur dari tabel `isi_akomodasi`
--

CREATE TABLE `isi_akomodasi` (
  `id_pembayaran` varchar(12) NOT NULL,
  `tgl_checkin` date NOT NULL,
  `tgl_checkout` date NOT NULL,
  `nama_hotel` varchar(30) NOT NULL,
  `harga_hotel` int(11) NOT NULL,
  `lama_inap` int(11) NOT NULL,
  `total_hotel` int(11) NOT NULL,
  `nama_transportasi` varchar(30) NOT NULL,
  `harga_transportasi` int(11) NOT NULL,
  `total_transportasi` int(11) NOT NULL,
  `lama_hari` int(11) NOT NULL,
  `total_wisata` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `isi_akomodasi`
--

INSERT INTO `isi_akomodasi` (`id_pembayaran`, `tgl_checkin`, `tgl_checkout`, `nama_hotel`, `harga_hotel`, `lama_inap`, `total_hotel`, `nama_transportasi`, `harga_transportasi`, `total_transportasi`, `lama_hari`, `total_wisata`) VALUES
('IT0001', '2021-06-02', '2021-06-03', 'Hotel Grand Vilia', 250000, 2, 500000, 'Honda Beat', 100000, 2, 200000, 70000),
('IT0002', '2021-06-11', '2021-06-15', 'Hotel Grand Vilia', 250000, 4, 1000000, 'Honda Beat', 100000, 4, 400000, 40000),
('IT0003', '2021-06-11', '2021-06-12', 'Hotel Grand Vilia', 250000, 2, 500000, 'Honda Beat', 100000, 2, 200000, 70000),
('IT0004', '2021-06-16', '2021-06-17', 'Hotel Grand Vilia', 250000, 2, 500000, 'Honda Beat', 100000, 2, 200000, 20000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `isi_oleh_oleh`
--

CREATE TABLE `isi_oleh_oleh` (
  `id_pembayaran` varchar(12) NOT NULL,
  `kode_barang` varchar(12) NOT NULL,
  `harga` int(11) NOT NULL,
  `qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `isi_oleh_oleh`
--

INSERT INTO `isi_oleh_oleh` (`id_pembayaran`, `kode_barang`, `harga`, `qty`) VALUES
('IP0001', 'KB0001', 25000, 2),
('IP0001', 'KB0002', 80000, 1),
('IP0002', 'KB0002', 80000, 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `isi_wisata`
--

CREATE TABLE `isi_wisata` (
  `id_pembayaran` varchar(12) NOT NULL,
  `kode_wisata` varchar(12) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `isi_wisata`
--

INSERT INTO `isi_wisata` (`id_pembayaran`, `kode_wisata`, `harga`) VALUES
('IT0001', 'KW0001', 20000),
('IT0001', 'KW0002', 50000),
('IT0002', 'KW0001', 20000),
('IT0002', 'KW0001', 20000),
('IT0003', 'KW0001', 20000),
('IT0003', 'KW0002', 50000),
('IT0004', 'KW0001', 20000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `nota`
--

CREATE TABLE `nota` (
  `id_pembayaran` varchar(12) NOT NULL,
  `tgl` date NOT NULL,
  `id_pengunjung` varchar(20) NOT NULL,
  `id_pegawai` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `nota`
--

INSERT INTO `nota` (`id_pembayaran`, `tgl`, `id_pengunjung`, `id_pegawai`) VALUES
('IT0001', '2021-06-01', '34658866', 'KP0001'),
('IT0002', '2021-06-01', '346588661', 'KP0001'),
('IT0003', '2021-06-10', '34658866', 'KP0002'),
('IT0004', '2021-06-16', '346588661', 'KP0001');

-- --------------------------------------------------------

--
-- Struktur dari tabel `nota_oleh_oleh`
--

CREATE TABLE `nota_oleh_oleh` (
  `id_pembayaran` varchar(12) NOT NULL,
  `tgl` date NOT NULL,
  `id_pengunjung` varchar(20) NOT NULL,
  `id_pegawai` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `nota_oleh_oleh`
--

INSERT INTO `nota_oleh_oleh` (`id_pembayaran`, `tgl`, `id_pengunjung`, `id_pegawai`) VALUES
('IP0001', '2021-06-01', '346588661', 'KP0001'),
('IP0002', '2019-06-16', '34658866', 'KP0001');

-- --------------------------------------------------------

--
-- Struktur dari tabel `oleh_oleh`
--

CREATE TABLE `oleh_oleh` (
  `kode_barang` varchar(15) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `Harga` int(11) NOT NULL,
  `stok` int(11) NOT NULL,
  `Alamat` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `oleh_oleh`
--

INSERT INTO `oleh_oleh` (`kode_barang`, `nama_barang`, `Harga`, `stok`, `Alamat`) VALUES
('KB0001', 'kacang botol', 25000, 50, 'kei'),
('KB0002', 'baju festival meti kei', 80000, 600, 'langgur');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` varchar(15) NOT NULL,
  `nama_pegawai` varchar(35) NOT NULL,
  `username` varchar(35) NOT NULL,
  `password` varchar(35) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama_pegawai`, `username`, `password`, `no_hp`, `alamat`) VALUES
('KP0001', 'Nasrul Matdoan', 'nasrul', '22222', '081617590996', 'Jl. Damai'),
('KP0002', 'Dewi', 'dewi', '22222', '066556', 'Depok');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengunjung`
--

CREATE TABLE `pengunjung` (
  `nik` varchar(20) NOT NULL,
  `nama_pengunjung` varchar(35) NOT NULL,
  `jenis_kelamin` varchar(15) NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `tujuan_wisata` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengunjung`
--

INSERT INTO `pengunjung` (`nik`, `nama_pengunjung`, `jenis_kelamin`, `alamat`, `no_hp`, `tujuan_wisata`) VALUES
('34658866', 'Wulan', 'Perempuan', 'Kp. Cikapek', '08176348788', 'kei'),
('346588661', 'Ismail', 'Laki-Laki', 'Kp. Gedong', '08176348788', 'Kei');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transportasi`
--

CREATE TABLE `transportasi` (
  `kd_transportasi` varchar(15) NOT NULL,
  `jenis_transportasi` varchar(50) NOT NULL,
  `nama_transportasi` varchar(50) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transportasi`
--

INSERT INTO `transportasi` (`kd_transportasi`, `jenis_transportasi`, `nama_transportasi`, `harga`) VALUES
('KT0001', 'Motor', 'Honda Beat', 100000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `wisata`
--

CREATE TABLE `wisata` (
  `kode_wisata` varchar(15) NOT NULL,
  `nama_wisata` varchar(50) NOT NULL,
  `harga` int(12) NOT NULL,
  `alamat` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `wisata`
--

INSERT INTO `wisata` (`kode_wisata`, `nama_wisata`, `harga`, `alamat`) VALUES
('KW0001', 'Gua Hawang', 20000, 'Desa Letvuan, Kabupaten Maluku Tenggara, Propinsi Maluku'),
('KW0002', 'Pantai Kei', 50000, 'Maluku Tenggara');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`kode_hotel`);

--
-- Indeks untuk tabel `isi_akomodasi`
--
ALTER TABLE `isi_akomodasi`
  ADD UNIQUE KEY `uniq` (`id_pembayaran`);

--
-- Indeks untuk tabel `isi_wisata`
--
ALTER TABLE `isi_wisata`
  ADD KEY `id_pembayaran` (`id_pembayaran`);

--
-- Indeks untuk tabel `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`id_pembayaran`);

--
-- Indeks untuk tabel `nota_oleh_oleh`
--
ALTER TABLE `nota_oleh_oleh`
  ADD PRIMARY KEY (`id_pembayaran`);

--
-- Indeks untuk tabel `oleh_oleh`
--
ALTER TABLE `oleh_oleh`
  ADD PRIMARY KEY (`kode_barang`);

--
-- Indeks untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indeks untuk tabel `pengunjung`
--
ALTER TABLE `pengunjung`
  ADD PRIMARY KEY (`nik`);

--
-- Indeks untuk tabel `transportasi`
--
ALTER TABLE `transportasi`
  ADD PRIMARY KEY (`kd_transportasi`);

--
-- Indeks untuk tabel `wisata`
--
ALTER TABLE `wisata`
  ADD PRIMARY KEY (`kode_wisata`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
