-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 29, 2025 at 07:01 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shopping_cart_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `product_dimension`
--

CREATE TABLE `product_dimension` (
  `product_id` bigint(20) NOT NULL,
  `capacity` varchar(10) NOT NULL,
  `price` varchar(10) NOT NULL,
  `product_name` varchar(20) NOT NULL,
  `variant` varchar(255) NOT NULL,
  `model` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_dimension`
--

INSERT INTO `product_dimension` (`product_id`, `capacity`, `price`, `product_name`, `variant`, `model`) VALUES
(1, '1TB', '100,000.00', 'iPhone 13', 'Graphite', 'PRO MAX'),
(2, '512GB', '88,000,00', 'iphone 16', 'Sierra Blue', 'PRO MAX'),
(3, '128GB', '46,000.00', 'Iphone 13', 'Silver', 'Base Model'),
(4, '1TB', '120,000.00', 'Sasung Galaxy', 'Silver', 'S25 Ultra'),
(5, '1TB', '98,000.00', 'Sasung Galaxy', 'Black', 'S24 Ultra');

-- --------------------------------------------------------

--
-- Table structure for table `sales_of_order`
--

CREATE TABLE `sales_of_order` (
  `order_id` bigint(20) NOT NULL,
  `order_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sales_of_order`
--

INSERT INTO `sales_of_order` (`order_id`, `order_date`, `status`, `product_id`, `customer_id`) VALUES
(1, '2025-01-01 15:52:14.000000', 'Placed', 1, 1),
(2, '2025-01-30 00:29:15.000000', 'Pending', 2, 1),
(11, '2025-01-30 01:28:06.000000', 'Pending', 2, 2),
(12, '2025-01-30 01:28:31.000000', 'Pending', 2, 2),
(13, '2025-01-30 01:28:34.000000', 'Pending', 2, 2),
(14, '2025-01-30 01:52:08.000000', 'Pending', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product_dimension`
--
ALTER TABLE `product_dimension`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `sales_of_order`
--
ALTER TABLE `sales_of_order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `FKdjje1prvxs9xj9xrpbu2qfovf` (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product_dimension`
--
ALTER TABLE `product_dimension`
  MODIFY `product_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `sales_of_order`
--
ALTER TABLE `sales_of_order`
  MODIFY `order_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sales_of_order`
--
ALTER TABLE `sales_of_order`
  ADD CONSTRAINT `FKdjje1prvxs9xj9xrpbu2qfovf` FOREIGN KEY (`product_id`) REFERENCES `product_dimension` (`product_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
