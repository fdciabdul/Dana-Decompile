package leakcanary;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0003\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lleakcanary/LeakCanary;", "", "Lleakcanary/LeakCanary$Config;", "PlaceComponentResult", "Lleakcanary/LeakCanary$Config;", "<init>", "()V", "Config"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes9.dex */
public final class LeakCanary {
    public static final LeakCanary INSTANCE = new LeakCanary();
    public static volatile Config PlaceComponentResult;

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        PlaceComponentResult = new Config(defaultConstructorMarker, 1, defaultConstructorMarker);
    }

    private LeakCanary() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0001X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lleakcanary/LeakCanary$Config;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes9.dex */
    public static final /* data */ class Config {
        public final Object MyBillsEntityDataFactory;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Config() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: leakcanary.LeakCanary.Config.<init>():void");
        }

        public final boolean equals(Object p0) {
            if (this != p0) {
                return (p0 instanceof Config) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, ((Config) p0).MyBillsEntityDataFactory);
            }
            return true;
        }

        public final int hashCode() {
            Object obj = this.MyBillsEntityDataFactory;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Config(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(")");
            return sb.toString();
        }

        private Config(Object obj) {
            this.MyBillsEntityDataFactory = obj;
        }

        public /* synthetic */ Config(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : obj);
        }
    }
}
