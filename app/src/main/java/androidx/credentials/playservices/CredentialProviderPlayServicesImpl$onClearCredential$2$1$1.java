package androidx.credentials.playservices;

import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.ClearCredentialUnknownException;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CredentialProviderPlayServicesImpl$onClearCredential$2$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CredentialManagerCallback<Void, ClearCredentialException> $$callback;
    final /* synthetic */ Exception $$e;
    final /* synthetic */ Executor $$executor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialProviderPlayServicesImpl$onClearCredential$2$1$1(Exception exc, Executor executor, CredentialManagerCallback<Void, ClearCredentialException> credentialManagerCallback) {
        super(0);
        this.$$e = exc;
        this.$$executor = executor;
        this.$$callback = credentialManagerCallback;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StringBuilder sb = new StringBuilder();
        sb.append("During clear credential sign out failed with ");
        sb.append(this.$$e);
        InstrumentInjector.log_w("PlayServicesImpl", sb.toString());
        Executor executor = this.$$executor;
        final CredentialManagerCallback<Void, ClearCredentialException> credentialManagerCallback = this.$$callback;
        final Exception exc = this.$$e;
        executor.execute(new Runnable() { // from class: androidx.credentials.playservices.CredentialProviderPlayServicesImpl$onClearCredential$2$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CredentialProviderPlayServicesImpl$onClearCredential$2$1$1.invoke$lambda$0(CredentialManagerCallback.this, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialManagerCallback credentialManagerCallback, Exception exc) {
        Intrinsics.checkNotNullParameter(credentialManagerCallback, "");
        Intrinsics.checkNotNullParameter(exc, "");
        credentialManagerCallback.onError(new ClearCredentialUnknownException(exc.getMessage()));
    }
}
