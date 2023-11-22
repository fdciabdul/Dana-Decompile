package id.dana.di.component;

/* loaded from: classes4.dex */
public final class DaggerCommonRichViewComponent {
    private DaggerCommonRichViewComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class CommonRichViewComponentImpl implements CommonRichViewComponent {
        private final CommonRichViewComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;

        public /* synthetic */ CommonRichViewComponentImpl() {
            this((byte) 0);
        }

        private CommonRichViewComponentImpl(byte b) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
        }
    }
}
