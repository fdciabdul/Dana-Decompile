package id.dana.social.view;

import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;
import com.google.android.material.appbar.AppBarLayout;
import id.dana.analytics.tracker.TrackerKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/social/view/AppBarStateChangeListener;", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "Lcom/google/android/material/appbar/AppBarLayout;", "p0", "", "p1", "", "onOffsetChanged", "(Lcom/google/android/material/appbar/AppBarLayout;I)V", "Lid/dana/social/view/AppBarStateChangeListener$State;", "BuiltInFictitiousFunctionClassFactory", "(Lcom/google/android/material/appbar/AppBarLayout;Lid/dana/social/view/AppBarStateChangeListener$State;)V", "PlaceComponentResult", "Lid/dana/social/view/AppBarStateChangeListener$State;", "getAuthRequestContext", "<init>", "()V", TrackerKey.Property.STATE}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private State getAuthRequestContext = State.IDLE;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/social/view/AppBarStateChangeListener$State;", "", "<init>", "(Ljava/lang/String;I)V", "EXPANDED", "COLLAPSED", RVScheduleType.IDLE}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    public abstract void BuiltInFictitiousFunctionClassFactory(AppBarLayout p0, State p1);

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public void onOffsetChanged(AppBarLayout p0, int p1) {
        State state;
        Intrinsics.checkNotNullParameter(p0, "");
        if (p1 == 0) {
            if (this.getAuthRequestContext != State.EXPANDED) {
                BuiltInFictitiousFunctionClassFactory(p0, State.EXPANDED);
            }
            state = State.EXPANDED;
        } else if (Math.abs(p1) >= p0.getTotalScrollRange()) {
            if (this.getAuthRequestContext != State.COLLAPSED) {
                BuiltInFictitiousFunctionClassFactory(p0, State.COLLAPSED);
            }
            state = State.COLLAPSED;
        } else {
            if (this.getAuthRequestContext != State.IDLE) {
                BuiltInFictitiousFunctionClassFactory(p0, State.IDLE);
            }
            state = State.IDLE;
        }
        this.getAuthRequestContext = state;
    }
}
