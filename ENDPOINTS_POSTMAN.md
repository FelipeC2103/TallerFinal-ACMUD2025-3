# 📋 Guía de Endpoints para Postman - Sistema de Gestión Comercial

**Base URL:** `http://localhost:8080`

---

## 🏢 DEPARTAMENTOS (`/api/departamentos`)

### ✅ Crear Departamento
```
POST http://localhost:8080/api/departamentos
Content-Type: application/json

{
  "nombre": "Cundinamarca"
}
```

### 📋 Listar todos los Departamentos
```
GET http://localhost:8080/api/departamentos
```

### 🔍 Buscar Departamento por ID
```
GET http://localhost:8080/api/departamentos/1
```

### ✏️ Actualizar Departamento
```
PUT http://localhost:8080/api/departamentos/1
Content-Type: application/json

{
  "nombre": "Cundinamarca Actualizado"
}
```

### ❌ Eliminar Departamento
```
DELETE http://localhost:8080/api/departamentos/1
```

---

## 🏙️ CIUDADES (`/api/ciudades`)

### ✅ Crear Ciudad
```
POST http://localhost:8080/api/ciudades
Content-Type: application/json

{
  "nombre": "Bogotá",
  "departamento": {
    "idDepartamento": 1
  }
}
```

### 📋 Listar todas las Ciudades
```
GET http://localhost:8080/api/ciudades
```

### 🔍 Buscar Ciudad por ID
```
GET http://localhost:8080/api/ciudades/1
```

### 🔍 Listar Ciudades por Departamento
```
GET http://localhost:8080/api/ciudades/departamento/1
```

### ✏️ Actualizar Ciudad
```
PUT http://localhost:8080/api/ciudades/1
Content-Type: application/json

{
  "nombre": "Bogotá D.C.",
  "departamento": {
    "idDepartamento": 1
  }
}
```

### ❌ Eliminar Ciudad
```
DELETE http://localhost:8080/api/ciudades/1
```

---

## 🎭 ROLES DE USUARIO (`/api/rol-usuarios`)

### ✅ Crear Rol (si tienes el controlador)
```
POST http://localhost:8080/api/roles
Content-Type: application/json

{
  "rol": "ADMIN"
}
```

---

## 👥 USUARIOS (`/api/usuarios`)

### ✅ Crear Usuario
```
POST http://localhost:8080/api/usuarios
Content-Type: application/json

{
  "nombre": "Juan",
  "apellido": "Pérez",
  "usSername": "jperez",
  "password": "password123",
  "email": "juan.perez@email.com",
  "telefono": "3001234567",
  "rolUsuario": {
    "id": 1
  },
  "ciudad": {
    "id": 1
  }
}
```

### 📋 Listar todos los Usuarios
```
GET http://localhost:8080/api/usuarios
```

### 🔍 Buscar Usuario por ID
```
GET http://localhost:8080/api/usuarios/1
```

### ✏️ Actualizar Usuario
```
PUT http://localhost:8080/api/usuarios/1
Content-Type: application/json

{
  "nombre": "Juan Carlos",
  "apellido": "Pérez García",
  "email": "juanc.perez@email.com",
  "telefono": "3009876543"
}
```

### ❌ Eliminar Usuario
```
DELETE http://localhost:8080/api/usuarios/1
```

### 🔎 CONSULTAS COMPLEJAS - USUARIOS

#### 1️⃣ Buscar usuarios por apellido
```
GET http://localhost:8080/api/usuarios/apellido/Pérez
```

#### 2️⃣ Listar usuarios de una ciudad específica
```
GET http://localhost:8080/api/usuarios/ciudad/1
```

#### 3️⃣ Listar usuarios por departamento
```
GET http://localhost:8080/api/usuarios/departamento/1
```

#### 4️⃣ Buscar usuarios cuyo nombre contenga texto
```
GET http://localhost:8080/api/usuarios/nombre/buscar?texto=Juan
```

---

## 📦 CATEGORÍAS (`/api/categorias`)

### ✅ Crear Categoría
```
POST http://localhost:8080/api/categorias
Content-Type: application/json

{
  "nombre": "Electrónica"
}
```

### 📋 Listar todas las Categorías
```
GET http://localhost:8080/api/categorias
```

### 🔍 Buscar Categoría por ID
```
GET http://localhost:8080/api/categorias/1
```

