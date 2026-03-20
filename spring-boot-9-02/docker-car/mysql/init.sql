CREATE TABLE `dealership`
(
    `id`   int          NOT NULL AUTO_INCREMENT,
    `logo` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `manufacturer`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `name`      varchar(255) NOT NULL,
    `country`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `model`
(
    `id`          int          NOT NULL AUTO_INCREMENT,
    `brandLogo`   varchar(255) NOT NULL,
    `engine`      float DEFAULT NULL,
    `name`        varchar(255) NOT NULL,
    `manufacturer_id` int   DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `model_dealership`
(
    `model_id`  int DEFAULT NULL,
    `dealership_id` int DEFAULT NULL
);

INSERT INTO dealership(`id`, `logo`, `name`)
VALUES ('1', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNWXrN3dgjBHiUUo3hRCn3NmaTbPbthqgvrg&s',
        'Autopunkt');
INSERT INTO dealership(`id`, `logo`, `name`)
VALUES ('2', 'https://caroutlet.pl/wp-content/uploads/2024/04/dynamica-uzywanev3.svg', 'Dynamica Caroutlet');
INSERT INTO dealership(`id`, `logo`, `name`)
VALUES ('3', 'https://komiskaro.pl/f/199d1589/6529/crop/detect/60/v0/w0/h200/L_011-1.png', 'Karo Auto Komis');
INSERT INTO dealership(`id`, `logo`, `name`)
VALUES ('4', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSThx78YXgqyqOL2yccb_4svVGx5dIuP8neg&s', 'Superauto');

INSERT INTO manufacturer(`id`, name, country)
VALUES ('1', 'Skoda', 'Czech Republic');
INSERT INTO manufacturer(`id`, name, country)
VALUES ('2', 'Ford', 'USA');
INSERT INTO manufacturer(`id`, name, country)
VALUES ('3', 'Citroen', 'France');
INSERT INTO manufacturer(`id`, name, country)
VALUES ('4', 'Opel', 'Germany');

INSERT INTO model(`id`, brandLogo, engine, name, `manufacturer_id`)
VALUES ('1', 'https://cdn.skoda-storyboard.com/2020/11/SKODA-3D-Standard-Logo_sRGB-e1478246875778.png', '2.0', 'Octavia', '1');
INSERT INTO model(`id`, brandLogo, engine, name, `manufacturer_id`)
VALUES ('2', 'https://cdn.skoda-storyboard.com/2020/11/SKODA-3D-Standard-Logo_sRGB-e1478246875778.png', '1.4', 'Fabia', '1');
INSERT INTO model(`id`, brandLogo, engine, name, `manufacturer_id`)
VALUES ('3', 'https://www.citypng.com/public/uploads/preview/ford-logo-emblem-hd-png-70175169471401511cpxj0ogw.png', '2.2', 'Focus', '2');
INSERT INTO model(`id`, brandLogo, engine, name, `manufacturer_id`)
VALUES ('4', 'https://www.citypng.com/public/uploads/preview/ford-logo-emblem-hd-png-70175169471401511cpxj0ogw.png', '1.6',
        'Fiesta', '2');
INSERT INTO model(`id`, brandLogo, engine, name, `manufacturer_id`)
VALUES ('5', 'https://logos-world.net/wp-content/uploads/2021/08/Citroen-Emblem-700x394.png',
        '2.4', 'Berlingo', '3');
INSERT INTO model(`id`, brandLogo, engine, name, `manufacturer_id`)
VALUES ('6', 'https://logos-world.net/wp-content/uploads/2021/08/Citroen-Emblem-700x394.png', '2.0', 'Jumpy', '3');
INSERT INTO model(`id`, brandLogo, engine, name, `manufacturer_id`)
VALUES ('7', 'https://www.citypng.com/public/uploads/preview/hd-opel-logo-transparent-background-701751694707069gfhsibdnlp.png', '1.2', 'Astra', '4');
INSERT INTO model(`id`, brandLogo, engine, name, `manufacturer_id`)
VALUES ('8', 'https://www.citypng.com/public/uploads/preview/hd-opel-logo-transparent-background-701751694707069gfhsibdnlp.png', '3.0', 'Insignia', '4');

INSERT INTO model_dealership(model_id, dealership_id)
VALUES ('1', '1');
INSERT INTO model_dealership(model_id, dealership_id)
VALUES ('1', '3');
INSERT INTO model_dealership(model_id, dealership_id)
VALUES ('2', '3');
INSERT INTO model_dealership(model_id, dealership_id)
VALUES ('3', '1');
INSERT INTO model_dealership(model_id, dealership_id)
VALUES ('3', '2');
INSERT INTO model_dealership(model_id, dealership_id)
VALUES ('4', '1');
INSERT INTO model_dealership(model_id, dealership_id)
VALUES ('4', '3');
INSERT INTO model_dealership(model_id, dealership_id)
VALUES ('5', '2');
INSERT INTO model_dealership(model_id, dealership_id)
VALUES ('5', '3');
INSERT INTO model_dealership(model_id, dealership_id)
VALUES ('6', '1');
INSERT INTO model_dealership(model_id, dealership_id)
VALUES ('7', '2');
















CREATE TABLE user
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE role
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    role     VARCHAR(255)
);

INSERT INTO user(username, password)
VALUES ('dbuser1', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser2', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser3', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS');


INSERT INTO role(username, role)
VALUES ('dbuser1', 'USER_ADMIN'),
       ('dbuser2', 'AUTHOR_ADMIN'),
       ('dbuser3', 'BOOK_ADMIN');




