FROM adoptopenjdk:openj9

EXPOSE 8081
ADD /build/libs/*.jar run.jar

ENTRYPOINT ["java", "-jar", "run.jar"]