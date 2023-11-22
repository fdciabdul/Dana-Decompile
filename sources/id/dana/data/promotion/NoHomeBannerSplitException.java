package id.dana.data.promotion;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00060\u0001j\u0002`\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/promotion/NoHomeBannerSplitException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NoHomeBannerSplitException extends Exception {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final NoHomeBannerSplitException NEW_INSTANCE = new NoHomeBannerSplitException();
    private static final String NO_HOME_BANNER_EXCEPTION = "Home Banner Split is empty";

    public NoHomeBannerSplitException() {
        super(NO_HOME_BANNER_EXCEPTION);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0083T¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/data/promotion/NoHomeBannerSplitException$Companion;", "", "Lid/dana/data/promotion/NoHomeBannerSplitException;", "NEW_INSTANCE", "Lid/dana/data/promotion/NoHomeBannerSplitException;", "getNEW_INSTANCE", "()Lid/dana/data/promotion/NoHomeBannerSplitException;", "", "NO_HOME_BANNER_EXCEPTION", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "getNEW_INSTANCE")
        public final NoHomeBannerSplitException getNEW_INSTANCE() {
            return NoHomeBannerSplitException.NEW_INSTANCE;
        }
    }
}
