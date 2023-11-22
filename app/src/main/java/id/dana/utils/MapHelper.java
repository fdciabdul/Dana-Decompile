package id.dana.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.maps.android.SphericalUtil;
import id.dana.drawable.NewShopMarkerHelper;
import id.dana.nearbyme.model.HighlightedShopModel;
import id.dana.nearbyme.model.ShopModel;
import java.util.HashMap;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class MapHelper {
    public Context BuiltInFictitiousFunctionClassFactory;
    public GoogleMap KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    public BitmapDescriptor getAuthRequestContext;
    public MarkerOptions moveToNextValue;
    public LatLngBounds.Builder scheduleImpl;
    private HashMap<String, MarkerOptions> lookAheadTest = new HashMap<>();
    public HashMap<String, MarkerOptions> MyBillsEntityDataFactory = new HashMap<>();
    public HashMap<String, MarkerOptions> getErrorConfigVersion = new HashMap<>();
    public final HashMap<String, BitmapDescriptor> PlaceComponentResult = new HashMap<>();

    @Inject
    public MapHelper(Context context) {
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    public final boolean MyBillsEntityDataFactory(Location location) {
        GoogleMap googleMap = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (googleMap == null || location == null || googleMap.getProjection().getVisibleRegion().latLngBounds.contains(LocationUtil.getAuthRequestContext(location))) ? false : true;
    }

    public static CameraUpdate getAuthRequestContext(LatLng latLng, float f) {
        return CameraUpdateFactory.newLatLngZoom(latLng, f);
    }

    public final MarkerOptions getAuthRequestContext(Location location, Drawable drawable) {
        LatLng authRequestContext = LocationUtil.getAuthRequestContext(location);
        if (this.moveToNextValue == null) {
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                this.moveToNextValue = new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(this.BuiltInFictitiousFunctionClassFactory.getResources(), id.dana.R.drawable.ic_user_indicator))).zIndex(1.0f);
            } else {
                this.moveToNextValue = new MarkerOptions().icon(NewShopMarkerHelper.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, drawable)).zIndex(0.1f);
            }
        }
        this.moveToNextValue.position(authRequestContext);
        return this.moveToNextValue;
    }

    public static BitmapDescriptor MyBillsEntityDataFactory(Bitmap bitmap) {
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    public final MarkerOptions MyBillsEntityDataFactory(String str, Location location, Drawable drawable, String str2, int i) {
        LatLng authRequestContext = LocationUtil.getAuthRequestContext(location);
        String KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str, authRequestContext, drawable, str2, i);
        MarkerOptions markerOptions = this.lookAheadTest.get(KClassImpl$Data$declaredNonStaticMembers$2);
        if (markerOptions == null) {
            MarkerOptions zIndex = new MarkerOptions().position(authRequestContext).icon(BitmapDescriptorFactory.fromBitmap(CustomMarkerUtils.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, drawable, str2, i))).zIndex(0.5f);
            this.lookAheadTest.put(KClassImpl$Data$declaredNonStaticMembers$2, zIndex);
            return zIndex;
        }
        return markerOptions;
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(String str, LatLng latLng, Drawable drawable, String str2, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(latLng.toString());
        sb.append(drawable.toString());
        sb.append(str2);
        sb.append(i);
        return sb.toString();
    }

    public final MarkerOptions BuiltInFictitiousFunctionClassFactory(String str, Location location, int i, Drawable drawable, int i2, int i3) {
        LatLng authRequestContext = LocationUtil.getAuthRequestContext(location);
        String KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str, authRequestContext, drawable, String.valueOf(i + i2), i3);
        MarkerOptions markerOptions = this.MyBillsEntityDataFactory.get(KClassImpl$Data$declaredNonStaticMembers$2);
        if (markerOptions == null) {
            MarkerOptions zIndex = new MarkerOptions().position(authRequestContext).icon(BitmapDescriptorFactory.fromBitmap(CustomMarkerUtils.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, i, drawable, i2, i3))).zIndex(0.1f);
            this.MyBillsEntityDataFactory.put(KClassImpl$Data$declaredNonStaticMembers$2, zIndex);
            return zIndex;
        }
        return markerOptions;
    }

    public static String PlaceComponentResult(Location location, String str, int i, boolean z, boolean z2) {
        int i2 = z ? id.dana.R.layout.view_new_shop_highlight_marker : id.dana.R.layout.view_new_shop_marker;
        String str2 = z2 ? "" : "nolabel";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(LocationUtil.getAuthRequestContext(location).toString());
        sb.append(i2);
        sb.append(str2);
        sb.append(i);
        return sb.toString();
    }

    public final void MyBillsEntityDataFactory(GoogleMap googleMap, GoogleMap.OnMarkerClickListener onMarkerClickListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = googleMap;
        if (googleMap != null) {
            googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this.BuiltInFictitiousFunctionClassFactory, id.dana.R.raw.f47042131886106));
        }
        BuiltInFictitiousFunctionClassFactory(13.0f, 20.0f);
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        googleMap.getUiSettings().setCompassEnabled(false);
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        googleMap.setOnMarkerClickListener(onMarkerClickListener);
    }

    private void BuiltInFictitiousFunctionClassFactory(float f, float f2) {
        GoogleMap googleMap = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (googleMap != null) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                f = 0.0f;
            }
            googleMap.setMinZoomPreference(f);
            GoogleMap googleMap2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                f2 = 21.0f;
            }
            googleMap2.setMaxZoomPreference(f2);
        }
    }

    public static LatLngBounds.Builder PlaceComponentResult(LatLngBounds.Builder builder, LatLng latLng, double d) {
        for (double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE; d2 <= 270.0d; d2 += 90.0d) {
            builder.include(SphericalUtil.computeOffset(latLng, 1000.0d * d, d2));
        }
        return builder;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(Marker marker, Marker marker2, ShopModel shopModel) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            return false;
        }
        ShopModel shopModel2 = (ShopModel) marker.getTag();
        ShopModel shopModel3 = (ShopModel) marker2.getTag();
        if (shopModel2 == null || shopModel3 == null) {
            return false;
        }
        return PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getProjection().toScreenLocation(marker.getPosition()), this.KClassImpl$Data$declaredNonStaticMembers$2.getProjection().toScreenLocation(marker2.getPosition()), shopModel2, shopModel3, shopModel);
    }

    private Rect PlaceComponentResult(Point point, ShopModel shopModel, boolean z) {
        int PlaceComponentResult;
        int authRequestContext = NewShopMarkerHelper.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, shopModel.MyBillsEntityDataFactory(), z);
        if (!z) {
            PlaceComponentResult = NewShopMarkerHelper.MyBillsEntityDataFactory();
        } else {
            PlaceComponentResult = NewShopMarkerHelper.PlaceComponentResult();
        }
        int i = point.x - (authRequestContext / 2);
        return new Rect(i, point.y - PlaceComponentResult, authRequestContext + i, point.y);
    }

    public final void MyBillsEntityDataFactory(Marker marker, HighlightedShopModel highlightedShopModel, Marker marker2, boolean z) {
        ShopModel shopModel = (ShopModel) marker.getTag();
        if (shopModel == null) {
            return;
        }
        if (highlightedShopModel != null && marker2 != null && highlightedShopModel.MyBillsEntityDataFactory.BottomSheetCardBindingView$watcherCardNumberView$1.equals(shopModel.BottomSheetCardBindingView$watcherCardNumberView$1)) {
            marker2.setIcon(getAuthRequestContext(shopModel, true, !z));
        } else {
            marker.setIcon(getAuthRequestContext(shopModel, false, !z));
        }
    }

    private boolean PlaceComponentResult(Point point, Point point2, ShopModel shopModel, ShopModel shopModel2, ShopModel shopModel3) {
        return Rect.intersects(PlaceComponentResult(point, shopModel, shopModel3 != null && shopModel.BuiltInFictitiousFunctionClassFactory(shopModel3.BottomSheetCardBindingView$watcherCardNumberView$1)), PlaceComponentResult(point2, shopModel2, shopModel3 != null && shopModel2.BuiltInFictitiousFunctionClassFactory(shopModel3.BottomSheetCardBindingView$watcherCardNumberView$1)));
    }

    private BitmapDescriptor getAuthRequestContext(ShopModel shopModel, boolean z, boolean z2) {
        BitmapDescriptor KClassImpl$Data$declaredNonStaticMembers$2;
        String PlaceComponentResult = PlaceComponentResult(LocationUtil.PlaceComponentResult(shopModel.DatabaseTableConfigUtil, shopModel.PrepareContext), shopModel.BottomSheetCardBindingView$watcherCardNumberView$1, shopModel.whenAvailable, z, z2);
        BitmapDescriptor bitmapDescriptor = this.PlaceComponentResult.get(PlaceComponentResult);
        if (bitmapDescriptor == null) {
            if (z) {
                KClassImpl$Data$declaredNonStaticMembers$2 = NewShopMarkerHelper.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, shopModel, z2);
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2 = NewShopMarkerHelper.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, shopModel, z2);
            }
            BitmapDescriptor bitmapDescriptor2 = KClassImpl$Data$declaredNonStaticMembers$2;
            this.PlaceComponentResult.put(PlaceComponentResult, bitmapDescriptor2);
            return bitmapDescriptor2;
        }
        return bitmapDescriptor;
    }
}
