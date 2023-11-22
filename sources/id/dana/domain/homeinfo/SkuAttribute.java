package id.dana.domain.homeinfo;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.danah5.DanaH5;
import id.dana.domain.globalsearch.model.ProductBizId;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b>\u0010?J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0005J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J²\u0001\u0010 \u001a\u00020\u00002\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b)\u0010\u0007R$\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010*\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010-R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b.\u0010\u0007R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010*\u001a\u0004\b/\u0010\u0007R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b0\u0010\u0007R$\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010*\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010-R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010*\u001a\u0004\b3\u0010\u0007R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u00104\u001a\u0004\b5\u0010\u0005R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u00104\u001a\u0004\b6\u0010\u0005R$\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00107\u001a\u0004\b8\u0010\u0013\"\u0004\b9\u0010:R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u00104\u001a\u0004\b;\u0010\u0005R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b<\u0010\u0007R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b=\u0010\u0007"}, d2 = {"Lid/dana/domain/homeinfo/SkuAttribute;", "", "", "", "component1", "()Ljava/util/List;", "component10", "()Ljava/lang/String;", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "Lid/dana/domain/globalsearch/model/ProductBizId;", "component9", "()Lid/dana/domain/globalsearch/model/ProductBizId;", DanaH5.SERVICE_KEY, "prepaidKey", "postpaidKey", "backgroundColor", "title", "icon", "buttonDescription", "serviceName", "productBizId", "key", "link", "appId", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/globalsearch/model/ProductBizId;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/homeinfo/SkuAttribute;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAppId", "setAppId", "(Ljava/lang/String;)V", "getBackgroundColor", "getButtonDescription", "getIcon", "getKey", "setKey", "getLink", "Ljava/util/List;", "getPostpaidKey", "getPrepaidKey", "Lid/dana/domain/globalsearch/model/ProductBizId;", "getProductBizId", "setProductBizId", "(Lid/dana/domain/globalsearch/model/ProductBizId;)V", "getServiceKey", "getServiceName", "getTitle", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/globalsearch/model/ProductBizId;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SkuAttribute {
    private String appId;
    private final String backgroundColor;
    private final String buttonDescription;
    private final String icon;
    private String key;
    private final String link;
    private final List<String> postpaidKey;
    private final List<String> prepaidKey;
    private ProductBizId productBizId;
    private final List<String> serviceKey;
    private final String serviceName;
    private final String title;

    public SkuAttribute() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, ARiverTrackWatchDogEventConstant.STARTUP_FLAG, null);
    }

    public final List<String> component1() {
        return this.serviceKey;
    }

    /* renamed from: component10  reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component11  reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* renamed from: component12  reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    public final List<String> component2() {
        return this.prepaidKey;
    }

    public final List<String> component3() {
        return this.postpaidKey;
    }

    /* renamed from: component4  reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: component5  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component6  reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component7  reason: from getter */
    public final String getButtonDescription() {
        return this.buttonDescription;
    }

    /* renamed from: component8  reason: from getter */
    public final String getServiceName() {
        return this.serviceName;
    }

    /* renamed from: component9  reason: from getter */
    public final ProductBizId getProductBizId() {
        return this.productBizId;
    }

    public final SkuAttribute copy(List<String> serviceKey, List<String> prepaidKey, List<String> postpaidKey, String backgroundColor, String title, String icon, String buttonDescription, String serviceName, ProductBizId productBizId, String key, String link, String appId) {
        return new SkuAttribute(serviceKey, prepaidKey, postpaidKey, backgroundColor, title, icon, buttonDescription, serviceName, productBizId, key, link, appId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SkuAttribute) {
            SkuAttribute skuAttribute = (SkuAttribute) other;
            return Intrinsics.areEqual(this.serviceKey, skuAttribute.serviceKey) && Intrinsics.areEqual(this.prepaidKey, skuAttribute.prepaidKey) && Intrinsics.areEqual(this.postpaidKey, skuAttribute.postpaidKey) && Intrinsics.areEqual(this.backgroundColor, skuAttribute.backgroundColor) && Intrinsics.areEqual(this.title, skuAttribute.title) && Intrinsics.areEqual(this.icon, skuAttribute.icon) && Intrinsics.areEqual(this.buttonDescription, skuAttribute.buttonDescription) && Intrinsics.areEqual(this.serviceName, skuAttribute.serviceName) && Intrinsics.areEqual(this.productBizId, skuAttribute.productBizId) && Intrinsics.areEqual(this.key, skuAttribute.key) && Intrinsics.areEqual(this.link, skuAttribute.link) && Intrinsics.areEqual(this.appId, skuAttribute.appId);
        }
        return false;
    }

    public final int hashCode() {
        List<String> list = this.serviceKey;
        int hashCode = list == null ? 0 : list.hashCode();
        List<String> list2 = this.prepaidKey;
        int hashCode2 = list2 == null ? 0 : list2.hashCode();
        List<String> list3 = this.postpaidKey;
        int hashCode3 = list3 == null ? 0 : list3.hashCode();
        String str = this.backgroundColor;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.title;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.icon;
        int hashCode6 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.buttonDescription;
        int hashCode7 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.serviceName;
        int hashCode8 = str5 == null ? 0 : str5.hashCode();
        ProductBizId productBizId = this.productBizId;
        int hashCode9 = productBizId == null ? 0 : productBizId.hashCode();
        String str6 = this.key;
        int hashCode10 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.link;
        int hashCode11 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.appId;
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + (str8 != null ? str8.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SkuAttribute(serviceKey=");
        sb.append(this.serviceKey);
        sb.append(", prepaidKey=");
        sb.append(this.prepaidKey);
        sb.append(", postpaidKey=");
        sb.append(this.postpaidKey);
        sb.append(", backgroundColor=");
        sb.append(this.backgroundColor);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", buttonDescription=");
        sb.append(this.buttonDescription);
        sb.append(", serviceName=");
        sb.append(this.serviceName);
        sb.append(", productBizId=");
        sb.append(this.productBizId);
        sb.append(", key=");
        sb.append(this.key);
        sb.append(", link=");
        sb.append(this.link);
        sb.append(", appId=");
        sb.append(this.appId);
        sb.append(')');
        return sb.toString();
    }

    public SkuAttribute(List<String> list, List<String> list2, List<String> list3, String str, String str2, String str3, String str4, String str5, ProductBizId productBizId, String str6, String str7, String str8) {
        this.serviceKey = list;
        this.prepaidKey = list2;
        this.postpaidKey = list3;
        this.backgroundColor = str;
        this.title = str2;
        this.icon = str3;
        this.buttonDescription = str4;
        this.serviceName = str5;
        this.productBizId = productBizId;
        this.key = str6;
        this.link = str7;
        this.appId = str8;
    }

    public /* synthetic */ SkuAttribute(List list, List list2, List list3, String str, String str2, String str3, String str4, String str5, ProductBizId productBizId, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : productBizId, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : str7, (i & 2048) == 0 ? str8 : null);
    }

    @JvmName(name = "getServiceKey")
    public final List<String> getServiceKey() {
        return this.serviceKey;
    }

    @JvmName(name = "getPrepaidKey")
    public final List<String> getPrepaidKey() {
        return this.prepaidKey;
    }

    @JvmName(name = "getPostpaidKey")
    public final List<String> getPostpaidKey() {
        return this.postpaidKey;
    }

    @JvmName(name = "getBackgroundColor")
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }

    @JvmName(name = "getButtonDescription")
    public final String getButtonDescription() {
        return this.buttonDescription;
    }

    @JvmName(name = "getServiceName")
    public final String getServiceName() {
        return this.serviceName;
    }

    @JvmName(name = "getProductBizId")
    public final ProductBizId getProductBizId() {
        return this.productBizId;
    }

    @JvmName(name = "setProductBizId")
    public final void setProductBizId(ProductBizId productBizId) {
        this.productBizId = productBizId;
    }

    @JvmName(name = "getKey")
    public final String getKey() {
        return this.key;
    }

    @JvmName(name = "setKey")
    public final void setKey(String str) {
        this.key = str;
    }

    @JvmName(name = "getLink")
    public final String getLink() {
        return this.link;
    }

    @JvmName(name = "getAppId")
    public final String getAppId() {
        return this.appId;
    }

    @JvmName(name = "setAppId")
    public final void setAppId(String str) {
        this.appId = str;
    }
}
