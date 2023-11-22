package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: classes.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {
    public static final byte[] PlaceComponentResult = {103, 121, -60, -41, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int moveToNextValue = 76;
    Window.Callback BuiltInFictitiousFunctionClassFactory;
    private int DatabaseTableConfigUtil;
    private CharSequence GetContactSyncConfig;
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    Toolbar MyBillsEntityDataFactory;
    private Drawable NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Drawable NetworkUserEntityData$$ExternalSyntheticLambda1;
    private Drawable NetworkUserEntityData$$ExternalSyntheticLambda2;
    private CharSequence NetworkUserEntityData$$ExternalSyntheticLambda7;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    private View PrepareContext;
    CharSequence getAuthRequestContext;
    private int getErrorConfigVersion;
    private Drawable initRecordTimeStamp;
    private View lookAheadTest;
    private int newProxyInstance;
    private ActionMenuPresenter scheduleImpl;

    /* JADX WARN: Removed duplicated region for block: B:20:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0024 -> B:23:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, java.lang.Object[] r8) {
        /*
            int r7 = r7 + 4
            byte[] r0 = androidx.appcompat.widget.ToolbarWidgetWrapper.PlaceComponentResult
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 0
            if (r0 != 0) goto L12
            r4 = 3
            r5 = 0
            r6 = 22
            goto L28
        L12:
            r4 = 97
            r5 = 0
        L15:
            int r7 = r7 + 1
            byte r6 = (byte) r4
            r1[r5] = r6
            if (r5 != r2) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r3)
            r8[r3] = r7
            return
        L24:
            r6 = r0[r7]
            int r5 = r5 + 1
        L28:
            int r6 = -r6
            int r4 = r4 + r6
            int r4 = r4 + (-8)
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ToolbarWidgetWrapper.a(int, java.lang.Object[]):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ToolbarWidgetWrapper(androidx.appcompat.widget.Toolbar r3, boolean r4) {
        /*
            r2 = this;
            int r0 = androidx.appcompat.R.string.MyBillsEntityDataFactory
            int r1 = androidx.appcompat.R.drawable.initRecordTimeStamp
            r2.<init>(r3, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ToolbarWidgetWrapper.<init>(androidx.appcompat.widget.Toolbar, boolean):void");
    }

    private ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i) {
        int i2;
        Drawable drawable;
        this.newProxyInstance = 0;
        this.getErrorConfigVersion = 0;
        this.MyBillsEntityDataFactory = toolbar;
        this.getAuthRequestContext = toolbar.getTitle();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = toolbar.getSubtitle();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = this.getAuthRequestContext != null;
        this.initRecordTimeStamp = toolbar.getNavigationIcon();
        TintTypedArray authRequestContext = TintTypedArray.getAuthRequestContext(toolbar.getContext(), null, R.styleable.KClassImpl$Data$declaredNonStaticMembers$2, R.attr.KClassImpl$Data$declaredNonStaticMembers$2, 0);
        int i3 = R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Object[] objArr = new Object[1];
        a(-1, objArr);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Class.forName((String) objArr[0]).isInstance(authRequestContext) ? InstrumentInjector.Resources_getDrawable((Context) authRequestContext, i3) : authRequestContext.BuiltInFictitiousFunctionClassFactory(i3);
        if (z) {
            CharSequence text = authRequestContext.BuiltInFictitiousFunctionClassFactory.getText(R.styleable.newProxyInstance);
            if (!TextUtils.isEmpty(text)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
                PlaceComponentResult(text);
            }
            CharSequence text2 = authRequestContext.BuiltInFictitiousFunctionClassFactory.getText(R.styleable.PrepareContext);
            if (!TextUtils.isEmpty(text2)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = text2;
                if ((this.DatabaseTableConfigUtil & 8) != 0) {
                    this.MyBillsEntityDataFactory.setSubtitle(text2);
                }
            }
            int i4 = R.styleable.isLayoutRequested;
            Object[] objArr2 = new Object[1];
            a(-1, objArr2);
            Drawable Resources_getDrawable = Class.forName((String) objArr2[0]).isInstance(authRequestContext) ? InstrumentInjector.Resources_getDrawable((Context) authRequestContext, i4) : authRequestContext.BuiltInFictitiousFunctionClassFactory(i4);
            if (Resources_getDrawable != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = Resources_getDrawable;
                FragmentBottomSheetPaymentSettingBinding();
            }
            int i5 = R.styleable.GetContactSyncConfig;
            Object[] objArr3 = new Object[1];
            a(-1, objArr3);
            Drawable Resources_getDrawable2 = Class.forName((String) objArr3[0]).isInstance(authRequestContext) ? InstrumentInjector.Resources_getDrawable((Context) authRequestContext, i5) : authRequestContext.BuiltInFictitiousFunctionClassFactory(i5);
            if (Resources_getDrawable2 != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = Resources_getDrawable2;
                FragmentBottomSheetPaymentSettingBinding();
            }
            if (this.initRecordTimeStamp == null && (drawable = this.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
                this.initRecordTimeStamp = drawable;
                NetworkUserEntityData$$ExternalSyntheticLambda3();
            }
            getAuthRequestContext(authRequestContext.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.lookAheadTest, 0));
            int resourceId = authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.moveToNextValue, 0);
            if (resourceId != 0) {
                View inflate = LayoutInflater.from(this.MyBillsEntityDataFactory.getContext()).inflate(resourceId, (ViewGroup) this.MyBillsEntityDataFactory, false);
                View view = this.lookAheadTest;
                if (view != null && (this.DatabaseTableConfigUtil & 16) != 0) {
                    this.MyBillsEntityDataFactory.removeView(view);
                }
                this.lookAheadTest = inflate;
                if (inflate != null && (this.DatabaseTableConfigUtil & 16) != 0) {
                    this.MyBillsEntityDataFactory.addView(inflate);
                }
                getAuthRequestContext(this.DatabaseTableConfigUtil | 16);
            }
            int layoutDimension = authRequestContext.BuiltInFictitiousFunctionClassFactory.getLayoutDimension(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda1, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.MyBillsEntityDataFactory.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.MyBillsEntityDataFactory.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = authRequestContext.BuiltInFictitiousFunctionClassFactory.getDimensionPixelOffset(R.styleable.getErrorConfigVersion, -1);
            int dimensionPixelOffset2 = authRequestContext.BuiltInFictitiousFunctionClassFactory.getDimensionPixelOffset(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda0, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                this.MyBillsEntityDataFactory.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda6, 0);
            if (resourceId2 != 0) {
                Toolbar toolbar2 = this.MyBillsEntityDataFactory;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), resourceId2);
            }
            int resourceId3 = authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda8, 0);
            if (resourceId3 != 0) {
                Toolbar toolbar3 = this.MyBillsEntityDataFactory;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), resourceId3);
            }
            int resourceId4 = authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda7, 0);
            if (resourceId4 != 0) {
                this.MyBillsEntityDataFactory.setPopupTheme(resourceId4);
            }
        } else {
            if (this.MyBillsEntityDataFactory.getNavigationIcon() != null) {
                i2 = 15;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.MyBillsEntityDataFactory.getNavigationIcon();
            } else {
                i2 = 11;
            }
            this.DatabaseTableConfigUtil = i2;
        }
        authRequestContext.BuiltInFictitiousFunctionClassFactory.recycle();
        if (i != this.getErrorConfigVersion) {
            this.getErrorConfigVersion = i;
            if (TextUtils.isEmpty(this.MyBillsEntityDataFactory.getNavigationContentDescription())) {
                int i6 = this.getErrorConfigVersion;
                this.GetContactSyncConfig = i6 != 0 ? this.MyBillsEntityDataFactory.getContext().getString(i6) : null;
                NetworkUserEntityData$$ExternalSyntheticLambda6();
            }
        }
        this.GetContactSyncConfig = this.MyBillsEntityDataFactory.getNavigationContentDescription();
        this.MyBillsEntityDataFactory.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.1
            final ActionMenuItem PlaceComponentResult;

            {
                ToolbarWidgetWrapper.this = this;
                this.PlaceComponentResult = new ActionMenuItem(this.MyBillsEntityDataFactory.getContext(), this.getAuthRequestContext);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ToolbarWidgetWrapper.this.BuiltInFictitiousFunctionClassFactory == null || !ToolbarWidgetWrapper.this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    return;
                }
                ToolbarWidgetWrapper.this.BuiltInFictitiousFunctionClassFactory.onMenuItemSelected(0, this.PlaceComponentResult);
            }
        });
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final ViewGroup getErrorConfigVersion() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final Context BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory.getContext();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean DatabaseTableConfigUtil() {
        return this.MyBillsEntityDataFactory.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory.collapseActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void getAuthRequestContext(Window.Callback callback) {
        this.BuiltInFictitiousFunctionClassFactory = callback;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void getAuthRequestContext(CharSequence charSequence) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            return;
        }
        PlaceComponentResult(charSequence);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final CharSequence lookAheadTest() {
        return this.MyBillsEntityDataFactory.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
        PlaceComponentResult(charSequence);
    }

    private void PlaceComponentResult(CharSequence charSequence) {
        this.getAuthRequestContext = charSequence;
        if ((this.DatabaseTableConfigUtil & 8) != 0) {
            this.MyBillsEntityDataFactory.setTitle(charSequence);
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
                ViewCompat.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getRootView(), charSequence);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void isLayoutRequested() {
        InstrumentInjector.log_i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        InstrumentInjector.log_i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean initRecordTimeStamp() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1 != null;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean GetContactSyncConfig() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2 != null;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = drawable;
        FragmentBottomSheetPaymentSettingBinding();
    }

    private void FragmentBottomSheetPaymentSettingBinding() {
        Drawable drawable;
        int i = this.DatabaseTableConfigUtil;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (drawable == null) {
                drawable = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            }
        } else {
            drawable = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        }
        this.MyBillsEntityDataFactory.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean getAuthRequestContext() {
        return this.MyBillsEntityDataFactory.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean newProxyInstance() {
        return this.MyBillsEntityDataFactory.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean PrepareContext() {
        return this.MyBillsEntityDataFactory.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda7() {
        return this.MyBillsEntityDataFactory.showOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return this.MyBillsEntityDataFactory.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void MyBillsEntityDataFactory(Menu menu, MenuPresenter.Callback callback) {
        if (this.scheduleImpl == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.MyBillsEntityDataFactory.getContext());
            this.scheduleImpl = actionMenuPresenter;
            actionMenuPresenter.MyBillsEntityDataFactory = R.id.getErrorConfigVersion;
        }
        this.scheduleImpl.setCallback(callback);
        this.MyBillsEntityDataFactory.setMenu((MenuBuilder) menu, this.scheduleImpl);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.DatabaseTableConfigUtil;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void getAuthRequestContext(int i) {
        View view;
        int i2 = this.DatabaseTableConfigUtil ^ i;
        this.DatabaseTableConfigUtil = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    NetworkUserEntityData$$ExternalSyntheticLambda6();
                }
                NetworkUserEntityData$$ExternalSyntheticLambda3();
            }
            if ((i2 & 3) != 0) {
                FragmentBottomSheetPaymentSettingBinding();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.MyBillsEntityDataFactory.setTitle(this.getAuthRequestContext);
                    this.MyBillsEntityDataFactory.setSubtitle(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                } else {
                    this.MyBillsEntityDataFactory.setTitle((CharSequence) null);
                    this.MyBillsEntityDataFactory.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.lookAheadTest) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.MyBillsEntityDataFactory.addView(view);
            } else {
                this.MyBillsEntityDataFactory.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void PlaceComponentResult(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.PrepareContext;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.MyBillsEntityDataFactory;
            if (parent == toolbar) {
                toolbar.removeView(this.PrepareContext);
            }
        }
        this.PrepareContext = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.newProxyInstance != 2) {
            return;
        }
        this.MyBillsEntityDataFactory.addView(scrollingTabContainerView, 0);
        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.PrepareContext.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.BuiltInFictitiousFunctionClassFactory = BadgeDrawable.BOTTOM_START;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void MyBillsEntityDataFactory(boolean z) {
        this.MyBillsEntityDataFactory.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final int moveToNextValue() {
        return this.newProxyInstance;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final ViewPropertyAnimatorCompat PlaceComponentResult(final int i, long j) {
        return ViewCompat.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory).getAuthRequestContext(i == 0 ? 1.0f : 0.0f).KClassImpl$Data$declaredNonStaticMembers$2(j).KClassImpl$Data$declaredNonStaticMembers$2(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.2
            private boolean getAuthRequestContext = false;

            {
                ToolbarWidgetWrapper.this = this;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void MyBillsEntityDataFactory(View view) {
                ToolbarWidgetWrapper.this.MyBillsEntityDataFactory.setVisibility(0);
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void getAuthRequestContext(View view) {
                if (this.getAuthRequestContext) {
                    return;
                }
                ToolbarWidgetWrapper.this.MyBillsEntityDataFactory.setVisibility(i);
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
                this.getAuthRequestContext = true;
            }
        });
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void PlaceComponentResult(Drawable drawable) {
        this.initRecordTimeStamp = drawable;
        NetworkUserEntityData$$ExternalSyntheticLambda3();
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        if ((this.DatabaseTableConfigUtil & 4) != 0) {
            Toolbar toolbar = this.MyBillsEntityDataFactory;
            Drawable drawable = this.initRecordTimeStamp;
            if (drawable == null) {
                drawable = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.MyBillsEntityDataFactory.setNavigationIcon((Drawable) null);
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        if ((this.DatabaseTableConfigUtil & 4) != 0) {
            if (TextUtils.isEmpty(this.GetContactSyncConfig)) {
                this.MyBillsEntityDataFactory.setNavigationContentDescription(this.getErrorConfigVersion);
            } else {
                this.MyBillsEntityDataFactory.setNavigationContentDescription(this.GetContactSyncConfig);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void MyBillsEntityDataFactory(SparseArray<Parcelable> sparseArray) {
        this.MyBillsEntityDataFactory.saveHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void PlaceComponentResult(SparseArray<Parcelable> sparseArray) {
        this.MyBillsEntityDataFactory.restoreHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final int NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.MyBillsEntityDataFactory.getHeight();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        this.MyBillsEntityDataFactory.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void MyBillsEntityDataFactory(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.MyBillsEntityDataFactory.setMenuCallbacks(callback, callback2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final Menu scheduleImpl() {
        return this.MyBillsEntityDataFactory.getMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = i != 0 ? ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getContext(), i) : null;
        FragmentBottomSheetPaymentSettingBinding();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void PlaceComponentResult(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i != 0 ? ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getContext(), i) : null;
        FragmentBottomSheetPaymentSettingBinding();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void MyBillsEntityDataFactory(int i) {
        this.GetContactSyncConfig = i == 0 ? null : this.MyBillsEntityDataFactory.getContext().getString(i);
        NetworkUserEntityData$$ExternalSyntheticLambda6();
    }
}
