# Sistema de Gestión de Pedidos de Cafetería Universitaria

# Descripción del Proyecto

El proyecto consiste en el desarrollo de una aplicación cliente-servidor que permite la gestión digital de pedidos en una cafetería universitaria, sustituyendo los registros manuales por un sistema automatizado que mejora la atención al cliente, el control de inventario y la trazabilidad de las órdenes.

El sistema integra un backend desarrollado con arquitectura por capas y un frontend en Java Swing que se comunica con los servicios web RESTful mediante peticiones HTTP.

2. Objetivo General Implementar una aplicación funcional que combine un cliente de escritorio (Swing) con un backend RESTful, aplicando buenas prácticas de desarrollo, principios de separación de capas y documentación de la API.

3. Alcance El sistema permitirá: Registrar clientes, productos y pedidos en una base de datos. Crear y consultar pedidos desde la interfaz Swing. Exponer endpoints RESTful para la gestión de pedidos y productos. Documentar los servicios web mediante Swagger/OpenAPI. Controlar versiones del código mediante Git aplicando ramas y commits descriptivos.

4. Arquitectura del Sistema El proyecto sigue una arquitectura multicapa, garantizando la separación de responsabilidades y la mantenibilidad del código: Capa Descripción Tecnologías Presentación (Frontend) Aplicación de escritorio desarrollada en Java Swing que permite a los usuarios interactuar con el sistema, visualizar productos y realizar pedidos. Java Swing Controladores (Controller) Gestionan las peticiones REST, actuando como punto de entrada del backend. Spring Boot Lógica de Negocio (Service). Contiene las reglas de negocio y operaciones sobre los datos (creación y validación de pedidos).

Spring Boot Persistencia (Repository y Model) Define las entidades del dominio y su mapeo con la base de datos utilizando JPA/Hibernate. JPA / Hibernate / MySQL Documentación y Control de Versiones Uso de Swagger/OpenAPI para la documentación de la API y GitHub para versionado con ramas y commits descriptivos. Swagger, Git

5. Beneficios del Proyecto Aplicación escalable y modular gracias a la arquitectura por capas. Comunicación eficiente entre cliente y servidor mediante servicios REST. Interfaz de escritorio intuitiva y funcional para los usuarios. Código mantenible, documentado y versionado profesionalmente.

# 📊 1. Diagrama Entidad-Relación
Este diagrama representa las tablas en tu base de datos (cafeteria_db) y cómo se conectan. Basado en tus entidades JPA (Cliente, Producto, Pedido), la estructura es la siguiente:
Las entidades centrales son Cliente y Producto. La entidad Pedido actúa como el "hecho" que conecta a un cliente con un producto en un momento dado.

Entidades y Atributos:
CLIENTE
1. documento (PK - Clave Primaria)
2. nombre

PRODUCTO

1. id (PK - Clave Primaria)
2. nombre
3. precio
4. stock

PEDIDO

1. id (PK - Clave Primaria)
2. cantidad
3. fechaPedido
4. estado
5. cliente_documento (FK - Clave Foránea que apunta a CLIENTE)
6. producto_id (FK - Clave Foránea que apunta a PRODUCTO)

# Relaciones (Cardinalidad):
Un Cliente puede tener muchos Pedidos. (Relación 1 a N)

Un Producto puede estar en muchos Pedidos. (Relación 1 a N)

