@echo off
title eureka
echo [eureka] cd "D:\Files\Uni\AWD-Training\backEnd\eureka"
pushd "D:\Files\Uni\AWD-Training\backEnd\eureka" || (echo Failed to cd to "D:\Files\Uni\AWD-Training\backEnd\eureka" & pause & exit /b 1)
mvn -q spring-boot:run
echo.
echo [eureka] stopped. Press any key to close tab.
popd
pause >nul
