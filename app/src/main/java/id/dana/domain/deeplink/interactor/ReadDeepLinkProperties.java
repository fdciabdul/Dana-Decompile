package id.dana.domain.deeplink.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.deeplink.model.DeepLinkPayload;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u001d\b\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/deeplink/interactor/ReadDeepLinkProperties;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/deeplink/model/DeepLinkPayload;", "Lid/dana/domain/deeplink/interactor/ReadDeepLinkProperties$Params;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/deeplink/interactor/ReadDeepLinkProperties$Params;)Lio/reactivex/Observable;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReadDeepLinkProperties extends UseCase<DeepLinkPayload, Params> {
    @Inject
    public ReadDeepLinkProperties(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override // id.dana.domain.UseCase
    public final Observable<DeepLinkPayload> buildUseCaseObservable(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        DeepLinkPayload deepLinkPayload = new DeepLinkPayload();
        deepLinkPayload.setFullUrl(params.getUrl());
        deepLinkPayload.setParams(MapsKt.mapOf(TuplesKt.to("intercept", SummaryActivity.CHECKED)));
        Observable<DeepLinkPayload> just = Observable.just(deepLinkPayload);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/deeplink/interactor/ReadDeepLinkProperties$Params;", "", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String url;

        public /* synthetic */ Params(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        @JvmStatic
        public static final Params forLinkRead(String str) {
            return INSTANCE.forLinkRead(str);
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/deeplink/interactor/ReadDeepLinkProperties$Params$Companion;", "", "", "url", "Lid/dana/domain/deeplink/interactor/ReadDeepLinkProperties$Params;", "forLinkRead", "(Ljava/lang/String;)Lid/dana/domain/deeplink/interactor/ReadDeepLinkProperties$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params forLinkRead(String url) {
                Intrinsics.checkNotNullParameter(url, "");
                return new Params(url, null);
            }
        }

        private Params(String str) {
            this.url = str;
        }

        @JvmName(name = "getUrl")
        public final String getUrl() {
            return this.url;
        }
    }
}
