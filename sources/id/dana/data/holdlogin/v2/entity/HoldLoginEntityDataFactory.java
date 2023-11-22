package id.dana.data.holdlogin.v2.entity;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.holdlogin.v2.entity.source.NewHoldLoginEntityNetwork;
import id.dana.data.holdlogin.v2.entity.source.OldHoldLoginEntityNetwork;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\f"}, d2 = {"Lid/dana/data/holdlogin/v2/entity/HoldLoginEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/holdlogin/v2/entity/HoldLoginEntityData;", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lid/dana/data/holdlogin/v2/entity/HoldLoginEntityData;", "Lid/dana/data/holdlogin/v2/entity/source/NewHoldLoginEntityNetwork;", "PlaceComponentResult", "Lid/dana/data/holdlogin/v2/entity/source/NewHoldLoginEntityNetwork;", "getAuthRequestContext", "Lid/dana/data/holdlogin/v2/entity/source/OldHoldLoginEntityNetwork;", "Lid/dana/data/holdlogin/v2/entity/source/OldHoldLoginEntityNetwork;", "MyBillsEntityDataFactory", "p1", "<init>", "(Lid/dana/data/holdlogin/v2/entity/source/OldHoldLoginEntityNetwork;Lid/dana/data/holdlogin/v2/entity/source/NewHoldLoginEntityNetwork;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HoldLoginEntityDataFactory extends AbstractEntityDataFactory<HoldLoginEntityData> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final NewHoldLoginEntityNetwork getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final OldHoldLoginEntityNetwork MyBillsEntityDataFactory;

    @Inject
    public HoldLoginEntityDataFactory(OldHoldLoginEntityNetwork oldHoldLoginEntityNetwork, NewHoldLoginEntityNetwork newHoldLoginEntityNetwork) {
        Intrinsics.checkNotNullParameter(oldHoldLoginEntityNetwork, "");
        Intrinsics.checkNotNullParameter(newHoldLoginEntityNetwork, "");
        this.MyBillsEntityDataFactory = oldHoldLoginEntityNetwork;
        this.getAuthRequestContext = newHoldLoginEntityNetwork;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
    public final HoldLoginEntityData createData2(String p0) {
        if (Intrinsics.areEqual(p0, "old_hold_login")) {
            return this.MyBillsEntityDataFactory;
        }
        if (Intrinsics.areEqual(p0, "new_hold_login")) {
            return this.getAuthRequestContext;
        }
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }
}
