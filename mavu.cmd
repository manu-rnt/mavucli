@echo off
setlocal enabledelayedexpansion

:: Cargar configuración
set CONF_FILE=%~dp0\conf\mavu-settings.cmd
if exist "%CONF_FILE%" (
    call "%CONF_FILE%"
) else (
    echo ⚠️  No se encontró el archivo de configuración: "%CONF_FILE%"
    exit /b 1
)

:: Full JAR path
set MAVU_JAR_PATH=%~dp0\target\mavucli-1.0.0-SNAPSHOT-jar-with-dependencies.jar

:: Comandos
if "%~1"=="" (
    echo MAVU CLI - Code Generator
    echo Usage:
    echo   mavu [command]
    echo.
    echo Available commands:
    echo   create-service
    echo   help
    echo   version
    exit /b 0
)

set COMMAND=%1
shift

:: ──────────────────────────────
:: Crear servicio interactivo
:: ──────────────────────────────
if /I "%COMMAND%"=="create-service" (
    call :CREATE_SERVICE
    exit /b 0
)

:: ──────────────────────────────
:: Otros comandos
:: ──────────────────────────────
if /I "%COMMAND%"=="help" (
    echo Available commands:
    echo   create-service
    echo   help
    echo   version
    exit /b 0
)

if /I "%COMMAND%"=="version" (
    echo MAVU CLI v1.0.0
    exit /b 0
)

echo Unknown command: %COMMAND%
exit /b 1

:: ──────────────────────────────
:: Función: Create Service
:: ──────────────────────────────
:CREATE_SERVICE
setlocal

echo.
echo ################## Crear nuevo servicio ######################

:: Nombre del servicio
set /p SERVICE_NAME=Nombre del servicio:

:: Descripción
set /p SERVICE_DESC=Descripcion del servicio:

:: Tipo de servicio usando CHOICE
echo.
echo Tipo de servicio:
echo   1) API
echo   2) Demonio
echo   3) Batch
choice /C 123 /N /M "Selecciona una opcion (1,2,3): "
if errorlevel 3 set SERVICE_TYPE=batch
if errorlevel 2 set SERVICE_TYPE=daemon
if errorlevel 1 set SERVICE_TYPE=api

echo.
echo 🧩 Creando servicio "%SERVICE_NAME%" tipo "%SERVICE_TYPE%"...
echo    Descripcion: "%SERVICE_DESC%"
echo.

:: Buscar YAML en directorio actual
set "YAML_FILE="
for %%f in (*.yaml *.yml) do (
    set "YAML_FILE=%%~f"
    goto found_yaml
)
:found_yaml
if not defined YAML_FILE (
    echo ❌ No se encontró ningún archivo YAML/YML en "%CD%".
    endlocal
    exit /b 1
)

echo 🧩 Usando archivo: "%YAML_FILE%"
java -jar "%MAVU_JAR_PATH%" -f "%YAML_FILE%"

endlocal
exit /b 0
