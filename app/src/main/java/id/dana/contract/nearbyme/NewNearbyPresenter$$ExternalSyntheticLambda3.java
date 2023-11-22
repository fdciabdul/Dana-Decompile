package id.dana.contract.nearbyme;

import id.dana.nearbyme.model.ShopModel;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.List;

/* loaded from: classes8.dex */
public final /* synthetic */ class NewNearbyPresenter$$ExternalSyntheticLambda3 implements Function3 {
    public final /* synthetic */ NewNearbyPresenter KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.functions.Function3
    public final Object apply(Object obj, Object obj2, Object obj3) {
        final NewNearbyPresenter newNearbyPresenter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        final String str = (String) obj;
        final List list = (List) obj2;
        Single list2 = Observable.fromIterable((List) obj3).filter(new Predicate() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj4) {
                boolean BuiltInFictitiousFunctionClassFactory;
                BuiltInFictitiousFunctionClassFactory = NewNearbyPresenter.BuiltInFictitiousFunctionClassFactory((ShopModel) obj4, str);
                return BuiltInFictitiousFunctionClassFactory;
            }
        }).filter(new Predicate() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj4) {
                boolean MyBillsEntityDataFactory;
                MyBillsEntityDataFactory = NewNearbyPresenter.MyBillsEntityDataFactory((ShopModel) obj4, list);
                return MyBillsEntityDataFactory;
            }
        }).toList();
        if (list2 instanceof FuseToObservable) {
            return ((FuseToObservable) list2).getAuthRequestContext();
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list2));
    }
}
