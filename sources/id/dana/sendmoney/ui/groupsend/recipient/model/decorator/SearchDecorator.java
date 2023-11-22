package id.dana.sendmoney.ui.groupsend.recipient.model.decorator;

import id.dana.sendmoney.ui.groupsend.recipient.model.Recipient;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/model/decorator/SearchDecorator;", "Lid/dana/sendmoney/ui/groupsend/recipient/model/decorator/RecipientDecorator;", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "MyBillsEntityDataFactory", "()Ljava/util/List;", "Lid/dana/sendmoney/ui/groupsend/recipient/model/Recipient;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/ui/groupsend/recipient/model/Recipient;", "p0", "", "p1", "<init>", "(Lid/dana/sendmoney/ui/groupsend/recipient/model/Recipient;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchDecorator extends RecipientDecorator {
    public final Recipient BuiltInFictitiousFunctionClassFactory;

    public SearchDecorator(Recipient recipient, boolean z) {
        Intrinsics.checkNotNullParameter(recipient, "");
        this.BuiltInFictitiousFunctionClassFactory = recipient;
        if (z) {
            MyBillsEntityDataFactory(new RecipientViewModel(7));
        }
    }

    @Override // id.dana.sendmoney.ui.groupsend.recipient.model.Recipient
    public final List<RecipientViewModel> MyBillsEntityDataFactory() {
        List<RecipientViewModel> MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(this.getAuthRequestContext, "");
        if ((!r1.isEmpty()) != false) {
            List<RecipientViewModel> list = this.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(list, "");
            MyBillsEntityDataFactory.addAll(list);
        }
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }
}
