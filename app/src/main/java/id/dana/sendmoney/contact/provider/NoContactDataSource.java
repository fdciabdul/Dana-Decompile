package id.dana.sendmoney.contact.provider;

import androidx.paging.PositionalDataSource;
import id.dana.sendmoney.model.RecipientViewModel;
import java.util.List;

/* loaded from: classes5.dex */
public class NoContactDataSource extends PositionalDataSource<RecipientViewModel> {
    private final List<RecipientViewModel> getAuthRequestContext;

    @Override // androidx.paging.PositionalDataSource
    public final void getAuthRequestContext(PositionalDataSource.LoadRangeParams loadRangeParams, PositionalDataSource.LoadRangeCallback<RecipientViewModel> loadRangeCallback) {
    }

    public NoContactDataSource(List<RecipientViewModel> list) {
        this.getAuthRequestContext = list;
    }

    @Override // androidx.paging.PositionalDataSource
    public final void MyBillsEntityDataFactory(PositionalDataSource.LoadInitialParams loadInitialParams, PositionalDataSource.LoadInitialCallback<RecipientViewModel> loadInitialCallback) {
        loadInitialCallback.PlaceComponentResult(this.getAuthRequestContext, 0);
    }
}
