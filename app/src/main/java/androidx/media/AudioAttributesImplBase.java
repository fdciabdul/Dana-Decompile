package androidx.media;

import com.alipay.iap.android.aplog.util.zip.LZMA_Base;
import java.util.Arrays;

/* loaded from: classes6.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {
    int PlaceComponentResult = 0;
    int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    int MyBillsEntityDataFactory = 0;
    int BuiltInFictitiousFunctionClassFactory = -1;

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2), Integer.valueOf(this.MyBillsEntityDataFactory), Integer.valueOf(this.PlaceComponentResult), Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory)});
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplBase) {
            AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == audioAttributesImplBase.KClassImpl$Data$declaredNonStaticMembers$2) {
                int i = this.MyBillsEntityDataFactory;
                int i2 = audioAttributesImplBase.MyBillsEntityDataFactory;
                int i3 = audioAttributesImplBase.BuiltInFictitiousFunctionClassFactory;
                if (i3 == -1) {
                    i3 = AudioAttributesCompat.getAuthRequestContext(false, i2, audioAttributesImplBase.PlaceComponentResult);
                }
                if (i3 == 6) {
                    i2 |= 4;
                } else if (i3 == 7) {
                    i2 |= 1;
                }
                return i == (i2 & LZMA_Base.kMatchMaxLen) && this.PlaceComponentResult == audioAttributesImplBase.PlaceComponentResult && this.BuiltInFictitiousFunctionClassFactory == audioAttributesImplBase.BuiltInFictitiousFunctionClassFactory;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.BuiltInFictitiousFunctionClassFactory != -1) {
            sb.append(" stream=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult));
        sb.append(" content=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.MyBillsEntityDataFactory).toUpperCase());
        return sb.toString();
    }
}
