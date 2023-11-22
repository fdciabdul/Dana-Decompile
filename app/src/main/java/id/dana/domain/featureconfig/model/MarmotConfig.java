package id.dana.domain.featureconfig.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/featureconfig/model/MarmotConfig;", "", "Lid/dana/domain/featureconfig/model/MarmotDanaPromotion;", "danaPromotion", "Lid/dana/domain/featureconfig/model/MarmotDanaPromotion;", "getDanaPromotion", "()Lid/dana/domain/featureconfig/model/MarmotDanaPromotion;", "<init>", "(Lid/dana/domain/featureconfig/model/MarmotDanaPromotion;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MarmotConfig {
    private final MarmotDanaPromotion danaPromotion;

    public MarmotConfig(MarmotDanaPromotion marmotDanaPromotion) {
        Intrinsics.checkNotNullParameter(marmotDanaPromotion, "");
        this.danaPromotion = marmotDanaPromotion;
    }

    @JvmName(name = "getDanaPromotion")
    public final MarmotDanaPromotion getDanaPromotion() {
        return this.danaPromotion;
    }
}
