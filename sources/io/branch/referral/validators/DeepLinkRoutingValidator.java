package io.branch.referral.validators;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import id.dana.data.constant.BranchLinkConstant;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.PrefHelper;
import java.lang.ref.WeakReference;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DeepLinkRoutingValidator {
    private static WeakReference<Activity> MyBillsEntityDataFactory;

    public static void KClassImpl$Data$declaredNonStaticMembers$2(WeakReference<Activity> weakReference) {
        String str;
        AlertDialog.Builder builder;
        AlertDialog.Builder builder2;
        MyBillsEntityDataFactory = weakReference;
        if (Branch.BuiltInFictitiousFunctionClassFactory() != null) {
            Branch BuiltInFictitiousFunctionClassFactory = Branch.BuiltInFictitiousFunctionClassFactory();
            PrefHelper prefHelper = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params"))) != null) {
                Branch BuiltInFictitiousFunctionClassFactory2 = Branch.BuiltInFictitiousFunctionClassFactory();
                PrefHelper prefHelper2 = BuiltInFictitiousFunctionClassFactory2.NetworkUserEntityData$$ExternalSyntheticLambda1;
                JSONObject BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params")));
                StringBuilder sb = new StringBuilder();
                sb.append("~");
                sb.append(Defines.Jsonkey.ReferringLink.getKey());
                str = BuiltInFictitiousFunctionClassFactory3.optString(sb.toString());
                if (!TextUtils.isEmpty(str) || weakReference == null) {
                }
                Branch BuiltInFictitiousFunctionClassFactory4 = Branch.BuiltInFictitiousFunctionClassFactory();
                PrefHelper prefHelper3 = BuiltInFictitiousFunctionClassFactory4.NetworkUserEntityData$$ExternalSyntheticLambda1;
                final JSONObject BuiltInFictitiousFunctionClassFactory5 = BuiltInFictitiousFunctionClassFactory4.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params")));
                if (BuiltInFictitiousFunctionClassFactory5.optInt("_branch_validate") == 60514) {
                    if (BuiltInFictitiousFunctionClassFactory5.optBoolean(Defines.Jsonkey.Clicked_Branch_Link.getKey())) {
                        if (MyBillsEntityDataFactory.get() != null) {
                            if (Build.VERSION.SDK_INT >= 21) {
                                builder2 = new AlertDialog.Builder(MyBillsEntityDataFactory.get(), 16974374);
                            } else {
                                builder2 = new AlertDialog.Builder(MyBillsEntityDataFactory.get());
                            }
                            builder2.setTitle("Branch Deeplinking Routing").setMessage("Good news - we got link data. Now a question for you, astute developer: did the app deep link to the specific piece of content you expected to see?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: io.branch.referral.validators.DeepLinkRoutingValidator.4
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    DeepLinkRoutingValidator.getAuthRequestContext(DeepLinkRoutingValidator.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory5, "g"));
                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: io.branch.referral.validators.DeepLinkRoutingValidator.3
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    DeepLinkRoutingValidator.getAuthRequestContext(DeepLinkRoutingValidator.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory5, BranchLinkConstant.PayloadKey.REFERRAL));
                                }
                            }).setNeutralButton(17039360, new DialogInterface.OnClickListener() { // from class: io.branch.referral.validators.DeepLinkRoutingValidator.2
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }).setCancelable(false).setIcon(17301651).show();
                            return;
                        }
                        return;
                    } else if (MyBillsEntityDataFactory.get() != null) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            builder = new AlertDialog.Builder(MyBillsEntityDataFactory.get(), 16974374);
                        } else {
                            builder = new AlertDialog.Builder(MyBillsEntityDataFactory.get());
                        }
                        builder.setTitle("Branch Deeplink Routing Support").setMessage("Bummer. It seems like +clicked_branch_link is false - we didn't deep link.  Double check that the link you're clicking has the same branch_key that is being used in your Manifest file. Return to Chrome when you're ready to test again.").setNeutralButton("Got it", new DialogInterface.OnClickListener() { // from class: io.branch.referral.validators.DeepLinkRoutingValidator.5
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).setCancelable(false).setIcon(17301651).show();
                        return;
                    } else {
                        return;
                    }
                } else if (BuiltInFictitiousFunctionClassFactory5.optBoolean("bnc_validate")) {
                    new Handler().postDelayed(new Runnable() { // from class: io.branch.referral.validators.DeepLinkRoutingValidator.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            DeepLinkRoutingValidator.getAuthRequestContext(DeepLinkRoutingValidator.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory5, ""));
                        }
                    }, 500L);
                    return;
                } else {
                    return;
                }
            }
        }
        str = "";
        if (TextUtils.isEmpty(str)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String MyBillsEntityDataFactory(org.json.JSONObject r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.validators.DeepLinkRoutingValidator.MyBillsEntityDataFactory(org.json.JSONObject, java.lang.String):java.lang.String");
    }

    static /* synthetic */ void getAuthRequestContext(String str) {
        if (MyBillsEntityDataFactory.get() != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str).buildUpon().appendQueryParameter("$uri_redirect_mode", "2").build());
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setPackage("com.android.chrome");
            MyBillsEntityDataFactory.get().getPackageManager().queryIntentActivities(intent, 0);
            try {
                MyBillsEntityDataFactory.get().startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                intent.setPackage(null);
                MyBillsEntityDataFactory.get().startActivity(intent);
            }
        }
    }
}
