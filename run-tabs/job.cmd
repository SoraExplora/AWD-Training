@echo off
title job
echo [job] cd "D:\Files\Uni\AWD-Training\backEnd\microservices\job"
pushd "D:\Files\Uni\AWD-Training\backEnd\microservices\job" || (echo Failed to cd to "D:\Files\Uni\AWD-Training\backEnd\microservices\job" & pause & exit /b 1)
timeout /t 7 /nobreak >nul
mvn -q spring-boot:run
echo.
echo [job] stopped. Press any key to close tab.
popd
pause >nul
