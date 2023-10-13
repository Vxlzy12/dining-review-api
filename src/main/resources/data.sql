DELETE FROM restaurant;

INSERT INTO restaurant (name, zip_code, overall_score, peanut_score, egg_score, dairy_score)
VALUES
  ('Restaurante Ejemplo 1', 12345, 4, 5, 4, 3),
  ('Restaurante Ejemplo 2', 12345, 3, 4, 3, 2);
INSERT INTO users (display_name, city, state, zip_code, peanut_allergy, egg_allergy, dairy_allergy) VALUES ('AlpacaStacka', 'Zaragoza', 'Aragon', 3001, true, false, false);
