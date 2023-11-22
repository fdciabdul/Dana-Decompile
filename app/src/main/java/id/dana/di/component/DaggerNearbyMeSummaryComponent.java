package id.dana.di.component;

/* loaded from: classes8.dex */
public final class DaggerNearbyMeSummaryComponent {
    private DaggerNearbyMeSummaryComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public ApplicationComponent MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class NearbyMeSummaryComponentImpl implements NearbyMeSummaryComponent {
        private final NearbyMeSummaryComponentImpl MyBillsEntityDataFactory;

        public /* synthetic */ NearbyMeSummaryComponentImpl() {
            this((byte) 0);
        }

        private NearbyMeSummaryComponentImpl(byte b) {
            this.MyBillsEntityDataFactory = this;
        }
    }
}
