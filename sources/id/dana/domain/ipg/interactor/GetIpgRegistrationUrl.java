package id.dana.domain.ipg.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.ipg.IpgRegistrationUrl;
import id.dana.domain.ipg.IpgRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/ipg/interactor/GetIpgRegistrationUrl;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/ipg/IpgRegistrationUrl;", "Lid/dana/domain/ipg/interactor/GetIpgRegistrationUrl$Params;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/ipg/interactor/GetIpgRegistrationUrl$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/ipg/IpgRepository;", "ipgRepository", "Lid/dana/domain/ipg/IpgRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/ipg/IpgRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetIpgRegistrationUrl extends UseCase<IpgRegistrationUrl, Params> {
    private final IpgRepository ipgRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetIpgRegistrationUrl(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, IpgRepository ipgRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(ipgRepository, "");
        this.ipgRepository = ipgRepository;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/domain/ipg/interactor/GetIpgRegistrationUrl$Params;", "", "", "bizType", "Ljava/lang/String;", "getBizType", "()Ljava/lang/String;", "deviceId", "getDeviceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final String bizType;
        private final String deviceId;

        public Params(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.deviceId = str;
            this.bizType = str2;
        }

        @JvmName(name = "getBizType")
        public final String getBizType() {
            return this.bizType;
        }

        @JvmName(name = "getDeviceId")
        public final String getDeviceId() {
            return this.deviceId;
        }
    }

    @Override // id.dana.domain.UseCase
    public final Observable<IpgRegistrationUrl> buildUseCaseObservable(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.ipgRepository.getIpgRegistrationUrl(params.getDeviceId(), params.getBizType());
    }
}
