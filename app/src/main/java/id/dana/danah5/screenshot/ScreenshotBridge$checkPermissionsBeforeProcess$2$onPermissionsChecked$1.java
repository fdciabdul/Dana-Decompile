package id.dana.danah5.screenshot;

import android.app.Activity;
import android.graphics.Bitmap;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danah5.screenshot.ScreenshotBridge$checkPermissionsBeforeProcess$2$onPermissionsChecked$1", f = "ScreenshotBridge.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class ScreenshotBridge$checkPermissionsBeforeProcess$2$onPermissionsChecked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ BridgeCallback $callback;
    final /* synthetic */ JSONObject $jsonResult;
    final /* synthetic */ ScreenshotBridgeModel $params;
    int label;
    final /* synthetic */ ScreenshotBridge this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenshotBridge$checkPermissionsBeforeProcess$2$onPermissionsChecked$1(ScreenshotBridge screenshotBridge, Activity activity, BridgeCallback bridgeCallback, JSONObject jSONObject, ScreenshotBridgeModel screenshotBridgeModel, Bitmap bitmap, Continuation<? super ScreenshotBridge$checkPermissionsBeforeProcess$2$onPermissionsChecked$1> continuation) {
        super(2, continuation);
        this.this$0 = screenshotBridge;
        this.$activity = activity;
        this.$callback = bridgeCallback;
        this.$jsonResult = jSONObject;
        this.$params = screenshotBridgeModel;
        this.$bitmap = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ScreenshotBridge$checkPermissionsBeforeProcess$2$onPermissionsChecked$1(this.this$0, this.$activity, this.$callback, this.$jsonResult, this.$params, this.$bitmap, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ScreenshotBridge$checkPermissionsBeforeProcess$2$onPermissionsChecked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.handleSaveToGallery(this.$activity, this.$callback, this.$jsonResult, this.$params, this.$bitmap);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
