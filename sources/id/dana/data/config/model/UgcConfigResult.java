package id.dana.data.config.model;

import id.dana.domain.featureconfig.model.UgcConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/config/model/UgcConfigResult;", "", "", "ugcInterval", "Ljava/lang/Integer;", "getUgcInterval", "()Ljava/lang/Integer;", "<init>", "(Ljava/lang/Integer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UgcConfigResult {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Integer ugcInterval;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UgcConfigResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.config.model.UgcConfigResult.<init>():void");
    }

    public UgcConfigResult(Integer num) {
        this.ugcInterval = num;
    }

    public /* synthetic */ UgcConfigResult(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Integer.valueOf((int) UgcConfig.DEFAULT_UGC_INTERVAL) : num);
    }

    @JvmName(name = "getUgcInterval")
    public final Integer getUgcInterval() {
        return this.ugcInterval;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/data/config/model/UgcConfigResult$Companion;", "", "Lid/dana/data/config/model/UgcConfigResult;", "", "reviewEnable", "Lid/dana/domain/featureconfig/model/UgcConfig;", "toUgcConfig", "(Lid/dana/data/config/model/UgcConfigResult;Z)Lid/dana/domain/featureconfig/model/UgcConfig;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UgcConfig toUgcConfig(UgcConfigResult ugcConfigResult, boolean z) {
            Intrinsics.checkNotNullParameter(ugcConfigResult, "");
            Integer ugcInterval = ugcConfigResult.getUgcInterval();
            return new UgcConfig(z, ugcInterval != null ? ugcInterval.intValue() : UgcConfig.DEFAULT_UGC_INTERVAL);
        }
    }
}
