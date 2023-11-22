package id.dana.data.services.repository.source.local;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.alibaba.fastjson.parser.JSONLexer;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.gson.Gson;
import id.dana.data.services.repository.source.model.CategoryHighlightedFeature;
import id.dana.data.services.repository.source.model.ServiceHighlighted;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Singleton
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0019\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b(\u0010)J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001b\u001a\u00020\u00022\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0010¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%"}, d2 = {"Lid/dana/data/services/repository/source/local/FavoriteServicesPreference;", "", "", "clearAll", "()Z", "", "phoneNumber", "Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;", "getCategoryHighlightedFeature", "(Ljava/lang/String;)Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;", "", "getFavoriteServices", "(Ljava/lang/String;)Ljava/util/List;", "Lid/dana/domain/services/model/ThirdPartyCategoryService;", "getFavoriteServicesCache", "(Ljava/lang/String;)Lid/dana/domain/services/model/ThirdPartyCategoryService;", "Lid/dana/data/services/repository/source/model/ServiceHighlighted;", "getServiceHighlighted", "(Ljava/lang/String;)Lid/dana/data/services/repository/source/model/ServiceHighlighted;", "categoryHighlightFeature", "", "saveCategoryHighlightedFeature", "(Ljava/lang/String;Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;)V", "favoriteServiceCache", "saveFavoriteServiceCache", "(Lid/dana/domain/services/model/ThirdPartyCategoryService;)Z", "services", "saveFavoriteServices", "(Ljava/util/List;Ljava/lang/String;)Z", "data", "saveServiceHighlighted", "(Ljava/lang/String;Lid/dana/data/services/repository/source/model/ServiceHighlighted;)V", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;Lcom/google/gson/Gson;)V", "Companion", "Key"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FavoriteServicesPreference {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static final String CATEGORY_HIGHLIGHTED_FEATURE = "category_highlighted_feature";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static final String SERVICE_HIGHLIGHTED = "service_highlighted";
    private static final String USER_EDUCATION_PREFERENCE = "UserEducationPreferenceproduction";
    private static int[] getAuthRequestContext;
    private final Gson gson;
    private final PreferenceFacade preferenceFacade;

    static {
        MyBillsEntityDataFactory();
        INSTANCE = new Companion(null);
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 31;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    static void MyBillsEntityDataFactory() {
        getAuthRequestContext = new int[]{796875965, 602144258, -1995210392, -1981407677, -1636183299, -1074130776, 341236486, -1726769697, -1950245219, -1029555278, -1385099116, -873772524, -1964449530, -735678453, -1778501093, 223710733, -1515924473, -411375790};
    }

    @Inject
    public FavoriteServicesPreference(Context context, Gson gson) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(gson, "");
        this.gson = gson;
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("UserEducationPreferenceproduction").setUseDrutherPreference(true)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.preferenceFacade = new SimpleSecureKeyPreference(createData2);
    }

    public final List<String> getFavoriteServices(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append("favorite_services");
        sb.append(phoneNumber);
        List<String> list = (List) preferenceFacade.getObject(sb.toString(), List.class);
        if (list != null) {
            return list;
        }
        int i = BuiltInFictitiousFunctionClassFactory + 83;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        List<String> emptyList = CollectionsKt.emptyList();
        int i3 = BuiltInFictitiousFunctionClassFactory + 123;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return emptyList;
    }

    public final boolean saveFavoriteServices(List<String> services, String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append("favorite_services");
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), (String) services);
        int i = BuiltInFictitiousFunctionClassFactory + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
            int i2 = 7 / 0;
            return true;
        }
        return true;
    }

    public final boolean clearAll() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? Typography.less : (char) 20) != '<') {
            this.preferenceFacade.clearAllData();
            return true;
        }
        this.preferenceFacade.clearAllData();
        return false;
    }

    public final boolean saveFavoriteServiceCache(ThirdPartyCategoryService favoriteServiceCache) {
        boolean z;
        int i = BuiltInFictitiousFunctionClassFactory + 15;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? (char) 29 : JSONLexer.EOI) != 29) {
            Intrinsics.checkNotNullParameter(favoriteServiceCache, "");
            this.preferenceFacade.saveData("favorite_services_cache", (String) favoriteServiceCache);
            z = true;
        } else {
            Intrinsics.checkNotNullParameter(favoriteServiceCache, "");
            this.preferenceFacade.saveData("favorite_services_cache", (String) favoriteServiceCache);
            z = false;
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 31;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if ((i2 % 2 == 0 ? '0' : '\t') != '\t') {
            Object[] objArr = null;
            int length = objArr.length;
            return z;
        }
        return z;
    }

    public final ThirdPartyCategoryService getFavoriteServicesCache(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append("favorite_services_cache");
        sb.append(phoneNumber);
        ThirdPartyCategoryService thirdPartyCategoryService = (ThirdPartyCategoryService) preferenceFacade.getObject(sb.toString(), ThirdPartyCategoryService.class);
        int i = BuiltInFictitiousFunctionClassFactory + 107;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
            int i2 = 61 / 0;
            return thirdPartyCategoryService;
        }
        return thirdPartyCategoryService;
    }

    public final void saveCategoryHighlightedFeature(String phoneNumber, CategoryHighlightedFeature categoryHighlightFeature) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(categoryHighlightFeature, "");
        String json = this.gson.toJson(categoryHighlightFeature, CategoryHighlightedFeature.class);
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        a(28 - (ViewConfiguration.getWindowTouchSlop() >> 8), new int[]{-1541134256, -1178657239, 1764299591, 108711040, -343222165, -226982765, -671246146, 96100243, -571975472, 930781, -1193852867, -1921075278, 1708479734, -327044781}, objArr);
        sb.append(((String) objArr[0]).intern());
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), json);
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
    }

    public final CategoryHighlightedFeature getCategoryHighlightedFeature(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        a(28 - TextUtils.getOffsetBefore("", 0), new int[]{-1541134256, -1178657239, 1764299591, 108711040, -343222165, -226982765, -671246146, 96100243, -571975472, 930781, -1193852867, -1921075278, 1708479734, -327044781}, objArr);
        sb.append(((String) objArr[0]).intern());
        sb.append(phoneNumber);
        CategoryHighlightedFeature categoryHighlightedFeature = (CategoryHighlightedFeature) this.gson.fromJson(preferenceFacade.getString(sb.toString()), CategoryHighlightedFeature.class);
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 39;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        return categoryHighlightedFeature;
    }

    public final ServiceHighlighted getServiceHighlighted(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(SERVICE_HIGHLIGHTED);
        sb.append(phoneNumber);
        ServiceHighlighted serviceHighlighted = (ServiceHighlighted) this.gson.fromJson(preferenceFacade.getString(sb.toString()), ServiceHighlighted.class);
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 91;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? '!' : 'K') != 'K') {
            int i2 = 1 / 0;
            return serviceHighlighted;
        }
        return serviceHighlighted;
    }

    public final void saveServiceHighlighted(String phoneNumber, ServiceHighlighted data) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(data, "");
        String json = this.gson.toJson(data, ServiceHighlighted.class);
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(SERVICE_HIGHLIGHTED);
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), json);
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 109;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? 'N' : '9') != '9') {
                int i2 = 37 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/services/repository/source/local/FavoriteServicesPreference$Key;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    static final class Key {
        public static final Key INSTANCE = new Key();

        private Key() {
        }
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = getAuthRequestContext;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i2 = $10 + 5;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            int i4 = 0;
            while (i4 < length) {
                iArr3[i4] = (int) (iArr2[i4] ^ (-3152031022165484798L));
                i4++;
                int i5 = $11 + 123;
                $10 = i5 % 128;
                int i6 = i5 % 2;
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = getAuthRequestContext;
        if (!(iArr5 == null)) {
            int i7 = $11 + 77;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i9 = 0;
            while (i9 < length3) {
                iArr6[i9] = (int) (iArr5[i9] ^ (-3152031022165484798L));
                i9++;
                length3 = length3;
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length ? '%' : '\t') != '%') {
                break;
            }
            int i10 = $10 + 105;
            $11 = i10 % 128;
            int i11 = i10 % 2;
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i12 = 0; i12 < 16; i12++) {
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i12];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i13 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i13;
            }
            int i14 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i14;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i15 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i16 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
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
        }
        String str = new String(cArr2, 0, i);
        try {
            int i17 = $11 + 125;
            $10 = i17 % 128;
            if (i17 % 2 == 0) {
                objArr[0] = str;
                return;
            }
            Object obj = null;
            obj.hashCode();
            objArr[0] = str;
        } catch (Exception e) {
            throw e;
        }
    }
}
