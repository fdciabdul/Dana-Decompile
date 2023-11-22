package androidx.annotation;

import id.dana.data.foundation.logger.log.LoginTrackingConstants;
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
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.ANNOTATION_CLASS})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@MustBeDocumented
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001B(\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u00058\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00028\u0007¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0011\u0010\t\u001a\u00020\u00058\u0007¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007"}, d2 = {"Landroidx/annotation/FloatRange;", "", "", "from", "()D", "", "fromInclusive", "()Z", LoginTrackingConstants.LoginParam.TO, "toInclusive"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Documented
/* loaded from: classes2.dex */
public @interface FloatRange {
    @JvmName(name = "from")
    double from() default Double.NEGATIVE_INFINITY;

    @JvmName(name = "fromInclusive")
    boolean fromInclusive() default true;

    @JvmName(name = LoginTrackingConstants.LoginParam.TO)
    double to() default Double.POSITIVE_INFINITY;

    @JvmName(name = "toInclusive")
    boolean toInclusive() default true;
}
