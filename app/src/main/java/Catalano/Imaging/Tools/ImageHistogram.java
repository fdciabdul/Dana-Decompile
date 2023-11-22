package Catalano.Imaging.Tools;

import Catalano.Statistics.HistogramStatistics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class ImageHistogram {
    private double BuiltInFictitiousFunctionClassFactory;
    public int[] KClassImpl$Data$declaredNonStaticMembers$2;
    private double MyBillsEntityDataFactory;
    private long NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    private int PlaceComponentResult;
    private double getAuthRequestContext;
    private double getErrorConfigVersion;
    private int lookAheadTest;
    private double moveToNextValue;

    public ImageHistogram(int[] iArr) {
        this.MyBillsEntityDataFactory = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.getErrorConfigVersion = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.BuiltInFictitiousFunctionClassFactory = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.getAuthRequestContext = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.moveToNextValue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        this.PlaceComponentResult = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        while (true) {
            int[] iArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i < iArr2.length) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 += iArr2[i];
                i++;
            } else {
                double BuiltInFictitiousFunctionClassFactory = HistogramStatistics.BuiltInFictitiousFunctionClassFactory(iArr2);
                this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
                double authRequestContext = HistogramStatistics.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory);
                this.getErrorConfigVersion = authRequestContext;
                this.getAuthRequestContext = HistogramStatistics.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, authRequestContext);
                this.moveToNextValue = HistogramStatistics.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.getErrorConfigVersion);
                this.PlaceComponentResult = HistogramStatistics.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
                this.lookAheadTest = HistogramStatistics.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
                this.BuiltInFictitiousFunctionClassFactory = HistogramStatistics.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
                return;
            }
        }
    }
}
