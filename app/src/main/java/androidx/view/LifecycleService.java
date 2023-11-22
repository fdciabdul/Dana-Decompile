package androidx.view;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;
import androidx.view.Lifecycle;

/* loaded from: classes3.dex */
public class LifecycleService extends Service implements LifecycleOwner {
    private final ServiceLifecycleDispatcher MyBillsEntityDataFactory = new ServiceLifecycleDispatcher(this);

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // android.app.Service
    public void onCreate() {
        this.MyBillsEntityDataFactory.PlaceComponentResult(Lifecycle.Event.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.MyBillsEntityDataFactory.PlaceComponentResult(Lifecycle.Event.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        this.MyBillsEntityDataFactory.PlaceComponentResult(Lifecycle.Event.ON_START);
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        ServiceLifecycleDispatcher serviceLifecycleDispatcher = this.MyBillsEntityDataFactory;
        serviceLifecycleDispatcher.PlaceComponentResult(Lifecycle.Event.ON_STOP);
        serviceLifecycleDispatcher.PlaceComponentResult(Lifecycle.Event.ON_DESTROY);
        super.onDestroy();
    }

    @Override // androidx.view.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
