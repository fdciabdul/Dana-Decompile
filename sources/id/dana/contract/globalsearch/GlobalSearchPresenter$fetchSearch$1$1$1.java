package id.dana.contract.globalsearch;

import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.globalsearch.model.SearchResultModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class GlobalSearchPresenter$fetchSearch$1$1$1 extends FunctionReferenceImpl implements Function1<SearchResultModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GlobalSearchPresenter$fetchSearch$1$1$1(Object obj) {
        super(1, obj, GlobalSearchContract.View.class, "onGetOfflineMerchantCategory", "onGetOfflineMerchantCategory(Lid/dana/globalsearch/model/SearchResultModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(SearchResultModel searchResultModel) {
        invoke2(searchResultModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SearchResultModel searchResultModel) {
        Intrinsics.checkNotNullParameter(searchResultModel, "");
        ((GlobalSearchContract.View) this.receiver).KClassImpl$Data$declaredNonStaticMembers$2(searchResultModel);
    }
}
