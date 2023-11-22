package id.dana.domain.wallet_v3.model;

import id.dana.animation.HomeTabActivity;
import id.dana.domain.mybills.interactor.GetInquirySubscriptionPaylaterWithDestination;
import id.dana.domain.payasset.model.PayMethod;
import id.dana.nearbyme.NearbyMePromoType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010"}, d2 = {"Lid/dana/domain/wallet_v3/model/CardAssetType;", "", "", "asset", "Ljava/lang/String;", "getAsset", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "DEBIT_CARD", "CREDIT_CARD", GetInquirySubscriptionPaylaterWithDestination.GOODSTYPE_PAYLATER, "GOALS", "BALANCE", PayMethod.DANA_PLUS, "EMAS"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public enum CardAssetType {
    DEBIT_CARD(NearbyMePromoType.LimitRangeType.DC),
    CREDIT_CARD("CC"),
    PAYLATER(GetInquirySubscriptionPaylaterWithDestination.GOODSTYPE_PAYLATER),
    GOALS("GOALS"),
    BALANCE("BALANCE"),
    DANA_PLUS(PayMethod.DANA_PLUS),
    EMAS("EMAS");


    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, CardAssetType> map;
    private final String asset;

    CardAssetType(String str) {
        this.asset = str;
    }

    @JvmName(name = "getAsset")
    public final String getAsset() {
        return this.asset;
    }

    static {
        CardAssetType[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        for (CardAssetType cardAssetType : values) {
            linkedHashMap.put(cardAssetType.asset, cardAssetType);
        }
        map = linkedHashMap;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00078\u0007¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/wallet_v3/model/CardAssetType$Companion;", "", "", HomeTabActivity.WALLET_SECTION, "Lid/dana/domain/wallet_v3/model/CardAssetType;", "getValue", "(Ljava/lang/String;)Lid/dana/domain/wallet_v3/model/CardAssetType;", "", "map", "Ljava/util/Map;", "getMap", "()Ljava/util/Map;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "getMap")
        public final Map<String, CardAssetType> getMap() {
            return CardAssetType.map;
        }

        public final CardAssetType getValue(String section) {
            Intrinsics.checkNotNullParameter(section, "");
            return getMap().get(section);
        }
    }
}
