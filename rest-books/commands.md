# Build native package for Linux system

mvn package -Dquarkus.package.type=native \
 -Dquarkus.native.container-build=true \
 -Dquarkus.container-image.build=true
