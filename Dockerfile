FROM centos:7
MAINTAINER CZX
ADD bamkafkaserv-1.0-SNAPSHOT.jar bamkafkaserv-1.0-SNAPSHOT.jar

ENV LANG C.UTF-8
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","bamkafkaserv-1.0-SNAPSHOT.jar"] #启动时运行
EXPOSE 10001