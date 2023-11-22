package id.dana.drawable;

import androidx.core.content.ContextCompat;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.R;
import id.dana.extension.view.ActivityExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NewNearbyMeActivity$setMyLocation$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NewNearbyMeActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewNearbyMeActivity$setMyLocation$1(NewNearbyMeActivity newNearbyMeActivity) {
        super(0);
        this.this$0 = newNearbyMeActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        NewNearbyMeActivity newNearbyMeActivity = this.this$0;
        newNearbyMeActivity.KClassImpl$Data$declaredNonStaticMembers$2 = ContextCompat.PlaceComponentResult(newNearbyMeActivity, (int) R.drawable.ic_avatar_grey_default);
        final NewNearbyMeActivity newNearbyMeActivity2 = this.this$0;
        ActivityExtKt.PlaceComponentResult(newNearbyMeActivity2, new Runnable() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$setMyLocation$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NewNearbyMeActivity$setMyLocation$1.m2743invoke$lambda0(NewNearbyMeActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2743invoke$lambda0(NewNearbyMeActivity newNearbyMeActivity) {
        Intrinsics.checkNotNullParameter(newNearbyMeActivity, "");
        newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda4();
    }
}
