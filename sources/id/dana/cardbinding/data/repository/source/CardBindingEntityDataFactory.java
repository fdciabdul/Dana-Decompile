package id.dana.cardbinding.data.repository.source;

import id.dana.cardbinding.data.repository.source.local.MLKitCardBindingEntityData;
import id.dana.cardbinding.data.repository.source.network.NetworkCardBindingEntityData;
import id.dana.cardbinding.data.repository.source.split.SplitCardBindingEntityData;
import id.dana.data.AbstractEntityDataFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000b\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/cardbinding/data/repository/source/CardBindingEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/cardbinding/data/repository/source/CardBindingEntityData;", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)Lid/dana/cardbinding/data/repository/source/CardBindingEntityData;", "Lid/dana/cardbinding/data/repository/source/local/MLKitCardBindingEntityData;", "MyBillsEntityDataFactory", "Lid/dana/cardbinding/data/repository/source/local/MLKitCardBindingEntityData;", "Lid/dana/cardbinding/data/repository/source/network/NetworkCardBindingEntityData;", "getAuthRequestContext", "Lid/dana/cardbinding/data/repository/source/network/NetworkCardBindingEntityData;", "Lid/dana/cardbinding/data/repository/source/split/SplitCardBindingEntityData;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cardbinding/data/repository/source/split/SplitCardBindingEntityData;", "p1", "p2", "<init>", "(Lid/dana/cardbinding/data/repository/source/local/MLKitCardBindingEntityData;Lid/dana/cardbinding/data/repository/source/network/NetworkCardBindingEntityData;Lid/dana/cardbinding/data/repository/source/split/SplitCardBindingEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CardBindingEntityDataFactory extends AbstractEntityDataFactory<CardBindingEntityData> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final SplitCardBindingEntityData getAuthRequestContext;
    private final MLKitCardBindingEntityData MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final NetworkCardBindingEntityData PlaceComponentResult;

    @Inject
    public CardBindingEntityDataFactory(MLKitCardBindingEntityData mLKitCardBindingEntityData, NetworkCardBindingEntityData networkCardBindingEntityData, SplitCardBindingEntityData splitCardBindingEntityData) {
        Intrinsics.checkNotNullParameter(mLKitCardBindingEntityData, "");
        Intrinsics.checkNotNullParameter(networkCardBindingEntityData, "");
        Intrinsics.checkNotNullParameter(splitCardBindingEntityData, "");
        this.MyBillsEntityDataFactory = mLKitCardBindingEntityData;
        this.PlaceComponentResult = networkCardBindingEntityData;
        this.getAuthRequestContext = splitCardBindingEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
    public final CardBindingEntityData createData2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return Intrinsics.areEqual(p0, "local") ? this.MyBillsEntityDataFactory : Intrinsics.areEqual(p0, "split") ? this.getAuthRequestContext : this.PlaceComponentResult;
    }
}
