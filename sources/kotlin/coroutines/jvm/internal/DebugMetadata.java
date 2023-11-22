package kotlin.coroutines.jvm.internal;

import com.alipay.mobile.rome.syncsdk.transport.connection.f;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.huawei.hms.opendevice.i;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmName;

@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b\u0081\u0002\u0018\u00002\u00020\u0001B\\\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002R\u0011\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u00068\u0007¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00068\u0007¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0007¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0011\u0010\u0013\u001a\u00020\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0007¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0019\u001a\u00020\u00168\u0007¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018"}, d2 = {"Lkotlin/coroutines/jvm/internal/DebugMetadata;", "", "", "c", "()Ljava/lang/String;", "className", "", i.MyBillsEntityDataFactory, "()[I", "indexToLabel", "l", "lineNumbers", "", "n", "()[Ljava/lang/String;", "localNames", "m", "methodName", f.f7258a, "sourceFile", "s", "spilled", "", SecurityConstants.KEY_VALUE, "()I", "version"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface DebugMetadata {
    @JvmName(name = "c")
    String c() default "";

    @JvmName(name = f.f7258a)
    String f() default "";

    @JvmName(name = i.MyBillsEntityDataFactory)
    int[] i() default {};

    @JvmName(name = "l")
    int[] l() default {};

    @JvmName(name = "m")
    String m() default "";

    @JvmName(name = "n")
    String[] n() default {};

    @JvmName(name = "s")
    String[] s() default {};

    @JvmName(name = SecurityConstants.KEY_VALUE)
    int v() default 1;
}
