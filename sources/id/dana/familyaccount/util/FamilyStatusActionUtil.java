package id.dana.familyaccount.util;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import id.dana.R;
import id.dana.animation.HomeTabActivity;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.domain.familyaccount.model.ConsultFamilyAccountResult;
import id.dana.familyaccount.constants.FamilyAccountRoleType;
import id.dana.familyaccount.constants.FamilyStatusConsultConstant;
import id.dana.familyaccount.view.dashboard.MemberDashboardActivity;
import id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity;
import id.dana.familyaccount.view.intro.FamilyAccountIntroActivity;
import id.dana.familyaccount.view.statusinformation.FamilyStatusInformationActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\f\u0010\u0014J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\n\u0010\u0015"}, d2 = {"Lid/dana/familyaccount/util/FamilyStatusActionUtil;", "", "Landroid/content/Context;", "p0", "", "PlaceComponentResult", "(Landroid/content/Context;)V", "", "p1", "p2", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "MyBillsEntityDataFactory", "(Landroid/content/Context;Ljava/lang/String;)V", "Lid/dana/domain/familyaccount/model/ConsultFamilyAccountResult;", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "p3", "getAuthRequestContext", "(Landroid/content/Context;Lid/dana/domain/familyaccount/model/ConsultFamilyAccountResult;Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "(Lid/dana/domain/familyaccount/model/ConsultFamilyAccountResult;Landroid/content/Context;Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "(Landroid/content/Context;Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FamilyStatusActionUtil {
    public static final FamilyStatusActionUtil INSTANCE = new FamilyStatusActionUtil();

    private FamilyStatusActionUtil() {
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory(ConsultFamilyAccountResult p0, Context p1, DynamicUrlWrapper p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        String status = p0.getStatus();
        switch (status.hashCode()) {
            case -1824356621:
                if (!status.equals("MAINTENANCE")) {
                    return;
                }
                KClassImpl$Data$declaredNonStaticMembers$2(p1, p0.getStatus(), p0.getRole());
                return;
            case -768982881:
                if (!status.equals(FamilyStatusConsultConstant.HAS_NOT_FAMILY_ACCOUNT_CANNOT_CREATE)) {
                    return;
                }
                p1.startActivity(new Intent(p1, FamilyAccountIntroActivity.class));
                return;
            case -650724201:
                if (status.equals(FamilyStatusConsultConstant.HAS_FAMILY_ACCOUNT)) {
                    MyBillsEntityDataFactory(p1, p0.getRole());
                    return;
                }
                return;
            case -86067292:
                if (status.equals("ORGANIZER_KYC_REVOKED")) {
                    KClassImpl$Data$declaredNonStaticMembers$2(p1, p2);
                    return;
                }
                return;
            case 935359716:
                if (!status.equals(FamilyStatusConsultConstant.HAS_NOT_FAMILY_ACCOUNT_CAN_CREATE)) {
                    return;
                }
                p1.startActivity(new Intent(p1, FamilyAccountIntroActivity.class));
                return;
            case 1136849717:
                if (!status.equals("ORGANIZER_HAS_FROZEN")) {
                    return;
                }
                KClassImpl$Data$declaredNonStaticMembers$2(p1, p0.getStatus(), p0.getRole());
                return;
            case 1622177143:
                if (status.equals(FamilyStatusConsultConstant.ACCOUNT_HAS_FROZEN)) {
                    PlaceComponentResult(p1);
                    return;
                }
                return;
            case 1818119806:
                if (!status.equals("REVOKED")) {
                    return;
                }
                KClassImpl$Data$declaredNonStaticMembers$2(p1, p0.getStatus(), p0.getRole());
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0072, code lost:
    
        if (r1.equals("ORGANIZER_HAS_FROZEN") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0087, code lost:
    
        if (r1.equals(id.dana.familyaccount.constants.FamilyStatusConsultConstant.HAS_NOT_FAMILY_ACCOUNT_CAN_CREATE) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ac, code lost:
    
        if (r1.equals(id.dana.familyaccount.constants.FamilyStatusConsultConstant.HAS_NOT_FAMILY_ACCOUNT_CANNOT_CREATE) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ae, code lost:
    
        r3.startActivity(new android.content.Intent(r3, id.dana.familyaccount.view.intro.FamilyAccountIntroActivity.class));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b8, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bf, code lost:
    
        if (r1.equals("MAINTENANCE") != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c1, code lost:
    
        KClassImpl$Data$declaredNonStaticMembers$2(r3, r4.getStatus(), r4.getRole());
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cc, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        if (r1.equals("REVOKED") == false) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e8  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void getAuthRequestContext(android.content.Context r3, id.dana.domain.familyaccount.model.ConsultFamilyAccountResult r4, final com.anggrayudi.storage.permission.FragmentPermissionRequest r5, id.dana.data.dynamicurl.DynamicUrlWrapper r6) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r1 = r4.getStatus()
            int r2 = r1.hashCode()
            switch(r2) {
                case -1824356621: goto Lb9;
                case -768982881: goto La6;
                case -650724201: goto L96;
                case -86067292: goto L8a;
                case 935359716: goto L81;
                case 944938249: goto L75;
                case 1136849717: goto L6c;
                case 1622177143: goto L25;
                case 1818119806: goto L1b;
                default: goto L19;
            }
        L19:
            goto Lcd
        L1b:
            java.lang.String r5 = "REVOKED"
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto Lc1
            goto Lcd
        L25:
            java.lang.String r4 = "ACCOUNT_HAS_FROZEN"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto Lcd
            id.dana.component.dialogcomponent.CustomDialog$Builder r4 = new id.dana.component.dialogcomponent.CustomDialog$Builder
            r4.<init>(r3)
            r6 = r4
            id.dana.component.dialogcomponent.CustomDialog$Builder r6 = (id.dana.component.dialogcomponent.CustomDialog.Builder) r6
            r6 = 2131233029(0x7f080905, float:1.8082184E38)
            r4.DatabaseTableConfigUtil = r6
            r6 = 2131953566(0x7f13079e, float:1.9543607E38)
            java.lang.String r6 = r3.getString(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.SubSequence = r6
            r6 = 2131953567(0x7f13079f, float:1.9543609E38)
            java.lang.String r6 = r3.getString(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.GetContactSyncConfig = r6
            r6 = 2131953682(0x7f130812, float:1.9543842E38)
            java.lang.String r3 = r3.getString(r6)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            id.dana.familyaccount.util.FamilyStatusActionUtil$actionFamilyAccountFreeze$2 r6 = new id.dana.familyaccount.util.FamilyStatusActionUtil$actionFamilyAccountFreeze$2
            r6.<init>()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            id.dana.component.dialogcomponent.CustomDialog$Builder r3 = r4.BuiltInFictitiousFunctionClassFactory(r3, r6)
            com.afollestad.materialdialogs.MaterialDialog r3 = r3.BuiltInFictitiousFunctionClassFactory()
            r3.show()
            return
        L6c:
            java.lang.String r5 = "ORGANIZER_HAS_FROZEN"
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto Lc1
            goto Lcd
        L75:
            java.lang.String r4 = "ACCOUNT_FREEZE"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto Lcd
            PlaceComponentResult(r3)
            return
        L81:
            java.lang.String r4 = "HAS_NOT_FAMILY_ACCOUNT|CAN_CREATE"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto Lae
            goto Lcd
        L8a:
            java.lang.String r4 = "ORGANIZER_KYC_REVOKED"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto Lcd
            KClassImpl$Data$declaredNonStaticMembers$2(r3, r6)
            return
        L96:
            java.lang.String r5 = "HAS_FAMILY_ACCOUNT"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto Lcd
            java.lang.String r4 = r4.getRole()
            MyBillsEntityDataFactory(r3, r4)
            return
        La6:
            java.lang.String r4 = "HAS_NOT_FAMILY_ACCOUNT|CANNOT_CREATE"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto Lcd
        Lae:
            android.content.Intent r4 = new android.content.Intent
            java.lang.Class<id.dana.familyaccount.view.intro.FamilyAccountIntroActivity> r5 = id.dana.familyaccount.view.intro.FamilyAccountIntroActivity.class
            r4.<init>(r3, r5)
            r3.startActivity(r4)
            return
        Lb9:
            java.lang.String r5 = "MAINTENANCE"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto Lcd
        Lc1:
            java.lang.String r5 = r4.getStatus()
            java.lang.String r4 = r4.getRole()
            KClassImpl$Data$declaredNonStaticMembers$2(r3, r5, r4)
            return
        Lcd:
            id.dana.utils.DANAToast r4 = id.dana.utils.DANAToast.PlaceComponentResult
            boolean r4 = r3 instanceof android.app.Activity
            if (r4 == 0) goto Ld7
            r4 = r3
            android.app.Activity r4 = (android.app.Activity) r4
            goto Ld8
        Ld7:
            r4 = 0
        Ld8:
            if (r4 == 0) goto Le8
            r5 = 2131953569(0x7f1307a1, float:1.9543613E38)
            java.lang.String r3 = r3.getString(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            id.dana.utils.DANAToast.PlaceComponentResult(r4, r3)
            return
        Le8:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Required value was null."
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.util.FamilyStatusActionUtil.getAuthRequestContext(android.content.Context, id.dana.domain.familyaccount.model.ConsultFamilyAccountResult, com.anggrayudi.storage.permission.FragmentPermissionRequest, id.dana.data.dynamicurl.DynamicUrlWrapper):void");
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(Context p0, final DynamicUrlWrapper p1) {
        CustomDialog.Builder builder = new CustomDialog.Builder(p0);
        builder.DatabaseTableConfigUtil = R.drawable.ic_family_account_kyc_revoked;
        builder.SubSequence = p0.getString(R.string.family_account_text_organizer_summary_kyc_revoke_title);
        builder.GetContactSyncConfig = p0.getString(R.string.family_account_text_organizer_summary_kyc_revoke_desc);
        builder.BuiltInFictitiousFunctionClassFactory(p0.getString(R.string.upgrade), new Function1<View, Unit>() { // from class: id.dana.familyaccount.util.FamilyStatusActionUtil$showDialogKycOrganizerRevoked$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                StringBuilder sb = new StringBuilder();
                sb.append("https://m.dana.id");
                sb.append(DynamicUrlWrapper.this.getKycFromProfileUrl());
                DanaH5.startContainerFullUrl(sb.toString());
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(p0.getString(R.string.sendmoney_upgrade_kyc_dialog_button_negative), new Function1<View, Unit>() { // from class: id.dana.familyaccount.util.FamilyStatusActionUtil$showDialogKycOrganizerRevoked$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        }).BuiltInFictitiousFunctionClassFactory().show();
    }

    private static void PlaceComponentResult(final Context p0) {
        CustomDialog.Builder builder = new CustomDialog.Builder(p0);
        builder.DatabaseTableConfigUtil = R.drawable.res_0x7f080905_networkuserentitydata_externalsyntheticlambda0;
        builder.SubSequence = p0.getString(R.string.family_account_freeze);
        builder.GetContactSyncConfig = p0.getString(R.string.family_account_freeze_description);
        builder.BuiltInFictitiousFunctionClassFactory(p0.getString(R.string.family_contact_cs), new Function1<View, Unit>() { // from class: id.dana.familyaccount.util.FamilyStatusActionUtil$actionFamilyAccountFreeze$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ActivityPermissionRequest phonePermission;
                Intrinsics.checkNotNullParameter(view, "");
                Context context = p0;
                HomeTabActivity homeTabActivity = context instanceof HomeTabActivity ? (HomeTabActivity) context : null;
                if (homeTabActivity == null || (phonePermission = homeTabActivity.getPhonePermission()) == null) {
                    return;
                }
                phonePermission.check();
            }
        }).BuiltInFictitiousFunctionClassFactory().show();
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(Context p0, String p1, String p2) {
        Intent intent = new Intent(p0, FamilyStatusInformationActivity.class);
        intent.putExtra(FamilyStatusInformationActivity.FAMILY_STATUS, p1);
        intent.putExtra("ROLE", p2);
        p0.startActivity(intent);
    }

    private static void MyBillsEntityDataFactory(Context p0, String p1) {
        if (Intrinsics.areEqual(p1, FamilyAccountRoleType.ORGANIZER)) {
            p0.startActivity(new Intent(p0, OrganizerDashboardActivity.class));
        } else if (Intrinsics.areEqual(p1, "MEMBER")) {
            p0.startActivity(new Intent(p0, MemberDashboardActivity.class));
        }
    }
}
