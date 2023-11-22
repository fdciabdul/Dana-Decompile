package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink;
import id.dana.domain.deeplink.model.DeepLink;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature;
import id.dana.domain.referral.interactor.GetReferralConsult;
import id.dana.domain.referral.model.MyReferralConsultRpcResponse;
import id.dana.referral.MyReferralDetailActivity;
import id.dana.referral.model.MyReferralConsult;
import id.dana.referral.model.MyReferralConsultMapper;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public class FeatureReferral {
    private CheckShowReferralCodeFeature BuiltInFictitiousFunctionClassFactory;
    MyReferralConsult KClassImpl$Data$declaredNonStaticMembers$2;
    String MyBillsEntityDataFactory;
    private GenerateReferralDeepLink PlaceComponentResult;
    Activity getAuthRequestContext;

    public FeatureReferral(Activity activity, GetReferralConsult getReferralConsult, CheckShowReferralCodeFeature checkShowReferralCodeFeature, final MyReferralConsultMapper myReferralConsultMapper, GenerateReferralDeepLink generateReferralDeepLink) {
        this.getAuthRequestContext = activity;
        this.BuiltInFictitiousFunctionClassFactory = checkShowReferralCodeFeature;
        this.PlaceComponentResult = generateReferralDeepLink;
        getReferralConsult.execute(new DefaultObserver<MyReferralConsultRpcResponse>() { // from class: id.dana.contract.deeplink.path.FeatureReferral.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                FeatureReferral.KClassImpl$Data$declaredNonStaticMembers$2(FeatureReferral.this, myReferralConsultMapper.BuiltInFictitiousFunctionClassFactory((MyReferralConsultRpcResponse) obj));
            }
        });
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FeatureReferral featureReferral, MyReferralConsult myReferralConsult) {
        featureReferral.KClassImpl$Data$declaredNonStaticMembers$2 = myReferralConsult;
        if (myReferralConsult.KClassImpl$Data$declaredNonStaticMembers$2 != null && myReferralConsult.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory()) {
            featureReferral.PlaceComponentResult.execute(new DefaultObserver<DeepLink>() { // from class: id.dana.contract.deeplink.path.FeatureReferral.2
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public /* synthetic */ void onNext(Object obj) {
                    FeatureReferral.this.MyBillsEntityDataFactory = ((DeepLink) obj).getLink();
                    FeatureReferral.getAuthRequestContext(FeatureReferral.this);
                }
            }, GenerateReferralDeepLink.Params.forParams(myReferralConsult.MyBillsEntityDataFactory));
            return;
        }
        Activity activity = featureReferral.getAuthRequestContext;
        ((BaseActivity) activity).showWarningDialog(activity.getString(R.string.referral_campaign_off));
    }

    static /* synthetic */ void getAuthRequestContext(final FeatureReferral featureReferral) {
        featureReferral.BuiltInFictitiousFunctionClassFactory.execute(Unit.INSTANCE, new Function1() { // from class: id.dana.contract.deeplink.path.FeatureReferral$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                FeatureReferral featureReferral2 = FeatureReferral.this;
                Activity activity = featureReferral2.getAuthRequestContext;
                boolean booleanValue = ((Boolean) obj).booleanValue();
                EventTrackerModel.Builder builder = new EventTrackerModel.Builder(activity.getApplicationContext());
                builder.MyBillsEntityDataFactory = TrackerKey.Event.REFERRER_PAGE_OPEN;
                EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", TrackerKey.SourceType.REFERRAL_DEEPLINK);
                MyBillsEntityDataFactory.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
                Intent intent = new Intent(activity, MyReferralDetailActivity.class);
                intent.putExtra(MyReferralDetailActivity.BundleKey.BUNDLE_REFERRAL_CONSULT, featureReferral2.KClassImpl$Data$declaredNonStaticMembers$2);
                intent.putExtra(MyReferralDetailActivity.BundleKey.BUNDLE_REFERRAL_DEEPLINK, featureReferral2.MyBillsEntityDataFactory);
                intent.putExtra(MyReferralDetailActivity.BundleKey.BUNDLE_SHOW_REFERRAL, booleanValue);
                activity.startActivity(intent);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.deeplink.path.FeatureReferral$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Throwable th = (Throwable) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
    }
}
