INSERT INTO team_work(id, name) VALUES
(1, 'Fedorov'),
(2, 'Rydik'),
(3, 'Svetloichniy');
INSERT INTO employee (id, first_name, last_name,team_work_id) VALUES
(1, 'Oleksii', 'Nefedov',1),
(2, 'Petya', 'Ivanov',1),
(3, 'Kolya', 'Kyplevackiy',2),
(4, 'Georgiy', 'Nejin',2);
INSERT INTO employee (id, first_name, last_name) VALUES
(5, 'Sasha', 'Stariy'),
(6, 'Ivan', 'Ivanich'),
(7, 'Senya', 'Ysachev'),
(8, 'Senja', 'Tkachenko'),
(9, 'Aleksandr', 'Beliy');
INSERT INTO time_sheet (id, name) VALUES
(1, 'example');
INSERT INTO time_sheet_employees (time_sheet_id, employees_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5);
INSERT INTO project (id,address,description, name) VALUES
(1, 'address one','first project','Kyliny'),
(2,'address two','second project', 'Petrovo');

