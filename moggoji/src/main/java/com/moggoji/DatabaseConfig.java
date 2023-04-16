package com.moggoji;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
 public class DatabaseConfig {

	@Autowired
	ApplicationContext applicationContext;

    @Bean
    SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
       
       final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
       sessionFactory.setDataSource(dataSource);

      PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
      sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
      sessionFactory.setConfigLocation(applicationContext.getResource("classpath:mybatis/mybatis-config.xml"));
      sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
      return sessionFactory.getObject();
  }

}