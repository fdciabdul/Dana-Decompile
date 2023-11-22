package id.dana.notification;

import io.reactivex.subjects.PublishSubject;

/* loaded from: classes5.dex */
public class RxNotificationBus {
    private static RxNotificationBus PlaceComponentResult;
    public final PublishSubject<Boolean> KClassImpl$Data$declaredNonStaticMembers$2 = PublishSubject.PlaceComponentResult();

    public static RxNotificationBus BuiltInFictitiousFunctionClassFactory() {
        if (PlaceComponentResult == null) {
            PlaceComponentResult = new RxNotificationBus();
        }
        return PlaceComponentResult;
    }
}
