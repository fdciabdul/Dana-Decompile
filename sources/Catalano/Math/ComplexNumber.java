package Catalano.Math;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.huawei.hms.opendevice.i;

/* loaded from: classes6.dex */
public class ComplexNumber {
    public double PlaceComponentResult;
    public double getAuthRequestContext;

    public ComplexNumber() {
        this((byte) 0);
    }

    private ComplexNumber(byte b) {
        this.PlaceComponentResult = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.getAuthRequestContext = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public String toString() {
        if (this.getAuthRequestContext >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.PlaceComponentResult);
            sb.append(" +");
            sb.append(this.getAuthRequestContext);
            sb.append(i.MyBillsEntityDataFactory);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.PlaceComponentResult);
        sb2.append(" ");
        sb2.append(this.getAuthRequestContext);
        sb2.append(i.MyBillsEntityDataFactory);
        return sb2.toString();
    }
}
