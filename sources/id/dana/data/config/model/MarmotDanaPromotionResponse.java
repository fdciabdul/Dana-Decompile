package id.dana.data.config.model;

import id.dana.domain.featureconfig.model.MarmotDanaPromotion;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/config/model/MarmotDanaPromotionResponse;", "", "", "migrationStatus", "Ljava/lang/Boolean;", "getMigrationStatus", "()Ljava/lang/Boolean;", "", "path", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MarmotDanaPromotionResponse {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Boolean migrationStatus;
    public String path;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MarmotDanaPromotionResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.config.model.MarmotDanaPromotionResponse.<init>():void");
    }

    public MarmotDanaPromotionResponse(String str, Boolean bool) {
        this.path = str;
        this.migrationStatus = bool;
    }

    @JvmName(name = "getPath")
    public final String getPath() {
        return this.path;
    }

    public /* synthetic */ MarmotDanaPromotionResponse(String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "/n/dana-promotion" : str, (i & 2) != 0 ? Boolean.FALSE : bool);
    }

    @JvmName(name = "getMigrationStatus")
    public final Boolean getMigrationStatus() {
        return this.migrationStatus;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/config/model/MarmotDanaPromotionResponse$Companion;", "", "Lid/dana/data/config/model/MarmotDanaPromotionResponse;", "Lid/dana/domain/featureconfig/model/MarmotDanaPromotion;", "toMarmotDanaPromotion", "(Lid/dana/data/config/model/MarmotDanaPromotionResponse;)Lid/dana/domain/featureconfig/model/MarmotDanaPromotion;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MarmotDanaPromotion toMarmotDanaPromotion(MarmotDanaPromotionResponse marmotDanaPromotionResponse) {
            Intrinsics.checkNotNullParameter(marmotDanaPromotionResponse, "");
            String path = marmotDanaPromotionResponse.getPath();
            if (path == null) {
                path = "/n/dana-promotion";
            }
            Boolean migrationStatus = marmotDanaPromotionResponse.getMigrationStatus();
            return new MarmotDanaPromotion(path, migrationStatus != null ? migrationStatus.booleanValue() : false);
        }
    }
}
