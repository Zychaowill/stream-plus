package org.streamframework.foundation.attribute.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Movable {

	String value() default "";
	
	String name() default "";
	
	Class<?> from();

	String fromName();
	
	Class<?> to();
	
	String toName();
}
