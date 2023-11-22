package id.dana.domain.core.usecase;

import com.alibaba.ariver.kernel.RVEvents;
import com.alipay.imobile.network.quake.exception.ServerException;
import id.dana.domain.tracker.MixpanelRepository;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 -*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u0001-B\u000f\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b+\u0010,Jk\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u00072\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\n2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fj\u0004\u0018\u0001`\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012Ju\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u00072\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0005j\u0002`\u00142\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fj\u0004\u0018\u0001`\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018JW\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u00072\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0005j\u0002`\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0013H&¢\u0006\u0004\b!\u0010\"J)\u0010$\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\tH\u0002¢\u0006\u0004\b$\u0010%R\u0017\u0010'\u001a\u00020&8\u0007¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*"}, d2 = {"Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "T", "Params", "Lid/dana/domain/core/usecase/BaseUseCase;", "params", "Lkotlin/Function1;", "", "Lid/dana/domain/core/usecase/OnSuccessCallback;", "onSuccess", "", "Lid/dana/domain/core/usecase/OnErrorCallback;", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "Lkotlin/Function0;", "Lid/dana/domain/core/usecase/OnCompleteCallback;", "onComplete", "Lio/reactivex/functions/Action;", "onDispose", "execute", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lio/reactivex/functions/Action;)V", "", "Lid/dana/domain/core/usecase/OnErrorCallbackWithDisplayedMessage;", "onErrorWithDisplayedMessage", "source", "executeJava2", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lio/reactivex/functions/Action;Ljava/lang/String;)V", "executeJava1", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "displayedMessage", "operationType", "errorMessage", "Lorg/json/JSONObject;", "generateErrorEventJsonObject", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;", "getOperationType", "()Ljava/lang/String;", "throwable", "trackErrorEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "Lid/dana/domain/tracker/MixpanelRepository;", "mixpanelTrackerRepository", "Lid/dana/domain/tracker/MixpanelRepository;", "getMixpanelTrackerRepository", "()Lid/dana/domain/tracker/MixpanelRepository;", "<init>", "(Lid/dana/domain/tracker/MixpanelRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseUseCaseWithAnalytics<T, Params> extends BaseUseCase<T, Params> {
    public static final String EVENT_KEY = "Displayed Error";
    private final MixpanelRepository mixpanelTrackerRepository;

    /* renamed from: execute$lambda-1 */
    public static final void m2267execute$lambda1() {
    }

    public abstract String getOperationType();

    @JvmName(name = "getMixpanelTrackerRepository")
    public final MixpanelRepository getMixpanelTrackerRepository() {
        return this.mixpanelTrackerRepository;
    }

    public BaseUseCaseWithAnalytics(MixpanelRepository mixpanelRepository) {
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        this.mixpanelTrackerRepository = mixpanelRepository;
    }

    private final JSONObject generateErrorEventJsonObject(String displayedMessage, String operationType, String errorMessage, String source) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n            {\n                'Displayed Message': \"");
        sb.append(displayedMessage);
        sb.append("\",\n                'Operation Type': \"");
        sb.append(operationType);
        sb.append("\",\n                'Error Message': \"");
        sb.append(errorMessage);
        sb.append("\",\n                'Source': \"");
        sb.append(source);
        sb.append("\"\n            }\n            ");
        return new JSONObject(StringsKt.trimIndent(sb.toString()));
    }

    public final void trackErrorEvent(String displayedMessage, String source, Throwable throwable) {
        try {
            ServerException serverException = (ServerException) throwable;
            this.mixpanelTrackerRepository.track("Displayed Error", generateErrorEventJsonObject(displayedMessage, serverException.getOperationType(), serverException.getLocalizedMessage(), source));
        } catch (Exception unused) {
            this.mixpanelTrackerRepository.track("Displayed Error", generateErrorEventJsonObject(displayedMessage, getOperationType(), throwable.getLocalizedMessage(), source));
        }
    }

    public static /* synthetic */ void executeJava1$default(BaseUseCaseWithAnalytics baseUseCaseWithAnalytics, Object obj, Function1 function1, Function1 function12, String str, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i & 8) != 0) {
            str = "";
        }
        baseUseCaseWithAnalytics.executeJava1(obj, function1, function12, str);
    }

    public final void executeJava1(Params params, Function1<? super T, Unit> onSuccess, final Function1<? super Throwable, String> onErrorWithDisplayedMessage, final String source) {
        Intrinsics.checkNotNullParameter(onSuccess, "");
        Intrinsics.checkNotNullParameter(onErrorWithDisplayedMessage, "");
        Intrinsics.checkNotNullParameter(source, "");
        execute(params, onSuccess, new Function1<Throwable, Unit>(this) { // from class: id.dana.domain.core.usecase.BaseUseCaseWithAnalytics$execute$1
            final /* synthetic */ BaseUseCaseWithAnalytics<T, Params> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                this.this$0.trackErrorEvent(onErrorWithDisplayedMessage.invoke(th), source, th);
            }
        }, new Function0<Unit>() { // from class: id.dana.domain.core.usecase.BaseUseCaseWithAnalytics$execute$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, new Action() { // from class: id.dana.domain.core.usecase.BaseUseCaseWithAnalytics$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() {
                BaseUseCaseWithAnalytics.m2267execute$lambda1();
            }
        });
    }

    public static /* synthetic */ void executeJava2$default(BaseUseCaseWithAnalytics baseUseCaseWithAnalytics, Object obj, Function1 function1, Function1 function12, Function0 function0, Action action, String str, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i & 32) != 0) {
            str = "";
        }
        baseUseCaseWithAnalytics.executeJava2(obj, function1, function12, function0, action, str);
    }

    public final void executeJava2(Params params, Function1<? super T, Unit> onSuccess, final Function1<? super Throwable, String> onErrorWithDisplayedMessage, Function0<Unit> onComplete, Action onDispose, final String source) {
        Intrinsics.checkNotNullParameter(onSuccess, "");
        Intrinsics.checkNotNullParameter(onErrorWithDisplayedMessage, "");
        Intrinsics.checkNotNullParameter(onDispose, "");
        Intrinsics.checkNotNullParameter(source, "");
        execute(params, onSuccess, new Function1<Throwable, Unit>(this) { // from class: id.dana.domain.core.usecase.BaseUseCaseWithAnalytics$execute$4
            final /* synthetic */ BaseUseCaseWithAnalytics<T, Params> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                this.this$0.trackErrorEvent(onErrorWithDisplayedMessage.invoke(th), source, th);
            }
        }, onComplete, onDispose);
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public void execute(Params params, final Function1<? super T, Unit> onSuccess, final Function1<? super Throwable, Unit> r4, final Function0<Unit> onComplete, Action onDispose) {
        Intrinsics.checkNotNullParameter(onSuccess, "");
        Intrinsics.checkNotNullParameter(r4, "");
        Intrinsics.checkNotNullParameter(onDispose, "");
        getDisposable().getAuthRequestContext(buildUseCase(params).subscribeOn(UseCaseSchedulers.getJobScheduler()).observeOn(UseCaseSchedulers.getPostScheduler()).doOnDispose(onDispose).subscribe(new Consumer() { // from class: id.dana.domain.core.usecase.BaseUseCaseWithAnalytics$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseUseCaseWithAnalytics.m2268execute$lambda2(Function1.this, obj);
            }
        }, new Consumer() { // from class: id.dana.domain.core.usecase.BaseUseCaseWithAnalytics$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseUseCaseWithAnalytics.m2269execute$lambda3(BaseUseCaseWithAnalytics.this, r4, (Throwable) obj);
            }
        }, new Action() { // from class: id.dana.domain.core.usecase.BaseUseCaseWithAnalytics$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Action
            public final void run() {
                BaseUseCaseWithAnalytics.m2270execute$lambda4(Function0.this, this);
            }
        }));
    }

    /* renamed from: execute$lambda-2 */
    public static final void m2268execute$lambda2(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "");
        function1.invoke(obj);
    }

    /* renamed from: execute$lambda-3 */
    public static final void m2269execute$lambda3(BaseUseCaseWithAnalytics baseUseCaseWithAnalytics, Function1 function1, Throwable th) {
        Intrinsics.checkNotNullParameter(baseUseCaseWithAnalytics, "");
        Intrinsics.checkNotNullParameter(function1, "");
        baseUseCaseWithAnalytics.getSubclassPath();
        Intrinsics.checkNotNullExpressionValue(th, "");
        function1.invoke(th);
        baseUseCaseWithAnalytics.dispose();
    }

    /* renamed from: execute$lambda-4 */
    public static final void m2270execute$lambda4(Function0 function0, BaseUseCaseWithAnalytics baseUseCaseWithAnalytics) {
        Intrinsics.checkNotNullParameter(baseUseCaseWithAnalytics, "");
        if (function0 != null) {
            function0.invoke();
        }
        baseUseCaseWithAnalytics.dispose();
    }
}
