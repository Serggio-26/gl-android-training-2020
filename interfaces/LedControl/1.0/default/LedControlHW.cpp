#define LOG_TAG "LedControl_HW"

#include <log/log.h>
#include "LedControlHW.h"

namespace vendor {
namespace gls {
namespace hardware {
namespace LedControl {
namespace V1_0 {
namespace implementation {

LedControlHW::LedControlHW() {
    ALOGD("->LedControlHW::LedControlHW()");
}

LedControlHW::~LedControlHW(){
    ALOGD("->LedControlHW::~LedControlHW()");
}

Return<result_t> LedControlHW::iLedControlHW(leds_t ledId, ledState_t state) {
    std::string name;
    std::string condition;

    switch(ledId) {
        case leds_t::LED1:
	    name = "user_led1";
	    break;
	case leds_t::LED2:
	    name = "user_led2";
	    break;
	case leds_t::LED3:
	    name = "user_led3";
	    break;
	case leds_t::LED4:
	    name = "user_led4";
	    break;
    }
    condition = (state == ledState_t::ON) ? "On" : "Off";
    ALOGD("->LedControlHW::iLedControlHW(led=%s, condition=%s)", name.c_str(), condition.c_str());
    return result_t::RES_OK;
}

} // namespace implementation
} // namespace V1_0
} // namespace LedControl
} // namespace hardware
} // namespace gls
} // namespace vendor

