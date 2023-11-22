package com.zoloz.android.phone.zdoc;

import android.graphics.drawable.Drawable;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.zoloz.config.ConfigCenter;
import com.ap.zoloz.hot.reload.ViewLoadService;

/* loaded from: classes8.dex */
public class R2 {

    /* loaded from: classes8.dex */
    public static class integer {
    }

    /* loaded from: classes8.dex */
    public static class string {
        public static String zdoc_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "???Take a Photo of Your ID" : viewLoadService.getString("zdoc_title", R.string.zdoc_title);
        }

        public static String zdoc_processing() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Processing?" : viewLoadService.getString("zdoc_processing", R.string.zdoc_processing);
        }

        public static String zdoc_success() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Submit completed!" : viewLoadService.getString("zdoc_success", R.string.zdoc_success);
        }

        public static String zdoc_capture() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "" : viewLoadService.getString("zdoc_capture", R.string.zdoc_capture);
        }

        public static String zdoc_confirm() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "" : viewLoadService.getString("zdoc_confirm", R.string.zdoc_confirm);
        }

        public static String zdoc_no_document_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "ID not found" : viewLoadService.getString("zdoc_no_document_title", R.string.zdoc_no_document_title);
        }

        public static String zdoc_no_document_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Make sure you are taking a picture of specified ID" : viewLoadService.getString("zdoc_no_document_msg", R.string.zdoc_no_document_msg);
        }

        public static String zdoc_wrong_document_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "ID type is wrong" : viewLoadService.getString("zdoc_wrong_document_title", R.string.zdoc_wrong_document_title);
        }

        public static String zdoc_wrong_document_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Make sure you are using your specified type of ID" : viewLoadService.getString("zdoc_wrong_document_msg", R.string.zdoc_wrong_document_msg);
        }

        public static String zdoc_noface_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "No face photo on ID" : viewLoadService.getString("zdoc_noface_title", R.string.zdoc_noface_title);
        }

        public static String zdoc_noface_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Make sure your photo on ID can be clearly seen and has no glare" : viewLoadService.getString("zdoc_noface_msg", R.string.zdoc_noface_msg);
        }

        public static String zdoc_unknow_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "ID photo is not clear" : viewLoadService.getString("zdoc_unknow_title", R.string.zdoc_unknow_title);
        }

        public static String zdoc_unknow_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Make sure your ID can be clearly seen and has no glare" : viewLoadService.getString("zdoc_unknow_msg", R.string.zdoc_unknow_msg);
        }

        public static String zdoc_imperfect_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "ID is incomplete" : viewLoadService.getString("zdoc_imperfect_title", R.string.zdoc_imperfect_title);
        }

        public static String zdoc_imperfect_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Make sure your ID can be clearly seen and is complete" : viewLoadService.getString("zdoc_imperfect_msg", R.string.zdoc_imperfect_msg);
        }

        public static String zdoc_blur_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "ID photo is not clear" : viewLoadService.getString("zdoc_blur_title", R.string.zdoc_blur_title);
        }

        public static String zdoc_blur_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Make sure your ID can be clearly seen and has no glare" : viewLoadService.getString("zdoc_blur_msg", R.string.zdoc_blur_msg);
        }

        public static String zdoc_exposure_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "ID photo is not clear" : viewLoadService.getString("zdoc_exposure_title", R.string.zdoc_exposure_title);
        }

        public static String zdoc_exposure_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Make sure your ID can be clearly seen and has no glare" : viewLoadService.getString("zdoc_exposure_msg", R.string.zdoc_exposure_msg);
        }

        public static String zdoc_expired_document_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "" : viewLoadService.getString("zdoc_expired_document_title", R.string.zdoc_expired_document_title);
        }

        public static String zdoc_expired_document_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "" : viewLoadService.getString("zdoc_expired_document_msg", R.string.zdoc_expired_document_msg);
        }

        public static String zdoc_user_cancel_stay() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Stay" : viewLoadService.getString("zdoc_user_cancel_stay", R.string.zdoc_user_cancel_stay);
        }

        public static String zdoc_user_cancel_quit() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Leave" : viewLoadService.getString("zdoc_user_cancel_quit", R.string.zdoc_user_cancel_quit);
        }

        public static String zdoc_user_cancel_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Will you leave or stay?" : viewLoadService.getString("zdoc_user_cancel_title", R.string.zdoc_user_cancel_title);
        }

        public static String zdoc_user_cancel_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Please stay to have a quick verification." : viewLoadService.getString("zdoc_user_cancel_msg", R.string.zdoc_user_cancel_msg);
        }

        public static String zdoc_dialog_retry() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Retry" : viewLoadService.getString("zdoc_dialog_retry", R.string.zdoc_dialog_retry);
        }

        public static String zdoc_dialog_close() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Close" : viewLoadService.getString("zdoc_dialog_close", R.string.zdoc_dialog_close);
        }

        public static String zdoc_camera_permission_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "?GCash? would like to access your camera" : viewLoadService.getString("zdoc_camera_permission_title", R.string.zdoc_camera_permission_title);
        }

        public static String zdoc_camera_permission_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "GCash wants to access your camera" : viewLoadService.getString("zdoc_camera_permission_msg", R.string.zdoc_camera_permission_msg);
        }

        public static String zdoc_camera_permission_settings() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "OK" : viewLoadService.getString("zdoc_camera_permission_settings", R.string.zdoc_camera_permission_settings);
        }

        public static String zdoc_camera_permission_not_allow() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Don\\'t allow" : viewLoadService.getString("zdoc_camera_permission_not_allow", R.string.zdoc_camera_permission_not_allow);
        }

        public static String zdoc_retry_max_got_it() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Got it" : viewLoadService.getString("zdoc_retry_max_got_it", R.string.zdoc_retry_max_got_it);
        }

        public static String zdoc_retry_max_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Attempt limit reached" : viewLoadService.getString("zdoc_retry_max_title", R.string.zdoc_retry_max_title);
        }

        public static String zdoc_retry_max_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "You\\'ve reached the maximum number of attempts. Please try again later" : viewLoadService.getString("zdoc_retry_max_msg", R.string.zdoc_retry_max_msg);
        }

        public static String zdoc_submit() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Submit" : viewLoadService.getString("zdoc_submit", R.string.zdoc_submit);
        }

        public static String zdoc_retry() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Retake" : viewLoadService.getString("zdoc_retry", R.string.zdoc_retry);
        }

        public static String alert_timeout_error_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Tip: Ensure your document can be seen clearly and avoid reflection" : viewLoadService.getString("alert_timeout_error_msg", R.string.alert_timeout_error_msg);
        }

        public static String alert_interrupt_error_title() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Verification Interrupted" : viewLoadService.getString("alert_interrupt_error_title", R.string.alert_interrupt_error_title);
        }

        public static String alert_interrupt_error_msg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Please continue to verify document" : viewLoadService.getString("alert_interrupt_error_msg", R.string.alert_interrupt_error_msg);
        }

        public static String zoloz_brand() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Powered by ZOLOZ" : viewLoadService.getString("zoloz_brand", R.string.zoloz_brand);
        }

        public static String main_message_default_front() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Take a photo of the FRONT of the ID" : viewLoadService.getString("main_message_default_front", R.string.main_message_default_front);
        }

        public static String main_message_default_back() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Now take a photo of the BACK of the ID" : viewLoadService.getString("main_message_default_back", R.string.main_message_default_back);
        }

        public static String main_message_default() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Place your ID within the frame" : viewLoadService.getString("main_message_default", R.string.main_message_default);
        }

        public static String main_big_frame_msg_default() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "" : viewLoadService.getString("main_big_frame_msg_default", R.string.main_big_frame_msg_default);
        }

        public static String main_big_frame_msg_default_front() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Take a photo of the FRONT of the ID" : viewLoadService.getString("main_big_frame_msg_default_front", R.string.main_big_frame_msg_default_front);
        }

        public static String main_big_frame_msg_default_back() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            return viewLoadService == null ? "Now take a photo of the BACK of the ID" : viewLoadService.getString("main_big_frame_msg_default_back", R.string.main_big_frame_msg_default_back);
        }
    }

    /* loaded from: classes8.dex */
    public static class color {
        public static int zdoc_line_color_light() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -15167233;
            }
            return viewLoadService.getColor("zdoc_line_color_light", R.color.zdoc_line_color_light);
        }

        public static int zdoc_line_cornor_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -14512138;
            }
            return viewLoadService.getColor("zdoc_line_cornor_color", R.color.zdoc_line_cornor_color);
        }

        public static int z_black_60() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -1728053248;
            }
            return viewLoadService.getColor("z_black_60", R.color.z_black_60);
        }

        public static int z_blue() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -16740635;
            }
            return viewLoadService.getColor("z_blue", R.color.z_blue);
        }

        public static int z_white_50() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -2130706433;
            }
            return viewLoadService.getColor("z_white_50", R.color.z_white_50);
        }

        public static int z_grey() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -7829368;
            }
            return viewLoadService.getColor("z_grey", R.color.z_grey);
        }

        public static int z_grey_2() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -5592406;
            }
            return viewLoadService.getColor("z_grey_2", R.color.z_grey_2);
        }

        public static int z_black() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -16777216;
            }
            return viewLoadService.getColor("z_black", R.color.z_black);
        }

        public static int gcash_pinkblue() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -9712131;
            }
            return viewLoadService.getColor("gcash_pinkblue", R.color.gcash_pinkblue);
        }

        public static int zdoc_message_view_bg_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -1;
            }
            return viewLoadService.getColor("zdoc_message_view_bg_color", R.color.zdoc_message_view_bg_color);
        }

        public static int zdoc_confirm_btn_normal_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -14253316;
            }
            return viewLoadService.getColor("zdoc_confirm_btn_normal_color", R.color.zdoc_confirm_btn_normal_color);
        }

        public static int zdoc_confirm_btn_press_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -14253316;
            }
            return viewLoadService.getColor("zdoc_confirm_btn_press_color", R.color.zdoc_confirm_btn_press_color);
        }

        public static int zdoc_retake_bg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return 0;
            }
            return viewLoadService.getColor("zdoc_retake_bg", R.color.zdoc_retake_bg);
        }

        public static int zdoc_retake_border_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -14253316;
            }
            return viewLoadService.getColor("zdoc_retake_border_color", R.color.zdoc_retake_border_color);
        }

        public static int zdoc_retake_text_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -14253316;
            }
            return viewLoadService.getColor("zdoc_retake_text_color", R.color.zdoc_retake_text_color);
        }

        public static int zdoc_submit_bg() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -14253316;
            }
            return viewLoadService.getColor("zdoc_submit_bg", R.color.zdoc_submit_bg);
        }

        public static int zdoc_submit_border_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -14253316;
            }
            return viewLoadService.getColor("zdoc_submit_border_color", R.color.zdoc_submit_border_color);
        }

        public static int zdoc_submit_text_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -1;
            }
            return viewLoadService.getColor("zdoc_submit_text_color", R.color.zdoc_submit_text_color);
        }

        public static int zdoc_message_tips_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -1;
            }
            return viewLoadService.getColor("zdoc_message_tips_color", R.color.zdoc_message_tips_color);
        }

        public static int zdoc_frame_bg_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -1728053248;
            }
            return viewLoadService.getColor("zdoc_frame_bg_color", R.color.zdoc_frame_bg_color);
        }

        public static int zdoc_line_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -9712131;
            }
            return viewLoadService.getColor("zdoc_line_color", R.color.zdoc_line_color);
        }

        public static int zdoc_frame_tips_color() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return -1;
            }
            return viewLoadService.getColor("zdoc_frame_tips_color", R.color.zdoc_frame_tips_color);
        }
    }

    /* loaded from: classes8.dex */
    public static class bool {
        public static boolean zdoc_frame_corner() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return true;
            }
            return viewLoadService.getBool("zdoc_frame_corner", R.bool.zdoc_frame_corner);
        }
    }

    /* loaded from: classes8.dex */
    public static class drawable {
        public static Drawable btn_pressed() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return null;
            }
            return viewLoadService.getDrawable("btn_pressed", R.drawable.btn_pressed);
        }

        public static Drawable btn_normal() {
            ViewLoadService viewLoadService = R2.getViewLoadService();
            if (viewLoadService == null) {
                return null;
            }
            return viewLoadService.getDrawable("btn_normal", R.drawable.btn_normal);
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
