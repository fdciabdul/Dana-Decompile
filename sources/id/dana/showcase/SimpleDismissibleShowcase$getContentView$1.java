package id.dana.showcase;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class SimpleDismissibleShowcase$getContentView$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleDismissibleShowcase$getContentView$1(Object obj) {
        super(0, obj, SimpleDismissibleShowcase.class, "PlaceComponentResult", "PlaceComponentResult()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((SimpleDismissibleShowcase) this.receiver).PlaceComponentResult();
    }
}
