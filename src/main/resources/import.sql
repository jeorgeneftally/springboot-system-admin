


INSERT INTO company(name,motto, image, foundation) VALUES ('Primera','Constacia-Sacrificio-Disciplina','No image',NOW());
INSERT INTO company(name,motto, image, foundation) VALUES ('Segunda','Unión y Esfuerzo','No image',NOW());
INSERT INTO company(name,motto, image, foundation) VALUES ('Tercera','La Vida por el Deber','No image',NOW());

INSERT INTO user(name, surname, address,email, telephone,image, company_id) VALUES ('Jeorge', 'Cea','Los Cardenales #89','jeorgeceacadiz@gmail.com','966043338','No image',1);
INSERT INTO user(name, surname, address,email, telephone,image, company_id) VALUES ('Jeorge1', 'Cea','Los Cardenales #89','jeorgeceacadiz@gmail.com','966043338','No image',2);
INSERT INTO user(name, surname, address,email, telephone,image, company_id) VALUES ('Jeorge2', 'Cea','Los Cardenales #89','jeorgeceacadiz@gmail.com','966043338','No image',3);

INSERT INTO course(name, site, hour,date) VALUES ('Bora', 'Chillan','20hrs', NOW());
INSERT INTO course(name, site, hour,date) VALUES ('Bora2', 'Chillan','20hrs',NOW());
INSERT INTO course(name, site, hour,date) VALUES ('Bora3', 'Chillan','20hrs',NOW());


INSERT INTO user_course(user_id, course_id) VALUES (1,1);
INSERT INTO user_course(user_id, course_id) VALUES (1,2);
INSERT INTO user_course(user_id, course_id) VALUES (1,3);
INSERT INTO user_course(user_id, course_id) VALUES (2,1);
INSERT INTO user_course(user_id, course_id) VALUES (2,2);
INSERT INTO user_course(user_id, course_id) VALUES (2,3);
INSERT INTO user_course(user_id, course_id) VALUES (3,1);
INSERT INTO user_course(user_id, course_id) VALUES (3,2);
INSERT INTO user_course(user_id, course_id) VALUES (3,3);

INSERT INTO firetruck(name,patent, company_id) VALUES ('B1','ncssda',1);
INSERT INTO firetruck(name,patent,  company_id) VALUES ('B2','dasdsa',2);
INSERT INTO firetruck(name,patent,  company_id) VALUES ('BF3','sadsa',3);
INSERT INTO firetruck(name,patent,  company_id) VALUES ('BF1','sadsad',1);
INSERT INTO firetruck(name,patent,  company_id) VALUES ('BX1','sdasad',1);

INSERT INTO maintenance(firetruck_id, description, date) VALUES (1,'Mantencion','2018-01-01');

INSERT INTO technical_review(firetruck_id, description, date) VALUES (1,'revision','2018-01-01');

INSERT INTO compartment( firetruck_id, name, description, date) VALUES (1,'G1', 'revision','2018-01-01');
INSERT INTO compartment( firetruck_id, name, description, date ) VALUES (1,'G2', 'revision','2018-01-01');
INSERT INTO compartment( firetruck_id, name, description, date) VALUES (1,'G3', 'revision', NOW());

INSERT INTO material(name) VALUES ('Mangera 50mm');
INSERT INTO material(name) VALUES ('Mangera 38mm');

INSERT INTO compartment_detail(compartment_id, quantity,size, state, material_id) VALUES (1,1, 'L','Bueno',1);
INSERT INTO compartment_detail(compartment_id, quantity,size, state, material_id) VALUES (1,1, 'L','Bueno',1);
INSERT INTO compartment_detail(compartment_id, quantity,size, state, material_id) VALUES (1,2, 'L','Regular',2);
INSERT INTO compartment_detail(compartment_id, quantity,size, state, material_id) VALUES (2,1, 'L','Bueno',1);
INSERT INTO compartment_detail(compartment_id, quantity,size, state, material_id) VALUES (3,2, 'L','Regular',2);

INSERT INTO role(name) VALUES ('ROLE_ADMIN')
INSERT INTO role(name) VALUES ('ROLE_USER')

INSERT INTO user_role(user_id,role_id) VALUES (1,1);
INSERT INTO user_role(user_id,role_id) VALUES (2,1);
INSERT INTO user_role(user_id,role_id) VALUES (3,1);


INSERT INTO warehouse(name, description, date, company_id) VALUES ('BODEGA 1', 'bod','2018-01-01',1);
INSERT INTO warehouse(name, description, date, company_id) VALUES ('BODEGA 2', 'bod','2018-01-01',1);
INSERT INTO warehouse(name, description, date, company_id) VALUES ('BODEGA 3', 'bod', NOW(),1);


INSERT INTO warehouse_detail(quantity,size, state, material_id,warehouse_id) VALUES (1, 'L','Bueno',1,1);
INSERT INTO warehouse_detail(quantity,size, state, material_id,warehouse_id)VALUES (1, 'L','Bueno',1,1);
INSERT INTO warehouse_detail(quantity,size, state, material_id,warehouse_id)VALUES (2, 'L','Regular',2,1);
INSERT INTO warehouse_detail(quantity,size, state, material_id,warehouse_id)VALUES (1, 'L','Bueno',1,1);
INSERT INTO warehouse_detail(quantity,size, state, material_id,warehouse_id)VALUES (2, 'L','Regular',2,1);

INSERT INTO user_detail(quantity,size, state, material_id,user_id) VALUES (1, 'L','Bueno',1,1);
INSERT INTO user_detail(quantity,size, state, material_id,user_id)VALUES (1, 'L','Bueno',1,1);