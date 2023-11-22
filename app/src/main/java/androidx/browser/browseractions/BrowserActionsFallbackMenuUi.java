package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.browser.R;
import androidx.core.widget.TextViewCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.List;

@Deprecated
/* loaded from: classes6.dex */
class BrowserActionsFallbackMenuUi implements AdapterView.OnItemClickListener {
    BrowserActionsFallMenuUiListener BuiltInFictitiousFunctionClassFactory;
    final Uri KClassImpl$Data$declaredNonStaticMembers$2;
    final Context MyBillsEntityDataFactory;
    private BrowserActionsFallbackMenuDialog PlaceComponentResult;
    private final List<BrowserActionItem> getAuthRequestContext;

    /* loaded from: classes6.dex */
    interface BrowserActionsFallMenuUiListener {
    }

    /* renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuUi$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ BrowserActionsFallbackMenuUi MyBillsEntityDataFactory;

        @Override // java.lang.Runnable
        public void run() {
            ((ClipboardManager) this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("url", this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.toString()));
            Toast.makeText(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory, this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.getString(R.string.MyBillsEntityDataFactory_res_0x7f130522), 0).show();
        }
    }

    /* renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuUi$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2 implements DialogInterface.OnShowListener {
        final /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ BrowserActionsFallbackMenuUi getAuthRequestContext;

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory == null) {
                InstrumentInjector.log_e("BrowserActionskMenuUi", "Cannot trigger menu item listener, it is null");
            } else {
                BrowserActionsFallMenuUiListener browserActionsFallMenuUiListener = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
            }
        }
    }

    /* renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuUi$3  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ TextView PlaceComponentResult;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextViewCompat.getAuthRequestContext(this.PlaceComponentResult) == Integer.MAX_VALUE) {
                this.PlaceComponentResult.setMaxLines(1);
                this.PlaceComponentResult.setEllipsize(TextUtils.TruncateAt.END);
                return;
            }
            this.PlaceComponentResult.setMaxLines(Integer.MAX_VALUE);
            this.PlaceComponentResult.setEllipsize(null);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BrowserActionItem browserActionItem = this.getAuthRequestContext.get(i);
        PendingIntent pendingIntent = browserActionItem.PlaceComponentResult;
        if (pendingIntent != null) {
            if (pendingIntent != null) {
                try {
                    PendingIntent pendingIntent2 = browserActionItem.PlaceComponentResult;
                    if (pendingIntent2 != null) {
                        pendingIntent2.send();
                    } else {
                        throw new IllegalStateException("Can't call getAction on BrowserActionItem with null action.");
                    }
                } catch (PendingIntent.CanceledException e) {
                    InstrumentInjector.log_e("BrowserActionskMenuUi", "Failed to send custom item action", e);
                }
            } else if (browserActionItem.getAuthRequestContext != null) {
                browserActionItem.getAuthRequestContext.run();
            }
            BrowserActionsFallbackMenuDialog browserActionsFallbackMenuDialog = this.PlaceComponentResult;
            if (browserActionsFallbackMenuDialog == null) {
                InstrumentInjector.log_e("BrowserActionskMenuUi", "Cannot dismiss dialog, it has already been dismissed.");
                return;
            } else {
                browserActionsFallbackMenuDialog.dismiss();
                return;
            }
        }
        throw new IllegalStateException("Can't call getAction on BrowserActionItem with null action.");
    }
}
