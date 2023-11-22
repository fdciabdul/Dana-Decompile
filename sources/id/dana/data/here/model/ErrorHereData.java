package id.dana.data.here.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/data/here/model/ErrorHereData;", "", "", "component1", "()Ljava/lang/String;", "component2", "errorCode", "message", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/here/model/ErrorHereData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getErrorCode", "getMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ErrorHereData {
    private final String errorCode;
    private final String message;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ErrorHereData() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.here.model.ErrorHereData.<init>():void");
    }

    public static /* synthetic */ ErrorHereData copy$default(ErrorHereData errorHereData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = errorHereData.errorCode;
        }
        if ((i & 2) != 0) {
            str2 = errorHereData.message;
        }
        return errorHereData.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final ErrorHereData copy(String errorCode, String message) {
        Intrinsics.checkNotNullParameter(errorCode, "");
        Intrinsics.checkNotNullParameter(message, "");
        return new ErrorHereData(errorCode, message);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ErrorHereData) {
            ErrorHereData errorHereData = (ErrorHereData) other;
            return Intrinsics.areEqual(this.errorCode, errorHereData.errorCode) && Intrinsics.areEqual(this.message, errorHereData.message);
        }
        return false;
    }

    public final int hashCode() {
        return (this.errorCode.hashCode() * 31) + this.message.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ErrorHereData(errorCode=");
        sb.append(this.errorCode);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(')');
        return sb.toString();
    }

    public ErrorHereData(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.errorCode = str;
        this.message = str2;
    }

    public /* synthetic */ ErrorHereData(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    @JvmName(name = "getMessage")
    public final String getMessage() {
        return this.message;
    }
}
