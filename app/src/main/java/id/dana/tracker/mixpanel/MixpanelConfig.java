package id.dana.tracker.mixpanel;

import android.content.Context;
import android.text.TextUtils;
import id.dana.analytics.mixpanel.MixPanelEvent;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.tracker.EventConfig;
import id.dana.tracker.EventConfigProperty;

/* loaded from: classes2.dex */
public class MixpanelConfig implements EventConfig {
    private DeviceInformationProvider BuiltInFictitiousFunctionClassFactory;
    private final EventConfigProperty MyBillsEntityDataFactory;

    @Override // id.dana.tracker.EventConfig
    public final void getAuthRequestContext() {
    }

    public MixpanelConfig(EventConfigProperty eventConfigProperty, DeviceInformationProvider deviceInformationProvider) {
        this.MyBillsEntityDataFactory = eventConfigProperty;
        if (deviceInformationProvider != null) {
            this.BuiltInFictitiousFunctionClassFactory = deviceInformationProvider;
        }
    }

    @Override // id.dana.tracker.EventConfig
    public final void MyBillsEntityDataFactory() {
        String str;
        Context context;
        Context context2;
        String str2;
        String str3;
        if (this.MyBillsEntityDataFactory != null) {
            if (moveToNextValue()) {
                str2 = this.MyBillsEntityDataFactory.PlaceComponentResult.getErrorConfigVersion;
                MixPanelTracker.BuiltInFictitiousFunctionClassFactory(str2);
                MixPanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda0();
                str3 = this.MyBillsEntityDataFactory.PlaceComponentResult.getErrorConfigVersion;
                PlaceComponentResult(str3);
                scheduleImpl();
                String MyBillsEntityDataFactory = MixPanelTracker.MyBillsEntityDataFactory();
                DeviceInformationProvider deviceInformationProvider = this.BuiltInFictitiousFunctionClassFactory;
                if (deviceInformationProvider != null) {
                    deviceInformationProvider.updateUtdIdForMixpanel(MyBillsEntityDataFactory);
                }
            } else {
                str = this.MyBillsEntityDataFactory.PlaceComponentResult.lookAheadTest;
                MixPanelTracker.BuiltInFictitiousFunctionClassFactory(str);
                MixPanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
            context = this.MyBillsEntityDataFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
            if (context != null) {
                context2 = this.MyBillsEntityDataFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                MixPanelTracker.getAuthRequestContext(context2);
            }
        }
    }

    @Override // id.dana.tracker.EventConfig
    public final void PlaceComponentResult() {
        Context context;
        String str;
        String str2;
        String str3;
        if (this.MyBillsEntityDataFactory != null) {
            if (moveToNextValue()) {
                str3 = this.MyBillsEntityDataFactory.PlaceComponentResult.getErrorConfigVersion;
                MixPanelTracker.BuiltInFictitiousFunctionClassFactory(str3);
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                context = this.MyBillsEntityDataFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                str = this.MyBillsEntityDataFactory.PlaceComponentResult.getErrorConfigVersion;
                str2 = this.MyBillsEntityDataFactory.PlaceComponentResult.MyBillsEntityDataFactory;
                MixPanelTracker.PlaceComponentResult(context, str, str2);
            }
        }
    }

    @Override // id.dana.tracker.EventConfig
    public final void BuiltInFictitiousFunctionClassFactory() {
        String str;
        if (this.MyBillsEntityDataFactory == null || !moveToNextValue()) {
            return;
        }
        str = this.MyBillsEntityDataFactory.PlaceComponentResult.getErrorConfigVersion;
        PlaceComponentResult(str);
        scheduleImpl();
    }

    private void PlaceComponentResult(String str) {
        Context context;
        if (MixPanelTracker.PlaceComponentResult.equals(str)) {
            return;
        }
        context = this.MyBillsEntityDataFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
        MixPanelEvent.Builder builder = new MixPanelEvent.Builder(context);
        builder.BuiltInFictitiousFunctionClassFactory = str;
        MixPanelTracker.BuiltInFictitiousFunctionClassFactory(new MixPanelEvent(builder, (byte) 0));
    }

    private boolean moveToNextValue() {
        Context context;
        String str;
        context = this.MyBillsEntityDataFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
        if (context != null) {
            str = this.MyBillsEntityDataFactory.PlaceComponentResult.getErrorConfigVersion;
            if (!TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        String str;
        if (moveToNextValue()) {
            str = this.MyBillsEntityDataFactory.PlaceComponentResult.MyBillsEntityDataFactory;
            if (!TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    private void scheduleImpl() {
        Context context;
        String str;
        String str2;
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            context = this.MyBillsEntityDataFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
            MixPanelEvent.Builder builder = new MixPanelEvent.Builder(context);
            str = this.MyBillsEntityDataFactory.PlaceComponentResult.getErrorConfigVersion;
            builder.BuiltInFictitiousFunctionClassFactory = str;
            str2 = this.MyBillsEntityDataFactory.PlaceComponentResult.MyBillsEntityDataFactory;
            builder.MyBillsEntityDataFactory = str2;
            MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(new MixPanelEvent(builder, (byte) 0));
        }
    }
}
