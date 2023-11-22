package com.alibaba.griver.core.ui.menu;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.api.common.menu.GRVBaseAppFavoriteMenuItem;
import com.alibaba.griver.api.common.menu.GriverMenuItem;
import com.alibaba.griver.api.open.GriverAboutUrlExtension;
import com.alibaba.griver.api.ui.optionmenu.GriverOptionMenuPanelExtension;
import com.alibaba.griver.base.common.adapter.ImageListener;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.base.common.utils.MapBuilder;
import com.alibaba.griver.base.common.utils.MonitorUtil;
import com.alibaba.griver.base.ui.widget.GriverBottomPopupDialog;
import com.alibaba.griver.core.Griver;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.jsapi.aboutinfo.AboutInfoBridgeExtension;
import com.alibaba.griver.ui.ant.api.OnItemClickListener;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import com.iap.ac.android.acs.operation.biz.region.bean.MenuExtraInfo;
import com.iap.ac.android.container.adapter.griver.extension.CustomMenuExtensionImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes6.dex */
public class UniformOptionMenuPanelExtensionImpl implements GriverOptionMenuPanelExtension {

    /* renamed from: a  reason: collision with root package name */
    private Handler f6472a = new Handler(Looper.getMainLooper());
    private RecyclerView b;
    private RecyclerView c;
    private TextView d;
    private ImageView e;
    private ImageView f;
    private TextView g;
    private OptionMenuRecyclerAdapter h;
    private OptionMenuRecyclerAdapter i;
    private GriverBottomPopupDialog j;
    private List<GriverMenuItem> k;
    private List<GriverMenuItem> l;
    private List<GriverMenuItem> m;

    @Override // com.alibaba.griver.api.ui.optionmenu.GriverOptionMenuPanelExtension
    public void showOptionMenuPanel(Page page, List<GriverMenuItem> list) {
        if (page == null || page.getPageContext() == null) {
            return;
        }
        this.m = list;
        a(page);
        Activity activity = page.getPageContext().getActivity();
        View inflate = LayoutInflater.from(activity).inflate(R.layout.griver_core_panel_option_menu, (ViewGroup) null);
        this.j = new GriverBottomPopupDialog(activity, inflate);
        a(page, inflate);
        d(page);
        b(page);
    }

