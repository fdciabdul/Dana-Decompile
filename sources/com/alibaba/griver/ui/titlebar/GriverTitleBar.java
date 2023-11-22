package com.alibaba.griver.ui.titlebar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.model.ScrollChangedCallback;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.ImageUtil;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.api.common.menu.GRVMPMoreMenuItemPriority;
import com.alibaba.griver.api.common.menu.GriverACMenuExtension;
import com.alibaba.griver.api.common.menu.GriverBaseMenuItem;
import com.alibaba.griver.api.common.menu.GriverMenuExtension;
import com.alibaba.griver.api.common.menu.GriverMenuItem;
import com.alibaba.griver.api.common.menu.OnMenuItemClickListener;
import com.alibaba.griver.api.ui.optionmenu.GriverOptionMenuPanelExtension;
import com.alibaba.griver.api.ui.titlebar.GVTitleBar;
import com.alibaba.griver.base.common.adapter.ImageListener;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.H5UrlHelper;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.core.jsapi.actionsheet.ActionSheetItem;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.popmenu.H5TinyPopMenu;
import com.alibaba.griver.ui.titlebar.NebulaTitleView;
import com.alibaba.griver.ui.titlebar.TitleView;
import com.alibaba.griver.ui.utils.ColorUtils;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import o.A;

/* loaded from: classes6.dex */
public class GriverTitleBar implements GVTitleBar {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    public static final String LONG_NAV_SEARCH_BAR_TYPE = "navSearchBar_type";
    public static final String LONG_SEG_COLOR_ACTIVE = "segColorActive";
    public static final String LONG_SEG_COLOR_NORMAL = "segColorNormal";
    public static final String LONG_SEG_SELECTED_INDEX = "segSelectedIndex";
    public static final String LONG_SEG_TITLES = "segTitles";
    public static final String LONG_SEG_WIDTHS = "segWidths";
    public static final String LONG_TRANSPARENT_TITLE = "transparentTitle";
    private static final int MAX_DEVELOPER_MENU = 3;
    private static int MyBillsEntityDataFactory = 0;
    private static final String TAG = "GriverTitleBar";
    private static final String TRANSPARENT_ALWAYS = "always";
    private static int getAuthRequestContext = 1;
    private static final Map<String, Integer> iconFontMap;
    private static final int mDefaultTitleBarColor = -1;
    private static final float mUnit = 0.75f;
    private float alpha;
    private String appId;
    private int delayDy;
    private int finalMaxScrollHeight;
    private ColorDrawable mContentBgDrawable;
    private View mContentView;
    private Context mContext;
    protected NebulaTitleView.Theme mCurrentTheme;
    private String mDefaultTitle;
    private View mDivider;
    private String[] mIconType;
    private boolean mIsTinyApp;
    private Page mPage;
    private NebulaPopMenu mPopMenu;
    private H5TinyPopMenu mTinyPopMenu;
    private NebulaTitleView mTitleView;
    private NebulaPopMenu mToolbarMenu;
    private boolean mTransTitle;
    private boolean readTitle;
    private int switchThemePoint;
    private String version;
    private Map<Integer, Bitmap> iconFontMapCache = new HashMap();
    private String transparentTitle = "";
    private boolean mOptionMenuPreventDefault = false;
    private boolean mIsPageFinished = false;
    private boolean isPageError = false;
    private boolean mUseSearch = false;
    private boolean preventScrollTrans = false;
    private int finalScale = 1;
    private boolean isSwitchMode = false;
    private boolean scrollWithTitleText = false;
    private boolean preventSetTitleColor = false;
    private boolean mIgnorePageTitleFromCallbacks = false;
    private boolean mIfImageTitle = false;
    private boolean mPageStarted = false;

    static void BuiltInFictitiousFunctionClassFactory() {
        MyBillsEntityDataFactory = 269894657;
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public void onPageResume() {
        int i = getAuthRequestContext + 119;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
    }

    static /* synthetic */ int access$000(GriverTitleBar griverTitleBar) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        int i3 = griverTitleBar.delayDy;
        int i4 = getAuthRequestContext + 111;
        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
        if ((i4 % 2 != 0 ? (char) 17 : JSONLexer.EOI) != 26) {
            int i5 = 62 / 0;
            return i3;
        }
        return i3;
    }

    static /* synthetic */ int access$002(GriverTitleBar griverTitleBar, int i) {
        int i2 = getAuthRequestContext + 29;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        boolean z = i2 % 2 == 0;
        griverTitleBar.delayDy = i;
        if (!z) {
            Object obj = null;
            obj.hashCode();
        }
        int i3 = getAuthRequestContext + 85;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return i;
    }

