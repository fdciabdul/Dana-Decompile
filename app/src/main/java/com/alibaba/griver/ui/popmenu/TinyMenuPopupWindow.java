package com.alibaba.griver.ui.popmenu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.StatusBarUtils;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.common.account.GriverAccount;
import com.alibaba.griver.base.common.adapter.ImageListener;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.badge.AUBadgeView;
import com.alibaba.griver.ui.ant.basic.AUHorizontalListView;
import com.alibaba.griver.ui.ant.dialog.AUDialog;
import com.alibaba.griver.ui.ant.text.AUIconView;
import com.alibaba.griver.ui.blur.AUBubbleView;
import com.alibaba.griver.ui.blur.Blur;
import com.alibaba.griver.ui.blur.BlurFactor;
import com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow;
import com.google.common.base.Ascii;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class TinyMenuPopupWindow extends AUDialog implements DialogInterface.OnDismissListener, View.OnClickListener, ITinyMenuPopupWindow {
    protected static final int MAX_MENU_ITEM_COUNT_ROW = 5;
    protected static final int MENU_HORIZONTAL_MARGIN = 2;
    protected static final int ROW_MARGIN_HORIZONTAL = 8;
    protected static final int ROW_MARGIN_TOP = 8;
    private long A;
    private LinearLayout B;
    private TextView C;
    private CornerMarkingUIController D;
    private View.OnClickListener E;
    private int F;

    /* renamed from: a  reason: collision with root package name */
    private float f6732a;
    private List<TinyMenuItemData> b;
    private TinyMenuItemData c;
    private String d;
    private String e;
    private Page f;
    private LinearLayout g;
    private LinearLayout h;
    private View i;
    private TextView j;
    private AUIconView k;
    private View l;
    private TextView m;
    protected Context mContext;
    protected AUHorizontalListView mFavoriteAndRecentTinyAppList;
    protected View mInternalContent;
    protected View mMenuContent;
    protected int mMenuItemWidth;
    View.OnLayoutChangeListener mOnLayoutChangeListener;
    protected int mRecentTinyAppItemWidth;
    protected List<TinyMenuFunctionModel> mRecentUseList;
    private AUIconView n;

    /* renamed from: o  reason: collision with root package name */
    private View.OnClickListener f6733o;
    private ITinyMenuPopupWindow.OnMenuWindowDismissListener p;
    private BaseAdapter q;
    private boolean r;
    private Bitmap s;
    private boolean t;
    private boolean u;
    private Map<String, String> v;
    private Map<String, View> w;
    private int x;
    private int y;
    private boolean z;
    public static final byte[] $$d = {75, -23, 102, -23, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 86;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {38, -105, 32, Ascii.RS, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int PlaceComponentResult = 31;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void I(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = 16 - r6
            int r8 = r8 + 4
            int r7 = 106 - r7
            byte[] r0 = com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r7
            r4 = 0
            r7 = r6
            goto L2c
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r8 = r8 + 1
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L2c:
            int r6 = r6 + r3
            int r6 = r6 + 2
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.I(int, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void J(short r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 4
            int r7 = r7 + 75
            int r8 = r8 * 4
            int r8 = 42 - r8
            int r9 = r9 * 4
            int r9 = r9 + 4
            byte[] r0 = com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.$$d
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L1a:
            r3 = 0
        L1b:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r9]
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L34:
            int r8 = -r8
            int r9 = r9 + r8
            int r8 = r10 + 1
            int r9 = r9 + (-7)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.J(short, short, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startRecentTinyApp() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startTinyAppAndCloseCurrent(String str) {
    }

    public TinyMenuPopupWindow(Context context) {
        super(context, R.style.griver_Pop_Menu_Style);
        this.mRecentUseList = new ArrayList();
        this.b = new ArrayList();
        this.r = false;
        this.t = true;
        this.u = false;
        this.v = new HashMap();
        this.w = new HashMap();
        this.x = 0;
        this.y = 0;
        this.z = false;
        this.A = 0L;
        this.D = new CornerMarkingUIController();
        this.E = new View.OnClickListener() { // from class: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TinyMenuPopupWindow.this.c == null) {
                    return;
                }
                if (TinyMenuPopupWindow.this.n == null || TinyMenuPopupWindow.this.n.getVisibility() != 8) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - TinyMenuPopupWindow.this.A < 1000) {
                        return;
                    }
                    TinyMenuPopupWindow.this.A = currentTimeMillis;
                    if (TinyMenuPopupWindow.this.c != null) {
                        TinyMenuPopupWindow tinyMenuPopupWindow = TinyMenuPopupWindow.this;
                        tinyMenuPopupWindow.a(tinyMenuPopupWindow.c);
                    }
                    TinyMenuPopupWindow.this.doDismissWithAnimation(true);
                }
            }
        };
        this.F = 0;
        this.mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                try {
                    int width = ((WindowManager) TinyMenuPopupWindow.this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
                    StringBuilder sb = new StringBuilder();
                    sb.append("on layout change width = ");
                    sb.append(width);
                    RVLogger.debug("TinyMenuPopupWindow", sb.toString());
                    if (width != TinyMenuPopupWindow.this.F) {
                        TinyMenuPopupWindow.this.a();
                        TinyMenuPopupWindow.this.d();
                    }
                } catch (Throwable th) {
                    RVLogger.e("TinyMenuPopupWindow", "onlayout change exception ", th);
                }
            }
        };
        this.mContext = context;
        Resources resources = context.getResources();
        if (resources != null) {
            try {
                this.v.put("1001", resources.getString(R.string.griver_ui_menu_item_about));
                this.v.put(TinyBlurMenu.ADD_TO_DESKTOP_ID, resources.getString(R.string.griver_ui_menu_item_add_to_desktop));
                this.v.put(TinyBlurMenu.ADD_TO_HOME_ID, resources.getString(R.string.griver_ui_menu_item_add_to_home));
                this.v.put(TinyBlurMenu.BACK_TO_HOME_ID, resources.getString(R.string.griver_ui_bar_back_to_home));
                this.v.put(TinyBlurMenu.CANCEL_FAVORITE_ID, resources.getString(R.string.griver_ui_title_bar_unfavorite_icon_font_unicode));
                this.v.put("1005", resources.getString(R.string.griver_ui_menu_item_favorite_icon_font_unicode));
                this.v.put("1002", resources.getString(R.string.griver_ui_menu_item_share));
                this.v.put(TinyBlurMenu.MESSAGE_ID, resources.getString(R.string.griver_ui_menu_item_message));
                this.v.put(TinyBlurMenu.FEEDBACK_ID, resources.getString(R.string.griver_ui_menu_item_complaint));
                this.v.put(TinyBlurMenu.BACK_TO_ALIPAY_HOME_ID, resources.getString(R.string.griver_ui_menu_item_back_to_home));
                this.v.put(TinyBlurMenu.OPEN_PERFORMANCE_ID, resources.getString(R.string.griver_ui_menu_item_performance));
                this.v.put(TinyBlurMenu.CLOSE_PERFORMANCE_ID, resources.getString(R.string.griver_ui_menu_item_performance));
                this.v.put(TinyBlurMenu.OPEN_VCONSOLE_ID, resources.getString(R.string.griver_ui_menu_item_debug));
                this.v.put(TinyBlurMenu.CLOSE_VCONSOLE_ID, resources.getString(R.string.griver_ui_menu_item_debug));
                this.v.put(TinyBlurMenu.OFFICIAL_FEEDBACK_ID, resources.getString(R.string.griver_ui_menu_item_official_feedback));
                this.v.put(TinyBlurMenu.MY_FAVORITE_TINY_APP, resources.getString(R.string.griver_ui_menu_my_favorite_tiny_app));
                this.v.put("default", resources.getString(R.string.griver_ui_menu_item_default));
            } catch (Throwable th) {
                RVLogger.e("TinyMenuPopupWindow", th);
            }
        }
    }

    private static SharedPreferences a(Context context, String str, String str2) {
        if (context != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("rv_local_storage_");
            sb.append(str);
            sb.append("_");
            sb.append(str2);
            return context.getSharedPreferences(sb.toString(), 0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        AppModel appModel;
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            I(b, b2, (byte) (b2 | 14), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            I((byte) (BuiltInFictitiousFunctionClassFactory[5] + 1), (byte) (-BuiltInFictitiousFunctionClassFactory[5]), BuiltInFictitiousFunctionClassFactory[5], objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 494, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 3, (char) (AndroidCharacter.getMirror('0') - '0'));
                    byte b3 = (byte) ($$d[4] - 1);
                    byte b4 = b3;
                    Object[] objArr4 = new Object[1];
                    J(b3, b4, b4, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r5 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (Process.myTid() >> 22) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-641395881, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.green(0), 17 - TextUtils.lastIndexOf("", '0'), (char) View.MeasureSpec.getSize(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                super.onCreate(bundle);
                View inflate = LayoutInflater.from(this.mContext).inflate(getLayoutId(), (ViewGroup) null);
                this.mMenuContent = inflate;
                this.mInternalContent = inflate.findViewById(R.id.menu_content);
                this.mFavoriteAndRecentTinyAppList = (AUHorizontalListView) this.mMenuContent.findViewById(R.id.favorite_and_recent_tiny_app_list);
                this.h = (LinearLayout) this.mMenuContent.findViewById(R.id.menu_area);
                this.k = (AUIconView) this.mMenuContent.findViewById(R.id.tiny_menu_arrow);
                this.i = this.mMenuContent.findViewById(R.id.close_menu);
                this.l = this.mMenuContent.findViewById(R.id.recent_use_tiny_app_title);
                this.j = (TextView) this.mMenuContent.findViewById(R.id.menu_title);
                this.g = (LinearLayout) this.mMenuContent.findViewById(R.id.recent_app_area);
                this.m = (TextView) this.mMenuContent.findViewById(R.id.tiny_app_desc);
                this.n = (AUIconView) this.mMenuContent.findViewById(R.id.about_icon);
                this.B = (LinearLayout) this.mMenuContent.findViewById(R.id.menu_action_content);
                this.C = (TextView) this.mMenuContent.findViewById(R.id.menu_action_text);
                this.mFavoriteAndRecentTinyAppList.setSelector(17170445);
                FavoriteAndRecentAppAdapter favoriteAndRecentAppAdapter = new FavoriteAndRecentAppAdapter();
                this.q = favoriteAndRecentAppAdapter;
                this.mFavoriteAndRecentTinyAppList.setAdapter((ListAdapter) favoriteAndRecentAppAdapter);
                if (!this.r) {
                    this.g.setVisibility(8);
                    this.mFavoriteAndRecentTinyAppList.setVisibility(8);
                    this.l.setVisibility(8);
                }
                this.i.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TinyMenuPopupWindow.this.z) {
                            return;
                        }
                        TinyMenuPopupWindow.this.doDismissWithAnimation(true);
                    }
                });
                try {
                    a();
                    Resources resources = this.mContext.getResources();
                    AppModel queryHighestAppInfo = GriverAppCenter.queryHighestAppInfo(this.e);
                    if (queryHighestAppInfo != null && !TextUtils.isEmpty(queryHighestAppInfo.getAppInfoModel().getName())) {
                        this.j.setText(queryHighestAppInfo.getAppInfoModel().getName());
                    }
                    Page page = this.f;
                    if (page != null && page.getApp() != null && (appModel = (AppModel) this.f.getApp().getData(AppModel.class)) != null && appModel.getAppInfoModel() != null) {
                        this.j.setText(appModel.getAppInfoModel().getName());
                    }
                    this.k.setIconfontFileName("iconfont");
                    this.k.setIconfontBundle("tinyfont");
                    this.k.setIconfontColor("#747474");
                    this.k.setIconfontUnicode(resources.getString(R.string.griver_ui_tiny_menu_arrow_icon_font));
                    this.n.setIconfontFileName("iconfont");
                    this.n.setIconfontBundle("tinyfont");
                    this.n.setIconfontColor("#747474");
                    this.n.setIconfontSize("16dp");
                    this.n.setIconfontUnicode(resources.getString(R.string.griver_ui_menu_mini_about_icon));
                } catch (Throwable th3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("initWidth...e=");
                    sb.append(th3);
                    RVLogger.e("TinyMenuPopupWindow", sb.toString());
                }
                requestWindowFeature(1);
                setContentView(this.mMenuContent);
                Window window = getWindow();
                if (window != null) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    initWindowManagerLayoutParams(attributes);
                    window.setAttributes(attributes);
                    View decorView = window.getDecorView();
                    if (decorView != null) {
                        decorView.setPadding(0, 0, 0, 0);
                    }
                }
                setOnDismissListener(this);
                setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.4
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                        if (!TinyMenuPopupWindow.this.z && keyEvent.getAction() == 1 && i2 == 4 && keyEvent.getRepeatCount() == 0) {
                            TinyMenuPopupWindow.this.doDismissWithAnimation(true);
                            return true;
                        }
                        return false;
                    }
                });
                this.l.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TinyMenuPopupWindow.this.startRecentTinyApp();
                        if (TinyMenuPopupWindow.this.z) {
                            return;
                        }
                        TinyMenuPopupWindow.this.doDismissWithAnimation(true);
                    }
                });
                this.j.setOnClickListener(this.E);
                this.m.setOnClickListener(this.E);
                this.n.setOnClickListener(this.E);
            } catch (Throwable th4) {
                Throwable cause3 = th4.getCause();
                if (cause3 == null) {
                    throw th4;
                }
                throw cause3;
            }
        } catch (Throwable th5) {
            Throwable cause4 = th5.getCause();
            if (cause4 == null) {
                throw th5;
            }
            throw cause4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            this.f6732a = this.mContext.getResources().getDisplayMetrics().density;
            int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
            initMenuItemWidth(width);
            StringBuilder sb = new StringBuilder();
            sb.append("initScreenWidth width = ");
            sb.append(width);
            RVLogger.debug("TinyMenuPopupWindow", sb.toString());
            this.F = width;
        } catch (Throwable th) {
            RVLogger.e("TinyMenuPopupWindow", "init screen width ", th);
        }
    }

    protected void initMenuItemWidth(int i) {
        this.mRecentTinyAppItemWidth = Math.round(this.f6732a * 75.0f);
        this.mMenuItemWidth = (i - Math.round((this.f6732a * 36.0f) + 0.5f)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onStart() {
        View view;
        List<TinyMenuFunctionModel> list;
        super.onStart();
        d();
        this.z = false;
        if (this.q != null && (list = this.mRecentUseList) != null && list.size() > 0) {
            this.q.notifyDataSetChanged();
        }
        c();
        View view2 = this.mMenuContent;
        if (view2 != null && (view = this.mInternalContent) != null) {
            if (this.s != null) {
                if (this.t) {
                    try {
                        view2.measure(0, 0);
                    } catch (Throwable th) {
                        RVLogger.e("TinyMenuPopupWindow", th);
                    }
                    this.x = this.mMenuContent.getMeasuredHeight();
                    this.t = false;
                }
                this.y = this.x;
                if (this.B.getVisibility() == 0) {
                    this.y += DimensionUtil.dip2px(getContext(), 22.0f);
                }
                this.mInternalContent.setBackgroundDrawable(createTinyMenuBackground(this.s));
            } else {
                view.setBackgroundResource(R.color.griver_ui_default_menu_bg);
            }
            this.mMenuContent.startAnimation(AnimationUtils.loadAnimation(this.mContext, getShowAnimationId()));
        }
        TextUtils.isEmpty(this.d);
        TextView textView = this.m;
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (this.c == null) {
            AUIconView aUIconView = this.n;
            if (aUIconView != null) {
                aUIconView.setVisibility(8);
            }
        } else {
            AUIconView aUIconView2 = this.n;
            if (aUIconView2 != null) {
                aUIconView2.setVisibility(8);
            }
        }
        List<TinyMenuFunctionModel> list2 = this.mRecentUseList;
        if (list2 == null || list2.size() == 0) {
            AUHorizontalListView aUHorizontalListView = this.mFavoriteAndRecentTinyAppList;
            if (aUHorizontalListView != null) {
                aUHorizontalListView.setVisibility(8);
            }
            View view3 = this.l;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            LinearLayout linearLayout = this.g;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } else if (!this.r) {
            AUHorizontalListView aUHorizontalListView2 = this.mFavoriteAndRecentTinyAppList;
            if (aUHorizontalListView2 != null) {
                aUHorizontalListView2.setVisibility(8);
            }
            View view4 = this.l;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.g;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        } else {
            AUHorizontalListView aUHorizontalListView3 = this.mFavoriteAndRecentTinyAppList;
            if (aUHorizontalListView3 != null) {
                aUHorizontalListView3.setVisibility(0);
            }
            View view5 = this.l;
            if (view5 != null) {
                view5.setVisibility(0);
            }
            LinearLayout linearLayout3 = this.g;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.u = false;
        View view = this.mInternalContent;
        if (view != null) {
            view.setBackgroundResource(R.color.griver_ui_default_menu_bg);
            this.s = null;
        }
        ITinyMenuPopupWindow.OnMenuWindowDismissListener onMenuWindowDismissListener = this.p;
        if (onMenuWindowDismissListener != null) {
            onMenuWindowDismissListener.onDismiss(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.6
            @Override // java.lang.Runnable
            public void run() {
                if (TinyMenuPopupWindow.this.z) {
                    return;
                }
                TinyMenuPopupWindow.this.doDismissWithAnimation(true, view);
            }
        });
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setCurrentAppId(String str) {
        this.e = str;
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setH5Page(Page page) {
        this.f = page;
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public boolean isShowMenu() {
        return this.u;
    }

    public void showMenu(Context context) {
        if (this.u) {
            return;
        }
        this.u = true;
        if ("yes".equalsIgnoreCase(GriverConfig.getConfig("h5_disableMenuBgBlur", ""))) {
            b();
        } else {
            GriverExecutors.getExecutor(ExecutorType.URGENT_DISPLAY).execute(new AnonymousClass7(context));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow$7  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass7 implements Runnable {
        final /* synthetic */ Context val$context;

        AnonymousClass7(Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            final View findViewById;
            final int i;
            final int i2;
            final Bitmap bitmap;
            final Canvas canvas;
            if (TinyMenuPopupWindow.this.f == null || TinyMenuPopupWindow.this.f.getPageContext().getActivity() == null || (findViewById = TinyMenuPopupWindow.this.f.getPageContext().getActivity().findViewById(16908290)) == null) {
                return;
            }
            DisplayMetrics displayMetrics = GriverEnv.getApplicationContext().getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                int i3 = displayMetrics.widthPixels;
                i2 = displayMetrics.heightPixels;
                i = i3;
            } else {
                i = 0;
                i2 = 0;
            }
            try {
                bitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            } catch (Throwable th) {
                RVLogger.e("TinyMenuPopupWindow", th);
                bitmap = null;
            }
            if (bitmap == null) {
                TinyMenuPopupWindow.this.b();
                return;
            }
            try {
                canvas = new Canvas(bitmap);
            } catch (Throwable th2) {
                RVLogger.e("TinyMenuPopupWindow", th2);
                canvas = null;
            }
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.7.1
                @Override // java.lang.Runnable
                public void run() {
                    final boolean z;
                    Canvas canvas2;
                    try {
                        canvas2 = canvas;
                    } catch (Throwable th3) {
                        RVLogger.e("TinyMenuPopupWindow", th3);
                        RVLogger.d("TinyMenuPopupWindow", "screen capture failed");
                    }
                    if (canvas2 != null) {
                        findViewById.draw(canvas2);
                        z = false;
                        GriverExecutors.getExecutor(ExecutorType.URGENT_DISPLAY).execute(new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.7.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BlurFactor blurFactor = new BlurFactor();
                                blurFactor.sampling = 8;
                                blurFactor.width = i;
                                blurFactor.height = i2;
                                blurFactor.color = Color.argb(230, 245, 245, 245);
                                try {
                                    if (!z) {
                                        TinyMenuPopupWindow.this.s = Blur.of(AnonymousClass7.this.val$context, bitmap, blurFactor);
                                    }
                                } catch (Throwable th4) {
                                    RVLogger.e("TinyMenuPopupWindow", th4);
                                    RVLogger.e("TinyMenuPopupWindow", "create menu blur failed");
                                    TinyMenuPopupWindow.this.s = null;
                                }
                                TinyMenuPopupWindow.this.b();
                            }
                        });
                    }
                    RVLogger.d("TinyMenuPopupWindow", "screen capture failed");
                    z = true;
                    GriverExecutors.getExecutor(ExecutorType.URGENT_DISPLAY).execute(new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.7.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BlurFactor blurFactor = new BlurFactor();
                            blurFactor.sampling = 8;
                            blurFactor.width = i;
                            blurFactor.height = i2;
                            blurFactor.color = Color.argb(230, 245, 245, 245);
                            try {
                                if (!z) {
                                    TinyMenuPopupWindow.this.s = Blur.of(AnonymousClass7.this.val$context, bitmap, blurFactor);
                                }
                            } catch (Throwable th4) {
                                RVLogger.e("TinyMenuPopupWindow", th4);
                                RVLogger.e("TinyMenuPopupWindow", "create menu blur failed");
                                TinyMenuPopupWindow.this.s = null;
                            }
                            TinyMenuPopupWindow.this.b();
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.8
            @Override // java.lang.Runnable
            public void run() {
                if (TinyMenuPopupWindow.this.b == null || TinyMenuPopupWindow.this.b.isEmpty()) {
                    RVLogger.d("TinyMenuPopupWindow", "internalShowMenu.. no valid item");
                } else if (!TinyMenuPopupWindow.this.isShowing()) {
                    try {
                        for (TinyMenuItemData tinyMenuItemData : TinyMenuPopupWindow.this.b) {
                            if (!TinyBlurMenu.MESSAGE_ID.equals(tinyMenuItemData.getMid()) && !TinyBlurMenu.OFFICIAL_FEEDBACK_ID.equals(tinyMenuItemData.getMid())) {
                                TinyBlurMenu.ADD_TO_HOME_ID.equals(tinyMenuItemData.getMid());
                            }
                        }
                        TinyMenuPopupWindow.this.show();
                    } catch (Throwable th) {
                        RVLogger.e("TinyMenuPopupWindow", th);
                    }
                }
            }
        });
    }

    private void c() {
        TinyAppActionState currentState;
        this.B.setVisibility(8);
        if (TinyMenuUtils.showActionIcon(this.f.getApp().getAppId()) && (currentState = TinyAppActionStateManager.getInstance().getCurrentState(this.f)) != null) {
            this.C.setText(currentState.getTips(getContext().getResources()));
            this.B.setVisibility(0);
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setMenuClickListener(View.OnClickListener onClickListener) {
        this.f6733o = onClickListener;
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setOnMenuWindowDismissListener(ITinyMenuPopupWindow.OnMenuWindowDismissListener onMenuWindowDismissListener) {
        this.p = onMenuWindowDismissListener;
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setMenus(List<TinyMenuItemData> list) {
        if (!a(list, true)) {
            this.t = true;
        }
        if (list != null) {
            this.b = new ArrayList();
            for (TinyMenuItemData tinyMenuItemData : list) {
                if (tinyMenuItemData != null) {
                    TinyMenuItemData tinyMenuItemData2 = new TinyMenuItemData();
                    a(tinyMenuItemData2, tinyMenuItemData);
                    this.b.add(tinyMenuItemData2);
                }
            }
        }
        if (this.b == null) {
            this.b = new ArrayList();
        }
    }

    public void setRecentUseTinyAppList(List<TinyMenuFunctionModel> list) {
        this.mRecentUseList = list;
        if (list == null) {
            this.mRecentUseList = new ArrayList();
        }
        BaseAdapter baseAdapter = this.q;
        if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void isShowRecentUseTinyAppArea(boolean z) {
        this.r = z;
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void updateFavoriteMenuItem(boolean z, List<TinyMenuItemData> list) {
        Map<String, View> map;
        Map<String, View> map2;
        AUBubbleView aUBubbleView;
        if (list == null || this.b == null || !a(list, false)) {
            if (list != null) {
                this.t = true;
                setMenus(list);
                d();
                return;
            }
            return;
        }
        TinyMenuItemData tinyMenuItemData = null;
        if (z) {
            if (list.contains(new TinyMenuItemData("", "", "", TinyBlurMenu.CANCEL_FAVORITE_ID)) && this.b != null && (map2 = this.w) != null && map2.containsKey("1005") && this.b.contains(new TinyMenuItemData("", "", "", "1005"))) {
                int indexOf = this.b.indexOf(new TinyMenuItemData("", "", "", "1005"));
                TinyMenuItemData tinyMenuItemData2 = (indexOf < 0 || indexOf >= this.b.size()) ? null : this.b.get(indexOf);
                int indexOf2 = list.indexOf(new TinyMenuItemData("", "", "", TinyBlurMenu.CANCEL_FAVORITE_ID));
                if (indexOf2 >= 0 && indexOf2 < list.size()) {
                    tinyMenuItemData = list.get(indexOf2);
                }
                if (tinyMenuItemData2 == null || tinyMenuItemData == null) {
                    return;
                }
                a(tinyMenuItemData2, tinyMenuItemData);
                View view = this.w.get("1005");
                a(tinyMenuItemData, view);
                this.w.put(TinyBlurMenu.CANCEL_FAVORITE_ID, view);
                if (view == null || (aUBubbleView = (AUBubbleView) view.findViewById(R.id.menu_item_corner_marking)) == null) {
                    return;
                }
                aUBubbleView.setVisibility(8);
            }
        } else if (list.contains(new TinyMenuItemData("", "", "", "1005")) && this.b != null && (map = this.w) != null && map.containsKey(TinyBlurMenu.CANCEL_FAVORITE_ID) && this.b.contains(new TinyMenuItemData("", "", "", TinyBlurMenu.CANCEL_FAVORITE_ID))) {
            int indexOf3 = this.b.indexOf(new TinyMenuItemData("", "", "", TinyBlurMenu.CANCEL_FAVORITE_ID));
            TinyMenuItemData tinyMenuItemData3 = (indexOf3 < 0 || indexOf3 >= this.b.size()) ? null : this.b.get(indexOf3);
            int indexOf4 = list.indexOf(new TinyMenuItemData("", "", "", "1005"));
            if (indexOf4 >= 0 && indexOf4 < list.size()) {
                tinyMenuItemData = list.get(indexOf4);
            }
            if (tinyMenuItemData == null || tinyMenuItemData3 == null) {
                return;
            }
            a(tinyMenuItemData3, tinyMenuItemData);
            View view2 = this.w.get(TinyBlurMenu.CANCEL_FAVORITE_ID);
            a(tinyMenuItemData, view2);
            this.w.put("1005", view2);
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void updateMessageMenuItem(List<TinyMenuItemData> list) {
        Map<String, View> map;
        TinyMenuItemData tinyMenuItemData;
        TinyMenuItemData tinyMenuItemData2;
        if (list == null || !list.contains(new TinyMenuItemData("", "", "", TinyBlurMenu.MESSAGE_ID)) || this.b == null || (map = this.w) == null || !map.containsKey(TinyBlurMenu.MESSAGE_ID) || !this.b.contains(new TinyMenuItemData("", "", "", TinyBlurMenu.MESSAGE_ID))) {
            return;
        }
        if (a(list, true)) {
            Iterator<TinyMenuItemData> it = this.b.iterator();
            while (true) {
                tinyMenuItemData = null;
                if (!it.hasNext()) {
                    tinyMenuItemData2 = null;
                    break;
                }
                tinyMenuItemData2 = it.next();
                if (tinyMenuItemData2 != null && TextUtils.equals(tinyMenuItemData2.getMid(), TinyBlurMenu.MESSAGE_ID)) {
                    break;
                }
            }
            Iterator<TinyMenuItemData> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                TinyMenuItemData next = it2.next();
                if (next != null && TextUtils.equals(next.getMid(), TinyBlurMenu.MESSAGE_ID)) {
                    tinyMenuItemData = next;
                    break;
                }
            }
            if (tinyMenuItemData2 == null || tinyMenuItemData == null) {
                return;
            }
            a(tinyMenuItemData2, tinyMenuItemData);
            a(tinyMenuItemData2, this.w.get(TinyBlurMenu.MESSAGE_ID));
            return;
        }
        this.t = true;
        setMenus(list);
        d();
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setTinyAppDesc(String str) {
        this.d = str;
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setMiniAbout(TinyMenuItemData tinyMenuItemData) {
        this.c = tinyMenuItemData;
    }

    private void a(TinyMenuItemData tinyMenuItemData, TinyMenuItemData tinyMenuItemData2) {
        if (tinyMenuItemData == null || tinyMenuItemData2 == null) {
            return;
        }
        tinyMenuItemData.action = tinyMenuItemData2.action;
        tinyMenuItemData.badgeType = tinyMenuItemData2.badgeType;
        tinyMenuItemData.callback = tinyMenuItemData2.callback;
        tinyMenuItemData.iconUrl = tinyMenuItemData2.iconUrl;
        tinyMenuItemData.latestMsgTime = tinyMenuItemData2.latestMsgTime;
        tinyMenuItemData.menuName = tinyMenuItemData2.menuName;
        tinyMenuItemData.messageCount = tinyMenuItemData2.messageCount;
        tinyMenuItemData.mid = tinyMenuItemData2.mid;
        tinyMenuItemData.params = tinyMenuItemData2.params;
        tinyMenuItemData.h5MenuIcon = tinyMenuItemData2.h5MenuIcon;
    }

    private boolean a(List<TinyMenuItemData> list, boolean z) {
        int size;
        int size2;
        int i;
        List<TinyMenuItemData> list2 = this.b;
        if (list2 == null || list == null || (size = list2.size()) != (size2 = list.size())) {
            return false;
        }
        if (z) {
            while (i < size && i < size2) {
                TinyMenuItemData tinyMenuItemData = this.b.get(i);
                TinyMenuItemData tinyMenuItemData2 = list.get(i);
                i = (tinyMenuItemData == null || tinyMenuItemData2 == null || !TextUtils.equals(tinyMenuItemData.getMid(), tinyMenuItemData2.getMid())) ? 0 : i + 1;
                return false;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        List<TinyMenuItemData> list;
        if (this.mContext != null && this.h != null && (list = this.b) != null && list.size() > 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            int round = Math.round((this.f6732a * 8.0f) + 0.5f);
            int round2 = Math.round((this.f6732a * 8.0f) + 0.5f);
            layoutParams.setMargins(round2, round, round2, 0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.mMenuItemWidth, -2);
            int round3 = Math.round((this.f6732a * 2.0f) + 0.5f);
            layoutParams2.setMargins(round3, 0, round3, 0);
            this.w.clear();
            this.h.removeAllViews();
            int size = this.b.size();
            LinearLayout linearLayout = null;
            for (int i = 0; i < size; i++) {
                TinyMenuItemData tinyMenuItemData = this.b.get(i);
                if (tinyMenuItemData != null && !TextUtils.isEmpty(tinyMenuItemData.getMid())) {
                    if (i % 5 == 0) {
                        linearLayout = new LinearLayout(this.mContext);
                        linearLayout.setClipChildren(false);
                        this.h.addView(linearLayout, layoutParams);
                    }
                    if (linearLayout != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.griver_ui_menu_item, (ViewGroup) null);
                        relativeLayout.setTag(Integer.valueOf(i));
                        relativeLayout.setClipChildren(false);
                        ViewCompat.getAuthRequestContext(relativeLayout, -i);
                        AUBubbleView aUBubbleView = (AUBubbleView) relativeLayout.findViewById(R.id.menu_item_corner_marking);
                        if (aUBubbleView != null) {
                            aUBubbleView.setTranslationX(this.mMenuItemWidth / 2);
                        }
                        a(tinyMenuItemData, relativeLayout);
                        if (this.f6733o != null) {
                            relativeLayout.setOnClickListener(this);
                        }
                        this.w.put(tinyMenuItemData.getMid(), relativeLayout);
                        linearLayout.addView(relativeLayout, layoutParams2);
                    }
                }
            }
            this.D.syncCornerMarkingDataToUI();
            return;
        }
        this.w.clear();
        this.h.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TinyMenuItemData tinyMenuItemData, View view) {
        if (view == null || tinyMenuItemData == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.menu_item_text);
        AUIconView aUIconView = (AUIconView) view.findViewById(R.id.menu_item_font_icon);
        ImageView imageView = (ImageView) view.findViewById(R.id.menu_item_img_icon);
        AUBadgeView aUBadgeView = (AUBadgeView) view.findViewById(R.id.menu_item_badge);
        if (textView != null) {
            textView.setText(tinyMenuItemData.menuName);
        }
        if (aUIconView != null && imageView != null) {
            if (TextUtils.isEmpty(tinyMenuItemData.iconUrl) && tinyMenuItemData.h5MenuIcon == null) {
                aUIconView.setVisibility(0);
                imageView.setVisibility(8);
                String str = this.v.get(tinyMenuItemData.mid);
                if (TextUtils.isEmpty(str)) {
                    str = this.v.get("default");
                }
                aUIconView.setIconfontFileName("iconfont");
                aUIconView.setIconfontBundle("tinyfont");
                aUIconView.setIconfontUnicode(str);
                aUIconView.setIconfontColor(Color.parseColor("#3C4550"));
                aUIconView.setIconfontSize("25dp");
            } else if (!TextUtils.isEmpty(tinyMenuItemData.iconUrl)) {
                aUIconView.setVisibility(4);
                imageView.setVisibility(0);
                ImageUtils.loadImage(tinyMenuItemData.iconUrl, new TinyAppImageLoader(imageView));
            } else if (tinyMenuItemData.h5MenuIcon != null) {
                aUIconView.setVisibility(4);
                imageView.setVisibility(0);
                imageView.setImageDrawable(tinyMenuItemData.h5MenuIcon);
            }
        }
        if (TinyBlurMenu.MESSAGE_ID.equals(tinyMenuItemData.getMid())) {
            long j = tinyMenuItemData.latestMsgTime;
            if (aUBadgeView != null) {
                try {
                    String userId = GriverAccount.getUserId();
                    if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(this.e)) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(userId);
                    sb.append("_");
                    sb.append(this.e);
                    sb.append("_messageLatestClickTime");
                    String obj = sb.toString();
                    SharedPreferences a2 = a(GriverEnv.getApplicationContext(), userId, this.e);
                    String string = a2 != null ? a2.getString(obj, "") : "";
                    if ((!TextUtils.isEmpty(string) ? Long.parseLong(string) : 0L) < j && j >= 0) {
                        if (tinyMenuItemData.badgeType > 0) {
                            if (tinyMenuItemData.badgeType == 1) {
                                if (tinyMenuItemData.messageCount > 0) {
                                    aUBadgeView.setVisibility(0);
                                    aUBadgeView.setStyleAndContent(AUBadgeView.Style.NUM, "");
                                    aUBadgeView.setMsgCount(tinyMenuItemData.messageCount, true);
                                    aUBadgeView.setMaxLines(1);
                                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aUBadgeView.getLayoutParams();
                                    if (layoutParams != null) {
                                        layoutParams.setMargins(Math.round(this.f6732a * 36.5f), Math.round(this.f6732a * 1.0f), 0, 0);
                                        aUBadgeView.setLayoutParams(layoutParams);
                                        return;
                                    }
                                    return;
                                }
                                aUBadgeView.setVisibility(8);
                                return;
                            } else if (tinyMenuItemData.badgeType == 2) {
                                if (tinyMenuItemData.messageCount > 0) {
                                    aUBadgeView.setVisibility(0);
                                    aUBadgeView.setStyleAndContent(AUBadgeView.Style.POINT, "");
                                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aUBadgeView.getLayoutParams();
                                    if (layoutParams2 != null) {
                                        layoutParams2.setMargins(Math.round(this.f6732a * 40.5f), Math.round(this.f6732a * 7.5f), 0, 0);
                                        aUBadgeView.setLayoutParams(layoutParams2);
                                        return;
                                    }
                                    return;
                                }
                                aUBadgeView.setVisibility(8);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    aUBadgeView.setVisibility(8);
                } catch (Throwable th) {
                    RVLogger.e("TinyMenuPopupWindow", th);
                }
            }
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void updateCornerMarking(List<CornerMarkingData> list) {
        this.D.setDataProvider(list);
        this.D.syncCornerMarkingDataToUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TinyMenuItemData tinyMenuItemData) {
        try {
            if (this.f == null) {
                return;
            }
            String format = String.format("javascript:(function(){function tinyApp_presetPopMenu_ready(callback){if(window.AlipayJSBridge){callback&&callback();}else{document.addEventListener('AlipayJSBridgeReady',callback,false);}}tinyApp_presetPopMenu_ready(AlipayJSBridge.call('%s', %s, %s));})();", tinyMenuItemData.getAction(), tinyMenuItemData.getParams(), tinyMenuItemData.getCallback());
            StringBuilder sb = new StringBuilder();
            sb.append("generateNativeJsApiInvoke finalInvoke ");
            sb.append(format);
            RVLogger.d("TinyMenuPopupWindow", sb.toString());
        } catch (Throwable th) {
            RVLogger.e("TinyMenuPopupWindow", th);
        }
    }

    public void doDismissWithAnimation(boolean z, final View view) {
        Context context;
        this.z = true;
        if (this.mMenuContent != null && (context = this.mContext) != null && z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(context, getDismissAnimationId());
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.9
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (TinyMenuPopupWindow.this.f6733o != null) {
                                    TinyMenuPopupWindow.this.f6733o.onClick(TinyMenuPopupWindow.this.D.interceptClickEventForCornerMarking(view) ? null : view);
                                }
                                TinyMenuPopupWindow.this.dismiss();
                            } catch (Throwable th) {
                                RVLogger.e("TinyMenuPopupWindow", th);
                            }
                        }
                    });
                }
            });
            this.mMenuContent.startAnimation(loadAnimation);
            return;
        }
        try {
            dismiss();
        } catch (Throwable th) {
            RVLogger.e("TinyMenuPopupWindow", th);
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void doDismissWithAnimation(boolean z) {
        doDismissWithAnimation(z, null);
    }

    protected void initWindowManagerLayoutParams(WindowManager.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 48;
        layoutParams.dimAmount = 0.4f;
    }

    protected int getLayoutId() {
        return R.layout.griver_ui_menu_layout_xml;
    }

    protected TinyMenuBgDrawable createTinyMenuBackground(Bitmap bitmap) {
        int statusBarHeight = StatusBarUtils.getStatusBarHeight(getContext());
        return new TinyMenuBgDrawable(bitmap, 0, statusBarHeight, bitmap.getWidth(), this.y + statusBarHeight, 0, 0, bitmap.getWidth(), this.y);
    }

    protected int getShowAnimationId() {
        return R.anim.griver_ui_menu_in;
    }

    protected int getDismissAnimationId() {
        return R.anim.griver_ui_menu_out;
    }

    /* loaded from: classes6.dex */
    static class ViewHolder {
        ImageView appIcon;
        TextView appName;
        AUIconView fontIcon;
        View parent;

        private ViewHolder() {
        }
    }

    /* loaded from: classes6.dex */
    public class TinyAppImageLoader implements ImageListener {

        /* renamed from: a  reason: collision with root package name */
        private ImageView f6735a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TinyAppImageLoader(ImageView imageView) {
            this.f6735a = imageView;
        }

        @Override // com.alibaba.griver.base.common.adapter.ImageListener
        public void onImage(Bitmap bitmap) {
            ImageView imageView = this.f6735a;
            if (imageView == null || bitmap == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class CornerMarkingUIController {

        /* renamed from: a  reason: collision with root package name */
        private List<CornerMarkingData> f6734a;

        private CornerMarkingUIController() {
        }

        public void setDataProvider(List<CornerMarkingData> list) {
            this.f6734a = list;
        }

        public void syncCornerMarkingDataToUI() {
            View view;
            String str;
            List<CornerMarkingData> list = this.f6734a;
            if (list == null || list.size() == 0) {
                return;
            }
            for (CornerMarkingData cornerMarkingData : this.f6734a) {
                String str2 = cornerMarkingData.mid;
                if (!TextUtils.isEmpty(str2) && (view = (View) TinyMenuPopupWindow.this.w.get(str2)) != null) {
                    AUBadgeView aUBadgeView = (AUBadgeView) view.findViewById(R.id.menu_item_badge);
                    if (aUBadgeView != null) {
                        aUBadgeView.setVisibility(8);
                    }
                    AUBubbleView aUBubbleView = (AUBubbleView) view.findViewById(R.id.menu_item_corner_marking);
                    if (aUBubbleView != null) {
                        aUBubbleView.setVisibility(0);
                        aUBubbleView.setTag(cornerMarkingData);
                        if (TextUtils.isEmpty(cornerMarkingData.superscript) || cornerMarkingData.superscript.length() <= 5) {
                            str = cornerMarkingData.superscript;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append(cornerMarkingData.superscript.substring(0, 4));
                            sb.append("...");
                            str = sb.toString();
                        }
                        aUBubbleView.setText(str);
                    }
                }
            }
        }

        public boolean interceptClickEventForCornerMarking(View view) {
            AUBubbleView aUBubbleView;
            if (view == null || (aUBubbleView = (AUBubbleView) view.findViewById(R.id.menu_item_corner_marking)) == null || !(aUBubbleView.getTag() instanceof CornerMarkingData)) {
                return false;
            }
            CornerMarkingData cornerMarkingData = (CornerMarkingData) aUBubbleView.getTag();
            String appId = TinyMenuPopupWindow.this.f.getApp().getAppId();
            if (TextUtils.isEmpty(appId)) {
                return false;
            }
            RVLogger.d("TinyMenuPopupWindow", "intercept click event for corner marking");
            List<CornerMarkingData> list = this.f6734a;
            if (list != null) {
                list.remove(cornerMarkingData);
            }
            new CornerMarkingDataProvider().click(appId, cornerMarkingData.noticeId);
            RVLogger.d("TinyMenuPopupWindow", cornerMarkingData.toJavaScript());
            aUBubbleView.setTag(null);
            if (view.getTag() instanceof Integer) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (TinyMenuPopupWindow.this.b == null || intValue < 0 || intValue >= TinyMenuPopupWindow.this.b.size()) {
                    return true;
                }
                TinyMenuPopupWindow tinyMenuPopupWindow = TinyMenuPopupWindow.this;
                tinyMenuPopupWindow.a((TinyMenuItemData) tinyMenuPopupWindow.b.get(intValue), view);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes6.dex */
    class FavoriteAndRecentAppAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        private FavoriteAndRecentAppAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (TinyMenuPopupWindow.this.mRecentUseList != null) {
                return TinyMenuPopupWindow.this.mRecentUseList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (TinyMenuPopupWindow.this.mRecentUseList == null || i >= TinyMenuPopupWindow.this.mRecentUseList.size()) {
                return null;
            }
            return TinyMenuPopupWindow.this.mRecentUseList.get(i);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            TinyMenuFunctionModel tinyMenuFunctionModel = (TinyMenuFunctionModel) getItem(i);
            if (tinyMenuFunctionModel != null) {
                return tinyMenuFunctionModel.functionType;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            final TinyMenuFunctionModel tinyMenuFunctionModel = (TinyMenuFunctionModel) getItem(i);
            if (tinyMenuFunctionModel == null) {
                return null;
            }
            if (view == null) {
                int i2 = (int) (TinyMenuPopupWindow.this.f6732a * 45.0f);
                LinearLayout linearLayout = new LinearLayout(TinyMenuPopupWindow.this.mContext);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new AUHorizontalListView.LayoutParams(TinyMenuPopupWindow.this.mRecentTinyAppItemWidth, -1));
                linearLayout.setGravity(17);
                ViewHolder viewHolder = new ViewHolder();
                linearLayout.setTag(viewHolder);
                if (tinyMenuFunctionModel == null || !tinyMenuFunctionModel.fillingMark) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
                    if (tinyMenuFunctionModel.functionType == 0) {
                        TinyRoundImageView tinyRoundImageView = new TinyRoundImageView(TinyMenuPopupWindow.this.mContext);
                        layoutParams.gravity = 17;
                        tinyRoundImageView.setRadius(DensityUtil.dip2px(TinyMenuPopupWindow.this.mContext, 7.0f));
                        tinyRoundImageView.setLayoutParams(layoutParams);
                        if (tinyMenuFunctionModel != null) {
                            ImageUtils.loadImage(tinyMenuFunctionModel.iconUrl, new TinyAppImageLoader(tinyRoundImageView));
                        }
                        linearLayout.addView(tinyRoundImageView);
                        viewHolder.appIcon = tinyRoundImageView;
                    } else if (tinyMenuFunctionModel.functionType == 1) {
                        AUIconView aUIconView = new AUIconView(TinyMenuPopupWindow.this.mContext);
                        Resources resources = TinyMenuPopupWindow.this.mContext.getResources();
                        if (resources != null) {
                            String string = resources.getString(R.string.griver_ui_more_recent_app_back_to_tiny_home);
                            aUIconView.setIconfontFileName("iconfont");
                            aUIconView.setIconfontBundle("tinyfont");
                            aUIconView.setIconfontUnicode(string);
                            aUIconView.setIconfontColor(Color.parseColor("#9da2a7"));
                            aUIconView.setLayoutParams(layoutParams);
                            aUIconView.setIconfontSize("25dp");
                            aUIconView.setBackgroundResource(R.drawable.griver_ui_recent_app_more_bg);
                        }
                        linearLayout.addView(aUIconView);
                        viewHolder.fontIcon = aUIconView;
                    }
                    TextView textView = new TextView(TinyMenuPopupWindow.this.mContext);
                    if (tinyMenuFunctionModel != null) {
                        textView.setText(tinyMenuFunctionModel.name);
                    }
                    textView.setTextSize(12.0f);
                    textView.setGravity(17);
                    textView.setSingleLine(true);
                    textView.setTextColor(Color.parseColor("#3C4550"));
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.gravity = 17;
                    layoutParams2.setMargins(6, 20, 6, 0);
                    linearLayout.addView(textView, layoutParams2);
                    viewHolder.appName = textView;
                    viewHolder.parent = linearLayout;
                    linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.FavoriteAndRecentAppAdapter.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TinyMenuFunctionModel tinyMenuFunctionModel2 = tinyMenuFunctionModel;
                            if (tinyMenuFunctionModel2 != null) {
                                if (tinyMenuFunctionModel2.functionType == 0) {
                                    TinyMenuPopupWindow.this.startTinyAppAndCloseCurrent(tinyMenuFunctionModel.appId);
                                } else if (tinyMenuFunctionModel.functionType == 1) {
                                    TinyMenuPopupWindow.this.startRecentTinyApp();
                                }
                            }
                            if (TinyMenuPopupWindow.this.z) {
                                return;
                            }
                            TinyMenuPopupWindow.this.doDismissWithAnimation(true);
                        }
                    });
                    return linearLayout;
                }
                return linearLayout;
            }
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
            if (viewHolder2 == null || viewHolder2.appName == null) {
                return view;
            }
            if (tinyMenuFunctionModel != null && tinyMenuFunctionModel.fillingMark) {
                viewHolder2.appName.setText((CharSequence) null);
                if (viewHolder2.appIcon != null) {
                    viewHolder2.appIcon.setImageBitmap(null);
                }
                return view;
            }
            if (tinyMenuFunctionModel != null) {
                viewHolder2.appName.setText(tinyMenuFunctionModel.name);
            }
            if (viewHolder2.appIcon != null) {
                viewHolder2.appIcon.setImageBitmap(null);
            }
            if (tinyMenuFunctionModel != null && viewHolder2.appIcon != null) {
                ImageUtils.loadImage(tinyMenuFunctionModel.iconUrl, new TinyAppImageLoader(viewHolder2.appIcon));
            }
            if (viewHolder2.parent != null) {
                viewHolder2.parent.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow.FavoriteAndRecentAppAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (tinyMenuFunctionModel.functionType == 0) {
                            TinyMenuPopupWindow.this.startTinyAppAndCloseCurrent(tinyMenuFunctionModel.appId);
                        } else if (tinyMenuFunctionModel.functionType == 1) {
                            TinyMenuPopupWindow.this.startRecentTinyApp();
                        }
                        if (TinyMenuPopupWindow.this.z) {
                            return;
                        }
                        TinyMenuPopupWindow.this.doDismissWithAnimation(true);
                    }
                });
                return view;
            }
            return view;
        }
    }
}
