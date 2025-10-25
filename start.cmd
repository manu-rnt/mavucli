@echo off
:: ───────────────────────────────────────────────
::  MV CLI  |  Local Environment Launcher
:: ───────────────────────────────────────────────

title MV CLI
color 0A
cls

:: Big ASCII banner (safe for Windows CMD)
echo.
echo   __  __     __     ____ _     ___ 
echo  ^|  \/  ^| _ _\ \   / / _^| ^|   ^|_ _^| 
echo  ^| ^|\/^| ^|/ _` \ \ / / _^|^| ^|    ^| ^| 
echo  ^| ^|  ^| ^| (_^| ^|\ V /  _^| ^|___ ^| ^| 
echo  ^|_^|  ^|_^|\__,_^| \_/  ^|_^| ^|____^|___^|
echo.
echo                 M   V      C   L   I
echo.
echo  +--------------------------------------------------------------------+
echo  ^|                                                                    ^|
echo  ^|   Empowering your service generation flow                     ^|
echo  ^|                                                                    ^|
echo  +--------------------------------------------------------------------+
echo.

:: Mascot Robot
echo                     [o_o]
echo                     ^<)   )╯   "Let's build something cool!"
echo                     /    \
echo.

timeout /t 1 >nul
echo  Initializing local environment...
timeout /t 1 >nul
echo.

:: Set up local PATH (project-local only)
set MV_HOME=%~dp0
set PATH=%~dp0;%PATH%

:: Ensure CMD prioritizes .CMD
set PATHEXT=.CMD;.BAT;.EXE;.COM

echo  [OK] Environment ready!
echo.
echo  You can now run commands like:
echo     mavu help
echo     mavu create-service
echo.
echo  Type "exit" to close this shell.
echo.

:: Open interactive CMD
:: Abrir PowerShell dentro de la misma ventana
powershell -NoExit -Command "cd '%~dp0'; Write-Host 'Bienvenido a MV CLI';"
