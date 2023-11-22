package androidx.annotation;

import com.alibaba.griver.beehive.lottie.constants.LottieConstants;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.jvm.JvmName;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@MustBeDocumented
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B(\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004"}, d2 = {"Landroidx/annotation/Size;", "", "", LottieConstants.PARAM_MAX_VALUE, "()J", LottieConstants.PARAM_MIN_VALUE, "multiple", "value"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Documented
/* loaded from: classes2.dex */
public @interface Size {
    @JvmName(name = LottieConstants.PARAM_MAX_VALUE)
    long max() default Long.MAX_VALUE;

    @JvmName(name = LottieConstants.PARAM_MIN_VALUE)
    long min() default Long.MIN_VALUE;

    @JvmName(name = "multiple")
    long multiple() default 1;

    @JvmName(name = "value")
    long value() default -1;
}
