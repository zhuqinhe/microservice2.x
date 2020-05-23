#下载java8的镜像
#FROM java:8
FROM java:alpine
#将本地文件挂到到/tmp目录
VOLUME /tmp
#复制文件到容器
ADD microservice-gateway.jar /app.jar
#暴露10000端口
EXPOSE 10000
#配置启动容器后执行的命令
ENTRYPOINT ["java","-jar","/app.jar"]

