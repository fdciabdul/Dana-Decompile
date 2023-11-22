package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {
    private static Method KClassImpl$Data$declaredNonStaticMembers$2;
    private static Method getAuthRequestContext;
    private static Method getErrorConfigVersion;
    private Runnable A;
    private View B;
    private final PopupScrollListener BottomSheetCardBindingView$watcherCardNumberView$1;
    final Handler BuiltInFictitiousFunctionClassFactory;
    private final PopupTouchInterceptor C;
    private int DatabaseTableConfigUtil;
    private Rect FragmentBottomSheetPaymentSettingBinding;
    private int GetContactSyncConfig;
    int MyBillsEntityDataFactory;
    public PopupWindow NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private View NetworkUserEntityData$$ExternalSyntheticLambda2;
    private AdapterView.OnItemClickListener NetworkUserEntityData$$ExternalSyntheticLambda3;
    private AdapterView.OnItemSelectedListener NetworkUserEntityData$$ExternalSyntheticLambda4;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final ListSelectorHider NetworkUserEntityData$$ExternalSyntheticLambda6;
    private Drawable NetworkUserEntityData$$ExternalSyntheticLambda7;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    DropDownListView PlaceComponentResult;
    private int PrepareContext;
    private boolean SubSequence;
    private final Rect VerifyPinStateManager$executeRiskChallenge$2$1;
    private DataSetObserver getCallingPid;
    private int getSupportButtonTintMode;
    private boolean initRecordTimeStamp;
    private int isLayoutRequested;
    private Context lookAheadTest;
    final ResizePopupRunnable moveToNextValue;
    private int newProxyInstance;
    private boolean readMicros;
    private ListAdapter scheduleImpl;
    private boolean whenAvailable;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                getAuthRequestContext = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                InstrumentInjector.log_i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                getErrorConfigVersion = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                InstrumentInjector.log_i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                InstrumentInjector.log_i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.B);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.B);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.DatabaseTableConfigUtil = -2;
        this.newProxyInstance = -2;
        this.PrepareContext = 1002;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
        this.initRecordTimeStamp = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = false;
        this.MyBillsEntityDataFactory = Integer.MAX_VALUE;
        this.getSupportButtonTintMode = 0;
        this.moveToNextValue = new ResizePopupRunnable();
        this.C = new PopupTouchInterceptor();
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = new PopupScrollListener();
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new ListSelectorHider();
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = new Rect();
        this.lookAheadTest = context;
        this.BuiltInFictitiousFunctionClassFactory = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReferralMapper_Factory, i, i2);
        this.GetContactSyncConfig = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PromoCategoryPresenter$1, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.InitSecurePreferenceAccount, 0);
        this.isLayoutRequested = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }

    public void PlaceComponentResult(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.getCallingPid;
        if (dataSetObserver == null) {
            this.getCallingPid = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.scheduleImpl;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.scheduleImpl = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.getCallingPid);
        }
        DropDownListView dropDownListView = this.PlaceComponentResult;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.scheduleImpl);
        }
    }

    public void NetworkUserEntityData$$ExternalSyntheticLambda0(int i) {
        this.getSupportButtonTintMode = i;
    }

    public void getAuthRequestContext(boolean z) {
        this.readMicros = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setFocusable(z);
    }

    public boolean NetworkUserEntityData$$ExternalSyntheticLambda7() {
        return this.readMicros;
    }

    public Drawable KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.getBackground();
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setBackgroundDrawable(drawable);
    }

    public void MyBillsEntityDataFactory(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setAnimationStyle(i);
    }

    public View lookAheadTest() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public void PlaceComponentResult(View view) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = view;
    }

    public int BuiltInFictitiousFunctionClassFactory() {
        return this.GetContactSyncConfig;
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        this.GetContactSyncConfig = i;
    }

    public int getErrorConfigVersion() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            return this.isLayoutRequested;
        }
        return 0;
    }

    public void getAuthRequestContext(int i) {
        this.isLayoutRequested = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
    }

    public void PlaceComponentResult(Rect rect) {
        this.FragmentBottomSheetPaymentSettingBinding = rect != null ? new Rect(rect) : null;
    }

    public void getErrorConfigVersion(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = i;
    }

    public int DatabaseTableConfigUtil() {
        return this.newProxyInstance;
    }

    public void lookAheadTest(int i) {
        this.newProxyInstance = i;
    }

    public void PlaceComponentResult(int i) {
        Drawable background = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getBackground();
        if (background != null) {
            background.getPadding(this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.newProxyInstance = this.VerifyPinStateManager$executeRiskChallenge$2$1.left + this.VerifyPinStateManager$executeRiskChallenge$2$1.right + i;
            return;
        }
        lookAheadTest(i);
    }

    public void getAuthRequestContext(AdapterView.OnItemClickListener onItemClickListener) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = onItemClickListener;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void a_() {
        int MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        boolean PrepareContext = PrepareContext();
        PopupWindowCompat.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.PrepareContext);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.isShowing()) {
            if (ViewCompat.C(lookAheadTest())) {
                int i = this.newProxyInstance;
                if (i == -1) {
                    i = -1;
                } else if (i == -2) {
                    i = lookAheadTest().getWidth();
                }
                int i2 = this.DatabaseTableConfigUtil;
                if (i2 == -1) {
                    if (!PrepareContext) {
                        MyBillsEntityDataFactory = -1;
                    }
                    if (PrepareContext) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setWidth(this.newProxyInstance == -1 ? -1 : 0);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setHeight(0);
                    } else {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setWidth(this.newProxyInstance == -1 ? -1 : 0);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setHeight(-1);
                    }
                } else if (i2 != -2) {
                    MyBillsEntityDataFactory = i2;
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.setOutsideTouchable((this.NetworkUserEntityData$$ExternalSyntheticLambda5 || this.initRecordTimeStamp) ? false : true);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.update(lookAheadTest(), this.GetContactSyncConfig, this.isLayoutRequested, i < 0 ? -1 : i, MyBillsEntityDataFactory < 0 ? -1 : MyBillsEntityDataFactory);
                return;
            }
            return;
        }
        int i3 = this.newProxyInstance;
        if (i3 == -1) {
            i3 = -1;
        } else if (i3 == -2) {
            i3 = lookAheadTest().getWidth();
        }
        int i4 = this.DatabaseTableConfigUtil;
        if (i4 == -1) {
            MyBillsEntityDataFactory = -1;
        } else if (i4 != -2) {
            MyBillsEntityDataFactory = i4;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setWidth(i3);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setHeight(MyBillsEntityDataFactory);
        BuiltInFictitiousFunctionClassFactory(true);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setOutsideTouchable((this.NetworkUserEntityData$$ExternalSyntheticLambda5 || this.initRecordTimeStamp) ? false : true);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setTouchInterceptor(this.C);
        if (this.whenAvailable) {
            PopupWindowCompat.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.SubSequence);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = getErrorConfigVersion;
            if (method != null) {
                try {
                    method.invoke(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.FragmentBottomSheetPaymentSettingBinding);
                } catch (Exception e) {
                    InstrumentInjector.log_e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        } else {
            Api29Impl.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.FragmentBottomSheetPaymentSettingBinding);
        }
        PopupWindowCompat.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, lookAheadTest(), this.GetContactSyncConfig, this.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        this.PlaceComponentResult.setSelection(-1);
        if (!this.readMicros || this.PlaceComponentResult.isInTouchMode()) {
            NetworkUserEntityData$$ExternalSyntheticLambda0();
        }
        if (this.readMicros) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.post(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void getAuthRequestContext() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dismiss();
        scheduleImpl();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setContentView(null);
        this.PlaceComponentResult = null;
        this.BuiltInFictitiousFunctionClassFactory.removeCallbacks(this.moveToNextValue);
    }

    public void MyBillsEntityDataFactory(PopupWindow.OnDismissListener onDismissListener) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setOnDismissListener(onDismissListener);
    }

    private void scheduleImpl() {
        View view = this.B;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.B);
            }
        }
    }

    public void scheduleImpl(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setInputMethodMode(i);
    }

    public void moveToNextValue(int i) {
        DropDownListView dropDownListView = this.PlaceComponentResult;
        if (!PlaceComponentResult() || dropDownListView == null) {
            return;
        }
        dropDownListView.setListSelectionHidden(false);
        dropDownListView.setSelection(i);
        if (dropDownListView.getChoiceMode() != 0) {
            dropDownListView.setItemChecked(i, true);
        }
    }

    public void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        DropDownListView dropDownListView = this.PlaceComponentResult;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean PlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.isShowing();
    }

    public boolean PrepareContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.getInputMethodMode() == 2;
    }

    public Object NetworkUserEntityData$$ExternalSyntheticLambda1() {
        if (PlaceComponentResult()) {
            return this.PlaceComponentResult.getSelectedItem();
        }
        return null;
    }

    public int NetworkUserEntityData$$ExternalSyntheticLambda2() {
        if (PlaceComponentResult()) {
            return this.PlaceComponentResult.getSelectedItemPosition();
        }
        return -1;
    }

    public long GetContactSyncConfig() {
        if (PlaceComponentResult()) {
            return this.PlaceComponentResult.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public View initRecordTimeStamp() {
        if (PlaceComponentResult()) {
            return this.PlaceComponentResult.getSelectedView();
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.PlaceComponentResult;
    }

    DropDownListView BuiltInFictitiousFunctionClassFactory(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int MyBillsEntityDataFactory() {
        int i;
        int i2;
        int makeMeasureSpec;
        int i3;
        if (this.PlaceComponentResult == null) {
            Context context = this.lookAheadTest;
            this.A = new Runnable() { // from class: androidx.appcompat.widget.ListPopupWindow.2
                @Override // java.lang.Runnable
                public void run() {
                    View lookAheadTest = ListPopupWindow.this.lookAheadTest();
                    if (lookAheadTest == null || lookAheadTest.getWindowToken() == null) {
                        return;
                    }
                    ListPopupWindow.this.a_();
                }
            };
            DropDownListView BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(context, !this.readMicros);
            this.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
            Drawable drawable = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (drawable != null) {
                BuiltInFictitiousFunctionClassFactory.setSelector(drawable);
            }
            this.PlaceComponentResult.setAdapter(this.scheduleImpl);
            this.PlaceComponentResult.setOnItemClickListener(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.PlaceComponentResult.setFocusable(true);
            this.PlaceComponentResult.setFocusableInTouchMode(true);
            this.PlaceComponentResult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.ListPopupWindow.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j) {
                    DropDownListView dropDownListView;
                    if (i4 == -1 || (dropDownListView = ListPopupWindow.this.PlaceComponentResult) == null) {
                        return;
                    }
                    dropDownListView.setListSelectionHidden(false);
                }
            });
            this.PlaceComponentResult.setOnScrollListener(this.BottomSheetCardBindingView$watcherCardNumberView$1);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (onItemSelectedListener != null) {
                this.PlaceComponentResult.setOnItemSelectedListener(onItemSelectedListener);
            }
            DropDownListView dropDownListView = this.PlaceComponentResult;
            View view = this.B;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.getSupportButtonTintMode;
                if (i4 == 0) {
                    linearLayout.addView(view);
                    linearLayout.addView(dropDownListView, layoutParams);
                } else if (i4 == 1) {
                    linearLayout.addView(dropDownListView, layoutParams);
                    linearLayout.addView(view);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid hint position ");
                    sb.append(this.getSupportButtonTintMode);
                    InstrumentInjector.log_e("ListPopupWindow", sb.toString());
                }
                int i5 = this.newProxyInstance;
                if (i5 >= 0) {
                    i3 = Integer.MIN_VALUE;
                } else {
                    i5 = 0;
                    i3 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i5, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                dropDownListView = linearLayout;
            } else {
                i = 0;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.setContentView(dropDownListView);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getContentView();
            View view2 = this.B;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getBackground();
        if (background != null) {
            background.getPadding(this.VerifyPinStateManager$executeRiskChallenge$2$1);
            i2 = this.VerifyPinStateManager$executeRiskChallenge$2$1.top + this.VerifyPinStateManager$executeRiskChallenge$2$1.bottom;
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
                this.isLayoutRequested = -this.VerifyPinStateManager$executeRiskChallenge$2$1.top;
            }
        } else {
            this.VerifyPinStateManager$executeRiskChallenge$2$1.setEmpty();
            i2 = 0;
        }
        int BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(lookAheadTest(), this.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda0.getInputMethodMode() == 2);
        if (this.initRecordTimeStamp || this.DatabaseTableConfigUtil == -1) {
            return BuiltInFictitiousFunctionClassFactory2 + i2;
        }
        int i6 = this.newProxyInstance;
        if (i6 == -2) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.lookAheadTest.getResources().getDisplayMetrics().widthPixels - (this.VerifyPinStateManager$executeRiskChallenge$2$1.left + this.VerifyPinStateManager$executeRiskChallenge$2$1.right), Integer.MIN_VALUE);
        } else if (i6 == -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.lookAheadTest.getResources().getDisplayMetrics().widthPixels - (this.VerifyPinStateManager$executeRiskChallenge$2$1.left + this.VerifyPinStateManager$executeRiskChallenge$2$1.right), 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        int measureHeightOfChildrenCompat = this.PlaceComponentResult.measureHeightOfChildrenCompat(makeMeasureSpec, 0, -1, BuiltInFictitiousFunctionClassFactory2 - i, -1);
        if (measureHeightOfChildrenCompat > 0) {
            i += i2 + this.PlaceComponentResult.getPaddingTop() + this.PlaceComponentResult.getPaddingBottom();
        }
        return measureHeightOfChildrenCompat + i;
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.whenAvailable = true;
        this.SubSequence = z;
    }

    /* loaded from: classes.dex */
    class PopupDataSetObserver extends DataSetObserver {
        PopupDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.PlaceComponentResult()) {
                ListPopupWindow.this.a_();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.getAuthRequestContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ListSelectorHider implements Runnable {
        ListSelectorHider() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ResizePopupRunnable implements Runnable {
        ResizePopupRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ListPopupWindow.this.PlaceComponentResult == null || !ViewCompat.C(ListPopupWindow.this.PlaceComponentResult) || ListPopupWindow.this.PlaceComponentResult.getCount() <= ListPopupWindow.this.PlaceComponentResult.getChildCount() || ListPopupWindow.this.PlaceComponentResult.getChildCount() > ListPopupWindow.this.MyBillsEntityDataFactory) {
                return;
            }
            ListPopupWindow.this.NetworkUserEntityData$$ExternalSyntheticLambda0.setInputMethodMode(2);
            ListPopupWindow.this.a_();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PopupTouchInterceptor implements View.OnTouchListener {
        PopupTouchInterceptor() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null && ListPopupWindow.this.NetworkUserEntityData$$ExternalSyntheticLambda0.isShowing() && x >= 0 && x < ListPopupWindow.this.NetworkUserEntityData$$ExternalSyntheticLambda0.getWidth() && y >= 0 && y < ListPopupWindow.this.NetworkUserEntityData$$ExternalSyntheticLambda0.getHeight()) {
                ListPopupWindow.this.BuiltInFictitiousFunctionClassFactory.postDelayed(ListPopupWindow.this.moveToNextValue, 250L);
                return false;
            } else if (action == 1) {
                ListPopupWindow.this.BuiltInFictitiousFunctionClassFactory.removeCallbacks(ListPopupWindow.this.moveToNextValue);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PopupScrollListener implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        PopupScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || ListPopupWindow.this.PrepareContext() || ListPopupWindow.this.NetworkUserEntityData$$ExternalSyntheticLambda0.getContentView() == null) {
                return;
            }
            ListPopupWindow.this.BuiltInFictitiousFunctionClassFactory.removeCallbacks(ListPopupWindow.this.moveToNextValue);
            ListPopupWindow.this.moveToNextValue.run();
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = getAuthRequestContext;
            if (method != null) {
                try {
                    method.invoke(this.NetworkUserEntityData$$ExternalSyntheticLambda0, Boolean.valueOf(z));
                    return;
                } catch (Exception unused) {
                    InstrumentInjector.log_i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        Api29Impl.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0, z);
    }

    private int BuiltInFictitiousFunctionClassFactory(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = KClassImpl$Data$declaredNonStaticMembers$2;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(this.NetworkUserEntityData$$ExternalSyntheticLambda0, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                    InstrumentInjector.log_i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0.getMaxAvailableHeight(view, i);
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.getMaxAvailableHeight(view, i, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        static void BuiltInFictitiousFunctionClassFactory(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void getAuthRequestContext(PopupWindow popupWindow, boolean z) {
            popupWindow.setIsClippedToScreen(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends ForwardingListener {
        final /* synthetic */ ListPopupWindow BuiltInFictitiousFunctionClassFactory;

        @Override // androidx.appcompat.widget.ForwardingListener
        public /* bridge */ /* synthetic */ ShowableListMenu getAuthRequestContext() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }
}
