DROP DATABASE IF EXISTS ecommerce;
DROP DATABASE IF EXISTS ecommerceTest;
DROP USER IF EXISTS 'ecommerceadmin'@'localhost';
CREATE DATABASE IF NOT EXISTS ecommerce;
CREATE DATABASE IF NOT EXISTS ecommerceTest;
CREATE USER IF NOT EXISTS 'ecommerceadmin'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
GRANT ALL PRIVILEGES ON ecommerce.* TO 'ecommerceadmin'@'localhost';
GRANT ALL PRIVILEGES ON ecommerceTest.* TO 'ecommerceadmin'@'localhost';
