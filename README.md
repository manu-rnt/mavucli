# mavucli
Herramienta de línea de comandos interactiva para crear rápidamente servicios API, demonio y batch a partir de especificaciones OpenAPI.

# MAVU CLI

Herramienta de línea de comandos para generar servicios **API**, **demonio** o **batch** a partir de archivos **OpenAPI YAML** de manera interactiva.

---

## 🛠 Instalación

1. Clona el repositorio:

```bash
git clone https://github.com/tuusuario/mavucli.git
cd mavucli
Asegúrate de tener Java 8 o superior instalado:

bash
Copiar código
java -version
Configura el CLI si es necesario (opcional):

bash
Copiar código
# Archivo de configuración por defecto: conf/mavu-settings.cmd
# Aquí puedes ajustar:
# - Ruta del JAR
# - Tipo de servicio por defecto
🚀 Uso del CLI
Abre tu terminal (CMD o PowerShell) y ejecuta:

bash
Copiar código
start.cmd
Esto abrirá un entorno preparado para usar el CLI, con las variables configuradas.

Comandos principales
mavu help
Muestra la lista de comandos disponibles.

mavu version
Muestra la versión del CLI.

mavu create-service
Genera un nuevo servicio de forma interactiva.

📝 Crear un servicio
Ejecuta:

bash
Copiar código
mavu create-service
El CLI te pedirá:

Nombre del servicio:
Escribe un nombre para tu servicio, por ejemplo product-api.

Descripción del servicio:
Escribe una breve descripción, por ejemplo Servicio API para gestión de productos.

Tipo de servicio:
Elige entre:

API

Demonio

Batch

Archivo OpenAPI YAML:
El CLI buscará automáticamente un archivo .yaml o .yml en el directorio actual.
Si no encuentra ninguno, mostrará un error.

⚡ Ejemplo de uso
bash
Copiar código
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
El CLI generará los DTOs, servicios y controladores definidos en tu archivo OpenAPI.

📂 Estructura de carpetas
bash
Copiar código
mavucli/
│
├─ target/mavucli-1.0.0-SNAPSHOT-jar-with-dependencies.jar  # JAR del generador
├─ conf/mavu-settings.cmd                                     # Configuración del CLI
├─ start.cmd                                                  # Inicializa el entorno del CLI
├─ mavu.cmd                                                   # Script principal del CLI
└─ openapi.yaml                                               # Ejemplo de archivo OpenAPI
⚠️ Notas
El CLI requiere Java instalado y disponible en el PATH.

El archivo OpenAPI debe estar en el mismo directorio donde ejecutas mavu create-service.

Actualmente, la selección del tipo de servicio se realiza por número (1, 2 o 3).
Futuras versiones podrían implementar selección interactiva con flechas.
