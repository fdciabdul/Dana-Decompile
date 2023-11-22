package id.dana.sendmoney.model;

import id.dana.domain.bank.model.UserBank;
import id.dana.requestmoney.model.UserBankModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.recipient.RecipientType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0006\u001a\u0006*\u00020\u00050\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\b\u001a\u00020\f*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\r\u001a\u0011\u0010\u000f\u001a\u00020\u000e*\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"", "p0", "Lid/dana/sendmoney/model/RecentRecipientModel;", "p1", "p2", "Lid/dana/sendmoney/model/RecipientModel;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Lid/dana/sendmoney/model/RecentRecipientModel;Ljava/lang/String;)Lid/dana/sendmoney/model/RecipientModel;", "getAuthRequestContext", "(Lid/dana/sendmoney/model/RecipientModel;)Lid/dana/sendmoney/model/RecentRecipientModel;", "Lid/dana/sendmoney/model/BankModel;", "Lid/dana/sendmoney/model/WithdrawNameCheckModel;", "Lid/dana/domain/bank/model/UserBank;", "(Lid/dana/sendmoney/model/BankModel;Lid/dana/sendmoney/model/WithdrawNameCheckModel;)Lid/dana/domain/bank/model/UserBank;", "Lid/dana/requestmoney/model/UserBankModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/model/BankModel;)Lid/dana/requestmoney/model/UserBankModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecipientModelExtKt {
    public static final RecentRecipientModel getAuthRequestContext(RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        RecentRecipientModel recentRecipientModel = new RecentRecipientModel();
        recentRecipientModel.isLayoutRequested = Intrinsics.areEqual(recipientModel.readMicros, RecipientType.GROUP_CONTACT) ? 7 : 1;
        recentRecipientModel.scheduleImpl = recipientModel.PlaceComponentResult();
        recentRecipientModel.getAuthRequestContext = recipientModel.getAuthRequestContext;
        recentRecipientModel.BuiltInFictitiousFunctionClassFactory = recipientModel.BuiltInFictitiousFunctionClassFactory;
        recentRecipientModel.getErrorConfigVersion = recipientModel.getErrorConfigVersion;
        recentRecipientModel.KClassImpl$Data$declaredNonStaticMembers$2(recipientModel.FragmentBottomSheetPaymentSettingBinding);
        recentRecipientModel.PlaceComponentResult = recipientModel.BuiltInFictitiousFunctionClassFactory();
        recentRecipientModel.initRecordTimeStamp = recipientModel.initRecordTimeStamp;
        recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
        recentRecipientModel.DatabaseTableConfigUtil = recipientModel.DatabaseTableConfigUtil;
        recentRecipientModel.MyBillsEntityDataFactory(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda8);
        recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
        recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        recentRecipientModel.lookAheadTest = recipientModel.getErrorConfigVersion();
        recentRecipientModel.getAuthRequestContext(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda5);
        recentRecipientModel.moveToNextValue = recipientModel.moveToNextValue;
        return recentRecipientModel;
    }

    public static final RecipientModel MyBillsEntityDataFactory(String str, RecentRecipientModel recentRecipientModel, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(recentRecipientModel, "");
        Intrinsics.checkNotNullParameter(str2, "");
        RecipientModel.Builder builder = new RecipientModel.Builder(str);
        builder.PlaceComponentResult = recentRecipientModel.getAuthRequestContext;
        builder.PrepareContext = str2;
        builder.scheduleImpl = recentRecipientModel.KClassImpl$Data$declaredNonStaticMembers$2();
        builder.initRecordTimeStamp = recentRecipientModel.PlaceComponentResult();
        builder.GetContactSyncConfig = recentRecipientModel.getErrorConfigVersion;
        String BuiltInFictitiousFunctionClassFactory = recentRecipientModel.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = "";
        }
        builder.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda3 = recentRecipientModel.initRecordTimeStamp;
        builder.lookAheadTest = recentRecipientModel.BuiltInFictitiousFunctionClassFactory;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
        builder.DatabaseTableConfigUtil = recentRecipientModel.DatabaseTableConfigUtil;
        builder.getAuthRequestContext = recentRecipientModel.getAuthRequestContext();
        builder.FragmentBottomSheetPaymentSettingBinding = recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
        builder.moveToNextValue = recentRecipientModel.getErrorConfigVersion();
        builder.isLayoutRequested = recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda0();
        builder.newProxyInstance = Intrinsics.areEqual(str, "contact") ? RecipientSource.ALL_CONTACTS : "";
        return builder.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final UserBank getAuthRequestContext(BankModel bankModel, WithdrawNameCheckModel withdrawNameCheckModel) {
        String str;
        Intrinsics.checkNotNullParameter(bankModel, "");
        Intrinsics.checkNotNullParameter(withdrawNameCheckModel, "");
        String str2 = withdrawNameCheckModel.KClassImpl$Data$declaredNonStaticMembers$2;
        String str3 = str2 == null ? "" : str2;
        CardHolderModel cardHolderModel = withdrawNameCheckModel.BuiltInFictitiousFunctionClassFactory;
        if (cardHolderModel != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(cardHolderModel.getAuthRequestContext);
            sb.append(" ");
            sb.append(cardHolderModel.KClassImpl$Data$declaredNonStaticMembers$2);
            str = sb.toString();
        } else {
            str = null;
        }
        String str4 = str == null ? "" : str;
        String str5 = withdrawNameCheckModel.MyBillsEntityDataFactory;
        String str6 = str5 == null ? "" : str5;
        String str7 = bankModel.lookAheadTest;
        String str8 = str7 == null ? "" : str7;
        String str9 = bankModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
        String str10 = str9 == null ? "" : str9;
        String str11 = bankModel.initRecordTimeStamp;
        String str12 = str11 == null ? "" : str11;
        String str13 = bankModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        return new UserBank(str3, str4, str6, str8, str10, str12, str13 == null ? "" : str13);
    }

    public static final UserBankModel BuiltInFictitiousFunctionClassFactory(BankModel bankModel) {
        Intrinsics.checkNotNullParameter(bankModel, "");
        String str = bankModel.KClassImpl$Data$declaredNonStaticMembers$2;
        String str2 = str == null ? "" : str;
        String str3 = bankModel.newProxyInstance;
        String str4 = str3 == null ? "" : str3;
        String str5 = bankModel.PlaceComponentResult;
        String str6 = str5 == null ? "" : str5;
        String str7 = bankModel.lookAheadTest;
        String str8 = str7 == null ? "" : str7;
        String str9 = bankModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
        String str10 = str9 == null ? "" : str9;
        String str11 = bankModel.initRecordTimeStamp;
        String str12 = str11 == null ? "" : str11;
        String str13 = bankModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        return new UserBankModel(str2, str4, str6, str8, str10, str12, str13 == null ? "" : str13);
    }
}
