package com.google.maps.android;

import com.google.android.gms.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/google/maps/android/StreetViewUtils;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class StreetViewUtils {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lcom/google/maps/android/StreetViewUtils$Companion;", "", "", "responseString", "Lcom/google/maps/android/ResponseStreetView;", "deserializeResponse", "(Ljava/lang/String;)Lcom/google/maps/android/ResponseStreetView;", "Lcom/google/android/gms/maps/model/LatLng;", "latLng", "apiKey", "Lcom/google/maps/android/Status;", "fetchStreetViewData", "(Lcom/google/android/gms/maps/model/LatLng;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object fetchStreetViewData(LatLng latLng, String str, Continuation<? super Status> continuation) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://maps.googleapis.com/maps/api/streetview/metadata?location=");
            sb.append(latLng.latitude);
            sb.append(',');
            sb.append(latLng.longitude);
            sb.append("&key=");
            sb.append(str);
            return BuildersKt.withContext(Dispatchers.getIO(), new StreetViewUtils$Companion$fetchStreetViewData$2(sb.toString(), null), continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ResponseStreetView deserializeResponse(String responseString) {
            String optString = new JSONObject(responseString).optString("status");
            Intrinsics.checkNotNullExpressionValue(optString, "");
            return new ResponseStreetView(Status.valueOf(optString));
        }
    }
}
