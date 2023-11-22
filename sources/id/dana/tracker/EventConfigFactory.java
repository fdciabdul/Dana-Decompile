package id.dana.tracker;

import id.dana.data.config.DeviceInformationProvider;
import id.dana.tracker.appsflyer.AppsflyerConfig;
import id.dana.tracker.branch.BranchConfig;
import id.dana.tracker.constant.TrackerType;
import id.dana.tracker.fullstory.FullstoryConfig;
import id.dana.tracker.mixpanel.MixpanelConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class EventConfigFactory {
    private EventConfigFactory() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static List<EventConfig> getAuthRequestContext(EventConfigProperty eventConfigProperty, DeviceInformationProvider deviceInformationProvider, String... strArr) {
        char c;
        EventConfig appsflyerConfig;
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            switch (str.hashCode()) {
                case -1658513466:
                    if (str.equals(TrackerType.FULLSTORY)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1381030494:
                    if (str.equals(TrackerType.BRANCH)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1066664664:
                    if (str.equals(TrackerType.MIXPANEL)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 770434801:
                    if (str.equals(TrackerType.APPSFLYER)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                appsflyerConfig = new AppsflyerConfig(eventConfigProperty);
            } else if (c == 1) {
                appsflyerConfig = new BranchConfig(eventConfigProperty);
            } else if (c == 2) {
                appsflyerConfig = new FullstoryConfig(eventConfigProperty);
            } else {
                appsflyerConfig = new MixpanelConfig(eventConfigProperty, deviceInformationProvider);
            }
            arrayList.add(appsflyerConfig);
        }
        return arrayList;
    }
}
