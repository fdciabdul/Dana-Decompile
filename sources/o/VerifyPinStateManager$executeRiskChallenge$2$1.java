package o;

/* loaded from: classes.dex */
public class VerifyPinStateManager$executeRiskChallenge$2$1 {
    public int BuiltInFictitiousFunctionClassFactory;
    public int PlaceComponentResult;
    public int getAuthRequestContext;

    public static void PlaceComponentResult(int[] iArr) {
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(iArr.length - i) - 1];
            iArr[(iArr.length - i) - 1] = i2;
        }
    }

    public static int getAuthRequestContext(int i) {
        NetworkUserEntityData$$ExternalSyntheticLambda5 networkUserEntityData$$ExternalSyntheticLambda5 = NetworkUserEntityData$$ExternalSyntheticLambda5.getAuthRequestContext;
        return ((networkUserEntityData$$ExternalSyntheticLambda5.KClassImpl$Data$declaredNonStaticMembers$2[0][(i >>> 24) & 255] + networkUserEntityData$$ExternalSyntheticLambda5.KClassImpl$Data$declaredNonStaticMembers$2[1][(i >>> 16) & 255]) ^ networkUserEntityData$$ExternalSyntheticLambda5.KClassImpl$Data$declaredNonStaticMembers$2[2][(i >>> 8) & 255]) + networkUserEntityData$$ExternalSyntheticLambda5.KClassImpl$Data$declaredNonStaticMembers$2[3][i & 255];
    }
}
