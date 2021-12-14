FROM openjdk:slim
ADD target/book-platform-1.jar book-platform.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/book-platform.jar"]