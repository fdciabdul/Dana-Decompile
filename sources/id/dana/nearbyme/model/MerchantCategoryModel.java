package id.dana.nearbyme.model;

import android.text.TextUtils;
import id.dana.base.BaseResponse;
import id.dana.nearbyme.MerchantViewType;

/* loaded from: classes5.dex */
public class MerchantCategoryModel extends BaseResponse {
    public static final MerchantCategoryModel BuiltInFictitiousFunctionClassFactory = new MerchantCategoryModel(MerchantViewType.MERCHANT_CAT_ALL, "All");
    public String MyBillsEntityDataFactory;
    public String getAuthRequestContext;

    public MerchantCategoryModel() {
    }

    private MerchantCategoryModel(String str, String str2) {
        this.MyBillsEntityDataFactory = str;
        this.getAuthRequestContext = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MerchantCategoryModel) {
            return TextUtils.equals(this.MyBillsEntityDataFactory, ((MerchantCategoryModel) obj).MyBillsEntityDataFactory);
        }
        return false;
    }

    public int hashCode() {
        return this.MyBillsEntityDataFactory.hashCode();
    }
}
