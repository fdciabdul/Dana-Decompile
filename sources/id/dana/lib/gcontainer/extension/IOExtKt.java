package id.dana.lib.gcontainer.extension;

import android.content.Context;
import android.net.Uri;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.io.FileNotFoundException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/net/Uri;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Ljava/io/InputStream;", "openInputStream", "(Landroid/net/Uri;Landroid/content/Context;)Ljava/io/InputStream;"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class IOExtKt {
    public static final InputStream openInputStream(Uri uri, Context context) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(uri, "");
        Intrinsics.checkNotNullParameter(context, "");
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        if (openInputStream != null) {
            return openInputStream;
        }
        throw new FileNotFoundException(Intrinsics.stringPlus("File not found: ", uri.getPath()));
    }
}
