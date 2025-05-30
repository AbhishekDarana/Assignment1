// package com.inventory;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import javax.sql.DataSource;

// import static org.assertj.core.api.Assertions.assertThat;

// @SpringBootTest
// public class DatabaseConnectionTest {

//     @Autowired
//     private DataSource dataSource;

//     @Test
//     void contextLoads() {
//         // Just assert that DataSource is not null and connection is valid
//         assertThat(dataSource).isNotNull();

//         try (var conn = dataSource.getConnection()) {
//             assertThat(conn.isValid(1)).isTrue();  // 1-second timeout to check connection
//         } catch (Exception e) {
//             throw new RuntimeException("Failed to connect to the database", e);
//         }
//     }
// }
