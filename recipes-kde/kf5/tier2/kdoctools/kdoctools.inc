SUMMARY = "Documentation generation from docbook"
LICENSE = "MIT | LGPLv2.1"
LIC_FILES_CHKSUM = " \
	file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
	file://LICENSE;md5=d975629b732b61cb58f9595c6baa9379 \
"

require ../../kf5-version.inc

inherit kde

# allarch recipes can go here
DEPENDS += "docbook-xml-dtd4 docbook-xsl-stylesheets"

# allarch packages do only install into machine sysroot
# for xml4
OECMAKE_EXTRA_ROOT_PATH = "${STAGING_DIR}/${MACHINE}"
# for xsl (we have to hardcode /usr - ${prefix} is aligned by native.bbclase
EXTRA_OECMAKE += "-DOE_ROOT_PATH_PREFIX=${STAGING_DIR}/${MACHINE}/usr"

SRCREV = "93b844cdcfde640acfb231429c1c685de2c3cc4f"

SRC_URI += " \
	file://0001-Add-cmdline-param-to-help-find-xsl.patch \
	file://0002-build-meinproc5-it-works-fine-in-our-environment.patch \
"

EXTRA_OECMAKE += "-DCMAKE_AR:FILEPATH=${AR}"
