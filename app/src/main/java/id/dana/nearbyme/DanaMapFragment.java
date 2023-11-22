package id.dana.nearbyme;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.SupportMapFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0012\u0010\u0010\u001a\u00020\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\r8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/nearbyme/DanaMapFragment;", "Lcom/google/android/gms/maps/SupportMapFragment;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Landroid/view/LayoutInflater;", "p0", "Landroid/view/ViewGroup;", "p1", "Landroid/os/Bundle;", "p2", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "getErrorConfigVersion", "Z", "BuiltInFictitiousFunctionClassFactory", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getAuthRequestContext", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "lookAheadTest", "Landroid/view/View;", "<init>", "()V", "Companion", "TouchableWrapper"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaMapFragment extends SupportMapFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private View getAuthRequestContext;

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.google.android.gms.maps.SupportMapFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext = super.onCreateView(p0, p1, p2);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        TouchableWrapper touchableWrapper = new TouchableWrapper(requireContext, new Function1<MotionEvent, Unit>() { // from class: id.dana.nearbyme.DanaMapFragment$onCreateView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter(motionEvent, "");
                int action = motionEvent.getAction();
                if (action == 0) {
                    DanaMapFragment.this.BuiltInFictitiousFunctionClassFactory = true;
                    DanaMapFragment.this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                } else if (action == 1) {
                    DanaMapFragment.this.BuiltInFictitiousFunctionClassFactory = false;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
                invoke2(motionEvent);
                return Unit.INSTANCE;
            }
        });
        touchableWrapper.addView(this.getAuthRequestContext);
        return touchableWrapper;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: getView  reason: from getter */
    public final View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B*\u0012\u0006\u0010\u0003\u001a\u00020\f\u0012\u0019\u0010\r\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\n\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\b\u0012\u0004\u0012\u00020\t0\u0007X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/nearbyme/DanaMapFragment$TouchableWrapper;", "Landroid/widget/FrameLayout;", "Landroid/view/MotionEvent;", "p0", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "Landroid/content/Context;", "p1", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    static final class TouchableWrapper extends FrameLayout {
        public final Function1<MotionEvent, Unit> PlaceComponentResult;
        public Map<Integer, View> getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public TouchableWrapper(Context context, Function1<? super MotionEvent, Unit> function1) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(function1, "");
            this.getAuthRequestContext = new LinkedHashMap();
            this.PlaceComponentResult = function1;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchTouchEvent(MotionEvent p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.PlaceComponentResult.invoke(p0);
            return super.dispatchTouchEvent(p0);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyme/DanaMapFragment$Companion;", "", "Lcom/google/android/gms/maps/GoogleMapOptions;", "p0", "Lid/dana/nearbyme/DanaMapFragment;", "MyBillsEntityDataFactory", "(Lcom/google/android/gms/maps/GoogleMapOptions;)Lid/dana/nearbyme/DanaMapFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static DanaMapFragment MyBillsEntityDataFactory(GoogleMapOptions p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            DanaMapFragment danaMapFragment = new DanaMapFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("MapOptions", p0);
            danaMapFragment.setArguments(bundle);
            return danaMapFragment;
        }
    }

    @Override // com.google.android.gms.maps.SupportMapFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }
}
