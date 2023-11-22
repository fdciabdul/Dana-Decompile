package id.dana.sendmoney.ui.core.mapper;

import id.dana.core.ui.model.MoneyViewModel;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.sendmoney.domain.core.model.init.TransferInitResult;
import id.dana.sendmoney.domain.core.model.init.TransferUserInfo;
import id.dana.sendmoney.ui.core.model.TransferInitResultModel;
import id.dana.sendmoney.ui.core.model.TransferUserInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/nearbyme/model/MoneyView;", "Lid/dana/core/ui/model/MoneyViewModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/core/ui/model/MoneyViewModel;", "Lid/dana/sendmoney/domain/core/model/init/TransferInitResult;", "Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/domain/core/model/init/TransferInitResult;)Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;", "Lid/dana/sendmoney/domain/core/model/init/TransferUserInfo;", "Lid/dana/sendmoney/ui/core/model/TransferUserInfoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/domain/core/model/init/TransferUserInfo;)Lid/dana/sendmoney/ui/core/model/TransferUserInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferInitModelMapperKt {
    private static MoneyViewModel BuiltInFictitiousFunctionClassFactory(MoneyView moneyView) {
        Intrinsics.checkNotNullParameter(moneyView, "");
        String amount = moneyView.getAmount();
        String currency = moneyView.getCurrency();
        String currencyCode = moneyView.getCurrencyCode();
        return new MoneyViewModel(amount, currency, currencyCode != null ? currencyCode : "");
    }

    public static final TransferInitResultModel MyBillsEntityDataFactory(TransferInitResult transferInitResult) {
        Intrinsics.checkNotNullParameter(transferInitResult, "");
        MoneyView moneyView = transferInitResult.PlaceComponentResult;
        MoneyViewModel BuiltInFictitiousFunctionClassFactory = moneyView != null ? BuiltInFictitiousFunctionClassFactory(moneyView) : new MoneyViewModel(null, null, null, 7, null);
        MoneyView moneyView2 = transferInitResult.getAuthRequestContext;
        MoneyViewModel BuiltInFictitiousFunctionClassFactory2 = moneyView2 != null ? BuiltInFictitiousFunctionClassFactory(moneyView2) : new MoneyViewModel(null, null, null, 7, null);
        MoneyView moneyView3 = transferInitResult.KClassImpl$Data$declaredNonStaticMembers$2;
        MoneyViewModel BuiltInFictitiousFunctionClassFactory3 = moneyView3 != null ? BuiltInFictitiousFunctionClassFactory(moneyView3) : new MoneyViewModel(null, null, null, 7, null);
        TransferUserInfo transferUserInfo = transferInitResult.BuiltInFictitiousFunctionClassFactory;
        TransferUserInfoModel KClassImpl$Data$declaredNonStaticMembers$2 = transferUserInfo != null ? KClassImpl$Data$declaredNonStaticMembers$2(transferUserInfo) : new TransferUserInfoModel(null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, false, false, null, false, null, 4194303, null);
        TransferUserInfo transferUserInfo2 = transferInitResult.MyBillsEntityDataFactory;
        return new TransferInitResultModel(BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory3, KClassImpl$Data$declaredNonStaticMembers$2, transferUserInfo2 != null ? KClassImpl$Data$declaredNonStaticMembers$2(transferUserInfo2) : new TransferUserInfoModel(null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, false, false, null, false, null, 4194303, null));
    }

    private static TransferUserInfoModel KClassImpl$Data$declaredNonStaticMembers$2(TransferUserInfo transferUserInfo) {
        Intrinsics.checkNotNullParameter(transferUserInfo, "");
        String str = transferUserInfo.NetworkUserEntityData$$ExternalSyntheticLambda5;
        String str2 = str == null ? "" : str;
        String str3 = transferUserInfo.initRecordTimeStamp;
        String str4 = str3 == null ? "" : str3;
        String str5 = transferUserInfo.NetworkUserEntityData$$ExternalSyntheticLambda2;
        String str6 = str5 == null ? "" : str5;
        String str7 = transferUserInfo.NetworkUserEntityData$$ExternalSyntheticLambda7;
        String str8 = str7 == null ? "" : str7;
        String str9 = transferUserInfo.getErrorConfigVersion;
        String str10 = str9 == null ? "" : str9;
        String str11 = transferUserInfo.lookAheadTest;
        String str12 = str11 == null ? "" : str11;
        Boolean bool = transferUserInfo.moveToNextValue;
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        MoneyView moneyView = transferUserInfo.getAuthRequestContext;
        MoneyViewModel BuiltInFictitiousFunctionClassFactory = moneyView != null ? BuiltInFictitiousFunctionClassFactory(moneyView) : new MoneyViewModel(null, null, null, 7, null);
        MoneyView moneyView2 = transferUserInfo.DatabaseTableConfigUtil;
        MoneyViewModel BuiltInFictitiousFunctionClassFactory2 = moneyView2 != null ? BuiltInFictitiousFunctionClassFactory(moneyView2) : new MoneyViewModel(null, null, null, 7, null);
        MoneyView moneyView3 = transferUserInfo.PrepareContext;
        MoneyViewModel BuiltInFictitiousFunctionClassFactory3 = moneyView3 != null ? BuiltInFictitiousFunctionClassFactory(moneyView3) : new MoneyViewModel(null, null, null, 7, null);
        MoneyView moneyView4 = transferUserInfo.GetContactSyncConfig;
        MoneyViewModel BuiltInFictitiousFunctionClassFactory4 = moneyView4 != null ? BuiltInFictitiousFunctionClassFactory(moneyView4) : new MoneyViewModel(null, null, null, 7, null);
        String str13 = transferUserInfo.KClassImpl$Data$declaredNonStaticMembers$2;
        String str14 = str13 == null ? "" : str13;
        String str15 = transferUserInfo.isLayoutRequested;
        String str16 = str15 == null ? "" : str15;
        String str17 = transferUserInfo.NetworkUserEntityData$$ExternalSyntheticLambda8;
        String str18 = str17 == null ? "" : str17;
        String str19 = transferUserInfo.scheduleImpl;
        String str20 = str19 == null ? "" : str19;
        String str21 = transferUserInfo.NetworkUserEntityData$$ExternalSyntheticLambda0;
        String str22 = str21 == null ? "" : str21;
        String str23 = transferUserInfo.NetworkUserEntityData$$ExternalSyntheticLambda1;
        String str24 = str23 == null ? "" : str23;
        Boolean bool2 = transferUserInfo.FragmentBottomSheetPaymentSettingBinding;
        boolean booleanValue2 = bool2 != null ? bool2.booleanValue() : false;
        Boolean bool3 = transferUserInfo.BuiltInFictitiousFunctionClassFactory;
        boolean booleanValue3 = bool3 != null ? bool3.booleanValue() : false;
        String str25 = transferUserInfo.MyBillsEntityDataFactory;
        String str26 = str25 == null ? "" : str25;
        Boolean bool4 = transferUserInfo.PlaceComponentResult;
        boolean booleanValue4 = bool4 != null ? bool4.booleanValue() : false;
        MoneyView moneyView5 = transferUserInfo.newProxyInstance;
        return new TransferUserInfoModel(str2, str4, str6, str8, str10, str12, booleanValue, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory3, BuiltInFictitiousFunctionClassFactory4, str14, str16, str18, str20, str22, str24, booleanValue2, booleanValue3, str26, booleanValue4, moneyView5 != null ? BuiltInFictitiousFunctionClassFactory(moneyView5) : new MoneyViewModel(null, null, null, 7, null));
    }
}
