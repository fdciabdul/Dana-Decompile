package com.anggrayudi.storage.extension;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0005\u001a!\u0010\u0004\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\f\u001a\u001b\u0010\u0006\u001a\u00020\u000b*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0006\u0010\u000e"}, d2 = {"Landroid/content/Context;", "Landroid/net/Uri;", "p0", "Landroidx/documentfile/provider/DocumentFile;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Landroid/net/Uri;)Landroidx/documentfile/provider/DocumentFile;", "MyBillsEntityDataFactory", "Landroid/app/Activity;", "", "Landroid/content/Intent;", "p1", "", "(Landroid/app/Activity;ILandroid/content/Intent;)V", "Landroid/content/BroadcastReceiver;", "(Landroid/content/Context;Landroid/content/BroadcastReceiver;)V"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ContextUtils {
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Activity activity, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(intent, "");
        try {
            activity.startActivityForResult(intent, i);
        } catch (ActivityNotFoundException unused) {
        }
    }

    public static final void MyBillsEntityDataFactory(Context context, BroadcastReceiver broadcastReceiver) {
        Intrinsics.checkNotNullParameter(context, "");
        if (broadcastReceiver == null) {
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException unused) {
        }
    }

    public static final DocumentFile MyBillsEntityDataFactory(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(uri, "");
        try {
            return DocumentFile.getAuthRequestContext(context, uri);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final DocumentFile KClassImpl$Data$declaredNonStaticMembers$2(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(uri, "");
        try {
            return DocumentFile.MyBillsEntityDataFactory(context, uri);
        } catch (Exception unused) {
            return null;
        }
    }
}
