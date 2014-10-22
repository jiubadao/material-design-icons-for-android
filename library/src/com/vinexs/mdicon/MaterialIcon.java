/* 
 * Copyright Vin Wong @ vinexs.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.vinexs.mdicon;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

public class MaterialIcon {

	public static final int AUTO_THEME = -1;
	public static final int DARK_THEME = 0;
	public static final int LIGHT_THEME = 1;
	public static final int THEME_FREE = 255;
	
	protected static Typeface typeface = null;
	
	protected Context context = null;
	protected int theme = -1;
	protected int color = 0;
	protected int alpha = 255;
	
	public MaterialIcon( Context context ) {
		this.context = context;
	}
	
	public MaterialIcon setTheme(int theme) {
		this.theme = theme;
		return this;
	}
	
	public MaterialIcon setColor(int color) {
		this.color = color;
		return this;
	}
	
	public MaterialIcon setAlpah(int a) {
		this.alpha = a;
		return this;
	}
	
	public MaterialDrawable draw( String iconName ) {
		String iconUnicode = "";
		try {
			iconUnicode = GoogleMaterialIcon.valueOf(iconName).getUnicode();
		} catch(Exception e) {
			e.printStackTrace();
		}
		Log.d("MaterialIcon", "Load drawable[" + iconName + "], unicode[" + iconUnicode + "]");
		return new MaterialDrawable(context, iconUnicode, theme, color, alpha);
	}

	public static MaterialDrawable icon( Context context, String iconName, int color ){
		String iconUnicode = "";
		try {
			iconUnicode = GoogleMaterialIcon.valueOf(iconName).getUnicode();
		} catch(Exception e) {
			e.printStackTrace();
		}
		Log.d("MaterialIcon", "Load drawable[" + iconName + "], unicode[" + iconUnicode + "]");
		return new MaterialDrawable(context, iconUnicode, color);
	}
	
	public static final Typeface getTypeface(Context context) throws Exception {
		if (typeface != null) {
			return typeface;
		}	
		File InternalFolder = new File(context.getFilesDir(), "typeface");
		if (!InternalFolder.exists()) {
			InternalFolder.mkdirs();
		}
		File fontFile = new File(InternalFolder, "google_material_design_icon.ttf");
		if (!fontFile.exists())
		{
			InputStream is = context.getResources().openRawResource(R.raw.google_material_design_icon);
			byte[] buffer = new byte[is.available()];
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fontFile));
			int l = 0;
			while ((l = is.read(buffer)) > 0) {
				bos.write(buffer, 0, l);
			}
			bos.close();					
		}
		typeface = Typeface.createFromFile( fontFile );
		return typeface;
	}
	
	public static enum GoogleMaterialIcon {
		
		ic_3d_rotation("\ue600"),
		ic_accessibility("\ue601"),
		ic_account_balance("\ue602"),
		ic_account_balance_wallet("\ue603"),
		ic_account_box("\ue604"),
		ic_account_child("\ue605"),
		ic_account_circle("\ue606"),
		ic_add_shopping_cart("\ue607"),
		ic_alarm("\ue608"),
		ic_alarm_add("\ue609"),
		ic_alarm_off("\ue60a"),
		ic_alarm_on("\ue60b"),
		ic_android("\ue60c"),
		ic_announcement("\ue60d"),
		ic_aspect_ratio("\ue60e"),
		ic_assessment("\ue60f"),
		ic_assignment("\ue610"),
		ic_assignment_ind("\ue611"),
		ic_assignment_late("\ue612"),
		ic_assignment_return("\ue613"),
		ic_assignment_returned("\ue614"),
		ic_assignment_turned_in("\ue615"),
		ic_autorenew("\ue616"),
		ic_backup("\ue617"),
		ic_book("\ue618"),
		ic_bookmark("\ue619"),
		ic_bookmark_outline("\ue61a"),
		ic_bug_report("\ue61b"),
		ic_cached("\ue61c"),
		ic_class("\ue61d"),
		ic_credit_card("\ue61e"),
		ic_dashboard("\ue61f"),
		ic_delete("\ue620"),
		ic_description("\ue621"),
		ic_dns("\ue622"),
		ic_done("\ue623"),
		ic_done_all("\ue624"),
		ic_event("\ue625"),
		ic_exit_to_app("\ue626"),
		ic_explore("\ue627"),
		ic_extension("\ue628"),
		ic_face_unlock("\ue629"),
		ic_favorite("\ue62a"),
		ic_favorite_outline("\ue62b"),
		ic_find_in_page("\ue62c"),
		ic_find_replace("\ue62d"),
		ic_flip_to_back("\ue62e"),
		ic_flip_to_front("\ue62f"),
		ic_get_app("\ue630"),
		ic_grade("\ue631"),
		ic_group_work("\ue632"),
		ic_help("\ue633"),
		ic_highlight_remove("\ue634"),
		ic_history("\ue635"),
		ic_home("\ue636"),
		ic_https("\ue637"),
		ic_info("\ue638"),
		ic_info_outline("\ue639"),
		ic_input("\ue63a"),
		ic_invert_colors("\ue63b"),
		ic_label("\ue63c"),
		ic_label_outline("\ue63d"),
		ic_language("\ue63e"),
		ic_launch("\ue63f"),
		ic_list("\ue640"),
		ic_lock("\ue641"),
		ic_lock_open("\ue642"),
		ic_lock_outline("\ue643"),
		ic_loyalty("\ue644"),
		ic_markunread_mailbox("\ue645"),
		ic_note_add("\ue646"),
		ic_open_in_browser("\ue647"),
		ic_open_in_new("\ue648"),
		ic_open_with("\ue649"),
		ic_pageview("\ue64a"),
		ic_payment("\ue64b"),
		ic_perm_camera_mic("\ue64c"),
		ic_perm_contact_cal("\ue64d"),
		ic_perm_data_setting("\ue64e"),
		ic_perm_device_info("\ue64f"),
		ic_perm_identity("\ue650"),
		ic_perm_media("\ue651"),
		ic_perm_phone_msg("\ue652"),
		ic_perm_scan_wifi("\ue653"),
		ic_picture_in_picture("\ue654"),
		ic_polymer("\ue655"),
		ic_print("\ue656"),
		ic_query_builder("\ue657"),
		ic_question_answer("\ue658"),
		ic_receipt("\ue659"),
		ic_redeem("\ue65a"),
		ic_report_problem("\ue65b"),
		ic_restore("\ue65c"),
		ic_room("\ue65d"),
		ic_schedule("\ue65e"),
		ic_search("\ue65f"),
		ic_settings("\ue660"),
		ic_settings_applications("\ue661"),
		ic_settings_backup_restore("\ue662"),
		ic_settings_bluetooth("\ue663"),
		ic_settings_cell("\ue664"),
		ic_settings_display("\ue665"),
		ic_settings_ethernet("\ue666"),
		ic_settings_input_antenna("\ue667"),
		ic_settings_input_component("\ue668"),
		ic_settings_input_composite("\ue669"),
		ic_settings_input_hdmi("\ue66a"),
		ic_settings_input_svideo("\ue66b"),
		ic_settings_overscan("\ue66c"),
		ic_settings_phone("\ue66d"),
		ic_settings_power("\ue66e"),
		ic_settings_remote("\ue66f"),
		ic_settings_voice("\ue670"),
		ic_shop("\ue671"),
		ic_shop_two("\ue672"),
		ic_shopping_basket("\ue673"),
		ic_shopping_cart("\ue674"),
		ic_speaker_notes("\ue675"),
		ic_spellcheck("\ue676"),
		ic_star_rate("\ue677"),
		ic_stars("\ue678"),
		ic_store("\ue679"),
		ic_subject("\ue67a"),
		ic_swap_horiz("\ue67b"),
		ic_swap_vert("\ue67c"),
		ic_swap_vert_circle("\ue67d"),
		ic_system_update_tv("\ue67e"),
		ic_tab("\ue67f"),
		ic_tab_unselected("\ue680"),
		ic_theaters("\ue681"),
		ic_thumb_down("\ue682"),
		ic_thumb_up("\ue683"),
		ic_thumbs_up_down("\ue684"),
		ic_toc("\ue685"),
		ic_today("\ue686"),
		ic_track_changes("\ue687"),
		ic_translate("\ue688"),
		ic_trending_down("\ue689"),
		ic_trending_neutral("\ue68a"),
		ic_trending_up("\ue68b"),
		ic_turned_in("\ue68c"),
		ic_turned_in_not("\ue68d"),
		ic_verified_user("\ue68e"),
		ic_view_agenda("\ue68f"),
		ic_view_array("\ue690"),
		ic_view_carousel("\ue691"),
		ic_view_column("\ue692"),
		ic_view_day("\ue693"),
		ic_view_headline("\ue694"),
		ic_view_list("\ue695"),
		ic_view_module("\ue696"),
		ic_view_quilt("\ue697"),
		ic_view_stream("\ue698"),
		ic_view_week("\ue699"),
		ic_visibility("\ue69a"),
		ic_visibility_off("\ue69b"),
		ic_wallet_giftcard("\ue69c"),
		ic_wallet_membership("\ue69d"),
		ic_wallet_travel("\ue69e"),
		ic_work("\ue69f"),
		ic_error("\ue6a0"),
		ic_warning("\ue6a1"),
		ic_album("\ue6a2"),
		ic_av_timer("\ue6a3"),
		ic_closed_caption("\ue6a4"),
		ic_equalizer("\ue6a5"),
		ic_explicit("\ue6a6"),
		ic_fast_forward("\ue6a7"),
		ic_fast_rewind("\ue6a8"),
		ic_games("\ue6a9"),
		ic_hearing("\ue6aa"),
		ic_high_quality("\ue6ab"),
		ic_loop("\ue6ac"),
		ic_mic("\ue6ad"),
		ic_mic_none("\ue6ae"),
		ic_mic_off("\ue6af"),
		ic_movie("\ue6b0"),
		ic_my_library_add("\ue6b1"),
		ic_my_library_books("\ue6b2"),
		ic_my_library_music("\ue6b3"),
		ic_new_releases("\ue6b4"),
		ic_not_interested("\ue6b5"),
		ic_pause("\ue6b6"),
		ic_pause_circle_fill("\ue6b7"),
		ic_pause_circle_outline("\ue6b8"),
		ic_play_arrow("\ue6b9"),
		ic_play_circle_fill("\ue6ba"),
		ic_play_circle_outline("\ue6bb"),
		ic_play_shopping_bag("\ue6bc"),
		ic_playlist_add("\ue6bd"),
		ic_queue("\ue6be"),
		ic_queue_music("\ue6bf"),
		ic_radio("\ue6c0"),
		ic_recent_actors("\ue6c1"),
		ic_repeat("\ue6c2"),
		ic_repeat_one("\ue6c3"),
		ic_replay("\ue6c4"),
		ic_shuffle("\ue6c5"),
		ic_skip_next("\ue6c6"),
		ic_skip_previous("\ue6c7"),
		ic_snooze("\ue6c8"),
		ic_stop("\ue6c9"),
		ic_subtitles("\ue6ca"),
		ic_surround_sound("\ue6cb"),
		ic_video_collection("\ue6cc"),
		ic_videocam("\ue6cd"),
		ic_videocam_off("\ue6ce"),
		ic_volume_down("\ue6cf"),
		ic_volume_mute("\ue6d0"),
		ic_volume_off("\ue6d1"),
		ic_volume_up("\ue6d2"),
		ic_web("\ue6d3"),
		ic_business("\ue6d4"),
		ic_call("\ue6d5"),
		ic_call_end("\ue6d6"),
		ic_call_made("\ue6d7"),
		ic_call_merge("\ue6d8"),
		ic_call_missed("\ue6d9"),
		ic_call_received("\ue6da"),
		ic_call_split("\ue6db"),
		ic_chat("\ue6dc"),
		ic_clear_all("\ue6dd"),
		ic_comment("\ue6de"),
		ic_contacts("\ue6df"),
		ic_dialer_sip("\ue6e0"),
		ic_dialpad("\ue6e1"),
		ic_dnd_on("\ue6e2"),
		ic_email("\ue6e3"),
		ic_forum("\ue6e4"),
		ic_import_export("\ue6e5"),
		ic_invert_colors_off("\ue6e6"),
		ic_invert_colors_on("\ue6e7"),
		ic_live_help("\ue6e8"),
		ic_location_off("\ue6e9"),
		ic_location_on("\ue6ea"),
		ic_message("\ue6eb"),
		ic_messenger("\ue6ec"),
		ic_no_sim("\ue6ed"),
		ic_phone("\ue6ee"),
		ic_portable_wifi_off("\ue6ef"),
		ic_quick_contacts_dialer("\ue6f0"),
		ic_quick_contacts_mail("\ue6f1"),
		ic_ring_volume("\ue6f2"),
		ic_stay_current_landscape("\ue6f3"),
		ic_stay_current_portrait("\ue6f4"),
		ic_stay_primary_landscape("\ue6f5"),
		ic_stay_primary_portrait("\ue6f6"),
		ic_swap_calls("\ue6f7"),
		ic_textsms("\ue6f8"),
		ic_voicemail("\ue6f9"),
		ic_vpn_key("\ue6fa"),
		ic_add("\ue6fb"),
		ic_add_box("\ue6fc"),
		ic_add_circle("\ue6fd"),
		ic_add_circle_outline("\ue6fe"),
		ic_archive("\ue6ff"),
		ic_backspace("\ue700"),
		ic_block("\ue701"),
		ic_clear("\ue702"),
		ic_content_copy("\ue703"),
		ic_content_cut("\ue704"),
		ic_content_paste("\ue705"),
		ic_create("\ue706"),
		ic_drafts("\ue707"),
		ic_filter_list("\ue708"),
		ic_flag("\ue709"),
		ic_forward("\ue70a"),
		ic_gesture("\ue70b"),
		ic_inbox("\ue70c"),
		ic_link("\ue70d"),
		ic_mail("\ue70e"),
		ic_markunread("\ue70f"),
		ic_redo("\ue710"),
		ic_remove("\ue711"),
		ic_remove_circle("\ue712"),
		ic_remove_circle_outline("\ue713"),
		ic_reply("\ue714"),
		ic_reply_all("\ue715"),
		ic_report("\ue716"),
		ic_save("\ue717"),
		ic_select_all("\ue718"),
		ic_send("\ue719"),
		ic_sort("\ue71a"),
		ic_text_format("\ue71b"),
		ic_undo("\ue71c"),
		ic_access_alarm("\ue71d"),
		ic_access_alarms("\ue71e"),
		ic_access_time("\ue71f"),
		ic_add_alarm("\ue720"),
		ic_airplanemode_off("\ue721"),
		ic_airplanemode_on("\ue722"),
		ic_battery_20("\ue723"),
		ic_battery_30("\ue724"),
		ic_battery_50("\ue725"),
		ic_battery_60("\ue726"),
		ic_battery_80("\ue727"),
		ic_battery_90("\ue728"),
		ic_battery_alert("\ue729"),
		ic_battery_charging_20("\ue72a"),
		ic_battery_charging_30("\ue72b"),
		ic_battery_charging_50("\ue72c"),
		ic_battery_charging_60("\ue72d"),
		ic_battery_charging_80("\ue72e"),
		ic_battery_charging_90("\ue72f"),
		ic_battery_charging_full("\ue730"),
		ic_battery_full("\ue731"),
		ic_battery_std("\ue732"),
		ic_battery_unknown("\ue733"),
		ic_bluetooth("\ue734"),
		ic_bluetooth_connected("\ue735"),
		ic_bluetooth_disabled("\ue736"),
		ic_bluetooth_searching("\ue737"),
		ic_brightness_auto("\ue738"),
		ic_brightness_high("\ue739"),
		ic_brightness_low("\ue73a"),
		ic_brightness_medium("\ue73b"),
		ic_data_usage("\ue73c"),
		ic_developer_mode("\ue73d"),
		ic_devices("\ue73e"),
		ic_dvr("\ue73f"),
		ic_gps_fixed("\ue740"),
		ic_gps_not_fixed("\ue741"),
		ic_gps_off("\ue742"),
		ic_location_disabled("\ue743"),
		ic_location_searching("\ue744"),
		ic_multitrack_audio("\ue745"),
		ic_network_cell("\ue746"),
		ic_network_wifi("\ue747"),
		ic_nfc("\ue748"),
		ic_now_wallpaper("\ue749"),
		ic_now_widgets("\ue74a"),
		ic_screen_lock_landscape("\ue74b"),
		ic_screen_lock_portrait("\ue74c"),
		ic_screen_lock_rotation("\ue74d"),
		ic_screen_rotation("\ue74e"),
		ic_sd_storage("\ue74f"),
		ic_settings_system_daydream("\ue750"),
		ic_signal_cellular_0_bar("\ue751"),
		ic_signal_cellular_1_bar("\ue752"),
		ic_signal_cellular_2_bar("\ue753"),
		ic_signal_cellular_3_bar("\ue754"),
		ic_signal_cellular_4_bar("\ue755"),
		ic_signal_cellular_connected_no_internet_0_bar("\ue756"),
		ic_signal_cellular_connected_no_internet_1_bar("\ue757"),
		ic_signal_cellular_connected_no_internet_2_bar("\ue758"),
		ic_signal_cellular_connected_no_internet_3_bar("\ue759"),
		ic_signal_cellular_connected_no_internet_4_bar("\ue75a"),
		ic_signal_cellular_no_sim("\ue75b"),
		ic_signal_cellular_null("\ue75c"),
		ic_signal_cellular_off("\ue75d"),
		ic_signal_wifi_0_bar("\ue75e"),
		ic_signal_wifi_1_bar("\ue75f"),
		ic_signal_wifi_2_bar("\ue760"),
		ic_signal_wifi_3_bar("\ue761"),
		ic_signal_wifi_4_bar("\ue762"),
		ic_signal_wifi_off("\ue763"),
		ic_signal_wifi_statusbar_1_bar_26x24px("\ue764"),
		ic_signal_wifi_statusbar_2_bar_26x24px("\ue765"),
		ic_signal_wifi_statusbar_3_bar_26x24px("\ue766"),
		ic_signal_wifi_statusbar_4_bar_26x24px("\ue767"),
		ic_signal_wifi_statusbar_connected_no_internet_1_26x24px("\ue768"),
		ic_signal_wifi_statusbar_connected_no_internet_2_26x24px("\ue769"),
		ic_signal_wifi_statusbar_connected_no_internet_3_26x24px("\ue76a"),
		ic_signal_wifi_statusbar_connected_no_internet_4_26x24px("\ue76b"),
		ic_signal_wifi_statusbar_connected_no_internet_26x24px("\ue76c"),
		ic_signal_wifi_statusbar_not_connected_26x24px("\ue76d"),
		ic_signal_wifi_statusbar_null_26x24px("\ue76e"),
		ic_storage("\ue76f"),
		ic_usb("\ue770"),
		ic_wifi_lock("\ue771"),
		ic_wifi_tethering("\ue772"),
		ic_attach_file("\ue773"),
		ic_attach_money("\ue774"),
		ic_border_all("\ue775"),
		ic_border_bottom("\ue776"),
		ic_border_clear("\ue777"),
		ic_border_color("\ue778"),
		ic_border_horizontal("\ue779"),
		ic_border_inner("\ue77a"),
		ic_border_left("\ue77b"),
		ic_border_outer("\ue77c"),
		ic_border_right("\ue77d"),
		ic_border_style("\ue77e"),
		ic_border_top("\ue77f"),
		ic_border_vertical("\ue780"),
		ic_format_align_center("\ue781"),
		ic_format_align_justify("\ue782"),
		ic_format_align_left("\ue783"),
		ic_format_align_right("\ue784"),
		ic_format_bold("\ue785"),
		ic_format_clear("\ue786"),
		ic_format_color_fill("\ue787"),
		ic_format_color_reset("\ue788"),
		ic_format_color_text("\ue789"),
		ic_format_indent_decrease("\ue78a"),
		ic_format_indent_increase("\ue78b"),
		ic_format_italic("\ue78c"),
		ic_format_line_spacing("\ue78d"),
		ic_format_list_bulleted("\ue78e"),
		ic_format_list_numbered("\ue78f"),
		ic_format_paint("\ue790"),
		ic_format_quote("\ue791"),
		ic_format_size("\ue792"),
		ic_format_strikethrough("\ue793"),
		ic_format_textdirection_l_to_r("\ue794"),
		ic_format_textdirection_r_to_l("\ue795"),
		ic_format_underline("\ue796"),
		ic_functions("\ue797"),
		ic_insert_chart("\ue798"),
		ic_insert_comment("\ue799"),
		ic_insert_drive_file("\ue79a"),
		ic_insert_emoticon("\ue79b"),
		ic_insert_invitation("\ue79c"),
		ic_insert_link("\ue79d"),
		ic_insert_photo("\ue79e"),
		ic_merge_type("\ue79f"),
		ic_mode_comment("\ue7a0"),
		ic_mode_edit("\ue7a1"),
		ic_publish("\ue7a2"),
		ic_vertical_align_bottom("\ue7a3"),
		ic_vertical_align_center("\ue7a4"),
		ic_vertical_align_top("\ue7a5"),
		ic_wrap_text("\ue7a6"),
		ic_attachment("\ue7a7"),
		ic_cloud("\ue7a8"),
		ic_cloud_circle("\ue7a9"),
		ic_cloud_done("\ue7aa"),
		ic_cloud_download("\ue7ab"),
		ic_cloud_off("\ue7ac"),
		ic_cloud_queue("\ue7ad"),
		ic_cloud_upload("\ue7ae"),
		ic_file_download("\ue7af"),
		ic_file_upload("\ue7b0"),
		ic_folder("\ue7b1"),
		ic_folder_open("\ue7b2"),
		ic_folder_shared("\ue7b3"),
		ic_cast("\ue7b4"),
		ic_cast_connected("\ue7b5"),
		ic_computer("\ue7b6"),
		ic_desktop_mac("\ue7b7"),
		ic_desktop_windows("\ue7b8"),
		ic_dock("\ue7b9"),
		ic_gamepad("\ue7ba"),
		ic_headset("\ue7bb"),
		ic_headset_mic("\ue7bc"),
		ic_keyboard("\ue7bd"),
		ic_keyboard_alt("\ue7be"),
		ic_keyboard_arrow_down("\ue7bf"),
		ic_keyboard_arrow_left("\ue7c0"),
		ic_keyboard_arrow_right("\ue7c1"),
		ic_keyboard_arrow_up("\ue7c2"),
		ic_keyboard_backspace("\ue7c3"),
		ic_keyboard_capslock("\ue7c4"),
		ic_keyboard_control("\ue7c5"),
		ic_keyboard_hide("\ue7c6"),
		ic_keyboard_return("\ue7c7"),
		ic_keyboard_tab("\ue7c8"),
		ic_keyboard_voice("\ue7c9"),
		ic_laptop("\ue7ca"),
		ic_laptop_chromebook("\ue7cb"),
		ic_laptop_mac("\ue7cc"),
		ic_laptop_windows("\ue7cd"),
		ic_memory("\ue7ce"),
		ic_mouse("\ue7cf"),
		ic_phone_android("\ue7d0"),
		ic_phone_iphone("\ue7d1"),
		ic_phonelink("\ue7d2"),
		ic_phonelink_off("\ue7d3"),
		ic_security("\ue7d4"),
		ic_sim_card("\ue7d5"),
		ic_smartphone("\ue7d6"),
		ic_speaker("\ue7d7"),
		ic_tablet("\ue7d8"),
		ic_tablet_android("\ue7d9"),
		ic_tablet_mac("\ue7da"),
		ic_tv("\ue7db"),
		ic_watch("\ue7dc"),
		ic_add_to_photos("\ue7dd"),
		ic_adjust("\ue7de"),
		ic_assistant_photo("\ue7df"),
		ic_audiotrack("\ue7e0"),
		ic_blur_circular("\ue7e1"),
		ic_blur_linear("\ue7e2"),
		ic_blur_off("\ue7e3"),
		ic_blur_on("\ue7e4"),
		ic_brightness_1("\ue7e5"),
		ic_brightness_2("\ue7e6"),
		ic_brightness_3("\ue7e7"),
		ic_brightness_4("\ue7e8"),
		ic_brightness_5("\ue7e9"),
		ic_brightness_6("\ue7ea"),
		ic_brightness_7("\ue7eb"),
		ic_brush("\ue7ec"),
		ic_camera("\ue7ed"),
		ic_camera_alt("\ue7ee"),
		ic_camera_front("\ue7ef"),
		ic_camera_rear("\ue7f0"),
		ic_camera_roll("\ue7f1"),
		ic_center_focus_strong("\ue7f2"),
		ic_center_focus_weak("\ue7f3"),
		ic_collections("\ue7f4"),
		ic_color_lens("\ue7f5"),
		ic_colorize("\ue7f6"),
		ic_compare("\ue7f7"),
		ic_control_point("\ue7f8"),
		ic_control_point_duplicate("\ue7f9"),
		ic_crop_3_2("\ue7fa"),
		ic_crop_5_4("\ue7fb"),
		ic_crop_7_5("\ue7fc"),
		ic_crop_16_9("\ue7fd"),
		ic_crop("\ue7fe"),
		ic_crop_din("\ue7ff"),
		ic_crop_free("\ue800"),
		ic_crop_landscape("\ue801"),
		ic_crop_original("\ue802"),
		ic_crop_portrait("\ue803"),
		ic_crop_square("\ue804"),
		ic_dehaze("\ue805"),
		ic_details("\ue806"),
		ic_edit("\ue807"),
		ic_exposure("\ue808"),
		ic_exposure_minus_1("\ue809"),
		ic_exposure_minus_2("\ue80a"),
		ic_exposure_plus_1("\ue80b"),
		ic_exposure_plus_2("\ue80c"),
		ic_exposure_zero("\ue80d"),
		ic_filter_1("\ue80e"),
		ic_filter_2("\ue80f"),
		ic_filter_3("\ue810"),
		ic_filter_4("\ue811"),
		ic_filter_5("\ue812"),
		ic_filter_6("\ue813"),
		ic_filter_7("\ue814"),
		ic_filter_8("\ue815"),
		ic_filter_9("\ue816"),
		ic_filter_9_plus("\ue817"),
		ic_filter("\ue818"),
		ic_filter_b_and_w("\ue819"),
		ic_filter_center_focus("\ue81a"),
		ic_filter_drama("\ue81b"),
		ic_filter_frames("\ue81c"),
		ic_filter_hdr("\ue81d"),
		ic_filter_none("\ue81e"),
		ic_filter_tilt_shift("\ue81f"),
		ic_filter_vintage("\ue820"),
		ic_flare("\ue821"),
		ic_flash_auto("\ue822"),
		ic_flash_off("\ue823"),
		ic_flash_on("\ue824"),
		ic_flip("\ue825"),
		ic_gradient("\ue826"),
		ic_grain("\ue827"),
		ic_grid_off("\ue828"),
		ic_grid_on("\ue829"),
		ic_hdr_off("\ue82a"),
		ic_hdr_on("\ue82b"),
		ic_hdr_strong("\ue82c"),
		ic_hdr_weak("\ue82d"),
		ic_healing("\ue82e"),
		ic_image("\ue82f"),
		ic_image_aspect_ratio("\ue830"),
		ic_iso("\ue831"),
		ic_landscape("\ue832"),
		ic_leak_add("\ue833"),
		ic_leak_remove("\ue834"),
		ic_lens("\ue835"),
		ic_looks_3("\ue836"),
		ic_looks_4("\ue837"),
		ic_looks_5("\ue838"),
		ic_looks_6("\ue839"),
		ic_looks("\ue83a"),
		ic_looks_one("\ue83b"),
		ic_looks_two("\ue83c"),
		ic_loupe("\ue83d"),
		ic_movie_creation("\ue83e"),
		ic_nature("\ue83f"),
		ic_nature_people("\ue840"),
		ic_navigate_before("\ue841"),
		ic_navigate_next("\ue842"),
		ic_palette("\ue843"),
		ic_panorama("\ue844"),
		ic_panorama_fisheye("\ue845"),
		ic_panorama_horizontal("\ue846"),
		ic_panorama_vertical("\ue847"),
		ic_panorama_wide_angle("\ue848"),
		ic_photo("\ue849"),
		ic_photo_album("\ue84a"),
		ic_photo_camera("\ue84b"),
		ic_photo_library("\ue84c"),
		ic_portrait("\ue84d"),
		ic_remove_red_eye("\ue84e"),
		ic_rotate_left("\ue84f"),
		ic_rotate_right("\ue850"),
		ic_slideshow("\ue851"),
		ic_straighten("\ue852"),
		ic_style("\ue853"),
		ic_switch_camera("\ue854"),
		ic_switch_video("\ue855"),
		ic_tag_faces("\ue856"),
		ic_texture("\ue857"),
		ic_timelapse("\ue858"),
		ic_timer_3("\ue859"),
		ic_timer_10("\ue85a"),
		ic_timer("\ue85b"),
		ic_timer_auto("\ue85c"),
		ic_timer_off("\ue85d"),
		ic_tonality("\ue85e"),
		ic_transform("\ue85f"),
		ic_tune("\ue860"),
		ic_wb_auto("\ue861"),
		ic_wb_cloudy("\ue862"),
		ic_wb_incandescent("\ue863"),
		ic_wb_irradescent("\ue864"),
		ic_wb_sunny("\ue865"),
		ic_beenhere("\ue866"),
		ic_directions("\ue867"),
		ic_directions_bike("\ue868"),
		ic_directions_bus("\ue869"),
		ic_directions_car("\ue86a"),
		ic_directions_ferry("\ue86b"),
		ic_directions_subway("\ue86c"),
		ic_directions_train("\ue86d"),
		ic_directions_transit("\ue86e"),
		ic_directions_walk("\ue86f"),
		ic_flight("\ue870"),
		ic_hotel("\ue871"),
		ic_layers("\ue872"),
		ic_layers_clear("\ue873"),
		ic_local_airport("\ue874"),
		ic_local_atm("\ue875"),
		ic_local_attraction("\ue876"),
		ic_local_bar("\ue877"),
		ic_local_cafe("\ue878"),
		ic_local_car_wash("\ue879"),
		ic_local_convenience_store("\ue87a"),
		ic_local_drink("\ue87b"),
		ic_local_florist("\ue87c"),
		ic_local_gas_station("\ue87d"),
		ic_local_grocery_store("\ue87e"),
		ic_local_hospital("\ue87f"),
		ic_local_hotel("\ue880"),
		ic_local_laundry_service("\ue881"),
		ic_local_library("\ue882"),
		ic_local_mall("\ue883"),
		ic_local_movies("\ue884"),
		ic_local_offer("\ue885"),
		ic_local_parking("\ue886"),
		ic_local_pharmacy("\ue887"),
		ic_local_phone("\ue888"),
		ic_local_pizza("\ue889"),
		ic_local_play("\ue88a"),
		ic_local_post_office("\ue88b"),
		ic_local_print_shop("\ue88c"),
		ic_local_restaurant("\ue88d"),
		ic_local_see("\ue88e"),
		ic_local_shipping("\ue88f"),
		ic_local_taxi("\ue890"),
		ic_location_history("\ue891"),
		ic_map("\ue892"),
		ic_my_location("\ue893"),
		ic_navigation("\ue894"),
		ic_pin_drop("\ue895"),
		ic_place("\ue896"),
		ic_rate_review("\ue897"),
		ic_restaurant_menu("\ue898"),
		ic_satellite("\ue899"),
		ic_store_mall_directory("\ue89a"),
		ic_terrain("\ue89b"),
		ic_traffic("\ue89c"),
		ic_apps_36px("\ue89d"),
		ic_apps("\ue89e"),
		ic_arrow_back_36px("\ue89f"),
		ic_arrow_back("\ue8a0"),
		ic_arrow_drop_down_36px("\ue8a1"),
		ic_arrow_drop_down("\ue8a2"),
		ic_arrow_drop_down_circle("\ue8a3"),
		ic_arrow_drop_up_36px("\ue8a4"),
		ic_arrow_drop_up("\ue8a5"),
		ic_arrow_forward_36px("\ue8a6"),
		ic_arrow_forward("\ue8a7"),
		ic_cancel_36px("\ue8a8"),
		ic_cancel("\ue8a9"),
		ic_check_36px("\ue8aa"),
		ic_check("\ue8ab"),
		ic_chevron_left_36px("\ue8ac"),
		ic_chevron_left("\ue8ad"),
		ic_chevron_right_36px("\ue8ae"),
		ic_chevron_right("\ue8af"),
		ic_close_36px("\ue8b0"),
		ic_close("\ue8b1"),
		ic_expand_less_36px("\ue8b2"),
		ic_expand_less("\ue8b3"),
		ic_expand_more_36px("\ue8b4"),
		ic_expand_more("\ue8b5"),
		ic_fullscreen_36px("\ue8b6"),
		ic_fullscreen("\ue8b7"),
		ic_fullscreen_exit_36px("\ue8b8"),
		ic_fullscreen_exit("\ue8b9"),
		ic_menu_36px("\ue8ba"),
		ic_menu("\ue8bb"),
		ic_more_horiz_36px("\ue8bc"),
		ic_more_horiz("\ue8bd"),
		ic_more_vert_36px("\ue8be"),
		ic_more_vert("\ue8bf"),
		ic_refresh_36px("\ue8c0"),
		ic_refresh("\ue8c1"),
		ic_unfold_less_36px("\ue8c2"),
		ic_unfold_less("\ue8c3"),
		ic_unfold_more_36px("\ue8c4"),
		ic_unfold_more("\ue8c5"),
		ic_adb("\ue8c6"),
		ic_bluetooth_audio("\ue8c7"),
		ic_disc_full("\ue8c8"),
		ic_dnd_forwardslash("\ue8c9"),
		ic_do_not_disturb("\ue8ca"),
		ic_drive_eta("\ue8cb"),
		ic_event_available("\ue8cc"),
		ic_event_busy("\ue8cd"),
		ic_event_note("\ue8ce"),
		ic_folder_special("\ue8cf"),
		ic_mms("\ue8d0"),
		ic_more("\ue8d1"),
		ic_network_locked("\ue8d2"),
		ic_phone_bluetooth_speaker("\ue8d3"),
		ic_phone_forwarded("\ue8d4"),
		ic_phone_in_talk("\ue8d5"),
		ic_phone_locked("\ue8d6"),
		ic_phone_missed("\ue8d7"),
		ic_phone_paused("\ue8d8"),
		ic_play_download("\ue8d9"),
		ic_play_install("\ue8da"),
		ic_sd_card("\ue8db"),
		ic_sim_card_alert("\ue8dc"),
		ic_sms("\ue8dd"),
		ic_sms_failed("\ue8de"),
		ic_sync("\ue8df"),
		ic_sync_disabled("\ue8e0"),
		ic_sync_problem("\ue8e1"),
		ic_system_update("\ue8e2"),
		ic_tap_and_play("\ue8e3"),
		ic_time_to_leave("\ue8e4"),
		ic_vibration("\ue8e5"),
		ic_voice_chat("\ue8e6"),
		ic_vpn_lock("\ue8e7"),
		ic_cake("\ue8e8"),
		ic_domain("\ue8e9"),
		ic_group("\ue8ea"),
		ic_group_add("\ue8eb"),
		ic_location_city("\ue8ec"),
		ic_mood("\ue8ed"),
		ic_notifications("\ue8ee"),
		ic_notifications_none("\ue8ef"),
		ic_notifications_off("\ue8f0"),
		ic_notifications_on("\ue8f1"),
		ic_notifications_paused("\ue8f2"),
		ic_pages("\ue8f3"),
		ic_party_mode("\ue8f4"),
		ic_people("\ue8f5"),
		ic_people_outline("\ue8f6"),
		ic_person("\ue8f7"),
		ic_person_add("\ue8f8"),
		ic_person_outline("\ue8f9"),
		ic_plus_one("\ue8fa"),
		ic_poll("\ue8fb"),
		ic_public("\ue8fc"),
		ic_school("\ue8fd"),
		ic_share("\ue8fe"),
		ic_whatshot("\ue8ff"),
		ic_check_box("\ue900"),
		ic_check_box_outline_blank("\ue901"),
		ic_radio_button_off("\ue902"),
		ic_radio_button_on("\ue903");
		
		String unicode;
		
		GoogleMaterialIcon(String unicode) {
			this.unicode = unicode;
		}
		
		public String getUnicode() {
			return unicode;
		}
		
	}
	
}
