# vtbmoretech
## База данных:

1) НСИ(сотрудник):
  - Фамилия
  - Имя
  - Отчество
  - Приватный ключ
  - Пользователь (1к1)
  - Отдел
  - Должность
  - Инвентарь (1к1)
  - Достижения (1кN)
  - Вложение (filedescriptor)
  
  2) Достижения:
  - Название
  - Описание
  - Дата получения 
  - Вложение
   
   3) Событие:
    - Название
    - Достижение (MкN)
    - Дата начала
    - Дата конца
    - Описание
   
   3) Новость:
   - Заголовок
   - Описание
   - Вложения
   - Автор
   - Дата публикации
   - Подтвержденность (видимость true/false)
    
   4) Инвентарь:
   - Предмет (1кN)
     
   5) Предмет:
   - id
   - Описание
   - Цена
