# Bootstrap Number Service

#!/usr/bin/env bash
mvn -U io.quarkus:quarkus-maven-plugin:create \
 -DprojectGroupId=com.jovisco.quarkus.microservices \
 -DprojectArtifactId=rest-number \
 -DclassName="com.jovisco.quarkus.microservices.numbers.NumberResource" \
 -Dpath="/api/numbers" \
 -Dextensions="resteasy-jsonb, smallrye-openapi"

# Bootstrap Books Service

#!/usr/bin/env bash
mvn -U io.quarkus:quarkus-maven-plugin:create \
 -DprojectGroupId=com.jovisco.quarkus.microservices \
 -DprojectArtifactId=rest-book \
 -DclassName="com.jovisco.quarkus.microservices.books.BookResource" \
 -Dpath="/api/books" \
 -Dextensions="resteasy-jsonb, smallrye-openapi"

# Examine API in Swagger UI

http://localhost:8071/q/swagger-ui

# Navigate to Qurkus Config Editor

http://localhost:8071/q/dev

# Build native package for Linux system

mvn package -Dquarkus.native.enabled=true \
 -Dquarkus.native.container-build=true
