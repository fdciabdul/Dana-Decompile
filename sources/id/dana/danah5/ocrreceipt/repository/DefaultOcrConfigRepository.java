package id.dana.danah5.ocrreceipt.repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import id.dana.appcontainer.plugin.ocrreceipt.repository.OcrConfigRepository;
import id.dana.danah5.ocrreceipt.repository.model.OcrImagePreprocessingConfigResult;
import id.dana.danah5.ocrreceipt.usecase.model.OcrImagePreprocessingConfigModel;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.storage.Serializer;
import id.dana.util.AmcsConfigUtils;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Singleton
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0013\u0010\r\u001a\u00020\u0007*\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0011\u001a\u00028\u0000\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u000f*\u00020\u0002H\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/danah5/ocrreceipt/repository/DefaultOcrConfigRepository;", "Lid/dana/appcontainer/plugin/ocrreceipt/repository/OcrConfigRepository;", "Lcom/alibaba/fastjson/JSONObject;", "getDefaultImagePreprocessingConfig", "()Lcom/alibaba/fastjson/JSONObject;", "getImagePreprocessingAmcs", "Lio/reactivex/Single;", "Lid/dana/danah5/ocrreceipt/usecase/model/OcrImagePreprocessingConfigModel;", "getImagePreprocessingConfig", "()Lio/reactivex/Single;", "", "getSnapSizeLimit", "Lid/dana/danah5/ocrreceipt/repository/model/OcrImagePreprocessingConfigResult;", "mapToOcrImagePreprocessingConfigModel", "(Lid/dana/danah5/ocrreceipt/repository/model/OcrImagePreprocessingConfigResult;)Lid/dana/danah5/ocrreceipt/usecase/model/OcrImagePreprocessingConfigModel;", "", "T", "toObject", "(Lcom/alibaba/fastjson/JSONObject;)Ljava/lang/Object;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "configEntityDataFactory", "<init>", "(Lid/dana/data/config/source/ConfigEntityDataFactory;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DefaultOcrConfigRepository implements OcrConfigRepository {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final boolean DEFAULT_PREPROCESSING_SWITCH = false;
    public static final long DEFAULT_PREPROCESSING_TIMEOUT = 60;
    public static final long DEFAULT_SIZE_LIMIT_MB = 2097152;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char[] PlaceComponentResult = null;
    private static int getAuthRequestContext = 1;
    private final Serializer serializer;

    public static /* synthetic */ Long $r8$lambda$65Q7fcNovQlB3jsOmuPEArxv3oI(Long l) {
        int i = getAuthRequestContext + 45;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 == 0)) {
            int i2 = 44 / 0;
            return m711getSnapSizeLimit$lambda1(l);
        }
        try {
            return m711getSnapSizeLimit$lambda1(l);
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ Long $r8$lambda$An1uf6xO6qYtwDPz6vSmvkdQcS8() {
        try {
            int i = getAuthRequestContext + 61;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            Long m710getSnapSizeLimit$lambda0 = m710getSnapSizeLimit$lambda0();
            int i3 = getAuthRequestContext + 87;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (i3 % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
                return m710getSnapSizeLimit$lambda0;
            }
            return m710getSnapSizeLimit$lambda0;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ JSONObject $r8$lambda$fZLO5_m0K8fpoF4lzYgB6iWK4k4(DefaultOcrConfigRepository defaultOcrConfigRepository) {
        int i = getAuthRequestContext + 77;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            JSONObject m708getImagePreprocessingConfig$lambda2 = m708getImagePreprocessingConfig$lambda2(defaultOcrConfigRepository);
            int i3 = getAuthRequestContext + 1;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return m708getImagePreprocessingConfig$lambda2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$vA-vqvA-gjyErtrLwZ5ifJeFUKc  reason: not valid java name */
    public static /* synthetic */ OcrImagePreprocessingConfigModel m707$r8$lambda$vAvqvAgjyErtrLwZ5ifJeFUKc(DefaultOcrConfigRepository defaultOcrConfigRepository, JSONObject jSONObject) {
        OcrImagePreprocessingConfigModel m709getImagePreprocessingConfig$lambda3;
        int i = getAuthRequestContext + 9;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        try {
            if (!(i % 2 == 0)) {
                m709getImagePreprocessingConfig$lambda3 = m709getImagePreprocessingConfig$lambda3(defaultOcrConfigRepository, jSONObject);
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                m709getImagePreprocessingConfig$lambda3 = m709getImagePreprocessingConfig$lambda3(defaultOcrConfigRepository, jSONObject);
            }
            int i2 = getAuthRequestContext + 65;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            return m709getImagePreprocessingConfig$lambda3;
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
        int i = getAuthRequestContext + 111;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? '.' : 'Y') != '.') {
            return;
        }
        int i2 = 14 / 0;
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        PlaceComponentResult = new char[]{35351, 35722, 35717, 35722, 35731, 35721, 35715, 35725, 35733, 35724, 35728, 35733, 35731, 35735, 35728, 35718, 35724, 35727, 35718, 35721, 35726, 35733, 35725, 35716, 35723, 35724, 35727, 35732, 35734, 35726, 35723, 35727, 35728, 35729, 35496, 35571, 35562, 35571, 35576, 35566, 35560, 35570, 35575, 35566, 35577, 35574, 35577, 35575, 35568, 35567, 35569, 35580, 35579, 35572, 35573, 35573, 35568};
    }

    @Inject
    public DefaultOcrConfigRepository(ConfigEntityDataFactory configEntityDataFactory, Serializer serializer) {
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.serializer = serializer;
        configEntityDataFactory.createData2("network");
    }

    @Override // id.dana.appcontainer.plugin.ocrreceipt.repository.OcrConfigRepository
    public final Single<Long> getSnapSizeLimit() {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$22;
        try {
            Single PlaceComponentResult2 = Single.PlaceComponentResult(new Callable() { // from class: id.dana.danah5.ocrreceipt.repository.DefaultOcrConfigRepository$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return DefaultOcrConfigRepository.$r8$lambda$An1uf6xO6qYtwDPz6vSmvkdQcS8();
                }
            });
            Function function = new Function() { // from class: id.dana.danah5.ocrreceipt.repository.DefaultOcrConfigRepository$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return DefaultOcrConfigRepository.$r8$lambda$65Q7fcNovQlB3jsOmuPEArxv3oI((Long) obj);
                }
            };
            ObjectHelper.PlaceComponentResult(function, "mapper is null");
            Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(PlaceComponentResult2, function));
            TimeUnit timeUnit = TimeUnit.SECONDS;
            KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
            ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
            ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22, "scheduler is null");
            Single BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleTimeout(BuiltInFictitiousFunctionClassFactory, 1L, timeUnit, KClassImpl$Data$declaredNonStaticMembers$22));
            Long valueOf = Long.valueOf((long) DEFAULT_SIZE_LIMIT_MB);
            ObjectHelper.PlaceComponentResult(valueOf, "value is null");
            Single<Long> BuiltInFictitiousFunctionClassFactory3 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleOnErrorReturn(BuiltInFictitiousFunctionClassFactory2, null, valueOf));
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory3, "");
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            return BuiltInFictitiousFunctionClassFactory3;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getSnapSizeLimit$lambda-0  reason: not valid java name */
    private static final Long m710getSnapSizeLimit$lambda0() {
        Long valueOf;
        Object obj;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 13;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? '@' : (char) 27) != '@') {
            valueOf = Long.valueOf((long) DEFAULT_SIZE_LIMIT_MB);
            Object[] objArr = new Object[1];
            a(new int[]{34, 23, 0, 0}, false, new byte[]{0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1}, objArr);
            obj = objArr[0];
        } else {
            valueOf = Long.valueOf((long) DEFAULT_SIZE_LIMIT_MB);
            Object[] objArr2 = new Object[1];
            a(new int[]{34, 23, 0, 0}, true, new byte[]{0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1}, objArr2);
            obj = objArr2[0];
        }
        return Long.valueOf(AmcsConfigUtils.KClassImpl$Data$declaredNonStaticMembers$2(((String) obj).intern(), valueOf).longValue());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        if (r6.longValue() == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        r6 = id.dana.danah5.ocrreceipt.repository.DefaultOcrConfigRepository.getAuthRequestContext + 1;
        id.dana.danah5.ocrreceipt.repository.DefaultOcrConfigRepository.KClassImpl$Data$declaredNonStaticMembers$2 = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        if ((r6 % 2) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        r6 = ';';
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        r6 = 25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
    
        if (r6 == 25) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        r6 = r6.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        r0 = id.dana.danah5.ocrreceipt.repository.DefaultOcrConfigRepository.DEFAULT_SIZE_LIMIT_MB;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
    
        r0 = r6.longValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0059, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
    
        if (r6.longValue() == 1) goto L13;
     */
    /* renamed from: getSnapSizeLimit$lambda-1  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.lang.Long m711getSnapSizeLimit$lambda1(java.lang.Long r6) {
        /*
            int r0 = id.dana.danah5.ocrreceipt.repository.DefaultOcrConfigRepository.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 41
            int r1 = r0 % 128
            id.dana.danah5.ocrreceipt.repository.DefaultOcrConfigRepository.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 89
            if (r0 != 0) goto L11
            r0 = 1
            goto L13
        L11:
            r0 = 89
        L13:
            java.lang.String r3 = ""
            if (r0 == r2) goto L25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            long r2 = r6.longValue()
            r4 = 1
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L4f
            goto L32
        L25:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            long r2 = r6.longValue()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L4f
        L32:
            int r6 = id.dana.danah5.ocrreceipt.repository.DefaultOcrConfigRepository.getAuthRequestContext
            int r6 = r6 + r1
            int r0 = r6 % 128
            id.dana.danah5.ocrreceipt.repository.DefaultOcrConfigRepository.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r6 = r6 % 2
            r0 = 25
            if (r6 == 0) goto L42
            r6 = 59
            goto L44
        L42:
            r6 = 25
        L44:
            if (r6 == r0) goto L4b
            r6 = 0
            int r6 = r6.length     // Catch: java.lang.Throwable -> L49
            goto L4b
        L49:
            r6 = move-exception
            throw r6
        L4b:
            r0 = 2097152(0x200000, double:1.0361308E-317)
            goto L53
        L4f:
            long r0 = r6.longValue()     // Catch: java.lang.Exception -> L58
        L53:
            java.lang.Long r6 = java.lang.Long.valueOf(r0)
            return r6
        L58:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.ocrreceipt.repository.DefaultOcrConfigRepository.m711getSnapSizeLimit$lambda1(java.lang.Long):java.lang.Long");
    }

    @Override // id.dana.appcontainer.plugin.ocrreceipt.repository.OcrConfigRepository
    public final Single<OcrImagePreprocessingConfigModel> getImagePreprocessingConfig() {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$22;
        Single PlaceComponentResult2 = Single.PlaceComponentResult(new Callable() { // from class: id.dana.danah5.ocrreceipt.repository.DefaultOcrConfigRepository$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultOcrConfigRepository.$r8$lambda$fZLO5_m0K8fpoF4lzYgB6iWK4k4(DefaultOcrConfigRepository.this);
            }
        });
        Function function = new Function() { // from class: id.dana.danah5.ocrreceipt.repository.DefaultOcrConfigRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultOcrConfigRepository.m707$r8$lambda$vAvqvAgjyErtrLwZ5ifJeFUKc(DefaultOcrConfigRepository.this, (JSONObject) obj);
            }
        };
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(PlaceComponentResult2, function));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleTimeout(BuiltInFictitiousFunctionClassFactory, 1L, timeUnit, KClassImpl$Data$declaredNonStaticMembers$22));
        Object deserialize = this.serializer.deserialize(getDefaultImagePreprocessingConfig().toString(), OcrImagePreprocessingConfigResult.class);
        Intrinsics.checkNotNullExpressionValue(deserialize, "");
        OcrImagePreprocessingConfigModel mapToOcrImagePreprocessingConfigModel = mapToOcrImagePreprocessingConfigModel((OcrImagePreprocessingConfigResult) deserialize);
        ObjectHelper.PlaceComponentResult(mapToOcrImagePreprocessingConfigModel, "value is null");
        Single<OcrImagePreprocessingConfigModel> BuiltInFictitiousFunctionClassFactory3 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleOnErrorReturn(BuiltInFictitiousFunctionClassFactory2, null, mapToOcrImagePreprocessingConfigModel));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory3, "");
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return BuiltInFictitiousFunctionClassFactory3;
    }

    /* renamed from: getImagePreprocessingConfig$lambda-2  reason: not valid java name */
    private static final JSONObject m708getImagePreprocessingConfig$lambda2(DefaultOcrConfigRepository defaultOcrConfigRepository) {
        int i = getAuthRequestContext + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(defaultOcrConfigRepository, "");
        JSONObject imagePreprocessingAmcs = defaultOcrConfigRepository.getImagePreprocessingAmcs();
        try {
            int i3 = getAuthRequestContext + 55;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return imagePreprocessingAmcs;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getImagePreprocessingConfig$lambda-3  reason: not valid java name */
    private static final OcrImagePreprocessingConfigModel m709getImagePreprocessingConfig$lambda3(DefaultOcrConfigRepository defaultOcrConfigRepository, JSONObject jSONObject) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 37;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? (char) 16 : '8') != 16) {
            try {
                Intrinsics.checkNotNullParameter(defaultOcrConfigRepository, "");
                Intrinsics.checkNotNullParameter(jSONObject, "");
                Object deserialize = defaultOcrConfigRepository.serializer.deserialize(jSONObject.toString(), OcrImagePreprocessingConfigResult.class);
                Intrinsics.checkNotNullExpressionValue(deserialize, "");
                return defaultOcrConfigRepository.mapToOcrImagePreprocessingConfigModel((OcrImagePreprocessingConfigResult) deserialize);
            } catch (Exception e) {
                throw e;
            }
        }
        Intrinsics.checkNotNullParameter(defaultOcrConfigRepository, "");
        Intrinsics.checkNotNullParameter(jSONObject, "");
        Object deserialize2 = defaultOcrConfigRepository.serializer.deserialize(jSONObject.toString(), OcrImagePreprocessingConfigResult.class);
        Intrinsics.checkNotNullExpressionValue(deserialize2, "");
        OcrImagePreprocessingConfigModel mapToOcrImagePreprocessingConfigModel = defaultOcrConfigRepository.mapToOcrImagePreprocessingConfigModel((OcrImagePreprocessingConfigResult) deserialize2);
        Object obj = null;
        obj.hashCode();
        return mapToOcrImagePreprocessingConfigModel;
    }

    private final JSONObject getImagePreprocessingAmcs() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 87;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            JSONObject defaultImagePreprocessingConfig = getDefaultImagePreprocessingConfig();
            Object[] objArr = new Object[1];
            a(new int[]{0, 34, 167, 0}, true, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0}, objArr);
            JSONObject authRequestContext = AmcsConfigUtils.getAuthRequestContext(((String) objArr[0]).intern(), defaultImagePreprocessingConfig);
            if (authRequestContext != null) {
                return authRequestContext;
            }
        } else {
            JSONObject defaultImagePreprocessingConfig2 = getDefaultImagePreprocessingConfig();
            Object[] objArr2 = new Object[1];
            a(new int[]{0, 34, 167, 0}, false, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0}, objArr2);
            JSONObject authRequestContext2 = AmcsConfigUtils.getAuthRequestContext(((String) objArr2[0]).intern(), defaultImagePreprocessingConfig2);
            if (authRequestContext2 != null) {
                return authRequestContext2;
            }
        }
        JSONObject defaultImagePreprocessingConfig3 = getDefaultImagePreprocessingConfig();
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        return defaultImagePreprocessingConfig3;
    }

    private final /* synthetic */ <T> T toObject(JSONObject jSONObject) {
        int i = getAuthRequestContext + 117;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
        }
        Serializer serializer = this.serializer;
        String obj = jSONObject.toString();
        Intrinsics.reifiedOperationMarker(4, "T");
        T t = (T) serializer.deserialize(obj, Object.class);
        Intrinsics.checkNotNullExpressionValue(t, "");
        return t;
    }

    private final OcrImagePreprocessingConfigModel mapToOcrImagePreprocessingConfigModel(OcrImagePreprocessingConfigResult ocrImagePreprocessingConfigResult) {
        try {
            OcrImagePreprocessingConfigModel ocrImagePreprocessingConfigModel = new OcrImagePreprocessingConfigModel(ocrImagePreprocessingConfigResult.getEnable(), ocrImagePreprocessingConfigResult.getTimeout());
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            return ocrImagePreprocessingConfigModel;
        } catch (Exception e) {
            throw e;
        }
    }

    private final JSONObject getDefaultImagePreprocessingConfig() {
        JSONObject jSONObject;
        try {
            Object json = JSON.toJSON(new OcrImagePreprocessingConfigResult(false, 60L));
            if (json != null) {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
                getAuthRequestContext = i % 128;
                if ((i % 2 == 0 ? ':' : (char) 24) != ':') {
                    try {
                        jSONObject = (JSONObject) json;
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    jSONObject = (JSONObject) json;
                    int i2 = 68 / 0;
                }
                int i3 = getAuthRequestContext + 9;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    int i4 = 43 / 0;
                    return jSONObject;
                }
                return jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        int length;
        char[] cArr;
        int i;
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        char[] cArr2 = PlaceComponentResult;
        if (cArr2 != null) {
            try {
                int i6 = $11 + 29;
                $10 = i6 % 128;
                if (i6 % 2 != 0) {
                    length = cArr2.length;
                    cArr = new char[length];
                    i = 1;
                } else {
                    length = cArr2.length;
                    cArr = new char[length];
                    i = 0;
                }
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    int i7 = $10 + 47;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    cArr[i] = (char) (cArr2[i] ^ 5097613533456403102L);
                    i++;
                }
                cArr2 = cArr;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr3 = new char[i3];
        try {
            System.arraycopy(cArr2, i2, cArr3, 0, i3);
            if (bArr != null) {
                char[] cArr4 = new char[i3];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                char c = 0;
                while (true) {
                    if (!(verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3)) {
                        break;
                    }
                    if ((bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1 ? 'M' : '7') != 'M') {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    }
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                int i9 = $11 + 81;
                $10 = i9 % 128;
                int i10 = i9 % 2;
                cArr3 = cArr4;
            }
            if (i5 > 0) {
                char[] cArr5 = new char[i3];
                System.arraycopy(cArr3, 0, cArr5, 0, i3);
                int i11 = i3 - i5;
                System.arraycopy(cArr5, 0, cArr3, i11, i5);
                System.arraycopy(cArr5, i5, cArr3, 0, i11);
            }
            if (!(!z)) {
                char[] cArr6 = new char[i3];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (true) {
                    if ((verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3 ? 'O' : '2') == '2') {
                        break;
                    }
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i3 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr6;
            }
            if (i4 > 0) {
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3) {
                    cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
            }
            objArr[0] = new String(cArr3);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
