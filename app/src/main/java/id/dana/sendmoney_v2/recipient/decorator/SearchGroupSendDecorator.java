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

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/sendmoney_v2/recipient/decorator/SearchGroupSendDecorator;", "Lid/dana/sendmoney/recipient/decorator/recipient/RecipientDecorator;", "", "Lid/dana/sendmoney/model/RecipientViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;", "BuiltInFictitiousFunctionClassFactory", "p0", "", "Lid/dana/sendmoney/model/RecentRecipientModel;", "p1", "", "p2", "<init>", "(Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchGroupSendDecorator extends RecipientDecorator {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Recipient BuiltInFictitiousFunctionClassFactory;

    public SearchGroupSendDecorator(Recipient recipient, List<? extends RecentRecipientModel> list, String str) {
        Intrinsics.checkNotNullParameter(recipient, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.BuiltInFictitiousFunctionClassFactory = recipient;
        String str2 = str;
        if ((str2.length() > 0) && list.isEmpty()) {
            KClassImpl$Data$declaredNonStaticMembers$2(new RecipientViewModel(22));
            return;
        }
        if (str2.length() == 0) {
            KClassImpl$Data$declaredNonStaticMembers$2(new RecipientViewModel(22));
            return;
        }
        List<? extends RecipientViewModel> apply = new RecentRecipientToRecipientViewModelMapper().apply(list);
        Intrinsics.checkNotNullExpressionValue(apply, "");
        List<RecipientViewModel> mutableList = CollectionsKt.toMutableList((Collection) apply);
        if ((!mutableList.isEmpty()) != false) {
            mutableList.add(0, new RecipientViewModel(26));
        }
        getAuthRequestContext(mutableList);
    }

    @Override // id.dana.sendmoney.recipient.decorator.recipient.Recipient
    public final List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2() {
        List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        List<RecipientViewModel> list = this.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(list, "");
        KClassImpl$Data$declaredNonStaticMembers$2.addAll(list);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
