package id.dana.sendmoney.model;

import id.dana.domain.sendmoney.model.TransferParticipant;

/* loaded from: classes5.dex */
public class ConfirmToBankParamModel {
    public String BuiltInFictitiousFunctionClassFactory;
    public String DatabaseTableConfigUtil;
    private String GetContactSyncConfig;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public TransferParticipant NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;
    public String PlaceComponentResult;
    public String getAuthRequestContext;
    public String getErrorConfigVersion;
    public String lookAheadTest;
    public String moveToNextValue;
    public String scheduleImpl;

    /* synthetic */ ConfirmToBankParamModel(byte b) {
        this();
    }

    private ConfirmToBankParamModel() {
    }

    public final boolean getAuthRequestContext() {
        String str = this.DatabaseTableConfigUtil;
        return (str == null || str.isEmpty()) ? false : true;
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        public String BuiltInFictitiousFunctionClassFactory;
        public String DatabaseTableConfigUtil;
        private String GetContactSyncConfig;
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public String MyBillsEntityDataFactory;
        public String NetworkUserEntityData$$ExternalSyntheticLambda0;
        public String PlaceComponentResult;
        public String getAuthRequestContext;
        public TransferParticipant getErrorConfigVersion;
        public String initRecordTimeStamp;
        public String lookAheadTest;
        public String moveToNextValue;
        public String scheduleImpl;

        public final ConfirmToBankParamModel MyBillsEntityDataFactory() {
            ConfirmToBankParamModel confirmToBankParamModel = new ConfirmToBankParamModel((byte) 0);
            confirmToBankParamModel.PlaceComponentResult = this.getAuthRequestContext;
            confirmToBankParamModel.KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            confirmToBankParamModel.BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory;
            confirmToBankParamModel.MyBillsEntityDataFactory = this.MyBillsEntityDataFactory;
            confirmToBankParamModel.moveToNextValue = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            confirmToBankParamModel.lookAheadTest = this.moveToNextValue;
            confirmToBankParamModel.scheduleImpl = this.scheduleImpl;
            confirmToBankParamModel.getErrorConfigVersion = this.lookAheadTest;
            confirmToBankParamModel.getAuthRequestContext = this.PlaceComponentResult;
            confirmToBankParamModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.DatabaseTableConfigUtil;
            confirmToBankParamModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.getErrorConfigVersion;
            confirmToBankParamModel.GetContactSyncConfig = this.GetContactSyncConfig;
            confirmToBankParamModel.DatabaseTableConfigUtil = this.initRecordTimeStamp;
            return confirmToBankParamModel;
        }
    }
}
