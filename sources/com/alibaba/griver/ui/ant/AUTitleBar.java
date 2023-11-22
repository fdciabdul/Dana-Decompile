package com.alibaba.griver.ui.ant;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.AUSegment;
import com.alibaba.griver.ui.ant.api.AUViewInterface;
import com.alibaba.griver.ui.ant.api.AntUI;
import com.alibaba.griver.ui.ant.api.ScrollTitleChangeListener;
import com.alibaba.griver.ui.ant.layout.AULinearLayout;
import com.alibaba.griver.ui.ant.layout.AURelativeLayout;
import com.alibaba.griver.ui.ant.text.AUIconView;
import com.alibaba.griver.ui.ant.text.AUTextView;
import com.alibaba.griver.ui.ant.theme.AUAbsTheme;
import com.alibaba.griver.ui.ant.theme.AUThemeKey;
import com.alibaba.griver.ui.ant.theme.AUThemeManager;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alibaba.griver.ui.ant.utils.AUScreenUtils;
import com.alibaba.griver.ui.ant.utils.StateListUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;

/* loaded from: classes6.dex */
public class AUTitleBar extends AURelativeLayout implements AUViewInterface, AntUI {
    private AttributeSet A;
    private OnBackListener B;
    private AUIconView b;
    private AUTextView c;
    private AUIconView d;
    private AUIconView e;
    private AURelativeLayout f;
    private AURelativeLayout g;
    private AURelativeLayout h;
    private AURelativeLayout i;
    private AULinearLayout j;
    private AULinearLayout k;
    private Drawable l;
    private int m;
    public int mDefaultScrollHeight;
    private int n;

    /* renamed from: o */
    private int f6658o;
    private int p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private int x;
    private boolean y;
    private AUSegment z;
    public static final byte[] PlaceComponentResult = {42, -75, 2, Ascii.US, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 246;

    /* renamed from: a */
    private static int[] f6657a = {0, 0, 30, 107, 191, 255};

    /* loaded from: classes6.dex */
    interface OnBackListener {
        boolean onBack();
    }

    public AUTitleBar(Context context) {
        super(context);
        this.mDefaultScrollHeight = 0;
        a(context, null);
    }

    public AUTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDefaultScrollHeight = 0;
        a(context, attributeSet);
    }

