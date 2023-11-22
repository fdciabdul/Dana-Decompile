package androidx.window.core;

import androidx.window.core.SpecificationComputer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B'\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J8\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0019\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000eX\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0011\u0010\u0004\u001a\u00028\u0000X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015"}, d2 = {"Landroidx/window/core/ValidSpecification;", "", "T", "Landroidx/window/core/SpecificationComputer;", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/Object;", "", "p0", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "p1", "getAuthRequestContext", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Landroidx/window/core/SpecificationComputer;", "Landroidx/window/core/Logger;", "Landroidx/window/core/Logger;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/Object;", "Landroidx/window/core/SpecificationComputer$VerificationMode;", "Landroidx/window/core/SpecificationComputer$VerificationMode;", "p2", "p3", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/window/core/SpecificationComputer$VerificationMode;Landroidx/window/core/Logger;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ValidSpecification<T> extends SpecificationComputer<T> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Logger MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final SpecificationComputer.VerificationMode getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final T BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    public ValidSpecification(T t, String str, SpecificationComputer.VerificationMode verificationMode, Logger logger) {
        Intrinsics.checkNotNullParameter(t, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(verificationMode, "");
        Intrinsics.checkNotNullParameter(logger, "");
        this.BuiltInFictitiousFunctionClassFactory = t;
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = verificationMode;
        this.MyBillsEntityDataFactory = logger;
    }

    @Override // androidx.window.core.SpecificationComputer
    public final SpecificationComputer<T> getAuthRequestContext(String p0, Function1<? super T, Boolean> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (p1.invoke((T) this.BuiltInFictitiousFunctionClassFactory).booleanValue()) {
            return this;
        }
        return new FailedSpecification(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, p0, this.MyBillsEntityDataFactory, this.getAuthRequestContext);
    }

    @Override // androidx.window.core.SpecificationComputer
    public final T BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
