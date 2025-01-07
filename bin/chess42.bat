@echo off
rem Navigate to the chess project folder
cd ..

rem Compile all Java files into the bin directory
javac -d bin src/main/*.java src/pieces/*.java

rem Run the Main class
java -cp bin main.Main

rem Notify the user
echo Compilation complete. Class files are in the "bin" directory.
pause