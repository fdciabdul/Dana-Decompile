package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
final class AppCompatReceiveContentHelper {
    private AppCompatReceiveContentHelper() {
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 31 || ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda8(textView) == null || !(i == 16908322 || i == 16908337)) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            ViewCompat.getAuthRequestContext(textView, new ContentInfoCompat.Builder(primaryClip, 1).MyBillsEntityDataFactory(i != 16908322 ? 1 : 0).KClassImpl$Data$declaredNonStaticMembers$2());
        }
        return true;
    }

    public static boolean getAuthRequestContext(View view, DragEvent dragEvent) {
        if (Build.VERSION.SDK_INT < 31 && Build.VERSION.SDK_INT >= 24 && dragEvent.getLocalState() == null && ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda8(view) != null) {
            Activity KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(view);
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Can't handle drop: no activity: view=");
                sb.append(view);
                InstrumentInjector.log_i("ReceiveContent", sb.toString());
                return false;
            } else if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            } else {
                if (dragEvent.getAction() == 3) {
                    if (view instanceof TextView) {
                        return OnDropApi24Impl.PlaceComponentResult(dragEvent, (TextView) view, KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                    return OnDropApi24Impl.getAuthRequestContext(dragEvent, view, KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
        }
        return false;
    }

    /* loaded from: classes3.dex */
    public static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        static boolean PlaceComponentResult(DragEvent dragEvent, TextView textView, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                ViewCompat.getAuthRequestContext(textView, new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).KClassImpl$Data$declaredNonStaticMembers$2());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }

        static boolean getAuthRequestContext(DragEvent dragEvent, View view, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            ViewCompat.getAuthRequestContext(view, new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).KClassImpl$Data$declaredNonStaticMembers$2());
            return true;
        }
    }

    static Activity KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
