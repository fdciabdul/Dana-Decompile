package id.dana.investment.model;

import id.dana.domain.investment.AccountInvestmentStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0013\b\u0086\b\u0018\u0000 02\u00020\u0001:\u00010B\u0093\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010#\u001a\u00020\u0011\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b.\u0010/J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0013\u001a\u00020\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0014\u0010\t\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0017X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u000fR\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u001dX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0014\u0010 \u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b \u0010\u000fR\u0014\u0010\"\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b!\u0010\u000f"}, d2 = {"Lid/dana/investment/model/UserInvestmentModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "getAuthRequestContext", "()Z", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/investment/AccountInvestmentStatus;", "Lid/dana/domain/investment/AccountInvestmentStatus;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/investment/model/MultiCurrencyMoneyViewModel;", "Lid/dana/investment/model/MultiCurrencyMoneyViewModel;", "Lid/dana/investment/model/InvestmentUnitModel;", "Lid/dana/investment/model/InvestmentUnitModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "lookAheadTest", "moveToNextValue", "", "Ljava/lang/Long;", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "DatabaseTableConfigUtil", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "<init>", "(Ljava/lang/String;Lid/dana/domain/investment/AccountInvestmentStatus;Ljava/lang/String;Lid/dana/investment/model/MultiCurrencyMoneyViewModel;Lid/dana/investment/model/InvestmentUnitModel;Lid/dana/investment/model/MultiCurrencyMoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lid/dana/investment/model/MultiCurrencyMoneyViewModel;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class UserInvestmentModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public InvestmentUnitModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public String DatabaseTableConfigUtil;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public MultiCurrencyMoneyViewModel scheduleImpl;
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public MultiCurrencyMoneyViewModel MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public AccountInvestmentStatus PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public MultiCurrencyMoneyViewModel moveToNextValue;
    public String lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public Long getErrorConfigVersion;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof UserInvestmentModel) {
            UserInvestmentModel userInvestmentModel = (UserInvestmentModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, userInvestmentModel.BuiltInFictitiousFunctionClassFactory) && this.PlaceComponentResult == userInvestmentModel.PlaceComponentResult && Intrinsics.areEqual(this.getAuthRequestContext, userInvestmentModel.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, userInvestmentModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, userInvestmentModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.scheduleImpl, userInvestmentModel.scheduleImpl) && Intrinsics.areEqual(this.lookAheadTest, userInvestmentModel.lookAheadTest) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, userInvestmentModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.getErrorConfigVersion, userInvestmentModel.getErrorConfigVersion) && Intrinsics.areEqual(this.moveToNextValue, userInvestmentModel.moveToNextValue) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, userInvestmentModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, userInvestmentModel.DatabaseTableConfigUtil);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = str == null ? 0 : str.hashCode();
        int hashCode2 = this.PlaceComponentResult.hashCode();
        String str2 = this.getAuthRequestContext;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        MultiCurrencyMoneyViewModel multiCurrencyMoneyViewModel = this.MyBillsEntityDataFactory;
        int hashCode4 = multiCurrencyMoneyViewModel == null ? 0 : multiCurrencyMoneyViewModel.hashCode();
        InvestmentUnitModel investmentUnitModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode5 = investmentUnitModel == null ? 0 : investmentUnitModel.hashCode();
        MultiCurrencyMoneyViewModel multiCurrencyMoneyViewModel2 = this.scheduleImpl;
        int hashCode6 = multiCurrencyMoneyViewModel2 == null ? 0 : multiCurrencyMoneyViewModel2.hashCode();
        String str3 = this.lookAheadTest;
        int hashCode7 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode8 = str4 == null ? 0 : str4.hashCode();
        Long l = this.getErrorConfigVersion;
        int hashCode9 = l == null ? 0 : l.hashCode();
        MultiCurrencyMoneyViewModel multiCurrencyMoneyViewModel3 = this.moveToNextValue;
        int hashCode10 = multiCurrencyMoneyViewModel3 == null ? 0 : multiCurrencyMoneyViewModel3.hashCode();
        String str5 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode11 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.DatabaseTableConfigUtil;
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserInvestmentModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(')');
        return sb.toString();
    }

    public UserInvestmentModel(String str, AccountInvestmentStatus accountInvestmentStatus, String str2, MultiCurrencyMoneyViewModel multiCurrencyMoneyViewModel, InvestmentUnitModel investmentUnitModel, MultiCurrencyMoneyViewModel multiCurrencyMoneyViewModel2, String str3, String str4, Long l, MultiCurrencyMoneyViewModel multiCurrencyMoneyViewModel3, String str5, String str6) {
        Intrinsics.checkNotNullParameter(accountInvestmentStatus, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = accountInvestmentStatus;
        this.getAuthRequestContext = str2;
        this.MyBillsEntityDataFactory = multiCurrencyMoneyViewModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = investmentUnitModel;
        this.scheduleImpl = multiCurrencyMoneyViewModel2;
        this.lookAheadTest = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
        this.getErrorConfigVersion = l;
        this.moveToNextValue = multiCurrencyMoneyViewModel3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str5;
        this.DatabaseTableConfigUtil = str6;
    }

    public /* synthetic */ UserInvestmentModel(String str, AccountInvestmentStatus accountInvestmentStatus, String str2, MultiCurrencyMoneyViewModel multiCurrencyMoneyViewModel, InvestmentUnitModel investmentUnitModel, MultiCurrencyMoneyViewModel multiCurrencyMoneyViewModel2, String str3, String str4, Long l, MultiCurrencyMoneyViewModel multiCurrencyMoneyViewModel3, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, accountInvestmentStatus, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? null : multiCurrencyMoneyViewModel, (i & 16) != 0 ? null : investmentUnitModel, (i & 32) != 0 ? null : multiCurrencyMoneyViewModel2, (i & 64) != 0 ? "" : str3, (i & 128) != 0 ? "" : str4, (i & 256) != 0 ? 0L : l, (i & 512) != 0 ? null : multiCurrencyMoneyViewModel3, (i & 1024) != 0 ? "" : str5, (i & 2048) != 0 ? "" : str6);
    }

    public final boolean getAuthRequestContext() {
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        return (str == null || StringsKt.isBlank(str)) || this.MyBillsEntityDataFactory == null;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/investment/model/UserInvestmentModel$Companion;", "", "Lid/dana/investment/model/UserInvestmentModel;", "PlaceComponentResult", "()Lid/dana/investment/model/UserInvestmentModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static UserInvestmentModel PlaceComponentResult() {
            return new UserInvestmentModel(null, AccountInvestmentStatus.NOT_EXIST, null, null, null, null, null, null, null, null, null, null, 4093, null);
        }
    }
}
