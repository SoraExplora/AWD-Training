@echo off
title meeting
echo [meeting] cd "D:\Files\Uni\AWD-Training\backEnd\microservices\meeting"
pushd "D:\Files\Uni\AWD-Training\backEnd\microservices\meeting" || (echo Failed to cd to "D:\Files\Uni\AWD-Training\backEnd\microservices\meeting" & pause & exit /b 1)
timeout /t 7 /nobreak >nul
mvn -q spring-boot:run
echo.
echo [meeting] stopped. Press any key to close tab.
popd
pause >nul
