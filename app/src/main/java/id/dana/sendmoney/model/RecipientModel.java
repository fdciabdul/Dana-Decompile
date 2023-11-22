package id.dana.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.recyclerview.widget.DiffUtil;
import id.dana.data.util.NumberUtils;
import id.dana.domain.sendmoney.TransferScenario;
import id.dana.sendmoney.recipient.RecipientType;
import java.util.Objects;

/* loaded from: classes5.dex */
public class RecipientModel extends BaseRecipientModel implements Parcelable {
    public static final Parcelable.Creator<RecipientModel> CREATOR = new Parcelable.Creator<RecipientModel>() { // from class: id.dana.sendmoney.model.RecipientModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ RecipientModel createFromParcel(Parcel parcel) {
            return new RecipientModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecipientModel[] newArray(int i) {
            return new RecipientModel[i];
        }
    };
    public static final DiffUtil.ItemCallback<RecipientModel> newProxyInstance = new DiffUtil.ItemCallback<RecipientModel>() { // from class: id.dana.sendmoney.model.RecipientModel.2
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(RecipientModel recipientModel, RecipientModel recipientModel2) {
            return getAuthRequestContext2(recipientModel, recipientModel2);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final /* synthetic */ boolean getAuthRequestContext(RecipientModel recipientModel, RecipientModel recipientModel2) {
            return MyBillsEntityDataFactory(recipientModel, recipientModel2);
        }

        private static boolean MyBillsEntityDataFactory(RecipientModel recipientModel, RecipientModel recipientModel2) {
            return recipientModel.toString().equals(recipientModel2.toString());
        }

        /* renamed from: getAuthRequestContext  reason: avoid collision after fix types in other method */
        private static boolean getAuthRequestContext2(RecipientModel recipientModel, RecipientModel recipientModel2) {
            return recipientModel.toString().equals(recipientModel2.toString());
        }
    };
    public int A;
    public String B;
    public String BottomSheetCardBindingView$watcherCardNumberView$1;
    private String C;
    public String FragmentBottomSheetPaymentSettingBinding;
    public String NetworkUserEntityData$$ExternalSyntheticLambda3;
    public String NetworkUserEntityData$$ExternalSyntheticLambda4;
    public String NetworkUserEntityData$$ExternalSyntheticLambda5;
    public String NetworkUserEntityData$$ExternalSyntheticLambda6;
    public String NetworkUserEntityData$$ExternalSyntheticLambda7;
    public String NetworkUserEntityData$$ExternalSyntheticLambda8;
    public String PrepareContext;
    public String SubSequence;
    private boolean VerifyPinStateManager$executeRiskChallenge$2$1;
    public int getCallingPid;
    public String getSupportButtonTintMode;
    public boolean isLayoutRequested;
    public String readMicros;
    public String whenAvailable;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RecipientModel(String str) {
        this.readMicros = str;
    }

    protected RecipientModel(Parcel parcel) {
        this.whenAvailable = parcel.readString();
        this.SubSequence = parcel.readString();
        this.getCallingPid = parcel.readInt();
        this.A = parcel.readInt();
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = parcel.readString();
        this.readMicros = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readString();
        this.scheduleImpl = parcel.readString();
        this.getErrorConfigVersion = parcel.readString();
        this.C = parcel.readString();
        this.PlaceComponentResult = parcel.readString();
        this.getAuthRequestContext = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = parcel.readString();
        this.DatabaseTableConfigUtil = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = parcel.readString();
        this.PrepareContext = parcel.readString();
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = parcel.readByte() != 0;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = parcel.readString();
        this.B = parcel.readString();
        this.getSupportButtonTintMode = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = parcel.readString();
        this.isLayoutRequested = parcel.readByte() != 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = parcel.readString();
        this.FragmentBottomSheetPaymentSettingBinding = parcel.readString();
        this.GetContactSyncConfig = parcel.readByte() != 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = parcel.readString();
        this.FragmentBottomSheetPaymentSettingBinding = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = parcel.readInt();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = parcel.readString();
        this.lookAheadTest = parcel.readByte() != 0;
    }

    @Override // id.dana.sendmoney.model.BaseRecipientModel
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        if ("phonenumber".equals(this.NetworkUserEntityData$$ExternalSyntheticLambda6)) {
            return NumberUtils.getClearPhoneNumber(super.KClassImpl$Data$declaredNonStaticMembers$2());
        }
        return super.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.sendmoney.model.BaseRecipientModel
    public final String BuiltInFictitiousFunctionClassFactory() {
        return TextUtils.isEmpty(super.BuiltInFictitiousFunctionClassFactory()) ? "" : super.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.sendmoney.model.BaseRecipientModel
    public final String PlaceComponentResult() {
        if (!"bank".equals(this.readMicros)) {
            return (("contact".equals(this.readMicros) || RecipientType.OTC.equals(this.readMicros) || "recentContacts".equals(this.readMicros)) && !TextUtils.isEmpty(super.PlaceComponentResult())) ? super.PlaceComponentResult() : "-";
        } else if (TextUtils.isEmpty(super.PlaceComponentResult())) {
            return !TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory) ? this.BuiltInFictitiousFunctionClassFactory : "-";
        } else {
            return super.PlaceComponentResult();
        }
    }

    public final String lookAheadTest() {
        return super.PlaceComponentResult();
    }

    @Override // id.dana.sendmoney.model.BaseRecipientModel
    public final boolean scheduleImpl() {
        return "userid".equals(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return TextUtils.isEmpty(super.PlaceComponentResult()) || (!TextUtils.isEmpty(super.PlaceComponentResult()) && super.PlaceComponentResult().equals("-"));
    }

    public final boolean initRecordTimeStamp() {
        return this.isLayoutRequested;
    }

    @Override // id.dana.sendmoney.model.BaseRecipientModel
    public final String getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    @Override // id.dana.sendmoney.model.BaseRecipientModel
    public final void MyBillsEntityDataFactory(String str) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str;
    }

    @Override // id.dana.sendmoney.model.BaseRecipientModel
    public final String MyBillsEntityDataFactory() {
        return this.FragmentBottomSheetPaymentSettingBinding;
    }

    @Override // id.dana.sendmoney.model.BaseRecipientModel
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        this.FragmentBottomSheetPaymentSettingBinding = str;
    }

