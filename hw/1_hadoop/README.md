# Домашнее задание №1: Hadoop

## Подробное [описание](https://github.com/GimmeDanger/made-big-data-2021/blob/master/hw/1_hadoop/HW1%20-%20Hadoop.pdf)

## 1. Развертывание локального кластера: [tutorial](https://youtu.be/ny2w5zImqvA)
  * Устанавливаем докер-образ из https://github.com/big-data-europe/docker-hadoop
  * Настраиваем [docker-compose.yml](https://github.com/GimmeDanger/made-big-data-2021/blob/master/hw/1_hadoop/docker-compose.yml)
  * Запускаем и сохраняем скриншоты: [NN.png](https://github.com/GimmeDanger/made-big-data-2021/blob/master/hw/1_hadoop/NN.png), [RM.png](https://github.com/GimmeDanger/made-big-data-2021/blob/master/hw/1_hadoop/RM.png)
  * Note: на этом этапе возникла проблема, что в дефолтном yml не было проброски порта для RM

## 2. Работа с файловой системой, простейшие операции
 * Запуск команд: [2_hdfs_dfs_intro.txt](https://github.com/GimmeDanger/made-big-data-2021/blob/master/hw/1_hadoop/2_hdfs_dfs_intro.txt)

## 3. Написание map reduce на Python: [tutorial](https://www.michael-noll.com/tutorials/writing-an-hadoop-mapreduce-program-in-python/)
 * Наивный расчет через numpy: [naive_calc.py](https://github.com/GimmeDanger/made-big-data-2021/blob/master/hw/1_hadoop/naive_calc.ipynb)
 * Mapper: [mapper.py](https://github.com/GimmeDanger/made-big-data-2021/blob/master/hw/1_hadoop/mapper.py)
 * Reducer: [reducer.py](https://github.com/GimmeDanger/made-big-data-2021/blob/master/hw/1_hadoop/reducer.py)
 * Запуск: [3_map_reduce_job.txt](https://github.com/GimmeDanger/made-big-data-2021/blob/master/hw/1_hadoop/3_map_reduce_job.txt)
 * Note: проблемы возникли в отсутствием установленного python3 в nodemanager1,2,3. Правильным способом решения было бы изменение докер образа, но я просто доустановил питон в "живые" контейнеры
