package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;

/* loaded from: classes6.dex */
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {
    private ListPopupWindow DatabaseTableConfigUtil;
    private final Callbacks KClassImpl$Data$declaredNonStaticMembers$2;
    private final Drawable MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final ViewTreeObserver.OnGlobalLayoutListener NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final View getAuthRequestContext;
    private final ImageView getErrorConfigVersion;
    private int lookAheadTest;
    final ActivityChooserViewAdapter mAdapter;
    final FrameLayout mDefaultActivityButton;
    final FrameLayout mExpandActivityOverflowButton;
    int mInitialActivityCount;
    boolean mIsSelectingDefaultActivity;
    final DataSetObserver mModelDataSetObserver;
    PopupWindow.OnDismissListener mOnDismissListener;
    ActionProvider mProvider;
    private final ImageView moveToNextValue;
    private final int scheduleImpl;
    public static final byte[] PlaceComponentResult = {TarHeader.LF_DIR, 93, -14, -126, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 71;

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mModelDataSetObserver = new DataSetObserver() { // from class: androidx.appcompat.widget.ActivityChooserView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.mAdapter.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.mAdapter.notifyDataSetInvalidated();
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.ActivityChooserView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ActivityChooserView.this.isShowingPopup()) {
                    if (!ActivityChooserView.this.isShown()) {
                        ActivityChooserView.this.getListPopupWindow().getAuthRequestContext();
                        return;
                    }
                    ActivityChooserView.this.getListPopupWindow().a_();
                    if (ActivityChooserView.this.mProvider != null) {
                        ActivityChooserView.this.mProvider.BuiltInFictitiousFunctionClassFactory(true);
                    }
                }
            }
        };
        this.mInitialActivityCount = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.C, i, 0);
        ViewCompat.MyBillsEntityDataFactory(this, context, R.styleable.C, attributeSet, obtainStyledAttributes, i, 0);
        this.mInitialActivityCount = obtainStyledAttributes.getInt(R.styleable.BottomSheetCardBindingView$watcherCardNumberView$1, 4);
        Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.VerifyPinStateManager$executeRiskChallenge$2$1);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.getAuthRequestContext, (ViewGroup) this, true);
        Callbacks callbacks = new Callbacks();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = callbacks;
        View findViewById = findViewById(R.id.NetworkUserEntityData$$ExternalSyntheticLambda0);
        this.getAuthRequestContext = findViewById;
        this.MyBillsEntityDataFactory = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.newProxyInstance);
        this.mDefaultActivityButton = frameLayout;
        frameLayout.setOnClickListener(callbacks);
        frameLayout.setOnLongClickListener(callbacks);
        this.getErrorConfigVersion = (ImageView) frameLayout.findViewById(R.id.NetworkUserEntityData$$ExternalSyntheticLambda3);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.NetworkUserEntityData$$ExternalSyntheticLambda8);
        frameLayout2.setOnClickListener(callbacks);
        InstrumentInjector.setAccessibilityDelegate(frameLayout2, new View.AccessibilityDelegate() { // from class: androidx.appcompat.widget.ActivityChooserView.3
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                AccessibilityNodeInfoCompat.MyBillsEntityDataFactory(accessibilityNodeInfo).getAuthRequestContext(true);
            }
        });
        frameLayout2.setOnTouchListener(new ForwardingListener(frameLayout2) { // from class: androidx.appcompat.widget.ActivityChooserView.4
            @Override // androidx.appcompat.widget.ForwardingListener
            public ShowableListMenu getAuthRequestContext() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            protected boolean MyBillsEntityDataFactory() {
                ActivityChooserView.this.showPopup();
                return true;
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            protected boolean BuiltInFictitiousFunctionClassFactory() {
                ActivityChooserView.this.dismissPopup();
                return true;
            }
        });
        this.mExpandActivityOverflowButton = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(R.id.NetworkUserEntityData$$ExternalSyntheticLambda3);
        this.moveToNextValue = imageView;
        imageView.setImageDrawable(__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d);
        ActivityChooserViewAdapter activityChooserViewAdapter = new ActivityChooserViewAdapter();
        this.mAdapter = activityChooserViewAdapter;
        activityChooserViewAdapter.registerDataSetObserver(new DataSetObserver() { // from class: androidx.appcompat.widget.ActivityChooserView.5
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.updateAppearance();
            }
        });
        Resources resources = context.getResources();
        this.scheduleImpl = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.MyBillsEntityDataFactory));
    }

    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        ActivityChooserViewAdapter activityChooserViewAdapter = this.mAdapter;
        ActivityChooserModel activityChooserModel2 = ActivityChooserView.this.mAdapter.PlaceComponentResult;
        if (activityChooserModel2 != null && ActivityChooserView.this.isShown()) {
            activityChooserModel2.unregisterObserver(ActivityChooserView.this.mModelDataSetObserver);
        }
        activityChooserViewAdapter.PlaceComponentResult = activityChooserModel;
        if (activityChooserModel != null && ActivityChooserView.this.isShown()) {
            activityChooserModel.registerObserver(ActivityChooserView.this.mModelDataSetObserver);
        }
        activityChooserViewAdapter.notifyDataSetChanged();
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.moveToNextValue.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.moveToNextValue.setContentDescription(getContext().getString(i));
    }

    public void setProvider(ActionProvider actionProvider) {
        this.mProvider = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return false;
        }
        this.mIsSelectingDefaultActivity = false;
        showPopupUnchecked(this.mInitialActivityCount);
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    void showPopupUnchecked(int i) {
        if (this.mAdapter.PlaceComponentResult == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        ?? r0 = this.mDefaultActivityButton.getVisibility() == 0 ? 1 : 0;
        int PlaceComponentResult2 = this.mAdapter.PlaceComponentResult.PlaceComponentResult();
        if (i != Integer.MAX_VALUE && PlaceComponentResult2 > i + r0) {
            ActivityChooserViewAdapter activityChooserViewAdapter = this.mAdapter;
            if (!activityChooserViewAdapter.BuiltInFictitiousFunctionClassFactory) {
                activityChooserViewAdapter.BuiltInFictitiousFunctionClassFactory = true;
                activityChooserViewAdapter.notifyDataSetChanged();
            }
            ActivityChooserViewAdapter activityChooserViewAdapter2 = this.mAdapter;
            int i2 = i - 1;
            if (activityChooserViewAdapter2.KClassImpl$Data$declaredNonStaticMembers$2 != i2) {
                activityChooserViewAdapter2.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
                activityChooserViewAdapter2.notifyDataSetChanged();
            }
        } else {
            ActivityChooserViewAdapter activityChooserViewAdapter3 = this.mAdapter;
            if (activityChooserViewAdapter3.BuiltInFictitiousFunctionClassFactory) {
                activityChooserViewAdapter3.BuiltInFictitiousFunctionClassFactory = false;
                activityChooserViewAdapter3.notifyDataSetChanged();
            }
            ActivityChooserViewAdapter activityChooserViewAdapter4 = this.mAdapter;
            if (activityChooserViewAdapter4.KClassImpl$Data$declaredNonStaticMembers$2 != i) {
                activityChooserViewAdapter4.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                activityChooserViewAdapter4.notifyDataSetChanged();
            }
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (listPopupWindow.PlaceComponentResult()) {
            return;
        }
        if (this.mIsSelectingDefaultActivity || r0 == 0) {
            ActivityChooserViewAdapter activityChooserViewAdapter5 = this.mAdapter;
            if (!activityChooserViewAdapter5.MyBillsEntityDataFactory || activityChooserViewAdapter5.getAuthRequestContext != r0) {
                activityChooserViewAdapter5.MyBillsEntityDataFactory = true;
                activityChooserViewAdapter5.getAuthRequestContext = r0;
                activityChooserViewAdapter5.notifyDataSetChanged();
            }
        } else {
            ActivityChooserViewAdapter activityChooserViewAdapter6 = this.mAdapter;
            if (activityChooserViewAdapter6.MyBillsEntityDataFactory || activityChooserViewAdapter6.getAuthRequestContext) {
                activityChooserViewAdapter6.MyBillsEntityDataFactory = false;
                activityChooserViewAdapter6.getAuthRequestContext = false;
                activityChooserViewAdapter6.notifyDataSetChanged();
            }
        }
        ActivityChooserViewAdapter activityChooserViewAdapter7 = this.mAdapter;
        int i3 = activityChooserViewAdapter7.KClassImpl$Data$declaredNonStaticMembers$2;
        activityChooserViewAdapter7.KClassImpl$Data$declaredNonStaticMembers$2 = Integer.MAX_VALUE;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = activityChooserViewAdapter7.getCount();
        View view = null;
        int i4 = 0;
        for (int i5 = 0; i5 < count; i5++) {
            view = activityChooserViewAdapter7.getView(i5, view, null);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i4 = Math.max(i4, view.getMeasuredWidth());
        }
        activityChooserViewAdapter7.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
        listPopupWindow.PlaceComponentResult(Math.min(i4, this.scheduleImpl));
        listPopupWindow.a_();
        ActionProvider actionProvider = this.mProvider;
        if (actionProvider != null) {
            actionProvider.BuiltInFictitiousFunctionClassFactory(true);
        }
        listPopupWindow.getListView().setContentDescription(getContext().getString(R.string.getAuthRequestContext));
        listPopupWindow.getListView().setSelector(new ColorDrawable(0));
    }

    public boolean dismissPopup() {
        if (isShowingPopup()) {
            getListPopupWindow().getAuthRequestContext();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                return true;
            }
            return true;
        }
        return true;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().PlaceComponentResult();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel activityChooserModel = this.mAdapter.PlaceComponentResult;
        if (activityChooserModel != null) {
            activityChooserModel.registerObserver(this.mModelDataSetObserver);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel activityChooserModel = this.mAdapter.PlaceComponentResult;
        if (activityChooserModel != null) {
            activityChooserModel.unregisterObserver(this.mModelDataSetObserver);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.getAuthRequestContext;
        if (this.mDefaultActivityButton.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.getAuthRequestContext.layout(0, 0, i3 - i, i4 - i2);
        if (isShowingPopup()) {
            return;
        }
        dismissPopup();
    }

    public ActivityChooserModel getDataModel() {
        return this.mAdapter.PlaceComponentResult;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.mInitialActivityCount = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.lookAheadTest = i;
    }

    ListPopupWindow getListPopupWindow() {
        if (this.DatabaseTableConfigUtil == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.DatabaseTableConfigUtil = listPopupWindow;
            listPopupWindow.PlaceComponentResult(this.mAdapter);
            this.DatabaseTableConfigUtil.PlaceComponentResult(this);
            this.DatabaseTableConfigUtil.getAuthRequestContext(true);
            this.DatabaseTableConfigUtil.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.DatabaseTableConfigUtil.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return this.DatabaseTableConfigUtil;
    }

    void updateAppearance() {
        if (this.mAdapter.getCount() > 0) {
            this.mExpandActivityOverflowButton.setEnabled(true);
        } else {
            this.mExpandActivityOverflowButton.setEnabled(false);
        }
        int PlaceComponentResult2 = this.mAdapter.PlaceComponentResult.PlaceComponentResult();
        int MyBillsEntityDataFactory = this.mAdapter.PlaceComponentResult.MyBillsEntityDataFactory();
        if (PlaceComponentResult2 == 1 || (PlaceComponentResult2 > 1 && MyBillsEntityDataFactory > 0)) {
            this.mDefaultActivityButton.setVisibility(0);
            ResolveInfo BuiltInFictitiousFunctionClassFactory2 = this.mAdapter.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
            PackageManager packageManager = getContext().getPackageManager();
            this.getErrorConfigVersion.setImageDrawable(BuiltInFictitiousFunctionClassFactory2.loadIcon(packageManager));
            if (this.lookAheadTest != 0) {
                this.mDefaultActivityButton.setContentDescription(getContext().getString(this.lookAheadTest, BuiltInFictitiousFunctionClassFactory2.loadLabel(packageManager)));
            }
        } else {
            this.mDefaultActivityButton.setVisibility(8);
        }
        if (this.mDefaultActivityButton.getVisibility() == 0) {
            this.getAuthRequestContext.setBackgroundDrawable(this.MyBillsEntityDataFactory);
        } else {
            this.getAuthRequestContext.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        Callbacks() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int itemViewType = ((ActivityChooserViewAdapter) adapterView.getAdapter()).getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ActivityChooserView.this.showPopupUnchecked(Integer.MAX_VALUE);
                    return;
                }
                throw new IllegalArgumentException();
            }
            ActivityChooserView.this.dismissPopup();
            if (ActivityChooserView.this.mIsSelectingDefaultActivity) {
                if (i > 0) {
                    ActivityChooserView.this.mAdapter.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(i);
                    return;
                }
                return;
            }
            if (!ActivityChooserView.this.mAdapter.MyBillsEntityDataFactory()) {
                i++;
            }
            Intent BuiltInFictitiousFunctionClassFactory = ActivityChooserView.this.mAdapter.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(i);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                BuiltInFictitiousFunctionClassFactory.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(BuiltInFictitiousFunctionClassFactory);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == ActivityChooserView.this.mDefaultActivityButton) {
                ActivityChooserView.this.dismissPopup();
                Intent BuiltInFictitiousFunctionClassFactory = ActivityChooserView.this.mAdapter.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(ActivityChooserView.this.mAdapter.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(ActivityChooserView.this.mAdapter.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory()));
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    BuiltInFictitiousFunctionClassFactory.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(BuiltInFictitiousFunctionClassFactory);
                }
            } else if (view == ActivityChooserView.this.mExpandActivityOverflowButton) {
                ActivityChooserView.this.mIsSelectingDefaultActivity = false;
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                activityChooserView.showPopupUnchecked(activityChooserView.mInitialActivityCount);
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.mDefaultActivityButton) {
                if (ActivityChooserView.this.mAdapter.getCount() > 0) {
                    ActivityChooserView.this.mIsSelectingDefaultActivity = true;
                    ActivityChooserView activityChooserView = ActivityChooserView.this;
                    activityChooserView.showPopupUnchecked(activityChooserView.mInitialActivityCount);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ActivityChooserView.this.mOnDismissListener != null) {
                ActivityChooserView.this.mOnDismissListener.onDismiss();
            }
            if (ActivityChooserView.this.mProvider != null) {
                ActivityChooserView.this.mProvider.BuiltInFictitiousFunctionClassFactory(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ActivityChooserViewAdapter extends BaseAdapter {
        boolean BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2 = 4;
        boolean MyBillsEntityDataFactory;
        ActivityChooserModel PlaceComponentResult;
        boolean getAuthRequestContext;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        ActivityChooserViewAdapter() {
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.BuiltInFictitiousFunctionClassFactory && i == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult();
            if (!this.MyBillsEntityDataFactory && this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() != null) {
                PlaceComponentResult--;
            }
            int min = Math.min(PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2);
            return this.BuiltInFictitiousFunctionClassFactory ? min + 1 : min;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.MyBillsEntityDataFactory && this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() != null) {
                i++;
            }
            return this.PlaceComponentResult.MyBillsEntityDataFactory(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    if (view == null || view.getId() != 1) {
                        View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.moveToNextValue, viewGroup, false);
                        inflate.setId(1);
                        ((TextView) inflate.findViewById(R.id.AppCompatEmojiTextHelper)).setText(ActivityChooserView.this.getContext().getString(R.string.PlaceComponentResult));
                        return inflate;
                    }
                    return view;
                }
                throw new IllegalArgumentException();
            }
            if (view == null || view.getId() != R.id.NetworkUserEntityData$$ExternalSyntheticLambda4) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.moveToNextValue, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(R.id.NetworkUserEntityData$$ExternalSyntheticLambda5);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(R.id.AppCompatEmojiTextHelper)).setText(resolveInfo.loadLabel(packageManager));
            if (this.MyBillsEntityDataFactory && i == 0 && this.getAuthRequestContext) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        public final boolean MyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }
    }

    /* loaded from: classes6.dex */
    public static class InnerLayout extends LinearLayout {
        public static final byte[] PlaceComponentResult = {37, 81, 122, 15, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
        public static final int getAuthRequestContext = 89;
        private static final int[] BuiltInFictitiousFunctionClassFactory = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray MyBillsEntityDataFactory = TintTypedArray.MyBillsEntityDataFactory(context, attributeSet, BuiltInFictitiousFunctionClassFactory);
            setBackgroundDrawable(__fsTypeCheck_03006d36da53514240897610a74f16fc(MyBillsEntityDataFactory, 0));
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.recycle();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0042 -> B:15:0x0049). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static android.graphics.drawable.Drawable __fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray r9, int r10) {
            /*
                byte[] r0 = androidx.appcompat.widget.ActivityChooserView.InnerLayout.PlaceComponentResult
                r1 = 23
                byte[] r1 = new byte[r1]
                r2 = 22
                r3 = 97
                r4 = -1
                r5 = 4
                if (r0 != 0) goto L17
                r4 = r1
                r5 = 22
                r6 = 4
                r7 = -1
                r1 = r0
                r0 = r10
                r10 = r9
                goto L49
            L17:
                r3 = r1
                r4 = 97
                r5 = -1
                r6 = 4
                r1 = r0
                r0 = r10
                r10 = r9
            L1f:
                int r5 = r5 + 1
                byte r7 = (byte) r4
                r3[r5] = r7
                if (r5 != r2) goto L42
                java.lang.String r1 = new java.lang.String
                r2 = 0
                r1.<init>(r3, r2)
                java.lang.Class r1 = java.lang.Class.forName(r1)
                boolean r9 = r1.isInstance(r9)
                if (r9 == 0) goto L3d
                android.content.Context r10 = (android.content.Context) r10
                android.graphics.drawable.Drawable r9 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r10, r0)
                return r9
            L3d:
                android.graphics.drawable.Drawable r9 = r10.BuiltInFictitiousFunctionClassFactory(r0)
                return r9
            L42:
                r7 = r1[r6]
                r8 = r4
                r4 = r3
                r3 = r7
                r7 = r5
                r5 = r8
            L49:
                int r3 = -r3
                int r5 = r5 + r3
                int r6 = r6 + 1
                int r3 = r5 + (-8)
                r5 = r7
                r8 = r4
                r4 = r3
                r3 = r8
                goto L1f
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserView.InnerLayout.__fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray, int):android.graphics.drawable.Drawable");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0042 -> B:15:0x004b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r8, int r9) {
        /*
            byte[] r0 = androidx.appcompat.widget.ActivityChooserView.PlaceComponentResult
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 3
            r3 = 97
            r4 = -1
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 97
            r5 = 3
            r6 = -1
            r1 = r0
            r0 = r9
            r9 = r8
            goto L4b
        L15:
            r2 = r1
            r3 = 3
            r4 = 97
            r5 = -1
            r1 = r0
            r0 = r9
            r9 = r8
        L1d:
            int r5 = r5 + 1
            byte r6 = (byte) r4
            r2[r5] = r6
            r6 = 22
            if (r5 != r6) goto L42
            java.lang.String r1 = new java.lang.String
            r3 = 0
            r1.<init>(r2, r3)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r8 = r1.isInstance(r8)
            if (r8 == 0) goto L3d
            android.content.Context r9 = (android.content.Context) r9
            android.graphics.drawable.Drawable r8 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r9, r0)
            return r8
        L3d:
            android.graphics.drawable.Drawable r8 = r9.getDrawable(r0)
            return r8
        L42:
            int r3 = r3 + 1
            r6 = r1[r3]
            r7 = r3
            r3 = r2
            r2 = r6
            r6 = r5
            r5 = r7
        L4b:
            int r4 = r4 + r2
            int r4 = r4 + (-8)
            r2 = r3
            r3 = r5
            r5 = r6
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
