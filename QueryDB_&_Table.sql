-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Aug 21, 2020 at 09:05 PM
-- Server version: 5.7.26
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `prueba`
--

-- --------------------------------------------------------

--
-- Table structure for table `crudservlet`
--

Create database if not exists `savocado`;
Use `savocado`;

CREATE TABLE `merchant` (
  `id` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `crudservlet`
--
ALTER TABLE `merchant`
  ADD PRIMARY KEY (`id`);
