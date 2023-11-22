package id.dana.data.here.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/data/here/model/References;", "", "Lid/dana/data/here/model/Supplier;", "component1", "()Lid/dana/data/here/model/Supplier;", "", "component2", "()Ljava/lang/Integer;", "supplier", "id", "copy", "(Lid/dana/data/here/model/Supplier;Ljava/lang/Integer;)Lid/dana/data/here/model/References;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getId", "Lid/dana/data/here/model/Supplier;", "getSupplier", "<init>", "(Lid/dana/data/here/model/Supplier;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class References {
    @SerializedName("id")
    private final Integer id;
    @SerializedName("supplier")
    private final Supplier supplier;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.data.here.model.Supplier, java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public References() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.here.model.References.<init>():void");
    }

    public static /* synthetic */ References copy$default(References references, Supplier supplier, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            supplier = references.supplier;
        }
        if ((i & 2) != 0) {
            num = references.id;
        }
        return references.copy(supplier, num);
    }

    /* renamed from: component1  reason: from getter */
    public final Supplier getSupplier() {
        return this.supplier;
    }

    /* renamed from: component2  reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    public final References copy(Supplier supplier, Integer id2) {
        return new References(supplier, id2);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof References) {
            References references = (References) other;
            return Intrinsics.areEqual(this.supplier, references.supplier) && Intrinsics.areEqual(this.id, references.id);
        }
        return false;
    }

    public final int hashCode() {
        Supplier supplier = this.supplier;
        int hashCode = supplier == null ? 0 : supplier.hashCode();
        Integer num = this.id;
        return (hashCode * 31) + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("References(supplier=");
        sb.append(this.supplier);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(')');
        return sb.toString();
    }

    public References(Supplier supplier, Integer num) {
        this.supplier = supplier;
        this.id = num;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ References(id.dana.data.here.model.Supplier r2, java.lang.Integer r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r1 = this;
            r5 = r4 & 1
            if (r5 == 0) goto Lb
            id.dana.data.here.model.Supplier r2 = new id.dana.data.here.model.Supplier
            r5 = 0
            r0 = 1
            r2.<init>(r5, r0, r5)
        Lb:
            r4 = r4 & 2
            if (r4 == 0) goto L14
            r3 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L14:
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.here.model.References.<init>(id.dana.data.here.model.Supplier, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getSupplier")
    public final Supplier getSupplier() {
        return this.supplier;
    }

    @JvmName(name = "getId")
    public final Integer getId() {
        return this.id;
    }
}
