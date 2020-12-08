-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Dec 07, 2020 at 06:13 PM
-- Server version: 5.7.26
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `savocado`
--

-- --------------------------------------------------------

CREATE DATABASE IF NOT EXISTS `savocado`;

--
-- Table structure for table `merchant`
--

CREATE TABLE `merchant` (
  `id` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `merchant`
--

INSERT INTO `merchant` (`id`, `name`, `password`, `email`, `country`) VALUES
(86, 'Edgar Renderos Alvarado', 'Hola1234', 'edraw.rda8@gmail.com', 'El Salvador');

-- --------------------------------------------------------

--
-- Table structure for table `orden`
--

CREATE TABLE `orden` (
  `id` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `dateordered` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orden`
--

INSERT INTO `orden` (`id`, `name`, `total`, `dateordered`) VALUES
(96, 'Ventas Varias Nuevamente', 199.99, '2020-12-07 03:34:40');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(70) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `dateadded` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `stock`, `dateadded`) VALUES
(29, 'Vidrio templado', 4.99, 360, '2020-12-06 02:50:38'),
(92, 'Teclado', 10.99, 532, '2020-12-06 03:13:03');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `merchant`
--
ALTER TABLE `merchant`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orden`
--
ALTER TABLE `orden`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);