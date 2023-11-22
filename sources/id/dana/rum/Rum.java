package id.dana.rum;

import android.app.Application;
import android.location.Location;
import android.webkit.WebView;
import com.alipay.imobile.network.quake.request.RequestInterceptor;
import com.fullstory.instrumentation.InstrumentInjector;
import com.splunk.rum.BackgroundProcessDetector;
import com.splunk.rum.ConnectionUtil;
import com.splunk.rum.DanaExporter;
import com.splunk.rum.SplunkRum;
import com.splunk.rum.SplunkRumBuilder;
import com.splunk.rum.StandardAttributes;
import id.dana.rum.Rum;
import id.dana.rum.model.RumConfigModel;
import id.dana.rum.okhttp.OkHttpJsonRpcAttributesExtractor;
import id.dana.rum.okhttp.OkHttpJsonRpcAttributesGetter;
import id.dana.rum.okhttp.OkHttpJsonRpcTelemetry;
import id.dana.rum.okhttp.OkHttpJsonRpcTelemetryBuilder;
import id.dana.rum.okhttp.OkHttpJsonRpcTracingCallFactory;
import id.dana.rum.okhttp.OkHttpJsonRpcTracingInterceptor;
import id.dana.rum.okhttp.OkHttpRumResponseAttributesExtractor;
import id.dana.rum.os.OSUtils;
import id.dana.rum.quake.QuakeTracing;
import id.dana.rum.quake.QuakeTracingBuilder;
import id.dana.rum.quake.RequestHeaderSetter;
import id.dana.rum.quake.RpcSpanNameExtractor;
import id.dana.rum.quake.RumResponseAttributesExtractor;
import id.dana.rum.quake.TracingInterceptor;
import id.dana.rum.splunk.Splunk;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;
import io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.SpanStatusExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientMetrics;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpSpanNameExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpSpanStatusExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesExtractor;
import io.opentelemetry.instrumentation.okhttp.v3_0.internal.OkHttpNetAttributesGetter;
import j$.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u001c2\u00020\u0001:\u0004\u001c\u001d\u001e\u001fJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016JI\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t0\b\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016JA\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t0\b\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\tH\u0016¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016JA\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t0\b\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\tH\u0016¢\u0006\u0002\u0010\u0015JA\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t0\b\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\tH\u0016¢\u0006\u0002\u0010\fJE\u0010\u0017\u001a\u00020\u00032\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001a2*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t0\b\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\tH\u0016¢\u0006\u0002\u0010\u001bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006 À\u0006\u0001"}, d2 = {"Lid/dana/rum/Rum;", "", "beginSubWorkflow", "", "name", "", "parent", "attributes", "", "Lkotlin/Pair;", "(Ljava/lang/String;Ljava/lang/String;[Lkotlin/Pair;)V", "beginWorkflow", "(Ljava/lang/String;[Lkotlin/Pair;)V", "discardWorkflow", "editWorkflowName", "", "previousName", "newName", "endWorkflow", "putWorkflowAttributes", "Lid/dana/rum/Rum$Workflow;", "(Ljava/lang/String;[Lkotlin/Pair;)Lid/dana/rum/Rum$Workflow;", "recordEvent", "recordNonFatal", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;[Lkotlin/Pair;)V", "Companion", "Enabler", "FirebaseLog", "Workflow", "rum_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Rum {
    public static final Companion getAuthRequestContext = Companion.BuiltInFictitiousFunctionClassFactory;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/rum/Rum$Enabler;", "", "Lid/dana/rum/model/RumConfigModel;", "getAuthRequestContext", "()Lid/dana/rum/model/RumConfigModel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Enabler {
        RumConfigModel getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/rum/Rum$FirebaseLog;", "", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface FirebaseLog {
        void getAuthRequestContext(String p0);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/rum/Rum$Workflow;", "", "", "PlaceComponentResult", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Workflow {
        void PlaceComponentResult();
    }

    void BuiltInFictitiousFunctionClassFactory(String str);

    void BuiltInFictitiousFunctionClassFactory(String str, Pair<String, ? extends Object>... pairArr);

    void MyBillsEntityDataFactory(Exception exc, Pair<String, ? extends Object>... pairArr);

    void PlaceComponentResult(String str);

    void PlaceComponentResult(String str, String str2);

    Workflow getAuthRequestContext(String str, Pair<String, ? extends Object>... pairArr);

    /* renamed from: id.dana.rum.Rum$-CC */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = Rum.getAuthRequestContext;
        }

        @JvmStatic
        public static String BuiltInFictitiousFunctionClassFactory() {
            Companion companion = Rum.getAuthRequestContext;
            return Companion.PlaceComponentResult();
        }

        @JvmStatic
        public static void BuiltInFictitiousFunctionClassFactory(Location location) {
            Companion companion = Rum.getAuthRequestContext;
            Companion.KClassImpl$Data$declaredNonStaticMembers$2(location);
        }

        public static void BuiltInFictitiousFunctionClassFactory(String str) {
            Intrinsics.checkNotNullParameter(str, "");
        }

        public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, Pair... pairArr) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(pairArr, "");
        }

        @JvmStatic
        public static RequestInterceptor MyBillsEntityDataFactory() {
            Companion companion = Rum.getAuthRequestContext;
            return Companion.MyBillsEntityDataFactory();
        }

        @JvmStatic
        public static <T> Pair<String, T> MyBillsEntityDataFactory(String str, T t) {
            Companion companion = Rum.getAuthRequestContext;
            return Companion.getAuthRequestContext(str, t);
        }

        public static void MyBillsEntityDataFactory(String str) {
            Intrinsics.checkNotNullParameter(str, "");
        }

        @JvmStatic
        public static void MyBillsEntityDataFactory(Pair<String, ? extends Object>... pairArr) {
            Companion companion = Rum.getAuthRequestContext;
            Companion.KClassImpl$Data$declaredNonStaticMembers$2(pairArr);
        }

        @JvmStatic
        public static Call.Factory PlaceComponentResult(OkHttpClient okHttpClient) {
            Companion companion = Rum.getAuthRequestContext;
            return Companion.getAuthRequestContext(okHttpClient);
        }

        public static void PlaceComponentResult(Exception exc, Pair... pairArr) {
            Intrinsics.checkNotNullParameter(exc, "");
            Intrinsics.checkNotNullParameter(pairArr, "");
        }

        @JvmStatic
        public static Rum getAuthRequestContext() {
            Companion companion = Rum.getAuthRequestContext;
            return Companion.BuiltInFictitiousFunctionClassFactory();
        }

        public static void getAuthRequestContext(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
        }

        @JvmStatic
        public static void getAuthRequestContext(Function3<? super Boolean, ? super Boolean, ? super Boolean, Unit> function3) {
            Companion companion = Rum.getAuthRequestContext;
            Companion.KClassImpl$Data$declaredNonStaticMembers$2(function3);
        }

        public static Workflow PlaceComponentResult(String str, Pair... pairArr) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(pairArr, "");
            return NoOpWorkflow.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b-\u0010.J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJW\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u000b\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u000b\u0010\u001dJ/\u0010 \u001a\u00020\u001c2\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001c0\u001eH\u0007¢\u0006\u0004\b \u0010!J1\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000#\"\u0004\b\u0000\u0010\"2\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\r\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\b\u0010$J;\u0010 \u001a\u00020\u001c2*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010#0%\"\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010#H\u0007¢\u0006\u0004\b \u0010&J\u000f\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010'J\u0017\u0010 \u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020(H\u0007¢\u0006\u0004\b \u0010)R\u0016\u0010\u0003\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010*R\u0014\u0010\b\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010,"}, d2 = {"Lid/dana/rum/Rum$Companion;", "", "Lcom/alipay/imobile/network/quake/request/RequestInterceptor;", "MyBillsEntityDataFactory", "()Lcom/alipay/imobile/network/quake/request/RequestInterceptor;", "Lokhttp3/OkHttpClient;", "p0", "Lokhttp3/Call$Factory;", "getAuthRequestContext", "(Lokhttp3/OkHttpClient;)Lokhttp3/Call$Factory;", "", "PlaceComponentResult", "()Ljava/lang/String;", "p1", "p2", "p3", "p4", "Landroid/app/Application;", "p5", "Lid/dana/rum/Rum$Enabler;", "p6", "Lid/dana/rum/Rum$FirebaseLog;", "p7", "p8", "Lid/dana/rum/Rum;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/app/Application;Lid/dana/rum/Rum$Enabler;Lid/dana/rum/Rum$FirebaseLog;Ljava/lang/String;)Lid/dana/rum/Rum;", "Landroid/webkit/WebView;", "", "(Landroid/webkit/WebView;)V", "Lkotlin/Function3;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lkotlin/jvm/functions/Function3;)V", "T", "Lkotlin/Pair;", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlin/Pair;", "", "([Lkotlin/Pair;)V", "()Lid/dana/rum/Rum;", "Landroid/location/Location;", "(Landroid/location/Location;)V", "Lid/dana/rum/Rum$Enabler;", "Lid/dana/rum/splunk/Splunk;", "Lid/dana/rum/splunk/Splunk;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private static final Splunk getAuthRequestContext = new Splunk();

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private static Enabler MyBillsEntityDataFactory = new Enabler() { // from class: id.dana.rum.Rum$Companion$$ExternalSyntheticLambda1
            @Override // id.dana.rum.Rum.Enabler
            public final RumConfigModel getAuthRequestContext() {
                return Rum.Companion.getAuthRequestContext();
            }
        };

        private Companion() {
        }

        @JvmStatic
        public static Rum BuiltInFictitiousFunctionClassFactory() {
            OSUtils oSUtils = OSUtils.INSTANCE;
            if (OSUtils.MyBillsEntityDataFactory() < 21 || !MyBillsEntityDataFactory.getAuthRequestContext().getGetAuthRequestContext()) {
                return RumNoOp.INSTANCE;
            }
            return getAuthRequestContext;
        }

        @JvmStatic
        public static Rum BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2, String p3, String p4, Application p5, Enabler p6, final FirebaseLog p7, String p8) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intrinsics.checkNotNullParameter(p4, "");
            Intrinsics.checkNotNullParameter(p5, "");
            Intrinsics.checkNotNullParameter(p6, "");
            Intrinsics.checkNotNullParameter(p7, "");
            Intrinsics.checkNotNullParameter(p8, "");
            MyBillsEntityDataFactory = p6;
            OSUtils oSUtils = OSUtils.INSTANCE;
            if (OSUtils.MyBillsEntityDataFactory() < 21 || !p6.getAuthRequestContext().getGetAuthRequestContext()) {
                return RumNoOp.INSTANCE;
            }
            SplunkRumBuilder authRequestContext = SplunkRum.getAuthRequestContext();
            if (authRequestContext.PlaceComponentResult != null && authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                InstrumentInjector.log_w("SplunkRum", "beaconEndpoint has already been set. Realm configuration will be ignored.");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("https://rum-ingest.");
                sb.append(p0);
                sb.append(".signalfx.com/v1/rum");
                authRequestContext.PlaceComponentResult = sb.toString();
                authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2 = p0;
            }
            authRequestContext.isLayoutRequested = p2;
            authRequestContext.getAuthRequestContext = p3;
            authRequestContext.scheduleImpl = p1;
            Attributes build = Attributes.CC.builder().put("vendor", "Splunk").put((AttributeKey<AttributeKey<String>>) StandardAttributes.KClassImpl$Data$declaredNonStaticMembers$2, (AttributeKey<String>) p4).build();
            if (build == null) {
                build = Attributes.CC.empty();
            }
            authRequestContext.getErrorConfigVersion = build;
            authRequestContext.moveToNextValue = true;
            authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1 = 50;
            authRequestContext.FragmentBottomSheetPaymentSettingBinding = p6.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2.getMyBillsEntityDataFactory();
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            authRequestContext.lookAheadTest = BackgroundProcessDetector.MyBillsEntityDataFactory(p8).booleanValue();
            authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda3 = false;
            if (p6.getAuthRequestContext().getMyBillsEntityDataFactory()) {
                authRequestContext.DatabaseTableConfigUtil = new DanaExporter.ResultCallback() { // from class: id.dana.rum.Rum$Companion$$ExternalSyntheticLambda2
                    @Override // com.splunk.rum.DanaExporter.ResultCallback
                    public final void getAuthRequestContext(String str) {
                        Rum.Companion.PlaceComponentResult(Rum.FirebaseLog.this, str);
                    }
                };
            }
            if (authRequestContext.isLayoutRequested == null || authRequestContext.PlaceComponentResult == null || authRequestContext.getAuthRequestContext == null) {
                throw new IllegalStateException("You must provide a rumAccessToken, a realm (or full beaconEndpoint), and an applicationName to create a valid Config instance.");
            }
            new ConnectionUtil.Factory();
            SplunkRum.BuiltInFictitiousFunctionClassFactory(authRequestContext, p5);
            return getAuthRequestContext;
        }

        @JvmStatic
        public static void KClassImpl$Data$declaredNonStaticMembers$2(Pair<String, ? extends Object>... p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            OSUtils oSUtils = OSUtils.INSTANCE;
            if (OSUtils.MyBillsEntityDataFactory() < 21 || !MyBillsEntityDataFactory.getAuthRequestContext().getGetAuthRequestContext()) {
                return;
            }
            if (p0.length == 0) {
                return;
            }
            SplunkRum MyBillsEntityDataFactory2 = SplunkRum.MyBillsEntityDataFactory();
            for (Pair<String, ? extends Object> pair : p0) {
                String component1 = pair.component1();
                final Object component2 = pair.component2();
                if (!(component2 instanceof String)) {
                    if (!(component2 instanceof Boolean)) {
                        if (!(component2 instanceof Long)) {
                            if (component2 instanceof Double) {
                                final AttributeKey<Double> doubleKey = AttributeKey.CC.doubleKey(component1);
                                MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(new Consumer() { // from class: com.splunk.rum.SplunkRum$$ExternalSyntheticLambda0
                                    @Override // j$.util.function.Consumer
                                    public final void accept(Object obj) {
                                        ((AttributesBuilder) obj).put((AttributeKey<AttributeKey>) AttributeKey.this, (AttributeKey) component2);
                                    }

                                    @Override // j$.util.function.Consumer
                                    public final /* synthetic */ Consumer andThen(Consumer consumer) {
                                        return Consumer.CC.PlaceComponentResult(this, consumer);
                                    }
                                });
                            }
                        } else {
                            final AttributeKey<Long> longKey = AttributeKey.CC.longKey(component1);
                            MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(new Consumer() { // from class: com.splunk.rum.SplunkRum$$ExternalSyntheticLambda0
                                @Override // j$.util.function.Consumer
                                public final void accept(Object obj) {
                                    ((AttributesBuilder) obj).put((AttributeKey<AttributeKey>) AttributeKey.this, (AttributeKey) component2);
                                }

                                @Override // j$.util.function.Consumer
                                public final /* synthetic */ Consumer andThen(Consumer consumer) {
                                    return Consumer.CC.PlaceComponentResult(this, consumer);
                                }
                            });
                        }
                    } else {
                        final AttributeKey<Boolean> booleanKey = AttributeKey.CC.booleanKey(component1);
                        MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(new Consumer() { // from class: com.splunk.rum.SplunkRum$$ExternalSyntheticLambda0
                            @Override // j$.util.function.Consumer
                            public final void accept(Object obj) {
                                ((AttributesBuilder) obj).put((AttributeKey<AttributeKey>) AttributeKey.this, (AttributeKey) component2);
                            }

                            @Override // j$.util.function.Consumer
                            public final /* synthetic */ Consumer andThen(Consumer consumer) {
                                return Consumer.CC.PlaceComponentResult(this, consumer);
                            }
                        });
                    }
                } else {
                    final AttributeKey<String> stringKey = AttributeKey.CC.stringKey(component1);
                    MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(new Consumer() { // from class: com.splunk.rum.SplunkRum$$ExternalSyntheticLambda0
                        @Override // j$.util.function.Consumer
                        public final void accept(Object obj) {
                            ((AttributesBuilder) obj).put((AttributeKey<AttributeKey>) AttributeKey.this, (AttributeKey) component2);
                        }

                        @Override // j$.util.function.Consumer
                        public final /* synthetic */ Consumer andThen(Consumer consumer) {
                            return Consumer.CC.PlaceComponentResult(this, consumer);
                        }
                    });
                }
            }
        }

        @JvmStatic
        public static Call.Factory getAuthRequestContext(OkHttpClient p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            OSUtils oSUtils = OSUtils.INSTANCE;
            if (OSUtils.MyBillsEntityDataFactory() < 21 || !MyBillsEntityDataFactory.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2.getPlaceComponentResult()) {
                return null;
            }
            OkHttpJsonRpcTelemetryBuilder MyBillsEntityDataFactory2 = OkHttpJsonRpcTelemetry.MyBillsEntityDataFactory(SplunkRum.MyBillsEntityDataFactory().PlaceComponentResult());
            MyBillsEntityDataFactory2.PlaceComponentResult.add(new OkHttpRumResponseAttributesExtractor());
            OkHttpJsonRpcAttributesGetter okHttpJsonRpcAttributesGetter = OkHttpJsonRpcAttributesGetter.INSTANCE;
            OkHttpJsonRpcTelemetry okHttpJsonRpcTelemetry = new OkHttpJsonRpcTelemetry(Instrumenter.builder(MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2, "io.opentelemetry.okhttp-3.0-DANA", HttpSpanNameExtractor.create(okHttpJsonRpcAttributesGetter)).setSpanStatusExtractor(HttpSpanStatusExtractor.create(okHttpJsonRpcAttributesGetter)).addAttributesExtractor(MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.build()).addAttributesExtractor(NetClientAttributesExtractor.create(new OkHttpNetAttributesGetter())).addAttributesExtractor(new OkHttpJsonRpcAttributesExtractor()).addAttributesExtractors(MyBillsEntityDataFactory2.PlaceComponentResult).addOperationMetrics(HttpClientMetrics.get()).buildInstrumenter(SpanKindExtractor.CC.alwaysClient()), MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2.getPropagators());
            return new OkHttpJsonRpcTracingCallFactory(p0.newBuilder().addInterceptor(new OkHttpJsonRpcTracingInterceptor(okHttpJsonRpcTelemetry.getAuthRequestContext, okHttpJsonRpcTelemetry.BuiltInFictitiousFunctionClassFactory)).build());
        }

        @JvmStatic
        public static void KClassImpl$Data$declaredNonStaticMembers$2(Function3<? super Boolean, ? super Boolean, ? super Boolean, Unit> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            OSUtils oSUtils = OSUtils.INSTANCE;
            p0.invoke(Boolean.valueOf(OSUtils.MyBillsEntityDataFactory() >= 21), Boolean.valueOf(MyBillsEntityDataFactory.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2.getPlaceComponentResult()), Boolean.valueOf(Intrinsics.areEqual(SplunkRum.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(), "")));
        }

        @JvmStatic
        public static RequestInterceptor MyBillsEntityDataFactory() {
            OSUtils oSUtils = OSUtils.INSTANCE;
            if (OSUtils.MyBillsEntityDataFactory() < 21 || !MyBillsEntityDataFactory.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2.getPlaceComponentResult()) {
                return null;
            }
            QuakeTracing.Companion companion = QuakeTracing.INSTANCE;
            OpenTelemetry PlaceComponentResult = SplunkRum.MyBillsEntityDataFactory().PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            QuakeTracingBuilder BuiltInFictitiousFunctionClassFactory2 = QuakeTracing.Companion.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult);
            SpanStatusExtractor create = HttpSpanStatusExtractor.create(BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2);
            Intrinsics.checkNotNullExpressionValue(create, "");
            RpcSpanNameExtractor.Companion companion2 = RpcSpanNameExtractor.INSTANCE;
            Instrumenter buildClientInstrumenter = Instrumenter.builder(BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory, "id.dana.quake", RpcSpanNameExtractor.Companion.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2)).setSpanStatusExtractor(create).addAttributesExtractor(BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.build()).addAttributesExtractor(NetClientAttributesExtractor.create(BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory)).addAttributesExtractor(new RumResponseAttributesExtractor()).addAttributesExtractors(BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult).buildClientInstrumenter(RequestHeaderSetter.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(buildClientInstrumenter, "");
            ContextPropagators propagators = BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory.getPropagators();
            Intrinsics.checkNotNullExpressionValue(propagators, "");
            QuakeTracing quakeTracing = new QuakeTracing(buildClientInstrumenter, propagators);
            return new TracingInterceptor(quakeTracing.MyBillsEntityDataFactory, quakeTracing.PlaceComponentResult);
        }

        @JvmStatic
        public static void PlaceComponentResult(WebView p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            OSUtils oSUtils = OSUtils.INSTANCE;
            if (OSUtils.MyBillsEntityDataFactory() < 21 || !MyBillsEntityDataFactory.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2.getMyBillsEntityDataFactory()) {
                return;
            }
            SplunkRum.MyBillsEntityDataFactory().getAuthRequestContext(p0);
        }

        @JvmStatic
        public static void KClassImpl$Data$declaredNonStaticMembers$2(final Location p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            OSUtils oSUtils = OSUtils.INSTANCE;
            if (OSUtils.MyBillsEntityDataFactory() < 21 || !MyBillsEntityDataFactory.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2.getMyBillsEntityDataFactory()) {
                return;
            }
            SplunkRum MyBillsEntityDataFactory2 = SplunkRum.MyBillsEntityDataFactory();
            if (p0 == null) {
                MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(new Consumer() { // from class: com.splunk.rum.SplunkRum$$ExternalSyntheticLambda1
                    @Override // j$.util.function.Consumer
                    public final void accept(Object obj) {
                        ((AttributesBuilder) obj).remove(SplunkRum.GetContactSyncConfig).remove(SplunkRum.DatabaseTableConfigUtil);
                    }

                    @Override // j$.util.function.Consumer
                    public final /* synthetic */ Consumer andThen(Consumer consumer) {
                        return Consumer.CC.PlaceComponentResult(this, consumer);
                    }
                });
            } else {
                MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(new Consumer() { // from class: com.splunk.rum.SplunkRum$$ExternalSyntheticLambda2
                    @Override // j$.util.function.Consumer
                    public final void accept(Object obj) {
                        ((AttributesBuilder) obj).put((AttributeKey<AttributeKey<AttributeKey<Double>>>) ((AttributeKey<AttributeKey<Double>>) SplunkRum.GetContactSyncConfig), (AttributeKey<AttributeKey<Double>>) ((AttributeKey<Double>) Double.valueOf(r0.getLatitude()))).put((AttributeKey<AttributeKey<AttributeKey<Double>>>) ((AttributeKey<AttributeKey<Double>>) SplunkRum.DatabaseTableConfigUtil), (AttributeKey<AttributeKey<Double>>) ((AttributeKey<Double>) Double.valueOf(p0.getLongitude())));
                    }

                    @Override // j$.util.function.Consumer
                    public final /* synthetic */ Consumer andThen(Consumer consumer) {
                        return Consumer.CC.PlaceComponentResult(this, consumer);
                    }
                });
            }
        }

        @JvmStatic
        public static String PlaceComponentResult() {
            OSUtils oSUtils = OSUtils.INSTANCE;
            if (OSUtils.MyBillsEntityDataFactory() < 21 || !MyBillsEntityDataFactory.getAuthRequestContext().getGetAuthRequestContext()) {
                return "";
            }
            String KClassImpl$Data$declaredNonStaticMembers$2 = SplunkRum.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2();
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @JvmStatic
        public static <T> Pair<String, T> getAuthRequestContext(String p0, T p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new Pair<>(p0, p1);
        }

        public static /* synthetic */ RumConfigModel getAuthRequestContext() {
            return new RumConfigModel(false, false, null, 7, null);
        }

        public static /* synthetic */ RumConfigModel KClassImpl$Data$declaredNonStaticMembers$2() {
            return new RumConfigModel(false, false, null, 7, null);
        }

        public static /* synthetic */ void PlaceComponentResult(FirebaseLog firebaseLog, String str) {
            Intrinsics.checkNotNullParameter(firebaseLog, "");
            Intrinsics.checkNotNullExpressionValue(str, "");
            firebaseLog.getAuthRequestContext(str);
        }
    }
}
