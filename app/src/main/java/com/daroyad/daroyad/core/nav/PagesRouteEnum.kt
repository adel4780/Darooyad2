package com.daroyad.daroyad.core.nav

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