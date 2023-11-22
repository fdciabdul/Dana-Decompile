package id.dana.explore.data.toggle.source;

import com.alibaba.fastjson.JSONObject;
import id.dana.danah5.DanaH5;
import id.dana.data.services.repository.ServicesEntityRepository;
import id.dana.explore.data.globalsearch.model.ExplorePromoConfigResponse;
import id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse;
import id.dana.explore.data.globalsearch.model.GlobalSearchWidgetResponse;
import id.dana.explore.domain.globalsearch.model.PopularPlaceInfo;
import id.dana.mybills.ui.constant.MyBillsServiceKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\f\u0010\u0005J\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0012J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0013\u0010\u0005"}, d2 = {"Lid/dana/explore/data/toggle/source/DefaultExploreGenerator;", "", "", "Lcom/alibaba/fastjson/JSONObject;", "BuiltInFictitiousFunctionClassFactory", "()Ljava/util/List;", "", "p0", "", "p1", "getAuthRequestContext", "(Ljava/lang/String;Z)Lcom/alibaba/fastjson/JSONObject;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/lang/String;", "Lid/dana/explore/data/globalsearch/model/GlobalSearchConfigResponse;", "MyBillsEntityDataFactory", "()Lid/dana/explore/data/globalsearch/model/GlobalSearchConfigResponse;", "p2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DefaultExploreGenerator {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final DefaultExploreGenerator INSTANCE;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static char[] MyBillsEntityDataFactory;
    private static int getAuthRequestContext;

    static {
        lookAheadTest();
        INSTANCE = new DefaultExploreGenerator();
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 41;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? '@' : (char) 31) != '@') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x0017
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static java.lang.String getAuthRequestContext() {
        /*
            int r0 = id.dana.explore.data.toggle.source.DefaultExploreGenerator.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L19
            int r0 = r0 + 115
            int r1 = r0 % 128
            id.dana.explore.data.toggle.source.DefaultExploreGenerator.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L19
            int r0 = r0 % 2
            java.lang.String r0 = "{\n   \"OFFLINE_MERCHANT\":{\n      \"enable\":true,\n      \"name\":\"NEARBY MERCHANTS\",\n      \"permission\": [\"location\"]\n   },\n   \"ONLINE_MERCHANT\":{\n      \"enable\":true,\n      \"name\":\"ONLINE MERCHANTS\"\n   },\n    \"SERVICE\":{\n      \"enable\":true,\n      \"name\":\"SERVICES\"\n   },\n    \"DF_SKU\":{\n      \"enable\":false,\n      \"name\":\"EAZY EATS DISHES\",\n      \"permission\": [\"location\"]\n   },\n    \"DF\":{\n      \"enable\":false,\n      \"name\":\"EAZY EATS RESTAURANTS\",\n      \"permission\": [\"location\"]\n   }\n}"
            int r1 = id.dana.explore.data.toggle.source.DefaultExploreGenerator.getAuthRequestContext
            int r1 = r1 + 105
            int r2 = r1 % 128
            id.dana.explore.data.toggle.source.DefaultExploreGenerator.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            return r0
        L17:
            r0 = move-exception
            throw r0
        L19:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.data.toggle.source.DefaultExploreGenerator.getAuthRequestContext():java.lang.String");
    }

    static void lookAheadTest() {
        MyBillsEntityDataFactory = new char[]{35498, 35572, 35574, 35573, 35573, 35578, 35579, 35578, 35575, 35570, 35576, 35570, 35570, 35573, 35562, 35569, 35576, 35578, 35580, 35576, 35568, 35574, 35492, 35567, 35569, 35564, 35564};
    }

    private DefaultExploreGenerator() {
    }

    public static List<JSONObject> PlaceComponentResult() {
        int i = getAuthRequestContext + 45;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        JSONObject authRequestContext = getAuthRequestContext("electricity", "prepostpaid", MyBillsServiceKey.ELECTRICITY);
        Object[] objArr = new Object[1];
        a(new int[]{0, 22, 0, 11}, false, new byte[]{1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1}, objArr);
        List<JSONObject> listOf = CollectionsKt.listOf((Object[]) new JSONObject[]{authRequestContext, getAuthRequestContext("mobilerecharge", "prepaid", ((String) objArr[0]).intern()), getAuthRequestContext("mobilerecharge", "postpaid", MyBillsServiceKey.MOBILE_POSTPAID), getAuthRequestContext("bpjs", "service", MyBillsServiceKey.BPJS), getAuthRequestContext("education", "service", "service_education"), getAuthRequestContext("creditcard", "service", "service_credit_card_repayment"), getAuthRequestContext("mptelkom", "service", "service_telkom"), getAuthRequestContext("games", "service", ServicesEntityRepository.SERVICE_GAMES), getAuthRequestContext("water", "service", MyBillsServiceKey.WATER)});
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return listOf;
    }

    public static List<JSONObject> BuiltInFictitiousFunctionClassFactory() {
        int i = getAuthRequestContext + 107;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        JSONObject authRequestContext = getAuthRequestContext("send_money", true);
        Object[] objArr = new Object[1];
        a(new int[]{0, 22, 0, 11}, false, new byte[]{1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1}, objArr);
        JSONObject authRequestContext2 = getAuthRequestContext(((String) objArr[0]).intern(), false);
        Object[] objArr2 = new Object[1];
        a(new int[]{22, 5, 0, 5}, false, new byte[]{0, 1, 1, 1, 1}, objArr2);
        List<JSONObject> listOf = CollectionsKt.listOf((Object[]) new JSONObject[]{authRequestContext, authRequestContext2, getAuthRequestContext(((String) objArr2[0]).intern(), false)});
        int i3 = getAuthRequestContext + 97;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return listOf;
    }

    public static List<String> KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 13;
        getAuthRequestContext = i % 128;
        if (!(i % 2 != 0)) {
            return CollectionsKt.listOf((Object[]) new String[]{"^[\\d\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\\\\\^\\_\\`\\~]+$", "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}", "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)"});
        }
        String[] strArr = new String[2];
        strArr[1] = "^[\\d\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\\\\\^\\_\\`\\~]+$";
        strArr[1] = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}";
        strArr[5] = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
        return CollectionsKt.listOf((Object[]) strArr);
    }

    private static JSONObject getAuthRequestContext(String p0, String p1, String p2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", (Object) p0);
        jSONObject.put("type", (Object) p1);
        jSONObject.put("serviceName", (Object) p2);
        try {
            int i = getAuthRequestContext + 59;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            return jSONObject;
        } catch (Exception e) {
            throw e;
        }
    }

    private static JSONObject getAuthRequestContext(String p0, boolean p1) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(DanaH5.SERVICE_KEY, (Object) p0);
        jSONObject.put("highlight", (Object) Boolean.valueOf(p1));
        int i = getAuthRequestContext + 75;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return jSONObject;
    }

    public static GlobalSearchConfigResponse MyBillsEntityDataFactory() {
        Boolean bool = Boolean.FALSE;
        GlobalSearchConfigResponse globalSearchConfigResponse = new GlobalSearchConfigResponse(bool, CollectionsKt.listOf(new PopularPlaceInfo("", "", "", false, 8, null)), bool, bool, new ExplorePromoConfigResponse(0), bool, bool, CollectionsKt.listOf((Object[]) new GlobalSearchWidgetResponse[]{new GlobalSearchWidgetResponse(1, "popularplace"), new GlobalSearchWidgetResponse(2, "promo"), new GlobalSearchWidgetResponse(3, "sku"), new GlobalSearchWidgetResponse(4, "recommendedservice"), new GlobalSearchWidgetResponse(5, "offlinemerchant"), new GlobalSearchWidgetResponse(6, "onlinemerchant"), new GlobalSearchWidgetResponse(7, "categoryservice"), new GlobalSearchWidgetResponse(8, "categorysku"), new GlobalSearchWidgetResponse(9, "restaurant")}));
        int i = getAuthRequestContext + 85;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return globalSearchConfigResponse;
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        int i;
        int i2;
        int i3;
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = 2;
        int i7 = iArr[2];
        int i8 = iArr[3];
        char[] cArr = MyBillsEntityDataFactory;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i9 = 0;
            while (i9 < length) {
                int i10 = $10 + 21;
                $11 = i10 % 128;
                if (i10 % i6 == 0) {
                    i3 = i7;
                    cArr2[i9] = (char) (cArr[i9] ^ 5097613533456403102L);
                    i9 *= 1;
                } else {
                    i3 = i7;
                    cArr2[i9] = (char) (cArr[i9] ^ 5097613533456403102L);
                    i9++;
                }
                i7 = i3;
                i6 = 2;
            }
            i = i7;
            cArr = cArr2;
        } else {
            i = i7;
        }
        char[] cArr3 = new char[i5];
        System.arraycopy(cArr, i4, cArr3, 0, i5);
        if (bArr != null) {
            int i11 = $11 + 65;
            $10 = i11 % 128;
            int i12 = i11 % 2;
            char[] cArr4 = new char[i5];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i5) {
                if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                    int i13 = $10 + 49;
                    $11 = i13 % 128;
                    if (i13 % 2 != 0) {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] % 2) / 1) + c);
                    }
                } else {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                }
                c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            int i14 = $10 + 33;
            $11 = i14 % 128;
            int i15 = i14 % 2;
            cArr3 = cArr4;
        }
        if ((i8 > 0 ? (char) 22 : ';') == 22) {
            char[] cArr5 = new char[i5];
            System.arraycopy(cArr3, 0, cArr5, 0, i5);
            int i16 = i5 - i8;
            System.arraycopy(cArr5, 0, cArr3, i16, i8);
            System.arraycopy(cArr5, i8, cArr3, 0, i16);
        }
        if (z) {
            char[] cArr6 = new char[i5];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i5) {
                try {
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i5 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
            cArr3 = cArr6;
        }
        if (i > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i5) {
                int i17 = $11 + 65;
                try {
                    $10 = i17 % 128;
                    if (i17 % 2 != 0) {
                        cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                        i2 = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory % 1;
                    } else {
                        cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                        i2 = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory + 1;
                    }
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = i2;
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        objArr[0] = new String(cArr3);
    }
}
