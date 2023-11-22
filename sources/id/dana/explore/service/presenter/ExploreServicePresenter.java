package id.dana.explore.service.presenter;

import id.dana.base.AbstractContractKt;
import id.dana.domain.core.usecase.NoParams;
import id.dana.explore.domain.sku.interactor.GetCategoryExploreDana;
import id.dana.explore.domain.sku.model.ExploreServiceModel;
import id.dana.explore.service.ExploreServiceContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/explore/service/presenter/ExploreServicePresenter;", "Lid/dana/explore/service/ExploreServiceContract$Presenter;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Lid/dana/explore/domain/sku/interactor/GetCategoryExploreDana;", "Lid/dana/explore/domain/sku/interactor/GetCategoryExploreDana;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/explore/service/ExploreServiceContract$View;", "PlaceComponentResult", "Lid/dana/explore/service/ExploreServiceContract$View;", "p0", "p1", "<init>", "(Lid/dana/explore/domain/sku/interactor/GetCategoryExploreDana;Lid/dana/explore/service/ExploreServiceContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExploreServicePresenter implements ExploreServiceContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetCategoryExploreDana KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ExploreServiceContract.View BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final /* synthetic */ void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Inject
    public ExploreServicePresenter(GetCategoryExploreDana getCategoryExploreDana, ExploreServiceContract.View view) {
        Intrinsics.checkNotNullParameter(getCategoryExploreDana, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getCategoryExploreDana;
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Override // id.dana.explore.service.ExploreServiceContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function1<List<? extends ExploreServiceModel>, Unit>() { // from class: id.dana.explore.service.presenter.ExploreServicePresenter$getExploreService$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ExploreServiceModel> list) {
                invoke2((List<ExploreServiceModel>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<ExploreServiceModel> list) {
                ExploreServiceContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                view = ExploreServicePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.onGetExploreService(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.explore.service.presenter.ExploreServicePresenter$getExploreService$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_EXPLORE_SERVICE, th.getMessage());
            }
        });
    }
}
