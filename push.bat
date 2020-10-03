@echo off
cd /d %cd%
echo -----------------------------------------------
echo %cd%
echo -----------------------------------------------
git status
git add .
git commit -m "%date% %time%"
git push
pause