# Guía de Reglas y Arquitectura del Proyecto (Delta / AgriPro)

Este documento define las restricciones técnicas, de arquitectura y de negocio obligatorias que la IA (**Delta**) debe auditar en cada Pull Request. Cualquier incumplimiento de estas normas debe ser reportado.

---

## 1. Arquitectura y Modelo de Capas
* **Modelo en Capas Estricto:** El desarrollo debe separar limpiamente la Capa de Datos (entidades, archivos de persistencia), la Capa de Lógica (validaciones, métodos de control, operaciones CRUD) y la Capa de Presentación (interfaces gráficas en Java Swing tipo web).
* **Restricción de Persistencia:** Los datos deben almacenarse exclusivamente mediante archivos  JSON según los lineamientos técnicos del proyecto. Queda prohibido el uso de bases de datos externas o librerías no autorizadas, solo Jcalendar esta permitido.
* **Estructuras de Datos:** Utilizar `ArrayList` y objetos propios para la manipulación en memoria. Elementos complejos serán sancionados.
---

## 2. Validación de Módulos y Reglas de Negocio

* **Control de Estados:** Cada registro (*Usuarios, Cultivos, Lotes, Agroquímicos, Paquetes de Aplicación y Aplicaciones*) debe incorporar obligatoriamente una propiedad de estado (`Activo` / `Inactivo`). Si un registro está inactivo, no puede ser utilizado ni permitir accesos (por ejemplo, el inicio de sesión de un usuario inactivo debe bloquearse aunque la contraseña sea correcta).
* **Control de Accesos (Login):** 
  * Los usuarios con rol **Administrador** tienen acceso a todas las funciones del sistema.
  * Los usuarios con rol **Normal** (digitadores) no pueden acceder al módulo de usuarios ni a la creación de lotes.
* **Gestión de Lotes:** Debe incluir un selector (`JComboBox`) para las unidades de medida (como metros cuadrados o hectáreas), aplicando los cálculos de conversión necesarios de forma automática.
* **Catálogo de Agroquímicos:** Los tipos de agroquímicos (*Herbicidas, Fungicidas, Insecticidas, Bactericidas y Fertilizante Foliar*) deben controlarse mediante componentes desplegables utilizando `getSelectedItem()` o en datos Caso de decisión del desarrollador seria `getSelectedIndex`, aclarando que Numero de USA para identificar para evitar confusiones en los tipos de datos.
* **Estructura Maestro-Detalle (Aplicaciones):** La creación de aplicaciones debe componerse de su respectivo identificador, nombre, motivo y un listado detallado de los agroquímicos asociados.
* **Reportes y Cálculos:** 
  * El calendario de aplicaciones debe permitir filtrar por año mostrando fecha, lote, cultivo y aplicación.
  * El reporte de agroquímicos consumibles por rango de fechas debe agrupar y sumar correctamente las cantidades totales por cultivo y agroquímico, evitando mostrar filas duplicadas individuales.

---

## 3. Normas de Código Limpio y Buenas Prácticas
* **Encapsulamiento:** Los atributos de las clases deben ser privados (`private`), exponiendo únicamente constructores, *getters* y *setters*.
* **Nomenclatura:** Usar nombres claros y descriptivos en español para métodos, clases y variables de negocio.
* **Supuestos:** No se debe de suponer que no SE incluyo algo, solamente SE le Debe de recordar en una seccion aparte.
