-- phpMyAdmin SQL Dump
-- version 2.11.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 17, 2019 at 04:21 PM
-- Server version: 5.0.45
-- PHP Version: 5.2.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `booking`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `kode_booking` int(50) NOT NULL,
  `id_kategori` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `waktu` varchar(100) NOT NULL,
  `nama_pemesan` varchar(100) NOT NULL,
  `nama_team` varchar(100) NOT NULL,
  `hp` varchar(50) NOT NULL,
  PRIMARY KEY  (`kode_booking`),
  KEY `barang_ibfk_1` (`id_kategori`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`kode_booking`, `id_kategori`, `tanggal`, `waktu`, `nama_pemesan`, `nama_team`, `hp`) VALUES
(12, '1', '2019-01-16', '212', '21', '212', '2112'),
(1, '2', '2019-01-16', 'jam 9 - 10', 'hajsah', 'hajsa', '2391019'),
(23, 'LPNG002', '2019-01-16', 'jam9-21', 'ddsa', 'sda', '23121'),
(123, 'LPNG003', '2019-01-16', '07.00 - 09.00', 'Joni', 'FCFC', '098767890'),
(1111, 'LPNG005', '2019-01-16', 'Jam 09.00 - 10.00', 'Alfin', 'THCFC', '0998678');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  PRIMARY KEY  (`id_kategori`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama`) VALUES
('LPNG001', 'Lapangan Sintetis'),
('LPNG002', 'Lapangan Plur'),
('LPNG003', 'Lapangan Rumput'),
('LPNG005', 'Lapangan 123');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(5) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(10) NOT NULL,
  `level` varchar(5) NOT NULL,
  PRIMARY KEY  (`id_user`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `level`) VALUES
(1, 'admin', 'admin', 'Admin'),
(2, 'Wahyu', 'wahyu', 'Admin'),
(3, 'kasir', 'kasir', 'Kasir');
