package androidx.appcompat.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
    private final AppCompatBackgroundHelper BuiltInFictitiousFunctionClassFactory;
    private SpinnerPopup NetworkUserEntityData$$ExternalSyntheticLambda0;
    private ForwardingListener getAuthRequestContext;
    private final boolean getErrorConfigVersion;
    int mDropDownWidth;
    final Rect mTempRect;
    private final Context moveToNextValue;
    private SpinnerAdapter scheduleImpl;
    public static final byte[] PlaceComponentResult = {4, -41, 37, 5, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 33;
    private static final int[] MyBillsEntityDataFactory = {16843505};

    /* loaded from: classes3.dex */
    public interface SpinnerPopup {
        int BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(int i);

        Drawable KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(int i);

        void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2);

        void KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable);

        CharSequence MyBillsEntityDataFactory();

        void PlaceComponentResult(ListAdapter listAdapter);

        void PlaceComponentResult(CharSequence charSequence);

        boolean PlaceComponentResult();

        void getAuthRequestContext();

        void getAuthRequestContext(int i);

        int getErrorConfigVersion();
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(SpinnerAdapter spinnerAdapter) {
        setAdapter(spinnerAdapter);
    }

    public AppCompatSpinner(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatSpinner(Context context, int i) {
        this(context, null, R.attr.F, i);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.F);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0051, code lost:
    
        if (r11 != null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0065, code lost:
    
        if (r11 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0067, code lost:
    
        r11.recycle();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.moveToNextValue;
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        SpinnerPopup spinnerPopup = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (spinnerPopup != null) {
            spinnerPopup.KClassImpl$Data$declaredNonStaticMembers$2(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        Drawable BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getPopupContext(), i);
        setPopupBackgroundDrawable(BuiltInFictitiousFunctionClassFactory);
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        SpinnerPopup spinnerPopup = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (spinnerPopup != null) {
            return spinnerPopup.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        SpinnerPopup spinnerPopup = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (spinnerPopup != null) {
            spinnerPopup.getAuthRequestContext(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        SpinnerPopup spinnerPopup = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (spinnerPopup != null) {
            return spinnerPopup.getErrorConfigVersion();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        SpinnerPopup spinnerPopup = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (spinnerPopup != null) {
            spinnerPopup.BuiltInFictitiousFunctionClassFactory(i);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        SpinnerPopup spinnerPopup = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (spinnerPopup != null) {
            return spinnerPopup.BuiltInFictitiousFunctionClassFactory();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            this.mDropDownWidth = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            return this.mDropDownWidth;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner
    /* renamed from: setAdapter */
    public void setAdapter2(SpinnerAdapter spinnerAdapter) {
        if (!this.getErrorConfigVersion) {
            this.scheduleImpl = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            Context context = this.moveToNextValue;
            if (context == null) {
                context = getContext();
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult(new DropDownAdapter(spinnerAdapter, context.getTheme()));
        }
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpinnerPopup spinnerPopup = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (spinnerPopup == null || !spinnerPopup.PlaceComponentResult()) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext();
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener = this.getAuthRequestContext;
        if (forwardingListener == null || !forwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        SpinnerPopup spinnerPopup = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (spinnerPopup != null) {
            if (spinnerPopup.PlaceComponentResult()) {
                return true;
            }
            showPopup();
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        SpinnerPopup spinnerPopup = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (spinnerPopup != null) {
            spinnerPopup.PlaceComponentResult(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        SpinnerPopup spinnerPopup = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        return spinnerPopup != null ? spinnerPopup.MyBillsEntityDataFactory() : super.getPrompt();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.BuiltInFictitiousFunctionClassFactory;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.KClassImpl$Data$declaredNonStaticMembers$2(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.BuiltInFictitiousFunctionClassFactory;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.PlaceComponentResult(drawable);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.BuiltInFictitiousFunctionClassFactory;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.MyBillsEntityDataFactory(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.BuiltInFictitiousFunctionClassFactory;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.MyBillsEntityDataFactory();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.BuiltInFictitiousFunctionClassFactory;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.BuiltInFictitiousFunctionClassFactory(mode);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.BuiltInFictitiousFunctionClassFactory;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getAuthRequestContext();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.BuiltInFictitiousFunctionClassFactory;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    int compatMeasureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.mTempRect);
            return i + this.mTempRect.left + this.mTempRect.right;
        }
        return i;
    }

    final SpinnerPopup getInternalPopup() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    void showPopup() {
        if (Build.VERSION.SDK_INT < 17) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(-1, -1);
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(getTextDirection(), Api17Impl.MyBillsEntityDataFactory(this));
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SpinnerPopup spinnerPopup = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        savedState.getAuthRequestContext = spinnerPopup != null && spinnerPopup.PlaceComponentResult();
        return savedState;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.getAuthRequestContext || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.2
            {
                AppCompatSpinner.this = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (!AppCompatSpinner.this.getInternalPopup().PlaceComponentResult()) {
                    AppCompatSpinner.this.showPopup();
                }
                ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver2 != null) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        Api16Impl.getAuthRequestContext(viewTreeObserver2, this);
                    } else {
                        viewTreeObserver2.removeGlobalOnLayoutListener(this);
                    }
                }
            }
        });
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.AppCompatSpinner.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: BuiltInFictitiousFunctionClassFactory */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: MyBillsEntityDataFactory */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean getAuthRequestContext;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.getAuthRequestContext = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.getAuthRequestContext ? (byte) 1 : (byte) 0);
        }
    }

    /* loaded from: classes3.dex */
    static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private ListAdapter PlaceComponentResult;
        private SpinnerAdapter getAuthRequestContext;

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        public DropDownAdapter(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.getAuthRequestContext = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.PlaceComponentResult = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof android.widget.ThemedSpinnerAdapter)) {
                    Api23Impl.MyBillsEntityDataFactory((android.widget.ThemedSpinnerAdapter) spinnerAdapter, theme);
                } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.getAuthRequestContext;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.getAuthRequestContext;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.getAuthRequestContext;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.getAuthRequestContext;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.getAuthRequestContext;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.getAuthRequestContext;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.getAuthRequestContext;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.PlaceComponentResult;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.PlaceComponentResult;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        private ListAdapter BuiltInFictitiousFunctionClassFactory;
        private CharSequence KClassImpl$Data$declaredNonStaticMembers$2;
        AlertDialog PlaceComponentResult;

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int BuiltInFictitiousFunctionClassFactory() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public Drawable KClassImpl$Data$declaredNonStaticMembers$2() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getErrorConfigVersion() {
            return 0;
        }

        DialogPopup() {
            AppCompatSpinner.this = r1;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void getAuthRequestContext() {
            AlertDialog alertDialog = this.PlaceComponentResult;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.PlaceComponentResult = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public boolean PlaceComponentResult() {
            AlertDialog alertDialog = this.PlaceComponentResult;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void PlaceComponentResult(ListAdapter listAdapter) {
            this.BuiltInFictitiousFunctionClassFactory = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void PlaceComponentResult(CharSequence charSequence) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public CharSequence MyBillsEntityDataFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (charSequence != null) {
                builder.setTitle(charSequence);
            }
            AlertDialog create = builder.setSingleChoiceItems(this.BuiltInFictitiousFunctionClassFactory, AppCompatSpinner.this.getSelectedItemPosition(), this).create();
            this.PlaceComponentResult = create;
            ListView listView = create.BuiltInFictitiousFunctionClassFactory.readMicros;
            if (Build.VERSION.SDK_INT >= 17) {
                Api17Impl.getAuthRequestContext(listView, i);
                listView.setTextAlignment(i2);
            }
            this.PlaceComponentResult.show();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AppCompatSpinner.this.setSelection(i);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i, this.BuiltInFictitiousFunctionClassFactory.getItemId(i));
            }
            getAuthRequestContext();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable) {
            InstrumentInjector.log_e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void getAuthRequestContext(int i) {
            InstrumentInjector.log_e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            InstrumentInjector.log_e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void BuiltInFictitiousFunctionClassFactory(int i) {
            InstrumentInjector.log_e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        ListAdapter KClassImpl$Data$declaredNonStaticMembers$2;
        private CharSequence getErrorConfigVersion;
        private final Rect lookAheadTest;
        private int scheduleImpl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DropdownPopup(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            AppCompatSpinner.this = r1;
            this.lookAheadTest = new Rect();
            PlaceComponentResult(r1);
            getAuthRequestContext(true);
            NetworkUserEntityData$$ExternalSyntheticLambda0(0);
            getAuthRequestContext(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.1
                {
                    DropdownPopup.this = this;
                }

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    AppCompatSpinner.this.setSelection(i2);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i2, DropdownPopup.this.KClassImpl$Data$declaredNonStaticMembers$2.getItemId(i2));
                    }
                    DropdownPopup.this.getAuthRequestContext();
                }
            });
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void PlaceComponentResult(ListAdapter listAdapter) {
            super.PlaceComponentResult(listAdapter);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public CharSequence MyBillsEntityDataFactory() {
            return this.getErrorConfigVersion;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void PlaceComponentResult(CharSequence charSequence) {
            this.getErrorConfigVersion = charSequence;
        }

        void moveToNextValue() {
            int scheduleImpl;
            Drawable KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
            int i = 0;
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                KClassImpl$Data$declaredNonStaticMembers$2.getPadding(AppCompatSpinner.this.mTempRect);
                i = ViewUtils.getAuthRequestContext(AppCompatSpinner.this) ? AppCompatSpinner.this.mTempRect.right : -AppCompatSpinner.this.mTempRect.left;
            } else {
                Rect rect = AppCompatSpinner.this.mTempRect;
                AppCompatSpinner.this.mTempRect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.mDropDownWidth == -2) {
                int compatMeasureContentWidth = AppCompatSpinner.this.compatMeasureContentWidth((SpinnerAdapter) this.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2());
                int i2 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.mTempRect.left) - AppCompatSpinner.this.mTempRect.right;
                if (compatMeasureContentWidth > i2) {
                    compatMeasureContentWidth = i2;
                }
                PlaceComponentResult(Math.max(compatMeasureContentWidth, (width - paddingLeft) - paddingRight));
            } else if (AppCompatSpinner.this.mDropDownWidth == -1) {
                PlaceComponentResult((width - paddingLeft) - paddingRight);
            } else {
                PlaceComponentResult(AppCompatSpinner.this.mDropDownWidth);
            }
            if (ViewUtils.getAuthRequestContext(AppCompatSpinner.this)) {
                scheduleImpl = i + (((width - paddingRight) - DatabaseTableConfigUtil()) - scheduleImpl());
            } else {
                scheduleImpl = i + paddingLeft + scheduleImpl();
            }
            KClassImpl$Data$declaredNonStaticMembers$2(scheduleImpl);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean PlaceComponentResult = PlaceComponentResult();
            moveToNextValue();
            scheduleImpl(2);
            super.a_();
            ListView listView = getListView();
            listView.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                Api17Impl.getAuthRequestContext(listView, i);
                listView.setTextAlignment(i2);
            }
            moveToNextValue(AppCompatSpinner.this.getSelectedItemPosition());
            if (PlaceComponentResult || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.2
                {
                    DropdownPopup.this = this;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    DropdownPopup dropdownPopup = DropdownPopup.this;
                    if (!dropdownPopup.KClassImpl$Data$declaredNonStaticMembers$2(AppCompatSpinner.this)) {
                        DropdownPopup.this.getAuthRequestContext();
                        return;
                    }
                    DropdownPopup.this.moveToNextValue();
                    DropdownPopup.super.a_();
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            MyBillsEntityDataFactory(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.3
                {
                    DropdownPopup.this = this;
                }

                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                    }
                }
            });
        }

        boolean KClassImpl$Data$declaredNonStaticMembers$2(View view) {
            return ViewCompat.C(view) && view.getGlobalVisibleRect(this.lookAheadTest);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void BuiltInFictitiousFunctionClassFactory(int i) {
            this.scheduleImpl = i;
        }

        public int scheduleImpl() {
            return this.scheduleImpl;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Api23Impl {
        private Api23Impl() {
        }

        static void MyBillsEntityDataFactory(android.widget.ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class Api17Impl {
        private Api17Impl() {
        }

        static int MyBillsEntityDataFactory(View view) {
            return view.getTextAlignment();
        }

        static void getAuthRequestContext(View view, int i) {
            view.setTextDirection(i);
        }
    }

    /* loaded from: classes3.dex */
    static final class Api16Impl {
        private Api16Impl() {
        }

        static void getAuthRequestContext(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x003f -> B:31:0x0046). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray r10, int r11) {
        /*
            byte[] r0 = androidx.appcompat.widget.AppCompatSpinner.PlaceComponentResult
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 3
            r4 = 0
            if (r0 != 0) goto L15
            r5 = r1
            r6 = 3
            r7 = 0
            r8 = 22
            r1 = r0
            r0 = r11
            r11 = r10
            goto L46
        L15:
            r5 = 97
            r3 = r1
            r6 = 3
            r7 = 0
            r1 = r0
            r0 = r11
            r11 = r10
        L1d:
            byte r8 = (byte) r5
            int r6 = r6 + 1
            r3[r7] = r8
            if (r7 != r2) goto L3f
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L3a
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L3a:
            android.graphics.drawable.Drawable r10 = r11.BuiltInFictitiousFunctionClassFactory(r0)
            return r10
        L3f:
            int r7 = r7 + 1
            r8 = r1[r6]
            r9 = r5
            r5 = r3
            r3 = r9
        L46:
            int r8 = -r8
            int r3 = r3 + r8
            int r3 = r3 + (-8)
            r9 = r5
            r5 = r3
            r3 = r9
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.__fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray, int):android.graphics.drawable.Drawable");
    }
}
