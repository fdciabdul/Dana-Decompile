package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class zzey {
    final /* synthetic */ zzfd zza;
    private final String zzb;
    private final Bundle zzc;
    private Bundle zzd;

    public zzey(zzfd zzfdVar, String str, Bundle bundle) {
        this.zza = zzfdVar;
        Preconditions.checkNotEmpty("default_event_parameters");
        this.zzb = "default_event_parameters";
        this.zzc = new Bundle();
    }

    public final Bundle zza() {
        char c;
        if (this.zzd == null) {
            String string = this.zza.zza().getString(this.zzb, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString(SecurityConstants.KEY_TEXT);
                            int hashCode = string3.hashCode();
                            if (hashCode == 100) {
                                if (string3.equals(d.f7256a)) {
                                    c = 1;
                                }
                                c = 65535;
                            } else if (hashCode != 108) {
                                if (hashCode == 115 && string3.equals("s")) {
                                    c = 0;
                                }
                                c = 65535;
                            } else {
                                if (string3.equals("l")) {
                                    c = 2;
                                }
                                c = 65535;
                            }
                            if (c == 0) {
                                bundle.putString(string2, jSONObject.getString(SecurityConstants.KEY_VALUE));
                            } else if (c == 1) {
                                bundle.putDouble(string2, Double.parseDouble(jSONObject.getString(SecurityConstants.KEY_VALUE)));
                            } else if (c == 2) {
                                bundle.putLong(string2, Long.parseLong(jSONObject.getString(SecurityConstants.KEY_VALUE)));
                            } else {
                                this.zza.zzs.zzay().zzd().zzb("Unrecognized persisted bundle type. Type", string3);
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.zza.zzs.zzay().zzd().zza("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.zzd = bundle;
                } catch (JSONException unused2) {
                    this.zza.zzs.zzay().zzd().zza("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.zzd == null) {
                this.zzd = this.zzc;
            }
        }
        return this.zzd;
    }

    public final void zzb(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.zza.zza().edit();
        if (bundle.size() == 0) {
            edit.remove(this.zzb);
        } else {
            String str = this.zzb;
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        jSONObject.put(SecurityConstants.KEY_VALUE, obj.toString());
                        if (obj instanceof String) {
                            jSONObject.put(SecurityConstants.KEY_TEXT, "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put(SecurityConstants.KEY_TEXT, "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put(SecurityConstants.KEY_TEXT, d.f7256a);
                        } else {
                            this.zza.zzs.zzay().zzd().zzb("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        this.zza.zzs.zzay().zzd().zzb("Cannot serialize bundle value to SharedPreferences", e);
                    }
                }
            }
            edit.putString(str, jSONArray.toString());
        }
        edit.apply();
        this.zzd = bundle;
    }
}