    static /* synthetic */ int access$100(GriverTitleBar griverTitleBar) {
        try {
            int i = getAuthRequestContext + 89;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            int i3 = griverTitleBar.finalMaxScrollHeight;
            try {
                int i4 = getAuthRequestContext + 97;
                KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                int i5 = i4 % 2;
                return i3;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ int access$200(GriverTitleBar griverTitleBar) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
        getAuthRequestContext = i % 128;
        if (!(i % 2 == 0)) {
            return griverTitleBar.finalScale;
        }
        int i2 = griverTitleBar.finalScale;
        Object obj = null;
        obj.hashCode();
        return i2;
    }

    static /* synthetic */ void access$300(GriverTitleBar griverTitleBar, int i, int i2, boolean z) {
        try {
            int i3 = getAuthRequestContext + 79;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            boolean z2 = i3 % 2 != 0;
            griverTitleBar.calAlphaValue(i, i2, z);
            if (z2) {
                int i4 = 79 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ ColorDrawable access$400(GriverTitleBar griverTitleBar) {
        try {
            int i = getAuthRequestContext + 67;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            boolean z = i % 2 == 0;
            ColorDrawable colorDrawable = griverTitleBar.mContentBgDrawable;
            if (!z) {
                int i2 = 39 / 0;
            }
            int i3 = getAuthRequestContext + 87;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (i3 % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
                return colorDrawable;
            }
            return colorDrawable;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void access$500(GriverTitleBar griverTitleBar, int i, int i2, boolean z) {
        int i3 = getAuthRequestContext + 101;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        boolean z2 = i3 % 2 != 0;
        griverTitleBar.switchTheme(i, i2, z);
        if (z2) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
        getAuthRequestContext = i4 % 128;
        int i5 = i4 % 2;
    }

    static /* synthetic */ NebulaTitleView access$600(GriverTitleBar griverTitleBar) {
        int i = getAuthRequestContext + 63;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? '`' : (char) 6) == 6) {
            try {
                return griverTitleBar.mTitleView;
            } catch (Exception e) {
                throw e;
            }
        }
        NebulaTitleView nebulaTitleView = griverTitleBar.mTitleView;
        Object obj = null;
        obj.hashCode();
        return nebulaTitleView;
    }

    static /* synthetic */ Page access$700(GriverTitleBar griverTitleBar) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Page page = griverTitleBar.mPage;
        int i3 = getAuthRequestContext + 41;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 27 : '1') != '1') {
            int i4 = 82 / 0;
            return page;
        }
        return page;
    }

    static /* synthetic */ void access$800(GriverTitleBar griverTitleBar, Bitmap bitmap, int i) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        griverTitleBar.setOptionImage(bitmap, i);
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
        getAuthRequestContext = i4 % 128;
        if (i4 % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        HashMap hashMap = new HashMap();
        iconFontMap = hashMap;
        hashMap.put("user", Integer.valueOf(R.drawable.griver_ui_userw));
        hashMap.put("info", Integer.valueOf(R.drawable.griver_ui_infow));
        hashMap.put("locate", Integer.valueOf(R.drawable.griver_ui_locatew));
        hashMap.put(ZolozEkycH5Handler.HUMMER_FOUNDATION_ADD, Integer.valueOf(R.drawable.griver_ui_plusw));
        hashMap.put("scan", Integer.valueOf(R.drawable.griver_ui_richscanw));
        hashMap.put("search", Integer.valueOf(R.drawable.griver_ui_searchw));
        hashMap.put("settings", Integer.valueOf(R.drawable.griver_ui_settingsw));
        Object[] objArr = new Object[1];
        a(new char[]{65534, 6, 2, 65531}, 142 - (ViewConfiguration.getScrollBarSize() >> 8), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 4, true, Color.green(0) + 1, objArr);
        hashMap.put(((String) objArr[0]).intern(), Integer.valueOf(R.drawable.griver_ui_helpw));
        hashMap.put("filter", Integer.valueOf(R.drawable.griver_ui_filterw));
        hashMap.put("mail", Integer.valueOf(R.drawable.griver_ui_mailw));
        hashMap.put("share", Integer.valueOf(R.drawable.griver_ui_sharew));
        hashMap.put(ActionSheetItem.BadgeInfo.TYPE_MORE, Integer.valueOf(R.drawable.griver_ui_white_titlebar_more_normal));
        int i = getAuthRequestContext + 65;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
    }

    public GriverTitleBar(Context context) {
        this.mContext = context;
        if (this.mTitleView == null) {
            this.mTitleView = new NebulaTitleView(context);
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
        }
        try {
            try {
                this.mDivider = this.mTitleView.getDivider();
                View contentView = this.mTitleView.getContentView();
                this.mContentView = contentView;
                contentView.setTag("h5_titlebar");
                this.mContentBgDrawable = this.mTitleView.getContentBackgroundView();
                this.mTitleView.setOptionType(TitleView.OptionType.MENU, 0, true);
                this.mTitleView.showCloseButton(false);
                this.mToolbarMenu = new NebulaPopMenu(context);
                this.mPopMenu = new NebulaPopMenu(context);
                int i3 = getAuthRequestContext + 43;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x010a, code lost:
    
        if ((r0) != true) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0119, code lost:
    
        if ((!r0 ? '\t' : kotlin.text.Typography.amp) != '&') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01da, code lost:
    
        if (r0 != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01eb, code lost:
    
        if ((r0.isTabPage(r18.mPage)) != true) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01ef, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0206, code lost:
    
        if (r0 != false) goto L95;
     */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0371 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x025e  */
    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachPage(com.alibaba.ariver.app.api.Page r19) {
        /*
            Method dump skipped, instructions count: 942
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.GriverTitleBar.attachPage(com.alibaba.ariver.app.api.Page):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if ((r0 != null) != true) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        if (r0.containsKey("transparentTitle") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        r2 = com.alibaba.ariver.kernel.common.utils.BundleUtils.getString(r0, "transparentTitle");
        r8.transparentTitle = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
    
        if (android.text.TextUtils.isEmpty(r2) != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
    
        if (android.text.TextUtils.equals("always", r8.transparentTitle) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
    
        r2 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext + 19;
        com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
    
        if ((r2 % 2) == 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        r2 = android.text.TextUtils.equals("auto", r8.transparentTitle);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0065, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (r2 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0073, code lost:
    
        if (android.text.TextUtils.equals("auto", r8.transparentTitle) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007d, code lost:
    
        if (android.text.TextUtils.equals(io.reactivex.annotations.SchedulerSupport.CUSTOM, r8.transparentTitle) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007f, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0081, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
    
        r8.mTransTitle = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        if (r0 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void applyTransparentTitle() {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.GriverTitleBar.applyTransparentTitle():void");
    }

    private void transparentTitleBar(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!(!TextUtils.equals(str, "auto"))) {
            int i = BundleUtils.getInt(bundle, RVParams.LONG_TITLE_SCROLLDISTANCE);
            this.finalMaxScrollHeight = i;
            int i2 = i / 255;
            if (i2 != 0) {
                int i3 = getAuthRequestContext + 51;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    int i4 = 94 / 0;
                }
            } else {
                i2 = 1;
            }
            this.finalScale = i2;
            this.switchThemePoint = (int) (i * mUnit);
            StringBuilder sb = new StringBuilder();
            sb.append("transparentTitleBar finalMaxScrollHeight is ");
            sb.append(this.finalMaxScrollHeight);
            sb.append(", switchThemePoint is ");
            sb.append(this.switchThemePoint);
            RVLogger.d(TAG, sb.toString());
            this.preventScrollTrans = false;
            calAlphaValue(this.finalMaxScrollHeight, this.finalScale, false);
            this.delayDy = this.mPage.getRender().getScrollY();
            this.scrollWithTitleText = "YES".equalsIgnoreCase(BundleUtils.getString(bundle, RVParams.LONG_TRANSPARENT_TITLE_TEXTAUTO));
            this.mPage.getRender().setScrollChangedCallback(new ScrollChangedCallback() { // from class: com.alibaba.griver.ui.titlebar.GriverTitleBar.1
                @Override // com.alibaba.ariver.engine.api.bridge.model.ScrollChangedCallback
                public void onScroll(int i5, int i6) {
                    GriverTitleBar griverTitleBar = GriverTitleBar.this;
                    GriverTitleBar.access$002(griverTitleBar, GriverTitleBar.access$000(griverTitleBar) + i6);
                    GriverTitleBar griverTitleBar2 = GriverTitleBar.this;
                    GriverTitleBar.access$300(griverTitleBar2, GriverTitleBar.access$100(griverTitleBar2), GriverTitleBar.access$200(GriverTitleBar.this), true);
                    int color = GriverTitleBar.access$400(GriverTitleBar.this).getColor();
                    GriverTitleBar griverTitleBar3 = GriverTitleBar.this;
                    GriverTitleBar.access$500(griverTitleBar3, color | (-16777216), GriverTitleBar.access$100(griverTitleBar3), true);
                }
            });
        } else {
            this.alpha = 0.0f;
            this.preventScrollTrans = true;
            this.scrollWithTitleText = false;
        }
        setTitleAlpha();
        setTitleElementsColor(bundle);
        if (("YES".equalsIgnoreCase(BundleUtils.getString(bundle, RVParams.LONG_TITLE_PENETRATE, "NO")) ? '\t' : '@') == '\t') {
            try {
                NebulaTitleView nebulaTitleView = this.mTitleView;
                if ((nebulaTitleView != null ? (char) 18 : '9') == 18) {
                    try {
                        View contentView = nebulaTitleView.getContentView();
                        if (!(!(contentView instanceof H5TitleBarFrameLayout))) {
                            ((H5TitleBarFrameLayout) contentView).setPreventTouchEvent(false);
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
        getAuthRequestContext = i5 % 128;
        int i6 = i5 % 2;
    }

    private void setTitleElementsColor(Bundle bundle) {
        int i = BundleUtils.getInt(bundle, "backButtonColor");
        if (i != 0) {
            this.mTitleView.setBackButtonColor(i | (-16777216));
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 87;
            getAuthRequestContext = i2 % 128;
            int i3 = i2 % 2;
        }
        int i4 = BundleUtils.getInt(bundle, "closeButtonColor");
        if (i4 != 0) {
            this.mTitleView.setCloseButtonColor(i4 | (-16777216));
        }
        int i5 = BundleUtils.getInt(bundle, "optionMenuColor");
        if (i5 != 0) {
            this.mTitleView.setOptionMenuColor(i5);
            H5TinyPopMenu h5TinyPopMenu = this.mTinyPopMenu;
            if (h5TinyPopMenu != null) {
                int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
                getAuthRequestContext = i6 % 128;
                int i7 = i6 % 2;
                h5TinyPopMenu.onSwitchToCustomTheme(i5 | (-16777216));
            }
        }
        int i8 = BundleUtils.getInt(bundle, "titleColor");
        if ((i8 != 0 ? (char) 28 : 'B') != 28) {
            return;
        }
        this.mTitleView.setTitleTextColor(i8 | (-16777216));
    }

    private void switchTheme(int i, int i2, boolean z) {
        int scrollY;
        int i3;
        int i4;
        NebulaTitleView nebulaTitleView;
        int i5 = getAuthRequestContext + 63;
        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
        int i6 = i5 % 2;
        Page page = this.mPage;
        if (page == null) {
            return;
        }
        if (z) {
            int i7 = getAuthRequestContext + 89;
            KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
            if (i7 % 2 != 0) {
                scrollY = this.delayDy;
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                scrollY = this.delayDy;
            }
        } else {
            scrollY = page.getRender().getScrollY();
        }
        if (this.preventScrollTrans) {
            return;
        }
        if ((Math.abs(scrollY) >= i2 ? ',' : '=') == ',') {
            if (BundleUtils.contains(this.mPage.getStartParams(), "autoTransparentTitleSlideThemeColor")) {
                i3 = BundleUtils.getInt(this.mPage.getStartParams(), "autoTransparentTitleSlideThemeColor");
                i4 = i3 | (-16777216);
            }
            i4 = 0;
        } else {
            if ((BundleUtils.contains(this.mPage.getStartParams(), "autoTransparentTitleInitThemeColor") ? '1' : '3') == '1') {
                i3 = BundleUtils.getInt(this.mPage.getStartParams(), "autoTransparentTitleInitThemeColor");
                i4 = i3 | (-16777216);
            }
            i4 = 0;
        }
        switchTheme(i);
        setTitleElementsColor(this.mPage.getStartParams());
        this.mContentBgDrawable.setAlpha((int) (this.alpha * 255.0f));
        this.mDivider.setAlpha(this.alpha);
        if ((this.scrollWithTitleText ? 'N' : 'U') == 'N' && (nebulaTitleView = this.mTitleView) != null) {
            TextView mainTitleView = nebulaTitleView.getMainTitleView();
            if (mainTitleView != null) {
                int i8 = getAuthRequestContext + 115;
                KClassImpl$Data$declaredNonStaticMembers$2 = i8 % 128;
                int i9 = i8 % 2;
                mainTitleView.setAlpha(this.alpha);
            }
            TextView subTitleView = this.mTitleView.getSubTitleView();
            if (subTitleView != null) {
                int i10 = getAuthRequestContext + 47;
                KClassImpl$Data$declaredNonStaticMembers$2 = i10 % 128;
                int i11 = i10 % 2;
                subTitleView.setAlpha(this.alpha);
            }
        }
        if (i4 != 0) {
            switchCustomTheme(i4);
        }
    }

    private boolean needTinyPopMenu(Page page) {
        AppModel appModel;
        if ((page == null ? '\b' : 'V') == 'V') {
            Bundle startParams = page.getStartParams();
            if ((startParams != null ? '-' : 'J') != 'J') {
                int i = getAuthRequestContext + 117;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                if (("NO".equalsIgnoreCase(startParams.getString("usePresetPopmenu")) ? (char) 2 : '(') == '(' && (appModel = (AppModel) page.getApp().getData(AppModel.class)) != null) {
                    return "YES".equalsIgnoreCase(JSONUtils.getString(appModel.getExtendInfos(), "usePresetPopmenu"));
                }
            }
            return false;
        }
        int i3 = getAuthRequestContext + 97;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        return i3 % 2 != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:
    
        if ((!r6) != true) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0022, code lost:
    
        r6 = r3.delayDy;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0025, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0027, code lost:
    
        r6 = r3.mPage.getRender().getScrollY();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
    
        if (java.lang.Math.abs(r6) < r4) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0037, code lost:
    
        r4 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext + 47;
        com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        if ((r4 % 2) == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
    
        if (r1 == true) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
    
        if (r6 > 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0049, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004a, code lost:
    
        r4 = r4.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004b, code lost:
    
        if (r6 > 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
    
        r3.alpha = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0050, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0053, code lost:
    
        r3.alpha = 1.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0055, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0056, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0059, code lost:
    
        r3.alpha = java.lang.Math.abs(r6 / r5) / 255.0f;
        r4 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext + 33;
        com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r6 != false) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void calAlphaValue(int r4, int r5, boolean r6) {
        /*
            r3 = this;
            int r0 = com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 53
            int r1 = r0 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L1b
            r0 = 76
            int r0 = r0 / r1
            if (r6 == 0) goto L27
            goto L22
        L19:
            r4 = move-exception
            throw r4
        L1b:
            if (r6 == 0) goto L1f
            r6 = 0
            goto L20
        L1f:
            r6 = 1
        L20:
            if (r6 == r2) goto L27
        L22:
            int r6 = r3.delayDy     // Catch: java.lang.Exception -> L25
            goto L31
        L25:
            r4 = move-exception
            goto L56
        L27:
            com.alibaba.ariver.app.api.Page r6 = r3.mPage
            com.alibaba.ariver.engine.api.Render r6 = r6.getRender()
            int r6 = r6.getScrollY()
        L31:
            int r0 = java.lang.Math.abs(r6)
            if (r0 < r4) goto L59
            int r4 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext
            int r4 = r4 + 47
            int r5 = r4 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L44
            r1 = 1
        L44:
            if (r1 == r2) goto L49
            if (r6 > 0) goto L51
            goto L4d
        L49:
            r4 = 0
            int r4 = r4.length     // Catch: java.lang.Throwable -> L57
            if (r6 > 0) goto L51
        L4d:
            r4 = 0
            r3.alpha = r4
            return
        L51:
            r4 = 1065353216(0x3f800000, float:1.0)
            r3.alpha = r4     // Catch: java.lang.Exception -> L25
            return
        L56:
            throw r4
        L57:
            r4 = move-exception
            throw r4
        L59:
            int r6 = r6 / r5
            int r4 = java.lang.Math.abs(r6)
            float r4 = (float) r4
            r5 = 1132396544(0x437f0000, float:255.0)
            float r4 = r4 / r5
            r3.alpha = r4
            int r4 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext
            int r4 = r4 + 33
            int r5 = r4 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            int r4 = r4 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.GriverTitleBar.calAlphaValue(int, int, boolean):void");
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public View getContent() {
        View view;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
        getAuthRequestContext = i % 128;
        try {
            if ((i % 2 == 0 ? 'Z' : '/') != 'Z') {
                view = this.mContentView;
            } else {
                view = this.mContentView;
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
            getAuthRequestContext = i2 % 128;
            int i3 = i2 % 2;
            return view;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public void onDestroy() {
        Object[] objArr = null;
        try {
            this.mPage = null;
            NebulaTitleView nebulaTitleView = this.mTitleView;
            if (nebulaTitleView != null) {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
                getAuthRequestContext = i % 128;
                if ((i % 2 == 0 ? (char) 6 : 'G') != 6) {
                    nebulaTitleView.releaseViewList();
                } else {
                    nebulaTitleView.releaseViewList();
                    int length = objArr.length;
                }
            }
            H5TinyPopMenu h5TinyPopMenu = this.mTinyPopMenu;
            if ((h5TinyPopMenu != null ? (char) 14 : (char) 4) != 4) {
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 71;
                getAuthRequestContext = i2 % 128;
                int i3 = i2 % 2;
                try {
                    h5TinyPopMenu.onRelease();
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void showTitleBar(boolean z) {
        int i;
        int i2 = getAuthRequestContext + 57;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        View view = this.mContentView;
        if ((z ? (char) 11 : '\r') != 11) {
            i = 8;
        } else {
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
            getAuthRequestContext = i4 % 128;
            int i5 = i4 % 2;
            i = 0;
        }
        view.setVisibility(i);
        int i6 = getAuthRequestContext + 23;
        KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
        if (!(i6 % 2 == 0)) {
            int i7 = 22 / 0;
        }
    }

    public void onReceivedTitle(String str, String str2) {
        int i = getAuthRequestContext + 55;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        setPageTitle(str2, str);
        int i3 = getAuthRequestContext + 7;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        if (r1 != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        if (android.text.TextUtils.equals(r5, r1.getPageURI()) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
    
        r6 = new java.lang.StringBuilder();
        r6.append(r5);
        r6.append(" not show");
        com.alibaba.griver.base.common.logger.GriverLogger.d(com.alibaba.griver.ui.titlebar.GriverTitleBar.TAG, r6.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setPageTitle(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            int r0 = com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 111
            int r1 = r0 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext = r1
            int r0 = r0 % 2
            java.lang.String r0 = "GriverTitleBar"
            if (r5 != 0) goto L16
            java.lang.String r5 = "case 1, page title ignored!"
            com.alibaba.griver.base.common.logger.GriverLogger.d(r0, r5)     // Catch: java.lang.Exception -> L14
            return
        L14:
            r5 = move-exception
            throw r5
        L16:
            boolean r1 = r4.readTitle
            if (r1 == 0) goto Lc1
            int r1 = com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2
            int r1 = r1 + 15
            int r2 = r1 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext = r2
            int r1 = r1 % 2
            boolean r1 = r4.mIgnorePageTitleFromCallbacks
            if (r1 != 0) goto Lc1
            boolean r1 = r4.mIfImageTitle
            if (r1 != 0) goto Lc1
            com.alibaba.ariver.app.api.Page r1 = r4.mPage
            r2 = 54
            if (r1 == 0) goto L35
            r3 = 54
            goto L37
        L35:
            r3 = 98
        L37:
            if (r3 == r2) goto L3a
            goto L76
        L3a:
            int r2 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext
            int r2 = r2 + 101
            int r3 = r2 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L57
            java.lang.String r1 = r1.getPageURI()
            boolean r1 = android.text.TextUtils.equals(r5, r1)
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L76
            goto L61
        L55:
            r5 = move-exception
            throw r5
        L57:
            java.lang.String r1 = r1.getPageURI()
            boolean r1 = android.text.TextUtils.equals(r5, r1)
            if (r1 == 0) goto L76
        L61:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = " not show"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.alibaba.griver.base.common.logger.GriverLogger.d(r0, r5)
            return
        L76:
            com.alibaba.griver.ui.titlebar.NebulaTitleView r1 = r4.mTitleView     // Catch: java.lang.IllegalArgumentException -> Lb6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.IllegalArgumentException -> Lb6
            r2.<init>()     // Catch: java.lang.IllegalArgumentException -> Lb6
            java.lang.String r3 = "http://"
            r2.append(r3)     // Catch: java.lang.IllegalArgumentException -> Lb6
            r2.append(r5)     // Catch: java.lang.IllegalArgumentException -> Lb6
            java.lang.String r2 = r2.toString()     // Catch: java.lang.IllegalArgumentException -> Lb6
            boolean r2 = r6.equals(r2)     // Catch: java.lang.IllegalArgumentException -> Lb6
            if (r2 != 0) goto Lb0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.IllegalArgumentException -> Lb6
            r2.<init>()     // Catch: java.lang.IllegalArgumentException -> Lb6
            java.lang.String r3 = "https://"
            r2.append(r3)     // Catch: java.lang.IllegalArgumentException -> Lb6
            r2.append(r5)     // Catch: java.lang.IllegalArgumentException -> Lb6
            java.lang.String r2 = r2.toString()     // Catch: java.lang.IllegalArgumentException -> Lb6
            boolean r6 = r6.equals(r2)     // Catch: java.lang.IllegalArgumentException -> Lb6
            r2 = 71
            if (r6 == 0) goto Lab
            r6 = 71
            goto Lad
        Lab:
            r6 = 20
        Lad:
            if (r6 == r2) goto Lb0
            goto Lb2
        Lb0:
            java.lang.String r5 = r4.mDefaultTitle     // Catch: java.lang.IllegalArgumentException -> Lb6
        Lb2:
            r1.setTitle(r5)     // Catch: java.lang.IllegalArgumentException -> Lb6
            return
        Lb6:
            r5 = move-exception
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r0, r5)
            com.alibaba.griver.ui.titlebar.NebulaTitleView r5 = r4.mTitleView
            java.lang.String r6 = r4.mDefaultTitle
            r5.setTitle(r6)
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.GriverTitleBar.setPageTitle(java.lang.String, java.lang.String):void");
    }

    private Bitmap createIconBitmap(int i, int i2) {
        Page page = this.mPage;
        if (!(page == null)) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            if (page.getPageContext() == null) {
                return null;
            }
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
            getAuthRequestContext = i5 % 128;
            int i6 = i5 % 2;
            Bitmap bitmap = this.iconFontMapCache.get(Integer.valueOf(i));
            if (bitmap == null) {
                int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
                getAuthRequestContext = i7 % 128;
                bitmap = i7 % 2 == 0 ? BitmapFactory.decodeResource(this.mContext.getResources(), i).copy(Bitmap.Config.ARGB_8888, false) : BitmapFactory.decodeResource(this.mContext.getResources(), i).copy(Bitmap.Config.ARGB_8888, true);
            }
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(i2 | (-16777216));
            canvas.drawBitmap(bitmap.extractAlpha(), 0.0f, 0.0f, paint);
            return bitmap;
        }
        return null;
    }

    private void setOptionImage(final Bitmap bitmap, final int i) {
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
            getAuthRequestContext = i2 % 128;
            int i3 = i2 % 2;
            if (bitmap == null) {
                return;
            }
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.titlebar.GriverTitleBar.2
                @Override // java.lang.Runnable
                public void run() {
                    GriverTitleBar.access$600(GriverTitleBar.this).setOptionType(TitleView.OptionType.ICON, i, true);
                    GriverTitleBar.access$600(GriverTitleBar.this).setButtonIcon(bitmap, i);
                }
            });
            int i4 = getAuthRequestContext + 65;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private String getDownloadImageUrl(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
            if (!(this.mPage != null)) {
                return str;
            }
        } else {
            int i2 = 32 / 0;
            if ((this.mPage != null ? '^' : 'H') != '^') {
                return str;
            }
        }
        if ((!TextUtils.isEmpty(str) ? '3' : '*') != '*') {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 13;
            getAuthRequestContext = i3 % 128;
            if ((i3 % 2 == 0 ? 'B' : '(') == 'B') {
                boolean startsWith = str.startsWith(SemanticAttributes.FaasTriggerValues.HTTP);
                Object[] objArr = null;
                int length = objArr.length;
                if (startsWith) {
                    return str;
                }
            } else if (str.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
                return str;
            }
            try {
                try {
                    String string = BundleUtils.getString(this.mPage.getStartParams(), "url");
                    if (TextUtils.isEmpty(string)) {
                        return str;
                    }
                    int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
                    getAuthRequestContext = i4 % 128;
                    int i5 = i4 % 2;
                    return UrlUtils.mergeUrl(string, str);
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
    
        if ((!r3.scrollWithTitleText) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
    
        r0 = r3.mTitleView;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r0 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
    
        r1 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext + 15;
        com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r1 % 128;
        r1 = r1 % 2;
        r0 = r0.getMainTitleView();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
    
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
    
        r1 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext + 85;
        com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r1 % 128;
        r1 = r1 % 2;
        r0.setAlpha(r3.alpha);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        r0 = r3.mTitleView.getSubTitleView();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
    
        r2 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006e, code lost:
    
        r2 = '\t';
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        if (r2 == 11) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0073, code lost:
    
        r1 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext + 29;
        com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r1 % 128;
        r1 = r1 % 2;
        r0.setAlpha(r3.alpha);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0020, code lost:
    
        if (r3.scrollWithTitleText != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setTitleAlpha() {
        /*
            r3 = this;
            int r0 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext
            int r0 = r0 + 105
            int r1 = r0 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 1132396544(0x437f0000, float:255.0)
            if (r0 == 0) goto L23
            android.graphics.drawable.ColorDrawable r0 = r3.mContentBgDrawable
            float r2 = r3.alpha
            float r2 = r2 - r1
            int r1 = (int) r2
            r0.setAlpha(r1)
            android.view.View r0 = r3.mDivider
            float r1 = r3.alpha
            r0.setAlpha(r1)
            boolean r0 = r3.scrollWithTitleText
            if (r0 == 0) goto L82
            goto L3e
        L23:
            android.graphics.drawable.ColorDrawable r0 = r3.mContentBgDrawable
            float r2 = r3.alpha
            float r2 = r2 * r1
            int r1 = (int) r2
            r0.setAlpha(r1)
            android.view.View r0 = r3.mDivider
            float r1 = r3.alpha
            r0.setAlpha(r1)
            boolean r0 = r3.scrollWithTitleText
            if (r0 == 0) goto L3a
            r0 = 0
            goto L3b
        L3a:
            r0 = 1
        L3b:
            if (r0 == 0) goto L3e
            goto L82
        L3e:
            com.alibaba.griver.ui.titlebar.NebulaTitleView r0 = r3.mTitleView
            if (r0 == 0) goto L82
            int r1 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext
            int r1 = r1 + 15
            int r2 = r1 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            android.widget.TextView r0 = r0.getMainTitleView()
            if (r0 == 0) goto L61
            int r1 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext
            int r1 = r1 + 85
            int r2 = r1 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            float r1 = r3.alpha
            r0.setAlpha(r1)
        L61:
            com.alibaba.griver.ui.titlebar.NebulaTitleView r0 = r3.mTitleView
            android.widget.TextView r0 = r0.getSubTitleView()
            r1 = 11
            if (r0 == 0) goto L6e
            r2 = 11
            goto L70
        L6e:
            r2 = 9
        L70:
            if (r2 == r1) goto L73
            goto L82
        L73:
            int r1 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext
            int r1 = r1 + 29
            int r2 = r1 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            float r1 = r3.alpha
            r0.setAlpha(r1)
        L82:
            int r0 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext
            int r0 = r0 + 103
            int r1 = r0 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L95
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L93
            return
        L93:
            r0 = move-exception
            throw r0
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.GriverTitleBar.setTitleAlpha():void");
    }

    private void setContentBackgroundViewColor(int i) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        this.mContentBgDrawable.setColor(i);
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
        getAuthRequestContext = i4 % 128;
        if (i4 % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public int getTitleColor() {
        try {
            int i = getAuthRequestContext + 7;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? '\f' : 'E') != '\f') {
                try {
                    return this.mContentBgDrawable.getColor();
                } catch (Exception e) {
                    throw e;
                }
            }
            int color = this.mContentBgDrawable.getColor();
            Object[] objArr = null;
            int length = objArr.length;
            return color;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public String getTransparentTitle() {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
            getAuthRequestContext = i % 128;
            if ((i % 2 == 0 ? '[' : '\t') != '[') {
                return this.transparentTitle;
            }
            int i2 = 84 / 0;
            return this.transparentTitle;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if ((r0 == null) != true) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:
    
        if ((r0 == null) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002a, code lost:
    
        r3 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext + 19;
        com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0036, code lost:
    
        if ((r3 % 2) == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003b, code lost:
    
        if (r3 == true) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        r2 = 90 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0040, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0043, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        return r0.getTitle();
     */
    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getTitle() {
        /*
            r5 = this;
            int r0 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext
            int r0 = r0 + 25
            int r1 = r0 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == r2) goto L21
            com.alibaba.griver.ui.titlebar.NebulaTitleView r0 = r5.mTitleView
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L1f
            if (r0 == 0) goto L1b
            r3 = 0
            goto L1c
        L1b:
            r3 = 1
        L1c:
            if (r3 == r2) goto L2a
            goto L44
        L1f:
            r0 = move-exception
            throw r0
        L21:
            com.alibaba.griver.ui.titlebar.NebulaTitleView r0 = r5.mTitleView     // Catch: java.lang.Exception -> L49
            if (r0 == 0) goto L27
            r3 = 0
            goto L28
        L27:
            r3 = 1
        L28:
            if (r3 == 0) goto L44
        L2a:
            java.lang.String r0 = ""
            int r3 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext
            int r3 = r3 + 19
            int r4 = r3 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L3a
            r3 = 0
            goto L3b
        L3a:
            r3 = 1
        L3b:
            if (r3 == r2) goto L43
            r2 = 90
            int r2 = r2 / r1
            return r0
        L41:
            r0 = move-exception
            throw r0
        L43:
            return r0
        L44:
            java.lang.String r0 = r0.getTitle()
            return r0
        L49:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.GriverTitleBar.getTitle():java.lang.String");
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public String getSubTitle() {
        NebulaTitleView nebulaTitleView;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
        getAuthRequestContext = i % 128;
        Object obj = null;
        if (i % 2 == 0) {
            nebulaTitleView = this.mTitleView;
            obj.hashCode();
            if (nebulaTitleView == null) {
                return "";
            }
        } else {
            nebulaTitleView = this.mTitleView;
            if (!(nebulaTitleView != null)) {
                return "";
            }
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        if (nebulaTitleView.getSubTitleView() != null) {
            try {
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
                try {
                    getAuthRequestContext = i4 % 128;
                    if (i4 % 2 == 0) {
                        CharSequence text = this.mTitleView.getSubTitleView().getText();
                        obj.hashCode();
                        if (text == null) {
                            return "";
                        }
                    } else {
                        if ((this.mTitleView.getSubTitleView().getText() != null ? 'F' : '=') != 'F') {
                            return "";
                        }
                    }
                    return this.mTitleView.getSubTitleView().getText().toString();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if ((!r1) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
    
        if ((r0 instanceof android.graphics.drawable.BitmapDrawable) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
    
        r1 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext + 97;
        com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        return ((android.graphics.drawable.BitmapDrawable) r0).getBitmap();
     */
    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap getImgTitle() {
        /*
            r4 = this;
            com.alibaba.griver.ui.titlebar.NebulaTitleView r0 = r4.mTitleView     // Catch: java.lang.Exception -> L5d
            r1 = 37
            if (r0 == 0) goto L9
            r2 = 37
            goto La
        L9:
            r2 = 7
        La:
            r3 = 0
            if (r2 == r1) goto Le
            goto L5c
        Le:
            int r1 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext
            int r1 = r1 + 79
            int r2 = r1 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            android.widget.ImageView r0 = r0.ivImageTitle
            if (r0 == 0) goto L5c
            int r0 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext     // Catch: java.lang.Exception -> L5d
            int r0 = r0 + 49
            int r1 = r0 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L5d
            int r0 = r0 % 2
            if (r0 == 0) goto L3f
            com.alibaba.griver.ui.titlebar.NebulaTitleView r0 = r4.mTitleView
            android.widget.ImageView r0 = r0.ivImageTitle
            android.graphics.drawable.Drawable r0 = r0.getDrawable()
            boolean r1 = r0 instanceof android.graphics.drawable.BitmapDrawable
            r3.hashCode()     // Catch: java.lang.Throwable -> L3d
            if (r1 == 0) goto L39
            r1 = 0
            goto L3a
        L39:
            r1 = 1
        L3a:
            if (r1 == 0) goto L4b
            goto L5c
        L3d:
            r0 = move-exception
            throw r0
        L3f:
            com.alibaba.griver.ui.titlebar.NebulaTitleView r0 = r4.mTitleView
            android.widget.ImageView r0 = r0.ivImageTitle
            android.graphics.drawable.Drawable r0 = r0.getDrawable()
            boolean r1 = r0 instanceof android.graphics.drawable.BitmapDrawable
            if (r1 == 0) goto L5c
        L4b:
            int r1 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext
            int r1 = r1 + 97
            int r2 = r1 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            android.graphics.drawable.BitmapDrawable r0 = (android.graphics.drawable.BitmapDrawable) r0
            android.graphics.Bitmap r0 = r0.getBitmap()
            return r0
        L5c:
            return r3
        L5d:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.GriverTitleBar.getImgTitle():android.graphics.Bitmap");
    }

    public NebulaTitleView getTitleView() {
        NebulaTitleView nebulaTitleView;
        int i = getAuthRequestContext + 119;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            nebulaTitleView = this.mTitleView;
        } else {
            nebulaTitleView = this.mTitleView;
            Object obj = null;
            obj.hashCode();
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        return nebulaTitleView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
    
        if ((r0 != null ? '/' : 0) != '/') goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        r0 = false;
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
    
        r3 = com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 + 103;
        com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        if ((r3 % 2) != 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        r0 = r0.getStartParams();
        r3 = com.alibaba.ariver.kernel.common.utils.BundleUtils.getBoolean(r0, com.alibaba.griver.core.GriverParam.LONG_ISPRERENDER, true);
        r0 = com.alibaba.ariver.kernel.common.utils.BundleUtils.getBoolean(r0, com.alibaba.ariver.kernel.RVParams.isTinyApp, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
    
        r0 = r0.getStartParams();
        r3 = com.alibaba.ariver.kernel.common.utils.BundleUtils.getBoolean(r0, com.alibaba.griver.core.GriverParam.LONG_ISPRERENDER, false);
        r0 = com.alibaba.ariver.kernel.common.utils.BundleUtils.getBoolean(r0, com.alibaba.ariver.kernel.RVParams.isTinyApp, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
    
        r4 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext + 117;
        com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0084, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if ((r0 == null) != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isPreRenderPage() {
        /*
            r6 = this;
            int r0 = com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 107
            int r1 = r0 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L1e
            com.alibaba.ariver.app.api.Page r0 = r6.mPage
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L18
            r3 = 0
            goto L19
        L18:
            r3 = 1
        L19:
            if (r3 == 0) goto L2d
            goto L2a
        L1c:
            r0 = move-exception
            throw r0
        L1e:
            com.alibaba.ariver.app.api.Page r0 = r6.mPage
            r3 = 47
            if (r0 == 0) goto L27
            r4 = 47
            goto L28
        L27:
            r4 = 0
        L28:
            if (r4 == r3) goto L2d
        L2a:
            r0 = 0
            r3 = 0
            goto L60
        L2d:
            int r3 = com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 103
            int r4 = r3 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext = r4
            int r3 = r3 % 2
            java.lang.String r4 = "isTinyApp"
            java.lang.String r5 = "isPrerender"
            if (r3 != 0) goto L4a
            android.os.Bundle r0 = r0.getStartParams()
            boolean r3 = com.alibaba.ariver.kernel.common.utils.BundleUtils.getBoolean(r0, r5, r1)
            boolean r0 = com.alibaba.ariver.kernel.common.utils.BundleUtils.getBoolean(r0, r4, r2)
            goto L56
        L4a:
            android.os.Bundle r0 = r0.getStartParams()     // Catch: java.lang.Exception -> L83
            boolean r3 = com.alibaba.ariver.kernel.common.utils.BundleUtils.getBoolean(r0, r5, r2)     // Catch: java.lang.Exception -> L83
            boolean r0 = com.alibaba.ariver.kernel.common.utils.BundleUtils.getBoolean(r0, r4, r2)     // Catch: java.lang.Exception -> L83
        L56:
            int r4 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext
            int r4 = r4 + 117
            int r5 = r4 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            int r4 = r4 % 2
        L60:
            r4 = 20
            if (r3 == 0) goto L67
            r3 = 91
            goto L69
        L67:
            r3 = 20
        L69:
            if (r3 == r4) goto L81
            r3 = 30
            if (r0 == 0) goto L72
            r0 = 57
            goto L74
        L72:
            r0 = 30
        L74:
            if (r0 == r3) goto L81
            int r0 = com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 15
            int r2 = r0 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext = r2
            int r0 = r0 % 2
            goto L82
        L81:
            r1 = 0
        L82:
            return r1
        L83:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.GriverTitleBar.isPreRenderPage():boolean");
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public void setTitle(String str, String str2, String str3, final String str4, boolean z) {
        Bitmap base64ToBitmap;
        if (isPreRenderPage()) {
            return;
        }
        if (z) {
            int i = getAuthRequestContext + 1;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            this.mIgnorePageTitleFromCallbacks = true;
        }
        if (!TextUtils.isEmpty(str3)) {
            int i3 = getAuthRequestContext + 27;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            try {
                this.mIfImageTitle = true;
                try {
                    if (!(str3.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) && (base64ToBitmap = ImageUtil.base64ToBitmap(str3)) != null) {
                        this.mTitleView.setImgTitle(base64ToBitmap, str4);
                        return;
                    }
                    this.mTitleView.setTitle(str);
                    if (this.mPage != null) {
                        String downloadImageUrl = getDownloadImageUrl(H5UrlHelper.decode(str3));
                        if (TextUtils.isEmpty(downloadImageUrl)) {
                            return;
                        }
                        ImageUtils.loadImage(downloadImageUrl, new ImageListener() { // from class: com.alibaba.griver.ui.titlebar.GriverTitleBar.3
                            @Override // com.alibaba.griver.base.common.adapter.ImageListener
                            public void onImage(final Bitmap bitmap) {
                                if (bitmap != null) {
                                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.titlebar.GriverTitleBar.3.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            GriverTitleBar.access$600(GriverTitleBar.this).setImgTitle(bitmap, str4);
                                        }
                                    });
                                }
                            }
                        });
                        return;
                    }
                    return;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (!TextUtils.isEmpty(str) && !this.mPageStarted) {
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
            getAuthRequestContext = i5 % 128;
            if (i5 % 2 == 0) {
                this.mDefaultTitle = str;
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                this.mDefaultTitle = str;
            }
        }
        this.mTitleView.setTitle(str);
        this.mTitleView.setSubTitle(str2);
        int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
        getAuthRequestContext = i6 % 128;
        int i7 = i6 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        if (r6 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        r3.mTransTitle = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        if (r6 != false) goto L13;
     */
    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setTitleColor(int r4, boolean r5, boolean r6, int r7) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.GriverTitleBar.setTitleColor(int, boolean, boolean, int):void");
    }

    private void resetDivider() {
        int i = getAuthRequestContext + 49;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        View view = this.mDivider;
        if ((view != null ? (char) 17 : 'M') == 17) {
            view.setVisibility(8);
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        if ((r0 == null) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0027, code lost:
    
        if (r0 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0029, code lost:
    
        r1 = com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 + 19;
        com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext = r1 % 128;
        r1 = r1 % 2;
        r0.showTitleLoading(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        r5 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext + 115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
    
        com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        if ((r5 % 2) == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:
    
        r5 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        return;
     */
    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void showTitleLoading(boolean r5) {
        /*
            r4 = this;
            int r0 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext
            int r0 = r0 + 101
            int r1 = r0 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 89
            if (r0 == 0) goto L11
            r0 = 53
            goto L13
        L11:
            r0 = 89
        L13:
            r2 = 0
            if (r0 == r1) goto L25
            com.alibaba.griver.ui.titlebar.NebulaTitleView r0 = r4.mTitleView     // Catch: java.lang.Exception -> L23
            int r1 = r2.length     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L1d
            r1 = 0
            goto L1e
        L1d:
            r1 = 1
        L1e:
            if (r1 == 0) goto L29
            goto L36
        L21:
            r5 = move-exception
            throw r5
        L23:
            r5 = move-exception
            goto L47
        L25:
            com.alibaba.griver.ui.titlebar.NebulaTitleView r0 = r4.mTitleView
            if (r0 == 0) goto L36
        L29:
            int r1 = com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2
            int r1 = r1 + 19
            int r3 = r1 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext = r3
            int r1 = r1 % 2
            r0.showTitleLoading(r5)
        L36:
            int r5 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext     // Catch: java.lang.Exception -> L23
            int r5 = r5 + 115
            int r0 = r5 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r0     // Catch: java.lang.Exception -> L23
            int r5 = r5 % 2
            if (r5 == 0) goto L46
            int r5 = r2.length     // Catch: java.lang.Throwable -> L44
            return
        L44:
            r5 = move-exception
            throw r5
        L46:
            return
        L47:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.GriverTitleBar.showTitleLoading(boolean):void");
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public void showBackButton(boolean z) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        NebulaTitleView nebulaTitleView = this.mTitleView;
        if (nebulaTitleView == null) {
            return;
        }
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
            try {
                getAuthRequestContext = i3 % 128;
                boolean z2 = i3 % 2 == 0;
                nebulaTitleView.showBackButton(z);
                if (!z2) {
                    return;
                }
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        if (r0 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:
    
        if (r0 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:
    
        r0.showOptionMenu(r4);
     */
    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void showOptionMenu(boolean r4) {
        /*
            r3 = this;
            int r0 = com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L39
            int r0 = r0 + 75
            int r1 = r0 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L39
            r1 = 2
            int r0 = r0 % r1
            if (r0 != 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            r2 = 0
            if (r0 == 0) goto L1c
            com.alibaba.griver.ui.titlebar.NebulaTitleView r0 = r3.mTitleView
            r2.hashCode()     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L23
            goto L20
        L1a:
            r4 = move-exception
            throw r4
        L1c:
            com.alibaba.griver.ui.titlebar.NebulaTitleView r0 = r3.mTitleView
            if (r0 == 0) goto L23
        L20:
            r0.showOptionMenu(r4)
        L23:
            int r4 = com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext
            int r4 = r4 + 41
            int r0 = r4 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r4 = r4 % r1
            if (r4 == 0) goto L31
            r4 = 70
            goto L32
        L31:
            r4 = 2
        L32:
            if (r4 == r1) goto L38
            int r4 = r2.length     // Catch: java.lang.Throwable -> L36
            return
        L36:
            r4 = move-exception
            throw r4
        L38:
            return
        L39:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.GriverTitleBar.showOptionMenu(boolean):void");
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public View getDivider() {
        int i = getAuthRequestContext + 81;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? Typography.less : 'J') != '<') {
            return this.mDivider;
        }
        View view = this.mDivider;
        Object obj = null;
        obj.hashCode();
        return view;
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public void setDivider(View view) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        this.mDivider = view;
        int i3 = getAuthRequestContext + 85;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    private void switchTheme(int i) {
        NebulaTitleView.Theme theme;
        H5TinyPopMenu h5TinyPopMenu;
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
        getAuthRequestContext = i2 % 128;
        if (i2 % 2 != 0) {
            try {
                theme = ColorUtils.getTheme(i, NebulaTitleView.Theme.LIGHT);
                if (this.mCurrentTheme == theme) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            theme = ColorUtils.getTheme(i, NebulaTitleView.Theme.LIGHT);
            int i3 = 11 / 0;
            if (this.mCurrentTheme == theme) {
                return;
            }
        }
        if ((theme == NebulaTitleView.Theme.LIGHT ? 'D' : JSONLexer.EOI) != 'D') {
            this.mCurrentTheme = NebulaTitleView.Theme.DARK;
            switchIconFontToDarkTheme();
            this.mTitleView.switchTheme(NebulaTitleView.Theme.DARK);
            H5TinyPopMenu h5TinyPopMenu2 = this.mTinyPopMenu;
            if (h5TinyPopMenu2 != null) {
                h5TinyPopMenu2.onSwitchToDarkTheme();
                return;
            }
            return;
        }
        int i4 = getAuthRequestContext + 19;
        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
        if (i4 % 2 == 0) {
            this.mCurrentTheme = NebulaTitleView.Theme.LIGHT;
            switchIconFontToLightTheme();
            this.mTitleView.switchTheme(NebulaTitleView.Theme.LIGHT);
            h5TinyPopMenu = this.mTinyPopMenu;
            if (h5TinyPopMenu == null) {
                return;
            }
        } else {
            this.mCurrentTheme = NebulaTitleView.Theme.LIGHT;
            switchIconFontToLightTheme();
            this.mTitleView.switchTheme(NebulaTitleView.Theme.LIGHT);
            h5TinyPopMenu = this.mTinyPopMenu;
            Object obj = null;
            obj.hashCode();
            if (h5TinyPopMenu == null) {
                return;
            }
        }
        try {
            h5TinyPopMenu.onSwitchToLightTheme();
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void switchCustomTheme(int i) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        this.mTitleView.switchToCustomTheme(i);
        if (!(BundleUtils.getBoolean(this.mPage.getStartParams(), "useTitleColorWhenAutoTransparentTitle", false) ? false : true)) {
            int i4 = BundleUtils.getInt(this.mPage.getStartParams(), "titleColor");
            try {
                if (i4 == 0) {
                    if ((this.mCurrentTheme == NebulaTitleView.Theme.DARK ? (char) 30 : '!') == '!') {
                        this.mTitleView.setTitleTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.mContext, R.color.griver_ui_light_icon_color));
                        return;
                    }
                    this.mTitleView.setTitleTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.mContext, R.color.griver_ui_dark_title_color));
                    int i5 = getAuthRequestContext + 21;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                    int i6 = i5 % 2;
                    return;
                }
                int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
                getAuthRequestContext = i7 % 128;
                if (i7 % 2 != 0) {
                    this.mTitleView.setTitleTextColor(i4);
                    return;
                }
                this.mTitleView.setTitleTextColor(i4);
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private void switchIconFontToCustomTheme(int i) {
        try {
            String[] strArr = this.mIconType;
            if (strArr == null) {
                return;
            }
            if (!(strArr.length > 0)) {
                return;
            }
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.mIconType;
                if (i2 >= strArr2.length) {
                    return;
                }
                String str = strArr2[i2];
                Integer num = iconFontMap.get(str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (!TextUtils.equals(str, "stupid") && num != null) {
                            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
                            getAuthRequestContext = i3 % 128;
                            if (!(i3 % 2 != 0)) {
                                setOptionImage(createIconBitmap(num.intValue(), i), i2);
                                Object obj = null;
                                obj.hashCode();
                            } else {
                                setOptionImage(createIconBitmap(num.intValue(), i), i2);
                            }
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
                i2++;
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 31;
                getAuthRequestContext = i4 % 128;
                int i5 = i4 % 2;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void switchIconFontToLightTheme() {
        String[] strArr;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            strArr = this.mIconType;
            Object obj = null;
            obj.hashCode();
            if (strArr == null) {
                return;
            }
        } else {
            try {
                strArr = this.mIconType;
                if (strArr == null) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        if (strArr.length <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            String[] strArr2 = this.mIconType;
            if ((i2 < strArr2.length ? (char) 11 : 'J') == 'J') {
                return;
            }
            String str = strArr2[i2];
            Integer num = iconFontMap.get(str);
            if ((!TextUtils.isEmpty(str)) && !TextUtils.equals(str, "stupid")) {
                int i3 = getAuthRequestContext + 47;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                if (num != null) {
                    int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 87;
                    getAuthRequestContext = i5 % 128;
                    int i6 = i5 % 2;
                    try {
                        setOptionImage(createIconBitmap(num.intValue(), ContextCompat.BuiltInFictitiousFunctionClassFactory(this.mContext, R.color.griver_ui_light_icon_color)), i2);
                    } catch (Exception e2) {
                        throw e2;
                    }
                } else {
                    continue;
                }
            }
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00c5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void switchIconFontToDarkTheme() {
        /*
            Method dump skipped, instructions count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.GriverTitleBar.switchIconFontToDarkTheme():void");
    }

    private void getTinyPopMenuData() {
        H5TinyPopMenu h5TinyPopMenu = new H5TinyPopMenu();
        this.mTinyPopMenu = h5TinyPopMenu;
        h5TinyPopMenu.init(this.mPage, "", this.mContext, (ViewGroup) this.mTitleView.getOptionMenuContainer());
        int i = getAuthRequestContext + 13;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        if ((r1 == null) != false) goto L17;
     */
    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setTransparentTitle(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L3f
            r1 = 31
            int r0 = r0 + r1
            int r2 = r0 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext = r2     // Catch: java.lang.Exception -> L3f
            int r0 = r0 % 2
            r2 = 1
            if (r0 != 0) goto L19
            r0 = 0
            r3.isSwitchMode = r0
            com.alibaba.ariver.app.api.Page r1 = r3.mPage
            if (r1 == 0) goto L16
            r2 = 0
        L16:
            if (r2 == 0) goto L27
            goto L3b
        L19:
            r3.isSwitchMode = r2
            com.alibaba.ariver.app.api.Page r0 = r3.mPage
            r2 = 39
            if (r0 == 0) goto L23
            r1 = 39
        L23:
            if (r1 == r2) goto L26
            goto L3b
        L26:
            r1 = r0
        L27:
            android.os.Bundle r0 = r1.getStartParams()
            java.lang.String r1 = "transparentTitle"
            r0.putString(r1, r4)
            int r4 = com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = r4 + 119
            int r0 = r4 % 128
            com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext = r0
            int r4 = r4 % 2
        L3b:
            r3.applyTransparentTitle()
            return
        L3f:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.GriverTitleBar.setTransparentTitle(java.lang.String):void");
    }

    public void onOptionMenuClick() {
        Iterator<GriverMenuItem> it;
        GriverMenuItem next;
        if (BundleUtils.getBoolean(this.mPage.getStartParams(), RVParams.isH5App, false)) {
            this.mToolbarMenu.showMenu(this.mTitleView.getPopAnchor());
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<GriverMenuItem> developerCustomMenu = getDeveloperCustomMenu();
        if (developerCustomMenu != null && developerCustomMenu.size() > 0) {
            arrayList.addAll(developerCustomMenu);
        }
        List<GriverMenuItem> menuList = ((GriverACMenuExtension) RVProxy.get(GriverACMenuExtension.class)).getMenuList(this.mPage);
        Object obj = null;
        if (menuList != null && menuList.size() > 0) {
            int i = getAuthRequestContext + 33;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (i % 2 != 0) {
                it = menuList.iterator();
                obj.hashCode();
            } else {
                try {
                    it = menuList.iterator();
                } catch (Exception e) {
                    throw e;
                }
            }
            while (it.hasNext()) {
                int i2 = getAuthRequestContext + 97;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                if ((i2 % 2 != 0 ? 'X' : Typography.quote) != 'X') {
                    next = it.next();
                    if (!(!next.canShow(this.mPage))) {
                        arrayList.add(next);
                    }
                } else {
                    next = it.next();
                    int i3 = 61 / 0;
                    if (next.canShow(this.mPage)) {
                        arrayList.add(next);
                    }
                }
            }
        }
        List<GriverMenuItem> menuList2 = ((GriverMenuExtension) RVProxy.get(GriverMenuExtension.class)).getMenuList(this.mPage);
        if (!(menuList2 == null)) {
            if ((menuList2.size() > 0 ? 'O' : (char) 7) == 'O') {
                Iterator<GriverMenuItem> it2 = menuList2.iterator();
                while (true) {
                    if ((it2.hasNext() ? '@' : Typography.amp) == '&') {
                        break;
                    }
                    GriverMenuItem next2 = it2.next();
                    if (next2.canShow(this.mPage)) {
                        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
                        getAuthRequestContext = i4 % 128;
                        if (i4 % 2 == 0) {
                            arrayList.add(next2);
                            obj.hashCode();
                        } else {
                            arrayList.add(next2);
                        }
                    }
                }
            }
        }
        ((GriverOptionMenuPanelExtension) RVProxy.get(GriverOptionMenuPanelExtension.class)).showOptionMenuPanel(this.mPage, arrayList);
    }

    private List<GriverMenuItem> getDeveloperCustomMenu() {
        final JSONArray jSONArray;
        Object[] objArr;
        LinkedList linkedList = new LinkedList();
        try {
            jSONArray = (JSONArray) this.mPage.getData(JSONArray.class);
            objArr = null;
        } catch (Throwable th) {
            GriverLogger.e(TAG, "getDeveloperCustomMenu", th);
        }
        if (jSONArray == null) {
            int i = getAuthRequestContext + 125;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (!(i % 2 == 0)) {
                int i2 = 49 / 0;
            }
            return null;
        }
        int size = jSONArray.size();
        int i3 = 0;
        while (true) {
            if (i3 >= 3) {
                break;
            }
            int i4 = getAuthRequestContext + 89;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            if (i4 % 2 == 0) {
                if (i3 >= size) {
                    break;
                }
            } else {
                int length = objArr.length;
                if (i3 >= size) {
                    break;
                }
            }
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            String string = JSONUtils.getString(jSONObject, "name");
            String string2 = JSONUtils.getString(jSONObject, "menuIconUrl");
            GriverBaseMenuItem griverBaseMenuItem = new GriverBaseMenuItem();
            griverBaseMenuItem.identifier = string;
            griverBaseMenuItem.name = string;
            griverBaseMenuItem.iconUrl = string2;
            griverBaseMenuItem.row = 2;
            griverBaseMenuItem.priority = GRVMPMoreMenuItemPriority.GRVMPMoreMenuItemPriorityHigh;
            griverBaseMenuItem.listener = new OnMenuItemClickListener() { // from class: com.alibaba.griver.ui.titlebar.GriverTitleBar.4
                @Override // com.alibaba.griver.api.common.menu.OnMenuItemClickListener
                public void onItemClick(Page page, String str) {
                    int size2 = jSONArray.size();
                    for (int i5 = 0; i5 < 3 && i5 < size2; i5++) {
                        if (TextUtils.equals(JSONUtils.getString(jSONArray.getJSONObject(i5), "name"), str)) {
                            JSONObject jSONObject2 = new JSONObject();
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("index", (Object) Integer.valueOf(i5));
                            jSONObject2.put("data", (Object) jSONObject3);
                            EngineUtils.sendToRender(GriverTitleBar.access$700(GriverTitleBar.this).getRender(), RVEvents.CUSTOM_POP_MENU_CLICKED, jSONObject2, null);
                            return;
                        }
                    }
                }
            };
            linkedList.add(griverBaseMenuItem);
            i3++;
        }
        return linkedList;
    }

    @Override // com.alibaba.griver.api.ui.titlebar.GVTitleBar
    public void enableBackButton(boolean z) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 37;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        NebulaTitleView nebulaTitleView = this.mTitleView;
        if ((nebulaTitleView != null) && nebulaTitleView.btBack != null) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
            getAuthRequestContext = i3 % 128;
            if (i3 % 2 == 0) {
                this.mTitleView.btBack.setEnabled(z);
                int i4 = 49 / 0;
            } else {
                this.mTitleView.btBack.setEnabled(z);
            }
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
            getAuthRequestContext = i5 % 128;
            int i6 = i5 % 2;
        }
        int i7 = getAuthRequestContext + 23;
        KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
        if (i7 % 2 != 0) {
            int i8 = 3 / 0;
        }
    }

    @Override // com.alibaba.griver.api.ui.titlebar.GVTitleBar
    public void enableCloseButton(boolean z) {
        NebulaTitleView nebulaTitleView;
        int i = getAuthRequestContext + 3;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        Object obj = null;
        if ((i % 2 != 0 ? 'Z' : '3') != '3') {
            try {
                nebulaTitleView = this.mTitleView;
                obj.hashCode();
                if (nebulaTitleView == null) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            nebulaTitleView = this.mTitleView;
            if (nebulaTitleView == null) {
                return;
            }
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
        getAuthRequestContext = i2 % 128;
        if (i2 % 2 == 0) {
            TextView textView = nebulaTitleView.btClose;
            obj.hashCode();
            if ((textView != null ? '_' : '6') != '_') {
                return;
            }
        } else if (nebulaTitleView.btClose == null) {
            return;
        }
        this.mTitleView.btClose.setEnabled(z);
    }

    @Override // com.alibaba.griver.api.ui.titlebar.GVTitleBar
    public void showCloseButton(boolean z) {
        try {
            NebulaTitleView nebulaTitleView = this.mTitleView;
            if (nebulaTitleView != null) {
                int i = getAuthRequestContext + 55;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (!(i % 2 == 0)) {
                    try {
                        nebulaTitleView.showCloseButton(z);
                        Object obj = null;
                        obj.hashCode();
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    nebulaTitleView.showCloseButton(z);
                }
            }
            int i2 = getAuthRequestContext + 35;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            if (i2 % 2 != 0) {
                int i3 = 82 / 0;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ac, code lost:
    
        if ((r0 != null) != true) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b7, code lost:
    
        if (r7.mPage.getApp() != null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c9, code lost:
    
        if ("20000067".equals(r7.mPage.getApp().getAppId()) == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cb, code lost:
    
        r0 = com.alibaba.griver.ui.titlebar.GriverTitleBar.KClassImpl$Data$declaredNonStaticMembers$2 + 91;
        com.alibaba.griver.ui.titlebar.GriverTitleBar.getAuthRequestContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d5, code lost:
    
        if ((r0 % 2) != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d8, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00dd, code lost:
    
        if (r2 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00df, code lost:
    
        r7.mToolbarMenu.removeMenu("refresh");
        r7.mToolbarMenu.removeMenu("h5MenuActionOfFont");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00eb, code lost:
    
        r0 = 26 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ef, code lost:
    
        r7.mToolbarMenu.removeMenu("refresh");
        r7.mToolbarMenu.removeMenu("h5MenuActionOfFont");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fa, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00fb, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00fc, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00fd, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00fe, code lost:
    
        r7.mToolbarMenu.clearMenuList();
     */
    @Override // com.alibaba.griver.api.ui.titlebar.GVTitleBar
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setToolbarMenu(com.alibaba.fastjson.JSONArray r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.GriverTitleBar.setToolbarMenu(com.alibaba.fastjson.JSONArray, boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cb, code lost:
    
        if (r10 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00df, code lost:
    
        if (r9.isEmpty() == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e9, code lost:
    
        if (r9.containsKey(r16.mIconType[r14]) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00eb, code lost:
    
        r3 = r9.get(r16.mIconType[r14]).intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00fd, code lost:
    
        if (r16.mCurrentTheme != com.alibaba.griver.ui.titlebar.NebulaTitleView.Theme.DARK) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ff, code lost:
    
        r9 = androidx.core.content.ContextCompat.BuiltInFictitiousFunctionClassFactory(r16.mContext, com.alibaba.griver.ui.R.color.griver_ui_dark_icon_color);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0108, code lost:
    
        r9 = androidx.core.content.ContextCompat.BuiltInFictitiousFunctionClassFactory(r16.mContext, com.alibaba.griver.ui.R.color.griver_ui_light_icon_color);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0110, code lost:
    
        setOptionImage(createIconBitmap(r3, r9), r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0118, code lost:
    
        r3 = com.alibaba.ariver.kernel.common.utils.JSONUtils.getString(r3, "icon");
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0120, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) != false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0122, code lost:
    
        loadImageAsync(r3, r14);
     */
    @Override // com.alibaba.griver.api.ui.titlebar.GVTitleBar
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setOptionMenu(java.lang.String r17, java.lang.String r18, java.lang.String r19, boolean r20, java.lang.String r21, boolean r22, com.alibaba.fastjson.JSONArray r23, boolean r24, java.lang.String r25, java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.GriverTitleBar.setOptionMenu(java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, boolean, com.alibaba.fastjson.JSONArray, boolean, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private void loadImageAsync(String str, final int i) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        try {
            if ((!str.startsWith(SemanticAttributes.FaasTriggerValues.HTTP) ? '!' : Typography.dollar) == '!') {
                Bitmap base64ToBitmap = ImageUtils.base64ToBitmap(str);
                if (base64ToBitmap == null) {
                    return;
                }
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
                getAuthRequestContext = i4 % 128;
                if ((i4 % 2 == 0 ? 'c' : (char) 2) != 'c') {
                    setOptionImage(base64ToBitmap, i);
                    return;
                }
                setOptionImage(base64ToBitmap, i);
                Object obj = null;
                obj.hashCode();
                return;
            }
            ImageUtils.loadImage(str, new ImageListener() { // from class: com.alibaba.griver.ui.titlebar.GriverTitleBar.6
                @Override // com.alibaba.griver.base.common.adapter.ImageListener
                public void onImage(Bitmap bitmap) {
                    if (bitmap != null) {
                        GriverTitleBar.access$800(GriverTitleBar.this, bitmap, i);
                    }
                }
            });
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        try {
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i2) {
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                int i4 = a2.MyBillsEntityDataFactory;
                cArr2[i4] = (char) (cArr2[i4] - ((int) (MyBillsEntityDataFactory ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            }
            if ((i3 > 0 ? 'X' : (char) 22) == 'X') {
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr3 = new char[i2];
                System.arraycopy(cArr2, 0, cArr3, 0, i2);
                System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
            }
            if (!(!z)) {
                int i5 = $11 + 81;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                char[] cArr4 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
                while (true) {
                    if ((a2.MyBillsEntityDataFactory < i2 ? '%' : (char) 23) != '%') {
                        break;
                    }
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                }
                int i7 = $10 + 87;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                cArr2 = cArr4;
            }
            String str = new String(cArr2);
            int i9 = $11 + 71;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            objArr[0] = str;
        } catch (Exception e) {
            throw e;
        }
    }
}
