package kotlin.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
@MustBeDocumented
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0004\u001a\u00020\u0003R\u0019\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/annotation/Target;", "", "", "Lkotlin/annotation/AnnotationTarget;", "allowedTargets", "()[Lkotlin/annotation/AnnotationTarget;"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Documented
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface Target {
    @JvmName(name = "allowedTargets")
    AnnotationTarget[] allowedTargets();
}
