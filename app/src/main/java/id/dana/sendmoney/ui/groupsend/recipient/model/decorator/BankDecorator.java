package id.dana.sendmoney.ui.groupsend.recipient.model.decorator;

import id.dana.data.util.NumberUtils;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.groupsend.recipient.mapper.BankToRecipientViewModelMapper;
import id.dana.sendmoney.ui.groupsend.recipient.model.RecentBankModel;
import id.dana.sendmoney.ui.groupsend.recipient.model.Recipient;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.EmptyStateViewModel;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B-\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/model/decorator/BankDecorator;", "Lid/dana/sendmoney/ui/groupsend/recipient/model/decorator/RecipientDecorator;", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "MyBillsEntityDataFactory", "()Ljava/util/List;", "Lid/dana/sendmoney/ui/groupsend/recipient/model/Recipient;", "PlaceComponentResult", "Lid/dana/sendmoney/ui/groupsend/recipient/model/Recipient;", "getAuthRequestContext", "p0", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/RecentBankModel;", "p1", "", "p2", "", "p3", "<init>", "(Lid/dana/sendmoney/ui/groupsend/recipient/model/Recipient;Ljava/util/List;ZLjava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class BankDecorator extends RecipientDecorator {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Recipient getAuthRequestContext;

    public BankDecorator(Recipient recipient, List<RecentBankModel> list, boolean z, String str) {
        Intrinsics.checkNotNullParameter(recipient, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.getAuthRequestContext = recipient;
        if (NumberUtils.isValidShowAccountNumber(str)) {
            MyBillsEntityDataFactory(new RecipientViewModel(12, str));
        } else if (z && list.isEmpty()) {
            MyBillsEntityDataFactory(new EmptyStateViewModel(18, R.drawable.ic_illustration_search_empty, R.string.recipient_not_found_title, R.string.recipient_not_found_desc, 0, false, 48, null));
        } else if (list.isEmpty()) {
            MyBillsEntityDataFactory(new EmptyStateViewModel(17, R.drawable.ic_illustration_recent_bank_empty, R.string.res_0x7f13015b_networkuserentitydata_externalsyntheticlambda0, R.string.bank_empty_desc, R.string.bank_empty_action_text, true));
        } else {
            MyBillsEntityDataFactory(new BankToRecipientViewModelMapper().apply(list));
        }
    }

    @Override // id.dana.sendmoney.ui.groupsend.recipient.model.Recipient
    public final List<RecipientViewModel> MyBillsEntityDataFactory() {
        List<RecipientViewModel> MyBillsEntityDataFactory = this.getAuthRequestContext.MyBillsEntityDataFactory();
        List<RecipientViewModel> list = this.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(list, "");
        MyBillsEntityDataFactory.addAll(list);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }
}
