package id.dana.domain.social;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\n\u000b"}, d2 = {"Lid/dana/domain/social/Result;", "", "T", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "Error", "Success", "Lid/dana/domain/social/Result$Success;", "Lid/dana/domain/social/Result$Error;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class Result<T> {
    public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Result() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u0000*\n\b\u0001\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u000f\u0012\u0006\u0010\u0006\u001a\u00028\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0004\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0001HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00028\u00018\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005"}, d2 = {"Lid/dana/domain/social/Result$Success;", "", "T", "Lid/dana/domain/social/Result;", "component1", "()Ljava/lang/Object;", "data", "copy", "(Ljava/lang/Object;)Lid/dana/domain/social/Result$Success;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getData", "<init>", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Success<T> extends Result<T> {
        private final T data;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.data;
            }
            return success.copy(obj);
        }

        public final T component1() {
            return this.data;
        }

        public final Success<T> copy(T data) {
            Intrinsics.checkNotNullParameter(data, "");
            return new Success<>(data);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.data, ((Success) other).data);
        }

        public final int hashCode() {
            return this.data.hashCode();
        }

        @Override // id.dana.domain.social.Result
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Success(data=");
            sb.append(this.data);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(T t) {
            super(null);
            Intrinsics.checkNotNullParameter(t, "");
            this.data = t;
        }

        @JvmName(name = "getData")
        public final T getData() {
            return this.data;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\u0010\u0007\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\b\u001a\u00020\u00002\f\b\u0002\u0010\u0007\u001a\u00060\u0003j\u0002`\u0004HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\u00060\u0003j\u0002`\u00048\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0006"}, d2 = {"Lid/dana/domain/social/Result$Error;", "Lid/dana/domain/social/Result;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "component1", "()Ljava/lang/Exception;", "exception", "copy", "(Ljava/lang/Exception;)Lid/dana/domain/social/Result$Error;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Exception;", "getException", "<init>", "(Ljava/lang/Exception;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Error extends Result {
        private final Exception exception;

        public static /* synthetic */ Error copy$default(Error error, Exception exc, int i, Object obj) {
            if ((i & 1) != 0) {
                exc = error.exception;
            }
            return error.copy(exc);
        }

        /* renamed from: component1  reason: from getter */
        public final Exception getException() {
            return this.exception;
        }

        public final Error copy(Exception exception) {
            Intrinsics.checkNotNullParameter(exception, "");
            return new Error(exception);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.exception, ((Error) other).exception);
        }

        public final int hashCode() {
            return this.exception.hashCode();
        }

        @Override // id.dana.domain.social.Result
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Error(exception=");
            sb.append(this.exception);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Exception exc) {
            super(null);
            Intrinsics.checkNotNullParameter(exc, "");
            this.exception = exc;
        }

        @JvmName(name = "getException")
        public final Exception getException() {
            return this.exception;
        }
    }

    public String toString() {
        if (this instanceof Success) {
            StringBuilder sb = new StringBuilder();
            sb.append("Success[data=");
            sb.append(((Success) this).getData());
            sb.append(']');
            return sb.toString();
        } else if (this instanceof Error) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error[exception=");
            sb2.append(((Error) this).getException());
            sb2.append(']');
            return sb2.toString();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
