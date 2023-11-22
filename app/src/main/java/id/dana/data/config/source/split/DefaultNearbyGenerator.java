package id.dana.data.config.source.split;

import android.view.Gravity;
import android.view.ViewConfiguration;
import com.alibaba.fastjson.JSONObject;
import id.dana.data.config.model.NearbyTrendingKeywordEntity;
import id.dana.data.config.source.amcs.result.NearbyConfigResult;
import id.dana.data.config.source.amcs.result.NearbyMigrateApiResult;
import id.dana.data.merchant.model.MerchantCategoryEntity;
import id.dana.data.merchant.model.MerchantSubcategoryEntity;
import id.dana.domain.merchant.MerchantCategoryType;
import id.dana.domain.notificationcenter.interactor.ConnectionType;
import id.dana.nearbyme.MerchantViewType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b8\u00109J\u0019\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\bJ'\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\bJ\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0\u0002¢\u0006\u0004\b \u0010\u0005J+\u0010!\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b!\u0010\"JI\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190#*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190#2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002¢\u0006\u0004\b&\u0010'J;\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0#*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0#2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010-\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010+R\u0014\u0010.\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010+R\u0014\u0010/\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010+R\u0014\u00100\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010+R\u0014\u00101\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010+R\u0014\u00102\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u0010+R\u0014\u00103\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u0010+R\u0014\u00104\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u0010+R\u0014\u00105\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u0010+R\u0014\u00106\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u0010+R\u0014\u00107\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u0010+"}, d2 = {"Lid/dana/data/config/source/split/DefaultNearbyGenerator;", "", "", "", "generateDefaultMerchantTopUpAgent", "()Ljava/util/Map;", "Lcom/alibaba/fastjson/JSONObject;", "generateMerchantCategories", "()Lcom/alibaba/fastjson/JSONObject;", "name", "generateMerchantCategory", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "", "generateMerchantOrder", "()Ljava/util/List;", "generateMerchantSubCategories", "", "mcc", "mcId", "generateMerchantSubCategoryValue", "(ILjava/lang/String;Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "generateMerchantTopUpAgent", "Lid/dana/data/config/source/amcs/result/NearbyConfigResult;", "generateNearbyConfig", "()Lid/dana/data/config/source/amcs/result/NearbyConfigResult;", "Lid/dana/data/merchant/model/MerchantCategoryEntity;", "generateNewMerchantCategories", "Lid/dana/domain/merchant/MerchantCategoryType;", "type", "generateNewMerchantOrder", "(Lid/dana/domain/merchant/MerchantCategoryType;)Ljava/util/List;", "Lid/dana/data/merchant/model/MerchantSubcategoryEntity;", "generateNewMerchantSubCategories", "generateMerchantSubCategory", "(Lcom/alibaba/fastjson/JSONObject;ILjava/lang/String;Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "", "id", "mccCodes", "generateNewMerchantCategory", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Ljava/util/Map;", "generateNewMerchantSubCategory", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "AUTOMOTIVE_DEALERS", "Ljava/lang/String;", "CLEANING_REPAIRS", "COVID19_HOSPITAL", "GAS_STATION", "HOME_SHOPPING", "HOUSING_CONTRACTORS", "INSURANCE_SERVICE", "MCC", "MCID", "MEDICAL_SERVICES", "NAME", "SCHOOL_EDUCATIONAL_SERVICE", "TOP_UP_AGENT", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultNearbyGenerator {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final String AUTOMOTIVE_DEALERS = "Automotive Dealers";
    private static final String CLEANING_REPAIRS = "Cleaning & Repairs";
    private static final String COVID19_HOSPITAL = "COVID-19 Hospital";
    private static final String GAS_STATION = "Gas Station";
    private static final String HOME_SHOPPING = "Home Shopping";
    private static final String HOUSING_CONTRACTORS = "Housing & Contractors";
    public static final DefaultNearbyGenerator INSTANCE;
    private static final String INSURANCE_SERVICE = "Insurance Service";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static final String MCC = "mcc";
    private static final String MCID = "mc_id";
    private static final String MEDICAL_SERVICES = "Medical Services and Health Practicioners";
    private static int[] MyBillsEntityDataFactory = null;
    private static final String NAME = "name";
    private static final String SCHOOL_EDUCATIONAL_SERVICE = "School & Educational Service";
    private static final String TOP_UP_AGENT = "Top Up Agent";
    private static int getAuthRequestContext;

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new DefaultNearbyGenerator();
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        MyBillsEntityDataFactory = new int[]{-1194980063, 1554913903, -492594635, 527734130, -1213052864, 1312476747, 2093406869, -1612534779, -1300920246, -327985367, 1714859817, 823948549, -1079504064, 1930481554, 579771227, 152493863, -358729005, -62042918};
    }

    private DefaultNearbyGenerator() {
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public final NearbyConfigResult generateNearbyConfig() {
        int i = 2;
        ?? r4 = 0;
        NearbyTrendingKeywordEntity nearbyTrendingKeywordEntity = new NearbyTrendingKeywordEntity("Pegadaian", r4, i, r4);
        Boolean bool = Boolean.TRUE;
        NearbyConfigResult nearbyConfigResult = new NearbyConfigResult(CollectionsKt.listOf((Object[]) new NearbyTrendingKeywordEntity[]{new NearbyTrendingKeywordEntity("Alfamart", r4, i, r4), nearbyTrendingKeywordEntity, new NearbyTrendingKeywordEntity("KFC", r4, i, r4), new NearbyTrendingKeywordEntity("RS Rujukan", r4, i, r4), new NearbyTrendingKeywordEntity("Lion Parcel", r4, i, r4), new NearbyTrendingKeywordEntity("Kimia Farma", r4, i, r4), new NearbyTrendingKeywordEntity("Pulsa", r4, i, r4)}), bool, Double.valueOf(1.0d), new NearbyMigrateApiResult(bool, bool));
        int i2 = getAuthRequestContext + 57;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        return nearbyConfigResult;
    }

    public final JSONObject generateMerchantCategories() {
        JSONObject jSONObject = new JSONObject();
        DefaultNearbyGenerator defaultNearbyGenerator = INSTANCE;
        jSONObject.put(MerchantViewType.MERCHANT_CAT_DANA_BISNIS, (Object) defaultNearbyGenerator.generateMerchantCategory("#BanggaBuatanIndonesia"));
        jSONObject.put(MerchantViewType.MERCHANT_CAT_PROMO, (Object) defaultNearbyGenerator.generateMerchantCategory("Promo"));
        jSONObject.put(MerchantViewType.MERCHANT_CAT_ORDER_ONLINE, (Object) defaultNearbyGenerator.generateMerchantCategory(HOME_SHOPPING));
        jSONObject.put(MerchantViewType.MERCHANT_CAT_COVID_19, (Object) defaultNearbyGenerator.generateMerchantCategory(COVID19_HOSPITAL));
        jSONObject.put(MerchantViewType.MERCHANT_CAT_FOOD_AND_BEVERAGES, (Object) defaultNearbyGenerator.generateMerchantCategory("Food and Beverages"));
        jSONObject.put(MerchantViewType.MERCHANT_CAT_RETAIL, (Object) defaultNearbyGenerator.generateMerchantCategory("Retail"));
        jSONObject.put(MerchantViewType.MERCHANT_CAT_TOP_UP_AGENT, (Object) defaultNearbyGenerator.generateMerchantCategory(TOP_UP_AGENT));
        jSONObject.put(MerchantViewType.MERCHANT_CAT_PROFESSIONAL_SERVICES, (Object) defaultNearbyGenerator.generateMerchantCategory("Professional Services"));
        jSONObject.put(MerchantViewType.MERCHANT_CAT_HEALTH, (Object) defaultNearbyGenerator.generateMerchantCategory("Health"));
        jSONObject.put(MerchantViewType.MERCHANT_CAT_ENTERTAINMENT, (Object) defaultNearbyGenerator.generateMerchantCategory("Entertainment"));
        jSONObject.put(MerchantViewType.MERCHANT_CAT_FINANCIAL, (Object) defaultNearbyGenerator.generateMerchantCategory("Financial"));
        jSONObject.put(MerchantViewType.MERCHANT_CAT_NON_PROFIT_ORGANIZATION, (Object) defaultNearbyGenerator.generateMerchantCategory("Non-Profit Organization"));
        try {
            int i = getAuthRequestContext + 47;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (!(i % 2 == 0)) {
                    return jSONObject;
                }
                int i2 = 48 / 0;
                return jSONObject;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final JSONObject generateMerchantSubCategories() {
        JSONObject jSONObject = new JSONObject();
        DefaultNearbyGenerator defaultNearbyGenerator = INSTANCE;
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5812, "Restaurant and Dining", MerchantViewType.MERCHANT_CAT_FOOD_AND_BEVERAGES);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5813, "Drink, Ice Cream and Dessert", MerchantViewType.MERCHANT_CAT_FOOD_AND_BEVERAGES);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5814, "Fast Food", MerchantViewType.MERCHANT_CAT_FOOD_AND_BEVERAGES);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5426, "Bakery, Snack, Patisseries", MerchantViewType.MERCHANT_CAT_FOOD_AND_BEVERAGES);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5655, "Fashion, Sport and Beauty", MerchantViewType.MERCHANT_CAT_RETAIL);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5499, "Convenient Store", MerchantViewType.MERCHANT_CAT_RETAIL);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5311, "Department Store", MerchantViewType.MERCHANT_CAT_RETAIL);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5411, "Groceries and Supermarket", MerchantViewType.MERCHANT_CAT_RETAIL);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5722, "Furniture, Household, and Electronic", MerchantViewType.MERCHANT_CAT_RETAIL);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5945, "Accessories, Hobby, Toy, and Game Shop", MerchantViewType.MERCHANT_CAT_RETAIL);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5641, "Baby apparel, toys, and others", MerchantViewType.MERCHANT_CAT_RETAIL);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5942, "Bookstore", MerchantViewType.MERCHANT_CAT_RETAIL);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5999, ConnectionType.OTHERS, MerchantViewType.MERCHANT_CAT_RETAIL);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 9999, TOP_UP_AGENT, MerchantViewType.MERCHANT_CAT_TOP_UP_AGENT);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 7298, "Health and Beauty Spa", MerchantViewType.MERCHANT_CAT_PROFESSIONAL_SERVICES);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 7230, "Salon and Barber Shops", MerchantViewType.MERCHANT_CAT_PROFESSIONAL_SERVICES);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 7297, "Reflexology", MerchantViewType.MERCHANT_CAT_PROFESSIONAL_SERVICES);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5533, "Service, Automotive, Carwash", MerchantViewType.MERCHANT_CAT_PROFESSIONAL_SERVICES);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 8299, "Education", MerchantViewType.MERCHANT_CAT_PROFESSIONAL_SERVICES);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5542, GAS_STATION, MerchantViewType.MERCHANT_CAT_PROFESSIONAL_SERVICES);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 7523, "Parking Lots", MerchantViewType.MERCHANT_CAT_PROFESSIONAL_SERVICES);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 4215, "Courier", MerchantViewType.MERCHANT_CAT_PROFESSIONAL_SERVICES);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 8071, "Laboratory and Medical Service", MerchantViewType.MERCHANT_CAT_HEALTH);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 5912, "Drug Store", MerchantViewType.MERCHANT_CAT_HEALTH);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 8062, "Hospital and Medical Clinic", MerchantViewType.MERCHANT_CAT_HEALTH);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 9997, COVID19_HOSPITAL, MerchantViewType.MERCHANT_CAT_COVID_19);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 7996, "Play Ground", MerchantViewType.MERCHANT_CAT_ENTERTAINMENT);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 7999, "Karaoke", MerchantViewType.MERCHANT_CAT_ENTERTAINMENT);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 7832, "Cinemas", MerchantViewType.MERCHANT_CAT_ENTERTAINMENT);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 6051, "Financial Services", MerchantViewType.MERCHANT_CAT_FINANCIAL);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 8661, "Religious Organization", MerchantViewType.MERCHANT_CAT_NON_PROFIT_ORGANIZATION);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 8398, "Charitable & Social Service", MerchantViewType.MERCHANT_CAT_NON_PROFIT_ORGANIZATION);
        defaultNearbyGenerator.generateMerchantSubCategory(jSONObject, 9998, HOME_SHOPPING, MerchantViewType.MERCHANT_CAT_ORDER_ONLINE);
        int i = getAuthRequestContext + 3;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return jSONObject;
    }

    public final JSONObject generateMerchantTopUpAgent() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("216620000005648450834", (Object) "RMYNW5ID");
            jSONObject.put("216620000008134034549", (Object) "BLMTW5ID");
            jSONObject.put("216620000034831097626", (Object) "PGDNW5ID");
            int i = getAuthRequestContext + 89;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            return jSONObject;
        } catch (Exception e) {
            throw e;
        }
    }

    public final Map<String, String> generateDefaultMerchantTopUpAgent() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("216620000005648450834", "RMYNW5ID");
        linkedHashMap.put("216620000008134034549", "BLMTW5ID");
        linkedHashMap.put("216620000034831097626", "PGDNW5ID");
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return linkedHashMap;
    }

    public final List<String> generateMerchantOrder() {
        int i = getAuthRequestContext + 13;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{MerchantViewType.MERCHANT_CAT_PROMO, MerchantViewType.MERCHANT_CAT_DANA_BISNIS, MerchantViewType.MERCHANT_CAT_ORDER_ONLINE, MerchantViewType.MERCHANT_CAT_COVID_19, MerchantViewType.MERCHANT_CAT_FOOD_AND_BEVERAGES, MerchantViewType.MERCHANT_CAT_RETAIL, MerchantViewType.MERCHANT_CAT_TOP_UP_AGENT, MerchantViewType.MERCHANT_CAT_PROFESSIONAL_SERVICES, MerchantViewType.MERCHANT_CAT_HEALTH, MerchantViewType.MERCHANT_CAT_ENTERTAINMENT, MerchantViewType.MERCHANT_CAT_FINANCIAL, MerchantViewType.MERCHANT_CAT_NON_PROFIT_ORGANIZATION});
        int i3 = getAuthRequestContext + 23;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 == 0 ? '[' : (char) 7) != 7) {
            Object[] objArr = null;
            int length = objArr.length;
            return listOf;
        }
        return listOf;
    }

    public final List<String> generateNewMerchantOrder(MerchantCategoryType type) {
        int i = getAuthRequestContext + 61;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(type, "");
        if ((type == MerchantCategoryType.MAPS ? 'I' : '1') == 'I') {
            int i3 = getAuthRequestContext + 37;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            try {
                List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{"mc_9", "mc_10", "mc_11", "mc_12", MerchantViewType.MERCHANT_CAT_COVID_19, "mc_13", "mc_14", MerchantViewType.MERCHANT_CAT_ENTERTAINMENT, MerchantViewType.MERCHANT_CAT_FINANCIAL, MerchantViewType.MERCHANT_CAT_FOOD_AND_BEVERAGES, MerchantViewType.MERCHANT_CAT_HEALTH, "mc_15", MerchantViewType.MERCHANT_CAT_NON_PROFIT_ORGANIZATION, "mc_16", MerchantViewType.MERCHANT_CAT_RETAIL, MerchantViewType.MERCHANT_CAT_PROFESSIONAL_SERVICES, "mc_18", "mc_19", "mc_20", "mc_21", "mc_others"});
                int i5 = getAuthRequestContext + 35;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                int i6 = i5 % 2;
                return listOf;
            } catch (Exception e) {
                throw e;
            }
        }
        return CollectionsKt.listOf((Object[]) new String[]{MerchantViewType.MERCHANT_CAT_PROMO, MerchantViewType.MERCHANT_CAT_OPEN_NOW, MerchantViewType.MERCHANT_CAT_TOP_UP_AGENT, MerchantViewType.MERCHANT_CAT_ORDER_ONLINE});
    }

    public final Map<String, MerchantCategoryEntity> generateNewMerchantCategories() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DefaultNearbyGenerator defaultNearbyGenerator = INSTANCE;
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, MerchantViewType.MERCHANT_CAT_DANA_BISNIS, "#BanggaBuatanIndonesia", CollectionsKt.emptyList());
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, MerchantViewType.MERCHANT_CAT_OPEN_NOW, "Open Now", CollectionsKt.emptyList());
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, MerchantViewType.MERCHANT_CAT_PROMO, "Promo", CollectionsKt.emptyList());
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, MerchantViewType.MERCHANT_CAT_ORDER_ONLINE, HOME_SHOPPING, CollectionsKt.listOf("9998"));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, MerchantViewType.MERCHANT_CAT_COVID_19, COVID19_HOSPITAL, CollectionsKt.listOf("9997"));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, "mc_others", ConnectionType.OTHERS, CollectionsKt.listOf("5999"));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, MerchantViewType.MERCHANT_CAT_FOOD_AND_BEVERAGES, "Food and Beverages", CollectionsKt.listOf((Object[]) new String[]{"5426", "5812", "5813", "5814", "5921"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, MerchantViewType.MERCHANT_CAT_RETAIL, "Retail", CollectionsKt.listOf((Object[]) new String[]{"5311", "5411", "5499"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, MerchantViewType.MERCHANT_CAT_TOP_UP_AGENT, TOP_UP_AGENT, CollectionsKt.listOf("9999"));
        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{"5045", "5697", "7221", "7276", "7277", "7299", "7372", "8111", "8911", "8999", "1520", "1711", "1731", "1771", "2741", "2842", "4225", "5541", "7210", "7211", "7217", "7251", "7278", "7311", "7332", "7333", "7342", "7349", "7361", "7394", "7538", "8351"});
        Object[] objArr = new Object[1];
        a(8 - Gravity.getAbsoluteGravity(0, 0), new int[]{-1689329284, 649997364, -868809781, -1109163180}, objArr);
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, MerchantViewType.MERCHANT_CAT_PROFESSIONAL_SERVICES, ((String) objArr[0]).intern(), listOf);
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, MerchantViewType.MERCHANT_CAT_HEALTH, "Health", CollectionsKt.listOf((Object[]) new String[]{"4119", "5047", "5912", "8021", "8031", "8041", "8042", "8043", "8044", "8062", "8071", "8099", "9997"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, MerchantViewType.MERCHANT_CAT_ENTERTAINMENT, "Entertainment", CollectionsKt.listOf((Object[]) new String[]{"5996", "7032", "7033", "7296", "7832", "7941", "7992", "7993", "7994", "7996", "7998", "7999"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, MerchantViewType.MERCHANT_CAT_FINANCIAL, "Financial", CollectionsKt.listOf((Object[]) new String[]{"5960", "6012", "6300", "6381", "6399", "7276", "8931"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, MerchantViewType.MERCHANT_CAT_NON_PROFIT_ORGANIZATION, "Organization", CollectionsKt.listOf((Object[]) new String[]{"8398", "8641", "8651", "8661", "8699"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, "mc_9", "Arts & Hobbies", CollectionsKt.listOf((Object[]) new String[]{"5131", "5193", "5733", "5735", "5932", "5933", "5945", "5946", "5947", "5949", "5970", "5971", "5992", "7993"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, "mc_10", "Automotive & Vehicle", CollectionsKt.listOf((Object[]) new String[]{"5533", "5541", "5571", "5592", "5598", "7538", "7542"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, "mc_11", "Beauty and Wellness", CollectionsKt.listOf((Object[]) new String[]{"5977", "7230", "7297", "7298"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, "mc_12", "Clothing", CollectionsKt.listOf((Object[]) new String[]{"5094", "5611", "5612", "5621", "5631", "5641", "5661", "5691", "5944", "5965", "7251"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, "mc_13", "Education", CollectionsKt.listOf((Object[]) new String[]{"5111", "5192", "5942", "5943", "8211", "8220", "8241", "8244", "8299"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, "mc_14", "Electronics", CollectionsKt.listOf((Object[]) new String[]{"5045", "5732"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, "mc_15", "Home Appliance", CollectionsKt.listOf((Object[]) new String[]{"763", "5039", "5211", "5231", "5251", "5407", "5712", "5719", "5722"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, "mc_16", "Pets & Animals", CollectionsKt.listOf((Object[]) new String[]{"742", "5995"}));
        Object[] objArr2 = new Object[1];
        a((ViewConfiguration.getScrollBarSize() >> 8) + 8, new int[]{-1689329284, 649997364, -868809781, -1109163180}, objArr2);
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, "mc_17", ((String) objArr2[0]).intern(), CollectionsKt.emptyList());
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, "mc_18", "Sports & Outdoors", CollectionsKt.listOf((Object[]) new String[]{"5561", "5655", "5940", "5941"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, "mc_19", "Transportation", CollectionsKt.listOf((Object[]) new String[]{"4119", "4121", "4131", "4214", "4215", "4784", "5172", "5542", "7523"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, "mc_20", "Travel", CollectionsKt.listOf((Object[]) new String[]{"4131", "4511", "4722", "7011", "7512", "7513"}));
        defaultNearbyGenerator.generateNewMerchantCategory(linkedHashMap, "mc_21", "Utilities", CollectionsKt.listOf((Object[]) new String[]{"4814", "4900"}));
        int i = getAuthRequestContext + 73;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return linkedHashMap;
    }

    public final Map<String, MerchantSubcategoryEntity> generateNewMerchantSubCategories() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DefaultNearbyGenerator defaultNearbyGenerator = INSTANCE;
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5812", "Restaurants");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5813", "Cafes");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5814", "Fast Food");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5426", "Bakery");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5921", "Beverages");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5499", "Convenience Store");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5311", "Department Store");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5411", "Supermarket");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5999", ConnectionType.OTHERS);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "9999", TOP_UP_AGENT);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7277", "Counseling");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7372", "Computer & Software");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8111", "Legal Service");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8911", "Architechture & Art Design");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7221", "Photography & Videography");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5697", "Tailors");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8999", "Professional Service");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7299", "Professional Service");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8071", "Laboratory and Medical Services");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5912", "Drug Store");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8062", "Hospital and Medical Clinic");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8031", MEDICAL_SERVICES);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8041", MEDICAL_SERVICES);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8042", MEDICAL_SERVICES);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8099", MEDICAL_SERVICES);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8043", "Optical Goods");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8044", "Optical Goods");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8021", "Medical Dental Ophthalmic & Supplies");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5047", "Medical Dental Ophthalmic & Supplies");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "9997", COVID19_HOSPITAL);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5996", "Swimming Pools");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7032", "Amusement Parks");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7033", "Playgrounds");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7296", "Costume & Formal Wear Rental");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7832", "Cinemas");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7941", "Toys, Games, and Hobbies");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7992", "Toys, Games, and Hobbies");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7994", "Arcades & Game Center");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7996", "Amusement Parks");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7998", "Playgrounds");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7999", "Karaoke");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5960", INSURANCE_SERVICE);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "6012", "Investment");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "6300", INSURANCE_SERVICE);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "6381", INSURANCE_SERVICE);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "6399", INSURANCE_SERVICE);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7276", "Financial & Investment Advisor");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8931", "Accounting");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8398", "Charity Organization");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8641", "Social Organization");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8651", "Political Organization");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8661", "Religious Organization");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8699", "Social Organization");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5131", "Collectibles");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5193", "Florist");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5733", "Music Instruments");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5735", "Video Games & Record Store");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5932", "Antiques");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5933", "Collectibles");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5945", "Hobbies, Toys, and Games");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5946", "Camera & Photography");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5947", "Gift Shops");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5949", "Sewing & Fabrics");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5970", "Arts & Crafts");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5971", "Art Dealers & Gallery");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5992", "Florist");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5533", "Parts & Accessories");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5571", AUTOMOTIVE_DEALERS);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5592", AUTOMOTIVE_DEALERS);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5598", AUTOMOTIVE_DEALERS);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7542", "Car Washes");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5977", "Cosmetics");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7230", "Salons & Barbershops");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7297", "Reflexology");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7298", "Health & Beauty Spa");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5094", "Jewelry");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5611", "Men’s Clothing");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5612", "Women's Clothing");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5621", "Women's Clothing");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5631", "Accessories");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5641", "Baby apparel, toys, and others");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5661", "Shoe Stores");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5691", "Men's Clothing");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5944", "Jewelry");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5965", "Accessories");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5111", "Stationery Office & School Supply");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5192", "Bookstore");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5942", "Bookstore");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5943", "Stationery Office & School Supply");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8211", SCHOOL_EDUCATIONAL_SERVICE);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8220", SCHOOL_EDUCATIONAL_SERVICE);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8241", SCHOOL_EDUCATIONAL_SERVICE);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8244", SCHOOL_EDUCATIONAL_SERVICE);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8299", SCHOOL_EDUCATIONAL_SERVICE);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5732", "Home Electronics");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5722", "Appliances");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5211", "Construction Materials");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5039", "Construction Materials");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5719", "Home Furnishing");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5231", "Home Furnishing");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5712", "Furniture");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "763", "Garden Supplies");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5251", "Hardware & Tools");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5407", "Security & Surveillance");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5995", "Pet Shops & Supplies");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "742", "Veterinary Services");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "1520", HOUSING_CONTRACTORS);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "1711", HOUSING_CONTRACTORS);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "1731", HOUSING_CONTRACTORS);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "1771", HOUSING_CONTRACTORS);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "2741", "Publishing & Printing");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "2842", CLEANING_REPAIRS);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "4225", "Moving & Storage");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7210", "Laundry");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7211", "Laundry");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7217", CLEANING_REPAIRS);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7278", "Buying & Shopping Service");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7311", "Advertising");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7332", "Photography Service");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7333", "Photography Service");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7342", CLEANING_REPAIRS);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7349", CLEANING_REPAIRS);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7361", "Employment Agencies");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7394", "Rental");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "8351", "Child Care Service");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5561", "Camping & Outdoors");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5655", "Sports Accessories & Apparels");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5940", "Bicycle");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5941", "Sports Accessories & Apparels");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "4121", "Taxicabs & Limousines");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "4214", "Delivery Couriers");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "4215", "Delivery Couriers");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "4784", "Toll and Bridge Fees");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5172", GAS_STATION);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5542", GAS_STATION);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7523", "Parking Lots & Garages");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "4511", "Airline");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "4722", "Tour & Travel Agencies");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "4761", "Tour & Travel Agencies");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7011", "Lodging & Hotels");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7512", "Car Rentals");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7513", "Car Rentals");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "4814", "Cellular & Telecommunication");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "4900", "Electricity, Gas, and Water");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "9998", HOME_SHOPPING);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "4119", "Ambulance Service");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "4131", "Charters & Tour Buses");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5045", "Computer & Software");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "5541", "Automotive Services");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7251", CLEANING_REPAIRS);
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7538", "Automotive Service");
        defaultNearbyGenerator.generateNewMerchantSubCategory(linkedHashMap, "7993", "Video Games & Record Store");
        int i = getAuthRequestContext + 33;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return linkedHashMap;
    }

    private final JSONObject generateMerchantCategory(String name) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", (Object) name);
            try {
                int i = getAuthRequestContext + 3;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                return jSONObject;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final JSONObject generateMerchantSubCategory(JSONObject jSONObject, int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("msc_");
        sb.append(i);
        jSONObject.put(sb.toString(), (Object) INSTANCE.generateMerchantSubCategoryValue(i, str, str2));
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        return jSONObject;
    }

    private final JSONObject generateMerchantSubCategoryValue(int mcc, String name, String mcId) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mcc", (Object) Integer.valueOf(mcc));
        jSONObject.put("name", (Object) name);
        jSONObject.put(MCID, (Object) mcId);
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? (char) 5 : '@') != 5) {
            return jSONObject;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return jSONObject;
    }

    private final Map<String, MerchantCategoryEntity> generateNewMerchantCategory(Map<String, MerchantCategoryEntity> map, String str, String str2, List<String> list) {
        MerchantCategoryEntity merchantCategoryEntity = new MerchantCategoryEntity();
        merchantCategoryEntity.f8069id = str;
        merchantCategoryEntity.name = str2;
        merchantCategoryEntity.mccCodes = list;
        map.put(str, merchantCategoryEntity);
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    private final Map<String, MerchantSubcategoryEntity> generateNewMerchantSubCategory(Map<String, MerchantSubcategoryEntity> map, String str, String str2) {
        MerchantSubcategoryEntity merchantSubcategoryEntity = new MerchantSubcategoryEntity();
        merchantSubcategoryEntity.mcc = str;
        merchantSubcategoryEntity.Name = str2;
        map.put(str, merchantSubcategoryEntity);
        int i = getAuthRequestContext + 25;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
            return map;
        }
        return map;
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int[] iArr2;
        int[] iArr3;
        int length;
        int[] iArr4;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        try {
            int[] iArr5 = MyBillsEntityDataFactory;
            if (iArr5 != null) {
                int i2 = $10 + 97;
                $11 = i2 % 128;
                if ((i2 % 2 == 0 ? (char) 22 : 'H') != 22) {
                    length = iArr5.length;
                    iArr4 = new int[length];
                } else {
                    length = iArr5.length;
                    iArr4 = new int[length];
                }
                for (int i3 = 0; i3 < length; i3++) {
                    iArr4[i3] = (int) (iArr5[i3] ^ (-3152031022165484798L));
                }
                iArr5 = iArr4;
            }
            int length2 = iArr5.length;
            int[] iArr6 = new int[length2];
            int[] iArr7 = MyBillsEntityDataFactory;
            boolean z = true;
            if (iArr7 == null) {
                iArr2 = iArr6;
            } else {
                int i4 = $11 + 83;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                int length3 = iArr7.length;
                int[] iArr8 = new int[length3];
                int i6 = 0;
                while (true) {
                    if ((i6 >= length3) == z) {
                        break;
                    }
                    int i7 = $10 + 55;
                    $11 = i7 % 128;
                    if (i7 % 2 == 0) {
                        iArr3 = iArr6;
                        iArr8[i6] = (int) (iArr7[i6] % (-3152031022165484798L));
                        i6 >>= 0;
                    } else {
                        iArr3 = iArr6;
                        iArr8[i6] = (int) (iArr7[i6] ^ (-3152031022165484798L));
                        i6++;
                    }
                    int i8 = $11 + 59;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
                    iArr6 = iArr3;
                    z = true;
                }
                iArr2 = iArr6;
                iArr7 = iArr8;
            }
            System.arraycopy(iArr7, 0, iArr2, 0, length2);
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
                int i10 = $11 + 37;
                $10 = i10 % 128;
                int i11 = i10 % 2;
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr2);
                int i12 = $10 + 87;
                $11 = i12 % 128;
                int i13 = i12 % 2;
                for (int i14 = 0; i14 < 16; i14++) {
                    int i15 = $10 + 59;
                    $11 = i15 % 128;
                    int i16 = i15 % 2;
                    try {
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr2[i14];
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        int i17 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i17;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                int i18 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i18;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr2[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr2[17];
                int i19 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i20 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr2);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
            }
            objArr[0] = new String(cArr2, 0, i);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
