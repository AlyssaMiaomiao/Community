package com.nowcoder.community;

<<<<<<< HEAD
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommunityApplication {

	public static void main(MysqlxDatatypes.Scalar.String[] args) {
=======
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
//这个注解所标识的类表示是配置文件
public class CommunityApplication {

	public static void main(String[] args) {

>>>>>>> 2965fdde98e956b8b636b00cee29f2367d6615b0
		SpringApplication.run(CommunityApplication.class, args);
	}

}