    @Override // id.dana.sendmoney.model.BaseRecipientModel
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda5;
    }

    @Override // id.dana.sendmoney.model.BaseRecipientModel
    public final void getAuthRequestContext(String str) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        String KClassImpl$Data$declaredNonStaticMembers$2;
        parcel.writeString(this.whenAvailable);
        parcel.writeString(this.SubSequence);
        parcel.writeInt(this.getCallingPid);
        parcel.writeInt(this.A);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        parcel.writeString(this.readMicros);
        if ("phonenumber".equals(this.NetworkUserEntityData$$ExternalSyntheticLambda6)) {
            KClassImpl$Data$declaredNonStaticMembers$2 = NumberUtils.getClearPhoneNumber(super.KClassImpl$Data$declaredNonStaticMembers$2());
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2 = super.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        parcel.writeString(KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeString(super.PlaceComponentResult());
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeString(this.C);
        parcel.writeString(TextUtils.isEmpty(super.BuiltInFictitiousFunctionClassFactory()) ? "" : super.BuiltInFictitiousFunctionClassFactory());
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        parcel.writeString(this.DatabaseTableConfigUtil);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        parcel.writeString(this.PrepareContext);
        parcel.writeByte(this.VerifyPinStateManager$executeRiskChallenge$2$1 ? (byte) 1 : (byte) 0);
        parcel.writeString(this.BottomSheetCardBindingView$watcherCardNumberView$1);
        parcel.writeString(this.B);
        parcel.writeString(this.getSupportButtonTintMode);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        parcel.writeByte(this.isLayoutRequested ? (byte) 1 : (byte) 0);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        parcel.writeString(this.FragmentBottomSheetPaymentSettingBinding);
        parcel.writeByte(moveToNextValue() ? (byte) 1 : (byte) 0);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        parcel.writeString(this.FragmentBottomSheetPaymentSettingBinding);
        parcel.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        parcel.writeByte(getErrorConfigVersion() ? (byte) 1 : (byte) 0);
    }

    public int hashCode() {
        return Objects.hash(this.whenAvailable, this.SubSequence, Integer.valueOf(this.getCallingPid), Integer.valueOf(this.A), this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.PrepareContext, Boolean.valueOf(this.VerifyPinStateManager$executeRiskChallenge$2$1), this.getSupportButtonTintMode, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.readMicros, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.B, this.C, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.NetworkUserEntityData$$ExternalSyntheticLambda3, Boolean.valueOf(this.isLayoutRequested), this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda5);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof RecipientModel) {
            RecipientModel recipientModel = (RecipientModel) obj;
            if (recipientModel.getErrorConfigVersion == null || this.getErrorConfigVersion == null) {
                return false;
            }
            if ("contact".equals(this.readMicros)) {
                return NumberUtils.getClearPhoneNumber(recipientModel.getErrorConfigVersion).equals(NumberUtils.getClearPhoneNumber(this.getErrorConfigVersion));
            }
            return recipientModel.getErrorConfigVersion.equals(this.getErrorConfigVersion);
        }
        return false;
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(QrTransferModel qrTransferModel) {
        return qrTransferModel.lookAheadTest() ? TransferScenario.PROFILE_QR : qrTransferModel.initRecordTimeStamp() ? TransferScenario.REQUEST_MONEY_BANK_QR : qrTransferModel.GetContactSyncConfig() ? TransferScenario.REQUEST_MONEY : "";
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        public boolean BuiltInFictitiousFunctionClassFactory;
        public String DatabaseTableConfigUtil;
        public int FragmentBottomSheetPaymentSettingBinding;
        public String GetContactSyncConfig;
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public String MyBillsEntityDataFactory;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        public String NetworkUserEntityData$$ExternalSyntheticLambda1;
        public String NetworkUserEntityData$$ExternalSyntheticLambda2;
        public String NetworkUserEntityData$$ExternalSyntheticLambda3;
        public String NetworkUserEntityData$$ExternalSyntheticLambda4;
        public String NetworkUserEntityData$$ExternalSyntheticLambda5;
        public String NetworkUserEntityData$$ExternalSyntheticLambda6;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda7;
        public String NetworkUserEntityData$$ExternalSyntheticLambda8;
        public String PlaceComponentResult;
        public String PrepareContext;
        private String SubSequence;
        public String getAuthRequestContext;
        private String getCallingPid;
        public String getErrorConfigVersion;
        private String getSupportButtonTintMode;
        public String initRecordTimeStamp;
        public String isLayoutRequested;
        public String lookAheadTest;
        public boolean moveToNextValue;
        public String newProxyInstance;
        private int readMicros;
        public String scheduleImpl;
        private int whenAvailable;

        public Builder(String str) {
            this.getSupportButtonTintMode = str;
        }

        public final RecipientModel KClassImpl$Data$declaredNonStaticMembers$2() {
            RecipientModel recipientModel = new RecipientModel(this.getSupportButtonTintMode);
            recipientModel.whenAvailable = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            recipientModel.SubSequence = this.newProxyInstance;
            recipientModel.getCallingPid = this.whenAvailable;
            recipientModel.A = this.readMicros;
            recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda4 = this.getCallingPid;
            recipientModel.MyBillsEntityDataFactory = this.scheduleImpl;
            recipientModel.scheduleImpl = this.initRecordTimeStamp;
            recipientModel.getErrorConfigVersion = this.GetContactSyncConfig;
            recipientModel.PlaceComponentResult = this.getErrorConfigVersion;
            recipientModel.C = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            recipientModel.getAuthRequestContext = this.PlaceComponentResult;
            recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            recipientModel.DatabaseTableConfigUtil = this.DatabaseTableConfigUtil;
            recipientModel.BuiltInFictitiousFunctionClassFactory = this.lookAheadTest;
            recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = this.PrepareContext;
            recipientModel.PrepareContext = this.KClassImpl$Data$declaredNonStaticMembers$2;
            recipientModel.VerifyPinStateManager$executeRiskChallenge$2$1 = this.BuiltInFictitiousFunctionClassFactory;
            recipientModel.BottomSheetCardBindingView$watcherCardNumberView$1 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            recipientModel.B = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            recipientModel.getSupportButtonTintMode = this.SubSequence;
            recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = this.MyBillsEntityDataFactory;
            recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            recipientModel.isLayoutRequested = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = this.getAuthRequestContext;
            recipientModel.FragmentBottomSheetPaymentSettingBinding = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            recipientModel.GetContactSyncConfig = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = this.getAuthRequestContext;
            recipientModel.FragmentBottomSheetPaymentSettingBinding = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = this.FragmentBottomSheetPaymentSettingBinding;
            recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda5 = this.isLayoutRequested;
            recipientModel.lookAheadTest = this.moveToNextValue;
            return recipientModel;
        }
    }
}
