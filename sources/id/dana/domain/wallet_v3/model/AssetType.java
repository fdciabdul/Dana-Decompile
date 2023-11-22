package id.dana.domain.wallet_v3.model;

import id.dana.animation.HomeTabActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012"}, d2 = {"Lid/dana/domain/wallet_v3/model/AssetType;", "", "", "asset", "Ljava/lang/String;", "getAsset", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "VOUCHER", "COUPON", "DISCOUNT_COUPON", "LOYALTY", "ID_CARD", "INSURANCE", "TICKET", "TRAVEL_TICKET", "PARKING"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public enum AssetType {
    VOUCHER("VOUCHER"),
    COUPON("COUPON"),
    DISCOUNT_COUPON("DISCOUNT_COUPON"),
    LOYALTY("LOYALTY"),
    ID_CARD("ID_CARD"),
    INSURANCE("INSURANCE"),
    TICKET("TICKET"),
    TRAVEL_TICKET("TRAVEL_TICKET"),
    PARKING("PARKING");


    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, AssetType> map;
    private final String asset;

    AssetType(String str) {
        this.asset = str;
    }

    @JvmName(name = "getAsset")
    public final String getAsset() {
        return this.asset;
    }

    static {
        AssetType[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        for (AssetType assetType : values) {
            linkedHashMap.put(assetType.asset, assetType);
        }
        map = linkedHashMap;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/wallet_v3/model/AssetType$Companion;", "", "", HomeTabActivity.WALLET_SECTION, "Lid/dana/domain/wallet_v3/model/AssetType;", "getValue", "(Ljava/lang/String;)Lid/dana/domain/wallet_v3/model/AssetType;", "getValueInString", "(Ljava/lang/String;)Ljava/lang/String;", "", "map", "Ljava/util/Map;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AssetType getValue(String section) {
            Intrinsics.checkNotNullParameter(section, "");
            return (AssetType) AssetType.map.get(section);
        }

        public final String getValueInString(String section) {
            Intrinsics.checkNotNullParameter(section, "");
            AssetType assetType = (AssetType) AssetType.map.get(section);
            if (assetType != null) {
                return assetType.getAsset();
            }
            return null;
        }
    }
}