### ✏️ Actualizar Categoría
```
PUT http://localhost:8080/api/categorias/1
Content-Type: application/json

{
  "nombre": "Electrónica y Tecnología"
}
```

### ❌ Eliminar Categoría
```
DELETE http://localhost:8080/api/categorias/1
```

---

## 🛍️ PRODUCTOS (`/api/productos`)

### ✅ Crear Producto
```
POST http://localhost:8080/api/productos
Content-Type: application/json

{
  "nombre": "Laptop HP",
  "descripcion": "Laptop HP 15.6 pulgadas, 8GB RAM, 256GB SSD",
  "precio": 2500000
}
```

### 📋 Listar todos los Productos
```
GET http://localhost:8080/api/productos
```

### 🔍 Buscar Producto por ID
```
GET http://localhost:8080/api/productos/1
```

### ✏️ Actualizar Producto
```
PUT http://localhost:8080/api/productos/1
Content-Type: application/json

{
  "nombre": "Laptop HP Pavilion",
  "descripcion": "Laptop HP Pavilion 15.6 pulgadas, 16GB RAM, 512GB SSD",
  "precio": 3200000
}
```

### ❌ Eliminar Producto
```
DELETE http://localhost:8080/api/productos/1
```

### 🔎 CONSULTAS COMPLEJAS - PRODUCTOS

#### 5️⃣ Listar productos por categoría
```
GET http://localhost:8080/api/productos/categoria/1
```

#### 6️⃣ Buscar productos por rango de precio
```
GET http://localhost:8080/api/productos/precio/rango?min=1000000&max=3000000
```

#### 7️⃣ Ordenar productos por precio (ascendente)
```
GET http://localhost:8080/api/productos/precio/ordenar?orden=asc
```

#### 7️⃣ Ordenar productos por precio (descendente)
```
GET http://localhost:8080/api/productos/precio/ordenar?orden=desc
```

#### 8️⃣ Listar productos creados después de una fecha
```
GET http://localhost:8080/api/productos/fecha/despues?fecha=2024-01-01T00:00:00
```

---

## 🏭 ALMACENES (`/api/almacenes`)

### ✅ Crear Almacén
```
POST http://localhost:8080/api/almacenes
Content-Type: application/json

{
  "nombre": "Almacén Central",
  "ciudad": {
    "id": 1
  }
}
```

### 📋 Listar todos los Almacenes
```
GET http://localhost:8080/api/almacenes
```

### 🔍 Buscar Almacén por ID
```
GET http://localhost:8080/api/almacenes/1
```

### ✏️ Actualizar Almacén
```
PUT http://localhost:8080/api/almacenes/1
Content-Type: application/json

{
  "nombre": "Almacén Central Norte",
  "ciudad": {
    "id": 1
  }
}
```

### ❌ Eliminar Almacén
```
DELETE http://localhost:8080/api/almacenes/1
```

### 🔎 CONSULTAS COMPLEJAS - ALMACENES

#### 🔟 Listar almacenes de una ciudad
```
GET http://localhost:8080/api/almacenes/ciudad/1
```

---

## 📊 ALMACÉN-PRODUCTOS (`/api/almacen-productos`)

### ✅ Asignar Producto a Almacén
```
POST http://localhost:8080/api/almacen-productos
Content-Type: application/json

{
  "almacen": {
    "idAlmacen": 1
  },
  "producto": {
    "idProducto": 1
  },
  "stock": 100,
  "direccion": "Estante A-12"
}
```

### 📋 Listar todas las Asignaciones
```
GET http://localhost:8080/api/almacen-productos
```

### 🔍 Buscar Asignación por ID
```
GET http://localhost:8080/api/almacen-productos/1
```

### ✏️ Actualizar Stock
```
PUT http://localhost:8080/api/almacen-productos/1
Content-Type: application/json

{
  "almacen": {
    "idAlmacen": 1
  },
  "producto": {
    "idProducto": 1
  },
  "stock": 150,
  "direccion": "Estante A-12"
}
```

### ❌ Eliminar Asignación
```
DELETE http://localhost:8080/api/almacen-productos/1
```

### 🔎 CONSULTAS COMPLEJAS - ALMACÉN-PRODUCTOS

#### 9️⃣ Listar todos los productos de un almacén
```
GET http://localhost:8080/api/almacen-productos/almacen/1
```

---

## 💰 VENTAS (`/api/ventas`)

### ✅ Crear Venta
```
POST http://localhost:8080/api/ventas
Content-Type: application/json

{
  "cliente": {
    "id": 1
  },
  "total": 5000000
}
```

