package com.example.up // Объявление пакета (уникального идентификатора) приложения

import android.os.Bundle // Импорт класса для работы с сохраненным состоянием экрана
import android.view.View // Импорт класса View для управления видимостью элементов (VISIBLE/GONE)
import android.widget.Button // Импорт компонента стандартной кнопки
import android.widget.ImageView // Импорт компонента для отображения графики
import androidx.appcompat.app.AppCompatActivity // Импорт базового класса для обратной совместимости интерфейса

// Главный класс экрана, наследуемый от AppCompatActivity (базовое окно приложения)
class MainActivity : AppCompatActivity() {

    // Системный метод жизненного цикла, вызываемый при первом создании экрана
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Вызов родительского метода для инициализации базовых механизмов окна

        // Связывание логического Kotlin-кода с визуальной XML-разметкой формы
        setContentView(R.layout.activity_main)

        // Инициализация переменных: связывание объектов кода с элементами UI по их уникальным ID
        val myButton: Button = findViewById(R.id.button) // Поиск главной кнопки клика
        val buttonClose: Button = findViewById(R.id.buttonClose) // Поиск кнопки закрытия просмотра
        val myImage: ImageView = findViewById(R.id.myImageView) // Поиск контейнера для фотографии

        // Регистрация слушателя событий (клик) для первой кнопки («Кликни меня!»)
        myButton.setOnClickListener {
            myButton.visibility = View.GONE // Полностью скрываем первую кнопку с экрана, освобождая место
            myImage.visibility = View.VISIBLE // Делаем контейнер с фотографией видимым для пользователя
            buttonClose.visibility = View.VISIBLE // Отображаем кнопку «Закрыть» для управления интерфейсом
        }

        // Регистрация слушателя событий для второй кнопки («Закрыть»)
        buttonClose.setOnClickListener {
            myImage.visibility = View.GONE // Бесследно скрываем изображение
            buttonClose.visibility = View.GONE // Прячем саму кнопку закрытия
            myButton.visibility = View.VISIBLE // Возвращаем первую кнопку в исходное видимое состояние
        }
    }
}