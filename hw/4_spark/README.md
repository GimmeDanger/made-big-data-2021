# Домашнее задание №4: Tf-Idf с использованием Spark DataFrame API

## По данным [Trip advisor hotel reviews](https://www.kaggle.com/andrewmvd/trip-advisor-hotel-reviews) посчитать [Tf-Idf](https://ru.wikipedia.org/wiki/TF-IDF) с помощью Spark DataFrame / Dataset API без использования Spark ML:
• Привести все к одному регистру
• Удалить все спецсимволы
• Посчитать частоту слова в предложении
• Посчитать количество документов со словом
• Взять только 100 самых встречаемых
• Сджойнить две полученные таблички и посчитать Tf-Idf (только для слов из предыдущего пункта)
• Запайвотить табличку

### Запускаем официальный [докер zeppelin](https://zeppelin.apache.org/download.html#using-the-official-docker-image) и загружаем датасет:
<pre>
$ docker run -p 8080:8080 --rm --name zeppelin apache/zeppelin:0.10.0
$ docker cp tripadvisor_hotel_reviews.csv 3a00188f2555:/opt/zeppelin/notebook/
</pre>

### Ноутбук-решение