### 📋 Listar todas las Ventas
```
GET http://localhost:8080/api/ventas
```

### 🔍 Buscar Venta por ID
```
GET http://localhost:8080/api/ventas/1
```

### ✏️ Actualizar Venta
```
PUT http://localhost:8080/api/ventas/1
Content-Type: application/json

{
  "cliente": {
    "id": 1
  },
  "total": 5500000
}
```

### ❌ Eliminar Venta
```
DELETE http://localhost:8080/api/ventas/1
```

### 🔎 CONSULTAS COMPLEJAS - VENTAS

#### 1️⃣1️⃣ Listar ventas por usuario cliente
```
GET http://localhost:8080/api/ventas/cliente/1
```

#### 1️⃣2️⃣ Consultar total vendido por fecha
```
GET http://localhost:8080/api/ventas/total/fecha?fechaInicio=2024-11-01T00:00:00&fechaFin=2024-11-30T23:59:59
```

#### 1️⃣2️⃣ Listar ventas por rango de fecha
```
GET http://localhost:8080/api/ventas/fecha/rango?fechaInicio=2024-11-01T00:00:00&fechaFin=2024-11-30T23:59:59
```

#### 1️⃣3️⃣ Buscar ventas con monto mayor a X valor
```
GET http://localhost:8080/api/ventas/monto/mayor?monto=3000000
```

---

## 🚀 FLUJO DE PRUEBA RECOMENDADO

### Paso 1: Crear datos base
1. Crear Departamento
2. Crear Ciudad (usando el ID del departamento)
3. Crear Rol de Usuario
4. Crear Usuario (usando IDs de rol y ciudad)
5. Crear Categoría
6. Crear Producto

### Paso 2: Crear relaciones
7. Crear Almacén (usando ID de ciudad)
8. Asignar Producto a Almacén (AlmacenProducto)
9. Crear Categoría-Producto (si tienes el endpoint)

### Paso 3: Crear transacciones
10. Crear Venta (usando ID de usuario como cliente)

### Paso 4: Probar consultas complejas
11. Ejecutar las 13 consultas complejas según los ejemplos arriba

---

## 📝 NOTAS IMPORTANTES

1. **Fechas en formato ISO 8601**: `2024-11-24T10:30:00`
2. **BigInteger para montos**: Los valores de `total` en ventas y `stock` son números enteros
3. **Relaciones**: Siempre enviar el objeto con su ID correspondiente
4. **IDs auto-generados**: Los IDs se generan automáticamente, no los incluyas en POST
5. **Campos obligatorios**: 
   - Usuario: `usSername` y `email` son únicos
   - Verifica los `@Column(nullable = false)` en las entidades

---

## 🔧 TIPS PARA POSTMAN

1. **Crear una Colección** llamada "Sistema Gestión Comercial"
2. **Crear un Environment** con la variable:
   - `baseUrl` = `http://localhost:8080`
3. **Usar `{{baseUrl}}` en las URLs** para cambiar fácilmente el servidor
4. **Guardar respuestas exitosas** para usar los IDs en requests posteriores
5. **Usar Tests en Postman** para extraer IDs automáticamente:
   ```javascript
   pm.test("Status code is 201", function () {
       pm.response.to.have.status(201);
       var jsonData = pm.response.json();
       pm.environment.set("lastCreatedId", jsonData.id);
   });
   ```

---

## ✅ CHECKLIST DE PRUEBAS (14 Consultas Obligatorias)

- [ ] 1. Buscar usuarios por apellido
- [ ] 2. Listar usuarios de una ciudad específica
- [ ] 3. Listar usuarios por departamento
- [ ] 4. Buscar usuarios cuyo nombre contenga X texto
- [ ] 5. Listar productos por categoría
- [ ] 6. Buscar productos por rango de precio
- [ ] 7. Ordenar productos por precio asc/desc
- [ ] 8. Listar productos creados después de una fecha
- [ ] 9. Listar todos los productos de un almacén
- [ ] 10. Listar almacenes de una ciudad
- [ ] 11. Listar ventas por usuario cliente
- [ ] 12. Consultar total vendido por fecha
- [ ] 13. Buscar ventas con monto mayor a X valor
- [ ] 14. Listar los productos más vendidos (PENDIENTE - requiere VentaDetalle)

---

**¡Listo para probar! 🎉**

