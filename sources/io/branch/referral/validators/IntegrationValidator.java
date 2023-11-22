package io.branch.referral.validators;

import android.net.Uri;
import android.text.TextUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import io.branch.referral.validators.ServerRequestGetAppConfig;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class IntegrationValidator implements ServerRequestGetAppConfig.IGetAppConfigEvents {
    private final BranchIntegrationModel MyBillsEntityDataFactory;

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String host = parse.getHost();
        if (TextUtils.isEmpty(host)) {
            host = "open";
        }
        if (this.MyBillsEntityDataFactory.MyBillsEntityDataFactory != null) {
            Iterator<String> keys = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.keys();
            boolean z = false;
            while (keys.hasNext()) {
                String next = keys.next();
                if (scheme != null && scheme.equals(next)) {
                    JSONArray optJSONArray = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.optJSONArray(next);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int i = 0;
                        while (true) {
                            if (i < optJSONArray.length()) {
                                if (host != null && host.equals(optJSONArray.optString(i))) {
                                    z = true;
                                    break;
                                }
                                i++;
                            } else {
                                break;
                            }
                        }
                    } else {
                        return true;
                    }
                }
            }
            return z;
        }
        return false;
    }

    private boolean BuiltInFictitiousFunctionClassFactory(String str) {
        if (!TextUtils.isEmpty(str) && this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            Iterator<String> it = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void PlaceComponentResult(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("** ERROR ** : ");
        sb.append(str);
        sb.append("\nPlease follow the link for more info ");
        sb.append(str2);
        InstrumentInjector.log_d("BranchSDK_Doctor", sb.toString());
    }

    @Override // io.branch.referral.validators.ServerRequestGetAppConfig.IGetAppConfigEvents
    public final void BuiltInFictitiousFunctionClassFactory(JSONObject jSONObject) {
        if (jSONObject == null) {
            PlaceComponentResult("Unable to read Dashboard config. Please confirm that your Branch key is properly added to the manifest. Please fix your Dashboard settings.", "https://branch.app.link/link-settings-page");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("3. Verifying application package name");
        sb.append(" ... ");
        InstrumentInjector.log_d("BranchSDK_Doctor", sb.toString());
        if (!this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.equals(jSONObject.optString("android_package_name"))) {
            PlaceComponentResult("Incorrect package name in Branch dashboard. Please correct your package name in dashboard -> link Settings page.", "https://docs.branch.io/pages/dashboard/integrate/#android");
            return;
        }
        InstrumentInjector.log_d("BranchSDK_Doctor", "Passed");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("4. Checking Android Manifest for URI based deep link config");
        sb2.append(" ... ");
        InstrumentInjector.log_d("BranchSDK_Doctor", sb2.toString());
        if (this.MyBillsEntityDataFactory.MyBillsEntityDataFactory == null || this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.length() == 0) {
            if (this.MyBillsEntityDataFactory.getAuthRequestContext) {
                PlaceComponentResult(String.format("No intent found for opening the app through uri Scheme '%s'.Please add the intent with URI scheme to your Android manifest.", jSONObject.optString("android_uri_scheme")), "https://docs.branch.io/pages/apps/android/#configure-app");
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("- Skipping. Unable to verify the deep link config. Failed to read the Android Manifest");
            sb3.append(" ... ");
            InstrumentInjector.log_d("BranchSDK_Doctor", sb3.toString());
        } else {
            InstrumentInjector.log_d("BranchSDK_Doctor", "Passed");
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("5. Verifying URI based deep link config with Branch dash board.");
        sb4.append(" ... ");
        InstrumentInjector.log_d("BranchSDK_Doctor", sb4.toString());
        String optString = jSONObject.optString("android_uri_scheme");
        if (TextUtils.isEmpty(optString)) {
            PlaceComponentResult("Uri Scheme to open your app is not specified in Branch dashboard. Please add URI scheme in Branch dashboard.", "https://docs.branch.io/pages/dashboard/integrate/#android");
            return;
        }
        InstrumentInjector.log_d("BranchSDK_Doctor", "Passed");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("6. Verifying intent for receiving URI scheme.");
        sb5.append(" ... ");
        InstrumentInjector.log_d("BranchSDK_Doctor", sb5.toString());
        if (!KClassImpl$Data$declaredNonStaticMembers$2(optString)) {
            if (this.MyBillsEntityDataFactory.getAuthRequestContext) {
                PlaceComponentResult(String.format("Uri scheme '%s' specified in Branch dashboard doesn't match with the deep link intent in manifest file", optString), "https://docs.branch.io/pages/dashboard/integrate/#android");
                return;
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("- Skipping. Unable to verify intent for receiving URI scheme. Failed to read the Android Manifest");
            sb6.append(" ... ");
            InstrumentInjector.log_d("BranchSDK_Doctor", sb6.toString());
        } else {
            InstrumentInjector.log_d("BranchSDK_Doctor", "Passed");
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append("7. Checking AndroidManifest for AppLink config.");
        sb7.append(" ... ");
        InstrumentInjector.log_d("BranchSDK_Doctor", sb7.toString());
        if (this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
            if (this.MyBillsEntityDataFactory.getAuthRequestContext) {
                PlaceComponentResult("Could not find any App Link hosts to support Android AppLinks. Please add intent filter for handling AppLinks in your Android Manifest file", "https://docs.branch.io/pages/deep-linking/android-app-links/#add-intent-filter-to-manifest");
                return;
            }
            StringBuilder sb8 = new StringBuilder();
            sb8.append("- Skipping. Unable to verify intent for receiving URI scheme. Failed to read the Android Manifest");
            sb8.append(" ... ");
            InstrumentInjector.log_d("BranchSDK_Doctor", sb8.toString());
        } else {
            InstrumentInjector.log_d("BranchSDK_Doctor", "Passed");
        }
        StringBuilder sb9 = new StringBuilder();
        sb9.append("8. Verifying any supported custom link domains.");
        sb9.append(" ... ");
        InstrumentInjector.log_d("BranchSDK_Doctor", sb9.toString());
        String optString2 = jSONObject.optString("short_url_domain");
        if (!TextUtils.isEmpty(optString2) && !BuiltInFictitiousFunctionClassFactory(optString2)) {
            if (this.MyBillsEntityDataFactory.getAuthRequestContext) {
                PlaceComponentResult(String.format("Could not find intent filter to support custom link domain '%s'. Please add intent filter for handling custom link domain in your Android Manifest file ", optString2), "https://docs.branch.io/pages/apps/android/#configure-app");
                return;
            }
            StringBuilder sb10 = new StringBuilder();
            sb10.append("- Skipping. Unable to verify supported custom link domains. Failed to read the Android Manifest");
            sb10.append(" ... ");
            InstrumentInjector.log_d("BranchSDK_Doctor", sb10.toString());
        } else {
            InstrumentInjector.log_d("BranchSDK_Doctor", "Passed");
        }
        StringBuilder sb11 = new StringBuilder();
        sb11.append("9. Verifying default link domains integrations.");
        sb11.append(" ... ");
        InstrumentInjector.log_d("BranchSDK_Doctor", sb11.toString());
        String optString3 = jSONObject.optString("default_short_url_domain");
        if (!TextUtils.isEmpty(optString3) && !BuiltInFictitiousFunctionClassFactory(optString3)) {
            if (this.MyBillsEntityDataFactory.getAuthRequestContext) {
                PlaceComponentResult(String.format("Could not find intent filter to support Branch default link domain '%s'. Please add intent filter for handling custom link domain in your Android Manifest file ", optString3), "https://docs.branch.io/pages/apps/android/#configure-app");
                return;
            }
            StringBuilder sb12 = new StringBuilder();
            sb12.append("- Skipping. Unable to verify default link domains. Failed to read the Android Manifest");
            sb12.append(" ... ");
            InstrumentInjector.log_d("BranchSDK_Doctor", sb12.toString());
        } else {
            InstrumentInjector.log_d("BranchSDK_Doctor", "Passed");
        }
        StringBuilder sb13 = new StringBuilder();
        sb13.append("10. Verifying alternate link domains integrations.");
        sb13.append(" ... ");
        InstrumentInjector.log_d("BranchSDK_Doctor", sb13.toString());
        String optString4 = jSONObject.optString("alternate_short_url_domain");
        if (!TextUtils.isEmpty(optString4) && !BuiltInFictitiousFunctionClassFactory(optString4)) {
            if (this.MyBillsEntityDataFactory.getAuthRequestContext) {
                PlaceComponentResult(String.format("Could not find intent filter to support alternate link domain '%s'. Please add intent filter for handling custom link domain in your Android Manifest file ", optString4), "https://docs.branch.io/pages/apps/android/#configure-app");
                return;
            }
            StringBuilder sb14 = new StringBuilder();
            sb14.append("- Skipping.Unable to verify alternate link domains. Failed to read the Android Manifest");
            sb14.append(" ... ");
            InstrumentInjector.log_d("BranchSDK_Doctor", sb14.toString());
        } else {
            InstrumentInjector.log_d("BranchSDK_Doctor", "Passed");
        }
        InstrumentInjector.log_d("BranchSDK_Doctor", "Passed");
        InstrumentInjector.log_d("BranchSDK_Doctor", "--------------------------------------------\nSuccessfully completed Branch integration validation. Everything looks good!");
        InstrumentInjector.log_d("BranchSDK_Doctor", "\n         Great! Comment out the 'validateSDKIntegration' line in your app. Next check your deep link routing.\n         Append '?bnc_validate=true' to any of your app's Branch links and click it on your mobile device (not the Simulator!) to start the test.\n         For instance, to validate a link like:\n         https://<yourapp>.app.link/NdJ6nFzRbK\n         click on:\n         https://<yourapp>.app.link/NdJ6nFzRbK?bnc_validate=true");
    }
}
