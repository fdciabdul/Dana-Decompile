package id.dana.animation.promobanner;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.animation.promobanner.NewPromoBannerContract;
import id.dana.domain.announcement.interactor.GetAnnouncements;
import id.dana.domain.announcement.interactor.GetGnAnnouncementsId;
import id.dana.domain.announcement.interactor.GetTrackedAnnouncementsId;
import id.dana.domain.announcement.interactor.SaveTrackedAnnouncementId;
import id.dana.domain.featureconfig.interactor.CheckAnnouncementFeature;
import id.dana.domain.home.interactor.GetPromoBannerAnnouncementFromPersistence;
import id.dana.domain.home.interactor.GetPromoBannerContentFromPersistence;
import id.dana.domain.home.interactor.SavePromoBannerAnnouncementIntoPersistence;
import id.dana.domain.home.interactor.SavePromoBannerCdpContentIntoPersistence;
import id.dana.domain.promotion.interactor.GetHomePromotionBanner;
import id.dana.pushverify.tracker.PushVerifyTracker;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NewPromoBannerPresenter_Factory implements Factory<NewPromoBannerPresenter> {
    private final Provider<CheckAnnouncementFeature> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetPromoBannerAnnouncementFromPersistence> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetAnnouncements> MyBillsEntityDataFactory;
    private final Provider<SavePromoBannerAnnouncementIntoPersistence> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<SaveTrackedAnnouncementId> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<NewPromoBannerContract.View> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<GetGnAnnouncementsId> getAuthRequestContext;
    private final Provider<GetTrackedAnnouncementsId> getErrorConfigVersion;
    private final Provider<SavePromoBannerCdpContentIntoPersistence> initRecordTimeStamp;
    private final Provider<GetHomePromotionBanner> lookAheadTest;
    private final Provider<GetPromoBannerContentFromPersistence> moveToNextValue;
    private final Provider<PushVerifyTracker> scheduleImpl;

    private NewPromoBannerPresenter_Factory(Provider<NewPromoBannerContract.View> provider, Provider<GetHomePromotionBanner> provider2, Provider<CheckAnnouncementFeature> provider3, Provider<GetAnnouncements> provider4, Provider<GetGnAnnouncementsId> provider5, Provider<GetTrackedAnnouncementsId> provider6, Provider<SaveTrackedAnnouncementId> provider7, Provider<SavePromoBannerCdpContentIntoPersistence> provider8, Provider<SavePromoBannerAnnouncementIntoPersistence> provider9, Provider<GetPromoBannerContentFromPersistence> provider10, Provider<GetPromoBannerAnnouncementFromPersistence> provider11, Provider<PushVerifyTracker> provider12, Provider<Context> provider13) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider;
        this.lookAheadTest = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.getAuthRequestContext = provider5;
        this.getErrorConfigVersion = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider7;
        this.initRecordTimeStamp = provider8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider9;
        this.moveToNextValue = provider10;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider11;
        this.scheduleImpl = provider12;
        this.PlaceComponentResult = provider13;
    }

    public static NewPromoBannerPresenter_Factory MyBillsEntityDataFactory(Provider<NewPromoBannerContract.View> provider, Provider<GetHomePromotionBanner> provider2, Provider<CheckAnnouncementFeature> provider3, Provider<GetAnnouncements> provider4, Provider<GetGnAnnouncementsId> provider5, Provider<GetTrackedAnnouncementsId> provider6, Provider<SaveTrackedAnnouncementId> provider7, Provider<SavePromoBannerCdpContentIntoPersistence> provider8, Provider<SavePromoBannerAnnouncementIntoPersistence> provider9, Provider<GetPromoBannerContentFromPersistence> provider10, Provider<GetPromoBannerAnnouncementFromPersistence> provider11, Provider<PushVerifyTracker> provider12, Provider<Context> provider13) {
        return new NewPromoBannerPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NewPromoBannerPresenter(this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), this.PlaceComponentResult.get());
    }
}
