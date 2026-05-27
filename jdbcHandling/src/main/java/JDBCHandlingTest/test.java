package JDBCHandlingTest;

import data.JdbcPerson;
import domain.Person;
import java.util.List;

public class test {

    public static void main(String[] args) {
        JdbcPerson jdbcPerson = new JdbcPerson();
        List<Person> people = jdbcPerson.select();
        for (Person person : people) {
            System.out.print(person);
            System.out.println("");
        }
    }
}