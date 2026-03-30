@echo off
title candidat
echo [candidat] cd "D:\Files\Uni\AWD-Training\backEnd\microservices\candidat"
pushd "D:\Files\Uni\AWD-Training\backEnd\microservices\candidat" || (echo Failed to cd to "D:\Files\Uni\AWD-Training\backEnd\microservices\candidat" & pause & exit /b 1)
timeout /t 7 /nobreak >nul
mvn -q spring-boot:run
echo.
echo [candidat] stopped. Press any key to close tab.
popd
pause >nul
