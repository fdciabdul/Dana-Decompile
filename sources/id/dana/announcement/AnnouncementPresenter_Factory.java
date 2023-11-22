package id.dana.announcement;

import dagger.internal.Factory;
import id.dana.announcement.AnnouncementContract;
import id.dana.domain.announcement.interactor.SaveGnAnnouncementId;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class AnnouncementPresenter_Factory implements Factory<AnnouncementPresenter> {
    private final Provider<AnnouncementContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SaveGnAnnouncementId> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new AnnouncementPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}
