echo off
echo --------------------------------------------------
core-java-practice
echo -------------------------------------------------------
cd /d %cd%
git status
git add .
git commit -m "core java practice %date% %time%"
git push
pause