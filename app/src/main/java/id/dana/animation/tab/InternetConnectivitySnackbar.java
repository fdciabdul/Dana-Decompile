package id.dana.animation.tab;

import android.animation.ObjectAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.ContentViewCallback;
import id.dana.R;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.util.connectivity.InternetConnectionStatus;
import id.dana.databinding.ViewSnackbarInternetConnectionBinding;
import id.dana.utils.OSUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0015\u0016B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\"\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002@GX\u0086\n¢\u0006\f\n\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u000b\u001a\u00020\u00048CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u000e"}, d2 = {"Lid/dana/home/tab/InternetConnectivitySnackbar;", "Lcom/google/android/material/snackbar/BaseTransientBottomBar;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)I", "Lid/dana/databinding/ViewSnackbarInternetConnectionBinding;", "Lid/dana/databinding/ViewSnackbarInternetConnectionBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "(Ljava/lang/String;)V", "PlaceComponentResult", "()I", "Landroid/view/ViewGroup;", "p1", "Lcom/google/android/material/snackbar/ContentViewCallback;", "p2", "<init>", "(Landroid/view/ViewGroup;Lid/dana/databinding/ViewSnackbarInternetConnectionBinding;Lcom/google/android/material/snackbar/ContentViewCallback;)V", "Companion", "InternetConnectionSnackBarCallback"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InternetConnectivitySnackbar extends BaseTransientBottomBar<InternetConnectivitySnackbar> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ViewSnackbarInternetConnectionBinding KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String PlaceComponentResult;

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    private final int BuiltInFictitiousFunctionClassFactory() {
        String str = this.PlaceComponentResult;
        return Intrinsics.areEqual(str, InternetConnectionStatus.SLOW_CONNECTION) ? R.string.connection_slow : Intrinsics.areEqual(str, InternetConnectionStatus.FAST_CONNECTION) ? R.string.connection_connected : R.string.connection_disconnected;
    }

    private final int BuiltInFictitiousFunctionClassFactory(String p0) {
        int i;
        if (Intrinsics.areEqual(p0, InternetConnectionStatus.SLOW_CONNECTION)) {
            i = R.color.f27152131100507;
        } else {
            i = Intrinsics.areEqual(p0, InternetConnectionStatus.FAST_CONNECTION) ? R.color.f23922131099979 : R.color.f26712131100373;
        }
        return ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), i);
    }

    @JvmName(name = "getAuthRequestContext")
    public final void getAuthRequestContext(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        String str2 = this.PlaceComponentResult;
        this.PlaceComponentResult = str;
        setDuration((Intrinsics.areEqual(str, InternetConnectionStatus.NOT_CONNECTED) || Intrinsics.areEqual(this.PlaceComponentResult, InternetConnectionStatus.SLOW_CONNECTION)) ? -2 : 2000);
        ViewSnackbarInternetConnectionBinding viewSnackbarInternetConnectionBinding = this.KClassImpl$Data$declaredNonStaticMembers$2;
        viewSnackbarInternetConnectionBinding.BuiltInFictitiousFunctionClassFactory.setText(BuiltInFictitiousFunctionClassFactory());
        LinearLayout linearLayout = viewSnackbarInternetConnectionBinding.MyBillsEntityDataFactory;
        if (OSUtil.scheduleImpl()) {
            ObjectAnimator.ofArgb(linearLayout, "backgroundColor", BuiltInFictitiousFunctionClassFactory(str2), BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult)).start();
        } else {
            linearLayout.setBackgroundColor(BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult));
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/home/tab/InternetConnectivitySnackbar$InternetConnectionSnackBarCallback;", "Lcom/google/android/material/snackbar/ContentViewCallback;", "", "p0", "p1", "", "animateContentIn", "(II)V", "animateContentOut", "Landroid/view/View;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/View;", "MyBillsEntityDataFactory", "<init>", "(Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    static final class InternetConnectionSnackBarCallback implements ContentViewCallback {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final View MyBillsEntityDataFactory;

        @Override // com.google.android.material.snackbar.ContentViewCallback
        public final void animateContentIn(int p0, int p1) {
        }

        @Override // com.google.android.material.snackbar.ContentViewCallback
        public final void animateContentOut(int p0, int p1) {
        }

        public InternetConnectionSnackBarCallback(View view) {
            Intrinsics.checkNotNullParameter(view, "");
            this.MyBillsEntityDataFactory = view;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/home/tab/InternetConnectivitySnackbar$Companion;", "", "Landroid/view/ViewGroup;", "p0", "", "p1", "Lid/dana/home/tab/InternetConnectivitySnackbar;", "MyBillsEntityDataFactory", "(Landroid/view/ViewGroup;Ljava/lang/String;)Lid/dana/home/tab/InternetConnectivitySnackbar;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static InternetConnectivitySnackbar MyBillsEntityDataFactory(ViewGroup p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            View inflate = LayoutInflater.from(p0.getContext()).inflate(R.layout.view_snackbar_internet_connection, p0, false);
            ViewSnackbarInternetConnectionBinding MyBillsEntityDataFactory = ViewSnackbarInternetConnectionBinding.MyBillsEntityDataFactory(inflate);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
            Intrinsics.checkNotNullExpressionValue(inflate, "");
            InternetConnectivitySnackbar internetConnectivitySnackbar = new InternetConnectivitySnackbar(p0, MyBillsEntityDataFactory, new InternetConnectionSnackBarCallback(inflate));
            internetConnectivitySnackbar.setGestureInsetBottomIgnored(true);
            View view = internetConnectivitySnackbar.getView();
            Intrinsics.checkNotNullExpressionValue(view, "");
            ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(view);
            internetConnectivitySnackbar.getAuthRequestContext(p1);
            return internetConnectivitySnackbar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InternetConnectivitySnackbar(ViewGroup viewGroup, ViewSnackbarInternetConnectionBinding viewSnackbarInternetConnectionBinding, ContentViewCallback contentViewCallback) {
        super(viewGroup, viewSnackbarInternetConnectionBinding.getAuthRequestContext, contentViewCallback);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(viewSnackbarInternetConnectionBinding, "");
        Intrinsics.checkNotNullParameter(contentViewCallback, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewSnackbarInternetConnectionBinding;
        this.PlaceComponentResult = InternetConnectionStatus.NOT_CONNECTED;
    }
}
