INSERT INTO roles (rol, created_at) VALUES ('ADMIN', NOW());
INSERT INTO roles (rol, created_at) VALUES ('USER', NOW());
INSERT INTO roles (rol, created_at) VALUES ('COMPANY MANAGER', NOW());
INSERT INTO roles (rol, created_at) VALUES ('DRIVER', NOW());
INSERT INTO roles (rol, created_at) VALUES ('MODERATOR', NOW());

-- Insert countries
INSERT INTO countries (id, name) VALUES (1, 'Colombia');
-- Insert cities
INSERT INTO cities (id, name, country_id) VALUES (1, 'Bogota',1);

-- Insert users santiago
INSERT INTO users (id, username, password, email, photo_profile_url, enabled, created_at, updated_at) VALUES (1, 'santiago', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', 'santiago@example.com', 'https://example.com/photos/santiago.jpg', true, NOW(), NOW());
-- Insert user Daniel
INSERT INTO users (id, username, password, email, photo_profile_url, enabled, created_at, updated_at) VALUES (2, 'daniel', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', 'daniel@example.com', 'https://example.com/photos/daniel.jpg', true, NOW(), NOW());
-- Insert user Andrea
INSERT INTO users (id, username, password, email, photo_profile_url, enabled, created_at, updated_at) VALUES (3, 'andrea', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', 'andrea@example.com', 'https://example.com/photos/andrea.jpg', true, NOW(), NOW());
-- Insert user Anyi
INSERT INTO users (id, username, password, email, photo_profile_url, enabled, created_at, updated_at) VALUES (4, 'anyi', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', 'anyi@example.com', 'https://example.com/photos/anyi.jpg', true, NOW(), NOW());

-- Associate Santiago with ADMIN role
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (1, 1);
-- Associate Daniel with USER role
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (2, 2);
-- Associate Andrea with COMPANY MANAGER role
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (3, 3);
-- Associate Anyi with DRIVER role
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (4, 4);


-- Insert routes
-- Insert route 1
INSERT INTO routes (id, name, price, created_at, updated_at) VALUES (1, 'Route A', 10.50, NOW(), NOW());

-- Insert route 2
INSERT INTO routes (id, name, price, created_at, updated_at) VALUES (2, 'Route B', 15.75, NOW(), NOW());

-- Insert route 3
INSERT INTO routes (id, name, price, created_at, updated_at) VALUES (3, 'Route C', 20.00, NOW(), NOW());

-- Insert review 1 for Route A
INSERT INTO reviews (id, title, stars, content, route_id, user_id, created_at, updated_at) VALUES (1, 'Great Experience', 5, 'The route was amazing and comfortable!', 1, 1, NOW(), NOW());

-- Insert review 2 for Route A
INSERT INTO reviews (id, title, stars, content, route_id, user_id, created_at, updated_at) VALUES (2, 'Good Service', 4, 'I enjoyed the trip but the seats could be better.', 1, 2, NOW(), NOW());

-- Insert review 1 for Route B
INSERT INTO reviews (id, title, stars, content, route_id, user_id, created_at, updated_at) VALUES (3, 'Satisfactory', 3, 'The route was okay, but it could be improved.', 2, 1, NOW(), NOW());

-- Insert review 2 for Route B
INSERT INTO reviews (id, title, stars, content, route_id, user_id, created_at, updated_at) VALUES (4, 'Convenient and Affordable', 4, 'Good value for money, especially for regular commuters.', 2, 2, NOW(), NOW());

-- Insert review 1 for Route C
INSERT INTO reviews (id, title, stars, content, route_id, user_id, created_at, updated_at) VALUES (5, 'Excellent', 5, 'One of the best routes I have taken!', 3, 1, NOW(), NOW());

-- Insert review 2 for Route C
INSERT INTO reviews (id, title, stars, content, route_id, user_id, created_at, updated_at) VALUES (6, 'Safe and Reliable', 4, 'A safe option for daily travel. Highly recommended.', 3, 2, NOW(), NOW());
