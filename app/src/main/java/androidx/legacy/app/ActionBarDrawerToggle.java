package androidx.legacy.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Method;

@Deprecated
/* loaded from: classes6.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private static final int[] KClassImpl$Data$declaredNonStaticMembers$2 = {16843531};
    private final int BuiltInFictitiousFunctionClassFactory;
    final Activity MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    private final Delegate getAuthRequestContext;
    private SlideDrawable lookAheadTest;
    private final int moveToNextValue;
    private SetIndicatorInfo scheduleImpl;

    @Deprecated
    /* loaded from: classes6.dex */
    public interface Delegate {
    }

    @Deprecated
    /* loaded from: classes6.dex */
    public interface DelegateProvider {
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void BuiltInFictitiousFunctionClassFactory(float f) {
        float min;
        float f2 = this.lookAheadTest.BuiltInFictitiousFunctionClassFactory;
        if (f > 0.5f) {
            min = Math.max(f2, Math.max(0.0f, f - 0.5f) * 2.0f);
        } else {
            min = Math.min(f2, f * 2.0f);
        }
        SlideDrawable slideDrawable = this.lookAheadTest;
        slideDrawable.BuiltInFictitiousFunctionClassFactory = min;
        slideDrawable.invalidateSelf();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void getAuthRequestContext() {
        SlideDrawable slideDrawable = this.lookAheadTest;
        slideDrawable.BuiltInFictitiousFunctionClassFactory = 1.0f;
        slideDrawable.invalidateSelf();
        if (this.PlaceComponentResult) {
            KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void MyBillsEntityDataFactory() {
        SlideDrawable slideDrawable = this.lookAheadTest;
        slideDrawable.BuiltInFictitiousFunctionClassFactory = 0.0f;
        slideDrawable.invalidateSelf();
        if (this.PlaceComponentResult) {
            KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue);
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if (this.getAuthRequestContext != null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            ActionBar actionBar = this.MyBillsEntityDataFactory.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
                return;
            }
            return;
        }
        if (this.scheduleImpl == null) {
            this.scheduleImpl = new SetIndicatorInfo(this.MyBillsEntityDataFactory);
        }
        if (this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            try {
                ActionBar actionBar2 = this.MyBillsEntityDataFactory.getActionBar();
                this.scheduleImpl.MyBillsEntityDataFactory.invoke(actionBar2, Integer.valueOf(i));
                actionBar2.setSubtitle(actionBar2.getSubtitle());
            } catch (Exception e) {
                InstrumentInjector.log_w("ActionBarDrawerToggle", "Couldn't set content description via JB-MR2 API", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SetIndicatorInfo {
        Method KClassImpl$Data$declaredNonStaticMembers$2;
        Method MyBillsEntityDataFactory;
        ImageView getAuthRequestContext;

        SetIndicatorInfo(Activity activity) {
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.MyBillsEntityDataFactory = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
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
                    this.getAuthRequestContext = (ImageView) childAt;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    class SlideDrawable extends InsetDrawable implements Drawable.Callback, FSDraw {
        float BuiltInFictitiousFunctionClassFactory;
        private float KClassImpl$Data$declaredNonStaticMembers$2;
        private final Rect MyBillsEntityDataFactory;
        private final boolean PlaceComponentResult;
        final /* synthetic */ ActionBarDrawerToggle getAuthRequestContext;

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            copyBounds(this.MyBillsEntityDataFactory);
            canvas.save();
            boolean z = ViewCompat.initRecordTimeStamp(this.getAuthRequestContext.MyBillsEntityDataFactory.getWindow().getDecorView()) == 1;
            int i = z ? -1 : 1;
            float width = this.MyBillsEntityDataFactory.width();
            canvas.translate((-this.KClassImpl$Data$declaredNonStaticMembers$2) * width * this.BuiltInFictitiousFunctionClassFactory * i, 0.0f);
            if (z && !this.PlaceComponentResult) {
                canvas.translate(width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            if (!InstrumentInjector.isRecordingDraw(this, canvas)) {
                super.draw(canvas);
            }
            canvas.restore();
        }
    }
}
