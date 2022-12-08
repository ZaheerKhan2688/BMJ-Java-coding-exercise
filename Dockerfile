FROM openjdk:11
EXPOSE 8080
ADD target/springboot-images-bmj.jar springboot-images-bmj.jar
ENTRYPOINT ["java","-jar","/springboot-images-bmj.jar"]