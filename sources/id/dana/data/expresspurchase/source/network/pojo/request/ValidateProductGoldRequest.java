package id.dana.data.expresspurchase.source.network.pojo.request;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/request/ValidateProductGoldRequest;", "", "", "bizParam", "Ljava/lang/String;", "getBizParam", "()Ljava/lang/String;", "goodsId", "getGoodsId", "secondaryBizParam", "getSecondaryBizParam", "", "validationInfo", "Ljava/util/Map;", "getValidationInfo", "()Ljava/util/Map;", "", "validationTypes", "Ljava/util/List;", "getValidationTypes", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ValidateProductGoldRequest {
    private final String bizParam;
    private final String goodsId;
    private final String secondaryBizParam;
    private final Map<String, Object> validationInfo;
    private final List<String> validationTypes;

    public ValidateProductGoldRequest(String str, String str2, String str3, List<String> list, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.goodsId = str;
        this.bizParam = str2;
        this.secondaryBizParam = str3;
        this.validationTypes = list;
        this.validationInfo = map;
    }

    public /* synthetic */ ValidateProductGoldRequest(String str, String str2, String str3, List list, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, list, map);
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getBizParam")
    public final String getBizParam() {
        return this.bizParam;
    }

    @JvmName(name = "getSecondaryBizParam")
    public final String getSecondaryBizParam() {
        return this.secondaryBizParam;
    }

    @JvmName(name = "getValidationTypes")
    public final List<String> getValidationTypes() {
        return this.validationTypes;
    }

    @JvmName(name = "getValidationInfo")
    public final Map<String, Object> getValidationInfo() {
        return this.validationInfo;
    }
}
