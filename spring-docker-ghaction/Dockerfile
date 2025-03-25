# Sử dụng OpenJDK 17 làm base image
FROM openjdk:17-jdk

# Tạo thư mục trong container
WORKDIR /app

# Sao chép file jar từ target vào container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]

# Mở port 8080
EXPOSE 8080
