package id.dana.extension;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.FileProvider;
import id.dana.data.util.NumberUtils;
import id.dana.utils.FileUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.TextUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\u0010\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\u001e\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u00020\u0001H\u0086\b¢\u0006\u0002\u0010\b\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\n\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\n\u001a(\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\nH\u0007\u001a\u001a\u0010\u0014\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016\u001a\u0012\u0010\u0018\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0011\u001a\u001e\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u0011H\u0007\u001a\n\u0010\u001c\u001a\u00020\u000f*\u00020\u0001\u001a*\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011\u001a\u001e\u0010#\u001a\u00020$*\u00020\u00022\u0006\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u0011H\u0007\u001a*\u0010%\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011¨\u0006&"}, d2 = {"findActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "getPhotoUri", "Landroid/net/Uri;", "getRootLayout", "T", "Landroid/view/View;", "(Landroid/app/Activity;)Landroid/view/View;", "getSupportColor", "", "resId", "getSupportDrawable", "Landroid/graphics/drawable/Drawable;", "launchDeepLink", "", "url", "", "action", "flags", "launchGoogleMapsForDirection", "latitude", "", "longitude", "launchPhoneCall", "phone", "launchWhatsApp", "text", "lockPortraitOrientationForNonOreo", "ongoingNotification", "Landroidx/core/app/NotificationCompat$Builder;", "channelId", "groupKey", "title", "message", "startSendIntentChooser", "Landroid/content/Intent;", "stopNotification", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContextExtKt {
    public static final void BuiltInFictitiousFunctionClassFactory(Context context, double d, double d2) {
        Intrinsics.checkNotNullParameter(context, "");
        StringBuilder sb = new StringBuilder();
        sb.append("google.navigation:q=");
        sb.append(d);
        sb.append(',');
        sb.append(d2);
        KClassImpl$Data$declaredNonStaticMembers$2(context, sb.toString(), null, 6);
    }

    public static final void PlaceComponentResult(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        StringBuilder sb = new StringBuilder();
        sb.append("tel:");
        sb.append(str);
        KClassImpl$Data$declaredNonStaticMembers$2(context, sb.toString(), "android.intent.action.DIAL", 4);
    }

    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        String indoPhoneNumber = NumberUtils.getIndoPhoneNumber(TextUtil.moveToNextValue(str));
        String obj = URLEncoder.encode(str2, Charsets.UTF_8.toString()).toString();
        StringBuilder sb = new StringBuilder();
        sb.append("https://wa.me/");
        sb.append(indoPhoneNumber);
        sb.append("?text=");
        sb.append(obj);
        KClassImpl$Data$declaredNonStaticMembers$2(context, sb.toString(), null, 6);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2, int i) {
        if ((i & 2) != 0) {
            str2 = "android.intent.action.VIEW";
        }
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        try {
            Intent flags = new Intent(str2, Uri.parse(str)).setFlags(0);
            Intrinsics.checkNotNullExpressionValue(flags, "");
            context.startActivity(flags);
        } catch (Throwable th) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.DEEPLINK_TAG, context.getClass().getName(), th);
        }
    }

    public static final Uri MyBillsEntityDataFactory(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        StringBuilder sb = new StringBuilder();
        sb.append("image_");
        sb.append(format);
        sb.append('_');
        File createTempFile = File.createTempFile(sb.toString(), ".jpg", FileUtil.PlaceComponentResult(context));
        if (OSUtil.NetworkUserEntityData$$ExternalSyntheticLambda2()) {
            Uri uriForFile = FileProvider.getUriForFile(context, "id.dana.provider", createTempFile);
            Intrinsics.checkNotNullExpressionValue(uriForFile, "");
            return uriForFile;
        }
        Uri fromFile = Uri.fromFile(createTempFile);
        Intrinsics.checkNotNullExpressionValue(fromFile, "");
        return fromFile;
    }

    public static /* synthetic */ Intent BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter("", "");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        context.startActivity(Intent.createChooser(intent, ""));
        return intent;
    }

    public static final void PlaceComponentResult(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        activity.setRequestedOrientation(OSUtil.DatabaseTableConfigUtil() ? -1 : 1);
    }

    public static final Drawable PlaceComponentResult(Context context, int i) {
        Drawable BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(context, "");
        BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(context, i);
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static final Activity getAuthRequestContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        while (!(context instanceof Activity)) {
            ContextWrapper contextWrapper = context instanceof ContextWrapper ? (ContextWrapper) context : null;
            context = contextWrapper != null ? contextWrapper.getBaseContext() : null;
            if (context == null) {
                throw new IllegalArgumentException("No activity found");
            }
        }
        return (Activity) context;
    }
}
