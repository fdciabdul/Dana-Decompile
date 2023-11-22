package id.dana.analytics.mixpanel;

import android.content.Context;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.analytics.tracker.EventStrategy;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MixPanelEvent implements EventStrategy {
    protected Builder MyBillsEntityDataFactory;

    public /* synthetic */ MixPanelEvent(Builder builder, byte b) {
        this(builder);
    }

    private MixPanelEvent(Builder builder) {
        this.MyBillsEntityDataFactory = builder;
    }

    public final Context KClassImpl$Data$declaredNonStaticMembers$2() {
        Builder builder = this.MyBillsEntityDataFactory;
        if (builder != null) {
            return builder.PlaceComponentResult;
        }
        return null;
    }

    public final String MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
    }

    public final String BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory;
    }

    public final JSONObject getAuthRequestContext() {
        Builder builder = this.MyBillsEntityDataFactory;
        return builder != null ? builder.getAuthRequestContext : new JSONObject();
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public String BuiltInFictitiousFunctionClassFactory;
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public String MyBillsEntityDataFactory;
        private Context PlaceComponentResult;
        public JSONObject getAuthRequestContext = new JSONObject();

        public Builder(Context context) {
            this.PlaceComponentResult = context;
        }

        public static Builder getAuthRequestContext(Context context) {
            return new Builder(context);
        }

        public final Builder MyBillsEntityDataFactory(Pair<String, Object>[] pairArr) {
            try {
                for (Pair<String, Object> pair : pairArr) {
                    this.getAuthRequestContext.put(pair.getFirst(), pair.getSecond());
                }
            } catch (JSONException e) {
                InstrumentInjector.log_e(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
            }
            return this;
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
            try {
                this.getAuthRequestContext.put(str, str2);
            } catch (JSONException e) {
                InstrumentInjector.log_e(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
            }
            return this;
        }

        public final Builder PlaceComponentResult(String str, Long l) {
            try {
                this.getAuthRequestContext.put(str, l);
            } catch (JSONException e) {
                InstrumentInjector.log_d(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
            }
            return this;
        }

        public final Builder getAuthRequestContext(String str, List<String> list) {
            try {
                this.getAuthRequestContext.put(str, new JSONArray((Collection) list));
            } catch (JSONException e) {
                InstrumentInjector.log_e(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
            }
            return this;
        }
    }

    @Override // id.dana.analytics.tracker.EventStrategy
    public final void PlaceComponentResult() {
        Builder builder = this.MyBillsEntityDataFactory;
        Context context = builder != null ? builder.PlaceComponentResult : null;
        Builder builder2 = this.MyBillsEntityDataFactory;
        String str = builder2 != null ? builder2.KClassImpl$Data$declaredNonStaticMembers$2 : "";
        Builder builder3 = this.MyBillsEntityDataFactory;
        MixPanelDataTracker.PlaceComponentResult(context, str, builder3 != null ? builder3.getAuthRequestContext : new JSONObject());
    }
}
