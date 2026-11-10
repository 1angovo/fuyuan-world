SET NAMES utf8mb4;
CREATE DATABASE IF NOT EXISTS fuyuan_db DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE fuyuan_db;

CREATE TABLE IF NOT EXISTS pet (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    breed VARCHAR(50),
    gender VARCHAR(10),
    birthday DATE,
    arrival_date DATE,
    personality VARCHAR(500),
    hobbies VARCHAR(500),
    description TEXT,
    avatar_url VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS diary (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pet_id BIGINT,
    title VARCHAR(100) NOT NULL,
    content TEXT,
    diary_type VARCHAR(30),
    event_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS photo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pet_id BIGINT,
    diary_id BIGINT,
    image_url VARCHAR(255),
    caption VARCHAR(255),
    category VARCHAR(30),
    taken_at DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS comment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(50) NOT NULL,
    content VARCHAR(500) NOT NULL,
    status INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS admin_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO pet (name, breed, gender, birthday, arrival_date, personality, hobbies, description, avatar_url)
SELECT '福元', '金渐层', '公', '2024-11-20', '2025-01-08', '粘人又傲娇，好奇宝宝', '逗猫棒、冻干、纸箱',
       '福元是一只金色的金渐层猫咪，有着标志性的大圆脸和大大的绿眼睛。他超级爱撒娇，最喜欢被摸摸头。福元还有好多名字——元宝、元元、福福、元宝，你说哪个都对！',
       '/images/richang1.jpg'
WHERE NOT EXISTS (SELECT 1 FROM pet WHERE name = '福元');

INSERT INTO diary (pet_id, title, content, diary_type, event_date)
SELECT 1, '福元的第一天', '今天，福元第一次来到新家，有点害怕又有点好奇，开始慢慢探索吧。', '重要时刻', '2025-01-08'
WHERE NOT EXISTS (SELECT 1 FROM diary WHERE title = '福元的第一天');

INSERT INTO diary (pet_id, title, content, diary_type, event_date)
SELECT 1, '福元第一次洗澡', '福元第一次洗澡，全程一脸懵，乖乖配合，太可爱啦！', '日常', '2025-01-10'
WHERE NOT EXISTS (SELECT 1 FROM diary WHERE title = '福元第一次洗澡');

INSERT INTO diary (pet_id, title, content, diary_type, event_date)
SELECT 1, '福元一岁啦', '今天给福元过一岁生日，准备了美味的蛋糕和好多小鱼干！', '重要时刻', '2025-11-20'
WHERE NOT EXISTS (SELECT 1 FROM diary WHERE title = '福元一岁啦');

INSERT INTO photo (pet_id, diary_id, image_url, caption, category, taken_at) SELECT 1, NULL, '/images/richang1.jpg', '日常照片 1', '日常', '2025-01-15' WHERE NOT EXISTS (SELECT 1 FROM photo WHERE image_url = '/images/richang1.jpg');
INSERT INTO photo (pet_id, diary_id, image_url, caption, category, taken_at) SELECT 1, NULL, '/images/richang2.jpg', '日常照片 2', '日常', '2025-02-05' WHERE NOT EXISTS (SELECT 1 FROM photo WHERE image_url = '/images/richang2.jpg');
INSERT INTO photo (pet_id, diary_id, image_url, caption, category, taken_at) SELECT 1, NULL, '/images/richang3.jpg', '日常照片 3', '日常', '2025-02-20' WHERE NOT EXISTS (SELECT 1 FROM photo WHERE image_url = '/images/richang3.jpg');
INSERT INTO photo (pet_id, diary_id, image_url, caption, category, taken_at) SELECT 1, NULL, '/images/richang4.jpg', '日常照片 4', '日常', '2025-03-10' WHERE NOT EXISTS (SELECT 1 FROM photo WHERE image_url = '/images/richang4.jpg');
INSERT INTO photo (pet_id, diary_id, image_url, caption, category, taken_at) SELECT 1, NULL, '/images/richang5.jpg', '日常照片 5', '日常', '2025-04-01' WHERE NOT EXISTS (SELECT 1 FROM photo WHERE image_url = '/images/richang5.jpg');
INSERT INTO photo (pet_id, diary_id, image_url, caption, category, taken_at) SELECT 1, NULL, '/images/richang6.jpg', '日常照片 6', '日常', '2025-05-15' WHERE NOT EXISTS (SELECT 1 FROM photo WHERE image_url = '/images/richang6.jpg');
INSERT INTO photo (pet_id, diary_id, image_url, caption, category, taken_at) SELECT 1, NULL, '/images/richang7.jpg', '日常照片 7', '日常', '2025-06-20' WHERE NOT EXISTS (SELECT 1 FROM photo WHERE image_url = '/images/richang7.jpg');
INSERT INTO photo (pet_id, diary_id, image_url, caption, category, taken_at) SELECT 1, NULL, '/images/richang8.jpg', '日常照片 8', '日常', '2025-08-08' WHERE NOT EXISTS (SELECT 1 FROM photo WHERE image_url = '/images/richang8.jpg');
INSERT INTO photo (pet_id, diary_id, image_url, caption, category, taken_at) SELECT 1, NULL, '/images/richang9.jpg', '日常照片 9', '日常', '2025-10-01' WHERE NOT EXISTS (SELECT 1 FROM photo WHERE image_url = '/images/richang9.jpg');

INSERT INTO admin_user (username, password_hash)
SELECT 'admin', 'e10adc3949ba59abbe56e057f20f883e'
WHERE NOT EXISTS (SELECT 1 FROM admin_user WHERE username = 'admin');
