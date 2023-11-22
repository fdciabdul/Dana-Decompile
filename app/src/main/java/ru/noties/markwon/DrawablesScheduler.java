package ru.noties.markwon;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import ru.noties.markwon.renderer.R;

/* loaded from: classes9.dex */
abstract class DrawablesScheduler {

    /* renamed from: ru.noties.markwon.DrawablesScheduler$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    static final class AnonymousClass1 implements View.OnAttachStateChangeListener {
        final /* synthetic */ TextView PlaceComponentResult;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            DrawablesScheduler.getAuthRequestContext(this.PlaceComponentResult);
            view.removeOnAttachStateChangeListener(this);
            view.setTag(R.id.markwon_drawables_scheduler, null);
        }
    }

    private DrawablesScheduler() {
    }

    /* loaded from: classes9.dex */
    static class DrawableCallbackImpl implements Drawable.Callback {
        private Rect BuiltInFictitiousFunctionClassFactory;
        private final TextView MyBillsEntityDataFactory;

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(final Drawable drawable) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.MyBillsEntityDataFactory.post(new Runnable() { // from class: ru.noties.markwon.DrawablesScheduler.DrawableCallbackImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DrawableCallbackImpl.this.invalidateDrawable(drawable);
                    }
                });
                return;
            }
            Rect bounds = drawable.getBounds();
            if (!this.BuiltInFictitiousFunctionClassFactory.equals(bounds)) {
                TextView textView = this.MyBillsEntityDataFactory;
                textView.setText(textView.getText());
                this.BuiltInFictitiousFunctionClassFactory = new Rect(bounds);
                return;
            }
            this.MyBillsEntityDataFactory.postInvalidate();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.MyBillsEntityDataFactory.postDelayed(runnable, j - SystemClock.uptimeMillis());
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.MyBillsEntityDataFactory.removeCallbacks(runnable);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        if (r2.size() == 0) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void getAuthRequestContext(android.widget.TextView r7) {
        /*
            java.lang.CharSequence r7 = r7.getText()
            r0 = 0
            if (r7 == 0) goto Lc
            int r1 = r7.length()
            goto Ld
        Lc:
            r1 = 0
        Ld:
            if (r1 == 0) goto L60
            boolean r2 = r7 instanceof android.text.Spanned
            if (r2 == 0) goto L60
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 2
            r2.<init>(r3)
            android.text.Spanned r7 = (android.text.Spanned) r7
            java.lang.Class<ru.noties.markwon.spans.AsyncDrawableSpan> r3 = ru.noties.markwon.spans.AsyncDrawableSpan.class
            java.lang.Object[] r3 = r7.getSpans(r0, r1, r3)
            ru.noties.markwon.spans.AsyncDrawableSpan[] r3 = (ru.noties.markwon.spans.AsyncDrawableSpan[]) r3
            if (r3 == 0) goto L36
            int r4 = r3.length
            if (r4 <= 0) goto L36
            int r4 = r3.length
            r5 = 0
        L2a:
            if (r5 >= r4) goto L36
            r6 = r3[r5]
            ru.noties.markwon.spans.AsyncDrawable r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            r2.add(r6)
            int r5 = r5 + 1
            goto L2a
        L36:
            java.lang.Class<android.text.style.DynamicDrawableSpan> r3 = android.text.style.DynamicDrawableSpan.class
            java.lang.Object[] r7 = r7.getSpans(r0, r1, r3)
            android.text.style.DynamicDrawableSpan[] r7 = (android.text.style.DynamicDrawableSpan[]) r7
            if (r7 == 0) goto L5a
            int r1 = r7.length
            if (r1 <= 0) goto L5a
            int r1 = r7.length
        L44:
            if (r0 >= r1) goto L5a
            r3 = r7[r0]
            android.graphics.drawable.Drawable r3 = r3.getDrawable()
            if (r3 == 0) goto L57
            boolean r4 = r3 instanceof ru.noties.markwon.spans.AsyncDrawable
            if (r4 == 0) goto L57
            ru.noties.markwon.spans.AsyncDrawable r3 = (ru.noties.markwon.spans.AsyncDrawable) r3
            r2.add(r3)
        L57:
            int r0 = r0 + 1
            goto L44
        L5a:
            int r7 = r2.size()
            if (r7 != 0) goto L62
        L60:
            java.util.List r2 = java.util.Collections.EMPTY_LIST
        L62:
            java.util.Iterator r7 = r2.iterator()
        L66:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L76
            java.lang.Object r0 = r7.next()
            ru.noties.markwon.spans.AsyncDrawable r0 = (ru.noties.markwon.spans.AsyncDrawable) r0
            r0.PlaceComponentResult()
            goto L66
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.noties.markwon.DrawablesScheduler.getAuthRequestContext(android.widget.TextView):void");
    }
}
