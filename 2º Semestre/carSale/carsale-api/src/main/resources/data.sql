
INSERT INTO cars (brand, model, image_url, description) VALUES
('Toyota', 'Corolla', 'https://www.toyotacomunica.com.br/wp-content/uploads/2023/09/pagina-24_COROLLA-2024_GR-S_2.png', 'Reliable and fuel-efficient sedan'),
('Honda', 'Civic', 'https://production.autoforce.com/uploads/version/profile_image/2701/comprar-exl_414646a7fc.png', 'Sporty and compact sedan'),
('Ford', 'Mustang', 'https://estofariabrasil.com.br/wp-content/uploads/2020/03/Mustang-GT500.png', 'Iconic American muscle car'),
('Chevrolet', 'Camaro', 'https://www.riocarchevroletpetrolina.com.br/content/dam/chevrolet/sa/br/pt/master/home/performance/camaro/colorizer/chevrolet-camaro-coupe-laranja-sunset.png?imwidth=900', 'High-performance sports car'),
('Tesla', 'Model S', 'https://www.tesla.com/ownersmanual/images/GUID-752B0ED4-D0A1-46C4-A141-F6A339F786A3-online-en-US.png', 'Luxurious electric sedan with autopilot'),
('BMW', 'X5', 'https://grandbrasil.com.br/wp-content/uploads/2020/02/5c1b0-grupo-de-mc3a1scara-1.webp', 'Premium mid-size SUV with advanced features');


INSERT INTO users (name, username, password, role) VALUES
('Alice Smith', 'alice.smith', '$2b$10$475MbfxlC6BalucOhJOQWOLDUPqRcNV/i4t3U2feGNQ7DPPtw7vmC', 'ROLE_ADMIN'),
('Bob Johnson', 'bob.johnson', '$2b$10$W0ykgtoIgiIQz4NohC9J.Of6wU3152GfLU4kSOvsn0kTpr1xLaR4O', 'ROLE_USER'),
('Charlie Brown', 'charlie.brown', '$2b$10$HdttlnZlCEKna0KdepkdGuhCSj.Hroq5XMmwfVy.ybRHEjCJRN8/u', 'ROLE_USER');

INSERT INTO Comments (comment, created_date, car_id, user_id) VALUES
('O Toyota Corolla superou minhas expectativas em termos de economia de combustível e conforto. Ótimo carro para quem busca um sedã confiável.', '2024-08-15', 1, 1),
('O Honda Civic oferece uma condução esportiva e confortável. Seu design moderno é impressionante, mas o consumo de combustível poderia ser melhor.', '2024-08-16', 2, 2),
('Dirigir o Ford Mustang é uma experiência incrível. O som do motor e a aceleração são viciantes. Definitivamente um carro para os amantes de velocidade.', '2024-08-17', 3, 3),
('O Chevrolet Camaro tem um desempenho impressionante e um design arrojado. No entanto, o espaço interno é um pouco limitado para passageiros mais altos.', '2024-08-18', 4, 1),
('O Tesla Model S é o futuro dos carros elétricos. A tecnologia de piloto automático é fantástica, mas o preço ainda é um pouco alto para a maioria.', '2024-08-19', 5, 2),
('O BMW X5 combina luxo e praticidade. É ideal para quem busca um SUV espaçoso e com bom desempenho, mas o consumo de combustível é um ponto de atenção.', '2024-08-20', 6, 3),
('A tecnologia do Honda Civic é de ponta, com conectividade excelente. No entanto, achei o espaço no banco traseiro um pouco apertado.', '2024-08-18', 2, 1),
('O Mustang é pura adrenalina. O design clássico com toques modernos é um ponto forte, mas o consumo de combustível é elevado.', '2024-08-20', 3, 2),
('A aceleração do Tesla Model S é incrível. É impressionante como ele combina luxo e sustentabilidade. A autonomia também é um ponto positivo.', '2024-08-24', 5, 3);