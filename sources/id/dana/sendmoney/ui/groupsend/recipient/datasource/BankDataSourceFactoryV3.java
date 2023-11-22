package id.dana.sendmoney.ui.groupsend.recipient.datasource;

import androidx.paging.PagingSource;
import id.dana.sendmoney.ui.groupsend.recipient.model.RecentBankModel;
import id.dana.sendmoney.ui.groupsend.recipient.model.Recipient;
import id.dana.sendmoney.ui.groupsend.recipient.model.decorator.BankDecorator;
import id.dana.sendmoney.ui.groupsend.recipient.model.decorator.SearchDecorator;
import id.dana.sendmoney.ui.groupsend.recipient.model.decorator.SectionDecorator;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/datasource/BankDataSourceFactoryV3;", "Lid/dana/sendmoney/ui/groupsend/recipient/datasource/RecipientDataSourceFactoryV3;", "Landroidx/paging/PagingSource;", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "PlaceComponentResult", "()Landroidx/paging/PagingSource;", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/RecentBankModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class BankDataSourceFactoryV3 extends RecipientDataSourceFactoryV3 {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<RecentBankModel> getAuthRequestContext = CollectionsKt.emptyList();

    @Override // id.dana.sendmoney.ui.groupsend.recipient.datasource.RecipientDataSourceFactoryV3
    public final PagingSource<Integer, RecipientViewModel> PlaceComponentResult() {
        return new NoContactDataSourceV3(new BankDecorator(new SectionDecorator(new SearchDecorator(new Recipient(), false), 10, false, getBuiltInFictitiousFunctionClassFactory()), this.getAuthRequestContext, getMyBillsEntityDataFactory(), getBuiltInFictitiousFunctionClassFactory()).MyBillsEntityDataFactory());
    }
}
