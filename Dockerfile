FROM openjdk:17
ADD target/hostel-mysql-docker.jar hostel-mysql-docker.jar
ENTRYPOINT ["java","-jar","/hostel-mysql-docker.jar"]