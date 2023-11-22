package id.dana.danah5;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.view.Lifecycle;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.griver.core.ui.activity.GriverBaseActivity;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.framework.common.ContainerUtils;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import dagger.Lazy;
import id.dana.danah5.DanaH5;
import id.dana.danah5.DanaH5$openUrlWithBundleListener$1;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.danah5.interactor.OpenH5;
import id.dana.domain.danah5.model.H5UserDataEntity;
import id.dana.domain.featureconfig.interactor.GetMarmotConfig;
import id.dana.domain.featureconfig.model.MarmotConfig;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.miniprogram.model.MiniProgramVersionRequirements;
import id.dana.domain.version.SemanticVersion;
import id.dana.globalnetwork.AlipayConnectInitializer;
import id.dana.lib.gcontainer.ContainerLifecycleCallback;
import id.dana.lib.gcontainer.GContainer;
import id.dana.model.ThirdPartyService;
import id.dana.scanner.ScannerActivity;
import id.dana.util.IapConnectKtx;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002PQB\t\b\u0002¢\u0006\u0004\bO\u0010\u000fJ+\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J3\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b \u0010!J#\u0010%\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\b)\u0010*J\u0017\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020+H\u0007¢\u0006\u0004\b)\u0010,J/\u0010)\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b)\u0010.J+\u00101\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u00100\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u000203H\u0007¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b7\u00108J!\u00107\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u00010/H\u0007¢\u0006\u0004\b7\u00109J\u0017\u0010:\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b:\u0010;J!\u0010:\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u00100\u001a\u0004\u0018\u00010/H\u0007¢\u0006\u0004\b:\u0010<J-\u0010:\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u00100\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b:\u0010=J?\u0010?\u001a\u00020\u00052\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010>\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b?\u0010@J?\u0010A\u001a\u00020\u00052\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010>\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\bA\u0010@J!\u0010B\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u00100\u001a\u0004\u0018\u00010/H\u0007¢\u0006\u0004\bB\u0010<J\u0013\u0010C\u001a\u00020\u0002*\u00020\u0002H\u0007¢\u0006\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u0010FR\u0014\u0010H\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bH\u0010FR\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b4\u0010IR\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010JR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010KR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010LR\u0018\u0010M\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010N"}, d2 = {"Lid/dana/danah5/DanaH5;", "", "", "url", "Lkotlin/Function1;", "", LogConstants.Mpm.EndNodeType.OPEN_URL, "checkMarmotConfig", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lid/dana/domain/miniprogram/model/MiniProgramVersionRequirements;", "requirements", "Lid/dana/danah5/DanaH5$H5Requirement;", "checkVersionRequirements", "(Lid/dana/domain/miniprogram/model/MiniProgramVersionRequirements;)Lid/dana/danah5/DanaH5$H5Requirement;", "closeAllContainers", "()V", "dispose", "Lid/dana/domain/featureconfig/model/MarmotConfig;", "marmotConfig", "urlToUpdate", "doReplaceWithMarmot", "(Lid/dana/domain/featureconfig/model/MarmotConfig;Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Ldagger/Lazy;", "Lid/dana/domain/danah5/interactor/OpenH5;", "openH5Lazy", "Lid/dana/domain/featureconfig/interactor/GetMarmotConfig;", "getMarmotConfig", "initialize", "(Landroid/content/Context;Ldagger/Lazy;Ldagger/Lazy;)V", "", "isUrlContainsDanaPromotion", "(Ljava/lang/String;)Z", "Landroid/os/Bundle;", HummerConstants.BUNDLE, "screenOrientation", "mergeBundle", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Bundle;", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "service", "openApp", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;)V", "Lid/dana/model/ThirdPartyService;", "(Lid/dana/model/ThirdPartyService;)V", "appIdOrUri", "(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V", "Lid/dana/utils/danah5/DanaH5Listener;", "danaH5Listener", "openUrlWithBundleListener", "(Ljava/lang/String;Landroid/os/Bundle;Lid/dana/utils/danah5/DanaH5Listener;)V", "Lid/dana/globalnetwork/AlipayConnectInitializer;", "alipayConnectInitializer", "setAlipayConnectInitializer", "(Lid/dana/globalnetwork/AlipayConnectInitializer;)V", "startContainerActivity", "(Landroid/os/Bundle;)V", "(Landroid/os/Bundle;Lid/dana/utils/danah5/DanaH5Listener;)V", "startContainerFullUrl", "(Ljava/lang/String;)V", "(Ljava/lang/String;Lid/dana/utils/danah5/DanaH5Listener;)V", "(Ljava/lang/String;Lid/dana/utils/danah5/DanaH5Listener;Ljava/lang/String;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "startContainerFullUrlWithSendCredentials", "(Ljava/lang/String;Lid/dana/utils/danah5/DanaH5Listener;Landroid/os/Bundle;Ljava/lang/String;)V", "startContainerFullUrlWithSendCredentialsWithoutTimeOut", "startContainerFullUrlWithoutTimeout", "correctedUrl", "(Ljava/lang/String;)Ljava/lang/String;", "OLD_DANA_PROMOTION_URL", "Ljava/lang/String;", "SCREEN_ORIENTATION", ScannerActivity.SERVICE_KEY, "Lid/dana/globalnetwork/AlipayConnectInitializer;", "Landroid/content/Context;", "Lid/dana/domain/featureconfig/interactor/GetMarmotConfig;", "Lid/dana/domain/featureconfig/model/MarmotConfig;", "openH5", "Lid/dana/domain/danah5/interactor/OpenH5;", "<init>", "CheckAppUpdatesMessageEvent", "H5Requirement"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DanaH5 {
    public static final DanaH5 INSTANCE = new DanaH5();
    private static final String OLD_DANA_PROMOTION_URL = "/i/dana-promotion";
    public static final String SCREEN_ORIENTATION = "screenOrientation";
    public static final String SERVICE_KEY = "serviceKey";
    private static AlipayConnectInitializer alipayConnectInitializer;
    private static Context context;
    private static GetMarmotConfig getMarmotConfig;
    private static MarmotConfig marmotConfig;
    private static OpenH5 openH5;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danah5/DanaH5$CheckAppUpdatesMessageEvent;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class CheckAppUpdatesMessageEvent {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/danah5/DanaH5$H5Requirement;", "", "<init>", "(Ljava/lang/String;I)V", "UPDATE_OS", "UPDATE_APP", "NOTHING"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public enum H5Requirement {
        UPDATE_OS,
        UPDATE_APP,
        NOTHING
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
    public static final void startContainerFullUrlWithSendCredentials() {
        startContainerFullUrlWithSendCredentials$default(null, null, null, null, 15, null);
    }

    @JvmStatic
    public static final void startContainerFullUrlWithSendCredentials(String str) {
        startContainerFullUrlWithSendCredentials$default(str, null, null, null, 14, null);
    }

    @JvmStatic
    public static final void startContainerFullUrlWithSendCredentials(String str, DanaH5Listener danaH5Listener) {
        startContainerFullUrlWithSendCredentials$default(str, danaH5Listener, null, null, 12, null);
    }

    @JvmStatic
    public static final void startContainerFullUrlWithSendCredentials(String str, DanaH5Listener danaH5Listener, Bundle bundle) {
        startContainerFullUrlWithSendCredentials$default(str, danaH5Listener, bundle, null, 8, null);
    }

    @JvmStatic
    public static final void startContainerFullUrlWithSendCredentialsWithoutTimeOut() {
        startContainerFullUrlWithSendCredentialsWithoutTimeOut$default(null, null, null, null, 15, null);
    }

    @JvmStatic
    public static final void startContainerFullUrlWithSendCredentialsWithoutTimeOut(String str) {
        startContainerFullUrlWithSendCredentialsWithoutTimeOut$default(str, null, null, null, 14, null);
    }

    @JvmStatic
    public static final void startContainerFullUrlWithSendCredentialsWithoutTimeOut(String str, DanaH5Listener danaH5Listener) {
        startContainerFullUrlWithSendCredentialsWithoutTimeOut$default(str, danaH5Listener, null, null, 12, null);
    }

    @JvmStatic
    public static final void startContainerFullUrlWithSendCredentialsWithoutTimeOut(String str, DanaH5Listener danaH5Listener, Bundle bundle) {
        startContainerFullUrlWithSendCredentialsWithoutTimeOut$default(str, danaH5Listener, bundle, null, 8, null);
    }

    private DanaH5() {
    }

    @JvmStatic
    public static final void setAlipayConnectInitializer(AlipayConnectInitializer alipayConnectInitializer2) {
        Intrinsics.checkNotNullParameter(alipayConnectInitializer2, "");
        alipayConnectInitializer = alipayConnectInitializer2;
    }

    @JvmStatic
    public static final void initialize(Context r1, Lazy<OpenH5> openH5Lazy, Lazy<GetMarmotConfig> getMarmotConfig2) {
        Intrinsics.checkNotNullParameter(r1, "");
        Intrinsics.checkNotNullParameter(openH5Lazy, "");
        Intrinsics.checkNotNullParameter(getMarmotConfig2, "");
        Context applicationContext = r1.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "");
        context = applicationContext;
        openH5 = openH5Lazy.get();
        getMarmotConfig = getMarmotConfig2.get();
    }

    @JvmStatic
    public static final void startContainerFullUrl(final String url) {
        Intrinsics.checkNotNullParameter(url, "");
        AlipayConnectInitializer alipayConnectInitializer2 = alipayConnectInitializer;
        if (alipayConnectInitializer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            alipayConnectInitializer2 = null;
        }
        IapConnectKtx.MyBillsEntityDataFactory(alipayConnectInitializer2, new Function0<Unit>() { // from class: id.dana.danah5.DanaH5$startContainerFullUrl$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DanaH5.INSTANCE.checkMarmotConfig(DanaH5.correctedUrl(url), new Function1<String, Unit>() { // from class: id.dana.danah5.DanaH5$startContainerFullUrl$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(String str) {
                        Intrinsics.checkNotNullParameter(str, "");
                        GContainer.openUrl$default(str, new Bundle(), null, null, 12, null);
                    }
                });
            }
        });
    }

    @JvmStatic
    public static final void startContainerFullUrl(String url, DanaH5Listener danaH5Listener) {
        Intrinsics.checkNotNullParameter(url, "");
        startContainerFullUrl(url, danaH5Listener, "portrait");
    }

    public static /* synthetic */ void startContainerFullUrl$default(String str, DanaH5Listener danaH5Listener, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "portrait";
        }
        startContainerFullUrl(str, danaH5Listener, str2);
    }

    @JvmStatic
    public static final void startContainerFullUrl(final String url, final DanaH5Listener danaH5Listener, final String screenOrientation) {
        Intrinsics.checkNotNullParameter(url, "");
        AlipayConnectInitializer alipayConnectInitializer2 = alipayConnectInitializer;
        if (alipayConnectInitializer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            alipayConnectInitializer2 = null;
        }
        IapConnectKtx.MyBillsEntityDataFactory(alipayConnectInitializer2, new Function0<Unit>() { // from class: id.dana.danah5.DanaH5$startContainerFullUrl$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Bundle mergeBundle;
                DanaH5 danaH5 = DanaH5.INSTANCE;
                String correctedUrl = DanaH5.correctedUrl(url);
                mergeBundle = DanaH5.INSTANCE.mergeBundle(new Bundle(), screenOrientation);
                danaH5.openUrlWithBundleListener(correctedUrl, mergeBundle, danaH5Listener);
            }
        });
    }

    @JvmStatic
    public static final void startContainerFullUrlWithoutTimeout(final String url, final DanaH5Listener danaH5Listener) {
        Intrinsics.checkNotNullParameter(url, "");
        AlipayConnectInitializer alipayConnectInitializer2 = alipayConnectInitializer;
        if (alipayConnectInitializer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            alipayConnectInitializer2 = null;
        }
        IapConnectKtx.KClassImpl$Data$declaredNonStaticMembers$2(alipayConnectInitializer2, new Function0<Unit>() { // from class: id.dana.danah5.DanaH5$startContainerFullUrlWithoutTimeout$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DanaH5.INSTANCE.openUrlWithBundleListener(DanaH5.correctedUrl(url), new Bundle(), danaH5Listener);
            }
        });
    }

    public static /* synthetic */ void startContainerFullUrlWithSendCredentials$default(String str, DanaH5Listener danaH5Listener, Bundle bundle, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            danaH5Listener = null;
        }
        if ((i & 4) != 0) {
            bundle = null;
        }
        if ((i & 8) != 0) {
            str2 = "portrait";
        }
        startContainerFullUrlWithSendCredentials(str, danaH5Listener, bundle, str2);
    }

    @JvmStatic
    public static final void startContainerFullUrlWithSendCredentials(final String url, final DanaH5Listener r3, final Bundle r4, final String screenOrientation) {
        AlipayConnectInitializer alipayConnectInitializer2 = alipayConnectInitializer;
        if (alipayConnectInitializer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            alipayConnectInitializer2 = null;
        }
        IapConnectKtx.MyBillsEntityDataFactory(alipayConnectInitializer2, new Function0<Unit>() { // from class: id.dana.danah5.DanaH5$startContainerFullUrlWithSendCredentials$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                OpenH5 openH52;
                Bundle mergeBundle;
                final String str = url;
                if (str == null) {
                    Bundle bundle = r4;
                    str = bundle != null ? bundle.getString("url") : null;
                    if (str == null) {
                        return;
                    }
                }
                openH52 = DanaH5.openH5;
                if (openH52 != null) {
                    OpenH5 openH53 = openH52;
                    mergeBundle = DanaH5.INSTANCE.mergeBundle(r4, screenOrientation);
                    OpenH5.Params params = new OpenH5.Params(str, mergeBundle, false);
                    final DanaH5Listener danaH5Listener = r3;
                    BaseUseCase.execute$default(openH53, params, new Function1<H5UserDataEntity, Unit>() { // from class: id.dana.danah5.DanaH5$startContainerFullUrlWithSendCredentials$1.1

                        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                        /* renamed from: id.dana.danah5.DanaH5$startContainerFullUrlWithSendCredentials$1$1$WhenMappings */
                        /* loaded from: classes4.dex */
                        public final /* synthetic */ class WhenMappings {
                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                            static {
                                int[] iArr = new int[DanaH5.H5Requirement.values().length];
                                iArr[DanaH5.H5Requirement.UPDATE_OS.ordinal()] = 1;
                                iArr[DanaH5.H5Requirement.UPDATE_APP.ordinal()] = 2;
                                iArr[DanaH5.H5Requirement.NOTHING.ordinal()] = 3;
                                $EnumSwitchMapping$0 = iArr;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(H5UserDataEntity h5UserDataEntity) {
                            invoke2(h5UserDataEntity);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(H5UserDataEntity h5UserDataEntity) {
                            DanaH5.H5Requirement checkVersionRequirements;
                            Intrinsics.checkNotNullParameter(h5UserDataEntity, "");
                            if (h5UserDataEntity.getAppId() != null || StringsKt.startsWith$default(str, "mini://", false, 2, (Object) null)) {
                                checkVersionRequirements = DanaH5.INSTANCE.checkVersionRequirements(h5UserDataEntity.getVersionRequirements());
                                int i = WhenMappings.$EnumSwitchMapping$0[checkVersionRequirements.ordinal()];
                                if (i == 1) {
                                    return;
                                }
                                if (i == 2) {
                                    EventBus.getDefault().post(new DanaH5.CheckAppUpdatesMessageEvent());
                                    return;
                                } else if (i == 3 && TextUtils.isDigitsOnly(str)) {
                                    GContainer.openApp$default(str, h5UserDataEntity.getH5ShareData(), null, 4, null);
                                    return;
                                }
                            }
                            DanaH5.INSTANCE.openUrlWithBundleListener(DanaH5.correctedUrl(str), h5UserDataEntity.getH5ShareData(), danaH5Listener);
                        }
                    }, null, 4, null);
                }
            }
        });
    }

    public static /* synthetic */ void startContainerFullUrlWithSendCredentialsWithoutTimeOut$default(String str, DanaH5Listener danaH5Listener, Bundle bundle, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            danaH5Listener = null;
        }
        if ((i & 4) != 0) {
            bundle = null;
        }
        if ((i & 8) != 0) {
            str2 = "portrait";
        }
        startContainerFullUrlWithSendCredentialsWithoutTimeOut(str, danaH5Listener, bundle, str2);
    }

    @JvmStatic
    public static final void startContainerFullUrlWithSendCredentialsWithoutTimeOut(final String url, final DanaH5Listener r3, final Bundle r4, final String screenOrientation) {
        AlipayConnectInitializer alipayConnectInitializer2 = alipayConnectInitializer;
        if (alipayConnectInitializer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            alipayConnectInitializer2 = null;
        }
        IapConnectKtx.KClassImpl$Data$declaredNonStaticMembers$2(alipayConnectInitializer2, new Function0<Unit>() { // from class: id.dana.danah5.DanaH5$startContainerFullUrlWithSendCredentialsWithoutTimeOut$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                OpenH5 openH52;
                Bundle mergeBundle;
                final String str = url;
                if (str == null) {
                    Bundle bundle = r4;
                    str = bundle != null ? bundle.getString("url") : null;
                    if (str == null) {
                        return;
                    }
                }
                openH52 = DanaH5.openH5;
                if (openH52 != null) {
                    OpenH5 openH53 = openH52;
                    mergeBundle = DanaH5.INSTANCE.mergeBundle(r4, screenOrientation);
                    OpenH5.Params params = new OpenH5.Params(str, mergeBundle, true);
                    final DanaH5Listener danaH5Listener = r3;
                    BaseUseCase.execute$default(openH53, params, new Function1<H5UserDataEntity, Unit>() { // from class: id.dana.danah5.DanaH5$startContainerFullUrlWithSendCredentialsWithoutTimeOut$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(H5UserDataEntity h5UserDataEntity) {
                            invoke2(h5UserDataEntity);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(H5UserDataEntity h5UserDataEntity) {
                            Intrinsics.checkNotNullParameter(h5UserDataEntity, "");
                            DanaH5.INSTANCE.openUrlWithBundleListener(DanaH5.correctedUrl(str), h5UserDataEntity.getH5ShareData(), danaH5Listener);
                        }
                    }, null, 4, null);
                }
            }
        });
    }

    public static /* synthetic */ void openApp$default(String str, Bundle bundle, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        if ((i & 4) != 0) {
            str2 = "portrait";
        }
        openApp(str, bundle, str2);
    }

    @JvmStatic
    public static final void openApp(String appIdOrUri, Bundle r8, String screenOrientation) {
        Intrinsics.checkNotNullParameter(appIdOrUri, "");
        startContainerFullUrlWithSendCredentials$default(appIdOrUri, null, r8, screenOrientation, 2, null);
    }

    @JvmStatic
    public static final void openApp(ThirdPartyService service) {
        Intrinsics.checkNotNullParameter(service, "");
        Bundle bundle = new Bundle();
        bundle.putString(SERVICE_KEY, service.NetworkUserEntityData$$ExternalSyntheticLambda8);
        String str = service.PlaceComponentResult;
        Intrinsics.checkNotNull(str);
        openApp(str, bundle, service.C);
    }

    @JvmStatic
    public static final void openApp(ThirdPartyServiceResponse service) {
        Intrinsics.checkNotNullParameter(service, "");
        Bundle bundle = new Bundle();
        bundle.putString(SERVICE_KEY, service.getKey());
        String appId = service.getAppId();
        Intrinsics.checkNotNull(appId);
        openApp(appId, bundle, service.getScreenOrientation());
    }

    public final Bundle mergeBundle(Bundle r3, String screenOrientation) {
        Bundle bundle = new Bundle();
        if (screenOrientation == null) {
            screenOrientation = "portrait";
        }
        bundle.putString("screenOrientation", screenOrientation);
        if (r3 != null) {
            r3.putAll(bundle);
            return r3;
        }
        return bundle;
    }

    public final H5Requirement checkVersionRequirements(MiniProgramVersionRequirements requirements) {
        SemanticVersion.Companion companion = SemanticVersion.INSTANCE;
        String str = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str, "");
        SemanticVersion fromVersion = companion.fromVersion(str);
        fromVersion.setPatch(0);
        if (fromVersion.compareTo(requirements.getMinOsVersion()) < 0) {
            return H5Requirement.UPDATE_OS;
        }
        if (new SemanticVersion(2, 47, 1).compareTo(requirements.getMinAppVersion()) < 0) {
            return H5Requirement.UPDATE_APP;
        }
        return H5Requirement.NOTHING;
    }

    public final void openUrlWithBundleListener(final String url, final Bundle r4, final DanaH5Listener danaH5Listener) {
        AlipayConnectInitializer alipayConnectInitializer2 = alipayConnectInitializer;
        if (alipayConnectInitializer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            alipayConnectInitializer2 = null;
        }
        IapConnectKtx.MyBillsEntityDataFactory(alipayConnectInitializer2, new Function0<Unit>() { // from class: id.dana.danah5.DanaH5$openUrlWithBundleListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (!TextUtils.isDigitsOnly(url)) {
                    DanaH5.INSTANCE.checkMarmotConfig(url, new AnonymousClass1(r4, danaH5Listener));
                } else {
                    GContainer.openApp$default(url, r4, null, 4, null);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "url", "", BridgeDSL.INVOKE, "(Ljava/lang/String;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.danah5.DanaH5$openUrlWithBundleListener$1$1  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
                final /* synthetic */ Bundle $$bundle;
                final /* synthetic */ DanaH5Listener $$danaH5Listener;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Bundle bundle, DanaH5Listener danaH5Listener) {
                    super(1);
                    this.$$bundle = bundle;
                    this.$$danaH5Listener = danaH5Listener;
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    Intrinsics.checkNotNullParameter(str, "");
                    final Bundle bundle = this.$$bundle;
                    final DanaH5Listener danaH5Listener = this.$$danaH5Listener;
                    GContainer.openUrl$default(str, bundle, null, new ContainerLifecycleCallback() { // from class: id.dana.danah5.DanaH5$openUrlWithBundleListener$1$1$$ExternalSyntheticLambda0
                        @Override // id.dana.lib.gcontainer.ContainerLifecycleCallback
                        public final void onContainerActivityLifecycleEvent(Lifecycle.Event event, GriverBaseActivity griverBaseActivity) {
                            DanaH5$openUrlWithBundleListener$1.AnonymousClass1.m626invoke$lambda0(DanaH5Listener.this, bundle, event, griverBaseActivity);
                        }
                    }, 4, null);
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* renamed from: invoke$lambda-0  reason: not valid java name */
                public static final void m626invoke$lambda0(DanaH5Listener danaH5Listener, Bundle bundle, Lifecycle.Event event, GriverBaseActivity griverBaseActivity) {
                    Intrinsics.checkNotNullParameter(event, "");
                    Intrinsics.checkNotNullParameter(griverBaseActivity, "");
                    if (event == Lifecycle.Event.ON_CREATE) {
                        if (danaH5Listener != null) {
                            danaH5Listener.onContainerCreated(bundle);
                        }
                    } else if (event != Lifecycle.Event.ON_DESTROY || danaH5Listener == null) {
                    } else {
                        danaH5Listener.onContainerDestroyed(bundle);
                    }
                }
            }
        });
    }

    @JvmStatic
    public static final void startContainerActivity(final Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "");
        AlipayConnectInitializer alipayConnectInitializer2 = alipayConnectInitializer;
        if (alipayConnectInitializer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            alipayConnectInitializer2 = null;
        }
        IapConnectKtx.MyBillsEntityDataFactory(alipayConnectInitializer2, new Function0<Unit>() { // from class: id.dana.danah5.DanaH5$startContainerActivity$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GContainer.openUrl$default(r2, null, null, 6, null);
            }
        });
    }

    @JvmStatic
    public static final void startContainerActivity(Bundle r2, DanaH5Listener danaH5Listener) {
        Intrinsics.checkNotNullParameter(r2, "");
        AlipayConnectInitializer alipayConnectInitializer2 = alipayConnectInitializer;
        if (alipayConnectInitializer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            alipayConnectInitializer2 = null;
        }
        IapConnectKtx.MyBillsEntityDataFactory(alipayConnectInitializer2, new DanaH5$startContainerActivity$2(r2, danaH5Listener));
    }

    @JvmStatic
    public static final String correctedUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, SemanticAttributes.FaasTriggerValues.HTTP, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        String substring2 = str.substring(lastIndexOf$default, str.length());
        Intrinsics.checkNotNullExpressionValue(substring2, "");
        String str2 = substring2;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= str2.length()) {
                break;
            }
            if (str2.charAt(i) == '?') {
                i2++;
            }
            i++;
        }
        if (i2 > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(substring);
            sb.append(StringsKt.replaceFirst$default(StringsKt.replace$default(substring2, "?", ContainerUtils.FIELD_DELIMITER, false, 4, (Object) null), ContainerUtils.FIELD_DELIMITER, "?", false, 4, (Object) null));
            return sb.toString();
        }
        return str;
    }

    @JvmStatic
    public static final void closeAllContainers() {
        GContainer.closeAllContainers();
    }

    @JvmStatic
    public static final void dispose() {
        OpenH5 openH52 = openH5;
        if (openH52 != null) {
            openH52.dispose();
        }
        GetMarmotConfig getMarmotConfig2 = getMarmotConfig;
        if (getMarmotConfig2 != null) {
            getMarmotConfig2.dispose();
        }
    }

    public final void checkMarmotConfig(final String url, final Function1<? super String, Unit> r6) {
        if (isUrlContainsDanaPromotion(url)) {
            MarmotConfig marmotConfig2 = marmotConfig;
            if (marmotConfig2 != null) {
                r6.invoke(INSTANCE.doReplaceWithMarmot(marmotConfig2, url));
                return;
            }
            GetMarmotConfig getMarmotConfig2 = getMarmotConfig;
            if (getMarmotConfig2 != null) {
                getMarmotConfig2.execute(NoParams.INSTANCE, new Function1<MarmotConfig, Unit>() { // from class: id.dana.danah5.DanaH5$checkMarmotConfig$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(MarmotConfig marmotConfig3) {
                        invoke2(marmotConfig3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(MarmotConfig marmotConfig3) {
                        String doReplaceWithMarmot;
                        Intrinsics.checkNotNullParameter(marmotConfig3, "");
                        DanaH5.marmotConfig = marmotConfig3;
                        Function1<String, Unit> function1 = r6;
                        doReplaceWithMarmot = DanaH5.this.doReplaceWithMarmot(marmotConfig3, url);
                        function1.invoke(doReplaceWithMarmot);
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.DanaH5$checkMarmotConfig$2$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_MARMOT_CONFIG, th.getLocalizedMessage(), th);
                        r6.invoke(url);
                    }
                });
                return;
            }
            return;
        }
        r6.invoke(url);
    }

    private final boolean isUrlContainsDanaPromotion(String url) {
        return StringsKt.contains$default((CharSequence) url, (CharSequence) OLD_DANA_PROMOTION_URL, false, 2, (Object) null);
    }

    public final String doReplaceWithMarmot(MarmotConfig marmotConfig2, String urlToUpdate) {
        return marmotConfig2.getDanaPromotion().getMigrationStatus() ? StringsKt.replace(urlToUpdate, OLD_DANA_PROMOTION_URL, marmotConfig2.getDanaPromotion().getPath(), true) : urlToUpdate;
    }
}
