package id.dana.danah5.imagecapture;

import android.net.Uri;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danah5.imagecapture.ImageCaptureBridge$onActivityResult$1$1", f = "ImageCaptureBridge.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class ImageCaptureBridge$onActivityResult$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $imageUri;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ImageCaptureBridge this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCaptureBridge$onActivityResult$1$1(ImageCaptureBridge imageCaptureBridge, Uri uri, Continuation<? super ImageCaptureBridge$onActivityResult$1$1> continuation) {
        super(2, continuation);
        this.this$0 = imageCaptureBridge;
        this.$imageUri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageCaptureBridge$onActivityResult$1$1(this.this$0, this.$imageUri, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ImageCaptureBridge$onActivityResult$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BridgeCallback bridgeCallback;
        Object convertUriToBase64;
        BridgeCallback bridgeCallback2;
        JSONObject jSONObject;
        Map map;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        String str = "data";
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            bridgeCallback = this.this$0.bridgeCallback;
            if (bridgeCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                bridgeCallback = null;
            }
            ImageCaptureBridge imageCaptureBridge = this.this$0;
            Uri uri = this.$imageUri;
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = jSONObject2;
            jSONObject3.put((JSONObject) "success", (String) Boxing.boxBoolean(true));
            Intrinsics.checkNotNullExpressionValue(uri, "");
            this.L$0 = jSONObject2;
            this.L$1 = "data";
            this.L$2 = jSONObject3;
            this.L$3 = bridgeCallback;
            this.label = 1;
            convertUriToBase64 = imageCaptureBridge.convertUriToBase64(uri, this);
            if (convertUriToBase64 == coroutine_suspended) {
                return coroutine_suspended;
            }
            bridgeCallback2 = bridgeCallback;
            obj = convertUriToBase64;
            jSONObject = jSONObject2;
            map = jSONObject3;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            bridgeCallback2 = (BridgeCallback) this.L$3;
            map = (Map) this.L$2;
            str = (String) this.L$1;
            jSONObject = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        map.put(str, obj);
        bridgeCallback2.sendBridgeResponse(new BridgeResponse(jSONObject));
        return Unit.INSTANCE;
    }
}
