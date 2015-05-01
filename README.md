nanook
======

A web terminal

![Alt cloverxell](https://raw.githubusercontent.com/aeshell/cloverxell/master/cloverxell.png)


![Alt cloverxellm](https://raw.githubusercontent.com/aeshell/cloverxell/master/cloverxellm.png)


Download and run:
-----------------

[cloverxell-0.57.zip](https://github.com/aeshell/cloverxell/releases/download/0.57/cloverxell-0.57.zip)


```shell
$ unzip cloverxell-0.57.zip
$ cd cloverxell-0.57/bin
$ ./cloverxell
```

Host, port and context:

```shell
$ ./cloverxell -h 192.168.1.1 -p 8083 -c app
```


Your own build:
---------------

```shell
$ git clone https://github.com/aeshell/cloverxell.git
$ cd cloverxell
$ ./gradlew clean distZip
$ cd build/distributions && unzip cloverxell-0.57.zip
$ cd cloverxell-0.57/bin/
$ ./cloverxell
```

