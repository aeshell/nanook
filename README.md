cloverxell
==========

A web terminal

![Alt cloverxell](https://raw.githubusercontent.com/aeshell/cloverxell/master/cloverxell.png)


![Alt cloverxellm](https://raw.githubusercontent.com/aeshell/cloverxell/master/cloverxellm.png)


Download and run:
-----------------

[cloverxell-0.56.zip](https://github.com/aeshell/cloverxell/releases/download/0.56/cloverxell-0.56.zip)


```
$ unzip cloverxell-0.56.zip 
$ java -jar cloverxell-0.56.jar 
```

Host, port and context:

```shell
$ java -jar cloverxell-0.56.jar -h 192.168.1.1 -p 8080 -c app
```


Your own build (SNAPSHOT):
--------------------------

```
$ git clone https://github.com/aeshell/aesh.git
$ git clone https://github.com/aeshell/aesh-extensions.git
$ git clone https://github.com/EsmerilProgramming/cloverx.git
$ git clone https://github.com/aeshell/cloverxell.git
$ cd aesh && ./gradlew clean install
$ cd ../aesh-extensions && ./gradlew clean install
$ cd ../cloverx && ./gradlew clean install
$ cd ../cloverxell && ./gradlew clean distZip
$ cd build/distributions && unzip cloverxell-0.57-SNAPSHOT.zip
$ cd cloverxell-0.57-SNAPSHOT/bin/
$ ./cloverxell
```

