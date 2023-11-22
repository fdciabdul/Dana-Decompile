package id.dana.data.dynamicurl;

import android.graphics.Color;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.constant.DanaUrl;
import id.dana.data.util.UrlUtil;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Singleton;
import kotlin.text.Typography;
import o.C;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import o.getOnBoardingScenario;

@Singleton
/* loaded from: classes2.dex */
public class DynamicUrlWrapper {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 18383;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 43073;
    private static int MyBillsEntityDataFactory = 0;
    private static char PlaceComponentResult = 51979;
    private static final String TAG = "DynamicUrlWrapper";
    private static char getAuthRequestContext = 61406;
    private static int scheduleImpl = 1;
    private String changeNameUrl;
    private String changePinUrl;
    private final ConfigEntityDataFactory configEntityDataFactory;
    private String forgotPinUrl;
    private String globalSendCountryListUrl;
    private String globalSendProvinceAndCityListUrl;
    private String helpUrl;
    private String kycFromGoalSavingUrl;
    private String kycFromKybUrl;
    private String kycFromProfileUrl;
    private String kycFromSendMoneyUrl;
    private String kycLandingPageUrl;
    private String myPaymentCardsUrl;
    private String pocketUrl;
    private String privacyPolicyUrl;
    private String readEMoney;
    private String topupUrl;
    private String transactionCompletedUrl;
    private String transactionDetailUrl;
    private String transactionProgressingUrl;
    private String trxDetailUrl;
    private String tutorialUrl;
    private String voucherDetail;

