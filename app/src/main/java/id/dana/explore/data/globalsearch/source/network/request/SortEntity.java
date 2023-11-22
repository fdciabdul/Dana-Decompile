package id.dana.explore.data.globalsearch.source.network.request;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/explore/data/globalsearch/source/network/request/SortEntity;", "", "", "by", "Ljava/lang/String;", "getBy", "()Ljava/lang/String;", "direction", "getDirection", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SortEntity {
    private final String by;
    private final String direction;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SortEntity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.data.globalsearch.source.network.request.SortEntity.<init>():void");
    }

    public SortEntity(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.by = str;
        this.direction = str2;
    }

    public /* synthetic */ SortEntity(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "name" : str, (i & 2) != 0 ? "asc" : str2);
    }

    @JvmName(name = "getBy")
    public final String getBy() {
        return this.by;
    }

    @JvmName(name = "getDirection")
    public final String getDirection() {
        return this.direction;
    }
}
