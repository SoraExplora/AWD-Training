@echo off
title candidature
echo [candidature] cd "D:\Files\Uni\AWD-Training\backEnd\microservices\candidature"
pushd "D:\Files\Uni\AWD-Training\backEnd\microservices\candidature" || (echo Failed to cd to "D:\Files\Uni\AWD-Training\backEnd\microservices\candidature" & pause & exit /b 1)
timeout /t 7 /nobreak >nul
mvn -q spring-boot:run
echo.
echo [candidature] stopped. Press any key to close tab.
popd
pause >nul