    public AUTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDefaultScrollHeight = 0;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        init(context, null, null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.grivertitleBar);
            initContent(context, null, obtainStyledAttributes);
            initStyleByTheme(context);
            initAttrStyle(context, null, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        } else {
            initStyleByTheme(context);
        }
        b();
    }

    @Override // com.alibaba.griver.ui.ant.api.AntUI
    public void init(Context context, AttributeSet attributeSet, TypedArray typedArray) {
        this.A = attributeSet;
        LayoutInflater.from(context).inflate(R.layout.griver_ui_title_bar, (ViewGroup) this, true);
        this.i = (AURelativeLayout) findViewById(R.id.title_bar_kernel);
        this.j = (AULinearLayout) findViewById(R.id.title_bar_horizon);
        this.b = (AUIconView) findViewById(R.id.back_button);
        this.c = (AUTextView) findViewById(R.id.title_text);
        this.d = (AUIconView) findViewById(R.id.left_text);
        this.e = (AUIconView) findViewById(R.id.right_text);
        this.f = (AURelativeLayout) findViewById(R.id.title_container);
        this.g = (AURelativeLayout) findViewById(R.id.right_container_1);
        this.h = (AURelativeLayout) findViewById(R.id.right_container_2);
        a();
        this.l = InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.griver_ui_drawable_titlebar_bg);
        this.n = getResources().getColor(R.color.griver_AU_COLOR_TITLE);
        if (AUScreenUtils.checkApFlag(context, attributeSet, this)) {
            this.m = AUScreenAdaptTool.getApFromDimen(getContext(), R.dimen.griver_title_text_size);
            this.q = AUScreenAdaptTool.getApFromDimen(getContext(), R.dimen.griver_button_icon_size);
            this.s = AUScreenAdaptTool.getApFromDimen(getContext(), R.dimen.griver_button_text_size);
            this.v = AUScreenAdaptTool.getApFromDimen(getContext(), R.dimen.griver_button_icon_size);
            this.x = AUScreenAdaptTool.getApFromDimen(getContext(), R.dimen.griver_button_text_size);
            this.mDefaultScrollHeight = (int) (AUScreenAdaptTool.getAPDensity(context) * 148.0f);
        } else {
            this.m = getResources().getDimensionPixelSize(R.dimen.griver_title_text_size);
            this.q = getResources().getDimensionPixelOffset(R.dimen.griver_button_icon_size);
            this.s = getResources().getDimensionPixelOffset(R.dimen.griver_button_text_size);
            this.v = getResources().getDimensionPixelOffset(R.dimen.griver_button_icon_size);
            this.x = getResources().getDimensionPixelOffset(R.dimen.griver_button_text_size);
            this.mDefaultScrollHeight = (int) (getResources().getDisplayMetrics().density * 148.0f);
        }
        this.f6658o = getResources().getColor(R.color.griver_ui_light_title_color);
        this.p = getResources().getColor(R.color.griver_ui_light_title_color);
        this.r = getResources().getColor(R.color.griver_ui_light_title_color);
        this.u = getResources().getColor(R.color.griver_ui_light_title_color);
        this.w = getResources().getColor(R.color.griver_ui_light_title_color);
        this.t = false;
        this.y = false;
    }

    @Override // com.alibaba.griver.ui.ant.api.AntUI
    public void initContent(Context context, AttributeSet attributeSet, TypedArray typedArray) {
        if (typedArray.hasValue(R.styleable.grivertitleBar_griverTitleText)) {
            this.c.setText(typedArray.getString(R.styleable.grivertitleBar_griverTitleText));
        }
        if (typedArray.hasValue(R.styleable.grivertitleBar_leftIconUnicode)) {
            setLeftButtonUnicode(typedArray.getString(R.styleable.grivertitleBar_leftIconUnicode));
        } else if (typedArray.hasValue(R.styleable.grivertitleBar_leftIconResid)) {
            setBtnImage(this.d, typedArray.getResourceId(R.styleable.grivertitleBar_leftIconResid, 0));
        } else if (typedArray.hasValue(R.styleable.grivertitleBar_leftText)) {
            setLeftButtonUnicode(typedArray.getString(R.styleable.grivertitleBar_leftText));
            this.t = true;
        } else {
            this.g.setVisibility(8);
        }
        if (typedArray.hasValue(R.styleable.grivertitleBar_rightIconUnicode)) {
            setRightButtonUnicode(typedArray.getString(R.styleable.grivertitleBar_rightIconUnicode));
        } else if (typedArray.hasValue(R.styleable.grivertitleBar_rightIconResid)) {
            setBtnImage(this.e, typedArray.getResourceId(R.styleable.grivertitleBar_rightIconResid, 0));
        } else if (typedArray.hasValue(R.styleable.grivertitleBar_rightText)) {
            setRightButtonText(typedArray.getString(R.styleable.grivertitleBar_rightText));
            this.y = true;
        } else {
            this.h.setVisibility(8);
        }
    }

    @Override // com.alibaba.griver.ui.ant.api.AntUI
    public void initStyleByTheme(Context context) {
        AUAbsTheme currentTheme = AUThemeManager.getCurrentTheme();
        this.l = currentTheme.getDrawable(context, AUThemeKey.TITLEBAR_BACKGROUND_COLOR, this.l);
        this.f6658o = currentTheme.getColor(context, AUThemeKey.TITLEBAR_ICON_COLOR, Integer.valueOf(this.f6658o)).intValue();
        this.m = currentTheme.getColor(context, AUThemeKey.TITLEBAR_TITLE_TEXTSIZE, Integer.valueOf(this.m)).intValue();
        this.n = currentTheme.getColor(context, AUThemeKey.TITLEBAR_TITLE_TEXTCOLOR, Integer.valueOf(this.n)).intValue();
        this.p = currentTheme.getColor(context, AUThemeKey.TITLEBAR_ICON_COLOR, Integer.valueOf(this.p)).intValue();
        this.q = currentTheme.getDimensionPixelOffset(context, AUThemeKey.TITLEBAR_ICON_SIZE, Integer.valueOf(this.q)).intValue();
        this.r = currentTheme.getColor(context, AUThemeKey.TITLEBAR_TEXTCOLOR, Integer.valueOf(this.r)).intValue();
        this.s = currentTheme.getDimensionPixelOffset(context, AUThemeKey.TITLEBAR_TEXTSIZE, Integer.valueOf(this.s)).intValue();
        this.u = currentTheme.getColor(context, AUThemeKey.TITLEBAR_ICON_COLOR, Integer.valueOf(this.u)).intValue();
        this.v = currentTheme.getDimensionPixelOffset(context, AUThemeKey.TITLEBAR_ICON_SIZE, Integer.valueOf(this.v)).intValue();
        this.w = currentTheme.getColor(context, AUThemeKey.TITLEBAR_TEXTCOLOR, Integer.valueOf(this.w)).intValue();
        this.x = currentTheme.getDimensionPixelOffset(context, AUThemeKey.TITLEBAR_TEXTSIZE, Integer.valueOf(this.x)).intValue();
    }

    @Override // com.alibaba.griver.ui.ant.api.AntUI
    public void initAttrStyle(Context context, AttributeSet attributeSet, TypedArray typedArray) {
        if (typedArray.hasValue(R.styleable.grivertitleBar_griverBackgroundDrawable)) {
            this.l = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(typedArray, R.styleable.grivertitleBar_griverBackgroundDrawable);
        }
        if (typedArray.hasValue(R.styleable.grivertitleBar_backIconColor)) {
            this.f6658o = typedArray.getColor(R.styleable.grivertitleBar_backIconColor, this.f6658o);
        }
        this.m = typedArray.getDimensionPixelOffset(R.styleable.grivertitleBar_griverTitleTextSize, this.m);
        this.n = typedArray.getColor(R.styleable.grivertitleBar_griverTitleTextColor, this.n);
        if (typedArray.hasValue(R.styleable.grivertitleBar_leftIconColor)) {
            this.p = typedArray.getColor(R.styleable.grivertitleBar_leftIconColor, this.p);
        }
        this.q = typedArray.getDimensionPixelOffset(R.styleable.grivertitleBar_leftIconSize, this.q);
        if (typedArray.hasValue(R.styleable.grivertitleBar_leftTextColor)) {
            this.r = typedArray.getColor(R.styleable.grivertitleBar_leftTextColor, this.r);
        }
        this.s = typedArray.getDimensionPixelOffset(R.styleable.grivertitleBar_leftTextSize, this.s);
        if (typedArray.hasValue(R.styleable.grivertitleBar_rightIconColor)) {
            this.u = typedArray.getColor(R.styleable.grivertitleBar_rightIconColor, this.u);
        }
        this.v = typedArray.getDimensionPixelOffset(R.styleable.grivertitleBar_rightIconSize, this.v);
        if (typedArray.hasValue(R.styleable.grivertitleBar_rightTextColor)) {
            this.w = typedArray.getColor(R.styleable.grivertitleBar_rightTextColor, this.w);
        }
        this.x = typedArray.getDimensionPixelOffset(R.styleable.grivertitleBar_rightTextSize, this.x);
    }

    @Override // com.alibaba.griver.ui.ant.api.AntUI
    public void upDateTheme(Context context, AUAbsTheme aUAbsTheme) {
        if (aUAbsTheme != null) {
            this.l = aUAbsTheme.getDrawable(context, AUThemeKey.TITLEBAR_BACKGROUND_COLOR, this.l);
            this.f6658o = aUAbsTheme.getColor(context, AUThemeKey.TITLEBAR_ICON_COLOR, Integer.valueOf(this.f6658o)).intValue();
            this.m = aUAbsTheme.getColor(context, AUThemeKey.TITLEBAR_TITLE_TEXTSIZE, Integer.valueOf(this.m)).intValue();
            this.n = aUAbsTheme.getColor(context, AUThemeKey.TITLEBAR_TITLE_TEXTCOLOR, Integer.valueOf(this.n)).intValue();
            this.p = aUAbsTheme.getColor(context, AUThemeKey.TITLEBAR_ICON_COLOR, Integer.valueOf(this.p)).intValue();
            this.q = aUAbsTheme.getDimensionPixelOffset(context, AUThemeKey.TITLEBAR_ICON_SIZE, Integer.valueOf(this.q)).intValue();
            this.r = aUAbsTheme.getColor(context, AUThemeKey.TITLEBAR_TEXTCOLOR, Integer.valueOf(this.r)).intValue();
            this.s = aUAbsTheme.getDimensionPixelOffset(context, AUThemeKey.TITLEBAR_TEXTSIZE, Integer.valueOf(this.s)).intValue();
            this.u = aUAbsTheme.getColor(context, AUThemeKey.TITLEBAR_ICON_COLOR, Integer.valueOf(this.u)).intValue();
            this.v = aUAbsTheme.getDimensionPixelOffset(context, AUThemeKey.TITLEBAR_ICON_SIZE, Integer.valueOf(this.v)).intValue();
            this.w = aUAbsTheme.getColor(context, AUThemeKey.TITLEBAR_TEXTCOLOR, Integer.valueOf(this.w)).intValue();
            this.x = aUAbsTheme.getDimensionPixelOffset(context, AUThemeKey.TITLEBAR_TEXTSIZE, Integer.valueOf(this.x)).intValue();
            b();
        }
    }

    private void a() {
        this.b.setIconfontFileName("titlebar");
        this.b.setIconfontBundle("tinyfont");
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.ant.AUTitleBar.1
            {
                AUTitleBar.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AUTitleBar.this.B == null || !AUTitleBar.this.B.onBack()) {
                    try {
                        Context context = AUTitleBar.this.getContext();
                        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        if (context == null || !(context instanceof Activity)) {
                            return;
                        }
                        ((Activity) context).onBackPressed();
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    private void b() {
        setBackgroundDrawable(this.l);
        this.c.setTextColor(this.n);
        this.c.setTextSize(0, this.m);
        this.b.setIconfontColorStates(a(this.f6658o));
        c();
        d();
    }

    private boolean a(String str) {
        return TextUtils.equals(str, getResources().getString(R.string.griver_iconfont_user_setting)) || TextUtils.equals(str, getResources().getString(R.string.griver_iconfont_add_user));
    }

    private void setLeftButtonUnicode(String str) {
        if (a(str)) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.griver_titlebar_icon_special_size);
            this.q = dimensionPixelOffset;
            this.d.setIconfontSize(dimensionPixelOffset);
        }
        this.d.setIconfontUnicode(str);
    }

    private void setRightButtonUnicode(String str) {
        if (a(str)) {
            if (AUScreenUtils.checkApFlag(getContext(), this.A, this)) {
                this.v = AUScreenAdaptTool.getApFromDimen(getContext(), R.dimen.griver_titlebar_icon_special_size);
            } else {
                this.v = getResources().getDimensionPixelSize(R.dimen.griver_titlebar_icon_special_size);
            }
            this.e.setIconfontSize(this.v);
        }
        this.e.setIconfontUnicode(str);
    }

    private void setLeftButtonStyle(boolean z) {
        this.t = z;
        c();
    }

    private void setRightButtonStyle(boolean z) {
        this.y = z;
        d();
    }

    public void setBtnImage(AUIconView aUIconView, int i) {
        aUIconView.setImageResource(i);
    }

    public void setIconFont(AUIconView aUIconView, int i, int i2) {
        if (i != 0) {
            aUIconView.setIconfontSize(i);
            double d = i;
            Double.isNaN(d);
            aUIconView.setIconTextMinHeight((int) (d * 1.4d));
        }
        if (i2 != 0) {
            aUIconView.setIconfontColorStates(a(i2));
        }
    }

    private void c() {
        if (this.t) {
            setIconFont(this.d, this.s, this.r);
        } else {
            setIconFont(this.d, this.q, this.p);
        }
    }

    private void d() {
        if (this.y) {
            setIconFont(this.e, this.x, this.w);
        } else {
            setIconFont(this.e, this.v, this.u);
        }
    }

    public AUIconView getBackButton() {
        return this.b;
    }

    public void setOnBackListener(OnBackListener onBackListener) {
        this.B = onBackListener;
    }

    public AURelativeLayout getLeftButton() {
        return this.g;
    }

    public AUIconView getLeftButtonIconView() {
        return this.d;
    }

    public AURelativeLayout getRightButton() {
        return this.h;
    }

    public AUIconView getRightButtonIconView() {
        return this.e;
    }

    public AUTextView getTitleText() {
        return this.c;
    }

    public void setTitleText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c.setText(str);
    }

    public AURelativeLayout getTitleContainer() {
        return this.f;
    }

    public AURelativeLayout getTitleBarRelative() {
        return this.i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.i.setBackground(drawable);
        } else {
            this.i.setBackgroundDrawable(drawable);
        }
    }

    public void setTitleText(String str, int i, int i2) {
        if (i != 0) {
            this.c.setTextSize(0, i);
        }
        if (i2 != 0) {
            this.c.setTextColor(i2);
        }
        setTitleText(str);
    }

    public void addSubTitleView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, R.id.title_text);
        layoutParams.addRule(5, R.id.title_text);
        this.f.addView(view, layoutParams);
    }

    public void setBackBtnInfo(Object obj, int i, int i2) {
        if (i2 != 0) {
            this.f6658o = i2;
        }
        if (obj instanceof String) {
            this.b.setIconfontUnicode((String) obj);
        } else if (obj instanceof Drawable) {
            this.b.setImageDrawable((Drawable) obj);
            this.b.setImageViewSize(i);
        }
        setIconFont(this.b, i, i2);
    }

    public void setBackBtnInfo(Object obj) {
        if (obj instanceof String) {
            this.b.setIconfontUnicode((String) obj);
        } else if (obj instanceof Drawable) {
            this.b.setImageDrawable((Drawable) obj);
        }
    }

    public void setLeftBtnInfo(Object obj, int i, int i2, boolean z) {
        if (obj instanceof Drawable) {
            setLeftButtonIcon((Drawable) obj);
            this.d.setImageViewSize(i);
        } else if (obj instanceof String) {
            if (z) {
                setLeftButtonText((String) obj);
            } else {
                setLeftButtonIcon((String) obj);
            }
        }
        setLeftButtonFont(i, i2, z);
    }

    public void setLeftButtonIcon(Drawable drawable) {
        if (drawable == null) {
            this.g.setVisibility(8);
            return;
        }
        this.d.setImageDrawable(drawable);
        setLeftButtonStyle(false);
        this.g.setVisibility(0);
    }

    public void setLeftButtonIcon(String str) {
        if (TextUtils.isEmpty(str)) {
            this.g.setVisibility(8);
            return;
        }
        setLeftButtonUnicode(str);
        setLeftButtonStyle(false);
        this.g.setVisibility(0);
    }

    public void setLeftButtonText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.g.setVisibility(8);
            return;
        }
        this.d.setIconfontUnicode(str);
        setLeftButtonStyle(true);
        this.g.setVisibility(0);
    }

    public void setLeftButtonEnabled(boolean z) {
        this.d.setEnabled(z);
        this.g.setEnabled(z);
    }

    public void setLeftButtonFont(int i, int i2, boolean z) {
        if (z) {
            if (i2 == 0) {
                i2 = this.r;
            }
            this.r = i2;
            if (i == 0) {
                i = this.s;
            }
            this.s = i;
        } else {
            if (i2 == 0) {
                i2 = this.p;
            }
            this.p = i2;
            if (i == 0) {
                i = this.q;
            }
            this.q = i;
        }
        setLeftButtonStyle(z);
    }

    public void setRightBtnInfo(Object obj, int i, int i2, boolean z) {
        if (obj instanceof Drawable) {
            setRightButtonIcon((Drawable) obj);
            this.e.setImageViewSize(i);
        } else if (obj instanceof String) {
            if (z) {
                setRightButtonText((String) obj);
            } else {
                setRightButtonIcon((String) obj);
            }
        }
        setRightButtonFont(i, i2, z);
    }

    public void setRightButtonIcon(Drawable drawable) {
        if (drawable == null) {
            this.h.setVisibility(8);
            return;
        }
        this.e.setImageDrawable(drawable);
        setRightButtonStyle(false);
        this.h.setVisibility(0);
    }

    public void setRightButtonIcon(String str) {
        if (TextUtils.isEmpty(str)) {
            this.h.setVisibility(8);
            return;
        }
        setRightButtonUnicode(str);
        setRightButtonStyle(false);
        this.h.setVisibility(0);
    }

    public void setRightButtonText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.h.setVisibility(8);
            return;
        }
        this.e.setText(str, false);
        setRightButtonStyle(true);
        this.h.setVisibility(0);
    }

    public void setRightButtonEnabled(boolean z) {
        this.e.setEnabled(z);
        this.h.setEnabled(z);
    }

    public void setRightButtonFont(int i, int i2, boolean z) {
        if (z) {
            if (i2 == 0) {
                i2 = this.w;
            }
            this.w = i2;
            if (i == 0) {
                i = this.x;
            }
            this.x = i;
        } else {
            if (i2 == 0) {
                i2 = this.u;
            }
            this.u = i2;
            if (i == 0) {
                i = this.v;
            }
            this.v = i;
        }
        setRightButtonStyle(z);
    }

    public void handleScrollChange(int i) {
        handleScrollChange(this.mDefaultScrollHeight, i);
    }

    public void handleScrollChange(int i, int i2) {
        handleScrollChange(i, i2, null);
    }

    public void handleScrollChange(int i, int i2, ScrollTitleChangeListener scrollTitleChangeListener) {
        if (i <= 0) {
            i = this.mDefaultScrollHeight;
        }
        if (i2 < 0) {
            return;
        }
        boolean z = false;
        int i3 = (i2 * 100) / i;
        if (i3 < 80) {
            setColorWhiteStyle();
        } else {
            setColorOriginalStyle();
            z = true;
        }
        int i4 = i3 / 20;
        if (i4 >= 5) {
            i4 = 5;
        }
        if (i4 > 0 && i4 < 5) {
            int[] iArr = f6657a;
            int i5 = iArr[i4];
            this.i.getBackground().setAlpha(i5 + (((i3 % 20) * (iArr[i4 + 1] - i5)) / 20));
        } else if (i4 == 0 || i4 == 5) {
            this.i.getBackground().setAlpha(f6657a[i4]);
        }
        if (scrollTitleChangeListener != null) {
            scrollTitleChangeListener.onChange(z);
        }
    }

    public void setColorWhiteStyle() {
        int color = getContext().getResources().getColor(R.color.griver_AU_COLOR_UNIVERSAL_BG);
        this.c.setTextColor(color);
        ColorStateList a2 = a(color);
        this.b.setIconfontColorStates(a2);
        this.d.setIconfontColorStates(a2);
        this.e.setIconfontColorStates(a2);
    }

    public void setColorOriginalStyle() {
        this.c.setTextColor(this.n);
        this.b.setIconfontColorStates(a(this.f6658o));
        c();
        d();
    }

    public void setBackButtonGone() {
        this.b.setVisibility(8);
    }

    public void attachFlagToLeftBtn(View view) {
        attachFlagView(this.g, this.d, view);
    }

    public void attachFlagToRightBtn(View view) {
        attachFlagView(this.h, this.e, view);
    }

    public void attachFlagView(AURelativeLayout aURelativeLayout, View view, View view2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, view.getId());
        layoutParams.addRule(6, view.getId());
        view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.griver_flag_top_margin) - (view2.getMeasuredHeight() / 2);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.griver_flag_left_margin);
        view2.setLayoutParams(layoutParams);
        aURelativeLayout.addView(view2);
    }

    private ColorStateList a(int i) {
        int i2 = 1728053247 & i;
        return StateListUtils.getColorStateList(i, i2, i2);
    }

    public void setSegment(String[] strArr, AUSegment.TabSwitchListener tabSwitchListener) {
        this.f.removeAllViews();
        AUSegment aUSegment = this.z;
        if (aUSegment != null) {
            ViewParent parent = aUSegment.getParent();
            AURelativeLayout aURelativeLayout = this.i;
            if (parent == aURelativeLayout) {
                aURelativeLayout.removeView(this.z);
            }
        }
        AUSegment aUSegment2 = new AUSegment(getContext());
        this.z = aUSegment2;
        aUSegment2.resetTabView(strArr);
        this.z.setTabSwitchListener(tabSwitchListener);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.griver_titlebar_segment_width), getResources().getDimensionPixelSize(R.dimen.griver_AU_SPACE12));
        layoutParams.addRule(14);
        layoutParams.addRule(3, R.id.title_bar_status_bar);
        this.i.addView(this.z, layoutParams);
    }

    public void toIOSStyle(String str) {
        this.b.setIconfontSize(this.s);
        AUIconView aUIconView = this.b;
        StringBuilder sb = new StringBuilder();
        sb.append(getResources().getString(R.string.griver_iconfont_back));
        sb.append(getResources().getString(R.string.griver_back));
        aUIconView.setIconfontUnicode(sb.toString());
        this.f.removeAllViews();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(R.dimen.griver_AU_SPACE12));
        layoutParams.addRule(14);
        layoutParams.addRule(3, R.id.title_bar_status_bar);
        AUTextView aUTextView = new AUTextView(getContext());
        aUTextView.setGravity(17);
        aUTextView.setTextSize(0, this.m);
        aUTextView.setTextColor(this.n);
        aUTextView.setText(str);
        this.i.addView(aUTextView, layoutParams);
    }

    public AUSegment getSegment() {
        return this.z;
    }

    @Deprecated
    public void addButtonView(View view) {
        addButtonView(view, -1, new ViewGroup.LayoutParams(-2, -1));
    }

    public void addButtonViewToRight(View view) {
        addButtonView(view, this.j.indexOfChild(this.h) + 1, new ViewGroup.LayoutParams(-2, -1));
    }

    public void addButtonViewToLeft(View view) {
        addButtonView(view, this.j.indexOfChild(this.g), new ViewGroup.LayoutParams(-2, -1));
    }

    public void addButtonView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        this.j.addView(view, i, layoutParams);
    }

    public void setTitleView(View view) {
        if (view == null) {
            AULinearLayout aULinearLayout = this.k;
            if (aULinearLayout != null) {
                this.j.removeView(aULinearLayout);
                this.f.setVisibility(0);
                this.k.removeAllViews();
                this.k = null;
                return;
            }
            return;
        }
        AULinearLayout aULinearLayout2 = this.k;
        if (aULinearLayout2 == null) {
            this.k = new AULinearLayout(getContext());
            int indexOfChild = this.j.indexOfChild(this.f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.griver_AU_SPACE12));
            layoutParams.weight = 1.0f;
            layoutParams.rightMargin = DensityUtil.dip2px(getContext(), 13.0f);
            layoutParams.gravity = 19;
            this.k.setGravity(19);
            this.j.addView(this.k, indexOfChild, layoutParams);
        } else {
            aULinearLayout2.removeAllViews();
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        }
        this.k.addView(view, layoutParams2);
        this.f.setVisibility(8);
    }

    public View getTitleView_SetBefore() {
        AULinearLayout aULinearLayout = this.k;
        if (aULinearLayout == null || aULinearLayout.getChildCount() <= 0) {
            return null;
        }
        return this.k.getChildAt(0);
    }

    @Override // com.alibaba.griver.ui.ant.layout.AURelativeLayout, com.alibaba.griver.ui.ant.api.AUViewInterface
    public Boolean isAP() {
        return Boolean.FALSE;
    }

    @Override // com.alibaba.griver.ui.ant.layout.AURelativeLayout, com.alibaba.griver.ui.ant.api.AUViewInterface
    public void setAP(Boolean bool) {
        StringBuilder sb = new StringBuilder();
        sb.append("setAP:");
        sb.append(bool);
        GriverLogger.d("AUTitleBar", sb.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0041  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0041 -> B:31:0x004b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r10, int r11) {
        /*
            byte[] r0 = com.alibaba.griver.ui.ant.AUTitleBar.PlaceComponentResult
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 97
            r4 = 0
            r5 = 3
            if (r0 != 0) goto L17
            r5 = r1
            r6 = 22
            r7 = 3
            r8 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L4b
        L17:
            r3 = r1
            r5 = 97
            r6 = 3
            r7 = 0
            r1 = r0
            r0 = r11
            r11 = r10
        L1f:
            int r6 = r6 + 1
            byte r8 = (byte) r5
            r3[r7] = r8
            if (r7 != r2) goto L41
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L3c
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L3c:
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r0)
            return r10
        L41:
            int r7 = r7 + 1
            r8 = r1[r6]
            r9 = r5
            r5 = r3
            r3 = r8
            r8 = r7
            r7 = r6
            r6 = r9
        L4b:
            int r3 = -r3
            int r6 = r6 + r3
            int r3 = r6 + (-8)
            r6 = r7
            r7 = r8
            r9 = r5
            r5 = r3
            r3 = r9
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.AUTitleBar.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
