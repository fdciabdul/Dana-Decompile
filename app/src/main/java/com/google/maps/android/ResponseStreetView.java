package com.google.maps.android;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lcom/google/maps/android/ResponseStreetView;", "", "Lcom/google/maps/android/Status;", "component1", "()Lcom/google/maps/android/Status;", "status", "copy", "(Lcom/google/maps/android/Status;)Lcom/google/maps/android/ResponseStreetView;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/google/maps/android/Status;", "getStatus", "<init>", "(Lcom/google/maps/android/Status;)V"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class ResponseStreetView {
    private final Status status;

    public static /* synthetic */ ResponseStreetView copy$default(ResponseStreetView responseStreetView, Status status, int i, Object obj) {
        if ((i & 1) != 0) {
            status = responseStreetView.status;
        }
        return responseStreetView.copy(status);
    }

    /* renamed from: component1  reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    public final ResponseStreetView copy(Status status) {
        Intrinsics.checkNotNullParameter(status, "");
        return new ResponseStreetView(status);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ResponseStreetView) && this.status == ((ResponseStreetView) other).status;
    }

    public final int hashCode() {
        return this.status.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResponseStreetView(status=");
        sb.append(this.status);
        sb.append(')');
        return sb.toString();
    }

    public ResponseStreetView(Status status) {
        Intrinsics.checkNotNullParameter(status, "");
        this.status = status;
    }

    @JvmName(name = "getStatus")
    public final Status getStatus() {
        return this.status;
    }
}
