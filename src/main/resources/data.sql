CREATE TABLE restaurant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    overall_score INT,
    peanut_score INT,
    egg_score INT,
    dairy_score INT
);

INSERT INTO restaurant (name, overall_score, peanut_score, egg_score, dairy_score) VALUES ('Tagliatella', 5, 4, 3, 2);