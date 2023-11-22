package id.dana.utils.retry;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b"}, d2 = {"Lid/dana/utils/retry/RetryException;", "", "<init>", "()V", "FirstRetry", "SecondRetry", "ThirdRetry", "UnknownRetry", "Lid/dana/utils/retry/RetryException$FirstRetry;", "Lid/dana/utils/retry/RetryException$SecondRetry;", "Lid/dana/utils/retry/RetryException$ThirdRetry;", "Lid/dana/utils/retry/RetryException$UnknownRetry;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class RetryException extends Throwable {
    public /* synthetic */ RetryException(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RetryException() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/utils/retry/RetryException$FirstRetry;", "Lid/dana/utils/retry/RetryException;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class FirstRetry extends RetryException {
        public static final FirstRetry INSTANCE = new FirstRetry();

        private FirstRetry() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/utils/retry/RetryException$SecondRetry;", "Lid/dana/utils/retry/RetryException;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class SecondRetry extends RetryException {
        public static final SecondRetry INSTANCE = new SecondRetry();

        private SecondRetry() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/utils/retry/RetryException$ThirdRetry;", "Lid/dana/utils/retry/RetryException;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ThirdRetry extends RetryException {
        public static final ThirdRetry INSTANCE = new ThirdRetry();

        private ThirdRetry() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/utils/retry/RetryException$UnknownRetry;", "Lid/dana/utils/retry/RetryException;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class UnknownRetry extends RetryException {
        public static final UnknownRetry INSTANCE = new UnknownRetry();

        private UnknownRetry() {
            super(null);
        }
    }
}
