FROM mysql/mysql-server:8.0
# FROM openjdk:jdk-alpine

# ENV MYSQL_DATABASE=taskdb\
#   MYSQL_USER=eREDROCK\
#   MYSQL_PASSWORD=1204shin\
#   MYSQL_ROOT_PASSWORD=1204shin\
#   TZ=Asia/Tokyo

COPY ./my.cnf /etc/my.cnf
RUN chmod 644 /etc/my.cnf