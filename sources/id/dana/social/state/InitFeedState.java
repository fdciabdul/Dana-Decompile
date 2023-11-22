package id.dana.social.state;

import id.dana.domain.social.InitStatus;
import id.dana.domain.social.model.InitFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u0000 \u00042\u00020\u0001:\u0004\u0005\u0004\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\b\t\n"}, d2 = {"Lid/dana/social/state/InitFeedState;", "", "<init>", "()V", "Companion", "Activated", "NoWording", "NotActivated", "Lid/dana/social/state/InitFeedState$NotActivated;", "Lid/dana/social/state/InitFeedState$NoWording;", "Lid/dana/social/state/InitFeedState$Activated;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class InitFeedState {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ InitFeedState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/state/InitFeedState$NotActivated;", "Lid/dana/social/state/InitFeedState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class NotActivated extends InitFeedState {
        public static final NotActivated INSTANCE = new NotActivated();

        private NotActivated() {
            super(null);
        }
    }

    private InitFeedState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/state/InitFeedState$NoWording;", "Lid/dana/social/state/InitFeedState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class NoWording extends InitFeedState {
        public static final NoWording INSTANCE = new NoWording();

        private NoWording() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/state/InitFeedState$Activated;", "Lid/dana/social/state/InitFeedState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Activated extends InitFeedState {
        public static final Activated INSTANCE = new Activated();

        private Activated() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/state/InitFeedState$Companion;", "", "Lid/dana/domain/social/model/InitFeed;", "p0", "Lid/dana/social/state/InitFeedState;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/social/model/InitFeed;)Lid/dana/social/state/InitFeedState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

            static {
                int[] iArr = new int[InitStatus.values().length];
                iArr[InitStatus.FINISH.ordinal()] = 1;
                BuiltInFictitiousFunctionClassFactory = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static InitFeedState BuiltInFictitiousFunctionClassFactory(InitFeed p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            if (WhenMappings.BuiltInFictitiousFunctionClassFactory[p0.getStatus().ordinal()] == 1) {
                return p0.getHasRestrictedContact() ? NoWording.INSTANCE : Activated.INSTANCE;
            }
            return NotActivated.INSTANCE;
        }
    }
}
