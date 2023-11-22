package id.dana.nearbyme;

import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.merchant.MerchantCategoryType;
import id.dana.domain.merchant.interactor.CheckMerchantCategoriesFeature;
import id.dana.domain.merchant.interactor.GetMerchantCategories;
import id.dana.domain.merchant.interactor.GetNewMerchantCategories;
import id.dana.domain.merchant.interactor.InitNewMerchantCategories;
import id.dana.nearbyme.MerchantContract;
import id.dana.nearbyme.mapper.MerchantCategoriesMapper;
import id.dana.nearbyme.model.MerchantCategoryModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public class MerchantPresenter implements MerchantContract.Presenter {
    final MerchantCategoriesMapper KClassImpl$Data$declaredNonStaticMembers$2;
    final InitNewMerchantCategories MyBillsEntityDataFactory;
    private final GetMerchantCategories NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final CheckMerchantCategoriesFeature getErrorConfigVersion;
    private final GetNewMerchantCategories moveToNextValue;
    final MerchantContract.View scheduleImpl;
    PublishSubject<List<MerchantCategoryModel>> BuiltInFictitiousFunctionClassFactory = PublishSubject.PlaceComponentResult();
    PublishSubject<List<ShopModel>> getAuthRequestContext = PublishSubject.PlaceComponentResult();
    private final CompositeDisposable lookAheadTest = new CompositeDisposable();
    final List<ShopModel> PlaceComponentResult = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(Observable observable) throws Exception {
        return observable;
    }

    @Inject
    public MerchantPresenter(MerchantContract.View view, GetMerchantCategories getMerchantCategories, CheckMerchantCategoriesFeature checkMerchantCategoriesFeature, GetNewMerchantCategories getNewMerchantCategories, MerchantCategoriesMapper merchantCategoriesMapper, InitNewMerchantCategories initNewMerchantCategories) {
        this.scheduleImpl = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getMerchantCategories;
        this.moveToNextValue = getNewMerchantCategories;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantCategoriesMapper;
        this.getErrorConfigVersion = checkMerchantCategoriesFeature;
        this.MyBillsEntityDataFactory = initNewMerchantCategories;
    }

    @Override // id.dana.nearbyme.MerchantContract.Presenter
    public final void MyBillsEntityDataFactory() {
        Observable flatMap = Observable.combineLatest(this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, new BiFunction() { // from class: id.dana.nearbyme.MerchantPresenter$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                final MerchantPresenter merchantPresenter = MerchantPresenter.this;
                final List list = (List) obj2;
                Single list2 = Observable.fromIterable((List) obj).filter(new Predicate() { // from class: id.dana.nearbyme.MerchantPresenter$$ExternalSyntheticLambda8
                    @Override // io.reactivex.functions.Predicate
                    public final boolean test(Object obj3) {
                        boolean MyBillsEntityDataFactory;
                        MyBillsEntityDataFactory = MerchantPresenter.MyBillsEntityDataFactory((MerchantCategoryModel) obj3, list);
                        return MyBillsEntityDataFactory;
                    }
                }).toList();
                if (list2 instanceof FuseToObservable) {
                    return ((FuseToObservable) list2).getAuthRequestContext();
                }
                return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list2));
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).flatMap(new Function() { // from class: id.dana.nearbyme.MerchantPresenter$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantPresenter.MyBillsEntityDataFactory((Observable) obj);
            }
        });
        final MerchantContract.View view = this.scheduleImpl;
        Objects.requireNonNull(view);
        this.lookAheadTest.getAuthRequestContext(flatMap.subscribe(new Consumer() { // from class: id.dana.nearbyme.MerchantPresenter$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MerchantContract.View.this.onGetNewMerchantMapsCategories((List) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean MyBillsEntityDataFactory(MerchantCategoryModel merchantCategoryModel, List<ShopModel> list) {
        Iterator<ShopModel> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().BuiltInFictitiousFunctionClassFactory(merchantCategoryModel)) {
                return true;
            }
        }
        return false;
    }

    @Override // id.dana.nearbyme.MerchantContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.getErrorConfigVersion.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.nearbyme.MerchantPresenter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                final MerchantPresenter merchantPresenter = MerchantPresenter.this;
                Boolean bool = (Boolean) obj;
                merchantPresenter.scheduleImpl.onCheckMerchantFilterFeatureEnableSuccess(bool.booleanValue());
                if (bool.booleanValue()) {
                    merchantPresenter.MyBillsEntityDataFactory.execute(Unit.INSTANCE, new Function1() { // from class: id.dana.nearbyme.MerchantPresenter$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            MerchantPresenter merchantPresenter2 = MerchantPresenter.this;
                            Boolean bool2 = (Boolean) obj2;
                            merchantPresenter2.MyBillsEntityDataFactory(MerchantCategoryType.LIST);
                            merchantPresenter2.MyBillsEntityDataFactory(MerchantCategoryType.MAPS);
                            return Unit.INSTANCE;
                        }
                    }, new Function1() { // from class: id.dana.nearbyme.MerchantPresenter$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return MerchantPresenter.KClassImpl$Data$declaredNonStaticMembers$2((Throwable) obj2);
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.nearbyme.MerchantPresenter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Throwable th = (Throwable) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
    }

    @Override // id.dana.nearbyme.MerchantContract.Presenter
    public final void getAuthRequestContext() {
        this.scheduleImpl.showProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.nearbyme.MerchantPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                MerchantPresenter merchantPresenter = MerchantPresenter.this;
                merchantPresenter.scheduleImpl.dismissProgress();
                merchantPresenter.scheduleImpl.onGetMerchantCategories(merchantPresenter.KClassImpl$Data$declaredNonStaticMembers$2.apply((List) obj));
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.nearbyme.MerchantPresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                MerchantPresenter merchantPresenter = MerchantPresenter.this;
                merchantPresenter.scheduleImpl.dismissProgress();
                merchantPresenter.scheduleImpl.onError(((Throwable) obj).getMessage());
                return Unit.INSTANCE;
            }
        });
    }

    public final void MyBillsEntityDataFactory(final MerchantCategoryType merchantCategoryType) {
        this.scheduleImpl.showProgress();
        this.moveToNextValue.execute(new GetNewMerchantCategories.Params(merchantCategoryType), new Function1() { // from class: id.dana.nearbyme.MerchantPresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                MerchantPresenter merchantPresenter = MerchantPresenter.this;
                MerchantCategoryType merchantCategoryType2 = merchantCategoryType;
                ArrayList arrayList = new ArrayList((List) obj);
                if (merchantCategoryType2 == MerchantCategoryType.LIST) {
                    merchantPresenter.scheduleImpl.onGetNewMerchantListCategories(merchantPresenter.KClassImpl$Data$declaredNonStaticMembers$2.apply(arrayList));
                } else {
                    merchantPresenter.BuiltInFictitiousFunctionClassFactory.onNext(merchantPresenter.KClassImpl$Data$declaredNonStaticMembers$2.apply(arrayList));
                }
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.nearbyme.MerchantPresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                MerchantPresenter merchantPresenter = MerchantPresenter.this;
                Throwable th = (Throwable) obj;
                merchantPresenter.scheduleImpl.onErrorGetNewMerchantCategories(merchantCategoryType);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("initNewMerchantCategories: ");
        sb.append(th.getMessage());
        DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", sb.toString());
        return Unit.INSTANCE;
    }

    @Override // id.dana.nearbyme.MerchantContract.Presenter
    public final void PlaceComponentResult(List<ShopModel> list, int i) {
        if (i == 1) {
            this.PlaceComponentResult.clear();
        }
        this.PlaceComponentResult.addAll(list);
        this.getAuthRequestContext.onNext(this.PlaceComponentResult);
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.moveToNextValue.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.getErrorConfigVersion.dispose();
        this.lookAheadTest.dispose();
    }
}
