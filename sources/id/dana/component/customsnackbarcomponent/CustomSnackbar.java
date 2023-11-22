package id.dana.component.customsnackbarcomponent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.ContentViewCallback;
import id.dana.component.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0001:\u0002\u0011\u0012B)\b\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "Lcom/google/android/material/snackbar/BaseTransientBottomBar;", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar$Builder;", "PlaceComponentResult", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar$Builder;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "p0", "Landroid/view/View;", "p1", "Lcom/google/android/material/snackbar/ContentViewCallback;", "p2", "p3", "<init>", "(Landroid/view/ViewGroup;Landroid/view/View;Lcom/google/android/material/snackbar/ContentViewCallback;Lid/dana/component/customsnackbarcomponent/CustomSnackbar$Builder;)V", "Builder", "Callback"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class CustomSnackbar extends BaseTransientBottomBar<CustomSnackbar> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Builder BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ViewGroup PlaceComponentResult;

    public /* synthetic */ CustomSnackbar(ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback, Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, view, contentViewCallback, builder);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private CustomSnackbar(android.view.ViewGroup r3, android.view.View r4, com.google.android.material.snackbar.ContentViewCallback r5, id.dana.component.customsnackbarcomponent.CustomSnackbar.Builder r6) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.component.customsnackbarcomponent.CustomSnackbar.<init>(android.view.ViewGroup, android.view.View, com.google.android.material.snackbar.ContentViewCallback, id.dana.component.customsnackbarcomponent.CustomSnackbar$Builder):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/component/customsnackbarcomponent/CustomSnackbar$Callback;", "Lcom/google/android/material/snackbar/ContentViewCallback;", "", "p0", "p1", "", "animateContentIn", "(II)V", "animateContentOut", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/View;", "PlaceComponentResult", "<init>", "(Landroid/view/View;)V"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public static final class Callback implements ContentViewCallback {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final View PlaceComponentResult;

        public Callback(View view) {
            Intrinsics.checkNotNullParameter(view, "");
            this.PlaceComponentResult = view;
        }

        @Override // com.google.android.material.snackbar.ContentViewCallback
        public final void animateContentIn(int p0, int p1) {
            ViewCompat.PlaceComponentResult(this.PlaceComponentResult, 0.0f);
            ViewPropertyAnimatorCompat KClassImpl$Data$declaredNonStaticMembers$2 = ViewCompat.MyBillsEntityDataFactory(this.PlaceComponentResult).KClassImpl$Data$declaredNonStaticMembers$2(1.0f).KClassImpl$Data$declaredNonStaticMembers$2(p1);
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(p0);
        }

        @Override // com.google.android.material.snackbar.ContentViewCallback
        public final void animateContentOut(int p0, int p1) {
            ViewCompat.PlaceComponentResult(this.PlaceComponentResult, 1.0f);
            ViewPropertyAnimatorCompat KClassImpl$Data$declaredNonStaticMembers$2 = ViewCompat.MyBillsEntityDataFactory(this.PlaceComponentResult).KClassImpl$Data$declaredNonStaticMembers$2(0.0f).KClassImpl$Data$declaredNonStaticMembers$2(p1);
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(p0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0012\u0010\r\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0012\u0010\u0007\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0012\u0010\u0013\u001a\u00020\tX\u0080\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0012\u0010\u0014\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R \u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0019R\u0012\u0010\u001d\u001a\u00020\u001aX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\fX\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u000eR\u0016\u0010\u001b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\nR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010!"}, d2 = {"Lid/dana/component/customsnackbarcomponent/CustomSnackbar$Builder;", "", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "Lid/dana/component/customsnackbarcomponent/SnackbarState;", "p0", "MyBillsEntityDataFactory", "(Lid/dana/component/customsnackbarcomponent/SnackbarState;)Lid/dana/component/customsnackbarcomponent/CustomSnackbar$Builder;", "", "I", "getAuthRequestContext", "", "PlaceComponentResult", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "scheduleImpl", "lookAheadTest", "getErrorConfigVersion", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "Lkotlin/Function1;", "", "Lkotlin/jvm/functions/Function1;", "Lid/dana/component/customsnackbarcomponent/SnackbarPosition;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/component/customsnackbarcomponent/SnackbarPosition;", "GetContactSyncConfig", "initRecordTimeStamp", "DatabaseTableConfigUtil", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public int getAuthRequestContext;

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        public int NetworkUserEntityData$$ExternalSyntheticLambda1;

        /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
        public String initRecordTimeStamp;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        String BuiltInFictitiousFunctionClassFactory;
        public int MyBillsEntityDataFactory;
        public int NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        public SnackbarPosition GetContactSyncConfig;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public int PlaceComponentResult;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public int moveToNextValue;

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        private final ViewGroup NetworkUserEntityData$$ExternalSyntheticLambda2;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public View.OnClickListener scheduleImpl;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public Function1<? super CustomSnackbar, Unit> getErrorConfigVersion;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public String lookAheadTest;

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes4.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] PlaceComponentResult;

            static {
                int[] iArr = new int[SnackbarState.values().length];
                PlaceComponentResult = iArr;
                iArr[SnackbarState.SUCCESS.ordinal()] = 1;
                iArr[SnackbarState.FAIL.ordinal()] = 2;
                iArr[SnackbarState.WARNING.ordinal()] = 3;
                iArr[SnackbarState.GENERAL.ordinal()] = 4;
            }
        }

        public Builder(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = viewGroup;
            this.getAuthRequestContext = 10;
            this.PlaceComponentResult = R.layout.view_custom_overlays_snackbar;
            this.GetContactSyncConfig = SnackbarPosition.BOTTOM;
            this.moveToNextValue = -2;
        }

        public final Builder MyBillsEntityDataFactory(SnackbarState p0) {
            int i;
            Intrinsics.checkNotNullParameter(p0, "");
            int i2 = WhenMappings.PlaceComponentResult[p0.ordinal()];
            if (i2 == 1) {
                i = R.drawable.res_0x7f0805b8_networkuserentitydata_externalsyntheticlambda2;
            } else if (i2 == 2) {
                i = R.drawable.bg_snackbar_state_fail;
            } else if (i2 == 3) {
                i = R.drawable.bg_snackbar_state_warning;
            } else if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                i = R.drawable.bg_snackbar_state_general;
            }
            this.MyBillsEntityDataFactory = i;
            return this;
        }

        public final CustomSnackbar BuiltInFictitiousFunctionClassFactory() {
            View inflate = LayoutInflater.from(this.NetworkUserEntityData$$ExternalSyntheticLambda2.getContext()).inflate(this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda2, false);
            ViewGroup viewGroup = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            Intrinsics.checkNotNullExpressionValue(inflate, "");
            return new CustomSnackbar(viewGroup, inflate, new Callback(inflate), this, null);
        }
    }
}
