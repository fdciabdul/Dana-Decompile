package id.dana.sendmoney.ui.groupsend.recipient.datasource;

import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B%\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/datasource/ContactDataSourceV3;", "Landroidx/paging/PagingSource;", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "Landroidx/paging/PagingSource$LoadParams;", "p0", "Landroidx/paging/PagingSource$LoadResult;", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "MyBillsEntityDataFactory", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "p1", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactDataSourceV3 extends PagingSource<Integer, RecipientViewModel> {
    private final List<RecipientViewModel> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final List<RecipientViewModel> MyBillsEntityDataFactory;

    @Override // androidx.paging.PagingSource
    public final /* synthetic */ Integer PlaceComponentResult(PagingState<Integer, RecipientViewModel> pagingState) {
        Intrinsics.checkNotNullParameter(pagingState, "");
        return pagingState.PlaceComponentResult;
    }

    public ContactDataSourceV3(List<RecipientViewModel> list, List<RecipientViewModel> list2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        this.MyBillsEntityDataFactory = list;
        this.BuiltInFictitiousFunctionClassFactory = list2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    }

    @Override // androidx.paging.PagingSource
    public final Object BuiltInFictitiousFunctionClassFactory(PagingSource.LoadParams<Integer> loadParams, Continuation<? super PagingSource.LoadResult<Integer, RecipientViewModel>> continuation) {
        int size;
        if (loadParams.PlaceComponentResult() != null) {
            Integer PlaceComponentResult = loadParams.PlaceComponentResult();
            if (PlaceComponentResult != null) {
                int intValue = PlaceComponentResult.intValue();
                int i = loadParams.getAuthRequestContext * intValue;
                int i2 = intValue + 1;
                int i3 = loadParams.getAuthRequestContext * i2;
                if (i <= this.KClassImpl$Data$declaredNonStaticMembers$2.size()) {
                    if (i3 > this.KClassImpl$Data$declaredNonStaticMembers$2.size()) {
                        i3 = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
                    }
                    return new PagingSource.LoadResult.Page(this.KClassImpl$Data$declaredNonStaticMembers$2.subList(i, i3), Integer.valueOf(i2));
                }
                return new PagingSource.LoadResult.Page(new ArrayList(), null);
            }
            return new PagingSource.LoadResult.Page(new ArrayList(), null);
        }
        if (this.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.add(0, new RecipientViewModel(1));
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.addAll(this.MyBillsEntityDataFactory);
            for (RecipientViewModel recipientViewModel : this.BuiltInFictitiousFunctionClassFactory) {
                if (recipientViewModel.getSupportButtonTintMode == 8) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.add(recipientViewModel);
                } else {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.add(0, recipientViewModel);
                }
            }
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.size() <= loadParams.getAuthRequestContext - 1) {
            size = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
        } else {
            size = loadParams.getAuthRequestContext - 1;
        }
        return new PagingSource.LoadResult.Page(this.KClassImpl$Data$declaredNonStaticMembers$2.subList(0, size), 3);
    }
}
