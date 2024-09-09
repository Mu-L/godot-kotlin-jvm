#ifdef TOOLS_ENABLED

#include "godot_kotlin_jvm_editor.h"

#include "constant.h"
#include "editor/build/build_manager.h"

#include <core/config/project_settings.h>
#include <editor/editor_interface.h>
#include <editor/filesystem_dock.h>

void GodotKotlinJvmEditor::on_menu_option_pressed(int option_id) {
    about_dialog->popup_centered();
}

void GodotKotlinJvmEditor::on_build_project_pressed() {
    BuildManager::get_instance().build_project_non_blocking();
}

bool GodotKotlinJvmEditor::build() {
    bool build_gradle_before_start = EDITOR_GET(build_before_start);

    if (build_gradle_before_start) {
        bool is_successful = BuildManager::get_instance().build_project_blocking();
        return is_successful;
    } else {
        return true;
    }
}

GodotKotlinJvmEditor* GodotKotlinJvmEditor::get_instance() {
    static GodotKotlinJvmEditor* instance {memnew(GodotKotlinJvmEditor)};
    return instance;
}

void GodotKotlinJvmEditor::update_build_dialog(String log) {
    MessageQueue::get_singleton()->push_callable(callable_mp(build_dialog, &BuildDialog::update_state).bind(log));
}

void GodotKotlinJvmEditor::_notification(int notification) {
    Control* editor_base_control = get_editor_interface()->get_base_control();

    switch (notification) {
        case NOTIFICATION_ENTER_TREE:
            _EDITOR_DEF(build_before_start, false);
            _EDITOR_DEF(show_info_on_start, true);
            _GLOBAL_DEF(gradle_dir, "res://");
            ProjectSettings::get_singleton()->set_custom_property_info(
              PropertyInfo(Variant::STRING, gradle_dir, PROPERTY_HINT_GLOBAL_DIR, "")
            );

            about_pop_menu->hide();
            about_pop_menu->connect(SNAME("id_pressed"), callable_mp(this, &GodotKotlinJvmEditor::on_menu_option_pressed));
            about_pop_menu->add_item("About Godot Kotlin JVM");
            add_tool_submenu_item("Kotlin/JVM", about_pop_menu);

            tool_bar_build_button->set_flat(true);
            tool_bar_build_button->set_text("Build");
            tool_bar_build_button->set_tooltip_text("Build gradle project");
            tool_bar_build_button->set_focus_mode(Control::FOCUS_NONE);
            tool_bar_build_button->connect(SNAME("pressed"), callable_mp(this, &GodotKotlinJvmEditor::on_build_project_pressed));
            add_control_to_container(CustomControlContainer::CONTAINER_TOOLBAR, tool_bar_build_button);

            editor_base_control->add_child(build_dialog);
            editor_base_control->add_child(about_dialog);

            if (EDITOR_GET(show_info_on_start)) {
                GodotKotlinJvmEditor::on_menu_option_pressed(0);
            }
            break;

        case NOTIFICATION_EXIT_TREE:
            editor_base_control->remove_child(build_dialog);
            editor_base_control->remove_child(about_dialog);
            remove_tool_menu_item("Kotlin/JVM");
            remove_control_from_container(CustomControlContainer::CONTAINER_TOOLBAR, tool_bar_build_button);
            break;
    }
}

GodotKotlinJvmEditor::GodotKotlinJvmEditor() :
  about_pop_menu(memnew(PopupMenu)),
  about_dialog(memnew(AboutDialog)),
  build_dialog(memnew(BuildDialog)),
  tool_bar_build_button(memnew(Button)) {}

GodotKotlinJvmEditor::~GodotKotlinJvmEditor() {
    memdelete(about_dialog);
    memdelete(build_dialog);
    memdelete(tool_bar_build_button);
}

#endif// TOOLS_ENABLED