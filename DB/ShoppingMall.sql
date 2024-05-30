-- Check if the ShoppingMall database exists and create it if it does not
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'ShoppingMall')
BEGIN
    CREATE DATABASE ShoppingMall COLLATE Chinese_Taiwan_Stroke_CI_AS;
END
GO

-- Use the ShoppingMall database
USE ShoppingMall;
GO

-- Create the Member table if it does not exist
IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND TABLE_NAME = 'Member')
BEGIN
CREATE TABLE Member (
                        member_id INT IDENTITY(1,1) PRIMARY KEY,
                        member_name NVARCHAR(50),
                        password VARCHAR(255) NOT NULL,
                        username VARCHAR(50) unique,
                        email NVARCHAR(50)
);
END
GO

-- Insert data into the Member table if it's empty
IF NOT EXISTS (SELECT * FROM Member)
BEGIN
    SET IDENTITY_INSERT Member ON;
INSERT INTO Member (member_id, member_name, email, password, username)
VALUES
    (458, '張三', 'zhangsan@example.com','$2a$10$.UAoeaAVeH8vhPsxHaw1I.teyo3iBunZllqraM1EmHQJwk1CkwD8u','user1'),
    (55688, '李四', 'lisi@example.com','$2a$10$.UAoeaAVeH8vhPsxHaw1I.teyo3iBunZllqraM1EmHQJwk1CkwD8u','user3'),
    (1713, '王五', 'wangwu@example.com','$2a$10$.UAoeaAVeH8vhPsxHaw1I.teyo3iBunZllqraM1EmHQJwk1CkwD8u','user2'),
    (1, '管理員', 'userone@example.com','$2a$10$.UAoeaAVeH8vhPsxHaw1I.teyo3iBunZllqraM1EmHQJwk1CkwD8u','admin');
SET IDENTITY_INSERT Member OFF;
END
GO

-- Create the product table if it does not exist
IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND TABLE_NAME = 'product')
BEGIN
CREATE TABLE product (
                         product_id NVARCHAR(10) PRIMARY KEY,
                         product_name NVARCHAR(50),
                         price INT,
                         quantity INT
);
END
GO

-- Insert data into the product table if it's empty
IF NOT EXISTS (SELECT * FROM product)
BEGIN
INSERT INTO product (product_id, product_name, price, quantity)
VALUES
    ('P001', 'osii 舒壓按摩椅', 98000, 5),
    ('P002', '網友最愛起司蛋糕', 1200, 50),
    ('P003', '真愛密碼項鍊', 8500, 20);
END
GO

-- Create the order table if it does not exist
IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND TABLE_NAME = 'order')
BEGIN
CREATE TABLE [order] (
                         order_id NVARCHAR(17) PRIMARY KEY,
    member_id INT NOT NULL,
    price INT,
    pay_status BIT,
    FOREIGN KEY (member_id) REFERENCES Member(member_id)
    );
END
GO

-- Insert data into the order table if it's empty
IF NOT EXISTS (SELECT * FROM [order])
BEGIN
INSERT INTO [order] (order_id, member_id, price, pay_status)
VALUES
    ('Ms20250801186230', 458, 98000, 1),
    ('Ms20250805157824', 55688, 9700, 0),
    ('Ms20250805258200', 1713, 2400, 1);
END
GO

-- Create the order_detail table if it does not exist
IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND TABLE_NAME = 'order_detail')
BEGIN
CREATE TABLE order_detail (
                              order_item_sn INT IDENTITY(1,1) PRIMARY KEY,
                              order_id NVARCHAR(17),
                              product_id NVARCHAR(10),
                              quantity INT,
                              stand_price INT,
                              item_price INT,
                              FOREIGN KEY (order_id) REFERENCES [order](order_id),
                              FOREIGN KEY (product_id) REFERENCES product(product_id)
);
END
GO

-- Insert data into the order_detail table if it's empty
IF NOT EXISTS (SELECT * FROM order_detail)
BEGIN
INSERT INTO order_detail (order_id, product_id, quantity, stand_price, item_price)
VALUES
    ('Ms20250801186230', 'P001', 1, 98000, 98000),
    ('Ms20250805157824', 'P002', 1, 1200, 1200),
    ('Ms20250805157824', 'P003', 1, 8500, 8500),
    ('Ms20250805258200', 'P002', 2, 1200, 2400);
END
GO

-- Select statements to verify contents of the tables
SELECT * FROM Member;
SELECT * FROM product;
SELECT * FROM [order];
SELECT * FROM order_detail;
