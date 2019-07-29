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

# Authorization
-
# API Example
## GET
##### All Authors
```ruby
curl -X GET \
  http://localhost:8090/author \
  -H 'Cache-Control: no-cache' \
  -H 'Postman-Token: 6cc099cc-2b8a-4602-ad56-100a8e6628bc'
```
##### Reward
```ruby
curl -X GET \
  http://localhost:8090/author/reward/1 \
  -H 'Cache-Control: no-cache' \
  -H 'Postman-Token: d750471d-d0c2-4a63-a2b2-634284421f18'
```
_**`Library.postman_collection.json`**_` locate in the root of repository.`
`Import it in Postman to see requests samples.`
