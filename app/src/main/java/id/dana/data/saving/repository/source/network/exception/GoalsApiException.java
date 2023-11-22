package id.dana.data.saving.repository.source.network.exception;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0005\u0010\u0011\u0012\u0013\u0014B-\b\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\u0082\u0001\u0005\u0015\u0016\u0017\u0018\u0019"}, d2 = {"Lid/dana/data/saving/repository/source/network/exception/GoalsApiException;", "", "", "hasTraceIdAndErrorCode", "()Z", "", "apiErrorCode", "Ljava/lang/String;", "getApiErrorCode", "()Ljava/lang/String;", "apiErrorMessage", "getApiErrorMessage", "apiTraceId", "getApiTraceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ReachMaximum", "UnableToCreate", "UnableToLoad", "UnableToTopUp", "UnableToWithdraw", "Lid/dana/data/saving/repository/source/network/exception/GoalsApiException$UnableToLoad;", "Lid/dana/data/saving/repository/source/network/exception/GoalsApiException$UnableToCreate;", "Lid/dana/data/saving/repository/source/network/exception/GoalsApiException$UnableToTopUp;", "Lid/dana/data/saving/repository/source/network/exception/GoalsApiException$UnableToWithdraw;", "Lid/dana/data/saving/repository/source/network/exception/GoalsApiException$ReachMaximum;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class GoalsApiException extends Throwable {
    private final String apiErrorCode;
    private final String apiErrorMessage;
    private final String apiTraceId;

    public /* synthetic */ GoalsApiException(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3);
    }

    public /* synthetic */ GoalsApiException(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, null);
    }

    @JvmName(name = "getApiErrorCode")
    public final String getApiErrorCode() {
        return this.apiErrorCode;
    }

    @JvmName(name = "getApiTraceId")
    public final String getApiTraceId() {
        return this.apiTraceId;
    }

    @JvmName(name = "getApiErrorMessage")
    public final String getApiErrorMessage() {
        return this.apiErrorMessage;
    }

    private GoalsApiException(String str, String str2, String str3) {
        super(str3);
        this.apiErrorCode = str;
        this.apiTraceId = str2;
        this.apiErrorMessage = str3;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/data/saving/repository/source/network/exception/GoalsApiException$UnableToLoad;", "Lid/dana/data/saving/repository/source/network/exception/GoalsApiException;", "", "errorCode", "Ljava/lang/String;", "getErrorCode", "()Ljava/lang/String;", "errorMessage", "getErrorMessage", "traceId", "getTraceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class UnableToLoad extends GoalsApiException {
        private final String errorCode;
        private final String errorMessage;
        private final String traceId;

        public UnableToLoad() {
            this(null, null, null, 7, null);
        }

        public /* synthetic */ UnableToLoad(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @JvmName(name = "getErrorCode")
        public final String getErrorCode() {
            return this.errorCode;
        }

        @JvmName(name = "getTraceId")
        public final String getTraceId() {
            return this.traceId;
        }

        @JvmName(name = "getErrorMessage")
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public UnableToLoad(String str, String str2, String str3) {
            super(str, str2, str3, null);
            this.errorCode = str;
            this.traceId = str2;
            this.errorMessage = str3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/data/saving/repository/source/network/exception/GoalsApiException$UnableToCreate;", "Lid/dana/data/saving/repository/source/network/exception/GoalsApiException;", "", "errorCode", "Ljava/lang/String;", "getErrorCode", "()Ljava/lang/String;", "traceId", "getTraceId", "errorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class UnableToCreate extends GoalsApiException {
        private final String errorCode;
        private final String traceId;

        public UnableToCreate() {
            this(null, null, null, 7, null);
        }

        public /* synthetic */ UnableToCreate(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @JvmName(name = "getErrorCode")
        public final String getErrorCode() {
            return this.errorCode;
        }

        @JvmName(name = "getTraceId")
        public final String getTraceId() {
            return this.traceId;
        }

        public UnableToCreate(String str, String str2, String str3) {
            super(str, str2, str3, null);
            this.errorCode = str;
            this.traceId = str2;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/data/saving/repository/source/network/exception/GoalsApiException$UnableToTopUp;", "Lid/dana/data/saving/repository/source/network/exception/GoalsApiException;", "", "errorCode", "Ljava/lang/String;", "getErrorCode", "()Ljava/lang/String;", "traceId", "getTraceId", "errorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class UnableToTopUp extends GoalsApiException {
        private final String errorCode;
        private final String traceId;

        public UnableToTopUp() {
            this(null, null, null, 7, null);
        }

        public /* synthetic */ UnableToTopUp(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @JvmName(name = "getErrorCode")
        public final String getErrorCode() {
            return this.errorCode;
        }

        @JvmName(name = "getTraceId")
        public final String getTraceId() {
            return this.traceId;
        }

        public UnableToTopUp(String str, String str2, String str3) {
            super(str, str2, str3, null);
            this.errorCode = str;
            this.traceId = str2;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/data/saving/repository/source/network/exception/GoalsApiException$UnableToWithdraw;", "Lid/dana/data/saving/repository/source/network/exception/GoalsApiException;", "", "errorCode", "Ljava/lang/String;", "getErrorCode", "()Ljava/lang/String;", "traceId", "getTraceId", "errorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class UnableToWithdraw extends GoalsApiException {
        private final String errorCode;
        private final String traceId;

        public UnableToWithdraw() {
            this(null, null, null, 7, null);
        }

        public /* synthetic */ UnableToWithdraw(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @JvmName(name = "getErrorCode")
        public final String getErrorCode() {
            return this.errorCode;
        }

        @JvmName(name = "getTraceId")
        public final String getTraceId() {
            return this.traceId;
        }

        public UnableToWithdraw(String str, String str2, String str3) {
            super(str, str2, str3, null);
            this.errorCode = str;
            this.traceId = str2;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/data/saving/repository/source/network/exception/GoalsApiException$ReachMaximum;", "Lid/dana/data/saving/repository/source/network/exception/GoalsApiException;", "", "errorCode", "Ljava/lang/String;", "getErrorCode", "()Ljava/lang/String;", "traceId", "getTraceId", "errorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ReachMaximum extends GoalsApiException {
        private final String errorCode;
        private final String traceId;

        public ReachMaximum() {
            this(null, null, null, 7, null);
        }

        public /* synthetic */ ReachMaximum(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @JvmName(name = "getErrorCode")
        public final String getErrorCode() {
            return this.errorCode;
        }

        @JvmName(name = "getTraceId")
        public final String getTraceId() {
            return this.traceId;
        }

        public ReachMaximum(String str, String str2, String str3) {
            super(str, str2, str3, null);
            this.errorCode = str;
            this.traceId = str2;
        }
    }

    public final boolean hasTraceIdAndErrorCode() {
        String str = this.apiTraceId;
        if (!(str == null || str.length() == 0)) {
            String str2 = this.apiErrorCode;
            if (!(str2 == null || str2.length() == 0)) {
                return true;
            }
        }
        return false;
    }
}
