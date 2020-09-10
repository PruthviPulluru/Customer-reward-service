insert into customer(id, name) values (250, 'John');
insert into customer(id, name) values (251, 'Kevin');

insert into customer_transaction(id, description, amount, tx_date, customer_id) values (1, 'tx 1', 170, '2020-09-07 10:20:10', 250);
insert into customer_transaction(id, description, amount, tx_date, customer_id) values (2, 'tx 2', 50, '2020-09-01 10:20:10', 250);
insert into customer_transaction(id, description, amount, tx_date, customer_id) values (3, 'tx 3', 120, '2020-08-24 10:20:10', 250);
insert into customer_transaction(id, description, amount, tx_date, customer_id) values (4, 'tx 10', 175, '2020-08-07 10:20:10', 250);
insert into customer_transaction(id, description, amount, tx_date, customer_id) values (5, 'tx 20', 65, '2020-08-05 10:20:10', 250);
insert into customer_transaction(id, description, amount, tx_date, customer_id) values (6, 'tx 30', 210, '2020-08-03 10:20:10', 250);
insert into customer_transaction(id, description, amount, tx_date, customer_id) values (7, 'tx 31', 42, '2020-07-18 17:10:10', 250);
insert into customer_transaction(id, description, amount, tx_date, customer_id) values (8, 'tx 8', 150, '2020-05-16 17:10:10', 250);

insert into customer_transaction(id, description, amount, tx_date, customer_id) values (20, 'tx 200', 25, '2020-08-01 12:20:10', 251);
insert into customer_transaction(id, description, amount, tx_date, customer_id) values (21, 'tx 201', 80, '2020-07-05 15:00:10', 251);
insert into customer_transaction(id, description, amount, tx_date, customer_id) values (22, 'tx 202', 116, '2020-09-01 11:30:10', 251);

insert into rewards_range(id,min_amt,max_amt,points) values(1,0,50,0);
insert into rewards_range(id,min_amt,max_amt,points) values(2,50.1,100,1);
insert into rewards_range(id,min_amt,max_amt,points) values(3,100.1,null,2);