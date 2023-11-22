package com.alipay.iap.android.f2fpay.widgets.mediator;

import android.view.View;
import com.alipay.iap.android.f2fpay.client.IF2FPayClient;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPaymentCodeCallback;
import com.alipay.iap.android.f2fpay.paymentcode.F2FPaymentCodeInfo;
import com.alipay.iap.android.f2fpay.widgets.widget.F2FPayAbstractPaymentCodeView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class F2FPayClientMediator {

    /* renamed from: a  reason: collision with root package name */
    private List<WeakReference<F2FPayAbstractPaymentCodeView>> f6977a = new ArrayList();
    private F2FPaymentCodeInfo b;
    private IF2FPayClient c;
    private int d;

    /* loaded from: classes6.dex */
    class a implements IF2FPaymentCodeCallback {

        /* renamed from: com.alipay.iap.android.f2fpay.widgets.mediator.F2FPayClientMediator$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0058a implements c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ F2FPaymentCodeInfo f6979a;

            C0058a(a aVar, F2FPaymentCodeInfo f2FPaymentCodeInfo) {
                this.f6979a = f2FPaymentCodeInfo;
            }

            @Override // com.alipay.iap.android.f2fpay.widgets.mediator.F2FPayClientMediator.c
            public void a(F2FPayAbstractPaymentCodeView f2FPayAbstractPaymentCodeView) {
                f2FPayAbstractPaymentCodeView.updatePaymentCode(this.f6979a);
            }
        }

        /* loaded from: classes6.dex */
        class b implements c {
            b(a aVar) {
            }

            @Override // com.alipay.iap.android.f2fpay.widgets.mediator.F2FPayClientMediator.c
            public void a(F2FPayAbstractPaymentCodeView f2FPayAbstractPaymentCodeView) {
                f2FPayAbstractPaymentCodeView.generatePaymentCodeFailed();
            }
        }

        a() {
        }

        @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPaymentCodeCallback
        public void onPaymentCodeGenerateFailed() {
            F2FPayClientMediator.this.b = null;
            F2FPayClientMediator.this.a(new b(this));
        }

        @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPaymentCodeCallback
        public void onPaymentCodeUpdated(F2FPaymentCodeInfo f2FPaymentCodeInfo) {
            F2FPayClientMediator.this.b = f2FPaymentCodeInfo;
            F2FPayClientMediator.this.a(new C0058a(this, f2FPaymentCodeInfo));
        }
    }

    /* loaded from: classes6.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            F2FPayClientMediator.this.a();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            F2FPayClientMediator.access$306(F2FPayClientMediator.this);
            if (F2FPayClientMediator.this.d <= 0) {
                F2FPayClientMediator.this.c.stopRefreshTask();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface c {
        void a(F2FPayAbstractPaymentCodeView f2FPayAbstractPaymentCodeView);
    }

    public F2FPayClientMediator(IF2FPayClient iF2FPayClient) {
        this.c = iF2FPayClient;
        iF2FPayClient.addPaymentCodeCallback(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.d++;
        this.c.startRefreshTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        Iterator<WeakReference<F2FPayAbstractPaymentCodeView>> it = this.f6977a.iterator();
        while (it.hasNext()) {
            F2FPayAbstractPaymentCodeView f2FPayAbstractPaymentCodeView = it.next().get();
            if (f2FPayAbstractPaymentCodeView == null) {
                it.remove();
            } else {
                cVar.a(f2FPayAbstractPaymentCodeView);
            }
        }
    }

    static /* synthetic */ int access$306(F2FPayClientMediator f2FPayClientMediator) {
        int i = f2FPayClientMediator.d - 1;
        f2FPayClientMediator.d = i;
        return i;
    }

    public void attachWithPaymentCodeView(F2FPayAbstractPaymentCodeView f2FPayAbstractPaymentCodeView) {
        if (f2FPayAbstractPaymentCodeView == null) {
            return;
        }
        if (f2FPayAbstractPaymentCodeView.isViewAttachedToWindow()) {
            a();
        }
        f2FPayAbstractPaymentCodeView.addOnAttachStateChangeListener(new b());
        this.f6977a.add(new WeakReference<>(f2FPayAbstractPaymentCodeView));
        F2FPaymentCodeInfo f2FPaymentCodeInfo = this.b;
        if (f2FPaymentCodeInfo != null) {
            f2FPayAbstractPaymentCodeView.updatePaymentCode(f2FPaymentCodeInfo);
        }
    }
}
