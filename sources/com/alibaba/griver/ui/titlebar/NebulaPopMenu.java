package com.alibaba.griver.ui.titlebar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.h5.point.GriverOptionMenuClickPoint;
import com.alibaba.griver.base.common.adapter.ImageListener;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.ui.R;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public class NebulaPopMenu {
    public static final String TAG = "NebulaPopMenu";

    /* renamed from: a  reason: collision with root package name */
    private List<PopMenuItem> f6767a;
    private List<PopMenuItem> b;
    private PopupWindow c;
    private Page d;
    private boolean e;
    private boolean f;
    private NebulaPopMenuItemHolder g;
    private int h;
    private int i;
    private List<View> j;
    private View k;
    private Context l;
    private FrameLayout m;
    private ViewGroup.LayoutParams n;

    /* renamed from: o  reason: collision with root package name */
    private View f6768o;
    private LinearLayout p;
    private boolean q = false;
    private View.OnClickListener r = new View.OnClickListener() { // from class: com.alibaba.griver.ui.titlebar.NebulaPopMenu.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NebulaPopMenu.this.c != null && NebulaPopMenu.this.c.isShowing()) {
                NebulaPopMenu.this.c.dismiss();
            }
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                PopMenuItem popMenuItem = (PopMenuItem) NebulaPopMenu.this.f6767a.get(((Integer) tag).intValue());
                popMenuItem.redDotNum = "-1";
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", (Object) popMenuItem.name);
                jSONObject.put("tag", (Object) popMenuItem.tag);
                jSONObject.put("title", (Object) popMenuItem.name);
                if (NebulaPopMenu.this.f) {
                    jSONObject.put("popMenuType", (Object) "popmenu");
                }
                ((GriverOptionMenuClickPoint) ExtensionPoint.as(GriverOptionMenuClickPoint.class).node(NebulaPopMenu.this.d).create()).menuClick(jSONObject);
            }
        }
    };

    public NebulaPopMenu(Context context) {
        b();
        this.e = true;
        this.f = false;
        this.l = context;
    }

    private void a() {
        if (this.m != null) {
            return;
        }
        Context context = this.l;
        if (!(context instanceof Activity) || ((Activity) context).getWindow() == null) {
            return;
        }
        this.m = (FrameLayout) ((Activity) this.l).findViewById(16908290);
    }

    public void setPage(Page page) {
        this.d = page;
    }

    public void setShowPopMenu(boolean z) {
        this.f = z;
    }

    public boolean hasMenu(String str) {
        List<PopMenuItem> list = this.f6767a;
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = this.f6767a.size() - 1; size >= 0; size--) {
            PopMenuItem popMenuItem = this.f6767a.get(size);
            if (popMenuItem != null && str.equals(popMenuItem.tag)) {
                return true;
            }
        }
        return false;
    }

    public void setMenu(JSONArray jSONArray, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        List<PopMenuItem> list;
        List<PopMenuItem> list2;
        if (jSONArray == null) {
            return;
        }
        if ((z | this.f) && (list2 = this.f6767a) != null) {
            list2.clear();
        }
        if (this.f && (list = this.f6767a) != null) {
            list.clear();
        }
        if (z2 && jSONArray.isEmpty()) {
            RVLogger.d(TAG, "menu not set");
            return;
        }
        synchronized (this.f6767a) {
            i = 0;
            for (int i4 = 0; i4 < this.f6767a.size(); i4++) {
                if (this.f6767a.get(i4).temp) {
                    i++;
                }
            }
        }
        if (z2 && i >= 11) {
            RVLogger.e(TAG, "reach max temp count!");
        } else if (jSONArray != null && this.f6767a.size() + jSONArray.size() >= 11) {
            RVLogger.e(TAG, "(oriCount + addCount) >= MAX_TEMP_COUNT!");
        } else {
            this.b = new ArrayList();
            for (int i5 = 0; i5 < jSONArray.size(); i5++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i5);
                String string = JSONUtils.getString(jSONObject, "name");
                String string2 = JSONUtils.getString(jSONObject, "tag");
                String string3 = JSONUtils.getString(jSONObject, "icon");
                String string4 = JSONUtils.getString(jSONObject, "redDot");
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("invalid tag: ");
                    sb.append(string2);
                    sb.append(" name: ");
                    sb.append(string);
                    RVLogger.w(TAG, sb.toString());
                } else if (a(string, string2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("existed tag: ");
                    sb2.append(string2);
                    sb2.append(" name: ");
                    sb2.append(string);
                    RVLogger.w(TAG, sb2.toString());
                } else {
                    if (string.length() > 8) {
                        string = string.substring(0, 8);
                    }
                    Drawable a2 = a(string2);
                    if (this.f) {
                        a2 = null;
                    }
                    PopMenuItem popMenuItem = new PopMenuItem(string, string2, a2, z2);
                    if (this.f && !TextUtils.isEmpty(string4)) {
                        popMenuItem.redDotNum = string4;
                    }
                    popMenuItem.iconUrl = string3;
                    if (this.b.size() >= 11 - i) {
                        break;
                    } else if ("ppchatShare".equals(string2)) {
                        popMenuItem.temp = false;
                        this.f6767a.add(0, popMenuItem);
                    } else if ("ppchatReportAbuse".equals(string2)) {
                        popMenuItem.temp = false;
                        this.f6767a.add(popMenuItem);
                    } else {
                        this.b.add(popMenuItem);
                    }
                }
            }
            synchronized (this.f6767a) {
                i2 = -1;
                i3 = -1;
                for (int i6 = 0; i6 < this.f6767a.size(); i6++) {
                    PopMenuItem popMenuItem2 = this.f6767a.get(i6);
                    if (popMenuItem2.temp) {
                        if (i2 < 0) {
                            i2 = i6;
                        }
                    } else if (i3 < 0 && (i6 != 0 || !"ppchatShare".equals(popMenuItem2.tag))) {
                        i3 = i6;
                    }
                }
            }
            if (i2 == -1) {
                i2 = (this.f6767a.size() <= 0 || !"ppchatShare".equals(this.f6767a.get(0).tag)) ? 0 : 1;
            }
            int i7 = i3 != -1 ? i3 : 0;
            if (z2) {
                this.f6767a.addAll(i2, this.b);
            } else {
                this.f6767a.addAll(i7, this.b);
            }
            d();
        }
    }

    public void setMenu(JSONArray jSONArray, boolean z) {
        setMenu(jSONArray, false, z);
    }

    public void addMenu(int i, PopMenuItem popMenuItem) {
        List<PopMenuItem> list = this.f6767a;
        if (list == null || popMenuItem == null) {
            return;
        }
        list.add(i, popMenuItem);
    }

    public void removeMenu(String str) {
        List<PopMenuItem> list = this.f6767a;
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return;
        }
        for (int size = this.f6767a.size() - 1; size >= 0; size--) {
            PopMenuItem popMenuItem = this.f6767a.get(size);
            if (popMenuItem != null && str.equals(popMenuItem.tag)) {
                this.f6767a.remove(size);
                return;
            }
        }
    }

    public void resetMenu() {
        for (int size = this.f6767a.size() - 1; size >= 0; size--) {
            if (this.f6767a.get(size).temp) {
                this.f6767a.remove(size);
            }
        }
        this.e = true;
        if (this.f6767a.size() == 0) {
            b();
        }
    }

    public void clearMenuList() {
        List<PopMenuItem> list = this.f6767a;
        if (list == null || this.q) {
            return;
        }
        list.clear();
        this.q = true;
    }

    public void showMenu(View view) {
        a();
        c();
        PopupWindow popupWindow = this.c;
        if (popupWindow != null && popupWindow.isShowing()) {
            RVLogger.d(TAG, "menu is showing!");
        } else if (this.g.getListCount() == 0) {
            if (GriverEnv.isDebuggable()) {
                Toast.makeText(GriverEnv.getApplicationContext(), R.string.griver_ui_no_menu_to_show, 0).show();
            }
        } else if (this.e || this.c == null) {
            this.p.setVerticalScrollBarEnabled(true);
            this.p.setOnClickListener(this.r);
            if (this.f) {
                this.j = new ArrayList();
            }
            int i = 0;
            for (int i2 = 0; i2 < this.g.getListCount(); i2++) {
                if (i2 != 0) {
                    View view2 = new View(this.l);
                    view2.setBackgroundResource(R.drawable.griver_ui_popmenu_divider);
                    this.p.addView(view2, new ViewGroup.LayoutParams(-1, 1));
                }
                View itemView = this.g.getItemView(i2, this.p);
                itemView.setOnClickListener(this.r);
                try {
                    itemView.measure(0, 0);
                } catch (Exception unused) {
                    i = DimensionUtil.dip2px(this.l, 200.0f);
                }
                int measuredWidth = itemView.getMeasuredWidth();
                if (i <= measuredWidth) {
                    i = measuredWidth;
                }
                this.p.addView(itemView);
                if (this.f) {
                    this.j.add(itemView);
                }
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.h = ((DimensionUtil.getScreenWidth(this.l) - DimensionUtil.dip2px(this.l, 10.0f)) - i) - iArr[0];
            this.i = 0;
            PopupWindow popupWindow2 = new PopupWindow(this.f6768o, i, -2);
            this.c = popupWindow2;
            popupWindow2.setBackgroundDrawable(new ColorDrawable(0));
            this.c.setTouchable(true);
            this.c.setFocusable(true);
            this.c.setOutsideTouchable(true);
            this.c.setClippingEnabled(false);
            this.c.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.alibaba.griver.ui.titlebar.NebulaPopMenu.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    RVLogger.d(NebulaPopMenu.TAG, "popupMenu onDismiss");
                    if (NebulaPopMenu.this.f && NebulaPopMenu.this.j != null) {
                        NebulaPopMenu.this.j.clear();
                    }
                    NebulaPopMenu.this.m.removeView(NebulaPopMenu.this.k);
                    NebulaPopMenu.this.p.removeAllViews();
                }
            });
            this.m.addView(this.k, this.n);
            try {
                this.c.showAsDropDown(view, this.h, this.i);
                this.c.update();
            } catch (Throwable th) {
                RVLogger.e(TAG, th);
            }
        }
    }

    public List<PopMenuItem> getMenuItemList() {
        return this.f6767a;
    }

    private void b() {
        ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null);
        this.g = new NebulaPopMenuItemHolder();
        List<PopMenuItem> synchronizedList = Collections.synchronizedList(new ArrayList());
        this.f6767a = synchronizedList;
        this.g.setList(synchronizedList);
    }

    private void c() {
        if (this.l == null || this.k != null) {
            return;
        }
        a();
        View view = new View(this.l);
        this.k = view;
        view.setBackgroundColor(-16777216);
        this.k.setAlpha(0.4f);
        this.n = new ViewGroup.LayoutParams(-1, -1);
        LayoutInflater layoutInflater = (LayoutInflater) this.l.getSystemService("layout_inflater");
        if (layoutInflater != null) {
            View inflate = layoutInflater.inflate(R.layout.griver_ui_popmenu, (ViewGroup) this.m, false);
            this.f6768o = inflate;
            this.p = (LinearLayout) inflate.findViewById(R.id.h5_popmenu_container);
        }
    }

    private void a(int i) {
        List<View> list;
        if (!this.f || (list = this.j) == null || list.isEmpty()) {
            return;
        }
        ((ImageView) this.j.get(i).findViewById(R.id.h5_iv_icon)).setImageDrawable(this.f6767a.get(i).icon);
    }

    private void d() {
        for (PopMenuItem popMenuItem : this.f6767a) {
            String str = popMenuItem.iconUrl;
            boolean z = popMenuItem.iconDownloading;
            final String str2 = popMenuItem.name;
            if (!TextUtils.isEmpty(str) && !z) {
                if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    a(str2, ImageUtils.byteToDrawable(str));
                } else {
                    ImageUtils.loadImage(str, new ImageListener() { // from class: com.alibaba.griver.ui.titlebar.NebulaPopMenu.3
                        @Override // com.alibaba.griver.base.common.adapter.ImageListener
                        public void onImage(Bitmap bitmap) {
                            NebulaPopMenu.this.a(str2, new BitmapDrawable(bitmap));
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        r2.icon = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        if (r4.f == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        a(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r5, android.graphics.drawable.Drawable r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L35
            if (r0 != 0) goto L33
            if (r6 == 0) goto L33
            r0 = 0
            java.util.List<com.alibaba.griver.ui.titlebar.PopMenuItem> r1 = r4.f6767a     // Catch: java.lang.Throwable -> L35
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L35
        L10:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L35
            if (r2 == 0) goto L31
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L35
            com.alibaba.griver.ui.titlebar.PopMenuItem r2 = (com.alibaba.griver.ui.titlebar.PopMenuItem) r2     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = r2.name     // Catch: java.lang.Throwable -> L35
            boolean r3 = android.text.TextUtils.equals(r3, r5)     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto L2e
            r2.icon = r6     // Catch: java.lang.Throwable -> L35
            boolean r5 = r4.f     // Catch: java.lang.Throwable -> L35
            if (r5 == 0) goto L31
            r4.a(r0)     // Catch: java.lang.Throwable -> L35
            goto L31
        L2e:
            int r0 = r0 + 1
            goto L10
        L31:
            monitor-exit(r4)
            return
        L33:
            monitor-exit(r4)
            return
        L35:
            r5 = move-exception
            monitor-exit(r4)
            goto L39
        L38:
            throw r5
        L39:
            goto L38
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.titlebar.NebulaPopMenu.a(java.lang.String, android.graphics.drawable.Drawable):void");
    }

    private boolean a(String str, String str2) {
        for (PopMenuItem popMenuItem : this.f6767a) {
            if (popMenuItem.name.equals(str) || popMenuItem.tag.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private Drawable a(String str) {
        Resources resources = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null);
        if ("ppchatReportAbuse".equals(str)) {
            return InstrumentInjector.Resources_getDrawable(resources, R.drawable.griver_ui_nav_complain);
        }
        if ("ppchatShare".equals(str) || "shareFriend".equals(str)) {
            return InstrumentInjector.Resources_getDrawable(resources, R.drawable.griver_ui_nav_share_friend);
        }
        return InstrumentInjector.Resources_getDrawable(resources, R.drawable.griver_ui_nav_default);
    }
}
