package kotlin;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import id.dana.sendmoney.contact.provider.ContactProvider;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmName;

@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\u0002\u0018\u00002\u00020\u0001B\\\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000fR\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\u000f8\u0007¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\t8\u0007¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\u000f8\u0007¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u001a\u001a\u00020\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004R\u0017\u0010\u001d\u001a\u00020\t8\u0007¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001b\u0010\u0015"}, d2 = {"Lkotlin/Metadata;", "", "", "bv", "()[I", "bv$annotations", "()V", "bytecodeVersion", "", "", "d1", "()[Ljava/lang/String;", ContactProvider.Column.PHONENUMBER, "d2", "data2", "", "xi", "()I", "xi$annotations", "extraInt", "xs", "()Ljava/lang/String;", "extraString", "k", "kind", "mv", "metadataVersion", "pn", "pn$annotations", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
/* loaded from: classes.dex */
public @interface Metadata {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.WARNING, message = "Bytecode version had no significant use in Kotlin metadata and it will be removed in a future version.")
        public static /* synthetic */ void bv$annotations() {
        }

        public static /* synthetic */ void pn$annotations() {
        }

        public static /* synthetic */ void xi$annotations() {
        }
    }

    @JvmName(name = "bv")
    int[] bv() default {1, 0, 3};

    @JvmName(name = "d1")
    String[] d1() default {};

    @JvmName(name = "d2")
    String[] d2() default {};

    @JvmName(name = "k")
    int k() default 1;

    @JvmName(name = "mv")
    int[] mv() default {};

    @JvmName(name = "pn")
    String pn() default "";

    @JvmName(name = "xi")
    int xi() default 0;

    @JvmName(name = "xs")
    String xs() default "";
}
