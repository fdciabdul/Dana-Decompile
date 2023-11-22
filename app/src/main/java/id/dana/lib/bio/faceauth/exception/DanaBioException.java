package id.dana.lib.bio.faceauth.exception;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u000f\u0010B\u0019\b\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0002\u0011\u0012"}, d2 = {"Lid/dana/lib/bio/faceauth/exception/DanaBioException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "", "errorCode", "I", "getErrorCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;I)V", "FaceAuthenticationException", "OpenPageException", "Lid/dana/lib/bio/faceauth/exception/DanaBioException$FaceAuthenticationException;", "Lid/dana/lib/bio/faceauth/exception/DanaBioException$OpenPageException;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class DanaBioException extends IllegalStateException {
    private final int errorCode;
    private final String message;

    public /* synthetic */ DanaBioException(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }

    @Override // java.lang.Throwable
    @JvmName(name = "getMessage")
    public String getMessage() {
        return this.message;
    }

    @JvmName(name = "getErrorCode")
    public int getErrorCode() {
        return this.errorCode;
    }

    private DanaBioException(String str, int i) {
        super(str);
        this.message = str;
        this.errorCode = i;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004"}, d2 = {"Lid/dana/lib/bio/faceauth/exception/DanaBioException$FaceAuthenticationException;", "Lid/dana/lib/bio/faceauth/exception/DanaBioException;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "message", "errorCode", "copy", "(Ljava/lang/String;I)Lid/dana/lib/bio/faceauth/exception/DanaBioException$FaceAuthenticationException;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getErrorCode", "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class FaceAuthenticationException extends DanaBioException {
        private final int errorCode;
        private final String message;

        public static /* synthetic */ FaceAuthenticationException copy$default(FaceAuthenticationException faceAuthenticationException, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = faceAuthenticationException.getMessage();
            }
            if ((i2 & 2) != 0) {
                i = faceAuthenticationException.getErrorCode();
            }
            return faceAuthenticationException.copy(str, i);
        }

        public final String component1() {
            return getMessage();
        }

        public final int component2() {
            return getErrorCode();
        }

        public final FaceAuthenticationException copy(String message, int errorCode) {
            Intrinsics.checkNotNullParameter(message, "");
            return new FaceAuthenticationException(message, errorCode);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof FaceAuthenticationException) {
                FaceAuthenticationException faceAuthenticationException = (FaceAuthenticationException) other;
                return Intrinsics.areEqual(getMessage(), faceAuthenticationException.getMessage()) && getErrorCode() == faceAuthenticationException.getErrorCode();
            }
            return false;
        }

        public final int hashCode() {
            return (getMessage().hashCode() * 31) + getErrorCode();
        }

        @Override // java.lang.Throwable
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FaceAuthenticationException(message=");
            sb.append(getMessage());
            sb.append(", errorCode=");
            sb.append(getErrorCode());
            sb.append(')');
            return sb.toString();
        }

        @Override // id.dana.lib.bio.faceauth.exception.DanaBioException, java.lang.Throwable
        @JvmName(name = "getMessage")
        public final String getMessage() {
            return this.message;
        }

        @Override // id.dana.lib.bio.faceauth.exception.DanaBioException
        @JvmName(name = "getErrorCode")
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FaceAuthenticationException(String str, int i) {
            super(str, i, null);
            Intrinsics.checkNotNullParameter(str, "");
            this.message = str;
            this.errorCode = i;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004"}, d2 = {"Lid/dana/lib/bio/faceauth/exception/DanaBioException$OpenPageException;", "Lid/dana/lib/bio/faceauth/exception/DanaBioException;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "message", "errorCode", "copy", "(Ljava/lang/String;I)Lid/dana/lib/bio/faceauth/exception/DanaBioException$OpenPageException;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getErrorCode", "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OpenPageException extends DanaBioException {
        private final int errorCode;
        private final String message;

        public static /* synthetic */ OpenPageException copy$default(OpenPageException openPageException, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = openPageException.getMessage();
            }
            if ((i2 & 2) != 0) {
                i = openPageException.getErrorCode();
            }
            return openPageException.copy(str, i);
        }

        public final String component1() {
            return getMessage();
        }

        public final int component2() {
            return getErrorCode();
        }

        public final OpenPageException copy(String message, int errorCode) {
            Intrinsics.checkNotNullParameter(message, "");
            return new OpenPageException(message, errorCode);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof OpenPageException) {
                OpenPageException openPageException = (OpenPageException) other;
                return Intrinsics.areEqual(getMessage(), openPageException.getMessage()) && getErrorCode() == openPageException.getErrorCode();
            }
            return false;
        }

        public final int hashCode() {
            return (getMessage().hashCode() * 31) + getErrorCode();
        }

        @Override // java.lang.Throwable
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OpenPageException(message=");
            sb.append(getMessage());
            sb.append(", errorCode=");
            sb.append(getErrorCode());
            sb.append(')');
            return sb.toString();
        }

        @Override // id.dana.lib.bio.faceauth.exception.DanaBioException, java.lang.Throwable
        @JvmName(name = "getMessage")
        public final String getMessage() {
            return this.message;
        }

        @Override // id.dana.lib.bio.faceauth.exception.DanaBioException
        @JvmName(name = "getErrorCode")
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenPageException(String str, int i) {
            super(str, i, null);
            Intrinsics.checkNotNullParameter(str, "");
            this.message = str;
            this.errorCode = i;
        }
    }
}
