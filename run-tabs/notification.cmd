@echo off
title notification
echo [notification] cd "D:\Files\Uni\AWD-Training\backEnd\microservices\notification"
pushd "D:\Files\Uni\AWD-Training\backEnd\microservices\notification" || (echo Failed to cd to "D:\Files\Uni\AWD-Training\backEnd\microservices\notification" & pause & exit /b 1)
timeout /t 7 /nobreak >nul
mvn -q spring-boot:run
echo.
echo [notification] stopped. Press any key to close tab.
popd
pause >nul
