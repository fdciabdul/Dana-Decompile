package id.dana.rum;

import id.dana.rum.Rum;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/rum/RumNoOp;", "Lid/dana/rum/Rum;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RumNoOp implements Rum {
    public static final RumNoOp INSTANCE = new RumNoOp();

    @Override // id.dana.rum.Rum
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(String str) {
        Rum.CC.BuiltInFictitiousFunctionClassFactory(str);
    }

    @Override // id.dana.rum.Rum
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(String str, Pair... pairArr) {
        Rum.CC.KClassImpl$Data$declaredNonStaticMembers$2(str, pairArr);
    }

    @Override // id.dana.rum.Rum
    public final /* synthetic */ void MyBillsEntityDataFactory(Exception exc, Pair... pairArr) {
        Rum.CC.PlaceComponentResult(exc, pairArr);
    }

    @Override // id.dana.rum.Rum
    public final /* synthetic */ void PlaceComponentResult(String str) {
        Rum.CC.MyBillsEntityDataFactory(str);
    }

    @Override // id.dana.rum.Rum
    public final /* synthetic */ void PlaceComponentResult(String str, String str2) {
        Rum.CC.getAuthRequestContext(str, str2);
    }

    @Override // id.dana.rum.Rum
    public final /* synthetic */ Rum.Workflow getAuthRequestContext(String str, Pair... pairArr) {
        return Rum.CC.PlaceComponentResult(str, pairArr);
    }

    private RumNoOp() {
    }
}
