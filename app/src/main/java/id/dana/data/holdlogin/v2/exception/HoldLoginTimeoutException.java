package id.dana.data.holdlogin.v2.exception;

import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/data/holdlogin/v2/exception/HoldLoginTimeoutException;", "Ljava/net/SocketTimeoutException;", "", "component1", "()Ljava/lang/String;", "errorMessage", "copy", "(Ljava/lang/String;)Lid/dana/data/holdlogin/v2/exception/HoldLoginTimeoutException;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getErrorMessage", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HoldLoginTimeoutException extends SocketTimeoutException {
    private final String errorMessage;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HoldLoginTimeoutException() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.holdlogin.v2.exception.HoldLoginTimeoutException.<init>():void");
    }

    public static /* synthetic */ HoldLoginTimeoutException copy$default(HoldLoginTimeoutException holdLoginTimeoutException, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = holdLoginTimeoutException.errorMessage;
        }
        return holdLoginTimeoutException.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final HoldLoginTimeoutException copy(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "");
        return new HoldLoginTimeoutException(errorMessage);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HoldLoginTimeoutException) && Intrinsics.areEqual(this.errorMessage, ((HoldLoginTimeoutException) other).errorMessage);
    }

    public final int hashCode() {
        return this.errorMessage.hashCode();
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HoldLoginTimeoutException(errorMessage=");
        sb.append(this.errorMessage);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ HoldLoginTimeoutException(java.lang.String r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L1e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Hold login timeout, more than "
            r1.append(r2)
            long r2 = id.dana.data.holdlogin.v2.ConstantsKt.BuiltInFictitiousFunctionClassFactory()
            r1.append(r2)
            java.lang.String r2 = " ms"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
        L1e:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.holdlogin.v2.exception.HoldLoginTimeoutException.<init>(java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getErrorMessage")
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HoldLoginTimeoutException(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "");
        this.errorMessage = str;
    }
}
