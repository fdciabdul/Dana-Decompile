package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {
    private Drawable BuiltInFictitiousFunctionClassFactory;
    private TextView DatabaseTableConfigUtil;
    private Drawable GetContactSyncConfig;
    private CheckBox MyBillsEntityDataFactory;
    private LayoutInflater NetworkUserEntityData$$ExternalSyntheticLambda0;
    private RadioButton NetworkUserEntityData$$ExternalSyntheticLambda1;
    private MenuItemImpl NetworkUserEntityData$$ExternalSyntheticLambda2;
    private TextView NetworkUserEntityData$$ExternalSyntheticLambda8;
    private LinearLayout PlaceComponentResult;
    private Context PrepareContext;
    private ImageView getErrorConfigVersion;
    private boolean initRecordTimeStamp;
    private ImageView isLayoutRequested;
    private ImageView lookAheadTest;
    private boolean moveToNextValue;
    private int newProxyInstance;
    private boolean scheduleImpl;
    public static final byte[] getAuthRequestContext = {12, -73, 84, 57, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 204;

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.VerifyPinStateManager$executeRiskChallenge$2$1);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        TintTypedArray authRequestContext = TintTypedArray.getAuthRequestContext(getContext(), attributeSet, R.styleable.f3x461046da, i, 0);
        this.BuiltInFictitiousFunctionClassFactory = __fsTypeCheck_03006d36da53514240897610a74f16fc(authRequestContext, R.styleable.BannerEntityDataFactory_Factory);
        this.newProxyInstance = authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.DebugCoroutineInfoImpl, -1);
        this.initRecordTimeStamp = authRequestContext.getAuthRequestContext(R.styleable.View$OnClickListener, false);
        this.PrepareContext = context;
        this.GetContactSyncConfig = __fsTypeCheck_03006d36da53514240897610a74f16fc(authRequestContext, R.styleable.SchedulerPoolFactory);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, R.attr.BottomSheetCardBindingView$watcherCardNumberView$1, 0);
        this.moveToNextValue = obtainStyledAttributes.hasValue(0);
        authRequestContext.BuiltInFictitiousFunctionClassFactory.recycle();
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this, this.BuiltInFictitiousFunctionClassFactory);
        TextView textView = (TextView) findViewById(R.id.AppCompatEmojiTextHelper);
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = textView;
        int i = this.newProxyInstance;
        if (i != -1) {
            textView.setTextAppearance(this.PrepareContext, i);
        }
        this.DatabaseTableConfigUtil = (TextView) findViewById(R.id.D);
        ImageView imageView = (ImageView) findViewById(R.id.G);
        this.isLayoutRequested = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.GetContactSyncConfig);
        }
        this.getErrorConfigVersion = (ImageView) findViewById(R.id.FragmentBottomSheetPaymentSettingBinding);
        this.PlaceComponentResult = (LinearLayout) findViewById(R.id.NetworkUserEntityData$$ExternalSyntheticLambda2);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i) {
        CharSequence title;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (prefersCondensedTitle()) {
            title = menuItemImpl.getTitleCondensed();
        } else {
            title = menuItemImpl.getTitle();
        }
        setTitle(title);
        setCheckable(menuItemImpl.isCheckable());
        setShortcut(menuItemImpl.scheduleImpl(), menuItemImpl.KClassImpl$Data$declaredNonStaticMembers$2());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        boolean hasSubMenu = menuItemImpl.hasSubMenu();
        ImageView imageView = this.isLayoutRequested;
        if (imageView != null) {
            imageView.setVisibility(hasSubMenu ? 0 : 8);
        }
        setContentDescription(menuItemImpl.getContentDescription());
    }

    public void setForceShowIcon(boolean z) {
        this.scheduleImpl = z;
        this.initRecordTimeStamp = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.setText(charSequence);
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda8.getVisibility() != 0) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.setVisibility(0);
            }
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda8.getVisibility() != 8) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        View view;
        if (!z && this.NetworkUserEntityData$$ExternalSyntheticLambda1 == null && this.MyBillsEntityDataFactory == null) {
            return;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.lookAheadTest()) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                BuiltInFictitiousFunctionClassFactory();
            }
            compoundButton = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            view = this.MyBillsEntityDataFactory;
        } else {
            if (this.MyBillsEntityDataFactory == null) {
                PlaceComponentResult();
            }
            compoundButton = this.MyBillsEntityDataFactory;
            view = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        }
        if (z) {
            compoundButton.setChecked(this.NetworkUserEntityData$$ExternalSyntheticLambda2.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.MyBillsEntityDataFactory;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.lookAheadTest()) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                BuiltInFictitiousFunctionClassFactory();
            }
            compoundButton = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        } else {
            if (this.MyBillsEntityDataFactory == null) {
                PlaceComponentResult();
            }
            compoundButton = this.MyBillsEntityDataFactory;
        }
        compoundButton.setChecked(z);
    }

    public void setShortcut(boolean z, char c) {
        String obj;
        int i = (z && this.NetworkUserEntityData$$ExternalSyntheticLambda2.scheduleImpl()) ? 0 : 8;
        if (i == 0) {
            TextView textView = this.DatabaseTableConfigUtil;
            MenuItemImpl menuItemImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            char KClassImpl$Data$declaredNonStaticMembers$22 = menuItemImpl.KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$22 == 0) {
                obj = "";
            } else {
                Resources resources = menuItemImpl.PlaceComponentResult.getContext().getResources();
                StringBuilder sb = new StringBuilder();
                if (ViewConfiguration.get(menuItemImpl.PlaceComponentResult.getContext()).hasPermanentMenuKey()) {
                    sb.append(resources.getString(R.string.initRecordTimeStamp));
                }
                int i2 = menuItemImpl.PlaceComponentResult.isQwertyMode() ? menuItemImpl.getErrorConfigVersion : menuItemImpl.lookAheadTest;
                MenuItemImpl.KClassImpl$Data$declaredNonStaticMembers$2(sb, i2, 65536, resources.getString(R.string.NetworkUserEntityData$$ExternalSyntheticLambda1));
                MenuItemImpl.KClassImpl$Data$declaredNonStaticMembers$2(sb, i2, 4096, resources.getString(R.string.moveToNextValue));
                MenuItemImpl.KClassImpl$Data$declaredNonStaticMembers$2(sb, i2, 2, resources.getString(R.string.getErrorConfigVersion));
                MenuItemImpl.KClassImpl$Data$declaredNonStaticMembers$2(sb, i2, 1, resources.getString(R.string.GetContactSyncConfig));
                MenuItemImpl.KClassImpl$Data$declaredNonStaticMembers$2(sb, i2, 4, resources.getString(R.string.DatabaseTableConfigUtil));
                MenuItemImpl.KClassImpl$Data$declaredNonStaticMembers$2(sb, i2, 8, resources.getString(R.string.lookAheadTest));
                if (KClassImpl$Data$declaredNonStaticMembers$22 == '\b') {
                    sb.append(resources.getString(R.string.NetworkUserEntityData$$ExternalSyntheticLambda0));
                } else if (KClassImpl$Data$declaredNonStaticMembers$22 == '\n') {
                    sb.append(resources.getString(R.string.scheduleImpl));
                } else if (KClassImpl$Data$declaredNonStaticMembers$22 == ' ') {
                    sb.append(resources.getString(R.string.NetworkUserEntityData$$ExternalSyntheticLambda2));
                } else {
                    sb.append(KClassImpl$Data$declaredNonStaticMembers$22);
                }
                obj = sb.toString();
            }
            textView.setText(obj);
        }
        if (this.DatabaseTableConfigUtil.getVisibility() != i) {
            this.DatabaseTableConfigUtil.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue() || this.scheduleImpl;
        if (z || this.initRecordTimeStamp) {
            ImageView imageView = this.lookAheadTest;
            if (imageView == null && drawable == null && !this.initRecordTimeStamp) {
                return;
            }
            if (imageView == null) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LayoutInflater.from(getContext());
                }
                ImageView imageView2 = (ImageView) this.NetworkUserEntityData$$ExternalSyntheticLambda0.inflate(R.layout.DatabaseTableConfigUtil, (ViewGroup) this, false);
                this.lookAheadTest = imageView2;
                LinearLayout linearLayout = this.PlaceComponentResult;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable != null || this.initRecordTimeStamp) {
                ImageView imageView3 = this.lookAheadTest;
                if (!z) {
                    drawable = null;
                }
                imageView3.setImageDrawable(drawable);
                if (this.lookAheadTest.getVisibility() != 0) {
                    this.lookAheadTest.setVisibility(0);
                    return;
                }
                return;
            }
            this.lookAheadTest.setVisibility(8);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.lookAheadTest != null && this.initRecordTimeStamp) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lookAheadTest.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public boolean showsIcon() {
        return this.scheduleImpl;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.getErrorConfigVersion;
        if (imageView != null) {
            imageView.setVisibility((this.moveToNextValue || !z) ? 8 : 0);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.getErrorConfigVersion;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.getErrorConfigVersion.getLayoutParams();
        rect.top += this.getErrorConfigVersion.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0040 -> B:15:0x0047). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray r9, int r10) {
        /*
            byte[] r0 = androidx.appcompat.view.menu.ListMenuItemView.getAuthRequestContext
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 0
            r3 = 97
            r4 = 3
            if (r0 != 0) goto L14
            r4 = r1
            r5 = 3
            r6 = 0
            r7 = 3
            r1 = r0
            r0 = r10
            r10 = r9
            goto L47
        L14:
            r3 = r1
            r4 = 97
            r5 = 3
            r6 = 0
            r1 = r0
            r0 = r10
            r10 = r9
        L1c:
            byte r7 = (byte) r4
            r3[r6] = r7
            r7 = 22
            int r5 = r5 + 1
            if (r6 != r7) goto L40
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r2)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r9 = r1.isInstance(r9)
            if (r9 == 0) goto L3b
            android.content.Context r10 = (android.content.Context) r10
            android.graphics.drawable.Drawable r9 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r10, r0)
            return r9
        L3b:
            android.graphics.drawable.Drawable r9 = r10.BuiltInFictitiousFunctionClassFactory(r0)
            return r9
        L40:
            int r6 = r6 + 1
            r7 = r1[r5]
            r8 = r4
            r4 = r3
            r3 = r8
        L47:
            int r7 = -r7
            int r3 = r3 + r7
            int r3 = r3 + (-8)
            r8 = r4
            r4 = r3
            r3 = r8
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.__fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray, int):android.graphics.drawable.Drawable");
    }

    private void PlaceComponentResult() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LayoutInflater.from(getContext());
        }
        CheckBox checkBox = (CheckBox) this.NetworkUserEntityData$$ExternalSyntheticLambda0.inflate(R.layout.getErrorConfigVersion, (ViewGroup) this, false);
        this.MyBillsEntityDataFactory = checkBox;
        LinearLayout linearLayout = this.PlaceComponentResult;
        if (linearLayout != null) {
            linearLayout.addView(checkBox, -1);
        } else {
            addView(checkBox, -1);
        }
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LayoutInflater.from(getContext());
        }
        RadioButton radioButton = (RadioButton) this.NetworkUserEntityData$$ExternalSyntheticLambda0.inflate(R.layout.NetworkUserEntityData$$ExternalSyntheticLambda1, (ViewGroup) this, false);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = radioButton;
        LinearLayout linearLayout = this.PlaceComponentResult;
        if (linearLayout != null) {
            linearLayout.addView(radioButton, -1);
        } else {
            addView(radioButton, -1);
        }
    }
}
