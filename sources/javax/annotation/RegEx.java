package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

@Syntax("RegEx")
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface RegEx {

    /* loaded from: classes3.dex */
    public static class Checker implements TypeQualifierValidator<RegEx> {
    }

    When when() default When.ALWAYS;
}
