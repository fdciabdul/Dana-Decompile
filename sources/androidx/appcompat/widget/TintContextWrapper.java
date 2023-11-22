package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TintContextWrapper extends ContextWrapper {
    private static final Object KClassImpl$Data$declaredNonStaticMembers$2 = new Object();
    private static ArrayList<WeakReference<TintContextWrapper>> getAuthRequestContext;
    private final Resources.Theme BuiltInFictitiousFunctionClassFactory;
    private final Resources MyBillsEntityDataFactory;

    @Override // android.content.ContextWrapper
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

    public static Context getAuthRequestContext(Context context) {
        if (MyBillsEntityDataFactory(context)) {
            synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
                ArrayList<WeakReference<TintContextWrapper>> arrayList = getAuthRequestContext;
                if (arrayList == null) {
                    getAuthRequestContext = new ArrayList<>();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference<TintContextWrapper> weakReference = getAuthRequestContext.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            getAuthRequestContext.remove(size);
                        }
                    }
                    for (int size2 = getAuthRequestContext.size() - 1; size2 >= 0; size2--) {
                        WeakReference<TintContextWrapper> weakReference2 = getAuthRequestContext.get(size2);
                        TintContextWrapper tintContextWrapper = weakReference2 != null ? weakReference2.get() : null;
                        if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                            return tintContextWrapper;
                        }
                    }
                }
                TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
                getAuthRequestContext.add(new WeakReference<>(tintContextWrapper2));
                return tintContextWrapper2;
            }
        }
        return context;
    }

    private static boolean MyBillsEntityDataFactory(Context context) {
        if ((context instanceof TintContextWrapper) || (context.getResources() instanceof TintResources) || (context.getResources() instanceof VectorEnabledTintResources)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || VectorEnabledTintResources.getAuthRequestContext();
    }

    private TintContextWrapper(Context context) {
        super(context);
        if (VectorEnabledTintResources.getAuthRequestContext()) {
            VectorEnabledTintResources vectorEnabledTintResources = new VectorEnabledTintResources(this, context.getResources());
            this.MyBillsEntityDataFactory = vectorEnabledTintResources;
            Resources.Theme newTheme = vectorEnabledTintResources.newTheme();
            this.BuiltInFictitiousFunctionClassFactory = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.MyBillsEntityDataFactory = new TintResources(this, context.getResources());
        this.BuiltInFictitiousFunctionClassFactory = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.BuiltInFictitiousFunctionClassFactory;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.BuiltInFictitiousFunctionClassFactory;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.MyBillsEntityDataFactory.getAssets();
    }
}
