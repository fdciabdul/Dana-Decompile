package kotlin.reflect;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J'\u0010\u0006\u001a\u00028\u00002\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u00028\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bH&¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8'X¦\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\f8'X¦\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0010\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\f8'X¦\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\f8'X¦\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u000eR\u0014\u0010\u001a\u001a\u00020\u00178'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001b8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8'X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R \u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u001b8'X¦\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0010\u001a\u0004\b$\u0010\u001dR\u001c\u0010+\u001a\u0004\u0018\u00010'8'X¦\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0010\u001a\u0004\b(\u0010)"}, d2 = {"Lkotlin/reflect/KCallable;", "R", "Lkotlin/reflect/KAnnotatedElement;", "", "", "args", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "", "Lkotlin/reflect/KParameter;", "callBy", "(Ljava/util/Map;)Ljava/lang/Object;", "", "isAbstract", "()Z", "isAbstract$annotations", "()V", "isFinal", "isFinal$annotations", "isOpen", "isOpen$annotations", "isSuspend", "isSuspend$annotations", "", "getName", "()Ljava/lang/String;", "name", "", "getParameters", "()Ljava/util/List;", "parameters", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "returnType", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "getTypeParameters$annotations", "typeParameters", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "visibility"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface KCallable<R> extends KAnnotatedElement {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getTypeParameters$annotations() {
        }

        public static /* synthetic */ void getVisibility$annotations() {
        }

        public static /* synthetic */ void isAbstract$annotations() {
        }

        public static /* synthetic */ void isFinal$annotations() {
        }

        public static /* synthetic */ void isOpen$annotations() {
        }

        public static /* synthetic */ void isSuspend$annotations() {
        }
    }

    R call(Object... args);

    R callBy(Map<KParameter, ? extends Object> args);

    @JvmName(name = "getName")
    String getName();

    @JvmName(name = "getParameters")
    List<KParameter> getParameters();

    @JvmName(name = "getReturnType")
    KType getReturnType();

    @JvmName(name = "getTypeParameters")
    List<KTypeParameter> getTypeParameters();

    @JvmName(name = "getVisibility")
    KVisibility getVisibility();

    @JvmName(name = "isAbstract")
    boolean isAbstract();

    @JvmName(name = "isFinal")
    boolean isFinal();

    @JvmName(name = "isOpen")
    boolean isOpen();

    @JvmName(name = "isSuspend")
    boolean isSuspend();
}
