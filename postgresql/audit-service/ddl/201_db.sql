CREATE USER audit_app_user PASSWORD '123';

CREATE DATABASE audit_service
    OWNER audit_app_user;