package id.dana.explore.domain.globalsearch.enums;

import id.dana.promoquest.handler.PromoQuestRedirectType;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n"}, d2 = {"Lid/dana/explore/domain/globalsearch/enums/RecommendationCategory;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "POPULAR_PLACES", PromoQuestRedirectType.SERVICES}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum RecommendationCategory {
    POPULAR_PLACES("MERCHANT_SHOP"),
    SERVICES(PromoQuestRedirectType.SERVICES);

    private final String type;

    RecommendationCategory(String str) {
        this.type = str;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }
}