![unnamed](https://github.com/user-attachments/assets/72141bcf-4ccf-4a98-9f35-c58b5951048a)

# Diagrama de Clases (Arquitectónico)
Este diagrama es más detallado y muestra las clases de tu aplicación Java (tanto del backend como del frontend), sus responsabilidades principales y cómo interactúan.




[Diagrama de Clases.drawio](https://github.com/user-attachments/files/23491681/Diagrama.de.Clases.drawio)
<mxfile host="app.diagrams.net" agent="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/142.0.0.0 Safari/537.36" version="28.2.9">
  <diagram name="Page-1" id="MD99ZTG1cz3UJOYK3dZ1">
    <mxGraphModel dx="1895" dy="2058" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="850" pageHeight="1100" math="0" shadow="0">
      <root>
        <mxCell id="0" />
        <mxCell id="1" parent="0" />
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-1" value="MODULO FRONTEND - Spring Swing Client" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="20" y="27.5" width="920" height="549" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-2" value="DTOs" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="49" y="440" width="833" height="104" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-3" value="ApiClients - Feign&#xa;&#xa;&#xa;&#xa;&#xa;&#xa;&#xa;" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="59" y="206.5" width="787" height="130" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-4" value="View - Swing&#xa;&#xa;&#xa;&#xa;&#xa;" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="110" y="42.5" width="653" height="104" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-5" value="MODULO BACKEND - Spring Boot API" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1160" y="-50" width="810" height="835" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-6" value="Models - JPA Entities&#xa;&#xa;&#xa;&#xa;&#xa;" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1211.5" y="668.5" width="725" height="104" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-7" value="Repositories&#xa;&#xa;&#xa;&#xa;&#xa;" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1208.5" y="480" width="753" height="104" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-8" value="Services&#xa;&#xa;&#xa;&#xa;&#xa;&#xa;&#xa;&#xa;&#xa;&#xa;&#xa;&#xa;&#xa;&#xa;" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1211.5" y="195" width="713" height="230" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-9" value="Controllers&#xa;&#xa;&#xa;&#xa;" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1185.5" y="-25" width="751" height="104" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-10" value="ClienteController" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1215.5" y="12.5" width="184" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-11" value="ProductoController" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1450" y="12.5" width="196" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-12" value="PedidoController" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1721.5" y="5" width="180" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-13" value="ClienteService" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1244.5" y="340.5" width="163" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-14" value="ProductoService" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1496.5" y="340.5" width="175" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-15" value="PedidoService" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1726.5" y="214.5" width="160" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-16" value="ClienteRepository" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1232.5" y="517.5" width="186" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-17" value="ProductoRepository" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1484.5" y="517.5" width="198" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-18" value="PedidoRepository" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1732.5" y="517.5" width="183" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-19" value="Cliente Entity" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1246.5" y="693.5" width="159" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-20" value="Producto Entity" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1498.5" y="693.5" width="171" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-21" value="Pedido Entity" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="1746.5" y="693.5" width="155" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-22" value="MainFrame JFrame" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="327" y="70" width="196" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-23" value="ClienteApiClient" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="110" y="246" width="177" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-24" value="ProductoApiClient" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="342" y="244.5" width="189" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-25" value="PedidoApiClient" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="658" y="246" width="173" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-26" value="ClienteDTO" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="84" y="465" width="140" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-27" value="ProductoDTO" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="287" y="465" width="152" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-28" value="PedidoDTO" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="495" y="465" width="137" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-29" value="PedidoRequest" style="whiteSpace=wrap;strokeWidth=2;" vertex="1" parent="1">
          <mxGeometry x="682" y="465" width="164" height="54" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-51" value="" style="endArrow=none;html=1;rounded=0;exitX=0.75;exitY=0;exitDx=0;exitDy=0;entryX=0;entryY=0.5;entryDx=0;entryDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-23" target="MnK8Lyq_ZDlNypLFmHxD-10">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1160" y="140" as="sourcePoint" />
            <mxPoint x="1210" y="90" as="targetPoint" />
            <Array as="points">
              <mxPoint x="243" y="190" />
              <mxPoint x="1080" y="190" />
              <mxPoint x="1080" y="39" />
            </Array>
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-52" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;HTTP GET /api/clientes/todos&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="1010" y="106.5" width="180" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-53" value="" style="endArrow=none;html=1;rounded=0;exitX=1;exitY=0.5;exitDx=0;exitDy=0;entryX=0;entryY=0.5;entryDx=0;entryDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-24" target="MnK8Lyq_ZDlNypLFmHxD-11">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1000" y="484.5" as="sourcePoint" />
            <mxPoint x="1050" y="434.5" as="targetPoint" />
            <Array as="points">
              <mxPoint x="531" y="273" />
              <mxPoint x="580" y="273" />
              <mxPoint x="580" y="180" />
              <mxPoint x="1000" y="180" />
              <mxPoint x="1000" y="-70" />
              <mxPoint x="1430" y="-70" />
              <mxPoint x="1430" y="39" />
            </Array>
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-56" value="" style="endArrow=none;html=1;rounded=0;entryX=0.5;entryY=1;entryDx=0;entryDy=0;exitX=0.5;exitY=0;exitDx=0;exitDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-15" target="MnK8Lyq_ZDlNypLFmHxD-12">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1090" y="216" as="sourcePoint" />
            <mxPoint x="1140" y="166" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-57" value="" style="endArrow=none;html=1;rounded=0;entryX=0;entryY=0.75;entryDx=0;entryDy=0;exitX=0.5;exitY=0;exitDx=0;exitDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-28" target="MnK8Lyq_ZDlNypLFmHxD-25">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1130" y="550" as="sourcePoint" />
            <mxPoint x="1180" y="500" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-58" value="" style="endArrow=none;html=1;rounded=0;exitX=0.75;exitY=0;exitDx=0;exitDy=0;edgeStyle=orthogonalEdgeStyle;entryX=0;entryY=0.5;entryDx=0;entryDy=0;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-13" target="MnK8Lyq_ZDlNypLFmHxD-15">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1320" y="288" as="sourcePoint" />
            <mxPoint x="1759.7166666666667" y="216" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-59" value="" style="endArrow=none;html=1;rounded=0;exitX=1;exitY=0.5;exitDx=0;exitDy=0;entryX=0;entryY=0.5;entryDx=0;entryDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-25" target="MnK8Lyq_ZDlNypLFmHxD-12">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1070" y="279.5" as="sourcePoint" />
            <mxPoint x="1360" y="260" as="targetPoint" />
            <Array as="points">
              <mxPoint x="970" y="273" />
              <mxPoint x="970" y="-110" />
              <mxPoint x="1700" y="-110" />
              <mxPoint x="1700" y="32" />
            </Array>
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-60" value="" style="endArrow=none;html=1;rounded=0;exitX=1;exitY=0.5;exitDx=0;exitDy=0;entryX=0.5;entryY=0;entryDx=0;entryDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-22" target="MnK8Lyq_ZDlNypLFmHxD-25">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="970" y="67.5" as="sourcePoint" />
            <mxPoint x="1020" y="17.5" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-64" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;HTTP GET /api/productos&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="980" width="160" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-66" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;HTTP POST /api/pedidos&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="910" y="-110" width="160" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-67" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Usa&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="1470" y="228.5" width="50" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-68" value="" style="endArrow=none;html=1;rounded=0;exitX=0.75;exitY=0;exitDx=0;exitDy=0;edgeStyle=orthogonalEdgeStyle;entryX=0.25;entryY=1;entryDx=0;entryDy=0;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-14" target="MnK8Lyq_ZDlNypLFmHxD-15">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="2030" y="439" as="sourcePoint" />
            <mxPoint x="2390" y="340" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-69" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Usa&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="1690" y="290" width="50" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-70" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Usa/Retorna&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="532" y="336.5" width="100" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-73" value="" style="endArrow=none;html=1;rounded=0;entryX=0.75;entryY=1;entryDx=0;entryDy=0;exitX=0.5;exitY=0;exitDx=0;exitDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-29" target="MnK8Lyq_ZDlNypLFmHxD-25">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1000" y="568" as="sourcePoint" />
            <mxPoint x="1094" y="390" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-74" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Usa/Retorna&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="746" y="370.5" width="100" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-75" value="" style="endArrow=none;html=1;rounded=0;entryX=0.25;entryY=1;entryDx=0;entryDy=0;exitX=0.75;exitY=0;exitDx=0;exitDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-27" target="MnK8Lyq_ZDlNypLFmHxD-24">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1030" y="608" as="sourcePoint" />
            <mxPoint x="1124" y="430" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-76" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Retorna&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="369" y="370.5" width="70" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-79" value="" style="endArrow=none;html=1;rounded=0;entryX=0.5;entryY=1;entryDx=0;entryDy=0;exitX=0.5;exitY=0;exitDx=0;exitDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-26" target="MnK8Lyq_ZDlNypLFmHxD-23">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1040" y="538" as="sourcePoint" />
            <mxPoint x="1134" y="360" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-78" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Retorna&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="154" y="370.5" width="70" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-81" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Inyecta y Usa&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="710" y="146.5" width="80" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-83" value="" style="endArrow=none;html=1;rounded=0;exitX=0.5;exitY=1;exitDx=0;exitDy=0;entryX=0.5;entryY=0;entryDx=0;entryDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-22" target="MnK8Lyq_ZDlNypLFmHxD-24">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="950" y="-70" as="sourcePoint" />
            <mxPoint x="1172" y="79" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-84" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Inyecta y Usa&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="396.5" y="166.5" width="80" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-85" value="" style="endArrow=none;html=1;rounded=0;exitX=0;exitY=0.5;exitDx=0;exitDy=0;entryX=0.5;entryY=0;entryDx=0;entryDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-22" target="MnK8Lyq_ZDlNypLFmHxD-23">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="550" y="-90" as="sourcePoint" />
            <mxPoint x="562" y="31" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-86" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Inyecta y Usa&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="158.5" y="146.5" width="80" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-87" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Llama a&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="1789" y="119" width="70" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-90" value="" style="endArrow=none;html=1;rounded=0;entryX=0.5;entryY=1;entryDx=0;entryDy=0;exitX=0.5;exitY=0;exitDx=0;exitDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-14" target="MnK8Lyq_ZDlNypLFmHxD-11">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1520" y="312.5" as="sourcePoint" />
            <mxPoint x="1525" y="156.5" as="targetPoint" />
            <Array as="points">
              <mxPoint x="1582" y="341" />
              <mxPoint x="1582" y="290" />
              <mxPoint x="1650" y="290" />
              <mxPoint x="1650" y="120" />
              <mxPoint x="1548" y="120" />
            </Array>
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-92" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Llama a&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="1630" y="136.5" width="70" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-97" value="" style="endArrow=none;html=1;rounded=0;entryX=0.5;entryY=1;entryDx=0;entryDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-13" target="MnK8Lyq_ZDlNypLFmHxD-10">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1100" y="356" as="sourcePoint" />
            <mxPoint x="1105" y="200" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-98" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Llama a&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="1300" y="189.5" width="70" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-100" value="" style="endArrow=none;html=1;rounded=0;entryX=0.5;entryY=1;entryDx=0;entryDy=0;exitX=0.881;exitY=-0.005;exitDx=0;exitDy=0;edgeStyle=orthogonalEdgeStyle;exitPerimeter=0;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-20" target="MnK8Lyq_ZDlNypLFmHxD-17">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1090" y="516" as="sourcePoint" />
            <mxPoint x="1095" y="360" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-101" value="" style="endArrow=none;html=1;rounded=0;entryX=0.5;entryY=1;entryDx=0;entryDy=0;exitX=0.75;exitY=0;exitDx=0;exitDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-17" target="MnK8Lyq_ZDlNypLFmHxD-14">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1110" y="426" as="sourcePoint" />
            <mxPoint x="1115" y="270" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-102" value="" style="endArrow=none;html=1;rounded=0;entryX=0.5;entryY=1;entryDx=0;entryDy=0;exitX=0.5;exitY=0;exitDx=0;exitDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-18" target="MnK8Lyq_ZDlNypLFmHxD-15">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1110" y="816" as="sourcePoint" />
            <mxPoint x="1115" y="660" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-103" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Usa&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="1809" y="379.5" width="50" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-104" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Usa&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="1600" y="440" width="50" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-106" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Mapea&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="1601.5" y="620" width="70" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-111" value="" style="endArrow=none;html=1;rounded=0;entryX=0.5;entryY=1;entryDx=0;entryDy=0;exitX=0.5;exitY=0;exitDx=0;exitDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-19" target="MnK8Lyq_ZDlNypLFmHxD-16">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1100" y="786" as="sourcePoint" />
            <mxPoint x="1105" y="630" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-112" value="" style="endArrow=none;html=1;rounded=0;entryX=0.5;entryY=1;entryDx=0;entryDy=0;exitX=0.5;exitY=0;exitDx=0;exitDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-16" target="MnK8Lyq_ZDlNypLFmHxD-13">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1060" y="726" as="sourcePoint" />
            <mxPoint x="1065" y="570" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-113" value="" style="endArrow=none;html=1;rounded=0;entryX=0.5;entryY=1;entryDx=0;entryDy=0;exitX=0.5;exitY=0;exitDx=0;exitDy=0;edgeStyle=orthogonalEdgeStyle;" edge="1" parent="1" source="MnK8Lyq_ZDlNypLFmHxD-21" target="MnK8Lyq_ZDlNypLFmHxD-18">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="1090" y="656" as="sourcePoint" />
            <mxPoint x="1095" y="500" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-108" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Usa&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="1310" y="435" width="50" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-110" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Mapea&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="1310" y="620" width="70" height="40" as="geometry" />
        </mxCell>
        <mxCell id="MnK8Lyq_ZDlNypLFmHxD-109" value="&lt;span style=&quot;color: rgb(255, 255, 255); font-family: Helvetica; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: center; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: nowrap; background-color: rgb(18, 18, 18); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;&quot;&gt;Mapea&lt;/span&gt;" style="text;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="1799" y="620" width="70" height="40" as="geometry" />
        </mxCell>
      </root>
    </mxGraphModel>
  </diagram>
</mxfile>

