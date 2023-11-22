package id.dana.domain.wallet_v3.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\f\r"}, d2 = {"Lid/dana/domain/wallet_v3/model/RulesRecommendationException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "InvalidOperatorException", "QueryNotAvailableException", "Lid/dana/domain/wallet_v3/model/RulesRecommendationException$QueryNotAvailableException;", "Lid/dana/domain/wallet_v3/model/RulesRecommendationException$InvalidOperatorException;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class RulesRecommendationException extends IllegalStateException {
    private final String message;

    public /* synthetic */ RulesRecommendationException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private RulesRecommendationException(String str) {
        super(str);
        this.message = str;
    }

    @Override // java.lang.Throwable
    @JvmName(name = "getMessage")
    public String getMessage() {
        return this.message;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/domain/wallet_v3/model/RulesRecommendationException$QueryNotAvailableException;", "Lid/dana/domain/wallet_v3/model/RulesRecommendationException;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lid/dana/domain/wallet_v3/model/RulesRecommendationException$QueryNotAvailableException;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class QueryNotAvailableException extends RulesRecommendationException {
        private final String message;

        public static /* synthetic */ QueryNotAvailableException copy$default(QueryNotAvailableException queryNotAvailableException, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = queryNotAvailableException.getMessage();
            }
            return queryNotAvailableException.copy(str);
        }

        public final String component1() {
            return getMessage();
        }

        public final QueryNotAvailableException copy(String message) {
            Intrinsics.checkNotNullParameter(message, "");
            return new QueryNotAvailableException(message);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof QueryNotAvailableException) && Intrinsics.areEqual(getMessage(), ((QueryNotAvailableException) other).getMessage());
        }

        public final int hashCode() {
            return getMessage().hashCode();
        }

        @Override // java.lang.Throwable
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("QueryNotAvailableException(message=");
            sb.append(getMessage());
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QueryNotAvailableException(String str) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "");
            this.message = str;
        }

        @Override // id.dana.domain.wallet_v3.model.RulesRecommendationException, java.lang.Throwable
        @JvmName(name = "getMessage")
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/domain/wallet_v3/model/RulesRecommendationException$InvalidOperatorException;", "Lid/dana/domain/wallet_v3/model/RulesRecommendationException;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lid/dana/domain/wallet_v3/model/RulesRecommendationException$InvalidOperatorException;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class InvalidOperatorException extends RulesRecommendationException {
        private final String message;

        public static /* synthetic */ InvalidOperatorException copy$default(InvalidOperatorException invalidOperatorException, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidOperatorException.getMessage();
            }
            return invalidOperatorException.copy(str);
        }

        public final String component1() {
            return getMessage();
        }

        public final InvalidOperatorException copy(String message) {
            Intrinsics.checkNotNullParameter(message, "");
            return new InvalidOperatorException(message);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InvalidOperatorException) && Intrinsics.areEqual(getMessage(), ((InvalidOperatorException) other).getMessage());
        }

        public final int hashCode() {
            return getMessage().hashCode();
        }

        @Override // java.lang.Throwable
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("InvalidOperatorException(message=");
            sb.append(getMessage());
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidOperatorException(String str) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "");
            this.message = str;
        }

        @Override // id.dana.domain.wallet_v3.model.RulesRecommendationException, java.lang.Throwable
        @JvmName(name = "getMessage")
        public final String getMessage() {
            return this.message;
        }
    }
}
