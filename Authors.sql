USE db_ltjava;

-- Xóa các bảng cũ để tránh xung đột
DROP TABLE IF EXISTS AUTHORISBN;
DROP TABLE IF EXISTS TITLES;
DROP TABLE IF EXISTS AUTHORS;
DROP TABLE IF EXISTS person;

-- Tạo bảng 'person' khớp với class JdbcPerson của bạn
CREATE TABLE IF NOT EXISTS person (
    id_person INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_person)
);

-- Chèn dữ liệu mẫu để test
INSERT INTO person (name) VALUES 
('Charly'),
('John'),
('Admin'),
('UserTest');