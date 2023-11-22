package id.dana.network.exception;

import id.dana.utils.extension.LanguageExtKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/network/exception/NoInternetConnectionException;", "Ljava/io/IOException;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NoInternetConnectionException extends IOException {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NETWORK_IS_NOT_AVAILABLE_MESSAGE_EN = "Oops, unstable internet connection. Please check your network and try again.";
    private static final String NETWORK_IS_NOT_AVAILABLE_MESSAGE_ID = "Yah, koneksi internet bermasalah. Silakan cek jaringanmu dan coba lagi ya";
    private final String message;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NoInternetConnectionException() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.network.exception.NoInternetConnectionException.<init>():void");
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006"}, d2 = {"Lid/dana/network/exception/NoInternetConnectionException$Companion;", "", "", "getMessage$core_network_productionRelease", "()Ljava/lang/String;", "NETWORK_IS_NOT_AVAILABLE_MESSAGE_EN", "Ljava/lang/String;", "NETWORK_IS_NOT_AVAILABLE_MESSAGE_ID", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getMessage$core_network_productionRelease() {
            return LanguageExtKt.getAuthRequestContext() ? NoInternetConnectionException.NETWORK_IS_NOT_AVAILABLE_MESSAGE_ID : NoInternetConnectionException.NETWORK_IS_NOT_AVAILABLE_MESSAGE_EN;
        }
    }

    public NoInternetConnectionException(String str) {
        super(str);
        this.message = str;
    }

    public /* synthetic */ NoInternetConnectionException(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? INSTANCE.getMessage$core_network_productionRelease() : str);
    }

    @Override // java.lang.Throwable
    @JvmName(name = "getMessage")
    public final String getMessage() {
        return this.message;
    }
}
