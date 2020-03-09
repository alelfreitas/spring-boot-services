FROM adoptopenjdk:openj9

EXPOSE 5555
ADD /build/libs/*.jar run.jar

ENTRYPOINT ["java", "-jar", "run.jar"]