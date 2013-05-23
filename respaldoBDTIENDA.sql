-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 13-03-2013 a las 18:02:37
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bdtienda`
--
CREATE DATABASE `bdtienda` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bdtienda`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblproductos`
--

CREATE TABLE IF NOT EXISTS `tblproductos` (
  `id` int(11) NOT NULL,
  `descripcion` text NOT NULL,
  `precio` float NOT NULL,
  `cantidad` int(11) NOT NULL,
  `color` text NOT NULL,
  `tam` int(11) NOT NULL,
  `genero` text NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblproductos`
--

INSERT INTO `tblproductos` (`id`, `descripcion`, `precio`, `cantidad`, `color`, `tam`, `genero`) VALUES
(0, 'CAMISA CHOLA', 350, 400, 'ROJO', 30, 'MASCULINO'),
(1, 'CAMISA FRESONA', 450, 300, 'ROJO', 23, 'FEMENINO');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
