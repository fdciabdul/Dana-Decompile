package androidx.appcompat.app;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
class ActionBarDrawerToggleHoneycomb {
    private static final int[] BuiltInFictitiousFunctionClassFactory = {16843531};

    public static SetIndicatorInfo PlaceComponentResult(Activity activity, Drawable drawable, int i) {
        SetIndicatorInfo setIndicatorInfo = new SetIndicatorInfo(activity);
        if (setIndicatorInfo.MyBillsEntityDataFactory != null) {
            try {
                android.app.ActionBar actionBar = activity.getActionBar();
                setIndicatorInfo.MyBillsEntityDataFactory.invoke(actionBar, drawable);
                setIndicatorInfo.BuiltInFictitiousFunctionClassFactory.invoke(actionBar, Integer.valueOf(i));
            } catch (Exception e) {
                InstrumentInjector.log_w("ActionBarDrawerToggleHC", "Couldn't set home-as-up indicator via JB-MR2 API", e);
            }
        } else if (setIndicatorInfo.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            setIndicatorInfo.KClassImpl$Data$declaredNonStaticMembers$2.setImageDrawable(drawable);
        } else {
            InstrumentInjector.log_w("ActionBarDrawerToggleHC", "Couldn't set home-as-up indicator");
        }
        return setIndicatorInfo;
    }

    public static SetIndicatorInfo getAuthRequestContext(SetIndicatorInfo setIndicatorInfo, Activity activity, int i) {
        if (setIndicatorInfo == null) {
            setIndicatorInfo = new SetIndicatorInfo(activity);
        }
        if (setIndicatorInfo.MyBillsEntityDataFactory != null) {
            try {
                android.app.ActionBar actionBar = activity.getActionBar();
                setIndicatorInfo.BuiltInFictitiousFunctionClassFactory.invoke(actionBar, Integer.valueOf(i));
                if (Build.VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Exception e) {
                InstrumentInjector.log_w("ActionBarDrawerToggleHC", "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return setIndicatorInfo;
    }

    /* loaded from: classes6.dex */
    static class SetIndicatorInfo {
        public Method BuiltInFictitiousFunctionClassFactory;
        public ImageView KClassImpl$Data$declaredNonStaticMembers$2;
        public Method MyBillsEntityDataFactory;

        SetIndicatorInfo(Activity activity) {
            try {
                this.MyBillsEntityDataFactory = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.BuiltInFictitiousFunctionClassFactory = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            } catch (NoSuchMethodException unused) {
                View findViewById = activity.findViewById(16908332);
                if (findViewById == null) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                if (viewGroup.getChildCount() != 2) {
                    return;
                }
                View childAt = viewGroup.getChildAt(0);
                childAt = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
                if (childAt instanceof ImageView) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = (ImageView) childAt;
                }
            }
        }
    }

    private ActionBarDrawerToggleHoneycomb() {
    }
}
