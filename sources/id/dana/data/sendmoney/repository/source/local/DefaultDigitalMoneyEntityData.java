package id.dana.data.sendmoney.repository.source.local;

import android.content.Context;
import com.alibaba.fastjson.parser.JSONLexer;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.sendmoney.DigitalMoneyEntityData;
import id.dana.data.sendmoney.model.DigitalMoneyEntity;
import id.dana.data.sendmoney.model.DigitalMoneyResult;
import id.dana.data.sendmoney.model.DigitalMoneyResultKt;
import id.dana.data.sendmoney.model.EWalletInnovConfigResult;
import id.dana.data.storage.Serializer;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Singleton
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ+\u0010\u0011\u001a\u001e\u0012\b\u0012\u0006*\u00020\u00070\u0007\u0018\u0001*\u000e\u0012\b\u0012\u0006*\u00020\u00070\u0007\u0018\u00010\u00030\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0007¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/data/sendmoney/repository/source/local/DefaultDigitalMoneyEntityData;", "Lid/dana/data/sendmoney/DigitalMoneyEntityData;", "Lkotlin/Function0;", "", "Lid/dana/data/sendmoney/model/DigitalMoneyEntity;", "getDigitalMoneyEntities", "()Lkotlin/jvm/functions/Function0;", "", "prefixes", "getDigitalMoneyEntityFromFile", "(Ljava/util/List;)Ljava/util/List;", "Lio/reactivex/Observable;", "Lid/dana/data/sendmoney/model/EWalletInnovConfigResult;", "getEWalletInnovConfig", "()Lio/reactivex/Observable;", "getEWalletPrefix", "", "getPrefixes", "()Ljava/util/List;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "getSerializer", "()Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultDigitalMoneyEntityData implements DigitalMoneyEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    public static final String DEFAULT_CATEGORIES_PREFIX_JSON = "json/amcs-ewallets-categories-prefix-default.json";
    public static final String DEFAULT_EWALLET_PREFIX_JSON = "json/amcs-ewallets-prefix-default.json";
    private static int PlaceComponentResult = 1;
    private static char[] getAuthRequestContext;
    private final Context context;
    private final Serializer serializer;

    public static /* synthetic */ List $r8$lambda$BFpyMXgqhJ9SoM1tpoQC_4Es3Ig(Function0 function0) {
        int i = PlaceComponentResult + 23;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            List m1919getEWalletPrefix$lambda0 = m1919getEWalletPrefix$lambda0(function0);
            int i3 = BuiltInFictitiousFunctionClassFactory + 3;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 == 0 ? '1' : Typography.dollar) != '$') {
                Object[] objArr = null;
                int length = objArr.length;
                return m1919getEWalletPrefix$lambda0;
            }
            return m1919getEWalletPrefix$lambda0;
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
        int i = BuiltInFictitiousFunctionClassFactory + 37;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    static void getAuthRequestContext() {
        getAuthRequestContext = new char[]{35572, 35413, 35411, 35406, 35410, 35406, 35412, 35406, 35404, 35406, 35401, 35404, 35408, 35415, 35409, 35402, 35413, 35415, 35409};
    }

    @Inject
    public DefaultDigitalMoneyEntityData(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.context = context;
        this.serializer = serializer;
    }

    public static final /* synthetic */ List access$getDigitalMoneyEntityFromFile(DefaultDigitalMoneyEntityData defaultDigitalMoneyEntityData, List list) {
        int i = BuiltInFictitiousFunctionClassFactory + 115;
        PlaceComponentResult = i % 128;
        char c = i % 2 == 0 ? '8' : '?';
        List<DigitalMoneyEntity> digitalMoneyEntityFromFile = defaultDigitalMoneyEntityData.getDigitalMoneyEntityFromFile(list);
        if (c != '?') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return digitalMoneyEntityFromFile;
    }

    public static final /* synthetic */ List access$getPrefixes(DefaultDigitalMoneyEntityData defaultDigitalMoneyEntityData) {
        int i = BuiltInFictitiousFunctionClassFactory + 109;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        List<String> prefixes = defaultDigitalMoneyEntityData.getPrefixes();
        int i3 = BuiltInFictitiousFunctionClassFactory + 63;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return prefixes;
    }

    @JvmName(name = "getContext")
    public final Context getContext() {
        try {
            int i = PlaceComponentResult + 21;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (i % 2 == 0) {
                return this.context;
            }
            try {
                int i2 = 17 / 0;
                return this.context;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getSerializer")
    public final Serializer getSerializer() {
        int i = PlaceComponentResult + 85;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        Serializer serializer = this.serializer;
        int i3 = BuiltInFictitiousFunctionClassFactory + 39;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return serializer;
    }

    /* renamed from: getEWalletPrefix$lambda-0  reason: not valid java name */
    private static final List m1919getEWalletPrefix$lambda0(Function0 function0) {
        List list;
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 37;
            PlaceComponentResult = i % 128;
            Object obj = null;
            if (i % 2 == 0) {
                Intrinsics.checkNotNullParameter(function0, "");
                list = (List) function0.invoke();
                obj.hashCode();
            } else {
                try {
                    Intrinsics.checkNotNullParameter(function0, "");
                    list = (List) function0.invoke();
                } catch (Exception e) {
                    throw e;
                }
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 41;
            PlaceComponentResult = i2 % 128;
            if (!(i2 % 2 == 0)) {
                return list;
            }
            obj.hashCode();
            return list;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.data.sendmoney.DigitalMoneyEntityData
    public final Observable<List<DigitalMoneyEntity>> getEWalletPrefix() {
        final Function0<List<DigitalMoneyEntity>> digitalMoneyEntities = getDigitalMoneyEntities();
        Observable<List<DigitalMoneyEntity>> onErrorReturnItem = Observable.fromCallable(new Callable() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultDigitalMoneyEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultDigitalMoneyEntityData.$r8$lambda$BFpyMXgqhJ9SoM1tpoQC_4Es3Ig(Function0.this);
            }
        }).onErrorReturnItem(CollectionsKt.emptyList());
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        int i = PlaceComponentResult + 83;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 != 0 ? 'M' : JSONLexer.EOI) != 'M') {
            return onErrorReturnItem;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return onErrorReturnItem;
    }

    @Override // id.dana.data.sendmoney.DigitalMoneyEntityData
    public final Observable<EWalletInnovConfigResult> getEWalletInnovConfig() {
        Observable<EWalletInnovConfigResult> just = Observable.just(new EWalletInnovConfigResult("", "", "", "", false));
        Intrinsics.checkNotNullExpressionValue(just, "");
        try {
            int i = PlaceComponentResult + 97;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (i % 2 != 0) {
                Object obj = null;
                obj.hashCode();
                return just;
            }
            return just;
        } catch (Exception e) {
            throw e;
        }
    }

    private final Function0<List<DigitalMoneyEntity>> getDigitalMoneyEntities() {
        Function0<List<DigitalMoneyEntity>> function0 = (Function0) new Function0<List<? extends DigitalMoneyEntity>>() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultDigitalMoneyEntityData$getDigitalMoneyEntities$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends DigitalMoneyEntity> invoke() {
                List access$getPrefixes = DefaultDigitalMoneyEntityData.access$getPrefixes(DefaultDigitalMoneyEntityData.this);
                List<? extends DigitalMoneyEntity> access$getDigitalMoneyEntityFromFile = access$getPrefixes != null ? DefaultDigitalMoneyEntityData.access$getDigitalMoneyEntityFromFile(DefaultDigitalMoneyEntityData.this, access$getPrefixes) : null;
                return access$getDigitalMoneyEntityFromFile == null ? CollectionsKt.emptyList() : access$getDigitalMoneyEntityFromFile;
            }
        };
        int i = PlaceComponentResult + 51;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (i % 2 != 0) {
            Object obj = null;
            obj.hashCode();
            return function0;
        }
        return function0;
    }

    private final List<String> getPrefixes() {
        Object obj;
        String str;
        String PlaceComponentResult2 = JsonUtil.PlaceComponentResult(this.context, DEFAULT_EWALLET_PREFIX_JSON);
        if (PlaceComponentResult2 != null) {
            Map<String, String> deserializeMap = this.serializer.deserializeMap(PlaceComponentResult2);
            if ((deserializeMap != null ? Typography.dollar : '1') != '$') {
                str = null;
            } else {
                int i = PlaceComponentResult + 15;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if (i % 2 != 0) {
                    Object[] objArr = new Object[1];
                    a(new int[]{0, 19, 100, 9}, false, new byte[]{0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, objArr);
                    obj = objArr[0];
                } else {
                    Object[] objArr2 = new Object[1];
                    a(new int[]{0, 19, 100, 9}, true, new byte[]{0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, objArr2);
                    obj = objArr2[0];
                }
                str = deserializeMap.get(((String) obj).intern());
            }
            if (str != null) {
                int i2 = BuiltInFictitiousFunctionClassFactory + 19;
                PlaceComponentResult = i2 % 128;
                int i3 = i2 % 2;
                return this.serializer.deserializeList(str);
            }
            return null;
        }
        return null;
    }

    private final List<DigitalMoneyEntity> getDigitalMoneyEntityFromFile(List<String> prefixes) {
        Map<String, String> deserializeMap;
        DigitalMoneyEntity digitalMoneyEntity;
        String PlaceComponentResult2 = JsonUtil.PlaceComponentResult(this.context, DEFAULT_CATEGORIES_PREFIX_JSON);
        if (PlaceComponentResult2 == null || (deserializeMap = this.serializer.deserializeMap(PlaceComponentResult2)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : prefixes) {
            try {
                Serializer serializer = this.serializer;
                StringBuilder sb = new StringBuilder();
                sb.append("ewallet_");
                sb.append(str);
                DigitalMoneyResult digitalMoneyResult = (DigitalMoneyResult) serializer.deserialize(deserializeMap.get(sb.toString()), DigitalMoneyResult.class);
                if ((digitalMoneyResult != null ? 'Y' : 'b') != 'b') {
                    try {
                        int i = BuiltInFictitiousFunctionClassFactory + 115;
                        PlaceComponentResult = i % 128;
                        int i2 = i % 2;
                        digitalMoneyEntity = DigitalMoneyResultKt.toDigitalMoneyEntity(digitalMoneyResult, str);
                        int i3 = PlaceComponentResult + 91;
                        BuiltInFictitiousFunctionClassFactory = i3 % 128;
                        int i4 = i3 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    digitalMoneyEntity = null;
                }
                if (digitalMoneyEntity != null) {
                    arrayList.add(digitalMoneyEntity);
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return arrayList;
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
        char[] cArr2 = getAuthRequestContext;
        if (cArr2 != null) {
            int i6 = $10 + 43;
            $11 = i6 % 128;
            if ((i6 % 2 == 0 ? (char) 22 : (char) 25) != 22) {
                length = cArr2.length;
                cArr = new char[length];
                i = 0;
            } else {
                length = cArr2.length;
                cArr = new char[length];
                i = 1;
            }
            while (i < length) {
                cArr[i] = (char) (cArr2[i] ^ 5097613533456403102L);
                i++;
            }
            cArr2 = cArr;
        }
        char[] cArr3 = new char[i3];
        try {
            System.arraycopy(cArr2, i2, cArr3, 0, i3);
            if ((bArr != null ? '=' : 'U') == '=') {
                char[] cArr4 = new char[i3];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                char c = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3) {
                    if (!(bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] != 1)) {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                        int i7 = $10 + 33;
                        $11 = i7 % 128;
                        int i8 = i7 % 2;
                    } else {
                        try {
                            cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr4;
            }
            if (i5 > 0) {
                char[] cArr5 = new char[i3];
                System.arraycopy(cArr3, 0, cArr5, 0, i3);
                int i9 = i3 - i5;
                System.arraycopy(cArr5, 0, cArr3, i9, i5);
                System.arraycopy(cArr5, i5, cArr3, 0, i9);
            }
            if (z) {
                int i10 = $11 + 103;
                $10 = i10 % 128;
                int i11 = i10 % 2;
                char[] cArr6 = new char[i3];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (true) {
                    if ((verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3 ? '+' : (char) 7) != '+') {
                        break;
                    }
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i3 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr6;
            }
            if ((i4 > 0 ? '?' : ',') != ',') {
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3) {
                    int i12 = $10 + 101;
                    $11 = i12 % 128;
                    int i13 = i12 % 2;
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
