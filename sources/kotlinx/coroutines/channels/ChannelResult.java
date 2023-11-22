package kotlinx.coroutines.channels;

import id.dana.analytics.tracker.TrackerKey;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 !*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\"!#B\u0016\b\u0000\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010\rJ\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001c\u0088\u0001\u0019\u0092\u0001\u0004\u0018\u00010\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult;", "T", "", "other", "", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "equals", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "exceptionOrNull", "getOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrNull", "getOrThrow-impl", "getOrThrow", "", "hashCode-impl", "(Ljava/lang/Object;)I", "hashCode", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "holder", "Ljava/lang/Object;", "isClosed-impl", "(Ljava/lang/Object;)Z", "isClosed", "isSuccess-impl", TrackerKey.Property.IS_SUCCESS, "constructor-impl", "Companion", "Closed", "Failed"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* loaded from: classes3.dex */
public final class ChannelResult<T> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Failed failed = new Failed();
    public final Object holder;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Failed;", "", "", "toString", "()Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static class Failed {
        public String toString() {
            return "Failed";
        }
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ChannelResult m4634boximpl(Object obj) {
        return new ChannelResult(obj);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> Object m4635constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4636equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof ChannelResult) && Intrinsics.areEqual(obj, ((ChannelResult) obj2).getHolder());
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4640hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final boolean equals(Object obj) {
        return m4636equalsimpl(this.holder, obj);
    }

    public final int hashCode() {
        return m4640hashCodeimpl(this.holder);
    }

    /* renamed from: unbox-impl  reason: not valid java name and from getter */
    public final /* synthetic */ Object getHolder() {
        return this.holder;
    }

    private /* synthetic */ ChannelResult(Object obj) {
        this.holder = obj;
    }

    @JvmName(name = "isSuccess-impl")
    /* renamed from: isSuccess-impl  reason: not valid java name */
    public static final boolean m4642isSuccessimpl(Object obj) {
        return !(obj instanceof Failed);
    }

    @JvmName(name = "isClosed-impl")
    /* renamed from: isClosed-impl  reason: not valid java name */
    public static final boolean m4641isClosedimpl(Object obj) {
        return obj instanceof Closed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl  reason: not valid java name */
    public static final T m4638getOrNullimpl(Object obj) {
        if (obj instanceof Failed) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrThrow-impl  reason: not valid java name */
    public static final T m4639getOrThrowimpl(Object obj) {
        if (obj instanceof Failed) {
            if (obj instanceof Closed) {
                Closed closed = (Closed) obj;
                if (closed.cause != null) {
                    throw closed.cause;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Trying to call 'getOrThrow' on a failed channel result: ");
            sb.append(obj);
            throw new IllegalStateException(sb.toString().toString());
        }
        return obj;
    }

    /* renamed from: exceptionOrNull-impl  reason: not valid java name */
    public static final Throwable m4637exceptionOrNullimpl(Object obj) {
        Closed closed = obj instanceof Closed ? (Closed) obj : null;
        if (closed != null) {
            return closed.cause;
        }
        return null;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Closed;", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "cause", "Ljava/lang/Throwable;", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Closed extends Failed {
        public final Throwable cause;

        public Closed(Throwable th) {
            this.cause = th;
        }

        public final boolean equals(Object other) {
            return (other instanceof Closed) && Intrinsics.areEqual(this.cause, ((Closed) other).cause);
        }

        public final int hashCode() {
            Throwable th = this.cause;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult.Failed
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Closed(");
            sb.append(this.cause);
            sb.append(')');
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u00022\u0006\u0010\f\u001a\u00028\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Companion;", "", "E", "", "cause", "Lkotlinx/coroutines/channels/ChannelResult;", "closed-JP2dKIU", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "closed", "failure-PtdJZtk", "()Ljava/lang/Object;", "failure", "value", "success-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "success", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "failed", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: success-JP2dKIU  reason: not valid java name */
        public final <E> Object m4647successJP2dKIU(E value) {
            return ChannelResult.m4635constructorimpl(value);
        }

        /* renamed from: failure-PtdJZtk  reason: not valid java name */
        public final <E> Object m4646failurePtdJZtk() {
            return ChannelResult.m4635constructorimpl(ChannelResult.failed);
        }

        /* renamed from: closed-JP2dKIU  reason: not valid java name */
        public final <E> Object m4645closedJP2dKIU(Throwable cause) {
            return ChannelResult.m4635constructorimpl(new Closed(cause));
        }
    }

    public final String toString() {
        return m4643toStringimpl(this.holder);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4643toStringimpl(Object obj) {
        if (obj instanceof Closed) {
            return ((Closed) obj).toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Value(");
        sb.append(obj);
        sb.append(')');
        return sb.toString();
    }
}
