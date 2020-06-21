#define LOG_TAG "vendor.gl_serggio_26.hardware.LedControl@1.0-service"

#include <hidl/HidlSupport.h>
#include <hidl/HidlTransportSupport.h>
#include "LedControlHW.h"

using ::android::hardware::configureRpcThreadpool;
using ::vendor::gl-serggio-26::hardware::LedControl::V1_0::implementation::LedControlHW;
using ::vendor::gl-serggio-26::hardware::LedControl::V1_0::ILedControlHW;
using ::android::hardware::joinRpcThreadpool;
using ::android::OK;
using ::android::sp;

int main(int /* argc */, char* /* argv */ []) {
    sp<ILedControlHW> ledControlHW = new LedControlHW();
    configureRpcThreadpool(1, true /* will join */);
    if (ledControlHW->registerAsService() != OK) {
        ALOGE("Couldn't register LedControlHW 1.0 service.");
        return 1;
    }
    joinRpcThreadpool();
    ALOGE("Service exited!");
    return 1;
}
