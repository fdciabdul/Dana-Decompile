package com.alibaba.griver.ui.ant;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.api.AntUI;
import com.alibaba.griver.ui.ant.helper.ItemCategory;
import com.alibaba.griver.ui.ant.layout.AURelativeLayout;
import com.alibaba.griver.ui.ant.layout.AUScrollLayout;
import com.alibaba.griver.ui.ant.layout.MenuItemLayout;
import com.alibaba.griver.ui.ant.text.AUIconView;
import com.alibaba.griver.ui.ant.theme.AUAbsTheme;
import com.alibaba.griver.ui.ant.theme.AUThemeKey;
import com.alibaba.griver.ui.ant.theme.AUThemeManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class AUSegment extends AURelativeLayout implements AntUI {
    public static final String TAG = "AUSegment";
    private int A;
    private int B;
    private AUScrollLayout C;
    private ImageView D;
    private float E;
    private HorizontalScrollView F;
    private MenuItemLayout G;
    private List<ItemCategory> H;
    private Map<Integer, View> I;
    private int J;
    private String K;

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f6655a;
    private int b;
    private String[] c;
    private TextView[] d;
    private int e;
    private float f;
    private ColorStateList g;
    private GradientDrawable h;
    private int i;
    private Scroller j;
    private TabSwitchListener k;
    private View l;
    private String m;
    private boolean n;

    /* renamed from: o  reason: collision with root package name */
    private int f6656o;
    private int p;
    private boolean q;
    private int[] r;
    private int[] s;
    private boolean t;
    public ImageView tabButtomLine;
    protected int tabCount;
    protected RelativeLayout[] tabRl;
    public LinearLayout tabsContainer;
    private boolean u;
    private int v;
    private int w;
    private int[] x;
    private AUIconView y;
    private boolean z;

    /* loaded from: classes6.dex */
    public interface TabSwitchListener {
        void onTabClick(int i, View view);
    }

    @Override // com.alibaba.griver.ui.ant.api.AntUI
    public void initContent(Context context, AttributeSet attributeSet, TypedArray typedArray) {
    }

    @Override // com.alibaba.griver.ui.ant.api.AntUI
    public void upDateTheme(Context context, AUAbsTheme aUAbsTheme) {
    }

    public AUSegment(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6655a = new Matrix();
        this.tabCount = 3;
        this.tabRl = new RelativeLayout[4];
        this.b = 100;
        this.c = new String[4];
        this.d = new TextView[4];
        this.f = 0.0f;
        this.g = null;
        this.i = 0;
        this.r = new int[4];
        this.s = new int[4];
        this.x = new int[4];
        this.H = new ArrayList();
        this.I = new HashMap();
        this.J = 0;
        a(context, attributeSet);
    }

    public AUSegment(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6655a = new Matrix();
        this.tabCount = 3;
        this.tabRl = new RelativeLayout[4];
        this.b = 100;
        this.c = new String[4];
        this.d = new TextView[4];
        this.f = 0.0f;
        this.g = null;
        this.i = 0;
        this.r = new int[4];
        this.s = new int[4];
        this.x = new int[4];
        this.H = new ArrayList();
        this.I = new HashMap();
        this.J = 0;
        a(context, attributeSet);
    }

    public AUSegment(Context context, int i, int i2) {
        super(context);
        this.f6655a = new Matrix();
        this.tabCount = 3;
        this.tabRl = new RelativeLayout[4];
        this.b = 100;
        this.c = new String[4];
        this.d = new TextView[4];
        this.f = 0.0f;
        this.g = null;
        this.i = 0;
        this.r = new int[4];
        this.s = new int[4];
        this.x = new int[4];
        this.H = new ArrayList();
        this.I = new HashMap();
        this.J = 0;
        a(context, null, i, i2);
    }

    public AUSegment(Context context) {
        super(context);
        this.f6655a = new Matrix();
        this.tabCount = 3;
        this.tabRl = new RelativeLayout[4];
        this.b = 100;
        this.c = new String[4];
        this.d = new TextView[4];
        this.f = 0.0f;
        this.g = null;
        this.i = 0;
        this.r = new int[4];
        this.s = new int[4];
        this.x = new int[4];
        this.H = new ArrayList();
        this.I = new HashMap();
        this.J = 0;
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        a(context, attributeSet, 0, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        if (i <= 0) {
            this.v = getResources().getDimensionPixelSize(R.dimen.griver_au_segment_text_padding) * 2;
        } else {
            this.v = i;
        }
        if (i2 <= 0) {
            this.B = this.v / 2;
        } else {
            this.B = i2;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.griverSegment);
        init(context, attributeSet, obtainStyledAttributes);
        initContent(context, attributeSet, obtainStyledAttributes);
        initStyleByTheme(context);
        initAttrStyle(context, attributeSet, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        a(context);
    }

    @Override // com.alibaba.griver.ui.ant.api.AntUI
    public void init(Context context, AttributeSet attributeSet, TypedArray typedArray) {
        this.tabCount = typedArray.getInt(R.styleable.griverSegment_griverTabCount, 4);
        this.m = typedArray.getString(R.styleable.griverSegment_griverTabTextArray);
        int i = 0;
        this.n = typedArray.getBoolean(R.styleable.griverSegment_griverUniformlySpaced, false);
        this.t = typedArray.getBoolean(R.styleable.griverSegment_griverScroll, false);
        this.u = typedArray.getBoolean(R.styleable.griverSegment_griverRepeatClick, false);
        this.z = typedArray.getBoolean(R.styleable.griverSegment_griverAdd, false);
        this.v = typedArray.getDimensionPixelOffset(R.styleable.griverSegment_griverTabSpace, this.v);
        this.B = typedArray.getDimensionPixelOffset(R.styleable.griverSegment_griverEdgeSpace, this.B);
        if (!TextUtils.isEmpty(this.m)) {
            String[] split = this.m.split(",");
            this.c = split;
            this.tabCount = split.length;
            this.d = new TextView[split.length];
            this.tabRl = new RelativeLayout[split.length];
            this.r = new int[split.length];
            this.s = new int[split.length];
            this.x = new int[split.length];
        } else {
            this.c[0] = typedArray.getString(R.styleable.griverSegment_griverTab1Text);
            this.c[1] = typedArray.getString(R.styleable.griverSegment_griverTab2Text);
            this.c[2] = typedArray.getString(R.styleable.griverSegment_griverTab3Text);
            this.c[3] = typedArray.getString(R.styleable.griverSegment_griverTab4Text);
            if (this.tabCount > 4) {
                this.tabCount = 3;
            }
        }
        while (true) {
            String[] strArr = this.c;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] == null) {
                strArr[i] = "";
            }
            i++;
        }
    }

    @Override // com.alibaba.griver.ui.ant.api.AntUI
    public void initStyleByTheme(Context context) {
        AUAbsTheme currentTheme = AUThemeManager.getCurrentTheme();
        if (currentTheme.containsKey(AUThemeKey.SEGMENT_TEXTCOLOR)) {
            this.g = currentTheme.getColorStateList(context, AUThemeKey.SEGMENT_TEXTCOLOR);
        }
        if (currentTheme.containsKey(AUThemeKey.SEGMENT_BOTTOM_COLOR)) {
            this.e = currentTheme.getColor(context, AUThemeKey.SEGMENT_BOTTOM_COLOR).intValue();
        }
    }

    @Override // com.alibaba.griver.ui.ant.api.AntUI
    public void initAttrStyle(Context context, AttributeSet attributeSet, TypedArray typedArray) {
        if (typedArray.getColor(R.styleable.griverSegment_griverButtomLineColor, 0) != 0) {
            this.e = typedArray.getColor(R.styleable.griverSegment_griverButtomLineColor, 0);
        }
    }

    private void a(Context context) {
        if (!this.t) {
            LayoutInflater.from(context).inflate(R.layout.griver_ui_switch_tab_layout, (ViewGroup) this, true);
            setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.griver_AU_SPACE10));
            this.j = new Scroller(context);
            this.tabsContainer = (LinearLayout) findViewById(R.id.tabs);
            this.tabButtomLine = (ImageView) findViewById(R.id.tabLine);
            this.y = (AUIconView) findViewById(R.id.addIcon);
            this.l = findViewById(R.id.bottomLine);
            this.p = getResources().getDisplayMetrics().widthPixels;
            a();
            getTabViews(context);
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.griver_ui_category_bar_layout, this);
        AUScrollLayout aUScrollLayout = (AUScrollLayout) findViewById(R.id.scroll_layout);
        this.C = aUScrollLayout;
        int i = this.B;
        int i2 = this.v / 2;
        int paddingTop = aUScrollLayout.getPaddingTop();
        int i3 = this.B;
        aUScrollLayout.setPadding((i + 1) - i2, paddingTop, (i3 + 1) - (this.v / 2), this.C.getPaddingBottom());
        this.F = (HorizontalScrollView) findViewById(R.id.horizontalScrollView);
        this.y = (AUIconView) findViewById(R.id.addIcon);
        ImageView imageView = (ImageView) findViewById(R.id.menu_bar);
        this.D = imageView;
        int i4 = this.e;
        if (i4 != 0) {
            imageView.setBackgroundColor(i4);
        }
        this.E = 0.0f;
        this.p = getResources().getDisplayMetrics().widthPixels;
        a();
    }

    private void a() {
        if (this.z) {
            this.y.setVisibility(0);
            this.A = this.p - getResources().getDimensionPixelSize(R.dimen.griver_au_segment_add_width);
            return;
        }
        this.y.setVisibility(8);
        this.A = this.p;
    }

    protected void getTabViews(Context context) {
        LinearLayout.LayoutParams layoutParams;
        if (this.t) {
            return;
        }
        this.tabsContainer.removeAllViews();
        this.f6656o = 0;
        for (int i = 0; i < this.tabCount; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.griver_ui_default_tab_view, (ViewGroup) null);
            this.tabRl[i] = relativeLayout;
            TextView textView = (TextView) relativeLayout.findViewById(R.id.tab_tv);
            textView.setText(this.c[i]);
            ColorStateList colorStateList = this.g;
            if (colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
            float f = this.f;
            if (f != 0.0f) {
                textView.setTextSize(0, f);
            }
            this.d[i] = textView;
            TextPaint paint = textView.getPaint();
            a(i, paint);
            if (this.n && this.f6656o > 0 && paint != null) {
                int measureText = (int) (paint.measureText(this.c[i]) + this.f6656o);
                layoutParams = new LinearLayout.LayoutParams(measureText, -1);
                this.r[i] = measureText;
                this.s[i] = (int) paint.measureText(this.c[i]);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
            }
            layoutParams.gravity = 17;
            this.tabsContainer.addView(relativeLayout, layoutParams);
        }
    }

    private void a(int i, Paint paint) {
        if (this.n && this.f6656o == 0 && this.p > 0 && paint != null) {
            String str = "";
            for (int i2 = 0; i2 < this.tabCount; i2++) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(this.c[i2]);
                str = sb.toString();
            }
            int measureText = (int) ((this.A - paint.measureText(str)) / (this.tabCount + 1));
            this.f6656o = measureText;
            this.w = measureText / 2;
        }
        if ((!this.n || this.f6656o <= 0 || paint == null) && paint != null) {
            this.s[i] = (int) paint.measureText(this.c[i]);
            int[] iArr = this.x;
            int i3 = this.A / this.tabCount;
            int[] iArr2 = this.s;
            iArr[i] = (i3 - iArr2[i]) / 2;
            if (!this.n && i3 < iArr2[i]) {
                iArr[i] = 0;
                iArr2[i] = i3;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("paddingDis[");
            sb2.append(i);
            sb2.append("] = ");
            sb2.append(this.x[i]);
            GriverLogger.d(TAG, sb2.toString());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!this.t) {
            int i5 = i3 - i;
            int i6 = this.tabCount;
            int i7 = i5 / i6;
            if (i7 != this.b || this.h == null) {
                if (this.z) {
                    this.b = this.A / i6;
                } else {
                    this.b = i7;
                }
                b();
            }
            if (i5 != this.p || i5 != this.A) {
                if (this.z) {
                    this.A = i5 - getResources().getDimensionPixelSize(R.dimen.griver_au_segment_add_width);
                } else {
                    this.A = i5;
                }
                if (this.d.length > 0) {
                    int i8 = 0;
                    while (true) {
                        TextView[] textViewArr = this.d;
                        if (i8 >= textViewArr.length) {
                            break;
                        }
                        TextView textView = textViewArr[i8];
                        if (textView != null) {
                            a(i8, textView.getPaint());
                        }
                        i8++;
                    }
                }
            }
            super.onLayout(z, i, i2, i3, i4);
            c();
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    private void b() {
        a(this.i);
    }

    private void a(int i) {
        if (this.t) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.h = gradientDrawable;
        gradientDrawable.setShape(0);
        int i2 = this.e;
        if (i2 != 0) {
            this.h.setColor(i2);
        } else {
            this.h.setColor(getResources().getColor(R.color.griver_AU_COLOR9));
        }
        this.h.setSize(this.s[i], getResources().getDimensionPixelSize(R.dimen.griver_switch_tab_line_height));
        this.tabButtomLine.setImageDrawable(this.h);
    }

    public void resetTabView(String[] strArr) {
        if (this.t || strArr == null || strArr.length == 0) {
            return;
        }
        int length = strArr.length;
        this.tabCount = length;
        this.i = Math.min(length - 1, this.i);
        this.c = strArr;
        int i = this.tabCount;
        this.d = new TextView[i];
        this.tabRl = new RelativeLayout[i];
        this.r = new int[strArr.length];
        this.s = new int[strArr.length];
        this.x = new int[strArr.length];
        getTabViews(getContext());
        c();
    }

    public void adjustLinePosition(int i, float f) {
        if (this.t) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("adjustLinePosition=");
        sb.append(i);
        GriverLogger.d(TAG, sb.toString());
        if (this.n) {
            this.f6655a.setTranslate(b(i), 0.0f);
            this.f6655a.postTranslate(this.r[i] * f, 0.0f);
            this.tabButtomLine.setImageMatrix(this.f6655a);
            a(i);
            return;
        }
        this.f6655a.setTranslate((this.b * i) + this.x[i], 0.0f);
        this.f6655a.postTranslate(this.b * f, 0.0f);
        this.tabButtomLine.setImageMatrix(this.f6655a);
    }

    private int b(int i) {
        int i2 = (this.f6656o / 2) + this.w;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += this.r[i3];
        }
        return i2;
    }

    private void c(int i) {
        if (this.t) {
            return;
        }
        this.f6655a.setTranslate(i, 0.0f);
        this.tabButtomLine.setImageMatrix(this.f6655a);
    }

    public void selectTab(int i) {
        if (this.t) {
            return;
        }
        int i2 = 0;
        while (i2 < this.tabCount) {
            this.tabRl[i2].setSelected(i == i2);
            ((TextView) this.tabRl[i2].findViewById(R.id.tab_tv)).getPaint().setFakeBoldText(i == i2);
            if (this.q) {
                this.tabRl[i2].setClickable(true);
            } else {
                this.tabRl[i2].setClickable(i != i2);
            }
            i2++;
        }
        this.i = i;
    }

    public void selectTabAndAdjustLine(int i) {
        if (this.t) {
            return;
        }
        selectTabAndAdjustLine(i, 250);
    }

    public void selectTabAndAdjustLine(int i, int i2) {
        if (this.t || i == this.i) {
            return;
        }
        selectTab(i);
        if (this.j.computeScrollOffset()) {
            adjustLinePosition(this.i, 0.0f);
            this.j.forceFinished(true);
        }
        a(i);
        if (this.n) {
            this.j.startScroll(b(this.i), 0, b(i) - b(this.i), 0, i2 * Math.abs(this.i - i));
        } else {
            Scroller scroller = this.j;
            int i3 = this.i;
            int i4 = this.b;
            int[] iArr = this.x;
            int i5 = iArr[i3];
            int i6 = (i3 * i4) + i5;
            scroller.startScroll(i6, 0, ((i4 * i) + iArr[i]) - i6, 0, i2 * Math.abs(i3 - i));
        }
        invalidate();
        this.i = i;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.t) {
            return;
        }
        if (this.j.computeScrollOffset()) {
            c(this.j.getCurrX());
            postInvalidate();
        }
        super.computeScroll();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.alibaba.griver.ui.ant.AUSegment$1] */
    public void setTabSwitchListener(TabSwitchListener tabSwitchListener) {
        if (!this.t) {
            this.k = tabSwitchListener;
            for (int i = 0; i < this.tabCount; i++) {
                this.tabRl[i].setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.ant.AUSegment.1
                    int position = 0;

                    public View.OnClickListener setPosition(int i2) {
                        this.position = i2;
                        return this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AUSegment.this.selectTabAndAdjustLine(this.position);
                        AUSegment.this.k.onTabClick(this.position, view);
                    }
                }.setPosition(i));
            }
            return;
        }
        this.k = tabSwitchListener;
    }

    public TextView[] getTextViews() {
        return this.d;
    }

    public View getBottomLine() {
        return this.l;
    }

    public void addTextRightView(View view, int i) {
        if (this.t) {
            if (i >= this.H.size()) {
                return;
            }
            MenuItemLayout menuItemLayout = (MenuItemLayout) this.C.getChildAt(i);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = DensityUtil.dip2px(getContext(), -15.0f);
            layoutParams.topMargin = DensityUtil.dip2px(getContext(), 6.0f);
            layoutParams.addRule(1, R.id.tv_menu_name);
            layoutParams.addRule(6, R.id.tv_menu_name);
            RelativeLayout relativeLayout = (RelativeLayout) menuItemLayout.findViewById(R.id.item_kernel);
            if (relativeLayout != null) {
                relativeLayout.addView(view, layoutParams);
            }
            this.I.put(Integer.valueOf(i), view);
            return;
        }
        RelativeLayout[] relativeLayoutArr = this.tabRl;
        if (relativeLayoutArr == null && (i >= relativeLayoutArr.length || view == null || relativeLayoutArr[i] == null)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = DensityUtil.dip2px(getContext(), -5.0f);
        layoutParams2.addRule(1, R.id.tab_tv);
        layoutParams2.addRule(6, R.id.tab_tv);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.tabRl[i].findViewById(R.id.tab_inner);
        if (relativeLayout2 != null) {
            relativeLayout2.addView(view, layoutParams2);
        }
    }

    public boolean isViewAllVisible(View view) {
        int right = view.getRight();
        int i = this.p;
        if (right > i) {
            GriverLogger.d(TAG, String.format("view is not all Visible: screenWidth = %s, viewRight = %s ", Integer.valueOf(i), Integer.valueOf(view.getRight())));
            return false;
        }
        GriverLogger.d(TAG, String.format("view is all Visible: screenWidth = %s, viewRight = %s ", Integer.valueOf(i), Integer.valueOf(view.getRight())));
        return true;
    }

    public void setCurrentSelTab(int i) {
        if (!this.t) {
            selectTab(i);
            this.i = i;
            c();
            return;
        }
        setCurrentIndex(i);
    }

    private void c() {
        if (this.t) {
            return;
        }
        this.j.forceFinished(true);
        if (this.n) {
            this.f6655a.setTranslate(b(this.i), 0.0f);
            a(this.i);
        } else {
            Matrix matrix = this.f6655a;
            int i = this.b;
            int i2 = this.i;
            matrix.setTranslate((i * i2) + this.x[i2], 0.0f);
        }
        this.tabButtomLine.setImageMatrix(this.f6655a);
    }

    private boolean a(List<ItemCategory> list, List<ItemCategory> list2) {
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!TextUtils.equals(list.get(i).categoryId, list2.get(i).categoryId) || !TextUtils.equals(list.get(i).categoryname, list2.get(i).categoryname)) {
                return false;
            }
        }
        return true;
    }

    public void init(List<ItemCategory> list) {
        init(list, false);
    }

    public void init(List<ItemCategory> list, boolean z) {
        if (list == null) {
            return;
        }
        List<ItemCategory> list2 = this.H;
        if (list2 == null || z || !a(list2, list)) {
            this.H = list;
            if (list.size() >= 0) {
                this.F.smoothScrollTo(0, 0);
                this.C.removeAllViews();
                this.J = 0;
                this.E = 0.0f;
            }
            e();
            d();
            this.I.clear();
        }
    }

    public void setDivideAutoSize(boolean z) {
        this.C.setDivideAutoSize(z);
        this.C.invalidate();
        this.C.requestLayout();
    }

    private void d() {
        try {
            if (this.J < this.H.size()) {
                MenuItemLayout menuItemLayout = (MenuItemLayout) this.C.getChildAt(this.J);
                this.G = menuItemLayout;
                ColorStateList colorStateList = this.g;
                if (colorStateList != null) {
                    menuItemLayout.setTextColor(colorStateList);
                    this.G.setTextBold(true);
                } else {
                    menuItemLayout.setInitTextColor(getResources().getColor(R.color.griver_indicate_color));
                    this.G.setTextBold(true);
                }
                this.K = (String) this.G.getTag();
            }
            if (this.H.size() == 0) {
                this.C.setVisibility(8);
                this.D.setVisibility(4);
            } else {
                this.C.setVisibility(0);
                this.D.setVisibility(0);
            }
            post(new Runnable() { // from class: com.alibaba.griver.ui.ant.AUSegment.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AUSegment aUSegment = AUSegment.this;
                        aUSegment.a(aUSegment.G.getX(), AUSegment.this.G.getTextWidth());
                    } catch (Exception e) {
                        GriverLogger.d(AUSegment.TAG, e.toString());
                    }
                }
            });
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("setBarState:");
            sb.append(e);
            GriverLogger.e(TAG, sb.toString());
        }
    }

    private void e() {
        for (int i = 0; i < this.H.size(); i++) {
            MenuItemLayout menuItemLayout = new MenuItemLayout(getContext(), this.v / 2);
            ItemCategory itemCategory = this.H.get(i);
            menuItemLayout.setTag(String.valueOf(i));
            menuItemLayout.setText(itemCategory.categoryname);
            menuItemLayout.setInitTextColor(getResources().getColor(R.color.griver_black));
            float f = this.f;
            if (f != 0.0f) {
                menuItemLayout.setTextSize(f);
            }
            a(menuItemLayout, itemCategory);
            this.C.addView(menuItemLayout);
        }
        this.C.invalidate();
        this.C.requestLayout();
    }

    private void a(MenuItemLayout menuItemLayout, final ItemCategory itemCategory) {
        menuItemLayout.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.ant.AUSegment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AUSegment.this.u || !TextUtils.equals(AUSegment.this.K, (String) view.getTag())) {
                    AUSegment.this.K = (String) view.getTag();
                    AUSegment.this.a(view, itemCategory);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, ItemCategory itemCategory) {
        if (this.J < this.H.size()) {
            this.G = (MenuItemLayout) this.C.getChildAt(this.J);
        }
        MenuItemLayout menuItemLayout = this.G;
        if (menuItemLayout != null) {
            menuItemLayout.setInitTextColor(getResources().getColor(R.color.griver_black));
            this.G.setTextBold(false);
        }
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            MenuItemLayout menuItemLayout2 = (MenuItemLayout) view;
            menuItemLayout2.setTextColor(colorStateList);
            menuItemLayout2.setTextBold(true);
        } else {
            MenuItemLayout menuItemLayout3 = (MenuItemLayout) view;
            menuItemLayout3.setInitTextColor(getResources().getColor(R.color.griver_indicate_color));
            menuItemLayout3.setTextBold(true);
        }
        if (this.k != null) {
            this.k.onTabClick(this.H.indexOf(itemCategory), view);
        }
        float x = view.getX();
        a(x, ((MenuItemLayout) view).getTextWidth());
        a(view, x);
        this.J = this.C.indexOfChild(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, float f) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        this.F.smoothScrollBy(iArr[0] - (this.p / 3), 0);
        this.E = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, int i) {
        if (this.E == f) {
            return;
        }
        try {
            ValueAnimator ofInt = ValueAnimator.ofInt(((LinearLayout.LayoutParams) this.D.getLayoutParams()).width, i - this.v);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.griver.ui.ant.AUSegment.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AUSegment.this.updateWidth(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofInt.setDuration(200L);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(new TranslateAnimation(this.E, f, 0.0f, 0.0f));
            animationSet.setFillBefore(true);
            animationSet.setFillAfter(true);
            animationSet.setDuration(200L);
            ofInt.start();
            this.D.startAnimation(animationSet);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveScrollBarTo:");
            sb.append(e);
            GriverLogger.e(TAG, sb.toString());
        }
    }

    public void updateWidth(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
        layoutParams.width = i;
        layoutParams.leftMargin = this.v / 2;
        layoutParams.rightMargin = this.v / 2;
        this.D.setLayoutParams(layoutParams);
    }

    public int getCurrentIndex() {
        return this.J;
    }

    private void setCurrentIndex(int i) {
        if (i >= this.H.size()) {
            return;
        }
        if (this.J < this.H.size()) {
            this.G = (MenuItemLayout) this.C.getChildAt(this.J);
        }
        MenuItemLayout menuItemLayout = this.G;
        if (menuItemLayout != null) {
            menuItemLayout.setInitTextColor(getResources().getColor(R.color.griver_black));
            this.G.setTextBold(false);
        }
        this.J = i;
        if (i < this.H.size()) {
            MenuItemLayout menuItemLayout2 = (MenuItemLayout) this.C.getChildAt(this.J);
            this.G = menuItemLayout2;
            if (menuItemLayout2 != null) {
                ColorStateList colorStateList = this.g;
                if (colorStateList != null) {
                    menuItemLayout2.setTextColor(colorStateList);
                    this.G.setTextBold(true);
                } else {
                    menuItemLayout2.setInitTextColor(getResources().getColor(R.color.griver_indicate_color));
                    this.G.setTextBold(true);
                }
                post(new Runnable() { // from class: com.alibaba.griver.ui.ant.AUSegment.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AUSegment aUSegment = AUSegment.this;
                            aUSegment.a(aUSegment.G.getX(), AUSegment.this.G.getTextWidth());
                            AUSegment aUSegment2 = AUSegment.this;
                            aUSegment2.a(aUSegment2.G, AUSegment.this.G.getX());
                        } catch (Exception e) {
                            GriverLogger.d(AUSegment.TAG, e.toString());
                        }
                    }
                });
                this.K = (String) this.G.getTag();
            }
        }
    }

    public AUIconView getAddIcon() {
        return this.y;
    }
}
