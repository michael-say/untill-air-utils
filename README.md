# unTill AIR Utils
## How to build

```shell
mvn clean compile assembly:single
```
## How to use 
### Fill location with data
```shell
java -cp ./target/airutils.jar com.untillairutils.LocationLoader /path/to/chromedriver https://alpha2.dev.untill.ru user@email.com 123456 "My Location"
```
Specify correct path to chromedriver, URL, login and password, location name.




