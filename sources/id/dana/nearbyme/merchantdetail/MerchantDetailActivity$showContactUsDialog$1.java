package id.dana.nearbyme.merchantdetail;

import android.content.Context;
import id.dana.extension.ContextExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class MerchantDetailActivity$showContactUsDialog$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MerchantDetailActivity$showContactUsDialog$1(Object obj) {
        super(1, obj, ContextExtKt.class, "launchPhoneCall", "launchPhoneCall(Landroid/content/Context;Ljava/lang/String;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        ContextExtKt.PlaceComponentResult((Context) this.receiver, str);
    }
}
