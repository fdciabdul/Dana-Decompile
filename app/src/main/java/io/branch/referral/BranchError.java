package io.branch.referral;

import com.alipay.plus.security.lite.SecLiteException;
import id.dana.data.constant.BranchLinkConstant;

/* loaded from: classes.dex */
public class BranchError {
    public String BuiltInFictitiousFunctionClassFactory;
    public int MyBillsEntityDataFactory;

    public BranchError(String str, int i) {
        String str2;
        this.BuiltInFictitiousFunctionClassFactory = "";
        this.MyBillsEntityDataFactory = -113;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (i == -113) {
            this.MyBillsEntityDataFactory = -113;
            str2 = " Branch API Error: poor network connectivity. Please try again later.";
        } else if (i == -114) {
            this.MyBillsEntityDataFactory = -114;
            str2 = " Branch API Error: Please enter your branch_key in your project's manifest file first.";
        } else if (i == -104) {
            this.MyBillsEntityDataFactory = -104;
            str2 = " Did you forget to call init? Make sure you init the session before making Branch calls.";
        } else if (i == -101) {
            this.MyBillsEntityDataFactory = SecLiteException.ERROR_API_KEY_OR_SIGN;
            str2 = " Unable to initialize Branch. Check network connectivity or that your branch key is valid.";
        } else if (i == -102) {
            this.MyBillsEntityDataFactory = -102;
            str2 = " Please add 'android.permission.INTERNET' in your applications manifest file.";
        } else if (i == -105) {
            this.MyBillsEntityDataFactory = BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS;
            str2 = " Unable to create a URL with that alias. If you want to reuse the alias, make sure to submit the same properties for all arguments and that the user is the same owner.";
        } else if (i == -106) {
            this.MyBillsEntityDataFactory = -106;
            str2 = " That Branch referral code is already in use.";
        } else if (i == -107) {
            this.MyBillsEntityDataFactory = -107;
            str2 = " Unable to redeem rewards. Please make sure you have credits available to redeem.";
        } else if (i == -108) {
            this.MyBillsEntityDataFactory = -108;
            str2 = "BranchApp class can be used only with API level 14 or above. Please make sure your minimum API level supported is 14. If you wish to use API level below 14 consider calling getInstance(Context) instead.";
        } else if (i == -109) {
            this.MyBillsEntityDataFactory = -109;
            str2 = "Branch instance is not created. Make  sure your Application class is an instance of BranchLikedApp.";
        } else if (i == -110) {
            this.MyBillsEntityDataFactory = -110;
            str2 = " Unable create share options. Couldn't find applications on device to share the link.";
        } else if (i == -111) {
            this.MyBillsEntityDataFactory = -111;
            str2 = " Request to Branch server timed out. Please check your internet connectivity";
        } else if (i == -117) {
            this.MyBillsEntityDataFactory = -117;
            str2 = " Tracking is disabled. Requested operation cannot be completed when tracking is disabled";
        } else if (i >= 500 || i == -112) {
            this.MyBillsEntityDataFactory = -112;
            str2 = " Unable to reach the Branch servers, please try again shortly.";
        } else if (i == 409 || i == -115) {
            this.MyBillsEntityDataFactory = -115;
            str2 = " A resource with this identifier already exists.";
        } else if (i >= 400 || i == -116) {
            this.MyBillsEntityDataFactory = -116;
            str2 = " The request was invalid.";
        } else {
            this.MyBillsEntityDataFactory = -113;
            str2 = " Check network connectivity and that you properly initialized.";
        }
        sb.append(str2);
        this.BuiltInFictitiousFunctionClassFactory = sb.toString();
    }

    public String toString() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
