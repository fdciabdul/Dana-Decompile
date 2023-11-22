package id.dana.contract.nearbyme;

import android.location.Location;
import id.dana.contract.nearbyme.NewNearbyMeContract;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithRadius;
import id.dana.domain.nearbyme.model.NearbyAutoSearchConfig;
import id.dana.domain.nearbyme.model.ShopsPage;
import id.dana.nearbyme.model.SearchConfigModel;
import id.dana.utils.ErrorUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes8.dex */
public final /* synthetic */ class NewNearbyPresenter$$ExternalSyntheticLambda24 implements Function1 {
    public final /* synthetic */ NewNearbyPresenter MyBillsEntityDataFactory;

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        final NewNearbyPresenter newNearbyPresenter = this.MyBillsEntityDataFactory;
        SearchConfigModel.Companion companion = SearchConfigModel.INSTANCE;
        final SearchConfigModel PlaceComponentResult = SearchConfigModel.Companion.PlaceComponentResult((NearbyAutoSearchConfig) obj);
        if (PlaceComponentResult.getEnabled()) {
            PublishSubject<Location> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
            newNearbyPresenter.DatabaseTableConfigUtil = PlaceComponentResult2;
            newNearbyPresenter.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(PlaceComponentResult2.debounce(PlaceComponentResult.getInterval(), TimeUnit.MILLISECONDS).filter(new Predicate() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda28
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj2) {
                    return NewNearbyPresenter.this.MyBillsEntityDataFactory(PlaceComponentResult, (Location) obj2);
                }
            }).map(new Function() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda29
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj2) {
                    Location location = (Location) obj2;
                    NewNearbyPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = location;
                    return location;
                }
            }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda30
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj2) {
                    final NewNearbyPresenter newNearbyPresenter2 = NewNearbyPresenter.this;
                    newNearbyPresenter2.NetworkUserEntityData$$ExternalSyntheticLambda8.showProgress();
                    newNearbyPresenter2.scheduleImpl.get().executeJava1(new GetNearbyShopsWithRadius.Params((Location) obj2, 3000, 1, 7, false, false, "", ""), new Function1() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            NewNearbyPresenter newNearbyPresenter3 = NewNearbyPresenter.this;
                            newNearbyPresenter3.NetworkUserEntityData$$ExternalSyntheticLambda8.dismissProgress();
                            newNearbyPresenter3.NetworkUserEntityData$$ExternalSyntheticLambda1.onNext(newNearbyPresenter3.initRecordTimeStamp.get().apply((ShopsPage) obj3).MyBillsEntityDataFactory);
                            return Unit.INSTANCE;
                        }
                    }, new Function1() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            NewNearbyPresenter newNearbyPresenter3 = NewNearbyPresenter.this;
                            newNearbyPresenter3.NetworkUserEntityData$$ExternalSyntheticLambda8.dismissProgress();
                            newNearbyPresenter3.NetworkUserEntityData$$ExternalSyntheticLambda8.onError(ErrorUtil.PlaceComponentResult((Throwable) obj3, newNearbyPresenter3.PlaceComponentResult));
                            NewNearbyMeContract.View view = newNearbyPresenter3.NetworkUserEntityData$$ExternalSyntheticLambda8;
                            return newNearbyPresenter3.NetworkUserEntityData$$ExternalSyntheticLambda8.BuiltInFictitiousFunctionClassFactory();
                        }
                    }, newNearbyPresenter2.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2());
                }
            }));
        }
        return Unit.INSTANCE;
    }
}
