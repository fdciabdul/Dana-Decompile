package id.dana.data.config.source.split;

import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.ViewConfiguration;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.core.GriverParams;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.data.config.source.amcs.result.PlayStoreReviewConfig;
import id.dana.data.constant.DanaUrl;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/config/source/split/DefaultJsonGenerator;", "", "Lcom/alibaba/fastjson/JSONObject;", "generateDefaultFeatureH5Entries", "()Lcom/alibaba/fastjson/JSONObject;", "generateDefaultFeatureStoreReview", "generateReferralUrlTnc", "generateShowAlipayConnectBrand", "generateUGCBannerConfig", "", "", "generateWhitelistedDomain", "()Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultJsonGenerator {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    public static final DefaultJsonGenerator INSTANCE;
    private static int[] PlaceComponentResult;
    private static int getAuthRequestContext;

    static {
        MyBillsEntityDataFactory();
        INSTANCE = new DefaultJsonGenerator();
        int i = BuiltInFictitiousFunctionClassFactory + 1;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    static void MyBillsEntityDataFactory() {
        PlaceComponentResult = new int[]{-1476178858, -965771089, 1470449467, -1189271373, -1138763662, 922412810, -535683832, -890446208, 1365772720, 386325804, -1816378251, 1997722074, -756708808, -616320777, 1798386635, -1051828446, -1192457041, 470840914};
    }

    private DefaultJsonGenerator() {
    }

    public final JSONObject generateDefaultFeatureStoreReview() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PlayStoreReviewConfig.Key.SHOW_REVIEW_ENTRACE, (Object) SummaryActivity.CHECKED);
            jSONObject.put(PlayStoreReviewConfig.Key.OPTION_RATE_COUNTDOWN, (Object) "60");
            jSONObject.put(PlayStoreReviewConfig.Key.OPTION_SKIP_COUNTDOWN, (Object) "30");
            jSONObject.put(PlayStoreReviewConfig.Key.SHOW_IN_APP_REVIEW, (Object) "false");
            int i = getAuthRequestContext + 11;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            return jSONObject;
        } catch (Exception e) {
            throw e;
        }
    }

    public final JSONObject generateDefaultFeatureH5Entries() {
        JSONObject jSONObject = new JSONObject();
        Object[] objArr = new Object[1];
        a(8 - (ViewConfiguration.getEdgeSlop() >> 16), new int[]{-1992688122, -817330837, -1480936853, 141323145}, objArr);
        jSONObject.put(((String) objArr[0]).intern(), (Object) DanaUrl.TUTORIAL);
        Object[] objArr2 = new Object[1];
        a(6 - Color.blue(0), new int[]{-1281263529, 2092311736, 950997534, -1057360296}, objArr2);
        jSONObject.put(((String) objArr2[0]).intern(), (Object) DanaUrl.POCKET);
        Object[] objArr3 = new Object[1];
        a(14 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new int[]{-1281263529, 2092311736, -1923057519, -372586616, -1538798371, 858270565, -767803452, 508867199}, objArr3);
        jSONObject.put(((String) objArr3[0]).intern(), (Object) "/m/pocket/detail?pocketId=");
        Object[] objArr4 = new Object[1];
        a(21 - (ViewConfiguration.getPressedStateDuration() >> 16), new int[]{-529786709, 1000035484, 293285897, -1266671309, 269457581, -168547474, -2069547042, -1695410888, -1758088100, -1792786583, -1063043556, 2896632}, objArr4);
        jSONObject.put(((String) objArr4[0]).intern(), (Object) DanaUrl.TRANSACTION_COMPLETED);
        Object[] objArr5 = new Object[1];
        a(23 - ((Process.getThreadPriority(0) + 20) >> 6), new int[]{-529786709, 1000035484, 293285897, -1266671309, 269457581, -168547474, 208846220, -193517432, -220013434, -1743862266, 1710265219, -350297615}, objArr5);
        jSONObject.put(((String) objArr5[0]).intern(), (Object) DanaUrl.TRANSACTION_PROGRESSING);
        Object[] objArr6 = new Object[1];
        a(18 - Gravity.getAbsoluteGravity(0, 0), new int[]{-529786709, 1000035484, 293285897, -1266671309, 269457581, -168547474, -1448725091, 2033277315, -1708788607, -1505202204}, objArr6);
        jSONObject.put(((String) objArr6[0]).intern(), (Object) DanaUrl.TRX_DETAIL);
        Object[] objArr7 = new Object[1];
        a(Color.red(0) + 3, new int[]{2135644574, 1914277535}, objArr7);
        jSONObject.put(((String) objArr7[0]).intern(), (Object) DanaUrl.KYC_LANDING_PAGE);
        int i = getAuthRequestContext + 15;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (!(i % 2 == 0)) {
            return jSONObject;
        }
        Object[] objArr8 = null;
        int length = objArr8.length;
        return jSONObject;
    }

    public final JSONObject generateReferralUrlTnc() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", (Object) DanaUrl.TNC_LINK);
        try {
            int i = getAuthRequestContext + 121;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                return jSONObject;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final JSONObject generateShowAlipayConnectBrand() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ContainerUIProvider.KEY_SHOW, (Object) Boolean.FALSE);
        jSONObject.put(GriverParams.ShareParams.IMAGE_URL, (Object) "");
        int i = BuiltInFictitiousFunctionClassFactory + 91;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            return jSONObject;
        }
        Object obj = null;
        obj.hashCode();
        return jSONObject;
    }

    public final List<String> generateWhitelistedDomain() {
        List<String> listOf;
        int i = getAuthRequestContext + 5;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? 'S' : (char) 2) != 2) {
            String[] strArr = new String[3];
            strArr[1] = "app.ceria.bri.co.id";
            strArr[1] = "registeruat.dbank.co.id/dana-web-verification";
            listOf = CollectionsKt.listOf((Object[]) strArr);
        } else {
            listOf = CollectionsKt.listOf((Object[]) new String[]{"app.ceria.bri.co.id", "registeruat.dbank.co.id/dana-web-verification"});
        }
        int i2 = getAuthRequestContext + 27;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        return listOf;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:17:0x0026
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public final com.alibaba.fastjson.JSONObject generateUGCBannerConfig() {
        /*
            r4 = this;
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject
            r0.<init>()
            java.lang.String r1 = "url"
            java.lang.String r2 = "https://a.m.dana.id/resource/imgs/merchant/img_merchant_bg_null.png"
            r0.put(r1, r2)     // Catch: java.lang.Exception -> L28
            int r1 = id.dana.data.config.source.split.DefaultJsonGenerator.getAuthRequestContext
            int r1 = r1 + 81
            int r2 = r1 % 128
            id.dana.data.config.source.split.DefaultJsonGenerator.BuiltInFictitiousFunctionClassFactory = r2
            int r1 = r1 % 2
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L1c
            r1 = 0
            goto L1d
        L1c:
            r1 = 1
        L1d:
            if (r1 == r3) goto L25
            r1 = 75
            int r1 = r1 / r2
            return r0
        L23:
            r0 = move-exception
            throw r0
        L25:
            return r0
        L26:
            r0 = move-exception
            throw r0
        L28:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.config.source.split.DefaultJsonGenerator.generateUGCBannerConfig():com.alibaba.fastjson.JSONObject");
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int i2;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = PlaceComponentResult;
        if (iArr2 != null) {
            int i3 = $11 + 49;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                iArr3[i5] = (int) (iArr2[i5] ^ (-3152031022165484798L));
                i5++;
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        try {
            int[] iArr5 = PlaceComponentResult;
            if (iArr5 != null) {
                int i6 = $11 + 21;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i8 = 0;
                while (true) {
                    if (i8 >= length3) {
                        break;
                    }
                    iArr6[i8] = (int) (iArr5[i8] ^ (-3152031022165484798L));
                    i8++;
                    length2 = length2;
                }
                i2 = length2;
                iArr5 = iArr6;
            } else {
                i2 = length2;
            }
            System.arraycopy(iArr5, 0, iArr4, 0, i2);
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                try {
                    cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                    cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                    cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                    VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                    int i9 = 0;
                    while (true) {
                        if (!(i9 < 16)) {
                            break;
                        }
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i9];
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        int i10 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i10;
                        i9++;
                        int i11 = $11 + 37;
                        $10 = i11 % 128;
                        int i12 = i11 % 2;
                    }
                    int i13 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i13;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                    int i14 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    int i15 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                    cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                    cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                    cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                    cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                    cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                    cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                    verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            objArr[0] = new String(cArr2, 0, i);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
