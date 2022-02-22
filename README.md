## Run mysql database 

The docker image contains a prebuilt banking database with some tables

```
docker run -d --rm -p 3306:3306 thecodecamp/customers-db:latest
```

DB Credentials
- user: root
- password: student