FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
COPY build/libs/*.jar weesvc.jar
EXPOSE 8080
CMD java  -XX:+ -XX:+UseCGroupMemoryLimitForHeap -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar weesvc.jarUnlockExperimentalVMOptions