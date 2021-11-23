CREATE TABLE IF NOT EXISTS delivery (
	id varchar(255) NOT NULL,
	name varchar(255) NOT NULL,
	plan varchar(255) NOT NULL,
	percentage_by_product double NOT NULL
);

INSERT INTO delivery (id, name, plan, percentage_by_product) values
('1000',  'iFood', 'Basic', 15.50),
('2000',  'Goommer', 'Go Essencial', 3.34),
('3000',  'Tonolucro', 'N/D', 25),
('4000',  'Aiqfome', 'N/d', 14.99);