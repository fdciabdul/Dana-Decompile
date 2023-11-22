package id.dana.domain.twilio.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004"}, d2 = {"Lid/dana/domain/twilio/model/BindEnrollInfo;", "", "", "component1", "()Ljava/lang/String;", "status", "copy", "(Ljava/lang/String;)Lid/dana/domain/twilio/model/BindEnrollInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getStatus", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BindEnrollInfo {
    private final String status;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BindEnrollInfo() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.twilio.model.BindEnrollInfo.<init>():void");
    }

    public static /* synthetic */ BindEnrollInfo copy$default(BindEnrollInfo bindEnrollInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bindEnrollInfo.status;
        }
        return bindEnrollInfo.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final BindEnrollInfo copy(String status) {
        Intrinsics.checkNotNullParameter(status, "");
        return new BindEnrollInfo(status);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BindEnrollInfo) && Intrinsics.areEqual(this.status, ((BindEnrollInfo) other).status);
    }

    public final int hashCode() {
        return this.status.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BindEnrollInfo(status=");
        sb.append(this.status);
        sb.append(')');
        return sb.toString();
    }

    public BindEnrollInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.status = str;
    }

    public /* synthetic */ BindEnrollInfo(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }
}
