package id.dana.utils.holdlogin.v2.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005"}, d2 = {"Lid/dana/utils/holdlogin/v2/model/HoldLoginErrorCodesEntity;", "", "", "", "MyBillsEntityDataFactory", "Ljava/util/List;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HoldLoginErrorCodesEntity {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public List<String> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<String> getAuthRequestContext;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HoldLoginErrorCodesEntity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.utils.holdlogin.v2.model.HoldLoginErrorCodesEntity.<init>():void");
    }

    private HoldLoginErrorCodesEntity(List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        this.getAuthRequestContext = list;
        this.MyBillsEntityDataFactory = list2;
    }

    public /* synthetic */ HoldLoginErrorCodesEntity(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.listOf((Object[]) new String[]{"AE15112001306101", "AE15112001306102", "AE15112158044830", "AE15112158045003", "AE15112158047201"}) : list, (i & 2) != 0 ? CollectionsKt.listOf((Object[]) new String[]{"AE15002058020002", "AE15012158044002"}) : list2);
    }
}
