require ${BPN}.inc

inherit cmake-lib

DEPENDS += " \
    ${BPN}-native \
    qtsvg \
    qttools \
    kcompletion \
    kconfig \
    kconfigwidgets \
    kcrash \
    kdesignerplugin \
    kdbusaddons \
    kemoticons \
    kglobalaccel \
    kitemmodels \
    kinit \
    kdoctools \
    kguiaddons \
    ki18n \
    kiconthemes \
    kio \
    knotifications \
    kparts \
    kservice \
    ktextwidgets \
    kunitconversion \
    kwidgetsaddons \
    kwindowsystem \
    kxmlgui \
    kded \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "virtual/xserver qtx11extras", "", d)} \
"

# uncomment for broken gelib getaddr / AI_PASSIVE
#EXTRA_OECMAKE += "-DHAVE_GOOD_GETADDRINFO=OFF"

do_compile_prepend() {
    # Error: Could not locate service type file kservicetypes5/ "kdedmodule.desktop" , tried ...
    export XDG_DATA_HOME=${STAGING_DATADIR}
}

do_configure_append() {
    # fix KCONFIG_COMPILER_LOCATION
    sed -i 's:${STAGING_LIBDIR_NATIVE}:${libdir}:g' ${B}/src/config-kstandarddirs.h
}

# cross libs / headers
CMAKE_ALIGN_SYSROOT[1] = "KDELibs4, -S${includedir}, -S${STAGING_INCDIR}"
CMAKE_ALIGN_SYSROOT[2] = "KDELibs4, -S${libdir}/lib, -S${STAGING_LIBDIR}/lib"

# native executables
CMAKE_ALIGN_SYSROOT[3] = "KF5KDELibs4Support, -S${bindir}, -S${STAGING_BINDIR_NATIVE}"

FILES_${PN} += " \
    ${datadir}/k*5 \
    ${datadir}/dbus-1 \
    ${OE_QMAKE_PATH_PLUGINS} \
"

FILES_${PN}-dbg += " \
    ${OE_QMAKE_PATH_PLUGINS}/.debug \
    ${OE_QMAKE_PATH_PLUGINS}/kf5/*/.debug \
    ${OE_QMAKE_PATH_PLUGINS}/*/.debug \
"
