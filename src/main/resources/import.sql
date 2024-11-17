INSERT INTO roles (rol, created_at) VALUES ('ADMIN', NOW());
INSERT INTO roles (rol, created_at) VALUES ('USER', NOW());
INSERT INTO roles (rol, created_at) VALUES ('COMPANY MANAGER', NOW());
INSERT INTO roles (rol, created_at) VALUES ('DRIVER', NOW());
INSERT INTO roles (rol, created_at) VALUES ('MODERATOR', NOW());

-- Insert countries
INSERT INTO countries ( name) VALUES ( 'Colombia');
-- Insert cities
INSERT INTO cities ( name, country_id) VALUES ( 'Bogota',1);

-- Insert users santiago
INSERT INTO users ( username, password, email, photo_profile_url, enabled, created_at, updated_at) VALUES ( 'santiago', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', 'santiago@example.com', 'https://example.com/photos/santiago.jpg', true, NOW(), NOW());
-- Insert user Daniel
INSERT INTO users ( username, password, email, photo_profile_url, enabled, created_at, updated_at) VALUES ( 'daniel', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', 'daniel@example.com', 'https://example.com/photos/daniel.jpg', true, NOW(), NOW());
-- Insert user Andrea
INSERT INTO users ( username, password, email, photo_profile_url, enabled, created_at, updated_at) VALUES ( 'andrea', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', 'andrea@example.com', 'https://example.com/photos/andrea.jpg', true, NOW(), NOW());
-- Insert user Anyi
INSERT INTO users ( username, password, email, photo_profile_url, enabled, created_at, updated_at) VALUES ( 'anyi', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', 'anyi@example.com', 'https://example.com/photos/anyi.jpg', true, NOW(), NOW());

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
INSERT INTO routes ( name, price, created_at, updated_at) VALUES ( 'Route A', 10.50, NOW(), NOW());

-- Insert route 2
INSERT INTO routes ( name, price, created_at, updated_at) VALUES ('Route B', 15.75, NOW(), NOW());

-- Insert route 3
INSERT INTO routes ( name, price, created_at, updated_at) VALUES ( 'Route C', 20.00, NOW(), NOW());

-- Insert review 1 for Route A
INSERT INTO reviews ( title, stars, content, route_id, user_id, created_at, updated_at) VALUES ( 'Great Experience', 5, 'The route was amazing and comfortable!', 1, 1, NOW(), NOW());

-- Insert review 2 for Route A
INSERT INTO reviews ( title, stars, content, route_id, user_id, created_at, updated_at) VALUES ( 'Good Service', 4, 'I enjoyed the trip but the seats could be better.', 1, 2, NOW(), NOW());

-- Insert review 3 for Route B
INSERT INTO reviews ( title, stars, content, route_id, user_id, created_at, updated_at) VALUES ( 'Comfortable Journey, But Room for Improvement', 4, 'The trip was overall very pleasant. The driver was friendly, and the scenery along the route was stunning. The bus was clean, and I appreciated the timely departure and arrival. However, I did find that the seats were a bit uncomfortable for a longer trip. A bit more legroom or cushioning would have made the ride more enjoyable.\n\nOne thing I liked about this service was the smooth check-in process. The staff were polite and quick to assist, which made the whole experience more streamlined. The air conditioning was also just right, making the ride comfortable despite the warm weather outside.\n\nThe only downside was the lack of onboard entertainment. A few movies or music options would have been a nice touch, especially for such a long ride. Despite these minor issues, I would still recommend this route for anyone looking for a reliable, efficient travel option.', 1, 3, NOW(), NOW());

-- Insert review 1 for Route B
INSERT INTO reviews ( title, stars, content, route_id, user_id, created_at, updated_at) VALUES ( 'Satisfactory', 3, 'The route was okay, but it could be improved.', 2, 1, NOW(), NOW());

-- Insert review 2 for Route B
INSERT INTO reviews ( title, stars, content, route_id, user_id, created_at, updated_at) VALUES ( 'Convenient and Affordable', 4, 'Good value for money, especially for regular commuters.', 2, 2, NOW(), NOW());

-- Insert review 1 for Route C
INSERT INTO reviews ( title, stars, content, route_id, user_id, created_at, updated_at) VALUES ( 'Excellent', 5, 'One of the best routes I have taken!', 3, 1, NOW(), NOW());

-- Insert review 2 for Route C
INSERT INTO reviews ( title, stars, content, route_id, user_id, created_at, updated_at) VALUES ( 'Safe and Reliable', 4, 'A safe option for daily travel. Highly recommended.', 3, 2, NOW(), NOW());
