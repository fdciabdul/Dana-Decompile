package id.dana.social.presenter;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.feeds.domain.activation.interactor.GetFriendsFeedWithInitFeedAndFeatureCheck;
import id.dana.feeds.domain.activation.interactor.InitSocialFeed;
import id.dana.feeds.domain.activation.interactor.ObserveInitFeed;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.domain.timeline.interactor.GetTimeline;
import id.dana.social.contract.SocialWidgetContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SocialWidgetPresenter_Factory implements Factory<SocialWidgetPresenter> {
    private final Provider<GetFriendsFeedWithInitFeedAndFeatureCheck> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ObserveInitFeed> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<SaveShareFeedConsent> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetShareFeedConsent> PlaceComponentResult;
    private final Provider<GetFeedConfig> getAuthRequestContext;
    private final Provider<GetTimeline> lookAheadTest;
    private final Provider<SocialWidgetContract.View> moveToNextValue;
    private final Provider<InitSocialFeed> scheduleImpl;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SocialWidgetPresenter(DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue));
    }
}
