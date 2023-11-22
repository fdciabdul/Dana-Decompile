package id.dana.danah5.chrome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import id.dana.danah5.DanaCustomH5;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.base.BaseBridgeExtension;
import id.dana.danah5.constant.BridgeName;
import id.dana.data.util.download.DownloadUtil;
import id.dana.dialog.LoadingDialog;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.util.a.a;
import id.dana.util.media.FileUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ1\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0015\u001a\u00020\u000b2\b\b\u0001\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001a8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/danah5/chrome/CustomTabBridge;", "Lid/dana/danah5/base/BaseBridgeExtension;", "", "url", "", "checkIsPdf", "(Ljava/lang/String;)Z", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "handlePdfDownloadAndShow", "(Landroid/app/Activity;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Ljava/lang/String;)V", CustomTabBridge.REQUEST_PARAM_IS_AUTO_DOWNLOAD_IF_PDF, "handleUrl", "(Landroid/app/Activity;Ljava/lang/String;ZLcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/app/api/Page;", "page", BridgeName.OPEN_IN_CUSTOM_CONTAINER, "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "openUrlViaCustomTab", "(Landroid/app/Activity;Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Landroid/app/Activity;", "Lid/dana/dialog/LoadingDialog;", "loadingDialog$delegate", "Lkotlin/Lazy;", "getLoadingDialog", "()Lid/dana/dialog/LoadingDialog;", "loadingDialog", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CustomTabBridge extends BaseBridgeExtension {
    public static final String MIME_TYPE_PDF = "application/pdf";
    public static final String REQUEST_PARAM_IS_AUTO_DOWNLOAD_IF_PDF = "isAutoDownloadIfPDF";
    public static final String REQUEST_PARAM_URL = "url";
    private Activity activity;

    /* renamed from: loadingDialog$delegate  reason: from kotlin metadata */
    private final Lazy loadingDialog = LazyKt.lazy(new Function0<LoadingDialog>() { // from class: id.dana.danah5.chrome.CustomTabBridge$loadingDialog$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            CustomTabBridge.this = this;
        }

        @Override // kotlin.jvm.functions.Function0
        public final LoadingDialog invoke() {
            Activity activity;
            activity = CustomTabBridge.this.activity;
            if (activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                activity = null;
            }
            return new LoadingDialog(activity);
        }
    });

    @JvmName(name = "getLoadingDialog")
    private final LoadingDialog getLoadingDialog() {
        return (LoadingDialog) this.loadingDialog.getValue();
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter(canOverride = false)
    public final void openInCustomContainer(@BindingParam(name = {"info"}) JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity != null) {
            this.activity = activity;
            String string = jSONObject.getString("url");
            boolean booleanValue = jSONObject.getBooleanValue(REQUEST_PARAM_IS_AUTO_DOWNLOAD_IF_PDF);
            if (!TextUtils.isEmpty(string)) {
                Activity activity2 = this.activity;
                if (activity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    activity2 = null;
                }
                Intrinsics.checkNotNullExpressionValue(string, "");
                handleUrl(activity2, string, booleanValue, bridgeCallback);
                return;
            }
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        bridgeCallback.sendBridgeResponse(BridgeResponse.NATIVE_NODE_NULL);
    }

    static /* synthetic */ void handleUrl$default(CustomTabBridge customTabBridge, Activity activity, String str, boolean z, BridgeCallback bridgeCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        customTabBridge.handleUrl(activity, str, z, bridgeCallback);
    }

    private final void handleUrl(Activity r1, String url, boolean r3, BridgeCallback bridgeCallback) {
        if (r3 && checkIsPdf(url)) {
            handlePdfDownloadAndShow(r1, bridgeCallback, url);
        } else {
            openUrlViaCustomTab(r1, url, bridgeCallback);
        }
    }

    private final void handlePdfDownloadAndShow(final Activity r8, BridgeCallback bridgeCallback, String url) {
        File MyBillsEntityDataFactory;
        r8.runOnUiThread(new Runnable() { // from class: id.dana.danah5.chrome.CustomTabBridge$$ExternalSyntheticLambda0
            {
                CustomTabBridge.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CustomTabBridge.m634handlePdfDownloadAndShow$lambda0(CustomTabBridge.this);
            }
        });
        if (FileUtil.getAuthRequestContext() <= 100) {
            r8.runOnUiThread(new Runnable() { // from class: id.dana.danah5.chrome.CustomTabBridge$$ExternalSyntheticLambda1
                {
                    CustomTabBridge.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    CustomTabBridge.m635handlePdfDownloadAndShow$lambda1(CustomTabBridge.this);
                }
            });
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(5, "Internal Storage Not Enough"));
            return;
        }
        Activity activity = r8;
        MyBillsEntityDataFactory = a.MyBillsEntityDataFactory(activity.getFilesDir(), "/DANA/");
        if (!MyBillsEntityDataFactory.exists()) {
            FileUtil.getAuthRequestContext(MyBillsEntityDataFactory.getAbsolutePath());
        }
        Disposable subscribe = DownloadUtil.downloadFile(url, FileUtil.BuiltInFictitiousFunctionClassFactory(activity, (String) CollectionsKt.last(StringsKt.split$default((CharSequence) url, new String[]{"/"}, false, 0, 6, (Object) null))).getPath(), ".pdf").observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.danah5.chrome.CustomTabBridge$$ExternalSyntheticLambda2
            {
                CustomTabBridge.this = this;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CustomTabBridge.m636handlePdfDownloadAndShow$lambda3(CustomTabBridge.this, r8, (File) obj);
            }
        }, new Consumer() { // from class: id.dana.danah5.chrome.CustomTabBridge$$ExternalSyntheticLambda3
            {
                CustomTabBridge.this = this;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CustomTabBridge.m637handlePdfDownloadAndShow$lambda4(CustomTabBridge.this, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        addDisposable(subscribe);
    }

    /* renamed from: handlePdfDownloadAndShow$lambda-0 */
    public static final void m634handlePdfDownloadAndShow$lambda0(CustomTabBridge customTabBridge) {
        Intrinsics.checkNotNullParameter(customTabBridge, "");
        LoadingDialog loadingDialog = customTabBridge.getLoadingDialog();
        if (loadingDialog.BuiltInFictitiousFunctionClassFactory.isShowing()) {
            return;
        }
        try {
            loadingDialog.BuiltInFictitiousFunctionClassFactory.show();
        } catch (Exception unused) {
        }
    }

    /* renamed from: handlePdfDownloadAndShow$lambda-1 */
    public static final void m635handlePdfDownloadAndShow$lambda1(CustomTabBridge customTabBridge) {
        Intrinsics.checkNotNullParameter(customTabBridge, "");
        customTabBridge.getLoadingDialog().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* renamed from: handlePdfDownloadAndShow$lambda-3 */
    public static final void m636handlePdfDownloadAndShow$lambda3(CustomTabBridge customTabBridge, Activity activity, File file) {
        Intrinsics.checkNotNullParameter(customTabBridge, "");
        Intrinsics.checkNotNullParameter(activity, "");
        DanaLog.MyBillsEntityDataFactory("javaClass", "onSuccess Download PDF");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(1);
        intent.addFlags(67108864);
        intent.setDataAndType(FileUtil.PlaceComponentResult(activity, file), "application/pdf");
        customTabBridge.getLoadingDialog().KClassImpl$Data$declaredNonStaticMembers$2();
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(intent);
        }
    }

    /* renamed from: handlePdfDownloadAndShow$lambda-4 */
    public static final void m637handlePdfDownloadAndShow$lambda4(CustomTabBridge customTabBridge, Throwable th) {
        Intrinsics.checkNotNullParameter(customTabBridge, "");
        DanaLog.BuiltInFictitiousFunctionClassFactory("javaClass", "onFail Download PDF");
        customTabBridge.getLoadingDialog().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final void openUrlViaCustomTab(Activity r3, String url, BridgeCallback bridgeCallback) {
        Context baseContext = r3.getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "");
        new DanaCustomH5(baseContext).openUrl(r3, url);
        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
    }

    private final boolean checkIsPdf(String url) {
        try {
            return StringsKt.equals(((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(url).openConnection()))).getContentType(), "application/pdf", true);
        } catch (Exception unused) {
            return false;
        }
    }
}
