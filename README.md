# 🚀 MAVU CLI

Herramienta de línea de comandos para generar servicios **API**, **Demonio** o **Batch** a partir de archivos **OpenAPI YAML**, de manera interactiva y rápida.

---

## 🛠 Requisitos

* **Java 17** o superior
  Verificá con:

```bash
java -version
```

* Windows CMD o PowerShell
* (Opcional) Maven si querés compilar desde código fuente

---

## 📥 Instalación

1. Cloná el repositorio:

```bash
git clone https://github.com/tuusuario/mavucli.git
cd mavucli
```

2. Revisá y configurá el CLI (archivo: `conf/mavu-settings.cmd`):

* Ruta del JAR del generador
* Tipo de servicio por defecto
* Opciones de color y banner

---

## 💻 Uso

Iniciá el CLI con:

```bash
start.cmd
```

Esto abre un entorno preparado para usar `mavu` con las variables de configuración listas.

### Comandos principales

* `mavu help` → Lista todos los comandos disponibles
* `mavu version` → Muestra la versión del CLI
* `mavu create-service` → Genera un nuevo servicio de manera interactiva

---

## 📝 Crear un servicio

Ejecutá:

```bash
mavu create-service
```

El CLI te pedirá:

1. **Nombre del servicio**
   Ejemplo: `product-api`

2. **Descripción del servicio**
   Ejemplo: `Servicio API para gestión de productos`

3. **Tipo de servicio**
   Elegí entre:

   * API
   * Demonio
   * Batch

4. **Archivo OpenAPI YAML**
   Se busca automáticamente un archivo `.yaml` o `.yml` en el directorio actual.
   Si no encuentra ninguno, mostrará un error.

> El código generado se colocará dentro de una carpeta `output` en el mismo directorio donde esté tu archivo YAML.

---

### 📌 Ejemplo de uso

```bash
C:\Desarrollo\mavucli> mavu create-service
################## Crear nuevo servicio ######################
Nombre del servicio: product-api
Descripcion del servicio: Servicio API para gestión de productos
Tipo de servicio:
1) API
2) Demonio
3) Batch
Elige 1, 2 o 3: 1

🧩 Creando servicio "product-api" tipo "api"...
   Descripcion: "Servicio API para gestión de productos"

🧩 Usando archivo: "openapi.yaml"
```

El CLI generará automáticamente los **DTOs, servicios y controladores** definidos en tu OpenAPI dentro de `./output`.

---

## 📂 Estructura de carpetas

```
mavucli/
│
├─ target/mavucli-1.0.0-SNAPSHOT-jar-with-dependencies.jar  # JAR del generador
├─ conf/mavu-settings.cmd                                     # Configuración del CLI
├─ start.cmd                                                  # Inicializa el entorno del CLI
├─ mavu.cmd                                                   # Script principal del CLI
├─ openapi.yaml                                               # Ejemplo de archivo OpenAPI
└─ output/                                                    # Código generado
```

---

## ⚠️ Notas

* Java 17 debe estar disponible en el PATH.
* El archivo OpenAPI debe estar en el mismo directorio donde ejecutás `mavu create-service`.
* La selección del tipo de servicio actualmente se hace por número (1, 2 o 3).
* El código generado se colocará en la carpeta `output` dentro del directorio del YAML.

---

