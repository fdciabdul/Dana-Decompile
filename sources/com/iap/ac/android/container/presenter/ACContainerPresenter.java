package com.iap.ac.android.container.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.common.container.IContainerPresenter;
import com.iap.ac.android.common.container.provider.ContainerUaProvider;
import com.iap.ac.android.common.container.utils.ContainerUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.ACMonitor;
import com.iap.ac.android.common.log.event.LogEvent;
import com.iap.ac.android.container.ACContainer;
import com.iap.ac.android.container.BuildConfig;
import com.iap.ac.android.container.R;
import com.iap.ac.android.container.activity.ACContainerActivity;
import com.iap.ac.android.container.activity.H5NetworkCheckActivity;
import com.iap.ac.android.container.constant.LogEventKeys;
import com.iap.ac.android.container.constant.LogEventName;
import com.iap.ac.android.container.js.plugin.ACContainerJSPlugin;
import com.iap.ac.android.container.utils.ResourceUtils;
import com.iap.ac.android.container.view.IContainerView;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.data.here.HereOauthManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ACContainerPresenter implements IContainerPresenter {
    private static final String TAG = "ContainerPresenter";
    private String bizCode;
    private IContainerView containerView;
    private ACContainerActivity mContext;
    private WebView mWebView;

    public ACContainerPresenter(ACContainerActivity aCContainerActivity, IContainerView iContainerView, String str) {
        this.mContext = aCContainerActivity;
        this.containerView = iContainerView;
        this.bizCode = str;
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void setTitle(String str) {
        IContainerView iContainerView;
        if (TextUtils.isEmpty(str) || (iContainerView = this.containerView) == null) {
            return;
        }
        iContainerView.setTitle(str);
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void reloadPage() {
        WebView webView = this.mWebView;
        if (webView == null) {
            ACLog.e(TAG, "reloadPage error: mWebView is null!");
        } else {
            webView.reload();
        }
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void loadUrl(final String str) {
        ACContainerActivity aCContainerActivity;
        if (this.mWebView == null || (aCContainerActivity = this.mContext) == null || !ContainerUtils.isActivityRunning(aCContainerActivity)) {
            ACLog.e(TAG, "loadUrl error: mWebView or mContext is null!");
        } else if (!TextUtils.isEmpty(str)) {
            this.mContext.runOnUiThread(new Runnable() { // from class: com.iap.ac.android.container.presenter.ACContainerPresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    WebView webView = ACContainerPresenter.this.mWebView;
                    String str2 = str;
                    InstrumentInjector.trackWebView(webView);
                    webView.loadUrl(str2);
                }
            });
        } else {
            this.mContext.runOnUiThread(new Runnable() { // from class: com.iap.ac.android.container.presenter.ACContainerPresenter.2
                @Override // java.lang.Runnable
                public void run() {
                    ACContainerPresenter aCContainerPresenter = ACContainerPresenter.this;
                    aCContainerPresenter.showDefaultErrorPage(str, -12, aCContainerPresenter.mContext.getResources().getString(R.string.h5_url_error));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDefaultErrorPage(String str, int i, String str2) {
        CharSequence charSequence;
        String str3;
        CharSequence charSequence2;
        CharSequence charSequence3;
        String replace;
        ACContainerActivity aCContainerActivity = this.mContext;
        if (aCContainerActivity == null || this.mWebView == null) {
            return;
        }
        Resources resources = aCContainerActivity.getResources();
        if (resources != null) {
            charSequence = resources.getString(R.string.h5_loading_failed);
            str3 = resources.getString(R.string.h5_menu_refresh);
            charSequence2 = resources.getString(R.string.h5_network_check);
            charSequence3 = resources.getString(R.string.h5_close);
        } else {
            charSequence = "";
            str3 = charSequence;
            charSequence2 = str3;
            charSequence3 = charSequence2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("showDefaultErrorPage buttonText ");
        sb.append(str3);
        ACLog.d(TAG, sb.toString());
        String readRawFromResource = ResourceUtils.readRawFromResource(R.raw.h5_page_error, resources);
        if (TextUtils.isEmpty(readRawFromResource)) {
            return;
        }
        if (!ACContainer.DEBUG) {
            readRawFromResource = removeDebugStub(readRawFromResource);
        }
        String replace2 = readRawFromResource.replace("####", str3).replace("****", charSequence2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        sb2.append(": ");
        sb2.append(str2);
        String replace3 = replace2.replaceAll("&&&&", sb2.toString()).replace("!!!!", charSequence);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i);
        String replace4 = replace3.replace("$$$$", sb3.toString()).replace("^^^^", charSequence3);
        if (!TextUtils.isEmpty(str)) {
            replace = replace4.replace("%%%%", str);
        } else {
            replace = replace4.replace("%%%%", "");
        }
        String replace5 = replace.replace("@@@@", ACContainerJSPlugin.SHOW_NETWORK_CHECK_ACTIVITY);
        WebView webView = this.mWebView;
        InstrumentInjector.trackWebView(webView);
        webView.loadDataWithBaseURL(str, replace5, "text/html", HereOauthManager.ENC, str);
    }

    private String removeDebugStub(String str) {
        return str.replace("id=\"networkCheck\"", "id=\"networkCheck\" style=\"display: none\" ");
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void postUrl(String str, byte[] bArr) {
        if (this.mWebView == null) {
            ACLog.e(TAG, "postUrl error: mWebView is null!");
        } else if (!TextUtils.isEmpty(str)) {
            WebView webView = this.mWebView;
            InstrumentInjector.trackWebView(webView);
            webView.postUrl(str, bArr);
        } else {
            showDefaultErrorPage(str, -12, this.mContext.getResources().getString(R.string.h5_url_error));
        }
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void closeWebview() {
        ACContainerActivity aCContainerActivity = this.mContext;
        if (aCContainerActivity != null) {
            aCContainerActivity.finish();
        }
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void showNetWorkCheckActivity(Map<String, String> map) {
        if (map == null || map.isEmpty() || this.mContext == null) {
            return;
        }
        String str = map.get(TrackerKey.Property.ERROR_CODE_FIREBASE);
        String str2 = map.get("url");
        String str3 = map.get(ZdocRecordService.REASON);
        Intent intent = new Intent(this.mContext, H5NetworkCheckActivity.class);
        intent.putExtra(TrackerKey.Property.ERROR_CODE_FIREBASE, str);
        intent.putExtra("url", str2);
        intent.putExtra(ZdocRecordService.REASON, str3);
        this.mContext.startActivity(intent);
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public Activity getActivity() {
        return this.mContext;
    }

    public void onProgressChanged(int i) {
        IContainerView iContainerView = this.containerView;
        if (iContainerView != null) {
            iContainerView.onProgressChanged(i);
        }
    }

    public void setWebView(WebView webView) {
        this.mWebView = webView;
        setWebView();
    }

    private void setWebView() {
        WebView webView = this.mWebView;
        if (webView == null) {
            return;
        }
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName(HereOauthManager.ENC);
        settings.setSupportZoom(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAllowFileAccess(false);
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        try {
            ContainerUaProvider containerUaProvider = (ContainerUaProvider) ACContainer.INSTANCE.getProvider(ContainerUaProvider.class.getName());
            if (containerUaProvider != null) {
                settings.setUserAgentString(containerUaProvider.getUa(settings.getUserAgentString()));
            }
            StringBuilder sb = new StringBuilder();
            sb.append("setWebView: UA = ");
            sb.append(settings.getUserAgentString());
            ACLog.d(TAG, sb.toString());
        } catch (ClassCastException e) {
            ACLog.e(TAG, "get UA provider error! ", e);
            HashMap hashMap = new HashMap();
            hashMap.put(LogEventKeys.SDK_VERSION, BuildConfig.VERSION_NAME);
            ACContainerActivity aCContainerActivity = this.mContext;
            if (aCContainerActivity != null && aCContainerActivity.getIntent() != null) {
                hashMap.put("url", this.mContext.getIntent().getStringExtra("url"));
            }
            ACMonitor.getInstance(this.bizCode).logEvent(new LogEvent(LogEventName.SET_UA_FAIL, hashMap));
        }
        InstrumentInjector.setWebViewClient(this.mWebView, new ACWebViewClient(this.mContext, this.mWebView, this, this.bizCode));
        this.mWebView.setWebChromeClient(new ACWebChromeClient(this.mWebView, this, this.bizCode));
        if (Build.VERSION.SDK_INT < 17) {
            this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            this.mWebView.removeJavascriptInterface("accessibility");
            this.mWebView.removeJavascriptInterface("accessibilityTraversal");
        }
    }

    public void onPageFinished(String str) {
        IContainerView iContainerView = this.containerView;
        if (iContainerView != null) {
            iContainerView.onPageFinished(str);
        }
    }

    public void onPageStarted(String str) {
        IContainerView iContainerView = this.containerView;
        if (iContainerView != null) {
            iContainerView.onPageStarted(str);
        }
    }
}
