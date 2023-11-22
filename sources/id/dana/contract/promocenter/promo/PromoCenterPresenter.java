package id.dana.contract.promocenter.promo;

import android.location.Location;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.base.BasePresenter;
import id.dana.contract.promocenter.promo.PromoCenterContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.promocenter.interactor.GetPromoAds;
import id.dana.domain.promocenter.interactor.GetPromoAdsConfigFeature;
import id.dana.domain.promocenter.interactor.GetPromoCategorizedList;
import id.dana.domain.promocenter.interactor.GetPromoList;
import id.dana.domain.promocenter.model.CategoryPromo;
import id.dana.domain.promocenter.model.Promo;
import id.dana.domain.promocenter.model.PromoAds;
import id.dana.domain.promocenter.model.PromoAdsConfig;
import id.dana.domain.promocenter.model.PromoResult;
import id.dana.promocenter.mapper.PromoAdsModelMapper;
import id.dana.promocenter.mapper.PromoCategoryModelMapper;
import id.dana.promocenter.mapper.PromoModelExtensionKt;
import id.dana.promocenter.model.PromoResultModel;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KBA\b\u0001\u0012\u0006\u0010\b\u001a\u00020A\u0012\u0006\u0010\u0015\u001a\u00020>\u0012\u0006\u0010\u001b\u001a\u000208\u0012\u0006\u0010E\u001a\u00020.\u0012\u0006\u0010F\u001a\u000201\u0012\u0006\u0010G\u001a\u00020+\u0012\u0006\u0010H\u001a\u00020(¢\u0006\u0004\bI\u0010JJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u0019\u0010\f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\f\u0010\u0010J\u0015\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0011¢\u0006\u0004\b\t\u0010\u0012J\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\f\u0010\u0012J%\u0010\u0016\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\f\u0010\u0019J\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\f\u0010\u001aJ+\u0010\u0006\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0006\u0010\u001cJ\u001b\u0010\u0016\u001a\u00020\u00112\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b\u0016\u0010\u001eJ'\u0010\u0016\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u001f2\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u001dH\u0002¢\u0006\u0004\b\u0016\u0010 J\u000f\u0010!\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\u0005J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\"H\u0002¢\u0006\u0004\b\u0016\u0010#R\u0012\u0010\u0016\u001a\u00020\u0018X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010$R\u0016\u0010\u0004\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u0006\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010\t\u001a\u0004\u0018\u00010\u0018X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010$R\u0016\u0010\f\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010)\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010,\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0012\u0010'\u001a\u00020\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u00104R\u0018\u0010%\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001e\u00109\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u00102\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010?R\u0014\u00106\u001a\u0004\u0018\u00010\u0018X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010$R\u0014\u0010<\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010@R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010C"}, d2 = {"Lid/dana/contract/promocenter/promo/PromoCenterPresenter;", "Lid/dana/base/BasePresenter;", "Lid/dana/contract/promocenter/promo/PromoCenterContract$Presenter;", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "", "p0", "PlaceComponentResult", "(I)V", "Landroid/location/Location;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/location/Location;)V", "Lid/dana/domain/DefaultObserver;", "Lid/dana/domain/promocenter/model/PromoAds;", "()Lid/dana/domain/DefaultObserver;", "", "(Z)V", "", "Lid/dana/domain/promocenter/model/Promo;", "p1", "BuiltInFictitiousFunctionClassFactory", "(ZLjava/util/List;)V", "", "(Ljava/lang/String;Z)V", "(ZLjava/lang/String;)V", "p2", "(Ljava/lang/String;ZLandroid/location/Location;)V", "", "(Ljava/util/List;)Z", "Lid/dana/domain/promocenter/model/PromoResult;", "(Lid/dana/domain/promocenter/model/PromoResult;Ljava/util/List;)Z", "onDestroy", "Lid/dana/promocenter/model/PromoResultModel;", "(Lid/dana/promocenter/model/PromoResultModel;)V", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "lookAheadTest", "Lid/dana/domain/promocenter/interactor/GetPromoAds;", "scheduleImpl", "Lid/dana/domain/promocenter/interactor/GetPromoAds;", "Lid/dana/domain/promocenter/interactor/GetPromoAdsConfigFeature;", "moveToNextValue", "Lid/dana/domain/promocenter/interactor/GetPromoAdsConfigFeature;", "Lid/dana/domain/promocenter/interactor/GetPromoCategorizedList;", "getErrorConfigVersion", "Lid/dana/domain/promocenter/interactor/GetPromoCategorizedList;", "Lid/dana/domain/promocenter/interactor/GetPromoList;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/domain/promocenter/interactor/GetPromoList;", "I", "Lid/dana/domain/promocenter/model/PromoAdsConfig;", "DatabaseTableConfigUtil", "Lid/dana/domain/promocenter/model/PromoAdsConfig;", "Lid/dana/promocenter/mapper/PromoAdsModelMapper;", "initRecordTimeStamp", "Lid/dana/promocenter/mapper/PromoAdsModelMapper;", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/domain/DefaultObserver;", "Lid/dana/promocenter/mapper/PromoCategoryModelMapper;", "Lid/dana/promocenter/mapper/PromoCategoryModelMapper;", "Landroid/location/Location;", "Lid/dana/contract/promocenter/promo/PromoCenterContract$View;", "newProxyInstance", "Lid/dana/contract/promocenter/promo/PromoCenterContract$View;", "isLayoutRequested", "p3", "p4", "p5", "p6", "<init>", "(Lid/dana/contract/promocenter/promo/PromoCenterContract$View;Lid/dana/promocenter/mapper/PromoCategoryModelMapper;Lid/dana/promocenter/mapper/PromoAdsModelMapper;Lid/dana/domain/promocenter/interactor/GetPromoCategorizedList;Lid/dana/domain/promocenter/interactor/GetPromoList;Lid/dana/domain/promocenter/interactor/GetPromoAdsConfigFeature;Lid/dana/domain/promocenter/interactor/GetPromoAds;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromoCenterPresenter extends BasePresenter implements PromoCenterContract.Presenter {
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private PromoAdsConfig NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final PromoCategoryModelMapper NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int lookAheadTest;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private GetPromoList moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private DefaultObserver<PromoAds> initRecordTimeStamp;
    public String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public Location NetworkUserEntityData$$ExternalSyntheticLambda2;
    private GetPromoCategorizedList getErrorConfigVersion;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final PromoAdsModelMapper GetContactSyncConfig;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private GetPromoAdsConfigFeature scheduleImpl;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final PromoCenterContract.View isLayoutRequested;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private GetPromoAds KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public PromoCenterPresenter(PromoCenterContract.View view, PromoCategoryModelMapper promoCategoryModelMapper, PromoAdsModelMapper promoAdsModelMapper, GetPromoCategorizedList getPromoCategorizedList, GetPromoList getPromoList, GetPromoAdsConfigFeature getPromoAdsConfigFeature, GetPromoAds getPromoAds) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(promoCategoryModelMapper, "");
        Intrinsics.checkNotNullParameter(promoAdsModelMapper, "");
        Intrinsics.checkNotNullParameter(getPromoCategorizedList, "");
        Intrinsics.checkNotNullParameter(getPromoList, "");
        Intrinsics.checkNotNullParameter(getPromoAdsConfigFeature, "");
        Intrinsics.checkNotNullParameter(getPromoAds, "");
        this.isLayoutRequested = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = promoCategoryModelMapper;
        this.GetContactSyncConfig = promoAdsModelMapper;
        this.getErrorConfigVersion = getPromoCategorizedList;
        this.moveToNextValue = getPromoList;
        this.scheduleImpl = getPromoAdsConfigFeature;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getPromoAds;
        this.lookAheadTest = 1;
        this.BuiltInFictitiousFunctionClassFactory = "";
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        this.BuiltInFictitiousFunctionClassFactory = "";
        BuiltInFictitiousFunctionClassFactory(p0, new ArrayList());
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, boolean p1) {
        this.DatabaseTableConfigUtil = p0;
        if (p1) {
            if (!TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory)) {
                PlaceComponentResult(false);
            } else {
                this.BuiltInFictitiousFunctionClassFactory = "";
                BuiltInFictitiousFunctionClassFactory(false, (List<Promo>) new ArrayList());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, boolean p1, Location p2) {
        this.PlaceComponentResult = p0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = p2;
        if (p1) {
            PlaceComponentResult(false);
        }
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, String p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        this.BuiltInFictitiousFunctionClassFactory = p1;
        PlaceComponentResult(p0);
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Location p0) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = p0;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            MyBillsEntityDataFactory();
        } else {
            getAuthRequestContext();
        }
    }

    private final void MyBillsEntityDataFactory() {
        this.scheduleImpl.execute(NoParams.INSTANCE, new Function1<PromoAdsConfig, Unit>() { // from class: id.dana.contract.promocenter.promo.PromoCenterPresenter$fetchPromoAdsConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PromoAdsConfig promoAdsConfig) {
                invoke2(promoAdsConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PromoAdsConfig promoAdsConfig) {
                PromoCenterPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = promoAdsConfig;
                PromoCenterPresenter.this.getAuthRequestContext();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promocenter.promo.PromoCenterPresenter$fetchPromoAdsConfig$2
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
                PromoCenterContract.View view;
                view = PromoCenterPresenter.this.isLayoutRequested;
                view.onGetPromoAdsError();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext() {
        PromoAdsConfig promoAdsConfig = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (promoAdsConfig != null) {
            Boolean valueOf = promoAdsConfig != null ? Boolean.valueOf(promoAdsConfig.getEnable()) : null;
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.booleanValue()) {
                PromoAdsConfig promoAdsConfig2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (promoAdsConfig2 != null) {
                    PlaceComponentResult(promoAdsConfig2.getNumberOfItemBatch());
                    return;
                }
                return;
            }
        }
        this.isLayoutRequested.trackPromotionCenterOpen();
        this.isLayoutRequested.onGetPromoAdsError();
    }

    private final DefaultObserver<PromoAds> KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.initRecordTimeStamp == null) {
            this.initRecordTimeStamp = new DefaultObserver<PromoAds>() { // from class: id.dana.contract.promocenter.promo.PromoCenterPresenter$getPromoAdsObserver$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    PromoCenterContract.View view;
                    PromoCenterContract.View view2;
                    PromoAdsModelMapper unused;
                    PromoAds promoAds = (PromoAds) obj;
                    Intrinsics.checkNotNullParameter(promoAds, "");
                    view = PromoCenterPresenter.this.isLayoutRequested;
                    view.dismissProgress();
                    view2 = PromoCenterPresenter.this.isLayoutRequested;
                    unused = PromoCenterPresenter.this.GetContactSyncConfig;
                    view2.onGetPromoAdsSuccess(PromoAdsModelMapper.getAuthRequestContext(promoAds.getAdsList()));
                    PromoCenterPresenter.this.getAuthRequestContext = true;
                    PromoCenterPresenter.KClassImpl$Data$declaredNonStaticMembers$2(PromoCenterPresenter.this);
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onError(Throwable p0) {
                    PromoCenterContract.View view;
                    PromoCenterContract.View view2;
                    Intrinsics.checkNotNullParameter(p0, "");
                    super.onError(p0);
                    view = PromoCenterPresenter.this.isLayoutRequested;
                    view.dismissProgress();
                    view2 = PromoCenterPresenter.this.isLayoutRequested;
                    view2.onGetPromoAdsError();
                    PromoCenterPresenter.this.getAuthRequestContext = true;
                    PromoCenterPresenter.KClassImpl$Data$declaredNonStaticMembers$2(PromoCenterPresenter.this);
                }
            };
        }
        DefaultObserver<PromoAds> defaultObserver = this.initRecordTimeStamp;
        if (defaultObserver != null) {
            return defaultObserver;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.domain.DefaultObserver<id.dana.domain.promocenter.model.PromoAds>");
    }

    private void PlaceComponentResult(final boolean p0) {
        if (p0) {
            this.lookAheadTest++;
        } else {
            this.lookAheadTest = 1;
            this.isLayoutRequested.showProgress();
        }
        this.getErrorConfigVersion.dispose();
        GetPromoCategorizedList getPromoCategorizedList = this.getErrorConfigVersion;
        GetPromoCategorizedList.Params.Companion companion = GetPromoCategorizedList.Params.INSTANCE;
        int i = this.lookAheadTest;
        String str = this.BuiltInFictitiousFunctionClassFactory;
        String str2 = this.DatabaseTableConfigUtil;
        String str3 = this.PlaceComponentResult;
        Location location = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double latitude = location != null ? location.getLatitude() : 0.0d;
        Location location2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (location2 != null) {
            d = location2.getLongitude();
        }
        getPromoCategorizedList.execute(companion.forGetPromoCategorizedList(10, i, str, str2, str3, latitude, d), new Function1<CategoryPromo, Unit>() { // from class: id.dana.contract.promocenter.promo.PromoCenterPresenter$getPromoCategorized$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CategoryPromo categoryPromo) {
                invoke2(categoryPromo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CategoryPromo categoryPromo) {
                PromoCategoryModelMapper promoCategoryModelMapper;
                Intrinsics.checkNotNullParameter(categoryPromo, "");
                if (categoryPromo.getPromoList() != null && !categoryPromo.getPromoList().isEmpty()) {
                    PromoCenterPresenter promoCenterPresenter = PromoCenterPresenter.this;
                    promoCategoryModelMapper = promoCenterPresenter.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    PromoResultModel apply = promoCategoryModelMapper.apply(categoryPromo);
                    Intrinsics.checkNotNullExpressionValue(apply, "");
                    promoCenterPresenter.BuiltInFictitiousFunctionClassFactory(apply);
                    return;
                }
                PromoCenterPresenter.PlaceComponentResult(PromoCenterPresenter.this, categoryPromo, p0);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promocenter.promo.PromoCenterPresenter$getPromoCategorized$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Intrinsics.checkNotNullParameter(th, "");
                PromoCenterPresenter.BuiltInFictitiousFunctionClassFactory(PromoCenterPresenter.this, p0);
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.PROMO_CENTER_GET_CATEGORIZED_PROMO_PREFIX, DanaLogConstants.ExceptionType.PROMO_CENTER_EXCEPTION, th);
            }
        });
    }

    public final void BuiltInFictitiousFunctionClassFactory(final boolean p0, final List<Promo> p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        if (p0) {
            this.lookAheadTest++;
        } else {
            this.lookAheadTest = 1;
            this.isLayoutRequested.showProgress();
        }
        this.moveToNextValue.dispose();
        this.moveToNextValue.execute(GetPromoList.Params.INSTANCE.forGetPromo(10, this.lookAheadTest, this.DatabaseTableConfigUtil), new Function1<PromoResult, Unit>() { // from class: id.dana.contract.promocenter.promo.PromoCenterPresenter$getPromoList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PromoResult promoResult) {
                invoke2(promoResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PromoResult promoResult) {
                PromoCenterContract.View view;
                boolean BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullParameter(promoResult, "");
                view = PromoCenterPresenter.this.isLayoutRequested;
                view.dismissProgress();
                List<Promo> PlaceComponentResult = PromoCenterPresenter.PlaceComponentResult(promoResult.getPromoList(), p1);
                BuiltInFictitiousFunctionClassFactory = PromoCenterPresenter.BuiltInFictitiousFunctionClassFactory(promoResult, PlaceComponentResult);
                if (BuiltInFictitiousFunctionClassFactory) {
                    PromoCenterPresenter.this.BuiltInFictitiousFunctionClassFactory(p0, PlaceComponentResult);
                } else {
                    promoResult.setPromoList(PlaceComponentResult);
                    PromoCenterPresenter.getAuthRequestContext(PromoCenterPresenter.this, promoResult, p0);
                }
                PromoCenterPresenter.this.MyBillsEntityDataFactory = true;
                PromoCenterPresenter.KClassImpl$Data$declaredNonStaticMembers$2(PromoCenterPresenter.this);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promocenter.promo.PromoCenterPresenter$getPromoList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                PromoCenterContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = PromoCenterPresenter.this.isLayoutRequested;
                view.dismissProgress();
                PromoCenterPresenter.KClassImpl$Data$declaredNonStaticMembers$2(PromoCenterPresenter.this, p0);
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.PROMO_CENTER_GET_PROMO_LIST_PREFIX, DanaLogConstants.ExceptionType.PROMO_CENTER_EXCEPTION, th);
                PromoCenterPresenter.this.MyBillsEntityDataFactory = true;
                PromoCenterPresenter.KClassImpl$Data$declaredNonStaticMembers$2(PromoCenterPresenter.this);
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.moveToNextValue.dispose();
        this.getErrorConfigVersion.dispose();
        this.scheduleImpl.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(List<?> p0) {
        return p0.size() < 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean BuiltInFictitiousFunctionClassFactory(PromoResult p0, List<? extends Promo> p1) {
        return p0.isHasMore() && BuiltInFictitiousFunctionClassFactory(p1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory(PromoResultModel p0) {
        this.isLayoutRequested.dismissProgress();
        if (this.lookAheadTest > 1) {
            this.isLayoutRequested.onSuccessLoadMorePromo(p0);
        } else {
            this.isLayoutRequested.onSuccessGetPromoList(p0);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PromoCenterPresenter promoCenterPresenter) {
        if (promoCenterPresenter.MyBillsEntityDataFactory && promoCenterPresenter.getAuthRequestContext) {
            promoCenterPresenter.MyBillsEntityDataFactory = false;
            promoCenterPresenter.getAuthRequestContext = false;
            promoCenterPresenter.isLayoutRequested.trackPromotionCenterOpen();
        }
    }

    public static final /* synthetic */ List PlaceComponentResult(List list, List list2) {
        if (list != null) {
            list2.addAll(list);
        }
        return list2;
    }

    public static final /* synthetic */ void getAuthRequestContext(PromoCenterPresenter promoCenterPresenter, PromoResult promoResult, boolean z) {
        if (!promoResult.getPromoList().isEmpty()) {
            promoCenterPresenter.BuiltInFictitiousFunctionClassFactory(PromoModelExtensionKt.BuiltInFictitiousFunctionClassFactory(promoResult, promoResult));
        } else if (z) {
            promoCenterPresenter.lookAheadTest--;
            promoCenterPresenter.isLayoutRequested.onErrorLoadMorePromo(PromoModelExtensionKt.BuiltInFictitiousFunctionClassFactory(promoResult, promoResult).PlaceComponentResult());
        } else {
            promoCenterPresenter.isLayoutRequested.onEmptyGetPromoList();
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(PromoCenterPresenter promoCenterPresenter, CategoryPromo categoryPromo, boolean z) {
        if (z) {
            promoCenterPresenter.lookAheadTest--;
            promoCenterPresenter.isLayoutRequested.onErrorLoadMorePromo(promoCenterPresenter.NetworkUserEntityData$$ExternalSyntheticLambda1.apply(categoryPromo).PlaceComponentResult());
            return;
        }
        promoCenterPresenter.isLayoutRequested.onEmptyGetPromoCategorized();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PromoCenterPresenter promoCenterPresenter, boolean z) {
        if (z) {
            promoCenterPresenter.lookAheadTest--;
            promoCenterPresenter.isLayoutRequested.onErrorLoadMorePromo(true);
            return;
        }
        promoCenterPresenter.isLayoutRequested.onErrorGetPromoCategorized();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PromoCenterPresenter promoCenterPresenter, boolean z) {
        if (z) {
            promoCenterPresenter.lookAheadTest--;
            promoCenterPresenter.isLayoutRequested.onErrorLoadMorePromo(true);
            return;
        }
        promoCenterPresenter.isLayoutRequested.onErrorGetPromo();
    }

    private final void PlaceComponentResult(int p0) {
        DefaultObserver<PromoAds> defaultObserver = this.initRecordTimeStamp;
        if (defaultObserver != null) {
            defaultObserver.dispose();
        }
        this.initRecordTimeStamp = null;
        GetPromoAds getPromoAds = this.KClassImpl$Data$declaredNonStaticMembers$2;
        DefaultObserver<PromoAds> KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        Location location = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        double latitude = location != null ? location.getLatitude() : 0.0d;
        Location location2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        getPromoAds.execute(KClassImpl$Data$declaredNonStaticMembers$2, new GetPromoAds.PromoAdsParams(p0, latitude, location2 != null ? location2.getLongitude() : 0.0d, ""));
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.Presenter
    public final void PlaceComponentResult() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            MyBillsEntityDataFactory();
        } else {
            getAuthRequestContext();
        }
    }
}
