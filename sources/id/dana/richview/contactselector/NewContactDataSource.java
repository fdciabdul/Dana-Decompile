package id.dana.richview.contactselector;

import androidx.paging.PageKeyedDataSource;
import id.dana.sendmoney.model.RecipientViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB/\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J1\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000b\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ1\u0010\u000b\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\rH\u0016¢\u0006\u0004\b\u000b\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0010\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/richview/contactselector/NewContactDataSource;", "Landroidx/paging/PageKeyedDataSource;", "", "Lid/dana/sendmoney/model/RecipientViewModel;", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "p0", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/PageKeyedDataSource$LoadParams;Landroidx/paging/PageKeyedDataSource$LoadCallback;)V", "PlaceComponentResult", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "(Landroidx/paging/PageKeyedDataSource$LoadInitialParams;Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;)V", "", "getAuthRequestContext", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "p2", "<init>", "(Ljava/util/List;Ljava/util/List;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewContactDataSource extends PageKeyedDataSource<Integer, RecipientViewModel> {
    private final List<RecipientViewModel> MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final boolean getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final List<RecipientViewModel> BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.paging.PageKeyedDataSource
    public final void PlaceComponentResult(PageKeyedDataSource.LoadParams<Integer> p0, PageKeyedDataSource.LoadCallback<Integer, RecipientViewModel> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
    }

    public /* synthetic */ NewContactDataSource(List list, ArrayList arrayList, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? new ArrayList() : arrayList, (i & 4) != 0 ? true : z);
    }

    private NewContactDataSource(List<RecipientViewModel> list, List<RecipientViewModel> list2, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        this.BuiltInFictitiousFunctionClassFactory = list;
        this.MyBillsEntityDataFactory = list2;
        this.getAuthRequestContext = z;
    }

    @Override // androidx.paging.PageKeyedDataSource
    public final void PlaceComponentResult(PageKeyedDataSource.LoadInitialParams<Integer> p0, PageKeyedDataSource.LoadInitialCallback<Integer, RecipientViewModel> p1) {
        int size;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (this.MyBillsEntityDataFactory.isEmpty() && this.getAuthRequestContext) {
            this.BuiltInFictitiousFunctionClassFactory.add(0, new RecipientViewModel(1));
        } else {
            for (RecipientViewModel recipientViewModel : this.MyBillsEntityDataFactory) {
                if (recipientViewModel.PrepareContext == 8) {
                    this.BuiltInFictitiousFunctionClassFactory.add(recipientViewModel);
                } else {
                    this.BuiltInFictitiousFunctionClassFactory.add(0, recipientViewModel);
                }
            }
        }
        if (this.BuiltInFictitiousFunctionClassFactory.size() > p0.PlaceComponentResult - 1) {
            size = p0.PlaceComponentResult - 1;
        } else {
            size = this.BuiltInFictitiousFunctionClassFactory.size();
        }
        p1.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.subList(0, size), 0, 3);
    }

    @Override // androidx.paging.PageKeyedDataSource
    public final void KClassImpl$Data$declaredNonStaticMembers$2(PageKeyedDataSource.LoadParams<Integer> p0, PageKeyedDataSource.LoadCallback<Integer, RecipientViewModel> p1) {
        int intValue;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (p0.MyBillsEntityDataFactory.intValue() * p0.KClassImpl$Data$declaredNonStaticMembers$2 > this.BuiltInFictitiousFunctionClassFactory.size()) {
            return;
        }
        if ((p0.MyBillsEntityDataFactory.intValue() + 1) * p0.KClassImpl$Data$declaredNonStaticMembers$2 > this.BuiltInFictitiousFunctionClassFactory.size()) {
            intValue = this.BuiltInFictitiousFunctionClassFactory.size();
        } else {
            intValue = (p0.MyBillsEntityDataFactory.intValue() + 1) * p0.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        p1.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.subList(p0.MyBillsEntityDataFactory.intValue() * p0.KClassImpl$Data$declaredNonStaticMembers$2, intValue), Integer.valueOf(p0.MyBillsEntityDataFactory.intValue() + 1));
    }
}
