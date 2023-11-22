package id.dana.sendmoney_v2.recipient.decorator;

import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.decorator.recipient.Recipient;
import id.dana.sendmoney.recipient.decorator.recipient.RecipientDecorator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/sendmoney_v2/recipient/decorator/SectionDecorator;", "Lid/dana/sendmoney/recipient/decorator/recipient/RecipientDecorator;", "", "Lid/dana/sendmoney/model/RecipientViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;", "getAuthRequestContext", "Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;", "p0", "", "p1", "", "p2", "", "p3", "<init>", "(Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;IZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SectionDecorator extends RecipientDecorator {
    private Recipient getAuthRequestContext;

    public SectionDecorator(Recipient recipient, int i, boolean z, String str) {
        Intrinsics.checkNotNullParameter(recipient, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.getAuthRequestContext = recipient;
        if (z) {
            KClassImpl$Data$declaredNonStaticMembers$2(new RecipientViewModel(i, str));
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
