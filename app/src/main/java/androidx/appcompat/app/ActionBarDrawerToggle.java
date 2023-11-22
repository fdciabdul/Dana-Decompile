package androidx.appcompat.app;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.appcompat.app.ActionBarDrawerToggleHoneycomb;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    View.OnClickListener BuiltInFictitiousFunctionClassFactory;
    final DrawerLayout KClassImpl$Data$declaredNonStaticMembers$2;
    boolean MyBillsEntityDataFactory;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Delegate PlaceComponentResult;
    private final int getAuthRequestContext;
    private boolean lookAheadTest;
    private DrawerArrowDrawable scheduleImpl;

    /* loaded from: classes.dex */
    public interface Delegate {
        void BuiltInFictitiousFunctionClassFactory(Drawable drawable, int i);

        void getAuthRequestContext(int i);
    }

    /* loaded from: classes.dex */
    public interface DelegateProvider {
    }

    /* renamed from: androidx.appcompat.app.ActionBarDrawerToggle$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ ActionBarDrawerToggle getAuthRequestContext;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.getAuthRequestContext.MyBillsEntityDataFactory) {
                ActionBarDrawerToggle actionBarDrawerToggle = this.getAuthRequestContext;
                int drawerLockMode = actionBarDrawerToggle.KClassImpl$Data$declaredNonStaticMembers$2.getDrawerLockMode(8388611);
                if (actionBarDrawerToggle.KClassImpl$Data$declaredNonStaticMembers$2.isDrawerVisible(8388611) && drawerLockMode != 2) {
                    actionBarDrawerToggle.KClassImpl$Data$declaredNonStaticMembers$2.closeDrawer(8388611);
                } else if (drawerLockMode != 1) {
                    actionBarDrawerToggle.KClassImpl$Data$declaredNonStaticMembers$2.openDrawer(8388611);
                }
            } else if (this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory != null) {
                this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.onClick(view);
            }
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void BuiltInFictitiousFunctionClassFactory(float f) {
        if (this.lookAheadTest) {
            MyBillsEntityDataFactory(Math.min(1.0f, Math.max(0.0f, f)));
        } else {
            MyBillsEntityDataFactory(0.0f);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void getAuthRequestContext() {
        MyBillsEntityDataFactory(1.0f);
        if (this.MyBillsEntityDataFactory) {
            this.PlaceComponentResult.getAuthRequestContext(this.getAuthRequestContext);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory(0.0f);
        if (this.MyBillsEntityDataFactory) {
            this.PlaceComponentResult.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
    }

    private void MyBillsEntityDataFactory(float f) {
        if (f == 1.0f) {
            DrawerArrowDrawable drawerArrowDrawable = this.scheduleImpl;
            if (!drawerArrowDrawable.MyBillsEntityDataFactory) {
                drawerArrowDrawable.MyBillsEntityDataFactory = true;
                drawerArrowDrawable.invalidateSelf();
            }
        } else if (f == 0.0f) {
            DrawerArrowDrawable drawerArrowDrawable2 = this.scheduleImpl;
            if (drawerArrowDrawable2.MyBillsEntityDataFactory) {
                drawerArrowDrawable2.MyBillsEntityDataFactory = false;
                drawerArrowDrawable2.invalidateSelf();
            }
        }
        this.scheduleImpl.setProgress(f);
    }

    /* loaded from: classes6.dex */
    static class FrameworkActionBarDelegate implements Delegate {
        private final Activity BuiltInFictitiousFunctionClassFactory;
        private ActionBarDrawerToggleHoneycomb.SetIndicatorInfo KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void BuiltInFictitiousFunctionClassFactory(Drawable drawable, int i) {
            android.app.ActionBar actionBar = this.BuiltInFictitiousFunctionClassFactory.getActionBar();
            if (actionBar != null) {
                if (Build.VERSION.SDK_INT < 18) {
                    actionBar.setDisplayShowHomeEnabled(true);
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = ActionBarDrawerToggleHoneycomb.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, drawable, i);
                    actionBar.setDisplayShowHomeEnabled(false);
                    return;
                }
                actionBar.setHomeAsUpIndicator(drawable);
                Api18Impl.MyBillsEntityDataFactory(actionBar, i);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void getAuthRequestContext(int i) {
            if (Build.VERSION.SDK_INT >= 18) {
                android.app.ActionBar actionBar = this.BuiltInFictitiousFunctionClassFactory.getActionBar();
                if (actionBar != null) {
                    Api18Impl.MyBillsEntityDataFactory(actionBar, i);
                    return;
                }
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ActionBarDrawerToggleHoneycomb.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, i);
        }

        /* loaded from: classes6.dex */
        static class Api18Impl {
            private Api18Impl() {
            }

            static void MyBillsEntityDataFactory(android.app.ActionBar actionBar, int i) {
                actionBar.setHomeActionContentDescription(i);
            }
        }
    }

    /* loaded from: classes6.dex */
    static class ToolbarCompatDelegate implements Delegate {
        final CharSequence MyBillsEntityDataFactory;
        final Toolbar PlaceComponentResult;

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void BuiltInFictitiousFunctionClassFactory(Drawable drawable, int i) {
            this.PlaceComponentResult.setNavigationIcon(drawable);
            getAuthRequestContext(i);
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void getAuthRequestContext(int i) {
            if (i == 0) {
                this.PlaceComponentResult.setNavigationContentDescription(this.MyBillsEntityDataFactory);
            } else {
                this.PlaceComponentResult.setNavigationContentDescription(i);
            }
        }
    }
}
