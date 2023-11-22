package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R;

/* loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {
    private static Configuration PlaceComponentResult;
    public int BuiltInFictitiousFunctionClassFactory;
    private Resources KClassImpl$Data$declaredNonStaticMembers$2;
    private Configuration MyBillsEntityDataFactory;
    private LayoutInflater getAuthRequestContext;
    private Resources.Theme lookAheadTest;

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(Context context, int i) {
        super(context);
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.lookAheadTest = theme;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void getAuthRequestContext(Configuration configuration) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.MyBillsEntityDataFactory != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.MyBillsEntityDataFactory = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.BuiltInFictitiousFunctionClassFactory != i) {
            this.BuiltInFictitiousFunctionClassFactory = i;
            PlaceComponentResult();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.lookAheadTest;
        if (theme != null) {
            return theme;
        }
        if (this.BuiltInFictitiousFunctionClassFactory == 0) {
            this.BuiltInFictitiousFunctionClassFactory = R.style.lookAheadTest;
        }
        PlaceComponentResult();
        return this.lookAheadTest;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.getAuthRequestContext == null) {
                this.getAuthRequestContext = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.getAuthRequestContext;
        }
        return getBaseContext().getSystemService(str);
    }

    private void PlaceComponentResult() {
        if (this.lookAheadTest == null) {
            this.lookAheadTest = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.lookAheadTest.setTo(theme);
            }
        }
        this.lookAheadTest.applyStyle(this.BuiltInFictitiousFunctionClassFactory, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (PlaceComponentResult == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            PlaceComponentResult = configuration2;
        }
        return configuration.equals(PlaceComponentResult);
    }

    /* loaded from: classes.dex */
    static class Api17Impl {
        private Api17Impl() {
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            if (this.MyBillsEntityDataFactory == null || (Build.VERSION.SDK_INT >= 26 && BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory))) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = createConfigurationContext(this.MyBillsEntityDataFactory).getResources();
            } else {
                Resources resources = super.getResources();
                Configuration configuration = new Configuration(resources.getConfiguration());
                configuration.updateFrom(this.MyBillsEntityDataFactory);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration);
            }
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
