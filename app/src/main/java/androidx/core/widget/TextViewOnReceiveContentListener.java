package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    @Override // androidx.core.view.OnReceiveContentListener
    public final ContentInfoCompat PlaceComponentResult(View view, ContentInfoCompat contentInfoCompat) {
        CharSequence MyBillsEntityDataFactory;
        if (Log.isLoggable("ReceiveContent", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("onReceive: ");
            sb.append(contentInfoCompat);
            InstrumentInjector.log_d("ReceiveContent", sb.toString());
        }
        if (contentInfoCompat.MyBillsEntityDataFactory() == 2) {
            return contentInfoCompat;
        }
        ClipData PlaceComponentResult = contentInfoCompat.PlaceComponentResult();
        int authRequestContext = contentInfoCompat.getAuthRequestContext();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z = false;
        for (int i = 0; i < PlaceComponentResult.getItemCount(); i++) {
            ClipData.Item itemAt = PlaceComponentResult.getItemAt(i);
            if (Build.VERSION.SDK_INT >= 16) {
                MyBillsEntityDataFactory = Api16Impl.MyBillsEntityDataFactory(context, itemAt, authRequestContext);
            } else {
                MyBillsEntityDataFactory = ApiImpl.MyBillsEntityDataFactory(context, itemAt, authRequestContext);
            }
            if (MyBillsEntityDataFactory != null) {
                if (!z) {
                    getAuthRequestContext(editable, MyBillsEntityDataFactory);
                    z = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), MyBillsEntityDataFactory);
                }
            }
        }
        return null;
    }

    private static void getAuthRequestContext(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Api16Impl {
        private Api16Impl() {
        }

        static CharSequence MyBillsEntityDataFactory(Context context, ClipData.Item item, int i) {
            if ((i & 1) != 0) {
                CharSequence coerceToText = item.coerceToText(context);
                return coerceToText instanceof Spanned ? coerceToText.toString() : coerceToText;
            }
            return item.coerceToStyledText(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ApiImpl {
        private ApiImpl() {
        }

        static CharSequence MyBillsEntityDataFactory(Context context, ClipData.Item item, int i) {
            CharSequence coerceToText = item.coerceToText(context);
            return ((i & 1) == 0 || !(coerceToText instanceof Spanned)) ? coerceToText : coerceToText.toString();
        }
    }
}
