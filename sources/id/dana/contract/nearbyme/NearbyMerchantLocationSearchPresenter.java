package id.dana.contract.nearbyme;

import android.location.Location;
import android.text.TextUtils;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.miniprogram.interactor.GetReverseGeocodeByLocation;
import id.dana.domain.miniprogram.model.Address;
import id.dana.domain.nearbyme.interactor.GetNearbyRankingConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithPagination;
import id.dana.domain.nearbyme.model.NearbyShopsPromo;
import id.dana.domain.nearbyme.model.ShopListRequest;
import id.dana.domain.nearbyme.model.ShopsPage;
import id.dana.domain.nearbyplaces.interactor.GetChainQueryResult;
import id.dana.domain.nearbyplaces.interactor.GetListNearbyLocation;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import id.dana.domain.tracker.GeocodeTrackerData;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import id.dana.drawable.ShopRankingCalculator;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.extension.ShopModelExtKt;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 O2\u00020\u0001:\u0001OBa\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020C\u0012\u0006\u0010\u0005\u001a\u00020%\u0012\u0006\u0010\u0006\u001a\u00020.\u0012\u0006\u0010\u0007\u001a\u00020,\u0012\u0006\u0010\b\u001a\u00020\u001e\u0012\u0006\u0010G\u001a\u000202\u0012\u0006\u0010H\u001a\u000206\u0012\u0006\u0010I\u001a\u000209\u0012\u0006\u0010J\u001a\u00020(\u0012\u0006\u0010K\u001a\u00020@\u0012\u0006\u0010L\u001a\u00020\"¢\u0006\u0004\bM\u0010NJ7\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u000f\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0010J'\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\n\u0010\u0019J\u001d\u0010\n\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00110\u001aH\u0016¢\u0006\u0004\b\n\u0010\u001bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00188\u0017X\u0096\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\n\u0010\u001dR\u0014\u0010\n\u001a\u00020\u001e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0014\u0010\f\u001a\u00020 8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010!R\u0014\u0010\u000f\u001a\u00020\"8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0016\u001a\u00020%8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010#\u001a\u00020,8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010-R\u0014\u00101\u001a\u00020.8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u0010&\u001a\u0002068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001e\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001a0<X\u0087\"¢\u0006\u0006\n\u0004\b\f\u0010=R'\u0010/\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00110\u001a0\u001a0>X\u0007¢\u0006\u0006\n\u0004\b1\u0010?R\u0014\u00107\u001a\u00020@8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b5\u0010AR\u0012\u00103\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b+\u0010BR\u0014\u0010F\u001a\u00020C8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bD\u0010E"}, d2 = {"Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchPresenter;", "Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$Presenter;", "", "p0", "Landroid/location/Location;", "p1", "p2", "p3", "p4", "", "PlaceComponentResult", "(Ljava/lang/String;Landroid/location/Location;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "(Landroid/location/Location;)V", "getAuthRequestContext", "()V", "Lid/dana/nearbyme/model/ShopModel;", "", "(Lid/dana/nearbyme/model/ShopModel;Ljava/lang/String;)Z", "onDestroy", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "(Ljava/lang/String;Landroid/location/Location;Ljava/lang/String;)V", "", "(Ljava/lang/String;Landroid/location/Location;I)V", "", "(Ljava/util/List;)V", "I", "()I", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/data/config/DeviceInformationProvider;", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "Lid/dana/domain/nearbyplaces/interactor/GetChainQueryResult;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/nearbyplaces/interactor/GetChainQueryResult;", "Lid/dana/domain/nearbyplaces/interactor/GetListNearbyLocation;", "lookAheadTest", "Lid/dana/domain/nearbyplaces/interactor/GetListNearbyLocation;", "Lid/dana/domain/nearbyme/interactor/GetNearbyRankingConfig;", "DatabaseTableConfigUtil", "Lid/dana/domain/nearbyme/interactor/GetNearbyRankingConfig;", "moveToNextValue", "Lid/dana/domain/nearbyme/interactor/GetNearbyShopsPromo;", "Lid/dana/domain/nearbyme/interactor/GetNearbyShopsPromo;", "Lid/dana/domain/nearbyme/interactor/GetNearbyShopsWithPagination;", "GetContactSyncConfig", "Lid/dana/domain/nearbyme/interactor/GetNearbyShopsWithPagination;", "scheduleImpl", "Lid/dana/domain/miniprogram/interactor/GetReverseGeocodeByLocation;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/domain/miniprogram/interactor/GetReverseGeocodeByLocation;", "getErrorConfigVersion", "Lid/dana/nearbyme/mapper/NearbyShopsModelMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/nearbyme/mapper/NearbyShopsModelMapper;", "Lid/dana/nearbyme/NearbyPromoModelMapper;", "initRecordTimeStamp", "Lid/dana/nearbyme/NearbyPromoModelMapper;", "Lio/reactivex/Observable;", "Lio/reactivex/Observable;", "Lio/reactivex/subjects/PublishSubject;", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/nearbyrevamp/ShopRankingCalculator;", "Lid/dana/nearbyrevamp/ShopRankingCalculator;", "Ljava/lang/String;", "Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$View;", "PrepareContext", "Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$View;", "isLayoutRequested", "p5", "p6", "p7", "p8", "p9", "p10", "<init>", "(Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$View;Lid/dana/domain/nearbyplaces/interactor/GetListNearbyLocation;Lid/dana/domain/nearbyme/interactor/GetNearbyShopsWithPagination;Lid/dana/domain/nearbyme/interactor/GetNearbyShopsPromo;Lid/dana/data/config/DeviceInformationProvider;Lid/dana/domain/miniprogram/interactor/GetReverseGeocodeByLocation;Lid/dana/nearbyme/mapper/NearbyShopsModelMapper;Lid/dana/nearbyme/NearbyPromoModelMapper;Lid/dana/domain/nearbyme/interactor/GetNearbyRankingConfig;Lid/dana/nearbyrevamp/ShopRankingCalculator;Lid/dana/domain/nearbyplaces/interactor/GetChainQueryResult;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NearbyMerchantLocationSearchPresenter implements NearbyMerchantLocationSearchContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Observable<List<ShopModel>> DatabaseTableConfigUtil;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final GetNearbyRankingConfig moveToNextValue;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final GetNearbyShopsWithPagination scheduleImpl;
    int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final GetNearbyShopsPromo NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final GetChainQueryResult getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final GetReverseGeocodeByLocation getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final NearbyShopsModelMapper lookAheadTest;
    public final DeviceInformationProvider PlaceComponentResult;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final NearbyMerchantLocationSearchContract.View isLayoutRequested;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final CompositeDisposable BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    final ShopRankingCalculator NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final NearbyPromoModelMapper initRecordTimeStamp;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetListNearbyLocation MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final PublishSubject<List<ShopModel>> GetContactSyncConfig;

    @Inject
    public NearbyMerchantLocationSearchPresenter(NearbyMerchantLocationSearchContract.View view, GetListNearbyLocation getListNearbyLocation, GetNearbyShopsWithPagination getNearbyShopsWithPagination, GetNearbyShopsPromo getNearbyShopsPromo, DeviceInformationProvider deviceInformationProvider, GetReverseGeocodeByLocation getReverseGeocodeByLocation, NearbyShopsModelMapper nearbyShopsModelMapper, NearbyPromoModelMapper nearbyPromoModelMapper, GetNearbyRankingConfig getNearbyRankingConfig, ShopRankingCalculator shopRankingCalculator, GetChainQueryResult getChainQueryResult) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getListNearbyLocation, "");
        Intrinsics.checkNotNullParameter(getNearbyShopsWithPagination, "");
        Intrinsics.checkNotNullParameter(getNearbyShopsPromo, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        Intrinsics.checkNotNullParameter(getReverseGeocodeByLocation, "");
        Intrinsics.checkNotNullParameter(nearbyShopsModelMapper, "");
        Intrinsics.checkNotNullParameter(nearbyPromoModelMapper, "");
        Intrinsics.checkNotNullParameter(getNearbyRankingConfig, "");
        Intrinsics.checkNotNullParameter(shopRankingCalculator, "");
        Intrinsics.checkNotNullParameter(getChainQueryResult, "");
        this.isLayoutRequested = view;
        this.MyBillsEntityDataFactory = getListNearbyLocation;
        this.scheduleImpl = getNearbyShopsWithPagination;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getNearbyShopsPromo;
        this.PlaceComponentResult = deviceInformationProvider;
        this.getErrorConfigVersion = getReverseGeocodeByLocation;
        this.lookAheadTest = nearbyShopsModelMapper;
        this.initRecordTimeStamp = nearbyPromoModelMapper;
        this.moveToNextValue = getNearbyRankingConfig;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = shopRankingCalculator;
        this.getAuthRequestContext = getChainQueryResult;
        this.BuiltInFictitiousFunctionClassFactory = new CompositeDisposable();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = "";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
        PublishSubject<List<ShopModel>> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.GetContactSyncConfig = PlaceComponentResult;
    }

    @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.Presenter
    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final int getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.Presenter
    public final void getAuthRequestContext() {
        String deviceUUID = this.PlaceComponentResult.getDeviceUUID();
        Intrinsics.checkNotNullExpressionValue(deviceUUID, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = deviceUUID;
    }

    @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable just = Observable.just(p0);
        Intrinsics.checkNotNullExpressionValue(just, "");
        Observable<List<ShopModel>> observable = this.DatabaseTableConfigUtil;
        if (observable != null) {
            Observable observable2 = just;
            if (observable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                observable = null;
            }
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(Observable.combineLatest(observable2, observable, new BiFunction() { // from class: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return NearbyMerchantLocationSearchPresenter.BuiltInFictitiousFunctionClassFactory(NearbyMerchantLocationSearchPresenter.this, (String) obj, (List) obj2);
                }
            }).flatMap(new Function() { // from class: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$$ExternalSyntheticLambda4
                /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                    jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter.BuiltInFictitiousFunctionClassFactory(io.reactivex.Observable):io.reactivex.ObservableSource
                    	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                    	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                    Caused by: java.lang.NullPointerException
                    */
                @Override // io.reactivex.functions.Function
                public final java.lang.Object apply(java.lang.Object r1) {
                    /*
                        r0 = this;
                        io.reactivex.Observable r1 = (io.reactivex.Observable) r1
                        io.reactivex.ObservableSource r1 = id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter.BuiltInFictitiousFunctionClassFactory(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$$ExternalSyntheticLambda4.apply(java.lang.Object):java.lang.Object");
                }
            }).subscribe(new Consumer() { // from class: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    NearbyMerchantLocationSearchPresenter.getAuthRequestContext(NearbyMerchantLocationSearchPresenter.this, (List) obj);
                }
            }));
        }
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(NearbyMerchantLocationSearchPresenter nearbyMerchantLocationSearchPresenter, String str, ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(nearbyMerchantLocationSearchPresenter, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(shopModel, "");
        return getAuthRequestContext(shopModel, str);
    }

    @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.Presenter
    public final void PlaceComponentResult(String p0, Location p1, String p2, String p3, String p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        HereMixPanelTrackerData hereMixPanelTrackerData = new HereMixPanelTrackerData(null, null, false, null, null, 31, null);
        hereMixPanelTrackerData.setSource(p4);
        this.getAuthRequestContext.execute(new GetChainQueryResult.Params(this.NetworkUserEntityData$$ExternalSyntheticLambda1, p0, p1, p2, GeocodeTrackerData.INSTANCE.fromAppLayerCaller(p3), hereMixPanelTrackerData), new Function1<List<? extends NearbyLocation>, Unit>() { // from class: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$getChainQueryDetail$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends NearbyLocation> list) {
                invoke2((List<NearbyLocation>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<NearbyLocation> list) {
                NearbyMerchantLocationSearchContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                view = NearbyMerchantLocationSearchPresenter.this.isLayoutRequested;
                view.onSuccessGetListLocations(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$getChainQueryDetail$2
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
                NearbyMerchantLocationSearchContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = NearbyMerchantLocationSearchPresenter.this.isLayoutRequested;
                view.onErrorGetListLocations();
            }
        });
    }

    @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, Location p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        HereMixPanelTrackerData hereMixPanelTrackerData = new HereMixPanelTrackerData(null, null, false, null, null, 31, null);
        hereMixPanelTrackerData.setSource(p2);
        this.MyBillsEntityDataFactory.execute(new GetListNearbyLocation.Params(this.NetworkUserEntityData$$ExternalSyntheticLambda1, p0, p1, hereMixPanelTrackerData), new Function1<List<? extends NearbyLocation>, Unit>() { // from class: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$searchListNearbyLocations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends NearbyLocation> list) {
                invoke2((List<NearbyLocation>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<NearbyLocation> list) {
                NearbyMerchantLocationSearchContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                view = NearbyMerchantLocationSearchPresenter.this.isLayoutRequested;
                view.onSuccessGetListLocations(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$searchListNearbyLocations$2
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
                NearbyMerchantLocationSearchContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(NearbyMerchantLocationSearchPresenter.this.getClass().getName());
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.NEARBY_LOCATION, sb.toString(), th);
                view = NearbyMerchantLocationSearchPresenter.this.isLayoutRequested;
                view.onErrorGetListLocations();
            }
        });
    }

    @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.Presenter
    public final void PlaceComponentResult(String p0, Location p1, final int p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.scheduleImpl.executeJava1(new GetNearbyShopsWithPagination.Params(new ShopListRequest(p1.getLatitude(), p1.getLongitude(), this.KClassImpl$Data$declaredNonStaticMembers$2, 20, p0, true, "search")), new Function1<ShopsPage, Unit>() { // from class: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$searchListShop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ShopsPage shopsPage) {
                invoke2(shopsPage);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ShopsPage shopsPage) {
                NearbyShopsModelMapper nearbyShopsModelMapper;
                NearbyMerchantLocationSearchContract.View view;
                NearbyMerchantLocationSearchContract.View view2;
                Intrinsics.checkNotNullParameter(shopsPage, "");
                nearbyShopsModelMapper = NearbyMerchantLocationSearchPresenter.this.lookAheadTest;
                List<ShopModel> list = nearbyShopsModelMapper.apply(shopsPage).MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(list, "");
                List mutableList = CollectionsKt.toMutableList((Collection) list);
                final NearbyMerchantLocationSearchPresenter nearbyMerchantLocationSearchPresenter = NearbyMerchantLocationSearchPresenter.this;
                Intrinsics.checkNotNullParameter(mutableList, "");
                nearbyMerchantLocationSearchPresenter.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory = true;
                CollectionsKt.sortWith(mutableList, new Comparator() { // from class: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$$ExternalSyntheticLambda2
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return NearbyMerchantLocationSearchPresenter.MyBillsEntityDataFactory(NearbyMerchantLocationSearchPresenter.this, (ShopModel) obj, (ShopModel) obj2);
                    }
                });
                final List<ShopModel> PlaceComponentResult = ShopModelExtKt.PlaceComponentResult(mutableList, p2);
                if (NearbyMerchantLocationSearchPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2 == 1) {
                    view2 = NearbyMerchantLocationSearchPresenter.this.isLayoutRequested;
                    view2.onSuccessSearchNearbyMerchantList(shopsPage.getHasMore(), PlaceComponentResult);
                } else {
                    view = NearbyMerchantLocationSearchPresenter.this.isLayoutRequested;
                    view.onSuccessLoadMoreNearbyMerchantList(shopsPage.getHasMore(), PlaceComponentResult);
                }
                final NearbyMerchantLocationSearchPresenter nearbyMerchantLocationSearchPresenter2 = NearbyMerchantLocationSearchPresenter.this;
                Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
                Iterator it = CollectionsKt.chunked(PlaceComponentResult, 5).iterator();
                while (it.hasNext()) {
                    nearbyMerchantLocationSearchPresenter2.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new GetNearbyShopsPromo.Params(ShopModelExtKt.KClassImpl$Data$declaredNonStaticMembers$2((List) it.next())), new Function1<List<NearbyShopsPromo>, Unit>() { // from class: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$getShopsPromo$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(List<NearbyShopsPromo> list2) {
                            invoke2(list2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(List<NearbyShopsPromo> list2) {
                            NearbyMerchantLocationSearchContract.View view3;
                            NearbyPromoModelMapper nearbyPromoModelMapper;
                            Intrinsics.checkNotNullParameter(list2, "");
                            view3 = NearbyMerchantLocationSearchPresenter.this.isLayoutRequested;
                            nearbyPromoModelMapper = NearbyMerchantLocationSearchPresenter.this.initRecordTimeStamp;
                            List<ShopModel> BuiltInFictitiousFunctionClassFactory = nearbyPromoModelMapper.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, list2);
                            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                            view3.onSuccessGetMerchantListPromo(BuiltInFictitiousFunctionClassFactory);
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$getShopsPromo$1$2
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            Intrinsics.checkNotNullParameter(th, "");
                            StringBuilder sb = new StringBuilder();
                            sb.append("NearbyMerchantLocationSearchPresenter");
                            sb.append(th.getMessage());
                            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.NEARBY_MERCHANT_SEARCH, sb.toString(), th);
                        }
                    });
                }
                NearbyMerchantLocationSearchPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$searchListShop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                NearbyMerchantLocationSearchContract.View view;
                NearbyMerchantLocationSearchContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(NearbyMerchantLocationSearchPresenter.this.getClass().getName());
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.NEARBY_MERCHANT_SEARCH, sb.toString(), th);
                view = NearbyMerchantLocationSearchPresenter.this.isLayoutRequested;
                view.onErrorGetNearbyMerchantList();
                if (NearbyMerchantLocationSearchPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2 == 1) {
                    view2 = NearbyMerchantLocationSearchPresenter.this.isLayoutRequested;
                    return view2.getNearbyMerchantListErrorTitle();
                }
                return "";
            }
        }, this.isLayoutRequested.getErrorSource());
    }

    public final void PlaceComponentResult(Location p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getErrorConfigVersion.execute(GetReverseGeocodeByLocation.Params.INSTANCE.create(p0), new Function1<Address, Unit>() { // from class: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$getReverseGeocodeByLocation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Address address) {
                invoke2(address);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Address address) {
                NearbyMerchantLocationSearchContract.View view;
                Intrinsics.checkNotNullParameter(address, "");
                view = NearbyMerchantLocationSearchPresenter.this.isLayoutRequested;
                view.onSuccessGetReverseGeocodeByLocation(address);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$getReverseGeocodeByLocation$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append("NearbyMerchantLocationSearchPresenter");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GEOCODE, sb.toString(), th);
            }
        });
    }

    private static boolean getAuthRequestContext(ShopModel p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String str = p1;
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(p0.newProxyInstance)) {
                return false;
            }
            String str2 = p0.newProxyInstance;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            String lowerCase = str2.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "");
            if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) str, false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.Presenter
    public final void PlaceComponentResult(List<? extends ShopModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.GetContactSyncConfig.onNext(p0);
    }

    @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.GetContactSyncConfig.subscribe(new NearbyMerchantLocationSearchPresenter$$ExternalSyntheticLambda1(this)));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.scheduleImpl.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.moveToNextValue.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.getAuthRequestContext.dispose();
    }

    public static /* synthetic */ void getAuthRequestContext(NearbyMerchantLocationSearchPresenter nearbyMerchantLocationSearchPresenter, List list) {
        Intrinsics.checkNotNullParameter(nearbyMerchantLocationSearchPresenter, "");
        NearbyMerchantLocationSearchContract.View view = nearbyMerchantLocationSearchPresenter.isLayoutRequested;
        Intrinsics.checkNotNullExpressionValue(list, "");
        view.onSuccessGetNearbyMerchantList(list);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    public static /* synthetic */ io.reactivex.ObservableSource BuiltInFictitiousFunctionClassFactory(io.reactivex.Observable r1) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            io.reactivex.ObservableSource r1 = (io.reactivex.ObservableSource) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter.BuiltInFictitiousFunctionClassFactory(io.reactivex.Observable):io.reactivex.ObservableSource");
    }

    public static /* synthetic */ int MyBillsEntityDataFactory(NearbyMerchantLocationSearchPresenter nearbyMerchantLocationSearchPresenter, ShopModel shopModel, ShopModel shopModel2) {
        Intrinsics.checkNotNullParameter(nearbyMerchantLocationSearchPresenter, "");
        ShopRankingCalculator shopRankingCalculator = nearbyMerchantLocationSearchPresenter.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(shopModel2, "");
        double KClassImpl$Data$declaredNonStaticMembers$2 = shopRankingCalculator.KClassImpl$Data$declaredNonStaticMembers$2(shopModel2);
        ShopRankingCalculator shopRankingCalculator2 = nearbyMerchantLocationSearchPresenter.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(shopModel, "");
        return Double.compare(KClassImpl$Data$declaredNonStaticMembers$2, shopRankingCalculator2.KClassImpl$Data$declaredNonStaticMembers$2(shopModel));
    }

    public static /* synthetic */ Observable BuiltInFictitiousFunctionClassFactory(NearbyMerchantLocationSearchPresenter nearbyMerchantLocationSearchPresenter, final String str, List list) {
        Intrinsics.checkNotNullParameter(nearbyMerchantLocationSearchPresenter, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Single list2 = Observable.fromIterable(list).filter(new Predicate() { // from class: id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean KClassImpl$Data$declaredNonStaticMembers$2;
                KClassImpl$Data$declaredNonStaticMembers$2 = NearbyMerchantLocationSearchPresenter.KClassImpl$Data$declaredNonStaticMembers$2(NearbyMerchantLocationSearchPresenter.this, str, (ShopModel) obj);
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
        }).toList();
        if (list2 instanceof FuseToObservable) {
            return ((FuseToObservable) list2).getAuthRequestContext();
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list2));
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(NearbyMerchantLocationSearchPresenter nearbyMerchantLocationSearchPresenter, List list) {
        Intrinsics.checkNotNullParameter(nearbyMerchantLocationSearchPresenter, "");
        Observable<List<ShopModel>> just = Observable.just(list);
        Intrinsics.checkNotNullExpressionValue(just, "");
        Intrinsics.checkNotNullParameter(just, "");
        nearbyMerchantLocationSearchPresenter.DatabaseTableConfigUtil = just;
    }

    @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
        this.scheduleImpl.dispose();
    }
}
