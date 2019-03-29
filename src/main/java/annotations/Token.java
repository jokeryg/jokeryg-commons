package annotations;




import enums.TokenMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 令牌注解
 * Created by 杨光 on 2017/6/22.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Token {
    TokenMethod method() default TokenMethod.none;
}



