create database ElectricityBillingSystem;


use ElectricityBillingSystem;
CREATE TABLE Customers (

    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    Username VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) UNIQUE NOT NULL,
    confirmpassword VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(15),
    address TEXT,
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code VARCHAR(10),
    Meter_Number int(6),
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    payment_method VARCHAR(50)
);

CREATE TABLE ElectricityUsage (
    usage_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    units_consumed DECIMAL(10, 2) NOT NULL,
    usage_date DATE NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

CREATE TABLE Bill (
    bill_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    billing_date DATE NOT NULL,
    usage_id INT,  -- Reference to usage_id in ElectricityUsage
    total_amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (usage_id) REFERENCES ElectricityUsage(usage_id)
);

ALTER TABLE Bill
ADD COLUMN previous_amount DECIMAL(10, 2) NULL;

Select * from Customers;
select * from Bill;
select * from  ElectricityUsage ;
