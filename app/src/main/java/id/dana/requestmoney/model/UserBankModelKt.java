package id.dana.requestmoney.model;

import id.dana.domain.bank.model.UserBank;
import id.dana.domain.qrbarcode.interactor.GetBankTransferQr;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\n*\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/requestmoney/model/UserBankModel;", "", "p0", "p1", "Lid/dana/domain/qrbarcode/interactor/GetBankTransferQr$Params;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/requestmoney/model/UserBankModel;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/qrbarcode/interactor/GetBankTransferQr$Params;", "Lid/dana/domain/bank/model/UserBank;", "getAuthRequestContext", "(Lid/dana/requestmoney/model/UserBankModel;)Lid/dana/domain/bank/model/UserBank;", "", "PlaceComponentResult", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserBankModelKt {
    public static final List<UserBankModel> PlaceComponentResult(List<UserBank> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<UserBank> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (UserBank userBank : list2) {
            Intrinsics.checkNotNullParameter(userBank, "");
            arrayList.add(new UserBankModel(userBank.getBankAccountIndexNo(), userBank.getBankAccountHolderName(), userBank.getBankAccountFormattedMaskedNo(), userBank.getWithdrawInstId(), userBank.getWithdrawPayMethod(), userBank.getWithdrawPayOption(), userBank.getWithdrawInstLocalName()));
        }
        return arrayList;
    }

    public static final GetBankTransferQr.Params KClassImpl$Data$declaredNonStaticMembers$2(UserBankModel userBankModel, String str, String str2) {
        Intrinsics.checkNotNullParameter(userBankModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return new GetBankTransferQr.Params(str, str2, userBankModel.KClassImpl$Data$declaredNonStaticMembers$2, userBankModel.PlaceComponentResult, userBankModel.getAuthRequestContext, userBankModel.MyBillsEntityDataFactory, userBankModel.NetworkUserEntityData$$ExternalSyntheticLambda0, userBankModel.scheduleImpl, userBankModel.BuiltInFictitiousFunctionClassFactory);
    }

    public static final UserBank getAuthRequestContext(UserBankModel userBankModel) {
        Intrinsics.checkNotNullParameter(userBankModel, "");
        return new UserBank(userBankModel.KClassImpl$Data$declaredNonStaticMembers$2, userBankModel.PlaceComponentResult, userBankModel.getAuthRequestContext, userBankModel.MyBillsEntityDataFactory, userBankModel.NetworkUserEntityData$$ExternalSyntheticLambda0, userBankModel.scheduleImpl, userBankModel.BuiltInFictitiousFunctionClassFactory);
    }
}
