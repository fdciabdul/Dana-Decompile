package id.dana.tracker.rds;

import id.dana.analytics.tracker.EventStrategy;
import id.dana.data.foundation.logger.rds.RDSEventMapper;
import id.dana.data.foundation.logger.rds.RDSTracker;

/* loaded from: classes5.dex */
public class RDSEvent implements EventStrategy {
    private String BuiltInFictitiousFunctionClassFactory;
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    private String getAuthRequestContext;
    private double lookAheadTest;
    private double scheduleImpl;

    public RDSEvent(String str) {
        this.MyBillsEntityDataFactory = str;
    }

    public RDSEvent(String str, String str2, String str3, boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.PlaceComponentResult = z;
    }

    public RDSEvent(String str, String str2, String str3, String str4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.getAuthRequestContext = str4;
    }

    public RDSEvent(String str, String str2, String str3, double d, double d2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.lookAheadTest = d;
        this.scheduleImpl = d2;
    }

    public RDSEvent(String str, String str2, String str3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
    }

    @Override // id.dana.analytics.tracker.EventStrategy
    public final void PlaceComponentResult() {
        RDSEventMapper rDSEventMapper = new RDSEventMapper();
        rDSEventMapper.BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
        rDSEventMapper.KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory;
        rDSEventMapper.getAuthRequestContext = this.BuiltInFictitiousFunctionClassFactory;
        rDSEventMapper.MyBillsEntityDataFactory = this.PlaceComponentResult;
        rDSEventMapper.PlaceComponentResult = this.getAuthRequestContext;
        rDSEventMapper.lookAheadTest = this.lookAheadTest;
        rDSEventMapper.moveToNextValue = this.scheduleImpl;
        RDSTracker.getAuthRequestContext(rDSEventMapper);
    }
}
