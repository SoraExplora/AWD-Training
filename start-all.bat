@echo off
setlocal EnableExtensions
cd /d "%~dp0"

REM ---- EDIT THESE FOLDERS (relative to this .bat) ----
set "EUREKA_DIR=backEnd\eureka"
set "GATEWAY_DIR=backEnd\gateway"
set "CANDIDAT_DIR=backEnd\microservices\candidat"
set "CANDIDATURE_DIR=backEnd\microservices\candidature"
set "JOB_DIR=backEnd\microservices\job"
set "MEETING_DIR=backEnd\microservices\meeting"
set "NOTIFICATION_DIR=backEnd\microservices\notification"
::set "FRONTEND_DIR=frontEnd\pidev-26"
REM ----------------------------------------------------

where wt >nul 2>nul
if errorlevel 1 (
  echo [ERROR] wt.exe not found. Install Windows Terminal.
  pause
  exit /b 1
)

REM Validate directories
if not exist "%CD%\%EUREKA_DIR%\" (echo [ERROR] Missing: %CD%\%EUREKA_DIR% & pause & exit /b 1)
if not exist "%CD%\%GATEWAY_DIR%\" (echo [ERROR] Missing: %CD%\%GATEWAY_DIR% & pause & exit /b 1)
if not exist "%CD%\%CANDIDAT_DIR%\" (echo [ERROR] Missing: %CD%\%CANDIDAT_DIR% & pause & exit /b 1)
if not exist "%CD%\%CANDIDATURE_DIR%\" (echo [ERROR] Missing: %CD%\%CANDIDATURE_DIR% & pause & exit /b 1)
if not exist "%CD%\%JOB_DIR%\" (echo [ERROR] Missing: %CD%\%JOB_DIR% & pause & exit /b 1)
if not exist "%CD%\%MEETING_DIR%\" (echo [ERROR] Missing: %CD%\%MEETING_DIR% & pause & exit /b 1)
if not exist "%CD%\%NOTIFICATION_DIR%\" (echo [ERROR] Missing: %CD%\%NOTIFICATION_DIR% & pause & exit /b 1)
::if not exist "%CD%\%FRONTEND_DIR%\" (echo [ERROR] Missing: %CD%\%FRONTEND_DIR% & pause & exit /b 1)

REM Create runner scripts in a stable folder next to this .bat (not TEMP)
set "RUNDIR=%CD%\run-tabs"
if not exist "%RUNDIR%" mkdir "%RUNDIR%"

call :writeRunner     "%RUNDIR%\eureka.cmd"                   "eureka"                    "%CD%\%EUREKA_DIR%"     0
call :writeRunner     "%RUNDIR%\gateway.cmd"                  "gateway"                   "%CD%\%GATEWAY_DIR%"    5
call :writeRunner     "%RUNDIR%\candidat.cmd"                 "candidat"                  "%CD%\%CANDIDAT_DIR%"       7
call :writeRunner     "%RUNDIR%\candidature.cmd"              "candidature"               "%CD%\%CANDIDATURE_DIR%"      7
call :writeRunner     "%RUNDIR%\job.cmd"                      "job"                       "%CD%\%JOB_DIR%"     7
call :writeRunner     "%RUNDIR%\meeting.cmd"                  "meeting"                   "%CD%\%MEETING_DIR%"        7
call :writeRunner     "%RUNDIR%\notification.cmd"             "notification"              "%CD%\%NOTIFICATION_DIR%"        7
::call :writeFrontend   "%RUNDIR%\frontend.cmd"                 "frontend"                  "%CD%\%FRONTEND_DIR%"

REM Start ONE Windows Terminal window with tabs
wt -w 0 ^
  new-tab --title "eureka"                     cmd /k "%RUNDIR%\eureka.cmd" ^
  ; new-tab --title "gateway"                  cmd /k "%RUNDIR%\gateway.cmd" ^
  ; new-tab --title "candidat"                 cmd /k "%RUNDIR%\candidat.cmd" ^
  ; new-tab --title "candidature"              cmd /k "%RUNDIR%\candidature.cmd" ^
  ; new-tab --title "job"                      cmd /k "%RUNDIR%\job.cmd" ^
  ; new-tab --title "meeting"                  cmd /k "%RUNDIR%\meeting.cmd" ^
  ; new-tab --title "notification"             cmd /k "%RUNDIR%\notification.cmd" ^
::  ; new-tab --title "frontend"                 cmd /k "%RUNDIR%\frontend.cmd"

exit /b 0

:writeRunner
set "FILE=%~1"
set "TITLE=%~2"
set "DIR=%~3"
set "DELAY=%~4"

> "%FILE%"  echo @echo off
>>"%FILE%"  echo title %TITLE%
>>"%FILE%"  echo echo [%TITLE%] cd "%DIR%"
>>"%FILE%"  echo pushd "%DIR%" ^|^| ^(echo Failed to cd to "%DIR%" ^& pause ^& exit /b 1^)
if not "%DELAY%"=="0" (
>>"%FILE%"  echo timeout /t %DELAY% /nobreak ^>nul
)
>>"%FILE%"  echo mvn -q spring-boot:run
>>"%FILE%"  echo echo.
>>"%FILE%"  echo echo [%TITLE%] stopped. Press any key to close tab.
>>"%FILE%"  echo popd
>>"%FILE%"  echo pause ^>nul
exit /b 0

:writeFrontend
set "FILE=%~1"
set "TITLE=%~2"
set "DIR=%~3"

> "%FILE%"  echo @echo off
>>"%FILE%"  echo title %TITLE%
>>"%FILE%"  echo echo [%TITLE%] cd "%DIR%"
>>"%FILE%"  echo pushd "%DIR%" ^|^| ^(echo Failed to cd to "%DIR%" ^& pause ^& exit /b 1^)
>>"%FILE%"  echo ng serve
>>"%FILE%"  echo echo.
>>"%FILE%"  echo echo [%TITLE%] stopped. Press any key to close tab.
>>"%FILE%"  echo popd
>>"%FILE%"  echo pause ^>nul
exit /b 0