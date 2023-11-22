package id.dana.data.h5onlineconfig.repository.source;

import com.iap.ac.config.lite.ConfigCenter;
import id.dana.data.h5onlineconfig.H5OnlineConfigEntityData;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.inject.Singleton;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;
import org.json.JSONObject;

@Singleton
/* loaded from: classes2.dex */
public class AmcsH5OnlineConfig implements H5OnlineConfigEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 1;
    private static char[] getAuthRequestContext = {35577, 35450, 35431, 35430, 35431, 35431};

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0019
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @javax.inject.Inject
    public AmcsH5OnlineConfig(android.content.Context r2, id.dana.data.foundation.amcs.AMCSManager r3) {
        /*
            r1 = this;
            r1.<init>()
            boolean r0 = r3.MyBillsEntityDataFactory()     // Catch: java.lang.Exception -> L38
            if (r0 != 0) goto L1b
            java.lang.String r0 = "prod"
            r3.MyBillsEntityDataFactory(r2, r0)     // Catch: java.lang.Exception -> L38
            int r2 = id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.PlaceComponentResult     // Catch: java.lang.Exception -> L38
            int r2 = r2 + 27
            int r3 = r2 % 128
            id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.MyBillsEntityDataFactory = r3     // Catch: java.lang.Exception -> L38
            int r2 = r2 % 2
            goto L1b
        L19:
            r2 = move-exception
            throw r2
        L1b:
            int r2 = id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.MyBillsEntityDataFactory
            int r2 = r2 + 73
            int r3 = r2 % 128
            id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.PlaceComponentResult = r3
            int r2 = r2 % 2
            r3 = 45
            if (r2 != 0) goto L2c
            r2 = 35
            goto L2e
        L2c:
            r2 = 45
        L2e:
            if (r2 == r3) goto L37
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L35
            return
        L35:
            r2 = move-exception
            throw r2
        L37:
            return
        L38:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.<init>(android.content.Context, id.dana.data.foundation.amcs.AMCSManager):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ JSONObject lambda$getH5OnlineConfig$0(String str) throws Exception {
        JSONObject sectionConfig;
        int i = MyBillsEntityDataFactory + 17;
        PlaceComponentResult = i % 128;
        if ((i % 2 == 0 ? 'a' : (char) 29) != 29) {
            try {
                sectionConfig = ConfigCenter.getInstance().getSectionConfig(str);
                int i2 = 58 / 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            sectionConfig = ConfigCenter.getInstance().getSectionConfig(str);
        }
        int i3 = PlaceComponentResult + 45;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return sectionConfig;
    }

    @Override // id.dana.data.h5onlineconfig.H5OnlineConfigEntityData
    public Observable<com.alibaba.fastjson.JSONObject> getH5OnlineConfig(final String str, final Set<String> set) {
        Observable<com.alibaba.fastjson.JSONObject> onErrorResumeNext = Observable.fromCallable(new Callable() { // from class: id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return AmcsH5OnlineConfig.lambda$getH5OnlineConfig$0(str);
            }
        }).map(new AmcsH5OnlineConfig$$ExternalSyntheticLambda1()).map(new Function() { // from class: id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AmcsH5OnlineConfig.this.m1347x77d7cbbc(set, (com.alibaba.fastjson.JSONObject) obj);
            }
        }).onErrorResumeNext(getCommonSection(str, set));
        int i = PlaceComponentResult + 61;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return onErrorResumeNext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getH5OnlineConfig$1$id-dana-data-h5onlineconfig-repository-source-AmcsH5OnlineConfig  reason: not valid java name */
    public /* synthetic */ com.alibaba.fastjson.JSONObject m1347x77d7cbbc(Set set, com.alibaba.fastjson.JSONObject jSONObject) throws Exception {
        int i = PlaceComponentResult + 97;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? 'O' : '3') != 'O') {
            return getH5OnlineConfigs(jSONObject, set);
        }
        com.alibaba.fastjson.JSONObject h5OnlineConfigs = getH5OnlineConfigs(jSONObject, set);
        Object[] objArr = null;
        int length = objArr.length;
        return h5OnlineConfigs;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0015, code lost:
    
        if ((r5 != null) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001a, code lost:
    
        if (r5 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x001c, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x001d, code lost:
    
        r0 = new com.alibaba.fastjson.JSONObject();
        r5 = r5.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:
    
        r1 = id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.MyBillsEntityDataFactory + 33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.PlaceComponentResult = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
    
        if (r5.hasNext() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0036, code lost:
    
        r0.putAll(getH5OnlineConfig(r4, r5.next()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.fastjson.JSONObject getH5OnlineConfigs(com.alibaba.fastjson.JSONObject r4, java.util.Set<java.lang.String> r5) {
        /*
            r3 = this;
            int r0 = id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L47
            int r0 = r0 + 75
            int r1 = r0 % 128
            id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L45
            int r0 = r0 % 2
            if (r0 != 0) goto L1a
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L18
            if (r5 != 0) goto L14
            r0 = 0
            goto L15
        L14:
            r0 = 1
        L15:
            if (r0 == 0) goto L1c
            goto L1d
        L18:
            r4 = move-exception
            throw r4
        L1a:
            if (r5 != 0) goto L1d
        L1c:
            return r4
        L1d:
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
            int r1 = id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L45
            int r1 = r1 + 33
            int r2 = r1 % 128
            id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.PlaceComponentResult = r2     // Catch: java.lang.Exception -> L47
            int r1 = r1 % 2
        L30:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Exception -> L45
            if (r1 == 0) goto L44
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            com.alibaba.fastjson.JSONObject r1 = r3.getH5OnlineConfig(r4, r1)
            r0.putAll(r1)
            goto L30
        L44:
            return r0
        L45:
            r4 = move-exception
            throw r4
        L47:
            r4 = move-exception
            goto L4a
        L49:
            throw r4
        L4a:
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.getH5OnlineConfigs(com.alibaba.fastjson.JSONObject, java.util.Set):com.alibaba.fastjson.JSONObject");
    }

    private Observable<com.alibaba.fastjson.JSONObject> getCommonSection(String str, final Set<String> set) {
        int i = PlaceComponentResult + 83;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Object[] objArr = new Object[1];
        a(new int[]{0, 6, 139, 0}, false, new byte[]{0, 0, 0, 0, 0, 1}, objArr);
        if (((String) objArr[0]).intern().equals(str)) {
            return Observable.fromCallable(new Callable() { // from class: id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig$$ExternalSyntheticLambda3
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return AmcsH5OnlineConfig.lambda$getCommonSection$2();
                }
            }).map(new AmcsH5OnlineConfig$$ExternalSyntheticLambda1()).map(new Function() { // from class: id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return AmcsH5OnlineConfig.this.m1346x5f680274(set, (com.alibaba.fastjson.JSONObject) obj);
                }
            });
        }
        Observable<com.alibaba.fastjson.JSONObject> just = Observable.just(new com.alibaba.fastjson.JSONObject());
        int i3 = MyBillsEntityDataFactory + 41;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            return just;
        }
        return just;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ JSONObject lambda$getCommonSection$2() throws Exception {
        JSONObject configObject;
        try {
            int i = PlaceComponentResult + 117;
            try {
                MyBillsEntityDataFactory = i % 128;
                if (!(i % 2 != 0)) {
                    configObject = ConfigCenter.getInstance().getConfigObject();
                } else {
                    configObject = ConfigCenter.getInstance().getConfigObject();
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i2 = MyBillsEntityDataFactory + 19;
                PlaceComponentResult = i2 % 128;
                if (!(i2 % 2 == 0)) {
                    return configObject;
                }
                int i3 = 69 / 0;
                return configObject;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getCommonSection$3$id-dana-data-h5onlineconfig-repository-source-AmcsH5OnlineConfig  reason: not valid java name */
    public /* synthetic */ com.alibaba.fastjson.JSONObject m1346x5f680274(Set set, com.alibaba.fastjson.JSONObject jSONObject) throws Exception {
        int i = PlaceComponentResult + 111;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        com.alibaba.fastjson.JSONObject h5OnlineConfigs = getH5OnlineConfigs(jSONObject, set);
        int i3 = MyBillsEntityDataFactory + 41;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return h5OnlineConfigs;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
    
        if ((!android.text.TextUtils.isEmpty(r9) ? 'B' : 'Q') != 'B') goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0069, code lost:
    
        if ((!android.text.TextUtils.isEmpty(r9) ? '/' : com.alibaba.fastjson.parser.JSONLexer.EOI) != '/') goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
    
        r3 = id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.PlaceComponentResult + 77;
        id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.MyBillsEntityDataFactory = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
    
        if ((r3 % 2) == 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
    
        r3 = '2';
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:
    
        r3 = kotlin.text.Typography.amp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
    
        if (r3 == '2') goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008b, code lost:
    
        if (r2.getKey().equals(r9) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008d, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008e, code lost:
    
        if (r4 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0091, code lost:
    
        r3 = r2.getKey().equals(r9);
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009c, code lost:
    
        r4 = r4.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009d, code lost:
    
        if (r3 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009f, code lost:
    
        r1.put(r2.getKey(), r2.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ad, code lost:
    
        r0.put(r2.getKey(), r2.getValue());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.fastjson.JSONObject getH5OnlineConfig(com.alibaba.fastjson.JSONObject r8, java.lang.String r9) {
        /*
            r7 = this;
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject
            r0.<init>()
            com.alibaba.fastjson.JSONObject r1 = new com.alibaba.fastjson.JSONObject
            r1.<init>()
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
            int r2 = id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.PlaceComponentResult
            int r2 = r2 + 51
            int r3 = r2 % 128
            id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.MyBillsEntityDataFactory = r3
            int r2 = r2 % 2
        L1c:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lc0
            int r2 = id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.MyBillsEntityDataFactory
            int r2 = r2 + 49
            int r3 = r2 % 128
            id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.PlaceComponentResult = r3
            int r2 = r2 % 2
            java.lang.Object r2 = r8.next()     // Catch: java.lang.Exception -> Lbe
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch: java.lang.Exception -> Lbe
            if (r2 == 0) goto L1c
            int r3 = id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.PlaceComponentResult
            int r3 = r3 + 115
            int r4 = r3 % 128
            id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.MyBillsEntityDataFactory = r4
            int r3 = r3 % 2
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L44
            r3 = 0
            goto L45
        L44:
            r3 = 1
        L45:
            if (r3 == r5) goto L5c
            boolean r3 = android.text.TextUtils.isEmpty(r9)
            r6 = 73
            int r6 = r6 / r4
            r6 = 66
            if (r3 != 0) goto L55
            r3 = 66
            goto L57
        L55:
            r3 = 81
        L57:
            if (r3 == r6) goto L6c
            goto Lad
        L5a:
            r8 = move-exception
            throw r8
        L5c:
            boolean r3 = android.text.TextUtils.isEmpty(r9)
            r6 = 47
            if (r3 != 0) goto L67
            r3 = 47
            goto L69
        L67:
            r3 = 26
        L69:
            if (r3 == r6) goto L6c
            goto Lad
        L6c:
            int r3 = id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.PlaceComponentResult
            int r3 = r3 + 77
            int r6 = r3 % 128
            id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.MyBillsEntityDataFactory = r6
            int r3 = r3 % 2
            r6 = 50
            if (r3 == 0) goto L7d
            r3 = 50
            goto L7f
        L7d:
            r3 = 38
        L7f:
            if (r3 == r6) goto L91
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L8e
            r4 = 1
        L8e:
            if (r4 == 0) goto Lad
            goto L9f
        L91:
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = r3.equals(r9)
            r4 = 0
            int r4 = r4.length     // Catch: java.lang.Throwable -> Lbc
            if (r3 == 0) goto Lad
        L9f:
            java.lang.Object r8 = r2.getKey()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r2.getValue()
            r1.put(r8, r2)
            goto Lc0
        Lad:
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            r0.put(r3, r2)
            goto L1c
        Lbc:
            r8 = move-exception
            throw r8
        Lbe:
            r8 = move-exception
            throw r8
        Lc0:
            boolean r8 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Exception -> Lc9
            if (r8 == 0) goto Lc7
            goto Lc8
        Lc7:
            r0 = r1
        Lc8:
            return r0
        Lc9:
            r8 = move-exception
            goto Lcc
        Lcb:
            throw r8
        Lcc:
            goto Lcb
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig.getH5OnlineConfig(com.alibaba.fastjson.JSONObject, java.lang.String):com.alibaba.fastjson.JSONObject");
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        char[] cArr;
        char c;
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr2 = getAuthRequestContext;
        if ((cArr2 != null ? 'c' : (char) 14) == 'c') {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i5 = 0;
            while (true) {
                if ((i5 < length ? '3' : ']') == ']') {
                    break;
                }
                cArr3[i5] = (char) (cArr2[i5] ^ 5097613533456403102L);
                i5++;
            }
            cArr2 = cArr3;
        }
        char[] cArr4 = new char[i2];
        System.arraycopy(cArr2, i, cArr4, 0, i2);
        if (!(bArr == null)) {
            try {
                int i6 = $11 + 35;
                $10 = i6 % 128;
                if (i6 % 2 != 0) {
                    cArr = new char[i2];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                    c = 1;
                } else {
                    cArr = new char[i2];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                    c = 0;
                }
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    if ((bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1 ? Typography.amp : 'c') != 'c') {
                        cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    } else {
                        cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    c = cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr4 = cArr;
            } catch (Exception e) {
                throw e;
            }
        }
        if (!(i4 <= 0)) {
            int i7 = $11 + 7;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            char[] cArr5 = new char[i2];
            try {
                System.arraycopy(cArr4, 0, cArr5, 0, i2);
                int i9 = i2 - i4;
                System.arraycopy(cArr5, 0, cArr4, i9, i4);
                System.arraycopy(cArr5, i4, cArr4, 0, i9);
                int i10 = $11 + 51;
                $10 = i10 % 128;
                int i11 = i10 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (z) {
            char[] cArr6 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                int i12 = $11 + 73;
                $10 = i12 % 128;
                int i13 = i12 % 2;
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr4[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr4 = cArr6;
        }
        if (i3 > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        objArr[0] = new String(cArr4);
    }
}
