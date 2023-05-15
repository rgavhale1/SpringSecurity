
FROM openjdk

ENV SERVER_PORT=8034

COPY target/SpringSecurity*.jar /usr/local/lib/SpringSecurity.jar

EXPOSE 8034
ENTRYPOINT ["java","-jar","/usr/local/lib/SpringSecurity.jar"]

