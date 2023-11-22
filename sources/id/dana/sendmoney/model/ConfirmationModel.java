package id.dana.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ExpandableListView;
import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.sendmoney.confirmation.ConfirmationType;
import id.dana.utils.TextUtil;
import kotlin.text.Typography;
import o.E;

/* loaded from: classes5.dex */
public class ConfirmationModel implements Parcelable {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final Parcelable.Creator<ConfirmationModel> CREATOR;
    private static long SummaryVoucherView$$ExternalSyntheticLambda2 = 0;
    private static int T = 0;
    private static int U = 1;
    private static char X;
    private static int isAuth;
    private String A;
    private String AppCompatEmojiTextHelper;
    private String B;
    private String BottomSheetCardBindingView$watcherCardNumberView$1;
    private String BuiltInFictitiousFunctionClassFactory;
    private String C;
    private String D;
    private String DatabaseTableConfigUtil;
    private int E;
    private String F;
    private String FragmentBottomSheetPaymentSettingBinding;
    private String G;
    private String GetContactSyncConfig;
    private String H;
    private boolean I;
    private String J;
    private String K;
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private ShareActivityModel L;
    private String M;
    private String MyBillsEntityDataFactory;
    private String N;
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;
    private String NetworkUserEntityData$$ExternalSyntheticLambda3;
    private CardHolderModel NetworkUserEntityData$$ExternalSyntheticLambda4;
    private int NetworkUserEntityData$$ExternalSyntheticLambda5;
    private String NetworkUserEntityData$$ExternalSyntheticLambda6;
    private String NetworkUserEntityData$$ExternalSyntheticLambda7;
    private String NetworkUserEntityData$$ExternalSyntheticLambda8;
    private String O;
    private int P;
    private boolean PlaceComponentResult;
    private String PrepareContext;
    private int Q;
    private WithdrawOTCModel R;
    private String S;
    private boolean SubSequence;
    private int SummaryVoucherView$$ExternalSyntheticLambda0;
    private String SummaryVoucherView$$ExternalSyntheticLambda1;
    private String VerifyPinStateManager$executeRiskChallenge$2$1;
    private String VerifyPinStateManager$executeRiskChallenge$2$2;
    private String getAuthRequestContext;
    private String getCallingPid;
    private String getErrorConfigVersion;
    private String getNameOrBuilderList;
    private String getOnBoardingScenario;
    private String getSupportButtonTintMode;
    private int getValueOfTouchPositionAbsolute;
    private String initRecordTimeStamp;
    private String isLayoutRequested;
    private String lookAheadTest;
    private String moveToNextValue;
    private String newProxyInstance;
    private String readMicros;
    private String scheduleImpl;
    private String whenAvailable;

    static void L() {
        X = (char) 13492;
        SummaryVoucherView$$ExternalSyntheticLambda2 = -5342047171824673935L;
        isAuth = -956812108;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        int i = T + 3;
        U = i % 128;
        return i % 2 == 0 ? 0 : 0;
    }

    /* synthetic */ ConfirmationModel(Parcel parcel, byte b) {
        this(parcel);
    }

