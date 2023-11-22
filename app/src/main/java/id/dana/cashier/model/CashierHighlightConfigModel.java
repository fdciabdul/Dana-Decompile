package id.dana.cashier.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bBQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0011\u0010\u000b\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0011\u0010\f\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0011\u0010\u000e\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0011\u0010\u0012\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f"}, d2 = {"Lid/dana/cashier/model/CashierHighlightConfigModel;", "", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Z", "", "getAuthRequestContext", "Ljava/util/List;", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "", "PlaceComponentResult", "I", "scheduleImpl", "moveToNextValue", "lookAheadTest", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;ILjava/util/List;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierHighlightConfigModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final List<String> MyBillsEntityDataFactory;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;
    public final int PlaceComponentResult;
    public final List<String> getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final int lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final List<String> moveToNextValue;

    public CashierHighlightConfigModel(String str, int i, List<String> list, List<String> list2, String str2, int i2, List<String> list3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list3, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.lookAheadTest = i;
        this.moveToNextValue = list;
        this.MyBillsEntityDataFactory = list2;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.PlaceComponentResult = i2;
        this.getAuthRequestContext = list3;
    }

    public final boolean MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return !Intrinsics.areEqual(p0, "highlight_new_shown") && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, "ribbon");
    }
}
