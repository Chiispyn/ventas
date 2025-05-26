
## base de datos nombre: db_venta
Crear una Venta:

## Método: POST
## URL: http://localhost:8084/api/ventas
## Cuerpo (Raw - JSON):


{
  "fechaVenta": "2025-05-15T15:25:00-04:00",
  "totalVenta": 125.50,
  "idPedido": 1,
  "idCliente": 10,
  "idUsuario": 5,
  "desc": 0.05,
  "metodoEnvio": "despachoADomicilio",
  "productosVenta": [
    {
      "idProducto": 101,
      "cantidad": 2,
      "precioUnitario": 25.00,
      "subtotal": 50.00
    },
    {
      "idProducto": 102,
      "cantidad": 1,
      "precioUnitario": 75.50,
      "subtotal": 75.50
    }
  ]
}
## Crear un ProductoVenta (para la venta con ID 1):

## Método: POST
## URL: http://localhost:8084/api/productos-venta
## Cuerpo (Raw - JSON):


{
  "venta": {"idVenta": 1},
  "idProducto": 201,
  "cantidad": 3,
  "precioUnitario": 10.00,
  "subtotal": 30.00
}
## Crear una Factura:

## Método: POST
## URL: http://localhost:8084/api/facturas
## Cuerpo (Raw - JSON):


{
  "fechaEmisio": "2025-05-15T15:30:00-04:00",
  "totalFactura": 125.50,
  "enviarCorreo": "cliente10@example.com"
}

## Obtener todas las Ventas:

## Método: GET
## URL: http://localhost:8084/api/ventas
## Acción: Envía esta petición para ver la lista de todas las ventas.


## Método: GET
## URL: http://localhost:8084/api/ventas/1



## Método: GET
## URL: http://localhost:8084/api/productos-venta



## Método: GET
## URL: http://localhost:8084/api/productos-venta/1



## Método: GET
## URL: http://localhost:8084/api/facturas



## Método: GET
## URL: http://localhost:8084/api/facturas/1

## Actualizar una Venta (ejemplo, la venta con ID 1):

## Método: PUT
## URL: http://localhost:8084/api/ventas/1
## Cuerpo (Raw - JSON):


{
  "totalVenta": 150.00,
  "metodoEnvio": "retiroLocal"}

## Actualizar un ProductoVenta (ejemplo, el producto con ID 1):

## Método: PUT
## URL: http://localhost:8084/api/productos-venta/1
## Cuerpo (Raw - JSON):


{
  "cantidad": 5,
  "subtotal": 50.00
}

## Actualizar una Factura (ejemplo, la factura con código 1):

## Método: PUT
## URL: http://localhost:8084/api/facturas/1
## Cuerpo (Raw - JSON):

{
  "totalFactura": 130.00,
  "enviarCorreo": "updated@example.com"
}

## Eliminar una Venta (ejemplo, la venta con ID 1):

## Método: DELETE
## URL: http://localhost:8084/api/ventas/1