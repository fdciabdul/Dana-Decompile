package id.dana.sendmoney.ui.groupsend.recipient.datasource;

import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/datasource/NoContactDataSourceV3;", "Landroidx/paging/PagingSource;", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "Landroidx/paging/PagingSource$LoadParams;", "p0", "Landroidx/paging/PagingSource$LoadResult;", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "PlaceComponentResult", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NoContactDataSourceV3 extends PagingSource<Integer, RecipientViewModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final List<RecipientViewModel> PlaceComponentResult;

    @Override // androidx.paging.PagingSource
    public final /* synthetic */ Integer PlaceComponentResult(PagingState<Integer, RecipientViewModel> pagingState) {
        Intrinsics.checkNotNullParameter(pagingState, "");
        return pagingState.PlaceComponentResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NoContactDataSourceV3(List<? extends RecipientViewModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.PlaceComponentResult = list;
    }

    @Override // androidx.paging.PagingSource
    public final Object BuiltInFictitiousFunctionClassFactory(PagingSource.LoadParams<Integer> loadParams, Continuation<? super PagingSource.LoadResult<Integer, RecipientViewModel>> continuation) {
        return new PagingSource.LoadResult.Page(this.PlaceComponentResult, null);
    }
}
