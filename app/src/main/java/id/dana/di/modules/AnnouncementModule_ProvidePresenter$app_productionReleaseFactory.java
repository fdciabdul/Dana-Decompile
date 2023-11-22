package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.announcement.AnnouncementContract;
import id.dana.announcement.AnnouncementPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class AnnouncementModule_ProvidePresenter$app_productionReleaseFactory implements Factory<AnnouncementContract.Presenter> {
    private final AnnouncementModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<AnnouncementPresenter> MyBillsEntityDataFactory;

    public static AnnouncementContract.Presenter BuiltInFictitiousFunctionClassFactory(AnnouncementModule announcementModule, AnnouncementPresenter announcementPresenter) {
        return (AnnouncementContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(announcementModule.KClassImpl$Data$declaredNonStaticMembers$2(announcementPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AnnouncementContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
