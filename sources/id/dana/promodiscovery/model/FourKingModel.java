package id.dana.promodiscovery.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\bR\u0012\u0010\r\u001a\u00020\nX\u0087\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/promodiscovery/model/FourKingModel;", "", "Lid/dana/promodiscovery/model/FourKingItem;", "PlaceComponentResult", "Lid/dana/promodiscovery/model/FourKingItem;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "()Z", "MyBillsEntityDataFactory", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "p0", "p1", "p2", "<init>", "(Lid/dana/promodiscovery/model/FourKingItem;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FourKingModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;
    public final FourKingItem PlaceComponentResult;

    public FourKingModel(FourKingItem fourKingItem, String str, boolean z) {
        Intrinsics.checkNotNullParameter(fourKingItem, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.PlaceComponentResult = fourKingItem;
        this.getAuthRequestContext = str;
        this.MyBillsEntityDataFactory = z;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }
}
