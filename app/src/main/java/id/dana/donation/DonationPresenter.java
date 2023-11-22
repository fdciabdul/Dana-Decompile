package id.dana.donation;

import com.huawei.hms.framework.common.ContainerUtils;
import id.dana.data.constant.DanaUrl;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.donation.interactor.GetDonationCampaigns;
import id.dana.domain.donation.model.DonationCampaign;
import id.dana.domain.featureconfig.interactor.GetDonationCampaignConfig;
import id.dana.domain.featureconfig.model.DonationCampaignConfig;
import id.dana.donation.DonationContract;
import id.dana.donation.mapper.DonationCampaignModelMapperKt;
import id.dana.donation.model.DonationCampaignModel;
import id.dana.kyb.constant.KybServiceRedirectType;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0010\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/donation/DonationPresenter;", "Lid/dana/donation/DonationContract$Presenter;", "Lid/dana/donation/model/DonationCampaignModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/donation/model/DonationCampaignModel;)V", "()V", "onDestroy", "Lid/dana/domain/authcode/interactor/GetAuthCode;", "Lid/dana/domain/authcode/interactor/GetAuthCode;", "Lid/dana/domain/featureconfig/interactor/GetDonationCampaignConfig;", "MyBillsEntityDataFactory", "Lid/dana/domain/featureconfig/interactor/GetDonationCampaignConfig;", "getAuthRequestContext", "Lid/dana/domain/donation/interactor/GetDonationCampaigns;", "PlaceComponentResult", "Lid/dana/domain/donation/interactor/GetDonationCampaigns;", "Lid/dana/donation/DonationContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/donation/DonationContract$View;", "p1", "p2", "p3", "<init>", "(Lid/dana/donation/DonationContract$View;Lid/dana/domain/donation/interactor/GetDonationCampaigns;Lid/dana/domain/authcode/interactor/GetAuthCode;Lid/dana/domain/featureconfig/interactor/GetDonationCampaignConfig;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes8.dex */
public final class DonationPresenter implements DonationContract.Presenter {
    private final GetAuthCode BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final DonationContract.View PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetDonationCampaignConfig getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetDonationCampaigns MyBillsEntityDataFactory;

    @Inject
    public DonationPresenter(DonationContract.View view, GetDonationCampaigns getDonationCampaigns, GetAuthCode getAuthCode, GetDonationCampaignConfig getDonationCampaignConfig) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getDonationCampaigns, "");
        Intrinsics.checkNotNullParameter(getAuthCode, "");
        Intrinsics.checkNotNullParameter(getDonationCampaignConfig, "");
        this.PlaceComponentResult = view;
        this.MyBillsEntityDataFactory = getDonationCampaigns;
        this.BuiltInFictitiousFunctionClassFactory = getAuthCode;
        this.getAuthRequestContext = getDonationCampaignConfig;
    }

    @Override // id.dana.donation.DonationContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.getAuthRequestContext.execute(new DefaultObserver<DonationCampaignConfig>() { // from class: id.dana.donation.DonationPresenter$getDonations$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                DonationContract.View view;
                DonationCampaignConfig donationCampaignConfig = (DonationCampaignConfig) obj;
                Intrinsics.checkNotNullParameter(donationCampaignConfig, "");
                super.onNext(donationCampaignConfig);
                if (donationCampaignConfig.isFeatureEnable()) {
                    view = DonationPresenter.this.PlaceComponentResult;
                    view.MyBillsEntityDataFactory(donationCampaignConfig);
                    r2.MyBillsEntityDataFactory.execute(new DefaultObserver<List<? extends DonationCampaign>>() { // from class: id.dana.donation.DonationPresenter$getDonationCampaign$1
                        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                        public final /* synthetic */ void onNext(Object obj2) {
                            DonationContract.View view2;
                            List list = (List) obj2;
                            Intrinsics.checkNotNullParameter(list, "");
                            super.onNext(list);
                            view2 = DonationPresenter.this.PlaceComponentResult;
                            view2.BuiltInFictitiousFunctionClassFactory(DonationCampaignModelMapperKt.getAuthRequestContext(list));
                        }

                        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                        public final void onError(Throwable p0) {
                            Intrinsics.checkNotNullParameter(p0, "");
                            super.onError(p0);
                            CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.DONATION_WIDGET, DanaLogConstants.ExceptionType.DONATION_CAMPAIGN_EXCEPTION, p0);
                        }
                    });
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.onError(p0);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.DONATION_WIDGET, DanaLogConstants.ExceptionType.DONATION_CAMPAIGN_EXCEPTION, p0);
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.getAuthRequestContext.dispose();
    }

    @Override // id.dana.donation.DonationContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final DonationCampaignModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (!Intrinsics.areEqual(p0.getErrorConfigVersion, KybServiceRedirectType.AUTH)) {
            this.PlaceComponentResult.MyBillsEntityDataFactory(p0.scheduleImpl);
        } else {
            this.BuiltInFictitiousFunctionClassFactory.execute(GetAuthCode.Params.INSTANCE.forGetAuthCode(p0.scheduleImpl, p0.getAuthRequestContext, p0.NetworkUserEntityData$$ExternalSyntheticLambda0, p0.getPlaceComponentResult()), new Function1<AuthCodeResult, Unit>() { // from class: id.dana.donation.DonationPresenter$getAuthCode$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(AuthCodeResult authCodeResult) {
                    invoke2(authCodeResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(AuthCodeResult authCodeResult) {
                    DonationContract.View view;
                    String obj;
                    Intrinsics.checkNotNullParameter(authCodeResult, "");
                    view = DonationPresenter.this.PlaceComponentResult;
                    DonationCampaignModel donationCampaignModel = p0;
                    String authCode = authCodeResult.getAuthCode();
                    Intrinsics.checkNotNullParameter(donationCampaignModel, "");
                    String str = donationCampaignModel.scheduleImpl;
                    String str2 = donationCampaignModel.lookAheadTest;
                    String str3 = authCode;
                    if (!(str3 == null || str3.length() == 0)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "?", false, 2, (Object) null)) {
                            if (StringsKt.endsWith$default(str, "?", false, 2, (Object) null)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(DanaUrl.SERVICE_AUTHCODE);
                                sb2.append(authCode);
                                obj = StringsKt.replace$default(sb2.toString(), "?", "", false, 4, (Object) null);
                            } else {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(DanaUrl.SERVICE_AUTHCODE);
                                sb3.append(authCode);
                                obj = StringsKt.replace$default(sb3.toString(), "?", ContainerUtils.FIELD_DELIMITER, false, 4, (Object) null);
                            }
                        } else {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(DanaUrl.SERVICE_AUTHCODE);
                            sb4.append(authCode);
                            obj = sb4.toString();
                        }
                        sb.append(obj);
                        str = sb.toString();
                    }
                    if (str2.length() > 0) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str);
                        sb5.append(DanaUrl.SERVICE_REQUEST_ID);
                        sb5.append(str2);
                        str = sb5.toString();
                    }
                    String str4 = str;
                    String str5 = str4;
                    if (StringsKt.contains$default((CharSequence) str5, (CharSequence) ContainerUtils.FIELD_DELIMITER, false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str5, (CharSequence) "?", false, 2, (Object) null)) {
                        str4 = StringsKt.replaceFirst$default(str4, ContainerUtils.FIELD_DELIMITER, "?", false, 4, (Object) null);
                    }
                    view.MyBillsEntityDataFactory(str4);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.donation.DonationPresenter$getAuthCode$2
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "");
                    CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.DONATION_WIDGET, DanaLogConstants.ExceptionType.DONATION_CAMPAIGN_EXCEPTION, th);
                }
            });
        }
    }
}
