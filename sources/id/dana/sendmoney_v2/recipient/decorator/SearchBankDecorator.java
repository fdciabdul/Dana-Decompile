package id.dana.sendmoney_v2.recipient.decorator;

import id.dana.data.util.NumberUtils;
import id.dana.sendmoney.mapper.BankToRecipientViewModelMapper;
import id.dana.sendmoney.model.RecentBankModel;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.decorator.recipient.Recipient;
import id.dana.sendmoney.recipient.decorator.recipient.RecipientDecorator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B%\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/sendmoney_v2/recipient/decorator/SearchBankDecorator;", "Lid/dana/sendmoney/recipient/decorator/recipient/RecipientDecorator;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Z", "", "Lid/dana/sendmoney/model/RecipientViewModel;", "()Ljava/util/List;", "Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;", "getAuthRequestContext", "Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;", "PlaceComponentResult", "", "Lid/dana/sendmoney/model/RecentBankModel;", "p1", "p2", "<init>", "(Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;Ljava/util/List;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchBankDecorator extends RecipientDecorator {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Recipient PlaceComponentResult;

    public SearchBankDecorator(Recipient recipient, List<RecentBankModel> list, String str) {
        Intrinsics.checkNotNullParameter(recipient, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.PlaceComponentResult = recipient;
        if (KClassImpl$Data$declaredNonStaticMembers$2(str)) {
            if (StringsKt.startsWith$default(str, "+", false, 2, (Object) null)) {
                KClassImpl$Data$declaredNonStaticMembers$2(new RecipientViewModel(18));
                return;
            }
            KClassImpl$Data$declaredNonStaticMembers$2(new RecipientViewModel(20));
            KClassImpl$Data$declaredNonStaticMembers$2(new RecipientViewModel(12, str));
            return;
        }
        String str2 = str;
        if ((str2.length() > 0) && list.isEmpty()) {
            KClassImpl$Data$declaredNonStaticMembers$2(new RecipientViewModel(22));
            return;
        }
        if (str2.length() == 0) {
            KClassImpl$Data$declaredNonStaticMembers$2(new RecipientViewModel(22));
            return;
        }
        BankToRecipientViewModelMapper bankToRecipientViewModelMapper = new BankToRecipientViewModelMapper();
        bankToRecipientViewModelMapper.BuiltInFictitiousFunctionClassFactory = true;
        List<RecipientViewModel> apply = bankToRecipientViewModelMapper.apply(list);
        Intrinsics.checkNotNullExpressionValue(apply, "");
        if ((!apply.isEmpty()) != false) {
            apply.add(0, new RecipientViewModel(20));
        }
        getAuthRequestContext(apply);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        return NumberUtils.isShowAccountNumber(p0) && p0.length() >= 4;
    }

    @Override // id.dana.sendmoney.recipient.decorator.recipient.Recipient
    public final List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2() {
        List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
        List<RecipientViewModel> list = this.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(list, "");
        KClassImpl$Data$declaredNonStaticMembers$2.addAll(list);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
