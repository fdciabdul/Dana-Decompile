package id.dana.domain.globalnetwork.interactor;

import com.iap.ac.android.biz.common.constants.ACConstants;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/globalnetwork/interactor/DecodeGnQr;", "Lid/dana/domain/UseCase;", "", "Lid/dana/domain/globalnetwork/interactor/DecodeGnQr$Params;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/globalnetwork/interactor/DecodeGnQr$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/globalnetwork/GlobalNetworkRepository;", "globalNetworkRepository", "Lid/dana/domain/globalnetwork/GlobalNetworkRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/globalnetwork/GlobalNetworkRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DecodeGnQr extends UseCase<String, Params> {
    private final GlobalNetworkRepository globalNetworkRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DecodeGnQr(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GlobalNetworkRepository globalNetworkRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(globalNetworkRepository, "");
        this.globalNetworkRepository = globalNetworkRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public final Observable<String> buildUseCaseObservable(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<String> retry = this.globalNetworkRepository.decodeGnQr(params.getAcDecodeValue(), params.getAcDecodeConfig(), params.getFromApp()).timeout(10L, TimeUnit.SECONDS).retry(1L);
        Intrinsics.checkNotNullExpressionValue(retry, "");
        return retry;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/domain/globalnetwork/interactor/DecodeGnQr$Params;", "", "", ACConstants.PARAMETER_KEY_AC_DECODE_CONFIG, "Ljava/lang/String;", "getAcDecodeConfig", "()Ljava/lang/String;", "setAcDecodeConfig", "(Ljava/lang/String;)V", "acDecodeValue", "getAcDecodeValue", "setAcDecodeValue", "", "fromApp", "Z", "getFromApp", "()Z", "setFromApp", "(Z)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private String acDecodeConfig;
        private String acDecodeValue;
        private boolean fromApp;

        @JvmStatic
        public static final Params forDecodeGnQr(String str, String str2, boolean z) {
            return INSTANCE.forDecodeGnQr(str, str2, z);
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/globalnetwork/interactor/DecodeGnQr$Params$Companion;", "", "", "acDecodeValue", ACConstants.PARAMETER_KEY_AC_DECODE_CONFIG, "", "fromApp", "Lid/dana/domain/globalnetwork/interactor/DecodeGnQr$Params;", "forDecodeGnQr", "(Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/domain/globalnetwork/interactor/DecodeGnQr$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params forDecodeGnQr(String acDecodeValue, String acDecodeConfig, boolean fromApp) {
                Intrinsics.checkNotNullParameter(acDecodeValue, "");
                Intrinsics.checkNotNullParameter(acDecodeConfig, "");
                return new Params(acDecodeValue, acDecodeConfig, fromApp);
            }
        }

        public Params(String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.acDecodeValue = str;
            this.acDecodeConfig = str2;
            this.fromApp = z;
        }

        @JvmName(name = "getAcDecodeConfig")
        public final String getAcDecodeConfig() {
            return this.acDecodeConfig;
        }

        @JvmName(name = "getAcDecodeValue")
        public final String getAcDecodeValue() {
            return this.acDecodeValue;
        }

        @JvmName(name = "getFromApp")
        public final boolean getFromApp() {
            return this.fromApp;
        }

        @JvmName(name = "setAcDecodeConfig")
        public final void setAcDecodeConfig(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.acDecodeConfig = str;
        }

        @JvmName(name = "setAcDecodeValue")
        public final void setAcDecodeValue(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.acDecodeValue = str;
        }

        @JvmName(name = "setFromApp")
        public final void setFromApp(boolean z) {
            this.fromApp = z;
        }
    }
}
