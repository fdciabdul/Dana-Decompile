package id.dana.contract.promodiscovery;

import android.location.Location;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.base.BasePresenter;
import id.dana.contract.promodiscovery.PromoDiscoveryContract;
import id.dana.contract.promodiscovery.mapper.PromoDiscoverModelMapperKt;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature;
import id.dana.domain.geocode.interactor.GetLatestSubdivision;
import id.dana.domain.geocode.model.LocationSubdisivision;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.promocenter.interactor.GetPromoCategorizedList;
import id.dana.domain.promocenter.interactor.GetPromoList;
import id.dana.domain.promocenter.model.CategoryPromo;
import id.dana.domain.promocenter.model.Promo;
import id.dana.domain.promocenter.model.PromoAction;
import id.dana.domain.promocenter.model.PromoResult;
import id.dana.domain.promodiscovery.interactor.GetDanaDealsThumbnail;
import id.dana.domain.promodiscovery.interactor.GetFourKingsPromo;
import id.dana.domain.promodiscovery.interactor.GetPromoDiscoverySectionConfig;
import id.dana.domain.promodiscovery.interactor.SwitchFourKingsPromoRedDot;
import id.dana.domain.promodiscovery.model.FourKingsPromoModel;
import id.dana.domain.promodiscovery.model.ProductInfoDiscoveryModel;
import id.dana.domain.promodiscovery.model.PromoDiscoverySectionConfig;
import id.dana.domain.services.interactor.GetService;
import id.dana.myprofile.settingconfig.ReferralSettingConfigRunner;
import id.dana.promocenter.mapper.PromoAdsModelMapperKt;
import id.dana.promocenter.model.PromoActionType;
import id.dana.promodiscovery.mapper.FourKingPromoMapperKt;
import id.dana.promodiscovery.model.FourKingItem;
import id.dana.referral.model.MyReferralConsult;
import id.dana.referral.model.MyReferralConsultMapper;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GBq\b\u0007\u0012\u0006\u0010\u0004\u001a\u000208\u0012\u0006\u0010\t\u001a\u00020'\u0012\u0006\u0010\u000b\u001a\u00020\u001e\u0012\u0006\u0010;\u001a\u00020\u001e\u0012\u0006\u0010<\u001a\u00020$\u0012\u0006\u0010=\u001a\u00020\u001c\u0012\u0006\u0010>\u001a\u000200\u0012\u0006\u0010?\u001a\u00020\u001a\u0012\u0006\u0010@\u001a\u00020-\u0012\u0006\u0010A\u001a\u00020 \u0012\u0006\u0010B\u001a\u000204\u0012\u0006\u0010C\u001a\u00020\"\u0012\u0006\u0010D\u001a\u00020+¢\u0006\u0004\bE\u0010FJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\f\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\f\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0010\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0014\u0010\u0010\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001dR\u0014\u0010\u0013\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0014\u0010\f\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010!R\u0014\u0010\u0012\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010#R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010(\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010,R\u0014\u0010\u0016\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010\u001fR\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:"}, d2 = {"Lid/dana/contract/promodiscovery/PromoDiscoveryPresenter;", "Lid/dana/base/BasePresenter;", "Lid/dana/contract/promodiscovery/PromoDiscoveryContract$Presenter;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/Integer;)V", "", "p1", "Landroid/location/Location;", "p2", "MyBillsEntityDataFactory", "(Ljava/lang/Integer;Ljava/lang/String;Landroid/location/Location;)V", "()V", "Lid/dana/domain/geocode/model/LocationSubdisivision;", "getAuthRequestContext", "()Lid/dana/domain/geocode/model/LocationSubdisivision;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/referral/model/MyReferralConsult;", "()Lid/dana/referral/model/MyReferralConsult;", "getErrorConfigVersion", "onDestroy", "Lid/dana/promodiscovery/model/FourKingItem;", "(Lid/dana/promodiscovery/model/FourKingItem;)V", "Lid/dana/domain/featureconfig/interactor/CheckShowReferralCodeFeature;", "Lid/dana/domain/featureconfig/interactor/CheckShowReferralCodeFeature;", "Lid/dana/domain/promodiscovery/interactor/GetDanaDealsThumbnail;", "Lid/dana/domain/promodiscovery/interactor/GetDanaDealsThumbnail;", "Lid/dana/domain/promocenter/interactor/GetPromoList;", "Lid/dana/domain/promocenter/interactor/GetPromoList;", "Lid/dana/domain/promodiscovery/interactor/GetFourKingsPromo;", "Lid/dana/domain/promodiscovery/interactor/GetFourKingsPromo;", "Lid/dana/domain/geocode/interactor/GetLatestSubdivision;", "Lid/dana/domain/geocode/interactor/GetLatestSubdivision;", "Lid/dana/domain/promocenter/interactor/GetPromoCategorizedList;", "Lid/dana/domain/promocenter/interactor/GetPromoCategorizedList;", "lookAheadTest", "Lid/dana/domain/promodiscovery/interactor/GetPromoDiscoverySectionConfig;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/promodiscovery/interactor/GetPromoDiscoverySectionConfig;", "scheduleImpl", "Lid/dana/domain/services/interactor/GetService;", "Lid/dana/domain/services/interactor/GetService;", "Lid/dana/referral/model/MyReferralConsultMapper;", "moveToNextValue", "Lid/dana/referral/model/MyReferralConsultMapper;", "Lid/dana/myprofile/settingconfig/ReferralSettingConfigRunner;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/myprofile/settingconfig/ReferralSettingConfigRunner;", "DatabaseTableConfigUtil", "Lid/dana/domain/promodiscovery/interactor/SwitchFourKingsPromoRedDot;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/domain/promodiscovery/interactor/SwitchFourKingsPromoRedDot;", "GetContactSyncConfig", "Lid/dana/contract/promodiscovery/PromoDiscoveryContract$View;", "initRecordTimeStamp", "Lid/dana/contract/promodiscovery/PromoDiscoveryContract$View;", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "<init>", "(Lid/dana/contract/promodiscovery/PromoDiscoveryContract$View;Lid/dana/domain/promodiscovery/interactor/GetPromoDiscoverySectionConfig;Lid/dana/domain/promocenter/interactor/GetPromoList;Lid/dana/domain/promocenter/interactor/GetPromoList;Lid/dana/domain/promocenter/interactor/GetPromoCategorizedList;Lid/dana/domain/promodiscovery/interactor/GetDanaDealsThumbnail;Lid/dana/myprofile/settingconfig/ReferralSettingConfigRunner;Lid/dana/domain/featureconfig/interactor/CheckShowReferralCodeFeature;Lid/dana/referral/model/MyReferralConsultMapper;Lid/dana/domain/promodiscovery/interactor/GetFourKingsPromo;Lid/dana/domain/promodiscovery/interactor/SwitchFourKingsPromoRedDot;Lid/dana/domain/geocode/interactor/GetLatestSubdivision;Lid/dana/domain/services/interactor/GetService;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromoDiscoveryPresenter extends BasePresenter implements PromoDiscoveryContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetDanaDealsThumbnail getAuthRequestContext;
    private final GetPromoList KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetFourKingsPromo MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final GetPromoDiscoverySectionConfig scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final ReferralSettingConfigRunner DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final SwitchFourKingsPromoRedDot GetContactSyncConfig;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetLatestSubdivision BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final CheckShowReferralCodeFeature PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final GetPromoCategorizedList lookAheadTest;
    private final PromoDiscoveryContract.View initRecordTimeStamp;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetService NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final MyReferralConsultMapper moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final GetPromoList getErrorConfigVersion;

    @Inject
    public PromoDiscoveryPresenter(PromoDiscoveryContract.View view, GetPromoDiscoverySectionConfig getPromoDiscoverySectionConfig, GetPromoList getPromoList, GetPromoList getPromoList2, GetPromoCategorizedList getPromoCategorizedList, GetDanaDealsThumbnail getDanaDealsThumbnail, ReferralSettingConfigRunner referralSettingConfigRunner, CheckShowReferralCodeFeature checkShowReferralCodeFeature, MyReferralConsultMapper myReferralConsultMapper, GetFourKingsPromo getFourKingsPromo, SwitchFourKingsPromoRedDot switchFourKingsPromoRedDot, GetLatestSubdivision getLatestSubdivision, GetService getService) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getPromoDiscoverySectionConfig, "");
        Intrinsics.checkNotNullParameter(getPromoList, "");
        Intrinsics.checkNotNullParameter(getPromoList2, "");
        Intrinsics.checkNotNullParameter(getPromoCategorizedList, "");
        Intrinsics.checkNotNullParameter(getDanaDealsThumbnail, "");
        Intrinsics.checkNotNullParameter(referralSettingConfigRunner, "");
        Intrinsics.checkNotNullParameter(checkShowReferralCodeFeature, "");
        Intrinsics.checkNotNullParameter(myReferralConsultMapper, "");
        Intrinsics.checkNotNullParameter(getFourKingsPromo, "");
        Intrinsics.checkNotNullParameter(switchFourKingsPromoRedDot, "");
        Intrinsics.checkNotNullParameter(getLatestSubdivision, "");
        Intrinsics.checkNotNullParameter(getService, "");
        this.initRecordTimeStamp = view;
        this.scheduleImpl = getPromoDiscoverySectionConfig;
        this.getErrorConfigVersion = getPromoList;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getPromoList2;
        this.lookAheadTest = getPromoCategorizedList;
        this.getAuthRequestContext = getDanaDealsThumbnail;
        this.DatabaseTableConfigUtil = referralSettingConfigRunner;
        this.PlaceComponentResult = checkShowReferralCodeFeature;
        this.moveToNextValue = myReferralConsultMapper;
        this.MyBillsEntityDataFactory = getFourKingsPromo;
        this.GetContactSyncConfig = switchFourKingsPromoRedDot;
        this.BuiltInFictitiousFunctionClassFactory = getLatestSubdivision;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getService;
    }

    @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.scheduleImpl.execute(NoParams.INSTANCE, new Function1<PromoDiscoverySectionConfig, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getPromoDiscoveryConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PromoDiscoverySectionConfig promoDiscoverySectionConfig) {
                invoke2(promoDiscoverySectionConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PromoDiscoverySectionConfig promoDiscoverySectionConfig) {
                PromoDiscoveryContract.View view;
                Intrinsics.checkNotNullParameter(promoDiscoverySectionConfig, "");
                view = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view.KClassImpl$Data$declaredNonStaticMembers$2(PromoDiscoverModelMapperKt.PlaceComponentResult(promoDiscoverySectionConfig));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getPromoDiscoveryConfig$2
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
                PromoDiscoveryContract.View view;
                PromoDiscoveryContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view.dismissProgress();
                view2 = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view2.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.Presenter
    public final void getAuthRequestContext(Integer p0) {
        this.getErrorConfigVersion.execute(GetPromoList.Params.INSTANCE.forGetPromo((p0 != null ? p0.intValue() : 5) - 1, 1, "NEW"), new Function1<PromoResult, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getVoucherListItem$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                PromoDiscoveryContract.View view;
                Intrinsics.checkNotNullParameter(promoResult, "");
                promoResult.getPromoList().add(0, PromoDiscoveryPresenter.scheduleImpl());
                view = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view.MyBillsEntityDataFactory(PromoAdsModelMapperKt.PlaceComponentResult(promoResult.getPromoList()));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getVoucherListItem$2
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
                PromoDiscoveryContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view.getErrorConfigVersion();
            }
        });
    }

    @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.PlaceComponentResult.execute(Unit.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getReferralConfigSetting$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                PromoDiscoveryContract.View view;
                view = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view.getAuthRequestContext(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getReferralConfigSetting$2
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
                PromoDiscoveryContract.View unused;
                Intrinsics.checkNotNullParameter(th, "");
                unused = PromoDiscoveryPresenter.this.initRecordTimeStamp;
            }
        });
    }

    @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.Presenter
    public final void MyBillsEntityDataFactory(Integer p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(GetPromoList.Params.INSTANCE.forGetPromo(p0 != null ? p0.intValue() : 5, 1, "NEAR_EXPIRED"), new Function1<PromoResult, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getExpiringPromoItem$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                PromoDiscoveryContract.View view;
                Intrinsics.checkNotNullParameter(promoResult, "");
                view = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view.KClassImpl$Data$declaredNonStaticMembers$2(PromoAdsModelMapperKt.PlaceComponentResult(promoResult.getPromoList()));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getExpiringPromoItem$2
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
                PromoDiscoveryContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view.MyBillsEntityDataFactory();
            }
        });
    }

    @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.Presenter
    public final void PlaceComponentResult(Integer p0) {
        this.lookAheadTest.execute(GetPromoCategorizedList.Params.Companion.forGetPromoCategorizedList$default(GetPromoCategorizedList.Params.INSTANCE, p0 != null ? p0.intValue() : 5, 1, "promocenter_category_bank", null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 24, null), new Function1<CategoryPromo, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getBankPromoItems$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                PromoDiscoveryContract.View view;
                Intrinsics.checkNotNullParameter(categoryPromo, "");
                view = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view.getAuthRequestContext(PromoAdsModelMapperKt.PlaceComponentResult(categoryPromo.getPromoList()));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getBankPromoItems$2
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
                PromoDiscoveryContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view.PlaceComponentResult();
            }
        });
    }

    @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.Presenter
    public final void MyBillsEntityDataFactory(Integer p0, String p1, Location p2) {
        GetDanaDealsThumbnail getDanaDealsThumbnail = this.getAuthRequestContext;
        int intValue = p0 != null ? p0.intValue() : 5;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double latitude = p2 != null ? p2.getLatitude() : 0.0d;
        if (p2 != null) {
            d = p2.getLongitude();
        }
        double d2 = d;
        if (p1 == null) {
            p1 = "SAVING_RATE";
        }
        getDanaDealsThumbnail.execute(new GetDanaDealsThumbnail.Params(intValue, latitude, d2, 0, p1), new Function1<List<? extends ProductInfoDiscoveryModel>, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getDanaDealsItems$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ProductInfoDiscoveryModel> list) {
                invoke2((List<ProductInfoDiscoveryModel>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<ProductInfoDiscoveryModel> list) {
                PromoDiscoveryContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                view = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view.BuiltInFictitiousFunctionClassFactory(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getDanaDealsItems$2
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
                PromoDiscoveryContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.Presenter
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<List<? extends FourKingsPromoModel>, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getFourKingItems$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends FourKingsPromoModel> list) {
                invoke2((List<FourKingsPromoModel>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<FourKingsPromoModel> list) {
                PromoDiscoveryContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                view = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view.PlaceComponentResult(FourKingPromoMapperKt.MyBillsEntityDataFactory(list));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getFourKingItems$2
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
                PromoDiscoveryContract.View unused;
                Intrinsics.checkNotNullParameter(th, "");
                unused = PromoDiscoveryPresenter.this.initRecordTimeStamp;
            }
        });
    }

    @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.Presenter
    public final void getAuthRequestContext(FourKingItem p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.GetContactSyncConfig.execute(FourKingPromoMapperKt.getAuthRequestContext(p0), new Function1<List<? extends FourKingsPromoModel>, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$switchFourKingsPromoRedDot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends FourKingsPromoModel> list) {
                invoke2((List<FourKingsPromoModel>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<FourKingsPromoModel> list) {
                PromoDiscoveryContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                view = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view.scheduleImpl(FourKingPromoMapperKt.MyBillsEntityDataFactory(list));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$switchFourKingsPromoRedDot$2
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
                PromoDiscoveryContract.View unused;
                Intrinsics.checkNotNullParameter(th, "");
                unused = PromoDiscoveryPresenter.this.initRecordTimeStamp;
            }
        });
    }

    @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.Presenter
    public final MyReferralConsult MyBillsEntityDataFactory() {
        MyReferralConsult BuiltInFictitiousFunctionClassFactory = this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(this.DatabaseTableConfigUtil.MyBillsEntityDataFactory);
        return BuiltInFictitiousFunctionClassFactory == null ? new MyReferralConsult() : BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.scheduleImpl.dispose();
        this.getErrorConfigVersion.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.lookAheadTest.dispose();
        this.PlaceComponentResult.dispose();
        this.getAuthRequestContext.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.GetContactSyncConfig.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
    }

    @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.Presenter
    public final LocationSubdisivision getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory.execute(new GetLatestSubdivision.Params(2L));
    }

    @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.Presenter
    public final void getErrorConfigVersion() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute("service_promo_quest", new Function1<ThirdPartyServiceResponse, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getServicePromoQuest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ThirdPartyServiceResponse thirdPartyServiceResponse) {
                invoke2(thirdPartyServiceResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ThirdPartyServiceResponse thirdPartyServiceResponse) {
                PromoDiscoveryContract.View view;
                Intrinsics.checkNotNullParameter(thirdPartyServiceResponse, "");
                view = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view.BuiltInFictitiousFunctionClassFactory(thirdPartyServiceResponse);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promodiscovery.PromoDiscoveryPresenter$getServicePromoQuest$2
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
                PromoDiscoveryContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = PromoDiscoveryPresenter.this.initRecordTimeStamp;
                view.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    public static final /* synthetic */ Promo scheduleImpl() {
        PromoAction promoAction = new PromoAction();
        promoAction.setType(PromoActionType.SECONDARY);
        promoAction.setName("DETAIL");
        promoAction.setRedirectUrl("/i/dana-promotion/claim-award");
        Promo promo = new Promo();
        promo.setPromoActions(CollectionsKt.listOf(promoAction));
        return promo;
    }
}
