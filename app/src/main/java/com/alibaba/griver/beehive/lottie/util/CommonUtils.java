package com.alibaba.griver.beehive.lottie.util;

import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.alibaba.griver.beehive.lottie.player.DynamicLayerModel;
import com.alibaba.griver.beehive.lottie.player.PlaceholderZoneModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class CommonUtils {
    public static void updateLocalVideoUrl() {
    }

    public static boolean pointInRect(MotionEvent motionEvent, RectF rectF) {
        if (rectF == null || motionEvent == null) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return x >= rectF.left && x <= rectF.right && y >= rectF.top && y <= rectF.bottom;
    }

    public static RectF mapRect(RectF rectF, ImageView imageView) {
        if (imageView == null || rectF == null) {
            return null;
        }
        RectF rectF2 = new RectF();
        if (imageView.getImageMatrix().mapRect(rectF2, rectF)) {
            return rectF2;
        }
        return null;
    }

    public static DynamicLayerModel getDynamicLayerModelByLayerid(List<DynamicLayerModel> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (DynamicLayerModel dynamicLayerModel : list) {
            if (TextUtils.equals(str, dynamicLayerModel.layerId)) {
                return dynamicLayerModel;
            }
        }
        return null;
    }

    public static List<PlaceholderZoneModel> getClickPlaceholdZoneModelList(List<DynamicLayerModel> list, ImageView imageView) {
        ArrayList arrayList = null;
        if (list != null && list.size() > 0) {
            for (DynamicLayerModel dynamicLayerModel : list) {
                if (TextUtils.equals(dynamicLayerModel.forAim, "image") && TextUtils.equals(dynamicLayerModel.type, DynamicLayerModel.TYPE_CLICK)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(new PlaceholderZoneModel(dynamicLayerModel.getLayerId(), mapRect(dynamicLayerModel.getRect(), imageView), dynamicLayerModel.getDynamicLayerAction()));
                }
            }
        }
        return arrayList;
    }

    public static List<PlaceholderZoneModel> getTimerPlaceholderZoneModel(List<DynamicLayerModel> list, ImageView imageView) {
        ArrayList arrayList = null;
        if (list != null && list.size() > 0) {
            for (DynamicLayerModel dynamicLayerModel : list) {
                if (TextUtils.equals(dynamicLayerModel.forAim, "image") && TextUtils.equals(dynamicLayerModel.type, "timer")) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(new PlaceholderZoneModel(dynamicLayerModel.getLayerId(), mapRect(dynamicLayerModel.getRect(), imageView), dynamicLayerModel.getTimerParams()));
                }
            }
        }
        return arrayList;
    }

    public static List<PlaceholderZoneModel> getVideoPlaceholderZoneModel(List<DynamicLayerModel> list, ImageView imageView) {
        if (list != null) {
            list.size();
            return null;
        }
        return null;
    }

    public static List<DynamicLayerModel> getTimerZoneModel(List<DynamicLayerModel> list) {
        ArrayList arrayList = null;
        if (list != null && list.size() > 0) {
            for (DynamicLayerModel dynamicLayerModel : list) {
                if (TextUtils.equals(dynamicLayerModel.forAim, DynamicLayerModel.FOR_ANIMATION) && TextUtils.equals(dynamicLayerModel.type, "timer")) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(dynamicLayerModel);
                }
            }
        }
        return arrayList;
    }

    public static List<DynamicLayerModel> getVideoZoneModel(List<DynamicLayerModel> list) {
        ArrayList arrayList = null;
        if (list != null && list.size() > 0) {
            for (DynamicLayerModel dynamicLayerModel : list) {
                if (TextUtils.equals(dynamicLayerModel.forAim, DynamicLayerModel.FOR_ANIMATION) && TextUtils.equals(dynamicLayerModel.type, "video")) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(dynamicLayerModel);
                }
            }
        }
        return arrayList;
    }

    public static String getUrlByLayerId(String str, List<DynamicLayerModel> list) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return null;
        }
        for (DynamicLayerModel dynamicLayerModel : list) {
            if (TextUtils.equals(dynamicLayerModel.layerId, str)) {
                if (dynamicLayerModel.dynamicLayerAction != null) {
                    return dynamicLayerModel.dynamicLayerAction.actionUrl;
                }
                return null;
            }
        }
        return null;
    }

    public static boolean getHasClickLayer(List<DynamicLayerModel> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        Iterator<DynamicLayerModel> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().type, DynamicLayerModel.TYPE_CLICK)) {
                return true;
            }
        }
        return false;
    }

    public static boolean getHasCountDownLayer(List<DynamicLayerModel> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (DynamicLayerModel dynamicLayerModel : list) {
            if (TextUtils.equals(dynamicLayerModel.type, "timer") && TextUtils.equals(dynamicLayerModel.forAim, DynamicLayerModel.FOR_ANIMATION)) {
                return true;
            }
        }
        return false;
    }

    public static boolean getHasVideoLayer(List<DynamicLayerModel> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (DynamicLayerModel dynamicLayerModel : list) {
            if (TextUtils.equals(dynamicLayerModel.type, "video") && TextUtils.equals(dynamicLayerModel.forAim, DynamicLayerModel.FOR_ANIMATION)) {
                return true;
            }
        }
        return false;
    }

    public static String resetSizeByDesnity(String str, float f) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            ArrayList<String> arrayList = new ArrayList();
            Matcher matcher = Pattern.compile("size=\"\\d+\"").matcher(str);
            while (matcher.find()) {
                arrayList.add(matcher.group());
            }
            if (arrayList.size() > 0) {
                for (String str2 : arrayList) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("size=\"");
                    sb.append((int) (Integer.valueOf(str2.split("\"")[1]).intValue() / f));
                    sb.append("\"");
                    str = str.replace(str2, sb.toString());
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public static String resetSize(String str, float f) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            ArrayList<String> arrayList = new ArrayList();
            Matcher matcher = Pattern.compile("size=\"\\d+\"").matcher(str);
            while (matcher.find()) {
                arrayList.add(matcher.group());
            }
            if (arrayList.size() > 0) {
                for (String str2 : arrayList) {
                    int floor = (int) Math.floor(Integer.valueOf(str2.split("\"")[1]).intValue() / f);
                    StringBuilder sb = new StringBuilder();
                    sb.append("size=\"");
                    sb.append(floor);
                    sb.append("\"");
                    str = str.replace(str2, sb.toString());
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }
}
