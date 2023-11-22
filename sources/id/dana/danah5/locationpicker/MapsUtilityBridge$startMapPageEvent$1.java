package id.dana.danah5.locationpicker;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.ariver.app.api.Page;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danah5.locationpicker.MapsUtilityBridge$startMapPageEvent$1", f = "MapsUtilityBridge.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class MapsUtilityBridge$startMapPageEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LatLng $initialLatLng;
    final /* synthetic */ Page $page;
    int label;
    final /* synthetic */ MapsUtilityBridge this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapsUtilityBridge$startMapPageEvent$1(Page page, LatLng latLng, MapsUtilityBridge mapsUtilityBridge, Continuation<? super MapsUtilityBridge$startMapPageEvent$1> continuation) {
        super(2, continuation);
        this.$page = page;
        this.$initialLatLng = latLng;
        this.this$0 = mapsUtilityBridge;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MapsUtilityBridge$startMapPageEvent$1(this.$page, this.$initialLatLng, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MapsUtilityBridge$startMapPageEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Activity activity = BridgeExtensionExtKt.getActivity(this.$page);
            if (activity != null) {
                LatLng latLng = this.$initialLatLng;
                MapsUtilityBridge mapsUtilityBridge = this.this$0;
                Intent putExtra = new Intent(activity, MapPageActivity.class).putExtra(MapPageActivity.INITIAL_LOCATION, latLng);
                Intrinsics.checkNotNullExpressionValue(putExtra, "");
                mapsUtilityBridge.startActivityForResult(activity, putExtra, 200);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
