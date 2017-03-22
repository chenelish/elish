package com.elish.hibernate;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity(name="hibernate")  //声明当前类为hibernate映射到数据库中的实体类
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class user {
	@Id   //声明此列为主键,作为映射对象的标识符
	 /**
     *  @GeneratedValue注解来定义生成策略
     *  GenerationType.TABLES 当前主键的值单独保存到一个数据库的表中
     *  GenerationType.SEQUENCE  利用底层数据库提供的序列生成标识符
     *  GenerationType.IDENTITY 采取数据库的自增策略
     *  GenerationType.AUTO 根据不同数据库自动选择合适的id生成方案，这里使用mysql,为递增型
     */
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",strategy="uuid")
	private String id;
	@Column(length=20,nullable=false)
private String name;
	@Column(length=10)

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}


}
