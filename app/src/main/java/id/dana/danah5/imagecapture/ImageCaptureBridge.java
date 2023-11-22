package id.dana.danah5.imagecapture;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.view.LifecycleOwnerKt;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.anggrayudi.storage.file.DocumentFileCompat;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.imagecapture.model.ImageCaptureModel;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.app.bridge.imagepicker.ImagePickerBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.promocenter.model.PromoActionType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 J9\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/danah5/imagecapture/ImageCaptureBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Lcom/alibaba/ariver/app/api/Page;", "page", "", "event", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", BridgeName.CAPTURE, "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Landroid/net/Uri;", "imageUri", "convertUriToBase64", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroidx/fragment/app/FragmentActivity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/danah5/imagecapture/model/ImageCaptureModel;", "imageCaptureModel", "Lid/dana/danah5/imagecapture/model/ImageCaptureModel;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ImageCaptureBridge extends BaseBridge {
    public static final int DEFAULT_QUALITY_LEVEL = 40;
    private static final String IMAGE_CAPTURE_DATA_KEY = "data";
    private static final int IMAGE_CAPTURE_REQUEST_CODE = 99;
    private static final String TAG = "ImageCaptureBridge";
    private FragmentActivity activity;
    private BridgeCallback bridgeCallback;
    private ImageCaptureModel imageCaptureModel;

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void capture(@BindingNode(Page.class) Page page, @BindingParam(name = {"event"}) String event, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback) {
        Object obj;
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        FragmentActivity fragmentActivity = null;
        FragmentActivity fragmentActivity2 = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        if (fragmentActivity2 == null) {
            return;
        }
        this.activity = fragmentActivity2;
        if (fragmentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragmentActivity2 = null;
        }
        if (DocumentFileCompat.BuiltInFictitiousFunctionClassFactory(fragmentActivity2, PromoActionType.PRIMARY) <= 104857600) {
            bridgeCallback.sendJSONResponse(ImagePickerBridge.INSTANCE.getErrorResult("GENERAL_ERROR"));
            return;
        }
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<ImageCaptureModel>() { // from class: id.dana.danah5.imagecapture.ImageCaptureBridge$capture$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
            obj = null;
        }
        ImageCaptureModel imageCaptureModel = (ImageCaptureModel) obj;
        if (imageCaptureModel == null) {
            return;
        }
        this.imageCaptureModel = imageCaptureModel;
        this.bridgeCallback = bridgeCallback;
        FragmentActivity fragmentActivity3 = this.activity;
        if (fragmentActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragmentActivity3 = null;
        }
        Intent intent = new Intent(fragmentActivity3, ImageCaptureActivity.class);
        ImageCaptureModel imageCaptureModel2 = this.imageCaptureModel;
        if (imageCaptureModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            imageCaptureModel2 = null;
        }
        intent.putExtra(ImageCaptureActivity.IMAGE_CAPTURE_MODEL_EXTRA, imageCaptureModel2);
        FragmentActivity fragmentActivity4 = this.activity;
        if (fragmentActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            fragmentActivity = fragmentActivity4;
        }
        startActivityForResult(fragmentActivity, intent, 99);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri uri;
        if (!(requestCode == 99 && resultCode == -1) || data == null || (uri = (Uri) data.getParcelableExtra(ImageCaptureActivity.IMAGE_CAPTURE_URI_EXTRA)) == null) {
            return;
        }
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragmentActivity = null;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(fragmentActivity), null, null, new ImageCaptureBridge$onActivityResult$1$1(this, uri, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object convertUriToBase64(Uri uri, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ImageCaptureBridge$convertUriToBase64$2(uri, this, null), continuation);
    }
}
