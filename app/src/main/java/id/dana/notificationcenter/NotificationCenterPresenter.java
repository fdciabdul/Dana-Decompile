package id.dana.notificationcenter;

import id.dana.domain.DefaultObserver;
import id.dana.domain.notificationcenter.interactor.FetchUserInbox;
import id.dana.domain.notificationcenter.interactor.MarkNotificationAsRead;
import id.dana.domain.notificationcenter.model.FetchInboxResponse;
import id.dana.domain.notificationcenter.model.MarkNotificationResponse;
import id.dana.domain.notificationcenter.model.NotificationDTOResponse;
import id.dana.notificationcenter.NotificationCenterContract;
import id.dana.notificationcenter.mapper.NotificationCenterMapper;
import id.dana.notificationcenter.model.NotificationCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class NotificationCenterPresenter implements NotificationCenterContract.Presenter {
    private final MarkNotificationAsRead BuiltInFictitiousFunctionClassFactory;
    private final NotificationCenterMapper MyBillsEntityDataFactory;
    private final NotificationCenterContract.View PlaceComponentResult;
    private final FetchUserInbox getAuthRequestContext;

    @Inject
    public NotificationCenterPresenter(NotificationCenterContract.View view, NotificationCenterMapper notificationCenterMapper, FetchUserInbox fetchUserInbox, MarkNotificationAsRead markNotificationAsRead) {
        this.PlaceComponentResult = view;
        this.MyBillsEntityDataFactory = notificationCenterMapper;
        this.getAuthRequestContext = fetchUserInbox;
        this.BuiltInFictitiousFunctionClassFactory = markNotificationAsRead;
    }

    @Override // id.dana.notificationcenter.NotificationCenterContract.Presenter
    public final void getAuthRequestContext(int i, String str, String str2) {
        if (str == null) {
            this.PlaceComponentResult.showProgress();
        }
        this.getAuthRequestContext.execute(new DefaultObserver<FetchInboxResponse>() { // from class: id.dana.notificationcenter.NotificationCenterPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                FetchInboxResponse fetchInboxResponse = (FetchInboxResponse) obj;
                NotificationCenterPresenter.this.PlaceComponentResult.dismissProgress();
                if (fetchInboxResponse.isSuccess()) {
                    NotificationCenterContract.View view = NotificationCenterPresenter.this.PlaceComponentResult;
                    NotificationCenterMapper unused = NotificationCenterPresenter.this.MyBillsEntityDataFactory;
                    NotificationCenter notificationCenter = null;
                    r1 = null;
                    ArrayList arrayList = null;
                    if (fetchInboxResponse != null) {
                        NotificationCenter notificationCenter2 = new NotificationCenter();
                        notificationCenter2.MyBillsEntityDataFactory = fetchInboxResponse.isHasMore();
                        notificationCenter2.getAuthRequestContext = fetchInboxResponse.getMaxId();
                        List<NotificationDTOResponse> notifications = fetchInboxResponse.getNotifications();
                        if (notifications != null && notifications.size() > 0) {
                            arrayList = new ArrayList();
                            Iterator<NotificationDTOResponse> it = notifications.iterator();
                            while (it.hasNext()) {
                                arrayList.add(NotificationCenterMapper.PlaceComponentResult(it.next()));
                            }
                        }
                        notificationCenter2.BuiltInFictitiousFunctionClassFactory = arrayList;
                        notificationCenter = notificationCenter2;
                    }
                    view.KClassImpl$Data$declaredNonStaticMembers$2(notificationCenter);
                    return;
                }
                NotificationCenterContract.View view2 = NotificationCenterPresenter.this.PlaceComponentResult;
                fetchInboxResponse.getErrorMessage();
                view2.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                NotificationCenterPresenter.this.PlaceComponentResult.dismissProgress();
                NotificationCenterPresenter.this.PlaceComponentResult.onError(th.getMessage());
            }
        }, FetchUserInbox.Params.forFetchUserInbox(i, str, str2));
    }

    @Override // id.dana.notificationcenter.NotificationCenterContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String str, final String str2) {
        this.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<MarkNotificationResponse>() { // from class: id.dana.notificationcenter.NotificationCenterPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                MarkNotificationResponse markNotificationResponse = (MarkNotificationResponse) obj;
                if (markNotificationResponse.isSuccess()) {
                    NotificationCenterContract.View unused = NotificationCenterPresenter.this.PlaceComponentResult;
                    return;
                }
                NotificationCenterContract.View unused2 = NotificationCenterPresenter.this.PlaceComponentResult;
                markNotificationResponse.getErrorMessage();
            }
        }, MarkNotificationAsRead.Params.forMarkNotificationAsRead(str));
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.getAuthRequestContext.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}
