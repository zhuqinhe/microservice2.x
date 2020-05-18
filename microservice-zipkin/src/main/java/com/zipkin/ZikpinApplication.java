package com.zipkin;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import zipkin.storage.mysql.MySQLStorage;
import zipkin2.server.internal.EnableZipkinServer;



/**
 * 端口规划  默认4000
 * @Description 
 * @author hoob
 * @date 2019年7月11日上午11:49:27
 */



@SpringBootApplication
@EnableZipkinServer
public class ZikpinApplication {
  public static void main(String[] args) {
    SpringApplication.run(ZikpinApplication.class, args);
  }
  @Bean
  public MySQLStorage mySQLStorage(DataSource datasource) {
      return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
  }

}
