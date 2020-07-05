#define LOG_TAG "LedControl_HW"

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

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
	for (int ledId = 1; ledId < 5; ++ledId) {
		std::string path = "/sys/class/leds/user_led" + std::to_string(ledId) + "/trigger";
		int led_fd = open(path.c_str(), O_WRONLY);
		if (led_fd < 0) {
			ALOGE("Can't open %s file to control LED!", path.c_str());
			break;
		}
		if (0 > write(led_fd, std::string("none").c_str(), std::string("none").length())) {
			ALOGE("Can't write to file %s", path.c_str());
		}
		if (0 != close(led_fd)) {
			ALOGE("Can't close %s file!", path.c_str());
			break;
		}
	}
}

LedControlHW::~LedControlHW(){
    ALOGD("->LedControlHW::~LedControlHW()");
}

Return<result_t> LedControlHW::iLedControlHW(leds_t ledId, ledState_t state) {
    std::string name;	
	result_t res;

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
	std::string path = "/sys/class/leds/" + name + "/brightness";
    std::string condition = (state == ledState_t::ON) ? "On" : "Off";
	std::string control = (state == ledState_t::ON) ? "255" : "0";
    ALOGD("->LedControlHW::iLedControlHW(led=%s, condition=%s)", name.c_str(), condition.c_str());
    
	int led_fd = open(path.c_str(), O_WRONLY);
	if (led_fd < 0) {
		ALOGE("Can't open %s file to control LED!", path.c_str());
		return result_t::RES_ERR;
	}
	if (0 > write(led_fd, control.c_str(), control.length())) {
		ALOGE("Can't write %s to file %s", control.c_str(), path.c_str());
		res = result_t::RES_ERR;
	}
	if (0 != close(led_fd)) {
		ALOGE("Can't close %s file!", path.c_str());
		return result_t::RES_ERR;
	}

	return res;
}

} // namespace implementation
} // namespace V1_0
} // namespace LedControl
} // namespace hardware
} // namespace gls
} // namespace vendor

