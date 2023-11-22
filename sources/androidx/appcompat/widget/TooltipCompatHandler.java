package androidx.appcompat.widget;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.fullstory.instrumentation.InstrumentInjector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static TooltipCompatHandler BuiltInFictitiousFunctionClassFactory;
    private static TooltipCompatHandler KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private TooltipPopup NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final CharSequence NetworkUserEntityData$$ExternalSyntheticLambda2;
    private int PlaceComponentResult;
    private final View getAuthRequestContext;
    private boolean getErrorConfigVersion;
    private boolean moveToNextValue;
    private final int scheduleImpl;
    private final Runnable NetworkUserEntityData$$ExternalSyntheticLambda1 = new Runnable() { // from class: androidx.appcompat.widget.TooltipCompatHandler$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            TooltipCompatHandler.this.MyBillsEntityDataFactory();
        }
    };
    private final Runnable lookAheadTest = new Runnable() { // from class: androidx.appcompat.widget.TooltipCompatHandler$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            TooltipCompatHandler.this.getAuthRequestContext();
        }
    };

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ void MyBillsEntityDataFactory() {
        getAuthRequestContext(false);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(View view, CharSequence charSequence) {
        TooltipCompatHandler tooltipCompatHandler = KClassImpl$Data$declaredNonStaticMembers$2;
        if (tooltipCompatHandler != null && tooltipCompatHandler.getAuthRequestContext == view) {
            BuiltInFictitiousFunctionClassFactory(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            TooltipCompatHandler tooltipCompatHandler2 = BuiltInFictitiousFunctionClassFactory;
            if (tooltipCompatHandler2 != null && tooltipCompatHandler2.getAuthRequestContext == view) {
                tooltipCompatHandler2.getAuthRequestContext();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new TooltipCompatHandler(view, charSequence);
    }

    private TooltipCompatHandler(View view, CharSequence charSequence) {
        this.getAuthRequestContext = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = charSequence;
        this.scheduleImpl = ViewConfigurationCompat.MyBillsEntityDataFactory(ViewConfiguration.get(view.getContext()));
        KClassImpl$Data$declaredNonStaticMembers$2();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.PlaceComponentResult = view.getWidth() / 2;
        this.MyBillsEntityDataFactory = view.getHeight() / 2;
        getAuthRequestContext(true);
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null || !this.moveToNextValue) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.getAuthRequestContext.getContext().getSystemService("accessibility");
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action == 10) {
                    KClassImpl$Data$declaredNonStaticMembers$2();
                    getAuthRequestContext();
                }
            } else if (this.getAuthRequestContext.isEnabled() && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null && KClassImpl$Data$declaredNonStaticMembers$2(motionEvent)) {
                BuiltInFictitiousFunctionClassFactory(this);
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        getAuthRequestContext();
    }

    void getAuthRequestContext(boolean z) {
        int height;
        int i;
        long j;
        int longPressTimeout;
        long j2;
        if (ViewCompat.C(this.getAuthRequestContext)) {
            BuiltInFictitiousFunctionClassFactory(null);
            TooltipCompatHandler tooltipCompatHandler = BuiltInFictitiousFunctionClassFactory;
            if (tooltipCompatHandler != null) {
                tooltipCompatHandler.getAuthRequestContext();
            }
            BuiltInFictitiousFunctionClassFactory = this;
            this.moveToNextValue = z;
            TooltipPopup tooltipPopup = new TooltipPopup(this.getAuthRequestContext.getContext());
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = tooltipPopup;
            View view = this.getAuthRequestContext;
            int i2 = this.PlaceComponentResult;
            int i3 = this.MyBillsEntityDataFactory;
            boolean z2 = this.moveToNextValue;
            CharSequence charSequence = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (tooltipPopup.PlaceComponentResult() && tooltipPopup.PlaceComponentResult()) {
                ((WindowManager) tooltipPopup.MyBillsEntityDataFactory.getSystemService("window")).removeView(tooltipPopup.BuiltInFictitiousFunctionClassFactory);
            }
            tooltipPopup.PlaceComponentResult.setText(charSequence);
            WindowManager.LayoutParams layoutParams = tooltipPopup.KClassImpl$Data$declaredNonStaticMembers$2;
            layoutParams.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = tooltipPopup.MyBillsEntityDataFactory.getResources().getDimensionPixelOffset(R.dimen.GetContactSyncConfig);
            if (view.getWidth() < dimensionPixelOffset) {
                i2 = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = tooltipPopup.MyBillsEntityDataFactory.getResources().getDimensionPixelOffset(R.dimen.initRecordTimeStamp);
                height = i3 + dimensionPixelOffset2;
                i = i3 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = tooltipPopup.MyBillsEntityDataFactory.getResources().getDimensionPixelOffset(z2 ? R.dimen.NetworkUserEntityData$$ExternalSyntheticLambda2 : R.dimen.DatabaseTableConfigUtil);
            View PlaceComponentResult = TooltipPopup.PlaceComponentResult(view);
            if (PlaceComponentResult == null) {
                InstrumentInjector.log_e("TooltipPopup", "Cannot find app view");
            } else {
                PlaceComponentResult.getWindowVisibleDisplayFrame(tooltipPopup.scheduleImpl);
                if (tooltipPopup.scheduleImpl.left < 0 && tooltipPopup.scheduleImpl.top < 0) {
                    Resources resources = tooltipPopup.MyBillsEntityDataFactory.getResources();
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    tooltipPopup.scheduleImpl.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                PlaceComponentResult.getLocationOnScreen(tooltipPopup.lookAheadTest);
                view.getLocationOnScreen(tooltipPopup.getAuthRequestContext);
                int[] iArr = tooltipPopup.getAuthRequestContext;
                int i4 = iArr[0];
                int[] iArr2 = tooltipPopup.lookAheadTest;
                int i5 = i4 - iArr2[0];
                iArr[0] = i5;
                iArr[1] = iArr[1] - iArr2[1];
                layoutParams.x = (i5 + i2) - (PlaceComponentResult.getWidth() / 2);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                tooltipPopup.BuiltInFictitiousFunctionClassFactory.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredHeight = tooltipPopup.BuiltInFictitiousFunctionClassFactory.getMeasuredHeight();
                int i6 = tooltipPopup.getAuthRequestContext[1];
                int i7 = ((i + i6) - dimensionPixelOffset3) - measuredHeight;
                int i8 = i6 + height + dimensionPixelOffset3;
                if (!z2) {
                    if (measuredHeight + i8 <= tooltipPopup.scheduleImpl.height()) {
                        layoutParams.y = i8;
                    }
                    layoutParams.y = i7;
                } else {
                    if (i7 < 0) {
                        layoutParams.y = i8;
                    }
                    layoutParams.y = i7;
                }
            }
            ((WindowManager) tooltipPopup.MyBillsEntityDataFactory.getSystemService("window")).addView(tooltipPopup.BuiltInFictitiousFunctionClassFactory, tooltipPopup.KClassImpl$Data$declaredNonStaticMembers$2);
            this.getAuthRequestContext.addOnAttachStateChangeListener(this);
            if (this.moveToNextValue) {
                j2 = 2500;
            } else {
                if ((ViewCompat.whenAvailable(this.getAuthRequestContext) & 1) == 1) {
                    j = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j - longPressTimeout;
            }
            this.getAuthRequestContext.removeCallbacks(this.lookAheadTest);
            this.getAuthRequestContext.postDelayed(this.lookAheadTest, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getAuthRequestContext() {
        if (BuiltInFictitiousFunctionClassFactory == this) {
            BuiltInFictitiousFunctionClassFactory = null;
            TooltipPopup tooltipPopup = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (tooltipPopup == null) {
                InstrumentInjector.log_e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            } else {
                if (tooltipPopup.PlaceComponentResult()) {
                    ((WindowManager) tooltipPopup.MyBillsEntityDataFactory.getSystemService("window")).removeView(tooltipPopup.BuiltInFictitiousFunctionClassFactory);
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
                KClassImpl$Data$declaredNonStaticMembers$2();
                this.getAuthRequestContext.removeOnAttachStateChangeListener(this);
            }
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2 == this) {
            BuiltInFictitiousFunctionClassFactory(null);
        }
        this.getAuthRequestContext.removeCallbacks(this.lookAheadTest);
    }

    private static void BuiltInFictitiousFunctionClassFactory(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.BuiltInFictitiousFunctionClassFactory();
        }
        KClassImpl$Data$declaredNonStaticMembers$2 = tooltipCompatHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.PlaceComponentResult();
        }
    }

    private void PlaceComponentResult() {
        this.getAuthRequestContext.postDelayed(this.NetworkUserEntityData$$ExternalSyntheticLambda1, ViewConfiguration.getLongPressTimeout());
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        this.getAuthRequestContext.removeCallbacks(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.getErrorConfigVersion || Math.abs(x - this.PlaceComponentResult) > this.scheduleImpl || Math.abs(y - this.MyBillsEntityDataFactory) > this.scheduleImpl) {
            this.PlaceComponentResult = x;
            this.MyBillsEntityDataFactory = y;
            this.getErrorConfigVersion = false;
            return true;
        }
        return false;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.getErrorConfigVersion = true;
    }
}
