package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;

@TypeQualifier(applicableTo = String.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface MatchesPattern {

    /* loaded from: classes3.dex */
    public static class Checker implements TypeQualifierValidator<MatchesPattern> {
    }

    int flags() default 0;

    @RegEx
    String value();
}