    private String getEntryPointTag() {
        try {
            int i = MyBillsEntityDataFactory + 11;
            scheduleImpl = i % 128;
            if (i % 2 == 0) {
                int i2 = 41 / 0;
                return "{entryPoint}";
            }
            return "{entryPoint}";
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ String access$002(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        int i = MyBillsEntityDataFactory + 107;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        dynamicUrlWrapper.topupUrl = str;
        int i3 = MyBillsEntityDataFactory + 91;
        scheduleImpl = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        }
        return str;
    }

    static /* synthetic */ String access$1002(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        try {
            int i = MyBillsEntityDataFactory + 97;
            scheduleImpl = i % 128;
            boolean z = i % 2 != 0;
            dynamicUrlWrapper.myPaymentCardsUrl = str;
            if (!z) {
                int i2 = 56 / 0;
            }
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ String access$102(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        int i = scheduleImpl + 119;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            try {
                dynamicUrlWrapper.pocketUrl = str;
            } catch (Exception e) {
                throw e;
            }
        } else {
            dynamicUrlWrapper.pocketUrl = str;
            Object[] objArr = null;
            int length = objArr.length;
        }
        return str;
    }

    static /* synthetic */ String access$1102(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        try {
            int i = MyBillsEntityDataFactory + 45;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            dynamicUrlWrapper.changePinUrl = str;
            int i3 = scheduleImpl + 37;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ String access$1202(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        int i = MyBillsEntityDataFactory + 81;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        dynamicUrlWrapper.forgotPinUrl = str;
        int i3 = scheduleImpl + 125;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    static /* synthetic */ String access$1302(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        int i = MyBillsEntityDataFactory + 105;
        scheduleImpl = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? '0' : 'O') != 'O') {
            try {
                dynamicUrlWrapper.changeNameUrl = str;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } else {
            dynamicUrlWrapper.changeNameUrl = str;
        }
        int i2 = scheduleImpl + 33;
        MyBillsEntityDataFactory = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 22 : ';') != 22) {
            return str;
        }
        objArr.hashCode();
        return str;
    }

    static /* synthetic */ String access$1402(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        int i = scheduleImpl + 77;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            dynamicUrlWrapper.helpUrl = str;
        } else {
            dynamicUrlWrapper.helpUrl = str;
            Object obj = null;
            obj.hashCode();
        }
        return str;
    }

    static /* synthetic */ String access$1502(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        int i = MyBillsEntityDataFactory + 49;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        dynamicUrlWrapper.privacyPolicyUrl = str;
        int i3 = MyBillsEntityDataFactory + 123;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    static /* synthetic */ String access$1602(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        int i = MyBillsEntityDataFactory + 39;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        dynamicUrlWrapper.tutorialUrl = str;
        int i3 = scheduleImpl + 67;
        MyBillsEntityDataFactory = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return str;
        }
        Object obj = null;
        obj.hashCode();
        return str;
    }

    static /* synthetic */ String access$1702(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        try {
            int i = scheduleImpl + 31;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            dynamicUrlWrapper.voucherDetail = str;
            int i3 = scheduleImpl + 119;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ String access$202(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        int i = MyBillsEntityDataFactory + 111;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        dynamicUrlWrapper.transactionCompletedUrl = str;
        try {
            int i3 = scheduleImpl + 43;
            MyBillsEntityDataFactory = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 24 : '[') != 24) {
                return str;
            }
            Object obj = null;
            obj.hashCode();
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ String access$302(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        int i = MyBillsEntityDataFactory + 23;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        dynamicUrlWrapper.transactionProgressingUrl = str;
        int i3 = MyBillsEntityDataFactory + 51;
        scheduleImpl = i3 % 128;
        if ((i3 % 2 == 0 ? ']' : '\n') != '\n') {
            int i4 = 70 / 0;
            return str;
        }
        return str;
    }

    static /* synthetic */ String access$402(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        int i = MyBillsEntityDataFactory + 125;
        scheduleImpl = i % 128;
        if ((i % 2 == 0 ? 'W' : 'E') != 'W') {
            dynamicUrlWrapper.trxDetailUrl = str;
        } else {
            dynamicUrlWrapper.trxDetailUrl = str;
            Object[] objArr = null;
            int length = objArr.length;
        }
        try {
            int i2 = MyBillsEntityDataFactory + 67;
            scheduleImpl = i2 % 128;
            if ((i2 % 2 == 0 ? '2' : (char) 30) != 30) {
                int i3 = 65 / 0;
                return str;
            }
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ String access$502(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        int i = scheduleImpl + 47;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? 'J' : (char) 23) != 23) {
            try {
                dynamicUrlWrapper.kycLandingPageUrl = str;
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            dynamicUrlWrapper.kycLandingPageUrl = str;
        }
        return str;
    }

    static /* synthetic */ String access$602(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        try {
            int i = MyBillsEntityDataFactory + 99;
            scheduleImpl = i % 128;
            if (i % 2 == 0) {
                dynamicUrlWrapper.kycFromProfileUrl = str;
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                dynamicUrlWrapper.kycFromProfileUrl = str;
            }
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ String access$702(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        int i = MyBillsEntityDataFactory + 23;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        dynamicUrlWrapper.kycFromSendMoneyUrl = str;
        int i3 = MyBillsEntityDataFactory + 33;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    static /* synthetic */ String access$802(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        int i = scheduleImpl + 71;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            dynamicUrlWrapper.kycFromGoalSavingUrl = str;
            try {
                int i3 = MyBillsEntityDataFactory + 93;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ String access$902(DynamicUrlWrapper dynamicUrlWrapper, String str) {
        try {
            int i = MyBillsEntityDataFactory + 123;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            dynamicUrlWrapper.kycFromKybUrl = str;
            int i3 = MyBillsEntityDataFactory + 81;
            scheduleImpl = i3 % 128;
            if ((i3 % 2 == 0 ? 'Z' : '#') != 'Z') {
                return str;
            }
            int i4 = 92 / 0;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0063
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @javax.inject.Inject
    public DynamicUrlWrapper(id.dana.data.config.source.ConfigEntityDataFactory r2) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "https://m.dana.id/m/portal/topup?entryPoint={entryPoint}"
            r1.topupUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://m.dana.id/i/dana-promotion/pocket/list"
            r1.pocketUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://m.dana.id/i/transaction/list/completed"
            r1.transactionCompletedUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://m.dana.id/i/transaction/list/progressing"
            r1.transactionProgressingUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://m.dana.id/m/portal/transaction?bizOrderId=%s&isClosable=true"
            r1.transactionDetailUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://m.dana.id/i/transaction/detail"
            r1.trxDetailUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "/i/kyc/landingPage"
            r1.kycLandingPageUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "/i/kyc/landingPage?entryPoint=profile"
            r1.kycFromProfileUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "/i/kyc/landingPage?entryPoint=sendMoney"
            r1.kycFromSendMoneyUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "/i/kyc/landingPage?entryPoint=goalSaving"
            r1.kycFromGoalSavingUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "/i/kyc/landingPage?entryPoint=kyb"
            r1.kycFromKybUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://m.dana.id/m/portal/bankcardlist"
            r1.myPaymentCardsUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://m.dana.id/m/portal/security/resetPin?mode=modify"
            r1.changePinUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://m.dana.id/m/portal/security/resetPin?mode=reset"
            r1.forgotPinUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://m.dana.id/m/portal/settings/editNickname"
            r1.changeNameUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://m.dana.id/m/standalone/help"
            r1.helpUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://m.dana.id/m/standalone/policy"
            r1.privacyPolicyUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://m.dana.id/i/tutorial/index"
            r1.tutorialUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://m.dana.id/i/dana-promotion/pocket/detail?pocketId=%s&isClosable=true&voucherV2=true"
            r1.voucherDetail = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://a.m.dana.id/resource/global-transfer/json/countryList.json"
            r1.globalSendCountryListUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://a.m.dana.id/resource/global-transfer/json/province/%s.json"
            r1.globalSendProvinceAndCityListUrl = r0     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = "https://link.dana.id/read-emoney"
            r1.readEMoney = r0     // Catch: java.lang.Exception -> L61
            r1.configEntityDataFactory = r2     // Catch: java.lang.Exception -> L61
            r1.init()     // Catch: java.lang.Exception -> L61
            return
        L61:
            r2 = move-exception
            throw r2
        L63:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.dynamicurl.DynamicUrlWrapper.<init>(id.dana.data.config.source.ConfigEntityDataFactory):void");
    }

    private ConfigEntityData createSplitDataConfig() {
        int i = scheduleImpl + 117;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        ConfigEntityData createData2 = this.configEntityDataFactory.createData2("split");
        try {
            int i3 = MyBillsEntityDataFactory + 13;
            scheduleImpl = i3 % 128;
            if (!(i3 % 2 != 0)) {
                int i4 = 67 / 0;
                return createData2;
            }
            return createData2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void init() {
        int i = MyBillsEntityDataFactory + 117;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        initH5Entries();
        try {
            int i3 = scheduleImpl + 81;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void initH5Entries() {
        createSplitDataConfig().getH5Entries().subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).onErrorResumeNext(getH5EntriesFromAMCS()).subscribe(new Observer<JSONObject>() { // from class: id.dana.data.dynamicurl.DynamicUrlWrapper.1
            private static int $10 = 0;
            private static int $11 = 1;
            private static int[] BuiltInFictitiousFunctionClassFactory = {-2027421508, 834454985, -584958748, -2138246163, -108143867, -1609027241, 1899211328, 520508853, -1426580215, 1729875118, 1521390789, 1695456255, 1633772065, 1543133174, 309705136, 616969033, -64607603, -341432259};
            private static long KClassImpl$Data$declaredNonStaticMembers$2 = 2385405005485945436L;
            private static int MyBillsEntityDataFactory = 0;
            private static int getAuthRequestContext = 1;

            @Override // io.reactivex.Observer
            public void onComplete() {
                int i = MyBillsEntityDataFactory + 125;
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                int i = getAuthRequestContext + 121;
                MyBillsEntityDataFactory = i % 128;
                if (!(i % 2 == 0)) {
                    Object obj = null;
                    obj.hashCode();
                }
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                int i = getAuthRequestContext + 83;
                MyBillsEntityDataFactory = i % 128;
                if (!(i % 2 == 0)) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            }

            @Override // io.reactivex.Observer
            public /* synthetic */ void onNext(JSONObject jSONObject) {
                int i = getAuthRequestContext + 19;
                MyBillsEntityDataFactory = i % 128;
                if (!(i % 2 != 0)) {
                    MyBillsEntityDataFactory(jSONObject);
                    return;
                }
                MyBillsEntityDataFactory(jSONObject);
                int i2 = 18 / 0;
            }

            private void MyBillsEntityDataFactory(JSONObject jSONObject) {
                if (jSONObject == null) {
                    int i = MyBillsEntityDataFactory + 83;
                    getAuthRequestContext = i % 128;
                    int i2 = i % 2;
                    return;
                }
                HashMap hashMap = new HashMap();
                Iterator<Map.Entry<String, Object>> it = jSONObject.entrySet().iterator();
                while (true) {
                    if ((it.hasNext() ? 'Y' : (char) 24) != 'Y') {
                        Object[] objArr = new Object[1];
                        a((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 5, new int[]{-1354846425, -1978324995, 680834315, 2101361220}, objArr);
                        String str = (String) hashMap.get(((String) objArr[0]).intern());
                        Object[] objArr2 = new Object[1];
                        a(6 - Color.red(0), new int[]{-2140433052, -2088755913, -656176012, 1094789067}, objArr2);
                        String str2 = (String) hashMap.get(((String) objArr2[0]).intern());
                        Object[] objArr3 = new Object[1];
                        b(26641 - View.resolveSizeAndState(0, 0, 0), new char[]{25451, 2940, 45916, 23362, 49960, 27435, 4890, 47900, 9214, 52201, 29659, 7163, 33712, 11181, 54172, 31632, 57955, 35419, 12889, 55865, 16943}, objArr3);
                        String str3 = (String) hashMap.get(((String) objArr3[0]).intern());
                        Object[] objArr4 = new Object[1];
                        b(TextUtils.lastIndexOf("", '0', 0, 0) + 8630, new char[]{25451, 17112, Typography.mdash, 1646, 58808, 52215, 43330, 34968, 28382, 19501, 12899, 4487, 63251, 54620, 46230, 39651, 30781, 24191, 15830, 58115, 49490, 41128, 34550}, objArr4);
                        String str4 = (String) hashMap.get(((String) objArr4[0]).intern());
                        Object[] objArr5 = new Object[1];
                        a(19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new int[]{713094570, -2135401866, -400897756, -1291691177, -1734243681, -1697542096, 1345678284, 1296834258, 2092343690, 2117145162}, objArr5);
                        String str5 = (String) hashMap.get(((String) objArr5[0]).intern());
                        Object[] objArr6 = new Object[1];
                        b((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 10723, new char[]{25460, 19077, 12474}, objArr6);
                        String str6 = (String) hashMap.get(((String) objArr6[0]).intern());
                        Object[] objArr7 = new Object[1];
                        a(16 - TextUtils.indexOf("", "", 0, 0), new int[]{-595324517, -1117919848, -1710189140, 1533488934, 70699728, -477547335, 2068742757, -2117834447}, objArr7);
                        String str7 = (String) hashMap.get(((String) objArr7[0]).intern());
                        Object[] objArr8 = new Object[1];
                        b((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 52127, new char[]{25453, 43237, 62546, 423, 19735, 39259, 42709, 61999, 16265}, objArr8);
                        String str8 = (String) hashMap.get(((String) objArr8[0]).intern());
                        Object[] objArr9 = new Object[1];
                        b(15971 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{25468, 23828, 8120, 55384, 39668, 21653, 5394, 55236, 36966, 21001, 3236}, objArr9);
                        String str9 = (String) hashMap.get(((String) objArr9[0]).intern());
                        Object[] objArr10 = new Object[1];
                        b(KeyEvent.getDeadChar(0, 0) + 57139, new char[]{25463, 48201, 56597, 65270}, objArr10);
                        String str10 = (String) hashMap.get(((String) objArr10[0]).intern());
                        Object[] objArr11 = new Object[1];
                        b(TextUtils.lastIndexOf("", '0', 0, 0) + 17138, new char[]{25455, 8604, 59028, 43962, 26810, 11721, 62144, 47063, 29927, 14601, 65049, 33581, 16432, 1371}, objArr11);
                        String str11 = (String) hashMap.get(((String) objArr11[0]).intern());
                        Object[] objArr12 = new Object[1];
                        a(TextUtils.getOffsetAfter("", 0) + 8, new int[]{207273451, -395792330, -1285785979, 1709363870}, objArr12);
                        String str12 = (String) hashMap.get(((String) objArr12[0]).intern());
                        Object[] objArr13 = new Object[1];
                        a(Color.red(0) + 13, new int[]{-2140433052, -2088755913, -525023666, 1693712010, 104137783, -776564414, 1297252331, 606899783}, objArr13);
                        String str13 = (String) hashMap.get(((String) objArr13[0]).intern());
                        DynamicUrlWrapper dynamicUrlWrapper = DynamicUrlWrapper.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append("https://m.dana.id");
                        sb.append(UrlUtil.getDynamicUrl(str, null, DanaUrl.TOPUP));
                        DynamicUrlWrapper.access$002(dynamicUrlWrapper, sb.toString());
                        DynamicUrlWrapper dynamicUrlWrapper2 = DynamicUrlWrapper.this;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("https://m.dana.id");
                        sb2.append(UrlUtil.getDynamicUrl(str2, null, DanaUrl.POCKET));
                        DynamicUrlWrapper.access$102(dynamicUrlWrapper2, sb2.toString());
                        DynamicUrlWrapper dynamicUrlWrapper3 = DynamicUrlWrapper.this;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("https://m.dana.id");
                        sb3.append(UrlUtil.getDynamicUrl(str3, null, DanaUrl.TRANSACTION_COMPLETED));
                        DynamicUrlWrapper.access$202(dynamicUrlWrapper3, sb3.toString());
                        DynamicUrlWrapper dynamicUrlWrapper4 = DynamicUrlWrapper.this;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("https://m.dana.id");
                        sb4.append(UrlUtil.getDynamicUrl(str4, null, DanaUrl.TRANSACTION_PROGRESSING));
                        DynamicUrlWrapper.access$302(dynamicUrlWrapper4, sb4.toString());
                        DynamicUrlWrapper dynamicUrlWrapper5 = DynamicUrlWrapper.this;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("https://m.dana.id");
                        sb5.append(UrlUtil.getDynamicUrl(str5, null, DanaUrl.TRX_DETAIL));
                        DynamicUrlWrapper.access$402(dynamicUrlWrapper5, sb5.toString());
                        DynamicUrlWrapper.access$502(DynamicUrlWrapper.this, UrlUtil.getDynamicUrl(str6, null, DanaUrl.KYC_LANDING_PAGE));
                        DynamicUrlWrapper.access$602(DynamicUrlWrapper.this, UrlUtil.getDynamicUrl(str6, DanaUrl.ENTRY_POINT_PROFILE, DanaUrl.KYC_FROM_PROFILE));
                        DynamicUrlWrapper.access$702(DynamicUrlWrapper.this, UrlUtil.getDynamicUrl(str6, DanaUrl.ENTRY_POINT_SENDMONEY, DanaUrl.KYC_FROM_SENDMONEY));
                        DynamicUrlWrapper.access$802(DynamicUrlWrapper.this, UrlUtil.getDynamicUrl(str6, DanaUrl.ENTRY_POINT_GOAL_SAVING, DanaUrl.KYC_FROM_GOAL_SAVING));
                        DynamicUrlWrapper.access$902(DynamicUrlWrapper.this, UrlUtil.getDynamicUrl(str6, DanaUrl.ENTRY_POINT_KYB, DanaUrl.KYC_FROM_KYB));
                        DynamicUrlWrapper dynamicUrlWrapper6 = DynamicUrlWrapper.this;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("https://m.dana.id");
                        sb6.append(UrlUtil.getDynamicUrl(str7, null, DanaUrl.MY_CARD));
                        DynamicUrlWrapper.access$1002(dynamicUrlWrapper6, sb6.toString());
                        DynamicUrlWrapper dynamicUrlWrapper7 = DynamicUrlWrapper.this;
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("https://m.dana.id");
                        sb7.append(UrlUtil.getDynamicUrl(str8, DanaUrl.PIN_MODE_MODIFY, DanaUrl.CHANGE_PIN));
                        DynamicUrlWrapper.access$1102(dynamicUrlWrapper7, sb7.toString());
                        DynamicUrlWrapper dynamicUrlWrapper8 = DynamicUrlWrapper.this;
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("https://m.dana.id");
                        sb8.append(UrlUtil.getDynamicUrl(str8, DanaUrl.PIN_MODE_RESET, DanaUrl.FORGOT_PIN));
                        DynamicUrlWrapper.access$1202(dynamicUrlWrapper8, sb8.toString());
                        DynamicUrlWrapper dynamicUrlWrapper9 = DynamicUrlWrapper.this;
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append("https://m.dana.id");
                        sb9.append(UrlUtil.getDynamicUrl(str9, null, DanaUrl.CHANGE_NAME));
                        DynamicUrlWrapper.access$1302(dynamicUrlWrapper9, sb9.toString());
                        DynamicUrlWrapper dynamicUrlWrapper10 = DynamicUrlWrapper.this;
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append("https://m.dana.id");
                        sb10.append(UrlUtil.getDynamicUrl(str10, null, DanaUrl.HELP));
                        DynamicUrlWrapper.access$1402(dynamicUrlWrapper10, sb10.toString());
                        DynamicUrlWrapper dynamicUrlWrapper11 = DynamicUrlWrapper.this;
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append("https://m.dana.id");
                        sb11.append(UrlUtil.getDynamicUrl(str11, null, DanaUrl.PRIVACY_POLICY));
                        DynamicUrlWrapper.access$1502(dynamicUrlWrapper11, sb11.toString());
                        DynamicUrlWrapper dynamicUrlWrapper12 = DynamicUrlWrapper.this;
                        StringBuilder sb12 = new StringBuilder();
                        sb12.append("https://m.dana.id");
                        sb12.append(UrlUtil.getDynamicUrl(str12, null, DanaUrl.TUTORIAL));
                        DynamicUrlWrapper.access$1602(dynamicUrlWrapper12, sb12.toString());
                        DynamicUrlWrapper dynamicUrlWrapper13 = DynamicUrlWrapper.this;
                        StringBuilder sb13 = new StringBuilder();
                        sb13.append("https://m.dana.id");
                        sb13.append(UrlUtil.getDynamicUrl(str13, null, DanaUrl.VOUCHER_DETAIL));
                        DynamicUrlWrapper.access$1702(dynamicUrlWrapper13, sb13.toString());
                        return;
                    }
                    int i3 = getAuthRequestContext + 115;
                    MyBillsEntityDataFactory = i3 % 128;
                    if (i3 % 2 == 0) {
                        Map.Entry<String, Object> next = it.next();
                        hashMap.put(next.getKey(), (String) next.getValue());
                    } else {
                        Map.Entry<String, Object> next2 = it.next();
                        hashMap.put(next2.getKey(), (String) next2.getValue());
                        Object obj = null;
                        obj.hashCode();
                    }
                }
            }

            private static void a(int i, int[] iArr, Object[] objArr) {
                int i2;
                int i3;
                VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
                char[] cArr = new char[4];
                int i4 = 2;
                char[] cArr2 = new char[iArr.length * 2];
                int[] iArr2 = BuiltInFictitiousFunctionClassFactory;
                if (iArr2 != null) {
                    int length = iArr2.length;
                    int[] iArr3 = new int[length];
                    int i5 = $10 + 51;
                    $11 = i5 % 128;
                    int i6 = i5 % 2;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= length) {
                            break;
                        }
                        int i8 = $11 + 77;
                        $10 = i8 % 128;
                        int i9 = i8 % 2;
                        iArr3[i7] = (int) (iArr2[i7] ^ (-3152031022165484798L));
                        i7++;
                    }
                    iArr2 = iArr3;
                }
                int length2 = iArr2.length;
                int[] iArr4 = new int[length2];
                int[] iArr5 = BuiltInFictitiousFunctionClassFactory;
                if (iArr5 == null) {
                    i2 = length2;
                } else {
                    int i10 = $10 + 113;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                    int length3 = iArr5.length;
                    int[] iArr6 = new int[length3];
                    int i12 = 0;
                    while (i12 < length3) {
                        int i13 = $10 + 101;
                        $11 = i13 % 128;
                        if (i13 % i4 == 0) {
                            i3 = length2;
                            iArr6[i12] = (int) (iArr5[i12] / (-3152031022165484798L));
                            i12 <<= 0;
                        } else {
                            i3 = length2;
                            iArr6[i12] = (int) (iArr5[i12] ^ (-3152031022165484798L));
                            i12++;
                        }
                        length2 = i3;
                        i4 = 2;
                    }
                    iArr5 = iArr6;
                    i2 = length2;
                }
                System.arraycopy(iArr5, 0, iArr4, 0, i2);
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
                    cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                    cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                    cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                    cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                    VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                    for (int i14 = 0; i14 < 16; i14++) {
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i14];
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        int i15 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i15;
                    }
                    try {
                        int i16 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        try {
                            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i16;
                            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                            int i17 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                            int i18 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
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
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
                objArr[0] = new String(cArr2, 0, i);
            }

            private static void b(int i, char[] cArr, Object[] objArr) {
                getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
                getonboardingscenario.MyBillsEntityDataFactory = i;
                int length = cArr.length;
                long[] jArr = new long[length];
                getonboardingscenario.getAuthRequestContext = 0;
                int i2 = $10 + 59;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                while (true) {
                    if ((getonboardingscenario.getAuthRequestContext < cArr.length ? (char) 20 : JSONLexer.EOI) == 26) {
                        break;
                    }
                    int i4 = $11 + 3;
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                    jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4796183387843776835L);
                    getonboardingscenario.getAuthRequestContext++;
                }
                char[] cArr2 = new char[length];
                getonboardingscenario.getAuthRequestContext = 0;
                while (true) {
                    if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                        objArr[0] = new String(cArr2);
                        return;
                    } else {
                        cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                        getonboardingscenario.getAuthRequestContext++;
                    }
                }
            }
        });
        int i = scheduleImpl + 9;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
    }

    Observable<JSONObject> getH5EntriesFromAMCS() {
        try {
            Observable<JSONObject> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.dynamicurl.DynamicUrlWrapper$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return DynamicUrlWrapper.lambda$getH5EntriesFromAMCS$0();
                }
            });
            int i = MyBillsEntityDataFactory + 35;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            return fromCallable;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if ((r0 == null) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        r4 = id.dana.data.dynamicurl.DynamicUrlWrapper.scheduleImpl + 35;
        id.dana.data.dynamicurl.DynamicUrlWrapper.MyBillsEntityDataFactory = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0062, code lost:
    
        if ((r4 % 2) == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        r4 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:
    
        r4 = '3';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
    
        if (r4 == 2) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
    
        r4 = 81 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        r4 = id.dana.data.dynamicurl.DynamicUrlWrapper.MyBillsEntityDataFactory + 9;
        id.dana.data.dynamicurl.DynamicUrlWrapper.scheduleImpl = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
    
        if ((r4 % 2) != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
    
        if (r2 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007d, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007e, code lost:
    
        r1 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008b, code lost:
    
        throw new id.dana.utils.exception.CallableReturnNullError("DynamicUrlWrapper#getH5EntriesFromAMCS");
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
    
        if (r0 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ com.alibaba.fastjson.JSONObject lambda$getH5EntriesFromAMCS$0() throws java.lang.Exception {
        /*
            int r0 = id.dana.data.dynamicurl.DynamicUrlWrapper.scheduleImpl
            int r0 = r0 + 55
            int r1 = r0 % 128
            id.dana.data.dynamicurl.DynamicUrlWrapper.MyBillsEntityDataFactory = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r4 = 18
            java.lang.String r5 = ""
            if (r0 == 0) goto L36
            int r0 = android.os.Process.getGidForName(r5)
            int r0 = 17 - r0
            char[] r4 = new char[r4]
            r4 = {x008c: FILL_ARRAY_DATA , data: [26554, -19174, -11890, 17360, 28247, -19967, 26402, 11846, 1961, -872, -21003, 6185, -29472, 22496, 32707, -14995, -530, -23913} // fill-array
            java.lang.Object[] r5 = new java.lang.Object[r2]
            a(r0, r4, r5)
            r0 = r5[r3]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            com.alibaba.fastjson.JSONObject r0 = id.dana.data.util.FeatureSwitch.getFeatureSwitchJSONObject(r0)
            if (r0 == 0) goto L84
            goto L59
        L36:
            r0 = 5
            int r5 = android.os.Process.getGidForName(r5)
            int r0 = r0 / r5
            char[] r4 = new char[r4]
            r4 = {x00a2: FILL_ARRAY_DATA , data: [26554, -19174, -11890, 17360, 28247, -19967, 26402, 11846, 1961, -872, -21003, 6185, -29472, 22496, 32707, -14995, -530, -23913} // fill-array
            java.lang.Object[] r5 = new java.lang.Object[r2]
            a(r0, r4, r5)
            r0 = r5[r3]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            com.alibaba.fastjson.JSONObject r0 = id.dana.data.util.FeatureSwitch.getFeatureSwitchJSONObject(r0)
            if (r0 == 0) goto L56
            r4 = 0
            goto L57
        L56:
            r4 = 1
        L57:
            if (r4 != 0) goto L84
        L59:
            int r4 = id.dana.data.dynamicurl.DynamicUrlWrapper.scheduleImpl
            int r4 = r4 + 35
            int r5 = r4 % 128
            id.dana.data.dynamicurl.DynamicUrlWrapper.MyBillsEntityDataFactory = r5
            int r4 = r4 % r1
            if (r4 == 0) goto L66
            r4 = 2
            goto L68
        L66:
            r4 = 51
        L68:
            if (r4 == r1) goto L6b
            goto L6e
        L6b:
            r4 = 81
            int r4 = r4 / r3
        L6e:
            int r4 = id.dana.data.dynamicurl.DynamicUrlWrapper.MyBillsEntityDataFactory
            int r4 = r4 + 9
            int r5 = r4 % 128
            id.dana.data.dynamicurl.DynamicUrlWrapper.scheduleImpl = r5
            int r4 = r4 % r1
            if (r4 != 0) goto L7a
            r2 = 0
        L7a:
            if (r2 == 0) goto L7d
            return r0
        L7d:
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L80
            return r0
        L80:
            r0 = move-exception
            throw r0
        L82:
            r0 = move-exception
            throw r0
        L84:
            id.dana.utils.exception.CallableReturnNullError r0 = new id.dana.utils.exception.CallableReturnNullError
            java.lang.String r1 = "DynamicUrlWrapper#getH5EntriesFromAMCS"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.dynamicurl.DynamicUrlWrapper.lambda$getH5EntriesFromAMCS$0():com.alibaba.fastjson.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if ((!isEntryPointExist()) != true) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        if ((!isEntryPointExist() ? '8' : 'D') != 'D') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        r0 = id.dana.data.dynamicurl.DynamicUrlWrapper.MyBillsEntityDataFactory + 11;
        id.dana.data.dynamicurl.DynamicUrlWrapper.scheduleImpl = r0 % 128;
        r0 = r0 % 2;
        addEntryPoint();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        r5 = r4.topupUrl.replace(getEntryPointTag(), r5);
        r0 = id.dana.data.dynamicurl.DynamicUrlWrapper.scheduleImpl + 7;
        id.dana.data.dynamicurl.DynamicUrlWrapper.MyBillsEntityDataFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if ((r0 % 2) == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
    
        r0 = 45 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getTopupUrl(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = id.dana.data.dynamicurl.DynamicUrlWrapper.MyBillsEntityDataFactory
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.data.dynamicurl.DynamicUrlWrapper.scheduleImpl = r2
            int r0 = r0 % 2
            r2 = 70
            if (r0 != 0) goto L11
            r0 = 70
            goto L13
        L11:
            r0 = 8
        L13:
            r3 = 0
            if (r0 == r2) goto L22
            boolean r0 = r4.isEntryPointExist()
            if (r0 != 0) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            if (r0 == r1) goto L34
            goto L41
        L22:
            boolean r0 = r4.isEntryPointExist()
            r1 = 23
            int r1 = r1 / r3
            r1 = 68
            if (r0 != 0) goto L30
            r0 = 56
            goto L32
        L30:
            r0 = 68
        L32:
            if (r0 == r1) goto L41
        L34:
            int r0 = id.dana.data.dynamicurl.DynamicUrlWrapper.MyBillsEntityDataFactory
            int r0 = r0 + 11
            int r1 = r0 % 128
            id.dana.data.dynamicurl.DynamicUrlWrapper.scheduleImpl = r1
            int r0 = r0 % 2
            r4.addEntryPoint()
        L41:
            java.lang.String r0 = r4.topupUrl
            java.lang.String r1 = r4.getEntryPointTag()
            java.lang.String r5 = r0.replace(r1, r5)
            int r0 = id.dana.data.dynamicurl.DynamicUrlWrapper.scheduleImpl
            int r0 = r0 + 7
            int r1 = r0 % 128
            id.dana.data.dynamicurl.DynamicUrlWrapper.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L5d
            r0 = 45
            int r0 = r0 / r3
            return r5
        L5b:
            r5 = move-exception
            throw r5
        L5d:
            return r5
        L5e:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.dynamicurl.DynamicUrlWrapper.getTopupUrl(java.lang.String):java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:14:0x0054
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void addEntryPoint() {
        /*
            r4 = this;
            int r0 = id.dana.data.dynamicurl.DynamicUrlWrapper.scheduleImpl
            int r0 = r0 + 47
            int r1 = r0 % 128
            id.dana.data.dynamicurl.DynamicUrlWrapper.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            java.lang.String r0 = r4.topupUrl
            java.lang.String r1 = "?"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L16
            r0 = 0
            goto L17
        L16:
            r0 = 1
        L17:
            if (r0 == 0) goto L1a
            goto L26
        L1a:
            java.lang.String r1 = "&"
            int r0 = id.dana.data.dynamicurl.DynamicUrlWrapper.scheduleImpl     // Catch: java.lang.Exception -> L52
            int r0 = r0 + 99
            int r2 = r0 % 128
            id.dana.data.dynamicurl.DynamicUrlWrapper.MyBillsEntityDataFactory = r2     // Catch: java.lang.Exception -> L52
            int r0 = r0 % 2
        L26:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "entryPoint="
            r0.append(r2)
            java.lang.String r2 = r4.getEntryPointTag()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r4.topupUrl
            r2.append(r3)
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r4.topupUrl = r0
            return
        L52:
            r0 = move-exception
            throw r0
        L54:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.dynamicurl.DynamicUrlWrapper.addEntryPoint():void");
    }

    private boolean isEntryPointExist() {
        try {
            int i = scheduleImpl + 15;
            MyBillsEntityDataFactory = i % 128;
            if ((i % 2 != 0 ? (char) 19 : (char) 28) != 28) {
                try {
                    boolean contains = this.topupUrl.contains(getEntryPointTag());
                    Object[] objArr = null;
                    int length = objArr.length;
                    return contains;
                } catch (Exception e) {
                    throw e;
                }
            }
            return this.topupUrl.contains(getEntryPointTag());
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getPocketUrl() {
        int i = scheduleImpl + 3;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            String str = this.pocketUrl;
            int i3 = MyBillsEntityDataFactory + 43;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getTransactionCompletedUrl() {
        int i = scheduleImpl + 31;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            String str = this.transactionCompletedUrl;
            int i3 = scheduleImpl + 115;
            MyBillsEntityDataFactory = i3 % 128;
            if (i3 % 2 != 0) {
                Object obj = null;
                obj.hashCode();
                return str;
            }
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getTransactionProgressingUrl() {
        try {
            int i = MyBillsEntityDataFactory + 55;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            String str = this.transactionProgressingUrl;
            int i3 = scheduleImpl + 53;
            MyBillsEntityDataFactory = i3 % 128;
            if ((i3 % 2 != 0 ? '#' : '[') != '#') {
                return str;
            }
            Object obj = null;
            obj.hashCode();
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getTransactionDetailUrl() {
        int i = scheduleImpl + 97;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            String str = this.transactionDetailUrl;
            int i3 = MyBillsEntityDataFactory + 25;
            scheduleImpl = i3 % 128;
            if ((i3 % 2 == 0 ? '5' : (char) 25) != '5') {
                return str;
            }
            int i4 = 43 / 0;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getTrxDetailUrl() {
        try {
            int i = scheduleImpl + 51;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            String str = this.trxDetailUrl;
            int i3 = MyBillsEntityDataFactory + 51;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getKycLandingPageUrl() {
        int i = MyBillsEntityDataFactory + 47;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        String str = this.kycLandingPageUrl;
        int i3 = MyBillsEntityDataFactory + 111;
        scheduleImpl = i3 % 128;
        if ((i3 % 2 == 0 ? 'J' : (char) 16) != 'J') {
            return str;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return str;
    }

    public String getKycFromProfileUrl() {
        int i = scheduleImpl + 49;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 == 0) {
            return this.kycFromProfileUrl;
        }
        String str = this.kycFromProfileUrl;
        Object obj = null;
        obj.hashCode();
        return str;
    }

    public String getKycFromSendMoneyUrl() {
        int i = scheduleImpl + 87;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 != 0) {
            String str = this.kycFromSendMoneyUrl;
            Object obj = null;
            obj.hashCode();
            return str;
        }
        return this.kycFromSendMoneyUrl;
    }

    public String getKycFromGoalSavingUrl() {
        int i = MyBillsEntityDataFactory + 51;
        scheduleImpl = i % 128;
        if (i % 2 != 0) {
            return this.kycFromGoalSavingUrl;
        }
        int i2 = 6 / 0;
        return this.kycFromGoalSavingUrl;
    }

    public String getKycFromKybUrl() {
        try {
            int i = scheduleImpl + 15;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            String str = this.kycFromKybUrl;
            int i3 = scheduleImpl + 35;
            MyBillsEntityDataFactory = i3 % 128;
            if ((i3 % 2 != 0 ? '`' : '\r') != '`') {
                return str;
            }
            Object obj = null;
            obj.hashCode();
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getMyPaymentCardsUrl() {
        int i = scheduleImpl + 41;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 == 0)) {
            String str = this.myPaymentCardsUrl;
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        }
        return this.myPaymentCardsUrl;
    }

    public String getChangePinUrl() {
        int i = scheduleImpl + 65;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        String str = this.changePinUrl;
        int i3 = scheduleImpl + 37;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public String getForgotPinUrl() {
        int i = scheduleImpl + 99;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            return this.forgotPinUrl;
        }
        int i2 = 9 / 0;
        return this.forgotPinUrl;
    }

    public String getChangeNameUrl() {
        String str;
        int i = MyBillsEntityDataFactory + 109;
        scheduleImpl = i % 128;
        if (!(i % 2 == 0)) {
            str = this.changeNameUrl;
        } else {
            str = this.changeNameUrl;
            int i2 = 46 / 0;
        }
        int i3 = MyBillsEntityDataFactory + 95;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public String getHelpUrl() {
        int i = scheduleImpl + 49;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? 'P' : (char) 17) != 17) {
            int i2 = 4 / 0;
            return this.helpUrl;
        }
        return this.helpUrl;
    }

    public String getPrivacyPolicyUrl() {
        int i = MyBillsEntityDataFactory + 43;
        scheduleImpl = i % 128;
        if (i % 2 == 0) {
            try {
                String str = this.privacyPolicyUrl;
                Object obj = null;
                obj.hashCode();
                return str;
            } catch (Exception e) {
                throw e;
            }
        }
        return this.privacyPolicyUrl;
    }

    public String getTutorialUrl() {
        int i = MyBillsEntityDataFactory + 77;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        String str = this.tutorialUrl;
        int i3 = scheduleImpl + 41;
        MyBillsEntityDataFactory = i3 % 128;
        if (i3 % 2 == 0) {
            return str;
        }
        int i4 = 36 / 0;
        return str;
    }

    public String getReadEMoney() {
        int i = scheduleImpl + 111;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        String str = this.readEMoney;
        int i3 = scheduleImpl + 61;
        MyBillsEntityDataFactory = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return str;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return str;
    }

    public String getVoucherDetail() {
        try {
            int i = scheduleImpl + 3;
            MyBillsEntityDataFactory = i % 128;
            if ((i % 2 != 0 ? 'B' : '#') != '#') {
                String str = this.voucherDetail;
                Object[] objArr = null;
                int length = objArr.length;
                return str;
            }
            return this.voucherDetail;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getGlobalSendCountryListUrl() {
        String str;
        int i = scheduleImpl + 107;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? 'b' : (char) 2) != 'b') {
            str = this.globalSendCountryListUrl;
        } else {
            try {
                str = this.globalSendCountryListUrl;
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = MyBillsEntityDataFactory + 75;
        scheduleImpl = i2 % 128;
        int i3 = i2 % 2;
        return str;
    }

    public String getGlobalSendProvinceAndCityListUrl(String str) {
        int i = scheduleImpl + 9;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        String format = String.format(this.globalSendProvinceAndCityListUrl, str);
        int i3 = MyBillsEntityDataFactory + 99;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        return format;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        int i2 = $10 + 7;
        $11 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? '%' : ':') == ':') {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
            int i4 = $10 + 15;
            $11 = i4 % 128;
            int i5 = 58224;
            if (i4 % 2 == 0) {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory % 0];
            } else {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            }
            int i6 = 0;
            while (true) {
                if ((i6 < 16 ? JSONLexer.EOI : (char) 18) != 26) {
                    break;
                }
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i5) ^ ((cArr3[0] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i5) ^ ((cArr3[1] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))));
                i5 -= 40503;
                i6++;
                int i7 = $11 + 51;
                $10 = i7 % 128;
                int i8 = i7 % 2;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
    }
}
