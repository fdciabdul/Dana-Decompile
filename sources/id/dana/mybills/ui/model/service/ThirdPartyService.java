package id.dana.mybills.ui.model.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.data.config.source.sharedpreference.SpmIdEntityData;
import id.dana.data.constant.UrlParam;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\bG\b\u0086\b\u0018\u00002\u00020\u0001:\u0006\u0097\u0001\u0098\u0001\u0099\u0001B×\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010/\u001a\u00020\n\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00108\u001a\u00020\n\u0012\b\b\u0002\u00109\u001a\u00020\r\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010@\u001a\u00020\n\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010B\u001a\u00020\n\u0012\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010E\u001a\u00020\n¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u001b\u0010\fJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u001f\u0010\fJ\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b \u0010\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0010\u0010\"\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\"\u0010\fJ\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0004J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u0004J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u0004J\u0010\u0010&\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b&\u0010\fJ\u0012\u0010'\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u0004J\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010\u0004J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010\u0004JÞ\u0002\u0010F\u001a\u00020\u00002\b\b\u0002\u0010*\u001a\u00020\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010/\u001a\u00020\n2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00108\u001a\u00020\n2\b\b\u0002\u00109\u001a\u00020\r2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00142\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010@\u001a\u00020\n2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010B\u001a\u00020\n2\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00142\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010E\u001a\u00020\nHÆ\u0001¢\u0006\u0004\bF\u0010GJ\u0010\u0010H\u001a\u00020\rHÖ\u0001¢\u0006\u0004\bH\u0010\u000fJ\u001a\u0010K\u001a\u00020\n2\b\u0010J\u001a\u0004\u0018\u00010IH\u0096\u0002¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\rH\u0016¢\u0006\u0004\bM\u0010\u000fJ\u0010\u0010N\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bN\u0010\u0004J \u0010S\u001a\u00020R2\u0006\u0010P\u001a\u00020O2\u0006\u0010Q\u001a\u00020\rHÖ\u0001¢\u0006\u0004\bS\u0010TR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010U\u001a\u0004\bV\u0010\u0004\"\u0004\bW\u0010XR$\u0010.\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010U\u001a\u0004\bY\u0010\u0004\"\u0004\bZ\u0010XR$\u0010<\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010U\u001a\u0004\b[\u0010\u0004\"\u0004\b\\\u0010XR$\u0010-\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010U\u001a\u0004\b]\u0010\u0004\"\u0004\b^\u0010XR$\u0010;\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010U\u001a\u0004\b_\u0010\u0004\"\u0004\b`\u0010XR$\u00100\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010U\u001a\u0004\ba\u0010\u0004\"\u0004\bb\u0010XR\"\u0010E\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010c\u001a\u0004\bE\u0010\f\"\u0004\bd\u0010eR\"\u0010/\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010c\u001a\u0004\b/\u0010\f\"\u0004\bf\u0010eR\"\u0010@\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010c\u001a\u0004\b@\u0010\f\"\u0004\bg\u0010eR\"\u00108\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010c\u001a\u0004\b8\u0010\f\"\u0004\bh\u0010eR\"\u0010*\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010U\u001a\u0004\bi\u0010\u0004\"\u0004\bj\u0010XR$\u0010+\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010U\u001a\u0004\bk\u0010\u0004\"\u0004\bl\u0010XR*\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010m\u001a\u0004\bn\u0010\u0016\"\u0004\bo\u0010pR$\u00101\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010U\u001a\u0004\bq\u0010\u0004\"\u0004\br\u0010XR$\u00102\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010U\u001a\u0004\bs\u0010\u0004\"\u0004\bt\u0010XR$\u00103\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010U\u001a\u0004\bu\u0010\u0004\"\u0004\bv\u0010XR$\u00104\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010U\u001a\u0004\bw\u0010\u0004\"\u0004\bx\u0010XR\"\u0010B\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010c\u001a\u0004\by\u0010\f\"\u0004\bz\u0010eR$\u00105\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010U\u001a\u0004\b{\u0010\u0004\"\u0004\b|\u0010XR$\u00106\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010U\u001a\u0004\b}\u0010\u0004\"\u0004\b~\u0010XR%\u0010>\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0013\n\u0004\b>\u0010U\u001a\u0004\b\u007f\u0010\u0004\"\u0005\b\u0080\u0001\u0010XR&\u00107\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b7\u0010U\u001a\u0005\b\u0081\u0001\u0010\u0004\"\u0005\b\u0082\u0001\u0010XR&\u0010D\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bD\u0010U\u001a\u0005\b\u0083\u0001\u0010\u0004\"\u0005\b\u0084\u0001\u0010XR(\u0010A\u001a\u0004\u0018\u00010\u001c8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bA\u0010\u0085\u0001\u001a\u0005\b\u0086\u0001\u0010\u001e\"\u0006\b\u0087\u0001\u0010\u0088\u0001R,\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bC\u0010m\u001a\u0005\b\u0089\u0001\u0010\u0016\"\u0005\b\u008a\u0001\u0010pR(\u0010?\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\b?\u0010\u008b\u0001\u001a\u0005\b\u008c\u0001\u0010\u001a\"\u0006\b\u008d\u0001\u0010\u008e\u0001R&\u00109\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\b9\u0010\u008f\u0001\u001a\u0005\b\u0090\u0001\u0010\u000f\"\u0006\b\u0091\u0001\u0010\u0092\u0001R&\u0010:\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b:\u0010U\u001a\u0005\b\u0093\u0001\u0010\u0004\"\u0005\b\u0094\u0001\u0010X"}, d2 = {"Lid/dana/mybills/ui/model/service/ThirdPartyService;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "", "component15", "()Z", "", "component16", "()I", "component17", "component18", "component19", "component2", "", "component20", "()Ljava/util/List;", "component21", "Lid/dana/mybills/ui/model/service/ThirdPartyService$SpmId;", "component22", "()Lid/dana/mybills/ui/model/service/ThirdPartyService$SpmId;", "component23", "Lid/dana/mybills/ui/model/service/SkuAttributeModel;", "component24", "()Lid/dana/mybills/ui/model/service/SkuAttributeModel;", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "key", "keyCategory", "action", "clientId", "appId", "isEnable", "icon", "link", "name", "nameInd", "nameTag", "operationType", "redirectUrl", "scopes", "isShowRedDot", "type", "userAction", "description", "buttonTitle", "keywords", "ribbonText", "spmId", "isFeatured", "skuAttributeModel", UrlParam.NEED_CONSULT, "spaceCodes", "screenOrientation", "isBiller", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lid/dana/mybills/ui/model/service/ThirdPartyService$SpmId;ZLid/dana/mybills/ui/model/service/SkuAttributeModel;ZLjava/util/List;Ljava/lang/String;Z)Lid/dana/mybills/ui/model/service/ThirdPartyService;", "describeContents", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAction", "setAction", "(Ljava/lang/String;)V", "getAppId", "setAppId", "getButtonTitle", "setButtonTitle", "getClientId", "setClientId", "getDescription", "setDescription", "getIcon", "setIcon", "Z", "setBiller", "(Z)V", "setEnable", "setFeatured", "setShowRedDot", "getKey", "setKey", "getKeyCategory", "setKeyCategory", "Ljava/util/List;", "getKeywords", "setKeywords", "(Ljava/util/List;)V", "getLink", "setLink", "getName", "setName", "getNameInd", "setNameInd", "getNameTag", "setNameTag", "getNeedConsult", "setNeedConsult", "getOperationType", "setOperationType", "getRedirectUrl", "setRedirectUrl", "getRibbonText", "setRibbonText", "getScopes", "setScopes", "getScreenOrientation", "setScreenOrientation", "Lid/dana/mybills/ui/model/service/SkuAttributeModel;", "getSkuAttributeModel", "setSkuAttributeModel", "(Lid/dana/mybills/ui/model/service/SkuAttributeModel;)V", "getSpaceCodes", "setSpaceCodes", "Lid/dana/mybills/ui/model/service/ThirdPartyService$SpmId;", "getSpmId", "setSpmId", "(Lid/dana/mybills/ui/model/service/ThirdPartyService$SpmId;)V", "I", "getType", "setType", "(I)V", "getUserAction", "setUserAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lid/dana/mybills/ui/model/service/ThirdPartyService$SpmId;ZLid/dana/mybills/ui/model/service/SkuAttributeModel;ZLjava/util/List;Ljava/lang/String;Z)V", "Builder", "SpmId", "Variant"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ThirdPartyService implements Parcelable {
    public static final Parcelable.Creator<ThirdPartyService> CREATOR = new Creator();
    private String action;
    private String appId;
    private String buttonTitle;
    private String clientId;
    private String description;
    private String icon;
    private boolean isBiller;
    private boolean isEnable;
    private boolean isFeatured;
    private boolean isShowRedDot;
    private String key;
    private String keyCategory;
    private List<String> keywords;
    private String link;
    private String name;
    private String nameInd;
    private String nameTag;
    private boolean needConsult;
    private String operationType;
    private String redirectUrl;
    private String ribbonText;
    private String scopes;
    private String screenOrientation;
    private SkuAttributeModel skuAttributeModel;
    private List<String> spaceCodes;
    private SpmId spmId;
    private int type;
    private String userAction;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<ThirdPartyService> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ThirdPartyService createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new ThirdPartyService(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readInt() == 0 ? null : SpmId.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, parcel.readInt() != 0 ? SkuAttributeModel.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0, parcel.createStringArrayList(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ThirdPartyService[] newArray(int i) {
            return new ThirdPartyService[i];
        }
    }

    public ThirdPartyService() {
        this(null, null, null, null, null, false, null, null, null, null, null, null, null, null, false, 0, null, null, null, null, null, null, false, null, false, null, null, false, 268435455, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component10  reason: from getter */
    public final String getNameInd() {
        return this.nameInd;
    }

    /* renamed from: component11  reason: from getter */
    public final String getNameTag() {
        return this.nameTag;
    }

    /* renamed from: component12  reason: from getter */
    public final String getOperationType() {
        return this.operationType;
    }

    /* renamed from: component13  reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    /* renamed from: component14  reason: from getter */
    public final String getScopes() {
        return this.scopes;
    }

    /* renamed from: component15  reason: from getter */
    public final boolean getIsShowRedDot() {
        return this.isShowRedDot;
    }

    /* renamed from: component16  reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component17  reason: from getter */
    public final String getUserAction() {
        return this.userAction;
    }

    /* renamed from: component18  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component19  reason: from getter */
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    /* renamed from: component2  reason: from getter */
    public final String getKeyCategory() {
        return this.keyCategory;
    }

    public final List<String> component20() {
        return this.keywords;
    }

    /* renamed from: component21  reason: from getter */
    public final String getRibbonText() {
        return this.ribbonText;
    }

    /* renamed from: component22  reason: from getter */
    public final SpmId getSpmId() {
        return this.spmId;
    }

    /* renamed from: component23  reason: from getter */
    public final boolean getIsFeatured() {
        return this.isFeatured;
    }

    /* renamed from: component24  reason: from getter */
    public final SkuAttributeModel getSkuAttributeModel() {
        return this.skuAttributeModel;
    }

    /* renamed from: component25  reason: from getter */
    public final boolean getNeedConsult() {
        return this.needConsult;
    }

    public final List<String> component26() {
        return this.spaceCodes;
    }

    /* renamed from: component27  reason: from getter */
    public final String getScreenOrientation() {
        return this.screenOrientation;
    }

    /* renamed from: component28  reason: from getter */
    public final boolean getIsBiller() {
        return this.isBiller;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component4  reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component6  reason: from getter */
    public final boolean getIsEnable() {
        return this.isEnable;
    }

    /* renamed from: component7  reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component8  reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* renamed from: component9  reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ThirdPartyService copy(String key, String keyCategory, String action, String clientId, String appId, boolean isEnable, String icon, String link, String name, String nameInd, String nameTag, String operationType, String redirectUrl, String scopes, boolean isShowRedDot, int type, String userAction, String description, String buttonTitle, List<String> keywords, String ribbonText, SpmId spmId, boolean isFeatured, SkuAttributeModel skuAttributeModel, boolean needConsult, List<String> spaceCodes, String screenOrientation, boolean isBiller) {
        Intrinsics.checkNotNullParameter(key, "");
        return new ThirdPartyService(key, keyCategory, action, clientId, appId, isEnable, icon, link, name, nameInd, nameTag, operationType, redirectUrl, scopes, isShowRedDot, type, userAction, description, buttonTitle, keywords, ribbonText, spmId, isFeatured, skuAttributeModel, needConsult, spaceCodes, screenOrientation, isBiller);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ThirdPartyService(key=");
        sb.append(this.key);
        sb.append(", keyCategory=");
        sb.append(this.keyCategory);
        sb.append(", action=");
        sb.append(this.action);
        sb.append(", clientId=");
        sb.append(this.clientId);
        sb.append(", appId=");
        sb.append(this.appId);
        sb.append(", isEnable=");
        sb.append(this.isEnable);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", link=");
        sb.append(this.link);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", nameInd=");
        sb.append(this.nameInd);
        sb.append(", nameTag=");
        sb.append(this.nameTag);
        sb.append(", operationType=");
        sb.append(this.operationType);
        sb.append(", redirectUrl=");
        sb.append(this.redirectUrl);
        sb.append(", scopes=");
        sb.append(this.scopes);
        sb.append(", isShowRedDot=");
        sb.append(this.isShowRedDot);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", userAction=");
        sb.append(this.userAction);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", buttonTitle=");
        sb.append(this.buttonTitle);
        sb.append(", keywords=");
        sb.append(this.keywords);
        sb.append(", ribbonText=");
        sb.append(this.ribbonText);
        sb.append(", spmId=");
        sb.append(this.spmId);
        sb.append(", isFeatured=");
        sb.append(this.isFeatured);
        sb.append(", skuAttributeModel=");
        sb.append(this.skuAttributeModel);
        sb.append(", needConsult=");
        sb.append(this.needConsult);
        sb.append(", spaceCodes=");
        sb.append(this.spaceCodes);
        sb.append(", screenOrientation=");
        sb.append(this.screenOrientation);
        sb.append(", isBiller=");
        sb.append(this.isBiller);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.key);
        parcel.writeString(this.keyCategory);
        parcel.writeString(this.action);
        parcel.writeString(this.clientId);
        parcel.writeString(this.appId);
        parcel.writeInt(this.isEnable ? 1 : 0);
        parcel.writeString(this.icon);
        parcel.writeString(this.link);
        parcel.writeString(this.name);
        parcel.writeString(this.nameInd);
        parcel.writeString(this.nameTag);
        parcel.writeString(this.operationType);
        parcel.writeString(this.redirectUrl);
        parcel.writeString(this.scopes);
        parcel.writeInt(this.isShowRedDot ? 1 : 0);
        parcel.writeInt(this.type);
        parcel.writeString(this.userAction);
        parcel.writeString(this.description);
        parcel.writeString(this.buttonTitle);
        parcel.writeStringList(this.keywords);
        parcel.writeString(this.ribbonText);
        SpmId spmId = this.spmId;
        if (spmId == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            spmId.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.isFeatured ? 1 : 0);
        SkuAttributeModel skuAttributeModel = this.skuAttributeModel;
        if (skuAttributeModel == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            skuAttributeModel.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.needConsult ? 1 : 0);
        parcel.writeStringList(this.spaceCodes);
        parcel.writeString(this.screenOrientation);
        parcel.writeInt(this.isBiller ? 1 : 0);
    }

    public ThirdPartyService(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, boolean z2, int i, String str14, String str15, String str16, List<String> list, String str17, SpmId spmId, boolean z3, SkuAttributeModel skuAttributeModel, boolean z4, List<String> list2, String str18, boolean z5) {
        Intrinsics.checkNotNullParameter(str, "");
        this.key = str;
        this.keyCategory = str2;
        this.action = str3;
        this.clientId = str4;
        this.appId = str5;
        this.isEnable = z;
        this.icon = str6;
        this.link = str7;
        this.name = str8;
        this.nameInd = str9;
        this.nameTag = str10;
        this.operationType = str11;
        this.redirectUrl = str12;
        this.scopes = str13;
        this.isShowRedDot = z2;
        this.type = i;
        this.userAction = str14;
        this.description = str15;
        this.buttonTitle = str16;
        this.keywords = list;
        this.ribbonText = str17;
        this.spmId = spmId;
        this.isFeatured = z3;
        this.skuAttributeModel = skuAttributeModel;
        this.needConsult = z4;
        this.spaceCodes = list2;
        this.screenOrientation = str18;
        this.isBiller = z5;
    }

    public /* synthetic */ ThirdPartyService(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, boolean z2, int i, String str14, String str15, String str16, List list, String str17, SpmId spmId, boolean z3, SkuAttributeModel skuAttributeModel, boolean z4, List list2, String str18, boolean z5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? null : str7, (i2 & 256) != 0 ? null : str8, (i2 & 512) != 0 ? null : str9, (i2 & 1024) != 0 ? null : str10, (i2 & 2048) != 0 ? null : str11, (i2 & 4096) != 0 ? null : str12, (i2 & 8192) != 0 ? null : str13, (i2 & 16384) != 0 ? false : z2, (i2 & 32768) != 0 ? 0 : i, (i2 & 65536) != 0 ? null : str14, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str15, (i2 & 262144) != 0 ? null : str16, (i2 & 524288) != 0 ? null : list, (i2 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : str17, (i2 & 2097152) != 0 ? null : spmId, (i2 & 4194304) != 0 ? false : z3, (i2 & 8388608) != 0 ? null : skuAttributeModel, (i2 & 16777216) != 0 ? false : z4, (i2 & 33554432) != 0 ? null : list2, (i2 & 67108864) != 0 ? null : str18, (i2 & 134217728) != 0 ? false : z5);
    }

    @JvmName(name = "getKey")
    public final String getKey() {
        return this.key;
    }

    @JvmName(name = "setKey")
    public final void setKey(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.key = str;
    }

    @JvmName(name = "getKeyCategory")
    public final String getKeyCategory() {
        return this.keyCategory;
    }

    @JvmName(name = "setKeyCategory")
    public final void setKeyCategory(String str) {
        this.keyCategory = str;
    }

    @JvmName(name = "getAction")
    public final String getAction() {
        return this.action;
    }

    @JvmName(name = "setAction")
    public final void setAction(String str) {
        this.action = str;
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "setClientId")
    public final void setClientId(String str) {
        this.clientId = str;
    }

    @JvmName(name = "getAppId")
    public final String getAppId() {
        return this.appId;
    }

    @JvmName(name = "setAppId")
    public final void setAppId(String str) {
        this.appId = str;
    }

    @JvmName(name = "isEnable")
    public final boolean isEnable() {
        return this.isEnable;
    }

    @JvmName(name = "setEnable")
    public final void setEnable(boolean z) {
        this.isEnable = z;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }

    @JvmName(name = "setIcon")
    public final void setIcon(String str) {
        this.icon = str;
    }

    @JvmName(name = "getLink")
    public final String getLink() {
        return this.link;
    }

    @JvmName(name = "setLink")
    public final void setLink(String str) {
        this.link = str;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "setName")
    public final void setName(String str) {
        this.name = str;
    }

    @JvmName(name = "getNameInd")
    public final String getNameInd() {
        return this.nameInd;
    }

    @JvmName(name = "setNameInd")
    public final void setNameInd(String str) {
        this.nameInd = str;
    }

    @JvmName(name = "getNameTag")
    public final String getNameTag() {
        return this.nameTag;
    }

    @JvmName(name = "setNameTag")
    public final void setNameTag(String str) {
        this.nameTag = str;
    }

    @JvmName(name = "getOperationType")
    public final String getOperationType() {
        return this.operationType;
    }

    @JvmName(name = "setOperationType")
    public final void setOperationType(String str) {
        this.operationType = str;
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "setRedirectUrl")
    public final void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    @JvmName(name = "getScopes")
    public final String getScopes() {
        return this.scopes;
    }

    @JvmName(name = "setScopes")
    public final void setScopes(String str) {
        this.scopes = str;
    }

    @JvmName(name = "isShowRedDot")
    public final boolean isShowRedDot() {
        return this.isShowRedDot;
    }

    @JvmName(name = "setShowRedDot")
    public final void setShowRedDot(boolean z) {
        this.isShowRedDot = z;
    }

    @JvmName(name = "getType")
    public final int getType() {
        return this.type;
    }

    @JvmName(name = "setType")
    public final void setType(int i) {
        this.type = i;
    }

    @JvmName(name = "getUserAction")
    public final String getUserAction() {
        return this.userAction;
    }

    @JvmName(name = "setUserAction")
    public final void setUserAction(String str) {
        this.userAction = str;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "setDescription")
    public final void setDescription(String str) {
        this.description = str;
    }

    @JvmName(name = "getButtonTitle")
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    @JvmName(name = "setButtonTitle")
    public final void setButtonTitle(String str) {
        this.buttonTitle = str;
    }

    @JvmName(name = "getKeywords")
    public final List<String> getKeywords() {
        return this.keywords;
    }

    @JvmName(name = "setKeywords")
    public final void setKeywords(List<String> list) {
        this.keywords = list;
    }

    @JvmName(name = "getRibbonText")
    public final String getRibbonText() {
        return this.ribbonText;
    }

    @JvmName(name = "setRibbonText")
    public final void setRibbonText(String str) {
        this.ribbonText = str;
    }

    @JvmName(name = "getSpmId")
    public final SpmId getSpmId() {
        return this.spmId;
    }

    @JvmName(name = "setSpmId")
    public final void setSpmId(SpmId spmId) {
        this.spmId = spmId;
    }

    @JvmName(name = "isFeatured")
    public final boolean isFeatured() {
        return this.isFeatured;
    }

    @JvmName(name = "setFeatured")
    public final void setFeatured(boolean z) {
        this.isFeatured = z;
    }

    @JvmName(name = "getSkuAttributeModel")
    public final SkuAttributeModel getSkuAttributeModel() {
        return this.skuAttributeModel;
    }

    @JvmName(name = "setSkuAttributeModel")
    public final void setSkuAttributeModel(SkuAttributeModel skuAttributeModel) {
        this.skuAttributeModel = skuAttributeModel;
    }

    @JvmName(name = "getNeedConsult")
    public final boolean getNeedConsult() {
        return this.needConsult;
    }

    @JvmName(name = "setNeedConsult")
    public final void setNeedConsult(boolean z) {
        this.needConsult = z;
    }

    @JvmName(name = "getSpaceCodes")
    public final List<String> getSpaceCodes() {
        return this.spaceCodes;
    }

    @JvmName(name = "setSpaceCodes")
    public final void setSpaceCodes(List<String> list) {
        this.spaceCodes = list;
    }

    @JvmName(name = "getScreenOrientation")
    public final String getScreenOrientation() {
        return this.screenOrientation;
    }

    @JvmName(name = "setScreenOrientation")
    public final void setScreenOrientation(String str) {
        this.screenOrientation = str;
    }

    @JvmName(name = "isBiller")
    public final boolean isBiller() {
        return this.isBiller;
    }

    @JvmName(name = "setBiller")
    public final void setBiller(boolean z) {
        this.isBiller = z;
    }

    public final int hashCode() {
        return this.key.hashCode();
    }

    public final boolean equals(Object other) {
        return this == other || ((other instanceof ThirdPartyService) && Intrinsics.areEqual(this.key, ((ThirdPartyService) other).key));
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/mybills/ui/model/service/ThirdPartyService$Variant;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Variant {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int EDIT = 5;
        public static final int EMPTY = 6;
        public static final int FEATURE = 2;
        public static final int HEADER = 3;
        public static final int ITEM = 0;
        public static final int MORE = 1;
        public static final int SPACE = 4;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\n\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/model/service/ThirdPartyService$Variant$Companion;", "", "", "EDIT", "I", "EMPTY", "FEATURE", "HEADER", "ITEM", "MORE", "SPACE", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int EDIT = 5;
            public static final int EMPTY = 6;
            public static final int FEATURE = 2;
            public static final int HEADER = 3;
            public static final int ITEM = 0;
            public static final int MORE = 1;
            public static final int SPACE = 4;

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103J\u0017\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u000eJ\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u001d\u0010\u0015\u001a\u00020\u00002\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u0017\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u0017\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u0017\u0010\u001a\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u000eJ\u0017\u0010\u001c\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\u0017\u0010\u001e\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\u0004J\u0017\u0010\u001f\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u0017\u0010 \u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010\u0004J\u0017\u0010\"\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\u00020\u00002\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014¢\u0006\u0004\b$\u0010\u0016J\u0017\u0010&\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b+\u0010\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010,R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010,R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010,R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010,R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010,R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010-R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010-R\u0016\u0010\u0010\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010-R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010,R\u0016\u0010\u0012\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010-R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010,R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010.R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010,R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010,R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010,R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010,R\u0016\u0010\u001b\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010-R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010,R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010,R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010,R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010,R\u0018\u0010 \u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010,R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010/R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010.R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u00100R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u00101R\u0018\u0010+\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,"}, d2 = {"Lid/dana/mybills/ui/model/service/ThirdPartyService$Builder;", "", "", "action", "(Ljava/lang/String;)Lid/dana/mybills/ui/model/service/ThirdPartyService$Builder;", "appId", "Lid/dana/mybills/ui/model/service/ThirdPartyService;", "build", "()Lid/dana/mybills/ui/model/service/ThirdPartyService;", "buttonTitle", "clientId", "description", "", "enable", "(Z)Lid/dana/mybills/ui/model/service/ThirdPartyService$Builder;", "featured", "hasRedDot", "icon", "isBiller", "key", "", "keywords", "(Ljava/util/List;)Lid/dana/mybills/ui/model/service/ThirdPartyService$Builder;", "link", "name", "nameInd", "nameTag", UrlParam.NEED_CONSULT, "operationType", "redirectUrl", "ribbonText", "scopes", "screenOrientation", "Lid/dana/mybills/ui/model/service/SkuAttributeModel;", "skuAttributeModel", "(Lid/dana/mybills/ui/model/service/SkuAttributeModel;)Lid/dana/mybills/ui/model/service/ThirdPartyService$Builder;", "spaceCodes", "Lid/dana/mybills/ui/model/service/ThirdPartyService$SpmId;", "spmId", "(Lid/dana/mybills/ui/model/service/ThirdPartyService$SpmId;)Lid/dana/mybills/ui/model/service/ThirdPartyService$Builder;", "", "type", "(I)Lid/dana/mybills/ui/model/service/ThirdPartyService$Builder;", "userAction", "Ljava/lang/String;", "Z", "Ljava/util/List;", "Lid/dana/mybills/ui/model/service/SkuAttributeModel;", "Lid/dana/mybills/ui/model/service/ThirdPartyService$SpmId;", "I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder {
        private String action;
        private String appId;
        private String buttonTitle;
        private String clientId;
        private String description;
        private boolean enable;
        private boolean featured;
        private boolean hasRedDot;
        private String icon;
        private boolean isBiller;
        private String key = "";
        private List<String> keywords;
        private String link;
        private String name;
        private String nameInd;
        private String nameTag;
        private boolean needConsult;
        private String operationType;
        private String redirectUrl;
        private String ribbonText;
        private String scopes;
        private String screenOrientation;
        private SkuAttributeModel skuAttributeModel;
        private List<String> spaceCodes;
        private SpmId spmId;
        private int type;
        private String userAction;

        public final Builder hasRedDot(boolean hasRedDot) {
            this.hasRedDot = hasRedDot;
            return this;
        }

        public final Builder ribbonText(String ribbonText) {
            this.ribbonText = ribbonText;
            return this;
        }

        public final Builder action(String action) {
            this.action = action;
            return this;
        }

        public final Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public final Builder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public final Builder enable(boolean enable) {
            this.enable = enable;
            return this;
        }

        public final Builder icon(String icon) {
            this.icon = icon;
            return this;
        }

        public final Builder key(String key) {
            Intrinsics.checkNotNullParameter(key, "");
            this.key = key;
            return this;
        }

        public final Builder link(String link) {
            this.link = link;
            return this;
        }

        public final Builder name(String name) {
            this.name = name;
            return this;
        }

        public final Builder nameInd(String nameInd) {
            this.nameInd = nameInd;
            return this;
        }

        public final Builder nameTag(String nameTag) {
            this.nameTag = nameTag;
            return this;
        }

        public final Builder operationType(String operationType) {
            this.operationType = operationType;
            return this;
        }

        public final Builder redirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
            return this;
        }

        public final Builder scopes(String scopes) {
            this.scopes = scopes;
            return this;
        }

        public final Builder type(int type) {
            this.type = type;
            return this;
        }

        public final Builder userAction(String userAction) {
            this.userAction = userAction;
            return this;
        }

        public final Builder description(String description) {
            this.description = description;
            return this;
        }

        public final Builder buttonTitle(String buttonTitle) {
            this.buttonTitle = buttonTitle;
            return this;
        }

        public final Builder keywords(List<String> keywords) {
            this.keywords = keywords;
            return this;
        }

        public final Builder spmId(SpmId spmId) {
            this.spmId = spmId;
            return this;
        }

        public final Builder featured(boolean featured) {
            this.featured = featured;
            return this;
        }

        public final Builder needConsult(boolean needConsult) {
            this.needConsult = needConsult;
            return this;
        }

        public final Builder spaceCodes(List<String> spaceCodes) {
            this.spaceCodes = spaceCodes;
            return this;
        }

        public final Builder skuAttributeModel(SkuAttributeModel skuAttributeModel) {
            this.skuAttributeModel = skuAttributeModel;
            return this;
        }

        public final Builder screenOrientation(String screenOrientation) {
            this.screenOrientation = screenOrientation;
            return this;
        }

        public final Builder isBiller(boolean isBiller) {
            this.isBiller = isBiller;
            return this;
        }

        public final ThirdPartyService build() {
            String str = this.key;
            String str2 = this.action;
            String str3 = this.clientId;
            String str4 = this.appId;
            boolean z = this.enable;
            String str5 = this.icon;
            String str6 = this.link;
            String str7 = this.name;
            String str8 = this.nameInd;
            String str9 = this.nameTag;
            String str10 = this.operationType;
            String str11 = this.redirectUrl;
            String str12 = this.scopes;
            int i = this.type;
            String str13 = this.userAction;
            String str14 = this.description;
            String str15 = this.buttonTitle;
            List<String> list = this.keywords;
            String str16 = this.ribbonText;
            return new ThirdPartyService(str, null, str2, str3, str4, z, str5, str6, str7, str8, str9, str10, str11, str12, this.hasRedDot, i, str13, str14, str15, list, str16, this.spmId, this.featured, this.skuAttributeModel, this.needConsult, this.spaceCodes, this.screenOrientation, this.isBiller, 2, null);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014"}, d2 = {"Lid/dana/mybills/ui/model/service/ThirdPartyService$SpmId;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Lid/dana/data/config/source/sharedpreference/SpmIdEntityData;", "toEntity", "()Lid/dana/data/config/source/sharedpreference/SpmIdEntityData;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "all", "Ljava/lang/String;", "getAll", "()Ljava/lang/String;", "setAll", "(Ljava/lang/String;)V", "home", "getHome", "setHome", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class SpmId implements Parcelable {
        private String all;
        private String home;

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Parcelable.Creator<SpmId> CREATOR = new Creator();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<SpmId> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SpmId createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new SpmId(parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SpmId[] newArray(int i) {
                return new SpmId[i];
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public SpmId() {
            /*
                r2 = this;
                r0 = 0
                r1 = 3
                r2.<init>(r0, r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.model.service.ThirdPartyService.SpmId.<init>():void");
        }

        @JvmStatic
        public static final SpmId fromEntity(SpmIdEntityData spmIdEntityData) {
            return INSTANCE.fromEntity(spmIdEntityData);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeString(this.home);
            parcel.writeString(this.all);
        }

        public SpmId(String str, String str2) {
            this.home = str;
            this.all = str2;
        }

        public /* synthetic */ SpmId(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @JvmName(name = "getAll")
        public final String getAll() {
            return this.all;
        }

        @JvmName(name = "getHome")
        public final String getHome() {
            return this.home;
        }

        @JvmName(name = "setAll")
        public final void setAll(String str) {
            this.all = str;
        }

        @JvmName(name = "setHome")
        public final void setHome(String str) {
            this.home = str;
        }

        public final SpmIdEntityData toEntity() {
            return new SpmIdEntityData(this.home, this.all);
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/mybills/ui/model/service/ThirdPartyService$SpmId$Companion;", "", "Lid/dana/data/config/source/sharedpreference/SpmIdEntityData;", "entity", "Lid/dana/mybills/ui/model/service/ThirdPartyService$SpmId;", "fromEntity", "(Lid/dana/data/config/source/sharedpreference/SpmIdEntityData;)Lid/dana/mybills/ui/model/service/ThirdPartyService$SpmId;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final SpmId fromEntity(SpmIdEntityData entity) {
                if (entity != null) {
                    return new SpmId(entity.getHome(), entity.getAll());
                }
                return null;
            }
        }
    }
}
