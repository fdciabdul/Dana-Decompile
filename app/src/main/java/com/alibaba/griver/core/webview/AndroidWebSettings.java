package com.alibaba.griver.core.webview;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.api.APWebSettings;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
final class AndroidWebSettings implements APWebSettings {
    public static final String TAG = "AndroidWebSettings";

    /* renamed from: a  reason: collision with root package name */
    private static Method f6488a;
    private WebSettings b;

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final String getDefaultUserAgent(Context context) {
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setAppCacheEnabled(boolean z) {
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setAppCachePath(String str) {
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setEnableFastScroller(boolean z) {
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setPageCacheCapacity(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidWebSettings(WebSettings webSettings) {
        this.b = webSettings;
        if (webSettings == null || Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (f6488a == null) {
            try {
                f6488a = this.b.getClass().getMethod("setMixedContentMode", Integer.TYPE);
            } catch (NoSuchMethodException e) {
                RVLogger.e(TAG, "Exception", e);
            }
        }
        Method method = f6488a;
        if (method != null) {
            try {
                method.invoke(this.b, 0);
            } catch (IllegalAccessException e2) {
                RVLogger.e(TAG, "AndroidWebSettings IllegalAccessException", e2);
            } catch (InvocationTargetException e3) {
                RVLogger.e(TAG, "AndroidWebSettings InvocationTargetException", e3);
            }
        }
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setSupportZoom(boolean z) {
        this.b.setSupportZoom(z);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean supportZoom() {
        return this.b.supportZoom();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getMediaPlaybackRequiresUserGesture() {
        if (Build.VERSION.SDK_INT >= 17) {
            return this.b.getMediaPlaybackRequiresUserGesture();
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                this.b.setMediaPlaybackRequiresUserGesture(z);
            } catch (NoSuchMethodError e) {
                RVLogger.e(TAG, "There is no method some models.", e);
            }
        }
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getBuiltInZoomControls() {
        return this.b.getBuiltInZoomControls();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setBuiltInZoomControls(boolean z) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.b.setBuiltInZoomControls(z);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getDisplayZoomControls() {
        if (Build.VERSION.SDK_INT >= 11) {
            return this.b.getDisplayZoomControls();
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setDisplayZoomControls(boolean z) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.b.setDisplayZoomControls(z);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getAllowFileAccess() {
        return this.b.getAllowFileAccess();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setAllowFileAccess(boolean z) {
        this.b.setAllowFileAccess(z);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getAllowContentAccess() {
        if (Build.VERSION.SDK_INT >= 11) {
            return this.b.getAllowContentAccess();
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setAllowContentAccess(boolean z) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.b.setAllowContentAccess(z);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getLoadWithOverviewMode() {
        return this.b.getLoadWithOverviewMode();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setLoadWithOverviewMode(boolean z) {
        this.b.setLoadWithOverviewMode(z);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getSaveFormData() {
        return this.b.getSaveFormData();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setSaveFormData(boolean z) {
        this.b.setSaveFormData(z);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getSavePassword() {
        return this.b.getSavePassword();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setSavePassword(boolean z) {
        this.b.setSavePassword(z);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final int getTextZoom() {
        if (Build.VERSION.SDK_INT >= 14) {
            return this.b.getTextZoom();
        }
        return 10;
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setTextZoom(int i) {
        if (Build.VERSION.SDK_INT >= 14) {
            this.b.setTextZoom(i);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final APWebSettings.TextSize getTextSize() {
        return APWebSettings.TextSize.valueOf(this.b.getTextSize().name());
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setTextSize(APWebSettings.TextSize textSize) {
        WebSettings.TextSize textSize2;
        int i = AnonymousClass1.$SwitchMap$com$alibaba$griver$base$api$APWebSettings$TextSize[textSize.ordinal()];
        if (i == 1) {
            textSize2 = WebSettings.TextSize.LARGER;
        } else if (i == 2) {
            textSize2 = WebSettings.TextSize.LARGEST;
        } else if (i == 3) {
            textSize2 = WebSettings.TextSize.NORMAL;
        } else if (i == 4) {
            textSize2 = WebSettings.TextSize.SMALLER;
        } else {
            textSize2 = i != 5 ? null : WebSettings.TextSize.SMALLEST;
        }
        if (textSize2 != null) {
            this.b.setTextSize(textSize2);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final APWebSettings.ZoomDensity getDefaultZoom() {
        return APWebSettings.ZoomDensity.valueOf(this.b.getDefaultZoom().name());
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getUseWideViewPort() {
        return this.b.getUseWideViewPort();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setUseWideViewPort(boolean z) {
        this.b.setUseWideViewPort(z);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setSupportMultipleWindows(boolean z) {
        this.b.setSupportMultipleWindows(z);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean supportMultipleWindows() {
        return this.b.supportMultipleWindows();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final APWebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return APWebSettings.LayoutAlgorithm.valueOf(this.b.getLayoutAlgorithm().name());
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setLayoutAlgorithm(APWebSettings.LayoutAlgorithm layoutAlgorithm) {
        WebSettings.LayoutAlgorithm layoutAlgorithm2;
        int i = AnonymousClass1.$SwitchMap$com$alibaba$griver$base$api$APWebSettings$LayoutAlgorithm[layoutAlgorithm.ordinal()];
        if (i == 1) {
            layoutAlgorithm2 = WebSettings.LayoutAlgorithm.NARROW_COLUMNS;
        } else if (i == 2) {
            layoutAlgorithm2 = WebSettings.LayoutAlgorithm.NORMAL;
        } else if (i == 3) {
            layoutAlgorithm2 = WebSettings.LayoutAlgorithm.SINGLE_COLUMN;
        } else {
            layoutAlgorithm2 = (i != 4 || Build.VERSION.SDK_INT < 19) ? null : WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING;
        }
        if (layoutAlgorithm2 != null) {
            this.b.setLayoutAlgorithm(layoutAlgorithm2);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final String getStandardFontFamily() {
        return this.b.getStandardFontFamily();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setStandardFontFamily(String str) {
        this.b.setStandardFontFamily(str);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final String getFixedFontFamily() {
        return this.b.getFixedFontFamily();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setFixedFontFamily(String str) {
        this.b.setFixedFontFamily(str);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final String getSansSerifFontFamily() {
        return this.b.getSansSerifFontFamily();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setSansSerifFontFamily(String str) {
        this.b.setSansSerifFontFamily(str);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final String getSerifFontFamily() {
        return this.b.getSerifFontFamily();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setSerifFontFamily(String str) {
        this.b.setSerifFontFamily(str);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final String getCursiveFontFamily() {
        return this.b.getCursiveFontFamily();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setCursiveFontFamily(String str) {
        this.b.setCursiveFontFamily(str);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final String getFantasyFontFamily() {
        return this.b.getFantasyFontFamily();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setFantasyFontFamily(String str) {
        this.b.setFantasyFontFamily(str);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final int getMinimumFontSize() {
        return this.b.getMinimumFontSize();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setMinimumFontSize(int i) {
        this.b.setMinimumFontSize(i);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final int getMinimumLogicalFontSize() {
        return this.b.getMinimumLogicalFontSize();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setMinimumLogicalFontSize(int i) {
        this.b.setMinimumLogicalFontSize(i);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final int getDefaultFontSize() {
        return this.b.getDefaultFontSize();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setDefaultFontSize(int i) {
        this.b.setDefaultFontSize(i);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final int getDefaultFixedFontSize() {
        return this.b.getDefaultFixedFontSize();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setDefaultFixedFontSize(int i) {
        this.b.setDefaultFixedFontSize(i);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getLoadsImagesAutomatically() {
        return this.b.getLoadsImagesAutomatically();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setLoadsImagesAutomatically(boolean z) {
        this.b.setLoadsImagesAutomatically(z);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getBlockNetworkImage() {
        return this.b.getBlockNetworkImage();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setBlockNetworkImage(boolean z) {
        this.b.setBlockNetworkImage(z);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getJavaScriptEnabled() {
        return this.b.getJavaScriptEnabled();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setJavaScriptEnabled(boolean z) {
        this.b.setJavaScriptEnabled(z);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setGeolocationDatabasePath(String str) {
        this.b.setGeolocationDatabasePath(str);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getDatabaseEnabled() {
        return this.b.getDatabaseEnabled();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setDatabaseEnabled(boolean z) {
        this.b.setDatabaseEnabled(z);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getDomStorageEnabled() {
        return this.b.getDomStorageEnabled();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setDomStorageEnabled(boolean z) {
        this.b.setDomStorageEnabled(z);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final String getDatabasePath() {
        return this.b.getDatabasePath();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setDatabasePath(String str) {
        this.b.setDatabasePath(str);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setGeolocationEnabled(boolean z) {
        this.b.setGeolocationEnabled(z);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getAllowUniversalAccessFromFileURLs() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.b.getAllowUniversalAccessFromFileURLs();
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setAllowUniversalAccessFromFileURLs(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.b.setAllowUniversalAccessFromFileURLs(z);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getAllowFileAccessFromFileURLs() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.b.getAllowFileAccessFromFileURLs();
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setAllowFileAccessFromFileURLs(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.b.setAllowFileAccessFromFileURLs(z);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final APWebSettings.PluginState getPluginState() {
        return APWebSettings.PluginState.valueOf(this.b.getPluginState().name());
    }

    /* renamed from: com.alibaba.griver.core.webview.AndroidWebSettings$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$griver$base$api$APWebSettings$LayoutAlgorithm;
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$griver$base$api$APWebSettings$PluginState;
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$griver$base$api$APWebSettings$TextSize;

        static {
            int[] iArr = new int[APWebSettings.PluginState.values().length];
            $SwitchMap$com$alibaba$griver$base$api$APWebSettings$PluginState = iArr;
            try {
                iArr[APWebSettings.PluginState.OFF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$griver$base$api$APWebSettings$PluginState[APWebSettings.PluginState.ON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$griver$base$api$APWebSettings$PluginState[APWebSettings.PluginState.ON_DEMAND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[APWebSettings.LayoutAlgorithm.values().length];
            $SwitchMap$com$alibaba$griver$base$api$APWebSettings$LayoutAlgorithm = iArr2;
            try {
                iArr2[APWebSettings.LayoutAlgorithm.NARROW_COLUMNS.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$griver$base$api$APWebSettings$LayoutAlgorithm[APWebSettings.LayoutAlgorithm.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$griver$base$api$APWebSettings$LayoutAlgorithm[APWebSettings.LayoutAlgorithm.SINGLE_COLUMN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$alibaba$griver$base$api$APWebSettings$LayoutAlgorithm[APWebSettings.LayoutAlgorithm.TEXT_AUTOSIZING.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[APWebSettings.TextSize.values().length];
            $SwitchMap$com$alibaba$griver$base$api$APWebSettings$TextSize = iArr3;
            try {
                iArr3[APWebSettings.TextSize.LARGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$alibaba$griver$base$api$APWebSettings$TextSize[APWebSettings.TextSize.LARGEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$alibaba$griver$base$api$APWebSettings$TextSize[APWebSettings.TextSize.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$alibaba$griver$base$api$APWebSettings$TextSize[APWebSettings.TextSize.SMALLER.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$alibaba$griver$base$api$APWebSettings$TextSize[APWebSettings.TextSize.SMALLEST.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setPluginState(APWebSettings.PluginState pluginState) {
        int i = AnonymousClass1.$SwitchMap$com$alibaba$griver$base$api$APWebSettings$PluginState[pluginState.ordinal()];
        if (i == 1) {
            this.b.setPluginState(WebSettings.PluginState.OFF);
        } else if (i == 2) {
            this.b.setPluginState(WebSettings.PluginState.ON);
        } else if (i == 3) {
            this.b.setPluginState(WebSettings.PluginState.ON_DEMAND);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.b.getJavaScriptCanOpenWindowsAutomatically();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.b.setJavaScriptCanOpenWindowsAutomatically(z);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final String getDefaultTextEncodingName() {
        return this.b.getDefaultTextEncodingName();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setDefaultTextEncodingName(String str) {
        this.b.setDefaultTextEncodingName(str);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final String getUserAgentString() {
        return this.b.getUserAgentString();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setUserAgentString(String str) {
        this.b.setUserAgentString(str);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setNeedInitialFocus(boolean z) {
        this.b.setNeedInitialFocus(z);
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final int getCacheMode() {
        return this.b.getCacheMode();
    }

    @Override // com.alibaba.griver.base.api.APWebSettings
    public final void setCacheMode(int i) {
        this.b.setCacheMode(i);
    }
}
