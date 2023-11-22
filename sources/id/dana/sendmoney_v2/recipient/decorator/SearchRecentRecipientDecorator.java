package id.dana.sendmoney_v2.recipient.decorator;

import id.dana.sendmoney.mapper.RecentRecipientToRecipientViewModelMapper;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.decorator.recipient.Recipient;
import id.dana.sendmoney.recipient.decorator.recipient.RecipientDecorator;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0007\u001a\u00020\u000b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/sendmoney_v2/recipient/decorator/SearchRecentRecipientDecorator;", "Lid/dana/sendmoney/recipient/decorator/recipient/RecipientDecorator;", "", "Lid/dana/sendmoney/model/RecipientViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)Z", "Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;", "", "Lid/dana/sendmoney/model/RecentRecipientModel;", "p1", "p2", "p3", "<init>", "(Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;Ljava/util/List;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchRecentRecipientDecorator extends RecipientDecorator {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Recipient KClassImpl$Data$declaredNonStaticMembers$2;

    public SearchRecentRecipientDecorator(Recipient recipient, List<? extends RecentRecipientModel> list, String str, boolean z) {
        Intrinsics.checkNotNullParameter(recipient, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recipient;
        if (getAuthRequestContext(str) && list.isEmpty() && z) {
            KClassImpl$Data$declaredNonStaticMembers$2(new RecipientViewModel(18));
            return;
        }
        int length = str.length();
        boolean z2 = true;
        if ((length > 0) && list.isEmpty()) {
            KClassImpl$Data$declaredNonStaticMembers$2(new RecipientViewModel(22));
            return;
        }
        List<? extends RecipientViewModel> apply = new RecentRecipientToRecipientViewModelMapper().apply(list);
        Intrinsics.checkNotNullExpressionValue(apply, "");
        List<RecipientViewModel> mutableList = CollectionsKt.toMutableList((Collection) apply);
        List<RecipientViewModel> list2 = mutableList;
        if (list2 != null && !list2.isEmpty()) {
            z2 = false;
        }
        if (!z2) {
            mutableList.add(0, new RecipientViewModel(23));
        }
        getAuthRequestContext(mutableList);
    }

    private static boolean getAuthRequestContext(String p0) {
        if (p0.length() == 0) {
            return false;
        }
        char charAt = p0.charAt(0);
        if ('a' <= charAt && charAt < '{') {
            return true;
        }
        char charAt2 = p0.charAt(0);
        return 'A' <= charAt2 && charAt2 < '[';
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
