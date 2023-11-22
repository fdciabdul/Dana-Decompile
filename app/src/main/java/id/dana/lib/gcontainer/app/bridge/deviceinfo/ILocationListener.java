package id.dana.lib.gcontainer.app.bridge.deviceinfo;

import android.content.Context;
import id.dana.lib.gcontainer.app.bridge.deviceinfo.DeviceInfo;

/* loaded from: classes2.dex */
public interface ILocationListener {
    DeviceInfo.Gps getLatestLocation(Context context);
}
