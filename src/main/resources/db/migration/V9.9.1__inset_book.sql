-- Insert dummy data into customer table
INSERT INTO public.customer (name) VALUES
('John Doe'),
('Jane Smith'),
('Alice Johnson'),
('Bob Brown'),
('Carol White'),
('David Green'),
('Emma Davis'),
('Frank Miller'),
('Grace Lee'),
('Hannah Wilson');

-- Insert dummy data into item table
INSERT INTO public.item (name, price) VALUES
('Laptop', 999.99),
('Smartphone', 499.99),
('Tablet', 299.99),
('Headphones', 149.99),
('Smartwatch', 199.99),
('Monitor', 299.99),
('Keyboard', 49.99),
('Mouse', 29.99),
('Printer', 129.99),
('Webcam', 89.99);

-- Insert dummy data into sale table
INSERT INTO public.sale (date, quantity, total_amount, customer_id, item_id) VALUES
('2024-07-01 10:00:00', 1, 999.99, 1, 1),
('2024-07-01 11:00:00', 2, 999.98, 2, 2),
('2024-07-01 12:00:00', 1, 299.99, 3, 3),
('2024-07-02 09:00:00', 3, 449.97, 4, 4),
('2024-07-02 14:00:00', 1, 199.99, 5, 5),
('2024-07-03 00:00:00', 1, 299.99, 6, 6),
('2024-07-03 00:00:00', 4, 199.96, 7, 7),
('2024-07-04 00:00:00', 5, 149.95, 8, 8),
('2024-07-04 00:00:00', 2, 259.98, 9, 9),
('2024-07-26 00:00:00', 3, 269.97, 10, 10);

