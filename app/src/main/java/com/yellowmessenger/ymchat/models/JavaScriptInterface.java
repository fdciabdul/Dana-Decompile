package com.yellowmessenger.ymchat.models;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.gson.Gson;
import com.yellowmessenger.ymchat.YMChat;

/* loaded from: classes8.dex */
public class JavaScriptInterface {
    protected WebView BuiltInFictitiousFunctionClassFactory;
    protected Activity getAuthRequestContext;

    public JavaScriptInterface(Activity activity, WebView webView) {
        this.getAuthRequestContext = activity;
        this.BuiltInFictitiousFunctionClassFactory = webView;
    }

    @JavascriptInterface
    public void loadURL(final String str) {
        this.getAuthRequestContext.runOnUiThread(new Runnable() { // from class: com.yellowmessenger.ymchat.models.JavaScriptInterface.1
            @Override // java.lang.Runnable
            public void run() {
                WebView webView = JavaScriptInterface.this.BuiltInFictitiousFunctionClassFactory;
                String str2 = str;
                InstrumentInjector.trackWebView(webView);
                webView.loadUrl(str2);
            }
        });
    }

    @JavascriptInterface
    public void receiveMessage(String str) {
        YMBotEventResponse yMBotEventResponse;
        try {
            yMBotEventResponse = (YMBotEventResponse) new Gson().fromJson(str, YMBotEventResponse.class);
        } catch (Exception unused) {
            yMBotEventResponse = new YMBotEventResponse(null, null);
        }
        if (yMBotEventResponse.PlaceComponentResult != null && ("close-bot".equals(yMBotEventResponse.PlaceComponentResult) || "upload-image".equals(yMBotEventResponse.PlaceComponentResult))) {
            yMBotEventResponse.BuiltInFictitiousFunctionClassFactory = true;
        }
        if (yMBotEventResponse.PlaceComponentResult()) {
            YMChat.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(yMBotEventResponse);
        } else {
            YMChat.KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2(yMBotEventResponse);
        }
    }
}
