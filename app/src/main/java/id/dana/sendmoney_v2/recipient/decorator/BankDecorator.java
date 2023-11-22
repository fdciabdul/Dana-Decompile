package id.dana.sendmoney_v2.recipient.decorator;

import id.dana.R;
import id.dana.data.util.NumberUtils;
import id.dana.sendmoney.mapper.BankToRecipientViewModelMapper;
import id.dana.sendmoney.model.RecentBankModel;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.decorator.recipient.Recipient;
import id.dana.sendmoney.recipient.decorator.recipient.RecipientDecorator;
import id.dana.sendmoney_v2.recipient.model.EmptyStateViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0004\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/sendmoney_v2/recipient/decorator/BankDecorator;", "Lid/dana/sendmoney/recipient/decorator/recipient/RecipientDecorator;", "", "Lid/dana/sendmoney/model/RecipientViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;", "getAuthRequestContext", "Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;", "p0", "", "Lid/dana/sendmoney/model/RecentBankModel;", "p1", "", "p2", "", "p3", "<init>", "(Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;Ljava/util/List;ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BankDecorator extends RecipientDecorator {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Recipient KClassImpl$Data$declaredNonStaticMembers$2;

    public BankDecorator(Recipient recipient, List<RecentBankModel> list, boolean z, String str) {
        Intrinsics.checkNotNullParameter(recipient, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recipient;
        if (NumberUtils.isValidShowAccountNumber(str)) {
            KClassImpl$Data$declaredNonStaticMembers$2(new RecipientViewModel(12, str));
        } else if (z && list.isEmpty()) {
            KClassImpl$Data$declaredNonStaticMembers$2(new EmptyStateViewModel(18, R.drawable.ic_illustration_search_empty, R.string.recipient_not_found_title, R.string.recipient_not_found_desc, 0, false, 48, null));
        } else if (list.isEmpty()) {
            KClassImpl$Data$declaredNonStaticMembers$2(new EmptyStateViewModel(17, R.drawable.ic_illustration_recent_bank_empty, R.string.res_0x7f13015b_networkuserentitydata_externalsyntheticlambda0, R.string.bank_empty_desc, R.string.bank_empty_action_text, true));
        } else {
            getAuthRequestContext(new BankToRecipientViewModelMapper().apply(list));
        }
    }

    @Override // id.dana.sendmoney.recipient.decorator.recipient.Recipient
    public final List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2() {
        List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        List<RecipientViewModel> list = this.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(list, "");
        KClassImpl$Data$declaredNonStaticMembers$2.addAll(list);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
