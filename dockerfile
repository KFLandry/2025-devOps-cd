FROM openjdk:21-jdk AS build
WORKDIR /workspace
ARG JAR_FILE=target/tp-cd-2025.war
COPY $JAR_FILE .
RUN java -Djarmode=layertools -jar tp-cd-2025.war extract --destination extracted

FROM openjdk:21-jdk
LABEL wl.maintainer='Wilfried Landry <kankeulandry22@gmail.com>'
ARG EXTRACTED=/workspace/extracted
WORKDIR /runtime/app
COPY --from=build ${EXTRACTED}/dependencies/ ./
COPY --from=build ${EXTRACTED}/spring-boot-loader/ ./
COPY --from=build ${EXTRACTED}/snapshot-dependencies/ ./
COPY --from=build ${EXTRACTED}/application/ ./
WORKDIR /runtime
ENV TZ="Europe/Paris"
EXPOSE 8080
VOLUME /runtime/delivery
ENV JAVA_OPTS="-cp /runtime/delivery:/runtime/app"
RUN mkdir -p /runtime/log && chmod -R 777 /runtime/log
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} org.springframework.boot.loader.launch.WarLauncher"]
