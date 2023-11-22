package androidx.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.BuildCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.ViewCompat;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleRegistry;
import androidx.view.ReportFragment;

/* loaded from: classes.dex */
public class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher.Component {
    private SimpleArrayMap<Class<? extends ExtraData>, ExtraData> mExtraDataMap = new SimpleArrayMap<>();
    private LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);

    @Deprecated
    /* loaded from: classes.dex */
    public static class ExtraData {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
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

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void putExtraData(ExtraData extraData) {
        this.mExtraDataMap.put(extraData.getClass(), extraData);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.PlaceComponentResult(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        LifecycleRegistry lifecycleRegistry = this.mLifecycleRegistry;
        Lifecycle.State state = Lifecycle.State.CREATED;
        lifecycleRegistry.PlaceComponentResult("markState");
        lifecycleRegistry.PlaceComponentResult("setCurrentState");
        lifecycleRegistry.getAuthRequestContext(state);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    public <T extends ExtraData> T getExtraData(Class<T> cls) {
        return (T) this.mExtraDataMap.get(cls);
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.core.view.KeyEventDispatcher.Component
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        boolean BuiltInFictitiousFunctionClassFactory;
        View decorView = getWindow().getDecorView();
        if (decorView != null) {
            BuiltInFictitiousFunctionClassFactory = ViewCompat.BuiltInFictitiousFunctionClassFactory(decorView, keyEvent);
            if (BuiltInFictitiousFunctionClassFactory) {
                return true;
            }
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean BuiltInFictitiousFunctionClassFactory;
        View decorView = getWindow().getDecorView();
        if (decorView != null) {
            BuiltInFictitiousFunctionClassFactory = ViewCompat.BuiltInFictitiousFunctionClassFactory(decorView, keyEvent);
            if (BuiltInFictitiousFunctionClassFactory) {
                return true;
            }
        }
        return KeyEventDispatcher.PlaceComponentResult(this, decorView, this, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean shouldDumpInternalState(String[] strArr) {
        return !shouldSkipDump(strArr);
    }

    private static boolean shouldSkipDump(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            String str = strArr[0];
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -645125871:
                    if (str.equals("--translation")) {
                        c = 0;
                        break;
                    }
                    break;
                case 100470631:
                    if (str.equals("--dump-dumpable")) {
                        c = 1;
                        break;
                    }
                    break;
                case 472614934:
                    if (str.equals("--list-dumpables")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1159329357:
                    if (str.equals("--contentcapture")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1455016274:
                    if (str.equals("--autofill")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c != 0) {
                if (c == 1 || c == 2) {
                    return BuildCompat.PlaceComponentResult();
                }
                return c != 3 ? c == 4 && Build.VERSION.SDK_INT >= 26 : Build.VERSION.SDK_INT >= 29;
            } else if (Build.VERSION.SDK_INT >= 31) {
                return true;
            }
        }
        return false;
    }
}
