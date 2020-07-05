# Hal
PRODUCT_PACKAGES += \
	vendor.gls.hardware.LedControl@1.0-service \

DEVICE_MANIFEST_FILE += \
	vendor/gls/hardware/interfaces/manifest.xml

DEVICE_MATRIX_FILE += \
	vendor/gls/hardware/interfaces/compatibility_matrix.xml

TARGET_FS_CONFIG_GEN += \
        vendor/gls/hardware/interfaces/config.fs


PRODUCT_PACKAGES += \
	LedControlService \
	LedControlApplication \


BOARD_SEPOLICY_DIRS += \
	vendor/gls/sepolicy

