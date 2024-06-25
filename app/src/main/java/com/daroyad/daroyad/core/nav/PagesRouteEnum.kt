package com.daroyad.daroyad.core.nav

/**
 * Enum class representing the different routes for navigation in the app.
 * Each route is associated with a string value that defines the path.
 */
enum class PagesRouteEnum(val route: String) {
    SPLASH("splash"),
    ONBOARDING("onboarding"),
    MAIN("main"),
    PRESCRIPTION("prescription?prescription={prescription}"),
    SHOW_PRESCRIPTION("show_prescription"),
    ADD_PRESCRIPTION("add_prescription"),
    EDIT_PRESCRIPTION("edit_prescription"),
    SHOW_MEDICINE("show_medicine"),
    ADD_MEDICINE("add_medicine"),
    EDIT_MEDICINE("edit_medicine"),
    MEDICINES_PAGE("medicines_page");
}
