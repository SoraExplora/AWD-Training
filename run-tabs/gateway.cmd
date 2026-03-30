@echo off
title gateway
echo [gateway] cd "D:\Files\Uni\AWD-Training\backEnd\gateway"
pushd "D:\Files\Uni\AWD-Training\backEnd\gateway" || (echo Failed to cd to "D:\Files\Uni\AWD-Training\backEnd\gateway" & pause & exit /b 1)
timeout /t 5 /nobreak >nul
mvn -q spring-boot:run
echo.
echo [gateway] stopped. Press any key to close tab.
popd
pause >nul
