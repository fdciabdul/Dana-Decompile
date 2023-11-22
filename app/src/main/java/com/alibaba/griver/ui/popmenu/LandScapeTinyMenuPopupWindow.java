package com.alibaba.griver.ui.popmenu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.text.AUIconView;
import com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow;
import com.google.common.base.Ascii;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class LandScapeTinyMenuPopupWindow extends TinyMenuPopupWindow {

    /* renamed from: a  reason: collision with root package name */
    private int f6723a;
    private int b;
    private FrameLayout c;
    public static final byte[] $$a = {4, -20, -33, -123, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 241;
    public static final byte[] getAuthRequestContext = {59, -54, -26, -72, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int MyBillsEntityDataFactory = 168;

    private static void G(byte b, int i, byte b2, Object[] objArr) {
        int i2 = b2 + 105;
        int i3 = (b * 4) + 16;
        byte[] bArr = getAuthRequestContext;
        int i4 = 19 - (i * 15);
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            i4++;
            i2 = i4 + (-i2) + 2;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i2;
            if (i5 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b3 = bArr[i4];
            i4++;
            i2 = i2 + (-b3) + 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002f -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void H(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = 3 - r8
            byte[] r0 = com.alibaba.griver.ui.popmenu.LandScapeTinyMenuPopupWindow.$$a
            int r7 = r7 * 2
            int r7 = 42 - r7
            int r6 = r6 * 4
            int r6 = r6 + 75
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L1a
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L38
        L1a:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L1e:
            byte r4 = (byte) r7
            int r8 = r8 + 1
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L2f
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2f:
            r4 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L38:
            int r7 = r7 + r8
            int r7 = r7 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.popmenu.LandScapeTinyMenuPopupWindow.H(short, int, int, java.lang.Object[]):void");
    }

    public LandScapeTinyMenuPopupWindow(Context context) {
        super(context);
        this.f6723a = context.getResources().getDimensionPixelSize(R.dimen.griver_ui_menu_landscape_width);
        this.b = context.getResources().getDimensionPixelSize(R.dimen.griver_ui_menu_landscape_recent_app_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow, android.app.Dialog
    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (getAuthRequestContext[5] - 1);
            Object[] objArr = new Object[1];
            G(b, b, getAuthRequestContext[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (getAuthRequestContext[5] - 1);
            byte b3 = getAuthRequestContext[5];
            Object[] objArr2 = new Object[1];
            G(b2, b3, (byte) (b3 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 494, Color.alpha(0) + 4, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))));
                    byte b4 = (byte) ($$a[35] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    H(b4, b5, b5, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 35 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-116315096, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, (Process.myTid() >> 22) + 18, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                this.c = (FrameLayout) this.mMenuContent.findViewById(R.id.favorite_and_recent_tiny_app_layout);
                Window window = getWindow();
                if (window != null) {
                    window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.alibaba.griver.ui.popmenu.LandScapeTinyMenuPopupWindow.1
                        @Override // android.view.View.OnSystemUiVisibilityChangeListener
                        public void onSystemUiVisibilityChange(int i2) {
                            LandScapeTinyMenuPopupWindow.this.b();
                        }
                    });
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 == null) {
                throw th4;
            }
            throw cause4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow, android.app.Dialog
    public void onStart() {
        super.onStart();
        b();
        a();
        this.mFavoriteAndRecentTinyAppList.setVisibility(8);
    }

    @Override // com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow, com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setRecentUseTinyAppList(List<TinyMenuFunctionModel> list) {
        if (this.mRecentUseList == null) {
            this.mRecentUseList = new ArrayList();
        } else if (list.size() > 10) {
            list = list.subList(0, 10);
        }
        this.mRecentUseList = list;
    }

    private void a() {
        this.c.removeAllViews();
        for (int i = 0; i < this.mRecentUseList.size(); i++) {
            this.c.addView(a(i, this.mRecentUseList.get(i)));
        }
    }

    private View a(int i, final TinyMenuFunctionModel tinyMenuFunctionModel) {
        int dip2px = DimensionUtil.dip2px(this.mContext, 45.0f);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, dip2px);
        if (tinyMenuFunctionModel.functionType == 0) {
            TinyRoundImageView tinyRoundImageView = new TinyRoundImageView(this.mContext);
            layoutParams.gravity = 17;
            tinyRoundImageView.setRadius(DensityUtil.dip2px(this.mContext, 7.0f));
            tinyRoundImageView.setLayoutParams(layoutParams);
            if (tinyMenuFunctionModel != null) {
                ImageUtils.loadImage(tinyMenuFunctionModel.iconUrl, new TinyMenuPopupWindow.TinyAppImageLoader(tinyRoundImageView));
            }
            linearLayout.addView(tinyRoundImageView);
        } else if (tinyMenuFunctionModel.functionType == 1) {
            AUIconView aUIconView = new AUIconView(this.mContext);
            Resources resources = this.mContext.getResources();
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
        }
        TextView textView = new TextView(this.mContext);
        if (tinyMenuFunctionModel != null) {
            textView.setText(tinyMenuFunctionModel.name);
        }
        textView.setTextSize(11.0f);
        textView.setGravity(17);
        textView.setSingleLine(true);
        textView.setTextColor(Color.parseColor("#3C4550"));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        layoutParams2.setMargins(6, 20, 6, 0);
        linearLayout.addView(textView, layoutParams2);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.popmenu.LandScapeTinyMenuPopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TinyMenuFunctionModel tinyMenuFunctionModel2 = tinyMenuFunctionModel;
                if (tinyMenuFunctionModel2 != null) {
                    if (tinyMenuFunctionModel2.functionType == 0) {
                        LandScapeTinyMenuPopupWindow.this.startTinyAppAndCloseCurrent(tinyMenuFunctionModel.appId);
                    } else if (tinyMenuFunctionModel.functionType == 1) {
                        LandScapeTinyMenuPopupWindow.this.startRecentTinyApp();
                    }
                }
                LandScapeTinyMenuPopupWindow.this.doDismissWithAnimation(true);
            }
        });
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.f6723a / 5, this.b);
        layoutParams3.topMargin = (i / 5) * this.b;
        layoutParams3.leftMargin = (i % 5) * this.mRecentTinyAppItemWidth;
        linearLayout.setLayoutParams(layoutParams3);
        return linearLayout;
    }

    @Override // com.alibaba.griver.ui.ant.dialog.AUBasicDialog, android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Window window = getWindow();
        if (window != null && Build.VERSION.SDK_INT >= 19) {
            window.getDecorView().setSystemUiVisibility(5894);
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow, com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void showMenu(Context context) {
        RVLogger.d("LandScapeTinyMenuPopupWindow", "landscape showMenu.");
        super.showMenu(context);
    }

    @Override // com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow
    protected int getLayoutId() {
        return R.layout.griver_ui_menu_layout_horizontal;
    }

    @Override // com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow
    protected void initWindowManagerLayoutParams(WindowManager.LayoutParams layoutParams) {
        layoutParams.width = this.f6723a;
        layoutParams.height = -1;
        layoutParams.gravity = 5;
        layoutParams.dimAmount = 0.4f;
    }

    @Override // com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow
    protected void initMenuItemWidth(int i) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.mRecentTinyAppItemWidth = Math.round((this.f6723a - DimensionUtil.dip2px(this.mContext, 4.0f)) / 5);
        this.mMenuItemWidth = (this.f6723a - Math.round((f * 36.0f) + 0.5f)) / 5;
    }

    @Override // com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow
    protected TinyMenuBgDrawable createTinyMenuBackground(Bitmap bitmap) {
        return new TinyMenuBgDrawable(bitmap, bitmap.getWidth() - this.f6723a, 0, bitmap.getWidth(), bitmap.getHeight(), 0, 0, this.f6723a, bitmap.getHeight());
    }

    @Override // com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow
    protected int getShowAnimationId() {
        return R.anim.griver_ui_menu_in_landscape;
    }

    @Override // com.alibaba.griver.ui.popmenu.TinyMenuPopupWindow
    protected int getDismissAnimationId() {
        return R.anim.griver_ui_menu_out_landscape;
    }
}
