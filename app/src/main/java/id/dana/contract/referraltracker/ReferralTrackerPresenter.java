package id.dana.contract.referraltracker;

import id.dana.contract.referraltracker.ReferralTrackerContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink;
import id.dana.domain.deeplink.model.DeepLink;
import id.dana.domain.featureconfig.interactor.GetReferralMessageTemplate;
import id.dana.domain.featureconfig.model.ReferralMessageTemplateConfig;
import id.dana.domain.promotion.CdpContent;
import id.dana.domain.promotion.Space;
import id.dana.domain.referral.interactor.GetLatestReferralCampaign;
import id.dana.domain.referral.interactor.GetReferralBanner;
import id.dana.domain.referral.interactor.GetReferralConsult;
import id.dana.domain.referral.interactor.SaveLastSeenReferralCampaign;
import id.dana.domain.referral.model.MyReferralConsultRpcResponse;
import id.dana.domain.referraltracker.interactor.GetReferralTracker;
import id.dana.domain.referraltracker.model.ReferralTracker;
import id.dana.domain.referralwidget.interactor.GetReferralWidgets;
import id.dana.domain.referralwidget.model.ReferralWidget;
import id.dana.domain.sendmoney.model.UserContact;
import id.dana.domain.synccontact.interactor.SyncOneContact;
import id.dana.mapper.ReferralTrackerModelMapper;
import id.dana.mapper.ReferralWidgetModelMapper;
import id.dana.referral.model.MyReferralConsult;
import id.dana.referral.model.MyReferralConsultMapper;
import id.dana.referral.model.ReferralBannerContent;
import id.dana.referral.model.ReferralBannerMapper;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 E2\u00020\u0001:\u0001EBy\b\u0007\u0012\u0006\u0010\u0003\u001a\u000204\u0012\u0006\u0010\u0010\u001a\u00020*\u0012\u0006\u00107\u001a\u00020.\u0012\u0006\u00108\u001a\u00020#\u0012\u0006\u00109\u001a\u000201\u0012\u0006\u0010:\u001a\u00020\u0012\u0012\u0006\u0010;\u001a\u00020\u0016\u0012\u0006\u0010<\u001a\u00020&\u0012\u0006\u0010=\u001a\u00020\u001c\u0012\u0006\u0010>\u001a\u00020(\u0012\u0006\u0010?\u001a\u00020 \u0012\u0006\u0010@\u001a\u00020\u0014\u0012\u0006\u0010A\u001a\u00020\u0018\u0012\u0006\u0010B\u001a\u00020\u001a¢\u0006\u0004\bC\u0010DJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\n\u0010\u000fJ\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\n\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0014\u0010\t\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0014\u0010\n\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\u000b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\f\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010$R\u0014\u0010!\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010'R\u0014\u0010\u001d\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010)R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010+\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u0010/\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106"}, d2 = {"Lid/dana/contract/referraltracker/ReferralTrackerPresenter;", "Lid/dana/contract/referraltracker/ReferralTrackerContract$Presenter;", "Lid/dana/referral/model/MyReferralConsult;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/referral/model/MyReferralConsult;)V", "getAuthRequestContext", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "scheduleImpl", "onDestroy", "", "(Ljava/lang/String;)V", "p1", "(Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/domain/deeplink/interactor/GenerateReferralDeepLink;", "Lid/dana/domain/deeplink/interactor/GenerateReferralDeepLink;", "Lid/dana/domain/referral/interactor/GetLatestReferralCampaign;", "Lid/dana/domain/referral/interactor/GetLatestReferralCampaign;", "Lid/dana/domain/referral/interactor/GetReferralBanner;", "Lid/dana/domain/referral/interactor/GetReferralBanner;", "Lid/dana/domain/referral/interactor/GetReferralConsult;", "Lid/dana/domain/referral/interactor/GetReferralConsult;", "Lid/dana/domain/featureconfig/interactor/GetReferralMessageTemplate;", "Lid/dana/domain/featureconfig/interactor/GetReferralMessageTemplate;", "Lid/dana/domain/referraltracker/interactor/GetReferralTracker;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/referraltracker/interactor/GetReferralTracker;", "getErrorConfigVersion", "Lid/dana/domain/referralwidget/interactor/GetReferralWidgets;", "lookAheadTest", "Lid/dana/domain/referralwidget/interactor/GetReferralWidgets;", "Lid/dana/referral/model/MyReferralConsultMapper;", "Lid/dana/referral/model/MyReferralConsultMapper;", "moveToNextValue", "Lid/dana/referral/model/ReferralBannerMapper;", "Lid/dana/referral/model/ReferralBannerMapper;", "Lid/dana/mapper/ReferralTrackerModelMapper;", "Lid/dana/mapper/ReferralTrackerModelMapper;", "Lid/dana/mapper/ReferralWidgetModelMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/mapper/ReferralWidgetModelMapper;", "DatabaseTableConfigUtil", "Lid/dana/domain/referral/interactor/SaveLastSeenReferralCampaign;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/domain/referral/interactor/SaveLastSeenReferralCampaign;", "Lid/dana/domain/synccontact/interactor/SyncOneContact;", "initRecordTimeStamp", "Lid/dana/domain/synccontact/interactor/SyncOneContact;", "Lid/dana/contract/referraltracker/ReferralTrackerContract$View;", "GetContactSyncConfig", "Lid/dana/contract/referraltracker/ReferralTrackerContract$View;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "<init>", "(Lid/dana/contract/referraltracker/ReferralTrackerContract$View;Lid/dana/mapper/ReferralWidgetModelMapper;Lid/dana/domain/referral/interactor/SaveLastSeenReferralCampaign;Lid/dana/referral/model/MyReferralConsultMapper;Lid/dana/domain/synccontact/interactor/SyncOneContact;Lid/dana/domain/deeplink/interactor/GenerateReferralDeepLink;Lid/dana/domain/referral/interactor/GetReferralBanner;Lid/dana/referral/model/ReferralBannerMapper;Lid/dana/domain/referraltracker/interactor/GetReferralTracker;Lid/dana/mapper/ReferralTrackerModelMapper;Lid/dana/domain/referralwidget/interactor/GetReferralWidgets;Lid/dana/domain/referral/interactor/GetLatestReferralCampaign;Lid/dana/domain/referral/interactor/GetReferralConsult;Lid/dana/domain/featureconfig/interactor/GetReferralMessageTemplate;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReferralTrackerPresenter implements ReferralTrackerContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GenerateReferralDeepLink getAuthRequestContext;
    private final ReferralTrackerContract.View GetContactSyncConfig;
    private final GetLatestReferralCampaign KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetReferralBanner BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final GetReferralTracker getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final ReferralWidgetModelMapper DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final SaveLastSeenReferralCampaign NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final GetReferralConsult PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetReferralMessageTemplate MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final ReferralTrackerModelMapper NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final SyncOneContact NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private GetReferralWidgets scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final ReferralBannerMapper lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final MyReferralConsultMapper moveToNextValue;

    @Inject
    public ReferralTrackerPresenter(ReferralTrackerContract.View view, ReferralWidgetModelMapper referralWidgetModelMapper, SaveLastSeenReferralCampaign saveLastSeenReferralCampaign, MyReferralConsultMapper myReferralConsultMapper, SyncOneContact syncOneContact, GenerateReferralDeepLink generateReferralDeepLink, GetReferralBanner getReferralBanner, ReferralBannerMapper referralBannerMapper, GetReferralTracker getReferralTracker, ReferralTrackerModelMapper referralTrackerModelMapper, GetReferralWidgets getReferralWidgets, GetLatestReferralCampaign getLatestReferralCampaign, GetReferralConsult getReferralConsult, GetReferralMessageTemplate getReferralMessageTemplate) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(referralWidgetModelMapper, "");
        Intrinsics.checkNotNullParameter(saveLastSeenReferralCampaign, "");
        Intrinsics.checkNotNullParameter(myReferralConsultMapper, "");
        Intrinsics.checkNotNullParameter(syncOneContact, "");
        Intrinsics.checkNotNullParameter(generateReferralDeepLink, "");
        Intrinsics.checkNotNullParameter(getReferralBanner, "");
        Intrinsics.checkNotNullParameter(referralBannerMapper, "");
        Intrinsics.checkNotNullParameter(getReferralTracker, "");
        Intrinsics.checkNotNullParameter(referralTrackerModelMapper, "");
        Intrinsics.checkNotNullParameter(getReferralWidgets, "");
        Intrinsics.checkNotNullParameter(getLatestReferralCampaign, "");
        Intrinsics.checkNotNullParameter(getReferralConsult, "");
        Intrinsics.checkNotNullParameter(getReferralMessageTemplate, "");
        this.GetContactSyncConfig = view;
        this.DatabaseTableConfigUtil = referralWidgetModelMapper;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = saveLastSeenReferralCampaign;
        this.moveToNextValue = myReferralConsultMapper;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = syncOneContact;
        this.getAuthRequestContext = generateReferralDeepLink;
        this.BuiltInFictitiousFunctionClassFactory = getReferralBanner;
        this.lookAheadTest = referralBannerMapper;
        this.getErrorConfigVersion = getReferralTracker;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = referralTrackerModelMapper;
        this.scheduleImpl = getReferralWidgets;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getLatestReferralCampaign;
        this.PlaceComponentResult = getReferralConsult;
        this.MyBillsEntityDataFactory = getReferralMessageTemplate;
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.Presenter
    public final void scheduleImpl() {
        this.scheduleImpl.execute(NoParams.INSTANCE, new Function1<List<? extends ReferralWidget>, Unit>() { // from class: id.dana.contract.referraltracker.ReferralTrackerPresenter$getReferralWidgets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ReferralWidget> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends ReferralWidget> list) {
                ReferralTrackerContract.View view;
                ReferralWidgetModelMapper referralWidgetModelMapper;
                Intrinsics.checkNotNullParameter(list, "");
                view = ReferralTrackerPresenter.this.GetContactSyncConfig;
                referralWidgetModelMapper = ReferralTrackerPresenter.this.DatabaseTableConfigUtil;
                view.setReferralWidgetFeatureValue(referralWidgetModelMapper.apply(list));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.referraltracker.ReferralTrackerPresenter$getReferralWidgets$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REFERRAL_TAG, sb.toString());
            }
        });
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.Presenter
    public final void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<MyReferralConsultRpcResponse>() { // from class: id.dana.contract.referraltracker.ReferralTrackerPresenter$getLatestReferralCampaign$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ReferralTrackerContract.View view;
                MyReferralConsultMapper myReferralConsultMapper;
                MyReferralConsultRpcResponse myReferralConsultRpcResponse = (MyReferralConsultRpcResponse) obj;
                Intrinsics.checkNotNullParameter(myReferralConsultRpcResponse, "");
                if (myReferralConsultRpcResponse.isCampaignEnable() && myReferralConsultRpcResponse.isCampaignUpdated()) {
                    view = ReferralTrackerPresenter.this.GetContactSyncConfig;
                    myReferralConsultMapper = ReferralTrackerPresenter.this.moveToNextValue;
                    view.onFinishCheckLatestReferralCampaign(myReferralConsultMapper.BuiltInFictitiousFunctionClassFactory(myReferralConsultRpcResponse));
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.onError(p0);
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.REFERRAL_CONSULT, DanaLogConstants.ExceptionType.REFERRAL_EXCEPTION, p0);
            }
        });
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.execute(new DefaultObserver(), SaveLastSeenReferralCampaign.Params.forReferralCampaignId(p0));
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.referraltracker.ReferralTrackerPresenter$syncOneDanaContact$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ReferralTrackerContract.View view;
                boolean booleanValue = ((Boolean) obj).booleanValue();
                view = ReferralTrackerPresenter.this.GetContactSyncConfig;
                view.onCheckRegisteredUser(booleanValue, p0);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.CONTACT_SYNC, DanaLogConstants.ExceptionType.CONTACT_SYNC_EXCEPTION, p02);
            }
        }, SyncOneContact.Params.forSyncOneContact(p0, new UserContact(p0, p1, null)));
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.PlaceComponentResult.execute(new DefaultObserver<MyReferralConsultRpcResponse>() { // from class: id.dana.contract.referraltracker.ReferralTrackerPresenter$getReferralConsult$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ReferralTrackerContract.View view;
                MyReferralConsultMapper myReferralConsultMapper;
                MyReferralConsultRpcResponse myReferralConsultRpcResponse = (MyReferralConsultRpcResponse) obj;
                Intrinsics.checkNotNullParameter(myReferralConsultRpcResponse, "");
                view = ReferralTrackerPresenter.this.GetContactSyncConfig;
                myReferralConsultMapper = ReferralTrackerPresenter.this.moveToNextValue;
                view.onGetReferralConsultSuccess(myReferralConsultMapper.BuiltInFictitiousFunctionClassFactory(myReferralConsultRpcResponse));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.onError(p0);
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.REFERRAL_CONSULT, DanaLogConstants.ExceptionType.REFERRAL_EXCEPTION, p0);
            }
        });
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.Presenter
    public final void MyBillsEntityDataFactory(MyReferralConsult p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.execute(new DefaultObserver<DeepLink>() { // from class: id.dana.contract.referraltracker.ReferralTrackerPresenter$getDeeplinkReferral$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ReferralTrackerContract.View view;
                DeepLink deepLink = (DeepLink) obj;
                Intrinsics.checkNotNullParameter(deepLink, "");
                view = ReferralTrackerPresenter.this.GetContactSyncConfig;
                view.onGetDeeplinkReferralSuccess(deepLink);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.DEEPLINK_PREFIX, DanaLogConstants.ExceptionType.REFERRAL_EXCEPTION, p02);
            }
        }, GenerateReferralDeepLink.Params.forParams(p0.MyBillsEntityDataFactory));
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<ReferralMessageTemplateConfig, Unit>() { // from class: id.dana.contract.referraltracker.ReferralTrackerPresenter$getMessageTemplate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ReferralMessageTemplateConfig referralMessageTemplateConfig) {
                invoke2(referralMessageTemplateConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ReferralMessageTemplateConfig referralMessageTemplateConfig) {
                ReferralTrackerContract.View view;
                view = ReferralTrackerPresenter.this.GetContactSyncConfig;
                view.onGetMessageTemplateSuccess(referralMessageTemplateConfig);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.referraltracker.ReferralTrackerPresenter$getMessageTemplate$2
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
                ReferralTrackerContract.View view;
                view = ReferralTrackerPresenter.this.GetContactSyncConfig;
                view.onGetMessageTemplateError();
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.REFERRAL_MESSAGE_TEMPLATE, DanaLogConstants.ExceptionType.REFERRAL_EXCEPTION, th);
            }
        });
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<Space>() { // from class: id.dana.contract.referraltracker.ReferralTrackerPresenter$getReferralBanner$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ReferralTrackerContract.View view;
                ReferralTrackerContract.View view2;
                ReferralBannerMapper referralBannerMapper;
                Space space = (Space) obj;
                Intrinsics.checkNotNullParameter(space, "");
                List<CdpContent> cdpContents = space.getCdpContents();
                String spaceCode = space.getSpaceCode();
                if (cdpContents == null || (!cdpContents.isEmpty()) == false) {
                    view = ReferralTrackerPresenter.this.GetContactSyncConfig;
                    view.onGetReferralBannerError();
                    return;
                }
                view2 = ReferralTrackerPresenter.this.GetContactSyncConfig;
                referralBannerMapper = ReferralTrackerPresenter.this.lookAheadTest;
                Intrinsics.checkNotNullExpressionValue(spaceCode, "");
                Intrinsics.checkNotNullParameter(spaceCode, "");
                ArrayList arrayList = new ArrayList();
                referralBannerMapper.MyBillsEntityDataFactory = spaceCode;
                Intrinsics.checkNotNull(cdpContents);
                for (CdpContent cdpContent : cdpContents) {
                    Intrinsics.checkNotNullParameter(cdpContent, "");
                    ReferralBannerContent map = referralBannerMapper.map(cdpContent);
                    Intrinsics.checkNotNull(map);
                    arrayList.add(map);
                }
                view2.onGetReferralBannerSuccess(arrayList);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                ReferralTrackerContract.View view;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onError(p0);
                view = ReferralTrackerPresenter.this.GetContactSyncConfig;
                view.onGetReferralBannerError();
            }
        });
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.Presenter
    public final void PlaceComponentResult() {
        this.getErrorConfigVersion.execute(new DefaultObserver<ReferralTracker>() { // from class: id.dana.contract.referraltracker.ReferralTrackerPresenter$getReferralTracker$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ReferralTrackerContract.View view;
                ReferralTrackerModelMapper referralTrackerModelMapper;
                ReferralTracker referralTracker = (ReferralTracker) obj;
                Intrinsics.checkNotNullParameter(referralTracker, "");
                view = ReferralTrackerPresenter.this.GetContactSyncConfig;
                referralTrackerModelMapper = ReferralTrackerPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.onGetReferralTrackerSuccess(referralTrackerModelMapper.apply(referralTracker));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                ReferralTrackerContract.View view;
                Intrinsics.checkNotNullParameter(p0, "");
                view = ReferralTrackerPresenter.this.GetContactSyncConfig;
                view.onGetReferralTrackerError();
            }
        }, GetReferralTracker.Params.forReferralTracker(1, 5));
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.scheduleImpl.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.dispose();
        this.PlaceComponentResult.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.getErrorConfigVersion.dispose();
    }
}
