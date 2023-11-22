package ru.noties.markwon;

import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import ru.noties.markwon.renderer.R;
import ru.noties.markwon.spans.TableRowSpan;

/* loaded from: classes9.dex */
abstract class TableRowsScheduler {

    /* renamed from: ru.noties.markwon.TableRowsScheduler$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    static final class AnonymousClass1 implements View.OnAttachStateChangeListener {
        final /* synthetic */ TextView BuiltInFictitiousFunctionClassFactory;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            TableRowsScheduler.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
            this.BuiltInFictitiousFunctionClassFactory.removeOnAttachStateChangeListener(this);
            this.BuiltInFictitiousFunctionClassFactory.setTag(R.id.markwon_tables_scheduler, null);
        }
    }

    /* renamed from: ru.noties.markwon.TableRowsScheduler$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    static final class AnonymousClass2 implements TableRowSpan.Invalidator {
        final /* synthetic */ TextView PlaceComponentResult;

        @Override // ru.noties.markwon.spans.TableRowSpan.Invalidator
        public final void getAuthRequestContext() {
            TextView textView = this.PlaceComponentResult;
            textView.setText(textView.getText());
        }
    }

    private TableRowsScheduler() {
    }

    static void MyBillsEntityDataFactory(TextView textView) {
        CharSequence text = textView.getText();
        Object[] spans = (TextUtils.isEmpty(text) || !(text instanceof Spanned)) ? null : ((Spanned) text).getSpans(0, text.length(), TableRowSpan.class);
        if (spans == null || spans.length <= 0) {
            return;
        }
        for (Object obj : spans) {
            ((TableRowSpan) obj).BuiltInFictitiousFunctionClassFactory = null;
        }
    }
}
