package id.dana.tracker;

import android.content.Context;
import android.text.TextUtils;
import id.dana.DanaApplication;
import id.dana.analytics.tracker.EventStrategy;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.util.ConnectivityUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes.dex */
public class EventTrackerModel {
    public Builder getAuthRequestContext;

    public /* synthetic */ EventTrackerModel(Builder builder, byte b) {
        this(builder);
    }

    private EventTrackerModel(Builder builder) {
        this.getAuthRequestContext = builder;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private Context BuiltInFictitiousFunctionClassFactory;
        private EventPropertiesModel KClassImpl$Data$declaredNonStaticMembers$2;
        public String MyBillsEntityDataFactory;
        private List<EventStrategy> PlaceComponentResult;

        public static /* synthetic */ String BuiltInFictitiousFunctionClassFactory(Builder builder) {
            return builder.MyBillsEntityDataFactory;
        }

        public static /* synthetic */ EventPropertiesModel MyBillsEntityDataFactory(Builder builder) {
            return builder.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public static Builder PlaceComponentResult(Context context) {
            return new Builder(context);
        }

        public Builder(Context context) {
            this.BuiltInFictitiousFunctionClassFactory = context;
            EventPropertiesModel eventPropertiesModel = new EventPropertiesModel();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = eventPropertiesModel;
            if (context != null) {
                eventPropertiesModel.BuiltInFictitiousFunctionClassFactory = context;
            }
        }

        public final Builder BuiltInFictitiousFunctionClassFactory(Map<String, String> map) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(map);
            return this;
        }

        public final Builder MyBillsEntityDataFactory(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.put(str, str2);
                } catch (JSONException e) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
                }
            }
            return this;
        }

        public final Builder PlaceComponentResult(String str, int i) {
            EventPropertiesModel eventPropertiesModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
            try {
                eventPropertiesModel.MyBillsEntityDataFactory.put(str, Integer.valueOf(i));
            } catch (JSONException e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
            }
            return this;
        }

        public final Builder BuiltInFictitiousFunctionClassFactory(String str, long j) {
            EventPropertiesModel eventPropertiesModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
            try {
                eventPropertiesModel.MyBillsEntityDataFactory.put(str, Long.valueOf(j));
            } catch (JSONException e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
            }
            return this;
        }

        public final Builder MyBillsEntityDataFactory(String str, double d) {
            EventPropertiesModel eventPropertiesModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
            try {
                eventPropertiesModel.MyBillsEntityDataFactory.put(str, Double.valueOf(d));
            } catch (JSONException e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
            }
            return this;
        }

        public final Builder BuiltInFictitiousFunctionClassFactory(String str, boolean z) {
            EventPropertiesModel eventPropertiesModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
            try {
                eventPropertiesModel.MyBillsEntityDataFactory.put(str, Boolean.valueOf(z));
            } catch (JSONException e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
            }
            return this;
        }

        public final Builder BuiltInFictitiousFunctionClassFactory(String str, List<?> list) {
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.put(str, list);
            } catch (JSONException e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
            }
            return this;
        }

        public final Builder BuiltInFictitiousFunctionClassFactory() {
            Context context = this.BuiltInFictitiousFunctionClassFactory;
            if (context instanceof DanaApplication) {
                try {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.put(TrackerKey.Property.NETWORK_TYPE, ConnectivityUtil.formatConnectionType(((DanaApplication) context).getNetworkType()));
                } catch (JSONException e) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
                }
            }
            return this;
        }

        public final void PlaceComponentResult() {
            ArrayList arrayList = new ArrayList();
            this.PlaceComponentResult = arrayList;
            arrayList.addAll(EventFactory.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }
}
