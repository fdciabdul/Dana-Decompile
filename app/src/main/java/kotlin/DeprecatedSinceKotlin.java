package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.jvm.JvmName;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@MustBeDocumented
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001e\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004"}, d2 = {"Lkotlin/DeprecatedSinceKotlin;", "", "", "errorSince", "()Ljava/lang/String;", "hiddenSince", "warningSince"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.TYPEALIAS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface DeprecatedSinceKotlin {
    @JvmName(name = "errorSince")
    String errorSince() default "";

    @JvmName(name = "hiddenSince")
    String hiddenSince() default "";

    @JvmName(name = "warningSince")
    String warningSince() default "";
}
