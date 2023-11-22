package id.dana.data.bank.model;

import id.dana.domain.bank.model.UserBank;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0006"}, d2 = {"", "Lid/dana/data/bank/model/UserConfigBankQrContent;", "", "Lid/dana/domain/bank/model/UserBank;", "PlaceComponentResult", "([Lid/dana/data/bank/model/UserConfigBankQrContent;)Ljava/util/List;", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserConfigBankQrContentKt {
    public static final List<UserConfigBankQrContent> PlaceComponentResult(List<UserBank> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<UserBank> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (UserBank userBank : list2) {
            Intrinsics.checkNotNullParameter(userBank, "");
            arrayList.add(new UserConfigBankQrContent(userBank.getBankAccountIndexNo(), userBank.getBankAccountHolderName(), userBank.getBankAccountFormattedMaskedNo(), userBank.getWithdrawInstId(), userBank.getWithdrawPayMethod(), userBank.getWithdrawPayOption(), userBank.getWithdrawInstLocalName()));
        }
        return arrayList;
    }

    public static final List<UserBank> PlaceComponentResult(UserConfigBankQrContent[] userConfigBankQrContentArr) {
        Intrinsics.checkNotNullParameter(userConfigBankQrContentArr, "");
        ArrayList arrayList = new ArrayList(userConfigBankQrContentArr.length);
        for (UserConfigBankQrContent userConfigBankQrContent : userConfigBankQrContentArr) {
            Intrinsics.checkNotNullParameter(userConfigBankQrContent, "");
            String bankAccountIndexNo = userConfigBankQrContent.getBankAccountIndexNo();
            String str = bankAccountIndexNo == null ? "" : bankAccountIndexNo;
            String bankAccountHolderName = userConfigBankQrContent.getBankAccountHolderName();
            String str2 = bankAccountHolderName == null ? "" : bankAccountHolderName;
            String bankAccountFormattedMaskedNo = userConfigBankQrContent.getBankAccountFormattedMaskedNo();
            String str3 = bankAccountFormattedMaskedNo == null ? "" : bankAccountFormattedMaskedNo;
            String withdrawInstId = userConfigBankQrContent.getWithdrawInstId();
            String str4 = withdrawInstId == null ? "" : withdrawInstId;
            String withdrawPayMethod = userConfigBankQrContent.getWithdrawPayMethod();
            String str5 = withdrawPayMethod == null ? "" : withdrawPayMethod;
            String withdrawPayOption = userConfigBankQrContent.getWithdrawPayOption();
            String str6 = withdrawPayOption == null ? "" : withdrawPayOption;
            String withdrawInstLocalName = userConfigBankQrContent.getWithdrawInstLocalName();
            arrayList.add(new UserBank(str, str2, str3, str4, str5, str6, withdrawInstLocalName == null ? "" : withdrawInstLocalName));
        }
        return arrayList;
    }
}
