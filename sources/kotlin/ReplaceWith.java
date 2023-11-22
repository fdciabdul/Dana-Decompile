package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.MustBeDocumented;
import kotlin.jvm.JvmName;

@Target({})
@kotlin.annotation.Target(allowedTargets = {})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@MustBeDocumented
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00058\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/ReplaceWith;", "", "", "expression", "()Ljava/lang/String;", "", "imports", "()[Ljava/lang/String;"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Documented
/* loaded from: classes2.dex */
public @interface ReplaceWith {
    @JvmName(name = "expression")
    String expression();

    @JvmName(name = "imports")
    String[] imports();
}
