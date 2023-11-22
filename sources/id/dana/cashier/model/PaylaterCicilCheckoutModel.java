package id.dana.cashier.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0005\u001a\u00020\u00048\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\t\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u000b"}, d2 = {"Lid/dana/cashier/model/PaylaterCicilCheckoutModel;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "PlaceComponentResult", "()Z", "Ljava/lang/Boolean;", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "p1", "p2", "p3", "p4", "<init>", "(ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterCicilCheckoutModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Boolean getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    public PaylaterCicilCheckoutModel() {
        this(false, null, null, null, null, 31, null);
    }

    private PaylaterCicilCheckoutModel(boolean z, Boolean bool, Boolean bool2, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.BuiltInFictitiousFunctionClassFactory = z;
        this.getAuthRequestContext = bool;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bool2;
        this.MyBillsEntityDataFactory = str;
        this.PlaceComponentResult = str2;
    }

    public /* synthetic */ PaylaterCicilCheckoutModel(boolean z, Boolean bool, Boolean bool2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : bool, (i & 4) == 0 ? bool2 : null, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? "" : str2);
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return Intrinsics.areEqual(this.MyBillsEntityDataFactory, p0);
    }
}
