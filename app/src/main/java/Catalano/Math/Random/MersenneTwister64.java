package Catalano.Math.Random;

import com.alibaba.wireless.security.SecExceptionCode;

/* loaded from: classes6.dex */
public class MersenneTwister64 implements IRandomNumberGenerator {
    private static final long[] BuiltInFictitiousFunctionClassFactory = {0, -5403634167711393303L};
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private long[] MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;

    public MersenneTwister64() {
        this((byte) 0);
    }

    private MersenneTwister64(byte b) {
        long[] jArr = new long[SecExceptionCode.SEC_ERROR_STA_LOW_VERSION_DATA_FILE];
        this.MyBillsEntityDataFactory = jArr;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 313;
        int i = 1;
        this.PlaceComponentResult = true;
        jArr[0] = 777078800230351907L;
        while (true) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            if (i >= 312) {
                return;
            }
            long[] jArr2 = this.MyBillsEntityDataFactory;
            int i2 = i - 1;
            jArr2[i] = ((jArr2[i2] ^ (jArr2[i2] >>> 62)) * 6364136223846793005L) + i;
            i++;
        }
    }
}
