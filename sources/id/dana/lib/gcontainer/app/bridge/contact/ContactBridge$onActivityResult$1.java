package id.dana.lib.gcontainer.app.bridge.contact;

import android.net.Uri;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import id.dana.lib.gcontainer.extension.CoroutineExtKt;
import id.dana.lib.logger.DANALog;
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

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "id.dana.lib.gcontainer.app.bridge.contact.ContactBridge$onActivityResult$1", f = "ContactBridge.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class ContactBridge$onActivityResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $uri;
    Object L$0;
    int label;
    final /* synthetic */ ContactBridge this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactBridge$onActivityResult$1(Uri uri, ContactBridge contactBridge, Continuation<? super ContactBridge$onActivityResult$1> continuation) {
        super(2, continuation);
        this.$uri = uri;
        this.this$0 = contactBridge;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ContactBridge$onActivityResult$1(this.$uri, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContactBridge$onActivityResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BridgeCallback bridgeCallback;
        JSONObject createSuccessResult;
        BridgeCallback bridgeCallback2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DANALog.KClassImpl$Data$declaredNonStaticMembers$2("ContactBridge", Intrinsics.stringPlus("data: ", this.$uri));
                bridgeCallback = this.this$0.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                createSuccessResult = this.this$0.createSuccessResult(this.$uri);
                this.L$0 = bridgeCallback;
                this.label = 1;
                Object await = CoroutineExtKt.await(createSuccessResult, this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bridgeCallback2 = bridgeCallback;
                obj = await;
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                bridgeCallback2 = (BridgeCallback) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            bridgeCallback2.sendJSONResponse((JSONObject) obj);
        } catch (Exception e) {
            DANALog.PlaceComponentResult("ContactBridge", "onReceiveMessageEvent", e);
            this.this$0.sendFailResult();
        }
        return Unit.INSTANCE;
    }
}
