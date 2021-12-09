FROM openjdk:slim
ADD target/review-platform-1.jar review-platform.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/review-platform.jar"]