package id.dana.domain.oauth.interactor;

import com.iap.ac.android.acs.plugin.utils.Constants;
import id.dana.domain.authcode.QueryAuthInfo;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.oauth.error.QueryAuthInfoException;
import id.dana.domain.oauth.model.QrBindingConfig;
import id.dana.domain.oauth.repository.OauthRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001%B\u0019\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u0017¢\u0006\u0004\b#\u0010$J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J7\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0010\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\u00020\b8\u0007@\u0007X\u0086\u000e¢\u0006\u0018\n\u0004\b\u001c\u0010\u001d\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\f"}, d2 = {"Lid/dana/domain/oauth/interactor/GetQueryAuthInfo;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/authcode/QueryAuthInfo;", "Lid/dana/domain/oauth/interactor/GetQueryAuthInfo$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/oauth/interactor/GetQueryAuthInfo$Params;)Lio/reactivex/Observable;", "", "initInterval", "", "checkInitInterval", "(J)V", "maxInterval", "checkMaxInterval", "Lid/dana/domain/oauth/model/QrBindingConfig;", "getQrBindingConfig", "()Lio/reactivex/Observable;", "", "authCode", "clientId", "queryAuthInfo", "(Ljava/lang/String;Ljava/lang/String;JJ)Lio/reactivex/Observable;", "Lid/dana/domain/oauth/interactor/GetQrBindingConfig;", "Lid/dana/domain/oauth/interactor/GetQrBindingConfig;", "Lid/dana/domain/oauth/repository/OauthRepository;", "oauthRepository", "Lid/dana/domain/oauth/repository/OauthRepository;", "retryInterval", "J", "getRetryInterval", "()J", "setRetryInterval", "getRetryInterval$annotations", "()V", "<init>", "(Lid/dana/domain/oauth/repository/OauthRepository;Lid/dana/domain/oauth/interactor/GetQrBindingConfig;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GetQueryAuthInfo extends BaseUseCase<QueryAuthInfo, Params> {
    private final GetQrBindingConfig getQrBindingConfig;
    private final OauthRepository oauthRepository;
    private long retryInterval;

    public static /* synthetic */ void getRetryInterval$annotations() {
    }

    @Inject
    public GetQueryAuthInfo(OauthRepository oauthRepository, GetQrBindingConfig getQrBindingConfig) {
        Intrinsics.checkNotNullParameter(oauthRepository, "");
        Intrinsics.checkNotNullParameter(getQrBindingConfig, "");
        this.oauthRepository = oauthRepository;
        this.getQrBindingConfig = getQrBindingConfig;
    }

    @JvmName(name = "getRetryInterval")
    public final long getRetryInterval() {
        return this.retryInterval;
    }

    @JvmName(name = "setRetryInterval")
    public final void setRetryInterval(long j) {
        this.retryInterval = j;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<QueryAuthInfo> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        this.retryInterval = 0L;
        Observable flatMap = getQrBindingConfig().flatMap(new Function() { // from class: id.dana.domain.oauth.interactor.GetQueryAuthInfo$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2380buildUseCase$lambda0;
                m2380buildUseCase$lambda0 = GetQueryAuthInfo.m2380buildUseCase$lambda0(GetQueryAuthInfo.this, params, (QrBindingConfig) obj);
                return m2380buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2380buildUseCase$lambda0(GetQueryAuthInfo getQueryAuthInfo, Params params, QrBindingConfig qrBindingConfig) {
        Intrinsics.checkNotNullParameter(getQueryAuthInfo, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(qrBindingConfig, "");
        return getQueryAuthInfo.queryAuthInfo(params.getAuthCode(), params.getClientId(), qrBindingConfig.getInitialRetryInterval(), qrBindingConfig.getMaxRetryInterval());
    }

    private final Observable<QrBindingConfig> getQrBindingConfig() {
        return this.getQrBindingConfig.buildUseCase(NoParams.INSTANCE);
    }

    private final Observable<QueryAuthInfo> queryAuthInfo(final String authCode, final String clientId, final long initInterval, final long maxInterval) {
        Observable<QueryAuthInfo> onErrorResumeNext = this.oauthRepository.queryAuthInfo(authCode, clientId).flatMap(new Function() { // from class: id.dana.domain.oauth.interactor.GetQueryAuthInfo$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2381queryAuthInfo$lambda2;
                m2381queryAuthInfo$lambda2 = GetQueryAuthInfo.m2381queryAuthInfo$lambda2(GetQueryAuthInfo.this, initInterval, maxInterval, authCode, clientId, (QueryAuthInfo) obj);
                return m2381queryAuthInfo$lambda2;
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.domain.oauth.interactor.GetQueryAuthInfo$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2383queryAuthInfo$lambda3;
                m2383queryAuthInfo$lambda3 = GetQueryAuthInfo.m2383queryAuthInfo$lambda3((Throwable) obj);
                return m2383queryAuthInfo$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: queryAuthInfo$lambda-2  reason: not valid java name */
    public static final ObservableSource m2381queryAuthInfo$lambda2(final GetQueryAuthInfo getQueryAuthInfo, final long j, final long j2, final String str, final String str2, QueryAuthInfo queryAuthInfo) {
        Intrinsics.checkNotNullParameter(getQueryAuthInfo, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(queryAuthInfo, "");
        if (!queryAuthInfo.getQueryAgain()) {
            return Observable.just(queryAuthInfo);
        }
        getQueryAuthInfo.checkInitInterval(j);
        getQueryAuthInfo.checkMaxInterval(j2);
        return Observable.timer(getQueryAuthInfo.retryInterval, TimeUnit.MILLISECONDS).flatMap(new Function() { // from class: id.dana.domain.oauth.interactor.GetQueryAuthInfo$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2382queryAuthInfo$lambda2$lambda1;
                m2382queryAuthInfo$lambda2$lambda1 = GetQueryAuthInfo.m2382queryAuthInfo$lambda2$lambda1(GetQueryAuthInfo.this, str, str2, j, j2, (Long) obj);
                return m2382queryAuthInfo$lambda2$lambda1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: queryAuthInfo$lambda-2$lambda-1  reason: not valid java name */
    public static final ObservableSource m2382queryAuthInfo$lambda2$lambda1(GetQueryAuthInfo getQueryAuthInfo, String str, String str2, long j, long j2, Long l) {
        Intrinsics.checkNotNullParameter(getQueryAuthInfo, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(l, "");
        getQueryAuthInfo.retryInterval *= 2;
        return getQueryAuthInfo.queryAuthInfo(str, str2, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: queryAuthInfo$lambda-3  reason: not valid java name */
    public static final ObservableSource m2383queryAuthInfo$lambda3(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Observable.error(new QueryAuthInfoException(th));
    }

    public final void checkInitInterval(long initInterval) {
        if (this.retryInterval == 0) {
            this.retryInterval = initInterval;
        }
    }

    public final void checkMaxInterval(long maxInterval) {
        if (this.retryInterval > maxInterval) {
            this.retryInterval = maxInterval;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J&\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0015"}, d2 = {"Lid/dana/domain/oauth/interactor/GetQueryAuthInfo$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "authCode", "clientId", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/oauth/interactor/GetQueryAuthInfo$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", Constants.JS_API_GET_AUTH_CODE, "setAuthCode", "(Ljava/lang/String;)V", "getClientId", "setClientId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final /* data */ class Params {
        private String authCode;
        private String clientId;

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.authCode;
            }
            if ((i & 2) != 0) {
                str2 = params.clientId;
            }
            return params.copy(str, str2);
        }

        /* renamed from: component1  reason: from getter */
        public final String getAuthCode() {
            return this.authCode;
        }

        /* renamed from: component2  reason: from getter */
        public final String getClientId() {
            return this.clientId;
        }

        public final Params copy(String authCode, String clientId) {
            Intrinsics.checkNotNullParameter(authCode, "");
            return new Params(authCode, clientId);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.authCode, params.authCode) && Intrinsics.areEqual(this.clientId, params.clientId);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.authCode.hashCode();
            String str = this.clientId;
            return (hashCode * 31) + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(authCode=");
            sb.append(this.authCode);
            sb.append(", clientId=");
            sb.append(this.clientId);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            this.authCode = str;
            this.clientId = str2;
        }

        @JvmName(name = Constants.JS_API_GET_AUTH_CODE)
        public final String getAuthCode() {
            return this.authCode;
        }

        @JvmName(name = "setAuthCode")
        public final void setAuthCode(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.authCode = str;
        }

        @JvmName(name = "getClientId")
        public final String getClientId() {
            return this.clientId;
        }

        @JvmName(name = "setClientId")
        public final void setClientId(String str) {
            this.clientId = str;
        }
    }
}
