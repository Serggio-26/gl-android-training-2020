#define LOG_TAG "LedControlHW"

#include <log/log.h>
#include "LedControlHW.h"

namespace vendor {
namespace gl-serggio-26 {
namespace LedControl {
namespace V1_0 {
namespace implementation {

LedControlHW::LedControlHW() {
    ALOGD("->LedControlHW::LedControlHW()");
}

LedControlHW::~LedControlHW(){
    ALOGD("->LedControlHW::~LedControlHW()");
}

Return<int> LedControlHW::iLedControlHW(leds ledId, bool stateOn) {
    ALOGD("->LedControlHW::iLedControlHW(led=%d, on=%d)", ledId, stateOn);
    return 0;
}

} // namespace implementation
} // namespace V1_0
} // namespace LedControl
} // namespace gl-serggio-26
} // namespace vendor
