FROM openjdk:8-jdk-alpine
MAINTAINER Justin Menga <justin.menga@gmail.com>
LABEL application=microtrader-dev

# Install system dependencies
RUN echo "http://nl.alpinelinux.org/alpine/edge/testing/" >> /etc/apk/repositories && \
    apk update && \
    apk add --no-cache bash libstdc++ nodejs git && \
    npm install bower -g

# Install common dependencies
ENV APP_VERSION=snapshot
COPY gradle /app/gradle
COPY build.gradle settings.gradle gradlew /app/
WORKDIR /app/
RUN ./gradlew copyDeps

# Install module dependencies
COPY audit-service/build.gradle /app/audit-service/
COPY quote-generator/build.gradle /app/quote-generator/
COPY portfolio-service/build.gradle /app/portfolio-service/
COPY trader-dashboard/build.gradle /app/trader-dashboard/
COPY trader-dashboard/src/main/resources/webroot/bower.json /app/trader-dashboard/src/main/resources/webroot/bower.json
RUN ./gradlew copyDeps

# Set the app version and copy the application source
ARG app_version
ENV APP_VERSION=${app_version}
COPY microtrader-common /app/microtrader-common
COPY audit-service /app/audit-service
COPY quote-generator /app/quote-generator
COPY portfolio-service /app/portfolio-service
COPY trader-dashboard /app/trader-dashboard


