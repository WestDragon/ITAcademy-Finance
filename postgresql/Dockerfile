FROM postgres:17-alpine
MAINTAINER ITAcademy

ADD /user-service/ddl/*.sql /docker-entrypoint-initdb.d/
ADD /audit-service/ddl/*.sql /docker-entrypoint-initdb.d/