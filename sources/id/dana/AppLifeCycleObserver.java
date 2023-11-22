package id.dana;

import androidx.view.Lifecycle;
import androidx.view.LifecycleObserver;
import androidx.view.OnLifecycleEvent;
import dagger.Lazy;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import id.dana.di.ComponentHolder;
import id.dana.toggle.locationpermission.LocationPermissionSubject;
import id.dana.utils.OSUtil;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

@Singleton
/* loaded from: classes.dex */
public class AppLifeCycleObserver implements LifecycleObserver {
    private final LocationPermissionSubject KClassImpl$Data$declaredNonStaticMembers$2;
    public Runnable getAuthRequestContext;
    private final Lazy<PreferenceAccountEntityData> getErrorConfigVersion;
    public final ArrayList<KeyBoardOperationListener> MyBillsEntityDataFactory = new ArrayList<>();
    private boolean BuiltInFictitiousFunctionClassFactory = true;
    private boolean PlaceComponentResult = false;

    /* loaded from: classes.dex */
    public interface KeyBoardOperationListener {
        void onHomeClicked();
    }

    @Inject
    public AppLifeCycleObserver(Lazy<PreferenceAccountEntityData> lazy, LocationPermissionSubject locationPermissionSubject) {
        this.getErrorConfigVersion = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = locationPermissionSubject;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onAppCreate() {
        if (!OSUtil.GetContactSyncConfig() || PermissionHelper.MyBillsEntityDataFactory(ComponentHolder.getAuthRequestContext().moveToNextValue(), "android.permission.ACCESS_FINE_LOCATION")) {
            LocationPermissionSubject locationPermissionSubject = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Object obj = locationPermissionSubject.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.get();
            if (Intrinsics.areEqual((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? null : NotificationLite.getValue(obj), Boolean.TRUE)) {
                return;
            }
            locationPermissionSubject.KClassImpl$Data$declaredNonStaticMembers$2.onNext(Boolean.TRUE);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onAppStop() {
        Runnable runnable = this.getAuthRequestContext;
        if (runnable != null) {
            runnable.run();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onAppPause() {
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.PlaceComponentResult = true;
        Iterator<KeyBoardOperationListener> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            it.next().onHomeClicked();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onAppStart() {
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onAppResume() {
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean PlaceComponentResult() {
        return this.PlaceComponentResult;
    }
}
