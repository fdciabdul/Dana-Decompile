package com.alibaba.griver.ui.popmenu;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.account.GriverAccount;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.AUImageView;
import com.alibaba.griver.ui.ant.badge.AUBadgeView;
import com.alibaba.griver.ui.ant.text.AUIconView;
import com.alibaba.griver.ui.popmenu.H5TinyPopMenu;
import com.alibaba.griver.ui.reddot.RedDotDrawable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class TitleBarRightButtonView extends LinearLayout implements TinyAppActionStateListener {
    public static final int ID_CLOSE_OPTTION_CONTAINER = 103;
    public static final int ID_FAVORITE_CONTAINER = 104;

    /* renamed from: a  reason: collision with root package name */
    private static final String f6738a = "TitleBarRightButtonView";
    private AUIconView b;
    private ImageView c;
    private AUIconView d;
    private AUBadgeView e;
    private RelativeLayout f;
    private AUImageView g;
    private TextView h;
    private TextView i;
    private RelativeLayout j;
    private String k;
    private String l;
    private String m;
    private String n;

    /* renamed from: o  reason: collision with root package name */
    private H5TinyPopMenu.TitleBarTheme f6739o;
    private CornerMarkingUIController p;
    private boolean q;
    private boolean r;
    private JSONObject s;
    private ObjectAnimator t;

    public TitleBarRightButtonView(Context context, H5TinyPopMenu.TitleBarTheme titleBarTheme, int i) {
        super(context);
        this.p = new CornerMarkingUIController();
        this.q = true;
        a(context, titleBarTheme, i);
    }

    public TitleBarRightButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = new CornerMarkingUIController();
        this.q = true;
        a(context, null, 0);
    }

    public TitleBarRightButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = new CornerMarkingUIController();
        this.q = true;
        a(context, null, 0);
    }

    private void a(Context context, H5TinyPopMenu.TitleBarTheme titleBarTheme, int i) {
        H5TinyPopMenu.TitleBarTheme titleBarTheme2 = titleBarTheme == null ? H5TinyPopMenu.TitleBarTheme.TITLE_BAR_THEME_DARK : titleBarTheme;
        float density = DimensionUtil.getDensity(context);
        Resources resources = context.getResources();
        if (resources != null) {
            this.k = resources.getString(R.string.griver_title_bar_favorite_icon_font_unicode);
            this.l = resources.getString(R.string.griver_title_bar_more_icon_font_unicode);
            this.m = resources.getString(R.string.griver_title_bar_close_icon_font_unicode);
        }
        setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        this.j = new RelativeLayout(context);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.j.setBackgroundResource(R.drawable.griver_ui_close_btn_bg_dark);
        relativeLayout.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (82.0f * density), -1);
        int i2 = (int) (9.0f * density);
        layoutParams2.topMargin = i2;
        layoutParams2.bottomMargin = i2;
        layoutParams2.rightMargin = (int) (4.0f * density);
        this.j.setLayoutParams(layoutParams2);
        int i3 = (int) (7.0f * density);
        int i4 = i3 / 3;
        int i5 = i3 + i4;
        double d = density;
        Double.isNaN(d);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins((int) (d * 24.5d), 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(0, 102);
        AUIconView aUIconView = new AUIconView(context, "tinyfont", "titlebar");
        this.b = aUIconView;
        aUIconView.setPadding(i5 + i4, 0, i5 - i4, 0);
        this.b.setLayoutParams(layoutParams4);
        this.b.setIconfontUnicode(this.l);
        this.b.setIconfontSize("22dp");
        this.b.setIconfontColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.griver_ui_dark_icon_color));
        this.b.setBackgroundResource(R.drawable.griver_ui_title_btn_bg_r_left);
        RedDotDrawable.wrap(this.b, getResources().getDimensionPixelOffset(R.dimen.griver_AU_REDDOTSIZE5), getResources().getDimensionPixelOffset(R.dimen.griver_AU_REDDOT_DX), getResources().getDimensionPixelOffset(R.dimen.griver_AU_REDDOT_DY), -65536);
        AUBadgeView aUBadgeView = new AUBadgeView(context);
        this.e = aUBadgeView;
        aUBadgeView.setLayoutParams(layoutParams3);
        this.e.setStyleAndContent(AUBadgeView.Style.POINT, "");
        this.e.setVisibility(8);
        this.e.setMaxLines(1);
        this.b.setContentDescription(context.getResources().getString(R.string.griver_more));
        ImageView imageView = new ImageView(context);
        this.c = imageView;
        imageView.setId(102);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(1, -1);
        layoutParams5.addRule(13);
        layoutParams5.setMargins(0, i3, 0, i3);
        this.c.setLayoutParams(layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams6.addRule(1, 102);
        AUIconView aUIconView2 = new AUIconView(context, "tinyfont", "titlebar");
        this.d = aUIconView2;
        aUIconView2.setLayoutParams(layoutParams6);
        this.d.setPadding(i5, 0, i5, 0);
        this.d.setIconfontUnicode(this.m);
        this.d.setIconfontSize("22dp");
        this.d.setIconfontColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.griver_ui_dark_icon_color));
        this.d.setBackgroundResource(R.drawable.griver_ui_title_btn_bg_r_right);
        this.d.setContentDescription(context.getResources().getString(R.string.griver_close));
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.gravity = 16;
        layoutParams7.rightMargin = (int) (8.0f * density);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.f = relativeLayout2;
        relativeLayout2.setLayoutParams(layoutParams7);
        this.f.setBackgroundResource(R.drawable.griver_ui_favorite_btn_bg_dark);
        RelativeLayout relativeLayout3 = new RelativeLayout(context);
        relativeLayout3.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        int i6 = (int) (density * 3.0f);
        relativeLayout3.setPadding(i6, i6, i6, i6);
        relativeLayout3.setBackgroundResource(R.drawable.griver_ui_title_btn_bg);
        relativeLayout3.setId(104);
        this.f.addView(relativeLayout3);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(a(24.0f), a(24.0f));
        layoutParams8.addRule(13);
        AUImageView aUImageView = new AUImageView(context);
        this.g = aUImageView;
        aUImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.g.setId(100);
        this.g.setLayoutParams(layoutParams8);
        this.g.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), R.drawable.griver_ui_title_favorite));
        this.g.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.griver_ui_dark_icon_color));
        relativeLayout3.addView(this.g);
        this.f.setVisibility(8);
        switchTheme(titleBarTheme2, i);
        setOrientation(0);
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (!"no".equalsIgnoreCase(rVConfigService != null ? rVConfigService.getConfigWithProcessCache("h5_showCloseButtonTitleBarRight", "") : "")) {
            this.j.addView(this.b);
            this.j.addView(this.c);
            this.j.addView(this.d);
            this.j.setId(103);
            relativeLayout.addView(this.j);
            relativeLayout.addView(this.e);
        }
        addView(this.f);
        addView(relativeLayout);
    }

    private int a(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void showOptionMenuRedDot(boolean z) {
        AUIconView aUIconView = this.b;
        if (aUIconView != null) {
            RedDotDrawable.showRedPoint(aUIconView, z);
            postInvalidate();
        }
    }

    public void setOptionMenuOnClickListener(View.OnClickListener onClickListener) {
        AUIconView aUIconView = this.b;
        if (aUIconView != null) {
            aUIconView.setOnClickListener(onClickListener);
        }
    }

    public void setCloseButtonOnClickListener(View.OnClickListener onClickListener) {
        AUIconView aUIconView = this.d;
        if (aUIconView != null) {
            aUIconView.setOnClickListener(onClickListener);
        }
    }

    public void setCloseButtonOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        AUIconView aUIconView = this.d;
        if (aUIconView != null) {
            aUIconView.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setFavoriteButtonClickListener(final View.OnClickListener onClickListener) {
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.popmenu.TitleBarRightButtonView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TitleBarRightButtonView.this.p.interceptClickEventForCornerMarking()) {
                        return;
                    }
                    onClickListener.onClick(view);
                }
            });
        }
    }

    public void setFavoriteBtnVisibility(int i) {
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i);
            setBadgeData(this.s);
        }
    }

    public void setFavoriteStatus(boolean z, String str) {
        this.q = z;
        this.r = true;
        switchFavoriteIconFont(z, str);
        setBadgeData(this.s);
    }

    public void switchFavoriteIconFont(boolean z, String str) {
        AUImageView aUImageView = this.g;
        if (aUImageView != null) {
            if (z) {
                ImageUtils.loadImage(aUImageView, ContextCompat.PlaceComponentResult(getContext(), R.drawable.griver_ui_title_favorited), str);
            } else {
                ImageUtils.loadImage(aUImageView, ContextCompat.PlaceComponentResult(getContext(), R.drawable.griver_ui_title_favorite), str);
            }
        }
    }

    public boolean isShowTitleBarFavorite() {
        RelativeLayout relativeLayout = this.f;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    public boolean isBadgeViewShow() {
        AUBadgeView aUBadgeView = this.e;
        return aUBadgeView != null && aUBadgeView.getVisibility() == 0;
    }

    public void setBadgeData(final JSONObject jSONObject) {
        this.s = jSONObject;
        AUBadgeView aUBadgeView = this.e;
        if (aUBadgeView != null) {
            aUBadgeView.setVisibility(8);
            if (jSONObject != null) {
                ExecutorUtils.runNotOnMain(ExecutorType.NETWORK, new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TitleBarRightButtonView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int i = JSONUtils.getInt(jSONObject, AUBadgeView.KEY_BADGE_STYLE);
                        final int i2 = JSONUtils.getInt(jSONObject, "unreadCount");
                        long j = JSONUtils.getLong(jSONObject, "latestMsgTime");
                        final int i3 = -1;
                        if (i2 > 0) {
                            try {
                                String userId = GriverAccount.getUserId();
                                if (!TextUtils.isEmpty(TitleBarRightButtonView.this.n) && !TextUtils.isEmpty(userId)) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(userId);
                                    sb.append("_");
                                    sb.append(TitleBarRightButtonView.this.n);
                                    sb.append("_titleBarOptionLatestClickTime");
                                    String obj = sb.toString();
                                    TitleBarRightButtonView titleBarRightButtonView = TitleBarRightButtonView.this;
                                    Context context = titleBarRightButtonView.getContext();
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(userId);
                                    sb2.append("_");
                                    sb2.append(TitleBarRightButtonView.this.n);
                                    SharedPreferences a2 = titleBarRightButtonView.a(context, sb2.toString());
                                    String string = a2 != null ? a2.getString(obj, "") : "";
                                    if (!TextUtils.isEmpty(string) && Long.parseLong(string) >= j) {
                                        if (!TitleBarRightButtonView.this.p.hasCornerMarking()) {
                                            return;
                                        }
                                        i = -1;
                                    }
                                }
                                i3 = i;
                            } catch (Throwable th) {
                                RVLogger.e(TitleBarRightButtonView.f6738a, th);
                            }
                        }
                        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TitleBarRightButtonView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (i3 > 0) {
                                    TitleBarRightButtonView.this.e.setVisibility(0);
                                    int i4 = i3;
                                    if (i4 != 1) {
                                        if (i4 != 2) {
                                            TitleBarRightButtonView.this.p.syncCornerMarkingDataToUI();
                                            return;
                                        }
                                        float density = DimensionUtil.getDensity(TitleBarRightButtonView.this.getContext());
                                        TitleBarRightButtonView.this.e.setStyleAndContent(AUBadgeView.Style.POINT, "");
                                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) TitleBarRightButtonView.this.e.getLayoutParams();
                                        if (layoutParams != null) {
                                            layoutParams.topMargin = Math.round(density * 12.5f);
                                            layoutParams.leftMargin = (int) (28.5f * density);
                                            TitleBarRightButtonView.this.e.setLayoutParams(layoutParams);
                                            return;
                                        }
                                        return;
                                    } else if (i2 > 0) {
                                        TitleBarRightButtonView.this.e.setStyleAndContent(AUBadgeView.Style.NUM, "");
                                        if (TitleBarRightButtonView.this.f6739o == H5TinyPopMenu.TitleBarTheme.TITLE_BAR_THEME_DARK) {
                                            TitleBarRightButtonView.this.e.setMsgCount(i2, true);
                                        } else {
                                            TitleBarRightButtonView.this.e.setMsgCount(i2, false);
                                        }
                                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) TitleBarRightButtonView.this.e.getLayoutParams();
                                        if (layoutParams2 != null) {
                                            int density2 = (int) (DimensionUtil.getDensity(TitleBarRightButtonView.this.getContext()) * 23.0f);
                                            layoutParams2.topMargin = 0;
                                            layoutParams2.leftMargin = density2;
                                            TitleBarRightButtonView.this.e.setLayoutParams(layoutParams2);
                                            return;
                                        }
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                TitleBarRightButtonView.this.p.syncCornerMarkingDataToUI();
                            }
                        });
                    }
                });
            } else {
                this.p.syncCornerMarkingDataToUI();
            }
        }
    }

    public void dismissBadgeView() {
        this.p.expose();
        ExecutorUtils.runNotOnMain(ExecutorType.NETWORK, new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TitleBarRightButtonView.3
            @Override // java.lang.Runnable
            public void run() {
                if (TitleBarRightButtonView.this.p.hasCornerMarking()) {
                    return;
                }
                ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TitleBarRightButtonView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (TitleBarRightButtonView.this.e != null) {
                            TitleBarRightButtonView.this.e.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void setAppId(String str) {
        this.n = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        String str = f6738a;
        StringBuilder sb = new StringBuilder();
        sb.append("switchToLightTheme...optionMenu=");
        sb.append(this.b);
        RVLogger.d(str, sb.toString());
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundResource(R.drawable.griver_ui_close_btn_bg_light);
        }
        AUIconView aUIconView = this.b;
        if (aUIconView != null) {
            aUIconView.setIconfontColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.griver_ui_light_icon_color));
        }
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.griver_ui_light_line_color));
        }
        AUIconView aUIconView2 = this.d;
        if (aUIconView2 != null) {
            aUIconView2.setIconfontColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.griver_ui_light_icon_color));
        }
        AUImageView aUImageView = this.g;
        if (aUImageView != null) {
            aUImageView.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.griver_ui_light_icon_color));
        }
        TextView textView = this.h;
        if (textView != null) {
            textView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.griver_ui_light_title_color));
        }
        RelativeLayout relativeLayout2 = this.f;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundResource(R.drawable.griver_ui_favorite_btn_bg_light);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        String str = f6738a;
        StringBuilder sb = new StringBuilder();
        sb.append("switchToBlueTheme...optionMenu=");
        sb.append(this.b);
        RVLogger.d(str, sb.toString());
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundResource(R.drawable.griver_ui_close_btn_bg_dark);
        }
        AUIconView aUIconView = this.b;
        if (aUIconView != null) {
            aUIconView.setIconfontColor(i);
        }
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.griver_ui_dark_line_color));
        }
        AUIconView aUIconView2 = this.d;
        if (aUIconView2 != null) {
            aUIconView2.setIconfontColor(i);
        }
        AUImageView aUImageView = this.g;
        if (aUImageView != null) {
            aUImageView.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.griver_ui_dark_icon_color));
        }
        TextView textView = this.h;
        if (textView != null) {
            textView.setTextColor(i);
        }
        RelativeLayout relativeLayout2 = this.f;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundResource(R.drawable.griver_ui_favorite_btn_bg_dark);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String str = f6738a;
        StringBuilder sb = new StringBuilder();
        sb.append("switchToDarkTheme...optionMenu=");
        sb.append(this.b);
        RVLogger.d(str, sb.toString());
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundResource(R.drawable.griver_ui_close_btn_bg_dark);
        }
        AUIconView aUIconView = this.b;
        if (aUIconView != null) {
            aUIconView.setIconfontColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.griver_ui_dark_icon_color));
        }
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.griver_ui_dark_line_color));
        }
        AUIconView aUIconView2 = this.d;
        if (aUIconView2 != null) {
            aUIconView2.setIconfontColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.griver_ui_dark_icon_color));
        }
        AUImageView aUImageView = this.g;
        if (aUImageView != null) {
            aUImageView.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.griver_ui_dark_icon_color));
        }
        TextView textView = this.h;
        if (textView != null) {
            textView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.griver_ui_dark_title_color));
        }
        RelativeLayout relativeLayout2 = this.f;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundResource(R.drawable.griver_ui_favorite_btn_bg_dark);
        }
    }

    public void switchTheme(final H5TinyPopMenu.TitleBarTheme titleBarTheme, final int i) {
        post(new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TitleBarRightButtonView.4
            @Override // java.lang.Runnable
            public void run() {
                TitleBarRightButtonView.this.f6739o = titleBarTheme;
                if (titleBarTheme == H5TinyPopMenu.TitleBarTheme.TITLE_BAR_THEME_LIGHT) {
                    TitleBarRightButtonView.this.a();
                } else if (titleBarTheme == H5TinyPopMenu.TitleBarTheme.TITLE_BAR_THEME_DARK) {
                    TitleBarRightButtonView.this.b();
                } else if (titleBarTheme == H5TinyPopMenu.TitleBarTheme.TITLE_BAR_THEME_CUSTOM) {
                    TitleBarRightButtonView.this.a(i);
                }
            }
        });
    }

    public void updateCornerMarking(List<CornerMarkingData> list) {
        this.p.setDataProvider(list);
        this.p.syncCornerMarkingDataToUI();
    }

    public void setH5Page(Page page) {
        this.p.setH5Page(page);
        if (page.getStartParams() == null || !BundleUtils.getBoolean(page.getStartParams(), RVParams.isTinyApp, false)) {
            return;
        }
        TinyAppActionStateManager.getInstance().registerStateListener(page, this);
    }

    public boolean isCornerMarkingShow() {
        TextView textView = this.i;
        return textView != null && textView.getVisibility() == 0;
    }

    @Override // com.alibaba.griver.ui.popmenu.TinyAppActionStateListener
    public void onStateChanged(TinyAppActionState tinyAppActionState) {
        if (TinyMenuUtils.showActionIcon(this.n)) {
            if (tinyAppActionState != null) {
                String str = f6738a;
                StringBuilder sb = new StringBuilder();
                sb.append("onStateChanged ");
                sb.append(tinyAppActionState.getAction());
                sb.append(" ");
                sb.append(tinyAppActionState.getCount());
                RVLogger.d(str, sb.toString());
                setOptionMenuIcon(tinyAppActionState);
                return;
            }
            c();
        }
    }

    private ObjectAnimator getOptionMenuBlinkAnimator() {
        if (this.t == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, "alpha", 1.0f, 0.0f, 1.0f);
            this.t = ofFloat;
            ofFloat.setDuration(1000L);
            this.t.setRepeatCount(-1);
            this.t.setRepeatMode(1);
        }
        return this.t;
    }

    private void setOptionMenuIcon(TinyAppActionState tinyAppActionState) {
        String iconUnicode = tinyAppActionState.getIconUnicode(getResources());
        if (TextUtils.isEmpty(iconUnicode)) {
            return;
        }
        this.b.setIconfontUnicode(iconUnicode);
        getOptionMenuBlinkAnimator().cancel();
        getOptionMenuBlinkAnimator().start();
    }

    private void c() {
        this.b.setIconfontUnicode(this.l);
        this.b.setAlpha(1.0f);
        getOptionMenuBlinkAnimator().cancel();
    }

    public View getFavorite() {
        return this.f;
    }

    public View getOptionMenu() {
        return this.b;
    }

    public View getOptionMenuContainer() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences a(Context context, String str) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class CornerMarkingUIController {

        /* renamed from: a  reason: collision with root package name */
        private List<CornerMarkingData> f6740a;
        private WeakReference<Page> b;

        private CornerMarkingUIController() {
        }

        public void setDataProvider(List<CornerMarkingData> list) {
            this.f6740a = list;
        }

        public void setH5Page(Page page) {
            this.b = new WeakReference<>(page);
        }

        private CornerMarkingData a() {
            List<CornerMarkingData> list = this.f6740a;
            if (list == null) {
                return null;
            }
            for (CornerMarkingData cornerMarkingData : list) {
                if (cornerMarkingData != null && "1005".equals(cornerMarkingData.mid)) {
                    return cornerMarkingData;
                }
            }
            return null;
        }

        public void syncCornerMarkingDataToUI() {
            if (TitleBarRightButtonView.this.i == null) {
                return;
            }
            CornerMarkingData a2 = a();
            if (a2 == null) {
                TitleBarRightButtonView.this.i.setTag(null);
                TitleBarRightButtonView.this.i.setText((CharSequence) null);
            } else {
                TitleBarRightButtonView.this.i.setTag(a2);
                TitleBarRightButtonView.this.i.setText(a2.superscript);
            }
            ExecutorUtils.runNotOnMain(ExecutorType.NETWORK, new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TitleBarRightButtonView.CornerMarkingUIController.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CornerMarkingUIController.this.hasCornerMarking()) {
                        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TitleBarRightButtonView.CornerMarkingUIController.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (TitleBarRightButtonView.this.e.getVisibility() != 0) {
                                    TitleBarRightButtonView.this.e.setVisibility(0);
                                    float density = DimensionUtil.getDensity(TitleBarRightButtonView.this.getContext());
                                    TitleBarRightButtonView.this.e.setStyleAndContent(AUBadgeView.Style.POINT, "");
                                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) TitleBarRightButtonView.this.e.getLayoutParams();
                                    if (layoutParams != null) {
                                        layoutParams.topMargin = Math.round(density * 12.5f);
                                        layoutParams.leftMargin = (int) (28.5f * density);
                                        TitleBarRightButtonView.this.e.setLayoutParams(layoutParams);
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }

        public boolean interceptClickEventForCornerMarking() {
            if (TitleBarRightButtonView.this.i != null && (TitleBarRightButtonView.this.i.getTag() instanceof CornerMarkingData)) {
                WeakReference<Page> weakReference = this.b;
                String appId = (weakReference != null ? weakReference.get() : null).getApp().getAppId();
                if (TextUtils.isEmpty(appId)) {
                    return false;
                }
                RVLogger.d(TitleBarRightButtonView.f6738a, "intercept click event for corner marking");
                CornerMarkingData cornerMarkingData = (CornerMarkingData) TitleBarRightButtonView.this.i.getTag();
                List<CornerMarkingData> list = this.f6740a;
                if (list != null) {
                    list.remove(cornerMarkingData);
                }
                new CornerMarkingDataProvider().click(appId, cornerMarkingData.noticeId);
                RVLogger.d(TitleBarRightButtonView.f6738a, cornerMarkingData.toJavaScript());
                syncCornerMarkingDataToUI();
                return TextUtils.equals("startApp", cornerMarkingData.action);
            }
            return false;
        }

        public boolean hasCornerMarking() {
            List<CornerMarkingData> list = this.f6740a;
            boolean z = false;
            if (list != null && list.size() > 0) {
                if (!TitleBarRightButtonView.this.r) {
                    TitleBarRightButtonView.this.r = true;
                }
                boolean z2 = TitleBarRightButtonView.this.f != null && TitleBarRightButtonView.this.f.getVisibility() == 0;
                for (CornerMarkingData cornerMarkingData : this.f6740a) {
                    if (!cornerMarkingData.exposed && (!z2 || !"1005".equals(cornerMarkingData.mid))) {
                        if (!TitleBarRightButtonView.this.q || !"1005".equals(cornerMarkingData.mid)) {
                            z = true;
                        }
                    }
                }
            }
            return z;
        }

        public void expose() {
            List<CornerMarkingData> list = this.f6740a;
            if (TitleBarRightButtonView.this.q) {
                list = new ArrayList<>();
                for (CornerMarkingData cornerMarkingData : this.f6740a) {
                    if (!"1005".equals(cornerMarkingData.mid)) {
                        list.add(cornerMarkingData);
                    }
                }
            }
            new CornerMarkingDataProvider().expose(TitleBarRightButtonView.this.n, list);
        }
    }
}
