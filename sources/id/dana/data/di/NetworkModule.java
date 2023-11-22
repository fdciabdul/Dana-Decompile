package id.dana.data.di;

import android.content.Context;
import com.alipay.imobile.network.sslpinning.SSLPinningManager;
import com.alipay.imobile.network.sslpinning.api.ISSLPinningManager;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import id.dana.data.foundation.toolbox.HttpEventMonitorListener;
import id.dana.data.holdlogin.v2.interceptor.OkhttpHoldLoginV2Interceptor;
import id.dana.data.network.IOkHttpSSLPinningManager;
import id.dana.data.network.OkHttpSSLPinningManager;
import id.dana.data.network.interceptor.CashierInterceptor;
import id.dana.data.network.interceptor.DanaLoggingInterceptor;
import id.dana.data.network.interceptor.ETagCacheInterceptor;
import id.dana.data.network.interceptor.NetworkAvailabilityInterceptor;
import id.dana.data.network.interceptor.RequestHeaderInterceptor;
import id.dana.data.network.interceptor.RequestHeaderWithLocationCheckInterceptor;
import id.dana.data.util.OkHttpFlipperPlugin;
import id.dana.data.util.Tls12SocketFactory;
import id.dana.rum.Rum;
import id.dana.rum.exception.RumInterceptorNullException;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
/* loaded from: classes.dex */
public class NetworkModule {
    private static final String CERT = "cert";
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ssZ";
    private static final String DEFAULT_CACHE_FILE_NAME = "okhttp-cache";
    private static final int DEFAULT_CACHE_SIZE = 1048576;
    private static final int DEFAULT_CONNECT_TIME_OUT = 30000;
    private static final int DEFAULT_READ_TIME_OUT = 30000;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public IOkHttpSSLPinningManager provideIOkHttpSSLPinningManager(OkHttpSSLPinningManager okHttpSSLPinningManager) {
        return okHttpSSLPinningManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder().setDateFormat(DATE_FORMAT).create();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public Cache provideCache(Context context) {
        return new Cache(new File(context.getFilesDir(), DEFAULT_CACHE_FILE_NAME), ConvertUtils.MB);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public EventListener.Factory provideEventListenerFactory() {
        return HttpEventMonitorListener.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public ISSLPinningManager provideISSLPinningManager(Context context) {
        SSLPinningManager sSLPinningManager = new SSLPinningManager(context);
        sSLPinningManager.setPinningMode(0);
        sSLPinningManager.setPresetCertificateFolderPath(CERT);
        return sSLPinningManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        return httpLoggingInterceptor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public FlipperOkhttpInterceptor provideOkhttpInterceptor() {
        return new FlipperOkhttpInterceptor(OkHttpFlipperPlugin.getInstance().getNetworkFlipperPlugin());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Named("BASIC_OKHTTP_BUILDER")
    public OkHttpClient.Builder provideBasicOkHttpClientBuilder(HttpLoggingInterceptor httpLoggingInterceptor, RequestHeaderInterceptor requestHeaderInterceptor, NetworkAvailabilityInterceptor networkAvailabilityInterceptor, ETagCacheInterceptor eTagCacheInterceptor, FlipperOkhttpInterceptor flipperOkhttpInterceptor, EventListener.Factory factory, DanaLoggingInterceptor danaLoggingInterceptor, Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        InstrumentInjector.okhttp_addInterceptors(builder);
        builder.connectTimeout(30000L, TimeUnit.MILLISECONDS);
        builder.readTimeout(30000L, TimeUnit.MILLISECONDS);
        builder.cache(cache);
        builder.eventListenerFactory(factory);
        builder.addInterceptor(httpLoggingInterceptor);
        builder.addInterceptor(requestHeaderInterceptor);
        builder.addInterceptor(networkAvailabilityInterceptor);
        builder.addInterceptor(eTagCacheInterceptor);
        builder.addInterceptor(flipperOkhttpInterceptor);
        builder.addInterceptor(danaLoggingInterceptor);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Named("OKHTTP_BUILDER_WITH_LOCATION_CHECK_RETROFIT")
    public OkHttpClient.Builder provideOkHttpWithLocationCheckBuilder(HttpLoggingInterceptor httpLoggingInterceptor, RequestHeaderWithLocationCheckInterceptor requestHeaderWithLocationCheckInterceptor, NetworkAvailabilityInterceptor networkAvailabilityInterceptor, ETagCacheInterceptor eTagCacheInterceptor, FlipperOkhttpInterceptor flipperOkhttpInterceptor, EventListener.Factory factory, DanaLoggingInterceptor danaLoggingInterceptor, Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        InstrumentInjector.okhttp_addInterceptors(builder);
        builder.connectTimeout(30000L, TimeUnit.MILLISECONDS);
        builder.readTimeout(30000L, TimeUnit.MILLISECONDS);
        builder.cache(cache);
        builder.eventListenerFactory(factory);
        builder.addInterceptor(httpLoggingInterceptor);
        builder.addInterceptor(requestHeaderWithLocationCheckInterceptor);
        builder.addInterceptor(networkAvailabilityInterceptor);
        builder.addInterceptor(eTagCacheInterceptor);
        builder.addInterceptor(flipperOkhttpInterceptor);
        builder.addInterceptor(danaLoggingInterceptor);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Named("SESSION_OKHTTP_BUILDER")
    public OkHttpClient.Builder provideSessionOkHttpClientBuilder(@Named("BASIC_OKHTTP_BUILDER") OkHttpClient.Builder builder, OkhttpHoldLoginV2Interceptor okhttpHoldLoginV2Interceptor) {
        builder.addInterceptor(okhttpHoldLoginV2Interceptor);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Named("SESSION_OKHTTP_WITH_LOCATION_CHECK_BUILDER")
    public OkHttpClient.Builder provideSessionOkHttpWithLocationCheckClientBuilder(@Named("OKHTTP_BUILDER_WITH_LOCATION_CHECK_RETROFIT") OkHttpClient.Builder builder, OkhttpHoldLoginV2Interceptor okhttpHoldLoginV2Interceptor) {
        builder.addInterceptor(okhttpHoldLoginV2Interceptor);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(@Named("BASIC_OKHTTP_BUILDER") OkHttpClient.Builder builder) {
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("SESSION_OKHTTP")
    public OkHttpClient provideSessionOkHttpClient(@Named("SESSION_OKHTTP_BUILDER") OkHttpClient.Builder builder) {
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("SECURED_OKHTTP")
    public OkHttpClient provideSecuredOkHttpClient(@Named("SESSION_OKHTTP_BUILDER") OkHttpClient.Builder builder) {
        return Tls12SocketFactory.enableTls12OnPreLollipop(builder).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("SECURED_OKHTTP_WITH_LOCATION_CHECK")
    public OkHttpClient provideSecuredOkWithLocationCheckHttpClient(@Named("SESSION_OKHTTP_WITH_LOCATION_CHECK_BUILDER") OkHttpClient.Builder builder) {
        return Tls12SocketFactory.enableTls12OnPreLollipop(builder).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("SECURED_OKHTTP_NAMECHECK")
    public OkHttpClient provideSecuredNameCheckOkHttpClient(@Named("SESSION_OKHTTP_BUILDER") OkHttpClient.Builder builder) {
        return Tls12SocketFactory.enableTls12OnPreLollipop(builder).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("CASHIER_OKHTTP")
    public OkHttpClient provideCashierOkHttpClient(@Named("BASIC_OKHTTP_BUILDER") OkHttpClient.Builder builder, CashierInterceptor cashierInterceptor, OkhttpHoldLoginV2Interceptor okhttpHoldLoginV2Interceptor) {
        builder.addInterceptor(cashierInterceptor);
        builder.addInterceptor(okhttpHoldLoginV2Interceptor);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("RESET_PASSWORD_OKHTTP")
    public OkHttpClient provideResetPasswordsOkHttpClient(@Named("BASIC_OKHTTP_BUILDER") OkHttpClient.Builder builder, OkhttpHoldLoginV2Interceptor okhttpHoldLoginV2Interceptor) {
        builder.addInterceptor(okhttpHoldLoginV2Interceptor);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("SECURED_CASHIER_OKHTTP")
    public OkHttpClient provideSecuredCashierOkHttpClient(@Named("BASIC_OKHTTP_BUILDER") OkHttpClient.Builder builder, CashierInterceptor cashierInterceptor, OkhttpHoldLoginV2Interceptor okhttpHoldLoginV2Interceptor) {
        builder.addInterceptor(cashierInterceptor);
        builder.addInterceptor(okhttpHoldLoginV2Interceptor);
        return Tls12SocketFactory.enableTls12OnPreLollipop(builder).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("UPLOAD_FILES_OKHTTP")
    public OkHttpClient provideUploadFilesOkHttpClient(@Named("SESSION_OKHTTP_BUILDER") OkHttpClient.Builder builder) {
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("NON_DANA_SERVICE_OKHTTP")
    public OkHttpClient provideNonDanaServiceOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, NetworkAvailabilityInterceptor networkAvailabilityInterceptor, ETagCacheInterceptor eTagCacheInterceptor, FlipperOkhttpInterceptor flipperOkhttpInterceptor, EventListener.Factory factory, DanaLoggingInterceptor danaLoggingInterceptor, Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        InstrumentInjector.okhttp_addInterceptors(builder);
        builder.connectTimeout(30000L, TimeUnit.MILLISECONDS);
        builder.readTimeout(30000L, TimeUnit.MILLISECONDS);
        builder.cache(cache);
        builder.eventListenerFactory(factory);
        builder.addInterceptor(httpLoggingInterceptor);
        builder.addInterceptor(networkAvailabilityInterceptor);
        builder.addInterceptor(eTagCacheInterceptor);
        builder.addInterceptor(flipperOkhttpInterceptor);
        builder.addInterceptor(danaLoggingInterceptor);
        return Tls12SocketFactory.enableTls12OnPreLollipop(builder).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofitBuilder(Gson gson, OkHttpClient okHttpClient, SharedPrefStartupConfig sharedPrefStartupConfig) {
        return setupStandardBuilder(gson, okHttpClient, sharedPrefStartupConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("SESSION_RETROFIT")
    public Retrofit.Builder provideSessionRetrofitBuilder(Gson gson, @Named("SESSION_OKHTTP") OkHttpClient okHttpClient, SharedPrefStartupConfig sharedPrefStartupConfig) {
        return setupStandardBuilder(gson, okHttpClient, sharedPrefStartupConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("SECURED_RETROFIT")
    public Retrofit.Builder provideSecuredRetrofitBuilder(Gson gson, @Named("SECURED_OKHTTP") OkHttpClient okHttpClient, SharedPrefStartupConfig sharedPrefStartupConfig) {
        return setupStandardBuilder(gson, okHttpClient, sharedPrefStartupConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("SECURED_RETROFIT_WITH_LOCATION_CHECK")
    public Retrofit.Builder provideSecureOkhttpWithLocationCheckRetrofitBuilder(Gson gson, @Named("SECURED_OKHTTP_WITH_LOCATION_CHECK") OkHttpClient okHttpClient, SharedPrefStartupConfig sharedPrefStartupConfig) {
        return setupStandardBuilder(gson, okHttpClient, sharedPrefStartupConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("SECURED_RETROFIT_NAMECHECK")
    public Retrofit.Builder provideSecuredRetrofitNameCheckBuilder(Gson gson, @Named("SECURED_OKHTTP_NAMECHECK") OkHttpClient okHttpClient, SharedPrefStartupConfig sharedPrefStartupConfig) {
        return setupStandardBuilder(gson, okHttpClient, sharedPrefStartupConfig);
    }

    private Retrofit.Builder setupStandardBuilder(Gson gson, OkHttpClient okHttpClient, SharedPrefStartupConfig sharedPrefStartupConfig) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.BuiltInFictitiousFunctionClassFactory.add((Converter.Factory) Objects.requireNonNull(GsonConverterFactory.BuiltInFictitiousFunctionClassFactory(gson), "factory == null"));
        builder.PlaceComponentResult.add((CallAdapter.Factory) Objects.requireNonNull(RxJava2CallAdapterFactory.KClassImpl$Data$declaredNonStaticMembers$2(), "factory == null"));
        builder.MyBillsEntityDataFactory = (Call.Factory) Objects.requireNonNull((Call.Factory) Objects.requireNonNull(okHttpClient, "client == null"), "factory == null");
        Rum.CC.getAuthRequestContext(new Function3() { // from class: id.dana.data.di.NetworkModule$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return NetworkModule.lambda$setupStandardBuilder$0((Boolean) obj, (Boolean) obj2, (Boolean) obj3);
            }
        });
        if (Rum.CC.PlaceComponentResult(okHttpClient) == null) {
            Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            RumInterceptorNullException rumInterceptorNullException = new RumInterceptorNullException();
            Intrinsics.checkNotNullParameter(rumInterceptorNullException, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(rumInterceptorNullException);
            Rum.CC.getAuthRequestContext().MyBillsEntityDataFactory(new RumInterceptorNullException(), new Pair[0]);
        } else {
            builder.MyBillsEntityDataFactory = (Call.Factory) Objects.requireNonNull((Call.Factory) Objects.requireNonNull(Rum.CC.PlaceComponentResult(okHttpClient)), "factory == null");
        }
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$setupStandardBuilder$0(Boolean bool, Boolean bool2, Boolean bool3) {
        Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        String obj = bool.toString();
        Intrinsics.checkNotNullParameter("Is Above API 21", "");
        Intrinsics.checkNotNullParameter(obj, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("Is Above API 21", obj);
        String obj2 = bool2.toString();
        Intrinsics.checkNotNullParameter("Is Network Instrumentation", "");
        Intrinsics.checkNotNullParameter(obj2, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("Is Network Instrumentation", obj2);
        String obj3 = bool3.toString();
        Intrinsics.checkNotNullParameter("Is Rum No Op", "");
        Intrinsics.checkNotNullParameter(obj3, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("Is Rum No Op", obj3);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("CASHIER_RETROFIT")
    public Retrofit.Builder provideCashierRetrofitBuilder(Gson gson, @Named("CASHIER_OKHTTP") OkHttpClient okHttpClient, SharedPrefStartupConfig sharedPrefStartupConfig) {
        return setupStandardBuilder(gson, okHttpClient, sharedPrefStartupConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("SECURED_CASHIER_RETROFIT")
    public Retrofit.Builder provideSecuredCashierRetrofitBuilder(Gson gson, @Named("SECURED_CASHIER_OKHTTP") OkHttpClient okHttpClient, SharedPrefStartupConfig sharedPrefStartupConfig) {
        return setupStandardBuilder(gson, okHttpClient, sharedPrefStartupConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("UPLOAD_FILES_RETROFIT")
    public Retrofit.Builder provideUploadFilesRetrofitBuilder(Gson gson, @Named("UPLOAD_FILES_OKHTTP") OkHttpClient okHttpClient, SharedPrefStartupConfig sharedPrefStartupConfig) {
        return setupStandardBuilder(gson, okHttpClient, sharedPrefStartupConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("NON_DANA_SERVICE_RETROFIT")
    public Retrofit.Builder provideNonDanaServiceRetrofitBuilder(Gson gson, @Named("NON_DANA_SERVICE_OKHTTP") OkHttpClient okHttpClient, SharedPrefStartupConfig sharedPrefStartupConfig) {
        return setupStandardBuilder(gson, okHttpClient, sharedPrefStartupConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("RESET_PASSWORD_RETROFIT")
    public Retrofit.Builder provideResetPasswordRetrofitBuilder(Gson gson, @Named("RESET_PASSWORD_OKHTTP") OkHttpClient okHttpClient, SharedPrefStartupConfig sharedPrefStartupConfig) {
        return setupStandardBuilder(gson, okHttpClient, sharedPrefStartupConfig);
    }
}
