package androidx.credentials.playservices.controllers;

import androidx.credentials.CredentialManagerCallback;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u0000\"\b\b\u0003\u0010\u0004*\u00020\u0000\"\b\b\u0004\u0010\u0005*\u00020\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "T1", "T2", "R2", "R1", "E1", "", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
final class CredentialProviderController$maybeReportErrorFromResultReceiver$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CredentialManagerCallback<R1, E1> $$callback;
    final /* synthetic */ E1 $$exception;
    final /* synthetic */ Executor $$executor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialProviderController$maybeReportErrorFromResultReceiver$1(Executor executor, CredentialManagerCallback<R1, E1> credentialManagerCallback, E1 e1) {
        super(0);
        this.$$executor = executor;
        this.$$callback = credentialManagerCallback;
        this.$$exception = e1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialManagerCallback credentialManagerCallback, Object obj) {
        Intrinsics.checkNotNullParameter(credentialManagerCallback, "");
        Intrinsics.checkNotNullParameter(obj, "");
        credentialManagerCallback.onError(obj);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Executor executor = this.$$executor;
        final CredentialManagerCallback<R1, E1> credentialManagerCallback = this.$$callback;
        final E1 e1 = this.$$exception;
        executor.execute(new Runnable() { // from class: androidx.credentials.playservices.controllers.CredentialProviderController$maybeReportErrorFromResultReceiver$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CredentialProviderController$maybeReportErrorFromResultReceiver$1.invoke$lambda$0(CredentialManagerCallback.this, e1);
            }
        });
    }
}
