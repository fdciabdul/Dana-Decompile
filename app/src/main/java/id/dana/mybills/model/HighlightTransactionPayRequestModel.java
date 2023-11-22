package id.dana.mybills.model;

import id.dana.mybills.constant.TransactionPayMode;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0011\u0010\n\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0004"}, d2 = {"Lid/dana/mybills/model/HighlightTransactionPayRequestModel;", "", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "PlaceComponentResult", "p0", "p1", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HighlightTransactionPayRequestModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final MoneyViewModel getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final String BuiltInFictitiousFunctionClassFactory;
    final String MyBillsEntityDataFactory;
    final MoneyViewModel PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2;

    private HighlightTransactionPayRequestModel(String str, MoneyViewModel moneyViewModel, @TransactionPayMode String str2, MoneyViewModel moneyViewModel2, MoneyViewModel moneyViewModel3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = moneyViewModel;
        this.MyBillsEntityDataFactory = str2;
        this.getAuthRequestContext = moneyViewModel2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = moneyViewModel3;
    }

    public /* synthetic */ HighlightTransactionPayRequestModel(String str, MoneyViewModel moneyViewModel, String str2, MoneyViewModel moneyViewModel2, MoneyViewModel moneyViewModel3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, moneyViewModel, str2, (i & 8) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel2, (i & 16) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel3);
    }
}
