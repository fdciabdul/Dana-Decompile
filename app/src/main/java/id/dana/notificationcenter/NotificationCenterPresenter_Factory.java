package id.dana.notificationcenter;

import dagger.internal.Factory;
import id.dana.domain.notificationcenter.interactor.FetchUserInbox;
import id.dana.domain.notificationcenter.interactor.MarkNotificationAsRead;
import id.dana.notificationcenter.NotificationCenterContract;
import id.dana.notificationcenter.mapper.NotificationCenterMapper;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class NotificationCenterPresenter_Factory implements Factory<NotificationCenterPresenter> {
    private final Provider<NotificationCenterContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FetchUserInbox> MyBillsEntityDataFactory;
    private final Provider<MarkNotificationAsRead> PlaceComponentResult;
    private final Provider<NotificationCenterMapper> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NotificationCenterPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
