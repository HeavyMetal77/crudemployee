package ua.tarastom.crudemployee.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

/*
если IDEA подчеркивает красным аннотированный класс (from Student) ("Cannot resolve simbol")
- https://ru.stackoverflow.com/questions/763151/%D0%A0%D0%B0%D0%B1%D0%BE%D1%82%D0%B0-%D1%81-hql-hibernate

Скорее всего у вас не включена интеграции идеи и БД. Идея подчеркивает потому,
что ничего не знает про схему вашей базы.
В левом столбце снизу (левее дерева файлов) у вас должны быть вкладка Persistence.
Откройте её, там должно быть имя ваше БД. ПКМ на ней и "Assign Data Sources..."
В открывшемся окне слева надо указать коннект к БД и сохранить (Если коннекта нет - справа на вкладке под мавеном
Database - подключить соединение к базе, тогда появится)
Если вкладки Persistence нет, тогда :
Ctrl + Shift + Alt + S
Facets
добавить jpa и внизу выбрать Default JPA provider - Hibernate
По факту даже не делая этого у вас все должно работать, если все сделали правильно.
Т.к. это ошибка интеграции Intellij IDEA а не проекта
 */