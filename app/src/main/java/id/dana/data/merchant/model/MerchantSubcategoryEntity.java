package id.dana.data.merchant.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MerchantSubcategoryEntity implements Serializable {
    public String Name;
    @JSONField(name = "mc_id")
    public String categoryId;
    public List<String> categoryIds = new ArrayList();
    public String mcc;
}
