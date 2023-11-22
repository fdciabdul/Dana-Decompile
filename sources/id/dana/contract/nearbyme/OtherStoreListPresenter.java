package id.dana.contract.nearbyme;

import id.dana.contract.nearbyme.OtherStoreListContract;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.domain.nearbyme.interactor.GetOtherStoreList;
import id.dana.domain.nearbyme.model.NearbyShopsPromo;
import id.dana.domain.nearbyme.model.OtherStoreListResult;
import id.dana.model.OtherStoreListResultModel;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.extension.ShopModelExtKt;
import id.dana.nearbyme.mapper.OtherStoreListResultModelMapper;
import id.dana.nearbyme.model.MerchantCategoryModel;
import id.dana.nearbyme.model.ShopModel;
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
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u001c\u0012\u0006\u0010\u000b\u001a\u00020\u0019\u0012\u0006\u0010\f\u001a\u00020(\u0012\u0006\u0010\u000e\u001a\u000200\u0012\u0006\u0010\u000f\u001a\u00020%¢\u0006\u0004\b3\u00104J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0003\u0010\bJ?\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J?\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0013\u001a\u00020\u001f8\u0017X\u0096\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b\u0013\u0010!R'\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00060#0#0\"X\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010$R\u0014\u0010\u001d\u001a\u00020%8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010&\u001a\b\u0012\u0004\u0012\u00020+0\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010,R'\u0010\u0017\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020+*\b\u0012\u0004\u0012\u00020+0#0#0\"X\u0007¢\u0006\u0006\n\u0004\b\u0003\u0010$R\u001a\u0010-\u001a\u00020\r8\u0017X\u0097\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b\u0011\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b1\u00102"}, d2 = {"Lid/dana/contract/nearbyme/OtherStoreListPresenter;", "Lid/dana/contract/nearbyme/OtherStoreListContract$Presenter;", "", "PlaceComponentResult", "()V", "", "Lid/dana/nearbyme/model/MerchantCategoryModel;", "p0", "(Ljava/util/List;)V", "", "", "p1", "p2", "", "p3", "p4", "p5", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;)V", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "onDestroy", "Lio/reactivex/disposables/CompositeDisposable;", "getErrorConfigVersion", "Lio/reactivex/disposables/CompositeDisposable;", "Lid/dana/domain/nearbyme/interactor/GetNearbyShopsPromo;", "Lid/dana/domain/nearbyme/interactor/GetNearbyShopsPromo;", "getAuthRequestContext", "Lid/dana/domain/nearbyme/interactor/GetOtherStoreList;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/nearbyme/interactor/GetOtherStoreList;", "", "Z", "()Z", "Lio/reactivex/subjects/PublishSubject;", "", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/nearbyme/mapper/OtherStoreListResultModelMapper;", "scheduleImpl", "Lid/dana/nearbyme/mapper/OtherStoreListResultModelMapper;", "Lid/dana/nearbyme/NearbyPromoModelMapper;", "lookAheadTest", "Lid/dana/nearbyme/NearbyPromoModelMapper;", "Lid/dana/nearbyme/model/ShopModel;", "Ljava/util/List;", "moveToNextValue", "I", "()I", "Lid/dana/contract/nearbyme/OtherStoreListContract$View;", "initRecordTimeStamp", "Lid/dana/contract/nearbyme/OtherStoreListContract$View;", "<init>", "(Lid/dana/domain/nearbyme/interactor/GetOtherStoreList;Lid/dana/domain/nearbyme/interactor/GetNearbyShopsPromo;Lid/dana/nearbyme/NearbyPromoModelMapper;Lid/dana/contract/nearbyme/OtherStoreListContract$View;Lid/dana/nearbyme/mapper/OtherStoreListResultModelMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OtherStoreListPresenter implements OtherStoreListContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    boolean MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final GetNearbyShopsPromo getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final PublishSubject<List<MerchantCategoryModel>> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final GetOtherStoreList PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final PublishSubject<List<ShopModel>> getErrorConfigVersion;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public List<ShopModel> scheduleImpl;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final CompositeDisposable BuiltInFictitiousFunctionClassFactory;
    private final OtherStoreListContract.View initRecordTimeStamp;
    private final NearbyPromoModelMapper lookAheadTest;
    int moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final OtherStoreListResultModelMapper NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public OtherStoreListPresenter(GetOtherStoreList getOtherStoreList, GetNearbyShopsPromo getNearbyShopsPromo, NearbyPromoModelMapper nearbyPromoModelMapper, OtherStoreListContract.View view, OtherStoreListResultModelMapper otherStoreListResultModelMapper) {
        Intrinsics.checkNotNullParameter(getOtherStoreList, "");
        Intrinsics.checkNotNullParameter(getNearbyShopsPromo, "");
        Intrinsics.checkNotNullParameter(nearbyPromoModelMapper, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(otherStoreListResultModelMapper, "");
        this.PlaceComponentResult = getOtherStoreList;
        this.getAuthRequestContext = getNearbyShopsPromo;
        this.lookAheadTest = nearbyPromoModelMapper;
        this.initRecordTimeStamp = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = otherStoreListResultModelMapper;
        this.scheduleImpl = new ArrayList();
        PublishSubject<List<ShopModel>> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.getErrorConfigVersion = PlaceComponentResult;
        PublishSubject<List<MerchantCategoryModel>> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult2;
        this.BuiltInFictitiousFunctionClassFactory = new CompositeDisposable();
        this.moveToNextValue = 1;
    }

    @Override // id.dana.contract.nearbyme.OtherStoreListContract.Presenter
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final int getMoveToNextValue() {
        return this.moveToNextValue;
    }

    @Override // id.dana.contract.nearbyme.OtherStoreListContract.Presenter
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // id.dana.contract.nearbyme.OtherStoreListContract.Presenter
    public final void MyBillsEntityDataFactory(String str, double d, double d2, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.PlaceComponentResult.execute(new GetOtherStoreList.Params(str, d, d2, 10, this.moveToNextValue, str2, str3, false, 128, null), new Function1<OtherStoreListResult, Unit>() { // from class: id.dana.contract.nearbyme.OtherStoreListPresenter$getShopList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OtherStoreListResult otherStoreListResult) {
                invoke2(otherStoreListResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OtherStoreListResult otherStoreListResult) {
                OtherStoreListContract.View view;
                OtherStoreListContract.View view2;
                OtherStoreListResultModelMapper otherStoreListResultModelMapper;
                Intrinsics.checkNotNullParameter(otherStoreListResult, "");
                OtherStoreListPresenter.this.moveToNextValue++;
                OtherStoreListPresenter.this.MyBillsEntityDataFactory = otherStoreListResult.getHasMore();
                view = OtherStoreListPresenter.this.initRecordTimeStamp;
                view.dismissProgress();
                view2 = OtherStoreListPresenter.this.initRecordTimeStamp;
                otherStoreListResultModelMapper = OtherStoreListPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                OtherStoreListResultModel apply = otherStoreListResultModelMapper.apply(otherStoreListResult);
                Intrinsics.checkNotNullExpressionValue(apply, "");
                view2.getAuthRequestContext(apply);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.nearbyme.OtherStoreListPresenter$getShopList$2
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
                OtherStoreListContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = OtherStoreListPresenter.this.initRecordTimeStamp;
                view.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.contract.nearbyme.OtherStoreListContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, double d, double d2, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.PlaceComponentResult.execute(new GetOtherStoreList.Params(str, d, d2, 20, this.moveToNextValue, str2, str3, true), new Function1<OtherStoreListResult, Unit>() { // from class: id.dana.contract.nearbyme.OtherStoreListPresenter$getOtherShopListAndPromo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OtherStoreListResult otherStoreListResult) {
                invoke2(otherStoreListResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OtherStoreListResult otherStoreListResult) {
                OtherStoreListContract.View view;
                OtherStoreListResultModelMapper otherStoreListResultModelMapper;
                Intrinsics.checkNotNullParameter(otherStoreListResult, "");
                view = OtherStoreListPresenter.this.initRecordTimeStamp;
                view.dismissProgress();
                otherStoreListResultModelMapper = OtherStoreListPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                OtherStoreListResultModel apply = otherStoreListResultModelMapper.apply(otherStoreListResult);
                OtherStoreListPresenter.BuiltInFictitiousFunctionClassFactory(OtherStoreListPresenter.this, apply.BuiltInFictitiousFunctionClassFactory);
                final OtherStoreListPresenter otherStoreListPresenter = OtherStoreListPresenter.this;
                List<ShopModel> list = apply.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullParameter(list, "");
                for (final List list2 : CollectionsKt.chunked(list, 5)) {
                    BaseUseCase.execute$default(otherStoreListPresenter.getAuthRequestContext, new GetNearbyShopsPromo.Params(ShopModelExtKt.KClassImpl$Data$declaredNonStaticMembers$2(list2)), new Function1<List<NearbyShopsPromo>, Unit>() { // from class: id.dana.contract.nearbyme.OtherStoreListPresenter$getShopsPromo$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(List<NearbyShopsPromo> list3) {
                            invoke2(list3);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(List<NearbyShopsPromo> list3) {
                            OtherStoreListContract.View view2;
                            NearbyPromoModelMapper nearbyPromoModelMapper;
                            Intrinsics.checkNotNullParameter(list3, "");
                            view2 = OtherStoreListPresenter.this.initRecordTimeStamp;
                            nearbyPromoModelMapper = OtherStoreListPresenter.this.lookAheadTest;
                            List<ShopModel> BuiltInFictitiousFunctionClassFactory = nearbyPromoModelMapper.BuiltInFictitiousFunctionClassFactory(list2, list3);
                            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                            view2.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
                        }
                    }, null, 4, null);
                }
                OtherStoreListPresenter.this.moveToNextValue++;
                OtherStoreListPresenter.this.MyBillsEntityDataFactory = otherStoreListResult.getHasMore();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.nearbyme.OtherStoreListPresenter$getOtherShopListAndPromo$2
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
                OtherStoreListContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = OtherStoreListPresenter.this.initRecordTimeStamp;
                view.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.contract.nearbyme.OtherStoreListContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(Observable.combineLatest(this.KClassImpl$Data$declaredNonStaticMembers$2.startWith((PublishSubject<List<MerchantCategoryModel>>) CollectionsKt.emptyList()), this.getErrorConfigVersion, new BiFunction() { // from class: id.dana.contract.nearbyme.OtherStoreListPresenter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return OtherStoreListPresenter.getAuthRequestContext((List) obj, (List) obj2);
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).flatMap(new Function() { // from class: id.dana.contract.nearbyme.OtherStoreListPresenter$$ExternalSyntheticLambda2
            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: id.dana.contract.nearbyme.OtherStoreListPresenter.PlaceComponentResult(io.reactivex.Observable):io.reactivex.ObservableSource
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                Caused by: java.lang.NullPointerException
                */
            @Override // io.reactivex.functions.Function
            public final java.lang.Object apply(java.lang.Object r1) {
                /*
                    r0 = this;
                    io.reactivex.Observable r1 = (io.reactivex.Observable) r1
                    io.reactivex.ObservableSource r1 = id.dana.contract.nearbyme.OtherStoreListPresenter.PlaceComponentResult(r1)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.nearbyme.OtherStoreListPresenter$$ExternalSyntheticLambda2.apply(java.lang.Object):java.lang.Object");
            }
        }).flatMap(new Function() { // from class: id.dana.contract.nearbyme.OtherStoreListPresenter$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return OtherStoreListPresenter.MyBillsEntityDataFactory((List) obj);
            }
        }).subscribe(new Consumer() { // from class: id.dana.contract.nearbyme.OtherStoreListPresenter$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OtherStoreListPresenter.MyBillsEntityDataFactory(OtherStoreListPresenter.this, (List) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAuthRequestContext(List list, ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(shopModel, "");
        return ShopModelExtKt.KClassImpl$Data$declaredNonStaticMembers$2(shopModel, list);
    }

    @Override // id.dana.contract.nearbyme.OtherStoreListContract.Presenter
    public final void PlaceComponentResult(List<MerchantCategoryModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(p0);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.PlaceComponentResult.dispose();
        this.getAuthRequestContext.dispose();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(OtherStoreListPresenter otherStoreListPresenter, List list) {
        Intrinsics.checkNotNullParameter(otherStoreListPresenter, "");
        OtherStoreListContract.View view = otherStoreListPresenter.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(list, "");
        view.BuiltInFictitiousFunctionClassFactory(list);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static /* synthetic */ io.reactivex.ObservableSource PlaceComponentResult(io.reactivex.Observable r1) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            io.reactivex.ObservableSource r1 = (io.reactivex.ObservableSource) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.nearbyme.OtherStoreListPresenter.PlaceComponentResult(io.reactivex.Observable):io.reactivex.ObservableSource");
    }

    public static /* synthetic */ Observable getAuthRequestContext(final List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Single list3 = Observable.fromIterable(list2).filter(new Predicate() { // from class: id.dana.contract.nearbyme.OtherStoreListPresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean authRequestContext;
                authRequestContext = OtherStoreListPresenter.getAuthRequestContext(list, (ShopModel) obj);
                return authRequestContext;
            }
        }).toList();
        if (list3 instanceof FuseToObservable) {
            return ((FuseToObservable) list3).getAuthRequestContext();
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list3));
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return ShopModelExtKt.getAuthRequestContext(list);
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(OtherStoreListPresenter otherStoreListPresenter, List list) {
        if (otherStoreListPresenter.moveToNextValue == 1) {
            otherStoreListPresenter.scheduleImpl = CollectionsKt.toMutableList((Collection) list);
        } else {
            otherStoreListPresenter.scheduleImpl.addAll(list);
        }
        otherStoreListPresenter.getErrorConfigVersion.onNext(otherStoreListPresenter.scheduleImpl);
    }

    @Override // id.dana.contract.nearbyme.OtherStoreListContract.Presenter
    public final void PlaceComponentResult() {
        this.moveToNextValue = 1;
        this.MyBillsEntityDataFactory = false;
        this.scheduleImpl.clear();
        this.PlaceComponentResult.dispose();
        this.getAuthRequestContext.dispose();
    }
}
