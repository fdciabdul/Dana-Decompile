package id.dana.danah5.screenshot;

import android.app.Activity;
import android.content.Context;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danah5.screenshot.ScreenshotBridge$handleSnapshot$1", f = "ScreenshotBridge.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class ScreenshotBridge$handleSnapshot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ BridgeCallback $callback;
    final /* synthetic */ ScreenshotBridgeModel $params;
    int label;
    final /* synthetic */ ScreenshotBridge this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenshotBridge$handleSnapshot$1(ScreenshotBridgeModel screenshotBridgeModel, Bitmap bitmap, ScreenshotBridge screenshotBridge, BridgeCallback bridgeCallback, Activity activity, Continuation<? super ScreenshotBridge$handleSnapshot$1> continuation) {
        super(2, continuation);
        this.$params = screenshotBridgeModel;
        this.$bitmap = bitmap;
        this.this$0 = screenshotBridge;
        this.$callback = bridgeCallback;
        this.$activity = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ScreenshotBridge$handleSnapshot$1(this.$params, this.$bitmap, this.this$0, this.$callback, this.$activity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ScreenshotBridge$handleSnapshot$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Bitmap createNewBitmap;
        CoroutineScope uiScope;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ScreenshotBridgeModel screenshotBridgeModel = this.$params;
            screenshotBridgeModel.setMaxWidth(screenshotBridgeModel.getMaxWidth() < 0 ? this.$bitmap.getWidth() : this.$params.getMaxWidth());
            ScreenshotBridgeModel screenshotBridgeModel2 = this.$params;
            screenshotBridgeModel2.setMaxHeight(screenshotBridgeModel2.getMaxHeight() < 0 ? this.$bitmap.getHeight() : this.$params.getMaxHeight());
            createNewBitmap = this.this$0.createNewBitmap(this.$params, this.$bitmap, this.$callback);
            if (createNewBitmap == null) {
                return Unit.INSTANCE;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.$params.isSaveToGallery()) {
                uiScope = this.this$0.getUiScope();
                BuildersKt__Builders_commonKt.launch$default(uiScope, null, null, new AnonymousClass1(this.this$0, this.$activity, this.$callback, jSONObject, this.$params, createNewBitmap, null), 3, null);
            } else {
                ScreenshotBridge screenshotBridge = this.this$0;
                Context applicationContext = this.$activity.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "");
                screenshotBridge.handleSave(applicationContext, this.$callback, jSONObject, this.$params, createNewBitmap);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.danah5.screenshot.ScreenshotBridge$handleSnapshot$1$1", f = "ScreenshotBridge.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.danah5.screenshot.ScreenshotBridge$handleSnapshot$1$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ BridgeCallback $callback;
        final /* synthetic */ Bitmap $newBitmap;
        final /* synthetic */ ScreenshotBridgeModel $params;
        final /* synthetic */ JSONObject $result;
        int label;
        final /* synthetic */ ScreenshotBridge this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScreenshotBridge screenshotBridge, Activity activity, BridgeCallback bridgeCallback, JSONObject jSONObject, ScreenshotBridgeModel screenshotBridgeModel, Bitmap bitmap, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = screenshotBridge;
            this.$activity = activity;
            this.$callback = bridgeCallback;
            this.$result = jSONObject;
            this.$params = screenshotBridgeModel;
            this.$newBitmap = bitmap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$activity, this.$callback, this.$result, this.$params, this.$newBitmap, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.checkPermissionsBeforeProcess(this.$activity, this.$callback, this.$result, this.$params, this.$newBitmap);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
