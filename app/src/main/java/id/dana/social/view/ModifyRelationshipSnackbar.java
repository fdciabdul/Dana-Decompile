package id.dana.social.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.ContentViewCallback;
import id.dana.R;
import id.dana.social.view.ModifyRelationshipSnackbar;
import id.dana.utils.WindowUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0001:\u0002\u000f\u0010B)\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/social/view/ModifyRelationshipSnackbar;", "Lcom/google/android/material/snackbar/BaseTransientBottomBar;", "Lid/dana/social/view/ModifyRelationshipSnackbar$Builder;", "PlaceComponentResult", "Lid/dana/social/view/ModifyRelationshipSnackbar$Builder;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "p0", "Landroid/view/View;", "p1", "Lcom/google/android/material/snackbar/ContentViewCallback;", "p2", "p3", "<init>", "(Landroid/view/ViewGroup;Landroid/view/View;Lcom/google/android/material/snackbar/ContentViewCallback;Lid/dana/social/view/ModifyRelationshipSnackbar$Builder;)V", "Builder", "Callback"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModifyRelationshipSnackbar extends BaseTransientBottomBar<ModifyRelationshipSnackbar> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Builder KClassImpl$Data$declaredNonStaticMembers$2;

    public /* synthetic */ ModifyRelationshipSnackbar(ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback, Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, view, contentViewCallback, builder);
    }

    private ModifyRelationshipSnackbar(ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback, Builder builder) {
        super(viewGroup, view, contentViewCallback);
        ImageView imageView;
        Button button;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder;
        getView().setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(viewGroup.getContext(), R.color.transparent));
        View view2 = getView();
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        view2.setPadding(0, 0, 0, WindowUtil.PlaceComponentResult(context));
        setDuration(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
        BaseTransientBottomBar.SnackbarBaseLayout snackbarBaseLayout = this.view;
        TextView textView = snackbarBaseLayout != null ? (TextView) snackbarBaseLayout.findViewById(R.id.tv_custom_snackbar) : null;
        if (textView != null) {
            textView.setText(this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion);
        }
        BaseTransientBottomBar.SnackbarBaseLayout snackbarBaseLayout2 = this.view;
        if (snackbarBaseLayout2 != null && (button = (Button) snackbarBaseLayout2.findViewById(R.id.btn_snackbar)) != null) {
            button.setOnClickListener(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext);
        }
        BaseTransientBottomBar.SnackbarBaseLayout snackbarBaseLayout3 = this.view;
        Button button2 = snackbarBaseLayout3 != null ? (Button) snackbarBaseLayout3.findViewById(R.id.btn_snackbar) : null;
        if (button2 != null) {
            button2.setVisibility(0);
        }
        BaseTransientBottomBar.SnackbarBaseLayout snackbarBaseLayout4 = this.view;
        Button button3 = snackbarBaseLayout4 != null ? (Button) snackbarBaseLayout4.findViewById(R.id.btn_snackbar) : null;
        if (button3 != null) {
            button3.setText(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
        }
        BaseTransientBottomBar.SnackbarBaseLayout snackbarBaseLayout5 = this.view;
        if (snackbarBaseLayout5 == null || (imageView = (ImageView) snackbarBaseLayout5.findViewById(R.id.BottomSheetType)) == null) {
            return;
        }
        InstrumentInjector.Resources_setImageResource(imageView, this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J7\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/social/view/ModifyRelationshipSnackbar$Callback;", "Lcom/google/android/material/snackbar/ContentViewCallback;", "", "p0", "p1", "", "animateContentIn", "(II)V", "animateContentOut", "Landroid/view/View;", "", "p2", "p3", "p4", "PlaceComponentResult", "(Landroid/view/View;FFII)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/View;", "getAuthRequestContext", "<init>", "(Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Callback implements ContentViewCallback {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final View getAuthRequestContext;

        public Callback(View view) {
            Intrinsics.checkNotNullParameter(view, "");
            this.getAuthRequestContext = view;
        }

        @Override // com.google.android.material.snackbar.ContentViewCallback
        public final void animateContentIn(int p0, int p1) {
            PlaceComponentResult(this.getAuthRequestContext, 0.0f, 1.0f, p0, p1);
        }

        @Override // com.google.android.material.snackbar.ContentViewCallback
        public final void animateContentOut(int p0, int p1) {
            PlaceComponentResult(this.getAuthRequestContext, 1.0f, 0.0f, p0, p1);
        }

        private static void PlaceComponentResult(View p0, float p1, float p2, int p3, int p4) {
            ViewCompat.PlaceComponentResult(p0, p1);
            ViewCompat.MyBillsEntityDataFactory(p0).KClassImpl$Data$declaredNonStaticMembers$2(p2).KClassImpl$Data$declaredNonStaticMembers$2(p4).PlaceComponentResult(p3);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0005\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0012\u0010\t\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0012\u0010\u0003\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0012\u0010\u000b\u001a\u00020\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0012\u0010\u000e\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/social/view/ModifyRelationshipSnackbar$Builder;", "", "", "BuiltInFictitiousFunctionClassFactory", "I", "MyBillsEntityDataFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "Landroid/view/View$OnClickListener;", "getAuthRequestContext", "Landroid/view/View$OnClickListener;", "moveToNextValue", "getErrorConfigVersion", "Landroid/view/ViewGroup;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/view/ViewGroup;", "lookAheadTest", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public int MyBillsEntityDataFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public String PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public final ViewGroup lookAheadTest;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        int KClassImpl$Data$declaredNonStaticMembers$2;
        public View.OnClickListener getAuthRequestContext;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public String getErrorConfigVersion;

        public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
        }

        public Builder(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.lookAheadTest = viewGroup;
            this.MyBillsEntityDataFactory = R.layout.view_modify_relationship_snackbar;
            this.getErrorConfigVersion = "";
            this.PlaceComponentResult = "";
            this.getAuthRequestContext = new View.OnClickListener() { // from class: id.dana.social.view.ModifyRelationshipSnackbar$Builder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ModifyRelationshipSnackbar.Builder.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            };
            this.BuiltInFictitiousFunctionClassFactory = -2;
        }
    }
}
