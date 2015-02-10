# Dockerize Your Application

This is an example how to simply dockerize your application with minimal effort.

## Build

```sh
gradle distribution
```
Distribution task depends on ```dockerize``` task and ```fatjar``` task.

## Make a docker image
Directory ```${buildDir}/distribution``` contains all you need to create docker image.
```sh
cd build/distribution
docker build -t jersey/hello .
```

## Run docker image

```sh
docker run -p 4001:4004 -d jersey/hello
```

## Test
```sh
curl localhost:4001/base/helloworld
```
...and here we go
```sh
Hello World!
```
