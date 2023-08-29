//package com.example.multitenant;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import javax.sql.DataSource;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.datasource.AbstractDataSource;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.web.servlet.function.HandlerFunction;
//import org.springframework.web.servlet.function.RouterFunction;
//import static org.springframework.web.servlet.function.RouterFunctions.route;
//import org.springframework.web.servlet.function.ServerRequest;
//import org.springframework.web.servlet.function.ServerResponse;
//
//@SpringBootApplication
//public class MultitenantApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(MultitenantApplication.class, args);
//
//        @Bean
//        RouterFunction<ServerResponse> routes
//        (JdbcTemplate template){
//            return route()
//                    .GET("/customers", request -> {
//                        var results:List<Customer> =template.query("select *from customer",
//                                (rs, rowNum) -> new Customer(rs.getInt("id"), rs.getString("name")));
//                        return ServerResponse.ok().body(results);
//
//                    }).build();
//        }
//
//    }
//
//    @Configuration
//    class DataSourceConfiguration {
//
//        @Bean
//        @Primary
//        DataSource multitenantDataSource(Map<String, DataSource>) {
//            var map:Map<Object, Object>=
//            dataSources.
//                    entrySet()
//                    .stream()
//                    .filter(e -> e.getKey().startsWith(prefix))
//                    .collect(Collectors.toMap(
//                            e -> (Object) Integer.parseInt(e.getKey().substring(prefix.length())),
//                            e -> (object) e.getValue()
//                    ));
//
//            map.forEach((tenantId, ds) -> {
//                var initializer = new ResourceDatabasePopulator(new ClassPathResource("schema.sql"),
//                        new ClasspathResource(prefix + tenantId + "-data.sql"));
//                initializer.execute(DataSource)ds
//                );
//                    System.out.println("Initialized datasource for" + tenantId);
//            });
//
//            var mds = new MultitenantDataSource();
//            mds.setTargetDataSources(map);
//            return mds;
//        }
//
//        @Bean
//        DataSource ds1() {
//            return dataSource(port:3306);
//                
//            }
//        DataSource ds2() {
//            return dataSource(port:3310);
//                
//            }
//        
//             private static void dataSource(int port) {
//            var dsp = new DataSourceProperties();
//            dsp.setPassword("root");
//            dsp.setUsername("root");
//            dsp.setUrl("jdbc:mysql://localhost:" + port + "/user")
//        }
//    }
//
//    class MultitenantDataSource extends AbstractDataSource {
//
//        @Override
//        protected DataSource determineTargetDataSource() {
//            if (this.initialized.compareAndSet(false, true)) {
//                this.afterPropertiesSet();
//            }
//        }
//
//        @Override
//        protected Object determineLookupKey() {
//
//            var authentication
//            :Authentication = SecurityContext.getContext().getAuthentication();
//            return null;
//        }
//    }
//
//}
//
//record Customer(Integer id, String name) {
//
//}
