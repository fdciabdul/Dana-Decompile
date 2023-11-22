package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import id.dana.R;
import id.dana.cashier.CardAssetUtils;
import id.dana.cashier.view.PaylaterInstallmentView;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.core.ui.util.NumberFormatterUtil;
import id.dana.data.config.model.PayLaterMethodConfig;
import id.dana.data.constant.DanaUrl;
import id.dana.data.util.BankLogoUrlUtil;
import id.dana.domain.investment.model.DanaPlusMethodConfig;
import id.dana.domain.payasset.model.PayMethod;
import id.dana.domain.paylater.model.PaylaterCicilMethodConfig;
import id.dana.model.PayMethodModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001d\b\u0016\u0018\u0000 ,2\u00020\u0001:\u000e-./0,123456789B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0005¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b!\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b\"\u0010\u0004R\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b#\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b$\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b%\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b)\u0010\u0007"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel;", "Landroid/os/Parcelable;", "", "PlaceComponentResult", "()Z", "", "describeContents", "()I", "getAuthRequestContext", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "scheduleImpl", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "initRecordTimeStamp", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda1", "", "NetworkUserEntityData$$ExternalSyntheticLambda2", "()Ljava/util/List;", "DatabaseTableConfigUtil", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "getErrorConfigVersion", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda7", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda8", "I", "newProxyInstance", "<init>", "(I)V", "Companion", "BalanceFamilyPayMethod", "BalancePayMethod", "CardPayMethod", "ChannelPayMethodModel", "DanaPlusPayMethod", "HelperPayMethod", "NewCardData", "OTCPayMethod", "PaylaterCicilPayMethod", "PaylaterPayMethod", "ShimmerAnimationPayMethod", "SmartPayActivation", "VirtualAccountPayMethod"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class CashierPayMethodModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public boolean getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory = true;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public boolean moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public boolean PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final int scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public boolean lookAheadTest;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<CashierPayMethodModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory */
    public String getMyBillsEntityDataFactory() {
        return "";
    }

    public String DatabaseTableConfigUtil() {
        return "";
    }

    /* renamed from: GetContactSyncConfig */
    public int getKClassImpl$Data$declaredNonStaticMembers$2() {
        return 0;
    }

    public String KClassImpl$Data$declaredNonStaticMembers$2() {
        return "";
    }

    public String MyBillsEntityDataFactory() {
        return "";
    }

    public String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return "";
    }

    public String NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return "";
    }

    public boolean PlaceComponentResult() {
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getAuthRequestContext() {
        return true;
    }

    public String initRecordTimeStamp() {
        return "";
    }

    public String lookAheadTest() {
        return "";
    }

    public String moveToNextValue() {
        return "";
    }

    public String scheduleImpl() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeInt(this.scheduleImpl);
    }

    public CashierPayMethodModel(int i) {
        this.scheduleImpl = i;
    }

    @JvmName(name = "newProxyInstance")
    /* renamed from: newProxyInstance  reason: from getter */
    public int getScheduleImpl() {
        return this.scheduleImpl;
    }

    @JvmName(name = "getErrorConfigVersion")
    /* renamed from: getErrorConfigVersion  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda8")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda3")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda6")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from getter */
    public final boolean getMoveToNextValue() {
        return this.moveToNextValue;
    }

    @JvmName(name = "PrepareContext")
    /* renamed from: PrepareContext  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda7")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda4")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from getter */
    public final boolean getLookAheadTest() {
        return this.lookAheadTest;
    }

    @JvmName(name = "isLayoutRequested")
    /* renamed from: isLayoutRequested  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    public List<String> NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return CollectionsKt.emptyList();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\u00020\u00048\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel$ChannelPayMethodModel;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Landroid/os/Parcel;", "p0", "", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/cashier/model/CashierPayChannelModel;", "getErrorConfigVersion", "Lid/dana/cashier/model/CashierPayChannelModel;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "()Lid/dana/cashier/model/CashierPayChannelModel;", "PlaceComponentResult", "GetContactSyncConfig", "I", "newProxyInstance", "()I", "BuiltInFictitiousFunctionClassFactory", "<init>", "(ILid/dana/cashier/model/CashierPayChannelModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static class ChannelPayMethodModel extends CashierPayMethodModel {
        public static final Parcelable.Creator<ChannelPayMethodModel> CREATOR = new Creator();

        /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
        public final int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        private final CashierPayChannelModel PlaceComponentResult;

        @Override // id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeInt(this.BuiltInFictitiousFunctionClassFactory);
            CashierPayChannelModel cashierPayChannelModel = this.PlaceComponentResult;
            if (cashierPayChannelModel == null) {
                p0.writeInt(0);
                return;
            }
            p0.writeInt(1);
            cashierPayChannelModel.writeToParcel(p0, p1);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        @JvmName(name = "newProxyInstance")
        /* renamed from: newProxyInstance  reason: from getter */
        public final int getScheduleImpl() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda5")
        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from getter */
        public CashierPayChannelModel getMyBillsEntityDataFactory() {
            return this.PlaceComponentResult;
        }

        public ChannelPayMethodModel(int i, CashierPayChannelModel cashierPayChannelModel) {
            super(i);
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.PlaceComponentResult = cashierPayChannelModel;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Creator implements Parcelable.Creator<ChannelPayMethodModel> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ChannelPayMethodModel createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new ChannelPayMethodModel(parcel.readInt(), parcel.readInt() == 0 ? null : CashierPayChannelModel.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ChannelPayMethodModel[] newArray(int i) {
                return new ChannelPayMethodModel[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0012\u001a\u00020#\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\nJ \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0004R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u0004\u0018\u00010 X\u0087\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010!R\u001a\u0010\f\u001a\u00020#8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel$BalancePayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel$ChannelPayMethodModel;", "", "PlaceComponentResult", "()Z", "", "describeContents", "()I", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "scheduleImpl", "lookAheadTest", "moveToNextValue", "initRecordTimeStamp", "GetContactSyncConfig", "DatabaseTableConfigUtil", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "FragmentBottomSheetPaymentSettingBinding", "KClassImpl$Data$declaredNonStaticMembers$2", "getSupportButtonTintMode", "NetworkUserEntityData$$ExternalSyntheticLambda2", "SubSequence", "getErrorConfigVersion", "Ljava/lang/Boolean;", "getAuthRequestContext", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "MyBillsEntityDataFactory", "Lid/dana/cashier/model/CashierPayChannelModel;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/cashier/model/CashierPayChannelModel;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "()Lid/dana/cashier/model/CashierPayChannelModel;", "p2", "p3", "<init>", "(Lid/dana/cashier/model/CashierPayChannelModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/Boolean;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static class BalancePayMethod extends ChannelPayMethodModel {
        public static final Parcelable.Creator<BalancePayMethod> CREATOR = new Creator();

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        private boolean KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        public final CashierPayChannelModel lookAheadTest;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
        private boolean BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public Boolean getAuthRequestContext;

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        public MoneyViewModel MyBillsEntityDataFactory;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public boolean PlaceComponentResult;

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String DatabaseTableConfigUtil() {
            return "DANA Balance";
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel, id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.lookAheadTest.writeToParcel(p0, p1);
            MoneyViewModel moneyViewModel = this.MyBillsEntityDataFactory;
            if (moneyViewModel == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                moneyViewModel.writeToParcel(p0, p1);
            }
            Boolean bool = this.getAuthRequestContext;
            if (bool == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                p0.writeInt(bool.booleanValue() ? 1 : 0);
            }
            p0.writeInt(this.BuiltInFictitiousFunctionClassFactory ? 1 : 0);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel
        @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda5")
        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from getter */
        public final CashierPayChannelModel getMyBillsEntityDataFactory() {
            return this.lookAheadTest;
        }

        @JvmName(name = "SubSequence")
        /* renamed from: SubSequence  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BalancePayMethod(CashierPayChannelModel cashierPayChannelModel, MoneyViewModel moneyViewModel, Boolean bool, boolean z) {
            super(0, cashierPayChannelModel);
            Intrinsics.checkNotNullParameter(cashierPayChannelModel, "");
            this.lookAheadTest = cashierPayChannelModel;
            this.MyBillsEntityDataFactory = moneyViewModel;
            this.getAuthRequestContext = bool;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        @JvmName(name = "FragmentBottomSheetPaymentSettingBinding")
        /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @JvmName(name = "getSupportButtonTintMode")
        /* renamed from: getSupportButtonTintMode  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Creator implements Parcelable.Creator<BalancePayMethod> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BalancePayMethod createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                CashierPayChannelModel createFromParcel = CashierPayChannelModel.CREATOR.createFromParcel(parcel);
                Boolean bool = null;
                MoneyViewModel createFromParcel2 = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                }
                return new BalancePayMethod(createFromParcel, createFromParcel2, bool, parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ BalancePayMethod[] newArray(int i) {
                return new BalancePayMethod[i];
            }
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final boolean PlaceComponentResult() {
            return Intrinsics.areEqual(this.lookAheadTest.getErrorConfigVersion, Boolean.TRUE);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        /* renamed from: BuiltInFictitiousFunctionClassFactory */
        public final String getMyBillsEntityDataFactory() {
            String str;
            String str2 = this.lookAheadTest.B;
            if (Intrinsics.areEqual(str2, "BALANCE") ? true : Intrinsics.areEqual(str2, PayMethod.DANA_PLUS)) {
                MoneyViewModel moneyViewModel = this.lookAheadTest.PlaceComponentResult;
                if (moneyViewModel != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                    String KClassImpl$Data$declaredNonStaticMembers$2 = NumberFormatterUtil.KClassImpl$Data$declaredNonStaticMembers$2(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), moneyViewModel.MyBillsEntityDataFactory());
                    if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                        KClassImpl$Data$declaredNonStaticMembers$2 = "";
                    }
                    sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
                    str = sb.toString();
                } else {
                    str = null;
                }
            } else {
                str = "";
            }
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String scheduleImpl() {
            String str = this.lookAheadTest.DatabaseTableConfigUtil;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String lookAheadTest() {
            String str = this.lookAheadTest.PrepareContext;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String moveToNextValue() {
            String str = this.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda7;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String initRecordTimeStamp() {
            String str = this.lookAheadTest.B;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        /* renamed from: GetContactSyncConfig */
        public final int getKClassImpl$Data$declaredNonStaticMembers$2() {
            if (this.lookAheadTest.PlaceComponentResult()) {
                return R.drawable.ic_landscape_small_dana_balance;
            }
            return 0;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0014\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0007J\u000f\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\r\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0004J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u001cX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0014\u0010\b\u001a\u0004\u0018\u00010\u001fX\u0086\u0002¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010&\u001a\u0004\u0018\u00010\"8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010%"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel$ChannelPayMethodModel;", "", "PlaceComponentResult", "()Z", "", "describeContents", "()I", "getAuthRequestContext", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "scheduleImpl", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "initRecordTimeStamp", "GetContactSyncConfig", "DatabaseTableConfigUtil", "FragmentBottomSheetPaymentSettingBinding", "p0", "(Ljava/lang/String;)Z", "whenAvailable", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/cashier/model/AssetCardModel;", "Lid/dana/cashier/model/AssetCardModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/model/CashierPayMethodModel$NewCardData;", "getErrorConfigVersion", "Lid/dana/cashier/model/CashierPayMethodModel$NewCardData;", "Lid/dana/cashier/model/CashierPayChannelModel;", "Lid/dana/cashier/model/CashierPayChannelModel;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "()Lid/dana/cashier/model/CashierPayChannelModel;", "MyBillsEntityDataFactory", "p2", "<init>", "(Lid/dana/cashier/model/AssetCardModel;Lid/dana/cashier/model/CashierPayChannelModel;Lid/dana/cashier/model/CashierPayMethodModel$NewCardData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class CardPayMethod extends ChannelPayMethodModel {
        public static final Parcelable.Creator<CardPayMethod> CREATOR = new Creator();

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public NewCardData getAuthRequestContext;

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        private final CashierPayChannelModel MyBillsEntityDataFactory;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public final AssetCardModel KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel, id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2.writeToParcel(p0, p1);
            CashierPayChannelModel cashierPayChannelModel = this.MyBillsEntityDataFactory;
            if (cashierPayChannelModel == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                cashierPayChannelModel.writeToParcel(p0, p1);
            }
            NewCardData newCardData = this.getAuthRequestContext;
            if (newCardData == null) {
                p0.writeInt(0);
                return;
            }
            p0.writeInt(1);
            newCardData.writeToParcel(p0, p1);
        }

        public /* synthetic */ CardPayMethod(AssetCardModel assetCardModel, CashierPayChannelModel cashierPayChannelModel, NewCardData newCardData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(assetCardModel, (i & 2) != 0 ? null : cashierPayChannelModel, (i & 4) != 0 ? null : newCardData);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel
        @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda5")
        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from getter */
        public final CashierPayChannelModel getMyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CardPayMethod(AssetCardModel assetCardModel, CashierPayChannelModel cashierPayChannelModel, NewCardData newCardData) {
            super(0, cashierPayChannelModel);
            Intrinsics.checkNotNullParameter(assetCardModel, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = assetCardModel;
            this.MyBillsEntityDataFactory = cashierPayChannelModel;
            this.getAuthRequestContext = newCardData;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        /* renamed from: GetContactSyncConfig */
        public final int getKClassImpl$Data$declaredNonStaticMembers$2() {
            CardAssetUtils cardAssetUtils = CardAssetUtils.INSTANCE;
            Integer MyBillsEntityDataFactory = CardAssetUtils.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7);
            if (MyBillsEntityDataFactory != null) {
                return MyBillsEntityDataFactory.intValue();
            }
            return 0;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        /* renamed from: BuiltInFictitiousFunctionClassFactory */
        public final String getMyBillsEntityDataFactory() {
            String obj;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2() || this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
                StringBuilder sb = new StringBuilder();
                String str = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda3;
                if (str == null) {
                    str = "";
                }
                sb.append(str);
                sb.append(" (Debit ");
                String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getCallingPid;
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(str2);
                sb.append(')');
                obj = sb.toString();
            } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult()) {
                StringBuilder sb2 = new StringBuilder();
                String str3 = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda3;
                if (str3 == null) {
                    str3 = "";
                }
                sb2.append(str3);
                sb2.append(" (Credit ");
                String str4 = this.KClassImpl$Data$declaredNonStaticMembers$2.getCallingPid;
                if (str4 == null) {
                    str4 = "";
                }
                sb2.append(str4);
                sb2.append(')');
                obj = sb2.toString();
            } else {
                obj = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda3;
            }
            return obj == null ? "" : obj;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        
            if (r1 == null) goto L16;
         */
        @Override // id.dana.cashier.model.CashierPayMethodModel
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String NetworkUserEntityData$$ExternalSyntheticLambda0() {
            /*
                r4 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                id.dana.cashier.model.AssetCardModel r1 = r4.KClassImpl$Data$declaredNonStaticMembers$2
                java.lang.String r1 = r1.NetworkUserEntityData$$ExternalSyntheticLambda3
                java.lang.String r2 = ""
                if (r1 != 0) goto Le
                r1 = r2
            Le:
                r0.append(r1)
                r1 = 32
                r0.append(r1)
                id.dana.cashier.model.AssetCardModel r1 = r4.KClassImpl$Data$declaredNonStaticMembers$2
                java.lang.String r1 = r1.getCallingPid
                if (r1 != 0) goto L2e
                id.dana.cashier.model.CashierPayMethodModel$NewCardData r1 = r4.getAuthRequestContext
                if (r1 == 0) goto L2a
                java.lang.String r1 = r1.PlaceComponentResult
                if (r1 == 0) goto L2a
                r3 = 4
                java.lang.String r1 = kotlin.text.StringsKt.takeLast(r1, r3)
                goto L2b
            L2a:
                r1 = 0
            L2b:
                if (r1 != 0) goto L2e
                goto L2f
            L2e:
                r2 = r1
            L2f:
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.model.CashierPayMethodModel.CardPayMethod.NetworkUserEntityData$$ExternalSyntheticLambda0():java.lang.String");
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String initRecordTimeStamp() {
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2.getSupportButtonTintMode;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final boolean PlaceComponentResult() {
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, Boolean.TRUE);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final boolean getAuthRequestContext() {
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2, Boolean.TRUE);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String DatabaseTableConfigUtil() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2() ? PayMethodModel.CashierSectionTitle.DEBIT_CARD : this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult() ? PayMethodModel.CashierSectionTitle.CREDIT_CARD : PayMethodModel.CashierSectionTitle.BANK_CARD;
        }

        public final boolean FragmentBottomSheetPaymentSettingBinding() {
            List<String> list = this.KClassImpl$Data$declaredNonStaticMembers$2.readMicros;
            return !(list == null || list.isEmpty()) && this.KClassImpl$Data$declaredNonStaticMembers$2.readMicros.contains("cvv2");
        }

        public final boolean whenAvailable() {
            AssetCardModel assetCardModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Boolean bool = assetCardModel.PlaceComponentResult;
            Boolean bool2 = Boolean.TRUE;
            return Intrinsics.areEqual(bool, bool2) && Intrinsics.areEqual(assetCardModel.NetworkUserEntityData$$ExternalSyntheticLambda2, bool2) && Intrinsics.areEqual(assetCardModel.FragmentBottomSheetPaymentSettingBinding, bool2);
        }

        public final boolean BuiltInFictitiousFunctionClassFactory(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return Intrinsics.areEqual(p0, this.KClassImpl$Data$declaredNonStaticMembers$2.whenAvailable);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String lookAheadTest() {
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String moveToNextValue() {
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2.whenAvailable;
            return str == null ? "" : str;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Creator implements Parcelable.Creator<CardPayMethod> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CardPayMethod createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new CardPayMethod(AssetCardModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : CashierPayChannelModel.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? NewCardData.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ CardPayMethod[] newArray(int i) {
                return new CardPayMethod[i];
            }
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String scheduleImpl() {
            CashierPayChannelModel cashierPayChannelModel = this.MyBillsEntityDataFactory;
            String str = cashierPayChannelModel != null ? cashierPayChannelModel.DatabaseTableConfigUtil : null;
            if (str == null || str.length() == 0) {
                String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp;
                if (str2 != null) {
                    return str2;
                }
            } else {
                CashierPayChannelModel cashierPayChannelModel2 = this.MyBillsEntityDataFactory;
                String str3 = cashierPayChannelModel2 != null ? cashierPayChannelModel2.DatabaseTableConfigUtil : null;
                if (str3 != null) {
                    return str3;
                }
            }
            return "";
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\nJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\u001b8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel$PaylaterPayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel$ChannelPayMethodModel;", "", "PlaceComponentResult", "()Z", "", "describeContents", "()I", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "scheduleImpl", "lookAheadTest", "moveToNextValue", "initRecordTimeStamp", "GetContactSyncConfig", "DatabaseTableConfigUtil", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getErrorConfigVersion", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/cashier/model/CashierPayChannelModel;", "Lid/dana/cashier/model/CashierPayChannelModel;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "()Lid/dana/cashier/model/CashierPayChannelModel;", "<init>", "(Lid/dana/cashier/model/CashierPayChannelModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class PaylaterPayMethod extends ChannelPayMethodModel {
        public static final Parcelable.Creator<PaylaterPayMethod> CREATOR = new Creator();

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public final CashierPayChannelModel BuiltInFictitiousFunctionClassFactory;

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String DatabaseTableConfigUtil() {
            return PayMethodModel.CashierSectionTitle.ONLINE_CREDIT;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        /* renamed from: GetContactSyncConfig */
        public final int getKClassImpl$Data$declaredNonStaticMembers$2() {
            return R.drawable.ic_landscape_small_dana_paylater_instant;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel, id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.BuiltInFictitiousFunctionClassFactory.writeToParcel(p0, p1);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel
        @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda5")
        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from getter */
        public final CashierPayChannelModel getMyBillsEntityDataFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaylaterPayMethod(CashierPayChannelModel cashierPayChannelModel) {
            super(5, cashierPayChannelModel);
            Intrinsics.checkNotNullParameter(cashierPayChannelModel, "");
            this.BuiltInFictitiousFunctionClassFactory = cashierPayChannelModel;
            PayLaterMethodConfig payLaterMethodConfig = cashierPayChannelModel.readMicros;
            String additionalInfoInstallmentSelection = payLaterMethodConfig != null ? payLaterMethodConfig.getAdditionalInfoInstallmentSelection() : null;
            this.MyBillsEntityDataFactory = additionalInfoInstallmentSelection != null ? additionalInfoInstallmentSelection : "";
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Creator implements Parcelable.Creator<PaylaterPayMethod> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PaylaterPayMethod createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new PaylaterPayMethod(CashierPayChannelModel.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PaylaterPayMethod[] newArray(int i) {
                return new PaylaterPayMethod[i];
            }
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final boolean PlaceComponentResult() {
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion, Boolean.TRUE);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String KClassImpl$Data$declaredNonStaticMembers$2() {
            PayLaterMethodConfig payLaterMethodConfig = this.BuiltInFictitiousFunctionClassFactory.readMicros;
            String additionalInfoPayConfirmation = payLaterMethodConfig != null ? payLaterMethodConfig.getAdditionalInfoPayConfirmation() : null;
            return additionalInfoPayConfirmation == null ? "" : additionalInfoPayConfirmation;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        /* renamed from: BuiltInFictitiousFunctionClassFactory */
        public final String getMyBillsEntityDataFactory() {
            String str;
            MoneyViewModel moneyViewModel = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
            if (moneyViewModel != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                String KClassImpl$Data$declaredNonStaticMembers$2 = NumberFormatterUtil.KClassImpl$Data$declaredNonStaticMembers$2(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), moneyViewModel.MyBillsEntityDataFactory());
                if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    KClassImpl$Data$declaredNonStaticMembers$2 = "";
                }
                sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
                str = sb.toString();
            } else {
                str = null;
            }
            return str == null ? "" : str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
        
            if (r0 == null) goto L17;
         */
        @Override // id.dana.cashier.model.CashierPayMethodModel
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String scheduleImpl() {
            /*
                r3 = this;
                id.dana.cashier.model.CashierPayChannelModel r0 = r3.BuiltInFictitiousFunctionClassFactory
                java.lang.String r0 = r0.DatabaseTableConfigUtil
                java.lang.String r1 = ""
                if (r0 != 0) goto L9
                r0 = r1
            L9:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                int r2 = r0.length()
                if (r2 != 0) goto L13
                r2 = 1
                goto L14
            L13:
                r2 = 0
            L14:
                if (r2 == 0) goto L25
                id.dana.cashier.model.CashierPayChannelModel r0 = r3.BuiltInFictitiousFunctionClassFactory
                id.dana.data.config.model.PayLaterMethodConfig r0 = r0.readMicros
                if (r0 == 0) goto L21
                java.lang.String r0 = r0.getPaymethodDescription()
                goto L22
            L21:
                r0 = 0
            L22:
                if (r0 != 0) goto L25
                goto L26
            L25:
                r1 = r0
            L26:
                java.lang.String r1 = (java.lang.String) r1
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.model.CashierPayMethodModel.PaylaterPayMethod.scheduleImpl():java.lang.String");
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String lookAheadTest() {
            String str = this.BuiltInFictitiousFunctionClassFactory.PrepareContext;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String moveToNextValue() {
            String str = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String initRecordTimeStamp() {
            String str = this.BuiltInFictitiousFunctionClassFactory.B;
            return str == null ? "" : str;
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u000200¢\u0006\u0004\b8\u00109J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0010J\r\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0016\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0010J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\fJ\r\u0010\u0018\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0010J\r\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u0010J\u000f\u0010\u001a\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u0010J\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000e¢\u0006\u0004\b\b\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u0004J \u0010\"\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010(R\u0016\u0010\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010(R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b,\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b-\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010\u0004R\u001a\u0010%\u001a\u0002008\u0017X\u0097\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002050\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b6\u00107"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel$PaylaterCicilPayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel$ChannelPayMethodModel;", "", "PlaceComponentResult", "()Z", "", "Lid/dana/cashier/model/LoanCreditChannelInfoModel;", "p0", "getAuthRequestContext", "(Ljava/util/List;)Z", "", DiskFormatter.B, "()I", "describeContents", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "scheduleImpl", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "whenAvailable", "moveToNextValue", "initRecordTimeStamp", "GetContactSyncConfig", "getCallingPid", "getSupportButtonTintMode", "DatabaseTableConfigUtil", "readMicros", "()Ljava/util/List;", "(Ljava/lang/String;)Z", "SubSequence", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "getErrorConfigVersion", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "MyBillsEntityDataFactory", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Z", "FragmentBottomSheetPaymentSettingBinding", "BottomSheetCardBindingView$watcherCardNumberView$1", "NetworkUserEntityData$$ExternalSyntheticLambda1", "VerifyPinStateManager$executeRiskChallenge$2$1", "Lid/dana/cashier/model/CashierPayChannelModel;", "PrepareContext", "Lid/dana/cashier/model/CashierPayChannelModel;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "()Lid/dana/cashier/model/CashierPayChannelModel;", "Lid/dana/cashier/model/RepaymentPlanModel;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Ljava/util/List;", "<init>", "(Lid/dana/cashier/model/CashierPayChannelModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class PaylaterCicilPayMethod extends ChannelPayMethodModel {
        public static final Parcelable.Creator<PaylaterCicilPayMethod> CREATOR = new Creator();

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        public boolean BuiltInFictitiousFunctionClassFactory;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
        public String PlaceComponentResult;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
        public List<RepaymentPlanModel> moveToNextValue;

        /* renamed from: PrepareContext  reason: from kotlin metadata */
        public final CashierPayChannelModel getErrorConfigVersion;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        public boolean getAuthRequestContext;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public String MyBillsEntityDataFactory;

        @Override // id.dana.cashier.model.CashierPayMethodModel
        /* renamed from: GetContactSyncConfig */
        public final int getKClassImpl$Data$declaredNonStaticMembers$2() {
            return R.drawable.ic_landscape_small_dana_cicil;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel, id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.getErrorConfigVersion.writeToParcel(p0, p1);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel
        @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda5")
        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from getter */
        public final CashierPayChannelModel getMyBillsEntityDataFactory() {
            return this.getErrorConfigVersion;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaylaterCicilPayMethod(CashierPayChannelModel cashierPayChannelModel) {
            super(6, cashierPayChannelModel);
            Intrinsics.checkNotNullParameter(cashierPayChannelModel, "");
            this.getErrorConfigVersion = cashierPayChannelModel;
            this.getAuthRequestContext = true;
            this.moveToNextValue = CollectionsKt.emptyList();
            this.MyBillsEntityDataFactory = "";
            this.PlaceComponentResult = "";
        }

        @JvmName(name = "BottomSheetCardBindingView$watcherCardNumberView$1")
        /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }

        @JvmName(name = "FragmentBottomSheetPaymentSettingBinding")
        /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @JvmName(name = "VerifyPinStateManager$executeRiskChallenge$2$1")
        /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from getter */
        public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda0() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        /* renamed from: BuiltInFictitiousFunctionClassFactory */
        public final String getMyBillsEntityDataFactory() {
            List<RepaymentInfoModel> list;
            RepaymentInfoModel repaymentInfoModel;
            MoneyViewModel moneyViewModel;
            String str = this.MyBillsEntityDataFactory;
            if (str.length() == 0) {
                String str2 = null;
                if ((this.moveToNextValue.isEmpty() ^ true ? this : null) != null) {
                    StringBuilder sb = new StringBuilder();
                    RepaymentPlanModel repaymentPlanModel = (RepaymentPlanModel) CollectionsKt.firstOrNull((List) this.moveToNextValue);
                    if (repaymentPlanModel != null && (list = repaymentPlanModel.MyBillsEntityDataFactory) != null && (repaymentInfoModel = (RepaymentInfoModel) CollectionsKt.firstOrNull((List) list)) != null && (moneyViewModel = repaymentInfoModel.getAuthRequestContext) != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                        String KClassImpl$Data$declaredNonStaticMembers$2 = NumberFormatterUtil.KClassImpl$Data$declaredNonStaticMembers$2(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), moneyViewModel.MyBillsEntityDataFactory());
                        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                            KClassImpl$Data$declaredNonStaticMembers$2 = "";
                        }
                        sb2.append(KClassImpl$Data$declaredNonStaticMembers$2);
                        str2 = sb2.toString();
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    sb.append(str2);
                    sb.append(" (x");
                    sb.append(B());
                    sb.append(')');
                    str2 = sb.toString();
                }
                str = str2 == null ? "" : str2;
            }
            return str;
        }

        private final int B() {
            Integer num;
            RepaymentPlanModel repaymentPlanModel = (RepaymentPlanModel) CollectionsKt.firstOrNull((List) this.moveToNextValue);
            if (repaymentPlanModel == null || (num = repaymentPlanModel.getAuthRequestContext) == null) {
                return 0;
            }
            return num.intValue();
        }

        private static boolean getAuthRequestContext(List<LoanCreditChannelInfoModel> p0) {
            LoanCreditChannelInfoModel loanCreditChannelInfoModel;
            Boolean bool;
            if (!(p0 != null && (p0.isEmpty() ^ true)) || (loanCreditChannelInfoModel = (LoanCreditChannelInfoModel) CollectionsKt.firstOrNull((List) p0)) == null || (bool = loanCreditChannelInfoModel.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                return false;
            }
            return bool.booleanValue();
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Creator implements Parcelable.Creator<PaylaterCicilPayMethod> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PaylaterCicilPayMethod createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new PaylaterCicilPayMethod(CashierPayChannelModel.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PaylaterCicilPayMethod[] newArray(int i) {
                return new PaylaterCicilPayMethod[i];
            }
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final boolean PlaceComponentResult() {
            return Intrinsics.areEqual(this.getErrorConfigVersion.getErrorConfigVersion, Boolean.TRUE);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String scheduleImpl() {
            PaylaterCicilMethodConfig paylaterCicilMethodConfig;
            String paymethodDescription;
            String str = this.getErrorConfigVersion.DatabaseTableConfigUtil;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            if (str2.length() == 0) {
                String str3 = this.PlaceComponentResult;
                if (str3.length() == 0) {
                    String str4 = null;
                    if (((B() == 0 || getMyBillsEntityDataFactory()) ? false : true ? this : null) != null && (paylaterCicilMethodConfig = this.getErrorConfigVersion.getSupportButtonTintMode) != null && (paymethodDescription = paylaterCicilMethodConfig.getPaymethodDescription()) != null) {
                        str4 = StringsKt.replace$default(paymethodDescription, PaylaterInstallmentView.AMOUNT_AND_INTEREST, String.valueOf(B()), false, 4, (Object) null);
                    }
                    str3 = str4 != null ? str4 : "";
                }
                str2 = str3;
            }
            return str2;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String lookAheadTest() {
            String str = this.getErrorConfigVersion.PrepareContext;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
            PaylaterCicilMethodConfig paylaterCicilMethodConfig = this.getErrorConfigVersion.getSupportButtonTintMode;
            String paymethodName = paylaterCicilMethodConfig != null ? paylaterCicilMethodConfig.getPaymethodName() : null;
            if (paymethodName == null) {
                paymethodName = "";
            }
            String str = paymethodName;
            if (str.length() == 0) {
                str = PayMethodModel.CashierSectionTitle.DANA_CICIL;
            }
            return str;
        }

        public final String whenAvailable() {
            PaylaterCicilMethodConfig paylaterCicilMethodConfig = this.getErrorConfigVersion.getSupportButtonTintMode;
            String onBoardingImageUrl = paylaterCicilMethodConfig != null ? paylaterCicilMethodConfig.getOnBoardingImageUrl() : null;
            return onBoardingImageUrl == null ? "" : onBoardingImageUrl;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String moveToNextValue() {
            String str = this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda7;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String initRecordTimeStamp() {
            String str = this.getErrorConfigVersion.B;
            return str == null ? "" : str;
        }

        public final String getCallingPid() {
            PaylaterCicilMethodConfig paylaterCicilMethodConfig = this.getErrorConfigVersion.getSupportButtonTintMode;
            String promoRibbonSelectedDesc = paylaterCicilMethodConfig != null ? paylaterCicilMethodConfig.getPromoRibbonSelectedDesc() : null;
            return promoRibbonSelectedDesc == null ? "" : promoRibbonSelectedDesc;
        }

        public final String getSupportButtonTintMode() {
            PaylaterCicilMethodConfig paylaterCicilMethodConfig = this.getErrorConfigVersion.getSupportButtonTintMode;
            String promoRibbonDesc = paylaterCicilMethodConfig != null ? paylaterCicilMethodConfig.getPromoRibbonDesc() : null;
            return promoRibbonDesc == null ? "" : promoRibbonDesc;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String DatabaseTableConfigUtil() {
            PaylaterCicilMethodConfig paylaterCicilMethodConfig = this.getErrorConfigVersion.getSupportButtonTintMode;
            String paymethodName = paylaterCicilMethodConfig != null ? paylaterCicilMethodConfig.getPaymethodName() : null;
            if (paymethodName == null) {
                paymethodName = "";
            }
            String str = paymethodName;
            if (str.length() == 0) {
                str = PayMethodModel.CashierSectionTitle.DANA_CICIL;
            }
            return str;
        }

        public final List<String> readMicros() {
            PaylaterCicilMethodConfig paylaterCicilMethodConfig = this.getErrorConfigVersion.getSupportButtonTintMode;
            List<String> tncSpaceCode = paylaterCicilMethodConfig != null ? paylaterCicilMethodConfig.getTncSpaceCode() : null;
            return tncSpaceCode == null ? CollectionsKt.emptyList() : tncSpaceCode;
        }

        public final boolean getAuthRequestContext(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            String str = this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda7;
            return Intrinsics.areEqual(p0, str != null ? str : "");
        }

        public final boolean SubSequence() {
            return getAuthRequestContext(this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda4);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\nJ \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u00168\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel$VirtualAccountPayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel$ChannelPayMethodModel;", "", "describeContents", "()I", "", "getAuthRequestContext", "()Z", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "lookAheadTest", "moveToNextValue", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "Lid/dana/cashier/model/CashierPayChannelModel;", "getErrorConfigVersion", "Lid/dana/cashier/model/CashierPayChannelModel;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "()Lid/dana/cashier/model/CashierPayChannelModel;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/cashier/model/CashierPayChannelModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class VirtualAccountPayMethod extends ChannelPayMethodModel {
        public static final Parcelable.Creator<VirtualAccountPayMethod> CREATOR = new Creator();

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public final CashierPayChannelModel MyBillsEntityDataFactory;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        @Override // id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel, id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.MyBillsEntityDataFactory.writeToParcel(p0, p1);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel
        @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda5")
        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from getter */
        public final CashierPayChannelModel getMyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VirtualAccountPayMethod(CashierPayChannelModel cashierPayChannelModel) {
            super(3, cashierPayChannelModel);
            Intrinsics.checkNotNullParameter(cashierPayChannelModel, "");
            this.MyBillsEntityDataFactory = cashierPayChannelModel;
            String str = cashierPayChannelModel.SubSequence;
            this.getAuthRequestContext = str != null ? str : "";
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Creator implements Parcelable.Creator<VirtualAccountPayMethod> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ VirtualAccountPayMethod createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new VirtualAccountPayMethod(CashierPayChannelModel.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ VirtualAccountPayMethod[] newArray(int i) {
                return new VirtualAccountPayMethod[i];
            }
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final boolean getAuthRequestContext() {
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1, Boolean.TRUE);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        /* renamed from: BuiltInFictitiousFunctionClassFactory */
        public final String getMyBillsEntityDataFactory() {
            String str = this.MyBillsEntityDataFactory.isLayoutRequested;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String lookAheadTest() {
            String str = this.MyBillsEntityDataFactory.PrepareContext;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String moveToNextValue() {
            String str = this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String initRecordTimeStamp() {
            String str = this.MyBillsEntityDataFactory.B;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String NetworkUserEntityData$$ExternalSyntheticLambda1() {
            return BankLogoUrlUtil.getBankLogoUrl(this.MyBillsEntityDataFactory.PrepareContext);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00168\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel$OTCPayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel$ChannelPayMethodModel;", "", "describeContents", "()I", "", "getAuthRequestContext", "()Z", "", "lookAheadTest", "()Ljava/lang/String;", "moveToNextValue", "initRecordTimeStamp", "", "NetworkUserEntityData$$ExternalSyntheticLambda2", "()Ljava/util/List;", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/cashier/model/CashierPayChannelModel;", "Lid/dana/cashier/model/CashierPayChannelModel;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "()Lid/dana/cashier/model/CashierPayChannelModel;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/cashier/model/CashierPayChannelModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OTCPayMethod extends ChannelPayMethodModel {
        public static final Parcelable.Creator<OTCPayMethod> CREATOR = new Creator();

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public final CashierPayChannelModel BuiltInFictitiousFunctionClassFactory;

        @Override // id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel, id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.BuiltInFictitiousFunctionClassFactory.writeToParcel(p0, p1);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel
        @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda5")
        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from getter */
        public final CashierPayChannelModel getMyBillsEntityDataFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OTCPayMethod(CashierPayChannelModel cashierPayChannelModel) {
            super(4, cashierPayChannelModel);
            Intrinsics.checkNotNullParameter(cashierPayChannelModel, "");
            this.BuiltInFictitiousFunctionClassFactory = cashierPayChannelModel;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Creator implements Parcelable.Creator<OTCPayMethod> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ OTCPayMethod createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new OTCPayMethod(CashierPayChannelModel.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ OTCPayMethod[] newArray(int i) {
                return new OTCPayMethod[i];
            }
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final boolean getAuthRequestContext() {
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1, Boolean.TRUE);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String lookAheadTest() {
            String str = this.BuiltInFictitiousFunctionClassFactory.PrepareContext;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String moveToNextValue() {
            String str = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String initRecordTimeStamp() {
            String str = this.BuiltInFictitiousFunctionClassFactory.B;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final List<String> NetworkUserEntityData$$ExternalSyntheticLambda2() {
            ArrayList arrayList;
            List<String> list = this.BuiltInFictitiousFunctionClassFactory.F;
            if (list != null) {
                List<String> list2 = list;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (String str : list2) {
                    Locale locale = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale, "");
                    String lowerCase = str.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                    String format = String.format(DanaUrl.OTC_LOGO_URL, Arrays.copyOf(new Object[]{lowerCase}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "");
                    arrayList2.add(format);
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            return arrayList == null ? CollectionsKt.emptyList() : arrayList;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel$SmartPayActivation;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Landroid/os/Parcel;", "p0", "", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "getErrorConfigVersion", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class SmartPayActivation extends CashierPayMethodModel {
        public static final Parcelable.Creator<SmartPayActivation> CREATOR = new Creator();

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        @Override // id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SmartPayActivation(String str) {
            super(2);
            Intrinsics.checkNotNullParameter(str, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Creator implements Parcelable.Creator<SmartPayActivation> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SmartPayActivation createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new SmartPayActivation(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SmartPayActivation[] newArray(int i) {
                return new SmartPayActivation[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u00058\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0007"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel$HelperPayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel;", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "", "GetContactSyncConfig", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getErrorConfigVersion", "Ljava/lang/String;", "MyBillsEntityDataFactory", "lookAheadTest", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "newProxyInstance", "getAuthRequestContext", "p2", "<init>", "(IILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class HelperPayMethod extends CashierPayMethodModel {
        public static final Parcelable.Creator<HelperPayMethod> CREATOR = new Creator();

        /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
        private final int getAuthRequestContext;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeInt(this.getAuthRequestContext);
            p0.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2);
            p0.writeString(this.MyBillsEntityDataFactory);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        @JvmName(name = "newProxyInstance")
        /* renamed from: newProxyInstance  reason: from getter */
        public final int getScheduleImpl() {
            return this.getAuthRequestContext;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HelperPayMethod(int i, int i2, String str) {
            super(i);
            Intrinsics.checkNotNullParameter(str, "");
            this.getAuthRequestContext = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            this.MyBillsEntityDataFactory = str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        /* renamed from: GetContactSyncConfig  reason: from getter */
        public final int getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final String getMyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Creator implements Parcelable.Creator<HelperPayMethod> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ HelperPayMethod createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new HelperPayMethod(parcel.readInt(), parcel.readInt(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ HelperPayMethod[] newArray(int i) {
                return new HelperPayMethod[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0013\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\nJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u0018X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u001c8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel$BalanceFamilyPayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel$ChannelPayMethodModel;", "", "PlaceComponentResult", "()Z", "", "describeContents", "()I", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "scheduleImpl", "lookAheadTest", "moveToNextValue", "initRecordTimeStamp", "GetContactSyncConfig", "DatabaseTableConfigUtil", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "getErrorConfigVersion", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "getAuthRequestContext", "Lid/dana/cashier/model/CashierPayChannelModel;", "Lid/dana/cashier/model/CashierPayChannelModel;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "()Lid/dana/cashier/model/CashierPayChannelModel;", "<init>", "(Lid/dana/cashier/model/CashierPayChannelModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class BalanceFamilyPayMethod extends ChannelPayMethodModel {
        public static final Parcelable.Creator<BalanceFamilyPayMethod> CREATOR = new Creator();

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public MoneyViewModel getAuthRequestContext;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public final CashierPayChannelModel MyBillsEntityDataFactory;

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String DatabaseTableConfigUtil() {
            return "Family Account";
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel, id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.MyBillsEntityDataFactory.writeToParcel(p0, p1);
            MoneyViewModel moneyViewModel = this.getAuthRequestContext;
            if (moneyViewModel == null) {
                p0.writeInt(0);
                return;
            }
            p0.writeInt(1);
            moneyViewModel.writeToParcel(p0, p1);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel
        @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda5")
        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from getter */
        public final CashierPayChannelModel getMyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BalanceFamilyPayMethod(CashierPayChannelModel cashierPayChannelModel, MoneyViewModel moneyViewModel) {
            super(0, cashierPayChannelModel);
            Intrinsics.checkNotNullParameter(cashierPayChannelModel, "");
            this.MyBillsEntityDataFactory = cashierPayChannelModel;
            this.getAuthRequestContext = moneyViewModel;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Creator implements Parcelable.Creator<BalanceFamilyPayMethod> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BalanceFamilyPayMethod createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new BalanceFamilyPayMethod(CashierPayChannelModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ BalanceFamilyPayMethod[] newArray(int i) {
                return new BalanceFamilyPayMethod[i];
            }
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final boolean PlaceComponentResult() {
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory.getErrorConfigVersion, Boolean.TRUE);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        /* renamed from: BuiltInFictitiousFunctionClassFactory */
        public final String getMyBillsEntityDataFactory() {
            String str;
            MoneyViewModel moneyViewModel = this.MyBillsEntityDataFactory.PlaceComponentResult;
            if (moneyViewModel != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                String KClassImpl$Data$declaredNonStaticMembers$2 = NumberFormatterUtil.KClassImpl$Data$declaredNonStaticMembers$2(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), moneyViewModel.MyBillsEntityDataFactory());
                if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    KClassImpl$Data$declaredNonStaticMembers$2 = "";
                }
                sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
                str = sb.toString();
            } else {
                str = null;
            }
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String MyBillsEntityDataFactory() {
            String str = this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String scheduleImpl() {
            String str = this.MyBillsEntityDataFactory.DatabaseTableConfigUtil;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String lookAheadTest() {
            String str = this.MyBillsEntityDataFactory.PrepareContext;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String moveToNextValue() {
            String str = this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (str == null) {
                String str2 = this.MyBillsEntityDataFactory.BottomSheetCardBindingView$watcherCardNumberView$1;
                return str2 == null ? "" : str2;
            }
            return str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String initRecordTimeStamp() {
            String str = this.MyBillsEntityDataFactory.B;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        /* renamed from: GetContactSyncConfig */
        public final int getKClassImpl$Data$declaredNonStaticMembers$2() {
            if (this.MyBillsEntityDataFactory.getAuthRequestContext()) {
                return R.drawable.ic_family_account_pay_chip;
            }
            return 0;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u001a\u0010\u0013\u001a\u00020\u00178\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\f\u0010\u0019"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel$NewCardData;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "scheduleImpl", "getErrorConfigVersion", "lookAheadTest", "", "Z", "()Z", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class NewCardData implements Parcelable {
        public static final Parcelable.Creator<NewCardData> CREATOR = new Creator();

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public String getAuthRequestContext;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public String BuiltInFictitiousFunctionClassFactory;
        public String NetworkUserEntityData$$ExternalSyntheticLambda0;
        public String PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public String MyBillsEntityDataFactory;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public String lookAheadTest;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public String scheduleImpl;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public boolean moveToNextValue;

        public NewCardData() {
            this(null, null, null, null, null, null, false, null, null, 511, null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.PlaceComponentResult);
            p0.writeString(this.getAuthRequestContext);
            p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
            p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            p0.writeString(this.scheduleImpl);
            p0.writeString(this.lookAheadTest);
            p0.writeInt(this.moveToNextValue ? 1 : 0);
            p0.writeString(this.MyBillsEntityDataFactory);
            p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        }

        public NewCardData(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8) {
            this.PlaceComponentResult = str;
            this.getAuthRequestContext = str2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
            this.scheduleImpl = str5;
            this.lookAheadTest = str6;
            this.moveToNextValue = z;
            this.MyBillsEntityDataFactory = str7;
            this.BuiltInFictitiousFunctionClassFactory = str8;
        }

        public /* synthetic */ NewCardData(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? false : z, (i & 128) != 0 ? null : str7, (i & 256) == 0 ? str8 : null);
        }

        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext  reason: from getter */
        public final boolean getMoveToNextValue() {
            return this.moveToNextValue;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Creator implements Parcelable.Creator<NewCardData> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ NewCardData createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new NewCardData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ NewCardData[] newArray(int i) {
                return new NewCardData[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\r\u001a\u00020\u00048\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel$ShimmerAnimationPayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Landroid/os/Parcel;", "p0", "", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getErrorConfigVersion", "I", "newProxyInstance", "()I", "BuiltInFictitiousFunctionClassFactory", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ShimmerAnimationPayMethod extends CashierPayMethodModel {
        public static final Parcelable.Creator<ShimmerAnimationPayMethod> CREATOR = new Creator();

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        private final int BuiltInFictitiousFunctionClassFactory;

        @Override // id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeInt(this.BuiltInFictitiousFunctionClassFactory);
        }

        public ShimmerAnimationPayMethod(int i) {
            super(i);
            this.BuiltInFictitiousFunctionClassFactory = i;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        @JvmName(name = "newProxyInstance")
        /* renamed from: newProxyInstance  reason: from getter */
        public final int getScheduleImpl() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Creator implements Parcelable.Creator<ShimmerAnimationPayMethod> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ShimmerAnimationPayMethod createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new ShimmerAnimationPayMethod(parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ShimmerAnimationPayMethod[] newArray(int i) {
                return new ShimmerAnimationPayMethod[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0012\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\nJ \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u001b8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel$DanaPlusPayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel$ChannelPayMethodModel;", "", "PlaceComponentResult", "()Z", "", "describeContents", "()I", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "scheduleImpl", "lookAheadTest", "moveToNextValue", "initRecordTimeStamp", "GetContactSyncConfig", "DatabaseTableConfigUtil", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/domain/investment/model/DanaPlusMethodConfig;", "getErrorConfigVersion", "Lid/dana/domain/investment/model/DanaPlusMethodConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/model/CashierPayChannelModel;", "Lid/dana/cashier/model/CashierPayChannelModel;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "()Lid/dana/cashier/model/CashierPayChannelModel;", "<init>", "(Lid/dana/cashier/model/CashierPayChannelModel;Lid/dana/domain/investment/model/DanaPlusMethodConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DanaPlusPayMethod extends ChannelPayMethodModel {
        public static final Parcelable.Creator<DanaPlusPayMethod> CREATOR = new Creator();

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public DanaPlusMethodConfig KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public final CashierPayChannelModel PlaceComponentResult;

        @Override // id.dana.cashier.model.CashierPayMethodModel
        /* renamed from: GetContactSyncConfig */
        public final int getKClassImpl$Data$declaredNonStaticMembers$2() {
            return R.drawable.ic_dana_plus;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel, id.dana.cashier.model.CashierPayMethodModel, android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.PlaceComponentResult.writeToParcel(p0, p1);
            p0.writeParcelable(this.KClassImpl$Data$declaredNonStaticMembers$2, p1);
        }

        public /* synthetic */ DanaPlusPayMethod(CashierPayChannelModel cashierPayChannelModel, DanaPlusMethodConfig danaPlusMethodConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(cashierPayChannelModel, (i & 2) != 0 ? null : danaPlusMethodConfig);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel.ChannelPayMethodModel
        @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda5")
        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from getter */
        public final CashierPayChannelModel getMyBillsEntityDataFactory() {
            return this.PlaceComponentResult;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DanaPlusPayMethod(CashierPayChannelModel cashierPayChannelModel, DanaPlusMethodConfig danaPlusMethodConfig) {
            super(7, cashierPayChannelModel);
            Intrinsics.checkNotNullParameter(cashierPayChannelModel, "");
            this.PlaceComponentResult = cashierPayChannelModel;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = danaPlusMethodConfig;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String DatabaseTableConfigUtil() {
            String payMethodName;
            DanaPlusMethodConfig danaPlusMethodConfig = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return (danaPlusMethodConfig == null || (payMethodName = danaPlusMethodConfig.getPayMethodName()) == null) ? PayMethodModel.CashierSectionTitle.DANA_PLUS : payMethodName;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Creator implements Parcelable.Creator<DanaPlusPayMethod> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DanaPlusPayMethod createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new DanaPlusPayMethod(CashierPayChannelModel.CREATOR.createFromParcel(parcel), (DanaPlusMethodConfig) parcel.readParcelable(DanaPlusPayMethod.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ DanaPlusPayMethod[] newArray(int i) {
                return new DanaPlusPayMethod[i];
            }
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final boolean PlaceComponentResult() {
            return Intrinsics.areEqual(this.PlaceComponentResult.getErrorConfigVersion, Boolean.TRUE);
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        /* renamed from: BuiltInFictitiousFunctionClassFactory */
        public final String getMyBillsEntityDataFactory() {
            String str;
            MoneyViewModel moneyViewModel = this.PlaceComponentResult.PlaceComponentResult;
            if (moneyViewModel != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                String KClassImpl$Data$declaredNonStaticMembers$2 = NumberFormatterUtil.KClassImpl$Data$declaredNonStaticMembers$2(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), moneyViewModel.MyBillsEntityDataFactory());
                if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    KClassImpl$Data$declaredNonStaticMembers$2 = "";
                }
                sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
                str = sb.toString();
            } else {
                str = null;
            }
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String scheduleImpl() {
            String str = this.PlaceComponentResult.DatabaseTableConfigUtil;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String lookAheadTest() {
            String str = this.PlaceComponentResult.PrepareContext;
            return str == null ? "" : str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String moveToNextValue() {
            String str = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (str == null) {
                String str2 = this.PlaceComponentResult.BottomSheetCardBindingView$watcherCardNumberView$1;
                return str2 == null ? "" : str2;
            }
            return str;
        }

        @Override // id.dana.cashier.model.CashierPayMethodModel
        public final String initRecordTimeStamp() {
            String str = this.PlaceComponentResult.B;
            return str == null ? "" : str;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ=\u0010\b\u001a\u0004\u0018\u00010\r2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0004\b\b\u0010\u000e"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel$Companion;", "", "", "Lid/dana/cashier/model/CashierPayChannelModel;", "p0", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "p1", "Lid/dana/cashier/model/CashierPayMethodModel$BalanceFamilyPayMethod;", "PlaceComponentResult", "(Ljava/util/List;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)Lid/dana/cashier/model/CashierPayMethodModel$BalanceFamilyPayMethod;", "", "p2", "p3", "Lid/dana/cashier/model/CashierPayMethodModel$BalancePayMethod;", "(Ljava/util/List;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/Boolean;Z)Lid/dana/cashier/model/CashierPayMethodModel$BalancePayMethod;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static BalancePayMethod PlaceComponentResult(List<CashierPayChannelModel> p0, MoneyViewModel p1, Boolean p2, boolean p3) {
            Object obj;
            if (p0 != null) {
                Iterator<T> it = p0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    CashierPayChannelModel cashierPayChannelModel = (CashierPayChannelModel) obj;
                    if (Intrinsics.areEqual("BALANCE", cashierPayChannelModel.B) && Intrinsics.areEqual("BALANCE", cashierPayChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda7)) {
                        break;
                    }
                }
                CashierPayChannelModel cashierPayChannelModel2 = (CashierPayChannelModel) obj;
                if (cashierPayChannelModel2 != null) {
                    return new BalancePayMethod(cashierPayChannelModel2, p1, p2, p3);
                }
                return null;
            }
            return null;
        }

        @JvmStatic
        public static BalanceFamilyPayMethod PlaceComponentResult(List<CashierPayChannelModel> p0, MoneyViewModel p1) {
            Object obj;
            if (p0 != null) {
                Iterator<T> it = p0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    CashierPayChannelModel cashierPayChannelModel = (CashierPayChannelModel) obj;
                    if (Intrinsics.areEqual("BALANCE", cashierPayChannelModel.B) && (Intrinsics.areEqual(PayMethod.BALANCE_FAMILY, cashierPayChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda7) || Intrinsics.areEqual(PayMethod.BALANCE_FAMILY, cashierPayChannelModel.BottomSheetCardBindingView$watcherCardNumberView$1))) {
                        break;
                    }
                }
                CashierPayChannelModel cashierPayChannelModel2 = (CashierPayChannelModel) obj;
                if (cashierPayChannelModel2 != null) {
                    if (p1 == null) {
                        p1 = cashierPayChannelModel2.lookAheadTest;
                    }
                    return new BalanceFamilyPayMethod(cashierPayChannelModel2, p1);
                }
                return null;
            }
            return null;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<CashierPayMethodModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CashierPayMethodModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new CashierPayMethodModel(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CashierPayMethodModel[] newArray(int i) {
            return new CashierPayMethodModel[i];
        }
    }
}
