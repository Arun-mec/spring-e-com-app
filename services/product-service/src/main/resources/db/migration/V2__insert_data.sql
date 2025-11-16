-- Insert categories
INSERT INTO category (id, name, description) VALUES
 ('550e8400-e29b-41d4-a716-446655440001', 'Electronics', 'Devices and gadgets'),
 ('550e8400-e29b-41d4-a716-446655440002', 'Books', 'Books across various genres'),
 ('550e8400-e29b-41d4-a716-446655440003', 'Clothing', 'Men and Women clothing'),
 ('550e8400-e29b-41d4-a716-446655440004', 'Home & Kitchen', 'Home appliances and kitchenware'),
 ('550e8400-e29b-41d4-a716-446655440005', 'Sports', 'Sports equipment and gear'),
 ('550e8400-e29b-41d4-a716-446655440006', 'Toys', 'Toys and games for kids');

-- Insert products linked to categories
INSERT INTO product (id, name, description, quantity, price, category_id) VALUES
  ('660e8400-e29b-41d4-a716-446655440001', 'Smartphone', 'Latest smartphone with OLED display', 50, 699.99, '550e8400-e29b-41d4-a716-446655440001'),
  ('660e8400-e29b-41d4-a716-446655440002', 'Laptop', 'Lightweight laptop with 16GB RAM', 30, 1299.99, '550e8400-e29b-41d4-a716-446655440001'),
  ('660e8400-e29b-41d4-a716-446655440003', 'Novel Book', 'Bestselling fiction novel', 100, 19.99, '550e8400-e29b-41d4-a716-446655440002'),
  ('660e8400-e29b-41d4-a716-446655440004', 'T-shirt', 'Cotton T-shirt for men', 200, 14.99, '550e8400-e29b-41d4-a716-446655440003'),
  ('660e8400-e29b-41d4-a716-446655440005', 'Blender', 'High-speed kitchen blender', 40, 89.99, '550e8400-e29b-41d4-a716-446655440004'),
  ('660e8400-e29b-41d4-a716-446655440006', 'Football', 'Standard size football', 60, 29.99, '550e8400-e29b-41d4-a716-446655440005');
