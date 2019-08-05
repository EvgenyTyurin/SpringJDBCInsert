package evgenyt.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;

/**
 * Spring JDBC insert sample
 * Aug 2019 EvgenyT
 */

public class App 
{
    public static void main( String[] args )
    {
        // Read context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        // Get dataSource bean
        DriverManagerDataSource dataSource = context.getBean("dataSource",
                DriverManagerDataSource.class);
        // Create insert actor
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("person");
        // Add parameters of insert query
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("person_id", "666");
        parameters.put("person_name", "John Silver");
        // Execute insert
        jdbcInsert.execute(parameters);
    }
}
