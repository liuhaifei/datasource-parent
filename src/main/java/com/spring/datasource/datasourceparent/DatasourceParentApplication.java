package com.spring.datasource.datasourceparent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spring.datasource.datasourceparent.mapper")
public class DatasourceParentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatasourceParentApplication.class, args);
	}
}
