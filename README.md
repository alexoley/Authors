## To run a project you need to execute simple script

in Linux:
```
export MySQL_URL=<host/ip>:<db_port>/<db_name>
export MySQL_USER=<db_user>
export MySQL_PASSWORD=<db_password>
./gradlew bootRun
```
in Windows:
```
set MySQL_URL=<host/ip>:<db_port>/<db_name>
set MySQL_USER=<db_user>
set MySQL_PASSWORD=<db_password>
gradlew.bat bootRun
```
#### To run only tests:
in Linux:
```
./gradlew test
```
in Windows:
```
gradlew.bat test
```
#### To run only build:
in Linux:
```
./gradlew test
```
in Windows:
```
gradlew.bat test
```