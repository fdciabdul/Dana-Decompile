package com.alibaba.griver.ui.titlebar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.page.BackPressedPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarCloseClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarDisclaimerClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarOptionClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarSegCheckPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarTitleClickPoint;
import com.alibaba.ariver.app.api.ui.StateListUtils;
import com.alibaba.ariver.app.api.ui.StatusBarUtils;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.appinfo.AppType;
import com.alibaba.griver.api.constants.GriverLaunchParams;
import com.alibaba.griver.api.ui.titlebar.GriverBackButtonStyleExtension;
import com.alibaba.griver.api.ui.titlebar.GriverButtonStyleExtension;
import com.alibaba.griver.api.ui.titlebar.GriverCloseButtonStyleExtension;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.utils.TypefaceCache;
import com.alibaba.griver.ui.titlebar.H5SegmentGroup;
import com.alibaba.griver.ui.titlebar.TitleView;
import com.alibaba.griver.ui.utils.H5ViewStubUtil;
import com.alipay.mobile.embedview.mapbiz.core.controller.ReportController;
import com.fullstory.instrumentation.InstrumentInjector;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class NebulaTitleView implements View.OnClickListener, H5SegmentGroup.OnItemCheckedChangeListener, TitleView {
    public static final String LONG_SEG_COLOR_ACTIVE = "segColorActive";
    public static final String LONG_SEG_COLOR_NORMAL = "segColorNormal";
    public static final String LONG_SEG_SELECTED_INDEX = "segSelectedIndex";
    public static final String LONG_SEG_TITLES = "segTitles";
    public static final String LONG_SEG_WIDTHS = "segWidths";
    public static final String TAG = "NebulaTitleView";
    public static final String TITLE_ALIGNMENT = "titleAlignment";
    public static final String TITLE_ALIGNMENT_AUTO = "auto";
    private int b;
    public ViewGroup backContainer;
    public View backToHomeContainer;
    public TextView btBack;
    public TextView btBackToHome;
    public TextView btClose;
    public View btDotView;
    public View btDotView1;
    public ImageButton btIcon;
    public ImageButton btIcon1;
    public TextView btMenu;
    public TextView btMenu1;
    public TextView btText;
    public TextView btText1;
    public H5TitleBarFrameLayout contentView;
    protected Theme currentTheme;
    private View d;
    public TextView disClaimer;
    public ImageView dotImage;
    public ImageView dotImage1;
    public TextView dotText;
    public TextView dotText1;
    private Page e;
    private View f;
    private Context g;
    private boolean h;
    public View h5NavOptions;
    public View h5NavOptions1;
    private ViewGroup i;
    public ImageView ivImageTitle;
    private H5SegmentGroup j;
    private LinearLayout k;
    public LinearLayout llTitle;
    public RelativeLayout rlTitle;
    public TextView tvSubtitle;
    public TextView tvTitle;
    public List<View> h5NavOptionsList = new ArrayList();
    public List<TextView> btMenuList = new ArrayList();
    public List<ImageButton> btIconList = new ArrayList();
    public List<TextView> btTextList = new ArrayList();
    public List<View> btDotViewList = new ArrayList();
    public List<ImageView> dotImageList = new ArrayList();
    public List<TextView> dotTextList = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    private TitleView.OptionType[] f6770a = new TitleView.OptionType[2];
    private int c = R.drawable.griver_ui_title_bar_progress;

    /* loaded from: classes6.dex */
    public enum Theme {
        DARK,
        LIGHT
    }

    private boolean a(int i, int i2) {
        return i2 == 0 || i2 < i;
    }

    public NebulaTitleView(Context context) {
        this.g = context;
        H5TitleBarFrameLayout h5TitleBarFrameLayout = (H5TitleBarFrameLayout) LayoutInflater.from(context).inflate(R.layout.griver_ui_navigation_bar, (!(context instanceof Activity) || ((Activity) context).getWindow() == null) ? null : (ViewGroup) ((Activity) this.g).findViewById(16908290), false);
        this.contentView = h5TitleBarFrameLayout;
        this.k = (LinearLayout) h5TitleBarFrameLayout.findViewById(R.id.h5_rl_title_bar);
        this.tvTitle = (TextView) this.contentView.findViewById(R.id.h5_tv_title);
        this.tvSubtitle = (TextView) this.contentView.findViewById(R.id.h5_tv_subtitle);
        this.disClaimer = (TextView) this.contentView.findViewById(R.id.h5_nav_disclaimer);
        this.ivImageTitle = (ImageView) this.contentView.findViewById(R.id.h5_tv_title_img);
        this.d = this.contentView.findViewById(R.id.h5_status_bar_adjust_view);
        this.tvSubtitle.setVisibility(8);
        this.ivImageTitle.setVisibility(8);
        this.tvTitle.setOnClickListener(this);
        this.tvSubtitle.setOnClickListener(this);
        this.ivImageTitle.setOnClickListener(this);
        this.btBack = (TextView) this.contentView.findViewById(R.id.h5_tv_nav_back);
        this.btClose = (TextView) this.contentView.findViewById(R.id.h5_nav_close);
        this.btBackToHome = (TextView) this.contentView.findViewById(R.id.h5_tv_nav_back_to_home);
        this.backToHomeContainer = this.contentView.findViewById(R.id.h5_nav_back_to_home);
        StringBuilder sb = new StringBuilder();
        sb.append("h5iconfont");
        sb.append(File.separator);
        sb.append("titlebar.ttf");
        Typeface typeface = TypefaceCache.getTypeface(context, "h5iconfont", sb.toString());
        this.backContainer = (ViewGroup) this.contentView.findViewById(R.id.h5_nav_back);
        this.btBack.setTypeface(typeface);
        this.btBack.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.griver_ui_light_icon_color));
        this.btClose.setTypeface(typeface);
        this.btClose.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.griver_ui_light_icon_color));
        this.disClaimer.setTypeface(typeface);
        this.disClaimer.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_light_icon_color));
        this.f = this.contentView.findViewById(R.id.h5_h_divider_intitle);
        this.rlTitle = (RelativeLayout) this.contentView.findViewById(R.id.h5_rl_title);
        this.llTitle = (LinearLayout) this.contentView.findViewById(R.id.h5_ll_title);
        this.h5NavOptions = this.contentView.findViewById(R.id.h5_nav_options);
        this.btDotView = this.contentView.findViewById(R.id.h5_bt_dot);
        this.btIcon = (ImageButton) this.contentView.findViewById(R.id.h5_bt_image);
        this.btText = (TextView) this.contentView.findViewById(R.id.h5_bt_text);
        TextView textView = (TextView) this.contentView.findViewById(R.id.h5_bt_options);
        this.btMenu = textView;
        textView.setTypeface(typeface);
        this.btMenu.setTextColor(StateListUtils.getStateColor(-15692055));
        this.dotImage = (ImageView) this.contentView.findViewById(R.id.h5_bt_dot_bg);
        this.dotText = (TextView) this.contentView.findViewById(R.id.h5_bt_dot_number);
        this.h5NavOptions1 = this.contentView.findViewById(R.id.h5_nav_options1);
        this.btDotView1 = this.contentView.findViewById(R.id.h5_bt_dot1);
        this.btIcon1 = (ImageButton) this.contentView.findViewById(R.id.h5_bt_image1);
        this.btText1 = (TextView) this.contentView.findViewById(R.id.h5_bt_text1);
        TextView textView2 = (TextView) this.contentView.findViewById(R.id.h5_bt_options1);
        this.btMenu1 = textView2;
        textView2.setTypeface(typeface);
        this.btMenu1.setTextColor(StateListUtils.getStateColor(-15692055));
        this.dotImage1 = (ImageView) this.contentView.findViewById(R.id.h5_bt_dot_bg1);
        this.dotText1 = (TextView) this.contentView.findViewById(R.id.h5_bt_dot_number1);
        H5SegmentGroup h5SegmentGroup = (H5SegmentGroup) this.contentView.findViewById(R.id.h5_nav_seg_group);
        this.j = h5SegmentGroup;
        h5SegmentGroup.setItemChangeListener(this);
        this.h5NavOptionsList.add(this.h5NavOptions);
        this.h5NavOptionsList.add(this.h5NavOptions1);
        this.btDotViewList.add(this.btDotView);
        this.btDotViewList.add(this.btDotView1);
        this.btIconList.add(this.btIcon);
        this.btIconList.add(this.btIcon1);
        this.btTextList.add(this.btText);
        this.btTextList.add(this.btText1);
        this.btMenuList.add(this.btMenu);
        this.btMenuList.add(this.btMenu1);
        this.dotImageList.add(this.dotImage);
        this.dotImageList.add(this.dotImage1);
        this.dotTextList.add(this.dotText);
        this.dotTextList.add(this.dotText1);
        this.b = 1;
        ((RelativeLayout) this.contentView.findViewById(R.id.adView)).setTag("adView");
        ((RelativeLayout) this.contentView.findViewById(R.id.h5_custom_view)).setTag("h5_custom_view");
        this.btBack.setOnClickListener(this);
        this.btClose.setOnClickListener(this);
        this.disClaimer.setOnClickListener(this);
        this.btText.setOnClickListener(this);
        this.btIcon.setOnClickListener(this);
        this.btText1.setOnClickListener(this);
        this.btIcon1.setOnClickListener(this);
        this.btMenu.setOnClickListener(this);
        this.btMenu1.setOnClickListener(this);
        ProgressBar progressBar = (ProgressBar) H5ViewStubUtil.getView(this.contentView, R.id.h5_nav_loading_stub, R.id.h5_nav_loading);
        Drawable Resources_getDrawable = InstrumentInjector.Resources_getDrawable(this.g.getResources(), this.c);
        int dip2px = DimensionUtil.dip2px(this.g, 17.0f);
        Resources_getDrawable.setBounds(0, 0, dip2px, dip2px);
        progressBar.setIndeterminateDrawable(Resources_getDrawable);
        GriverBackButtonStyleExtension griverBackButtonStyleExtension = (GriverBackButtonStyleExtension) RVProxy.get(GriverBackButtonStyleExtension.class);
        if (!TextUtils.isEmpty(griverBackButtonStyleExtension.getType())) {
            a(this.btBack, griverBackButtonStyleExtension);
        }
        GriverCloseButtonStyleExtension griverCloseButtonStyleExtension = (GriverCloseButtonStyleExtension) RVProxy.get(GriverCloseButtonStyleExtension.class);
        if (TextUtils.isEmpty(griverCloseButtonStyleExtension.getType())) {
            return;
        }
        a(this.btClose, griverCloseButtonStyleExtension);
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setButtonSize(float f) {
        this.btBack.setTextSize(2, f);
        this.btClose.setTextSize(2, f);
        this.btBackToHome.setTextSize(2, f);
        this.btMenu.setTextSize(2, f);
        this.btMenu1.setTextSize(2, f);
    }

    private void a(TextView textView, GriverButtonStyleExtension griverButtonStyleExtension) {
        if (textView == null || griverButtonStyleExtension == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("set custom button style, view: ");
        sb.append(textView);
        sb.append(", type: ");
        sb.append(griverButtonStyleExtension.getType());
        GriverLogger.d(TAG, sb.toString());
        if ("text".equalsIgnoreCase(griverButtonStyleExtension.getType())) {
            textView.setText(griverButtonStyleExtension.getContent());
        } else if ("icon".equalsIgnoreCase(griverButtonStyleExtension.getType())) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, griverButtonStyleExtension.getIconDrawable(), (Drawable) null);
        }
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setButtonIcon(Bitmap bitmap, int i) {
        if (a(i, this.btIconList.size())) {
            return;
        }
        this.btIconList.get(i).setImageBitmap(bitmap);
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public String getTitle() {
        TextView textView = this.tvTitle;
        if (textView != null) {
            return textView.getText().toString();
        }
        return null;
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setTitle(String str) {
        if (str == null || !a(str)) {
            return;
        }
        this.tvTitle.setText(b(str));
        this.tvTitle.setVisibility(0);
        this.ivImageTitle.setVisibility(8);
        String string = this.e.getStartParams().getString("titleAlignment");
        EllipsizeGroupLayout ellipsizeGroupLayout = (EllipsizeGroupLayout) this.contentView.findViewById(R.id.h5_ll_title_stub);
        if (!TextUtils.isEmpty(string) && string.equalsIgnoreCase("auto") && this.contentView != null && this.e != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ellipsizeGroupLayout.getLayoutParams();
            layoutParams.addRule(13);
            ellipsizeGroupLayout.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ellipsizeGroupLayout.getLayoutParams();
        layoutParams2.addRule(9);
        ellipsizeGroupLayout.setLayoutParams(layoutParams2);
    }

    private boolean a(String str) {
        return (str.startsWith("http://") || str.startsWith("https://")) ? false : true;
    }

    private String b(String str) {
        Page page = this.e;
        if (page != null) {
            Bundle startParams = page.getStartParams();
            AppType parse = AppType.parse(BundleUtils.getString(this.e.getSceneParams(), "appType"));
            boolean z = BundleUtils.getBoolean(startParams, GriverLaunchParams.H5_ALWAYS_SHOW_DEFAULT_TITLE, false);
            String string = BundleUtils.getString(startParams, "defaultTitle");
            if (parse == AppType.WEB_H5 && z && !TextUtils.isEmpty(string)) {
                return string;
            }
        }
        return str;
    }

    private void a(int i, int i2, boolean z) {
        if (a(i, this.btTextList.size())) {
            return;
        }
        if (z) {
            this.btTextList.get(i).setVisibility(i2);
            if (i2 == 0) {
                this.f6770a[i] = TitleView.OptionType.TEXT;
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.btTextList.get(i3).setVisibility(i2);
            if (i2 == 0) {
                this.f6770a[i] = TitleView.OptionType.TEXT;
            }
        }
    }

    private void b(int i, int i2, boolean z) {
        if (a(i, this.btIconList.size())) {
            return;
        }
        if (z) {
            this.btIconList.get(i).setVisibility(i2);
            if (i2 == 0) {
                this.f6770a[i] = TitleView.OptionType.ICON;
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.btIconList.get(i3).setVisibility(i2);
            if (i2 == 0) {
                this.f6770a[i] = TitleView.OptionType.ICON;
            }
        }
    }

    private void c(int i, int i2, boolean z) {
        if (a(i, this.btMenuList.size())) {
            return;
        }
        if (z) {
            this.btMenuList.get(i).setVisibility(i2);
            if (i2 == 0) {
                this.f6770a[i] = TitleView.OptionType.MENU;
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.btMenuList.get(i3).setVisibility(i2);
            if (i2 == 0) {
                this.f6770a[i] = TitleView.OptionType.MENU;
            }
        }
    }

    private void b(int i, int i2) {
        if (a(i, this.btDotViewList.size())) {
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.btDotViewList.get(i3).setVisibility(i2);
        }
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setSubTitle(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            z = false;
        } else {
            z = true;
            this.tvSubtitle.setText(str);
        }
        this.tvSubtitle.setVisibility(z ? 0 : 8);
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setImgTitle(Bitmap bitmap) {
        if (bitmap != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("imgTitle width ");
            sb.append(bitmap.getWidth());
            sb.append(", imgTitle height ");
            sb.append(bitmap.getHeight());
            RVLogger.d(TAG, sb.toString());
            this.ivImageTitle.setImageBitmap(bitmap);
            this.ivImageTitle.setVisibility(0);
            this.tvTitle.setVisibility(8);
            this.tvSubtitle.setVisibility(8);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ivImageTitle width ");
            sb2.append(this.ivImageTitle.getWidth());
            sb2.append(", ivImageTitle height ");
            sb2.append(this.ivImageTitle.getHeight());
            RVLogger.d(TAG, sb2.toString());
        }
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setImgTitle(Bitmap bitmap, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ivImageTitle.setContentDescription(str);
        }
        setImgTitle(bitmap);
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void showCloseButton(boolean z) {
        View view;
        this.h = z;
        this.btClose.setVisibility(z ? 0 : 8);
        if (z && (view = this.backToHomeContainer) != null) {
            view.setVisibility(8);
        }
        b();
        a();
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void showBackButton(boolean z) {
        View view;
        this.backContainer.setVisibility(z ? 0 : 8);
        this.btBack.setVisibility(z ? 0 : 8);
        if (z && (view = this.backToHomeContainer) != null) {
            view.setVisibility(8);
        }
        b();
        a();
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void showHomeButton(boolean z) {
        this.backToHomeContainer.setVisibility(z ? 0 : 8);
    }

    private void a() {
        if (this.btBack.getVisibility() == 0) {
            if (this.h) {
                a(12);
            } else {
                a(0);
            }
        } else if (this.h) {
            a(12);
        } else {
            a(16);
        }
    }

    private void a(int i) {
        ((RelativeLayout.LayoutParams) this.rlTitle.getLayoutParams()).setMargins(DimensionUtil.dip2px(this.g, i), 0, 0, 0);
    }

    private void b() {
        if (this.h) {
            if (this.btBack.getVisibility() == 0) {
                b(0);
            } else {
                b(16);
            }
        }
    }

    private void b(int i) {
        ((RelativeLayout.LayoutParams) this.btClose.getLayoutParams()).setMargins(DimensionUtil.dip2px(this.g, i), 0, 0, 0);
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void showOptionMenu(boolean z) {
        if (z) {
            int i = this.b;
            if (i == 1) {
                this.h5NavOptions.setVisibility(0);
                return;
            } else if (i == 2) {
                this.h5NavOptions.setVisibility(0);
                this.h5NavOptions1.setVisibility(0);
                return;
            } else {
                return;
            }
        }
        this.h5NavOptions.setVisibility(8);
        this.h5NavOptions1.setVisibility(8);
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setOptionType(TitleView.OptionType optionType) {
        setOptionType(optionType, 0, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x002e  */
    @Override // com.alibaba.griver.ui.titlebar.TitleView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setOptionType(com.alibaba.griver.ui.titlebar.TitleView.OptionType r4, int r5, boolean r6) {
        /*
            r3 = this;
            com.alibaba.griver.ui.titlebar.TitleView$OptionType r0 = com.alibaba.griver.ui.titlebar.TitleView.OptionType.ICON
            r1 = 1
            r2 = 0
            if (r4 != r0) goto L7
            goto L16
        L7:
            com.alibaba.griver.ui.titlebar.TitleView$OptionType r0 = com.alibaba.griver.ui.titlebar.TitleView.OptionType.TEXT
            if (r4 != r0) goto Le
            r4 = 0
            r0 = 0
            goto L19
        Le:
            com.alibaba.griver.ui.titlebar.TitleView$OptionType r0 = com.alibaba.griver.ui.titlebar.TitleView.OptionType.MENU
            if (r4 != r0) goto L15
            r4 = 1
            r1 = 0
            goto L17
        L15:
            r1 = 0
        L16:
            r4 = 0
        L17:
            r0 = r1
            r1 = 0
        L19:
            if (r1 == 0) goto L1d
            r1 = 0
            goto L1f
        L1d:
            r1 = 8
        L1f:
            r3.a(r5, r1, r6)
            r1 = 4
            if (r0 == 0) goto L27
            r0 = 0
            goto L28
        L27:
            r0 = 4
        L28:
            r3.b(r5, r0, r6)
            if (r4 == 0) goto L2e
            goto L2f
        L2e:
            r2 = 4
        L2f:
            r3.c(r5, r2, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.NebulaTitleView.setOptionType(com.alibaba.griver.ui.titlebar.TitleView$OptionType, int, boolean):void");
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void showTitleLoading(boolean z) {
        H5ViewStubUtil.setViewVisibility(this.contentView, R.id.h5_nav_loading_stub, R.id.h5_nav_loading, z ? 0 : 8);
        if (z) {
            ProgressBar progressBar = (ProgressBar) H5ViewStubUtil.getView(this.contentView, R.id.h5_nav_loading_stub, R.id.h5_nav_loading);
            Drawable Resources_getDrawable = InstrumentInjector.Resources_getDrawable(this.g.getResources(), this.c);
            int dip2px = DimensionUtil.dip2px(this.g, 17.0f);
            Resources_getDrawable.setBounds(0, 0, dip2px, dip2px);
            progressBar.setIndeterminateDrawable(Resources_getDrawable);
        }
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void showTitleDisclaimer(boolean z) {
        TextView textView = this.disClaimer;
        if (textView != null) {
            if (z) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setPage(Page page) {
        this.e = page;
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public View getContentView() {
        return this.contentView;
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public ColorDrawable getContentBackgroundView() {
        return this.contentView.getContentBgView();
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public TextView getMainTitleView() {
        return this.tvTitle;
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public TextView getSubTitleView() {
        return this.tvSubtitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append("onClick ");
        sb.append(view);
        RVLogger.d(TAG, sb.toString());
        if (this.e == null) {
            return;
        }
        if (view.equals(this.btBack)) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) GriverEnv.getApplicationContext().getSystemService("input_method");
                if (inputMethodManager != null && inputMethodManager.isActive()) {
                    GriverLogger.d(TAG, "hide soft input");
                    inputMethodManager.hideSoftInputFromWindow(this.btBack.getApplicationWindowToken(), 0);
                }
            } catch (Exception e) {
                GriverLogger.e(TAG, "get input service failed", e);
            }
            ((BackPressedPoint) ExtensionPoint.as(BackPressedPoint.class).node(this.e).create()).handleBackPressed(this.e);
        } else if (view.equals(this.btClose)) {
            ((TitleBarCloseClickPoint) ExtensionPoint.as(TitleBarCloseClickPoint.class).node(this.e).create()).onCloseClick();
        } else if (view.equals(this.btIcon) || view.equals(this.btText)) {
            ((TitleBarOptionClickPoint) ExtensionPoint.as(TitleBarOptionClickPoint.class).node(this.e).create()).onOptionClick(0, false);
        } else if (view.equals(this.btIcon1) || view.equals(this.btText1)) {
            ((TitleBarOptionClickPoint) ExtensionPoint.as(TitleBarOptionClickPoint.class).node(this.e).create()).onOptionClick(1, false);
        } else if (view.equals(this.btMenu) || view.equals(this.btMenu1)) {
            ((TitleBarOptionClickPoint) ExtensionPoint.as(TitleBarOptionClickPoint.class).node(this.e).create()).onOptionClick(!view.equals(this.btMenu), true);
        } else if (view.equals(this.tvTitle) || view.equals(this.ivImageTitle)) {
            ((TitleBarTitleClickPoint) ExtensionPoint.as(TitleBarTitleClickPoint.class).node(this.e).create()).onTitleClick();
        } else if (view.equals(this.tvSubtitle)) {
            ((TitleBarTitleClickPoint) ExtensionPoint.as(TitleBarTitleClickPoint.class).node(this.e).create()).onSubTitleClick();
        } else if (view.equals(this.disClaimer)) {
            ((TitleBarDisclaimerClickPoint) ExtensionPoint.as(TitleBarDisclaimerClickPoint.class).node(this.e).create()).onDisclaimerClick();
        }
        if (view.equals(this.btIcon) || view.equals(this.btText) || view.equals(this.btMenu)) {
            this.btDotView.setVisibility(8);
        }
        if (view.equals(this.btIcon1) || view.equals(this.btText1) || view.equals(this.btMenu1)) {
            this.btDotView1.setVisibility(8);
        }
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setOptionMenu(String str, String str2, String str3, boolean z, String str4, boolean z2, JSONArray jSONArray, String str5, String str6, String str7) {
        boolean equals = TextUtils.equals(ReportController.PARAM_TINY, str7);
        if (z && !equals) {
            this.h5NavOptions1.setVisibility(8);
            b(1, 8);
            setOptionType(TitleView.OptionType.MENU, 0, true);
            this.b = 1;
        } else if (jSONArray == null || jSONArray.isEmpty()) {
            if (equals) {
                a(str, str2, str5, str3, str6, str4, 1);
                this.b = 2;
                return;
            }
            a(str, str2, str5, str3, str6, str4, 0);
            this.b = 1;
        } else {
            this.b = 0;
            String str8 = "title";
            String str9 = "icon";
            String str10 = "icontype";
            if (z2 && !equals) {
                int min = Math.min(jSONArray.size(), 2);
                int i = 0;
                while (i < min) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    int i2 = i;
                    a(JSONUtils.getString(jSONObject, str8), JSONUtils.getString(jSONObject, str9), JSONUtils.getString(jSONObject, str10), JSONUtils.getString(jSONObject, "redDot", "-1"), JSONUtils.getString(jSONObject, "contentDesc"), JSONUtils.getString(jSONObject, "color"), i2);
                    this.b++;
                    i = i2 + 1;
                    str10 = str10;
                    str9 = str9;
                    str8 = str8;
                }
                return;
            }
            this.b = 2;
            JSONObject jSONObject2 = jSONArray.getJSONObject(0);
            a(JSONUtils.getString(jSONObject2, "title"), JSONUtils.getString(jSONObject2, "icon"), JSONUtils.getString(jSONObject2, "icontype"), JSONUtils.getString(jSONObject2, "redDot", "-1"), JSONUtils.getString(jSONObject2, "contentDesc"), JSONUtils.getString(jSONObject2, "color"), 1);
        }
    }

    private void a(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        int i2 = -15692055;
        if (!TextUtils.isEmpty(str6)) {
            try {
                i2 = Color.parseColor(str6);
            } catch (Throwable unused) {
            }
            this.btTextList.get(i).setTextColor((-16777216) | i2);
        } else {
            this.btTextList.get(i).setTextColor(-15692055);
        }
        if (!TextUtils.isEmpty(str)) {
            this.btDotViewList.get(i).setVisibility(8);
            String trim = str.trim();
            this.btTextList.get(i).setText(trim);
            setOptionType(TitleView.OptionType.TEXT, i, true);
            this.btTextList.get(i).setContentDescription(trim);
        } else if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            this.btDotViewList.get(i).setVisibility(8);
            if (!TextUtils.isEmpty(str5)) {
                this.btIconList.get(i).setContentDescription(str5);
            }
        }
        int i3 = -1;
        try {
            i3 = Integer.parseInt(str4);
        } catch (NumberFormatException unused2) {
        }
        this.btDotViewList.get(i).setVisibility(i3 >= 0 ? 0 : 8);
        c(i, i3);
    }

    private void c(int i, int i2) {
        String obj;
        if (this.f6770a[i] == TitleView.OptionType.MENU) {
            RVLogger.debug(TAG, "adjust menu");
        } else if (this.f6770a[i] == TitleView.OptionType.ICON) {
            RVLogger.debug(TAG, "adjust icon");
        } else if (this.f6770a[i] == TitleView.OptionType.TEXT) {
            RVLogger.debug(TAG, "adjust text");
            if (i2 == 0) {
                this.dotImageList.get(i).setPadding(0, DimensionUtil.dip2px(this.g, 7.8f), DimensionUtil.dip2px(this.g, 6.0f), 0);
            }
        }
        if (i2 == 0) {
            this.dotImageList.get(i).setVisibility(0);
            this.dotTextList.get(i).setVisibility(8);
        } else if (i2 > 0) {
            this.dotTextList.get(i).setVisibility(0);
            this.dotImageList.get(i).setVisibility(8);
            if (i2 > 99) {
                obj = "···";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                obj = sb.toString();
            }
            TextView textView = this.dotTextList.get(i);
            textView.setText(obj);
            if (i2 >= 10) {
                textView.setTextSize(10.0f);
            } else {
                textView.setTextSize(12.0f);
            }
        }
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public View getDivider() {
        return this.f;
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public View getPopAnchor() {
        return this.btMenu;
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void resetTitleColor(int i) {
        H5TitleBarFrameLayout h5TitleBarFrameLayout = this.contentView;
        if (h5TitleBarFrameLayout != null) {
            h5TitleBarFrameLayout.getContentBgView().setColor(i);
        }
    }

    public void switchTheme(Theme theme) {
        if (Theme.DARK == theme) {
            this.currentTheme = Theme.DARK;
            switchToDarkTheme();
            return;
        }
        this.currentTheme = Theme.LIGHT;
        switchToLightTheme();
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void switchToLightTheme() {
        RVLogger.d(TAG, "switchToLightTheme");
        this.tvTitle.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_light_title_color));
        this.tvSubtitle.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_light_title_color));
        this.btText.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_light_title_color));
        this.btText1.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_light_title_color));
        this.btBack.setTextColor(StateListUtils.getStateColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_light_icon_color)));
        this.btClose.setTextColor(StateListUtils.getStateColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_light_icon_color)));
        this.btMenu.setTextColor(StateListUtils.getStateColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_light_icon_color)));
        this.btMenu1.setTextColor(StateListUtils.getStateColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_light_icon_color)));
        this.disClaimer.setTextColor(StateListUtils.getStateColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_light_icon_color)));
        this.btBackToHome.setTextColor(StateListUtils.getStateColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_light_icon_color)));
        this.c = R.drawable.griver_ui_title_bar_progress;
        if (Build.VERSION.SDK_INT >= 23) {
            setLightStatusBar(this.contentView);
        }
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void switchToDarkTheme() {
        RVLogger.d(TAG, "switchToDarkTheme");
        this.tvTitle.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_dark_title_color));
        this.tvSubtitle.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_dark_title_color));
        this.btText.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_dark_title_color));
        this.btText1.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_dark_title_color));
        this.btBack.setTextColor(StateListUtils.getStateColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_dark_icon_color)));
        this.btClose.setTextColor(StateListUtils.getStateColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_dark_icon_color)));
        this.btMenu.setTextColor(StateListUtils.getStateColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_dark_icon_color)));
        this.btMenu1.setTextColor(StateListUtils.getStateColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_dark_icon_color)));
        this.btBackToHome.setTextColor(StateListUtils.getStateColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_dark_icon_color)));
        this.disClaimer.setTextColor(StateListUtils.getStateColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.g, R.color.griver_ui_dark_icon_color)));
        this.c = R.drawable.griver_ui_title_bar_progress_white;
        if (Build.VERSION.SDK_INT >= 23) {
            clearLightStatusBar(this.contentView);
        }
    }

    public static void setLightStatusBar(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setSystemUiVisibility(view.getSystemUiVisibility() | 8192);
        }
    }

    public static void clearLightStatusBar(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setSystemUiVisibility(view.getSystemUiVisibility() & (-8193));
        }
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void switchToCustomTheme(int i) {
        RVLogger.d(TAG, "switchToCustomTheme");
        int i2 = i | (-16777216);
        this.tvTitle.setTextColor(i2);
        this.tvSubtitle.setTextColor(i2);
        this.btText.setTextColor(i2);
        this.btText1.setTextColor(i2);
        this.btBack.setTextColor(StateListUtils.getStateColor(i2));
        this.btClose.setTextColor(StateListUtils.getStateColor(i2));
        this.btMenu.setTextColor(StateListUtils.getStateColor(i2));
        this.btMenu1.setTextColor(StateListUtils.getStateColor(i2));
        this.disClaimer.setTextColor(StateListUtils.getStateColor(i2));
        this.btBackToHome.setTextColor(StateListUtils.getStateColor(i2));
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void releaseViewList() {
        List<View> list = this.h5NavOptionsList;
        if (list != null) {
            list.clear();
        }
        List<View> list2 = this.btDotViewList;
        if (list2 != null) {
            list2.clear();
        }
        List<ImageButton> list3 = this.btIconList;
        if (list3 != null) {
            list3.clear();
        }
        List<TextView> list4 = this.btTextList;
        if (list4 != null) {
            list4.clear();
        }
        List<TextView> list5 = this.btMenuList;
        if (list5 != null) {
            list5.clear();
        }
        List<ImageView> list6 = this.dotImageList;
        if (list6 != null) {
            list6.clear();
        }
        List<TextView> list7 = this.dotTextList;
        if (list7 != null) {
            list7.clear();
        }
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void openTranslucentStatusBarSupport(int i) {
        int statusBarHeight;
        if (!StatusBarUtils.isSupport() || (statusBarHeight = StatusBarUtils.getStatusBarHeight(this.g)) == 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.height = statusBarHeight;
        this.d.setLayoutParams(layoutParams);
        this.d.setVisibility(0);
        try {
            StatusBarUtils.setTransparentColor((Activity) this.g, i);
        } catch (Exception e) {
            RVLogger.e(TAG, e);
        }
        int dip2px = DensityUtil.dip2px(this.g, 48.0f);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams2.height = dip2px + statusBarHeight;
        this.k.setLayoutParams(layoutParams2);
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setBackCloseButtonImage(String str) {
        if ("yellow".equalsIgnoreCase(str)) {
            this.btBack.setTextColor(StateListUtils.getStateColor(-2109303));
            this.btClose.setTextColor(StateListUtils.getStateColor(-2109303));
            this.c = R.drawable.griver_ui_title_bar_progress_gold;
        }
        if ("black".equalsIgnoreCase(str)) {
            this.btBack.setTextColor(StateListUtils.getStateColor(-16777216));
            this.btClose.setTextColor(StateListUtils.getStateColor(-16777216));
            this.c = R.drawable.griver_ui_title_bar_progress;
        }
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setBackCloseButtonImage(String str, Bundle bundle) {
        if ("yellow".equalsIgnoreCase(str)) {
            this.btBack.setTextColor(StateListUtils.getStateColor(-2109303));
            this.btClose.setTextColor(StateListUtils.getStateColor(-2109303));
            setOptionMenuColor(-2109303);
            this.c = R.drawable.griver_ui_title_bar_progress_gold;
        }
        if ("black".equalsIgnoreCase(str)) {
            this.btBack.setTextColor(StateListUtils.getStateColor(-16777216));
            this.btClose.setTextColor(StateListUtils.getStateColor(-16777216));
            setOptionMenuColor(-16777216);
            this.c = R.drawable.griver_ui_title_bar_progress;
        }
        if (SchedulerSupport.CUSTOM.equalsIgnoreCase(str)) {
            setBackHomeButtonColor(BundleUtils.getInt(bundle, GriverLaunchParams.BACK_HOME_BUTTON_COLOR, -15692055));
            setBackButtonColor(BundleUtils.getInt(bundle, "backButtonColor", -15692055));
            setCloseButtonColor(BundleUtils.getInt(bundle, "closeButtonColor", -15692055));
            setOptionMenuColor(BundleUtils.getInt(bundle, "optionMenuColor", -15692055));
        }
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setBackButtonColor(int i) {
        this.btBack.setTextColor(StateListUtils.getStateColor(i | (-16777216)));
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setCloseButtonColor(int i) {
        a(this.btClose, i);
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setTitleLoading(int i) {
        try {
            InstrumentInjector.Resources_getDrawable(this.g.getResources(), i);
            this.c = i;
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("get drawable resource failed, do not set to progress loading: ");
            sb.append(i);
            GriverLogger.w(TAG, sb.toString());
        }
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setBackHomeButtonColor(int i) {
        a(this.btBackToHome, i);
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setOptionMenuColor(int i) {
        a(this.btMenu, i);
        a(this.btMenu1, i);
        a(this.btText, i);
        a(this.btText1, i);
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setTitleBackgroundImage(int i) {
        if (this.k == null || this.g == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                this.k.setBackground(InstrumentInjector.Resources_getDrawable(this.g.getResources(), i));
            } else {
                this.k.setBackgroundDrawable(InstrumentInjector.Resources_getDrawable(this.g.getResources(), i));
            }
        } catch (Exception e) {
            GriverLogger.e(TAG, "set title background image exception", e);
        }
    }

    private void a(TextView textView, int i) {
        if (textView != null) {
            try {
                textView.setTextColor(StateListUtils.getStateColor(i | (-16777216)));
            } catch (Exception unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("set color for view failed: ");
                sb.append(textView);
                GriverLogger.e(TAG, sb.toString());
            }
        }
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setTitleTextColor(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("setTitleTextColor: ");
        sb.append(i);
        RVLogger.d(TAG, sb.toString());
        int i2 = i | (-16777216);
        this.tvTitle.setTextColor(i2);
        this.tvSubtitle.setTextColor(i2);
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public View getOptionMenuContainer() {
        return this.h5NavOptions;
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void setTitleView(View view) {
        if (view == null) {
            ViewGroup viewGroup = this.i;
            if (viewGroup != null) {
                this.rlTitle.removeView(viewGroup);
                this.llTitle.setVisibility(0);
                this.i.removeAllViews();
                this.i = null;
                return;
            }
            return;
        }
        ViewGroup viewGroup2 = this.i;
        if (viewGroup2 == null) {
            this.i = new LinearLayout(this.g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(15);
            this.rlTitle.addView(this.i, layoutParams);
        } else {
            viewGroup2.removeAllViews();
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        }
        this.i.addView(view, layoutParams2);
        this.llTitle.setVisibility(4);
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void enableTitleSegControl(boolean z) {
        this.j.setEnabled(z);
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void initTitleSegControl(JSONObject jSONObject) {
        Exception e;
        Integer[] numArr;
        int i = JSONUtils.getInt(jSONObject, "segSelectedIndex");
        JSONArray jSONArray = jSONObject.getJSONArray("segWidths");
        JSONArray jSONArray2 = jSONObject.getJSONArray("segTitles");
        int i2 = JSONUtils.getInt(jSONObject, "segColorNormal");
        int i3 = JSONUtils.getInt(jSONObject, "segColorActive");
        if (jSONArray != null && !jSONArray.isEmpty() && jSONArray2 != null && !jSONArray2.isEmpty()) {
            String[] strArr = null;
            try {
                numArr = (Integer[]) jSONArray.toArray(new Integer[1]);
                try {
                    strArr = (String[]) jSONArray2.toArray(new String[1]);
                } catch (Exception e2) {
                    e = e2;
                    RVLogger.w(TAG, "segtitle or width is not right type", e);
                    if (numArr != null) {
                        this.j.setSegmentColor(i2, i3);
                        this.j.addItems(strArr, numArr);
                        this.j.setDefaultChecked(i);
                        this.j.setVisibility(0);
                    }
                    this.j.setEnabled(false);
                }
            } catch (Exception e3) {
                e = e3;
                numArr = null;
            }
            if (numArr != null && strArr != null && numArr.length == strArr.length) {
                this.j.setSegmentColor(i2, i3);
                this.j.addItems(strArr, numArr);
                this.j.setDefaultChecked(i);
                this.j.setVisibility(0);
            }
        } else {
            RVLogger.d(TAG, "SegWidth or  segTitles is empty)");
        }
        this.j.setEnabled(false);
    }

    @Override // com.alibaba.griver.ui.titlebar.H5SegmentGroup.OnItemCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup == this.j) {
            ((TitleBarSegCheckPoint) ExtensionPoint.as(TitleBarSegCheckPoint.class).node(this.e).create()).onSegItemChecked(i);
        }
    }

    @Override // com.alibaba.griver.ui.titlebar.TitleView
    public void performLastSegItemChecked(boolean z) {
        this.j.performLastItemChecked(z);
    }
}
