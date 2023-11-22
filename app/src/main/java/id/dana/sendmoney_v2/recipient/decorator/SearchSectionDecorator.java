package id.dana.sendmoney_v2.recipient.decorator;

import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.decorator.recipient.Recipient;
import id.dana.sendmoney.recipient.decorator.recipient.RecipientDecorator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\b\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0007"}, d2 = {"Lid/dana/sendmoney_v2/recipient/decorator/SearchSectionDecorator;", "Lid/dana/sendmoney/recipient/decorator/recipient/RecipientDecorator;", "", "Lid/dana/sendmoney/model/RecipientViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;", "Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;", "getAuthRequestContext", "p0", "", "p1", "<init>", "(Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchSectionDecorator extends RecipientDecorator {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Recipient getAuthRequestContext;

    public SearchSectionDecorator(Recipient recipient, boolean z) {
        Intrinsics.checkNotNullParameter(recipient, "");
        this.getAuthRequestContext = recipient;
        if (z) {
            KClassImpl$Data$declaredNonStaticMembers$2(new RecipientViewModel(7));
        }
    }

    @Override // id.dana.sendmoney.recipient.decorator.recipient.Recipient
    public final List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2() {
        List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(this.PlaceComponentResult, "");
        if ((!r1.isEmpty()) != false) {
            List<RecipientViewModel> list = this.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(list, "");
            KClassImpl$Data$declaredNonStaticMembers$2.addAll(list);
        }
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
