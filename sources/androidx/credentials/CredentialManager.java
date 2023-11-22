package androidx.credentials;

import android.app.PendingIntent;
import android.content.Context;
import android.os.CancellationSignal;
import androidx.credentials.PrepareGetCredentialResponse;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 '2\u00020\u0001:\u0001'J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J8\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f0\rH&J!\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0014H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J>\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00170\rH&J\b\u0010\u0018\u001a\u00020\u0019H'J!\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u001cH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ!\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0097@ø\u0001\u0000¢\u0006\u0002\u0010 J>\u0010!\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\"0\rH&J>\u0010!\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\"0\rH'J\u0019\u0010#\u001a\u00020$2\u0006\u0010\u0004\u001a\u00020\u001cH\u0097@ø\u0001\u0000¢\u0006\u0002\u0010%J6\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0\rH'ø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006(À\u0006\u0001"}, d2 = {"Landroidx/credentials/CredentialManager;", "", "clearCredentialState", "", "request", "Landroidx/credentials/ClearCredentialStateRequest;", "(Landroidx/credentials/ClearCredentialStateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCredentialStateAsync", "cancellationSignal", "Landroid/os/CancellationSignal;", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/credentials/CredentialManagerCallback;", "Ljava/lang/Void;", "Landroidx/credentials/exceptions/ClearCredentialException;", "createCredential", "Landroidx/credentials/CreateCredentialResponse;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Landroidx/credentials/CreateCredentialRequest;", "(Landroid/content/Context;Landroidx/credentials/CreateCredentialRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCredentialAsync", "Landroidx/credentials/exceptions/CreateCredentialException;", "createSettingsPendingIntent", "Landroid/app/PendingIntent;", "getCredential", "Landroidx/credentials/GetCredentialResponse;", "Landroidx/credentials/GetCredentialRequest;", "(Landroid/content/Context;Landroidx/credentials/GetCredentialRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pendingGetCredentialHandle", "Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "(Landroid/content/Context;Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCredentialAsync", "Landroidx/credentials/exceptions/GetCredentialException;", "prepareGetCredential", "Landroidx/credentials/PrepareGetCredentialResponse;", "(Landroidx/credentials/GetCredentialRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareGetCredentialAsync", "Companion", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface CredentialManager {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Object clearCredentialState(ClearCredentialStateRequest clearCredentialStateRequest, Continuation<? super Unit> continuation);

    void clearCredentialStateAsync(ClearCredentialStateRequest request, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<Void, ClearCredentialException> callback);

    Object createCredential(Context context, CreateCredentialRequest createCredentialRequest, Continuation<? super CreateCredentialResponse> continuation);

    void createCredentialAsync(Context context, CreateCredentialRequest request, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> callback);

    PendingIntent createSettingsPendingIntent();

    Object getCredential(Context context, GetCredentialRequest getCredentialRequest, Continuation<? super GetCredentialResponse> continuation);

    Object getCredential(Context context, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, Continuation<? super GetCredentialResponse> continuation);

    void getCredentialAsync(Context context, GetCredentialRequest request, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<GetCredentialResponse, GetCredentialException> callback);

    void getCredentialAsync(Context context, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<GetCredentialResponse, GetCredentialException> callback);

    Object prepareGetCredential(GetCredentialRequest getCredentialRequest, Continuation<? super PrepareGetCredentialResponse> continuation);

    void prepareGetCredentialAsync(GetCredentialRequest request, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<PrepareGetCredentialResponse, GetCredentialException> callback);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/credentials/CredentialManager$Companion;", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroidx/credentials/CredentialManager;", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(Landroid/content/Context;)Landroidx/credentials/CredentialManager;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @JvmStatic
        public final CredentialManager create(Context context) {
            Intrinsics.checkNotNullParameter(context, "");
            return new CredentialManagerImpl(context);
        }
    }

    /* renamed from: androidx.credentials.CredentialManager$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = CredentialManager.INSTANCE;
        }

        @JvmStatic
        public static CredentialManager create(Context context) {
            return CredentialManager.INSTANCE.create(context);
        }

        public static /* synthetic */ Object getCredential$suspendImpl(CredentialManager credentialManager, Context context, GetCredentialRequest getCredentialRequest, Continuation<? super GetCredentialResponse> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            final CancellationSignal cancellationSignal = new CancellationSignal();
            cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.credentials.CredentialManager$getCredential$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    cancellationSignal.cancel();
                }
            });
            credentialManager.getCredentialAsync(context, getCredentialRequest, cancellationSignal, new CredentialManager$$ExternalSyntheticLambda0(), new CredentialManagerCallback<GetCredentialResponse, GetCredentialException>() { // from class: androidx.credentials.CredentialManager$getCredential$2$callback$1
                @Override // androidx.credentials.CredentialManagerCallback
                public final void onResult(GetCredentialResponse result) {
                    Intrinsics.checkNotNullParameter(result, "");
                    CancellableContinuation<GetCredentialResponse> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(result));
                }

                @Override // androidx.credentials.CredentialManagerCallback
                public final void onError(GetCredentialException e) {
                    Intrinsics.checkNotNullParameter(e, "");
                    CancellableContinuation<GetCredentialResponse> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(e)));
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        public static /* synthetic */ Object getCredential$suspendImpl(CredentialManager credentialManager, Context context, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, Continuation<? super GetCredentialResponse> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            final CancellationSignal cancellationSignal = new CancellationSignal();
            cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.credentials.CredentialManager$getCredential$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    cancellationSignal.cancel();
                }
            });
            credentialManager.getCredentialAsync(context, pendingGetCredentialHandle, cancellationSignal, new CredentialManager$$ExternalSyntheticLambda0(), new CredentialManagerCallback<GetCredentialResponse, GetCredentialException>() { // from class: androidx.credentials.CredentialManager$getCredential$4$callback$1
                @Override // androidx.credentials.CredentialManagerCallback
                public final void onResult(GetCredentialResponse result) {
                    Intrinsics.checkNotNullParameter(result, "");
                    CancellableContinuation<GetCredentialResponse> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(result));
                }

                @Override // androidx.credentials.CredentialManagerCallback
                public final void onError(GetCredentialException e) {
                    Intrinsics.checkNotNullParameter(e, "");
                    CancellableContinuation<GetCredentialResponse> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(e)));
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        public static /* synthetic */ Object prepareGetCredential$suspendImpl(CredentialManager credentialManager, GetCredentialRequest getCredentialRequest, Continuation<? super PrepareGetCredentialResponse> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            final CancellationSignal cancellationSignal = new CancellationSignal();
            cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.credentials.CredentialManager$prepareGetCredential$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    cancellationSignal.cancel();
                }
            });
            credentialManager.prepareGetCredentialAsync(getCredentialRequest, cancellationSignal, new CredentialManager$$ExternalSyntheticLambda0(), new CredentialManagerCallback<PrepareGetCredentialResponse, GetCredentialException>() { // from class: androidx.credentials.CredentialManager$prepareGetCredential$2$callback$1
                @Override // androidx.credentials.CredentialManagerCallback
                public final void onResult(PrepareGetCredentialResponse result) {
                    Intrinsics.checkNotNullParameter(result, "");
                    CancellableContinuation<PrepareGetCredentialResponse> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(result));
                }

                @Override // androidx.credentials.CredentialManagerCallback
                public final void onError(GetCredentialException e) {
                    Intrinsics.checkNotNullParameter(e, "");
                    CancellableContinuation<PrepareGetCredentialResponse> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(e)));
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        public static /* synthetic */ Object createCredential$suspendImpl(CredentialManager credentialManager, Context context, CreateCredentialRequest createCredentialRequest, Continuation<? super CreateCredentialResponse> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            final CancellationSignal cancellationSignal = new CancellationSignal();
            cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.credentials.CredentialManager$createCredential$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    cancellationSignal.cancel();
                }
            });
            credentialManager.createCredentialAsync(context, createCredentialRequest, cancellationSignal, new CredentialManager$$ExternalSyntheticLambda0(), new CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException>() { // from class: androidx.credentials.CredentialManager$createCredential$2$callback$1
                @Override // androidx.credentials.CredentialManagerCallback
                public final void onResult(CreateCredentialResponse result) {
                    Intrinsics.checkNotNullParameter(result, "");
                    CancellableContinuation<CreateCredentialResponse> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(result));
                }

                @Override // androidx.credentials.CredentialManagerCallback
                public final void onError(CreateCredentialException e) {
                    Intrinsics.checkNotNullParameter(e, "");
                    CancellableContinuation<CreateCredentialResponse> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(e)));
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        public static /* synthetic */ Object clearCredentialState$suspendImpl(CredentialManager credentialManager, ClearCredentialStateRequest clearCredentialStateRequest, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            final CancellationSignal cancellationSignal = new CancellationSignal();
            cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.credentials.CredentialManager$clearCredentialState$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    cancellationSignal.cancel();
                }
            });
            credentialManager.clearCredentialStateAsync(clearCredentialStateRequest, cancellationSignal, new CredentialManager$$ExternalSyntheticLambda0(), new CredentialManagerCallback<Void, ClearCredentialException>() { // from class: androidx.credentials.CredentialManager$clearCredentialState$2$callback$1
                @Override // androidx.credentials.CredentialManagerCallback
                public final void onResult(Void result) {
                    CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(Unit.INSTANCE));
                }

                @Override // androidx.credentials.CredentialManagerCallback
                public final void onError(ClearCredentialException e) {
                    Intrinsics.checkNotNullParameter(e, "");
                    CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(e)));
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        }
    }
}
