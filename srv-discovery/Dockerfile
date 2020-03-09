FROM adoptopenjdk:openj9

EXPOSE 8761
ADD /build/libs/*.jar run.jar

ENTRYPOINT ["java", "-jar", "run.jar"]