package androidx.window.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000 \u0010*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0003\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\u0003\u0010\bJ8\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0019\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\b\u000bH&¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Landroidx/window/core/SpecificationComputer;", "", "T", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/Object;", "p0", "", "p1", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "getAuthRequestContext", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Landroidx/window/core/SpecificationComputer;", "<init>", "()V", "Companion", "VerificationMode"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class SpecificationComputer<T> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Landroidx/window/core/SpecificationComputer$VerificationMode;", "", "<init>", "(Ljava/lang/String;I)V", "STRICT", "LOG", "QUIET"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public enum VerificationMode {
        STRICT,
        LOG,
        QUIET
    }

    public abstract T BuiltInFictitiousFunctionClassFactory();

    public abstract SpecificationComputer<T> getAuthRequestContext(String p0, Function1<? super T, Boolean> p1);

    /* JADX INFO: Access modifiers changed from: protected */
    public static String BuiltInFictitiousFunctionClassFactory(Object p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        StringBuilder sb = new StringBuilder();
        sb.append(p1);
        sb.append(" value: ");
        sb.append(p0);
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/window/core/SpecificationComputer$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ SpecificationComputer MyBillsEntityDataFactory(Object obj, String str, VerificationMode verificationMode) {
            AndroidLogger androidLogger = AndroidLogger.INSTANCE;
            Intrinsics.checkNotNullParameter(obj, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(verificationMode, "");
            Intrinsics.checkNotNullParameter(androidLogger, "");
            return new ValidSpecification(obj, str, verificationMode, androidLogger);
        }
    }
}
