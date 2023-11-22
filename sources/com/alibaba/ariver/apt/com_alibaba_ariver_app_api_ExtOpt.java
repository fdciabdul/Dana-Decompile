package com.alibaba.ariver.apt;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppLoadResult;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.Visit;
import com.alibaba.ariver.app.api.activity.StartClientBundle;
import com.alibaba.ariver.app.api.point.activity.ActivityHelperOnCreateFinishedPoint;
import com.alibaba.ariver.app.api.point.activity.ActivityOnNewIntentPoint;
import com.alibaba.ariver.app.api.point.app.AppCreatePoint;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.app.AppExitPoint;
import com.alibaba.ariver.app.api.point.app.AppInteractionPoint;
import com.alibaba.ariver.app.api.point.app.AppLeaveHintPoint;
import com.alibaba.ariver.app.api.point.app.AppLoadInterceptorPoint;
import com.alibaba.ariver.app.api.point.app.AppLoadPoint;
import com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint;
import com.alibaba.ariver.app.api.point.app.AppOnLoadResultPoint;
import com.alibaba.ariver.app.api.point.app.AppPausePoint;
import com.alibaba.ariver.app.api.point.app.AppRestartPoint;
import com.alibaba.ariver.app.api.point.app.AppResumePoint;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.app.api.point.app.BackKeyDownPoint;
import com.alibaba.ariver.app.api.point.app.PushWindowPoint;
import com.alibaba.ariver.app.api.point.biz.DisclaimerPoint;
import com.alibaba.ariver.app.api.point.biz.PageLoadUrlNoInterceptorPoint;
import com.alibaba.ariver.app.api.point.biz.PageLoadUrlPoint;
import com.alibaba.ariver.app.api.point.biz.PostNotificationPoint;
import com.alibaba.ariver.app.api.point.biz.SceneParamChangePoint;
import com.alibaba.ariver.app.api.point.biz.SnapshotPoint;
import com.alibaba.ariver.app.api.point.biz.StartParamChangePoint;
import com.alibaba.ariver.app.api.point.biz.VisitUrlPoint;
import com.alibaba.ariver.app.api.point.dialog.ActionSheetPoint;
import com.alibaba.ariver.app.api.point.dialog.AgreementConfirmPoint;
import com.alibaba.ariver.app.api.point.dialog.CreateActionSheetParam;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.app.api.point.dialog.CreatePromptParam;
import com.alibaba.ariver.app.api.point.dialog.DialogPoint;
import com.alibaba.ariver.app.api.point.dialog.PromptPoint;
import com.alibaba.ariver.app.api.point.embedview.EmbedWebviewLoadPoint;
import com.alibaba.ariver.app.api.point.engine.EngineInitFailedPoint;
import com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint;
import com.alibaba.ariver.app.api.point.error.BlankScreenPoint;
import com.alibaba.ariver.app.api.point.error.JsErrorPoint;
import com.alibaba.ariver.app.api.point.error.WebviewExceptionPoint;
import com.alibaba.ariver.app.api.point.fragment.FragmentPausePoint;
import com.alibaba.ariver.app.api.point.fragment.FragmentResumePoint;
import com.alibaba.ariver.app.api.point.page.BackPressedPoint;
import com.alibaba.ariver.app.api.point.page.PageBackPoint;
import com.alibaba.ariver.app.api.point.page.PageDestroyPoint;
import com.alibaba.ariver.app.api.point.page.PageEnterInterceptPoint;
import com.alibaba.ariver.app.api.point.page.PageEnterPoint;
import com.alibaba.ariver.app.api.point.page.PageExitInterceptPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PageHidePoint;
import com.alibaba.ariver.app.api.point.page.PageInitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PagePushInterceptPoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.app.api.point.page.PageShowLoadingPoint;
import com.alibaba.ariver.app.api.point.page.PageShowPoint;
import com.alibaba.ariver.app.api.point.page.PageStartedPoint;
import com.alibaba.ariver.app.api.point.page.PageSwitchInterceptPoint;
import com.alibaba.ariver.app.api.point.view.CollectPerformanceCallback;
import com.alibaba.ariver.app.api.point.view.CollectPerformancePoint;
import com.alibaba.ariver.app.api.point.view.KeyBoardVisiblePoint;
import com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarCloseClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarDisclaimerClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarOptionClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarSegCheckPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarShowClosePoint;
import com.alibaba.ariver.app.api.point.view.TitleBarShowFavoritesPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarTitleClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarTransparentPoint;
import com.alibaba.ariver.app.api.point.view.ToastPoint;
import com.alibaba.ariver.engine.api.bridge.model.LoadParams;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes6.dex */
public final class com_alibaba_ariver_app_api_ExtOpt {
    public static final byte[] getAuthRequestContext = {65, TarHeader.LF_CHR, -100, -34, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int PlaceComponentResult = 32;

    public static void opt2() {
    }

    public static void opt1() {
        ExtensionOpt.setupMethodInvokeOptimizer(PageInitPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.1
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onPageInit".equals(str) && objArr.length == 3) {
                    ((PageInitPoint) extension).onPageInit((String) objArr[0], (Bundle) objArr[1], (Bundle) objArr[2]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageShowPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.2
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onPageShow".equals(str) && objArr.length == 2) {
                    ((PageShowPoint) extension).onPageShow((Page) objArr[0], (JSONObject) objArr[1]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PagePushInterceptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.3
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("interceptPushPage".equals(str) && objArr.length == 3) {
                    return ((PagePushInterceptPoint) extension).interceptPushPage((App) objArr[0], (String) objArr[1], (Bundle) objArr[2]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageStartedPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.4
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onStarted".equals(str) && objArr.length == 1) {
                    ((PageStartedPoint) extension).onStarted((String) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageShowLoadingPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.5
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("showLoading".equals(str) && objArr.length == 0) {
                    ((PageShowLoadingPoint) extension).showLoading();
                }
                if ("hideLoading".equals(str) && objArr.length == 0) {
                    ((PageShowLoadingPoint) extension).hideLoading();
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(BackPressedPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.6
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("handleBackPressed".equals(str) && objArr.length == 1) {
                    return ((BackPressedPoint) extension).handleBackPressed((Page) objArr[0]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageHidePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.7
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onPageHide".equals(str) && objArr.length == 1) {
                    ((PageHidePoint) extension).onPageHide((Page) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PagePausePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.8
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onPagePause".equals(str) && objArr.length == 1) {
                    ((PagePausePoint) extension).onPagePause((Page) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageSwitchInterceptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.9
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("interceptSwitchPage".equals(str) && objArr.length == 3) {
                    return ((PageSwitchInterceptPoint) extension).interceptSwitchPage((App) objArr[0], (String) objArr[1], (Bundle) objArr[2]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageExitInterceptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.10
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("interceptPageExit".equals(str) && objArr.length == 1) {
                    return Boolean.valueOf(((PageExitInterceptPoint) extension).interceptPageExit((Page) objArr[0]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageExitPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.11
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onPageExit".equals(str) && objArr.length == 1) {
                    ((PageExitPoint) extension).onPageExit((Page) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageBackPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.12
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onBackPerformed".equals(str) && objArr.length == 1) {
                    ((PageBackPoint) extension).onBackPerformed((Page) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageEnterInterceptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.13
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("interceptLoadMainDoc".equals(str) && objArr.length == 2) {
                    return Boolean.valueOf(((PageEnterInterceptPoint) extension).interceptLoadMainDoc((Page) objArr[0], (LoadParams) objArr[1]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageResumePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.14
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onPageResume".equals(str) && objArr.length == 1) {
                    ((PageResumePoint) extension).onPageResume((Page) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageDestroyPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.15
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onPageDestroy".equals(str) && objArr.length == 1) {
                    ((PageDestroyPoint) extension).onPageDestroy((Page) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageEnterPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.16
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onPageEnter".equals(str) && objArr.length == 1) {
                    ((PageEnterPoint) extension).onPageEnter((Page) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppLoadInterceptorPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.17
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("intercept".equals(str) && objArr.length == 4) {
                    ((AppLoadInterceptorPoint) extension).intercept((String) objArr[0], (Bundle) objArr[1], (Bundle) objArr[2], (AppLoadResult) objArr[3]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppResumePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.18
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onAppResume".equals(str) && objArr.length == 1) {
                    ((AppResumePoint) extension).onAppResume((App) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppOnLoadResultPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.19
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onLoadResult".equals(str) && objArr.length == 2) {
                    ((AppOnLoadResultPoint) extension).onLoadResult((App) objArr[0], (AppLoadResult) objArr[1]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppOnConfigurationChangedPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.20
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onConfigurationChanged".equals(str) && objArr.length == 3) {
                    ((AppOnConfigurationChangedPoint) extension).onConfigurationChanged((App) objArr[0], (Configuration) objArr[1], (String) objArr[2]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppRestartPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.21
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onAppRestart".equals(str) && objArr.length == 3) {
                    return ((AppRestartPoint) extension).onAppRestart((App) objArr[0], (Bundle) objArr[1], (Bundle) objArr[2]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppPausePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.22
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onAppPause".equals(str) && objArr.length == 1) {
                    ((AppPausePoint) extension).onAppPause((App) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppInteractionPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.23
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onAppInteraction".equals(str) && objArr.length == 1) {
                    ((AppInteractionPoint) extension).onAppInteraction((App) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppStartPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.24
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onAppStart".equals(str) && objArr.length == 1) {
                    ((AppStartPoint) extension).onAppStart((App) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppLoadPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.25
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("loadApp".equals(str) && objArr.length == 4) {
                    ((AppLoadPoint) extension).loadApp((String) objArr[0], (Bundle) objArr[1], (Bundle) objArr[2], (AppLoadPoint.LoadResultCallback) objArr[3]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(BackKeyDownPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.26
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("intercept".equals(str) && objArr.length == 1) {
                    return ((BackKeyDownPoint) extension).intercept((App) objArr[0]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppLeaveHintPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.27
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onAppLeaveHint".equals(str) && objArr.length == 1) {
                    ((AppLeaveHintPoint) extension).onAppLeaveHint((App) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppCreatePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.28
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onAppCreate".equals(str) && objArr.length == 1) {
                    ((AppCreatePoint) extension).onAppCreate((App) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PushWindowPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.29
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("handlePushWindow".equals(str) && objArr.length == 4) {
                    return Boolean.valueOf(((PushWindowPoint) extension).handlePushWindow((Page) objArr[0], (String) objArr[1], (Bundle) objArr[2], (Bundle) objArr[3]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppExitPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.30
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onAppExit".equals(str) && objArr.length == 1) {
                    ((AppExitPoint) extension).onAppExit((App) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppDestroyPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.31
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onAppDestroy".equals(str) && objArr.length == 1) {
                    ((AppDestroyPoint) extension).onAppDestroy((App) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(EngineInitFailedPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.32
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onEngineInitFailed".equals(str) && objArr.length == 0) {
                    return ((EngineInitFailedPoint) extension).onEngineInitFailed();
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(EngineInitSuccessPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.33
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onInitSuccess".equals(str) && objArr.length == 0) {
                    ((EngineInitSuccessPoint) extension).onInitSuccess();
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ActivityOnNewIntentPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.34
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onNewIntent".equals(str) && objArr.length == 3) {
                    ((ActivityOnNewIntentPoint) extension).onNewIntent((App) objArr[0], (Activity) objArr[1], (Intent) objArr[2]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ActivityHelperOnCreateFinishedPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.35
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onActivityHelperOnCreateFinished".equals(str) && objArr.length == 3) {
                    ((ActivityHelperOnCreateFinishedPoint) extension).onActivityHelperOnCreateFinished((App) objArr[0], (FragmentActivity) objArr[1], (StartClientBundle) objArr[2]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TabBarInfoQueryPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.36
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("queryTabBarInfo".equals(str) && objArr.length == 1) {
                    ((TabBarInfoQueryPoint) extension).queryTabBarInfo((TabBarInfoQueryPoint.OnTabBarInfoQueryListener) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarCloseClickPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.37
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onCloseClick".equals(str) && objArr.length == 0) {
                    ((TitleBarCloseClickPoint) extension).onCloseClick();
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarShowFavoritesPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.38
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if (RVParams.LONG_SHOW_FAVORITES.equals(str) && objArr.length == 1) {
                    ((TitleBarShowFavoritesPoint) extension).showFavorites(((Boolean) objArr[0]).booleanValue());
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(KeyBoardVisiblePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.39
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onKeyboardVisible".equals(str) && objArr.length == 2) {
                    ((KeyBoardVisiblePoint) extension).onKeyboardVisible((String) objArr[0], (String) objArr[1]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(CollectPerformancePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.40
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onCollectWhenDestroy".equals(str) && objArr.length == 2) {
                    ((CollectPerformancePoint) extension).onCollectWhenDestroy((Page) objArr[0], (CollectPerformanceCallback) objArr[1]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarShowClosePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.41
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("showClose".equals(str) && objArr.length == 1) {
                    ((TitleBarShowClosePoint) extension).showClose(((Boolean) objArr[0]).booleanValue());
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarSegCheckPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.42
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onSegItemChecked".equals(str) && objArr.length == 1) {
                    ((TitleBarSegCheckPoint) extension).onSegItemChecked(((Integer) objArr[0]).intValue());
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarTitleClickPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.43
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onTitleClick".equals(str) && objArr.length == 0) {
                    ((TitleBarTitleClickPoint) extension).onTitleClick();
                }
                if ("onSubTitleClick".equals(str) && objArr.length == 0) {
                    ((TitleBarTitleClickPoint) extension).onSubTitleClick();
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarTransparentPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.44
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onTrasparentTitle".equals(str) && objArr.length == 2) {
                    ((TitleBarTransparentPoint) extension).onTrasparentTitle((Page) objArr[0], (String) objArr[1]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarOptionClickPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.45
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onOptionClick".equals(str) && objArr.length == 2) {
                    ((TitleBarOptionClickPoint) extension).onOptionClick(((Integer) objArr[0]).intValue(), ((Boolean) objArr[1]).booleanValue());
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ToastPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.46
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("showToast".equals(str) && objArr.length == 6) {
                    ((ToastPoint) extension).showToast((Context) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue(), (String) objArr[3], ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue());
                }
                if ("hideToast".equals(str) && objArr.length == 0) {
                    ((ToastPoint) extension).hideToast();
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarDisclaimerClickPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.47
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onDisclaimerClick".equals(str) && objArr.length == 0) {
                    ((TitleBarDisclaimerClickPoint) extension).onDisclaimerClick();
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(JsErrorPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.48
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onJsErrorMessage".equals(str) && objArr.length == 2) {
                    ((JsErrorPoint) extension).onJsErrorMessage((String) objArr[0], (Page) objArr[1]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(WebviewExceptionPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.49
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("populateErrorPage".equals(str) && objArr.length == 3) {
                    return ((WebviewExceptionPoint) extension).populateErrorPage((String) objArr[0], ((Integer) objArr[1]).intValue(), (String) objArr[2]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(BlankScreenPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.50
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onBlankScreen".equals(str) && objArr.length == 2) {
                    ((BlankScreenPoint) extension).onBlankScreen((Page) objArr[0], (JSONObject) objArr[1]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(SnapshotPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.51
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("addScreenshotListener".equals(str) && objArr.length == 1) {
                    ((SnapshotPoint) extension).addScreenshotListener((Page) objArr[0]);
                }
                if ("registerReceiever".equals(str) && objArr.length == 1) {
                    ((SnapshotPoint) extension).registerReceiever((BroadcastReceiver) objArr[0]);
                }
                if ("unregisterReceiver".equals(str) && objArr.length == 1) {
                    ((SnapshotPoint) extension).unregisterReceiver((BroadcastReceiver) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(SceneParamChangePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.52
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onSceneParamChange".equals(str) && objArr.length == 2) {
                    return Boolean.valueOf(((SceneParamChangePoint) extension).onSceneParamChange((String) objArr[0], objArr[1]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageLoadUrlPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.53
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("loadUrlDirectly".equals(str) && objArr.length == 3) {
                    return ((PageLoadUrlPoint) extension).loadUrlDirectly((JSONObject) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(StartParamChangePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.54
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onStartParamChange".equals(str) && objArr.length == 2) {
                    return Boolean.valueOf(((StartParamChangePoint) extension).onStartParamChange((String) objArr[0], objArr[1]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(VisitUrlPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.55
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onVisit".equals(str) && objArr.length == 1) {
                    ((VisitUrlPoint) extension).onVisit((Visit) objArr[0]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageLoadUrlNoInterceptorPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.56
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("loadUrlDirectlyWithNoIntercept".equals(str) && objArr.length == 3) {
                    ((PageLoadUrlNoInterceptorPoint) extension).loadUrlDirectlyWithNoIntercept((JSONObject) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PostNotificationPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.57
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("handlePostNotification".equals(str) && objArr.length == 3) {
                    ((PostNotificationPoint) extension).handlePostNotification((String) objArr[0], (JSONObject) objArr[1], (Page) objArr[2]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(DisclaimerPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.58
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("showDisclaimer".equals(str) && objArr.length == 1) {
                    ((DisclaimerPoint) extension).showDisclaimer(((Integer) objArr[0]).intValue());
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(EmbedWebviewLoadPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.59
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onPageLoaded".equals(str) && objArr.length == 2) {
                    ((EmbedWebviewLoadPoint) extension).onPageLoaded((Page) objArr[0], (Map) objArr[1]);
                }
                if ("onPageLoadError".equals(str) && objArr.length == 2) {
                    ((EmbedWebviewLoadPoint) extension).onPageLoadError((Page) objArr[0], (Map) objArr[1]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ActionSheetPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.60
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("getActionSheet".equals(str) && objArr.length == 1) {
                    return ((ActionSheetPoint) extension).getActionSheet((CreateActionSheetParam) objArr[0]);
                }
                if ("updateActionSheetContent".equals(str) && objArr.length == 1) {
                    ((ActionSheetPoint) extension).updateActionSheetContent((ArrayList) objArr[0]);
                }
                if ("onRelease".equals(str) && objArr.length == 0) {
                    ((ActionSheetPoint) extension).onRelease();
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(DialogPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.61
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("createDialog".equals(str) && objArr.length == 2) {
                    return ((DialogPoint) extension).createDialog((Activity) objArr[0], (CreateDialogParam) objArr[1]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AgreementConfirmPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.62
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("hasPermission".equals(str) && objArr.length == 2) {
                    return Boolean.valueOf(((AgreementConfirmPoint) extension).hasPermission((App) objArr[0], (String) objArr[1]));
                }
                if ("onAgreementClick".equals(str) && objArr.length == 2) {
                    ((AgreementConfirmPoint) extension).onAgreementClick((App) objArr[0], (String) objArr[1]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PromptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.63
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("createDialog".equals(str) && objArr.length == 2) {
                    return ((PromptPoint) extension).createDialog((Activity) objArr[0], (CreatePromptParam) objArr[1]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(FragmentResumePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.64
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onResume".equals(str) && objArr.length == 2) {
                    ((FragmentResumePoint) extension).onResume((Page) objArr[0], (Fragment) objArr[1]);
                    return null;
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(FragmentPausePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.65
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                if ("onPause".equals(str) && objArr.length == 2) {
                    ((FragmentPausePoint) extension).onPause((Page) objArr[0], (Fragment) objArr[1]);
                    return null;
                }
                return null;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:191:0x0616 A[Catch: all -> 0x0664, TryCatch #37 {all -> 0x0664, blocks: (B:185:0x05f4, B:189:0x0611, B:191:0x0616, B:192:0x0654), top: B:348:0x05f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0654 A[Catch: all -> 0x0664, TRY_LEAVE, TryCatch #37 {all -> 0x0664, blocks: (B:185:0x05f4, B:189:0x0611, B:191:0x0616, B:192:0x0654), top: B:348:0x05f4 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:193:0x0658 -> B:194:0x065b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void opt3() {
        /*
            Method dump skipped, instructions count: 2387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt.opt3():void");
    }
}
