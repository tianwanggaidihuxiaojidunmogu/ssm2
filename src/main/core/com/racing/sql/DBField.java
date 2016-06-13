package com.racing.sql;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DBField {
	String name() default "";

	String type() default "VARCHAR2";

	int length() default 0;

	int precision() default 0;

	String remark() default "";
	
	boolean isNotNull() default false;
}
