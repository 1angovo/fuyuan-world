# 🐾 福元的世界 - 宠物档案与成长记录平台

这是一个基于 **Spring Boot + 原生前端 (HTML/CSS/JS)** 开发的全栈个人项目。最初用来记录我家猫咪“福元”的日常生活，现在已升级为一个具备完整后端接口与数据库持久化能力的宠物展示与管理系统。

**在线预览 (前端静态版)**：[https://1angovo.github.io/1angovo/](https://1angovo.github.io/1angovo/)

## 🛠️ 技术栈

- **前端**：HTML5, CSS3, 原生 JavaScript (Fetch API)
- **后端**：Java 17, Spring Boot 3.2.5
- **持久层**：MyBatis 3.0.3
- **数据库**：H2 Database (文件模式，兼容 MySQL 语法)
- **工具**：Maven, Postman, Git

## ✨ 核心功能

1. **宠物档案展示**：首页动态读取并展示宠物（福元）的基本信息。
2. **日常瞬间相册**：从数据库读取照片列表，展示九宫格相册。
3. **粉丝留言板**：访客可提交留言（默认状态为待审核），前端仅展示审核通过的留言。
4. **RESTful API**：提供标准的宠物、照片、留言的增删改查接口。

## 📂 项目结构

```text
Fuyuan
├── src/main/java/com/example/fuyuan
│   ├── controller        # 控制层，处理 HTTP 请求
│   ├── service           # 业务逻辑层
│   │   └── impl          # 业务逻辑实现
│   ├── mapper            # MyBatis 数据访问接口
│   ├── entity            # 数据库实体类
│   ├── common            # 通用返回结果封装 (Result)
│   └── config            # 跨域等配置类
├── src/main/resources
│   ├── static            # 前端静态资源 (HTML/CSS/JS/图片)
│   ├── mapper            # MyBatis XML 映射文件
│   ├── application.properties # 核心配置文件
│   └── schema.sql        # 数据库自动建表脚本
└── pom.xml               # Maven 依赖管理