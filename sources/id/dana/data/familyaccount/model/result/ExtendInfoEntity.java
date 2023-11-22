package id.dana.data.familyaccount.model.result;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0005\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0003"}, d2 = {"Lid/dana/data/familyaccount/model/result/ExtendInfoEntity;", "", "component1", "()Ljava/lang/Object;", "any", "copy", "(Ljava/lang/Object;)Lid/dana/data/familyaccount/model/result/ExtendInfoEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getAny", "<init>", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ExtendInfoEntity {
    private final Object any;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ExtendInfoEntity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.familyaccount.model.result.ExtendInfoEntity.<init>():void");
    }

    public static /* synthetic */ ExtendInfoEntity copy$default(ExtendInfoEntity extendInfoEntity, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = extendInfoEntity.any;
        }
        return extendInfoEntity.copy(obj);
    }

    /* renamed from: component1  reason: from getter */
    public final Object getAny() {
        return this.any;
    }

    public final ExtendInfoEntity copy(Object any) {
        return new ExtendInfoEntity(any);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ExtendInfoEntity) && Intrinsics.areEqual(this.any, ((ExtendInfoEntity) other).any);
    }

    public final int hashCode() {
        Object obj = this.any;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtendInfoEntity(any=");
        sb.append(this.any);
        sb.append(')');
        return sb.toString();
    }

    public ExtendInfoEntity(Object obj) {
        this.any = obj;
    }

    public /* synthetic */ ExtendInfoEntity(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj);
    }

    @JvmName(name = "getAny")
    public final Object getAny() {
        return this.any;
    }
}
