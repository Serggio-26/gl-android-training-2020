LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAG := optional

LOCAL_SRC_FILES := \
	$(call all-java-files-under, java) \
	$(call all-Iaidl-files-under, aidl)

LOCAL_PACKAGE_NAME := LedControlService
LOCAL_MANIFEST_FILE := AndroidManifest.xml
LOCAL_SERTIFICATE := platform
LOCAL_PRIVATE_PLATFORM_APIS := true
LOCAL_USE_AAPT2 := true
LOCAL_RESOURCE_DIR := $(LOCAL_PATH)/res
LOCAL_STATIC_ANDROID_LIBRARIES := \
	android-support-v7-appcompat 



include $(BUILD_PACKAGE)
