FROM mysql/mysql-server:8.0
FROM openjdk:jdk-alpine

ENV MYSQL_DATABASE=${DATABASE} \
  MYSQL_USER=${USERNAME} \
  MYSQL_PASSWORD=${USERPASS} \
  MYSQL_ROOT_PASSWORD=${ROOTPASS} \
  TZ=Asia/Tokyo

COPY ./my.cnf /etc/my.cnf
RUN chmod 644 /etc/my.cnf