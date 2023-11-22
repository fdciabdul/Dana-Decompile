package id.dana.utils.measureloadscreen;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0019\b\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\t\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\r\u001a\u00020\u000f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010"}, d2 = {"Lid/dana/utils/measureloadscreen/FirstDrawListener;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "", "onDraw", "()V", "Lid/dana/utils/measureloadscreen/FirstDrawListener$OnFirstDrawCallback;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/utils/measureloadscreen/FirstDrawListener$OnFirstDrawCallback;", "Landroid/os/Handler;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/os/Handler;", "PlaceComponentResult", "", "MyBillsEntityDataFactory", "Z", "Landroid/view/View;", "Landroid/view/View;", "p0", "p1", "<init>", "(Landroid/view/View;Lid/dana/utils/measureloadscreen/FirstDrawListener$OnFirstDrawCallback;)V", "Companion", "OnFirstDrawCallback"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FirstDrawListener implements ViewTreeObserver.OnDrawListener {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final OnFirstDrawCallback BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Handler PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final View MyBillsEntityDataFactory;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/utils/measureloadscreen/FirstDrawListener$OnFirstDrawCallback;", "", "", "getAuthRequestContext", "()V", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnFirstDrawCallback {
        void BuiltInFictitiousFunctionClassFactory();

        void getAuthRequestContext();
    }

    public /* synthetic */ FirstDrawListener(View view, OnFirstDrawCallback onFirstDrawCallback, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, onFirstDrawCallback);
    }

    @JvmStatic
    public static final FirstDrawListener getAuthRequestContext(View view, OnFirstDrawCallback onFirstDrawCallback) {
        return Companion.MyBillsEntityDataFactory(view, onFirstDrawCallback);
    }

    private FirstDrawListener(View view, OnFirstDrawCallback onFirstDrawCallback) {
        this.MyBillsEntityDataFactory = view;
        this.BuiltInFictitiousFunctionClassFactory = onFirstDrawCallback;
        this.PlaceComponentResult = new Handler(Looper.getMainLooper());
        if (this.MyBillsEntityDataFactory.getViewTreeObserver().isAlive() && this.MyBillsEntityDataFactory.isAttachedToWindow()) {
            this.MyBillsEntityDataFactory.getViewTreeObserver().addOnDrawListener(this);
        } else {
            this.MyBillsEntityDataFactory.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: id.dana.utils.measureloadscreen.FirstDrawListener$registerFirstDrawListener$1
                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewDetachedFromWindow(View p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewAttachedToWindow(View p0) {
                    View view2;
                    View view3;
                    View view4;
                    Intrinsics.checkNotNullParameter(p0, "");
                    view2 = FirstDrawListener.this.MyBillsEntityDataFactory;
                    if (view2.getViewTreeObserver().isAlive()) {
                        view4 = FirstDrawListener.this.MyBillsEntityDataFactory;
                        view4.getViewTreeObserver().addOnDrawListener(FirstDrawListener.this);
                    }
                    view3 = FirstDrawListener.this.MyBillsEntityDataFactory;
                    view3.removeOnAttachStateChangeListener(this);
                }
            });
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
        this.PlaceComponentResult.postAtFrontOfQueue(new Runnable() { // from class: id.dana.utils.measureloadscreen.FirstDrawListener$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FirstDrawListener.PlaceComponentResult(FirstDrawListener.this);
            }
        });
        this.PlaceComponentResult.post(new Runnable() { // from class: id.dana.utils.measureloadscreen.FirstDrawListener$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FirstDrawListener.getAuthRequestContext(FirstDrawListener.this);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/utils/measureloadscreen/FirstDrawListener$Companion;", "", "Landroid/view/View;", "p0", "Lid/dana/utils/measureloadscreen/FirstDrawListener$OnFirstDrawCallback;", "p1", "Lid/dana/utils/measureloadscreen/FirstDrawListener;", "MyBillsEntityDataFactory", "(Landroid/view/View;Lid/dana/utils/measureloadscreen/FirstDrawListener$OnFirstDrawCallback;)Lid/dana/utils/measureloadscreen/FirstDrawListener;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static FirstDrawListener MyBillsEntityDataFactory(View p0, OnFirstDrawCallback p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return new FirstDrawListener(p0, p1, null);
        }
    }

    public static /* synthetic */ void getAuthRequestContext(FirstDrawListener firstDrawListener) {
        Intrinsics.checkNotNullParameter(firstDrawListener, "");
        if (firstDrawListener.MyBillsEntityDataFactory.getViewTreeObserver().isAlive()) {
            firstDrawListener.MyBillsEntityDataFactory.getViewTreeObserver().removeOnDrawListener(firstDrawListener);
        }
    }

    public static /* synthetic */ void PlaceComponentResult(FirstDrawListener firstDrawListener) {
        Intrinsics.checkNotNullParameter(firstDrawListener, "");
        firstDrawListener.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
    }
}
