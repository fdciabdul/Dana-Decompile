package androidx.credentials;

import android.credentials.PrepareGetCredentialResponse;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0003\"#$Bc\b\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010j\u0004\u0018\u0001`\u0016\u0012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u0012\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nj\u0004\u0018\u0001`\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004R+\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nj\u0004\u0018\u0001`\u000b8\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010j\u0004\u0018\u0001`\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010j\u0004\u0018\u0001`\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f"}, d2 = {"Landroidx/credentials/PrepareGetCredentialResponse;", "", "", "hasAuthenticationResults", "()Z", "", "credentialType", "hasCredentialResults", "(Ljava/lang/String;)Z", "hasRemoteResults", "Lkotlin/Function1;", "Landroidx/credentials/HasCredentialResultsDelegate;", "credentialTypeDelegate", "Lkotlin/jvm/functions/Function1;", "getCredentialTypeDelegate", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/Function0;", "Landroidx/credentials/HasAuthenticationResultsDelegate;", "hasAuthResultsDelegate", "Lkotlin/jvm/functions/Function0;", "getHasAuthResultsDelegate", "()Lkotlin/jvm/functions/Function0;", "Landroidx/credentials/HasRemoteResultsDelegate;", "hasRemoteResultsDelegate", "getHasRemoteResultsDelegate", "isNullHandlesForTest", "Z", "Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "pendingGetCredentialHandle", "Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "getPendingGetCredentialHandle", "()Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "<init>", "(Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Z)V", "Builder", "PendingGetCredentialHandle", "TestBuilder"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PrepareGetCredentialResponse {
    private final Function1<String, Boolean> credentialTypeDelegate;
    private final Function0<Boolean> hasAuthResultsDelegate;
    private final Function0<Boolean> hasRemoteResultsDelegate;
    private final boolean isNullHandlesForTest;
    private final PendingGetCredentialHandle pendingGetCredentialHandle;

    public /* synthetic */ PrepareGetCredentialResponse(PendingGetCredentialHandle pendingGetCredentialHandle, Function0 function0, Function0 function02, Function1 function1, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(pendingGetCredentialHandle, function0, function02, function1, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PrepareGetCredentialResponse(PendingGetCredentialHandle pendingGetCredentialHandle, Function0<Boolean> function0, Function0<Boolean> function02, Function1<? super String, Boolean> function1, boolean z) {
        this.pendingGetCredentialHandle = pendingGetCredentialHandle;
        this.hasRemoteResultsDelegate = function0;
        this.hasAuthResultsDelegate = function02;
        this.credentialTypeDelegate = function1;
        this.isNullHandlesForTest = z;
        if (Build.VERSION.SDK_INT < 34 || z) {
            return;
        }
        Intrinsics.checkNotNull(pendingGetCredentialHandle);
    }

    @JvmName(name = "getPendingGetCredentialHandle")
    public final PendingGetCredentialHandle getPendingGetCredentialHandle() {
        return this.pendingGetCredentialHandle;
    }

    @JvmName(name = "getHasRemoteResultsDelegate")
    public final Function0<Boolean> getHasRemoteResultsDelegate() {
        return this.hasRemoteResultsDelegate;
    }

    @JvmName(name = "getHasAuthResultsDelegate")
    public final Function0<Boolean> getHasAuthResultsDelegate() {
        return this.hasAuthResultsDelegate;
    }

    @JvmName(name = "getCredentialTypeDelegate")
    public final Function1<String, Boolean> getCredentialTypeDelegate() {
        return this.credentialTypeDelegate;
    }

    @JvmName(name = "isNullHandlesForTest")
    /* renamed from: isNullHandlesForTest  reason: from getter */
    public final boolean getIsNullHandlesForTest() {
        return this.isNullHandlesForTest;
    }

    public final boolean hasCredentialResults(String credentialType) {
        Intrinsics.checkNotNullParameter(credentialType, "");
        Function1<String, Boolean> function1 = this.credentialTypeDelegate;
        if (function1 != null) {
            return function1.invoke(credentialType).booleanValue();
        }
        return false;
    }

    public final boolean hasAuthenticationResults() {
        Function0<Boolean> function0 = this.hasAuthResultsDelegate;
        if (function0 != null) {
            return function0.invoke().booleanValue();
        }
        return false;
    }

    public final boolean hasRemoteResults() {
        Function0<Boolean> function0 = this.hasRemoteResultsDelegate;
        if (function0 != null) {
            return function0.invoke().booleanValue();
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "", "Landroid/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "frameworkHandle", "Landroid/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "getFrameworkHandle", "()Landroid/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "<init>", "(Landroid/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class PendingGetCredentialHandle {
        private final PrepareGetCredentialResponse.PendingGetCredentialHandle frameworkHandle;

        public PendingGetCredentialHandle(PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle) {
            this.frameworkHandle = pendingGetCredentialHandle;
            if (Build.VERSION.SDK_INT >= 34) {
                Intrinsics.checkNotNull(pendingGetCredentialHandle);
            }
        }

        @JvmName(name = "getFrameworkHandle")
        public final PrepareGetCredentialResponse.PendingGetCredentialHandle getFrameworkHandle() {
            return this.frameworkHandle;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0007J\u0017\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017j\u0004\u0018\u0001`\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR*\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001bj\u0004\u0018\u0001`\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017j\u0004\u0018\u0001`\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001aR\u0018\u0010!\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Landroidx/credentials/PrepareGetCredentialResponse$Builder;", "", "Landroidx/credentials/PrepareGetCredentialResponse;", "build", "()Landroidx/credentials/PrepareGetCredentialResponse;", "", "hasAuthenticationResults", "()Z", "", "credentialType", "hasCredentialType", "(Ljava/lang/String;)Z", "hasRemoteResults", "Landroid/credentials/PrepareGetCredentialResponse;", "resp", "setFrameworkResponse", "(Landroid/credentials/PrepareGetCredentialResponse;)Landroidx/credentials/PrepareGetCredentialResponse$Builder;", "Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "handle", "setPendingGetCredentialHandle", "(Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;)Landroidx/credentials/PrepareGetCredentialResponse$Builder;", "frameworkResponse", "Landroid/credentials/PrepareGetCredentialResponse;", "Lkotlin/Function0;", "Landroidx/credentials/HasAuthenticationResultsDelegate;", "hasAuthResultsDelegate", "Lkotlin/jvm/functions/Function0;", "Lkotlin/Function1;", "Landroidx/credentials/HasCredentialResultsDelegate;", "hasCredentialResultsDelegate", "Lkotlin/jvm/functions/Function1;", "Landroidx/credentials/HasRemoteResultsDelegate;", "hasRemoteResultsDelegate", "pendingGetCredentialHandle", "Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Builder {
        private android.credentials.PrepareGetCredentialResponse frameworkResponse;
        private Function0<Boolean> hasAuthResultsDelegate;
        private Function1<? super String, Boolean> hasCredentialResultsDelegate;
        private Function0<Boolean> hasRemoteResultsDelegate;
        private PendingGetCredentialHandle pendingGetCredentialHandle;

        public final Builder setFrameworkResponse(android.credentials.PrepareGetCredentialResponse resp) {
            this.frameworkResponse = resp;
            if (resp != null) {
                this.hasCredentialResultsDelegate = new PrepareGetCredentialResponse$Builder$setFrameworkResponse$1(this);
                this.hasAuthResultsDelegate = new PrepareGetCredentialResponse$Builder$setFrameworkResponse$2(this);
                this.hasRemoteResultsDelegate = new PrepareGetCredentialResponse$Builder$setFrameworkResponse$3(this);
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean hasCredentialType(String credentialType) {
            android.credentials.PrepareGetCredentialResponse prepareGetCredentialResponse = this.frameworkResponse;
            Intrinsics.checkNotNull(prepareGetCredentialResponse);
            return prepareGetCredentialResponse.hasCredentialResults(credentialType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean hasAuthenticationResults() {
            android.credentials.PrepareGetCredentialResponse prepareGetCredentialResponse = this.frameworkResponse;
            Intrinsics.checkNotNull(prepareGetCredentialResponse);
            return prepareGetCredentialResponse.hasAuthenticationResults();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean hasRemoteResults() {
            android.credentials.PrepareGetCredentialResponse prepareGetCredentialResponse = this.frameworkResponse;
            Intrinsics.checkNotNull(prepareGetCredentialResponse);
            return prepareGetCredentialResponse.hasRemoteResults();
        }

        public final Builder setPendingGetCredentialHandle(PendingGetCredentialHandle handle) {
            Intrinsics.checkNotNullParameter(handle, "");
            this.pendingGetCredentialHandle = handle;
            return this;
        }

        public final PrepareGetCredentialResponse build() {
            return new PrepareGetCredentialResponse(this.pendingGetCredentialHandle, this.hasRemoteResultsDelegate, this.hasAuthResultsDelegate, this.hasCredentialResultsDelegate, false, null);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\n\u001a\u00020\u00002\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00002\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00070\fj\u0002`\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00002\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00070\fj\u0002`\u0010¢\u0006\u0004\b\u0011\u0010\u000fR$\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fj\u0004\u0018\u0001`\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fj\u0004\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013"}, d2 = {"Landroidx/credentials/PrepareGetCredentialResponse$TestBuilder;", "", "Landroidx/credentials/PrepareGetCredentialResponse;", "build", "()Landroidx/credentials/PrepareGetCredentialResponse;", "Lkotlin/Function1;", "", "", "Landroidx/credentials/HasCredentialResultsDelegate;", "handler", "setCredentialTypeDelegate", "(Lkotlin/jvm/functions/Function1;)Landroidx/credentials/PrepareGetCredentialResponse$TestBuilder;", "Lkotlin/Function0;", "Landroidx/credentials/HasAuthenticationResultsDelegate;", "setHasAuthResultsDelegate", "(Lkotlin/jvm/functions/Function0;)Landroidx/credentials/PrepareGetCredentialResponse$TestBuilder;", "Landroidx/credentials/HasRemoteResultsDelegate;", "setHasRemoteResultsDelegate", "hasAuthResultsDelegate", "Lkotlin/jvm/functions/Function0;", "hasCredentialResultsDelegate", "Lkotlin/jvm/functions/Function1;", "hasRemoteResultsDelegate", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class TestBuilder {
        private Function0<Boolean> hasAuthResultsDelegate;
        private Function1<? super String, Boolean> hasCredentialResultsDelegate;
        private Function0<Boolean> hasRemoteResultsDelegate;

        public final TestBuilder setCredentialTypeDelegate(Function1<? super String, Boolean> handler) {
            Intrinsics.checkNotNullParameter(handler, "");
            this.hasCredentialResultsDelegate = handler;
            return this;
        }

        public final TestBuilder setHasAuthResultsDelegate(Function0<Boolean> handler) {
            Intrinsics.checkNotNullParameter(handler, "");
            this.hasAuthResultsDelegate = handler;
            return this;
        }

        public final TestBuilder setHasRemoteResultsDelegate(Function0<Boolean> handler) {
            Intrinsics.checkNotNullParameter(handler, "");
            this.hasRemoteResultsDelegate = handler;
            return this;
        }

        public final PrepareGetCredentialResponse build() {
            return new PrepareGetCredentialResponse(null, this.hasRemoteResultsDelegate, this.hasAuthResultsDelegate, this.hasCredentialResultsDelegate, true, null);
        }
    }
}