    private void a(Page page) {
        this.k = new ArrayList();
        this.l = new ArrayList();
        for (GriverMenuItem griverMenuItem : this.m) {
            if (griverMenuItem.row == 1) {
                this.k.add(griverMenuItem);
                Collections.sort(this.k, new Comparator<GriverMenuItem>() { // from class: com.alibaba.griver.core.ui.menu.UniformOptionMenuPanelExtensionImpl.1
                    @Override // java.util.Comparator
                    public int compare(GriverMenuItem griverMenuItem2, GriverMenuItem griverMenuItem3) {
                        return griverMenuItem2.priority.getValue() - griverMenuItem3.priority.getValue();
                    }
                });
            } else if (griverMenuItem.row == 2) {
                this.l.add(griverMenuItem);
                Collections.sort(this.l, new Comparator<GriverMenuItem>() { // from class: com.alibaba.griver.core.ui.menu.UniformOptionMenuPanelExtensionImpl.2
                    @Override // java.util.Comparator
                    public int compare(GriverMenuItem griverMenuItem2, GriverMenuItem griverMenuItem3) {
                        return griverMenuItem2.priority.getValue() - griverMenuItem3.priority.getValue();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Page page, GriverMenuItem griverMenuItem) {
        this.j.dismiss();
        if (griverMenuItem.listener != null) {
            if (griverMenuItem instanceof GRVBaseAppFavoriteMenuItem) {
                MonitorUtil.trackMenuClick(CustomMenuExtensionImpl.TYPE_FAVORITE, new MapBuilder.Builder().map("action", ((GRVBaseAppFavoriteMenuItem) griverMenuItem).getAppFavoriteStatus() == 1 ? "remove" : ZolozEkycH5Handler.HUMMER_FOUNDATION_ADD).map("from", MenuExtraInfo.MENU_ID_PANEL_COLLECT).build());
            } else {
                MonitorUtil.trackOtherMenu(griverMenuItem);
            }
            griverMenuItem.listener.onItemClick(page, griverMenuItem.identifier);
        }
    }

    private void b(final Page page) {
        this.h.setOnItemClickListener(new OnItemClickListener() { // from class: com.alibaba.griver.core.ui.menu.UniformOptionMenuPanelExtensionImpl.3
            @Override // com.alibaba.griver.ui.ant.api.OnItemClickListener
            public void onClick(View view, int i) {
                UniformOptionMenuPanelExtensionImpl uniformOptionMenuPanelExtensionImpl = UniformOptionMenuPanelExtensionImpl.this;
                uniformOptionMenuPanelExtensionImpl.a(page, (GriverMenuItem) uniformOptionMenuPanelExtensionImpl.k.get(i));
            }
        });
        this.i.setOnItemClickListener(new OnItemClickListener() { // from class: com.alibaba.griver.core.ui.menu.UniformOptionMenuPanelExtensionImpl.4
            @Override // com.alibaba.griver.ui.ant.api.OnItemClickListener
            public void onClick(View view, int i) {
                UniformOptionMenuPanelExtensionImpl uniformOptionMenuPanelExtensionImpl = UniformOptionMenuPanelExtensionImpl.this;
                uniformOptionMenuPanelExtensionImpl.a(page, (GriverMenuItem) uniformOptionMenuPanelExtensionImpl.l.get(i));
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.core.ui.menu.UniformOptionMenuPanelExtensionImpl.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UniformOptionMenuPanelExtensionImpl.this.j.dismiss();
            }
        });
        GoToAboutClickListener goToAboutClickListener = new GoToAboutClickListener(page);
        this.d.setOnClickListener(goToAboutClickListener);
        this.e.setOnClickListener(goToAboutClickListener);
        this.f.setOnClickListener(goToAboutClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Page page) {
        this.j.dismiss();
        if (page == null) {
            return;
        }
        String aboutUrl = ((GriverAboutUrlExtension) RVProxy.get(GriverAboutUrlExtension.class)).getAboutUrl(page);
        if (TextUtils.isEmpty(aboutUrl)) {
            GriverLogger.w("CustomOptionMenuPanelExtensionImpl", "no about url integrated, do not open");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(AboutInfoBridgeExtension.PARAM_QUERY_APP_ID, page.getApp().getAppId());
        bundle.putString(AboutInfoBridgeExtension.PARAM_QUERY_APP_VERSION, AppInfoUtils.getDeveloperVersion((AppModel) page.getApp().getData(AppModel.class)));
        Griver.openUrl(GriverEnv.getApplicationContext(), aboutUrl, bundle);
    }

    private void d(Page page) {
        PageContext pageContext = page.getPageContext();
        if (pageContext == null || pageContext.getActivity() == null) {
            GriverLogger.e("CustomOptionMenuPanelExtensionImpl", "initData failed, pageContext is null or activity is null");
            return;
        }
        this.h = new OptionMenuRecyclerAdapter(pageContext.getActivity(), page.getApp().getAppId(), this.k);
        this.i = new OptionMenuRecyclerAdapter(pageContext.getActivity(), page.getApp().getAppId(), this.l);
        this.b.setAdapter(this.h);
        this.c.setAdapter(this.i);
    }

    private void a(Page page, View view) {
        PageContext pageContext = page.getPageContext();
        if (pageContext == null || pageContext.getActivity() == null) {
            GriverLogger.e("CustomOptionMenuPanelExtensionImpl", "initView failed, pageContext is null or activity is null");
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(pageContext.getActivity());
        linearLayoutManager.setOrientation(0);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_user);
        this.b = recyclerView;
        recyclerView.setLayoutManager(linearLayoutManager);
        this.b.setItemAnimator(new DefaultItemAnimator());
        this.c = (RecyclerView) view.findViewById(R.id.recycler_view_app);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(pageContext.getActivity());
        linearLayoutManager2.setOrientation(0);
        this.c.setLayoutManager(linearLayoutManager2);
        this.c.setItemAnimator(new DefaultItemAnimator());
        if (this.k.size() == 0) {
            this.b.setVisibility(8);
        }
        if (this.l.size() == 0) {
            this.c.setVisibility(8);
        }
        this.d = (TextView) view.findViewById(R.id.tv_name);
        this.e = (ImageView) view.findViewById(R.id.iv_icon);
        this.f = (ImageView) view.findViewById(R.id.iv_more);
        this.g = (TextView) view.findViewById(R.id.tv_cancel);
        AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
        ImageUtils.loadImage(appModel.getAppInfoModel().getLogo(), new ImageListener() { // from class: com.alibaba.griver.core.ui.menu.UniformOptionMenuPanelExtensionImpl.6
            @Override // com.alibaba.griver.base.common.adapter.ImageListener
            public void onImage(Bitmap bitmap) {
                UniformOptionMenuPanelExtensionImpl.this.e.setImageBitmap(bitmap);
            }
        });
        this.d.setText(appModel.getAppInfoModel().getName());
        this.j.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class GoToAboutClickListener implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<Page> f6473a;

        public GoToAboutClickListener(Page page) {
            this.f6473a = new WeakReference<>(page);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UniformOptionMenuPanelExtensionImpl.this.c(this.f6473a.get());
        }
    }
}
