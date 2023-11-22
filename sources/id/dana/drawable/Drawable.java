package id.dana.drawable;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.extension.view.ActivityExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/graphics/drawable/Drawable;", "it", "", BridgeDSL.INVOKE, "(Landroid/graphics/drawable/Drawable;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: id.dana.nearbyrevamp.NewNearbyMeActivity$setMyLocation$2  reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class Drawable extends Lambda implements Function1<android.graphics.drawable.Drawable, Unit> {
    final /* synthetic */ NewNearbyMeActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Drawable(NewNearbyMeActivity newNearbyMeActivity) {
        super(1);
        this.this$0 = newNearbyMeActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(android.graphics.drawable.Drawable drawable) {
        invoke2(drawable);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(android.graphics.drawable.Drawable drawable) {
        this.this$0.KClassImpl$Data$declaredNonStaticMembers$2 = drawable;
        final NewNearbyMeActivity newNearbyMeActivity = this.this$0;
        ActivityExtKt.PlaceComponentResult(newNearbyMeActivity, new Runnable() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$setMyLocation$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Drawable.m2745invoke$lambda0(NewNearbyMeActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2745invoke$lambda0(NewNearbyMeActivity newNearbyMeActivity) {
        Intrinsics.checkNotNullParameter(newNearbyMeActivity, "");
        newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda4();
    }
}
