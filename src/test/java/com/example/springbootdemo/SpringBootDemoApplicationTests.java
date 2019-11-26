package com.example.springbootdemo;

import com.example.springbootdemo.config.MyAppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class SpringBootDemoApplicationTests {

  @Test
  void contextLoads() {
    System.out.println(1);
  }

  /**
   * {@link com.zaxxer.hikari.HikariDataSource}
   */
  @Autowired
  DataSource dataSource;
  @Test
  public void testJdbc() throws SQLException {
    System.out.println(dataSource.getClass());
    Connection connection = dataSource.getConnection();
    System.out.println(connection);
    connection.close();
  }

  /**
   * {@link }
   */
  @Autowired
  JdbcTemplate jdbcTemplate;
  @Test
  public void testJdbcTemplate(){
    System.out.println(jdbcTemplate.queryForList("select account from t_core_user",String.class));
  }
}
