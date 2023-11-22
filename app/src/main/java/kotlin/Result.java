package kotlin;

import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.analytics.tracker.TrackerKey;
import java.io.Serializable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0087@\u0018\u0000 #*\u0006\b\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002#$B\u0016\b\u0000\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u000fJ\u001a\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0014\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001b\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b \u0010!\u0088\u0001\u001e\u0092\u0001\u0004\u0018\u00010\u0004ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "other", "", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "equals", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "exceptionOrNull", "getOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrNull", "", "hashCode-impl", "(Ljava/lang/Object;)I", "hashCode", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "isFailure-impl", "(Ljava/lang/Object;)Z", "isFailure", "isSuccess-impl", TrackerKey.Property.IS_SUCCESS, "value", "Ljava/lang/Object;", "getValue$annotations", "()V", "constructor-impl", "Companion", HummerConstants.EKYC_FAIL}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class Result<T> implements Serializable {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final Object value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Result m3178boximpl(Object obj) {
        return new Result(obj);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> Object m3179constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3180equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && Intrinsics.areEqual(obj, ((Result) obj2).getValue());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3181equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3184hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final boolean equals(Object obj) {
        return m3180equalsimpl(this.value, obj);
    }

    public final int hashCode() {
        return m3184hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name and from getter */
    public final /* synthetic */ Object getValue() {
        return this.value;
    }

    private /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    @JvmName(name = "isSuccess-impl")
    /* renamed from: isSuccess-impl  reason: not valid java name */
    public static final boolean m3186isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    @JvmName(name = "isFailure-impl")
    /* renamed from: isFailure-impl  reason: not valid java name */
    public static final boolean m3185isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl  reason: not valid java name */
    private static final T m3183getOrNullimpl(Object obj) {
        if (m3185isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    /* renamed from: exceptionOrNull-impl  reason: not valid java name */
    public static final Throwable m3182exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    public final String toString() {
        return m3187toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3187toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Success(");
        sb.append(obj);
        sb.append(')');
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u00022\u0006\u0010\b\u001a\u00028\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/Result$Companion;", "", "T", "", "exception", "Lkotlin/Result;", "failure", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "value", "success", "(Ljava/lang/Object;)Ljava/lang/Object;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final <T> Object success(T value) {
            return Result.m3179constructorimpl(value);
        }

        private final <T> Object failure(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "");
            return Result.m3179constructorimpl(ResultKt.createFailure(exception));
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "exception", "Ljava/lang/Throwable;", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "");
            this.exception = th;
        }

        public final boolean equals(Object other) {
            return (other instanceof Failure) && Intrinsics.areEqual(this.exception, ((Failure) other).exception);
        }

        public final int hashCode() {
            return this.exception.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Failure(");
            sb.append(this.exception);
            sb.append(')');
            return sb.toString();
        }
    }
}
