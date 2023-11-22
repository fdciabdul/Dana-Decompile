package androidx.multidex;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public class MultiDexApplication extends Application {
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

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        InstrumentInjector.init(this, context);
        super.attachBaseContext(context);
        MultiDex.getAuthRequestContext(this);
    }
}
