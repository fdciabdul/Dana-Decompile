package id.dana.lib.gcontainer;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.exthub.config.ExtHubMetaInfoParser;
import com.alibaba.griver.api.common.GriverEvent;
import com.alibaba.griver.api.common.GriverExtension;
import com.alibaba.griver.api.common.GriverExtensionManifest;
import com.alibaba.griver.api.ui.titlebar.GriverBackButtonStyleExtension;
import com.alibaba.griver.api.ui.titlebar.GriverCloseButtonStyleExtension;
import com.alibaba.griver.base.common.rpc.OnRpcResultListener;
import com.alibaba.griver.core.Griver;
import com.alibaba.griver.core.bridge.GriverBridgeManifest;
import com.alibaba.griver.core.model.applist.FetchAppsRequest;
import com.alibaba.griver.core.model.applist.FetchAppsResult;
import com.alibaba.griver.core.point.GriverEventManifest;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.lib.gcontainer.app.bridge.core.GriverH5ActivityLifecycleCallbacks;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import id.dana.lib.gcontainer.app.bridge.subapp.CloseSubAppBridge;
import id.dana.lib.gcontainer.app.extension.toolbar.BackButtonExtension;
import id.dana.lib.gcontainer.app.extension.toolbar.CloseButtonExtension;
import id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bV\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bJ_\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\f2&\u0010\u0011\u001a\"\u0012\u000b\u0012\t\u0018\u00010\t¢\u0006\u0002\b\u0010\u0012\u000b\u0012\t\u0018\u00010\u0005¢\u0006\u0002\b\u0010\u0012\u0004\u0012\u00020\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010 \u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0004\b \u0010!J;\u0010 \u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0004\b \u0010#J3\u0010)\u001a\u00020\u00022\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0$2\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050'\"\u00020\u0005H\u0007¢\u0006\u0004\b)\u0010*J-\u0010)\u001a\u00020\u00022\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0$2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050+H\u0007¢\u0006\u0004\b)\u0010,J0\u0010)\u001a\u00020\u0002\"\n\b\u0000\u0010-\u0018\u0001*\u00020%2\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050'\"\u00020\u0005H\u0086\b¢\u0006\u0004\b)\u0010.J\u000f\u0010/\u001a\u00020\u0002H\u0002¢\u0006\u0004\b/\u0010\u0004J\u000f\u00100\u001a\u00020\u0002H\u0002¢\u0006\u0004\b0\u0010\u0004JS\u00106\u001a\u00020\u00022\u000e\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u0002010$2\u000e\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u0002030$2\"\u00105\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002030$0'\"\n\u0012\u0006\b\u0001\u0012\u0002030$H\u0007¢\u0006\u0004\b6\u00107JE\u00106\u001a\u00020\u00022\u000e\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u0002010$2\u000e\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u0002030$2\u0014\u00105\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002030$0+H\u0007¢\u0006\u0004\b6\u00108JL\u00106\u001a\u00020\u0002\"\n\b\u0000\u00109\u0018\u0001*\u000201\"\n\b\u0001\u0010:\u0018\u0001*\u0002032\"\u00105\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002030$0'\"\n\u0012\u0006\b\u0001\u0012\u0002030$H\u0086\b¢\u0006\u0004\b6\u0010;J$\u0010>\u001a\u00020\u0002\"\n\b\u0000\u0010-\u0018\u0001*\u00020<2\u0006\u0010=\u001a\u00020<H\u0086\b¢\u0006\u0004\b>\u0010?J'\u0010>\u001a\u00020\u00022\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020<0$2\u0006\u0010=\u001a\u00020<H\u0007¢\u0006\u0004\b>\u0010@J!\u0010A\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\bA\u0010BR\u001a\u0010G\u001a\u00020C8GX\u0087\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0004\u001a\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020J8GX\u0087\u0004¢\u0006\f\u0012\u0004\bO\u0010\u0004\u001a\u0004\bM\u0010NR(\u0010\u001b\u001a\u00020\u001a8\u0007@\u0007X\u0087\u000e¢\u0006\u0018\n\u0004\b\u001b\u0010P\u0012\u0004\bU\u0010\u0004\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T"}, d2 = {"Lid/dana/lib/gcontainer/GContainer;", "", "", "closeAllContainers", "()V", "", "appId", "closeApp", "(Ljava/lang/String;)V", "", "queryStartIndex", "querySize", "Lkotlin/Function1;", "Lcom/alibaba/griver/core/model/applist/FetchAppsResult;", "onSuccess", "Lkotlin/Function2;", "Lkotlin/ParameterName;", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "fetchMiniPrograms", "(IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "Landroid/app/Application;", "application", "initialize", "(Landroid/app/Application;)V", "Landroid/os/Bundle;", "params", "Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle;", "toolbarStyle", "openApp", "(Ljava/lang/String;Landroid/os/Bundle;Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle;)V", "Lid/dana/lib/gcontainer/ContainerLifecycleCallback;", "containerLifecycleCallback", LogConstants.Mpm.EndNodeType.OPEN_URL, "(Landroid/os/Bundle;Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle;Lid/dana/lib/gcontainer/ContainerLifecycleCallback;)V", "url", "(Ljava/lang/String;Landroid/os/Bundle;Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle;Lid/dana/lib/gcontainer/ContainerLifecycleCallback;)V", "Ljava/lang/Class;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/BridgeExtension;", "clazz", "", "jsapiMethods", "registerBridge", "(Ljava/lang/Class;[Ljava/lang/String;)V", "", "(Ljava/lang/Class;Ljava/util/List;)V", "T", "([Ljava/lang/String;)V", "registerDefaultBridges", "registerDefaultExtensions", "Lcom/alibaba/ariver/kernel/api/node/Scope;", ExtHubMetaInfoParser.KEY_EXTENSION_SCOPE_CLASS_NAME, "Lcom/alibaba/griver/api/common/GriverEvent;", "handlerClass", "eventFilters", "registerEventHandler", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)V", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/util/List;)V", "S", "EventHandler", "([Ljava/lang/Class;)V", "Lcom/alibaba/griver/api/common/GriverExtension;", ExtHubMetaInfoParser.KEY_EXTENSION_INFO, "registerExtension", "(Lcom/alibaba/griver/api/common/GriverExtension;)V", "(Ljava/lang/Class;Lcom/alibaba/griver/api/common/GriverExtension;)V", "setDefaultParams", "(Landroid/os/Bundle;Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle;)Landroid/os/Bundle;", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "getApplicationContext$annotations", "applicationContext", HummerConstants.CONTEXT, "Landroid/content/Context;", "", "initialized", "Z", "isOpeningH5", "()Z", "isOpeningH5$annotations", "Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle;", "getToolbarStyle", "()Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle;", "setToolbarStyle", "(Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle;)V", "getToolbarStyle$annotations", "<init>"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class GContainer {
    private static Context context;
    private static boolean initialized;
    public static final GContainer INSTANCE = new GContainer();
    private static ToolbarStyle toolbarStyle = new ToolbarStyle(0, 0, null, null, null, 31, null);

    @JvmStatic
    public static /* synthetic */ void getApplicationContext$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getToolbarStyle$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isOpeningH5$annotations() {
    }

    @JvmStatic
    public static final void openApp(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        openApp$default(str, null, null, 6, null);
    }

    @JvmStatic
    public static final void openApp(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "");
        openApp$default(str, bundle, null, 4, null);
    }

    @JvmStatic
    public static final void openUrl(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "");
        openUrl$default(bundle, null, null, 6, null);
    }

    @JvmStatic
    public static final void openUrl(Bundle bundle, ToolbarStyle toolbarStyle2) {
        Intrinsics.checkNotNullParameter(bundle, "");
        openUrl$default(bundle, toolbarStyle2, null, 4, null);
    }

    @JvmStatic
    public static final void openUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        openUrl$default(str, null, null, null, 14, null);
    }

    @JvmStatic
    public static final void openUrl(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "");
        openUrl$default(str, bundle, null, null, 12, null);
    }

    @JvmStatic
    public static final void openUrl(String str, Bundle bundle, ToolbarStyle toolbarStyle2) {
        Intrinsics.checkNotNullParameter(str, "");
        openUrl$default(str, bundle, toolbarStyle2, null, 8, null);
    }

    private GContainer() {
    }

    @JvmName(name = "getToolbarStyle")
    public static final ToolbarStyle getToolbarStyle() {
        return toolbarStyle;
    }

    @JvmName(name = "setToolbarStyle")
    public static final void setToolbarStyle(ToolbarStyle toolbarStyle2) {
        Intrinsics.checkNotNullParameter(toolbarStyle2, "");
        toolbarStyle = toolbarStyle2;
    }

    @JvmName(name = "getApplicationContext")
    public static final Context getApplicationContext() {
        Context context2 = context;
        if (context2 != null) {
            return context2;
        }
        throw new IllegalStateException("GContainer has not been initialized yet.");
    }

    @JvmStatic
    public static final void initialize(Application application) {
        Intrinsics.checkNotNullParameter(application, "");
        if (initialized) {
            return;
        }
        GContainer gContainer = INSTANCE;
        context = application.getApplicationContext();
        application.registerActivityLifecycleCallbacks(new GriverH5ActivityLifecycleCallbacks());
        gContainer.registerDefaultBridges();
        gContainer.registerDefaultExtensions();
        initialized = true;
    }

    private final void registerDefaultBridges() {
        registerBridge(CloseSubAppBridge.class, ArraysKt.toList(new String[]{"closeSubApp"}));
        registerBridge(H5GetLogInfoBridge.class, ArraysKt.toList(new String[]{"getLogInfo"}));
    }

    private final void registerDefaultExtensions() {
        registerExtension(GriverBackButtonStyleExtension.class, new BackButtonExtension());
        registerExtension(GriverCloseButtonStyleExtension.class, new CloseButtonExtension());
    }

    @JvmStatic
    public static final void registerExtension(Class<? extends GriverExtension> clazz, GriverExtension extension) {
        Intrinsics.checkNotNullParameter(clazz, "");
        Intrinsics.checkNotNullParameter(extension, "");
        Griver.registerExtension(new GriverExtensionManifest(clazz, extension));
    }

    public final /* synthetic */ <T extends GriverExtension> void registerExtension(GriverExtension extension) {
        Intrinsics.checkNotNullParameter(extension, "");
        Intrinsics.reifiedOperationMarker(4, "T");
        registerExtension(GriverExtension.class, extension);
    }

    public final /* synthetic */ <T extends BridgeExtension> void registerBridge(String... jsapiMethods) {
        Intrinsics.checkNotNullParameter(jsapiMethods, "");
        Intrinsics.reifiedOperationMarker(4, "T");
        registerBridge(BridgeExtension.class, ArraysKt.toList(jsapiMethods));
    }

    @JvmStatic
    public static final void registerBridge(Class<? extends BridgeExtension> clazz, String... jsapiMethods) {
        Intrinsics.checkNotNullParameter(clazz, "");
        Intrinsics.checkNotNullParameter(jsapiMethods, "");
        registerBridge(clazz, ArraysKt.toList(jsapiMethods));
    }

    @JvmStatic
    public static final void registerBridge(Class<? extends BridgeExtension> clazz, List<String> jsapiMethods) {
        Intrinsics.checkNotNullParameter(clazz, "");
        Intrinsics.checkNotNullParameter(jsapiMethods, "");
        if ((!jsapiMethods.isEmpty()) == true) {
            Griver.registerBridge(new GriverBridgeManifest(clazz, jsapiMethods));
        }
    }

    public final /* synthetic */ <S extends Scope, EventHandler extends GriverEvent> void registerEventHandler(Class<? extends GriverEvent>... eventFilters) {
        Intrinsics.checkNotNullParameter(eventFilters, "");
        Intrinsics.reifiedOperationMarker(4, "S");
        Intrinsics.reifiedOperationMarker(4, "EventHandler");
        registerEventHandler(Scope.class, GriverEvent.class, ArraysKt.toList(eventFilters));
    }

    @JvmStatic
    public static final void registerEventHandler(Class<? extends Scope> scope, Class<? extends GriverEvent> handlerClass, List<? extends Class<? extends GriverEvent>> eventFilters) {
        Intrinsics.checkNotNullParameter(scope, "");
        Intrinsics.checkNotNullParameter(handlerClass, "");
        Intrinsics.checkNotNullParameter(eventFilters, "");
        if ((!eventFilters.isEmpty()) == true) {
            String name = handlerClass.getName();
            List<? extends Class<? extends GriverEvent>> list = eventFilters;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Class) it.next()).getName());
            }
            Griver.registerEventHandler(new GriverEventManifest(name, arrayList, scope));
        }
    }

    @JvmStatic
    public static final void registerEventHandler(Class<? extends Scope> scope, Class<? extends GriverEvent> handlerClass, Class<? extends GriverEvent>... eventFilters) {
        Intrinsics.checkNotNullParameter(scope, "");
        Intrinsics.checkNotNullParameter(handlerClass, "");
        Intrinsics.checkNotNullParameter(eventFilters, "");
        registerEventHandler(scope, handlerClass, ArraysKt.toList(eventFilters));
    }

    public static /* synthetic */ void openUrl$default(String str, Bundle bundle, ToolbarStyle toolbarStyle2, ContainerLifecycleCallback containerLifecycleCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        if ((i & 4) != 0) {
            toolbarStyle2 = null;
        }
        if ((i & 8) != 0) {
            containerLifecycleCallback = null;
        }
        openUrl(str, bundle, toolbarStyle2, containerLifecycleCallback);
    }

    @JvmStatic
    public static final void openUrl(String url, Bundle params, ToolbarStyle toolbarStyle2, ContainerLifecycleCallback containerLifecycleCallback) {
        Intrinsics.checkNotNullParameter(url, "");
        if (containerLifecycleCallback != null) {
            GriverH5ActivityLifecycleCallbacks.INSTANCE.getContainerLifecycleCallbacks().add(containerLifecycleCallback);
        }
        GContainer gContainer = INSTANCE;
        Context applicationContext = getApplicationContext();
        if (params == null) {
            params = new Bundle();
        }
        Griver.openUrl(applicationContext, url, gContainer.setDefaultParams(params, toolbarStyle2));
    }

    public static /* synthetic */ void openUrl$default(Bundle bundle, ToolbarStyle toolbarStyle2, ContainerLifecycleCallback containerLifecycleCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            toolbarStyle2 = null;
        }
        if ((i & 4) != 0) {
            containerLifecycleCallback = null;
        }
        openUrl(bundle, toolbarStyle2, containerLifecycleCallback);
    }

    @JvmStatic
    public static final void openUrl(Bundle params, ToolbarStyle toolbarStyle2, ContainerLifecycleCallback containerLifecycleCallback) {
        Intrinsics.checkNotNullParameter(params, "");
        String string = params.getString("url");
        if (string == null) {
            return;
        }
        openUrl(string, params, toolbarStyle2, containerLifecycleCallback);
    }

    public static /* synthetic */ void openApp$default(String str, Bundle bundle, ToolbarStyle toolbarStyle2, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        if ((i & 4) != 0) {
            toolbarStyle2 = null;
        }
        openApp(str, bundle, toolbarStyle2);
    }

    @JvmStatic
    public static final void openApp(String appId, Bundle params, ToolbarStyle toolbarStyle2) {
        Intrinsics.checkNotNullParameter(appId, "");
        GContainer gContainer = INSTANCE;
        Context applicationContext = getApplicationContext();
        if (params == null) {
            params = new Bundle();
        }
        Griver.openApp(applicationContext, appId, gContainer.setDefaultParams(params, toolbarStyle2));
    }

    private final Bundle setDefaultParams(Bundle params, ToolbarStyle toolbarStyle2) {
        if (toolbarStyle2 == null) {
            toolbarStyle2 = getToolbarStyle();
        }
        Context applicationContext = getApplicationContext();
        params.putInt("titleBarBackgroundImage", toolbarStyle2.getToolbarBackgroundDrawable());
        params.putInt("titleBarColor", ContextCompat.BuiltInFictitiousFunctionClassFactory(applicationContext, toolbarStyle2.getToolbarBackgroundColor()));
        params.putString("defaultTitle", toolbarStyle2.getTitle().getPreloadTitle());
        params.putInt("titleColor", ContextCompat.BuiltInFictitiousFunctionClassFactory(applicationContext, toolbarStyle2.getTitle().getTextColor()));
        params.putInt("backButtonColor", ContextCompat.BuiltInFictitiousFunctionClassFactory(applicationContext, toolbarStyle2.getBackButton().getColor()));
        params.putInt("closeButtonColor", ContextCompat.BuiltInFictitiousFunctionClassFactory(applicationContext, toolbarStyle2.getCloseButton().getColor()));
        params.putBoolean("showCloseButton", toolbarStyle2.getCloseButton().getShow());
        Context applicationContext2 = getApplicationContext();
        try {
            String str = applicationContext2.getPackageManager().getPackageInfo(applicationContext2.getPackageName(), 0).versionName;
            Intrinsics.checkNotNullExpressionValue(str, "");
            params.putString("danaAppVersion", StringsKt.substringBefore$default(str, '-', (String) null, 2, (Object) null));
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return params;
    }

    @JvmName(name = "isOpeningH5")
    public static final boolean isOpeningH5() {
        return GriverH5ActivityLifecycleCallbacks.INSTANCE.isOpeningH5();
    }

    @JvmStatic
    public static final void closeApp(String appId) {
        Intrinsics.checkNotNullParameter(appId, "");
        Griver.closeApp(appId);
    }

    @JvmStatic
    public static final void closeAllContainers() {
        EventBus.getDefault().post(new GriverH5ActivityLifecycleCallbacks.FinishAllSessionsMessageEvent());
    }

    public static /* synthetic */ void fetchMiniPrograms$default(int i, int i2, Function1 function1, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 100;
        }
        fetchMiniPrograms(i, i2, function1, function2);
    }

    @JvmStatic
    public static final void fetchMiniPrograms(int queryStartIndex, int querySize, final Function1<? super FetchAppsResult, Unit> onSuccess, final Function2<? super Integer, ? super String, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "");
        Intrinsics.checkNotNullParameter(onError, "");
        Griver.fetchApps(new FetchAppsRequest(queryStartIndex, querySize), new OnRpcResultListener<FetchAppsResult>() { // from class: id.dana.lib.gcontainer.GContainer$fetchMiniPrograms$1
            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public final void onResultSuccess(FetchAppsResult result) {
                Intrinsics.checkNotNullParameter(result, "");
                onSuccess.invoke(result);
            }

            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public final void onResultFailed(int errorCode, String errorMessage) {
                onError.invoke(Integer.valueOf(errorCode), errorMessage);
            }
        });
    }
}
