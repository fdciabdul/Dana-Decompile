package id.dana.data.here.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/data/here/model/Street;", "", "", "component1", "()Ljava/lang/Integer;", "component2", "start", "end", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lid/dana/data/here/model/Street;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getEnd", "getStart", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class Street {
    @SerializedName("end")
    private final Integer end;
    @SerializedName("start")
    private final Integer start;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Street() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.here.model.Street.<init>():void");
    }

    public static /* synthetic */ Street copy$default(Street street, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = street.start;
        }
        if ((i & 2) != 0) {
            num2 = street.end;
        }
        return street.copy(num, num2);
    }

    /* renamed from: component1  reason: from getter */
    public final Integer getStart() {
        return this.start;
    }

    /* renamed from: component2  reason: from getter */
    public final Integer getEnd() {
        return this.end;
    }

    public final Street copy(Integer start, Integer end) {
        return new Street(start, end);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Street) {
            Street street = (Street) other;
            return Intrinsics.areEqual(this.start, street.start) && Intrinsics.areEqual(this.end, street.end);
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.start;
        int hashCode = num == null ? 0 : num.hashCode();
        Integer num2 = this.end;
        return (hashCode * 31) + (num2 != null ? num2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Street(start=");
        sb.append(this.start);
        sb.append(", end=");
        sb.append(this.end);
        sb.append(')');
        return sb.toString();
    }

    public Street(Integer num, Integer num2) {
        this.start = num;
        this.end = num2;
    }

    public /* synthetic */ Street(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2);
    }

    @JvmName(name = "getStart")
    public final Integer getStart() {
        return this.start;
    }

    @JvmName(name = "getEnd")
    public final Integer getEnd() {
        return this.end;
    }
}
