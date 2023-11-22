package id.dana.domain.ipg.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.ipg.IpgRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/ipg/interactor/GetIpgClickedAgree;", "Lid/dana/domain/UseCase;", "", "Lid/dana/domain/ipg/interactor/GetIpgClickedAgree$Params;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/ipg/interactor/GetIpgClickedAgree$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/ipg/IpgRepository;", "ipgRepository", "Lid/dana/domain/ipg/IpgRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/ipg/IpgRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetIpgClickedAgree extends UseCase<Boolean, Params> {
    private final IpgRepository ipgRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetIpgClickedAgree(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, IpgRepository ipgRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(ipgRepository, "");
        this.ipgRepository = ipgRepository;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\"\u0010\u0005\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/domain/ipg/interactor/GetIpgClickedAgree$Params;", "", "", "component1", "()Ljava/lang/String;", "userConsentConfigKey", "copy", "(Ljava/lang/String;)Lid/dana/domain/ipg/interactor/GetIpgClickedAgree$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getUserConsentConfigKey", "setUserConsentConfigKey", "(Ljava/lang/String;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private String userConsentConfigKey;

        public static /* synthetic */ Params copy$default(Params params, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.userConsentConfigKey;
            }
            return params.copy(str);
        }

        /* renamed from: component1  reason: from getter */
        public final String getUserConsentConfigKey() {
            return this.userConsentConfigKey;
        }

        public final Params copy(String userConsentConfigKey) {
            Intrinsics.checkNotNullParameter(userConsentConfigKey, "");
            return new Params(userConsentConfigKey);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.userConsentConfigKey, ((Params) other).userConsentConfigKey);
        }

        public final int hashCode() {
            return this.userConsentConfigKey.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(userConsentConfigKey=");
            sb.append(this.userConsentConfigKey);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.userConsentConfigKey = str;
        }

        @JvmName(name = "getUserConsentConfigKey")
        public final String getUserConsentConfigKey() {
            return this.userConsentConfigKey;
        }

        @JvmName(name = "setUserConsentConfigKey")
        public final void setUserConsentConfigKey(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.userConsentConfigKey = str;
        }
    }

    @Override // id.dana.domain.UseCase
    public final Observable<Boolean> buildUseCaseObservable(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.ipgRepository.isClickedAgree(params.getUserConsentConfigKey());
    }
}
