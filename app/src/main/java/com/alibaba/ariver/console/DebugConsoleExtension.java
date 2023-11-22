package com.alibaba.ariver.console;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.console.view.ConsoleToggleButton;
import com.alibaba.ariver.console.view.IConsoleView;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.DisplayUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.R;
import com.alibaba.fastjson.JSONObject;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class DebugConsoleExtension implements View.OnClickListener, DebugConsolePoint, NodeAware<App> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<App> f6010a;
    private IConsoleView b;
    private ViewGroup c;
    private ConsoleToggleButton d;
    private boolean e;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.console.DebugConsolePoint
    public void sendMsgToConsoleView(JSONObject jSONObject) {
        IConsoleView iConsoleView = this.b;
        if (iConsoleView == null) {
            return;
        }
        iConsoleView.sendMsg("onTinyDebugConsole", jSONObject);
    }

    @Override // com.alibaba.ariver.console.DebugConsolePoint
    public void showToggleButton(boolean z) {
        App d = d();
        if (d == null) {
            RVLogger.e("AriverRemoteDebug:DebugConsoleExtension", "showToggleButton app is null.");
            return;
        }
        ConsoleToggleButton consoleToggleButton = this.d;
        if (consoleToggleButton == null && z) {
            c();
            ((RVDebugConsoleProxy) RVProxy.get(RVDebugConsoleProxy.class)).setToggleButtonVisible(d.getAppId(), true);
            a();
            return;
        }
        if (consoleToggleButton != null) {
            consoleToggleButton.setVisibility(z ? 0 : 8);
        }
        ((RVDebugConsoleProxy) RVProxy.get(RVDebugConsoleProxy.class)).setToggleButtonVisible(d.getAppId(), z);
    }

    @Override // com.alibaba.ariver.console.DebugConsolePoint
    public void toggleConsoleView() {
        ViewGroup viewGroup = this.c;
        if (viewGroup == null || this.b == null || this.e) {
            RVLogger.e("AriverRemoteDebug:DebugConsoleExtension", "Console View is not created!");
            return;
        }
        this.c.setVisibility(viewGroup.getVisibility() == 0 ? 8 : 0);
    }

    @Override // com.alibaba.ariver.console.DebugConsolePoint
    public boolean isDebugPanelExists() {
        return (this.b == null || this.e) ? false : true;
    }

    private void a() {
        Activity e = e();
        if (e == null) {
            return;
        }
        if (this.e) {
            RVLogger.d("AriverRemoteDebug:DebugConsoleExtension", "[createConsoleView] view creating!");
            return;
        }
        App d = d();
        if (d == null) {
            RVLogger.d("AriverRemoteDebug:DebugConsoleExtension", "[createConsoleView] app is null.");
            return;
        }
        this.e = true;
        ((RVDebugConsoleProxy) RVProxy.get(RVDebugConsoleProxy.class)).initConsoleView(e, d.getStartToken(), new ConsoleViewCreateCallback() { // from class: com.alibaba.ariver.console.DebugConsoleExtension.1
            @Override // com.alibaba.ariver.console.ConsoleViewCreateCallback
            public void onConsoleViewCreated(IConsoleView iConsoleView) {
                DebugConsoleExtension.this.b = iConsoleView;
                DebugConsoleExtension.this.b();
                DebugConsoleExtension.this.e = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Activity e;
        IConsoleView iConsoleView = this.b;
        if (iConsoleView == null || iConsoleView.getView() == null || (e = e()) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) e.findViewById(16908290);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = DisplayUtils.getTitleAndStatusBarHeight(e);
        FrameLayout frameLayout = new FrameLayout(e);
        frameLayout.setVisibility(8);
        viewGroup.addView(frameLayout, layoutParams);
        frameLayout.setBackgroundColor(1996488704);
        frameLayout.bringToFront();
        frameLayout.setOnClickListener(this);
        this.c = frameLayout;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, ((RVDebugConsoleProxy) RVProxy.get(RVDebugConsoleProxy.class)).getDebugConsoleViewHeight(e));
        layoutParams2.gravity = 80;
        frameLayout.addView(this.b.getView(), layoutParams2);
    }

    @Override // com.alibaba.ariver.console.DebugConsolePoint
    public void removeConsoleView() {
        Activity e = e();
        if (e == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) e.findViewById(16908290);
        IConsoleView iConsoleView = this.b;
        if (iConsoleView != null) {
            View view = iConsoleView.getView();
            if (view != null) {
                viewGroup.removeView(view);
            }
            this.b.destroy();
        }
        ViewGroup viewGroup2 = this.c;
        if (viewGroup2 != null) {
            viewGroup.removeView(viewGroup2);
        }
    }

    private void c() {
        RVLogger.d("AriverRemoteDebug:DebugConsoleExtension", "[initToggleButton]");
        Activity e = e();
        if (e == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) e.findViewById(16908290);
        this.d = new ConsoleToggleButton(e);
        this.d.setBackgroundColor(((RVDebugConsoleProxy) RVProxy.get(RVDebugConsoleProxy.class)).getConsoleToggleButtonColor(e));
        this.d.setText(R.string.console_toggle_button_text);
        this.d.setTextSize(15.0f);
        this.d.setTextColor(-1);
        this.d.setPadding(18, 12, 18, 12);
        int titleAndStatusBarHeight = DisplayUtils.getTitleAndStatusBarHeight(e);
        this.d.setRange(DimensionUtil.getScreenWidth(e), DimensionUtil.getScreenHeight(e) - titleAndStatusBarHeight);
        this.d.setOnClickListener(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = 200;
        layoutParams.rightMargin = 30;
        viewGroup.addView(this.d, layoutParams);
        this.d.bringToFront();
    }

    private App d() {
        WeakReference<App> weakReference = this.f6010a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private Activity e() {
        AppContext appContext;
        App d = d();
        if (d == null || (appContext = d.getAppContext()) == null) {
            return null;
        }
        Context context = appContext.getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        this.f6010a = weakReference;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d) {
            toggleConsoleView();
        } else if (view == this.c) {
            toggleConsoleView();
        }
    }
}
