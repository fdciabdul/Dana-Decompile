package j$.time.format;

import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;

/* loaded from: classes.dex */
public abstract /* synthetic */ class SignStyle$EnumUnboxingLocalUtility {
    public static final /* synthetic */ int[] MyBillsEntityDataFactory = {1, 2, 3, 4, 5};

    public static /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        int[] iArr = new int[i];
        System.arraycopy(MyBillsEntityDataFactory, 0, iArr, 0, i);
        return iArr;
    }

    public static /* synthetic */ String MyBillsEntityDataFactory(int i) {
        return i == 1 ? "NORMAL" : i == 2 ? CdpSpaceInfo.UPDATE_POLICY_ALWAYS : i == 3 ? "NEVER" : i == 4 ? "NOT_NEGATIVE" : i == 5 ? "EXCEEDS_PAD" : "null";
    }

    public static /* synthetic */ int getAuthRequestContext(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }
}
