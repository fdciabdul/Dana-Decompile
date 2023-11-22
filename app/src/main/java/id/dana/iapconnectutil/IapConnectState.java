package id.dana.iapconnectutil;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t"}, d2 = {"Lid/dana/iapconnectutil/IapConnectState;", "", "<init>", "()V", "Error", "Finished", "Loading", "Lid/dana/iapconnectutil/IapConnectState$Loading;", "Lid/dana/iapconnectutil/IapConnectState$Finished;", "Lid/dana/iapconnectutil/IapConnectState$Error;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class IapConnectState {
    public /* synthetic */ IapConnectState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/iapconnectutil/IapConnectState$Loading;", "Lid/dana/iapconnectutil/IapConnectState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Loading extends IapConnectState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    private IapConnectState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/iapconnectutil/IapConnectState$Finished;", "Lid/dana/iapconnectutil/IapConnectState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Finished extends IapConnectState {
        public static final Finished INSTANCE = new Finished();

        private Finished() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/iapconnectutil/IapConnectState$Error;", "Lid/dana/iapconnectutil/IapConnectState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Error extends IapConnectState {
        public static final Error INSTANCE = new Error();

        private Error() {
            super(null);
        }
    }
}
