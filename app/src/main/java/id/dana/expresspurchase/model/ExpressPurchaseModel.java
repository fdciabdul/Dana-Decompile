package id.dana.expresspurchase.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.JSONObject;
import id.dana.domain.expresspurchase.constant.TemplateType;
import id.dana.expresspurchase.view.ExpressPurchaseActivity;
import id.dana.mybills.ui.constant.ServiceName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0007\u0012\u0013\u0014\u0015\u0016\u0017\u0018BA\b\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\t\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\n\u0082\u0001\u0004\u0019\u001a\u001b\u001c"}, d2 = {"Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "Landroid/os/Parcelable;", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;", "PlaceComponentResult", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;", "getAuthRequestContext", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;", "p0", "p1", "p2", "p3", "p4", "<init>", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;)V", ExpressPurchaseActivity.DEALS_EVENT_SOURCE, "Gold", ServiceName.INSURANCE, "OfferContent", "Paylater", "PaymentResultContent", "PreviousPurchasement", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Deals;", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Insurance;", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Paylater;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ExpressPurchaseModel implements Parcelable {
    public final PaymentResultContent BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final PaymentResultContent MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final PaymentResultContent PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final PaymentResultContent KClassImpl$Data$declaredNonStaticMembers$2;
    public final PreviousPurchasement getAuthRequestContext;

    public /* synthetic */ ExpressPurchaseModel(PreviousPurchasement previousPurchasement, PaymentResultContent paymentResultContent, PaymentResultContent paymentResultContent2, PaymentResultContent paymentResultContent3, PaymentResultContent paymentResultContent4, DefaultConstructorMarker defaultConstructorMarker) {
        this(previousPurchasement, paymentResultContent, paymentResultContent2, paymentResultContent3, paymentResultContent4);
    }

    private ExpressPurchaseModel(PreviousPurchasement previousPurchasement, PaymentResultContent paymentResultContent, PaymentResultContent paymentResultContent2, PaymentResultContent paymentResultContent3, PaymentResultContent paymentResultContent4) {
        this.getAuthRequestContext = previousPurchasement;
        this.PlaceComponentResult = paymentResultContent;
        this.BuiltInFictitiousFunctionClassFactory = paymentResultContent2;
        this.MyBillsEntityDataFactory = paymentResultContent3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = paymentResultContent4;
    }

    public /* synthetic */ ExpressPurchaseModel(PreviousPurchasement previousPurchasement, PaymentResultContent paymentResultContent, PaymentResultContent paymentResultContent2, PaymentResultContent paymentResultContent3, PaymentResultContent paymentResultContent4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(previousPurchasement, (i & 2) != 0 ? null : paymentResultContent, (i & 4) != 0 ? null : paymentResultContent2, (i & 8) != 0 ? null : paymentResultContent3, (i & 16) != 0 ? null : paymentResultContent4, null);
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B¶\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0001\u00103\u001a\u00020\u000b\u0012\u0006\u00104\u001a\u00020\u000b\u0012\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b00\u0012\u001b\b\u0002\u00106\u001a\u0015\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001a¢\u0006\u0002\b.\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u00108\u001a\u00020 \u0012\b\u00109\u001a\u0004\u0018\u00010#\u0012\b\u0010:\u001a\u0004\u0018\u00010#\u0012\b\u0010;\u001a\u0004\u0018\u00010#\u0012\b\u0010<\u001a\u0004\u0018\u00010#\u0012\u0006\u0010=\u001a\u00020)\u0012\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001a\u0012\u0006\u0010?\u001a\u00020\u000b¢\u0006\u0004\b@\u0010AJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001aX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0011\u0010\u0013\u001a\u00020 X\u0006¢\u0006\u0006\n\u0004\b!\u0010\"R\u0013\u0010\u001e\u001a\u0004\u0018\u00010#X\u0006¢\u0006\u0006\n\u0004\b$\u0010%R\u0013\u0010\u0016\u001a\u0004\u0018\u00010#X\u0006¢\u0006\u0006\n\u0004\b&\u0010%R\u0013\u0010\u0018\u001a\u0004\u0018\u00010#X\u0006¢\u0006\u0006\n\u0004\b'\u0010%R\u0013\u0010\u001b\u001a\u0004\u0018\u00010#X\u0006¢\u0006\u0006\n\u0004\b(\u0010%R\u0011\u0010'\u001a\u00020)X\u0006¢\u0006\u0006\n\u0004\b*\u0010+R\u0011\u0010&\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b,\u0010\u0014R\u0013\u0010$\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b-\u0010\u0014R$\u0010!\u001a\u0015\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001a¢\u0006\u0002\b.X\u0006¢\u0006\u0006\n\u0004\b/\u0010\u001cR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b00X\u0006¢\u0006\u0006\n\u0004\b1\u00102"}, d2 = {"Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;", "Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "moveToNextValue", "Ljava/lang/String;", "getAuthRequestContext", "lookAheadTest", "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda0", "BuiltInFictitiousFunctionClassFactory", "", "scheduleImpl", "Ljava/util/Map;", "PlaceComponentResult", "getErrorConfigVersion", "MyBillsEntityDataFactory", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent;", "DatabaseTableConfigUtil", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent;", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;", "initRecordTimeStamp", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;", "PrepareContext", "newProxyInstance", "Lkotlinx/android/parcel/RawValue;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "", "isLayoutRequested", "Ljava/util/List;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;Ljava/util/Map;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Gold extends ExpressPurchaseModel {
        public static final Parcelable.Creator<Gold> CREATOR = new Creator();

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        public final OfferContent moveToNextValue;

        /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
        public final PaymentResultContent lookAheadTest;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        public final PaymentResultContent scheduleImpl;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
        public final PaymentResultContent NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
        public final PreviousPurchasement NetworkUserEntityData$$ExternalSyntheticLambda2;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
        public final Map<String, Object> DatabaseTableConfigUtil;

        /* renamed from: PrepareContext  reason: from kotlin metadata */
        public final String GetContactSyncConfig;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        public final PaymentResultContent getErrorConfigVersion;

        /* renamed from: isLayoutRequested  reason: from kotlin metadata */
        public final List<String> NetworkUserEntityData$$ExternalSyntheticLambda1;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* renamed from: newProxyInstance  reason: from kotlin metadata */
        public final String initRecordTimeStamp;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public final Map<String, String> PlaceComponentResult;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Gold) {
                Gold gold = (Gold) p0;
                return Intrinsics.areEqual(this.getAuthRequestContext, gold.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, gold.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.GetContactSyncConfig, gold.GetContactSyncConfig) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, gold.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, gold.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, gold.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.initRecordTimeStamp, gold.initRecordTimeStamp) && Intrinsics.areEqual(this.moveToNextValue, gold.moveToNextValue) && Intrinsics.areEqual(this.scheduleImpl, gold.scheduleImpl) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, gold.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.lookAheadTest, gold.lookAheadTest) && Intrinsics.areEqual(this.getErrorConfigVersion, gold.getErrorConfigVersion) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, gold.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.PlaceComponentResult, gold.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, gold.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.getAuthRequestContext.hashCode();
            int hashCode2 = this.MyBillsEntityDataFactory.hashCode();
            int hashCode3 = this.GetContactSyncConfig.hashCode();
            int hashCode4 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
            int hashCode5 = this.NetworkUserEntityData$$ExternalSyntheticLambda1.hashCode();
            int hashCode6 = this.DatabaseTableConfigUtil.hashCode();
            String str = this.initRecordTimeStamp;
            int hashCode7 = str == null ? 0 : str.hashCode();
            int hashCode8 = this.moveToNextValue.hashCode();
            PaymentResultContent paymentResultContent = this.scheduleImpl;
            int hashCode9 = paymentResultContent == null ? 0 : paymentResultContent.hashCode();
            PaymentResultContent paymentResultContent2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int hashCode10 = paymentResultContent2 == null ? 0 : paymentResultContent2.hashCode();
            PaymentResultContent paymentResultContent3 = this.lookAheadTest;
            int hashCode11 = paymentResultContent3 == null ? 0 : paymentResultContent3.hashCode();
            PaymentResultContent paymentResultContent4 = this.getErrorConfigVersion;
            return (((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + (paymentResultContent4 != null ? paymentResultContent4.hashCode() : 0)) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda2.hashCode()) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Gold(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", GetContactSyncConfig=");
            sb.append(this.GetContactSyncConfig);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            sb.append(", DatabaseTableConfigUtil=");
            sb.append(this.DatabaseTableConfigUtil);
            sb.append(", initRecordTimeStamp=");
            sb.append(this.initRecordTimeStamp);
            sb.append(", moveToNextValue=");
            sb.append(this.moveToNextValue);
            sb.append(", scheduleImpl=");
            sb.append(this.scheduleImpl);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb.append(", lookAheadTest=");
            sb.append(this.lookAheadTest);
            sb.append(", getErrorConfigVersion=");
            sb.append(this.getErrorConfigVersion);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.getAuthRequestContext);
            p0.writeString(this.MyBillsEntityDataFactory);
            p0.writeString(this.GetContactSyncConfig);
            p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
            p0.writeStringList(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            Map<String, Object> map = this.DatabaseTableConfigUtil;
            p0.writeInt(map.size());
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                p0.writeString(entry.getKey());
                p0.writeValue(entry.getValue());
            }
            p0.writeString(this.initRecordTimeStamp);
            this.moveToNextValue.writeToParcel(p0, p1);
            PaymentResultContent paymentResultContent = this.scheduleImpl;
            if (paymentResultContent == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                paymentResultContent.writeToParcel(p0, p1);
            }
            PaymentResultContent paymentResultContent2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (paymentResultContent2 == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                paymentResultContent2.writeToParcel(p0, p1);
            }
            PaymentResultContent paymentResultContent3 = this.lookAheadTest;
            if (paymentResultContent3 == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                paymentResultContent3.writeToParcel(p0, p1);
            }
            PaymentResultContent paymentResultContent4 = this.getErrorConfigVersion;
            if (paymentResultContent4 == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                paymentResultContent4.writeToParcel(p0, p1);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.writeToParcel(p0, p1);
            Map<String, String> map2 = this.PlaceComponentResult;
            p0.writeInt(map2.size());
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                p0.writeString(entry2.getKey());
                p0.writeString(entry2.getValue());
            }
            p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        }

        public /* synthetic */ Gold(String str, String str2, String str3, String str4, List list, Map map, String str5, OfferContent offerContent, PaymentResultContent paymentResultContent, PaymentResultContent paymentResultContent2, PaymentResultContent paymentResultContent3, PaymentResultContent paymentResultContent4, PreviousPurchasement previousPurchasement, Map map2, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, (i & 16) != 0 ? new ArrayList() : list, (i & 32) != 0 ? new LinkedHashMap() : map, (i & 64) != 0 ? null : str5, offerContent, paymentResultContent, paymentResultContent2, paymentResultContent3, paymentResultContent4, previousPurchasement, map2, str6);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Gold(String str, String str2, @TemplateType String str3, String str4, List<String> list, Map<String, ? extends Object> map, String str5, OfferContent offerContent, PaymentResultContent paymentResultContent, PaymentResultContent paymentResultContent2, PaymentResultContent paymentResultContent3, PaymentResultContent paymentResultContent4, PreviousPurchasement previousPurchasement, Map<String, String> map2, String str6) {
            super(previousPurchasement, paymentResultContent, paymentResultContent2, paymentResultContent3, paymentResultContent4, null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(map, "");
            Intrinsics.checkNotNullParameter(offerContent, "");
            Intrinsics.checkNotNullParameter(previousPurchasement, "");
            Intrinsics.checkNotNullParameter(map2, "");
            Intrinsics.checkNotNullParameter(str6, "");
            this.getAuthRequestContext = str;
            this.MyBillsEntityDataFactory = str2;
            this.GetContactSyncConfig = str3;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str4;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = list;
            this.DatabaseTableConfigUtil = map;
            this.initRecordTimeStamp = str5;
            this.moveToNextValue = offerContent;
            this.scheduleImpl = paymentResultContent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = paymentResultContent2;
            this.lookAheadTest = paymentResultContent3;
            this.getErrorConfigVersion = paymentResultContent4;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = previousPurchasement;
            this.PlaceComponentResult = map2;
            this.BuiltInFictitiousFunctionClassFactory = str6;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Gold> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Gold createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                int i = 0;
                for (int i2 = 0; i2 != readInt; i2++) {
                    linkedHashMap.put(parcel.readString(), parcel.readValue(Gold.class.getClassLoader()));
                }
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                String readString5 = parcel.readString();
                OfferContent createFromParcel = OfferContent.CREATOR.createFromParcel(parcel);
                PaymentResultContent createFromParcel2 = parcel.readInt() == 0 ? null : PaymentResultContent.CREATOR.createFromParcel(parcel);
                PaymentResultContent createFromParcel3 = parcel.readInt() == 0 ? null : PaymentResultContent.CREATOR.createFromParcel(parcel);
                PaymentResultContent createFromParcel4 = parcel.readInt() == 0 ? null : PaymentResultContent.CREATOR.createFromParcel(parcel);
                PaymentResultContent createFromParcel5 = parcel.readInt() != 0 ? PaymentResultContent.CREATOR.createFromParcel(parcel) : null;
                PreviousPurchasement createFromParcel6 = PreviousPurchasement.CREATOR.createFromParcel(parcel);
                int readInt2 = parcel.readInt();
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(readInt2);
                while (i != readInt2) {
                    linkedHashMap3.put(parcel.readString(), parcel.readString());
                    i++;
                    readInt2 = readInt2;
                }
                return new Gold(readString, readString2, readString3, readString4, createStringArrayList, linkedHashMap2, readString5, createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, linkedHashMap3, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Gold[] newArray(int i) {
                return new Gold[i];
            }
        }

        public static /* synthetic */ Gold MyBillsEntityDataFactory(Gold gold, List list, Map map, String str) {
            String str2 = gold.getAuthRequestContext;
            String str3 = gold.MyBillsEntityDataFactory;
            String str4 = gold.GetContactSyncConfig;
            String str5 = gold.KClassImpl$Data$declaredNonStaticMembers$2;
            OfferContent offerContent = gold.moveToNextValue;
            PaymentResultContent paymentResultContent = gold.scheduleImpl;
            PaymentResultContent paymentResultContent2 = gold.NetworkUserEntityData$$ExternalSyntheticLambda0;
            PaymentResultContent paymentResultContent3 = gold.lookAheadTest;
            PaymentResultContent paymentResultContent4 = gold.getErrorConfigVersion;
            PreviousPurchasement previousPurchasement = gold.NetworkUserEntityData$$ExternalSyntheticLambda2;
            Map<String, String> map2 = gold.PlaceComponentResult;
            String str6 = gold.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(map, "");
            Intrinsics.checkNotNullParameter(offerContent, "");
            Intrinsics.checkNotNullParameter(previousPurchasement, "");
            Intrinsics.checkNotNullParameter(map2, "");
            Intrinsics.checkNotNullParameter(str6, "");
            return new Gold(str2, str3, str4, str5, list, map, str, offerContent, paymentResultContent, paymentResultContent2, paymentResultContent3, paymentResultContent4, previousPurchasement, map2, str6);
        }
    }

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0086\b\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0081\u0002\u0012\u0006\u0010\t\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\b\b\u0001\u0010B\u001a\u00020\r\u0012\u0006\u0010C\u001a\u00020(\u0012\u0006\u0010D\u001a\u00020\r\u0012\u0006\u0010E\u001a\u00020\r\u0012\u0006\u0010F\u001a\u00020\r\u0012\u0006\u0010G\u001a\u00020\r\u0012\u0006\u0010H\u001a\u00020\r\u0012\u0006\u0010I\u001a\u00020\r\u0012\u0006\u0010J\u001a\u00020\r\u0012\u0006\u0010K\u001a\u00020\r\u0012\u0006\u0010L\u001a\u00020\r\u0012\u0006\u0010M\u001a\u00020\r\u0012\u0006\u0010N\u001a\u00020\r\u0012\u0006\u0010O\u001a\u00020\r\u0012\b\u0010P\u001a\u0004\u0018\u00010?\u0012\b\u0010Q\u001a\u0004\u0018\u00010+\u0012\b\u0010R\u001a\u0004\u0018\u00010+\u0012\b\u0010S\u001a\u0004\u0018\u00010+\u0012\b\u0010T\u001a\u0004\u0018\u00010+\u0012\u0006\u0010U\u001a\u000201\u0012\b\u0010V\u001a\u0004\u0018\u00010\r\u0012\b\u0010W\u001a\u0004\u0018\u00010\r\u0012\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001b\u0012\b\b\u0002\u0010Y\u001a\u00020\u0002\u0012\b\u0010Z\u001a\u0004\u0018\u00010;¢\u0006\u0004\b[\u0010\\J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0017\u001a\u00020\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0003\u001a\u00020\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u001f\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001bX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0011\u0010 \u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0012\u0010\u001c\u001a\u00020\rX\u0086\u0002¢\u0006\u0006\n\u0004\b!\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b#\u0010\u0016R\u0011\u0010\u001f\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b$\u0010%R\u0011\u0010\u0015\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b&\u0010\u0016R\u0011\u0010#\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b'\u0010\u0016R\u0012\u0010\"\u001a\u00020(X\u0086\u0002¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010&\u001a\u0004\u0018\u00010+X\u0086\u0002¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010$\u001a\u0004\u0018\u00010+X\u0086\u0002¢\u0006\u0006\n\u0004\b.\u0010-R\u0014\u0010!\u001a\u0004\u0018\u00010+X\u0086\u0002¢\u0006\u0006\n\u0004\b/\u0010-R\u0014\u0010'\u001a\u0004\u0018\u00010+X\u0086\u0002¢\u0006\u0006\n\u0004\b0\u0010-R\u0012\u0010.\u001a\u000201X\u0086\u0002¢\u0006\u0006\n\u0004\b2\u00103R\u0011\u0010,\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b4\u0010\u0016R\u0011\u0010)\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b5\u0010\u0016R\u0011\u0010/\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b6\u0010\u0016R\u0011\u00105\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b7\u0010\u0016R\u0011\u00100\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b8\u0010\u0016R\u0014\u00102\u001a\u0004\u0018\u00010\rX\u0086\u0002¢\u0006\u0006\n\u0004\b9\u0010\u0016R\u0011\u00106\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b:\u0010\u0016R\u0013\u00104\u001a\u0004\u0018\u00010;X\u0006¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010<\u001a\u0004\u0018\u00010\rX\u0086\u0002¢\u0006\u0006\n\u0004\b>\u0010\u0016R\u0014\u0010:\u001a\u0004\u0018\u00010?X\u0086\u0002¢\u0006\u0006\n\u0004\b@\u0010A"}, d2 = {"Lid/dana/expresspurchase/model/ExpressPurchaseModel$Deals;", "Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "", "describeContents", "()I", "", "p0", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "moveToNextValue", "Ljava/lang/String;", "getAuthRequestContext", "lookAheadTest", "scheduleImpl", "PlaceComponentResult", "", "getErrorConfigVersion", "Ljava/util/Map;", "MyBillsEntityDataFactory", "NetworkUserEntityData$$ExternalSyntheticLambda0", "BuiltInFictitiousFunctionClassFactory", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "DatabaseTableConfigUtil", "initRecordTimeStamp", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda1", "PrepareContext", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent;", "isLayoutRequested", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent;", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda5", "getCallingPid", "readMicros", "getSupportButtonTintMode", "SubSequence", "", "whenAvailable", "Ljava/lang/Double;", "VerifyPinStateManager$executeRiskChallenge$2$1", "Lid/dana/expresspurchase/model/VoucherExpressInfoModel;", "C", "Lid/dana/expresspurchase/model/VoucherExpressInfoModel;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "p22", "p23", "p24", "p25", "p26", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/expresspurchase/model/VoucherExpressInfoModel;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZLjava/lang/Double;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Deals extends ExpressPurchaseModel {

        /* renamed from: C  reason: from kotlin metadata */
        public VoucherExpressInfoModel SubSequence;

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        public final String scheduleImpl;

        /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
        public PreviousPurchasement NetworkUserEntityData$$ExternalSyntheticLambda7;

        /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
        public final String lookAheadTest;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        public final String moveToNextValue;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
        public String getErrorConfigVersion;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
        public final String isLayoutRequested;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
        public final String NetworkUserEntityData$$ExternalSyntheticLambda8;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
        public final String newProxyInstance;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
        public PaymentResultContent PrepareContext;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
        public PaymentResultContent initRecordTimeStamp;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
        public PaymentResultContent NetworkUserEntityData$$ExternalSyntheticLambda1;

        /* renamed from: PrepareContext  reason: from kotlin metadata */
        public final String DatabaseTableConfigUtil;

        /* renamed from: SubSequence  reason: from kotlin metadata */
        public final String NetworkUserEntityData$$ExternalSyntheticLambda5;

        /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
        public String whenAvailable;

        /* renamed from: getCallingPid  reason: from kotlin metadata */
        public final String NetworkUserEntityData$$ExternalSyntheticLambda3;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public final Map<String, String> MyBillsEntityDataFactory;

        /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
        public String FragmentBottomSheetPaymentSettingBinding;

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: isLayoutRequested  reason: from kotlin metadata */
        public OfferContent GetContactSyncConfig;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public String getAuthRequestContext;

        /* renamed from: newProxyInstance  reason: from kotlin metadata */
        public PaymentResultContent NetworkUserEntityData$$ExternalSyntheticLambda2;

        /* renamed from: readMicros  reason: from kotlin metadata */
        public final String NetworkUserEntityData$$ExternalSyntheticLambda6;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        /* renamed from: whenAvailable  reason: from kotlin metadata */
        public final Double NetworkUserEntityData$$ExternalSyntheticLambda4;
        public static final Parcelable.Creator<Deals> CREATOR = new Creator();

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Deals) {
                Deals deals = (Deals) p0;
                return Intrinsics.areEqual(this.getAuthRequestContext, deals.getAuthRequestContext) && Intrinsics.areEqual(this.getErrorConfigVersion, deals.getErrorConfigVersion) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda5, deals.NetworkUserEntityData$$ExternalSyntheticLambda5) && Intrinsics.areEqual(this.GetContactSyncConfig, deals.GetContactSyncConfig) && Intrinsics.areEqual(this.lookAheadTest, deals.lookAheadTest) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, deals.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.scheduleImpl, deals.scheduleImpl) && Intrinsics.areEqual(this.PlaceComponentResult, deals.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, deals.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.moveToNextValue, deals.moveToNextValue) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, deals.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda6, deals.NetworkUserEntityData$$ExternalSyntheticLambda6) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda3, deals.NetworkUserEntityData$$ExternalSyntheticLambda3) && Intrinsics.areEqual(this.newProxyInstance, deals.newProxyInstance) && Intrinsics.areEqual(this.isLayoutRequested, deals.isLayoutRequested) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, deals.NetworkUserEntityData$$ExternalSyntheticLambda8) && Intrinsics.areEqual(this.SubSequence, deals.SubSequence) && Intrinsics.areEqual(this.PrepareContext, deals.PrepareContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, deals.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.initRecordTimeStamp, deals.initRecordTimeStamp) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, deals.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, deals.NetworkUserEntityData$$ExternalSyntheticLambda7) && Intrinsics.areEqual(this.whenAvailable, deals.whenAvailable) && Intrinsics.areEqual(this.FragmentBottomSheetPaymentSettingBinding, deals.FragmentBottomSheetPaymentSettingBinding) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, deals.MyBillsEntityDataFactory) && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == deals.NetworkUserEntityData$$ExternalSyntheticLambda0 && Intrinsics.areEqual((Object) this.NetworkUserEntityData$$ExternalSyntheticLambda4, (Object) deals.NetworkUserEntityData$$ExternalSyntheticLambda4);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.getAuthRequestContext.hashCode();
            int hashCode2 = this.getErrorConfigVersion.hashCode();
            int hashCode3 = this.NetworkUserEntityData$$ExternalSyntheticLambda5.hashCode();
            int hashCode4 = this.GetContactSyncConfig.hashCode();
            int hashCode5 = this.lookAheadTest.hashCode();
            int hashCode6 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
            int hashCode7 = this.scheduleImpl.hashCode();
            int hashCode8 = this.PlaceComponentResult.hashCode();
            int hashCode9 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
            int hashCode10 = this.moveToNextValue.hashCode();
            int hashCode11 = this.DatabaseTableConfigUtil.hashCode();
            int hashCode12 = this.NetworkUserEntityData$$ExternalSyntheticLambda6.hashCode();
            int hashCode13 = this.NetworkUserEntityData$$ExternalSyntheticLambda3.hashCode();
            int hashCode14 = this.newProxyInstance.hashCode();
            int hashCode15 = this.isLayoutRequested.hashCode();
            int hashCode16 = this.NetworkUserEntityData$$ExternalSyntheticLambda8.hashCode();
            VoucherExpressInfoModel voucherExpressInfoModel = this.SubSequence;
            int hashCode17 = voucherExpressInfoModel == null ? 0 : voucherExpressInfoModel.hashCode();
            PaymentResultContent paymentResultContent = this.PrepareContext;
            int hashCode18 = paymentResultContent == null ? 0 : paymentResultContent.hashCode();
            PaymentResultContent paymentResultContent2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            int hashCode19 = paymentResultContent2 == null ? 0 : paymentResultContent2.hashCode();
            PaymentResultContent paymentResultContent3 = this.initRecordTimeStamp;
            int hashCode20 = paymentResultContent3 == null ? 0 : paymentResultContent3.hashCode();
            PaymentResultContent paymentResultContent4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            int hashCode21 = paymentResultContent4 == null ? 0 : paymentResultContent4.hashCode();
            int hashCode22 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.hashCode();
            String str = this.whenAvailable;
            int hashCode23 = str == null ? 0 : str.hashCode();
            String str2 = this.FragmentBottomSheetPaymentSettingBinding;
            int hashCode24 = str2 == null ? 0 : str2.hashCode();
            Map<String, String> map = this.MyBillsEntityDataFactory;
            int hashCode25 = map == null ? 0 : map.hashCode();
            boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i = z ? 1 : z ? 1 : 0;
            Double d = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            return (((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + i) * 31) + (d != null ? d.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Deals(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", getErrorConfigVersion=");
            sb.append(this.getErrorConfigVersion);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda5=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            sb.append(", GetContactSyncConfig=");
            sb.append(this.GetContactSyncConfig);
            sb.append(", lookAheadTest=");
            sb.append(this.lookAheadTest);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", scheduleImpl=");
            sb.append(this.scheduleImpl);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", moveToNextValue=");
            sb.append(this.moveToNextValue);
            sb.append(", DatabaseTableConfigUtil=");
            sb.append(this.DatabaseTableConfigUtil);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda6=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda3=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            sb.append(", newProxyInstance=");
            sb.append(this.newProxyInstance);
            sb.append(", isLayoutRequested=");
            sb.append(this.isLayoutRequested);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda8=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            sb.append(", SubSequence=");
            sb.append(this.SubSequence);
            sb.append(", PrepareContext=");
            sb.append(this.PrepareContext);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            sb.append(", initRecordTimeStamp=");
            sb.append(this.initRecordTimeStamp);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            sb.append(", whenAvailable=");
            sb.append(this.whenAvailable);
            sb.append(", FragmentBottomSheetPaymentSettingBinding=");
            sb.append(this.FragmentBottomSheetPaymentSettingBinding);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda4=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.getAuthRequestContext);
            p0.writeString(this.getErrorConfigVersion);
            p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.GetContactSyncConfig.writeToParcel(p0, p1);
            p0.writeString(this.lookAheadTest);
            p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
            p0.writeString(this.scheduleImpl);
            p0.writeString(this.PlaceComponentResult);
            p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
            p0.writeString(this.moveToNextValue);
            p0.writeString(this.DatabaseTableConfigUtil);
            p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            p0.writeString(this.newProxyInstance);
            p0.writeString(this.isLayoutRequested);
            p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            VoucherExpressInfoModel voucherExpressInfoModel = this.SubSequence;
            if (voucherExpressInfoModel == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                voucherExpressInfoModel.writeToParcel(p0, p1);
            }
            PaymentResultContent paymentResultContent = this.PrepareContext;
            if (paymentResultContent == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                paymentResultContent.writeToParcel(p0, p1);
            }
            PaymentResultContent paymentResultContent2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (paymentResultContent2 == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                paymentResultContent2.writeToParcel(p0, p1);
            }
            PaymentResultContent paymentResultContent3 = this.initRecordTimeStamp;
            if (paymentResultContent3 == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                paymentResultContent3.writeToParcel(p0, p1);
            }
            PaymentResultContent paymentResultContent4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (paymentResultContent4 == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                paymentResultContent4.writeToParcel(p0, p1);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda7.writeToParcel(p0, p1);
            p0.writeString(this.whenAvailable);
            p0.writeString(this.FragmentBottomSheetPaymentSettingBinding);
            Map<String, String> map = this.MyBillsEntityDataFactory;
            if (map == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                p0.writeInt(map.size());
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    p0.writeString(entry.getKey());
                    p0.writeString(entry.getValue());
                }
            }
            p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda0 ? 1 : 0);
            Double d = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (d == null) {
                p0.writeInt(0);
                return;
            }
            p0.writeInt(1);
            p0.writeDouble(d.doubleValue());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Deals(String str, String str2, @TemplateType String str3, OfferContent offerContent, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, VoucherExpressInfoModel voucherExpressInfoModel, PaymentResultContent paymentResultContent, PaymentResultContent paymentResultContent2, PaymentResultContent paymentResultContent3, PaymentResultContent paymentResultContent4, PreviousPurchasement previousPurchasement, String str16, String str17, Map<String, String> map, boolean z, Double d) {
            super(previousPurchasement, paymentResultContent, paymentResultContent2, paymentResultContent3, paymentResultContent4, null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(offerContent, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(str6, "");
            Intrinsics.checkNotNullParameter(str7, "");
            Intrinsics.checkNotNullParameter(str8, "");
            Intrinsics.checkNotNullParameter(str9, "");
            Intrinsics.checkNotNullParameter(str10, "");
            Intrinsics.checkNotNullParameter(str11, "");
            Intrinsics.checkNotNullParameter(str12, "");
            Intrinsics.checkNotNullParameter(str13, "");
            Intrinsics.checkNotNullParameter(str14, "");
            Intrinsics.checkNotNullParameter(str15, "");
            Intrinsics.checkNotNullParameter(previousPurchasement, "");
            this.getAuthRequestContext = str;
            this.getErrorConfigVersion = str2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = str3;
            this.GetContactSyncConfig = offerContent;
            this.lookAheadTest = str4;
            this.BuiltInFictitiousFunctionClassFactory = str5;
            this.scheduleImpl = str6;
            this.PlaceComponentResult = str7;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str8;
            this.moveToNextValue = str9;
            this.DatabaseTableConfigUtil = str10;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = str11;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = str12;
            this.newProxyInstance = str13;
            this.isLayoutRequested = str14;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str15;
            this.SubSequence = voucherExpressInfoModel;
            this.PrepareContext = paymentResultContent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = paymentResultContent2;
            this.initRecordTimeStamp = paymentResultContent3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = paymentResultContent4;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = previousPurchasement;
            this.whenAvailable = str16;
            this.FragmentBottomSheetPaymentSettingBinding = str17;
            this.MyBillsEntityDataFactory = map;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = d;
        }

        public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            Map<String, String> map = this.MyBillsEntityDataFactory;
            if (map != null) {
                String str = map.get("AGGREGATOR_VOUCHER");
                Boolean valueOf = str != null ? Boolean.valueOf(Intrinsics.areEqual(JSONObject.parseObject(str).get("redemptionType"), "ONLINE")) : null;
                if (valueOf != null) {
                    return valueOf.booleanValue();
                }
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Deals> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Deals createFromParcel(Parcel parcel) {
                LinkedHashMap linkedHashMap;
                String str;
                Intrinsics.checkNotNullParameter(parcel, "");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                OfferContent createFromParcel = OfferContent.CREATOR.createFromParcel(parcel);
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                String readString13 = parcel.readString();
                String readString14 = parcel.readString();
                String readString15 = parcel.readString();
                VoucherExpressInfoModel createFromParcel2 = parcel.readInt() == 0 ? null : VoucherExpressInfoModel.CREATOR.createFromParcel(parcel);
                PaymentResultContent createFromParcel3 = parcel.readInt() == 0 ? null : PaymentResultContent.CREATOR.createFromParcel(parcel);
                PaymentResultContent createFromParcel4 = parcel.readInt() == 0 ? null : PaymentResultContent.CREATOR.createFromParcel(parcel);
                PaymentResultContent createFromParcel5 = parcel.readInt() == 0 ? null : PaymentResultContent.CREATOR.createFromParcel(parcel);
                PaymentResultContent createFromParcel6 = parcel.readInt() == 0 ? null : PaymentResultContent.CREATOR.createFromParcel(parcel);
                PreviousPurchasement createFromParcel7 = PreviousPurchasement.CREATOR.createFromParcel(parcel);
                String readString16 = parcel.readString();
                String readString17 = parcel.readString();
                if (parcel.readInt() == 0) {
                    str = readString12;
                    linkedHashMap = null;
                } else {
                    int readInt = parcel.readInt();
                    linkedHashMap = new LinkedHashMap(readInt);
                    int i = 0;
                    while (i != readInt) {
                        linkedHashMap.put(parcel.readString(), parcel.readString());
                        i++;
                        readInt = readInt;
                        readString12 = readString12;
                    }
                    str = readString12;
                }
                return new Deals(readString, readString2, readString3, createFromParcel, readString4, readString5, readString6, readString7, readString8, readString9, readString10, readString11, str, readString13, readString14, readString15, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, readString16, readString17, linkedHashMap, parcel.readInt() != 0, parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()));
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Deals[] newArray(int i) {
                return new Deals[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0001\u0010-\u001a\u00020\u000b\u0012\u0006\u0010.\u001a\u00020\u000b\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u00100\u001a\u00020\u001e\u0012\b\u00101\u001a\u0004\u0018\u00010\"\u0012\b\u00102\u001a\u0004\u0018\u00010\"\u0012\b\u00103\u001a\u0004\u0018\u00010\"\u0012\b\u00104\u001a\u0004\u0018\u00010\"\u0012\u0006\u00105\u001a\u00020(\u0012\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0018¢\u0006\u0004\b7\u00108J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0018X\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0011\u0010!\u001a\u00020\u001eX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\"X\u0006¢\u0006\u0006\n\u0004\b#\u0010$R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\"X\u0006¢\u0006\u0006\n\u0004\b%\u0010$R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\"X\u0006¢\u0006\u0006\n\u0004\b&\u0010$R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\"X\u0006¢\u0006\u0006\n\u0004\b'\u0010$R\u0011\u0010\u0019\u001a\u00020(X\u0006¢\u0006\u0006\n\u0004\b)\u0010*R\u0011\u0010#\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b+\u0010\u0014R\u0013\u0010&\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b,\u0010\u0014"}, d2 = {"Lid/dana/expresspurchase/model/ExpressPurchaseModel$Insurance;", "Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "moveToNextValue", "PlaceComponentResult", "", "lookAheadTest", "Ljava/util/Map;", "KClassImpl$Data$declaredNonStaticMembers$2", "getErrorConfigVersion", "getAuthRequestContext", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent;", "scheduleImpl", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent;", "MyBillsEntityDataFactory", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;", "initRecordTimeStamp", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;", "GetContactSyncConfig", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda8", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Insurance extends ExpressPurchaseModel {
        public static final Parcelable.Creator<Insurance> CREATOR = new Creator();

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        public final PaymentResultContent scheduleImpl;

        /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
        public final PreviousPurchasement lookAheadTest;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        public final PaymentResultContent moveToNextValue;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
        public final PaymentResultContent getErrorConfigVersion;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
        public final String DatabaseTableConfigUtil;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        public final PaymentResultContent NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public final Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        /* renamed from: newProxyInstance  reason: from kotlin metadata */
        public final String initRecordTimeStamp;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public final OfferContent MyBillsEntityDataFactory;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Insurance) {
                Insurance insurance = (Insurance) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, insurance.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, insurance.getAuthRequestContext) && Intrinsics.areEqual(this.initRecordTimeStamp, insurance.initRecordTimeStamp) && Intrinsics.areEqual(this.PlaceComponentResult, insurance.PlaceComponentResult) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, insurance.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, insurance.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.moveToNextValue, insurance.moveToNextValue) && Intrinsics.areEqual(this.scheduleImpl, insurance.scheduleImpl) && Intrinsics.areEqual(this.getErrorConfigVersion, insurance.getErrorConfigVersion) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, insurance.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.lookAheadTest, insurance.lookAheadTest) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, insurance.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
            int hashCode2 = this.getAuthRequestContext.hashCode();
            int hashCode3 = this.initRecordTimeStamp.hashCode();
            int hashCode4 = this.PlaceComponentResult.hashCode();
            String str = this.DatabaseTableConfigUtil;
            int hashCode5 = str == null ? 0 : str.hashCode();
            int hashCode6 = this.MyBillsEntityDataFactory.hashCode();
            PaymentResultContent paymentResultContent = this.moveToNextValue;
            int hashCode7 = paymentResultContent == null ? 0 : paymentResultContent.hashCode();
            PaymentResultContent paymentResultContent2 = this.scheduleImpl;
            int hashCode8 = paymentResultContent2 == null ? 0 : paymentResultContent2.hashCode();
            PaymentResultContent paymentResultContent3 = this.getErrorConfigVersion;
            int hashCode9 = paymentResultContent3 == null ? 0 : paymentResultContent3.hashCode();
            PaymentResultContent paymentResultContent4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + (paymentResultContent4 != null ? paymentResultContent4.hashCode() : 0)) * 31) + this.lookAheadTest.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Insurance(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", initRecordTimeStamp=");
            sb.append(this.initRecordTimeStamp);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", DatabaseTableConfigUtil=");
            sb.append(this.DatabaseTableConfigUtil);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", moveToNextValue=");
            sb.append(this.moveToNextValue);
            sb.append(", scheduleImpl=");
            sb.append(this.scheduleImpl);
            sb.append(", getErrorConfigVersion=");
            sb.append(this.getErrorConfigVersion);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb.append(", lookAheadTest=");
            sb.append(this.lookAheadTest);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
            p0.writeString(this.getAuthRequestContext);
            p0.writeString(this.initRecordTimeStamp);
            p0.writeString(this.PlaceComponentResult);
            p0.writeString(this.DatabaseTableConfigUtil);
            this.MyBillsEntityDataFactory.writeToParcel(p0, p1);
            PaymentResultContent paymentResultContent = this.moveToNextValue;
            if (paymentResultContent == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                paymentResultContent.writeToParcel(p0, p1);
            }
            PaymentResultContent paymentResultContent2 = this.scheduleImpl;
            if (paymentResultContent2 == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                paymentResultContent2.writeToParcel(p0, p1);
            }
            PaymentResultContent paymentResultContent3 = this.getErrorConfigVersion;
            if (paymentResultContent3 == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                paymentResultContent3.writeToParcel(p0, p1);
            }
            PaymentResultContent paymentResultContent4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (paymentResultContent4 == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                paymentResultContent4.writeToParcel(p0, p1);
            }
            this.lookAheadTest.writeToParcel(p0, p1);
            Map<String, String> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
            p0.writeInt(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                p0.writeString(entry.getKey());
                p0.writeString(entry.getValue());
            }
        }

        public /* synthetic */ Insurance(String str, String str2, String str3, String str4, String str5, OfferContent offerContent, PaymentResultContent paymentResultContent, PaymentResultContent paymentResultContent2, PaymentResultContent paymentResultContent3, PaymentResultContent paymentResultContent4, PreviousPurchasement previousPurchasement, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, (i & 16) != 0 ? null : str5, offerContent, paymentResultContent, paymentResultContent2, paymentResultContent3, paymentResultContent4, previousPurchasement, map);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Insurance(String str, String str2, @TemplateType String str3, String str4, String str5, OfferContent offerContent, PaymentResultContent paymentResultContent, PaymentResultContent paymentResultContent2, PaymentResultContent paymentResultContent3, PaymentResultContent paymentResultContent4, PreviousPurchasement previousPurchasement, Map<String, String> map) {
            super(previousPurchasement, paymentResultContent, paymentResultContent2, paymentResultContent3, paymentResultContent4, null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(offerContent, "");
            Intrinsics.checkNotNullParameter(previousPurchasement, "");
            Intrinsics.checkNotNullParameter(map, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.getAuthRequestContext = str2;
            this.initRecordTimeStamp = str3;
            this.PlaceComponentResult = str4;
            this.DatabaseTableConfigUtil = str5;
            this.MyBillsEntityDataFactory = offerContent;
            this.moveToNextValue = paymentResultContent;
            this.scheduleImpl = paymentResultContent2;
            this.getErrorConfigVersion = paymentResultContent3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = paymentResultContent4;
            this.lookAheadTest = previousPurchasement;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = map;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Insurance> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Insurance createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                OfferContent createFromParcel = OfferContent.CREATOR.createFromParcel(parcel);
                PaymentResultContent createFromParcel2 = parcel.readInt() == 0 ? null : PaymentResultContent.CREATOR.createFromParcel(parcel);
                PaymentResultContent createFromParcel3 = parcel.readInt() == 0 ? null : PaymentResultContent.CREATOR.createFromParcel(parcel);
                PaymentResultContent createFromParcel4 = parcel.readInt() == 0 ? null : PaymentResultContent.CREATOR.createFromParcel(parcel);
                PaymentResultContent createFromParcel5 = parcel.readInt() != 0 ? PaymentResultContent.CREATOR.createFromParcel(parcel) : null;
                PreviousPurchasement createFromParcel6 = PreviousPurchasement.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                for (int i = 0; i != readInt; i++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
                return new Insurance(readString, readString2, readString3, readString4, readString5, createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, linkedHashMap);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Insurance[] newArray(int i) {
                return new Insurance[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001:\u0001)B5\u0012\u0006\u0010\u0006\u001a\u00020\u001b\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u000b\u0012\u0006\u0010%\u001a\u00020\u000b\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001e\u001a\u00020\u001bX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0011\u0010!\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0011\u0010#\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\"\u0010 "}, d2 = {"Lid/dana/expresspurchase/model/ExpressPurchaseModel$Paylater;", "Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Paylater$BenefitContent;", "lookAheadTest", "Ljava/util/List;", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda0", "I", "getAuthRequestContext", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;", "moveToNextValue", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;", "KClassImpl$Data$declaredNonStaticMembers$2", "scheduleImpl", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "getErrorConfigVersion", "MyBillsEntityDataFactory", "p2", "p3", "p4", "<init>", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "BenefitContent"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Paylater extends ExpressPurchaseModel {
        public static final Parcelable.Creator<Paylater> CREATOR = new Creator();

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public final int getAuthRequestContext;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public final List<BenefitContent> PlaceComponentResult;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public final PreviousPurchasement KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Paylater) {
                Paylater paylater = (Paylater) p0;
                return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, paylater.KClassImpl$Data$declaredNonStaticMembers$2) && this.getAuthRequestContext == paylater.getAuthRequestContext && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, paylater.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, paylater.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, paylater.PlaceComponentResult);
            }
            return false;
        }

        public final int hashCode() {
            return (((((((this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + this.getAuthRequestContext) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.PlaceComponentResult.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Paylater(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2.writeToParcel(p0, p1);
            p0.writeInt(this.getAuthRequestContext);
            p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
            p0.writeString(this.MyBillsEntityDataFactory);
            List<BenefitContent> list = this.PlaceComponentResult;
            p0.writeInt(list.size());
            Iterator<BenefitContent> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(p0, p1);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paylater(PreviousPurchasement previousPurchasement, int i, String str, String str2, List<BenefitContent> list) {
            super(previousPurchasement, null, null, null, null, 30, null);
            Intrinsics.checkNotNullParameter(previousPurchasement, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(list, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = previousPurchasement;
            this.getAuthRequestContext = i;
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.MyBillsEntityDataFactory = str2;
            this.PlaceComponentResult = list;
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014"}, d2 = {"Lid/dana/expresspurchase/model/ExpressPurchaseModel$Paylater$BenefitContent;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "MyBillsEntityDataFactory", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class BenefitContent implements Parcelable {
            public static final Parcelable.Creator<BenefitContent> CREATOR = new Creator();

            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
            public String getAuthRequestContext;

            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
            public String PlaceComponentResult;
            public String MyBillsEntityDataFactory;

            public /* synthetic */ BenefitContent() {
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            public final boolean equals(Object p0) {
                if (this == p0) {
                    return true;
                }
                if (p0 instanceof BenefitContent) {
                    BenefitContent benefitContent = (BenefitContent) p0;
                    return Intrinsics.areEqual(this.MyBillsEntityDataFactory, benefitContent.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, benefitContent.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, benefitContent.getAuthRequestContext);
                }
                return false;
            }

            public final int hashCode() {
                return (((this.MyBillsEntityDataFactory.hashCode() * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.getAuthRequestContext.hashCode();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("BenefitContent(MyBillsEntityDataFactory=");
                sb.append(this.MyBillsEntityDataFactory);
                sb.append(", PlaceComponentResult=");
                sb.append(this.PlaceComponentResult);
                sb.append(", getAuthRequestContext=");
                sb.append(this.getAuthRequestContext);
                sb.append(')');
                return sb.toString();
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                p0.writeString(this.MyBillsEntityDataFactory);
                p0.writeString(this.PlaceComponentResult);
                p0.writeString(this.getAuthRequestContext);
            }

            public BenefitContent(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
                this.MyBillsEntityDataFactory = str;
                this.PlaceComponentResult = str2;
                this.getAuthRequestContext = str3;
            }

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes5.dex */
            public static final class Creator implements Parcelable.Creator<BenefitContent> {
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ BenefitContent createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "");
                    return new BenefitContent(parcel.readString(), parcel.readString(), parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ BenefitContent[] newArray(int i) {
                    return new BenefitContent[i];
                }
            }
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Paylater> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Paylater createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                PreviousPurchasement createFromParcel = PreviousPurchasement.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                int readInt2 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt2);
                for (int i = 0; i != readInt2; i++) {
                    arrayList.add(BenefitContent.CREATOR.createFromParcel(parcel));
                }
                return new Paylater(createFromParcel, readInt, readString, readString2, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Paylater[] newArray(int i) {
                return new Paylater[i];
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b+\u0018\u00002\u00020\u0001:\u0001:B±\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u000f\u0012\u0006\u0010%\u001a\u00020\u000f\u0012\u0006\u0010&\u001a\u00020\u000f\u0012\u0006\u0010'\u001a\u00020\u000f\u0012\u0006\u0010(\u001a\u00020\u000f\u0012\u0006\u0010)\u001a\u00020\u000f\u0012\u0006\u0010*\u001a\u00020\u000f\u0012\u0006\u0010+\u001a\u00020\u000f\u0012\u0006\u0010,\u001a\u00020\u000f\u0012\u0006\u0010-\u001a\u00020\u000f\u0012\u0006\u0010.\u001a\u00020\u000f\u0012\u0006\u0010/\u001a\u00020\u000f\u0012\b\u00100\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u00101\u001a\u00020\u000f\u0012\u0006\u00102\u001a\u00020\u000f\u0012\u0006\u00103\u001a\u00020\u000f\u0012\u0006\u00104\u001a\u00020\u000f\u0012\u0006\u00105\u001a\u00020\u000f\u0012\u0006\u00106\u001a\u00020\u000f\u0012\u0006\u00107\u001a\u00020\u000f¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0010\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0011\u0010\f\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0015\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0018\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0017\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0011\u0010\u001a\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0011\u0010\u001c\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u0011\u0010\u001d\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u0011R\u0011\u0010\u001b\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u0011R\u0011\u0010\u0019\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u0011\u0010\u001f\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\u0011R\u0011\u0010!\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b \u0010\u0011R\u0011\u0010\"\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\u0011R\u0011\u0010\u001e\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b!\u0010\u0011R\u0011\u0010 \u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\"\u0010\u0011R\u0011\u0010$\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b#\u0010\u0011"}, d2 = {"Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent$BenefitModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent$BenefitModel;", "BuiltInFictitiousFunctionClassFactory", "", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "PlaceComponentResult", "scheduleImpl", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "initRecordTimeStamp", "GetContactSyncConfig", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda8", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda7", "newProxyInstance", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda4", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent$BenefitModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "BenefitModel"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class OfferContent implements Parcelable {
        public static final Parcelable.Creator<OfferContent> CREATOR = new Creator();

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String getAuthRequestContext;
        public final String DatabaseTableConfigUtil;

        /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
        public final String NetworkUserEntityData$$ExternalSyntheticLambda1;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final BenefitModel BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public final String scheduleImpl;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
        public final String initRecordTimeStamp;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
        public final String NetworkUserEntityData$$ExternalSyntheticLambda4;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
        public final String newProxyInstance;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
        public final String PrepareContext;
        public final String PlaceComponentResult;

        /* renamed from: PrepareContext  reason: from kotlin metadata */
        public final String isLayoutRequested;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        public final String GetContactSyncConfig;

        /* renamed from: isLayoutRequested  reason: from kotlin metadata */
        public final String NetworkUserEntityData$$ExternalSyntheticLambda7;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public final String getErrorConfigVersion;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public final String lookAheadTest;

        /* renamed from: newProxyInstance  reason: from kotlin metadata */
        public final String NetworkUserEntityData$$ExternalSyntheticLambda8;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public final String moveToNextValue;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.moveToNextValue);
            p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            p0.writeString(this.newProxyInstance);
            p0.writeString(this.GetContactSyncConfig);
            p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            p0.writeString(this.DatabaseTableConfigUtil);
            p0.writeString(this.lookAheadTest);
            p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
            p0.writeString(this.scheduleImpl);
            p0.writeString(this.getErrorConfigVersion);
            p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            p0.writeString(this.initRecordTimeStamp);
            BenefitModel benefitModel = this.BuiltInFictitiousFunctionClassFactory;
            if (benefitModel == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                benefitModel.writeToParcel(p0, p1);
            }
            p0.writeString(this.MyBillsEntityDataFactory);
            p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            p0.writeString(this.isLayoutRequested);
            p0.writeString(this.PrepareContext);
            p0.writeString(this.getAuthRequestContext);
            p0.writeString(this.PlaceComponentResult);
        }

        public OfferContent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, BenefitModel benefitModel, String str14, String str15, String str16, String str17, String str18, String str19, String str20) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(str6, "");
            Intrinsics.checkNotNullParameter(str7, "");
            Intrinsics.checkNotNullParameter(str8, "");
            Intrinsics.checkNotNullParameter(str9, "");
            Intrinsics.checkNotNullParameter(str10, "");
            Intrinsics.checkNotNullParameter(str11, "");
            Intrinsics.checkNotNullParameter(str12, "");
            Intrinsics.checkNotNullParameter(str13, "");
            Intrinsics.checkNotNullParameter(str14, "");
            Intrinsics.checkNotNullParameter(str15, "");
            Intrinsics.checkNotNullParameter(str16, "");
            Intrinsics.checkNotNullParameter(str17, "");
            Intrinsics.checkNotNullParameter(str18, "");
            Intrinsics.checkNotNullParameter(str19, "");
            Intrinsics.checkNotNullParameter(str20, "");
            this.moveToNextValue = str;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str2;
            this.newProxyInstance = str3;
            this.GetContactSyncConfig = str4;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str5;
            this.DatabaseTableConfigUtil = str6;
            this.lookAheadTest = str7;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str8;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str9;
            this.scheduleImpl = str10;
            this.getErrorConfigVersion = str11;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str12;
            this.initRecordTimeStamp = str13;
            this.BuiltInFictitiousFunctionClassFactory = benefitModel;
            this.MyBillsEntityDataFactory = str14;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = str15;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = str16;
            this.isLayoutRequested = str17;
            this.PrepareContext = str18;
            this.getAuthRequestContext = str19;
            this.PlaceComponentResult = str20;
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u0007\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\f\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\r"}, d2 = {"Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent$BenefitModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "PlaceComponentResult", "getAuthRequestContext", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class BenefitModel implements Parcelable {
            public static final Parcelable.Creator<BenefitModel> CREATOR = new Creator();

            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
            public final String MyBillsEntityDataFactory;

            /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
            public final String BuiltInFictitiousFunctionClassFactory;

            /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
            public final String PlaceComponentResult;

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                p0.writeString(this.PlaceComponentResult);
                p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
                p0.writeString(this.MyBillsEntityDataFactory);
            }

            public BenefitModel(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
                this.PlaceComponentResult = str;
                this.BuiltInFictitiousFunctionClassFactory = str2;
                this.MyBillsEntityDataFactory = str3;
            }

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes5.dex */
            public static final class Creator implements Parcelable.Creator<BenefitModel> {
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ BenefitModel createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "");
                    return new BenefitModel(parcel.readString(), parcel.readString(), parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ BenefitModel[] newArray(int i) {
                    return new BenefitModel[i];
                }
            }
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<OfferContent> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ OfferContent createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new OfferContent(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : BenefitModel.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ OfferContent[] newArray(int i) {
                return new OfferContent[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u0007\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\f\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\r"}, d2 = {"Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "PlaceComponentResult", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PaymentResultContent implements Parcelable {
        public static final Parcelable.Creator<PaymentResultContent> CREATOR = new Creator();

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
            p0.writeString(this.PlaceComponentResult);
            p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
            p0.writeString(this.MyBillsEntityDataFactory);
            p0.writeString(this.getAuthRequestContext);
        }

        public PaymentResultContent(String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.PlaceComponentResult = str2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
            this.MyBillsEntityDataFactory = str4;
            this.getAuthRequestContext = str5;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<PaymentResultContent> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PaymentResultContent createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new PaymentResultContent(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PaymentResultContent[] newArray(int i) {
                return new PaymentResultContent[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u0007\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0011\u0010\u000f\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0011\u0010\f\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\r"}, d2 = {"Lid/dana/expresspurchase/model/ExpressPurchaseModel$PreviousPurchasement;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class PreviousPurchasement implements Parcelable {
        public static final Parcelable.Creator<PreviousPurchasement> CREATOR = new Creator();

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.getAuthRequestContext);
            p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
            p0.writeString(this.MyBillsEntityDataFactory);
            p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
            p0.writeString(this.PlaceComponentResult);
        }

        public PreviousPurchasement(String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            this.getAuthRequestContext = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
            this.MyBillsEntityDataFactory = str3;
            this.BuiltInFictitiousFunctionClassFactory = str4;
            this.PlaceComponentResult = str5;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<PreviousPurchasement> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PreviousPurchasement createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new PreviousPurchasement(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PreviousPurchasement[] newArray(int i) {
                return new PreviousPurchasement[i];
            }
        }
    }
}
