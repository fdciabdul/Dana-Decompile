package id.dana.mybills.danah5;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.mybills.ui.model.BizProductModel;
import id.dana.mybills.ui.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/mybills/danah5/BillerPortalBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Lcom/alibaba/ariver/app/api/Page;", "page", "", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", BillerPortalBridge.JSAPI_METHOD_NAME, "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "<init>", "()V", "Companion", "Event"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BillerPortalBridge extends SimpleBridgeExtension {
    public static final String JSAPI_METHOD_NAME = "billerPortal";

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void billerPortal(@BindingNode(Page.class) Page page, @BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
            bridgeCallback.sendJSONResponse(jSONObject);
            EventBus.getDefault().post(new Event(eventName, info));
            activity.finish();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/mybills/danah5/BillerPortalBridge$Event;", "", "", "component1", "()Ljava/lang/String;", "Lcom/alibaba/fastjson/JSONObject;", "component2", "()Lcom/alibaba/fastjson/JSONObject;", "name", "info", "copy", "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;)Lid/dana/mybills/danah5/BillerPortalBridge$Event;", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lid/dana/mybills/danah5/BillerPortalBridge$Event$Info;", "getInfoParsed", "()Lid/dana/mybills/danah5/BillerPortalBridge$Event$Info;", "", "hashCode", "()I", "toString", "Lcom/alibaba/fastjson/JSONObject;", "getInfo", "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;)V", "Companion", "Info"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Event {
        public static final String BILL_ADD = "addNewBill";
        public static final String BILL_EDIT = "editBill";
        private final JSONObject info;
        private final String name;

        public static /* synthetic */ Event copy$default(Event event, String str, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                str = event.name;
            }
            if ((i & 2) != 0) {
                jSONObject = event.info;
            }
            return event.copy(str, jSONObject);
        }

        /* renamed from: component1  reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2  reason: from getter */
        public final JSONObject getInfo() {
            return this.info;
        }

        public final Event copy(String name, JSONObject info) {
            Intrinsics.checkNotNullParameter(name, "");
            return new Event(name, info);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Event) {
                Event event = (Event) other;
                return Intrinsics.areEqual(this.name, event.name) && Intrinsics.areEqual(this.info, event.info);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.name.hashCode();
            JSONObject jSONObject = this.info;
            return (hashCode * 31) + (jSONObject == null ? 0 : jSONObject.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Event(name=");
            sb.append(this.name);
            sb.append(", info=");
            sb.append(this.info);
            sb.append(')');
            return sb.toString();
        }

        public Event(String str, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(str, "");
            this.name = str;
            this.info = jSONObject;
        }

        @JvmName(name = "getName")
        public final String getName() {
            return this.name;
        }

        @JvmName(name = "getInfo")
        public final JSONObject getInfo() {
            return this.info;
        }

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u0000 42\u00020\u0001:\u00014BO\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b2\u00103J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJX\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0018J\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004J \u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b'\u0010(R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b*\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010+\u001a\u0004\b,\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b-\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b.\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010)\u001a\u0004\b/\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010+\u001a\u0004\b0\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010)\u001a\u0004\b1\u0010\u0004"}, d2 = {"Lid/dana/mybills/danah5/BillerPortalBridge$Event$Info;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "Lcom/alibaba/fastjson/JSONObject;", "component6", "()Lcom/alibaba/fastjson/JSONObject;", "component7", "customerId", "voucherName", "goodsId", "goodsType", "goodsTitle", FirebaseAnalytics.Param.PRICE, "extendInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/fastjson/JSONObject;)Lid/dana/mybills/danah5/BillerPortalBridge$Event$Info;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "Lid/dana/mybills/ui/model/BizProductModel;", "toBizProductModel", "()Lid/dana/mybills/ui/model/BizProductModel;", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getCustomerId", "Lcom/alibaba/fastjson/JSONObject;", "getExtendInfo", "getGoodsId", "getGoodsTitle", "getGoodsType", "getPrice", "getVoucherName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/fastjson/JSONObject;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final /* data */ class Info implements Parcelable {
            public static final String KEY_BILLER_DENOM_TEXT = "billerDenomText";
            public static final String KEY_QUERY_URL_PROVIDER = "queryUrlProvider";
            private final String customerId;
            private final JSONObject extendInfo;
            private final String goodsId;
            private final String goodsTitle;
            private final String goodsType;
            private final JSONObject price;
            private final String voucherName;
            public static final Parcelable.Creator<Info> CREATOR = new Creator();

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes9.dex */
            public static final class Creator implements Parcelable.Creator<Info> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final Info createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "");
                    return new Info(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (JSONObject) parcel.readSerializable(), (JSONObject) parcel.readSerializable());
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final Info[] newArray(int i) {
                    return new Info[i];
                }
            }

            public Info() {
                this(null, null, null, null, null, null, null, 127, null);
            }

            public static /* synthetic */ Info copy$default(Info info, String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, JSONObject jSONObject2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = info.customerId;
                }
                if ((i & 2) != 0) {
                    str2 = info.voucherName;
                }
                String str6 = str2;
                if ((i & 4) != 0) {
                    str3 = info.goodsId;
                }
                String str7 = str3;
                if ((i & 8) != 0) {
                    str4 = info.goodsType;
                }
                String str8 = str4;
                if ((i & 16) != 0) {
                    str5 = info.goodsTitle;
                }
                String str9 = str5;
                if ((i & 32) != 0) {
                    jSONObject = info.price;
                }
                JSONObject jSONObject3 = jSONObject;
                if ((i & 64) != 0) {
                    jSONObject2 = info.extendInfo;
                }
                return info.copy(str, str6, str7, str8, str9, jSONObject3, jSONObject2);
            }

            /* renamed from: component1  reason: from getter */
            public final String getCustomerId() {
                return this.customerId;
            }

            /* renamed from: component2  reason: from getter */
            public final String getVoucherName() {
                return this.voucherName;
            }

            /* renamed from: component3  reason: from getter */
            public final String getGoodsId() {
                return this.goodsId;
            }

            /* renamed from: component4  reason: from getter */
            public final String getGoodsType() {
                return this.goodsType;
            }

            /* renamed from: component5  reason: from getter */
            public final String getGoodsTitle() {
                return this.goodsTitle;
            }

            /* renamed from: component6  reason: from getter */
            public final JSONObject getPrice() {
                return this.price;
            }

            /* renamed from: component7  reason: from getter */
            public final JSONObject getExtendInfo() {
                return this.extendInfo;
            }

            public final Info copy(String customerId, String voucherName, String goodsId, String goodsType, String goodsTitle, JSONObject price, JSONObject extendInfo) {
                Intrinsics.checkNotNullParameter(voucherName, "");
                Intrinsics.checkNotNullParameter(goodsId, "");
                Intrinsics.checkNotNullParameter(goodsType, "");
                Intrinsics.checkNotNullParameter(goodsTitle, "");
                Intrinsics.checkNotNullParameter(price, "");
                Intrinsics.checkNotNullParameter(extendInfo, "");
                return new Info(customerId, voucherName, goodsId, goodsType, goodsTitle, price, extendInfo);
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            public final boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (other instanceof Info) {
                    Info info = (Info) other;
                    return Intrinsics.areEqual(this.customerId, info.customerId) && Intrinsics.areEqual(this.voucherName, info.voucherName) && Intrinsics.areEqual(this.goodsId, info.goodsId) && Intrinsics.areEqual(this.goodsType, info.goodsType) && Intrinsics.areEqual(this.goodsTitle, info.goodsTitle) && Intrinsics.areEqual(this.price, info.price) && Intrinsics.areEqual(this.extendInfo, info.extendInfo);
                }
                return false;
            }

            public final int hashCode() {
                String str = this.customerId;
                return ((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.voucherName.hashCode()) * 31) + this.goodsId.hashCode()) * 31) + this.goodsType.hashCode()) * 31) + this.goodsTitle.hashCode()) * 31) + this.price.hashCode()) * 31) + this.extendInfo.hashCode();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Info(customerId=");
                sb.append(this.customerId);
                sb.append(", voucherName=");
                sb.append(this.voucherName);
                sb.append(", goodsId=");
                sb.append(this.goodsId);
                sb.append(", goodsType=");
                sb.append(this.goodsType);
                sb.append(", goodsTitle=");
                sb.append(this.goodsTitle);
                sb.append(", price=");
                sb.append(this.price);
                sb.append(", extendInfo=");
                sb.append(this.extendInfo);
                sb.append(')');
                return sb.toString();
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "");
                parcel.writeString(this.customerId);
                parcel.writeString(this.voucherName);
                parcel.writeString(this.goodsId);
                parcel.writeString(this.goodsType);
                parcel.writeString(this.goodsTitle);
                parcel.writeSerializable(this.price);
                parcel.writeSerializable(this.extendInfo);
            }

            public Info(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, JSONObject jSONObject2) {
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
                Intrinsics.checkNotNullParameter(str4, "");
                Intrinsics.checkNotNullParameter(str5, "");
                Intrinsics.checkNotNullParameter(jSONObject, "");
                Intrinsics.checkNotNullParameter(jSONObject2, "");
                this.customerId = str;
                this.voucherName = str2;
                this.goodsId = str3;
                this.goodsType = str4;
                this.goodsTitle = str5;
                this.price = jSONObject;
                this.extendInfo = jSONObject2;
            }

            @JvmName(name = "getCustomerId")
            public final String getCustomerId() {
                return this.customerId;
            }

            @JvmName(name = "getVoucherName")
            public final String getVoucherName() {
                return this.voucherName;
            }

            @JvmName(name = "getGoodsId")
            public final String getGoodsId() {
                return this.goodsId;
            }

            @JvmName(name = "getGoodsType")
            public final String getGoodsType() {
                return this.goodsType;
            }

            @JvmName(name = "getGoodsTitle")
            public final String getGoodsTitle() {
                return this.goodsTitle;
            }

            public /* synthetic */ Info(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, JSONObject jSONObject2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) == 0 ? str5 : "", (i & 32) != 0 ? new JSONObject() : jSONObject, (i & 64) != 0 ? new JSONObject() : jSONObject2);
            }

            @JvmName(name = "getPrice")
            public final JSONObject getPrice() {
                return this.price;
            }

            @JvmName(name = "getExtendInfo")
            public final JSONObject getExtendInfo() {
                return this.extendInfo;
            }

            public final BizProductModel toBizProductModel() {
                return new BizProductModel("-1", MoneyViewModel.INSTANCE.fromCurrencyAmountModel((CurrencyAmountModel) JSON.toJavaObject(this.price, CurrencyAmountModel.class)), this.goodsId, this.goodsTitle, this.goodsType, "", true, "", this.voucherName, 0L, MapsKt.mapOf(TuplesKt.to(KEY_QUERY_URL_PROVIDER, this.extendInfo.getString(KEY_QUERY_URL_PROVIDER)), TuplesKt.to(KEY_BILLER_DENOM_TEXT, this.goodsTitle)), null, "");
            }
        }

        public final Info getInfoParsed() {
            JSONObject jSONObject = this.info;
            Info info = jSONObject != null ? (Info) JSON.toJavaObject(jSONObject, Info.class) : null;
            return info == null ? new Info(null, null, null, null, null, null, null, 127, null) : info;
        }
    }
}
