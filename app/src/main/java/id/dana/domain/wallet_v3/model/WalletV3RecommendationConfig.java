package id.dana.domain.wallet_v3.model;

import android.view.ViewConfiguration;
import com.alibaba.griver.core.GriverParams;
import com.j256.ormlite.stmt.query.SimpleComparison;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.danah5.danaprotection.DanaProtectionKey;
import id.dana.domain.payasset.model.PayMethod;
import id.dana.domain.wallet_v3.constant.WalletRecommendationConstant;
import id.dana.expresspurchase.view.ExpressPurchaseActivity;
import id.dana.nearbyme.NearbyMePromoType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u0000 52\u00020\u0001:\u00015B\u0085\u0001\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b3\u00104J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u008e\u0001\u0010\u001c\u001a\u00020\u00002\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b%\u0010\u0007R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b'\u0010\u0007R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b(\u0010\u0007R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b)\u0010\u0007R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b*\u0010\u0007R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b+\u0010\u0007R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010\u0005R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b.\u0010\u0007R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010/\u001a\u0004\b0\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b1\u0010\u0007R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b2\u0010\u0007"}, d2 = {"Lid/dana/domain/wallet_v3/model/WalletV3RecommendationConfig;", "", "", "", "component1", "()Ljava/util/List;", "component10", "()Ljava/lang/String;", "component2", "component3", "Lid/dana/domain/wallet_v3/model/Rules;", "component4", "()Lid/dana/domain/wallet_v3/model/Rules;", "component5", "component6", "component7", "component8", "component9", "keywords", DanaProtectionKey.DanaProtectionResultParamsKey.RECOMMENDATION, GriverParams.ShareParams.IMAGE_URL, "rules", "titleEn", "titleId", "descEn", "descId", "btnTitleEn", "btnTitleId", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/wallet_v3/model/Rules;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/wallet_v3/model/WalletV3RecommendationConfig;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBtnTitleEn", "getBtnTitleId", "getDescEn", "getDescId", "getImageUrl", "Ljava/util/List;", "getKeywords", DanaProtectionKey.EventName.GET_RECOMMENDATION, "Lid/dana/domain/wallet_v3/model/Rules;", "getRules", "getTitleEn", "getTitleId", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/wallet_v3/model/Rules;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class WalletV3RecommendationConfig {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String WALLET_V3_BANK_CARDS = "wallet_v3_bank_cards_recommendation";
    public static final String WALLET_V3_DANA_PLUS = "wallet_v3_dana_plus_recommendation";
    public static final String WALLET_V3_DEALS = "wallet_v3_deals_recommendation";
    public static final String WALLET_V3_EMAS = "wallet_v3_emas_recommendation";
    public static final String WALLET_V3_E_KTP = "wallet_v3_ektp_recommendation";
    public static final String WALLET_V3_GOAL = "wallet_v3_goals_recommendation";
    public static final String WALLET_V3_LOYALTY = "wallet_v3_loyalty_recommendation";
    public String btnTitleEn;
    public String btnTitleId;
    public String descEn;
    public String descId;
    public String imageUrl;
    public List<String> keywords;
    public String recommendation;
    public Rules rules;
    public String titleEn;
    public String titleId;

    public WalletV3RecommendationConfig() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public final List<String> component1() {
        return this.keywords;
    }

    /* renamed from: component10  reason: from getter */
    public final String getBtnTitleId() {
        return this.btnTitleId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getRecommendation() {
        return this.recommendation;
    }

    /* renamed from: component3  reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component4  reason: from getter */
    public final Rules getRules() {
        return this.rules;
    }

    /* renamed from: component5  reason: from getter */
    public final String getTitleEn() {
        return this.titleEn;
    }

    /* renamed from: component6  reason: from getter */
    public final String getTitleId() {
        return this.titleId;
    }

    /* renamed from: component7  reason: from getter */
    public final String getDescEn() {
        return this.descEn;
    }

    /* renamed from: component8  reason: from getter */
    public final String getDescId() {
        return this.descId;
    }

    /* renamed from: component9  reason: from getter */
    public final String getBtnTitleEn() {
        return this.btnTitleEn;
    }

    public final WalletV3RecommendationConfig copy(List<String> keywords, String recommendation, String imageUrl, Rules rules, String titleEn, String titleId, String descEn, String descId, String btnTitleEn, String btnTitleId) {
        return new WalletV3RecommendationConfig(keywords, recommendation, imageUrl, rules, titleEn, titleId, descEn, descId, btnTitleEn, btnTitleId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof WalletV3RecommendationConfig) {
            WalletV3RecommendationConfig walletV3RecommendationConfig = (WalletV3RecommendationConfig) other;
            return Intrinsics.areEqual(this.keywords, walletV3RecommendationConfig.keywords) && Intrinsics.areEqual(this.recommendation, walletV3RecommendationConfig.recommendation) && Intrinsics.areEqual(this.imageUrl, walletV3RecommendationConfig.imageUrl) && Intrinsics.areEqual(this.rules, walletV3RecommendationConfig.rules) && Intrinsics.areEqual(this.titleEn, walletV3RecommendationConfig.titleEn) && Intrinsics.areEqual(this.titleId, walletV3RecommendationConfig.titleId) && Intrinsics.areEqual(this.descEn, walletV3RecommendationConfig.descEn) && Intrinsics.areEqual(this.descId, walletV3RecommendationConfig.descId) && Intrinsics.areEqual(this.btnTitleEn, walletV3RecommendationConfig.btnTitleEn) && Intrinsics.areEqual(this.btnTitleId, walletV3RecommendationConfig.btnTitleId);
        }
        return false;
    }

    public final int hashCode() {
        List<String> list = this.keywords;
        int hashCode = list == null ? 0 : list.hashCode();
        String str = this.recommendation;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.imageUrl;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        Rules rules = this.rules;
        int hashCode4 = rules == null ? 0 : rules.hashCode();
        String str3 = this.titleEn;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.titleId;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.descEn;
        int hashCode7 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.descId;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.btnTitleEn;
        int hashCode9 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.btnTitleId;
        return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + (str8 != null ? str8.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WalletV3RecommendationConfig(keywords=");
        sb.append(this.keywords);
        sb.append(", recommendation=");
        sb.append(this.recommendation);
        sb.append(", imageUrl=");
        sb.append(this.imageUrl);
        sb.append(", rules=");
        sb.append(this.rules);
        sb.append(", titleEn=");
        sb.append(this.titleEn);
        sb.append(", titleId=");
        sb.append(this.titleId);
        sb.append(", descEn=");
        sb.append(this.descEn);
        sb.append(", descId=");
        sb.append(this.descId);
        sb.append(", btnTitleEn=");
        sb.append(this.btnTitleEn);
        sb.append(", btnTitleId=");
        sb.append(this.btnTitleId);
        sb.append(')');
        return sb.toString();
    }

    public WalletV3RecommendationConfig(List<String> list, String str, String str2, Rules rules, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.keywords = list;
        this.recommendation = str;
        this.imageUrl = str2;
        this.rules = rules;
        this.titleEn = str3;
        this.titleId = str4;
        this.descEn = str5;
        this.descId = str6;
        this.btnTitleEn = str7;
        this.btnTitleId = str8;
    }

    public /* synthetic */ WalletV3RecommendationConfig(List list, String str, String str2, Rules rules, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : rules, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) == 0 ? str8 : null);
    }

    @JvmName(name = "getKeywords")
    public final List<String> getKeywords() {
        return this.keywords;
    }

    @JvmName(name = DanaProtectionKey.EventName.GET_RECOMMENDATION)
    public final String getRecommendation() {
        return this.recommendation;
    }

    @JvmName(name = "getImageUrl")
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @JvmName(name = "getRules")
    public final Rules getRules() {
        return this.rules;
    }

    @JvmName(name = "getTitleEn")
    public final String getTitleEn() {
        return this.titleEn;
    }

    @JvmName(name = "getTitleId")
    public final String getTitleId() {
        return this.titleId;
    }

    @JvmName(name = "getDescEn")
    public final String getDescEn() {
        return this.descEn;
    }

    @JvmName(name = "getDescId")
    public final String getDescId() {
        return this.descId;
    }

    @JvmName(name = "getBtnTitleEn")
    public final String getBtnTitleEn() {
        return this.btnTitleEn;
    }

    @JvmName(name = "getBtnTitleId")
    public final String getBtnTitleId() {
        return this.btnTitleId;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000b"}, d2 = {"Lid/dana/domain/wallet_v3/model/WalletV3RecommendationConfig$Companion;", "", "", "", "getDefaultKey", "()[Ljava/lang/String;", "key", "Lid/dana/domain/wallet_v3/model/WalletV3RecommendationConfig;", "getDefaultValue", "(Ljava/lang/String;)Lid/dana/domain/wallet_v3/model/WalletV3RecommendationConfig;", "WALLET_V3_BANK_CARDS", "Ljava/lang/String;", "WALLET_V3_DANA_PLUS", "WALLET_V3_DEALS", "WALLET_V3_EMAS", "WALLET_V3_E_KTP", "WALLET_V3_GOAL", "WALLET_V3_LOYALTY", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        private static int scheduleImpl = 1;
        private static char[] MyBillsEntityDataFactory = {39434, 39448, 39437, 39433, 39444, 39450, 39454, 39440, 39452};
        private static boolean BuiltInFictitiousFunctionClassFactory = true;
        private static boolean getAuthRequestContext = true;
        private static int PlaceComponentResult = 909155327;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String[] getDefaultKey() {
            int i = scheduleImpl + 61;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? '\t' : 'E') != '\t') {
                return new String[]{WalletV3RecommendationConfig.WALLET_V3_BANK_CARDS, WalletV3RecommendationConfig.WALLET_V3_EMAS, WalletV3RecommendationConfig.WALLET_V3_GOAL, WalletV3RecommendationConfig.WALLET_V3_DANA_PLUS, WalletV3RecommendationConfig.WALLET_V3_DEALS, WalletV3RecommendationConfig.WALLET_V3_LOYALTY};
            }
            try {
                String[] strArr = new String[103];
                strArr[0] = WalletV3RecommendationConfig.WALLET_V3_BANK_CARDS;
                strArr[0] = WalletV3RecommendationConfig.WALLET_V3_EMAS;
                strArr[4] = WalletV3RecommendationConfig.WALLET_V3_GOAL;
                strArr[2] = WalletV3RecommendationConfig.WALLET_V3_DANA_PLUS;
                strArr[4] = WalletV3RecommendationConfig.WALLET_V3_DEALS;
                strArr[3] = WalletV3RecommendationConfig.WALLET_V3_LOYALTY;
                return strArr;
            } catch (Exception e) {
                throw e;
            }
        }

        public final WalletV3RecommendationConfig getDefaultValue(String key) {
            WalletV3RecommendationConfig walletV3RecommendationConfig;
            Intrinsics.checkNotNullParameter(key, "");
            switch (key.hashCode()) {
                case -1729761790:
                    if (key.equals(WalletV3RecommendationConfig.WALLET_V3_EMAS)) {
                        List listOf = CollectionsKt.listOf((Object[]) new String[]{"Emas", "DANA Emas", "Investasi", "Investments"});
                        Rules rules = new Rules(HomeTabActivity.WALLET_SECTION, CollectionsKt.emptyList(), "financial", "", "==", 0);
                        Object[] objArr = new Object[1];
                        a(127 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), new byte[]{-127, -119, -120, -126, -121, -126, -122, -123, -124, -125, -126, -127}, null, null, objArr);
                        walletV3RecommendationConfig = new WalletV3RecommendationConfig(listOf, ((String) objArr[0]).intern(), "https://m.dana.id/resource/imgs/dana-wallet/recom-bg-emas.png", rules, "eMAS", "eMAS", "Check your eMAS profit directly on Wallet", "Cek keuntungan eMAS langsung dari Dompet", "ADD", "TAMBAH");
                        int i = scheduleImpl + 95;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                        int i2 = i % 2;
                        break;
                    } else {
                        return null;
                    }
                case -607565461:
                    if (key.equals(WalletV3RecommendationConfig.WALLET_V3_DANA_PLUS)) {
                        return new WalletV3RecommendationConfig(CollectionsKt.emptyList(), "service_dana_plus", WalletRecommendationConstant.IMG_URL_DANA_PLUS, new Rules("asset", CollectionsKt.listOf(PayMethod.DANA_PLUS), "financial", "", "==", 0), "DANA Plus", "DANA Plus", "Transact easily with your DANA Plus profits", "Transaksi mudah pakai keuntungan DANA Plus", "ADD", "TAMBAH");
                    }
                    return null;
                case -520782764:
                    if (key.equals(WalletV3RecommendationConfig.WALLET_V3_GOAL)) {
                        walletV3RecommendationConfig = new WalletV3RecommendationConfig(CollectionsKt.listOf((Object[]) new String[]{"Tabungan", "DANA Goals", "Goals", "target", "Investasi", "Investments"}), "service_goals", "https://m.dana.id/resource/imgs/dana-wallet/recom-bg-goals.png", new Rules(HomeTabActivity.WALLET_SECTION, CollectionsKt.emptyList(), "financial", "", "==", 0), "DANA Goals", "DANA Goals", "Getting quick access to view your goals", "Akses cepat untuk lihat pencapaian Impian kamu", "ADD", "TAMBAH");
                        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
                        scheduleImpl = i3 % 128;
                        int i4 = i3 % 2;
                        break;
                    } else {
                        return null;
                    }
                case 442474510:
                    if (key.equals(WalletV3RecommendationConfig.WALLET_V3_LOYALTY)) {
                        return new WalletV3RecommendationConfig(CollectionsKt.listOf((Object[]) new String[]{"Loyalty", "Membership", "Member"}), "service_loyalty", "https://m.dana.id/resource/imgs/dana-wallet/recom-bg-loyalty.png", new Rules(HomeTabActivity.WALLET_SECTION, CollectionsKt.emptyList(), "loyalty", "", SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION, 0), "Collect Loyalty", "Kumpulin Loyalty", "Get the promos with your transactions!", "Transaksi terus dan dapetin promonya!", "ADD", "TAMBAH");
                    }
                    return null;
                case 560474029:
                    if (key.equals(WalletV3RecommendationConfig.WALLET_V3_DEALS)) {
                        return new WalletV3RecommendationConfig(CollectionsKt.listOf((Object[]) new String[]{"Promo", "Voucher", ExpressPurchaseActivity.DEALS_EVENT_SOURCE, TrackerKey.PromoCenterSourceType.DANA_DEALS, "Diskon", "Discount"}), "service_deals", WalletRecommendationConstant.IMG_URL_DEALS, new Rules(HomeTabActivity.WALLET_SECTION, CollectionsKt.emptyList(), "voucher_and_ticket", "", SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION, 0), TrackerKey.PromoCenterSourceType.DANA_DEALS, TrackerKey.PromoCenterSourceType.DANA_DEALS, "Find the best promos from your fave brands", "Temukan penawaran hemat dari brand favorit", "BUY", "BELI");
                    }
                    return null;
                case 1546592636:
                    if (key.equals(WalletV3RecommendationConfig.WALLET_V3_BANK_CARDS)) {
                        return new WalletV3RecommendationConfig(CollectionsKt.listOf((Object[]) new String[]{"DANA Balance", "Kartu Bank", "Bank", "Kartu", "BCA", "Mandiri", "Permata", "Danamon", "DBS"}), "service_bank_card", WalletRecommendationConstant.IMG_URL_BANK_CARD, new Rules("asset", CollectionsKt.listOf((Object[]) new String[]{NearbyMePromoType.LimitRangeType.DC, "CC"}), "payment", "&&", SimpleComparison.LESS_THAN_OPERATION, 10), "Bank Cards", "Kartu Bank", "Pay simpler with your saved bank cards", "Bayar lebih simpel dengan kartu bank kamu", "SAVE", "SIMPAN");
                    }
                    return null;
                case 1739065914:
                    if (key.equals(WalletV3RecommendationConfig.WALLET_V3_E_KTP)) {
                        return new WalletV3RecommendationConfig(CollectionsKt.listOf((Object[]) new String[]{"KTP", "SIM"}), "service_ektp", WalletRecommendationConstant.IMG_URL_EKTP, new Rules("asset", CollectionsKt.listOf("ID_CARD"), "identity", "", "==", 0), "Add your e-KTP", "Simpan e-KTP", "Access your personal ID within reach", "Akses kartu identitas dalam genggaman", "ADD", "TAMBAH");
                    }
                    return null;
                default:
                    return null;
            }
            return walletV3RecommendationConfig;
        }

        private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
            int i2;
            BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
            char[] cArr2 = MyBillsEntityDataFactory;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                try {
                    int i3 = $10 + 37;
                    $11 = i3 % 128;
                    int i4 = i3 % 2;
                    for (int i5 = 0; i5 < length; i5++) {
                        int i6 = $11 + 47;
                        $10 = i6 % 128;
                        int i7 = i6 % 2;
                        cArr3[i5] = (char) (cArr2[i5] ^ 4571606982258105150L);
                    }
                    cArr2 = cArr3;
                } catch (Exception e) {
                    throw e;
                }
            }
            int i8 = (int) (4571606982258105150L ^ PlaceComponentResult);
            if (!(!getAuthRequestContext)) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if (!(bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult)) {
                        objArr[0] = new String(cArr4);
                        return;
                    }
                    int i9 = $11 + 59;
                    $10 = i9 % 128;
                    if (i9 % 2 != 0) {
                        cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult << 0) >> bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] * i8);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory / 0;
                    } else {
                        cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i8);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                    }
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
                }
            } else {
                if ((BuiltInFictitiousFunctionClassFactory ? '(' : 'F') == 'F') {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                    char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        int i10 = $11 + 5;
                        $10 = i10 % 128;
                        if (i10 % 2 != 0) {
                            cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult + 0) / bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] * i] / i8);
                        } else {
                            cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i8);
                        }
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                        int i11 = $10 + 71;
                        $11 = i11 % 128;
                        int i12 = i11 % 2;
                    }
                    objArr[0] = new String(cArr5);
                    return;
                }
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? '(' : (char) 7) == 7) {
                        objArr[0] = new String(cArr6);
                        return;
                    } else {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i8);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    }
                }
            }
        }
    }
}
