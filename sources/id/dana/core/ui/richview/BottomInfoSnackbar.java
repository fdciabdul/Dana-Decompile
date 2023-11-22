package id.dana.core.ui.richview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.ContentViewCallback;
import id.dana.core.ui.R;
import id.dana.core.ui.constant.BottomInfoSnackbarState;
import id.dana.core.ui.databinding.ViewBottomInfoSnackbarBinding;
import id.dana.core.ui.extension.ViewExtKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0012\u0010\f\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/core/ui/richview/BottomInfoSnackbar;", "Lcom/google/android/material/snackbar/BaseTransientBottomBar;", "Lid/dana/core/ui/constant/BottomInfoSnackbarState;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/core/ui/constant/BottomInfoSnackbarState;)V", "Lid/dana/core/ui/databinding/ViewBottomInfoSnackbarBinding;", "Lid/dana/core/ui/databinding/ViewBottomInfoSnackbarBinding;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/core/ui/constant/BottomInfoSnackbarState;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "p1", "Lcom/google/android/material/snackbar/ContentViewCallback;", "p2", "<init>", "(Landroid/view/ViewGroup;Lid/dana/core/ui/databinding/ViewBottomInfoSnackbarBinding;Lcom/google/android/material/snackbar/ContentViewCallback;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BottomInfoSnackbar extends BaseTransientBottomBar<BottomInfoSnackbar> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public BottomInfoSnackbarState getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final ViewBottomInfoSnackbarBinding MyBillsEntityDataFactory;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[BottomInfoSnackbarState.values().length];
            iArr[BottomInfoSnackbarState.ERROR.ordinal()] = 1;
            iArr[BottomInfoSnackbarState.NORMAL.ordinal()] = 2;
            iArr[BottomInfoSnackbarState.SUCCESS.ordinal()] = 3;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[p0.ordinal()];
        if (i == 1) {
            this.MyBillsEntityDataFactory.getAuthRequestContext.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.scheduleImpl_res_0x7f0602d6));
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.initRecordTimeStamp));
        } else if (i == 2) {
            this.MyBillsEntityDataFactory.getAuthRequestContext.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.lookAheadTest));
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.moveToNextValue));
        } else if (i == 3) {
            this.MyBillsEntityDataFactory.getAuthRequestContext.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.res_0x7f06014c_networkuserentitydata_externalsyntheticlambda0));
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.initRecordTimeStamp));
        }
        this.getAuthRequestContext = p0;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/core/ui/richview/BottomInfoSnackbar$Companion;", "", "Landroid/view/ViewGroup;", "p0", "Lid/dana/core/ui/richview/BottomInfoSnackbar;", "getAuthRequestContext", "(Landroid/view/ViewGroup;)Lid/dana/core/ui/richview/BottomInfoSnackbar;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static BottomInfoSnackbar getAuthRequestContext(ViewGroup p0) {
            ViewGroup viewGroup;
            Intrinsics.checkNotNullParameter(p0, "");
            ViewGroup viewGroup2 = p0;
            ViewGroup viewGroup3 = null;
            while (true) {
                if (viewGroup2 instanceof CoordinatorLayout) {
                    viewGroup = (ViewGroup) viewGroup2;
                    break;
                }
                if (viewGroup2 instanceof FrameLayout) {
                    if (((FrameLayout) viewGroup2).getId() == 16908290) {
                        viewGroup = (ViewGroup) viewGroup2;
                        break;
                    }
                    viewGroup3 = (ViewGroup) viewGroup2;
                }
                if (viewGroup2 != null) {
                    ViewParent parent = viewGroup2.getParent();
                    viewGroup2 = parent instanceof View ? (View) parent : null;
                }
                if (viewGroup2 == null) {
                    viewGroup = viewGroup3;
                    break;
                }
            }
            if (viewGroup == null) {
                throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
            }
            ViewBottomInfoSnackbarBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewBottomInfoSnackbarBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(p0.getContext()).inflate(R.layout.view_bottom_info_snackbar, viewGroup, false));
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            BottomInfoSnackbar bottomInfoSnackbar = new BottomInfoSnackbar(viewGroup, KClassImpl$Data$declaredNonStaticMembers$2, new ContentViewCallback() { // from class: id.dana.core.ui.richview.BottomInfoSnackbar$Companion$make$1
                @Override // com.google.android.material.snackbar.ContentViewCallback
                public final void animateContentIn(int p02, int p1) {
                }

                @Override // com.google.android.material.snackbar.ContentViewCallback
                public final void animateContentOut(int p02, int p1) {
                }
            });
            bottomInfoSnackbar.setGestureInsetBottomIgnored(true);
            View view = bottomInfoSnackbar.getView();
            Intrinsics.checkNotNullExpressionValue(view, "");
            ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(view);
            return bottomInfoSnackbar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomInfoSnackbar(ViewGroup viewGroup, ViewBottomInfoSnackbarBinding viewBottomInfoSnackbarBinding, ContentViewCallback contentViewCallback) {
        super(viewGroup, viewBottomInfoSnackbarBinding.BuiltInFictitiousFunctionClassFactory, contentViewCallback);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(viewBottomInfoSnackbarBinding, "");
        Intrinsics.checkNotNullParameter(contentViewCallback, "");
        this.MyBillsEntityDataFactory = viewBottomInfoSnackbarBinding;
        setDuration(3000);
        this.getAuthRequestContext = BottomInfoSnackbarState.NORMAL;
    }
}
