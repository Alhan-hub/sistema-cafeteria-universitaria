# Sistema de Gestión de Pedidos de Cafetería Universitaria

# Descripción del Proyecto

El proyecto consiste en el desarrollo de una aplicación cliente-servidor que permite la gestión digital de pedidos en una cafetería universitaria, sustituyendo los registros manuales por un sistema automatizado que mejora la atención al cliente, el control de inventario y la trazabilidad de las órdenes.

El sistema integra un backend desarrollado con arquitectura por capas y un frontend en Java Swing que se comunica con los servicios web RESTful mediante peticiones HTTP.

2. Objetivo General Implementar una aplicación funcional que combine un cliente de escritorio (Swing) con un backend RESTful, aplicando buenas prácticas de desarrollo, principios de separación de capas y documentación de la API.

3. Alcance El sistema permitirá: Registrar clientes, productos y pedidos en una base de datos. Crear y consultar pedidos desde la interfaz Swing. Exponer endpoints RESTful para la gestión de pedidos y productos. Documentar los servicios web mediante Swagger/OpenAPI. Controlar versiones del código mediante Git aplicando ramas y commits descriptivos.

4. Arquitectura del Sistema El proyecto sigue una arquitectura multicapa, garantizando la separación de responsabilidades y la mantenibilidad del código: Capa Descripción Tecnologías Presentación (Frontend) Aplicación de escritorio desarrollada en Java Swing que permite a los usuarios interactuar con el sistema, visualizar productos y realizar pedidos. Java Swing Controladores (Controller) Gestionan las peticiones REST, actuando como punto de entrada del backend. Spring Boot Lógica de Negocio (Service). Contiene las reglas de negocio y operaciones sobre los datos (creación y validación de pedidos).

Spring Boot Persistencia (Repository y Model) Define las entidades del dominio y su mapeo con la base de datos utilizando JPA/Hibernate. JPA / Hibernate / MySQL Documentación y Control de Versiones Uso de Swagger/OpenAPI para la documentación de la API y GitHub para versionado con ramas y commits descriptivos. Swagger, Git

5. Beneficios del Proyecto Aplicación escalable y modular gracias a la arquitectura por capas. Comunicación eficiente entre cliente y servidor mediante servicios REST. Interfaz de escritorio intuitiva y funcional para los usuarios. Código mantenible, documentado y versionado profesionalmente.
