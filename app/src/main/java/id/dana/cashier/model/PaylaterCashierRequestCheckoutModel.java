package id.dana.cashier.model;

import id.dana.domain.useragreement.model.AgreementInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0013\u0010\f\u001a\u0004\u0018\u00010\bX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\n"}, d2 = {"Lid/dana/cashier/model/PaylaterCashierRequestCheckoutModel;", "", "Lid/dana/domain/useragreement/model/AgreementInfo;", "MyBillsEntityDataFactory", "Lid/dana/domain/useragreement/model/AgreementInfo;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Ljava/lang/Integer;", "", "PlaceComponentResult", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "p0", "p1", "p2", "p3", "<init>", "(Ljava/lang/Integer;Lid/dana/domain/useragreement/model/AgreementInfo;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterCashierRequestCheckoutModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Integer MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final AgreementInfo KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    public PaylaterCashierRequestCheckoutModel() {
        this(null, null, null, null, 15, null);
    }

    public PaylaterCashierRequestCheckoutModel(Integer num, AgreementInfo agreementInfo, String str, String str2) {
        this.MyBillsEntityDataFactory = num;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = agreementInfo;
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getAuthRequestContext = str2;
    }

    public /* synthetic */ PaylaterCashierRequestCheckoutModel(Integer num, AgreementInfo agreementInfo, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : agreementInfo, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
    }
}
