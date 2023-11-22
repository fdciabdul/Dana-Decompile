package id.dana.data.config.model;

import id.dana.domain.featureconfig.model.MarmotConfig;
import id.dana.domain.featureconfig.model.MarmotDanaPromotion;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/config/model/MarmotConfigResponse;", "", "Lid/dana/data/config/model/MarmotDanaPromotionResponse;", "danaPromotion", "Lid/dana/data/config/model/MarmotDanaPromotionResponse;", "getDanaPromotion", "()Lid/dana/data/config/model/MarmotDanaPromotionResponse;", "<init>", "(Lid/dana/data/config/model/MarmotDanaPromotionResponse;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MarmotConfigResponse {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public MarmotDanaPromotionResponse danaPromotion;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.data.config.model.MarmotDanaPromotionResponse, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MarmotConfigResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.config.model.MarmotConfigResponse.<init>():void");
    }

    public MarmotConfigResponse(MarmotDanaPromotionResponse marmotDanaPromotionResponse) {
        this.danaPromotion = marmotDanaPromotionResponse;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ MarmotConfigResponse(id.dana.data.config.model.MarmotDanaPromotionResponse r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto Lb
            id.dana.data.config.model.MarmotDanaPromotionResponse r1 = new id.dana.data.config.model.MarmotDanaPromotionResponse
            r2 = 3
            r3 = 0
            r1.<init>(r3, r3, r2, r3)
        Lb:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.config.model.MarmotConfigResponse.<init>(id.dana.data.config.model.MarmotDanaPromotionResponse, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getDanaPromotion")
    public final MarmotDanaPromotionResponse getDanaPromotion() {
        return this.danaPromotion;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/config/model/MarmotConfigResponse$Companion;", "", "Lid/dana/data/config/model/MarmotConfigResponse;", "Lid/dana/domain/featureconfig/model/MarmotConfig;", "toMarmotConfig", "(Lid/dana/data/config/model/MarmotConfigResponse;)Lid/dana/domain/featureconfig/model/MarmotConfig;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean, java.lang.String] */
        public final MarmotConfig toMarmotConfig(MarmotConfigResponse marmotConfigResponse) {
            MarmotDanaPromotion marmotDanaPromotion;
            Intrinsics.checkNotNullParameter(marmotConfigResponse, "");
            MarmotDanaPromotionResponse danaPromotion = marmotConfigResponse.getDanaPromotion();
            if (danaPromotion == null || (marmotDanaPromotion = MarmotDanaPromotionResponse.INSTANCE.toMarmotDanaPromotion(danaPromotion)) == null) {
                ?? r2 = 0;
                marmotDanaPromotion = MarmotDanaPromotionResponse.INSTANCE.toMarmotDanaPromotion(new MarmotDanaPromotionResponse(r2, r2, 3, r2));
            }
            return new MarmotConfig(marmotDanaPromotion);
        }
    }
}
