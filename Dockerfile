FROM openjdk:21

# định nghĩa tên biến môi trường
# cách 1
# ARG FILE_JAR=target/SpringBootWeb_2-0.0.1-SNAPSHOT.jar
# cách 2
ARG FILE_JAR=target/*.jar

# Thêm vào docker là ADD va dặt tên mới api-service.jar
ADD ${FILE_JAR} api-service.jar

# Chạy
ENTRYPOINT ["java", "-jar", "api-service.jar"]

EXPOSE 8080