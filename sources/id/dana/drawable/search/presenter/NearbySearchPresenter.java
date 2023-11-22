package id.dana.drawable.search.presenter;

import id.dana.domain.nearbysearch.interactor.GetNearbyTrendingKeyword;
import id.dana.domain.nearbysearch.model.NearbyTrendingKeyword;
import id.dana.drawable.search.NearbySearchContract;
import id.dana.drawable.search.mapper.NearbyTrendingKeywordMapperKt;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/nearbyrevamp/search/presenter/NearbySearchPresenter;", "Lid/dana/nearbyrevamp/search/NearbySearchContract$Presenter;", "", "MyBillsEntityDataFactory", "()V", "onDestroy", "Lid/dana/domain/nearbysearch/interactor/GetNearbyTrendingKeyword;", "PlaceComponentResult", "Lid/dana/domain/nearbysearch/interactor/GetNearbyTrendingKeyword;", "Lid/dana/nearbyrevamp/search/NearbySearchContract$View;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyrevamp/search/NearbySearchContract$View;", "p0", "p1", "<init>", "(Lid/dana/nearbyrevamp/search/NearbySearchContract$View;Lid/dana/domain/nearbysearch/interactor/GetNearbyTrendingKeyword;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbySearchPresenter implements NearbySearchContract.Presenter {
    private final NearbySearchContract.View BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetNearbyTrendingKeyword MyBillsEntityDataFactory;

    @Inject
    public NearbySearchPresenter(NearbySearchContract.View view, GetNearbyTrendingKeyword getNearbyTrendingKeyword) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getNearbyTrendingKeyword, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.MyBillsEntityDataFactory = getNearbyTrendingKeyword;
    }

    @Override // id.dana.nearbyrevamp.search.NearbySearchContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory.execute(Unit.INSTANCE, new Function1<List<? extends NearbyTrendingKeyword>, Unit>() { // from class: id.dana.nearbyrevamp.search.presenter.NearbySearchPresenter$getNearbyTrendingKeyword$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends NearbyTrendingKeyword> list) {
                invoke2((List<NearbyTrendingKeyword>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<NearbyTrendingKeyword> list) {
                NearbySearchContract.View view;
                NearbySearchContract.View view2;
                Intrinsics.checkNotNullParameter(list, "");
                if ((!list.isEmpty()) != false) {
                    view2 = NearbySearchPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    view2.getAuthRequestContext(NearbyTrendingKeywordMapperKt.BuiltInFictitiousFunctionClassFactory(list));
                    return;
                }
                view = NearbySearchPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.BuiltInFictitiousFunctionClassFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.nearbyrevamp.search.presenter.NearbySearchPresenter$getNearbyTrendingKeyword$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                NearbySearchContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = NearbySearchPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
    }
}
