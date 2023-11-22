package id.dana.danah5.imagecapture;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.view.result.contract.ActivityResultContract;
import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/danah5/imagecapture/GalleryResultContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "Landroid/content/Context;", HummerConstants.CONTEXT, "input", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "", "resultCode", "intent", "parseResult", "(ILandroid/content/Intent;)Landroid/net/Uri;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GalleryResultContract extends ActivityResultContract<String, Uri> {
    @Override // androidx.view.result.contract.ActivityResultContract
    public final Intent createIntent(Context context, String input) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(input, "");
        Intent dataAndType = new Intent("android.intent.action.PICK").setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, input);
        Intrinsics.checkNotNullExpressionValue(dataAndType, "");
        return dataAndType;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.view.result.contract.ActivityResultContract
    public final Uri parseResult(int resultCode, Intent intent) {
        if (intent != null) {
            if (!(resultCode == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
        return null;
    }
}
