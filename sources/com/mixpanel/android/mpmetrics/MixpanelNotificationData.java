package com.mixpanel.android.mpmetrics;

import java.util.List;

/* loaded from: classes.dex */
class MixpanelNotificationData {
    List<MixpanelNotificationButtonData> BuiltInFictitiousFunctionClassFactory;
    PushTapAction DatabaseTableConfigUtil;
    String GetContactSyncConfig;
    String NetworkUserEntityData$$ExternalSyntheticLambda0;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    String NetworkUserEntityData$$ExternalSyntheticLambda2;
    int NetworkUserEntityData$$ExternalSyntheticLambda3;
    String NetworkUserEntityData$$ExternalSyntheticLambda7;
    CharSequence NetworkUserEntityData$$ExternalSyntheticLambda8;
    String PlaceComponentResult;
    CharSequence PrepareContext;
    String getErrorConfigVersion;
    boolean initRecordTimeStamp;
    String isLayoutRequested;
    String moveToNextValue;
    String newProxyInstance;
    String scheduleImpl;
    int lookAheadTest = -1;
    int NetworkUserEntityData$$ExternalSyntheticLambda6 = -1;
    int KClassImpl$Data$declaredNonStaticMembers$2 = -1;
    int getAuthRequestContext = -1;
    String MyBillsEntityDataFactory = "mp";

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.initRecordTimeStamp;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    /* loaded from: classes3.dex */
    static class MixpanelNotificationButtonData {
        PushTapAction KClassImpl$Data$declaredNonStaticMembers$2;
        String PlaceComponentResult;
        String getAuthRequestContext;

        public MixpanelNotificationButtonData(String str, PushTapAction pushTapAction, String str2) {
            this.PlaceComponentResult = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = pushTapAction;
            this.getAuthRequestContext = str2;
        }
    }

    /* loaded from: classes3.dex */
    protected static class PushTapAction {
        final String BuiltInFictitiousFunctionClassFactory;
        final PushTapActionType getAuthRequestContext;

        public PushTapAction(PushTapActionType pushTapActionType, String str) {
            this.getAuthRequestContext = pushTapActionType;
            this.BuiltInFictitiousFunctionClassFactory = str;
        }

        public PushTapAction(PushTapActionType pushTapActionType) {
            this(pushTapActionType, null);
        }
    }

    /* loaded from: classes3.dex */
    protected enum PushTapActionType {
        HOMESCREEN("homescreen"),
        URL_IN_BROWSER("browser"),
        DEEP_LINK("deeplink"),
        ERROR("error");

        private String stringVal;

        PushTapActionType(String str) {
            this.stringVal = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.stringVal;
        }

        public static PushTapActionType fromString(String str) {
            for (PushTapActionType pushTapActionType : values()) {
                if (pushTapActionType.toString().equals(str)) {
                    return pushTapActionType;
                }
            }
            return ERROR;
        }
    }
}
