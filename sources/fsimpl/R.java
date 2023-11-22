package fsimpl;

import android.app.Activity;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class R implements View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f7812a;
    final /* synthetic */ Activity b;
    final /* synthetic */ Q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public R(Q q, View view, Activity activity) {
        this.c = q;
        this.f7812a = view;
        this.b = activity;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f7812a.removeOnAttachStateChangeListener(this);
        this.c.a(this.b);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
