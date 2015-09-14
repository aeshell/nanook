# nanook


A web terminal

![Alt nanook](https://raw.githubusercontent.com/aeshell/nanook/master/nanook.png)


#### Your own build (SNAPSHOT):


```
$ git clone https://github.com/wildfly-swarm/wildfly-swarm.git

$ cd wildfly-swarm && mvn clean install -Dmaven.test.skip=true

$ git clone https://github.com/aeshell/nanook.git

$ cd ./gradlew clean wildfly-swarm-package && java -jar ./build/libs/nanook-swarm.jar

```


