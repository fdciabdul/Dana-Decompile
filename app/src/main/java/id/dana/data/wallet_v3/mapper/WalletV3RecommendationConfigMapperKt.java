package id.dana.data.wallet_v3.mapper;

import id.dana.domain.wallet_v3.model.AssetRecommendation;
import id.dana.domain.wallet_v3.model.Rules;
import id.dana.domain.wallet_v3.model.RulesRecommendation;
import id.dana.domain.wallet_v3.model.WalletV3RecommendationConfig;
import id.dana.utils.StringWrapper;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/wallet_v3/model/WalletV3RecommendationConfig;", "Lid/dana/domain/wallet_v3/model/AssetRecommendation;", "toAssetRecommendation", "(Lid/dana/domain/wallet_v3/model/WalletV3RecommendationConfig;)Lid/dana/domain/wallet_v3/model/AssetRecommendation;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WalletV3RecommendationConfigMapperKt {
    public static final AssetRecommendation toAssetRecommendation(WalletV3RecommendationConfig walletV3RecommendationConfig) {
        Object m3179constructorimpl;
        String sectionType;
        Intrinsics.checkNotNullParameter(walletV3RecommendationConfig, "");
        String str = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            RulesRecommendation.Builder builder = new RulesRecommendation.Builder();
            Rules rules = walletV3RecommendationConfig.getRules();
            RulesRecommendation.Builder baseOn = builder.setBaseOn(rules != null ? rules.getBasedOn() : null);
            Rules rules2 = walletV3RecommendationConfig.getRules();
            RulesRecommendation.Builder assetTypes = baseOn.setAssetTypes(rules2 != null ? rules2.getAssetType() : null);
            Rules rules3 = walletV3RecommendationConfig.getRules();
            RulesRecommendation.Builder sectionType2 = assetTypes.setSectionType(rules3 != null ? rules3.getSectionType() : null);
            Rules rules4 = walletV3RecommendationConfig.getRules();
            RulesRecommendation.Builder logicalOperator = sectionType2.setLogicalOperator(rules4 != null ? rules4.getLogicalOperator() : null);
            Rules rules5 = walletV3RecommendationConfig.getRules();
            RulesRecommendation.Builder comparisonOperator = logicalOperator.setComparisonOperator(rules5 != null ? rules5.getComparisonOperator() : null);
            Rules rules6 = walletV3RecommendationConfig.getRules();
            m3179constructorimpl = Result.m3179constructorimpl(comparisonOperator.setComparator(rules6 != null ? rules6.getComparator() : null).build());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        String recommendation = walletV3RecommendationConfig.getRecommendation();
        String str2 = recommendation == null ? "" : recommendation;
        String imageUrl = walletV3RecommendationConfig.getImageUrl();
        StringWrapper.StringLocaleValue stringLocaleValue = new StringWrapper.StringLocaleValue(walletV3RecommendationConfig.getTitleEn(), walletV3RecommendationConfig.getTitleId());
        StringWrapper.StringLocaleValue stringLocaleValue2 = new StringWrapper.StringLocaleValue(walletV3RecommendationConfig.getDescEn(), walletV3RecommendationConfig.getDescId());
        StringWrapper.StringLocaleValue stringLocaleValue3 = new StringWrapper.StringLocaleValue(walletV3RecommendationConfig.getBtnTitleEn(), walletV3RecommendationConfig.getBtnTitleId());
        List<String> keywords = walletV3RecommendationConfig.getKeywords();
        if (keywords == null) {
            keywords = CollectionsKt.emptyList();
        }
        List<String> list = keywords;
        Rules rules7 = walletV3RecommendationConfig.getRules();
        String comparisonOperator2 = rules7 != null ? rules7.getComparisonOperator() : null;
        String str3 = comparisonOperator2 == null ? "" : comparisonOperator2;
        Rules rules8 = walletV3RecommendationConfig.getRules();
        Integer comparator = rules8 != null ? rules8.getComparator() : null;
        if (Result.m3185isFailureimpl(m3179constructorimpl)) {
            m3179constructorimpl = null;
        }
        RulesRecommendation rulesRecommendation = (RulesRecommendation) m3179constructorimpl;
        String rawSQL = rulesRecommendation != null ? rulesRecommendation.getRawSQL() : null;
        String str4 = rawSQL == null ? "" : rawSQL;
        Rules rules9 = walletV3RecommendationConfig.getRules();
        if (rules9 != null && (sectionType = rules9.getSectionType()) != null) {
            str = sectionType.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "");
        }
        return new AssetRecommendation(str2, imageUrl, stringLocaleValue, stringLocaleValue2, stringLocaleValue3, list, str4, str3, comparator, str == null ? "" : str, null, 1024, null);
    }
}
