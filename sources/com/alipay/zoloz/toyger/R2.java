package com.alipay.zoloz.toyger;

import android.graphics.drawable.GradientDrawable;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.zoloz.config.ConfigCenter;
import com.ap.zoloz.hot.reload.ViewLoadService;
import id.dana.analytics.tracker.TrackerKey;

/* loaded from: classes7.dex */
public class R2 {

    /* loaded from: classes7.dex */
    public static class integer {
    }

    /* loaded from: classes7.dex */
    public static class string {
        public static String zface_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Scan Face" : viewLoadService.getString("zface_title", R.string.zface_title);
        }

        public static String zface_no_face() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "No face detected" : viewLoadService.getString("zface_no_face", R.string.zface_no_face);
        }

        public static String zface_distance_too_far() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Please move closer to the camera" : viewLoadService.getString("zface_distance_too_far", R.string.zface_distance_too_far);
        }

        public static String zface_distance_too_close() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Please move further from the camera" : viewLoadService.getString("zface_distance_too_close", R.string.zface_distance_too_close);
        }

        public static String zface_not_in_center() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "No face detected" : viewLoadService.getString("zface_not_in_center", R.string.zface_not_in_center);
        }

        public static String zface_bad_pitch() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "No face detected" : viewLoadService.getString("zface_bad_pitch", R.string.zface_bad_pitch);
        }

        public static String zface_bad_yaw() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "No face detected" : viewLoadService.getString("zface_bad_yaw", R.string.zface_bad_yaw);
        }

        public static String zface_is_moving() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Photo is unclear" : viewLoadService.getString("zface_is_moving", R.string.zface_is_moving);
        }

        public static String zface_bad_brightness() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Place is too dark" : viewLoadService.getString("zface_bad_brightness", R.string.zface_bad_brightness);
        }

        public static String zface_bad_quality() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "No face detected" : viewLoadService.getString("zface_bad_quality", R.string.zface_bad_quality);
        }

        public static String zface_bad_eye_openness() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Open your eyes" : viewLoadService.getString("zface_bad_eye_openness", R.string.zface_bad_eye_openness);
        }

        public static String zface_blink_openness() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Please blink your eyes to prove you?re not a robot" : viewLoadService.getString("zface_blink_openness", R.string.zface_blink_openness);
        }

        public static String zface_stack_time() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Stay still" : viewLoadService.getString("zface_stack_time", R.string.zface_stack_time);
        }

        public static String zface_processing() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Processing..." : viewLoadService.getString("zface_processing", R.string.zface_processing);
        }

        public static String zface_retry_max_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Exceeded Limit" : viewLoadService.getString("zface_retry_max_title", R.string.zface_retry_max_title);
        }

        public static String zface_retry_max_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "You\\'ve exceeded the maximum number of attempts. Please try again later!" : viewLoadService.getString("zface_retry_max_msg", R.string.zface_retry_max_msg);
        }

        public static String zface_retry_max_got_it() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Got it!" : viewLoadService.getString("zface_retry_max_got_it", R.string.zface_retry_max_got_it);
        }

        public static String zface_user_cancel_stay() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Stay" : viewLoadService.getString("zface_user_cancel_stay", R.string.zface_user_cancel_stay);
        }

        public static String zface_user_cancel_quit() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Quit" : viewLoadService.getString("zface_user_cancel_quit", R.string.zface_user_cancel_quit);
        }

        public static String zface_user_cancel_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Are you sure want to quit?" : viewLoadService.getString("zface_user_cancel_title", R.string.zface_user_cancel_title);
        }

        public static String zface_user_cancel_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "You are almost done, stay to complete?" : viewLoadService.getString("zface_user_cancel_msg", R.string.zface_user_cancel_msg);
        }

        public static String zface_camera_without_permission_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "\"TNG eWallet\" Would Like To Access Your Camera" : viewLoadService.getString("zface_camera_without_permission_title", R.string.zface_camera_without_permission_title);
        }

        public static String zface_camera_without_permission_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "This allows you to take photos in the app." : viewLoadService.getString("zface_camera_without_permission_msg", R.string.zface_camera_without_permission_msg);
        }

        public static String zface_camera_without_permission_go_settings() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "OK" : viewLoadService.getString("zface_camera_without_permission_go_settings", R.string.zface_camera_without_permission_go_settings);
        }

        public static String zface_camera_without_permission_quit() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Don\\'t allow" : viewLoadService.getString("zface_camera_without_permission_quit", R.string.zface_camera_without_permission_quit);
        }

        public static String zface_time_out_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Hey there, good lookin\\'!" : viewLoadService.getString("zface_time_out_title", R.string.zface_time_out_title);
        }

        public static String zface_time_out_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Please position your face within the frame and ensure the place is well-lit." : viewLoadService.getString("zface_time_out_msg", R.string.zface_time_out_msg);
        }

        public static String zface_time_out_retry() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Retry" : viewLoadService.getString("zface_time_out_retry", R.string.zface_time_out_retry);
        }

        public static String zface_time_out_quit() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Close" : viewLoadService.getString("zface_time_out_quit", R.string.zface_time_out_quit);
        }

        public static String zface_scan_fail_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Face Not Detected" : viewLoadService.getString("zface_scan_fail_title", R.string.zface_scan_fail_title);
        }

        public static String zface_scan_fail_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Please position your face within the frame and ensure the place is well-lit." : viewLoadService.getString("zface_scan_fail_msg", R.string.zface_scan_fail_msg);
        }

        public static String zface_scan_fail_retry() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Retry" : viewLoadService.getString("zface_scan_fail_retry", R.string.zface_scan_fail_retry);
        }

        public static String zface_scan_fail_quit() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Close" : viewLoadService.getString("zface_scan_fail_quit", R.string.zface_scan_fail_quit);
        }

        public static String zface_interrupt_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Action Interrupted" : viewLoadService.getString("zface_interrupt_title", R.string.zface_interrupt_title);
        }

        public static String zface_interrupt_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Whoops, your action was interrupted. Please try again!" : viewLoadService.getString("zface_interrupt_msg", R.string.zface_interrupt_msg);
        }

        public static String zface_interrupt_retry() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Retry" : viewLoadService.getString("zface_interrupt_retry", R.string.zface_interrupt_retry);
        }

        public static String zface_interrupt_close() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Close" : viewLoadService.getString("zface_interrupt_close", R.string.zface_interrupt_close);
        }

        public static String zface_camera_init_error_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "This mobile phone may be broken, not supported for face authentication" : viewLoadService.getString("zface_camera_init_error_msg", R.string.zface_camera_init_error_msg);
        }

        public static String zface_camera_init_error_got_it() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Got it" : viewLoadService.getString("zface_camera_init_error_got_it", R.string.zface_camera_init_error_got_it);
        }

        public static String zface_device_unsupport_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "This mobile phone may be broken, not supported for face authentication" : viewLoadService.getString("zface_device_unsupport_msg", R.string.zface_device_unsupport_msg);
        }

        public static String zface_device_unsupport_got_it() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Got it" : viewLoadService.getString("zface_device_unsupport_got_it", R.string.zface_device_unsupport_got_it);
        }

        public static String zface_zoloz_brand() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Powered by ZOLOZ" : viewLoadService.getString("zface_zoloz_brand", R.string.zface_zoloz_brand);
        }

        public static String zface_detect_dialog_first_login() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "For the first time use, please enable Face Scan" : viewLoadService.getString("zface_detect_dialog_first_login", R.string.zface_detect_dialog_first_login);
        }

        public static String zface_detect_dialog_first_login_confirm() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Enable" : viewLoadService.getString("zface_detect_dialog_first_login_confirm", R.string.zface_detect_dialog_first_login_confirm);
        }

        public static String zface_detect_dialog_first_login_cancel() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? TrackerKey.AppUpdateAction.APP_UPDATE_LATER : viewLoadService.getString("zface_detect_dialog_first_login_cancel", R.string.zface_detect_dialog_first_login_cancel);
        }

        public static String zface_head_up() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Slowly raise your head" : viewLoadService.getString("zface_head_up", R.string.zface_head_up);
        }

        public static String zface_head_up_right() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Slowly turn to the top right" : viewLoadService.getString("zface_head_up_right", R.string.zface_head_up_right);
        }

        public static String zface_head_right() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Slowly turn right" : viewLoadService.getString("zface_head_right", R.string.zface_head_right);
        }

        public static String zface_head_right_down() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "\"Slowly turn to the bottom right" : viewLoadService.getString("zface_head_right_down", R.string.zface_head_right_down);
        }

        public static String zface_head_down() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Slowly nod your head" : viewLoadService.getString("zface_head_down", R.string.zface_head_down);
        }

        public static String zface_head_down_left() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Slowly turn to the bottom left" : viewLoadService.getString("zface_head_down_left", R.string.zface_head_down_left);
        }

        public static String zface_head_left() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Slowly turn left" : viewLoadService.getString("zface_head_left", R.string.zface_head_left);
        }

        public static String zface_head_left_up() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Slowly turn to the top left" : viewLoadService.getString("zface_head_left_up", R.string.zface_head_left_up);
        }

        public static String zface_mouth_open() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Open your mouth" : viewLoadService.getString("zface_mouth_open", R.string.zface_mouth_open);
        }
    }

    /* loaded from: classes7.dex */
    public static class color {
        public static int zface_title_text_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -1;
            }
            return viewLoadService.getColor("zface_title_text_color", R.color.zface_title_text_color);
        }

        public static int zface_top_tip_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -12153115;
            }
            return viewLoadService.getColor("zface_top_tip_color", R.color.zface_top_tip_color);
        }

        public static int zface_progress_start_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -3873284;
            }
            return viewLoadService.getColor("zface_progress_start_color", R.color.zface_progress_start_color);
        }

        public static int zface_progress_end_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -15692055;
            }
            return viewLoadService.getColor("zface_progress_end_color", R.color.zface_progress_end_color);
        }

        public static int zface_progress_bg_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -2103573;
            }
            return viewLoadService.getColor("zface_progress_bg_color", R.color.zface_progress_bg_color);
        }
    }

    /* loaded from: classes7.dex */
    public static class bool {
        public static boolean zface_page_can_click_back() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return true;
            }
            return viewLoadService.getBool("zface_page_can_click_back", R.bool.zface_page_can_click_back);
        }
    }

    /* loaded from: classes7.dex */
    public static class drawable {
        public static GradientDrawable zface_titlebar_bg_without_line() {
            ConfigCenter.getInstance().getApplicationContext();
            return new GradientDrawable();
        }
    }

    public static ViewLoadService getViewLoadService() {
        if (BioServiceManager.getCurrentInstance() == null) {
            if (ConfigCenter.getInstance().getApplicationContext() == null) {
                return null;
            }
            return (ViewLoadService) BioServiceManager.getLocalService(ConfigCenter.getInstance().getApplicationContext(), ViewLoadService.class);
        }
        return (ViewLoadService) BioServiceManager.getCurrentInstance().getBioService(ViewLoadService.class);
    }
}
