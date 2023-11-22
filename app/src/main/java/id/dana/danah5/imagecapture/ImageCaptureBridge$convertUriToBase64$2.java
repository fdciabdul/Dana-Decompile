package id.dana.danah5.imagecapture;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import id.dana.danah5.imagecapture.model.ImageCaptureModel;
import id.dana.utils.BitmapUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
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
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danah5.imagecapture.ImageCaptureBridge$convertUriToBase64$2", f = "ImageCaptureBridge.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class ImageCaptureBridge$convertUriToBase64$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Uri $imageUri;
    int label;
    final /* synthetic */ ImageCaptureBridge this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCaptureBridge$convertUriToBase64$2(Uri uri, ImageCaptureBridge imageCaptureBridge, Continuation<? super ImageCaptureBridge$convertUriToBase64$2> continuation) {
        super(2, continuation);
        this.$imageUri = uri;
        this.this$0 = imageCaptureBridge;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageCaptureBridge$convertUriToBase64$2(this.$imageUri, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((ImageCaptureBridge$convertUriToBase64$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FragmentActivity fragmentActivity;
        ImageCaptureModel imageCaptureModel;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            Uri uri = this.$imageUri;
            fragmentActivity = this.this$0.activity;
            if (fragmentActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                fragmentActivity = null;
            }
            Bitmap PlaceComponentResult = BitmapUtil.PlaceComponentResult(uri, fragmentActivity);
            imageCaptureModel = this.this$0.imageCaptureModel;
            if (imageCaptureModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                imageCaptureModel = null;
            }
            Integer qualityLevel = imageCaptureModel.getQualityLevel();
            return BitmapUtil.MyBillsEntityDataFactory(PlaceComponentResult, qualityLevel != null ? qualityLevel.intValue() : 40);
        } catch (Exception e) {
            DanaLog.MyBillsEntityDataFactory("ImageCaptureBridge", e);
            return null;
        }
    }
}
