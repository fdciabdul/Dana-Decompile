package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes7.dex */
public class RegisteredKey extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RegisteredKey> CREATOR = new zzj();
    String zza;
    private final KeyHandle zzb;
    private final String zzc;

    public RegisteredKey(KeyHandle keyHandle) {
        this(keyHandle, null, null);
    }

    public static RegisteredKey parseFromJson(JSONObject jSONObject) throws JSONException {
        return new RegisteredKey(KeyHandle.parseFromJson(jSONObject), jSONObject.has(ClientData.KEY_CHALLENGE) ? jSONObject.getString(ClientData.KEY_CHALLENGE) : null, jSONObject.has("appId") ? jSONObject.getString("appId") : null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RegisteredKey) {
            RegisteredKey registeredKey = (RegisteredKey) obj;
            String str = this.zza;
            if (str == null) {
                if (registeredKey.zza != null) {
                    return false;
                }
            } else if (!str.equals(registeredKey.zza)) {
                return false;
            }
            if (this.zzb.equals(registeredKey.zzb)) {
                String str2 = this.zzc;
                if (str2 == null) {
                    if (registeredKey.zzc != null) {
                        return false;
                    }
                } else if (!str2.equals(registeredKey.zzc)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public String getAppId() {
        return this.zzc;
    }

    public String getChallengeValue() {
        return this.zza;
    }

    public KeyHandle getKeyHandle() {
        return this.zzb;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.zza;
            if (str != null) {
                jSONObject.put(ClientData.KEY_CHALLENGE, str);
            }
            JSONObject zza = this.zzb.zza();
            Iterator<String> keys = zza.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, zza.get(next));
            }
            String str2 = this.zzc;
            if (str2 != null) {
                jSONObject.put("appId", str2);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SignResponseData.JSON_RESPONSE_DATA_KEY_HANDLE, Base64.encodeToString(this.zzb.getBytes(), 11));
            if (this.zzb.getProtocolVersion() != ProtocolVersion.UNKNOWN) {
                jSONObject.put("version", this.zzb.getProtocolVersion().toString());
            }
            if (this.zzb.getTransports() != null) {
                jSONObject.put("transports", this.zzb.getTransports().toString());
            }
            String str = this.zza;
            if (str != null) {
                jSONObject.put(ClientData.KEY_CHALLENGE, str);
            }
            String str2 = this.zzc;
            if (str2 != null) {
                jSONObject.put("appId", str2);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getKeyHandle(), i, false);
        SafeParcelWriter.writeString(parcel, 3, getChallengeValue(), false);
        SafeParcelWriter.writeString(parcel, 4, getAppId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public RegisteredKey(KeyHandle keyHandle, String str, String str2) {
        this.zzb = (KeyHandle) Preconditions.checkNotNull(keyHandle);
        this.zza = str;
        this.zzc = str2;
    }

    public int hashCode() {
        String str = this.zza;
        int hashCode = str == null ? 0 : str.hashCode();
        int hashCode2 = this.zzb.hashCode();
        String str2 = this.zzc;
        return ((((hashCode + 31) * 31) + hashCode2) * 31) + (str2 != null ? str2.hashCode() : 0);
    }
}
