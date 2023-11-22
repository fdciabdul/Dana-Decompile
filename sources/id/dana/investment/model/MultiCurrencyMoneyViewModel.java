package id.dana.investment.model;

import id.dana.model.CurrencyAmountModel;
import id.dana.utils.BalanceUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u000e\u0010\rR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0014\u0010\f\u001a\u0004\u0018\u00010\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\t\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014"}, d2 = {"Lid/dana/investment/model/MultiCurrencyMoneyViewModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "PlaceComponentResult", "()Z", "", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "toString", "", "Ljava/lang/Long;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getErrorConfigVersion", "lookAheadTest", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MultiCurrencyMoneyViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Long MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Long BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Long getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String lookAheadTest;

    public MultiCurrencyMoneyViewModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MultiCurrencyMoneyViewModel) {
            MultiCurrencyMoneyViewModel multiCurrencyMoneyViewModel = (MultiCurrencyMoneyViewModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, multiCurrencyMoneyViewModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, multiCurrencyMoneyViewModel.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, multiCurrencyMoneyViewModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, multiCurrencyMoneyViewModel.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, multiCurrencyMoneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.lookAheadTest, multiCurrencyMoneyViewModel.lookAheadTest);
        }
        return false;
    }

    public final int hashCode() {
        Long l = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = l == null ? 0 : l.hashCode();
        Long l2 = this.getAuthRequestContext;
        int hashCode2 = l2 == null ? 0 : l2.hashCode();
        Long l3 = this.MyBillsEntityDataFactory;
        int hashCode3 = l3 == null ? 0 : l3.hashCode();
        String str = this.PlaceComponentResult;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.lookAheadTest;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiCurrencyMoneyViewModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(')');
        return sb.toString();
    }

    public MultiCurrencyMoneyViewModel(Long l, Long l2, Long l3, String str, String str2, String str3) {
        this.BuiltInFictitiousFunctionClassFactory = l;
        this.getAuthRequestContext = l2;
        this.MyBillsEntityDataFactory = l3;
        this.PlaceComponentResult = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.lookAheadTest = str3;
    }

    public /* synthetic */ MultiCurrencyMoneyViewModel(Long l, Long l2, Long l3, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) == 0 ? l3 : null, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? "" : str3);
    }

    public final String MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory != null ? BalanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(new CurrencyAmountModel(String.valueOf(this.BuiltInFictitiousFunctionClassFactory), this.PlaceComponentResult)) : "";
    }

    public final boolean PlaceComponentResult() {
        String obj;
        Long l = this.BuiltInFictitiousFunctionClassFactory;
        if (l == null || (obj = l.toString()) == null) {
            return false;
        }
        return StringsKt.contains$default((CharSequence) obj, '-', false, 2, (Object) null);
    }
}
