# Conversor de Moneda

Este proyecto es un **Conversor de Moneda** en Java, el cual permite realizar conversiones de diferentes monedas utilizando la API de [Exchange Rate API](https://www.exchangerate-api.com/docs/pair-conversion-requests).

## Funcionalidades

El conversor permite realizar conversiones entre las siguientes monedas:

1. **Dólar a Peso argentino**
2. **Peso argentino a Dólar**
3. **Dólar a Real brasileño**
4. **Real brasileño a Dólar**
5. **Dólar a Peso colombiano**
6. **Peso colombiano a Dólar**

También incluye la opción de **salir** del programa.

## Requisitos

- **Java 8 o superior**
- **Conexión a Internet** (para hacer uso de la API de Exchange Rate)
- **Una cuenta en [ExchangeRate API](https://www.exchangerate-api.com/)** para obtener la clave API (gratis para solicitudes básicas).

## Configuración de la API Key

Para que el código funcione correctamente, es necesario generar una **API Key** desde la página de [ExchangeRate API](https://www.exchangerate-api.com/).

Una vez tengas tu clave API, sigue estos pasos:

1. Abre el archivo `ConsumoApi.java` en el proyecto.
2. Busca la constante `API_KEY`.
3. Pega tu clave API en esta constante, reemplazando el valor que esté allí.