    static {
        L();
        CREATOR = new Parcelable.Creator<ConfirmationModel>() { // from class: id.dana.sendmoney.model.ConfirmationModel.1
            @Override // android.os.Parcelable.Creator
            public /* synthetic */ ConfirmationModel createFromParcel(Parcel parcel) {
                return new ConfirmationModel(parcel, (byte) 0);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ ConfirmationModel[] newArray(int i) {
                return new ConfirmationModel[i];
            }
        };
        int i = U + 27;
        T = i % 128;
        if ((i % 2 != 0 ? '3' : 'R') != '3') {
            return;
        }
        int i2 = 38 / 0;
    }

    public ConfirmationModel() {
        this.PlaceComponentResult = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private ConfirmationModel(android.os.Parcel r5) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.model.ConfirmationModel.<init>(android.os.Parcel):void");
    }

    public final WithdrawOTCModel G() {
        try {
            int i = T + 79;
            U = i % 128;
            int i2 = i % 2;
            try {
                WithdrawOTCModel withdrawOTCModel = this.R;
                int i3 = T + 15;
                U = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 4 : (char) 31) != 4) {
                    return withdrawOTCModel;
                }
                Object obj = null;
                obj.hashCode();
                return withdrawOTCModel;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(WithdrawOTCModel withdrawOTCModel) {
        int i = T + 13;
        U = i % 128;
        int i2 = i % 2;
        this.R = withdrawOTCModel;
        int i3 = U + 69;
        T = i3 % 128;
        if ((i3 % 2 != 0 ? 'D' : (char) 29) != 'D') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public final String initRecordTimeStamp() {
        int i = T + 31;
        U = i % 128;
        int i2 = i % 2;
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int i3 = U + 53;
        T = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda2(String str) {
        int i = T + 73;
        U = i % 128;
        if (i % 2 == 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str;
            Object[] objArr = null;
            int length = objArr.length;
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = T + 73;
        U = i2 % 128;
        int i3 = i2 % 2;
        parcel.writeString(this.getNameOrBuilderList);
        parcel.writeString(this.AppCompatEmojiTextHelper);
        parcel.writeInt(this.Q);
        parcel.writeInt(this.P);
        parcel.writeInt(this.E);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeByte(this.PlaceComponentResult ? (byte) 1 : (byte) 0);
        parcel.writeString(this.lookAheadTest);
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeString(this.scheduleImpl);
        parcel.writeString(this.moveToNextValue);
        parcel.writeString(this.isLayoutRequested);
        parcel.writeString(this.DatabaseTableConfigUtil);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        parcel.writeString(this.initRecordTimeStamp);
        parcel.writeString(this.PrepareContext);
        parcel.writeString(this.readMicros);
        parcel.writeString(this.whenAvailable);
        parcel.writeString(this.getSupportButtonTintMode);
        parcel.writeString(this.getCallingPid);
        parcel.writeString(this.BottomSheetCardBindingView$watcherCardNumberView$1);
        parcel.writeString(this.A);
        parcel.writeString(this.D);
        parcel.writeString(this.VerifyPinStateManager$executeRiskChallenge$2$2);
        parcel.writeString(this.getOnBoardingScenario);
        parcel.writeString(this.F);
        parcel.writeString(this.newProxyInstance);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        parcel.writeByte(this.I ? (byte) 1 : (byte) 0);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        parcel.writeString(this.K);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeString(this.B);
        parcel.writeString(this.VerifyPinStateManager$executeRiskChallenge$2$1);
        parcel.writeString(this.H);
        parcel.writeString(this.C);
        parcel.writeInt(this.getValueOfTouchPositionAbsolute);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        parcel.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        parcel.writeString(this.S);
        parcel.writeString(this.GetContactSyncConfig);
        parcel.writeString(this.SummaryVoucherView$$ExternalSyntheticLambda1);
        parcel.writeString(this.O);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        parcel.writeParcelable(this.R, 1);
        parcel.writeString(this.J);
        parcel.writeString(this.M);
        parcel.writeString(this.FragmentBottomSheetPaymentSettingBinding);
        parcel.writeParcelable(this.L, 1);
        parcel.writeString(this.G);
        parcel.writeInt(this.SummaryVoucherView$$ExternalSyntheticLambda0);
        parcel.writeString(this.N);
        parcel.writeByte(this.SubSequence ? (byte) 1 : (byte) 0);
        int i4 = T + 31;
        U = i4 % 128;
        if ((i4 % 2 == 0 ? '-' : 'O') != 'O') {
            Object obj = null;
            obj.hashCode();
        }
    }

    public final String C() {
        int i = U + 33;
        T = i % 128;
        int i2 = i % 2;
        try {
            String str = this.getNameOrBuilderList;
            int i3 = T + 121;
            U = i3 % 128;
            if (i3 % 2 == 0) {
                Object[] objArr = null;
                int length = objArr.length;
                return str;
            }
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void E(String str) {
        try {
            int i = U + 87;
            T = i % 128;
            Object[] objArr = null;
            if (i % 2 != 0) {
                this.getNameOrBuilderList = str;
                int length = objArr.length;
            } else {
                this.getNameOrBuilderList = str;
            }
            int i2 = U + 79;
            T = i2 % 128;
            if ((i2 % 2 != 0 ? InputCardNumberView.DIVIDER : 'J') != 'J') {
                objArr.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public final String getSupportButtonTintMode() {
        try {
            int i = U + 83;
            T = i % 128;
            int i2 = i % 2;
            try {
                String str = this.AppCompatEmojiTextHelper;
                int i3 = T + 27;
                U = i3 % 128;
                if ((i3 % 2 == 0 ? 'T' : Typography.amp) != '&') {
                    int i4 = 15 / 0;
                    return str;
                }
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void A(String str) {
        int i = T + 51;
        U = i % 128;
        int i2 = i % 2;
        this.AppCompatEmojiTextHelper = str;
        int i3 = U + 17;
        T = i3 % 128;
        if ((i3 % 2 != 0 ? 'M' : (char) 31) != 31) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public final int B() {
        try {
            int i = U + 85;
            T = i % 128;
            if (!(i % 2 == 0)) {
                int i2 = this.Q;
                Object obj = null;
                obj.hashCode();
                return i2;
            }
            return this.Q;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        int i2 = U + 117;
        T = i2 % 128;
        int i3 = i2 % 2;
        this.Q = i;
        int i4 = T + 43;
        U = i4 % 128;
        int i5 = i4 % 2;
    }

    public final int D() {
        int i;
        int i2 = T + 49;
        U = i2 % 128;
        if (i2 % 2 != 0) {
            i = this.P;
        } else {
            i = this.P;
            int i3 = 36 / 0;
        }
        try {
            int i4 = U + 93;
            T = i4 % 128;
            int i5 = i4 % 2;
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        int i2 = T + 79;
        U = i2 % 128;
        boolean z = i2 % 2 != 0;
        this.P = i;
        if (!z) {
            int i3 = 77 / 0;
        }
        try {
            int i4 = T + 59;
            try {
                U = i4 % 128;
                if ((i4 % 2 == 0 ? (char) 14 : '8') != 14) {
                    return;
                }
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final int SubSequence() {
        int i = T + 93;
        U = i % 128;
        if (i % 2 != 0) {
            try {
                return this.E;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i2 = this.E;
            Object[] objArr = null;
            int length = objArr.length;
            return i2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda6(String str) {
        int i = U + 77;
        T = i % 128;
        int i2 = i % 2;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = str;
        int i3 = U + 3;
        T = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public final boolean H() {
        int i = U + 39;
        T = i % 128;
        int i2 = i % 2;
        boolean z = this.PlaceComponentResult;
        int i3 = U + 9;
        T = i3 % 128;
        if (i3 % 2 == 0) {
            return z;
        }
        Object obj = null;
        obj.hashCode();
        return z;
    }

    public final void getAuthRequestContext(boolean z) {
        int i = T + 31;
        U = i % 128;
        int i2 = i % 2;
        this.PlaceComponentResult = z;
        int i3 = T + 109;
        U = i3 % 128;
        if ((i3 % 2 == 0 ? 'K' : 'R') != 'R') {
            Object obj = null;
            obj.hashCode();
        }
    }

    public final String PlaceComponentResult() {
        int i = T + 43;
        U = i % 128;
        int i2 = i % 2;
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i3 = T + 63;
        U = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        try {
            int i = U + 13;
            T = i % 128;
            if ((i % 2 != 0 ? 'R' : (char) 24) != 24) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
                Object obj = null;
                obj.hashCode();
            } else {
                try {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
                } catch (Exception e) {
                    throw e;
                }
            }
            int i2 = T + 113;
            U = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = U + 27;
        T = i % 128;
        int i2 = i % 2;
        String str = this.BuiltInFictitiousFunctionClassFactory;
        int i3 = U + 95;
        T = i3 % 128;
        if (!(i3 % 2 == 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        }
        return str;
    }

    public final void PlaceComponentResult(String str) {
        int i = T + 125;
        U = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? 'U' : 'A') != 'A') {
            try {
                this.BuiltInFictitiousFunctionClassFactory = str;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.BuiltInFictitiousFunctionClassFactory = str;
        }
        int i2 = T + 125;
        U = i2 % 128;
        if (!(i2 % 2 == 0)) {
            return;
        }
        obj.hashCode();
    }

    public final String BuiltInFictitiousFunctionClassFactory() {
        int i = T + 73;
        U = i % 128;
        if ((i % 2 == 0 ? '(' : 'K') != 'K') {
            try {
                String str = this.getAuthRequestContext;
                Object obj = null;
                obj.hashCode();
                return str;
            } catch (Exception e) {
                throw e;
            }
        }
        return this.getAuthRequestContext;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        int i = U + 121;
        T = i % 128;
        if ((i % 2 != 0 ? JSONLexer.EOI : (char) 22) != 22) {
            this.getAuthRequestContext = str;
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            try {
                this.getAuthRequestContext = str;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = U + 15;
        T = i2 % 128;
        int i3 = i2 % 2;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0(String str) {
        int i = U + 97;
        T = i % 128;
        Object[] objArr = null;
        if (!(i % 2 == 0)) {
            try {
                this.lookAheadTest = str;
                objArr.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.lookAheadTest = str;
        }
        int i2 = T + 23;
        U = i2 % 128;
        if ((i2 % 2 == 0 ? ')' : (char) 24) != ')') {
            return;
        }
        int length = objArr.length;
    }

    public final String getErrorConfigVersion() {
        int i = U + 53;
        T = i % 128;
        int i2 = i % 2;
        String str = this.scheduleImpl;
        int i3 = T + 15;
        U = i3 % 128;
        if ((i3 % 2 == 0 ? 'A' : 'V') != 'A') {
            return str;
        }
        int i4 = 53 / 0;
        return str;
    }

    public final void getErrorConfigVersion(String str) {
        int i = T + 85;
        U = i % 128;
        char c = i % 2 == 0 ? InputCardNumberView.DIVIDER : '^';
        this.scheduleImpl = str;
        if (c != '^') {
            int i2 = 95 / 0;
        }
    }

    public final int moveToNextValue() {
        int i = T + 69;
        U = i % 128;
        int i2 = i % 2;
        int H = H(this.scheduleImpl);
        int i3 = U + 3;
        T = i3 % 128;
        int i4 = i3 % 2;
        return H;
    }

    private static int H(String str) {
        int i = T + 17;
        U = i % 128;
        int i2 = i % 2;
        try {
            int parseInt = Integer.parseInt(str);
            int i3 = U + 41;
            T = i3 % 128;
            int i4 = i3 % 2;
            return parseInt;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public final String scheduleImpl() {
        String str;
        try {
            int i = T + 61;
            U = i % 128;
            if (!(i % 2 != 0)) {
                str = this.moveToNextValue;
                int i2 = 52 / 0;
            } else {
                str = this.moveToNextValue;
            }
            int i3 = U + 27;
            T = i3 % 128;
            if ((i3 % 2 != 0 ? '@' : 'H') != '@') {
                return str;
            }
            Object obj = null;
            obj.hashCode();
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void scheduleImpl(String str) {
        int i = U + 33;
        T = i % 128;
        int i2 = i % 2;
        try {
            this.moveToNextValue = str;
            int i3 = T + 63;
            U = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final String PrepareContext() {
        try {
            int i = U + 41;
            T = i % 128;
            int i2 = i % 2;
            String str = this.PrepareContext;
            try {
                int i3 = T + 73;
                U = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void newProxyInstance(String str) {
        int i = U + 59;
        T = i % 128;
        if (!(i % 2 != 0)) {
            this.PrepareContext = str;
            return;
        }
        this.PrepareContext = str;
        Object obj = null;
        obj.hashCode();
    }

    public final String DatabaseTableConfigUtil() {
        String str;
        int i = T + 49;
        U = i % 128;
        if (!(i % 2 == 0)) {
            str = this.initRecordTimeStamp;
        } else {
            str = this.initRecordTimeStamp;
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = U + 77;
        T = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 55 / 0;
            return str;
        }
        return str;
    }

    public final void GetContactSyncConfig(String str) {
        int i = T + 77;
        U = i % 128;
        char c = i % 2 == 0 ? 'V' : 'a';
        this.initRecordTimeStamp = str;
        if (c != 'a') {
            Object obj = null;
            obj.hashCode();
        }
    }

    public final void SubSequence(String str) {
        int i = T + 43;
        U = i % 128;
        try {
            if ((i % 2 == 0 ? '8' : '2') == '2') {
                this.A = str;
                return;
            }
            this.A = str;
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public final void C(String str) {
        try {
            int i = T + 81;
            U = i % 128;
            int i2 = i % 2;
            this.D = str;
            int i3 = U + 105;
            T = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public final String lookAheadTest() {
        int i = U + 59;
        T = i % 128;
        if ((i % 2 == 0 ? '!' : ';') != '!') {
            try {
                int i2 = 70 / 0;
                return this.getErrorConfigVersion;
            } catch (Exception e) {
                throw e;
            }
        }
        return this.getErrorConfigVersion;
    }

    public final void moveToNextValue(String str) {
        try {
            int i = U + 11;
            T = i % 128;
            boolean z = i % 2 == 0;
            this.getErrorConfigVersion = str;
            if (z) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void VerifyPinStateManager$executeRiskChallenge$2$1(String str) {
        int i = T + 81;
        U = i % 128;
        int i2 = i % 2;
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = str;
        int i3 = U + 5;
        T = i3 % 128;
        int i4 = i3 % 2;
    }

    public final String FragmentBottomSheetPaymentSettingBinding() {
        try {
            int i = U + 35;
            T = i % 128;
            int i2 = i % 2;
            try {
                String str = this.getCallingPid;
                int i3 = T + 113;
                U = i3 % 128;
                if ((i3 % 2 == 0 ? JSONLexer.EOI : 'B') != 'B') {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return str;
                }
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void FragmentBottomSheetPaymentSettingBinding(String str) {
        try {
            int i = U + 107;
            try {
                T = i % 128;
                int i2 = i % 2;
                this.getCallingPid = str;
                int i3 = U + 65;
                T = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final String whenAvailable() {
        int i = U + 99;
        T = i % 128;
        int i2 = i % 2;
        String str = this.F;
        int i3 = U + 113;
        T = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return str;
        }
        Object obj = null;
        obj.hashCode();
        return str;
    }

    public final void B(String str) {
        int i = U + 71;
        T = i % 128;
        if (i % 2 == 0) {
            try {
                this.F = str;
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.F = str;
            int i2 = 28 / 0;
        }
        int i3 = T + 95;
        U = i3 % 128;
        if ((i3 % 2 == 0 ? 'H' : '0') != 'H') {
            return;
        }
        int i4 = 19 / 0;
    }

    public final String NetworkUserEntityData$$ExternalSyntheticLambda7() {
        int i = U + 75;
        T = i % 128;
        int i2 = i % 2;
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        try {
            int i3 = T + 93;
            U = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 15 : 'D') != 'D') {
                Object obj = null;
                obj.hashCode();
                return str;
            }
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void PrepareContext(String str) {
        int i = U + 109;
        T = i % 128;
        int i2 = i % 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = str;
        int i3 = T + 85;
        U = i3 % 128;
        if (i3 % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public final void lookAheadTest(String str) {
        int i = U + 29;
        T = i % 128;
        int i2 = i % 2;
        this.DatabaseTableConfigUtil = str;
        try {
            int i3 = U + 73;
            T = i3 % 128;
            if ((i3 % 2 != 0 ? 'T' : '!') != 'T') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda3(String str) {
        int i = U + 99;
        T = i % 128;
        int i2 = i % 2;
        this.getSupportButtonTintMode = str;
        try {
            int i3 = T + 71;
            try {
                U = i3 % 128;
                if (i3 % 2 == 0) {
                    int i4 = 54 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final String NetworkUserEntityData$$ExternalSyntheticLambda4() {
        int i = T + 41;
        U = i % 128;
        if ((i % 2 == 0 ? '=' : (char) 3) != '=') {
            try {
                return this.whenAvailable;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i2 = 83 / 0;
            return this.whenAvailable;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda4(String str) {
        int i = T + 25;
        U = i % 128;
        if ((i % 2 == 0 ? (char) 18 : 'G') != 18) {
            try {
                this.whenAvailable = str;
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.whenAvailable = str;
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = U + 1;
        T = i2 % 128;
        int i3 = i2 % 2;
    }

    public final void PlaceComponentResult(CardHolderModel cardHolderModel) {
        int i = T + 65;
        U = i % 128;
        int i2 = i % 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = cardHolderModel;
        int i3 = T + 61;
        U = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 16 : '?') != 16) {
            return;
        }
        int i4 = 34 / 0;
    }

    public final String NetworkUserEntityData$$ExternalSyntheticLambda1() {
        String str;
        int i = T + 5;
        U = i % 128;
        if (!(i % 2 != 0)) {
            str = this.isLayoutRequested;
            int i2 = 23 / 0;
        } else {
            try {
                str = this.isLayoutRequested;
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = T + 19;
        try {
            U = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void initRecordTimeStamp(String str) {
        try {
            int i = U + 69;
            T = i % 128;
            boolean z = i % 2 != 0;
            this.isLayoutRequested = str;
            if (z) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public final String readMicros() {
        int i = T + 123;
        U = i % 128;
        if (i % 2 == 0) {
            int i2 = 5 / 0;
            return this.getOnBoardingScenario;
        }
        try {
            return this.getOnBoardingScenario;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void whenAvailable(String str) {
        int i = U + 61;
        T = i % 128;
        int i2 = i % 2;
        try {
            this.getOnBoardingScenario = str;
            int i3 = T + 35;
            U = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final String NetworkUserEntityData$$ExternalSyntheticLambda2() {
        try {
            int i = T + 39;
            try {
                U = i % 128;
                int i2 = i % 2;
                String str = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                int i3 = T + 29;
                U = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    return str;
                }
                Object[] objArr = null;
                int length = objArr.length;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void DatabaseTableConfigUtil(String str) {
        int i = U + 61;
        T = i % 128;
        int i2 = i % 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str;
        try {
            int i3 = T + 53;
            U = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final String isLayoutRequested() {
        int i = U + 5;
        T = i % 128;
        int i2 = i % 2;
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        int i3 = T + 79;
        U = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 66 / 0;
            return str;
        }
        return str;
    }

    public final void isLayoutRequested(String str) {
        int i = U + 33;
        T = i % 128;
        if (i % 2 != 0) {
            try {
                this.NetworkUserEntityData$$ExternalSyntheticLambda6 = str;
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = str;
        }
        int i2 = U + 9;
        T = i2 % 128;
        int i3 = i2 % 2;
    }

    public final String VerifyPinStateManager$executeRiskChallenge$2$1() {
        int i = T + 75;
        U = i % 128;
        if (i % 2 == 0) {
            String str = this.K;
            Object obj = null;
            obj.hashCode();
            return str;
        }
        return this.K;
    }

    public final void D(String str) {
        int i = U + 55;
        T = i % 128;
        int i2 = i % 2;
        this.K = str;
        try {
            int i3 = T + 83;
            U = i3 % 128;
            if (!(i3 % 2 != 0)) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public final String NetworkUserEntityData$$ExternalSyntheticLambda8() {
        try {
            int i = T + 107;
            U = i % 128;
            char c = i % 2 != 0 ? (char) 5 : (char) 2;
            String str = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (c != 5) {
                Object obj = null;
                obj.hashCode();
            }
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda7(String str) {
        int i = T + 31;
        U = i % 128;
        int i2 = i % 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = str;
        int i3 = U + 21;
        T = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 78 / 0;
        }
    }

    public final String newProxyInstance() {
        int i = T + 9;
        U = i % 128;
        int i2 = i % 2;
        try {
            if ((ConfirmationType.Destination.OTC.equals(this.PrepareContext) ? '\b' : (char) 25) == 25) {
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append(getAuthRequestContext());
                    sb.append(" ");
                    sb.append(MyBillsEntityDataFactory());
                    return sb.toString();
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = U + 87;
            T = i3 % 128;
            if (i3 % 2 == 0) {
                return getNameOrBuilderList();
            }
            String nameOrBuilderList = getNameOrBuilderList();
            Object obj = null;
            obj.hashCode();
            return nameOrBuilderList;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private String getNameOrBuilderList() {
        Object obj;
        int i = U + 41;
        T = i % 128;
        if ((i % 2 != 0 ? 'O' : (char) 6) != 'O') {
            Object[] objArr = new Object[1];
            a(new char[]{51157, 11105, 52249, 48558}, new char[]{62397, 32403, 52401, 64771}, (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 972), new char[]{44997, 18682, 26208, 35160}, View.MeasureSpec.getSize(0), objArr);
            obj = objArr[0];
        } else {
            Object[] objArr2 = new Object[1];
            a(new char[]{51157, 11105, 52249, 48558}, new char[]{62397, 32403, 52401, 64771}, (char) ((ExpandableListView.getPackedPositionForGroup(1) > 1L ? 1 : (ExpandableListView.getPackedPositionForGroup(1) == 1L ? 0 : -1)) + 23754), new char[]{44997, 18682, 26208, 35160}, View.MeasureSpec.getSize(1), objArr2);
            obj = objArr2[0];
        }
        return AppCompatEmojiTextHelper(((String) obj).intern());
    }

    private String AppCompatEmojiTextHelper(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(" ");
        sb.append(str);
        String obj = sb.toString();
        if ((TextUtils.isDigitsOnly(this.KClassImpl$Data$declaredNonStaticMembers$2) ? ';' : '.') != '.' && Integer.parseInt(this.KClassImpl$Data$declaredNonStaticMembers$2) > 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append("s");
            obj = sb2.toString();
            try {
                int i = U + 77;
                try {
                    T = i % 128;
                    int i2 = i % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = U + 101;
        T = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 97 / 0;
            return obj;
        }
        return obj;
    }

    public final String getAuthRequestContext() {
        try {
            int i = T + 101;
            U = i % 128;
            if (i % 2 == 0) {
                int i2 = 97 / 0;
                return TextUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return TextUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(this.KClassImpl$Data$declaredNonStaticMembers$2);
        } catch (Exception e) {
            throw e;
        }
    }

    public final void MyBillsEntityDataFactory(String str) {
        int i = U + 33;
        T = i % 128;
        Object obj = null;
        if (!(i % 2 != 0)) {
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            obj.hashCode();
        }
        int i2 = T + 11;
        U = i2 % 128;
        if (i2 % 2 == 0) {
            obj.hashCode();
        }
    }

    public final String MyBillsEntityDataFactory() {
        int i = T + 91;
        U = i % 128;
        int i2 = i % 2;
        try {
            String NetworkUserEntityData$$ExternalSyntheticLambda1 = TextUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(this.MyBillsEntityDataFactory);
            int i3 = U + 115;
            T = i3 % 128;
            if (!(i3 % 2 == 0)) {
                int i4 = 89 / 0;
                return NetworkUserEntityData$$ExternalSyntheticLambda1;
            }
            return NetworkUserEntityData$$ExternalSyntheticLambda1;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void getAuthRequestContext(String str) {
        try {
            int i = U + 1;
            T = i % 128;
            int i2 = i % 2;
            this.MyBillsEntityDataFactory = str;
            try {
                int i3 = T + 47;
                U = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void getCallingPid(String str) {
        int i = U + 125;
        T = i % 128;
        Object[] objArr = null;
        if ((i % 2 != 0 ? 'H' : (char) 27) != 27) {
            this.B = str;
            objArr.hashCode();
        } else {
            try {
                this.B = str;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i2 = T + 47;
            U = i2 % 128;
            if (!(i2 % 2 != 0)) {
                int length = objArr.length;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final String NetworkUserEntityData$$ExternalSyntheticLambda6() {
        int i = U + 97;
        T = i % 128;
        if (!(i % 2 != 0)) {
            return this.VerifyPinStateManager$executeRiskChallenge$2$1;
        }
        String str = this.VerifyPinStateManager$executeRiskChallenge$2$1;
        Object obj = null;
        obj.hashCode();
        return str;
    }

    public final void readMicros(String str) {
        try {
            int i = T + 97;
            U = i % 128;
            if ((i % 2 == 0 ? (char) 15 : '@') == '@') {
                this.VerifyPinStateManager$executeRiskChallenge$2$1 = str;
                return;
            }
            try {
                this.VerifyPinStateManager$executeRiskChallenge$2$1 = str;
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final String NetworkUserEntityData$$ExternalSyntheticLambda5() {
        int i = U + 41;
        T = i % 128;
        int i2 = i % 2;
        String str = this.readMicros;
        int i3 = U + 57;
        T = i3 % 128;
        if (i3 % 2 == 0) {
            return str;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return str;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda5(String str) {
        int i = U + 67;
        T = i % 128;
        boolean z = i % 2 == 0;
        this.readMicros = str;
        if (!z) {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = T + 1;
        U = i2 % 128;
        int i3 = i2 % 2;
    }

    public final String getCallingPid() {
        int i = T + 87;
        U = i % 128;
        int i2 = i % 2;
        try {
            String str = this.H;
            int i3 = T + 81;
            U = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void VerifyPinStateManager$executeRiskChallenge$2$2(String str) {
        int i = U + 67;
        T = i % 128;
        int i2 = i % 2;
        try {
            this.H = str;
            int i3 = T + 13;
            U = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final String NetworkUserEntityData$$ExternalSyntheticLambda3() {
        int i = T + 29;
        U = i % 128;
        int i2 = i % 2;
        String str = this.C;
        try {
            int i3 = T + 31;
            U = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return str;
            }
            Object obj = null;
            obj.hashCode();
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void getSupportButtonTintMode(String str) {
        int i = U + 55;
        T = i % 128;
        if ((i % 2 != 0 ? (char) 6 : (char) 0) != 6) {
            try {
                this.C = str;
            } catch (Exception e) {
                throw e;
            }
        } else {
            try {
                this.C = str;
                int i2 = 86 / 0;
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = T + 99;
        U = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public final void MyBillsEntityDataFactory(int i) {
        try {
            int i2 = T + 111;
            U = i2 % 128;
            int i3 = i2 % 2;
            this.getValueOfTouchPositionAbsolute = i;
            int i4 = U + 63;
            T = i4 % 128;
            if (!(i4 % 2 != 0)) {
                return;
            }
            int i5 = 99 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public final String GetContactSyncConfig() {
        int i = U + 89;
        T = i % 128;
        if (!(i % 2 != 0)) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        }
        try {
            int i2 = 51 / 0;
            return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda8(String str) {
        int i = U + 17;
        T = i % 128;
        char c = i % 2 != 0 ? (char) 22 : '^';
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str;
        if (c != 22) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public final void PlaceComponentResult(int i) {
        int i2 = U + 117;
        T = i2 % 128;
        int i3 = i2 % 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = i;
        int i4 = U + 27;
        T = i4 % 128;
        int i5 = i4 % 2;
    }

    public final String E() {
        int i = T + 51;
        U = i % 128;
        if (i % 2 != 0) {
            return this.S;
        }
        int i2 = 65 / 0;
        return this.S;
    }

    public final void I(String str) {
        int i = U + 47;
        T = i % 128;
        int i2 = i % 2;
        this.S = str;
        try {
            int i3 = T + 41;
            U = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        int i = T + 105;
        U = i % 128;
        int i2 = i % 2;
        String str = this.GetContactSyncConfig;
        int i3 = T + 3;
        U = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda1(String str) {
        int i = U + 91;
        T = i % 128;
        int i2 = i % 2;
        this.GetContactSyncConfig = str;
        int i3 = U + 87;
        T = i3 % 128;
        if ((i3 % 2 != 0 ? JSONLexer.EOI : (char) 31) != 26) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public final void F(String str) {
        int i = T + 117;
        U = i % 128;
        int i2 = i % 2;
        try {
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = str;
            int i3 = U + 99;
            T = i3 % 128;
            if ((i3 % 2 != 0 ? 'M' : '3') != '3') {
                int i4 = 15 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public final String getValueOfTouchPositionAbsolute() {
        int i = U + 101;
        T = i % 128;
        if ((i % 2 != 0 ? (char) 15 : '?') == 15) {
            int i2 = 96 / 0;
            return this.O;
        }
        try {
            return this.O;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void getValueOfTouchPositionAbsolute(String str) {
        int i = U + 59;
        T = i % 128;
        boolean z = i % 2 != 0;
        this.O = str;
        if (!z) {
            return;
        }
        int i2 = 98 / 0;
    }

    public final String BottomSheetCardBindingView$watcherCardNumberView$1() {
        try {
            int i = T + 33;
            U = i % 128;
            int i2 = i % 2;
            String str = this.J;
            int i3 = U + 7;
            T = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 23 : 'W') != 23) {
                return str;
            }
            Object obj = null;
            obj.hashCode();
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void getOnBoardingScenario(String str) {
        try {
            int i = T + 41;
            try {
                U = i % 128;
                if ((i % 2 == 0 ? 'H' : '?') == '?') {
                    this.J = str;
                    return;
                }
                this.J = str;
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final boolean F() {
        int i = U + 57;
        T = i % 128;
        int i2 = i % 2;
        try {
            boolean z = !TextUtils.isEmpty(DatabaseTableConfigUtil());
            int i3 = T + 65;
            U = i3 % 128;
            if ((i3 % 2 != 0 ? 'c' : (char) 2) != 'c') {
                Object[] objArr = null;
                int length = objArr.length;
                return z;
            }
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    public final ShareActivityModel A() {
        int i = U + 57;
        T = i % 128;
        int i2 = i % 2;
        try {
            ShareActivityModel shareActivityModel = this.L;
            int i3 = T + 5;
            U = i3 % 128;
            int i4 = i3 % 2;
            return shareActivityModel;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void PlaceComponentResult(ShareActivityModel shareActivityModel) {
        int i = T + 11;
        U = i % 128;
        if ((i % 2 == 0 ? 'H' : Typography.amp) == '&') {
            this.L = shareActivityModel;
            return;
        }
        this.L = shareActivityModel;
        Object obj = null;
        obj.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        if ((r0 != null) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:
    
        if ((r0 != null ? '+' : '\b') != '+') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
    
        if (r0.getKClassImpl$Data$declaredNonStaticMembers$2() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0036, code lost:
    
        r0 = id.dana.sendmoney.model.ConfirmationModel.T + 13;
        id.dana.sendmoney.model.ConfirmationModel.U = r0 % 128;
        r0 = r0 % 2;
        r0 = id.dana.sendmoney.model.ConfirmationModel.T + 19;
        id.dana.sendmoney.model.ConfirmationModel.U = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean AppCompatEmojiTextHelper() {
        /*
            r5 = this;
            int r0 = id.dana.sendmoney.model.ConfirmationModel.T
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.sendmoney.model.ConfirmationModel.U = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L22
            id.dana.sendmoney.model.ShareActivityModel r0 = r5.L
            r3 = 83
            int r3 = r3 / r2
            if (r0 == 0) goto L1c
            r3 = 1
            goto L1d
        L1c:
            r3 = 0
        L1d:
            if (r3 == 0) goto L4b
            goto L30
        L20:
            r0 = move-exception
            throw r0
        L22:
            id.dana.sendmoney.model.ShareActivityModel r0 = r5.L     // Catch: java.lang.Exception -> L4d
            r3 = 43
            if (r0 == 0) goto L2b
            r4 = 43
            goto L2d
        L2b:
            r4 = 8
        L2d:
            if (r4 == r3) goto L30
            goto L4b
        L30:
            boolean r0 = r0.getKClassImpl$Data$declaredNonStaticMembers$2()
            if (r0 == 0) goto L4b
            int r0 = id.dana.sendmoney.model.ConfirmationModel.T     // Catch: java.lang.Exception -> L4d
            int r0 = r0 + 13
            int r2 = r0 % 128
            id.dana.sendmoney.model.ConfirmationModel.U = r2     // Catch: java.lang.Exception -> L4d
            int r0 = r0 % 2
            int r0 = id.dana.sendmoney.model.ConfirmationModel.T     // Catch: java.lang.Exception -> L4d
            int r0 = r0 + 19
            int r2 = r0 % 128
            id.dana.sendmoney.model.ConfirmationModel.U = r2     // Catch: java.lang.Exception -> L4d
            int r0 = r0 % 2
            goto L4c
        L4b:
            r1 = 0
        L4c:
            return r1
        L4d:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.model.ConfirmationModel.AppCompatEmojiTextHelper():boolean");
    }

    public final void BottomSheetCardBindingView$watcherCardNumberView$1(String str) {
        try {
            int i = T + 91;
            U = i % 128;
            int i2 = i % 2;
            this.G = str;
            int i3 = T + 19;
            U = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final int VerifyPinStateManager$executeRiskChallenge$2$2() {
        int i;
        try {
            int i2 = U + 67;
            try {
                T = i2 % 128;
                if (!(i2 % 2 == 0)) {
                    i = this.SummaryVoucherView$$ExternalSyntheticLambda0;
                    int i3 = 17 / 0;
                } else {
                    i = this.SummaryVoucherView$$ExternalSyntheticLambda0;
                }
                int i4 = U + 7;
                T = i4 % 128;
                int i5 = i4 % 2;
                return i;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void getAuthRequestContext(int i) {
        int i2 = U + 33;
        T = i2 % 128;
        int i3 = i2 % 2;
        try {
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = i;
            int i4 = T + 31;
            U = i4 % 128;
            if (!(i4 % 2 != 0)) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public final boolean I() {
        boolean z;
        int i = U + 101;
        T = i % 128;
        Object obj = null;
        if (!(i % 2 == 0)) {
            z = this.SubSequence;
            obj.hashCode();
        } else {
            z = this.SubSequence;
        }
        try {
            int i2 = U + 65;
            T = i2 % 128;
            if ((i2 % 2 != 0 ? (char) 6 : '\'') != 6) {
                return z;
            }
            obj.hashCode();
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void MyBillsEntityDataFactory(boolean z) {
        int i = U + 25;
        T = i % 128;
        int i2 = i % 2;
        this.SubSequence = z;
        int i3 = U + 31;
        T = i3 % 128;
        int i4 = i3 % 2;
    }

    public final String getOnBoardingScenario() {
        int i = T + 99;
        U = i % 128;
        int i2 = i % 2;
        String str = this.N;
        int i3 = U + 119;
        T = i3 % 128;
        if ((i3 % 2 != 0 ? '%' : (char) 16) != '%') {
            return str;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return str;
    }

    public final void G(String str) {
        try {
            int i = U + 119;
            T = i % 128;
            if ((i % 2 != 0 ? '(' : '2') == '2') {
                this.N = str;
                return;
            }
            this.N = str;
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public final boolean J() {
        int i = U + 95;
        T = i % 128;
        int i2 = i % 2;
        try {
            String str = this.N;
            if (str != null) {
                if (!(str.isEmpty())) {
                    int i3 = U + 15;
                    T = i3 % 128;
                    int i4 = i3 % 2;
                    return true;
                }
            }
            int i5 = T + 75;
            U = i5 % 128;
            int i6 = i5 % 2;
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        int i2 = $10 + 115;
        $11 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? (char) 17 : 'T') != 17) {
                objArr[0] = new String(cArr6);
                return;
            }
            int i4 = $10 + 31;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            int i6 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i7 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i6]) % 65535);
            cArr5[i7] = (char) (((cArr4[i7] * 32718) + cArr5[i6]) / 65535);
            cArr4[i7] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i7] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (SummaryVoucherView$$ExternalSyntheticLambda2 ^ 4360990799332652212L)) ^ ((int) (isAuth ^ 4360990799332652212L))) ^ ((char) (X ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
    }
}
