DROP DATABASE IF EXISTS ecommerceTest;
DROP USER IF EXISTS 'ecommercetestadmin'@'localhost';
CREATE DATABASE IF NOT EXISTS ecommerceTest;
CREATE USER IF NOT EXISTS 'ecommercetestadmin'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
GRANT ALL PRIVILEGES ON ecommerceTest.* TO 'ecommercetestadmin'@'localhost';
