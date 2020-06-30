# haecksOnTheBeach2020

##Running the application
./gradlew build

java -jar build/libs/haecksOnTheBeach2020-0.0.1-SNAPSHOT.jar

In the browser, open 

http://localhost:8080/stock?symbol=AAPL

Please note:
Due to rate limiting by the API, NullPointerExceptions can occur when too many requests are made after each other. If this happens,
wait a bit before requesting again.